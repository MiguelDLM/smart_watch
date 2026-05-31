import React, { useState, useRef, useCallback, useEffect } from 'react';
import { 
  Upload, 
  Download, 
  AlertTriangle, 
  CheckCircle2, 
  Loader2, 
  ArrowLeft, 
  ArrowUp, 
  ArrowDown, 
  Play, 
  Pause,
  Cpu,
  Lock,
  Unlock
} from 'lucide-react';
import { usePyodide, type DecompressedDial } from './hooks/usePyodide';
import { CanvasWatchface } from './components/CanvasWatchface';
import { FontGenerator } from './components/FontGenerator';
import { WeatherGenerator } from './components/WeatherGenerator';
import { BatteryGenerator } from './components/BatteryGenerator';
import { AnimationSlicer } from './components/AnimationSlicer';
import { HandGenerator } from './components/HandGenerator';
import { PresetsPanel, type PresetEntry } from './components/PresetsPanel';
import { loadWorkspace, saveWorkspace, clearWorkspace } from './utils/db';
import './App.css';

const BLOCK_TYPES = [
  // System layers
  { value: 'BLK_BGIMG',    label: 'Background Image',     group: 'system' },
  { value: 'BLK_PREVI',    label: 'Preview Image',         group: 'system' },
  // Analog hands
  { value: 'BLK_ARMH',     label: 'Hour Hand',             group: 'hands' },
  { value: 'BLK_ARMM',     label: 'Minute Hand',           group: 'hands' },
  { value: 'BLK_ARMS',     label: 'Second Hand',           group: 'hands' },
  { value: 'BLK_BIGYO',    label: 'Center Cap / Separator',group: 'hands' },
  // Time digits
  { value: 'BLK_HOUR',     label: 'Hours digits',          group: 'time' },
  { value: 'BLK_MIN',      label: 'Minutes digits',        group: 'time' },
  { value: 'BLK_SEC',      label: 'Seconds digits',        group: 'time' },
  { value: 'BLK_AMPM',     label: 'AM/PM indicator',       group: 'time' },
  // Date
  { value: 'BLK_YEAR',     label: 'Year digits',           group: 'date' },
  { value: 'BLK_MONTH',    label: 'Month digits',          group: 'date' },
  { value: 'BLK_DAY',      label: 'Day digits',            group: 'date' },
  { value: 'BLK_WEEKD',    label: 'Day of Week',           group: 'date' },
  // Health & fitness
  { value: 'BLK_STEPS',    label: 'Steps digits',          group: 'fitness' },
  { value: 'BLK_PULS',     label: 'Heart Rate',            group: 'fitness' },
  { value: 'BLK_CALOR',    label: 'Calories',              group: 'fitness' },
  { value: 'BLK_DIST',     label: 'Distance',              group: 'fitness' },
  // Battery & status
  { value: 'BLK_BATTN',    label: 'Battery digits',        group: 'status' },
  { value: 'BLK_BATTS',    label: 'Battery strip / gauge', group: 'status' },
  { value: 'BLK_CONN',     label: 'Bluetooth status',      group: 'status' },
  // Weather
  { value: 'BLK_WEAT',     label: 'Weather icons',         group: 'weather' },
  { value: 'BLK_TEMP',     label: 'Temperature digits',    group: 'weather' },
  // Gauges / progress
  { value: 'BLK_PROG1',    label: 'Arc Progress 1 (steps arc)',   group: 'gauges' },
  { value: 'BLK_PROG2',    label: 'Arc Progress 2 (activity arc)',group: 'gauges' },
  { value: 'BLK_UNK_A1',   label: 'Gauge overlay (type A1)',      group: 'gauges' },
  // Animation
  { value: 'BLK_ANIM',     label: 'Animation (looping strip)',    group: 'animation' },
];

const TYPOGRAPHIC_BLOCKS = [
  'BLK_YEAR', 'BLK_MONTH', 'BLK_DAY', 'BLK_HOUR', 'BLK_MIN', 'BLK_SEC', 
  'BLK_WEEKD', 'BLK_STEPS', 'BLK_PULS', 'BLK_CALOR', 'BLK_DIST', 'BLK_BATTN', 'BLK_TEMP',
  'BLK_AMPM'
];

const isTypographicBlock = (type: string): boolean => {
  return TYPOGRAPHIC_BLOCKS.includes(type);
};

// Watch convention: weekday frame 0 = Sunday (SUN-first), matching original dials.
const DEFAULT_WEEKDAYS_TEXT = 'SUN\nMON\nTUE\nWED\nTHU\nFRI\nSAT';
const DEFAULT_MONTHS_TEXT = 'JAN\nFEB\nMAR\nAPR\nMAY\nJUN\nJUL\nAUG\nSEP\nOCT\nNOV\nDEC';
const DEFAULT_DIGITS_TEXT = '0\n1\n2\n3\n4\n5\n6\n7\n8\n9';

const getExpectedFramesForType = (type: string, currentFrms?: number): number[] => {
  if (type === 'BLK_BGIMG' || type === 'BLK_PREVI') return [1];
  if (type === 'BLK_ARMH' || type === 'BLK_ARMM' || type === 'BLK_ARMS') return [1];
  if (type === 'BLK_BIGYO') return [1];
  if (type === 'BLK_WEEKD') return [7];
  if (type === 'BLK_MONTH') return [10, 12];
  if (type === 'BLK_AMPM' || type === 'BLK_CONN') return [2];
  if (type === 'BLK_BATTS' || type === 'BLK_UNK_A1') return [6];
  if (type === 'BLK_WEAT') return [12];
  if (type === 'BLK_PROG1' || type === 'BLK_PROG2') return [11];
  if (type === 'BLK_DIST') return [11];
  if (TYPOGRAPHIC_BLOCKS.includes(type)) return [10];
  return [currentFrms || 1];
};

const getDefaultFramesForType = (type: string, currentFrms?: number): number => {
  if (type === 'BLK_BGIMG' || type === 'BLK_PREVI') return 1;
  if (type === 'BLK_ARMH' || type === 'BLK_ARMM' || type === 'BLK_ARMS') return 1;
  if (type === 'BLK_BIGYO') return 1;
  if (type === 'BLK_WEEKD') return 7;
  if (type === 'BLK_MONTH') return currentFrms === 12 ? 12 : 10;
  if (type === 'BLK_AMPM' || type === 'BLK_CONN') return 2;
  if (type === 'BLK_BATTS' || type === 'BLK_UNK_A1') return 6;
  if (type === 'BLK_WEAT') return 12;
  if (type === 'BLK_PROG1' || type === 'BLK_PROG2') return 11;
  if (type === 'BLK_DIST') return 11;
  if (TYPOGRAPHIC_BLOCKS.includes(type)) return 10;
  return currentFrms || 1;
};

const normalizeFontConfigForType = (prevConfig: any, type: string, frms: number): any => {
  const styleConfig = prevConfig ? {
    fontFamily: prevConfig.fontFamily,
    fontSize: prevConfig.fontSize,
    fontWeight: prevConfig.fontWeight,
    isItalic: prevConfig.isItalic,
    textColor: prevConfig.textColor,
    bgColor: prevConfig.bgColor,
    strokeColor: prevConfig.strokeColor,
    strokeWidth: prevConfig.strokeWidth,
    shadowColor: prevConfig.shadowColor,
    shadowBlur: prevConfig.shadowBlur,
    shadowOffsetX: prevConfig.shadowOffsetX,
    shadowOffsetY: prevConfig.shadowOffsetY,
    letterSpacing: prevConfig.letterSpacing,
    textOffsetX: prevConfig.textOffsetX,
    textOffsetY: prevConfig.textOffsetY,
    frameWidth: prevConfig.frameWidth,
    frameHeight: prevConfig.frameHeight
  } : {};

  if (type === 'BLK_WEEKD') {
    return {
      ...styleConfig,
      selectedPreset: 'weekdays_en',
      customWeekdaysText: prevConfig?.customWeekdaysText || DEFAULT_WEEKDAYS_TEXT
    };
  }

  if (type === 'BLK_MONTH') {
    const monthPreset = frms === 12 ? 'months_en' : 'digits';
    return {
      ...styleConfig,
      selectedPreset: monthPreset,
      customMonthsText: prevConfig?.customMonthsText || DEFAULT_MONTHS_TEXT,
      customDigitsText: prevConfig?.customDigitsText || DEFAULT_DIGITS_TEXT
    };
  }

  if (TYPOGRAPHIC_BLOCKS.includes(type)) {
    return {
      ...styleConfig,
      selectedPreset: 'digits',
      customDigitsText: prevConfig?.customDigitsText || DEFAULT_DIGITS_TEXT
    };
  }

  return prevConfig;
};

// Normalize block type names from decompiler format to builder canonical format
const normalizeBlockType = (b: any): any => {
  const t = b.type;
  let normalizedType = t;
  let isLocked = b.locked;
  let frms = b.frms;
  let comp = b.comp;

  // Background / wallpaper
  if (t === 'BLK_BACKGROUND' || t === 'BLK_BACKGROUND2' || t === 'BLK_BACKGROUND3' || t === 'BLK_BG' || t === 'BLK_BGIMG') {
    normalizedType = 'BLK_BGIMG';
    isLocked = true;
    frms = 1;
  }
  // Preview thumbnail
  else if (t === 'BLK_PREV' || t === 'BLK_PREVI') {
    normalizedType = 'BLK_PREVI';
    frms = 1;
  }
  // Analog hands (comp=0 in decompiled dials)
  else if (t === 'BLK_ARM_HOUR') { normalizedType = 'BLK_ARMH'; frms = 1; comp = 0; }
  else if (t === 'BLK_ARM_MINUTE') { normalizedType = 'BLK_ARMM'; frms = 1; comp = 0; }
  else if (t === 'BLK_ARM_SECOND') { normalizedType = 'BLK_ARMS'; frms = 1; comp = 0; }
  // Center cap / bigyo (pivot decoration)
  else if (t === 'BLK_BIGYO' || t === 'BLK_BERRY') { normalizedType = 'BLK_BIGYO'; }
  // Time digits
  else if (t === 'BLK_HOURS') { normalizedType = 'BLK_HOUR'; }
  else if (t === 'BLK_MINUTES') { normalizedType = 'BLK_MIN'; }
  else if (t === 'BLK_SECONDS') { normalizedType = 'BLK_SEC'; }
  // Battery
  else if (t === 'BLK_BATTERY' || t === 'BLK_BATTN') { normalizedType = 'BLK_BATTN'; }
  else if (t === 'BLK_BATTERY_STRIP' || t === 'BLK_BATTS') { normalizedType = 'BLK_BATTS'; frms = frms || 6; }
  // Connection / BT
  else if (t === 'BLK_CONNECT') { normalizedType = 'BLK_CONN'; }
  // Weather
  else if (t === 'BLK_WEATHER') { normalizedType = 'BLK_WEAT'; frms = frms || 12; }
  // Day of week
  else if (t === 'BLK_WEEKDAY') { normalizedType = 'BLK_WEEKD'; }
  // Progress arcs
  else if (t === 'BLK_PROGRESS1' || t === 'BLK_PROG1') { normalizedType = 'BLK_PROG1'; frms = frms || 11; }
  else if (t === 'BLK_PROGRESS2' || t === 'BLK_PROG2') { normalizedType = 'BLK_PROG2'; frms = frms || 11; }
  // Animation
  else if (t === 'BLK_ANIMPART' || t === 'BLK_ANIM') { normalizedType = 'BLK_ANIM'; }
  // Unknown A1 gauge type
  else if (t === 'BLK_UNKNOWN_A1' || t === 'BLK_UNK_A1') { normalizedType = 'BLK_UNK_A1'; frms = frms || 6; }
  // AM/PM indicator
  else if (t === 'BLK_AMPM') { normalizedType = 'BLK_AMPM'; frms = frms || 2; }
  // Pulse/heart rate
  else if (t === 'BLK_PULSE') { normalizedType = 'BLK_PULS'; }

  return { ...b, type: normalizedType, frms, comp: comp !== undefined ? comp : b.comp, locked: isLocked };
};

