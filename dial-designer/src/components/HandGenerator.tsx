import React, { useState, useEffect, useRef } from 'react';
import { X, Check, Clock } from 'lucide-react';

interface HandGeneratorProps {
  isOpen: boolean;
  handType: 'hour' | 'minute' | 'second';
  onClose: () => void;
  onApply: (
    hourDataUrl: string, minuteDataUrl: string, secondDataUrl: string,
    hourW: number, hourH: number, hourCtx: number, hourCty: number,
    minW: number, minH: number, minCtx: number, minCty: number,
    secW: number, secH: number, secCtx: number, secCty: number,
    config: any
  ) => void;
  initialConfig?: any;
}

// Hand style presets
const HAND_STYLES = [
  { value: 'sword',    label: '⚔️  Sword',     desc: 'Sharp pointed blade' },
  { value: 'arrow',   label: '→  Arrow',      desc: 'Classic arrow tip' },
  { value: 'baton',   label: '▬  Baton',      desc: 'Thick rectangular stick' },
  { value: 'needle',  label: '|  Needle',     desc: 'Ultra-thin line' },
  { value: 'club',    label: '🏑 Club',        desc: 'Thick base, thin tip' },
  { value: 'diamond', label: '◆  Diamond',    desc: 'Diamond-faceted hand' },
  { value: 'leaf',    label: '🍂 Leaf',        desc: 'Organic leaf shape' },
  { value: 'lollipop',label: '⦿  Lollipop',   desc: 'Round tip on stick' },
];

// Default configs by hand type
// Default sizes are tuned to real extracted hands (≈466 px dial): hour ~150 px tall,
// minute ~210 px, second ~250 px. Too-small hands are invisible on the watch.
const getDefaults = (type: 'hour' | 'minute' | 'second') => {
  if (type === 'hour')   return { width: 16, handLength: 120, tailLength: 30, tipStyle: 'sword',   color: '#ffffff', tailColor: '#aaaaaa', glowColor: '', glowBlur: 0, shadow: true, outline: true, outlineColor: '#000000', outlineWidth: 2, rounded: true };
  if (type === 'minute') return { width: 12, handLength: 175, tailLength: 35, tipStyle: 'sword',   color: '#ffffff', tailColor: '#aaaaaa', glowColor: '', glowBlur: 0, shadow: true, outline: true, outlineColor: '#000000', outlineWidth: 2, rounded: true };
  return                        { width: 5,  handLength: 205, tailLength: 45, tipStyle: 'needle',  color: '#ff4444', tailColor: '#ff2222', glowColor: '#ff0000', glowBlur: 6, shadow: false, outline: false, outlineColor: '#000000', outlineWidth: 1, rounded: false };
};

// Canvas preview scale for individual hand renders
const PREVIEW_SCALE = 1.5;

