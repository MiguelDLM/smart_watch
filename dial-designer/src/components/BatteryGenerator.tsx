import React, { useState, useEffect, useRef } from 'react';
import { 
  X, 
  Check, 
  Battery 
} from 'lucide-react';

interface BatteryGeneratorProps {
  isOpen: boolean;
  onClose: () => void;
  onApply: (generatedImgDataUrl: string, width: number, height: number, frms: number, fontConfig?: any) => void;
  initialFontConfig?: any;
}

// Helpers for color interpolation
const hexToRgb = (hex: string): { r: number; g: number; b: number } => {
  let clean = hex.trim().replace('#', '');
  if (clean.length === 3) {
    clean = clean[0] + clean[0] + clean[1] + clean[1] + clean[2] + clean[2];
  }
  const num = parseInt(clean, 16);
  return {
    r: (num >> 16) & 255,
    g: (num >> 8) & 255,
    b: num & 255
  };
};

const interpolateColor = (color1: string, color2: string, factor: number): string => {
  try {
    const c1 = hexToRgb(color1);
    const c2 = hexToRgb(color2);
    const r = Math.round(c1.r + factor * (c2.r - c1.r));
    const g = Math.round(c1.g + factor * (c2.g - c1.g));
    const b = Math.round(c1.b + factor * (c2.b - c1.b));
    return `rgb(${r},${g},${b})`;
  } catch (e) {
    return color1;
  }
};

const normalizeColorForPicker = (colorStr: string): string => {
  if (!colorStr) return '#ffffff';
  let clean = colorStr.trim().toLowerCase();
  if (clean.startsWith('rgba') || clean.startsWith('rgb')) {
    return '#ffffff';
  }
  if (!clean.startsWith('#')) {
    clean = '#' + clean;
  }
  if (clean.length === 4) {
    return '#' + clean[1] + clean[1] + clean[2] + clean[2] + clean[3] + clean[3];
  }
  if (/^#[0-9a-f]{6}$/.test(clean)) {
    return clean;
  }
  return '#ffffff';
};