const validateAndSyncAssetDimensions = async (
  block: any,
  imgUrl: string | undefined
): Promise<{ issue?: string; adjusted?: boolean; actualWidth?: number; actualHeight?: number } | null> => {
  if (!imgUrl) {
    return { issue: `Layer (${block.type}) has no image data to validate.` };
  }

  // The background is stored at full resolution and intentionally positioned/scaled
  // by the user (block width/height/posx/posy act as a transform). It is cropped to
  // the watch-face size during baking at compile time, so its pre-bake dimensions
  // must NOT be synced to the source image size.
  if (block.type === 'BLK_BGIMG') {
    return null;
  }

  return await new Promise((resolve) => {
    const img = new Image();
    img.onload = () => {
      const frameCount = Math.max(1, block.frms || 1);
      if (img.height % frameCount !== 0) {
        resolve({
          issue: `Layer (${block.type}) image height ${img.height} is not divisible by ${frameCount} frames.`
        });
        return;
      }

      // The block's width/height are the source of truth (they reflect the user's
      // on-canvas scaling/positioning). The Python compiler resizes the source image
      // to (block.width × block.height*frms) with LANCZOS, so a mismatch between the
      // generated asset and the block dimensions is EXPECTED after a resize and must
      // NOT be reverted here — doing so discards the user's scaling and snaps the
      // element back to its original generated size.
      resolve(null);
    };
    img.onerror = () => resolve({ issue: `Layer (${block.type}) image failed to load for validation.` });
    img.src = imgUrl;
  });
};