const drawHand = (
  canvas: HTMLCanvasElement,
  cfg: ReturnType<typeof getDefaults>,
  previewAngle = 0,
  scale = 1
) => {
  const w = Math.round(cfg.width * scale);
  const tipLen = Math.round(cfg.handLength * scale);
  const tailLen = Math.round(cfg.tailLength * scale);
  const totalH = tipLen + tailLen;
  const cw = w + 20; // slight padding
  const ch = totalH + 20;

  canvas.width = cw;
  canvas.height = ch;

  const ctx = canvas.getContext('2d')!;
  ctx.clearRect(0, 0, cw, ch);

  // Apply rotation for preview
  if (previewAngle !== 0) {
    ctx.save();
    ctx.translate(cw / 2, tailLen + 10);
    ctx.rotate((previewAngle * Math.PI) / 180);
    ctx.translate(-cw / 2, -(tailLen + 10));
  }

  const cx = cw / 2;
  // Pivot sits below the full tip (tip points UP), tail extends below the pivot.
  const pivotY = tipLen + 10;
  const tipY = pivotY - tipLen;   // = 10 (top), never clipped
  const tailY = pivotY + tailLen;

  // Glow
  if (cfg.glowBlur > 0 && cfg.glowColor) {
    ctx.shadowColor = cfg.glowColor;
    ctx.shadowBlur = cfg.glowBlur;
  } else {
    ctx.shadowColor = 'transparent';
    ctx.shadowBlur = 0;
  }

  // Drop shadow
  if (cfg.shadow) {
    ctx.shadowColor = 'rgba(0,0,0,0.6)';
    ctx.shadowBlur = 4;
    ctx.shadowOffsetX = 1;
    ctx.shadowOffsetY = 1;
  }

  ctx.beginPath();
  const hw = w / 2;
  const tailW = Math.max(w * 0.4, 2);
  const tailHw = tailW / 2;

  if (cfg.tipStyle === 'needle') {
    // Ultra-thin straight line
    ctx.moveTo(cx, tipY);
    ctx.lineTo(cx + 0.5, tailY);
    ctx.lineTo(cx - 0.5, tailY);
    ctx.closePath();
  } else if (cfg.tipStyle === 'sword') {
    ctx.moveTo(cx, tipY); // sharp tip
    ctx.lineTo(cx + hw, pivotY - tipLen * 0.2);
    ctx.lineTo(cx + tailHw, pivotY);
    ctx.lineTo(cx + tailHw, tailY);
    ctx.lineTo(cx - tailHw, tailY);
    ctx.lineTo(cx - tailHw, pivotY);
    ctx.lineTo(cx - hw, pivotY - tipLen * 0.2);
    ctx.closePath();
  } else if (cfg.tipStyle === 'arrow') {
    ctx.moveTo(cx, tipY); // arrow tip
    ctx.lineTo(cx + hw, pivotY - tipLen * 0.35);
    ctx.lineTo(cx + hw * 0.4, pivotY - tipLen * 0.35);
    ctx.lineTo(cx + tailHw, pivotY);
    ctx.lineTo(cx + tailHw, tailY);
    ctx.lineTo(cx - tailHw, tailY);
    ctx.lineTo(cx - tailHw, pivotY);
    ctx.lineTo(cx - hw * 0.4, pivotY - tipLen * 0.35);
    ctx.lineTo(cx - hw, pivotY - tipLen * 0.35);
    ctx.closePath();
  } else if (cfg.tipStyle === 'baton') {
    const r = cfg.rounded ? hw : 0;
    ctx.roundRect ? ctx.roundRect(cx - hw, tipY, w, totalH, r) : ctx.rect(cx - hw, tipY, w, totalH);
  } else if (cfg.tipStyle === 'club') {
    ctx.moveTo(cx, tipY);
    ctx.lineTo(cx + hw, tipY + tipLen * 0.6);
    ctx.lineTo(cx + tailHw, pivotY);
    ctx.lineTo(cx + tailHw, tailY);
    ctx.lineTo(cx - tailHw, tailY);
    ctx.lineTo(cx - tailHw, pivotY);
    ctx.lineTo(cx - hw, tipY + tipLen * 0.6);
    ctx.closePath();
  } else if (cfg.tipStyle === 'diamond') {
    ctx.moveTo(cx, tipY);
    ctx.lineTo(cx + hw, pivotY - tipLen * 0.5);
    ctx.lineTo(cx, pivotY - tipLen * 0.1);
    ctx.lineTo(cx - hw, pivotY - tipLen * 0.5);
    ctx.closePath();
    // tail
    ctx.moveTo(cx - tailHw, pivotY);
    ctx.lineTo(cx + tailHw, pivotY);
    ctx.lineTo(cx + tailHw, tailY);
    ctx.lineTo(cx - tailHw, tailY);
    ctx.closePath();
  } else if (cfg.tipStyle === 'leaf') {
    ctx.moveTo(cx, tipY);
    ctx.bezierCurveTo(cx + hw * 1.5, tipY + tipLen * 0.3, cx + hw, pivotY - tipLen * 0.15, cx, pivotY);
    ctx.bezierCurveTo(cx - hw, pivotY - tipLen * 0.15, cx - hw * 1.5, tipY + tipLen * 0.3, cx, tipY);
    ctx.closePath();
    // Stem tail
    ctx.moveTo(cx - tailHw * 0.7, pivotY);
    ctx.lineTo(cx + tailHw * 0.7, pivotY);
    ctx.lineTo(cx + tailHw * 0.5, tailY);
    ctx.lineTo(cx - tailHw * 0.5, tailY);
    ctx.closePath();
  } else if (cfg.tipStyle === 'lollipop') {
    // Round tip ball
    ctx.arc(cx, tipY + hw, hw, 0, Math.PI * 2);
    ctx.closePath();
    ctx.fill();
    ctx.beginPath();
    ctx.rect(cx - tailHw * 0.6, tipY + hw * 2, tailHw * 1.2, tipLen - hw * 2 + tailLen);
    ctx.closePath();
  }

  // Gradient fill
  const grad = ctx.createLinearGradient(cx - hw, tipY, cx + hw, tipY);
  grad.addColorStop(0, shadeColor(cfg.color, -20));
  grad.addColorStop(0.5, cfg.color);
  grad.addColorStop(1, shadeColor(cfg.color, -20));
  ctx.fillStyle = grad;
  ctx.fill();

  // Outline
  if (cfg.outline && cfg.outlineWidth > 0) {
    ctx.shadowColor = 'transparent';
    ctx.shadowBlur = 0;
    ctx.strokeStyle = cfg.outlineColor;
    ctx.lineWidth = cfg.outlineWidth;
    ctx.stroke();
  }

  if (previewAngle !== 0) {
    ctx.restore();
  }
};

