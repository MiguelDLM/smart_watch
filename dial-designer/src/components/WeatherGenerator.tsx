import React, { useState, useEffect, useRef } from 'react';
import { 
  X, 
  Check, 
  Download, 
  Palette, 
  PaintBucket, 
  Paintbrush, 
  Sparkles, 
  MoveHorizontal, 
  MoveVertical, 
  Move,
  CloudSun
} from 'lucide-react';

interface WeatherGeneratorProps {
  isOpen: boolean;
  onClose: () => void;
  onApply: (generatedImgDataUrl: string, width: number, height: number, frms: number, fontConfig?: any) => void;
  initialFontConfig?: any;
}

const normalizeColorForPicker = (colorStr: string): string => {
  if (!colorStr) return '#000000';
  let clean = colorStr.trim().toLowerCase();
  if (clean.startsWith('rgba')) {
    return '#000000';
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
  return '#000000';
};

const WEATHER_STATE_ICONS = [
  {
    code: 0,
    name: 'Other (Otro / Desconocido)',
    // HelpCircle
    svg: '<circle cx="12" cy="12" r="10" /><path d="M9.09 9a3 3 0 0 1 5.83 1c0 2-3 3-3 3" /><path d="M12 17h.01" />'
  },
  {
    code: 1,
    name: 'Sunny (Soleado)',
    // Sun
    svg: '<circle cx="12" cy="12" r="4" /><path d="M12 2v2m0 16v2M4.93 4.93l1.41 1.41m11.32 11.32l1.41 1.41M2 12h2m16 0h2M6.34 17.66l-1.41 1.41m12.73-12.73l-1.41 1.41" />'
  },
  {
    code: 2,
    name: 'Cloudy (Nuboso)',
    // CloudSun
    svg: '<path d="M12 2v2M4.93 4.93l1.41 1.41M2 12h2M6.34 17.66l-1.41 1.41M19.07 4.93l-1.41 1.41" /><path d="M15.9 10.9A5.5 5.5 0 0 0 9 17h5a3.5 3.5 0 1 0 0-7c-.1 0-.2 0-.3.1" />'
  },
  {
    code: 3,
    name: 'Overcast (Cubierto)',
    // Cloud
    svg: '<path d="M17.5 19A3.5 3.5 0 0 0 21 15.5c0-2.79-2.54-4.5-5-4.5-.51 0-1-.07-1.5-.2-1-1.89-3-3.8-5.5-3.8A5 5 0 0 0 4 12c0 .48.06.94.18 1.38A3.5 3.5 0 0 0 3.5 20h14" />'
  },
  {
    code: 4,
    name: 'Rainy (Lluvioso)',
    // CloudRain
    svg: '<path d="M17.5 19A3.5 3.5 0 0 0 21 15.5c0-2.79-2.54-4.5-5-4.5-.51 0-1-.07-1.5-.2-1-1.89-3-3.8-5.5-3.8A5 5 0 0 0 4 12c0 .48.06.94.18 1.38A3.5 3.5 0 0 0 3.5 20h14" /><path d="M8 22v-2m4 2v-2m4 2v-2" />'
  },
  {
    code: 5,
    name: 'Thunder (Tormenta)',
    // CloudLightning
    svg: '<path d="M19 16.9A5 5 0 0 0 18 7h-1.26a8 8 0 1 0-11.62 8.58" /><path d="M13 11l-4 6h6l-3 5" />'
  },
  {
    code: 6,
    name: 'Thundershower (Tormenta con lluvia)',
    // CloudLightning + Rain drops
    svg: '<path d="M19 16.9A5 5 0 0 0 18 7h-1.26a8 8 0 1 0-11.62 8.58" /><path d="M13 11l-3 5h4l-2 4" /><path d="M8 18v2m8-2v2" />'
  },
  {
    code: 7,
    name: 'High-wind (Viento fuerte)',
    // Wind
    svg: '<path d="M17.7 7.7a2.5 2.5 0 1 1 1.8 4.3H2M9.6 4.6A2 2 0 1 1 11 8H2M12.6 19.4A2 2 0 1 0 14 16H2" />'
  },
  {
    code: 8,
    name: 'Snowy (Nevado)',
    // Snowflake
    svg: '<path d="M2 12h20M12 2v20m8-4-4-4 4-4M4 8l4 4-4 4m12 4-4-4-4 4M8 4l4 4 4-4" />'
  },
  {
    code: 9,
    name: 'Foggy (Niebla)',
    // Cloud + horizontal mist lines
    svg: '<path d="M17.5 19A3.5 3.5 0 0 0 21 15.5c0-2.79-2.54-4.5-5-4.5-.51 0-1-.07-1.5-.2-1-1.89-3-3.8-5.5-3.8A5 5 0 0 0 4 12c0 .48.06.94.18 1.38A3.5 3.5 0 0 0 3.5 20h14" /><path d="M4 22h16M6 19h12" />'
  },
  {
    code: 10,
    name: 'Sandstorm (Tormenta de arena)',
    // Tornado
    svg: '<path d="M21 4H3m17 4H4m14 4H6m9 4H9m4 4h-2" />'
  },
  {
    code: 11,
    name: 'Haze (Neblina)',
    // Sun + mist lines below
    svg: '<path d="M18 10a6 6 0 1 0-12 0" /><path d="M2 22h20M6 18h12M8 14h8" />'
  }
];

export const WeatherGenerator: React.FC<WeatherGeneratorProps> = ({
  isOpen,
  onClose,
  onApply,
  initialFontConfig
}) => {
  // Dimension & styles states
  const [frameWidth, setFrameWidth] = useState(48);
  const [frameHeight, setFrameHeight] = useState(48);
  const [iconColor, setIconColor] = useState('#ffffff');
  const [bgColor, setBgColor] = useState('transparent');
  const [strokeWidth, setStrokeWidth] = useState(2);
  const [iconPadding, setIconPadding] = useState(8);

  // Shadow/Glow styling
  const [shadowColor, setShadowColor] = useState('rgba(0,0,0,0.5)');
  const [shadowBlur, setShadowBlur] = useState(0);
  const [shadowOffsetX, setShadowOffsetX] = useState(0);
  const [shadowOffsetY, setShadowOffsetY] = useState(0);

  // Output
  const [generatedDataUrl, setGeneratedDataUrl] = useState<string | null>(null);
  const canvasRef = useRef<HTMLCanvasElement | null>(null);

  // Load initial configuration if editing
  useEffect(() => {
    if (isOpen && initialFontConfig) {
      if (initialFontConfig.frameWidth !== undefined) setFrameWidth(initialFontConfig.frameWidth);
      if (initialFontConfig.frameHeight !== undefined) setFrameHeight(initialFontConfig.frameHeight);
      if (initialFontConfig.iconColor) setIconColor(initialFontConfig.iconColor);
      if (initialFontConfig.bgColor) setBgColor(initialFontConfig.bgColor);
      if (initialFontConfig.strokeWidth !== undefined) setStrokeWidth(initialFontConfig.strokeWidth);
      if (initialFontConfig.iconPadding !== undefined) setIconPadding(initialFontConfig.iconPadding);
      if (initialFontConfig.shadowColor) setShadowColor(initialFontConfig.shadowColor);
      if (initialFontConfig.shadowBlur !== undefined) setShadowBlur(initialFontConfig.shadowBlur);
      if (initialFontConfig.shadowOffsetX !== undefined) setShadowOffsetX(initialFontConfig.shadowOffsetX);
      if (initialFontConfig.shadowOffsetY !== undefined) setShadowOffsetY(initialFontConfig.shadowOffsetY);
    }
  }, [isOpen, initialFontConfig]);

  // Generate Weather Sheet
  const generateSheet = async () => {
    const canvas = canvasRef.current || document.createElement('canvas');
    canvas.width = frameWidth;
    canvas.height = frameHeight * 12;

    const ctx = canvas.getContext('2d');
    if (!ctx) return;

    // Clear background
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    if (bgColor !== 'transparent') {
      ctx.fillStyle = bgColor;
      ctx.fillRect(0, 0, canvas.width, canvas.height);
    }

    const size = Math.min(frameWidth, frameHeight) - (iconPadding * 2);

    const promises = WEATHER_STATE_ICONS.map((item, index) => {
      return new Promise<void>((resolve) => {
        const svgString = `<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="${size}" height="${size}" fill="none" stroke="${iconColor}" stroke-width="${strokeWidth}" stroke-linecap="round" stroke-linejoin="round">${item.svg}</svg>`;
        const svgBlob = new Blob([svgString], { type: 'image/svg+xml;charset=utf-8' });
        const url = URL.createObjectURL(svgBlob);
        const img = new Image();
        img.onload = () => {
          const x = (frameWidth - size) / 2;
          const y = index * frameHeight + (frameHeight - size) / 2;

          if (shadowBlur > 0) {
            ctx.save();
            ctx.shadowColor = shadowColor;
            ctx.shadowBlur = shadowBlur;
            ctx.shadowOffsetX = shadowOffsetX;
            ctx.shadowOffsetY = shadowOffsetY;
            ctx.drawImage(img, x, y, size, size);
            ctx.restore();
          } else {
            ctx.drawImage(img, x, y, size, size);
          }

          URL.revokeObjectURL(url);
          resolve();
        };
        img.onerror = () => {
          URL.revokeObjectURL(url);
          resolve();
        };
        img.src = url;
      });
    });

    await Promise.all(promises);

    const dataUrl = canvas.toDataURL('image/png');
    setGeneratedDataUrl(dataUrl);
  };

  // Re-generate sheet when options change
  useEffect(() => {
    if (isOpen) {
      generateSheet();
    }
  }, [
    isOpen,
    frameWidth,
    frameHeight,
    iconColor,
    bgColor,
    strokeWidth,
    iconPadding,
    shadowColor,
    shadowBlur,
    shadowOffsetX,
    shadowOffsetY
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
            <CloudSun size={20} color="var(--accent-hover)" />
            <h3 style={{ margin: 0, fontSize: '1.25rem', fontWeight: 800 }}>Weather Icon Sheet Generator</h3>
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
            {/* Dimensions */}
            <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '1rem' }}>
              <div style={{ display: 'flex', flexDirection: 'column', gap: '0.35rem' }}>
                <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600, display: 'flex', alignItems: 'center', gap: '0.35rem' }}>
                  <MoveHorizontal size={14} /> FRAME WIDTH
                </label>
                <input 
                  type="number"
                  min="8"
                  value={frameWidth}
                  onChange={(e) => setFrameWidth(Math.max(8, parseInt(e.target.value) || 8))}
                  style={{
                    background: 'var(--bg-secondary)',
                    border: '1px solid var(--glass-border)',
                    color: 'var(--text-primary)',
                    padding: '0.5rem',
                    borderRadius: '6px',
                    fontFamily: 'var(--font-mono)',
                  }}
                />
              </div>
              <div style={{ display: 'flex', flexDirection: 'column', gap: '0.35rem' }}>
                <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600, display: 'flex', alignItems: 'center', gap: '0.35rem' }}>
                  <MoveVertical size={14} /> FRAME HEIGHT
                </label>
                <input 
                  type="number"
                  min="8"
                  value={frameHeight}
                  onChange={(e) => setFrameHeight(Math.max(8, parseInt(e.target.value) || 8))}
                  style={{
                    background: 'var(--bg-secondary)',
                    border: '1px solid var(--glass-border)',
                    color: 'var(--text-primary)',
                    padding: '0.5rem',
                    borderRadius: '6px',
                    fontFamily: 'var(--font-mono)',
                  }}
                />
              </div>
            </div>

            {/* Colors picker */}
            <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '1rem' }}>
              <div style={{ display: 'flex', flexDirection: 'column', gap: '0.35rem' }}>
                <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600, display: 'flex', alignItems: 'center', gap: '0.35rem' }}>
                  <Palette size={14} /> ICON COLOR
                </label>
                <div style={{ display: 'flex', gap: '0.5rem', alignItems: 'center' }}>
                  <input 
                    type="color"
                    value={normalizeColorForPicker(iconColor)}
                    onChange={(e) => setIconColor(e.target.value)}
                    style={{
                      border: 'none',
                      background: 'none',
                      width: '32px',
                      height: '32px',
                      cursor: 'pointer'
                    }}
                  />
                  <input 
                    type="text" 
                    value={iconColor}
                    onChange={(e) => setIconColor(e.target.value)}
                    style={{
                      background: 'var(--bg-secondary)',
                      border: '1px solid var(--glass-border)',
                      color: 'var(--text-primary)',
                      padding: '0.4rem',
                      borderRadius: '6px',
                      fontFamily: 'var(--font-mono)',
                      fontSize: '0.85rem',
                      width: '100%'
                    }}
                  />
                </div>
              </div>

              <div style={{ display: 'flex', flexDirection: 'column', gap: '0.35rem' }}>
                <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600, display: 'flex', alignItems: 'center', gap: '0.35rem' }}>
                  <PaintBucket size={14} /> BACKGROUND
                </label>
                <div style={{ display: 'flex', gap: '0.5rem', alignItems: 'center' }}>
                  <select 
                    value={bgColor === 'transparent' ? 'transparent' : 'color'}
                    onChange={(e) => setBgColor(e.target.value === 'transparent' ? 'transparent' : '#000000')}
                    style={{
                      background: 'var(--bg-secondary)',
                      border: '1px solid var(--glass-border)',
                      color: 'var(--text-primary)',
                      padding: '0.45rem',
                      borderRadius: '6px',
                      fontFamily: 'var(--font-sans)',
                      width: '100px'
                    }}
                  >
                    <option value="transparent">Transparent</option>
                    <option value="color">Solid Color</option>
                  </select>
                  
                  {bgColor !== 'transparent' && (
                    <input 
                      type="color"
                      value={normalizeColorForPicker(bgColor)}
                      onChange={(e) => setBgColor(e.target.value)}
                      style={{
                        border: 'none',
                        background: 'none',
                        width: '32px',
                        height: '32px',
                        cursor: 'pointer'
                      }}
                    />
                  )}
                </div>
              </div>
            </div>

            {/* Thickness and Padding */}
            <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '1rem' }}>
              <div style={{ display: 'flex', flexDirection: 'column', gap: '0.35rem' }}>
                <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600, display: 'flex', alignItems: 'center', gap: '0.35rem' }}>
                  <Paintbrush size={14} /> STROKE THICKNESS
                </label>
                <input 
                  type="number"
                  min="0.5"
                  max="5"
                  step="0.5"
                  value={strokeWidth}
                  onChange={(e) => setStrokeWidth(Math.max(0.5, parseFloat(e.target.value) || 1))}
                  style={{
                    background: 'var(--bg-secondary)',
                    border: '1px solid var(--glass-border)',
                    color: 'var(--text-primary)',
                    padding: '0.5rem',
                    borderRadius: '6px',
                    fontFamily: 'var(--font-mono)',
                  }}
                />
              </div>
              <div style={{ display: 'flex', flexDirection: 'column', gap: '0.35rem' }}>
                <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600, display: 'flex', alignItems: 'center', gap: '0.35rem' }}>
                  <Move size={14} /> INNER PADDING (PX)
                </label>
                <input 
                  type="number"
                  min="0"
                  max="20"
                  value={iconPadding}
                  onChange={(e) => setIconPadding(Math.max(0, parseInt(e.target.value) || 0))}
                  style={{
                    background: 'var(--bg-secondary)',
                    border: '1px solid var(--glass-border)',
                    color: 'var(--text-primary)',
                    padding: '0.5rem',
                    borderRadius: '6px',
                    fontFamily: 'var(--font-mono)',
                  }}
                />
              </div>
            </div>

            {/* Shadow & Glow Settings */}
            <div style={{ borderTop: '1px solid var(--glass-border)', paddingTop: '1.25rem', display: 'flex', flexDirection: 'column', gap: '1rem' }}>
              <h4 style={{ margin: 0, fontSize: '0.85rem', color: 'var(--text-secondary)', fontWeight: 700, letterSpacing: '0.5px', display: 'flex', alignItems: 'center', gap: '0.35rem' }}>
                <Sparkles size={14} /> SHADOW & GLOW (SOMBRA/GLOW)
              </h4>
              
              <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '1rem' }}>
                <div style={{ display: 'flex', flexDirection: 'column', gap: '0.35rem' }}>
                  <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600, display: 'flex', alignItems: 'center', gap: '0.35rem' }}>
                    <Palette size={14} /> SHADOW COLOR
                  </label>
                  <div style={{ display: 'flex', gap: '0.5rem', alignItems: 'center' }}>
                    <input 
                      type="color"
                      value={normalizeColorForPicker(shadowColor)}
                      onChange={(e) => setShadowColor(e.target.value)}
                      style={{
                        border: 'none',
                        background: 'none',
                        width: '32px',
                        height: '32px',
                        cursor: 'pointer'
                      }}
                    />
                    <input 
                      type="text" 
                      value={shadowColor}
                      onChange={(e) => setShadowColor(e.target.value)}
                      style={{
                        background: 'var(--bg-secondary)',
                        border: '1px solid var(--glass-border)',
                        color: 'var(--text-primary)',
                        padding: '0.4rem',
                        borderRadius: '6px',
                        fontFamily: 'var(--font-mono)',
                        fontSize: '0.85rem',
                        width: '100%'
                      }}
                    />
                  </div>
                </div>

                <div style={{ display: 'flex', flexDirection: 'column', gap: '0.35rem' }}>
                  <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600, display: 'flex', alignItems: 'center', gap: '0.35rem' }}>
                    <Sparkles size={14} /> GLOW BLUR (DIFUMINADO)
                  </label>
                  <input 
                    type="number"
                    min="0"
                    max="30"
                    value={shadowBlur}
                    onChange={(e) => setShadowBlur(Math.max(0, parseInt(e.target.value) || 0))}
                    style={{
                      background: 'var(--bg-secondary)',
                      border: '1px solid var(--glass-border)',
                      color: 'var(--text-primary)',
                      padding: '0.5rem',
                      borderRadius: '6px',
                      fontFamily: 'var(--font-mono)',
                    }}
                  />
                </div>
              </div>

              <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '1rem' }}>
                <div style={{ display: 'flex', flexDirection: 'column', gap: '0.35rem' }}>
                  <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600, display: 'flex', alignItems: 'center', gap: '0.35rem' }}>
                    <MoveHorizontal size={14} /> OFFSET X
                  </label>
                  <input 
                    type="number"
                    min="-20"
                    max="20"
                    value={shadowOffsetX}
                    onChange={(e) => setShadowOffsetX(parseInt(e.target.value) || 0)}
                    style={{
                      background: 'var(--bg-secondary)',
                      border: '1px solid var(--glass-border)',
                      color: 'var(--text-primary)',
                      padding: '0.5rem',
                      borderRadius: '6px',
                      fontFamily: 'var(--font-mono)',
                    }}
                  />
                </div>

                <div style={{ display: 'flex', flexDirection: 'column', gap: '0.35rem' }}>
                  <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600, display: 'flex', alignItems: 'center', gap: '0.35rem' }}>
                    <MoveVertical size={14} /> OFFSET Y
                  </label>
                  <input 
                    type="number"
                    min="-20"
                    max="20"
                    value={shadowOffsetY}
                    onChange={(e) => setShadowOffsetY(parseInt(e.target.value) || 0)}
                    style={{
                      background: 'var(--bg-secondary)',
                      border: '1px solid var(--glass-border)',
                      color: 'var(--text-primary)',
                      padding: '0.5rem',
                      borderRadius: '6px',
                      fontFamily: 'var(--font-mono)',
                    }}
                  />
                </div>
              </div>
            </div>

          </div>

          {/* Preview Column */}
          <div 
            style={{
              flex: '1',
              padding: '1.5rem',
              backgroundColor: 'rgba(0,0,0,0.3)',
              display: 'flex',
              flexDirection: 'column',
              alignItems: 'center',
              justifyContent: 'flex-start',
              gap: '1.5rem',
              overflowY: 'auto'
            }}
          >
            <div style={{ alignSelf: 'flex-start', fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600 }}>
              WEATHER SHEET SLICES
            </div>

            {/* Generated Sheet Preview */}
            {generatedDataUrl && (
              <div style={{ display: 'flex', width: '100%', flexDirection: 'column', gap: '0.5rem' }}>
                <span style={{ fontSize: '0.75rem', color: 'var(--text-muted)', fontWeight: 600 }}>SLICED FRAMES (12 STATES)</span>
                <div 
                  style={{
                    display: 'flex',
                    flexWrap: 'wrap',
                    gap: '0.5rem',
                    background: 'rgba(0,0,0,0.2)',
                    padding: '1rem',
                    borderRadius: '8px',
                    border: '1px solid var(--glass-border)',
                    maxHeight: '450px',
                    overflowY: 'auto'
                  }}
                >
                  {WEATHER_STATE_ICONS.map((item, index) => (
                    <div 
                      key={index}
                      style={{
                        display: 'flex',
                        flexDirection: 'column',
                        alignItems: 'center',
                        gap: '0.25rem',
                        background: 'var(--bg-secondary)',
                        border: '1px solid var(--glass-border)',
                        borderRadius: '4px',
                        padding: '4px',
                        width: `${Math.max(frameWidth + 12, 60)}px`
                      }}
                    >
                      <span style={{ fontSize: '9px', color: 'var(--text-muted)', fontFamily: 'var(--font-mono)' }}>#{index}</span>
                      <div 
                        style={{
                          width: `${frameWidth}px`,
                          height: `${frameHeight}px`,
                          backgroundImage: `url(${generatedDataUrl})`,
                          backgroundPosition: `0px -${index * frameHeight}px`,
                          backgroundSize: `${frameWidth}px ${frameHeight * 12}px`,
                          imageRendering: 'pixelated'
                        }}
                      />
                      <span 
                        style={{ 
                          fontSize: '8px', 
                          color: 'var(--text-primary)', 
                          fontWeight: 600, 
                          maxWidth: '100%', 
                          overflow: 'hidden', 
                          textOverflow: 'ellipsis', 
                          whiteSpace: 'nowrap',
                          textAlign: 'center' 
                        }}
                        title={item.name}
                      >
                        {item.name.split(' ')[0]}
                      </span>
                    </div>
                  ))}
                </div>
              </div>
            )}

          </div>

        </div>

        {/* Footer controls */}
        <div 
          className="panel-header" 
          style={{
            display: 'flex',
            justifyContent: 'flex-end',
            alignItems: 'center',
            padding: '1rem 1.5rem',
            borderTop: '1px solid var(--glass-border)',
            gap: '1rem'
          }}
        >
          <button className="btn btn-secondary" onClick={onClose}>
            Cancel
          </button>
          
          {generatedDataUrl && (
            <button 
              className="btn btn-secondary"
              onClick={() => {
                const link = document.createElement('a');
                link.href = generatedDataUrl;
                link.download = `weather_${frameWidth}x${frameHeight}-all.png`;
                document.body.appendChild(link);
                link.click();
                document.body.removeChild(link);
              }}
            >
              <Download size={14} />
              Download PNG
            </button>
          )}

          <button 
            className="btn btn-primary"
            onClick={() => {
              if (generatedDataUrl) {
                onApply(generatedDataUrl, frameWidth, frameHeight, 12, {
                  frameWidth,
                  frameHeight,
                  iconColor,
                  bgColor,
                  strokeWidth,
                  iconPadding,
                  shadowColor,
                  shadowBlur,
                  shadowOffsetX,
                  shadowOffsetY
                });
              }
            }}
            disabled={!generatedDataUrl}
          >
            <Check size={14} />
            Apply to Selected Layer
          </button>
        </div>

      </div>
    </div>
  );
};
