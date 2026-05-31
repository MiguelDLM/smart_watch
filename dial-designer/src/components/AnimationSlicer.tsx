import React, { useState, useEffect } from 'react';
import { X, Check, Loader2, Play, Pause, AlertTriangle, Sparkles } from 'lucide-react';
// @ts-ignore
import { parseGIF, decompressFrames } from 'gifuct-js';

interface AnimationSlicerProps {
  isOpen: boolean;
  file: File | null;
  onClose: () => void;
  onApply: (generatedImgDataUrl: string, width: number, height: number, frms: number) => void;
  initialWidth: number;
  initialHeight: number;
}

export const AnimationSlicer: React.FC<AnimationSlicerProps> = ({
  isOpen,
  file,
  onClose,
  onApply,
  initialWidth,
  initialHeight
}) => {
  const [frameCount, setFrameCount] = useState(10); // Default to 10 frames to save memory
  const [targetWidth, setTargetWidth] = useState(initialWidth || 100);
  const [targetHeight, setTargetHeight] = useState(initialHeight || 100);

  // Crop percentage variables
  const [cropX, setCropX] = useState(0); // 0-100%
  const [cropY, setCropY] = useState(0); // 0-100%
  const [cropSize, setCropSize] = useState(100); // 10-100%

  const [isSlicing, setIsSlicing] = useState(false);
  const [progress, setProgress] = useState(0);
  const [errorMsg, setErrorMsg] = useState<string | null>(null);

  // Previews
  const [extractedFrames, setExtractedFrames] = useState<string[]>([]);
  const [compiledDataUrl, setCompiledDataUrl] = useState<string | null>(null);
  const [previewFileUrl, setPreviewFileUrl] = useState<string | null>(null);
  const [fileType, setFileType] = useState<'gif' | 'video' | null>(null);

  // Simulation play loop
  const [simFrameIdx, setSimFrameIdx] = useState(0);
  const [isPlayingSim, setIsPlayingSim] = useState(true);

  // Clean up object URLs
  useEffect(() => {
    if (file) {
      const url = URL.createObjectURL(file);
      setPreviewFileUrl(url);
      const type = file.name.toLowerCase().endsWith('.gif') ? 'gif' : 'video';
      setFileType(type);
      setExtractedFrames([]);
      setCompiledDataUrl(null);
      setErrorMsg(null);
      return () => {
        URL.revokeObjectURL(url);
      };
    } else {
      setPreviewFileUrl(null);
      setFileType(null);
    }
  }, [file]);

  // Sync initial dimensions
  useEffect(() => {
    if (isOpen) {
      setTargetWidth(initialWidth || 100);
      setTargetHeight(initialHeight || 100);
    }
  }, [isOpen, initialWidth, initialHeight]);

  // Simulation Play timer
  useEffect(() => {
    if (!isPlayingSim || extractedFrames.length === 0) return;
    const interval = setInterval(() => {
      setSimFrameIdx((prev) => (prev + 1) % extractedFrames.length);
    }, 150); // 150ms per frame
    return () => clearInterval(interval);
  }, [isPlayingSim, extractedFrames]);

  // Start slicing process
  const startSlicing = async () => {
    if (!file || !fileType) return;
    setIsSlicing(true);
    setProgress(0);
    setErrorMsg(null);
    setExtractedFrames([]);
    setCompiledDataUrl(null);

    try {
      if (fileType === 'video') {
        await sliceVideo();
      } else {
        await sliceGif();
      }
    } catch (err: any) {
      console.error(err);
      setErrorMsg(err.message || 'Failed to process animation file.');
    } finally {
      setIsSlicing(false);
    }
  };

  // Video Slicer Implementation
  const sliceVideo = (): Promise<void> => {
    return new Promise((resolve, reject) => {
      if (!previewFileUrl) return reject(new Error('No video source loaded'));

      const video = document.createElement('video');
      video.src = previewFileUrl;
      video.muted = true;
      video.playsInline = true;
      video.crossOrigin = 'anonymous';

      video.onloadedmetadata = async () => {
        try {
          const videoW = video.videoWidth;
          const videoH = video.videoHeight;
          const duration = video.duration;
          
          // Calculate source crop dimensions
          const sizeFrac = cropSize / 100;
          const sourceSize = Math.min(videoW, videoH) * sizeFrac;
          const sourceX = (videoW - sourceSize) * (cropX / 100);
          const sourceY = (videoH - sourceSize) * (cropY / 100);

          const canvas = document.createElement('canvas');
          canvas.width = targetWidth;
          canvas.height = targetHeight;
          const ctx = canvas.getContext('2d');
          if (!ctx) throw new Error('Could not create 2D canvas context');

          const frames: string[] = [];
          const interval = duration / Math.max(1, frameCount - 1);

          for (let i = 0; i < frameCount; i++) {
            const time = i * interval;
            video.currentTime = Math.min(time, duration - 0.05); // slightly before end to avoid black frame
            
            await new Promise((res) => {
              const onSeeked = () => {
                video.removeEventListener('seeked', onSeeked);
                res(null);
              };
              video.addEventListener('seeked', onSeeked);
            });

            // Draw cropped video frame
            ctx.clearRect(0, 0, targetWidth, targetHeight);
            ctx.drawImage(
              video,
              sourceX, sourceY, sourceSize, sourceSize,
              0, 0, targetWidth, targetHeight
            );
            frames.push(canvas.toDataURL('image/png'));
            setProgress(Math.round(((i + 1) / frameCount) * 100));
          }

          setExtractedFrames(frames);
          compileSheet(frames);
          resolve();
        } catch (e) {
          reject(e);
        }
      };

      video.onerror = () => {
        reject(new Error('Video failed to load for decoding. Make sure it is a supported browser format.'));
      };
    });
  };

  // GIF Slicer Implementation using gifuct-js
  const sliceGif = async () => {
    if (!file) return;
    const arrayBuffer = await file.arrayBuffer();
    const gif = parseGIF(arrayBuffer);
    const rawFrames = decompressFrames(gif, true);

    if (!rawFrames || rawFrames.length === 0) {
      throw new Error('Could not parse any frames from this GIF.');
    }

    const gifW = gif.lsd.width;
    const gifH = gif.lsd.height;

    // Calculate crop dimensions
    const sizeFrac = cropSize / 100;
    const sourceSize = Math.min(gifW, gifH) * sizeFrac;
    const sourceX = (gifW - sourceSize) * (cropX / 100);
    const sourceY = (gifH - sourceSize) * (cropY / 100);

    // Create accumulation canvas (standard GIF optimization requires drawing patches over previous frames)
    const accCanvas = document.createElement('canvas');
    accCanvas.width = gifW;
    accCanvas.height = gifH;
    const accCtx = accCanvas.getContext('2d');
    if (!accCtx) throw new Error('Could not create accumulator canvas');

    const totalFrames = rawFrames.length;
    
    // Determine frame indices to extract
    const indicesToExtract: number[] = [];
    for (let i = 0; i < frameCount; i++) {
      const idx = Math.min(
        Math.floor((i / Math.max(1, frameCount - 1)) * (totalFrames - 1)),
        totalFrames - 1
      );
      indicesToExtract.push(idx);
    }

    const canvas = document.createElement('canvas');
    canvas.width = targetWidth;
    canvas.height = targetHeight;
    const ctx = canvas.getContext('2d');
    if (!ctx) throw new Error('Could not create output canvas');

    const frames: string[] = [];

    for (let i = 0; i < totalFrames; i++) {
      const frame = rawFrames[i];

      // Draw GIF frame patch onto accumulator canvas
      const frameImageData = accCtx.createImageData(frame.dims.width, frame.dims.height);
      frameImageData.data.set(frame.patch);

      const tempCanvas = document.createElement('canvas');
      tempCanvas.width = frame.dims.width;
      tempCanvas.height = frame.dims.height;
      tempCanvas.getContext('2d')?.putImageData(frameImageData, 0, 0);

      // Draw patch relative to its offset top/left
      accCtx.drawImage(tempCanvas, frame.dims.left, frame.dims.top);

      // If this frame index should be extracted, capture it
      if (indicesToExtract.includes(i)) {
        ctx.clearRect(0, 0, targetWidth, targetHeight);
        ctx.drawImage(
          accCanvas,
          sourceX, sourceY, sourceSize, sourceSize,
          0, 0, targetWidth, targetHeight
        );
        frames.push(canvas.toDataURL('image/png'));
        setProgress(Math.round((frames.length / frameCount) * 100));
      }
    }

    setExtractedFrames(frames);
    compileSheet(frames);
  };

  // Compile extracted frame frames into a vertical strip sheet
  const compileSheet = (frames: string[]) => {
    if (frames.length === 0) return;
    const canvas = document.createElement('canvas');
    canvas.width = targetWidth;
    canvas.height = targetHeight * frames.length;
    const ctx = canvas.getContext('2d');
    if (!ctx) return;

    ctx.clearRect(0, 0, canvas.width, canvas.height);

    const promises = frames.map((dataUrl, idx) => {
      return new Promise<void>((resolve) => {
        const img = new Image();
        img.onload = () => {
          ctx.drawImage(img, 0, idx * targetHeight, targetWidth, targetHeight);
          resolve();
        };
        img.src = dataUrl;
      });
    });

    Promise.all(promises).then(() => {
      setCompiledDataUrl(canvas.toDataURL('image/png'));
    });
  };

  if (!isOpen) return null;

  return (
    <div 
      style={{
        position: 'fixed',
        inset: 0,
        backgroundColor: 'rgba(0,0,0,0.7)',
        backdropFilter: 'blur(8px)',
        zIndex: 110,
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
            <Sparkles size={20} color="var(--accent-hover)" />
            <h3 style={{ margin: 0, fontSize: '1.25rem', fontWeight: 800 }}>Animation Slicer ({fileType?.toUpperCase()})</h3>
          </div>
          <button 
            onClick={onClose}
            disabled={isSlicing}
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
            {/* Warning Alert about Smartwatch Memory */}
            <div style={{
              background: 'rgba(255, 193, 7, 0.1)',
              border: '1px solid rgba(255, 193, 7, 0.3)',
              borderRadius: '6px',
              padding: '0.75rem',
              color: '#ffc107',
              fontSize: '0.8rem',
              display: 'flex',
              gap: '0.5rem',
              alignItems: 'flex-start'
            }}>
              <AlertTriangle size={16} style={{ flexShrink: 0, marginTop: '2px' }} />
              <div>
                <strong>Smartwatch memory warning:</strong> Smartwatches have extremely limited RAM. 
                Keep dimensions small (e.g. 100x100) and use fewer frames (e.g. 10 or 12) to avoid clock freeze.
              </div>
            </div>

            {/* Target Dimensions */}
            <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '1rem' }}>
              <div style={{ display: 'flex', flexDirection: 'column', gap: '0.4rem' }}>
                <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600 }}>TARGET WIDTH (PX)</label>
                <input 
                  type="number" min="16" max="466" value={targetWidth}
                  disabled={isSlicing}
                  onChange={(e) => setTargetWidth(Math.max(16, parseInt(e.target.value) || 16))}
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
              <div style={{ display: 'flex', flexDirection: 'column', gap: '0.4rem' }}>
                <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600 }}>TARGET HEIGHT (PX)</label>
                <input 
                  type="number" min="16" max="466" value={targetHeight}
                  disabled={isSlicing}
                  onChange={(e) => setTargetHeight(Math.max(16, parseInt(e.target.value) || 16))}
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

            {/* Frame Count */}
            <div style={{ display: 'flex', flexDirection: 'column', gap: '0.4rem' }}>
              <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600 }}>FRAMES TO EXTRACT</label>
              <select
                value={frameCount}
                disabled={isSlicing}
                onChange={(e) => setFrameCount(parseInt(e.target.value) || 10)}
                style={{
                  background: 'var(--bg-secondary)',
                  border: '1px solid var(--glass-border)',
                  color: 'var(--text-primary)',
                  padding: '0.5rem',
                  borderRadius: '6px',
                  fontFamily: 'var(--font-sans)',
                }}
              >
                <option value="5">5 frames (Ultra-lightweight)</option>
                <option value="8">8 frames (Recommended)</option>
                <option value="10">10 frames (Standard)</option>
                <option value="12">12 frames (Smooth)</option>
                <option value="15">15 frames (Heavy)</option>
                <option value="20">20 frames (Max safety limit)</option>
              </select>
            </div>

            {/* Crop Settings */}
            <div style={{ display: 'flex', flexDirection: 'column', gap: '0.75rem', borderTop: '1px solid var(--glass-border)', paddingTop: '1rem' }}>
              <span style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600 }}>SQUARE CROP ALIGNMENT</span>
              
              <div style={{ display: 'flex', flexDirection: 'column', gap: '0.4rem' }}>
                <div style={{ display: 'flex', justifyContent: 'space-between', fontSize: '0.75rem' }}>
                  <span>Horizontal Position (X Offset)</span>
                  <span style={{ fontFamily: 'var(--font-mono)' }}>{cropX}%</span>
                </div>
                <input 
                  type="range" min="0" max="100" value={cropX}
                  disabled={isSlicing}
                  onChange={(e) => setCropX(parseInt(e.target.value) || 0)}
                  style={{ width: '100%', accentColor: 'var(--accent)' }}
                />
              </div>

              <div style={{ display: 'flex', flexDirection: 'column', gap: '0.4rem' }}>
                <div style={{ display: 'flex', justifyContent: 'space-between', fontSize: '0.75rem' }}>
                  <span>Vertical Position (Y Offset)</span>
                  <span style={{ fontFamily: 'var(--font-mono)' }}>{cropY}%</span>
                </div>
                <input 
                  type="range" min="0" max="100" value={cropY}
                  disabled={isSlicing}
                  onChange={(e) => setCropY(parseInt(e.target.value) || 0)}
                  style={{ width: '100%', accentColor: 'var(--accent)' }}
                />
              </div>

              <div style={{ display: 'flex', flexDirection: 'column', gap: '0.4rem' }}>
                <div style={{ display: 'flex', justifyContent: 'space-between', fontSize: '0.75rem' }}>
                  <span>Crop Area Size</span>
                  <span style={{ fontFamily: 'var(--font-mono)' }}>{cropSize}%</span>
                </div>
                <input 
                  type="range" min="10" max="100" value={cropSize}
                  disabled={isSlicing}
                  onChange={(e) => setCropSize(parseInt(e.target.value) || 10)}
                  style={{ width: '100%', accentColor: 'var(--accent)' }}
                />
              </div>
            </div>

            {/* Error Message */}
            {errorMsg && (
              <div style={{ color: 'var(--error)', fontSize: '0.8rem', display: 'flex', gap: '0.25rem', alignItems: 'center' }}>
                <AlertTriangle size={14} /> {errorMsg}
              </div>
            )}

            {/* Trigger slice */}
            <button 
              className="btn btn-primary"
              onClick={startSlicing}
              disabled={isSlicing || !previewFileUrl}
              style={{ justifyContent: 'center', marginTop: 'auto' }}
            >
              {isSlicing ? (
                <>
                  <Loader2 size={16} className="animate-spin" />
                  Slicing... {progress}%
                </>
              ) : (
                'Slice & Extract Frames'
              )}
            </button>

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
            {/* Input Video/GIF Source View with Crop Box visualizer */}
            <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'center', width: '100%', gap: '0.75rem' }}>
              <span style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600, letterSpacing: '0.05em' }}>SOURCE VIEWPORT</span>
              
              <div 
                style={{ 
                  width: '180px', 
                  height: '180px', 
                  background: '#0b0c16',
                  borderRadius: '12px', 
                  border: '1px dashed var(--glass-border)',
                  display: 'flex',
                  justifyContent: 'center',
                  alignItems: 'center',
                  overflow: 'hidden',
                  position: 'relative'
                }}
              >
                {/* HTML5 video element for preview or standard animated img for gif */}
                {fileType === 'video' && previewFileUrl && (
                  <video 
                    src={previewFileUrl} 
                    autoPlay 
                    loop 
                    muted 
                    playsInline
                    style={{ width: '100%', height: '100%', objectFit: 'contain' }}
                  />
                )}
                {fileType === 'gif' && previewFileUrl && (
                  <img 
                    src={previewFileUrl} 
                    alt="Source GIF" 
                    style={{ width: '100%', height: '100%', objectFit: 'contain' }}
                  />
                )}

                {/* Simulated Crop Overlay Box */}
                <div 
                  style={{
                    position: 'absolute',
                    border: '2px solid var(--accent)',
                    boxShadow: '0 0 0 9999px rgba(0, 0, 0, 0.5)',
                    width: `${cropSize * 0.9}%`,
                    height: `${cropSize * 0.9}%`,
                    // Center positioning based on sliders
                    left: `${(100 - cropSize) * (cropX / 100) * 0.9 + (100 - cropSize * 0.9) * 0.05}%`,
                    top: `${(100 - cropSize) * (cropY / 100) * 0.9 + (100 - cropSize * 0.9) * 0.05}%`,
                    pointerEvents: 'none',
                    borderRadius: '4px'
                  }}
                />
              </div>
            </div>

            {/* Extracted Simulation Loop Preview */}
            <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'center', width: '100%', gap: '0.75rem', marginTop: '1rem' }}>
              <div style={{ display: 'flex', justifyContent: 'space-between', width: '100%', alignItems: 'center' }}>
                <span style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600 }}>EXTRACTED PREVIEW</span>
                {extractedFrames.length > 0 && (
                  <button 
                    onClick={() => setIsPlayingSim(!isPlayingSim)}
                    style={{ background: 'transparent', border: 'none', color: 'var(--accent)', cursor: 'pointer', display: 'flex', padding: 0 }}
                  >
                    {isPlayingSim ? <Pause size={14} /> : <Play size={14} />}
                  </button>
                )}
              </div>

              <div 
                style={{ 
                  width: '120px', 
                  height: '120px', 
                  background: '#0b0c16',
                  borderRadius: '8px', 
                  border: '1px solid var(--glass-border)',
                  display: 'flex',
                  justifyContent: 'center',
                  alignItems: 'center',
                  overflow: 'hidden',
                  position: 'relative'
                }}
              >
                {extractedFrames.length > 0 ? (
                  <>
                    <img 
                      src={extractedFrames[simFrameIdx]} 
                      alt={`Frame ${simFrameIdx}`} 
                      style={{ width: '100%', height: '100%', objectFit: 'contain' }}
                    />
                    <div style={{ position: 'absolute', bottom: '4px', right: '4px', fontSize: '9px', background: 'rgba(0,0,0,0.6)', padding: '2px 4px', borderRadius: '3px', fontFamily: 'var(--font-mono)' }}>
                      {simFrameIdx + 1}/{extractedFrames.length}
                    </div>
                  </>
                ) : (
                  <span style={{ fontSize: '0.75rem', color: 'var(--text-muted)', textAlign: 'center', padding: '10px' }}>
                    Click "Slice" to extract frames
                  </span>
                )}
              </div>
            </div>

            {/* Vertical Compiled Strip Preview */}
            <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'center', width: '100%', gap: '0.4rem', marginTop: '1rem' }}>
              <span style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600 }}>VERTICAL COMPILED STRIP</span>
              <div 
                style={{
                  width: '100%',
                  height: '100px',
                  overflowY: 'auto',
                  border: '1px solid var(--glass-border)',
                  borderRadius: '6px',
                  padding: '0.5rem',
                  display: 'flex',
                  flexDirection: 'column',
                  alignItems: 'center',
                  background: 'rgba(0,0,0,0.3)',
                  boxShadow: 'inset 0 0 5px rgba(0,0,0,0.5)'
                }}
              >
                {compiledDataUrl ? (
                  <img 
                    src={compiledDataUrl} 
                    alt="Compiled Strip" 
                    style={{ border: '1px solid rgba(255,255,255,0.05)' }}
                  />
                ) : (
                  <span style={{ fontSize: '0.75rem', color: 'var(--text-muted)' }}>Not compiled</span>
                )}
              </div>
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
            disabled={isSlicing}
          >
            Cancel
          </button>
          
          <button 
            className="btn btn-primary" 
            onClick={() => {
              if (compiledDataUrl) {
                onApply(compiledDataUrl, targetWidth, targetHeight, extractedFrames.length);
              }
            }}
            disabled={!compiledDataUrl || isSlicing}
          >
            <Check size={16} />
            Apply Animation
          </button>
        </div>

      </div>
    </div>
  );
};