// Generate final single-frame hand PNG at exact dimensions
const generateHandPng = (
  cfg: ReturnType<typeof getDefaults>,
  targetW: number,
  targetH: number
): string => {
  const canvas = document.createElement('canvas');
  canvas.width = targetW;
  canvas.height = targetH;
  const ctx = canvas.getContext('2d')!;
  ctx.clearRect(0, 0, targetW, targetH);

  const tipLen = cfg.handLength;
  const tailLen = cfg.tailLength;
  const w = cfg.width;
  const cx = targetW / 2;
  // Pivot below the full tip so the tip (pointer) is never clipped and points UP.
  // cty is stored as the distance from the BOTTOM (= tailLen + pad), matching the
  // firmware convention used by the extracted hand presets.
  const pivotY = tipLen + Math.max(0, (targetH - tipLen - tailLen) / 2);
  const tipY = pivotY - tipLen;
  const tailY = pivotY + tailLen;
  const hw = w / 2;
  const tailHw = Math.max(w * 0.4, 1);

  if (cfg.glowBlur > 0 && cfg.glowColor) {
    ctx.shadowColor = cfg.glowColor;
    ctx.shadowBlur = cfg.glowBlur;
  }
  if (cfg.shadow) {
    ctx.shadowColor = 'rgba(0,0,0,0.5)';
    ctx.shadowBlur = 3;
    ctx.shadowOffsetX = 1;
    ctx.shadowOffsetY = 1;
  }

  ctx.beginPath();
  if (cfg.tipStyle === 'needle') {
    ctx.moveTo(cx, tipY); ctx.lineTo(cx + 0.5, tailY); ctx.lineTo(cx - 0.5, tailY); ctx.closePath();
  } else if (cfg.tipStyle === 'sword') {
    ctx.moveTo(cx, tipY);
    ctx.lineTo(cx + hw, pivotY - tipLen * 0.2);
    ctx.lineTo(cx + tailHw, pivotY);
    ctx.lineTo(cx + tailHw, tailY);
    ctx.lineTo(cx - tailHw, tailY);
    ctx.lineTo(cx - tailHw, pivotY);
    ctx.lineTo(cx - hw, pivotY - tipLen * 0.2);
    ctx.closePath();
  } else if (cfg.tipStyle === 'arrow') {
    ctx.moveTo(cx, tipY);
    ctx.lineTo(cx + hw, pivotY - tipLen * 0.35);
    ctx.lineTo(cx + hw * 0.4, pivotY - tipLen * 0.35);
    ctx.lineTo(cx + tailHw, pivotY);
    ctx.lineTo(cx + tailHw, tailY);
    ctx.lineTo(cx - tailHw, tailY);
    ctx.lineTo(cx - tailHw, pivotY);
    ctx.lineTo(cx - hw * 0.4, pivotY - tipLen * 0.35);
    ctx.lineTo(cx - hw, pivotY - tipLen * 0.35);
    ctx.closePath();
  } else if (cfg.tipStyle === 'baton') {
    const r = cfg.rounded ? hw : 0;
    if (ctx.roundRect) ctx.roundRect(cx - hw, tipY, w, tipLen + tailLen, r);
    else ctx.rect(cx - hw, tipY, w, tipLen + tailLen);
  } else if (cfg.tipStyle === 'club') {
    ctx.moveTo(cx, tipY);
    ctx.lineTo(cx + hw, tipY + tipLen * 0.6);
    ctx.lineTo(cx + tailHw, pivotY);
    ctx.lineTo(cx + tailHw, tailY);
    ctx.lineTo(cx - tailHw, tailY);
    ctx.lineTo(cx - tailHw, pivotY);
    ctx.lineTo(cx - hw, tipY + tipLen * 0.6);
    ctx.closePath();
  } else if (cfg.tipStyle === 'diamond') {
    ctx.moveTo(cx, tipY);
    ctx.lineTo(cx + hw, pivotY - tipLen * 0.5);
    ctx.lineTo(cx, pivotY - tipLen * 0.1);
    ctx.lineTo(cx - hw, pivotY - tipLen * 0.5);
    ctx.closePath();
    ctx.fill();
    ctx.beginPath();
    ctx.rect(cx - tailHw, pivotY, tailHw * 2, tailLen);
  } else if (cfg.tipStyle === 'leaf') {
    ctx.moveTo(cx, tipY);
    ctx.bezierCurveTo(cx + hw * 1.5, tipY + tipLen * 0.3, cx + hw, pivotY - tipLen * 0.15, cx, pivotY);
    ctx.bezierCurveTo(cx - hw, pivotY - tipLen * 0.15, cx - hw * 1.5, tipY + tipLen * 0.3, cx, tipY);
    ctx.closePath();
    ctx.fill();
    ctx.beginPath();
    ctx.rect(cx - tailHw * 0.5, pivotY, tailHw, tailLen);
  } else if (cfg.tipStyle === 'lollipop') {
    ctx.arc(cx, tipY + hw, hw, 0, Math.PI * 2);
    ctx.closePath();
    ctx.fill();
    ctx.beginPath();
    ctx.rect(cx - tailHw * 0.6, tipY + hw * 2, tailHw * 1.2, tipLen - hw * 2 + tailLen);
  }

  const grad = ctx.createLinearGradient(cx - hw, tipY, cx + hw, tipY);
  grad.addColorStop(0, shadeColor(cfg.color, -20));
  grad.addColorStop(0.5, cfg.color);
  grad.addColorStop(1, shadeColor(cfg.color, -20));
  ctx.fillStyle = grad;
  ctx.fill();

  if (cfg.outline && cfg.outlineWidth > 0) {
    ctx.shadowColor = 'transparent';
    ctx.shadowBlur = 0;
    ctx.strokeStyle = cfg.outlineColor;
    ctx.lineWidth = cfg.outlineWidth;
    ctx.stroke();
  }

  return canvas.toDataURL('image/png');
};

