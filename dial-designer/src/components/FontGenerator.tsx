import React, { useState, useEffect, useRef, useMemo } from 'react';
import { 
  X, 
  Check, 
  Download, 
  Type, 
  Bold, 
  Italic, 
  Palette, 
  PaintBucket, 
  Paintbrush, 
  Sparkles, 
  MoveHorizontal, 
  MoveVertical, 
  ChevronsLeftRight, 
  Move,
  AlertTriangle
} from 'lucide-react';

interface FontGeneratorProps {
  isOpen: boolean;
  onClose: () => void;
  onApply: (
    generatedImgDataUrl: string, 
    width: number, 
    height: number, 
    frms: number, 
    alnx?: number,
    fontConfig?: any
  ) => void;
  selectedBlockType: string;
  initialFontConfig?: any;
  initialFrms?: number;
}

const normalizeColorForPicker = (colorStr: string): string => {
  if (!colorStr) return '#000000';
  let clean = colorStr.trim().toLowerCase();
  if (clean.startsWith('rgba')) {
    // Attempt to extract hex from rgba, or just return default black if semi-transparent
    return '#000000';
  }
  if (!clean.startsWith('#')) {
    clean = '#' + clean;
  }
  // Convert #fff to #ffffff
  if (clean.length === 4) {
    return '#' + clean[1] + clean[1] + clean[2] + clean[2] + clean[3] + clean[3];
  }
  // Ensure it's exactly 7 characters and valid hex
  if (/^#[0-9a-f]{6}$/.test(clean)) {
    return clean;
  }
  return '#000000';
};

const getMaximumTextWidth = (itemsList: string[], family: string, size: number, weight: string, italic: boolean): number => {
  if (typeof document === 'undefined') return 0;
  const canvas = document.createElement('canvas');
  const ctx = canvas.getContext('2d');
  if (!ctx) return 0;
  ctx.font = `${italic ? 'italic' : ''} ${weight} ${size}px ${family}`;
  let maxWidth = 0;
  itemsList.forEach(item => {
    const w = ctx.measureText(item).width;
    if (w > maxWidth) maxWidth = w;
  });
  return Math.ceil(maxWidth);
};

const AUTO_FIT_PADDING = 6;

