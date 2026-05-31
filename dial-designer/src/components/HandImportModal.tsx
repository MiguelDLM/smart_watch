import React, { useEffect, useRef, useState } from 'react';
import { X, Check, Crosshair, Circle as CircleIcon } from 'lucide-react';
import { loadImageElement, imgWidth, imgHeight } from '../utils/loadImage';

interface HandImportModalProps {
  isOpen: boolean;
  file: File | null;
  handLabel: string; // 'hour' | 'minute' | 'second'
  onClose: () => void;
  // Emits the normalized hand: tip points up, pivot pinned to the watch center.
  // cty = horizontal pivot (from left), ctx = vertical pivot from the BOTTOM.
  onApply: (url: string, width: number, height: number, ctx: number, cty: number) => void;
}

const STAGE = 380; // max display size of the editing stage (px)
const HANDLE = 9;  // crop handle hit radius (display px)
const MARKER = 12; // pivot/tip hit radius (display px)

type DragTarget = 'pivot' | 'tip' | 'nw' | 'ne' | 'sw' | 'se' | 'move' | null;

export const HandImportModal: React.FC<HandImportModalProps> = ({ isOpen, file, handLabel, onClose, onApply }) => {
  const [img, setImg] = useState<HTMLImageElement | null>(null);
  const [srcW, setSrcW] = useState(0);
  const [srcH, setSrcH] = useState(0);
  const [crop, setCrop] = useState({ x: 0, y: 0, w: 0, h: 0 }); // source coords
  const [pivot, setPivot] = useState({ x: 0, y: 0 });            // source coords
  const [tip, setTip] = useState({ x: 0, y: 0 });                // source coords
  const [error, setError] = useState<string | null>(null);
  const [resultUrl, setResultUrl] = useState<string | null>(null);

  const stageRef = useRef<HTMLCanvasElement | null>(null);
  const previewRef = useRef<HTMLCanvasElement | null>(null);
  const dragRef = useRef<DragTarget>(null);

  // Scale source → display
  const scale = srcW > 0 ? Math.min(STAGE / srcW, STAGE / srcH, 1.5) : 1;
  const dispW = Math.round(srcW * scale);
  const dispH = Math.round(srcH * scale);

  // Load the file
  useEffect(() => {
    if (!isOpen || !file) return;
    setError(null);
    setResultUrl(null);
    loadImageElement(file)
      .then((image) => {
        const w = imgWidth(image);
        const h = imgHeight(image);
        setImg(image);
        setSrcW(w);
        setSrcH(h);
        // Sensible defaults: full crop, pivot near bottom-center, tip near top-center.
        setCrop({ x: 0, y: 0, w, h });
        setPivot({ x: Math.round(w / 2), y: Math.round(h * 0.85) });
        setTip({ x: Math.round(w / 2), y: Math.round(h * 0.1) });
      })
      .catch((e) => setError(e.message || 'Failed to load image.'));
  }, [isOpen, file]);

  // Redraw the editing stage whenever inputs change.
  useEffect(() => {
    const c = stageRef.current;
    if (!c || !img || dispW === 0) return;
    c.width = dispW;
    c.height = dispH;
    const ctx = c.getContext('2d');
    if (!ctx) return;
    ctx.clearRect(0, 0, dispW, dispH);
    // checkered transparency backdrop
    ctx.fillStyle = '#2a2a32';
    ctx.fillRect(0, 0, dispW, dispH);
    ctx.drawImage(img, 0, 0, srcW, srcH, 0, 0, dispW, dispH);

    const cx = crop.x * scale, cy = crop.y * scale, cw = crop.w * scale, ch = crop.h * scale;
    // dim outside the crop
    ctx.fillStyle = 'rgba(0,0,0,0.55)';
    ctx.fillRect(0, 0, dispW, cy);
    ctx.fillRect(0, cy + ch, dispW, dispH - (cy + ch));
    ctx.fillRect(0, cy, cx, ch);
    ctx.fillRect(cx + cw, cy, dispW - (cx + cw), ch);
    // crop border + handles
    ctx.strokeStyle = '#aa3bff';
    ctx.lineWidth = 1.5;
    ctx.strokeRect(cx, cy, cw, ch);
    ctx.fillStyle = '#aa3bff';
    [[cx, cy], [cx + cw, cy], [cx, cy + ch], [cx + cw, cy + ch]].forEach(([hx, hy]) => {
      ctx.fillRect(hx - 4, hy - 4, 8, 8);
    });

    // axis line pivot → tip
    const px = pivot.x * scale, py = pivot.y * scale, tx = tip.x * scale, ty = tip.y * scale;
    ctx.strokeStyle = 'rgba(80,220,160,0.9)';
    ctx.lineWidth = 2;
    ctx.beginPath();
    ctx.moveTo(px, py);
    ctx.lineTo(tx, ty);
    ctx.stroke();

    // tip marker (crosshair)
    ctx.strokeStyle = '#ffd23f';
    ctx.lineWidth = 2;
    ctx.beginPath();
    ctx.moveTo(tx - 8, ty); ctx.lineTo(tx + 8, ty);
    ctx.moveTo(tx, ty - 8); ctx.lineTo(tx, ty + 8);
    ctx.stroke();

    // pivot marker (ring + dot)
    ctx.strokeStyle = '#50dca0';
    ctx.lineWidth = 2;
    ctx.beginPath(); ctx.arc(px, py, 8, 0, Math.PI * 2); ctx.stroke();
    ctx.fillStyle = '#50dca0';
    ctx.beginPath(); ctx.arc(px, py, 3, 0, Math.PI * 2); ctx.fill();
  }, [img, crop, pivot, tip, dispW, dispH, scale, srcW, srcH]);

  // Compute the normalized hand and a preview thumbnail.
  const buildResult = (): { url: string; width: number; height: number; ctx: number; cty: number } | null => {
    if (!img) return null;
    // 1. Rasterize the crop region to its own canvas (source pixels).
    const cw = Math.max(1, Math.round(crop.w));
    const ch = Math.max(1, Math.round(crop.h));
    const cropCanvas = document.createElement('canvas');
    cropCanvas.width = cw;
    cropCanvas.height = ch;
    const cctx = cropCanvas.getContext('2d')!;
    cctx.drawImage(img, crop.x, crop.y, cw, ch, 0, 0, cw, ch);

    // pivot/tip relative to the crop origin
    const pX = pivot.x - crop.x, pY = pivot.y - crop.y;
    const tX = tip.x - crop.x, tY = tip.y - crop.y;

    // 2. Rotation so the pivot→tip vector points straight up (0,-1).
    const angle = Math.atan2(tY - pY, tX - pX);
    const rot = -Math.PI / 2 - angle;
    const cos = Math.cos(rot), sin = Math.sin(rot);

    // 3. Rotated bounding box of the crop corners around the pivot.
    const corners = [[0, 0], [cw, 0], [0, ch], [cw, ch]];
    let minX = Infinity, minY = Infinity, maxX = -Infinity, maxY = -Infinity;
    for (const [x, y] of corners) {
      const dx = x - pX, dy = y - pY;
      const rx = dx * cos - dy * sin;
      const ry = dx * sin + dy * cos;
      minX = Math.min(minX, rx); maxX = Math.max(maxX, rx);
      minY = Math.min(minY, ry); maxY = Math.max(maxY, ry);
    }
    const outW = Math.max(1, Math.ceil(maxX - minX));
    const outH = Math.max(1, Math.ceil(maxY - minY));
    const pivotOutX = -minX; // pivot position within the output
    const pivotOutY = -minY;

    const out = document.createElement('canvas');
    out.width = outW;
    out.height = outH;
    const octx = out.getContext('2d')!;
    octx.translate(pivotOutX, pivotOutY);
    octx.rotate(rot);
    octx.drawImage(cropCanvas, -pX, -pY);

    const url = out.toDataURL('image/png');
    return {
      url,
      width: outW,
      height: outH,
      cty: Math.round(pivotOutX),          // horizontal pivot (from left)
      ctx: Math.round(outH - pivotOutY),   // vertical pivot from the BOTTOM
    };
  };

  // Live preview of the normalized hand whenever markers/crop change.
  useEffect(() => {
    if (!isOpen || !img) return;
    const res = buildResult();
    if (!res) return;
    setResultUrl(res.url);
    const c = previewRef.current;
    if (!c) return;
    const pimg = new Image();
    pimg.onload = () => {
      const maxH = 200, maxW = 120;
      const s = Math.min(maxW / res.width, maxH / res.height, 2);
      c.width = Math.max(1, Math.round(res.width * s));
      c.height = Math.max(1, Math.round(res.height * s));
      const ctx = c.getContext('2d')!;
      ctx.clearRect(0, 0, c.width, c.height);
      ctx.drawImage(pimg, 0, 0, c.width, c.height);
      // pivot guide
      ctx.fillStyle = '#50dca0';
      ctx.beginPath();
      ctx.arc(res.cty * s, (res.height - res.ctx) * s, 3, 0, Math.PI * 2);
      ctx.fill();
    };
    pimg.src = res.url;
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [img, crop, pivot, tip, isOpen]);

  const toSource = (e: React.PointerEvent) => {
    const rect = (e.target as HTMLCanvasElement).getBoundingClientRect();
    const dx = e.clientX - rect.left;
    const dy = e.clientY - rect.top;
    return { x: dx / scale, y: dy / scale, dispX: dx, dispY: dy };
  };

  const hitTest = (dispX: number, dispY: number): DragTarget => {
    const px = pivot.x * scale, py = pivot.y * scale;
    const tx = tip.x * scale, ty = tip.y * scale;
    if (Math.hypot(dispX - px, dispY - py) <= MARKER) return 'pivot';
    if (Math.hypot(dispX - tx, dispY - ty) <= MARKER) return 'tip';
    const cx = crop.x * scale, cy = crop.y * scale, cw = crop.w * scale, ch = crop.h * scale;
    const near = (ax: number, ay: number) => Math.hypot(dispX - ax, dispY - ay) <= HANDLE;
    if (near(cx, cy)) return 'nw';
    if (near(cx + cw, cy)) return 'ne';
    if (near(cx, cy + ch)) return 'sw';
    if (near(cx + cw, cy + ch)) return 'se';
    if (dispX >= cx && dispX <= cx + cw && dispY >= cy && dispY <= cy + ch) return 'move';
    return null;
  };

  const onPointerDown = (e: React.PointerEvent) => {
    const { dispX, dispY } = toSource(e);
    dragRef.current = hitTest(dispX, dispY);
    (e.target as HTMLCanvasElement).setPointerCapture(e.pointerId);
  };

  const onPointerMove = (e: React.PointerEvent) => {
    const t = dragRef.current;
    if (!t) return;
    const { x, y } = toSource(e);
    const clampX = Math.max(0, Math.min(srcW, x));
    const clampY = Math.max(0, Math.min(srcH, y));
    if (t === 'pivot') setPivot({ x: clampX, y: clampY });
    else if (t === 'tip') setTip({ x: clampX, y: clampY });
    else setCrop((c) => {
      let { x: cx, y: cy, w: cw, h: ch } = c;
      if (t === 'move') {
        cx = Math.max(0, Math.min(srcW - cw, x - cw / 2));
        cy = Math.max(0, Math.min(srcH - ch, y - ch / 2));
      } else {
        const right = cx + cw, bottom = cy + ch;
        if (t === 'nw') { cx = Math.min(clampX, right - 8); cy = Math.min(clampY, bottom - 8); cw = right - cx; ch = bottom - cy; }
        if (t === 'ne') { cy = Math.min(clampY, bottom - 8); cw = Math.max(8, clampX - cx); ch = bottom - cy; }
        if (t === 'sw') { cx = Math.min(clampX, right - 8); cw = right - cx; ch = Math.max(8, clampY - cy); }
        if (t === 'se') { cw = Math.max(8, clampX - cx); ch = Math.max(8, clampY - cy); }
      }
      return { x: cx, y: cy, w: cw, h: ch };
    });
  };

  const onPointerUp = (e: React.PointerEvent) => {
    dragRef.current = null;
    try { (e.target as HTMLCanvasElement).releasePointerCapture(e.pointerId); } catch { /* noop */ }
  };

  const handleApply = () => {
    const res = buildResult();
    if (!res) return;
    onApply(res.url, res.width, res.height, res.ctx, res.cty);
    onClose();
  };

  if (!isOpen) return null;

  return (
    <div style={{ position: 'fixed', inset: 0, backgroundColor: 'rgba(0,0,0,0.75)', backdropFilter: 'blur(8px)', zIndex: 100, display: 'flex', justifyContent: 'center', alignItems: 'center', padding: '2rem' }}>
      <div className="glass-panel" style={{ width: '100%', maxWidth: '900px', maxHeight: '92vh', display: 'flex', flexDirection: 'column', overflow: 'hidden', boxShadow: 'var(--shadow-lg)' }}>
        <div className="panel-header" style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', padding: '1.25rem 1.5rem', borderBottom: '1px solid var(--glass-border)' }}>
          <div>
            <h3 style={{ margin: 0, fontSize: '1.25rem', fontWeight: 800 }}>Import {handLabel} hand</h3>
            <span style={{ fontSize: '0.78rem', color: 'var(--text-muted)' }}>Crop the artwork, then place the rotation pivot and the tip.</span>
          </div>
          <button onClick={onClose} style={{ background: 'transparent', border: 'none', color: 'var(--text-secondary)', cursor: 'pointer' }}><X size={20} /></button>
        </div>

        <div style={{ display: 'flex', flexGrow: 1, overflow: 'hidden' }}>
          {/* Editing stage */}
          <div style={{ flex: 1, padding: '1.25rem', display: 'flex', flexDirection: 'column', alignItems: 'center', gap: '0.75rem', overflowY: 'auto', background: 'rgba(0,0,0,0.2)' }}>
            {error ? (
              <div style={{ color: 'var(--error)', padding: '2rem', textAlign: 'center' }}>{error}</div>
            ) : (
              <>
                <canvas
                  ref={stageRef}
                  style={{ borderRadius: '8px', border: '1px solid var(--glass-border)', touchAction: 'none', cursor: 'crosshair' }}
                  onPointerDown={onPointerDown}
                  onPointerMove={onPointerMove}
                  onPointerUp={onPointerUp}
                />
                <div style={{ display: 'flex', gap: '1rem', fontSize: '0.75rem', color: 'var(--text-muted)' }}>
                  <span style={{ display: 'flex', alignItems: 'center', gap: '0.3rem' }}><CircleIcon size={12} color="#50dca0" /> Pivot (rotation axis)</span>
                  <span style={{ display: 'flex', alignItems: 'center', gap: '0.3rem' }}><Crosshair size={12} color="#ffd23f" /> Tip</span>
                  <span style={{ color: '#aa3bff' }}>▢ Crop</span>
                </div>
              </>
            )}
          </div>

          {/* Preview */}
          <div style={{ width: '260px', borderLeft: '1px solid var(--glass-border)', padding: '1.25rem', display: 'flex', flexDirection: 'column', alignItems: 'center', gap: '1rem' }}>
            <span style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600, letterSpacing: '0.05em' }}>NORMALIZED (tip up)</span>
            <div style={{ background: 'repeating-conic-gradient(#3a3a44 0% 25%, #2a2a32 0% 50%) 50% / 14px 14px', borderRadius: '8px', border: '1px solid var(--glass-border)', padding: '0.75rem', minHeight: '210px', display: 'flex', alignItems: 'center', justifyContent: 'center' }}>
              <canvas ref={previewRef} style={{ maxWidth: '120px', maxHeight: '200px' }} />
            </div>
            <span style={{ fontSize: '0.7rem', color: 'var(--text-muted)', textAlign: 'center' }}>
              The green dot marks where the hand pins to the watch center.
            </span>
          </div>
        </div>

        <div className="panel-header" style={{ display: 'flex', justifyContent: 'flex-end', gap: '0.75rem', padding: '1rem 1.5rem', borderTop: '1px solid var(--glass-border)' }}>
          <button className="btn btn-secondary" onClick={onClose}>Cancel</button>
          <button className="btn btn-primary" onClick={handleApply} disabled={!resultUrl} style={{ display: 'flex', alignItems: 'center', gap: '0.4rem' }}>
            <Check size={16} /> Apply hand
          </button>
        </div>
      </div>
    </div>
  );
};
