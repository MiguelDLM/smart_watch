import React, { useEffect, useState } from 'react';
import { X, Check } from 'lucide-react';

export interface PresetEntry {
  type: string;
  frms: number;
  width: number;
  height: number;
  colsp: string;
  ctx?: number;
  cty?: number;
  align?: number;
  comp?: number;
  validated?: boolean;
}

interface PresetsPanelProps {
  isOpen: boolean;
  onClose: () => void;
  onApply: (path: string, entry: PresetEntry, dataUrl: string) => void;
  selectedBlockType?: string;
}

const HAND_TYPES = ['BLK_ARMH', 'BLK_ARMM', 'BLK_ARMS'];

const CATEGORIES: { id: string; label: string; desc: string }[] = [
  { id: 'hands', label: '🕐 Manecillas', desc: 'Hora / minuto / segundo (con pivote)' },
  { id: 'battery', label: '🔋 Batería', desc: 'Tiras de nivel de batería' },
  { id: 'weather', label: '⛅ Clima', desc: 'Sets de iconos de clima' },
  { id: 'animation', label: '✨ Animaciones', desc: 'Tiras de animación multi-frame' },
  { id: 'center_cap', label: '⦿ Tapa central', desc: 'Tapas del eje central' },
];

// Respect the Vite base path so presets resolve in dev and on static deploys.
const assetUrl = (p: string) => `${import.meta.env.BASE_URL}${p}`.replace(/\/\/+/g, '/');