const shadeColor = (hex: string, amount: number): string => {
  try {
    const clean = hex.replace('#', '');
    const num = parseInt(clean, 16);
    const r = Math.min(255, Math.max(0, ((num >> 16) & 0xff) + amount));
    const g = Math.min(255, Math.max(0, ((num >> 8) & 0xff) + amount));
    const b = Math.min(255, Math.max(0, (num & 0xff) + amount));
    return `rgb(${r},${g},${b})`;
  } catch { return hex; }
};

export const HandGenerator: React.FC<HandGeneratorProps> = ({
  isOpen, handType, onClose, onApply, initialConfig
}) => {
  const [hourCfg, setHourCfg] = useState(getDefaults('hour'));
  const [minCfg, setMinCfg] = useState(getDefaults('minute'));
  const [secCfg, setSecCfg] = useState(getDefaults('second'));
  const [editingHand, setEditingHand] = useState<'hour' | 'minute' | 'second'>(handType);

  const hourPreviewRef = useRef<HTMLCanvasElement>(null);
  const minPreviewRef = useRef<HTMLCanvasElement>(null);
  const secPreviewRef = useRef<HTMLCanvasElement>(null);
  const dialRef = useRef<HTMLCanvasElement>(null);

  const getCfg = () => editingHand === 'hour' ? hourCfg : editingHand === 'minute' ? minCfg : secCfg;
  const setCfg = (update: any) => {
    if (editingHand === 'hour') setHourCfg(prev => ({ ...prev, ...update }));
    else if (editingHand === 'minute') setMinCfg(prev => ({ ...prev, ...update }));
    else setSecCfg(prev => ({ ...prev, ...update }));
  };

  // Sync initial config
  useEffect(() => {
    if (isOpen && initialConfig) {
      if (initialConfig.hourCfg) setHourCfg(initialConfig.hourCfg);
      if (initialConfig.minCfg) setMinCfg(initialConfig.minCfg);
      if (initialConfig.secCfg) setSecCfg(initialConfig.secCfg);
    }
  }, [isOpen, initialConfig]);

  // Draw individual hand preview
  useEffect(() => {
    if (!isOpen) return;
    if (hourPreviewRef.current) drawHand(hourPreviewRef.current, hourCfg, 0, PREVIEW_SCALE);
    if (minPreviewRef.current) drawHand(minPreviewRef.current, minCfg, 0, PREVIEW_SCALE);
    if (secPreviewRef.current) drawHand(secPreviewRef.current, secCfg, 0, PREVIEW_SCALE);
  }, [isOpen, hourCfg, minCfg, secCfg]);

  // Draw full dial preview
  useEffect(() => {
    if (!isOpen || !dialRef.current) return;
    const canvas = dialRef.current;
    canvas.width = 220;
    canvas.height = 220;
    const ctx = canvas.getContext('2d')!;
    ctx.clearRect(0, 0, 220, 220);

    // Draw watch face circle
    ctx.fillStyle = '#111827';
    ctx.beginPath();
    ctx.arc(110, 110, 108, 0, Math.PI * 2);
    ctx.fill();
    ctx.strokeStyle = 'rgba(255,255,255,0.15)';
    ctx.lineWidth = 2;
    ctx.stroke();

    // Hour markers
    for (let i = 0; i < 12; i++) {
      const angle = (i * 30 * Math.PI) / 180;
      const x1 = 110 + Math.sin(angle) * 95;
      const y1 = 110 - Math.cos(angle) * 95;
      const x2 = 110 + Math.sin(angle) * (i % 3 === 0 ? 80 : 88);
      const y2 = 110 - Math.cos(angle) * (i % 3 === 0 ? 80 : 88);
      ctx.strokeStyle = i % 3 === 0 ? 'rgba(255,255,255,0.7)' : 'rgba(255,255,255,0.3)';
      ctx.lineWidth = i % 3 === 0 ? 2 : 1;
      ctx.beginPath();
      ctx.moveTo(x1, y1);
      ctx.lineTo(x2, y2);
      ctx.stroke();
    }

    // Now = 10:09:30 for classic preview
    const hAngle = ((10 % 12) * 30 + 9 * 0.5) * Math.PI / 180;
    const mAngle = (9 * 6) * Math.PI / 180;
    const sAngle = (30 * 6) * Math.PI / 180;

    // Render each hand with the SAME drawHand routine used for the individual
    // preview and the exported PNG, so the dial preview reflects the real shape
    // (tip style, gradient, outline, glow, tail). Hands are designed for a ~466 px
    // dial (radius 233); scale into this 220 px preview (radius ~100) so size
    // changes show proportionally.
    const DIAL_SCALE = 100 / 233;
    const handScratch = document.createElement('canvas');

    const drawDialHand = (angle: number, cfg: any) => {
      // drawHand renders the hand pointing up with its rotation pivot at
      // (canvas.width/2, round(handLength*scale)+10).
      drawHand(handScratch, cfg, 0, DIAL_SCALE);
      const pivotX = handScratch.width / 2;
      const pivotY = Math.round(cfg.handLength * DIAL_SCALE) + 10;
      ctx.save();
      ctx.translate(110, 110);
      ctx.rotate(angle);
      ctx.drawImage(handScratch, -pivotX, -pivotY);
      ctx.restore();
    };

    drawDialHand(hAngle, hourCfg);
    drawDialHand(mAngle, minCfg);
    drawDialHand(sAngle, secCfg);

    // Center dot
    ctx.fillStyle = '#ffffff';
    ctx.beginPath();
    ctx.arc(110, 110, 4, 0, Math.PI * 2);
    ctx.fill();
  }, [isOpen, hourCfg, minCfg, secCfg]);

  const handleApply = () => {
    // Compute dimensions
    const hourW = hourCfg.width + 10;
    const hourH = hourCfg.handLength + hourCfg.tailLength + 10;
    const minW = minCfg.width + 10;
    const minH = minCfg.handLength + minCfg.tailLength + 10;
    const secW = secCfg.width + 10;
    const secH = secCfg.handLength + secCfg.tailLength + 10;

    // Descriptor pivot bytes (matching original watch hands, verified across dials):
    //   ctx (byte 18) = VERTICAL pivot measured from the BOTTOM of the image
    //   cty (byte 19) = HORIZONTAL pivot from the left (= width/2)
    // generateHandPng places the pivot at handLength+5 from the top, i.e.
    // tailLength+5 from the bottom.
    const hourCtx = hourCfg.tailLength + 5;
    const hourCty = Math.round(hourW / 2);
    const minCtx = minCfg.tailLength + 5;
    const minCty = Math.round(minW / 2);
    const secCtx = secCfg.tailLength + 5;
    const secCty = Math.round(secW / 2);

    const hUrl = generateHandPng(hourCfg, hourW, hourH);
    const mUrl = generateHandPng(minCfg, minW, minH);
    const sUrl = generateHandPng(secCfg, secW, secH);

    onApply(
      hUrl, mUrl, sUrl,
      hourW, hourH, hourCtx, hourCty,
      minW, minH, minCtx, minCty,
      secW, secH, secCtx, secCty,
      { hourCfg, minCfg, secCfg }
    );
  };

  if (!isOpen) return null;

  const cfg = getCfg();
  const handTabs: ('hour' | 'minute' | 'second')[] = ['hour', 'minute', 'second'];

  const ColorPicker = ({ label, value, onChange }: { label: string; value: string; onChange: (v: string) => void }) => (
    <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between', gap: '0.5rem' }}>
      <span style={{ fontSize: '0.82rem' }}>{label}</span>
      <div style={{ display: 'flex', alignItems: 'center', gap: '0.4rem' }}>
        <input type="color" value={value.startsWith('#') ? value : '#ffffff'}
          onChange={e => onChange(e.target.value)}
          style={{ border: 'none', background: 'transparent', width: '28px', height: '28px', cursor: 'pointer', colorScheme: 'light' }} />
        <input type="text" value={value} onChange={e => onChange(e.target.value)}
          style={{ width: '72px', padding: '0.25rem 0.4rem', borderRadius: '4px', border: '1px solid var(--glass-border)', background: 'var(--bg-secondary)', color: 'var(--text-primary)', fontSize: '0.75rem', fontFamily: 'var(--font-mono)' }} />
      </div>
    </div>
  );

  return (
    <div style={{ position: 'fixed', inset: 0, backgroundColor: 'rgba(0,0,0,0.75)', backdropFilter: 'blur(8px)', zIndex: 100, display: 'flex', justifyContent: 'center', alignItems: 'center', padding: '2rem' }}>
      <div className="glass-panel" style={{ width: '100%', maxWidth: '960px', maxHeight: '92vh', display: 'flex', flexDirection: 'column', overflow: 'hidden', boxShadow: 'var(--shadow-lg)' }}>

        {/* Header */}
        <div className="panel-header" style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', padding: '1.25rem 1.5rem', borderBottom: '1px solid var(--glass-border)' }}>
          <div style={{ display: 'flex', alignItems: 'center', gap: '0.75rem' }}>
            <Clock size={20} color="var(--accent-hover)" />
            <h3 style={{ margin: 0, fontSize: '1.25rem', fontWeight: 800 }}>Analog Hand Set Builder</h3>
            <span style={{ fontSize: '0.75rem', color: 'var(--text-muted)', background: 'rgba(255,255,255,0.06)', padding: '0.2rem 0.5rem', borderRadius: '4px' }}>Generates Hour + Minute + Second</span>
          </div>
          <button onClick={onClose} style={{ background: 'transparent', border: 'none', color: 'var(--text-secondary)', cursor: 'pointer', padding: '0.25rem' }}>
            <X size={20} />
          </button>
        </div>

        <div style={{ display: 'flex', flexGrow: 1, overflow: 'hidden' }}>

          {/* Left: Settings */}
          <div style={{ flex: 1, padding: '1.25rem', overflowY: 'auto', borderRight: '1px solid var(--glass-border)', display: 'flex', flexDirection: 'column', gap: '1rem' }}>

            {/* Hand tab switcher */}
            <div style={{ display: 'flex', gap: '0.5rem', borderBottom: '1px solid var(--glass-border)', paddingBottom: '0.75rem' }}>
              {handTabs.map(t => (
                <button key={t} onClick={() => setEditingHand(t)}
                  className={`btn ${editingHand === t ? 'btn-primary' : 'btn-secondary'}`}
                  style={{ flex: 1, fontSize: '0.8rem', padding: '0.4rem', textTransform: 'capitalize' }}>
                  {t === 'hour' ? '🕐' : t === 'minute' ? '🕙' : '🔴'} {t}
                </button>
              ))}
            </div>

            {/* Style selector */}
            <div style={{ display: 'flex', flexDirection: 'column', gap: '0.4rem' }}>
              <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600 }}>HAND SHAPE</label>
              <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '0.4rem' }}>
                {HAND_STYLES.map(s => (
                  <button key={s.value} onClick={() => setCfg({ tipStyle: s.value })}
                    style={{
                      padding: '0.4rem 0.6rem', borderRadius: '6px', border: `1px solid ${cfg.tipStyle === s.value ? 'var(--accent)' : 'var(--glass-border)'}`,
                      background: cfg.tipStyle === s.value ? 'rgba(var(--accent-rgb, 100,120,255), 0.15)' : 'var(--bg-secondary)',
                      color: cfg.tipStyle === s.value ? 'var(--accent-hover)' : 'var(--text-secondary)', cursor: 'pointer', textAlign: 'left', fontSize: '0.78rem', fontWeight: cfg.tipStyle === s.value ? 700 : 400
                    }}>
                    {s.label}
                    <div style={{ fontSize: '0.65rem', color: 'var(--text-muted)', marginTop: '2px' }}>{s.desc}</div>
                  </button>
                ))}
              </div>
            </div>

            {/* Dimensions */}
            <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr 1fr', gap: '0.6rem' }}>
              {[
                { key: 'width', label: 'Width (px)', min: 1, max: 40 },
                { key: 'handLength', label: 'Tip Length', min: 30, max: 200 },
                { key: 'tailLength', label: 'Tail Length', min: 5, max: 80 },
              ].map(({ key, label, min, max }) => (
                <div key={key} style={{ display: 'flex', flexDirection: 'column', gap: '0.25rem' }}>
                  <label style={{ fontSize: '0.7rem', color: 'var(--text-muted)', fontWeight: 600 }}>{label.toUpperCase()}</label>
                  <input type="number" min={min} max={max} value={(cfg as any)[key]}
                    onChange={e => setCfg({ [key]: Math.max(min, Math.min(max, parseInt(e.target.value) || min)) })}
                    style={{ background: 'var(--bg-secondary)', border: '1px solid var(--glass-border)', color: 'var(--text-primary)', padding: '0.4rem', borderRadius: '6px', fontFamily: 'var(--font-mono)', width: '100%', fontSize: '0.85rem' }} />
                </div>
              ))}
            </div>

            {/* Colors */}
            <div className="glass-panel" style={{ padding: '0.75rem', display: 'flex', flexDirection: 'column', gap: '0.5rem', background: 'rgba(255,255,255,0.01)' }}>
              <span style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600 }}>COLORS</span>
              <ColorPicker label="Hand Color" value={cfg.color} onChange={v => setCfg({ color: v })} />
              <ColorPicker label="Glow Color" value={cfg.glowColor || '#000000'} onChange={v => setCfg({ glowColor: v })} />
            </div>

            {/* Style toggles */}
            <div style={{ display: 'flex', flexDirection: 'column', gap: '0.5rem', borderTop: '1px solid var(--glass-border)', paddingTop: '0.75rem' }}>
              {[
                { key: 'outline', label: 'Dark Outline' },
                { key: 'shadow', label: 'Drop Shadow' },
                { key: 'rounded', label: 'Rounded Caps' },
              ].map(({ key, label }) => (
                <div key={key} style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between' }}>
                  <label htmlFor={`hg-${key}`} style={{ fontSize: '0.85rem', cursor: 'pointer' }}>{label}</label>
                  <input type="checkbox" id={`hg-${key}`} checked={(cfg as any)[key]}
                    onChange={e => setCfg({ [key]: e.target.checked })}
                    style={{ width: '16px', height: '16px', accentColor: 'var(--accent)' }} />
                </div>
              ))}
              {cfg.outline && (
                <div style={{ display: 'flex', alignItems: 'center', gap: '0.5rem', paddingLeft: '1rem' }}>
                  <span style={{ fontSize: '0.8rem', color: 'var(--text-muted)' }}>Outline Width</span>
                  <input type="range" min={1} max={4} value={cfg.outlineWidth} onChange={e => setCfg({ outlineWidth: parseInt(e.target.value) })}
                    style={{ flex: 1, accentColor: 'var(--accent)' }} />
                  <span style={{ fontFamily: 'var(--font-mono)', fontSize: '0.8rem', minWidth: '20px' }}>{cfg.outlineWidth}</span>
                </div>
              )}
              {cfg.glowColor && (
                <div style={{ display: 'flex', alignItems: 'center', gap: '0.5rem' }}>
                  <span style={{ fontSize: '0.8rem', color: 'var(--text-muted)' }}>Glow Blur</span>
                  <input type="range" min={0} max={20} value={cfg.glowBlur} onChange={e => setCfg({ glowBlur: parseInt(e.target.value) })}
                    style={{ flex: 1, accentColor: 'var(--accent)' }} />
                  <span style={{ fontFamily: 'var(--font-mono)', fontSize: '0.8rem', minWidth: '20px' }}>{cfg.glowBlur}</span>
                </div>
              )}
            </div>
          </div>

          {/* Right: Preview */}
          <div style={{ width: '340px', padding: '1.25rem', background: 'rgba(0,0,0,0.2)', display: 'flex', flexDirection: 'column', alignItems: 'center', gap: '1.25rem', overflowY: 'auto' }}>

            {/* Dial preview */}
            <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'center', gap: '0.5rem', width: '100%' }}>
              <span style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600, letterSpacing: '0.05em' }}>LIVE DIAL PREVIEW (10:09:30)</span>
              <div style={{ background: '#0b0c16', borderRadius: '50%', border: '2px solid rgba(255,255,255,0.1)', boxShadow: '0 0 30px rgba(0,0,0,0.8)' }}>
                <canvas ref={dialRef} />
              </div>
            </div>

            {/* Individual hand previews */}
            <div style={{ width: '100%', display: 'flex', flexDirection: 'column', gap: '0.75rem' }}>
              <span style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600, letterSpacing: '0.05em' }}>INDIVIDUAL HANDS (12 o'clock)</span>
              <div style={{ display: 'flex', gap: '1rem', justifyContent: 'center' }}>
                {([['hour', hourPreviewRef], ['minute', minPreviewRef], ['second', secPreviewRef]] as const).map(([label, ref]) => (
                  <div key={label} style={{ display: 'flex', flexDirection: 'column', alignItems: 'center', gap: '0.35rem' }}>
                    <div style={{ background: 'repeating-conic-gradient(#3a3a44 0% 25%, #2a2a32 0% 50%) 50% / 14px 14px', borderRadius: '8px', border: `1px solid ${editingHand === label ? 'var(--accent)' : 'var(--glass-border)'}`, padding: '0.5rem', minWidth: '60px', minHeight: '80px', display: 'flex', alignItems: 'center', justifyContent: 'center' }}
                      onClick={() => setEditingHand(label)}>
                      <canvas ref={ref as any} style={{ maxWidth: '50px', maxHeight: '120px' }} />
                    </div>
                    <span style={{ fontSize: '0.7rem', color: editingHand === label ? 'var(--accent-hover)' : 'var(--text-muted)', textTransform: 'capitalize' }}>{label}</span>
                  </div>
                ))}
              </div>
            </div>

            {/* Dimensions info */}
            <div className="glass-panel" style={{ width: '100%', padding: '0.75rem', background: 'rgba(255,255,255,0.02)', fontSize: '0.75rem' }}>
              <div style={{ color: 'var(--text-muted)', fontWeight: 600, marginBottom: '0.4rem' }}>GENERATED SIZES (px)</div>
              {[
                { label: 'Hour', cfg: hourCfg },
                { label: 'Minute', cfg: minCfg },
                { label: 'Second', cfg: secCfg },
              ].map(({ label, cfg: c }) => {
                const w = c.width + 10;
                const h = c.handLength + c.tailLength + 10;
                const ctxV = Math.round(w / 2);
                const ctyV = c.tailLength + 5;
                return (
                  <div key={label} style={{ display: 'flex', gap: '0.5rem', fontFamily: 'var(--font-mono)', marginBottom: '0.2rem', flexWrap: 'wrap' }}>
                    <span style={{ color: 'var(--text-secondary)', minWidth: '50px' }}>{label}:</span>
                    <span style={{ color: 'var(--accent-hover)' }}>{w}×{h}</span>
                    <span style={{ color: 'var(--text-muted)' }}>pivot({ctxV},{ctyV})</span>
                  </div>
                );
              })}
            </div>
          </div>
        </div>

        {/* Footer */}
        <div className="panel-footer" style={{ display: 'flex', justifyContent: 'flex-end', gap: '1rem', padding: '1.25rem 1.5rem', borderTop: '1px solid var(--glass-border)', background: 'rgba(255,255,255,0.01)' }}>
          <button className="btn btn-secondary" onClick={onClose}>Cancel</button>
          <button className="btn btn-primary" onClick={handleApply}>
            <Check size={16} /> Apply Hand Set (Hour + Minute + Second)
          </button>
        </div>
      </div>
    </div>
  );
};
