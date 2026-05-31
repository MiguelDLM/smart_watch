import React, { useEffect, useRef, useState } from 'react';
import { X, Check, Play, Pause } from 'lucide-react';
import { loadImageElement, imgWidth, imgHeight } from '../utils/loadImage';

interface SpriteSlicerModalProps {
  isOpen: boolean;
  file: File | null;
  frameCount: number;   // required number of states/frames (N)
  initialWidth: number; // default target cell width
  initialHeight: number;// default target cell height
  blockLabel: string;
  onClose: () => void;
  // Emits a vertical W×(H×N) PNG stack plus the per-frame dimensions and frame count.
  onApply: (url: string, width: number, height: number, frms: number) => void;
}

const STAGE = 420;
const HANDLE = 9;

type DragTarget = 'nw' | 'ne' | 'sw' | 'se' | 'move' | null;

// Pick a default grid (cols × rows) that can hold N cells.
const defaultGrid = (n: number): { cols: number; rows: number } => {
  if (n <= 1) return { cols: 1, rows: 1 };
  if (n === 2) return { cols: 2, rows: 1 };
  if (n === 6) return { cols: 3, rows: 2 };
  if (n === 7) return { cols: 7, rows: 1 };
  if (n === 10) return { cols: 5, rows: 2 };
  if (n === 11) return { cols: 11, rows: 1 };
  if (n === 12) return { cols: 4, rows: 3 };
  const cols = Math.ceil(Math.sqrt(n));
  return { cols, rows: Math.ceil(n / cols) };
};