export const BatteryGenerator: React.FC<BatteryGeneratorProps> = ({
  isOpen,
  onClose,
  onApply,
  initialFontConfig
}) => {
  // Dimension & states
  const [frameWidth, setFrameWidth] = useState(84);
  const [frameHeight, setFrameHeight] = useState(75);
  const [frameCount, setFrameCount] = useState(6); // default is 6 frames: 0%, 20%, 40%, 60%, 80%, 100%
  
  // Design details
  const [presetStyle, setPresetStyle] = useState<'horizontal_capsule' | 'vertical_capsule' | 'circular_ring' | 'gauge_arc' | 'pill_dots'>('horizontal_capsule');
  const [colorMode, setColorMode] = useState<'solid' | 'dynamic' | 'gradient'>('dynamic');
  const [solidColor, setSolidColor] = useState('#ffffff');
  const [lowColor, setLowColor] = useState('#ff4d4d'); // red
  const [midColor, setMidColor] = useState('#ffc83b'); // yellow/orange
  const [highColor, setHighColor] = useState('#2ecc71'); // green
  
  const [strokeWidth, setStrokeWidth] = useState(3);
  const [borderRadius, setBorderRadius] = useState(6);
  const [iconPadding, setIconPadding] = useState(12);
  const [bgColor, setBgColor] = useState('transparent');
  
  // Custom overlays
  const [showPercentage, setShowPercentage] = useState(false);
  const [showLightning, setShowLightning] = useState(true); // Draw bolt on full charge
  const [fontSize, setFontSize] = useState(11);
  
  // Simulator State
  const [simLevel, setSimLevel] = useState(100);
  
  // Canvas Refs
  const [generatedDataUrl, setGeneratedDataUrl] = useState<string | null>(null);
  const canvasRef = useRef<HTMLCanvasElement | null>(null);

  // Sync initial config
  useEffect(() => {
    if (isOpen && initialFontConfig) {
      if (initialFontConfig.frameWidth !== undefined) setFrameWidth(initialFontConfig.frameWidth);
      if (initialFontConfig.frameHeight !== undefined) setFrameHeight(initialFontConfig.frameHeight);
      if (initialFontConfig.frameCount !== undefined) setFrameCount(initialFontConfig.frameCount);
      if (initialFontConfig.presetStyle) setPresetStyle(initialFontConfig.presetStyle);
      if (initialFontConfig.colorMode) setColorMode(initialFontConfig.colorMode);
      if (initialFontConfig.solidColor) setSolidColor(initialFontConfig.solidColor);
      if (initialFontConfig.lowColor) setLowColor(initialFontConfig.lowColor);
      if (initialFontConfig.midColor) setMidColor(initialFontConfig.midColor);
      if (initialFontConfig.highColor) setHighColor(initialFontConfig.highColor);
      if (initialFontConfig.strokeWidth !== undefined) setStrokeWidth(initialFontConfig.strokeWidth);
      if (initialFontConfig.borderRadius !== undefined) setBorderRadius(initialFontConfig.borderRadius);
      if (initialFontConfig.iconPadding !== undefined) setIconPadding(initialFontConfig.iconPadding);
      if (initialFontConfig.bgColor) setBgColor(initialFontConfig.bgColor);
      if (initialFontConfig.showPercentage !== undefined) setShowPercentage(initialFontConfig.showPercentage);
      if (initialFontConfig.showLightning !== undefined) setShowLightning(initialFontConfig.showLightning);
      if (initialFontConfig.fontSize !== undefined) setFontSize(initialFontConfig.fontSize);
    }
  }, [isOpen, initialFontConfig]);

  // Color logic for specific percentage
  const getColorForPercent = (percent: number): string => {
    if (colorMode === 'solid') return solidColor;
    if (colorMode === 'dynamic') {
      if (percent <= 20) return lowColor;
      if (percent <= 60) return midColor;
      return highColor;
    }
    // Gradient Mode
    if (percent <= 50) {
      return interpolateColor(lowColor, midColor, percent / 50);
    } else {
      return interpolateColor(midColor, highColor, (percent - 50) / 50);
    }
  };

  // Draw bolt
  const drawLightningBolt = (ctx: CanvasRenderingContext2D, cx: number, cy: number, size: number, color: string) => {
    ctx.fillStyle = color;
    ctx.beginPath();
    ctx.moveTo(cx + size * 0.12, cy - size * 0.45);
    ctx.lineTo(cx - size * 0.28, cy + size * 0.05);
    ctx.lineTo(cx + size * 0.04, cy + size * 0.05);
    ctx.lineTo(cx - size * 0.12, cy + size * 0.45);
    ctx.lineTo(cx + size * 0.28, cy - size * 0.05);
    ctx.lineTo(cx - size * 0.04, cy - size * 0.05);
    ctx.closePath();
    ctx.fill();
  };

  // Render function for a single frame
  const drawSingleFrame = (
    ctx: CanvasRenderingContext2D, 
    xOffset: number, 
    yOffset: number, 
    percent: number,
    isChargingSim = false
  ) => {
    const w = frameWidth;
    const h = frameHeight;
    const color = getColorForPercent(percent);

    ctx.save();
    ctx.translate(xOffset, yOffset);

    // Style 1: Horizontal Capsule
    if (presetStyle === 'horizontal_capsule') {
      const pad = iconPadding;
      const bodyW = w - pad * 2 - 6;
      const bodyH = h - pad * 2;
      const rx = borderRadius;

      // Draw Cap
      const capW = 5;
      const capH = bodyH * 0.35;
      const capX = pad + bodyW;
      const capY = pad + (bodyH - capH) / 2;
      ctx.fillStyle = color;
      ctx.beginPath();
      // Using custom path or roundRect if supported
      ctx.roundRect ? ctx.roundRect(capX, capY, capW, capH, [0, 2, 2, 0]) : ctx.rect(capX, capY, capW, capH);
      ctx.fill();

      // Draw Body Outline
      ctx.strokeStyle = color;
      ctx.lineWidth = strokeWidth;
      ctx.beginPath();
      ctx.roundRect ? ctx.roundRect(pad, pad, bodyW, bodyH, rx) : ctx.rect(pad, pad, bodyW, bodyH);
      ctx.stroke();

      // Draw Inner Charge Fill
      const margin = strokeWidth + 2;
      const maxFillW = bodyW - margin * 2;
      const fillW = maxFillW * (percent / 100);
      const fillH = bodyH - margin * 2;
      const fillX = pad + margin;
      const fillY = pad + margin;

      if (fillW > 0) {
        ctx.fillStyle = color;
        ctx.beginPath();
        ctx.roundRect ? ctx.roundRect(fillX, fillY, fillW, fillH, Math.max(0, rx - 2)) : ctx.rect(fillX, fillY, fillW, fillH);
        ctx.fill();
      }

      // Draw overlay icons or text
      const cx = pad + bodyW / 2;
      const cy = pad + bodyH / 2;

      if (showLightning && (isChargingSim || percent === 100)) {
        // Draw lightning bolt
        ctx.strokeStyle = '#000000';
        ctx.lineWidth = 3;
        ctx.lineJoin = 'round';
        // Stroke first to create contrast
        ctx.save();
        ctx.fillStyle = '#ffffff';
        drawLightningBolt(ctx, cx, cy, Math.min(bodyW, bodyH) * 0.8, '#ffc83b');
        ctx.restore();
      } else if (showPercentage && percent > 0) {
        ctx.font = `bold ${fontSize}px sans-serif`;
        ctx.fillStyle = percent > 50 ? '#000000' : color;
        ctx.textAlign = 'center';
        ctx.textBaseline = 'middle';
        ctx.fillText(`${Math.round(percent)}%`, cx, cy);
      }
    }

    // Style 2: Vertical Capsule
    if (presetStyle === 'vertical_capsule') {
      const pad = iconPadding;
      const bodyW = w - pad * 2;
      const bodyH = h - pad * 2 - 6;
      const rx = borderRadius;

      // Draw Cap on top
      const capW = bodyW * 0.35;
      const capH = 5;
      const capX = pad + (bodyW - capW) / 2;
      const capY = pad;
      ctx.fillStyle = color;
      ctx.beginPath();
      ctx.roundRect ? ctx.roundRect(capX, capY, capW, capH, [2, 2, 0, 0]) : ctx.rect(capX, capY, capW, capH);
      ctx.fill();

      // Draw Body Outline
      ctx.strokeStyle = color;
      ctx.lineWidth = strokeWidth;
      ctx.beginPath();
      ctx.roundRect ? ctx.roundRect(pad, pad + capH, bodyW, bodyH, rx) : ctx.rect(pad, pad + capH, bodyW, bodyH);
      ctx.stroke();

      // Draw Inner Charge Fill (bottom to top)
      const margin = strokeWidth + 2;
      const maxFillH = bodyH - margin * 2;
      const fillH = maxFillH * (percent / 100);
      const fillW = bodyW - margin * 2;
      const fillX = pad + margin;
      const fillY = pad + capH + bodyH - margin - fillH;

      if (fillH > 0) {
        ctx.fillStyle = color;
        ctx.beginPath();
        ctx.roundRect ? ctx.roundRect(fillX, fillY, fillW, fillH, Math.max(0, rx - 2)) : ctx.rect(fillX, fillY, fillW, fillH);
        ctx.fill();
      }

      // Draw overlay icons or text
      const cx = pad + bodyW / 2;
      const cy = pad + capH + bodyH / 2;

      if (showLightning && (isChargingSim || percent === 100)) {
        ctx.save();
        drawLightningBolt(ctx, cx, cy, Math.min(bodyW, bodyH) * 0.8, '#ffc83b');
        ctx.restore();
      } else if (showPercentage && percent > 0) {
        ctx.font = `bold ${fontSize}px sans-serif`;
        ctx.fillStyle = percent > 50 ? '#000000' : color;
        ctx.textAlign = 'center';
        ctx.textBaseline = 'middle';
        ctx.fillText(`${Math.round(percent)}%`, cx, cy);
      }
    }

    // Style 3: Circular Ring
    if (presetStyle === 'circular_ring') {
      const cx = w / 2;
      const cy = h / 2;
      const radius = Math.min(w, h) / 2 - iconPadding;

      // Draw background track
      ctx.strokeStyle = 'rgba(255,255,255,0.08)';
      ctx.lineWidth = strokeWidth;
      ctx.beginPath();
      ctx.arc(cx, cy, radius, 0, Math.PI * 2);
      ctx.stroke();

      // Draw filled arc
      if (percent > 0) {
        ctx.strokeStyle = color;
        ctx.lineWidth = strokeWidth + 1;
        ctx.lineCap = 'round';
        ctx.beginPath();
        const startAngle = -Math.PI / 2;
        const endAngle = startAngle + (Math.PI * 2) * (percent / 100);
        ctx.arc(cx, cy, radius, startAngle, endAngle);
        ctx.stroke();
      }

      // Draw overlay charging bolt or percentage inside the ring
      if (showLightning && (isChargingSim || percent === 100)) {
        drawLightningBolt(ctx, cx, cy, radius * 0.9, '#ffc83b');
      } else if (showPercentage) {
        ctx.font = `bold ${fontSize}px sans-serif`;
        ctx.fillStyle = color;
        ctx.textAlign = 'center';
        ctx.textBaseline = 'middle';
        ctx.fillText(`${Math.round(percent)}%`, cx, cy);
      } else {
        // Draw battery icon inside circular progress
        ctx.fillStyle = color;
        ctx.font = `${radius * 0.7}px sans-serif`;
        ctx.textAlign = 'center';
        ctx.textBaseline = 'middle';
        ctx.fillText('⚡', cx, cy); // Simple placeholder icon inside circle
      }
    }

    // Style 4: Gauge Arc (Open Arc Speedometer Style)
    if (presetStyle === 'gauge_arc') {
      const cx = w / 2;
      const cy = h / 2;
      const radius = Math.min(w, h) / 2 - iconPadding;
      const startAngle = 0.75 * Math.PI; // bottom-left
      const endAngle = 2.25 * Math.PI; // bottom-right
      const totalArc = 1.5 * Math.PI;

      // Draw background track
      ctx.strokeStyle = 'rgba(255,255,255,0.08)';
      ctx.lineWidth = strokeWidth;
      ctx.lineCap = 'round';
      ctx.beginPath();
      ctx.arc(cx, cy, radius, startAngle, endAngle);
      ctx.stroke();

      // Draw filled indicator
      if (percent > 0) {
        ctx.strokeStyle = color;
        ctx.lineWidth = strokeWidth + 2;
        ctx.lineCap = 'round';
        ctx.beginPath();
        const fillEndAngle = startAngle + totalArc * (percent / 100);
        ctx.arc(cx, cy, radius, startAngle, fillEndAngle);
        ctx.stroke();
      }

      // Draw overlay charging bolt or percentage inside the gauge
      if (showLightning && (isChargingSim || percent === 100)) {
        drawLightningBolt(ctx, cx, cy, radius * 0.9, '#ffc83b');
      } else if (showPercentage) {
        ctx.font = `bold ${fontSize}px sans-serif`;
        ctx.fillStyle = color;
        ctx.textAlign = 'center';
        ctx.textBaseline = 'middle';
        ctx.fillText(`${Math.round(percent)}%`, cx, cy);
      }
    }

    // Style 5: Segmented Dots
    if (presetStyle === 'pill_dots') {
      const pad = iconPadding;
      const dotsCount = 5;
      const activeDots = Math.ceil((percent / 100) * dotsCount);
      
      const gap = 4;
      const bodyW = w - pad * 2;
      const dotW = (bodyW - (dotsCount - 1) * gap) / dotsCount;
      const dotH = h - pad * 2;
      const rx = borderRadius;

      for (let i = 0; i < dotsCount; i++) {
        const dotX = pad + i * (dotW + gap);
        ctx.fillStyle = i < activeDots ? color : 'rgba(255,255,255,0.08)';
        ctx.beginPath();
        ctx.roundRect ? ctx.roundRect(dotX, pad, dotW, dotH, rx) : ctx.rect(dotX, pad, dotW, dotH);
        ctx.fill();
      }

      if (showLightning && (isChargingSim || percent === 100)) {
        ctx.save();
        // Draw centered charging bolt over dots
        const cx = w / 2;
        const cy = h / 2;
        ctx.strokeStyle = '#000';
        ctx.lineWidth = 3;
        // Stroke outline to separate from background
        drawLightningBolt(ctx, cx, cy, Math.min(bodyW, dotH) * 0.9, '#ffc83b');
        ctx.restore();
      }
    }

    ctx.restore();
  };

  // Generate Battery Sheet Image URL
  const generateSheet = () => {
    const canvas = canvasRef.current || document.createElement('canvas');
    canvas.width = frameWidth;
    canvas.height = frameHeight * frameCount;

    const ctx = canvas.getContext('2d');
    if (!ctx) return;

    // Clear background
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    if (bgColor !== 'transparent') {
      ctx.fillStyle = bgColor;
      ctx.fillRect(0, 0, canvas.width, canvas.height);
    }

    // Draw each frame vertically stacked
    for (let i = 0; i < frameCount; i++) {
      // Calculate level percentage for this frame
      // Frame 0 = 0%
      // Last frame = 100%
      const percentage = frameCount > 1 ? (i / (frameCount - 1)) * 100 : 100;
      
      // Draw frame
      drawSingleFrame(ctx, 0, i * frameHeight, percentage);
    }

    const dataUrl = canvas.toDataURL('image/png');
    setGeneratedDataUrl(dataUrl);
  };

  // Re-generate sheet when settings change
  useEffect(() => {
    if (isOpen) {
      generateSheet();
    }
  }, [
    isOpen,
    frameWidth,
    frameHeight,
    frameCount,
    presetStyle,
    colorMode,
    solidColor,
    lowColor,
    midColor,
    highColor,
    strokeWidth,
    borderRadius,
    iconPadding,
    bgColor,
    showPercentage,
    showLightning,
    fontSize
  ]);

  // Preview simulator single frame drawing helper
  const drawSimulator = (canvas: HTMLCanvasElement | null) => {
    if (!canvas) return;
    canvas.width = frameWidth * 2; // double size for clear preview
    canvas.height = frameHeight * 2;
    const ctx = canvas.getContext('2d');
    if (!ctx) return;

    ctx.clearRect(0, 0, canvas.width, canvas.height);
    if (bgColor !== 'transparent') {
      ctx.fillStyle = bgColor;
      ctx.fillRect(0, 0, canvas.width, canvas.height);
    }

    ctx.save();
    ctx.scale(2, 2); // upscale single frame
    drawSingleFrame(ctx, 0, 0, simLevel);
    ctx.restore();
  };

  // Run simulator draw
  const simCanvasRef = useRef<HTMLCanvasElement | null>(null);
  useEffect(() => {
    if (isOpen) {
      drawSimulator(simCanvasRef.current);
    }
  }, [
    isOpen,
    simLevel,
    frameWidth,
    frameHeight,
    presetStyle,
    colorMode,
    solidColor,
    lowColor,
    midColor,
    highColor,
    strokeWidth,
    borderRadius,
    iconPadding,
    bgColor,
    showPercentage,
    showLightning,
    fontSize
  ]);

  if (!isOpen) return null;

  return (
    <div 
      style={{
        position: 'fixed',
        inset: 0,
        backgroundColor: 'rgba(0,0,0,0.7)',
        backdropFilter: 'blur(8px)',
        zIndex: 100,
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
        padding: '2rem'
      }}
    >
      <div 
        className="glass-panel" 
        style={{
          width: '100%',
          maxWidth: '850px',
          maxHeight: '90vh',
          display: 'flex',
          flexDirection: 'column',
          overflow: 'hidden',
          boxShadow: 'var(--shadow-lg)'
        }}
      >
        {/* Header */}
        <div 
          className="panel-header" 
          style={{
            display: 'flex',
            justifyContent: 'space-between',
            alignItems: 'center',
            padding: '1.25rem 1.5rem',
            borderBottom: '1px solid var(--glass-border)'
          }}
        >
          <div style={{ display: 'flex', alignItems: 'center', gap: '0.75rem' }}>
            <Battery size={20} color="var(--accent-hover)" />
            <h3 style={{ margin: 0, fontSize: '1.25rem', fontWeight: 800 }}>Battery Icon Sheet Generator</h3>
          </div>
          <button 
            onClick={onClose}
            style={{
              background: 'transparent',
              border: 'none',
              color: 'var(--text-secondary)',
              cursor: 'pointer',
              display: 'flex',
              padding: '0.25rem'
            }}
          >
            <X size={20} />
          </button>
        </div>

        {/* Scrollable Layout Body */}
        <div style={{ display: 'flex', flexGrow: 1, overflow: 'hidden' }}>
          
          {/* Settings Column */}
          <div 
            style={{
              flex: '1',
              padding: '1.5rem',
              overflowY: 'auto',
              borderRight: '1px solid var(--glass-border)',
              display: 'flex',
              flexDirection: 'column',
              gap: '1.25rem'
            }}
          >
            {/* Style Preset Selector */}
            <div style={{ display: 'flex', flexDirection: 'column', gap: '0.4rem' }}>
              <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600 }}>BATTERY PRESET STYLE</label>
              <select
                value={presetStyle}
                onChange={(e) => setPresetStyle(e.target.value as any)}
                style={{
                  background: 'var(--bg-secondary)',
                  border: '1px solid var(--glass-border)',
                  color: 'var(--text-primary)',
                  padding: '0.5rem',
                  borderRadius: '6px',
                  fontFamily: 'var(--font-sans)',
                  width: '100%'
                }}
              >
                <option value="horizontal_capsule">Horizontal Capsule (Classic)</option>
                <option value="vertical_capsule">Vertical Capsule</option>
                <option value="circular_ring">Circular Progress Ring</option>
                <option value="gauge_arc">Open Gauge Speedometer Arc</option>
                <option value="pill_dots">Segmented Capsule Dots (5 steps)</option>
              </select>
            </div>

            {/* Frame Dimensions & Counts */}
            <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr 1fr', gap: '0.75rem' }}>
              <div style={{ display: 'flex', flexDirection: 'column', gap: '0.4rem' }}>
                <label style={{ fontSize: '0.75rem', color: 'var(--text-muted)', fontWeight: 600 }}>WIDTH</label>
                <input 
                  type="number" min="16" max="256" value={frameWidth}
                  onChange={(e) => setFrameWidth(Math.max(16, parseInt(e.target.value) || 16))}
                  style={{
                    background: 'var(--bg-secondary)',
                    border: '1px solid var(--glass-border)',
                    color: 'var(--text-primary)',
                    padding: '0.5rem',
                    borderRadius: '6px',
                    fontFamily: 'var(--font-mono)',
                    width: '100%'
                  }}
                />
              </div>
              <div style={{ display: 'flex', flexDirection: 'column', gap: '0.4rem' }}>
                <label style={{ fontSize: '0.75rem', color: 'var(--text-muted)', fontWeight: 600 }}>HEIGHT</label>
                <input 
                  type="number" min="16" max="256" value={frameHeight}
                  onChange={(e) => setFrameHeight(Math.max(16, parseInt(e.target.value) || 16))}
                  style={{
                    background: 'var(--bg-secondary)',
                    border: '1px solid var(--glass-border)',
                    color: 'var(--text-primary)',
                    padding: '0.5rem',
                    borderRadius: '6px',
                    fontFamily: 'var(--font-mono)',
                    width: '100%'
                  }}
                />
              </div>
              <div style={{ display: 'flex', flexDirection: 'column', gap: '0.4rem' }}>
                <label style={{ fontSize: '0.75rem', color: 'var(--text-muted)', fontWeight: 600 }} title="Number of levels/frames to compile">LEVELS (FRAMES)</label>
                <select
                  value={frameCount}
                  onChange={(e) => setFrameCount(parseInt(e.target.value) || 6)}
                  style={{
                    background: 'var(--bg-secondary)',
                    border: '1px solid var(--glass-border)',
                    color: 'var(--text-primary)',
                    padding: '0.5rem',
                    borderRadius: '6px',
                    fontFamily: 'var(--font-sans)',
                    width: '100%'
                  }}
                >
                  <option value="5">5 (0%, 25%, 50%, 75%, 100%)</option>
                  <option value="6">6 (20% Steps - Default)</option>
                  <option value="10">10 (10% Steps)</option>
                  <option value="11">11 (0% to 100% in 10% steps)</option>
                </select>
              </div>
            </div>

            {/* Colors and Coloring Modes */}
            <div className="glass-panel" style={{ padding: '1rem', display: 'flex', flexDirection: 'column', gap: '0.75rem', background: 'rgba(255,255,255,0.01)' }}>
              <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
                <span style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600 }}>COLOR MODE</span>
                <div style={{ display: 'flex', gap: '0.5rem' }}>
                  {['solid', 'dynamic', 'gradient'].map((m) => (
                    <button
                      key={m}
                      onClick={() => setColorMode(m as any)}
                      className={`badge ${colorMode === m ? 'accent' : ''}`}
                      style={{ border: 'none', cursor: 'pointer', textTransform: 'capitalize', fontSize: '10px', padding: '0.2rem 0.5rem' }}
                    >
                      {m}
                    </button>
                  ))}
                </div>
              </div>

              {colorMode === 'solid' ? (
                <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between' }}>
                  <span style={{ fontSize: '0.85rem' }}>Battery Color</span>
                  <div style={{ display: 'flex', alignItems: 'center', gap: '0.5rem' }}>
                    <input 
                      type="color" 
                      value={normalizeColorForPicker(solidColor)}
                      onChange={(e) => setSolidColor(e.target.value)}
                      style={{ border: 'none', background: 'transparent', width: '32px', height: '32px', cursor: 'pointer' }}
                    />
                    <input 
                      type="text" 
                      value={solidColor}
                      onChange={(e) => setSolidColor(e.target.value)}
                      style={{ width: '80px', padding: '0.3rem', borderRadius: '4px', border: '1px solid var(--glass-border)', background: 'var(--bg-secondary)', color: 'var(--text-primary)', fontSize: '0.8rem', fontFamily: 'var(--font-mono)' }}
                    />
                  </div>
                </div>
              ) : (
                <div style={{ display: 'flex', flexDirection: 'column', gap: '0.5rem' }}>
                  {/* Dynamic Color Inputs */}
                  <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between' }}>
                    <span style={{ fontSize: '0.85rem', display: 'flex', alignItems: 'center', gap: '0.35rem' }}>
                      <span style={{ width: '8px', height: '8px', borderRadius: '50%', backgroundColor: lowColor }} /> Low (0-20%)
                    </span>
                    <input 
                      type="color" value={normalizeColorForPicker(lowColor)}
                      onChange={(e) => setLowColor(e.target.value)}
                      style={{ border: 'none', background: 'transparent', width: '28px', height: '28px', cursor: 'pointer' }}
                    />
                  </div>
                  <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between' }}>
                    <span style={{ fontSize: '0.85rem', display: 'flex', alignItems: 'center', gap: '0.35rem' }}>
                      <span style={{ width: '8px', height: '8px', borderRadius: '50%', backgroundColor: midColor }} /> Medium (20-60%)
                    </span>
                    <input 
                      type="color" value={normalizeColorForPicker(midColor)}
                      onChange={(e) => setMidColor(e.target.value)}
                      style={{ border: 'none', background: 'transparent', width: '28px', height: '28px', cursor: 'pointer' }}
                    />
                  </div>
                  <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between' }}>
                    <span style={{ fontSize: '0.85rem', display: 'flex', alignItems: 'center', gap: '0.35rem' }}>
                      <span style={{ width: '8px', height: '8px', borderRadius: '50%', backgroundColor: highColor }} /> High (60-100%)
                    </span>
                    <input 
                      type="color" value={normalizeColorForPicker(highColor)}
                      onChange={(e) => setHighColor(e.target.value)}
                      style={{ border: 'none', background: 'transparent', width: '28px', height: '28px', cursor: 'pointer' }}
                    />
                  </div>
                </div>
              )}
            </div>

            {/* Custom overlays & styling details */}
            <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '1rem' }}>
              <div style={{ display: 'flex', flexDirection: 'column', gap: '0.4rem' }}>
                <label style={{ fontSize: '0.75rem', color: 'var(--text-muted)', fontWeight: 600 }}>STROKE WIDTH</label>
                <input 
                  type="range" min="1" max="10" value={strokeWidth}
                  onChange={(e) => setStrokeWidth(parseInt(e.target.value) || 2)}
                  style={{ width: '100%', accentColor: 'var(--accent)' }}
                />
              </div>
              <div style={{ display: 'flex', flexDirection: 'column', gap: '0.4rem' }}>
                <label style={{ fontSize: '0.75rem', color: 'var(--text-muted)', fontWeight: 600 }}>INNER CORNER RADIUS</label>
                <input 
                  type="range" min="0" max="20" value={borderRadius}
                  onChange={(e) => setBorderRadius(parseInt(e.target.value) || 0)}
                  style={{ width: '100%', accentColor: 'var(--accent)' }}
                />
              </div>
            </div>

            <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '1rem' }}>
              <div style={{ display: 'flex', flexDirection: 'column', gap: '0.4rem' }}>
                <label style={{ fontSize: '0.75rem', color: 'var(--text-muted)', fontWeight: 600 }}>PADDING</label>
                <input 
                  type="range" min="0" max="30" value={iconPadding}
                  onChange={(e) => setIconPadding(parseInt(e.target.value) || 0)}
                  style={{ width: '100%', accentColor: 'var(--accent)' }}
                />
              </div>
              <div style={{ display: 'flex', flexDirection: 'column', gap: '0.4rem' }}>
                <label style={{ fontSize: '0.75rem', color: 'var(--text-muted)', fontWeight: 600 }}>BACKGROUND CANVAS</label>
                <select
                  value={bgColor}
                  onChange={(e) => setBgColor(e.target.value)}
                  style={{
                    background: 'var(--bg-secondary)',
                    border: '1px solid var(--glass-border)',
                    color: 'var(--text-primary)',
                    padding: '0.5rem',
                    borderRadius: '6px',
                    fontFamily: 'var(--font-sans)',
                    width: '100%'
                  }}
                >
                  <option value="transparent">Transparent (Transparente)</option>
                  <option value="#000000">Black (Negro)</option>
                  <option value="#1a1a1a">Dark Grey (Gris Oscuro)</option>
                </select>
              </div>
            </div>

            {/* Extra Premium Features */}
            <div style={{ display: 'flex', flexDirection: 'column', gap: '0.65rem', borderTop: '1px solid var(--glass-border)', paddingTop: '1rem' }}>
              <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between' }}>
                <label htmlFor="show-charge-lightning" style={{ fontSize: '0.85rem', cursor: 'pointer' }}>Show Charging Bolt Icon (⚡)</label>
                <input 
                  type="checkbox" id="show-charge-lightning" checked={showLightning}
                  onChange={(e) => setShowLightning(e.target.checked)}
                  style={{ width: '16px', height: '16px', accentColor: 'var(--accent)' }}
                />
              </div>

              {(presetStyle === 'horizontal_capsule' || presetStyle === 'vertical_capsule' || presetStyle === 'circular_ring' || presetStyle === 'gauge_arc') && (
                <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between' }}>
                  <label htmlFor="show-pct-text" style={{ fontSize: '0.85rem', cursor: 'pointer' }}>Draw Percentage text inside battery</label>
                  <input 
                    type="checkbox" id="show-pct-text" checked={showPercentage}
                    onChange={(e) => setShowPercentage(e.target.checked)}
                    style={{ width: '16px', height: '16px', accentColor: 'var(--accent)' }}
                  />
                </div>
              )}

              {showPercentage && (
                <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between', paddingLeft: '1rem' }}>
                  <span style={{ fontSize: '0.8rem', color: 'var(--text-muted)' }}>Font Size</span>
                  <input 
                    type="range" min="8" max="24" value={fontSize}
                    onChange={(e) => setFontSize(parseInt(e.target.value) || 12)}
                    style={{ width: '120px', accentColor: 'var(--accent)' }}
                  />
                </div>
              )}
            </div>

          </div>

          {/* Real-time Preview Column */}
          <div 
            style={{
              width: '320px',
              padding: '1.5rem',
              background: 'rgba(0,0,0,0.2)',
              display: 'flex',
              flexDirection: 'column',
              alignItems: 'center',
              justifyContent: 'space-between',
              overflowY: 'auto'
            }}
          >
            {/* Live Simulator View */}
            <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'center', width: '100%', gap: '1rem' }}>
              <span style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600, letterSpacing: '0.05em' }}>BATTERY SIMULATOR</span>
              
              <div 
                style={{ 
                  width: '180px', 
                  height: '180px', 
                  background: bgColor === 'transparent' ? '#0b0c16' : bgColor,
                  backgroundImage: bgColor === 'transparent' ? 'radial-gradient(rgba(255,255,255,0.04) 1px, transparent 0)' : 'none',
                  backgroundSize: '16px 16px',
                  borderRadius: '12px', 
                  border: '1px dashed var(--glass-border)',
                  display: 'flex',
                  justifyContent: 'center',
                  alignItems: 'center',
                  boxShadow: 'inset 0 0 10px rgba(0,0,0,0.5)',
                  position: 'relative'
                }}
              >
                <canvas ref={simCanvasRef} style={{ maxWidth: '100%', maxHeight: '100%' }} />
                
                {/* Simulation indicator */}
                <div style={{ position: 'absolute', bottom: '6px', fontSize: '0.75rem', fontFamily: 'var(--font-mono)', fontWeight: 'bold', color: getColorForPercent(simLevel) }}>
                  Sim: {simLevel}% {simLevel === 100 && showLightning ? '(Charging ⚡)' : ''}
                </div>
              </div>

              {/* Slider for level */}
              <div style={{ display: 'flex', flexDirection: 'column', gap: '0.35rem', width: '100%' }}>
                <div style={{ display: 'flex', justifyContent: 'space-between', fontSize: '0.75rem' }}>
                  <span style={{ color: 'var(--text-muted)' }}>Test Level:</span>
                  <span style={{ fontFamily: 'var(--font-mono)', fontWeight: 'bold' }}>{simLevel}%</span>
                </div>
                <input 
                  type="range" min="0" max="100" value={simLevel}
                  onChange={(e) => setSimLevel(parseInt(e.target.value) || 0)}
                  style={{ width: '100%', accentColor: 'var(--accent)' }}
                />
              </div>
            </div>

            {/* Vertical Sheet Preview */}
            <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'center', width: '100%', gap: '0.75rem', marginTop: '1.5rem' }}>
              <span style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600, letterSpacing: '0.05em' }}>COMPILED VERTICAL SHEET</span>
              <div 
                style={{
                  width: '100%',
                  height: '180px',
                  overflowY: 'auto',
                  border: '1px solid var(--glass-border)',
                  borderRadius: '6px',
                  padding: '1rem 0.5rem',
                  display: 'flex',
                  flexDirection: 'column',
                  alignItems: 'center',
                  background: 'rgba(255,255,255,0.01)',
                  boxShadow: 'inset 0 0 8px rgba(0,0,0,0.3)'
                }}
              >
                {generatedDataUrl ? (
                  <img 
                    src={generatedDataUrl} 
                    alt="Battery Sheet Preview" 
                    style={{
                      border: '1px solid rgba(255,255,255,0.1)',
                      background: bgColor === 'transparent' ? '#0b0c16' : bgColor,
                    }}
                  />
                ) : (
                  <span style={{ fontSize: '0.8rem', color: 'var(--text-muted)' }}>Generating preview...</span>
                )}
              </div>
              <span style={{ fontSize: '10px', color: 'var(--text-muted)' }}>
                Total: {frameWidth}x{frameHeight * frameCount} px ({frameCount} frames)
              </span>
            </div>

          </div>

        </div>

        {/* Footer Actions */}
        <div 
          className="panel-footer" 
          style={{
            display: 'flex',
            justifyContent: 'flex-end',
            gap: '1rem',
            padding: '1.25rem 1.5rem',
            borderTop: '1px solid var(--glass-border)',
            background: 'rgba(255, 255, 255, 0.01)'
          }}
        >
          <button 
            className="btn btn-secondary" 
            onClick={onClose}
          >
            Cancel
          </button>
          
          <button 
            className="btn btn-primary" 
            onClick={() => {
              if (generatedDataUrl) {
                // Return generated PNG, dimensions, and config metadata to save settings
                onApply(
                  generatedDataUrl, 
                  frameWidth, 
                  frameHeight, 
                  frameCount, 
                  {
                    frameWidth,
                    frameHeight,
                    frameCount,
                    presetStyle,
                    colorMode,
                    solidColor,
                    lowColor,
                    midColor,
                    highColor,
                    strokeWidth,
                    borderRadius,
                    iconPadding,
                    bgColor,
                    showPercentage,
                    showLightning,
                    fontSize
                  }
                );
              }
            }}
            disabled={!generatedDataUrl}
          >
            <Check size={16} />
            Apply Battery Sheet
          </button>
        </div>

      </div>
    </div>
  );
};