export const App: React.FC = () => {
  const { 
    status, 
    error: pyodideError, 
    isLoading, 
    decompressDial, 
    compressDial 
  } = usePyodide();

  // App State
  const [dragActive, setDragActive] = useState(false);
  const [isProcessing, setIsProcessing] = useState(false);
  const [consoleLogs, setConsoleLogs] = useState<string>('Console initialized. Awaiting file...');
  const [error, setError] = useState<string | null>(null);
  const [dialData, setDialData] = useState<DecompressedDial | null>(null);
  const [selectedBlockIndex, setSelectedBlockIndex] = useState<number | null>(null);
  const [watchfaceSize, setWatchfaceSize] = useState({ width: 466, height: 466 });

  // Load workspace on mount
  useEffect(() => {
    const restoreWorkspace = async () => {
      try {
        log('Checking for saved workspace in IndexedDB...');
        const saved = await loadWorkspace();
        if (saved && saved.metadata && saved.images) {
          log('Restoring workspace from last session...');
          
          // Recreate blob URLs for the images
          const recreatedImages: Record<string, string> = {};
          for (const [fname, arrayBuffer] of Object.entries(saved.images)) {
            const blob = new Blob([arrayBuffer as ArrayBuffer], { type: 'image/png' });
            recreatedImages[fname] = URL.createObjectURL(blob);
          }
          
          // Normalize block types to ensure editor compatibility
          if (saved.metadata && saved.metadata.blocks) {
            saved.metadata.blocks = saved.metadata.blocks.map((b: any) => normalizeBlockType(b));
          }
          
          setDialData({
            metadata: saved.metadata,
            images: recreatedImages
          });
          setWatchfaceSize(saved.watchfaceSize);
          log('Workspace successfully restored!');
        } else {
          log('No saved workspace found. Ready to upload or create.');
        }
      } catch (err: any) {
        console.error('Failed to load workspace from IndexedDB:', err);
        log(`Warning: Failed to load saved workspace: ${err.message || err}`);
      }
    };
    
    restoreWorkspace();
  }, []);

  // Auto-save workspace on changes (debounced by 1s)
  useEffect(() => {
    if (!dialData) {
      clearWorkspace().catch(() => {});
      return;
    }

    const timer = setTimeout(async () => {
      try {
        const imagesToSave: Record<string, ArrayBuffer> = {};
        for (const [fname, url] of Object.entries(dialData.images)) {
          if (url.startsWith('blob:')) {
            const res = await fetch(url);
            imagesToSave[fname] = await res.arrayBuffer();
          } else if (url.startsWith('data:')) {
            const base64Str = url.split(',')[1];
            const binaryStr = atob(base64Str);
            const uint8 = new Uint8Array(binaryStr.length);
            for (let i = 0; i < binaryStr.length; i++) {
              uint8[i] = binaryStr.charCodeAt(i);
            }
            imagesToSave[fname] = uint8.buffer;
          }
        }
        
        await saveWorkspace({
          metadata: dialData.metadata,
          images: imagesToSave,
          watchfaceSize
        });
      } catch (err: any) {
        console.error('Failed to auto-save workspace:', err);
      }
    }, 1000);

    return () => clearTimeout(timer);
  }, [dialData, watchfaceSize]);



  // Simulation State
  const [mockState, setMockState] = useState({
    hour: 10,
    minute: 9,
    second: 30,
    day: 26,
    year: 2026,
    steps: 6420,
    battery: 78,
    connected: true,
    weather: 1
  });
  
  const timerRef = useRef<any>(null);
  const [isLiveRunning, setIsLiveRunning] = useState(false);

  const [initialMode, setInitialMode] = useState<'select' | 'upload'>('select');
  const fileInputRef = useRef<HTMLInputElement>(null);
  const assetFileInputRef = useRef<HTMLInputElement>(null);

  const [isFontModalOpen, setIsFontModalOpen] = useState(false);
  const [isWeatherModalOpen, setIsWeatherModalOpen] = useState(false);
  const [isBatteryModalOpen, setIsBatteryModalOpen] = useState(false);
  const [isHandModalOpen, setIsHandModalOpen] = useState(false);
  const [isPresetsOpen, setIsPresetsOpen] = useState(false);
  const [activeAnimationFile, setActiveAnimationFile] = useState<File | null>(null);

  // Add message to local logs
  const log = useCallback((message: string) => {
    setConsoleLogs(prev => `${prev}\n[${new Date().toLocaleTimeString()}] ${message}`);
  }, []);

  // Handle custom asset upload (supports multiple formats, converted to PNG in-browser)
  const handleAssetFileChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    if (selectedBlockIndex === null || !dialData || !e.target.files || !e.target.files[0]) return;
    
    const file = e.target.files[0];
    const block = dialData.metadata.blocks[selectedBlockIndex];
    
    // Check if the uploaded file is a GIF or Video, or if the block is an animation block
    const isGifOrVideo = file.name.toLowerCase().endsWith('.gif') || 
                          file.type.startsWith('video/') ||
                          file.name.toLowerCase().endsWith('.mp4') ||
                          file.name.toLowerCase().endsWith('.webm') ||
                          file.name.toLowerCase().endsWith('.mov');
                          
    if (isGifOrVideo || block.type === 'BLK_ANIM' || block.type === 'BLK_ANIMPART') {
      log(`Animation or video file detected: ${file.name}. Opening Animation Slicer...`);
      setActiveAnimationFile(file);
      // Reset input value so same file can be uploaded again
      e.target.value = '';
      return;
    }
    
    const reader = new FileReader();
    reader.onload = (event) => {
      const dataUrl = event.target?.result as string;
      
      // Validate image dimensions and convert to PNG
      const img = new Image();
      img.onload = () => {
        const w = img.width;
        const h = img.height;
        const frames = block.frms || 1;
        const expectedHeight = block.height * frames;
        
        log(`Uploaded custom asset: ${file.name}. Resolution: ${w}x${h} px.`);
        
        let updatedWidth = block.width;
        let updatedHeight = block.height;
        let updatedPosX = block.posx;
        let updatedPosY = block.posy;
        let unlockForPositioning = false;
        const isBg = block.type === 'BLK_BGIMG';

        if (isBg) {
          // Do NOT auto-crop the background. Keep the full image and place it with a
          // "cover" fit (fills the screen, no distortion) as a starting point. The
          // user can then drag/resize to frame the part they want; the final crop to
          // the watch-face size is baked at compile time. So width/height/posx/posy
          // act as a positioning transform here, not the image's own pixel size.
          const targetW = watchfaceSize.width;
          const targetH = watchfaceSize.height;
          const coverScale = Math.max(targetW / w, targetH / h);
          updatedWidth = Math.round(w * coverScale);
          updatedHeight = Math.round(h * coverScale);
          updatedPosX = Math.round((targetW - updatedWidth) / 2);
          updatedPosY = Math.round((targetH - updatedHeight) / 2);
          unlockForPositioning = true;
          log(`Imported background at full resolution (${w}x${h}). Placed with cover fit — drag/resize it to frame the area you want; it is cropped to ${targetW}x${targetH} on compile.`);
        } else if (w !== block.width || h !== expectedHeight) {
          log(`Warning: Dimensions changed from ${block.width}x${expectedHeight} to ${w}x${h}. Adjusting metadata dimensions...`);
          updatedWidth = w;
          updatedHeight = Math.round(h / frames);
          log(`Updated block bounds to: ${updatedWidth}x${updatedHeight} px per frame.`);
        }

        // Convert to standard PNG in-browser to support any input format (JPG, WebP,
        // SVG, BMP) WITHOUT cropping/resizing — the full image is preserved.
        const canvas = document.createElement('canvas');
        canvas.width = w;
        canvas.height = h;
        let pngDataUrl = dataUrl;
        const ctx = canvas.getContext('2d');
        if (ctx) {
          ctx.drawImage(img, 0, 0);
          pngDataUrl = canvas.toDataURL('image/png');
        }

        // Apply changes
        const updatedImages = { ...dialData.images };
        // Normalize file extension to .png for compatibility with the bin compiler
        const baseName = file.name.substring(0, file.name.lastIndexOf('.')) || file.name;
        const fname = block.fname || `generated/${baseName}.png`;
        
        // Force the filename extension in metadata to be .png since it's now a PNG Data URL
        const normalizedFname = fname.endsWith('.png') ? fname : `${fname.substring(0, fname.lastIndexOf('.')) || fname}.png`;
        
        updatedImages[normalizedFname] = pngDataUrl;
        
        const updatedBlocks = [...dialData.metadata.blocks];
        updatedBlocks[selectedBlockIndex] = {
          ...block,
          fname: normalizedFname,
          width: updatedWidth,
          height: updatedHeight,
          posx: updatedPosX,
          posy: updatedPosY,
          frms: frames,
          ...(unlockForPositioning ? { locked: false } : {}),
        };

        setDialData({
          ...dialData,
          images: updatedImages,
          metadata: {
            ...dialData.metadata,
            blocks: updatedBlocks
          }
        });
      };
      img.src = dataUrl;
    };
    reader.readAsDataURL(file);
  };

  // Handle applied generated font sheet
  const handleApplyFontSheet = (dataUrl: string, width: number, height: number, frms: number, alnx?: number, fontConfig?: any) => {
    if (selectedBlockIndex === null || !dialData) return;
    const block = dialData.metadata.blocks[selectedBlockIndex];
    
    const updatedImages = { ...dialData.images };
    const fname = block.fname || `generated/font_${block.type.toLowerCase()}.png`;
    updatedImages[fname] = dataUrl;

    const updatedBlocks = [...dialData.metadata.blocks];
    updatedBlocks[selectedBlockIndex] = {
      ...block,
      fname,
      width,
      height,
      frms,
      ...(alnx !== undefined ? { alnx } : {}),
      fontConfig
    };

    setDialData({
      ...dialData,
      images: updatedImages,
      metadata: {
        ...dialData.metadata,
        blocks: updatedBlocks
      }
    });

    setIsFontModalOpen(false);
    log(`Applied generated font sheet to layer: ${block.type} (${width}x${height} per digit, ${frms} frames, alnx mode: ${alnx !== undefined ? alnx : block.alnx || 0})`);
  };

  // Handle applied generated weather sheet
  const handleApplyWeatherSheet = (dataUrl: string, width: number, height: number, frms: number, fontConfig?: any) => {
    if (selectedBlockIndex === null || !dialData) return;
    const block = dialData.metadata.blocks[selectedBlockIndex];
    
    const updatedImages = { ...dialData.images };
    const fname = block.fname || `generated/weather_${block.type.toLowerCase()}.png`;
    updatedImages[fname] = dataUrl;

    const updatedBlocks = [...dialData.metadata.blocks];
    updatedBlocks[selectedBlockIndex] = {
      ...block,
      fname,
      width,
      height,
      frms,
      fontConfig
    };

    setDialData({
      ...dialData,
      images: updatedImages,
      metadata: {
        ...dialData.metadata,
        blocks: updatedBlocks
      }
    });

    setIsWeatherModalOpen(false);
    log(`Applied generated weather icon sheet to layer: ${block.type} (${width}x${height}, ${frms} frames)`);
  };

  const handleApplyBatterySheet = (dataUrl: string, width: number, height: number, frms: number, fontConfig?: any) => {
    if (selectedBlockIndex === null || !dialData) return;
    const block = dialData.metadata.blocks[selectedBlockIndex];
    
    const updatedImages = { ...dialData.images };
    const fname = block.fname || `generated/battery_${block.type.toLowerCase()}.png`;
    updatedImages[fname] = dataUrl;

    const updatedBlocks = [...dialData.metadata.blocks];
    updatedBlocks[selectedBlockIndex] = {
      ...block,
      fname,
      width,
      height,
      frms,
      fontConfig
    };

    setDialData({
      ...dialData,
      images: updatedImages,
      metadata: {
        ...dialData.metadata,
        blocks: updatedBlocks
      }
    });

    setIsBatteryModalOpen(false);
    log(`Applied generated battery icon sheet to layer: ${block.type} (${width}x${height}, ${frms} frames)`);
  };

  const handleApplySlicedAnimation = (dataUrl: string, width: number, height: number, frms: number) => {
    if (selectedBlockIndex === null || !dialData || !activeAnimationFile) return;
    const block = dialData.metadata.blocks[selectedBlockIndex];
    
    log(`Applying sliced animation: ${activeAnimationFile.name}. Resolution: ${width}x${height} px, ${frms} frames.`);
    
    const updatedImages = { ...dialData.images };
    // Normalize file extension to .png for compatibility with the bin compiler
    const baseName = activeAnimationFile.name.substring(0, activeAnimationFile.name.lastIndexOf('.')) || activeAnimationFile.name;
    const fname = block.fname || `generated/${baseName}.png`;
    const normalizedFname = fname.endsWith('.png') ? fname : `${fname.substring(0, fname.lastIndexOf('.')) || fname}.png`;
    
    updatedImages[normalizedFname] = dataUrl;
    
    const isAnim = block.type === 'BLK_ANIM' || block.type === 'BLK_ANIMPART';
    const updatedBlocks = [...dialData.metadata.blocks];
    updatedBlocks[selectedBlockIndex] = {
      ...block,
      fname: normalizedFname,
      width,
      height,
      frms,
      // Animation blocks need align=9 + cty=0 to be positioned/played correctly on
      // the watch (every original BLK_ANIM uses this; align=0 mispositions it). ctx
      // is the playback interval — originals are always nonzero, so default it.
      ...(isAnim ? { alnx: 9, ctx: block.ctx && block.ctx > 0 ? block.ctx : 10, cty: 0 } : {}),
    };

    setDialData({
      ...dialData,
      images: updatedImages,
      metadata: {
        ...dialData.metadata,
        blocks: updatedBlocks
      }
    });

    setActiveAnimationFile(null);
  };

  // Apply a full analog hand set (hour + minute + second) from the Hand Builder.
  // Hands are rotated around their pivot (ctx, cty); placing posx/posy at the watch
  // center positions that pivot at the center of the dial.
  const handleApplyHandSet = (
    hUrl: string, mUrl: string, sUrl: string,
    hW: number, hH: number, hCx: number, hCy: number,
    mW: number, mH: number, mCx: number, mCy: number,
    sW: number, sH: number, sCx: number, sCy: number,
    config: any
  ) => {
    if (!dialData) return;
    const center = Math.round(watchfaceSize.width / 2);
    const uid = Date.now();
    const hands = [
      { type: 'BLK_ARMH', key: 'hour', url: hUrl, w: hW, h: hH, cx: hCx, cy: hCy },
      { type: 'BLK_ARMM', key: 'minute', url: mUrl, w: mW, h: mH, cx: mCx, cy: mCy },
      { type: 'BLK_ARMS', key: 'second', url: sUrl, w: sW, h: sH, cx: sCx, cy: sCy },
    ];

    const updatedImages = { ...dialData.images };
    const updatedBlocks = [...dialData.metadata.blocks];

    hands.forEach((hd) => {
      const fname = `generated/hand_${hd.key}_${uid}.png`;
      updatedImages[fname] = hd.url;
      const data = {
        type: hd.type, frms: 1, fname, reuse: false, colsp: 'RGBA',
        width: hd.w, height: hd.h, posx: center, posy: center,
        // Canonical analog-hand descriptor: align=9 + raw (comp=0), matching the
        // 30/42 original watch hands. align=0/comp=4 leaves the hand undrawn.
        alnx: 9, comp: 0, ctx: hd.cx, cty: hd.cy, handConfig: config,
      };
      const idx = updatedBlocks.findIndex((b: any) => b.type === hd.type);
      if (idx >= 0) updatedBlocks[idx] = { ...updatedBlocks[idx], ...data };
      else updatedBlocks.push(data);
    });

    setDialData({
      ...dialData,
      images: updatedImages,
      metadata: { ...dialData.metadata, blocks: updatedBlocks },
    });
    setIsHandModalOpen(false);
    setSelectedBlockIndex(updatedBlocks.findIndex((b: any) => b.type === 'BLK_ARMH'));
    log('Applied analog hand set (hour + minute + second).');
  };

  // Add an extracted preset (hand, battery, weather, animation, center cap) as a block.
  const handleApplyPreset = (path: string, entry: PresetEntry, dataUrl: string) => {
    if (!dialData) return;
    const allowMultiple = new Set(['BLK_ANIM', 'BLK_ANIMPART', 'BLK_BIGYO', 'BLK_UNK_A1']);
    const isHand = entry.type === 'BLK_ARMH' || entry.type === 'BLK_ARMM' || entry.type === 'BLK_ARMS';
    const center = Math.round(watchfaceSize.width / 2);
    const base = (path.split('/').pop() || 'preset').replace('.png', '');
    const fname = `presets/${base}_${Date.now()}.png`;

    const updatedImages = { ...dialData.images, [fname]: dataUrl };
    const updatedBlocks = [...dialData.metadata.blocks];

    const data: any = {
      type: entry.type, frms: entry.frms, fname, reuse: false,
      colsp: entry.colsp || 'RGBA',
      width: entry.width, height: entry.height,
      // Hands anchor by their pivot (ctx,cty) → place pivot at the watch center.
      // Other elements anchor top-left → offset by half the extent to center them.
      posx: isHand ? center : Math.round(center - entry.width / 2),
      posy: isHand ? center : Math.round(center - entry.height / 2),
      // Reproduce the source block's descriptor faithfully. align/comp/ctx/cty come
      // from the original dial (manifest) — e.g. hands and animations both require
      // align=9 (align=0 leaves them undrawn or mispositioned on the watch).
      alnx: entry.align ?? (isHand ? 9 : 0),
      comp: entry.comp ?? (isHand ? 0 : 4),
      ctx: entry.ctx ?? 0,
      cty: entry.cty ?? 0,
    };

    const existingIdx = !allowMultiple.has(entry.type)
      ? updatedBlocks.findIndex((b: any) => b.type === entry.type)
      : -1;

    let targetIdx: number;
    if (existingIdx >= 0) {
      updatedBlocks[existingIdx] = { ...updatedBlocks[existingIdx], ...data };
      targetIdx = existingIdx;
    } else {
      updatedBlocks.push(data);
      targetIdx = updatedBlocks.length - 1;
    }

    setDialData({
      ...dialData,
      images: updatedImages,
      metadata: { ...dialData.metadata, blocks: updatedBlocks },
    });
    setSelectedBlockIndex(targetIdx);
    setIsPresetsOpen(false);
    log(`Added preset ${base} as ${entry.type} (${entry.frms}f, ${entry.width}x${entry.height}).`);
  };

  // Handle file drop & upload
  const processFile = useCallback(async (file: File) => {
    if (!file.name.endsWith('.bin')) {
      setError('Please select a valid smartwatch dial file (.bin)');
      log('Error: Invalid file format uploaded.');
      return;
    }

    setIsProcessing(true);
    log(`Decompressing file: ${file.name} (${(file.size / 1024).toFixed(1)} KB)...`);

    try {
      const data = await decompressDial(file);
      // Normalize all block types to builder canonical names
      data.metadata.blocks = data.metadata.blocks.map((b: any) => normalizeBlockType(b));
      setDialData(data);
      const bgBlock = data.metadata.blocks.find((b: any) => b.type === 'BLK_BGIMG');
      if (bgBlock) {
        setWatchfaceSize({ width: bgBlock.width, height: bgBlock.height });
      } else {
        // Some dials use a full-screen ANIMPART as background (no BLK_BGIMG)
        const animBlock = data.metadata.blocks.find((b: any) => b.type === 'BLK_ANIM' && b.width >= 300);
        if (animBlock) {
          setWatchfaceSize({ width: animBlock.width, height: animBlock.height });
        }
      }
      setSelectedBlockIndex(null);
      log(`Decompress successfully! Extracted dial: ${data.metadata.dial_name}`);
      log(`Total layers/blocks found: ${data.metadata.blocks.length}`);
    } catch (err: any) {
      console.error(err);
      setError(`Failed to decompress dial file: ${err.message || err}`);
      log(`Error: Decompression failed: ${err.message || err}`);
    } finally {
      setIsProcessing(false);
    }
  }, [decompressDial, log]);

  // Drag handlers
  const handleDrag = (e: React.DragEvent) => {
    e.preventDefault();
    e.stopPropagation();
    if (e.type === "dragenter" || e.type === "dragover") {
      setDragActive(true);
    } else if (e.type === "dragleave") {
      setDragActive(false);
    }
  };

  const handleDrop = (e: React.DragEvent) => {
    e.preventDefault();
    e.stopPropagation();
    setDragActive(false);
    
    if (e.dataTransfer.files && e.dataTransfer.files[0]) {
      processFile(e.dataTransfer.files[0]);
    }
  };

  const handleFileChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    if (e.target.files && e.target.files[0]) {
      processFile(e.target.files[0]);
    }
  };

  // Compile dial back to .bin
  const handleCompile = async () => {
    if (!dialData) return;
    
    setIsProcessing(true);
    log(`Compiling dial [${dialData.metadata.dial_name}] back to binary...`);

    try {
      const bgBlock = dialData.metadata.blocks.find((b: any) => b.type === 'BLK_BGIMG');
      let compiledImages = { ...dialData.images };
      let compiledMetadata = JSON.parse(JSON.stringify(dialData.metadata));

      // Safety net: hands and animations must ship with align=9 to be drawn and
      // positioned correctly on the watch (verified across all original dials).
      // Catch any block that slipped through with align=0 regardless of how it was
      // created. Animations also need cty=0 and a nonzero ctx (playback interval).
      compiledMetadata.blocks.forEach((block: any) => {
        const isHandBlk = block.type === 'BLK_ARMH' || block.type === 'BLK_ARMM' || block.type === 'BLK_ARMS';
        const isAnimBlk = block.type === 'BLK_ANIM' || block.type === 'BLK_ANIMPART';
        if ((isHandBlk || isAnimBlk) && block.alnx !== 9) block.alnx = 9;
        if (isHandBlk && block.comp !== 0) block.comp = 0; // canonical align=9 + raw
        if (isAnimBlk) {
          block.cty = 0;
          if (!block.ctx || block.ctx <= 0) block.ctx = 10;
        }
      });

      const compileIssues: string[] = [];
      compiledMetadata.blocks.forEach((block: any, idx: number) => {
        if (!block.fname) {
          compileIssues.push(`Layer ${idx + 1} (${block.type}) has no asset assigned.`);
          return;
        }
        if (!compiledImages[block.fname]) {
          compileIssues.push(`Layer ${idx + 1} (${block.type}) is missing image data for ${block.fname}.`);
        }
        const expectedFrames = getExpectedFramesForType(block.type, block.frms);
        if (expectedFrames.length > 0 && !expectedFrames.includes(block.frms)) {
          compileIssues.push(`Layer ${idx + 1} (${block.type}) has ${block.frms} frames; expected ${expectedFrames.join(' or ')}.`);
        }
      });

      if (compileIssues.length > 0) {
        const message = `Compile aborted. Fix these issues:\n- ${compileIssues.join('\n- ')}`;
        log(message);
        setError(message);
        setIsProcessing(false);
        return;
      }

      const dimensionResults = await Promise.all(
        compiledMetadata.blocks.map((block: any) =>
          validateAndSyncAssetDimensions(block, compiledImages[block.fname])
        )
      );
      const dimensionIssues = dimensionResults
        .filter(result => result?.issue)
        .map(result => result?.issue) as string[];
      const autoAdjusted = dimensionResults
        .map((result, idx) => ({ result, idx }))
        .filter(entry => entry.result?.adjusted);

      if (autoAdjusted.length > 0) {
        autoAdjusted.forEach(({ idx, result }) => {
          const block = compiledMetadata.blocks[idx];
          log(
            `Auto-synced ${block.type} dimensions to ${result?.actualWidth}x${result?.actualHeight} from asset.`
          );
        });
      }

      if (dimensionIssues.length > 0) {
        const message = `Compile aborted. Asset size mismatches:\n- ${dimensionIssues.join('\n- ')}`;
        log(message);
        setError(message);
        setIsProcessing(false);
        return;
      }

      if (bgBlock && compiledImages[bgBlock.fname]) {
        log("Baking background cropping and scaling changes...");
        try {
          const bakedBgUrl = await new Promise<string>((resolve, reject) => {
            const img = new Image();
            img.onload = () => {
              const canvas = document.createElement('canvas');
              canvas.width = watchfaceSize.width;
              canvas.height = watchfaceSize.height;
              const ctx = canvas.getContext('2d');
              if (ctx) {
                ctx.fillStyle = '#000000'; // Default black backing
                ctx.fillRect(0, 0, watchfaceSize.width, watchfaceSize.height);
                // Draw user positioned/scaled background
                ctx.drawImage(img, bgBlock.posx, bgBlock.posy, bgBlock.width, bgBlock.height);
              }
              resolve(canvas.toDataURL('image/png'));
            };
            img.onerror = () => reject(new Error("Failed to load background image for baking"));
            img.src = compiledImages[bgBlock.fname];
          });

          // Override background coordinates and size in compiled metadata
          const bgBlockIdx = compiledMetadata.blocks.findIndex((b: any) => b.type === 'BLK_BGIMG');
          if (bgBlockIdx !== -1) {
            compiledMetadata.blocks[bgBlockIdx].posx = 0;
            compiledMetadata.blocks[bgBlockIdx].posy = 0;
            compiledMetadata.blocks[bgBlockIdx].width = watchfaceSize.width;
            compiledMetadata.blocks[bgBlockIdx].height = watchfaceSize.height;
          }

          compiledImages[bgBlock.fname] = bakedBgUrl;
          log("Background successfully baked!");
        } catch (err: any) {
          log(`Warning: Background baking failed (${err.message || err}). Compiling with original files.`);
        }
      }

      const compiledBlob = await compressDial(compiledMetadata, compiledImages);
      log(`Compilation complete! Generating download link...`);

      // Trigger browser download
      const downloadUrl = URL.createObjectURL(compiledBlob);
      const link = document.createElement('a');
      link.href = downloadUrl;
      link.download = `${dialData.metadata.dial_name || 'compiled'}_new.bin`;
      document.body.appendChild(link);
      link.click();
      document.body.removeChild(link);
      URL.revokeObjectURL(downloadUrl);
      
      log(`Successfully compiled and downloaded dial.`);
    } catch (err: any) {
      console.error("Compile error details:", err);
      let errMessage = "";
      if (err) {
        if (typeof err === 'string') {
          errMessage = err;
        } else if (err.message) {
          errMessage = err.message;
        } else if (err.toString && err.toString() !== '[object Object]') {
          errMessage = err.toString();
        } else {
          try {
            errMessage = JSON.stringify(err);
          } catch (e) {
            errMessage = String(err);
          }
        }
      } else {
        errMessage = "Unknown error";
      }
      setError(`Failed to compile dial: ${errMessage}`);
      log(`Error: Failed to compile dial: ${errMessage}`);
    } finally {
      setIsProcessing(false);
    }
  };

  const handleBackToUpload = () => {
    if (isLiveRunning) {
      toggleLiveSimulation();
    }
    setDialData(null);
    setSelectedBlockIndex(null);
    setError(null);
    setInitialMode('select');
    log('Reset editor. Awaiting selection...');
  };

  const handleCreateNewDial = () => {
    // Generate blank circular canvas for background
    const bgCanvas = document.createElement('canvas');
    bgCanvas.width = 466;
    bgCanvas.height = 466;
    const bgCtx = bgCanvas.getContext('2d');
    if (bgCtx) {
      bgCtx.fillStyle = '#0f121e';
      bgCtx.fillRect(0, 0, 466, 466);
      
      bgCtx.strokeStyle = 'rgba(255,255,255,0.05)';
      bgCtx.lineWidth = 2;
      bgCtx.strokeRect(0, 0, 466, 466);
    }
    const bgDataUrl = bgCanvas.toDataURL('image/png');

    // Generate blank preview canvas
    const prevCanvas = document.createElement('canvas');
    prevCanvas.width = 280;
    prevCanvas.height = 280;
    const prevCtx = prevCanvas.getContext('2d');
    if (prevCtx) {
      prevCtx.fillStyle = '#0f121e';
      prevCtx.fillRect(0, 0, 280, 280);
    }
    const prevDataUrl = prevCanvas.toDataURL('image/png');

    const newMetadata = {
      dial_name: 'new_dial',
      blocks: [
        {
          type: 'BLK_PREVI',
          frms: 1,
          fname: 'generated/prev.png',
          reuse: false,
          colsp: 'RGBA',
          width: 280,
          height: 280,
          posx: 0,
          posy: 0,
          alnx: 0,
          ctx: 0,
          cty: 0
        },
        {
          type: 'BLK_BGIMG',
          frms: 1,
          fname: 'generated/background.png',
          reuse: false,
          colsp: 'RGB',
          width: 466,
          height: 466,
          posx: 0,
          posy: 0,
          alnx: 0,
          ctx: 0,
          cty: 0,
          locked: true
        }
      ]
    };

    setDialData({
      metadata: newMetadata,
      images: {
        'generated/prev.png': prevDataUrl,
        'generated/background.png': bgDataUrl
      }
    });
    setWatchfaceSize({ width: 466, height: 466 });
    setSelectedBlockIndex(1); // Select background layer
    log('Created a blank watch face dial workspace.');
  };

  const handleAddBlock = () => {
    if (!dialData) return;
    
    // Types that may appear multiple times
    const allowMultiple = new Set(['BLK_ANIM', 'BLK_BIGYO', 'BLK_UNK_A1']);
    
    // Find the first available block type that is not already added
    const existingTypes = new Set(dialData.metadata.blocks.map((b: any) => b.type));
    let defaultType = 'BLK_HOUR';
    const candidateType = BLOCK_TYPES.find(bt => 
      bt.value !== 'BLK_BGIMG' && 
      bt.value !== 'BLK_PREVI' && 
      !allowMultiple.has(bt.value) &&
      !existingTypes.has(bt.value)
    );
    if (candidateType) {
      defaultType = candidateType.value;
    } else {
      defaultType = 'BLK_ANIM'; // If all singular types are filled, default to animation
    }
    
    // Find the last typographic block that has a fontConfig to inherit from
    const lastTypoBlock = [...dialData.metadata.blocks]
      .reverse()
      .find(b => isTypographicBlock(b.type) && b.fontConfig);

    const uniqueId = Date.now();
    const typeSuffix = defaultType.toLowerCase().substring(4); // e.g. "hour"
    const defaultFrms = getDefaultFramesForType(defaultType);
    const newBlock = {
      type: defaultType,
      frms: defaultFrms,
      fname: lastTypoBlock && isTypographicBlock(defaultType) ? `generated/font_${typeSuffix}_${uniqueId}.png` : '',
      reuse: false,
      colsp: 'RGBA',
      width: lastTypoBlock ? lastTypoBlock.width : 60,
      height: lastTypoBlock ? lastTypoBlock.height : 60,
      posx: 203, // center approx (233 - 30)
      posy: 203,
      alnx: lastTypoBlock ? lastTypoBlock.alnx : 0,
      ctx: 0,
      cty: 0,
      ...(lastTypoBlock ? { fontConfig: { ...lastTypoBlock.fontConfig } } : {})
    };

    let updatedImages = { ...dialData.images };
    if (lastTypoBlock && lastTypoBlock.fname && dialData.images[lastTypoBlock.fname]) {
      updatedImages[newBlock.fname] = dialData.images[lastTypoBlock.fname];
    }
    
    const updatedBlocks = [...dialData.metadata.blocks, newBlock];
    setDialData({
      ...dialData,
      images: updatedImages,
      metadata: {
        ...dialData.metadata,
        blocks: updatedBlocks
      }
    });
    setSelectedBlockIndex(updatedBlocks.length - 1);
    log('Added a new layer. ' + (lastTypoBlock ? 'Automatically inherited typography design from previous layer.' : 'Configure its type and upload/generate its asset.'));
  };

  const handleDeleteBlock = () => {
    if (selectedBlockIndex === null || !dialData) return;
    const block = dialData.metadata.blocks[selectedBlockIndex];
    
    if (block.type === 'BLK_BGIMG') {
      alert("The background layer (BLK_BGIMG) cannot be deleted.");
      return;
    }
    
    const updatedBlocks = dialData.metadata.blocks.filter((_: any, idx: number) => idx !== selectedBlockIndex);
    
    // Remove image if no other block is using it
    const updatedImages = { ...dialData.images };
    const imageUsedElsewhere = updatedBlocks.some((b: any) => b.fname === block.fname);
    if (!imageUsedElsewhere && block.fname) {
      delete updatedImages[block.fname];
    }
    
    setDialData({
      ...dialData,
      images: updatedImages,
      metadata: {
        ...dialData.metadata,
        blocks: updatedBlocks
      }
    });
    setSelectedBlockIndex(null);
    log(`Deleted layer: ${block.type}.`);
  };

  const handleResetBackground = () => {
    if (!dialData) return;
    
    // 1. Force the screen resolution back to 466x466
    setWatchfaceSize({ width: 466, height: 466 });
    
    // 2. Check if a background block exists (type BLK_BGIMG)
    const blocks = [...dialData.metadata.blocks];
    const bgBlockIdx = blocks.findIndex((b: any) => b.type === 'BLK_BGIMG');
    
    const canvas = document.createElement('canvas');
    canvas.width = 466;
    canvas.height = 466;
    const ctx = canvas.getContext('2d');
    if (ctx) {
      ctx.fillStyle = '#000000';
      ctx.fillRect(0, 0, 466, 466);
    }
    const defaultBgDataUrl = canvas.toDataURL('image/png');
    
    const updatedImages = { ...dialData.images };
    
    if (bgBlockIdx !== -1) {
      // Background exists, reset its metadata values
      blocks[bgBlockIdx] = {
        ...blocks[bgBlockIdx],
        width: 466,
        height: 466,
        posx: 0,
        posy: 0,
        frms: 1,
        fname: blocks[bgBlockIdx].fname || 'generated/background.png',
        locked: true
      };
      if (!updatedImages[blocks[bgBlockIdx].fname]) {
        updatedImages[blocks[bgBlockIdx].fname] = defaultBgDataUrl;
      }
      setSelectedBlockIndex(bgBlockIdx);
    } else {
      // Background is missing, recreate and insert at index 0 (as required for background)
      const newBgBlock = {
        type: 'BLK_BGIMG',
        frms: 1,
        fname: 'generated/background.png',
        reuse: false,
        colsp: 'RGB',
        width: 466,
        height: 466,
        posx: 0,
        posy: 0,
        alnx: 0,
        ctx: 0,
        cty: 0,
        locked: true
      };
      blocks.unshift(newBgBlock);
      updatedImages['generated/background.png'] = defaultBgDataUrl;
      setSelectedBlockIndex(0);
    }
    
    setDialData({
      ...dialData,
      images: updatedImages,
      metadata: {
        ...dialData.metadata,
        blocks: blocks
      }
    });
    
    log('Default background layer (466x466) restored and resolution reset.');
  };

  const handleBlockTypeChange = (index: number, newType: string) => {
    if (!dialData) return;
    const block = dialData.metadata.blocks[index];
    const defaultFrms = getDefaultFramesForType(newType, block.frms);

    const updatedFields: Partial<any> = {
      type: newType,
      frms: defaultFrms
    };

    if (isTypographicBlock(newType)) {
      updatedFields.fontConfig = normalizeFontConfigForType(block.fontConfig, newType, defaultFrms);
    } else if (block.fontConfig) {
      updatedFields.fontConfig = undefined;
    }

    handleUpdateBlock(index, updatedFields);
  };

  const handleCenterBlock = (axis: 'horizontal' | 'vertical' | 'both') => {
    if (selectedBlockIndex === null || !dialData) return;
    const block = dialData.metadata.blocks[selectedBlockIndex];
    
    // Find background size to dynamically adjust canvas size
    const bgBlock = dialData.metadata.blocks.find((b: any) => b.type === 'BLK_BGIMG');
    const size = bgBlock ? bgBlock.width : 466;
    
    const updatedFields: Partial<any> = {};

    if (block.type === 'BLK_ARMH' || block.type === 'BLK_ARMM' || block.type === 'BLK_ARMS') {
      // For hands, center them at the pivot point
      if (axis === 'horizontal' || axis === 'both') updatedFields.posx = Math.round(size / 2);
      if (axis === 'vertical' || axis === 'both') updatedFields.posy = Math.round(size / 2);
    } else {
      // All blocks are anchored by their TOP-LEFT corner at (posx, posy), so to
      // center on screen we place that corner at (size - extent) / 2. Digit groups
      // span N * width (the watch advances each digit by `width`).
      let elementWidth = block.width;
      if (block.type === 'BLK_HOUR' || block.type === 'BLK_MIN' || block.type === 'BLK_SEC') {
        elementWidth = 2 * block.width;
      } else if (block.type === 'BLK_DAY' || block.type === 'BLK_MONTH' || block.type === 'BLK_YEAR') {
        elementWidth = 2 * block.width;
      } else if (block.type === 'BLK_STEPS') {
        elementWidth = 5 * block.width;
      } else if (block.type === 'BLK_BATTN') {
        elementWidth = 3 * block.width;
      }

      const elementHeight = block.height;

      if (axis === 'horizontal' || axis === 'both') {
        updatedFields.posx = Math.round((size - elementWidth) / 2);
      }
      if (axis === 'vertical' || axis === 'both') {
        updatedFields.posy = Math.round((size - elementHeight) / 2);
      }
    }

    handleUpdateBlock(selectedBlockIndex, updatedFields);
    log(`Centered layer: ${block.type} ${axis}.`);
  };

  // Rescales background image proportionally based on 'fit', 'fill' or 'reset'
  const handleScaleBackground = (type: 'fit' | 'fill' | 'reset') => {
    if (selectedBlockIndex === null || !dialData) return;
    const block = dialData.metadata.blocks[selectedBlockIndex];
    if (block.type !== 'BLK_BGIMG') return;

    const imgUrl = dialData.images[block.fname];
    if (!imgUrl) return;

    const img = new Image();
    img.onload = () => {
      const naturalW = img.width;
      const naturalH = img.height;
      const targetW = watchfaceSize.width;
      const targetH = watchfaceSize.height;

      let newW = naturalW;
      let newH = naturalH;
      let newX = 0;
      let newY = 0;

      if (type === 'fit') {
        const scale = Math.min(targetW / naturalW, targetH / naturalH);
        newW = Math.round(naturalW * scale);
        newH = Math.round(naturalH * scale);
        newX = Math.round((targetW - newW) / 2);
        newY = Math.round((targetH - newH) / 2);
      } else if (type === 'fill') {
        const scale = Math.max(targetW / naturalW, targetH / naturalH);
        newW = Math.round(naturalW * scale);
        newH = Math.round(naturalH * scale);
        newX = Math.round((targetW - newW) / 2);
        newY = Math.round((targetH - newH) / 2);
      } else if (type === 'reset') {
        newW = naturalW;
        newH = naturalH;
        newX = Math.round((targetW - newW) / 2);
        newY = Math.round((targetH - newH) / 2);
      }

      handleUpdateBlock(selectedBlockIndex, {
        width: newW,
        height: newH,
        posx: newX,
        posy: newY
      });
      log(`Rescaled background: ${type} (${newW}x${newH} px at posx: ${newX}, posy: ${newY})`);
    };
    img.src = imgUrl;
  };

  // State Updates for Canvas Blocks
  const handleUpdateBlock = useCallback((index: number, updatedFields: Partial<any>) => {
    setDialData(prev => {
      if (!prev) return null;
      const newBlocks = [...prev.metadata.blocks];
      newBlocks[index] = { ...newBlocks[index], ...updatedFields };
      return {
        ...prev,
        metadata: {
          ...prev.metadata,
          blocks: newBlocks
        }
      };
    });
  }, []);

  const handleMoveBlock = (index: number, direction: 'up' | 'down') => {
    if (!dialData) return;
    const blocks = [...dialData.metadata.blocks];
    const targetIdx = direction === 'up' ? index - 1 : index + 1;
    
    if (targetIdx < 0 || targetIdx >= blocks.length) return;

    // Swap blocks
    const temp = blocks[index];
    blocks[index] = blocks[targetIdx];
    blocks[targetIdx] = temp;

    setDialData({
      ...dialData,
      metadata: {
        ...dialData.metadata,
        blocks
      }
    });

    // Update selection selection index
    if (selectedBlockIndex === index) {
      setSelectedBlockIndex(targetIdx);
    } else if (selectedBlockIndex === targetIdx) {
      setSelectedBlockIndex(index);
    }
    log(`Moved block layer ${direction === 'up' ? 'upwards' : 'downwards'}.`);
  };

  // Live Timer Simulation toggle
  const toggleLiveSimulation = () => {
    if (isLiveRunning) {
      clearInterval(timerRef.current);
      setIsLiveRunning(false);
      log('Live simulation paused.');
    } else {
      setIsLiveRunning(true);
      log('Live simulation started.');
      timerRef.current = setInterval(() => {
        setMockState(prev => {
          let nextSec = prev.second + 1;
          let nextMin = prev.minute;
          let nextHour = prev.hour;

          if (nextSec >= 60) {
            nextSec = 0;
            nextMin += 1;
          }
          if (nextMin >= 60) {
            nextMin = 0;
            nextHour += 1;
          }
          if (nextHour >= 24) {
            nextHour = 0;
          }

          return {
            ...prev,
            second: nextSec,
            minute: nextMin,
            hour: nextHour
          };
        });
      }, 1000);
    }
  };

  // Status Badge UI helper
  const renderStatusBadge = () => {
    const statusLabels: Record<string, string> = {
      idle: 'Initializing...',
      loading_engine: 'Loading WebAssembly Python...',
      loading_packages: 'Downloading Pillow & NumPy...',
      loading_script: 'Injecting Compiler Core...',
      ready: 'Engine Ready',
      error: 'Engine Error'
    };

    return (
      <div className={`status-badge ${status}`}>
        {isLoading && <Loader2 size={14} className="animate-spin" />}
        {!isLoading && status === 'ready' && <CheckCircle2 size={14} />}
        {!isLoading && status === 'error' && <AlertTriangle size={14} />}
        <span className="status-dot" />
        <span>{statusLabels[status] || status}</span>
      </div>
    );
  };

  const selectedBlock = selectedBlockIndex !== null && dialData 
    ? dialData.metadata.blocks[selectedBlockIndex] 
    : null;

  return (
    <div className="container">
      {/* Header */}
      <header className="app-header">
        <div className="brand">
          <h1>HK89 Dial Designer</h1>
          <p>Visual Watch Face Creator & Editor</p>
        </div>
        {renderStatusBadge()}
      </header>

      {/* Engine Error Alert */}
      {(pyodideError || error) && (
        <div className="glass-panel" style={{ 
          borderColor: 'var(--error)', 
          padding: '1.25rem', 
          marginBottom: '2rem',
          display: 'flex',
          gap: '1rem',
          alignItems: 'center',
          background: 'var(--error-glow)'
        }}>
          <AlertTriangle color="var(--error)" size={24} />
          <div>
            <h4 style={{ margin: 0, color: 'var(--error)', fontWeight: 700 }}>Error Encountered</h4>
            <p style={{ margin: '0.25rem 0 0 0', fontSize: '0.9rem', color: 'var(--text-secondary)' }}>
              {pyodideError || error}
            </p>
          </div>
        </div>
      )}

      {/* Main workspace */}
      {!dialData ? (
        initialMode === 'select' ? (
          // Choice Selection UI
          <div className="selection-grid">
            <div className="selection-card" onClick={() => setInitialMode('upload')}>
              <div className="selection-card-icon">
                <Upload size={32} />
              </div>
              <h3 className="selection-card-title">Decompile Existing Dial</h3>
              <p className="selection-card-desc">
                Upload and decompress an existing watch face .bin file to inspect, edit, and recompile it.
              </p>
            </div>
            
            <div className="selection-card" onClick={handleCreateNewDial}>
              <div className="selection-card-icon">
                <Cpu size={32} />
              </div>
              <h3 className="selection-card-title">Create New Dial</h3>
              <p className="selection-card-desc">
                Start a fresh watch face design from scratch with a blank background canvas.
              </p>
            </div>
          </div>
        ) : (
          // File upload UI
          <div className="glass-panel" style={{ padding: '2rem', display: 'flex', flexDirection: 'column', alignItems: 'center', gap: '1.5rem' }}>
            <div 
              className={`upload-container ${dragActive ? 'drag-active' : ''}`}
              onDragEnter={handleDrag}
              onDragOver={handleDrag}
              onDragLeave={handleDrag}
              onDrop={handleDrop}
              onClick={() => fileInputRef.current?.click()}
              style={{ width: '100%' }}
            >
              <input 
                type="file" 
                ref={fileInputRef} 
                style={{ display: 'none' }} 
                accept=".bin"
                onChange={handleFileChange}
                disabled={isLoading || isProcessing}
              />
              
              {isProcessing ? (
                <Loader2 size={48} className="upload-icon animate-spin" />
              ) : (
                <Upload size={48} className="upload-icon" />
              )}
              
              <p className="upload-text">
                {isProcessing ? 'Processing dial file...' : 'Select or drop your watch face .bin file'}
              </p>
              <p className="upload-subtext">
                Upload an existing smartwatch watch face bin file to decompress and inspect assets.
              </p>
            </div>
            
            <button 
              className="btn btn-secondary" 
              onClick={() => setInitialMode('select')}
              disabled={isProcessing}
            >
              <ArrowLeft size={16} />
              Back to Choice
            </button>
          </div>
        )
      ) : (
        // Editor & Visualization layout
        <div style={{ display: 'flex', flexDirection: 'column', gap: '2rem' }}>
          
          <div className="editor-grid" style={{ gridTemplateColumns: '1fr 380px', gap: '2rem' }}>
            
            {/* Column 1: Interactive Canvas & Simulation Sliders */}
            <div style={{ display: 'flex', flexDirection: 'column', gap: '1.5rem' }}>
              <div className="glass-panel" style={{ padding: '1.5rem', display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
                <CanvasWatchface
                  watchfaceSize={watchfaceSize}
                  blocks={dialData.metadata.blocks}
                  images={dialData.images}
                  selectedBlockIndex={selectedBlockIndex}
                  onSelectBlock={setSelectedBlockIndex}
                  onUpdateBlock={handleUpdateBlock}
                  mockState={mockState}
                />
              </div>

              {/* Simulation Sliders Panel */}
              <div className="glass-panel">
                <div className="panel-header" style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
                  <h3>Simulation Controls</h3>
                  <button 
                    className={`btn ${isLiveRunning ? 'btn-secondary' : 'btn-primary'}`} 
                    style={{ padding: '0.4rem 0.8rem', fontSize: '0.8rem' }}
                    onClick={toggleLiveSimulation}
                  >
                    {isLiveRunning ? <Pause size={12} /> : <Play size={12} />}
                    {isLiveRunning ? 'Pause Time' : 'Run Live Time'}
                  </button>
                </div>
                <div className="panel-body" style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '1.5rem' }}>
                  
                  {/* Slider: Time */}
                  <div style={{ display: 'flex', flexDirection: 'column', gap: '0.5rem' }}>
                    <div style={{ display: 'flex', justifyContent: 'space-between', fontSize: '0.85rem' }}>
                      <span style={{ color: 'var(--text-secondary)' }}>Hour</span>
                      <span style={{ fontFamily: 'var(--font-mono)', fontWeight: 600 }}>{mockState.hour}h</span>
                    </div>
                    <input 
                      type="range" min="0" max="23" value={mockState.hour}
                      disabled={isLiveRunning}
                      onChange={(e) => setMockState({ ...mockState, hour: parseInt(e.target.value) })}
                      style={{ width: '100%', accentColor: 'var(--accent)' }}
                    />
                    
                    <div style={{ display: 'flex', justifyContent: 'space-between', fontSize: '0.85rem', marginTop: '0.25rem' }}>
                      <span style={{ color: 'var(--text-secondary)' }}>Minute</span>
                      <span style={{ fontFamily: 'var(--font-mono)', fontWeight: 600 }}>{mockState.minute}m</span>
                    </div>
                    <input 
                      type="range" min="0" max="59" value={mockState.minute}
                      disabled={isLiveRunning}
                      onChange={(e) => setMockState({ ...mockState, minute: parseInt(e.target.value) })}
                      style={{ width: '100%', accentColor: 'var(--accent)' }}
                    />

                    <div style={{ display: 'flex', justifyContent: 'space-between', fontSize: '0.85rem', marginTop: '0.25rem' }}>
                      <span style={{ color: 'var(--text-secondary)' }}>Day</span>
                      <span style={{ fontFamily: 'var(--font-mono)', fontWeight: 600 }}>{mockState.day}</span>
                    </div>
                    <input 
                      type="range" min="1" max="31" value={mockState.day}
                      disabled={isLiveRunning}
                      onChange={(e) => setMockState({ ...mockState, day: parseInt(e.target.value) })}
                      style={{ width: '100%', accentColor: 'var(--accent)' }}
                    />

                    <div style={{ display: 'flex', justifyContent: 'space-between', fontSize: '0.85rem', marginTop: '0.25rem' }}>
                      <span style={{ color: 'var(--text-secondary)' }}>Year</span>
                      <span style={{ fontFamily: 'var(--font-mono)', fontWeight: 600 }}>{mockState.year}</span>
                    </div>
                    <input 
                      type="range" min="2000" max="2099" value={mockState.year}
                      disabled={isLiveRunning}
                      onChange={(e) => setMockState({ ...mockState, year: parseInt(e.target.value) })}
                      style={{ width: '100%', accentColor: 'var(--accent)' }}
                    />
                  </div>

                  {/* Slider: Battery, Steps, Bluetooth */}
                  <div style={{ display: 'flex', flexDirection: 'column', gap: '0.5rem' }}>
                    <div style={{ display: 'flex', justifyContent: 'space-between', fontSize: '0.85rem' }}>
                      <span style={{ color: 'var(--text-secondary)' }}>Battery</span>
                      <span style={{ fontFamily: 'var(--font-mono)', fontWeight: 600 }}>{mockState.battery}%</span>
                    </div>
                    <input 
                      type="range" min="0" max="100" value={mockState.battery}
                      onChange={(e) => setMockState({ ...mockState, battery: parseInt(e.target.value) })}
                      style={{ width: '100%', accentColor: 'var(--accent)' }}
                    />

                    <div style={{ display: 'flex', justifyContent: 'space-between', fontSize: '0.85rem', marginTop: '0.25rem' }}>
                      <span style={{ color: 'var(--text-secondary)' }}>Steps</span>
                      <span style={{ fontFamily: 'var(--font-mono)', fontWeight: 600 }}>{mockState.steps} steps</span>
                    </div>
                    <input 
                      type="range" min="0" max="15000" step="50" value={mockState.steps}
                      onChange={(e) => setMockState({ ...mockState, steps: parseInt(e.target.value) })}
                      style={{ width: '100%', accentColor: 'var(--accent)' }}
                    />

                    <div style={{ display: 'flex', alignItems: 'center', gap: '0.5rem', marginTop: '0.5rem' }}>
                      <input 
                        type="checkbox" id="bt-conn" checked={mockState.connected}
                        onChange={(e) => setMockState({ ...mockState, connected: e.target.checked })}
                        style={{ accentColor: 'var(--accent)' }}
                      />
                      <label htmlFor="bt-conn" style={{ fontSize: '0.85rem', color: 'var(--text-secondary)', cursor: 'pointer' }}>
                        Bluetooth Connected
                      </label>
                    </div>
                  </div>

                </div>
              </div>

            </div>

            {/* Column 2: Layer List & Property Inspector */}
            <div className="sidebar-panel">
              
              {/* Actions panel */}
              <div className="glass-panel" style={{ padding: '1.25rem', display: 'flex', flexDirection: 'column', gap: '0.75rem' }}>
                <button 
                  className="btn btn-primary" 
                  onClick={handleCompile}
                  disabled={isLoading || isProcessing}
                  style={{ justifyContent: 'center' }}
                >
                  {isProcessing ? <Loader2 size={16} className="animate-spin" /> : <Download size={16} />}
                  Compile & Download .bin
                </button>
                
                <button 
                  className="btn btn-secondary" 
                  onClick={handleBackToUpload}
                  disabled={isLoading || isProcessing}
                  style={{ justifyContent: 'center' }}
                >
                  <ArrowLeft size={16} />
                  Upload Another File
                </button>
              </div>

              {/* Inspector Panel */}
              <div className="glass-panel">
                <div className="panel-header">
                  <h3>Inspector</h3>
                </div>
                <div className="panel-body">
                  {selectedBlock ? (
                    <div style={{ display: 'flex', flexDirection: 'column', gap: '1rem' }}>
                      
                      {/* Field: Type & Lock Row */}
                      <div style={{ display: 'flex', gap: '0.75rem', alignItems: 'flex-end' }}>
                        <div style={{ display: 'flex', flexDirection: 'column', gap: '0.35rem', flex: 1 }}>
                          <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600 }}>LAYER TYPE</label>
                          <select 
                            value={selectedBlock.type}
                            onChange={(e) => handleBlockTypeChange(selectedBlockIndex!, e.target.value)}
                            style={{
                              background: 'var(--bg-secondary)',
                              border: '1px solid var(--glass-border)',
                              color: 'var(--text-primary)',
                              padding: '0.5rem',
                              borderRadius: '6px',
                              width: '100%',
                              fontFamily: 'var(--font-sans)',
                            }}
                          >
                            {(() => {
                              const groups: Record<string, typeof BLOCK_TYPES> = {};
                              BLOCK_TYPES.forEach(bt => {
                                const g = (bt as any).group || 'other';
                                if (!groups[g]) groups[g] = [];
                                groups[g].push(bt);
                              });
                              const groupLabels: Record<string, string> = {
                                system: '🖼️ System', hands: '🕐 Analog Hands', time: '🕓 Time',
                                date: '📅 Date', fitness: '💪 Health & Fitness', status: '🔋 Status',
                                weather: '🌤️ Weather', gauges: '📊 Gauges', animation: '✨ Animation', other: '⚙️ Other'
                              };
                              // Types that may appear multiple times
                              const allowMultiple = new Set(['BLK_ANIM', 'BLK_BIGYO', 'BLK_UNK_A1']);
                              return Object.entries(groups).map(([group, types]) => (
                                <optgroup key={group} label={groupLabels[group] || group}>
                                  {types.map(bt => {
                                    const isDuplicate = dialData?.metadata.blocks.some(
                                      (b: any, idx: number) => b.type === bt.value && idx !== selectedBlockIndex
                                    );
                                    const isDisabled = isDuplicate && !allowMultiple.has(bt.value);
                                    return (
                                      <option
                                        key={bt.value}
                                        value={bt.value}
                                        disabled={isDisabled}
                                      >
                                        {bt.label}{isDisabled ? ' ✓' : ''}
                                      </option>
                                    );
                                  })}
                                </optgroup>
                              ));
                            })()}
                          </select>
                          {dialData && dialData.metadata.blocks.filter((b: any) => b.type === selectedBlock.type).length > 1 && !['BLK_ANIM', 'BLK_BIGYO', 'BLK_UNK_A1'].includes(selectedBlock.type) && (
                            <div style={{
                              color: '#ff4d4d',
                              fontSize: '0.75rem',
                              marginTop: '0.35rem',
                              display: 'flex',
                              alignItems: 'center',
                              gap: '0.25rem',
                              fontWeight: 500
                            }}>
                              <AlertTriangle size={12} /> Only one layer of this type is allowed. Duplicate type will cause issues.
                            </div>
                          )}
                        </div>
                        <button
                          className={`btn ${selectedBlock.locked ? 'btn-primary' : 'btn-secondary'}`}
                          style={{
                            padding: '0.5rem',
                            height: '38px',
                            display: 'flex',
                            alignItems: 'center',
                            justifyContent: 'center',
                            width: '42px',
                            borderColor: selectedBlock.locked ? 'var(--accent)' : 'var(--glass-border)',
                            background: selectedBlock.locked ? 'rgba(170, 59, 255, 0.25)' : 'var(--bg-secondary)',
                          }}
                          onClick={() => handleUpdateBlock(selectedBlockIndex!, { locked: !selectedBlock.locked })}
                          title={selectedBlock.locked ? "Unlock Layer" : "Lock Layer"}
                        >
                          {selectedBlock.locked ? <Lock size={16} /> : <Unlock size={16} />}
                        </button>
                      </div>

                      {/* Coordinates Grid */}
                      <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '1rem' }}>
                        <div style={{ display: 'flex', flexDirection: 'column', gap: '0.35rem' }}>
                          <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600 }}>POS X</label>
                          <input 
                            type="number" 
                            value={selectedBlock.posx}
                            onChange={(e) => handleUpdateBlock(selectedBlockIndex!, { posx: parseInt(e.target.value) || 0 })}
                            style={{
                              background: 'var(--bg-secondary)',
                              border: '1px solid var(--glass-border)',
                              color: 'var(--text-primary)',
                              padding: '0.5rem',
                              borderRadius: '6px',
                              width: '100%',
                              fontFamily: 'var(--font-mono)',
                            }}
                          />
                        </div>
                        <div style={{ display: 'flex', flexDirection: 'column', gap: '0.35rem' }}>
                          <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600 }}>POS Y</label>
                          <input 
                            type="number" 
                            value={selectedBlock.posy}
                            onChange={(e) => handleUpdateBlock(selectedBlockIndex!, { posy: parseInt(e.target.value) || 0 })}
                            style={{
                              background: 'var(--bg-secondary)',
                              border: '1px solid var(--glass-border)',
                              color: 'var(--text-primary)',
                              padding: '0.5rem',
                              borderRadius: '6px',
                              width: '100%',
                              fontFamily: 'var(--font-mono)',
                            }}
                          />
                        </div>
                      </div>

                      {/* Size Grid (Width and Height) */}
                      <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '1rem' }}>
                        <div style={{ display: 'flex', flexDirection: 'column', gap: '0.35rem' }}>
                          <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600 }}>WIDTH</label>
                          <input 
                            type="number" 
                            value={selectedBlock.width}
                            onChange={(e) => handleUpdateBlock(selectedBlockIndex!, { width: Math.max(4, parseInt(e.target.value) || 0) })}
                            style={{
                              background: 'var(--bg-secondary)',
                              border: '1px solid var(--glass-border)',
                              color: 'var(--text-primary)',
                              padding: '0.5rem',
                              borderRadius: '6px',
                              width: '100%',
                              fontFamily: 'var(--font-mono)',
                            }}
                          />
                        </div>
                        <div style={{ display: 'flex', flexDirection: 'column', gap: '0.35rem' }}>
                          <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600 }}>HEIGHT</label>
                          <input 
                            type="number" 
                            value={selectedBlock.height}
                            onChange={(e) => handleUpdateBlock(selectedBlockIndex!, { height: Math.max(4, parseInt(e.target.value) || 0) })}
                            style={{
                              background: 'var(--bg-secondary)',
                              border: '1px solid var(--glass-border)',
                              color: 'var(--text-primary)',
                              padding: '0.5rem',
                              borderRadius: '6px',
                              width: '100%',
                              fontFamily: 'var(--font-mono)',
                            }}
                          />
                        </div>
                      </div>

                      {/* Background Scaling Presets */}
                      {selectedBlock.type === 'BLK_BGIMG' && (
                        <div style={{ display: 'flex', flexDirection: 'column', gap: '0.35rem' }}>
                          <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600 }}>BACKGROUND FIT</label>
                          <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr 1fr', gap: '0.5rem' }}>
                            <button 
                              className="btn btn-secondary" 
                              style={{ padding: '0.4rem', fontSize: '0.75rem', justifyContent: 'center' }} 
                              onClick={() => handleScaleBackground('fit')}
                            >
                              Fit Screen
                            </button>
                            <button 
                              className="btn btn-secondary" 
                              style={{ padding: '0.4rem', fontSize: '0.75rem', justifyContent: 'center' }} 
                              onClick={() => handleScaleBackground('fill')}
                            >
                              Fill Screen
                            </button>
                            <button 
                              className="btn btn-secondary" 
                              style={{ padding: '0.4rem', fontSize: '0.75rem', justifyContent: 'center' }} 
                              onClick={() => handleScaleBackground('reset')}
                            >
                              Reset Size
                            </button>
                          </div>
                        </div>
                      )}

                      {/* Centering buttons */}
                      {selectedBlock.type !== 'BLK_BGIMG' && (
                        <div style={{ display: 'flex', flexDirection: 'column', gap: '0.35rem' }}>
                          <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600 }}>ALIGNMENT</label>
                          <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr 1fr', gap: '0.5rem' }}>
                            <button 
                              className="btn btn-secondary" 
                              style={{ padding: '0.4rem', fontSize: '0.75rem', justifyContent: 'center' }} 
                              onClick={() => handleCenterBlock('horizontal')}
                            >
                              Center X
                            </button>
                            <button 
                              className="btn btn-secondary" 
                              style={{ padding: '0.4rem', fontSize: '0.75rem', justifyContent: 'center' }} 
                              onClick={() => handleCenterBlock('vertical')}
                            >
                              Center Y
                            </button>
                            <button 
                              className="btn btn-secondary" 
                              style={{ padding: '0.4rem', fontSize: '0.75rem', justifyContent: 'center' }} 
                              onClick={() => handleCenterBlock('both')}
                            >
                              Center All
                            </button>
                          </div>
                        </div>
                      )}

                      {/* Copy Style from Another Layer */}
                      {isTypographicBlock(selectedBlock.type) && (
                        <div style={{ display: 'flex', flexDirection: 'column', gap: '0.35rem' }}>
                          <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600 }}>
                            COPY TYPOGRAPHY FROM
                          </label>
                          <select
                            value=""
                            onChange={(e) => {
                              const sourceIdx = parseInt(e.target.value);
                              if (isNaN(sourceIdx)) return;
                              const sourceBlock = dialData.metadata.blocks[sourceIdx];
                              if (!sourceBlock || !sourceBlock.fontConfig) return;
                              
                              // Copy properties
                              const updatedImages = { ...dialData.images };
                              const newFname = `generated/font_${selectedBlock.type.toLowerCase()}_${Date.now()}.png`;
                              if (sourceBlock.fname && dialData.images[sourceBlock.fname]) {
                                updatedImages[newFname] = dialData.images[sourceBlock.fname];
                              }
                              
                              const updatedBlocks = [...dialData.metadata.blocks];
                              updatedBlocks[selectedBlockIndex!] = {
                                ...selectedBlock,
                                fname: newFname,
                                width: sourceBlock.width,
                                height: sourceBlock.height,
                                frms: sourceBlock.frms,
                                alnx: sourceBlock.alnx,
                                fontConfig: { ...sourceBlock.fontConfig }
                              };
                              
                              setDialData({
                                ...dialData,
                                images: updatedImages,
                                metadata: {
                                  ...dialData.metadata,
                                  blocks: updatedBlocks
                                }
                              });
                              log(`Copied typography design from layer: ${sourceBlock.type}`);
                            }}
                            style={{
                              background: 'var(--bg-secondary)',
                              border: '1px solid var(--glass-border)',
                              color: 'var(--text-primary)',
                              padding: '0.5rem',
                              borderRadius: '6px',
                              width: '100%',
                              fontFamily: 'var(--font-sans)',
                            }}
                          >
                            <option value="">-- Select layer to copy style --</option>
                            {dialData.metadata.blocks.map((block: any, idx: number) => {
                              if (idx !== selectedBlockIndex && isTypographicBlock(block.type) && block.fontConfig) {
                                return (
                                  <option key={idx} value={idx}>
                                    Layer #{idx} ({block.type})
                                  </option>
                                );
                              }
                              return null;
                            })}
                          </select>
                        </div>
                      )}

                      {/* Pivot Rotation Centers (only for Hands) */}
                      {(selectedBlock.type === 'BLK_ARMH' || selectedBlock.type === 'BLK_ARMM' || selectedBlock.type === 'BLK_ARMS') && (
                        <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '1rem', borderTop: '1px solid var(--glass-border)', paddingTop: '1rem' }}>
                          <div style={{ display: 'flex', flexDirection: 'column', gap: '0.35rem' }}>
                            <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600 }} title="X center of rotation relative to image left border">PIVOT X (CTX)</label>
                            <input 
                              type="number" 
                              value={selectedBlock.ctx}
                              onChange={(e) => handleUpdateBlock(selectedBlockIndex!, { ctx: parseInt(e.target.value) || 0 })}
                              style={{
                                background: 'var(--bg-secondary)',
                                border: '1px solid var(--glass-border)',
                                color: 'var(--text-primary)',
                                padding: '0.5rem',
                                borderRadius: '6px',
                                width: '100%',
                                fontFamily: 'var(--font-mono)',
                              }}
                            />
                          </div>
                          <div style={{ display: 'flex', flexDirection: 'column', gap: '0.35rem' }}>
                            <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600 }} title="Y center of rotation relative to image top border">PIVOT Y (CTY)</label>
                            <input 
                              type="number" 
                              value={selectedBlock.cty}
                              onChange={(e) => handleUpdateBlock(selectedBlockIndex!, { cty: parseInt(e.target.value) || 0 })}
                              style={{
                                background: 'var(--bg-secondary)',
                                border: '1px solid var(--glass-border)',
                                color: 'var(--text-primary)',
                                padding: '0.5rem',
                                borderRadius: '6px',
                                width: '100%',
                                fontFamily: 'var(--font-mono)',
                              }}
                            />
                          </div>
                        </div>
                      )}

                      {/* Display Readonly block details */}
                      <div style={{ borderTop: '1px solid var(--glass-border)', paddingTop: '1rem', fontSize: '0.8rem', color: 'var(--text-muted)', display: 'flex', flexDirection: 'column', gap: '0.25rem' }}>
                        <div>Asset name: <span style={{ fontFamily: 'var(--font-mono)', color: 'var(--text-secondary)' }}>{selectedBlock.fname}</span></div>
                        <div>Frames: <span style={{ fontFamily: 'var(--font-mono)', color: 'var(--text-secondary)' }}>{selectedBlock.frms}</span></div>
                        <div>Resolutions: <span style={{ fontFamily: 'var(--font-mono)', color: 'var(--text-secondary)' }}>{selectedBlock.width}x{selectedBlock.height} px</span></div>
                      </div>

                      {/* Custom Asset Uploader & Font Sheet Generator Actions */}
                      <div style={{ display: 'flex', flexDirection: 'column', gap: '0.5rem', marginTop: '0.5rem' }}>
                        {!isTypographicBlock(selectedBlock.type) && (
                          <>
                            <input 
                              type="file" 
                              ref={assetFileInputRef} 
                              style={{ display: 'none' }} 
                              accept="image/*,video/*" 
                              onChange={handleAssetFileChange} 
                            />
                            <button 
                              className="btn btn-secondary" 
                              style={{ fontSize: '0.85rem', justifyContent: 'center', padding: '0.5rem' }} 
                              onClick={() => assetFileInputRef.current?.click()}
                            >
                              {selectedBlock.type === 'BLK_ANIM' || selectedBlock.type === 'BLK_ANIMPART' 
                                ? 'Upload GIF / Video' 
                                : 'Upload Custom Image'}
                            </button>
                          </>
                        )}
                        {isTypographicBlock(selectedBlock.type) && (
                          <button 
                            className="btn btn-secondary" 
                            style={{ fontSize: '0.85rem', justifyContent: 'center', padding: '0.5rem' }} 
                            onClick={() => setIsFontModalOpen(true)}
                          >
                            {selectedBlock.fontConfig ? 'Edit Font Sheet' : 'Generate Font Sheet'}
                          </button>
                        )}
                        {selectedBlock.type === 'BLK_WEAT' && (
                          <button 
                            className="btn btn-secondary" 
                            style={{ fontSize: '0.85rem', justifyContent: 'center', padding: '0.5rem' }} 
                            onClick={() => setIsWeatherModalOpen(true)}
                          >
                            {selectedBlock.fontConfig ? 'Edit Weather Icons' : 'Generate Weather Icons'}
                          </button>
                        )}
                        {(selectedBlock.type === 'BLK_BATTS' || selectedBlock.type === 'BLK_BATTERY_STRIP') && (
                          <button
                            className="btn btn-secondary"
                            style={{ fontSize: '0.85rem', justifyContent: 'center', padding: '0.5rem' }}
                            onClick={() => setIsBatteryModalOpen(true)}
                          >
                            {selectedBlock.fontConfig ? 'Edit Battery Icons' : 'Generate Battery Icons'}
                          </button>
                        )}
                        {(selectedBlock.type === 'BLK_ARMH' || selectedBlock.type === 'BLK_ARMM' || selectedBlock.type === 'BLK_ARMS') && (
                          <button
                            className="btn btn-secondary"
                            style={{ fontSize: '0.85rem', justifyContent: 'center', padding: '0.5rem' }}
                            onClick={() => setIsHandModalOpen(true)}
                          >
                            {selectedBlock.handConfig ? 'Edit Hand Set' : 'Build Hand Set'}
                          </button>
                        )}
                        <button 
                          className="btn btn-secondary" 
                          style={{ fontSize: '0.85rem', justifyContent: 'center', padding: '0.5rem', borderColor: 'var(--error)', color: 'var(--error)' }} 
                          onClick={handleDeleteBlock}
                        >
                          Delete Layer
                        </button>
                      </div>

                    </div>
                  ) : (
                    <div style={{ textAlign: 'center', color: 'var(--text-muted)', padding: '2rem 1rem', fontSize: '0.9rem' }}>
                      Select a layer on the canvas or in the list below to edit its properties.
                    </div>
                  )}
                </div>
              </div>

              {/* Blocks/Layers List */}
              <div className="glass-panel">
                <div className="panel-header">
                  <h3>Layers Rendering Queue</h3>
                </div>
                <div className="panel-body blocks-list" style={{ maxHeight: '300px' }}>
                  {!dialData.metadata.blocks.some((b: any) => b.type === 'BLK_BGIMG') && (
                    <div style={{
                      background: 'rgba(255, 77, 77, 0.1)',
                      border: '1px solid rgba(255, 77, 77, 0.3)',
                      borderRadius: '6px',
                      padding: '0.5rem',
                      color: '#ff4d4d',
                      fontSize: '0.8rem',
                      marginBottom: '1rem',
                      display: 'flex',
                      alignItems: 'center',
                      gap: '0.35rem'
                    }}>
                      <AlertTriangle size={14} /> Background layer (BLK_BGIMG) is missing! Click "Reset Bg" to recreate it.
                    </div>
                  )}
                  <div style={{ display: 'flex', gap: '0.5rem', marginBottom: '0.5rem' }}>
                    <button
                      className="btn btn-primary"
                      style={{ fontSize: '0.85rem', justifyContent: 'center', padding: '0.5rem', flex: 2 }}
                      onClick={handleAddBlock}
                    >
                      + Add New Layer
                    </button>
                    <button
                      className="btn btn-secondary"
                      style={{
                        fontSize: '0.85rem',
                        justifyContent: 'center',
                        padding: '0.5rem',
                        flex: 1,
                        borderColor: 'var(--accent)',
                        color: 'var(--accent)',
                        background: 'rgba(170, 59, 255, 0.05)'
                      }}
                      onClick={handleResetBackground}
                      title="Restore default background layer (466x466) and reset screen resolution"
                    >
                      Reset Bg
                    </button>
                  </div>
                  <div style={{ display: 'flex', gap: '0.5rem', marginBottom: '1rem' }}>
                    <button
                      className="btn btn-secondary"
                      style={{ fontSize: '0.85rem', justifyContent: 'center', padding: '0.5rem', flex: 1 }}
                      onClick={() => setIsPresetsOpen(true)}
                      title="Add a hand, battery, weather or animation extracted from real dials"
                    >
                      📦 Presets
                    </button>
                    <button
                      className="btn btn-secondary"
                      style={{ fontSize: '0.85rem', justifyContent: 'center', padding: '0.5rem', flex: 1 }}
                      onClick={() => setIsHandModalOpen(true)}
                      title="Generate a matching hour/minute/second analog hand set"
                    >
                      🕐 Hand Builder
                    </button>
                  </div>
                  {dialData.metadata.blocks.map((block: any, idx: number) => (
                    <div 
                      key={idx} 
                      className={`block-row-card ${selectedBlockIndex === idx ? 'active' : ''}`}
                      onClick={() => setSelectedBlockIndex(idx)}
                      style={{ 
                        cursor: 'pointer',
                        borderColor: selectedBlockIndex === idx ? 'var(--accent)' : 'var(--glass-border)',
                        background: selectedBlockIndex === idx ? 'rgba(170, 59, 255, 0.05)' : 'rgba(255, 255, 255, 0.01)'
                      }}
                    >
                      <div className="block-row-left">
                        <span className="block-row-type">{block.type}</span>
                        <span className="block-row-fname" style={{ fontSize: '10px' }}>{block.fname || 'No asset'}</span>
                      </div>
                      
                      {/* Layer order adjustments & Lock */}
                      <div style={{ display: 'flex', gap: '0.4rem', alignItems: 'center' }} onClick={(e) => e.stopPropagation()}>
                        <button 
                          onClick={() => handleUpdateBlock(idx, { locked: !block.locked })}
                          style={{
                            background: 'transparent',
                            border: 'none',
                            color: block.locked ? 'var(--accent)' : 'var(--text-muted)',
                            cursor: 'pointer',
                            padding: '0.2rem',
                            display: 'flex',
                            alignItems: 'center',
                          }}
                          title={block.locked ? "Unlock Layer" : "Lock Layer"}
                        >
                          {block.locked ? <Lock size={14} /> : <Unlock size={14} />}
                        </button>
                        <button 
                          disabled={idx === 0 || block.type === 'BLK_BGIMG'} 
                          onClick={() => handleMoveBlock(idx, 'up')}
                          style={{
                            background: 'transparent',
                            border: 'none',
                            color: idx === 0 || block.type === 'BLK_BGIMG' ? 'var(--text-muted)' : 'var(--text-secondary)',
                            cursor: idx === 0 || block.type === 'BLK_BGIMG' ? 'not-allowed' : 'pointer',
                            padding: '0.2rem'
                          }}
                          title="Bring Layer Forward"
                        >
                          <ArrowUp size={14} />
                        </button>
                        <button 
                          disabled={idx === dialData.metadata.blocks.length - 1} 
                          onClick={() => handleMoveBlock(idx, 'down')}
                          style={{
                            background: 'transparent',
                            border: 'none',
                            color: idx === dialData.metadata.blocks.length - 1 ? 'var(--text-muted)' : 'var(--text-secondary)',
                            cursor: idx === dialData.metadata.blocks.length - 1 ? 'not-allowed' : 'pointer',
                            padding: '0.2rem'
                          }}
                          title="Send Layer Backward"
                        >
                          <ArrowDown size={14} />
                        </button>
                      </div>
                    </div>
                  ))}
                </div>
              </div>

            </div>

          </div>

          {/* Row 2: Console logs & Asset Sheet preview */}
          <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '2rem' }}>
            
            {/* Logs panel */}
            <div className="glass-panel">
              <div className="panel-header">
                <h3>Terminal Output</h3>
              </div>
              <div className="panel-body">
                <div className="console-logs" style={{ maxHeight: '250px' }}>
                  {consoleLogs}
                </div>
              </div>
            </div>

            {/* Extracted Image Sheets */}
            <div className="glass-panel">
              <div className="panel-header">
                <h3>Extracted Image Sheets</h3>
              </div>
              <div className="panel-body" style={{ maxHeight: '280px', overflowY: 'auto' }}>
                <div className="assets-grid" style={{ gridTemplateColumns: '1fr' }}>
                  {dialData.metadata.blocks.map((block: any, idx: number) => {
                    const imgSrc = dialData.images[block.fname];
                    if (!imgSrc) return null;
                    
                    return (
                      <div 
                        key={idx} 
                        className="glass-panel asset-card" 
                        style={{ 
                          flexDirection: 'row', 
                          height: '90px', 
                          cursor: 'pointer',
                          borderColor: selectedBlockIndex === idx ? 'var(--accent)' : 'var(--glass-border)'
                        }}
                        onClick={() => setSelectedBlockIndex(idx)}
                      >
                        <div className="asset-card-preview" style={{ width: '90px', height: '100%', borderBottom: 'none', borderRight: '1px solid var(--glass-border)' }}>
                          <img src={imgSrc} alt={block.fname} className="asset-img" />
                        </div>
                        <div className="asset-card-details" style={{ padding: '0.5rem 1rem', justifyContent: 'center' }}>
                          <h4 className="asset-title" style={{ fontSize: '0.85rem' }}>{block.fname}</h4>
                          <div className="asset-badge-row" style={{ marginTop: '0.25rem' }}>
                            <span className="badge accent" style={{ fontSize: '10px' }}>{block.type}</span>
                            <span className="badge" style={{ fontSize: '10px' }}>{block.width}x{block.height} ({block.frms} f)</span>
                          </div>
                        </div>
                      </div>
                    );
                  })}
                </div>
              </div>
            </div>

          </div>

        </div>
      )}
      {/* Font Sheet Generator Modal */}
      <FontGenerator 
        isOpen={isFontModalOpen}
        onClose={() => setIsFontModalOpen(false)}
        onApply={handleApplyFontSheet}
        selectedBlockType={selectedBlock?.type || ''}
        initialFontConfig={selectedBlock?.fontConfig}
        initialFrms={selectedBlock?.frms}
      />
      {/* Weather Icon Sheet Generator Modal */}
      <WeatherGenerator 
        isOpen={isWeatherModalOpen}
        onClose={() => setIsWeatherModalOpen(false)}
        onApply={handleApplyWeatherSheet}
        initialFontConfig={selectedBlock?.fontConfig}
      />
      {/* Battery Icon Sheet Generator Modal */}
      <BatteryGenerator 
        isOpen={isBatteryModalOpen}
        onClose={() => setIsBatteryModalOpen(false)}
        onApply={handleApplyBatterySheet}
        initialFontConfig={selectedBlock?.fontConfig}
      />
      {/* Animation Slicer Modal */}
      <AnimationSlicer
        isOpen={activeAnimationFile !== null}
        file={activeAnimationFile}
        onClose={() => setActiveAnimationFile(null)}
        onApply={handleApplySlicedAnimation}
        initialWidth={selectedBlock?.width || 100}
        initialHeight={selectedBlock?.height || 100}
      />
      {/* Analog Hand Set Builder Modal */}
      <HandGenerator
        isOpen={isHandModalOpen}
        handType={
          selectedBlock?.type === 'BLK_ARMM' ? 'minute'
            : selectedBlock?.type === 'BLK_ARMS' ? 'second'
            : 'hour'
        }
        onClose={() => setIsHandModalOpen(false)}
        onApply={handleApplyHandSet}
        initialConfig={selectedBlock?.handConfig}
      />
      {/* Extracted Presets Library Modal */}
      <PresetsPanel
        isOpen={isPresetsOpen}
        onClose={() => setIsPresetsOpen(false)}
        onApply={handleApplyPreset}
        selectedBlockType={selectedBlock?.type}
      />
    </div>
  );
};

export default App;