export const SpriteSlicerModal: React.FC<SpriteSlicerModalProps> = ({
  isOpen, file, frameCount, initialWidth, initialHeight, blockLabel, onClose, onApply,
}) => {
  const [img, setImg] = useState<HTMLImageElement | null>(null);
  const [srcW, setSrcW] = useState(0);
  const [srcH, setSrcH] = useState(0);
  const [region, setRegion] = useState({ x: 0, y: 0, w: 0, h: 0 }); // source coords
  const [cols, setCols] = useState(1);
  const [rows, setRows] = useState(1);
  const [colMajor, setColMajor] = useState(false);
  const [targetW, setTargetW] = useState(initialWidth || 64);
  const [targetH, setTargetH] = useState(initialHeight || 64);
  const [frames, setFrames] = useState<string[]>([]);
  const [stackUrl, setStackUrl] = useState<string | null>(null);
  const [error, setError] = useState<string | null>(null);
  const [playing, setPlaying] = useState(true);
  const [simIdx, setSimIdx] = useState(0);

  const stageRef = useRef<HTMLCanvasElement | null>(null);
  const playRef = useRef<HTMLCanvasElement | null>(null);
  const dragRef = useRef<DragTarget>(null);

  const scale = srcW > 0 ? Math.min(STAGE / srcW, STAGE / srcH, 1.5) : 1;
  const dispW = Math.round(srcW * scale);
  const dispH = Math.round(srcH * scale);
  const N = Math.max(1, frameCount);

  // Load file + defaults
  useEffect(() => {
    if (!isOpen || !file) return;
    setError(null);
    setFrames([]);
    setStackUrl(null);
    const g = defaultGrid(N);
    setCols(g.cols);
    setRows(g.rows);
    setColMajor(false);
    setTargetW(initialWidth || 64);
    setTargetH(initialHeight || 64);
    loadImageElement(file)
      .then((image) => {
        const w = imgWidth(image), h = imgHeight(image);
        setImg(image);
        setSrcW(w);
        setSrcH(h);
        setRegion({ x: 0, y: 0, w, h });
      })
      .catch((e) => setError(e.message || 'Failed to load image.'));
  }, [isOpen, file, N, initialWidth, initialHeight]);

  // Extract N frames + build the vertical stack whenever inputs change.
  useEffect(() => {
    if (!img || region.w <= 0 || cols < 1 || rows < 1) return;
    const cellW = region.w / cols;
    const cellH = region.h / rows;
    const tw = Math.max(1, Math.round(targetW));
    const th = Math.max(1, Math.round(targetH));
    const urls: string[] = [];
    for (let i = 0; i < N; i++) {
      const col = colMajor ? Math.floor(i / rows) : i % cols;
      const row = colMajor ? i % rows : Math.floor(i / cols);
      const sx = region.x + col * cellW;
      const sy = region.y + row * cellH;
      const fc = document.createElement('canvas');
      fc.width = tw; fc.height = th;
      const fctx = fc.getContext('2d')!;
      fctx.imageSmoothingQuality = 'high';
      fctx.drawImage(img, sx, sy, cellW, cellH, 0, 0, tw, th);
      urls.push(fc.toDataURL('image/png'));
    }
    setFrames(urls);

    // vertical stack
    const stack = document.createElement('canvas');
    stack.width = tw; stack.height = th * N;
    const sctx = stack.getContext('2d')!;
    let loaded = 0;
    urls.forEach((u, i) => {
      const im = new Image();
      im.onload = () => {
        sctx.drawImage(im, 0, i * th);
        loaded++;
        if (loaded === N) setStackUrl(stack.toDataURL('image/png'));
      };
      im.src = u;
    });
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [img, region, cols, rows, colMajor, targetW, targetH, N]);

  // Draw the stage with the grid overlay.
  useEffect(() => {
    const c = stageRef.current;
    if (!c || !img || dispW === 0) return;
    c.width = dispW; c.height = dispH;
    const ctx = c.getContext('2d');
    if (!ctx) return;
    ctx.clearRect(0, 0, dispW, dispH);
    ctx.fillStyle = '#2a2a32';
    ctx.fillRect(0, 0, dispW, dispH);
    ctx.drawImage(img, 0, 0, srcW, srcH, 0, 0, dispW, dispH);

    const rx = region.x * scale, ry = region.y * scale, rw = region.w * scale, rh = region.h * scale;
    // dim outside region
    ctx.fillStyle = 'rgba(0,0,0,0.5)';
    ctx.fillRect(0, 0, dispW, ry);
    ctx.fillRect(0, ry + rh, dispW, dispH - (ry + rh));
    ctx.fillRect(0, ry, rx, rh);
    ctx.fillRect(rx + rw, ry, dispW - (rx + rw), rh);

    // grid lines
    ctx.strokeStyle = 'rgba(170,59,255,0.6)';
    ctx.lineWidth = 1;
    for (let cc = 1; cc < cols; cc++) {
      const x = rx + (rw / cols) * cc;
      ctx.beginPath(); ctx.moveTo(x, ry); ctx.lineTo(x, ry + rh); ctx.stroke();
    }
    for (let rr = 1; rr < rows; rr++) {
      const y = ry + (rh / rows) * rr;
      ctx.beginPath(); ctx.moveTo(rx, y); ctx.lineTo(rx + rw, y); ctx.stroke();
    }
    // region border + handles
    ctx.strokeStyle = '#aa3bff';
    ctx.lineWidth = 1.5;
    ctx.strokeRect(rx, ry, rw, rh);
    ctx.fillStyle = '#aa3bff';
    [[rx, ry], [rx + rw, ry], [rx, ry + rh], [rx + rw, ry + rh]].forEach(([hx, hy]) => ctx.fillRect(hx - 4, hy - 4, 8, 8));

    // number each cell in read order (first N)
    ctx.fillStyle = '#ffd23f';
    ctx.font = '11px monospace';
    ctx.textAlign = 'center';
    ctx.textBaseline = 'middle';
    const cw = rw / cols, ch = rh / rows;
    for (let i = 0; i < N; i++) {
      const col = colMajor ? Math.floor(i / rows) : i % cols;
      const row = colMajor ? i % rows : Math.floor(i / cols);
      ctx.fillText(String(i), rx + col * cw + cw / 2, ry + row * ch + ch / 2);
    }
  }, [img, region, cols, rows, colMajor, dispW, dispH, scale, srcW, srcH, N]);

  // play loop
  useEffect(() => {
    if (!playing || frames.length === 0) return;
    const id = setInterval(() => setSimIdx((p) => (p + 1) % frames.length), 180);
    return () => clearInterval(id);
  }, [playing, frames]);

  useEffect(() => {
    const c = playRef.current;
    if (!c || frames.length === 0) return;
    const im = new Image();
    im.onload = () => {
      const s = Math.min(96 / im.width, 96 / im.height, 3);
      c.width = Math.max(1, Math.round(im.width * s));
      c.height = Math.max(1, Math.round(im.height * s));
      const ctx = c.getContext('2d')!;
      ctx.clearRect(0, 0, c.width, c.height);
      ctx.drawImage(im, 0, 0, c.width, c.height);
    };
    im.src = frames[simIdx % frames.length];
  }, [frames, simIdx]);

  const toDisp = (e: React.PointerEvent) => {
    const rect = (e.target as HTMLCanvasElement).getBoundingClientRect();
    return { dispX: e.clientX - rect.left, dispY: e.clientY - rect.top };
  };
  const hitTest = (dispX: number, dispY: number): DragTarget => {
    const rx = region.x * scale, ry = region.y * scale, rw = region.w * scale, rh = region.h * scale;
    const near = (ax: number, ay: number) => Math.hypot(dispX - ax, dispY - ay) <= HANDLE;
    if (near(rx, ry)) return 'nw';
    if (near(rx + rw, ry)) return 'ne';
    if (near(rx, ry + rh)) return 'sw';
    if (near(rx + rw, ry + rh)) return 'se';
    if (dispX >= rx && dispX <= rx + rw && dispY >= ry && dispY <= ry + rh) return 'move';
    return null;
  };
  const onPointerDown = (e: React.PointerEvent) => {
    const { dispX, dispY } = toDisp(e);
    dragRef.current = hitTest(dispX, dispY);
    (e.target as HTMLCanvasElement).setPointerCapture(e.pointerId);
  };
  const onPointerMove = (e: React.PointerEvent) => {
    const t = dragRef.current;
    if (!t) return;
    const { dispX, dispY } = toDisp(e);
    const x = Math.max(0, Math.min(srcW, dispX / scale));
    const y = Math.max(0, Math.min(srcH, dispY / scale));
    setRegion((r) => {
      let { x: gx, y: gy, w: gw, h: gh } = r;
      if (t === 'move') {
        gx = Math.max(0, Math.min(srcW - gw, x - gw / 2));
        gy = Math.max(0, Math.min(srcH - gh, y - gh / 2));
      } else {
        const right = gx + gw, bottom = gy + gh;
        if (t === 'nw') { gx = Math.min(x, right - 8); gy = Math.min(y, bottom - 8); gw = right - gx; gh = bottom - gy; }
        if (t === 'ne') { gy = Math.min(y, bottom - 8); gw = Math.max(8, x - gx); gh = bottom - gy; }
        if (t === 'sw') { gx = Math.min(x, right - 8); gw = right - gx; gh = Math.max(8, y - gy); }
        if (t === 'se') { gw = Math.max(8, x - gx); gh = Math.max(8, y - gy); }
      }
      return { x: gx, y: gy, w: gw, h: gh };
    });
  };
  const onPointerUp = (e: React.PointerEvent) => {
    dragRef.current = null;
    try { (e.target as HTMLCanvasElement).releasePointerCapture(e.pointerId); } catch { /* noop */ }
  };

  const handleApply = () => {
    if (!stackUrl) return;
    onApply(stackUrl, Math.round(targetW), Math.round(targetH), N);
    onClose();
  };

  if (!isOpen) return null;

  const numInput = (val: number, set: (n: number) => void, min: number, max: number) => (
    <input type="number" value={val} min={min} max={max}
      onChange={(e) => set(Math.max(min, Math.min(max, parseInt(e.target.value) || min)))}
      style={{ background: 'var(--bg-secondary)', border: '1px solid var(--glass-border)', color: 'var(--text-primary)', padding: '0.4rem', borderRadius: '6px', width: '70px', fontFamily: 'var(--font-mono)' }} />
  );

  return (
    <div style={{ position: 'fixed', inset: 0, backgroundColor: 'rgba(0,0,0,0.75)', backdropFilter: 'blur(8px)', zIndex: 100, display: 'flex', justifyContent: 'center', alignItems: 'center', padding: '2rem' }}>
      <div className="glass-panel" style={{ width: '100%', maxWidth: '980px', maxHeight: '92vh', display: 'flex', flexDirection: 'column', overflow: 'hidden', boxShadow: 'var(--shadow-lg)' }}>
        <div className="panel-header" style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', padding: '1.25rem 1.5rem', borderBottom: '1px solid var(--glass-border)' }}>
          <div>
            <h3 style={{ margin: 0, fontSize: '1.25rem', fontWeight: 800 }}>Slice {blockLabel} ({N} states)</h3>
            <span style={{ fontSize: '0.78rem', color: 'var(--text-muted)' }}>Frame the sprite area, set the grid, and confirm each state in order (0…{N - 1}).</span>
          </div>
          <button onClick={onClose} style={{ background: 'transparent', border: 'none', color: 'var(--text-secondary)', cursor: 'pointer' }}><X size={20} /></button>
        </div>

        <div style={{ display: 'flex', flexGrow: 1, overflow: 'hidden' }}>
          {/* Stage */}
          <div style={{ flex: 1, padding: '1.25rem', display: 'flex', flexDirection: 'column', alignItems: 'center', gap: '0.75rem', overflowY: 'auto', background: 'rgba(0,0,0,0.2)' }}>
            {error ? (
              <div style={{ color: 'var(--error)', padding: '2rem', textAlign: 'center' }}>{error}</div>
            ) : (
              <canvas ref={stageRef}
                style={{ borderRadius: '8px', border: '1px solid var(--glass-border)', touchAction: 'none', cursor: 'crosshair' }}
                onPointerDown={onPointerDown} onPointerMove={onPointerMove} onPointerUp={onPointerUp} />
            )}
            <div style={{ display: 'flex', gap: '1rem', alignItems: 'center', flexWrap: 'wrap', justifyContent: 'center' }}>
              <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)' }}>Cols {numInput(cols, setCols, 1, 50)}</label>
              <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)' }}>Rows {numInput(rows, setRows, 1, 50)}</label>
              <button className={`btn ${colMajor ? 'btn-primary' : 'btn-secondary'}`} style={{ fontSize: '0.78rem', padding: '0.35rem 0.6rem' }} onClick={() => setColMajor((v) => !v)}>
                Order: {colMajor ? 'column-major' : 'row-major'}
              </button>
            </div>
            {cols * rows < N && (
              <span style={{ fontSize: '0.75rem', color: 'var(--error)' }}>Grid has {cols * rows} cells but {N} are required — increase cols/rows.</span>
            )}
          </div>

          {/* Frames + preview */}
          <div style={{ width: '300px', borderLeft: '1px solid var(--glass-border)', padding: '1.25rem', display: 'flex', flexDirection: 'column', gap: '1rem', overflowY: 'auto' }}>
            <div style={{ display: 'flex', gap: '0.75rem', alignItems: 'center' }}>
              <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)' }}>W {numInput(targetW, setTargetW, 1, 466)}</label>
              <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)' }}>H {numInput(targetH, setTargetH, 1, 466)}</label>
            </div>

            <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'center', gap: '0.5rem' }}>
              <div style={{ display: 'flex', alignItems: 'center', gap: '0.5rem' }}>
                <span style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600 }}>PLAY PREVIEW</span>
                <button onClick={() => setPlaying((p) => !p)} style={{ background: 'transparent', border: 'none', color: 'var(--text-secondary)', cursor: 'pointer' }}>
                  {playing ? <Pause size={14} /> : <Play size={14} />}
                </button>
              </div>
              <div style={{ background: 'repeating-conic-gradient(#3a3a44 0% 25%, #2a2a32 0% 50%) 50% / 12px 12px', borderRadius: '8px', border: '1px solid var(--glass-border)', padding: '0.5rem', minWidth: '100px', minHeight: '100px', display: 'flex', alignItems: 'center', justifyContent: 'center' }}>
                <canvas ref={playRef} style={{ imageRendering: 'pixelated' }} />
              </div>
            </div>

            <span style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600 }}>FRAMES ({frames.length})</span>
            <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fill, minmax(48px, 1fr))', gap: '0.4rem' }}>
              {frames.map((f, i) => (
                <div key={i} style={{ display: 'flex', flexDirection: 'column', alignItems: 'center', gap: '0.15rem' }}>
                  <div style={{ width: '100%', aspectRatio: '1', background: 'repeating-conic-gradient(#3a3a44 0% 25%, #2a2a32 0% 50%) 50% / 8px 8px', borderRadius: '4px', border: i === simIdx % Math.max(1, frames.length) ? '1px solid var(--accent)' : '1px solid var(--glass-border)', backgroundImage: `url(${f})`, backgroundSize: 'contain', backgroundRepeat: 'no-repeat', backgroundPosition: 'center' }} />
                  <span style={{ fontSize: '0.62rem', color: 'var(--text-muted)', fontFamily: 'var(--font-mono)' }}>{i}</span>
                </div>
              ))}
            </div>
          </div>
        </div>

        <div className="panel-header" style={{ display: 'flex', justifyContent: 'flex-end', gap: '0.75rem', padding: '1rem 1.5rem', borderTop: '1px solid var(--glass-border)' }}>
          <button className="btn btn-secondary" onClick={onClose}>Cancel</button>
          <button className="btn btn-primary" onClick={handleApply} disabled={!stackUrl || cols * rows < N} style={{ display: 'flex', alignItems: 'center', gap: '0.4rem' }}>
            <Check size={16} /> Apply {N} frames
          </button>
        </div>
      </div>
    </div>
  );
};
