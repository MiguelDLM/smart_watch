import React, { useEffect, useState, useRef } from 'react';
import { Stage, Layer, Image as KonvaImage, Group, Circle, Line, Rect, Transformer, Shape, Ring } from 'react-konva';

// Simple hook to load images asynchronously in React
const useImage = (url: string | undefined) => {
  const [image, setImage] = useState<HTMLImageElement | null>(null);

  useEffect(() => {
    if (!url) {
      setImage(null);
      return;
    }
    const img = new Image();
    img.src = url;
    img.onload = () => setImage(img);
    img.onerror = () => setImage(null);
  }, [url]);

  return image;
};

// Component to render a specific block layer
interface BlockLayerProps {
  id: string;
  block: any;
  imgUrl: string | undefined;
  mockState: {
    hour: number;
    minute: number;
    second: number;
    day: number;
    year: number;
    steps: number;
    battery: number;
    connected: boolean;
  };
  isSelected: boolean;
  onSelect: () => void;
  onUpdate: (updatedFields: Partial<any>) => void;
}

const BlockLayer: React.FC<BlockLayerProps> = ({
  id,
  block,
  imgUrl,
  mockState,
  isSelected,
  onSelect,
  onUpdate,
}) => {
  const image = useImage(imgUrl);
  const [animFrameIdx, setAnimFrameIdx] = useState(0);

  const { type, width, height, posx, posy, frms, ctx, cty, locked } = block;

  const isHand = type === 'BLK_ARMH' || type === 'BLK_ARMM' || type === 'BLK_ARMS';
  const isNumeric = 
    type === 'BLK_HOUR' || 
    type === 'BLK_MIN' || 
    type === 'BLK_SEC' || 
    type === 'BLK_STEPS' || 
    type === 'BLK_BATTN' ||
    type === 'BLK_DAY' ||
    type === 'BLK_MONTH' ||
    type === 'BLK_YEAR' ||
    type === 'BLK_CALOR' ||
    type === 'BLK_DIST' ||
    type === 'BLK_PULS' ||
    type === 'BLK_TEMP';
  // Static/single-frame blocks that appear at a fixed frame index based on state
  const isStrip = 
    type === 'BLK_BATTS' || 
    type === 'BLK_CONN' || 
    type === 'BLK_WEAT' || 
    type === 'BLK_WEEKD' || 
    type === 'BLK_AMPM' ||
    type === 'BLK_PROG1' ||
    type === 'BLK_PROG2' ||
    type === 'BLK_UNK_A1' ||
    type === 'BLK_BIGYO' ||
    (type === 'BLK_MONTH' && frms !== 10);
  // Only explicit animation blocks animate by cycling frames
  const isAnimation = type === 'BLK_ANIM' || type === 'BLK_ANIMPART';

  useEffect(() => {
    if (isAnimation && frms > 1) {
      const interval = setInterval(() => {
        setAnimFrameIdx(prev => (prev + 1) % frms);
      }, 150);
      return () => clearInterval(interval);
    }
  }, [isAnimation, frms]);

  // All hooks above must run unconditionally (Rules of Hooks); only now is it
  // safe to bail out when the image has not loaded yet.
  if (!image) return null;

  // Handle resizing / scaling transformation
  const handleTransformEnd = (e: any) => {
    const node = e.target;
    const scaleX = node.scaleX();
    const scaleY = node.scaleY();
    
    // Reset scale to 1 so the shape redraws with literal width/height
    node.scaleX(1);
    node.scaleY(1);

    const updatedFields: Partial<any> = {
      width: Math.max(4, Math.round(width * scaleX)),
      height: Math.max(4, Math.round(height * scaleY)),
      posx: Math.round(node.x()),
      posy: Math.round(node.y())
    };

    // If it is an analog hand, also scale the pivot offset proportionally
    if (type === 'BLK_ARMH' || type === 'BLK_ARMM' || type === 'BLK_ARMS') {
      updatedFields.ctx = Math.round((ctx || 0) * scaleX);
      updatedFields.cty = Math.round((cty || 0) * scaleY);
    }

    onUpdate(updatedFields);
  };

  // 1. Render Analog Hands (Hour, Minute, Second)
  if (isHand) {
    let rotation = 0;
    if (type === 'BLK_ARMH') {
      rotation = ((mockState.hour % 12) * 30) + (mockState.minute * 0.5);
    } else if (type === 'BLK_ARMM') {
      rotation = mockState.minute * 6;
    } else if (type === 'BLK_ARMS') {
      rotation = mockState.second * 6;
    }

    // Hands have a FIXED rotation pivot (the watch center) and a size defined in the
    // Hand Builder — they are not draggable/scalable on the canvas. Firmware pivot
    // bytes (verified against original dials): ctx = vertical pivot from the BOTTOM,
    // cty = horizontal pivot from the left (= width/2). Konva offsets are measured
    // from the top-left, so offsetX = cty and offsetY = height - ctx.
    const pivotOffsetX = cty;
    const pivotOffsetY = height - ctx;
    return (
      <Group
        id={id}
        x={posx}
        y={posy}
        draggable={false}
        listening={true}
        onClick={(e) => {
          e.cancelBubble = true;
          onSelect();
        }}
        onTouchStart={(e) => {
          e.cancelBubble = true;
          onSelect();
        }}
      >
        {/* Render the hand rotated around its pivot (cty, height - ctx) */}
        <KonvaImage
          image={image}
          width={width}
          height={height}
          offsetX={pivotOffsetX}
          offsetY={pivotOffsetY}
          rotation={rotation}
          crop={{
            x: 0,
            y: 0,
            width: image.width,
            height: image.height,
          }}
        />

        {/* Draw rotation pivot guide if selected */}
        {isSelected && (
          <>
            <Circle x={0} y={0} radius={4} fill="var(--accent)" stroke="#fff" strokeWidth={1} />
            <Rect
              x={-pivotOffsetX}
              y={-pivotOffsetY}
              width={width}
              height={height}
              stroke="var(--accent)"
              strokeWidth={1}
              dash={[4, 4]}
            />
          </>
        )}
      </Group>
    );
  }

  // 2. Render Numeric/Text sheets (Hour, Minute, Steps, Battery, Date, Health)
  if (isNumeric && (frms === 10 || frms === 11)) {
    // Get mock string value
    let valString = '';
    if (type === 'BLK_HOUR') valString = String(mockState.hour).padStart(2, '0');
    else if (type === 'BLK_MIN') valString = String(mockState.minute).padStart(2, '0');
    else if (type === 'BLK_SEC') valString = String(mockState.second).padStart(2, '0');
    else if (type === 'BLK_STEPS') valString = String(mockState.steps % 100);
    else if (type === 'BLK_BATTN') valString = String(mockState.battery);
    else if (type === 'BLK_DAY') valString = String(mockState.day).padStart(2, '0');
    else if (type === 'BLK_MONTH') valString = '05';
    else if (type === 'BLK_YEAR') valString = String(mockState.year).slice(-2).padStart(2, '0');
    else if (type === 'BLK_CALOR') valString = '36';
    else if (type === 'BLK_DIST') valString = '12'; // 1.2 km mock
    else if (type === 'BLK_PULS') valString = '72';
    else if (type === 'BLK_TEMP') valString = '24';
    const totalDigitFrames = frms || 10; // support 10 or 11 (dist decimal)

    const digits = valString.split('');

    // The watch anchors a digit group by its TOP-LEFT corner at (posx, posy).
    return (
      <Group
        id={id}
        x={posx}
        y={posy}
        draggable={!locked}
        listening={!locked}
        onDragStart={onSelect}
        onDragEnd={(e) => {
          onUpdate({
            posx: Math.round(e.target.x()),
            posy: Math.round(e.target.y()),
          });
        }}
        onTransformEnd={handleTransformEnd}
        onClick={(e) => {
          e.cancelBubble = true;
          onSelect();
        }}
        onTouchStart={(e) => {
          e.cancelBubble = true;
          onSelect();
        }}
      >
        {digits.map((char, index) => {
          const digitVal = parseInt(char, 10);
          if (isNaN(digitVal)) return null;

          return (
            <KonvaImage
              key={index}
              image={image}
              x={index * width}
              y={0}
              width={width}
              height={height}
              crop={{
                x: 0,
                y: digitVal * (image.height / totalDigitFrames),
                width: image.width,
                height: image.height / totalDigitFrames,
              }}
            />
          );
        })}

        {/* Selected outline */}
        {isSelected && (
          <Rect
            x={0}
            y={0}
            width={digits.length * width}
            height={height}
            stroke="var(--accent)"
            strokeWidth={1}
            dash={[4, 4]}
          />
        )}
      </Group>
    );
  }

  // 2.5 Render Animations (explicit BLK_ANIM/BLK_ANIMPART, or any multi-frame block that isn't hand/numeric/strip)
  if (isAnimation) {
    const totalFrames = Math.max(1, frms || 1);
    const frameIdx = animFrameIdx % totalFrames;

    return (
      <Group
        id={id}
        x={posx}
        y={posy}
        draggable={!locked}
        listening={!locked}
        onDragStart={onSelect}
        onDragEnd={(e) => {
          onUpdate({
            posx: Math.round(e.target.x()),
            posy: Math.round(e.target.y()),
          });
        }}
        onTransformEnd={handleTransformEnd}
        onClick={(e) => {
          e.cancelBubble = true;
          onSelect();
        }}
        onTouchStart={(e) => {
          e.cancelBubble = true;
          onSelect();
        }}
      >
        <KonvaImage
          image={image}
          width={width}
          height={height}
          crop={{
            x: 0,
            y: frameIdx * (image.height / totalFrames),
            width: image.width,
            height: image.height / totalFrames,
          }}
        />

        {isSelected && (
          <Rect
            x={0}
            y={0}
            width={width}
            height={height}
            stroke="var(--accent)"
            strokeWidth={1}
            dash={[4, 4]}
          />
        )}
      </Group>
    );
  }

  // 3. Render Status Strips (Battery strips, Connection), Weather, Weekdays, and text-based Months
  if (isStrip) {
    const totalFrames = Math.max(1, frms || 1);
    let frameIdx = 0;
    if (type === 'BLK_BATTS' || type === 'BLK_UNK_A1') {
      // Battery-related: map 0–100% to frame 0–(totalFrames-1)
      frameIdx = Math.min(
        Math.floor((mockState.battery / 100) * (totalFrames - 1)),
        totalFrames - 1
      );
    } else if (type === 'BLK_CONN') {
      frameIdx = mockState.connected ? 1 : 0;
    } else if (type === 'BLK_AMPM') {
      frameIdx = mockState.hour >= 12 ? 1 : 0;
    } else if (type === 'BLK_WEAT') {
      const weatherVal = (mockState as any).weather !== undefined ? (mockState as any).weather : 1;
      frameIdx = Math.min(Math.max(0, weatherVal), totalFrames - 1);
    } else if (type === 'BLK_WEEKD') {
      frameIdx = new Date(mockState.year, 4, mockState.day).getDay() % totalFrames;
    } else if (type === 'BLK_MONTH') {
      frameIdx = 4 % totalFrames;
    } else if (type === 'BLK_PROG1' || type === 'BLK_PROG2') {
      // Progress arcs: map steps/activity to a frame (0–10)
      frameIdx = Math.min(Math.floor((mockState.steps % 10000) / 10000 * totalFrames), totalFrames - 1);
    } else if (type === 'BLK_BIGYO') {
      frameIdx = 0; // Center cap is always frame 0
    }

    return (
      <Group
        id={id}
        x={posx}
        y={posy}
        draggable={!locked}
        listening={!locked}
        onDragStart={onSelect}
        onDragEnd={(e) => {
          onUpdate({
            posx: Math.round(e.target.x()),
            posy: Math.round(e.target.y()),
          });
        }}
        onTransformEnd={handleTransformEnd}
        onClick={(e) => {
          e.cancelBubble = true;
          onSelect();
        }}
        onTouchStart={(e) => {
          e.cancelBubble = true;
          onSelect();
        }}
      >
        <KonvaImage
          image={image}
          width={width}
          height={height}
          crop={{
            x: 0,
            y: frameIdx * (image.height / totalFrames),
            width: image.width,
            height: image.height / totalFrames,
          }}
        />

        {isSelected && (
          <Rect
            x={0}
            y={0}
            width={width}
            height={height}
            stroke="var(--accent)"
            strokeWidth={1}
            dash={[4, 4]}
          />
        )}
      </Group>
    );
  }

  // 4. Default: Render Static Block / Background (frame 0)
  if (type === 'BLK_PREVI') return null;

  return (
    <Group
      id={id}
      x={posx}
      y={posy}
      draggable={!locked}
      listening={!locked}
      onDragStart={onSelect}
      onDragEnd={(e) => {
        onUpdate({
          posx: Math.round(e.target.x()),
          posy: Math.round(e.target.y()),
        });
      }}
      onTransformEnd={handleTransformEnd}
      onClick={(e) => {
        e.cancelBubble = true;
        onSelect();
      }}
      onTouchStart={(e) => {
        e.cancelBubble = true;
        onSelect();
      }}
    >
      <KonvaImage
        image={image}
        width={width}
        height={height}
        crop={{
          x: 0,
          y: 0,
          width: image.width,
          height: image.height,
        }}
      />

      {isSelected && (
        <Rect
          x={0}
          y={0}
          width={width}
          height={height}
          stroke="var(--accent)"
          strokeWidth={1}
          dash={[4, 4]}
        />
      )}
    </Group>
  );
};