export const PresetsPanel: React.FC<PresetsPanelProps> = ({ isOpen, onClose, onApply, selectedBlockType }) => {
  const [manifest, setManifest] = useState<Record<string, PresetEntry>>({});
  const [loading, setLoading] = useState(false);
  const [activeCat, setActiveCat] = useState('battery');
  const [busyPath, setBusyPath] = useState<string | null>(null);

  // Hands presets are only meaningful while a hand layer is selected, since they
  // carry a fixed rotation pivot and replace BLK_ARMH/ARMM/ARMS in place.
  const handsAllowed = selectedBlockType !== undefined && HAND_TYPES.includes(selectedBlockType);
  const visibleCategories = CATEGORIES.filter((c) => c.id !== 'hands' || handsAllowed);

  useEffect(() => {
    if (!isOpen) return;
    setLoading(true);
    fetch(assetUrl('presets/manifest.json'))
      .then((r) => (r.ok ? r.json() : {}))
      .then((data) => setManifest(data || {}))
      .catch(() => setManifest({}))
      .finally(() => setLoading(false));
  }, [isOpen]);

  // Default to hands when opening on a hand layer; otherwise keep off the hidden tab.
  useEffect(() => {
    if (!isOpen) return;
    if (handsAllowed) setActiveCat('hands');
    else setActiveCat((c) => (c === 'hands' ? 'battery' : c));
  }, [isOpen, handsAllowed]);

  const handlePick = async (path: string, entry: PresetEntry) => {
    try {
      setBusyPath(path);
      const res = await fetch(assetUrl(path));
      const blob = await res.blob();
      const dataUrl = await new Promise<string>((resolve, reject) => {
        const fr = new FileReader();
        fr.onload = () => resolve(fr.result as string);
        fr.onerror = () => reject(new Error('read failed'));
        fr.readAsDataURL(blob);
      });
      onApply(path, entry, dataUrl);
    } finally {
      setBusyPath(null);
    }
  };

  if (!isOpen) return null;

  const entries = Object.entries(manifest)
    .filter(([p]) => p.startsWith(`presets/${activeCat}/`))
    .sort(([a], [b]) => a.localeCompare(b));

  return (
    <div style={{ position: 'fixed', inset: 0, backgroundColor: 'rgba(0,0,0,0.75)', backdropFilter: 'blur(8px)', zIndex: 100, display: 'flex', justifyContent: 'center', alignItems: 'center', padding: '2rem' }}>
      <div className="glass-panel" style={{ width: '100%', maxWidth: '920px', maxHeight: '92vh', display: 'flex', flexDirection: 'column', overflow: 'hidden', boxShadow: 'var(--shadow-lg)' }}>

        {/* Header */}
        <div className="panel-header" style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', padding: '1.25rem 1.5rem', borderBottom: '1px solid var(--glass-border)' }}>
          <div style={{ display: 'flex', alignItems: 'center', gap: '0.75rem' }}>
            <h3 style={{ margin: 0, fontSize: '1.25rem', fontWeight: 800 }}>Presets extraídos</h3>
            <span style={{ fontSize: '0.75rem', color: 'var(--text-muted)', background: 'rgba(255,255,255,0.06)', padding: '0.2rem 0.5rem', borderRadius: '4px' }}>Manecillas, batería, clima y animaciones de diales reales</span>
          </div>
          <button onClick={onClose} style={{ background: 'transparent', border: 'none', color: 'var(--text-secondary)', cursor: 'pointer', padding: '0.25rem' }}>
            <X size={20} />
          </button>
        </div>

        <div style={{ display: 'flex', flexGrow: 1, overflow: 'hidden' }}>
          {/* Category sidebar */}
          <div style={{ width: '220px', borderRight: '1px solid var(--glass-border)', padding: '1rem', display: 'flex', flexDirection: 'column', gap: '0.5rem', overflowY: 'auto' }}>
            {visibleCategories.map((c) => {
              const count = Object.keys(manifest).filter((p) => p.startsWith(`presets/${c.id}/`)).length;
              return (
                <button
                  key={c.id}
                  onClick={() => setActiveCat(c.id)}
                  className={`btn ${activeCat === c.id ? 'btn-primary' : 'btn-secondary'}`}
                  style={{ flexDirection: 'column', alignItems: 'flex-start', gap: '0.15rem', textAlign: 'left', padding: '0.6rem 0.7rem' }}
                >
                  <span style={{ fontSize: '0.9rem', fontWeight: 700 }}>{c.label} <span style={{ color: 'var(--text-muted)', fontWeight: 400 }}>({count})</span></span>
                  <span style={{ fontSize: '0.7rem', color: 'var(--text-muted)' }}>{c.desc}</span>
                </button>
              );
            })}
          </div>

          {/* Preset grid */}
          <div style={{ flex: 1, padding: '1.25rem', overflowY: 'auto', background: 'rgba(0,0,0,0.2)' }}>
            {loading ? (
              <div style={{ color: 'var(--text-muted)', textAlign: 'center', padding: '2rem' }}>Cargando presets…</div>
            ) : entries.length === 0 ? (
              <div style={{ color: 'var(--text-muted)', textAlign: 'center', padding: '2rem' }}>No hay presets en esta categoría.</div>
            ) : (
              <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fill, minmax(130px, 1fr))', gap: '1rem' }}>
                {entries.map(([path, entry]) => {
                  const name = path.split('/').pop()!.replace('.png', '');
                  return (
                    <button
                      key={path}
                      onClick={() => handlePick(path, entry)}
                      disabled={busyPath !== null}
                      style={{
                        display: 'flex', flexDirection: 'column', alignItems: 'center', gap: '0.4rem',
                        background: 'var(--bg-secondary)', border: '1px solid var(--glass-border)', borderRadius: '10px',
                        padding: '0.75rem', cursor: busyPath ? 'wait' : 'pointer', transition: 'border-color 0.15s',
                      }}
                      onMouseEnter={(e) => (e.currentTarget.style.borderColor = 'var(--accent)')}
                      onMouseLeave={(e) => (e.currentTarget.style.borderColor = 'var(--glass-border)')}
                    >
                      <div style={{ width: '100%', height: '110px', display: 'flex', alignItems: 'center', justifyContent: 'center', background: 'repeating-conic-gradient(#2a2a35 0% 25%, #1f1f28 0% 50%) 50% / 16px 16px', borderRadius: '6px', overflow: 'hidden' }}>
                        <img
                          src={assetUrl(path)}
                          alt={name}
                          style={{ maxWidth: '100%', maxHeight: '100%', objectFit: 'contain', imageRendering: 'pixelated' }}
                        />
                      </div>
                      <span style={{ fontSize: '0.78rem', fontWeight: 600, color: 'var(--text-primary)', textAlign: 'center', wordBreak: 'break-all' }}>{name}</span>
                      <span style={{ fontSize: '0.68rem', color: 'var(--text-muted)', fontFamily: 'var(--font-mono)' }}>
                        {entry.frms > 1 ? `${entry.frms}f · ` : ''}{entry.width}×{entry.height}
                        {entry.ctx !== undefined ? ` · ⊕(${entry.ctx},${entry.cty})` : ''}
                      </span>
                      {busyPath === path && (
                        <span style={{ fontSize: '0.7rem', color: 'var(--accent-hover)', display: 'flex', alignItems: 'center', gap: '0.25rem' }}><Check size={12} /> Añadiendo…</span>
                      )}
                    </button>
                  );
                })}
              </div>
            )}
          </div>
        </div>
      </div>
    </div>
  );
};