const PRESET_LISTS = [
  { id: 'digits', name: 'Digits (0-9)', items: ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9'] },
  { id: 'weekdays_en', name: 'Week Days (EN)', items: ['SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT'] },
  { id: 'weekdays_es', name: 'Week Days (ES)', items: ['DOM', 'LUN', 'MAR', 'MIE', 'JUE', 'VIE', 'SAB'] },
  { id: 'months_en', name: 'Months (EN)', items: ['JAN', 'FEB', 'MAR', 'APR', 'MAY', 'JUN', 'JUL', 'AUG', 'SEP', 'OCT', 'NOV', 'DEC'] },
  { id: 'months_es', name: 'Months (ES)', items: ['ENE', 'FEB', 'MAR', 'ABR', 'MAY', 'JUN', 'JUL', 'AGO', 'SEP', 'OCT', 'NOV', 'DIC'] },
  { id: 'custom', name: 'Custom (One per line)', items: [] }
];

const MONTH_TEXT_PRESETS = [
  { id: 'months_en', name: 'English (JAN, FEB...)', items: ['JAN', 'FEB', 'MAR', 'APR', 'MAY', 'JUN', 'JUL', 'AUG', 'SEP', 'OCT', 'NOV', 'DEC'] },
  { id: 'months_es', name: 'Spanish (ENE, FEB...)', items: ['ENE', 'FEB', 'MAR', 'ABR', 'MAY', 'JUN', 'JUL', 'AGO', 'SEP', 'OCT', 'NOV', 'DIC'] },
  { id: 'months_fr', name: 'French (JAN, FEV...)', items: ['JAN', 'FEV', 'MAR', 'AVR', 'MAI', 'JUN', 'JUL', 'AOU', 'SEP', 'OCT', 'NOV', 'DEC'] },
  { id: 'months_it', name: 'Italian (GEN, FEB...)', items: ['GEN', 'FEB', 'MAR', 'APR', 'MAG', 'GIU', 'LUG', 'AGO', 'SET', 'OTT', 'NOV', 'DIC'] },
  { id: 'months_de', name: 'German (JAN, FEB...)', items: ['JAN', 'FEB', 'MAE', 'APR', 'MAI', 'JUN', 'JUL', 'AUG', 'SEP', 'OKT', 'NOV', 'DEZ'] },
  { id: 'months_pt', name: 'Portuguese (JAN, FEV...)', items: ['JAN', 'FEV', 'MAR', 'ABR', 'MAI', 'JUN', 'JUL', 'AGO', 'SET', 'OUT', 'NOV', 'DEZ'] },
  { id: 'custom_months', name: 'Custom Month Names', items: [] }
];

// Watch convention: frame 0 = Sunday (SUN-first). The original dials store
// weekday sheets as SUN, MON, ... SAT, so all presets must start on Sunday.
const WEEKDAY_PRESETS = [
  { id: 'weekdays_en', name: 'English (SUN, MON...)', items: ['SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT'] },
  { id: 'weekdays_es', name: 'Spanish (DOM, LUN...)', items: ['DOM', 'LUN', 'MAR', 'MIE', 'JUE', 'VIE', 'SAB'] },
  { id: 'weekdays_fr', name: 'French (DIM, LUN...)', items: ['DIM', 'LUN', 'MAR', 'MER', 'JEU', 'VEN', 'SAM'] },
  { id: 'weekdays_it', name: 'Italian (DOM, LUN...)', items: ['DOM', 'LUN', 'MAR', 'MER', 'GIO', 'VEN', 'SAB'] },
  { id: 'weekdays_de', name: 'German (SON, MON...)', items: ['SON', 'MON', 'DIE', 'MIT', 'DON', 'FRE', 'SAM'] },
  { id: 'weekdays_pt', name: 'Portuguese (DOM, SEG...)', items: ['DOM', 'SEG', 'TER', 'QUA', 'QUI', 'SEX', 'SAB'] },
  { id: 'custom_weekdays', name: 'Custom Weekdays', items: [] }
];

export const FontGenerator: React.FC<FontGeneratorProps> = ({
  isOpen,
  onClose,
  onApply,
  selectedBlockType,
  initialFontConfig,
  initialFrms
}) => {
  // Preset selection
  const [selectedPreset, setSelectedPreset] = useState('digits');
  
  // Custom texts for different block types to prevent overwriting
  const [customDigitsText, setCustomDigitsText] = useState('0\n1\n2\n3\n4\n5\n6\n7\n8\n9');
  const [customMonthsText, setCustomMonthsText] = useState('JAN\nFEB\nMAR\nAPR\nMAY\nJUN\nJUL\nAUG\nSEP\nOCT\nNOV\nDEC');
  const [customWeekdaysText, setCustomWeekdaysText] = useState('SUN\nMON\nTUE\nWED\nTHU\nFRI\nSAT');
  const [customGenericText, setCustomGenericText] = useState('0\n1\n2\n3\n4\n5\n6\n7\n8\n9');

  // Spacing between digits (ALNX) and live composite preview text
  const [digitSpacing, setDigitSpacing] = useState(0);
  const [sampleText, setSampleText] = useState('1208');

  // Font properties
  const [fontFamily, setFontFamily] = useState('Outfit');
  const fileInputRef = useRef<HTMLInputElement | null>(null);

  // Pre-configured open-source Google Fonts (OFL / copyright-free)
  const [availableFonts, setAvailableFonts] = useState<Array<{ name: string; family: string; source: 'google' | 'user' }>>([
    { name: 'Outfit', family: 'Outfit', source: 'google' },
    { name: 'Inter', family: 'Inter', source: 'google' },
    { name: 'Roboto', family: 'Roboto', source: 'google' },
    { name: 'Montserrat', family: 'Montserrat', source: 'google' },
    { name: 'Bebas Neue (Condensed)', family: 'Bebas Neue', source: 'google' },
    { name: 'Orbitron (Digital Clock)', family: 'Orbitron', source: 'google' },
    { name: 'Chakra Petch (Tech)', family: 'Chakra Petch', source: 'google' },
    { name: 'JetBrains Mono (Coding)', family: 'JetBrains Mono', source: 'google' },
    { name: 'Playfair Display (Elegant Serif)', family: 'Playfair Display', source: 'google' },
    { name: 'Rubik Mono One (Bold Digit)', family: 'Rubik Mono One', source: 'google' }
  ]);

  const [fontSize, setFontSize] = useState(32);
  const [fontWeight, setFontWeight] = useState('bold');
  const [isItalic, setIsItalic] = useState(false);
  
  // Sheet dimensions & style
  const [frameWidth, setFrameWidth] = useState(32);
  const [frameHeight, setFrameHeight] = useState(48);
  const [textColor, setTextColor] = useState('#ffffff');
  const [bgColor, setBgColor] = useState('transparent'); // transparent or HEX color

  // Outline/Stroke styling
  const [strokeColor, setStrokeColor] = useState('#000000');
  const [strokeWidth, setStrokeWidth] = useState(0);

  // Shadow/Glow styling
  const [shadowColor, setShadowColor] = useState('rgba(0,0,0,0.5)');
  const [shadowBlur, setShadowBlur] = useState(0);
  const [shadowOffsetX, setShadowOffsetX] = useState(0);
  const [shadowOffsetY, setShadowOffsetY] = useState(0);

  // Character spacing and cell offset shifts
  const [letterSpacing, setLetterSpacing] = useState(0);

  // The watch advances each digit by the block `width` (the alnx byte is an
  // alignment-mode enum, NOT inter-digit spacing). So digit spacing must be baked
  // into the per-digit cell/frame width, and the generated bitmap must be that wide.
  const cellWidth = Math.max(4, frameWidth + digitSpacing);
  const [textOffsetX, setTextOffsetX] = useState(0);
  const [textOffsetY, setTextOffsetY] = useState(0);

  // Generated Output
  const [generatedDataUrl, setGeneratedDataUrl] = useState<string | null>(null);

  const canvasRef = useRef<HTMLCanvasElement | null>(null);

  // Reset digit spacing on open; the persisted value (if any) is restored from
  // fontConfig below. The block's alnx byte is an alignment mode, NOT spacing,
  // so it must not seed digitSpacing.
  useEffect(() => {
    if (isOpen) {
      setDigitSpacing(0);
    }
  }, [isOpen]);

  // Derived month mode
  const isMonthBlock = selectedBlockType === 'BLK_MONTH';
  const monthMode = isMonthBlock 
    ? ((selectedPreset === 'digits' || selectedPreset === 'custom') ? 'numeric' : 'text')
    : 'numeric';

  // Load initialFontConfig when opening the modal
  useEffect(() => {
    if (isOpen) {
      if (initialFontConfig) {
        if (initialFontConfig.selectedPreset) setSelectedPreset(initialFontConfig.selectedPreset);
        if (initialFontConfig.customDigitsText) setCustomDigitsText(initialFontConfig.customDigitsText);
        if (initialFontConfig.customMonthsText) setCustomMonthsText(initialFontConfig.customMonthsText);
        if (initialFontConfig.customWeekdaysText) setCustomWeekdaysText(initialFontConfig.customWeekdaysText);
        if (initialFontConfig.customGenericText) setCustomGenericText(initialFontConfig.customGenericText);
        
        // Backward compatibility for old customText
        if (initialFontConfig.customText) {
          if (selectedBlockType === 'BLK_MONTH') {
            if (initialFontConfig.selectedPreset === 'custom' || initialFontConfig.selectedPreset === 'digits') {
              setCustomDigitsText(initialFontConfig.customText);
            } else {
              setCustomMonthsText(initialFontConfig.customText);
            }
          } else if (selectedBlockType === 'BLK_WEEKD') {
            setCustomWeekdaysText(initialFontConfig.customText);
          } else {
            setCustomDigitsText(initialFontConfig.customText);
            setCustomGenericText(initialFontConfig.customText);
          }
        }

        if (initialFontConfig.fontFamily) setFontFamily(initialFontConfig.fontFamily);
        if (initialFontConfig.fontSize) setFontSize(initialFontConfig.fontSize);
        if (initialFontConfig.fontWeight) setFontWeight(initialFontConfig.fontWeight);
        if (initialFontConfig.isItalic !== undefined) setIsItalic(initialFontConfig.isItalic);
        if (initialFontConfig.textColor) setTextColor(initialFontConfig.textColor);
        if (initialFontConfig.bgColor) setBgColor(initialFontConfig.bgColor);
        if (initialFontConfig.strokeColor) setStrokeColor(initialFontConfig.strokeColor);
        if (initialFontConfig.strokeWidth !== undefined) setStrokeWidth(initialFontConfig.strokeWidth);
        if (initialFontConfig.shadowColor) setShadowColor(initialFontConfig.shadowColor);
        if (initialFontConfig.shadowBlur !== undefined) setShadowBlur(initialFontConfig.shadowBlur);
        if (initialFontConfig.shadowOffsetX !== undefined) setShadowOffsetX(initialFontConfig.shadowOffsetX);
        if (initialFontConfig.shadowOffsetY !== undefined) setShadowOffsetY(initialFontConfig.shadowOffsetY);
        if (initialFontConfig.letterSpacing !== undefined) setLetterSpacing(initialFontConfig.letterSpacing);
        if (initialFontConfig.textOffsetX !== undefined) setTextOffsetX(initialFontConfig.textOffsetX);
        if (initialFontConfig.textOffsetY !== undefined) setTextOffsetY(initialFontConfig.textOffsetY);
        if (initialFontConfig.frameWidth !== undefined) setFrameWidth(initialFontConfig.frameWidth);
        if (initialFontConfig.frameHeight !== undefined) setFrameHeight(initialFontConfig.frameHeight);
        if (initialFontConfig.digitSpacing !== undefined) setDigitSpacing(initialFontConfig.digitSpacing);

        const preset = initialFontConfig.selectedPreset || '';
        if (selectedBlockType === 'BLK_WEEKD') {
          if (!preset.includes('week')) {
            setSelectedPreset('weekdays_en');
          }
        } else if (selectedBlockType === 'BLK_MONTH') {
          if (initialFrms === 12) {
            if (!preset.includes('month')) {
              setSelectedPreset('months_en');
            }
          } else if (preset.includes('week') || preset.includes('month')) {
            setSelectedPreset('digits');
          }
        } else if (preset.includes('week') || preset.includes('month')) {
          setSelectedPreset('digits');
        }
      } else {
        // No initialFontConfig - initialize based on block type
        if (selectedBlockType === 'BLK_WEEKD') {
          setSelectedPreset('weekdays_en');
        } else if (selectedBlockType === 'BLK_MONTH') {
          if (initialFrms === 12) {
            setSelectedPreset('months_en');
          } else {
            setSelectedPreset('digits');
          }
        } else {
          setSelectedPreset('digits');
        }
      }
    }
  }, [isOpen, initialFontConfig, selectedBlockType, initialFrms]);

  // Set default sampleText when preset changes
  useEffect(() => {
    if (selectedPreset.includes('week') || selectedPreset === 'custom_weekdays') {
      setSampleText('MON WED');
    } else if (selectedPreset.includes('month') || selectedPreset === 'custom_months') {
      setSampleText('JAN APR');
    } else {
      setSampleText('1208');
    }
  }, [selectedPreset]);

  const handleFontFileUpload = (e: React.ChangeEvent<HTMLInputElement>) => {
    if (!e.target.files || !e.target.files[0]) return;
    const file = e.target.files[0];
    const fontName = file.name.substring(0, file.name.lastIndexOf('.')) || file.name;
    const sanitizedFontName = fontName.replace(/[^a-zA-Z0-9]/g, '_');

    const reader = new FileReader();
    reader.onload = async (event) => {
      const buffer = event.target?.result as ArrayBuffer;
      try {
        const fontFace = new FontFace(sanitizedFontName, buffer);
        const loadedFace = await fontFace.load();
        document.fonts.add(loadedFace);
        
        setAvailableFonts(prev => [
          ...prev, 
          { name: `Uploaded: ${file.name}`, family: sanitizedFontName, source: 'user' }
        ]);
        setFontFamily(sanitizedFontName);
      } catch (err: any) {
        alert(`Failed to load font file: ${err.message || err}`);
      }
    };
    reader.readAsArrayBuffer(file);
  };

  // Retrieve current items list for a specific preset
  const getItemsListForPreset = (presetId: string): string[] => {
    // If it's weekdays
    if (selectedBlockType === 'BLK_WEEKD') {
      const preset = WEEKDAY_PRESETS.find(p => p.id === presetId);
      if (preset && preset.id !== 'custom_weekdays') {
        return preset.items;
      }
      return customWeekdaysText
        .split('\n')
        .map(item => item.trim().toUpperCase().substring(0, 3))
        .filter(Boolean);
    }

    // If it's month
    if (selectedBlockType === 'BLK_MONTH') {
      if (presetId === 'digits') {
        return PRESET_LISTS.find(p => p.id === 'digits')?.items || [];
      }
      if (presetId === 'custom') {
        return customDigitsText.split('\n').map(item => item.trim()).filter(Boolean);
      }
      
      const preset = MONTH_TEXT_PRESETS.find(p => p.id === presetId);
      if (preset && preset.id !== 'custom_months') {
        return preset.items;
      }
      return customMonthsText
        .split('\n')
        .map(item => item.trim().toUpperCase().substring(0, 3))
        .filter(Boolean);
    }

    // For other numeric layers
    const isNumericType = [
      'BLK_YEAR', 'BLK_DAY', 'BLK_HOUR', 'BLK_MIN', 'BLK_SEC', 
      'BLK_STEPS', 'BLK_PULS', 'BLK_CALOR', 'BLK_DIST', 'BLK_BATTN', 'BLK_TEMP'
    ].includes(selectedBlockType);

    if (isNumericType) {
      if (presetId === 'custom') {
        return customDigitsText.split('\n').map(item => item.trim()).filter(Boolean);
      }
      return PRESET_LISTS.find(p => p.id === 'digits')?.items || [];
    }

    // Fallback/Generic
    const preset = PRESET_LISTS.find(p => p.id === presetId);
    if (preset && preset.id !== 'custom') {
      return preset.items;
    }
    return customGenericText.split('\n').map(item => item.trim()).filter(Boolean);
  };

  const getItemsList = (): string[] => {
    return getItemsListForPreset(selectedPreset);
  };

  // Memoized maximum text width calculation
  const maxTextWidth = useMemo(() => {
    const items = getItemsList();
    if (items.length === 0) return 0;
    return getMaximumTextWidth(items, fontFamily, fontSize, fontWeight, isItalic);
  }, [selectedPreset, customDigitsText, customMonthsText, customWeekdaysText, customGenericText, fontFamily, fontSize, fontWeight, isItalic, selectedBlockType]);

  // Handle applied preset changes and adjust dimensions if needed
  const handlePresetChange = (newPreset: string) => {
    setSelectedPreset(newPreset);
    
    const items = getItemsListForPreset(newPreset);
    if (items.length > 0) {
      const maxW = getMaximumTextWidth(items, fontFamily, fontSize, fontWeight, isItalic);
      const maxChars = Math.max(...items.map(item => item.length));
      const spacingWidth = Math.max(0, (maxChars - 1) * letterSpacing);
      const paddedWidth = Math.ceil(maxW + spacingWidth + (AUTO_FIT_PADDING * 2));
      
      if (paddedWidth > frameWidth) {
        setFrameWidth(paddedWidth);
      }
    }
  };

  // Auto-expand frame width for multi-letter text on initial mount/switch to avoid clipping.
  useEffect(() => {
    if (!isOpen) return;
    const isWeekdayText = selectedBlockType === 'BLK_WEEKD';
    const isMonthText = selectedBlockType === 'BLK_MONTH' && monthMode === 'text';
    if (!isWeekdayText && !isMonthText) return;

    const items = getItemsList();
    if (items.length === 0) return;

    const maxW = getMaximumTextWidth(items, fontFamily, fontSize, fontWeight, isItalic);
    const maxChars = Math.max(...items.map(item => item.length));
    const spacingWidth = Math.max(0, (maxChars - 1) * letterSpacing);
    const paddedWidth = Math.ceil(maxW + spacingWidth + (AUTO_FIT_PADDING * 2));

    if (paddedWidth > frameWidth) {
      setFrameWidth(paddedWidth);
    }
  }, [
    isOpen,
    selectedBlockType,
    selectedPreset
  ]);

  // Generate Font Sheet on Canvas
  const generateSheet = () => {
    const items = getItemsList();
    if (items.length === 0) return;

    const canvas = canvasRef.current || document.createElement('canvas');
    canvas.width = cellWidth;
    canvas.height = frameHeight * items.length;
    
    const ctx = canvas.getContext('2d');
    if (!ctx) return;

    // Clear and set background
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    if (bgColor !== 'transparent') {
      ctx.fillStyle = bgColor;
      ctx.fillRect(0, 0, canvas.width, canvas.height);
    }

    // Configure text styling
    ctx.textAlign = 'center';
    ctx.textBaseline = 'middle';
    ctx.font = `${isItalic ? 'italic' : ''} ${fontWeight} ${fontSize}px ${fontFamily}`;

    // Configure modern letter spacing if browser supports it
    if ('letterSpacing' in ctx) {
      (ctx as any).letterSpacing = `${letterSpacing}px`;
    }

    // Configure shadow / glow
    if (shadowBlur > 0) {
      ctx.shadowColor = shadowColor;
      ctx.shadowBlur = shadowBlur;
      ctx.shadowOffsetX = shadowOffsetX;
      ctx.shadowOffsetY = shadowOffsetY;
    } else {
      ctx.shadowColor = 'transparent';
      ctx.shadowBlur = 0;
      ctx.shadowOffsetX = 0;
      ctx.shadowOffsetY = 0;
    }

    // Draw characters sequentially
    items.forEach((item, index) => {
      const startX = (cellWidth / 2) + textOffsetX;
      const startY = (index * frameHeight) + (frameHeight / 2) + textOffsetY;

      ctx.save();
      // Clip rendering to this cell's bounding box to prevent outlines or shadows bleeding into adjacent frames
      ctx.beginPath();
      ctx.rect(0, index * frameHeight, cellWidth, frameHeight);
      ctx.clip();

      // Draw stroke/outline first
      if (strokeWidth > 0) {
        ctx.strokeStyle = strokeColor;
        ctx.lineWidth = strokeWidth * 2;
        ctx.lineJoin = 'round';
        ctx.strokeText(item, startX, startY);
      }

      // Draw fill text on top
      ctx.fillStyle = textColor;
      ctx.fillText(item, startX, startY);

      ctx.restore();
    });

    const dataUrl = canvas.toDataURL('image/png');
    setGeneratedDataUrl(dataUrl);
  };

  // Trigger generator whenever any styling input changes
  useEffect(() => {
    if (isOpen) {
      generateSheet();
    }
  }, [
    isOpen,
    selectedPreset,
    customDigitsText,
    customMonthsText,
    customWeekdaysText,
    customGenericText,
    fontFamily,
    fontSize,
    fontWeight,
    isItalic,
    frameWidth,
    frameHeight,
    textColor,
    bgColor,
    strokeColor,
    strokeWidth,
    shadowColor,
    shadowBlur,
    shadowOffsetX,
    shadowOffsetY,
    letterSpacing,
    digitSpacing,
    textOffsetX,
    textOffsetY
  ]);

  const getSampleSlices = (text: string, itemsList: string[]) => {
    const isMultiCharPreset = itemsList.some(item => item.length > 1);
    if (isMultiCharPreset) {
      const words = text.split(/[\s,]+/).filter(Boolean);
      return words.map(word => {
        const idx = itemsList.findIndex(item => item.toLowerCase() === word.toLowerCase());
        return { text: word, index: idx };
      });
    } else {
      return text.split('').map(char => {
        const idx = itemsList.findIndex(item => item.toLowerCase() === char.toLowerCase());
        return { text: char, index: idx };
      });
    }
  };

  if (!isOpen) return null;

  const items = getItemsList();

  // Validation checks
  let validationMessage = '';
  let isValidFrameCount = true;

  if (selectedBlockType === 'BLK_WEEKD') {
    if (items.length !== 7) {
      validationMessage = `Weekdays layer expects exactly 7 frames. Current: ${items.length}`;
      isValidFrameCount = false;
    }
  } else if (selectedBlockType === 'BLK_MONTH') {
    if (monthMode === 'numeric') {
      if (items.length !== 10) {
        validationMessage = `Numeric month layer expects exactly 10 frames (0-9). Current: ${items.length}`;
        isValidFrameCount = false;
      }
    } else {
      if (items.length !== 12) {
        validationMessage = `Text month layer expects exactly 12 frames (JAN-DEC). Current: ${items.length}`;
        isValidFrameCount = false;
      }
    }
  } else {
    // Other digit layers
    if (items.length !== 10) {
      validationMessage = `Numeric layers expect exactly 10 frames (0-9). Current: ${items.length}`;
      isValidFrameCount = false;
    }
  }

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
            <Type size={20} color="var(--accent-hover)" />
            <h3 style={{ margin: 0, fontSize: '1.25rem', fontWeight: 800 }}>Font Sheet Generator</h3>
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
            
            {/* Custom Preset Section based on Block Type */}
            {selectedBlockType === 'BLK_MONTH' ? (
              <div style={{ display: 'flex', flexDirection: 'column', gap: '0.85rem' }}>
                {/* Mode Selector Tab buttons */}
                <div style={{ display: 'flex', flexDirection: 'column', gap: '0.35rem' }}>
                  <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600 }}>
                    MONTH FORMAT TYPE
                  </label>
                  <div style={{ display: 'flex', gap: '0.5rem', background: 'var(--bg-secondary)', padding: '4px', borderRadius: '8px', border: '1px solid var(--glass-border)' }}>
                    <button
                      type="button"
                      onClick={() => handlePresetChange('digits')}
                      style={{
                        flex: 1,
                        padding: '0.5rem',
                        borderRadius: '6px',
                        border: 'none',
                        background: monthMode === 'numeric' ? 'var(--accent)' : 'transparent',
                        color: monthMode === 'numeric' ? '#ffffff' : 'var(--text-secondary)',
                        fontWeight: 600,
                        cursor: 'pointer',
                        transition: 'all 0.2s'
                      }}
                    >
                      Numeric (0-9)
                    </button>
                    <button
                      type="button"
                      onClick={() => handlePresetChange('months_en')}
                      style={{
                        flex: 1,
                        padding: '0.5rem',
                        borderRadius: '6px',
                        border: 'none',
                        background: monthMode === 'text' ? 'var(--accent)' : 'transparent',
                        color: monthMode === 'text' ? '#ffffff' : 'var(--text-secondary)',
                        fontWeight: 600,
                        cursor: 'pointer',
                        transition: 'all 0.2s'
                      }}
                    >
                      Text (Month Names)
                    </button>
                  </div>
                </div>

                {/* Preset Sub-Selector depending on mode */}
                {monthMode === 'numeric' ? (
                  <div style={{ display: 'flex', flexDirection: 'column', gap: '0.35rem' }}>
                    <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600 }}>
                      NUMERIC PRESET
                    </label>
                    <select
                      value={selectedPreset}
                      onChange={(e) => handlePresetChange(e.target.value)}
                      style={{
                        background: 'var(--bg-secondary)',
                        border: '1px solid var(--glass-border)',
                        color: 'var(--text-primary)',
                        padding: '0.5rem',
                        borderRadius: '6px',
                        fontFamily: 'var(--font-sans)',
                      }}
                    >
                      <option value="digits">Digits (0-9)</option>
                      <option value="custom">Custom Digits</option>
                    </select>
                  </div>
                ) : (
                  <div style={{ display: 'flex', flexDirection: 'column', gap: '0.35rem' }}>
                    <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600 }}>
                      LANGUAGE PRESET (3 LETTERS)
                    </label>
                    <select
                      value={selectedPreset}
                      onChange={(e) => handlePresetChange(e.target.value)}
                      style={{
                        background: 'var(--bg-secondary)',
                        border: '1px solid var(--glass-border)',
                        color: 'var(--text-primary)',
                        padding: '0.5rem',
                        borderRadius: '6px',
                        fontFamily: 'var(--font-sans)',
                      }}
                    >
                      {MONTH_TEXT_PRESETS.map(p => (
                        <option key={p.id} value={p.id}>{p.name}</option>
                      ))}
                    </select>
                  </div>
                )}
              </div>
            ) : selectedBlockType === 'BLK_WEEKD' ? (
              <div style={{ display: 'flex', flexDirection: 'column', gap: '0.35rem' }}>
                <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600, display: 'flex', alignItems: 'center', gap: '0.35rem' }}>
                  <Type size={14} /> WEEKDAY PRESET (3 LETTERS)
                </label>
                <select
                  value={selectedPreset}
                  onChange={(e) => handlePresetChange(e.target.value)}
                  style={{
                    background: 'var(--bg-secondary)',
                    border: '1px solid var(--glass-border)',
                    color: 'var(--text-primary)',
                    padding: '0.5rem',
                    borderRadius: '6px',
                    fontFamily: 'var(--font-sans)',
                  }}
                >
                  {WEEKDAY_PRESETS.map(p => (
                    <option key={p.id} value={p.id}>{p.name}</option>
                  ))}
                </select>
              </div>
            ) : (
              /* Other numeric block types */
              <div style={{ display: 'flex', flexDirection: 'column', gap: '0.35rem' }}>
                <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600, display: 'flex', alignItems: 'center', gap: '0.35rem' }}>
                  <Type size={14} /> CHARACTER SET PRESET
                </label>
                <select
                  value={selectedPreset}
                  onChange={(e) => handlePresetChange(e.target.value)}
                  style={{
                    background: 'var(--bg-secondary)',
                    border: '1px solid var(--glass-border)',
                    color: 'var(--text-primary)',
                    padding: '0.5rem',
                    borderRadius: '6px',
                    fontFamily: 'var(--font-sans)',
                  }}
                >
                  <option value="digits">Digits (0-9)</option>
                  <option value="custom">Custom (One per line)</option>
                </select>
              </div>
            )}

            {/* Custom Input text areas depending on preset selection */}
            {selectedPreset === 'custom' && (
              <div style={{ display: 'flex', flexDirection: 'column', gap: '0.35rem' }}>
                <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600, display: 'flex', alignItems: 'center', gap: '0.35rem' }}>
                  <Type size={14} /> CUSTOM DIGITS (ONE PER LINE - EXPECT 10 VALUES)
                </label>
                <textarea 
                  rows={6}
                  value={customDigitsText}
                  onChange={(e) => setCustomDigitsText(e.target.value)}
                  style={{
                    background: 'var(--bg-secondary)',
                    border: '1px solid var(--glass-border)',
                    color: 'var(--text-primary)',
                    padding: '0.5rem',
                    borderRadius: '6px',
                    fontFamily: 'var(--font-mono)',
                    fontSize: '0.85rem'
                  }}
                  placeholder="0&#10;1&#10;2&#10;3&#10;..."
                />
              </div>
            )}

            {selectedPreset === 'custom_months' && (
              <div style={{ display: 'flex', flexDirection: 'column', gap: '0.35rem' }}>
                <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600, display: 'flex', alignItems: 'center', gap: '0.35rem' }}>
                  <Type size={14} /> CUSTOM MONTH NAMES (ONE PER LINE - EXPECT 12 VALUES)
                </label>
                <textarea 
                  rows={8}
                  value={customMonthsText}
                  onChange={(e) => setCustomMonthsText(e.target.value)}
                  style={{
                    background: 'var(--bg-secondary)',
                    border: '1px solid var(--glass-border)',
                    color: 'var(--text-primary)',
                    padding: '0.5rem',
                    borderRadius: '6px',
                    fontFamily: 'var(--font-mono)',
                    fontSize: '0.85rem'
                  }}
                  placeholder="JAN&#10;FEB&#10;MAR&#10;..."
                />
                <span style={{ fontSize: '0.75rem', color: 'var(--text-muted)' }}>
                  Values will automatically be capitalized and abbreviated to 3 letters.
                </span>
              </div>
            )}

            {selectedPreset === 'custom_weekdays' && (
              <div style={{ display: 'flex', flexDirection: 'column', gap: '0.35rem' }}>
                <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600, display: 'flex', alignItems: 'center', gap: '0.35rem' }}>
                  <Type size={14} /> CUSTOM WEEKDAY NAMES (ONE PER LINE - EXPECT 7 VALUES)
                </label>
                <textarea 
                  rows={8}
                  value={customWeekdaysText}
                  onChange={(e) => setCustomWeekdaysText(e.target.value)}
                  style={{
                    background: 'var(--bg-secondary)',
                    border: '1px solid var(--glass-border)',
                    color: 'var(--text-primary)',
                    padding: '0.5rem',
                    borderRadius: '6px',
                    fontFamily: 'var(--font-mono)',
                    fontSize: '0.85rem'
                  }}
                  placeholder="MON&#10;TUE&#10;WED&#10;..."
                />
                <span style={{ fontSize: '0.75rem', color: 'var(--text-muted)' }}>
                  Values will automatically be capitalized and abbreviated to 3 letters.
                </span>
              </div>
            )}

            {/* Validation Error Message */}
            {validationMessage && (
              <div 
                style={{
                  background: 'rgba(239, 68, 68, 0.1)',
                  border: '1px solid rgba(239, 68, 68, 0.3)',
                  color: '#f87171',
                  padding: '0.75rem',
                  borderRadius: '6px',
                  fontSize: '0.8rem',
                  fontWeight: 500,
                  display: 'flex',
                  alignItems: 'center',
                  gap: '0.5rem',
                  marginTop: '0.25rem'
                }}
              >
                <span>⚠️ {validationMessage}</span>
              </div>
            )}

            {/* Font Selection & Upload */}
            <div style={{ display: 'flex', flexDirection: 'column', gap: '0.5rem' }}>
              <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600, display: 'flex', alignItems: 'center', gap: '0.35rem' }}>
                <Type size={14} /> SELECT TYPOGRAPHY
              </label>
              <div style={{ display: 'flex', gap: '0.5rem' }}>
                <select 
                  value={availableFonts.some(f => f.family === fontFamily) ? fontFamily : 'custom'}
                  onChange={(e) => {
                    const val = e.target.value;
                    if (val !== 'custom') {
                      setFontFamily(val);
                    }
                  }}
                  style={{
                    background: 'var(--bg-secondary)',
                    border: '1px solid var(--glass-border)',
                    color: 'var(--text-primary)',
                    padding: '0.5rem',
                    borderRadius: '6px',
                    fontFamily: 'var(--font-sans)',
                    flexGrow: 1
                  }}
                >
                  {availableFonts.map(f => (
                    <option key={f.family} value={f.family}>{f.name}</option>
                  ))}
                  <option value="custom">-- Custom System Font --</option>
                </select>
                
                <input 
                  type="file"
                  ref={fileInputRef}
                  style={{ display: 'none' }}
                  accept=".ttf,.otf,.woff,.woff2"
                  onChange={handleFontFileUpload}
                />
                
                <button 
                  className="btn btn-secondary"
                  style={{ padding: '0.5rem', fontSize: '0.8rem', whiteSpace: 'nowrap' }}
                  onClick={() => fileInputRef.current?.click()}
                >
                  Upload Font File
                </button>
              </div>

              {/* Custom manual input if 'custom' is selected or custom font is active */}
              {(!availableFonts.some(f => f.family === fontFamily) || fontFamily === 'custom') && (
                <div style={{ display: 'flex', flexDirection: 'column', gap: '0.35rem', marginTop: '0.25rem' }}>
                  <input 
                    type="text"
                    value={fontFamily === 'custom' ? '' : fontFamily}
                    onChange={(e) => setFontFamily(e.target.value)}
                    style={{
                      background: 'var(--bg-secondary)',
                      border: '1px solid var(--glass-border)',
                      color: 'var(--text-primary)',
                      padding: '0.5rem',
                      borderRadius: '6px',
                      fontFamily: 'var(--font-mono)',
                      fontSize: '0.85rem'
                    }}
                    placeholder="Enter system font name (e.g. Arial, Impact)"
                  />
                </div>
              )}
            </div>

            <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '1rem' }}>
              <div style={{ display: 'flex', flexDirection: 'column', gap: '0.35rem' }}>
                <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600, display: 'flex', alignItems: 'center', gap: '0.35rem' }}>
                  <Move size={14} /> FONT SIZE (PX)
                </label>
                <input 
                  type="number"
                  min="8"
                  max="120"
                  value={fontSize}
                  onChange={(e) => setFontSize(parseInt(e.target.value) || 12)}
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
                  <Bold size={14} /> WEIGHT
                </label>
                <select 
                  value={fontWeight}
                  onChange={(e) => setFontWeight(e.target.value)}
                  style={{
                    background: 'var(--bg-secondary)',
                    border: '1px solid var(--glass-border)',
                    color: 'var(--text-primary)',
                    padding: '0.5rem',
                    borderRadius: '6px',
                    fontFamily: 'var(--font-sans)',
                  }}
                >
                  <option value="normal">Normal</option>
                  <option value="500">Medium</option>
                  <option value="bold">Bold</option>
                  <option value="800">Extra Bold</option>
                </select>
              </div>
            </div>

            {/* Frame Dimension properties */}
            <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '1rem' }}>
              <div style={{ display: 'flex', flexDirection: 'column', gap: '0.35rem' }}>
                <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600, display: 'flex', alignItems: 'center', gap: '0.35rem' }}>
                  <MoveHorizontal size={14} /> FRAME WIDTH
                </label>
                <input 
                  type="number"
                  min="4"
                  value={frameWidth}
                  onChange={(e) => setFrameWidth(parseInt(e.target.value) || 8)}
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
                  min="4"
                  value={frameHeight}
                  onChange={(e) => setFrameHeight(parseInt(e.target.value) || 8)}
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

            {maxTextWidth > frameWidth && (
              <div style={{
                padding: '0.75rem',
                background: 'rgba(239, 68, 68, 0.1)',
                border: '1px solid rgba(239, 68, 68, 0.25)',
                borderRadius: '8px',
                color: '#f87171',
                fontSize: '0.85rem',
                display: 'flex',
                flexDirection: 'column',
                gap: '0.5rem',
                marginTop: '-0.25rem'
              }}>
                <div style={{ display: 'flex', alignItems: 'center', gap: '0.35rem', fontWeight: 600, color: '#f87171' }}>
                  <AlertTriangle size={16} /> Text clipping warning!
                </div>
                <div>
                  The max text width is <strong>{maxTextWidth}px</strong>, but frame width is <strong>{frameWidth}px</strong>. Some text will be clipped.
                </div>
                <button
                  type="button"
                  onClick={() => setFrameWidth(maxTextWidth + 16)}
                  style={{
                    background: 'var(--accent)',
                    color: '#ffffff',
                    border: 'none',
                    padding: '0.35rem 0.75rem',
                    borderRadius: '6px',
                    cursor: 'pointer',
                    fontWeight: 600,
                    fontSize: '0.8rem',
                    alignSelf: 'flex-start',
                    transition: 'opacity 0.2s'
                  }}
                  onMouseEnter={(e) => (e.currentTarget.style.opacity = '0.9')}
                  onMouseLeave={(e) => (e.currentTarget.style.opacity = '1')}
                >
                  Auto-fit Width ({maxTextWidth + 16}px)
                </button>
              </div>
            )}

            {/* Colors picker */}
            <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '1rem' }}>
              <div style={{ display: 'flex', flexDirection: 'column', gap: '0.35rem' }}>
                <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600, display: 'flex', alignItems: 'center', gap: '0.35rem' }}>
                  <Palette size={14} /> TEXT COLOR
                </label>
                <div style={{ display: 'flex', gap: '0.5rem', alignItems: 'center' }}>
                  <input 
                    type="color"
                    value={normalizeColorForPicker(textColor)}
                    onChange={(e) => setTextColor(e.target.value)}
                    style={{
                      border: 'none',
                      background: 'none',
                      width: '32px',
                      height: '32px',
                      cursor: 'pointer',
                      colorScheme: 'light'
                    }}
                  />
                  <input 
                    type="text" 
                    value={textColor}
                    onChange={(e) => setTextColor(e.target.value)}
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
                        cursor: 'pointer',
                        colorScheme: 'light'
                      }}
                    />
                  )}
                </div>
              </div>
            </div>

            {/* Italic toggle */}
            <div style={{ display: 'flex', alignItems: 'center', gap: '0.5rem', marginTop: '0.25rem' }}>
              <input 
                type="checkbox" 
                id="italic-text" 
                checked={isItalic}
                onChange={(e) => setIsItalic(e.target.checked)}
                style={{ accentColor: 'var(--accent)' }}
              />
              <label htmlFor="italic-text" style={{ fontSize: '0.85rem', color: 'var(--text-secondary)', cursor: 'pointer', display: 'flex', alignItems: 'center', gap: '0.35rem' }}>
                <Italic size={14} /> Italic Text Style
              </label>
            </div>

            {/* Outline (Stroke) Settings */}
            <div style={{ borderTop: '1px solid var(--glass-border)', paddingTop: '1.25rem', display: 'flex', flexDirection: 'column', gap: '1rem' }}>
              <h4 style={{ margin: 0, fontSize: '0.85rem', color: 'var(--text-secondary)', fontWeight: 700, letterSpacing: '0.5px', display: 'flex', alignItems: 'center', gap: '0.35rem' }}>
                <Paintbrush size={14} /> OUTLINE / CONTORNO
              </h4>
              
              <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '1rem' }}>
                <div style={{ display: 'flex', flexDirection: 'column', gap: '0.35rem' }}>
                  <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600, display: 'flex', alignItems: 'center', gap: '0.35rem' }}>
                    <Palette size={14} /> OUTLINE COLOR
                  </label>
                  <div style={{ display: 'flex', gap: '0.5rem', alignItems: 'center' }}>
                    <input 
                      type="color"
                      value={normalizeColorForPicker(strokeColor)}
                      onChange={(e) => setStrokeColor(e.target.value)}
                      style={{
                        border: 'none',
                        background: 'none',
                        width: '32px',
                        height: '32px',
                        cursor: 'pointer',
                        colorScheme: 'light'
                      }}
                    />
                    <input 
                      type="text" 
                      value={strokeColor}
                      onChange={(e) => setStrokeColor(e.target.value)}
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
                    <Move size={14} /> OUTLINE THICKNESS
                  </label>
                  <input 
                    type="number"
                    min="0"
                    max="15"
                    value={strokeWidth}
                    onChange={(e) => setStrokeWidth(Math.max(0, parseInt(e.target.value) || 0))}
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
                        cursor: 'pointer',
                        colorScheme: 'light'
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
                    max="50"
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
                    <MoveHorizontal size={14} /> OFFSET X (DESVIACIÓN X)
                  </label>
                  <input 
                    type="number"
                    min="-50"
                    max="50"
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
                    <MoveVertical size={14} /> OFFSET Y (DESVIACIÓN Y)
                  </label>
                  <input 
                    type="number"
                    min="-50"
                    max="50"
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

            {/* Spacing & Alignment Offsets */}
            <div style={{ borderTop: '1px solid var(--glass-border)', paddingTop: '1.25rem', display: 'flex', flexDirection: 'column', gap: '1rem' }}>
              <h4 style={{ margin: 0, fontSize: '0.85rem', color: 'var(--text-secondary)', fontWeight: 700, letterSpacing: '0.5px', display: 'flex', alignItems: 'center', gap: '0.35rem' }}>
                <ChevronsLeftRight size={14} /> ALIGNMENT & SPACING (ESPACIADO Y AJUSTE)
              </h4>
              
              <div style={{ display: 'flex', flexDirection: 'column', gap: '0.35rem' }}>
                <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600, display: 'flex', alignItems: 'center', gap: '0.35rem' }}>
                  <ChevronsLeftRight size={14} /> LETTER SPACING (ESPACIO LETRAS)
                </label>
                <input 
                  type="number"
                  min="-20"
                  max="50"
                  value={letterSpacing}
                  onChange={(e) => setLetterSpacing(parseInt(e.target.value) || 0)}
                  style={{
                    background: 'var(--bg-secondary)',
                    border: '1px solid var(--glass-border)',
                    color: 'var(--text-primary)',
                    padding: '0.5rem',
                    borderRadius: '6px',
                    fontFamily: 'var(--font-mono)',
                  }}
                  title="Spacing between letters within a single cell (e.g. MON)"
                />
              </div>

              <div style={{ display: 'flex', flexDirection: 'column', gap: '0.35rem' }}>
                <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600, display: 'flex', alignItems: 'center', gap: '0.35rem' }}>
                  <ChevronsLeftRight size={14} /> DIGIT SPACING (SEPARACIÓN — se suma al ancho de cada dígito)
                </label>
                <div style={{ display: 'flex', gap: '0.5rem', alignItems: 'center' }}>
                  <input 
                    type="range"
                    min="-50"
                    max="50"
                    value={digitSpacing}
                    onChange={(e) => setDigitSpacing(parseInt(e.target.value) || 0)}
                    style={{ flexGrow: 1, accentColor: 'var(--accent)', cursor: 'pointer' }}
                  />
                  <input 
                    type="number" 
                    min="-50"
                    max="50"
                    value={digitSpacing}
                    onChange={(e) => setDigitSpacing(parseInt(e.target.value) || 0)}
                    style={{
                      background: 'var(--bg-secondary)',
                      border: '1px solid var(--glass-border)',
                      color: 'var(--text-primary)',
                      padding: '0.5rem',
                      borderRadius: '6px',
                      fontFamily: 'var(--font-mono)',
                      width: '70px'
                    }}
                  />
                </div>
              </div>

              <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '1rem' }}>
                <div style={{ display: 'flex', flexDirection: 'column', gap: '0.35rem' }}>
                  <label style={{ fontSize: '0.8rem', color: 'var(--text-muted)', fontWeight: 600, display: 'flex', alignItems: 'center', gap: '0.35rem' }}>
                    <MoveHorizontal size={14} /> CELL SHIFT X (AJUSTE X)
                  </label>
                  <input 
                    type="number"
                    min="-50"
                    max="50"
                    value={textOffsetX}
                    onChange={(e) => setTextOffsetX(parseInt(e.target.value) || 0)}
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
                    <MoveVertical size={14} /> CELL SHIFT Y (AJUSTE Y)
                  </label>
                  <input 
                    type="number"
                    min="-50"
                    max="50"
                    value={textOffsetY}
                    onChange={(e) => setTextOffsetY(parseInt(e.target.value) || 0)}
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
              SHEET AND SLICE PREVIEW
            </div>

            {/* Live Digit Spacing Preview (Muestra de Dígitos Juntos) */}
            {generatedDataUrl && (
              <div style={{ display: 'flex', width: '100%', flexDirection: 'column', gap: '0.6rem', borderBottom: '1px solid var(--glass-border)', paddingBottom: '1.25rem' }}>
                <span style={{ fontSize: '0.75rem', color: 'var(--text-muted)', fontWeight: 600 }}>LIVE DIGIT SPACING PREVIEW</span>
                
                {/* Input for preview text */}
                <div style={{ display: 'flex', gap: '0.5rem', alignItems: 'center' }}>
                  <input 
                    type="text"
                    value={sampleText}
                    onChange={(e) => setSampleText(e.target.value)}
                    placeholder="Enter sample digits (e.g. 12:08)"
                    style={{
                      background: 'var(--bg-secondary)',
                      border: '1px solid var(--glass-border)',
                      color: 'var(--text-primary)',
                      padding: '0.45rem 0.6rem',
                      borderRadius: '6px',
                      fontFamily: 'var(--font-sans)',
                      fontSize: '0.85rem',
                      flexGrow: 1
                    }}
                  />
                  <button 
                    className="btn btn-secondary" 
                    style={{ padding: '0.45rem 0.75rem', fontSize: '0.8rem' }}
                    onClick={() => setSampleText(selectedPreset.includes('week') ? 'MON WED' : '1208')}
                  >
                    Reset
                  </button>
                </div>

                {/* Slices Rendered Side by Side */}
                <div 
                  style={{
                    display: 'flex',
                    justifyContent: 'center',
                    alignItems: 'center',
                    background: 'rgba(0,0,0,0.4)',
                    padding: '1.5rem',
                    borderRadius: '8px',
                    border: '1px solid var(--glass-border)',
                    minHeight: `${frameHeight + 20}px`,
                    overflowX: 'auto'
                  }}
                >
                  <div style={{ display: 'flex', alignItems: 'center' }}>
                    {getSampleSlices(sampleText, items).map((slice, i) => {
                      const isFound = slice.index !== -1;
                      
                      return (
                        <div 
                          key={i}
                          style={{
                            width: `${cellWidth}px`,
                            height: `${frameHeight}px`,
                            flexShrink: 0,
                            ...(isFound ? {
                              backgroundImage: `url(${generatedDataUrl})`,
                              backgroundPosition: `0px -${slice.index * frameHeight}px`,
                              backgroundSize: `${cellWidth}px ${frameHeight * items.length}px`,
                              imageRendering: 'pixelated'
                            } : {
                              display: 'flex',
                              alignItems: 'center',
                              justifyContent: 'center',
                              color: textColor,
                              fontFamily: fontFamily,
                              fontSize: `${fontSize}px`,
                              fontWeight: fontWeight,
                              fontStyle: isItalic ? 'italic' : 'normal',
                              textShadow: shadowBlur > 0 ? `${shadowOffsetX}px ${shadowOffsetY}px ${shadowBlur}px ${shadowColor}` : 'none',
                              WebkitTextStroke: strokeWidth > 0 ? `${strokeWidth * 2}px ${strokeColor}` : 'none',
                            })
                          }}
                        >
                          {!isFound && slice.text}
                        </div>
                      );
                    })}
                  </div>
                </div>
              </div>
            )}

            {/* Generated Sheet Preview */}
            {generatedDataUrl && (
              <div style={{ display: 'flex', width: '100%', flexDirection: 'column', gap: '0.5rem', marginTop: '0.5rem' }}>
                <span style={{ fontSize: '0.75rem', color: 'var(--text-muted)', fontWeight: 600 }}>SLICED FRAMES ({items.length} FRAMES)</span>
                <div 
                  style={{
                    display: 'flex',
                    flexWrap: 'wrap',
                    gap: '0.5rem',
                    background: 'rgba(0,0,0,0.2)',
                    padding: '1rem',
                    borderRadius: '8px',
                    border: '1px solid var(--glass-border)',
                    maxHeight: '300px',
                    overflowY: 'auto'
                  }}
                >
                  {items.map((item, index) => (
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
                        width: `${Math.max(cellWidth + 12, 45)}px`
                      }}
                    >
                      <span style={{ fontSize: '9px', color: 'var(--text-muted)', fontFamily: 'var(--font-mono)' }}>#{index}</span>
                      <div
                        style={{
                          width: `${cellWidth}px`,
                          height: `${frameHeight}px`,
                          backgroundImage: `url(${generatedDataUrl})`,
                          backgroundPosition: `0px -${index * frameHeight}px`,
                          backgroundSize: `${cellWidth}px ${frameHeight * items.length}px`,
                          imageRendering: 'pixelated'
                        }}
                      />
                      <span style={{ fontSize: '10px', color: 'var(--text-primary)', fontWeight: 600, maxWidth: '100%', overflow: 'hidden', textOverflow: 'ellipsis', whiteSpace: 'nowrap' }}>
                        {item}
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
                link.download = `font_${frameWidth}x${frameHeight}-all.png`;
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
                onApply(generatedDataUrl, cellWidth, frameHeight, items.length, 0, {
                  fontFamily,
                  fontSize,
                  fontWeight,
                  isItalic,
                  textColor,
                  bgColor,
                  strokeColor,
                  strokeWidth,
                  shadowColor,
                  shadowBlur,
                  shadowOffsetX,
                  shadowOffsetY,
                  letterSpacing,
                  textOffsetX,
                  textOffsetY,
                  selectedPreset,
                  customDigitsText,
                  customMonthsText,
                  customWeekdaysText,
                  customGenericText,
                  customText: (
                    selectedPreset === 'custom' ? customDigitsText : 
                    selectedPreset === 'custom_months' ? customMonthsText : 
                    selectedPreset === 'custom_weekdays' ? customWeekdaysText : 
                    customGenericText
                  ),
                  frameWidth,
                  frameHeight,
                  digitSpacing
                });
              }
            }}
            disabled={!generatedDataUrl || !isValidFrameCount}
          >
            <Check size={14} />
            Apply to Selected Layer
          </button>
        </div>

      </div>
    </div>
  );
};