interface CanvasWatchfaceProps {
  watchfaceSize: { width: number; height: number };
  blocks: any[];
  images: Record<string, string>;
  selectedBlockIndex: number | null;
  onSelectBlock: (index: number | null) => void;
  onUpdateBlock: (index: number, updatedFields: Partial<any>) => void;
  mockState: {
    hour: number;
    minute: number;
    second: number;
    day: number;
    year: number;
    steps: number;
    battery: number;
    connected: boolean;
  };
}

export const CanvasWatchface: React.FC<CanvasWatchfaceProps> = ({
  watchfaceSize,
  blocks,
  images,
  selectedBlockIndex,
  onSelectBlock,
  onUpdateBlock,
  mockState,
}) => {
  const stageRef = useRef<any>(null);
  const transformerRef = useRef<any>(null);

  const size = watchfaceSize.width;
  const padding = 120; // Working pasteboard area padding to see/edit oversized assets
  const stageSize = size + padding * 2;

  // Bind transformer to selected block node
  useEffect(() => {
    if (selectedBlockIndex !== null && transformerRef.current && stageRef.current) {
      const selectedNode = stageRef.current.findOne(`#block-${selectedBlockIndex}`);
      if (selectedNode) {
        transformerRef.current.nodes([selectedNode]);
        transformerRef.current.getLayer().batchDraw();
      } else {
        transformerRef.current.nodes([]);
      }
    } else if (transformerRef.current) {
      transformerRef.current.nodes([]);
    }
  }, [selectedBlockIndex, blocks]);

  return (
    <div 
      style={{
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
        padding: '1.5rem',
        background: 'rgba(0,0,0,0.2)',
        borderRadius: '12px',
        border: '1px solid var(--glass-border)',
        overflow: 'hidden',
        position: 'relative'
      }}
    >
      {/* Stage Container representing the watch designer workbench */}
      <div 
        style={{
          position: 'relative',
          display: 'flex',
          justifyContent: 'center',
          alignItems: 'center',
          background: 'var(--bg-primary)',
          borderRadius: '16px',
          border: '1px solid var(--glass-border)',
          boxShadow: 'inset 0 0 30px rgba(0,0,0,0.6)',
          overflow: 'hidden',
        }}
      >
        <Stage
          ref={stageRef}
          width={stageSize}
          height={stageSize}
          onClick={() => onSelectBlock(null)}
          onTouchStart={() => onSelectBlock(null)}
        >
          <Layer>
            {/* Everything inside this Group is relative to the watch face origin (0, 0) */}
            <Group x={padding} y={padding}>
              {/* Draw crosshair grid lines for watch center alignment */}
              <Line
                points={[0, size / 2, size, size / 2]}
                stroke="rgba(255,255,255,0.06)"
                strokeWidth={1}
                dash={[5, 5]}
              />
              <Line
                points={[size / 2, 0, size / 2, size]}
                stroke="rgba(255,255,255,0.06)"
                strokeWidth={1}
                dash={[5, 5]}
              />
              
              {/* Active Screen Guide Circle */}
              <Circle
                x={size / 2}
                y={size / 2}
                radius={size / 2}
                stroke="rgba(255,255,255,0.15)"
                strokeWidth={1}
                listening={false}
              />

              {/* Render all watch face block layers in order */}
              {blocks.map((block, idx) => (
                <BlockLayer
                  key={idx}
                  id={`block-${idx}`}
                  block={block}
                  imgUrl={images[block.fname]}
                  mockState={mockState}
                  isSelected={selectedBlockIndex === idx}
                  onSelect={() => onSelectBlock(idx)}
                  onUpdate={(fields) => onUpdateBlock(idx, fields)}
                />
              ))}
            </Group>

            {/* Dark Mask for area outside the circular watch face boundary */}
            <Shape
              sceneFunc={(context, shape) => {
                context.beginPath();
                // Outer rectangle covering the whole Stage
                context.rect(0, 0, stageSize, stageSize);
                // Inner circle representing the watch face screen (anti-clockwise to subtract)
                context.arc(
                  padding + size / 2,
                  padding + size / 2,
                  size / 2,
                  0,
                  Math.PI * 2,
                  true
                );
                context.closePath();
                context.fillStrokeShape(shape);
              }}
              fill="rgba(10, 10, 15, 0.6)"
              listening={false}
            />

            {/* Premium Smartwatch Bezel Overlay */}
            <Ring
              x={padding + size / 2}
              y={padding + size / 2}
              innerRadius={size / 2}
              outerRadius={size / 2 + 20}
              fill="hsl(230, 20%, 8%)"
              stroke="hsl(230, 20%, 15%)"
              strokeWidth={2}
              shadowColor="#000"
              shadowBlur={15}
              shadowOpacity={0.6}
              listening={false}
            />
            {/* Bezel inner metallic accent ring */}
            <Circle
              x={padding + size / 2}
              y={padding + size / 2}
              radius={size / 2 + 1}
              stroke="rgba(255,255,255,0.08)"
              strokeWidth={1}
              listening={false}
            />

            {/* Dynamic transformer for resizing elements on top of the mask and bezel */}
            {selectedBlockIndex !== null && !blocks[selectedBlockIndex].locked
              && !['BLK_ARMH', 'BLK_ARMM', 'BLK_ARMS'].includes(blocks[selectedBlockIndex].type) && (
              <Transformer
                ref={transformerRef}
                rotateEnabled={false} // Disable rotation since static watchface layers cannot be statically rotated in firmware
                enabledAnchors={['top-left', 'top-right', 'bottom-left', 'bottom-right', 'top-center', 'bottom-center', 'left-center', 'right-center']}
                boundBoxFunc={(oldBox, newBox) => {
                  // Guard minimum width and height
                  if (newBox.width < 4 || newBox.height < 4) {
                    return oldBox;
                  }
                  return newBox;
                }}
              />
            )}
          </Layer>
        </Stage>
      </div>
    </div>
  );
};
