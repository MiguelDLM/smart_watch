// Shared helpers for importing raster/vector images into the dial designer.
// The watch firmware only understands raster pixels, so SVGs are rasterized to PNG
// at import time. PNG/JPG/WebP/BMP load natively via an <img> element.

const SVG_FALLBACK_SIZE = 512;

/**
 * Load any supported image file (png/jpg/jpeg/webp/bmp/svg) into an HTMLImageElement.
 * SVGs draw fine through an <img>; if an SVG reports no intrinsic size we fall back to
 * a square canvas so it can still be rasterized.
 */
export const loadImageElement = (file: File): Promise<HTMLImageElement> => {
  return new Promise((resolve, reject) => {
    const url = URL.createObjectURL(file);
    const img = new Image();
    img.onload = () => {
      // Some SVGs have no width/height attributes → naturalWidth can be 0.
      if (!img.naturalWidth || !img.naturalHeight) {
        const fallback = new Image();
        fallback.onload = () => {
          URL.revokeObjectURL(url);
          resolve(fallback);
        };
        fallback.onerror = () => {
          URL.revokeObjectURL(url);
          reject(new Error('Failed to load image (no intrinsic size).'));
        };
        // Force a concrete size by reloading through a data URL with width/height hints
        // is not generally possible; instead expose the fallback dimensions on the element.
        Object.defineProperty(img, '_fallbackSize', { value: SVG_FALLBACK_SIZE });
        URL.revokeObjectURL(url);
        resolve(img);
        return;
      }
      URL.revokeObjectURL(url);
      resolve(img);
    };
    img.onerror = () => {
      URL.revokeObjectURL(url);
      reject(new Error(`Failed to load image: ${file.name}`));
    };
    img.src = url;
  });
};

/** Natural width of an image, honoring the SVG fallback size when intrinsic size is 0. */
export const imgWidth = (img: HTMLImageElement): number =>
  img.naturalWidth || (img as any)._fallbackSize || SVG_FALLBACK_SIZE;

/** Natural height of an image, honoring the SVG fallback size when intrinsic size is 0. */
export const imgHeight = (img: HTMLImageElement): number =>
  img.naturalHeight || (img as any)._fallbackSize || SVG_FALLBACK_SIZE;

/**
 * Draw a source rectangle of `img` into a `dw × dh` canvas and return a PNG data URL.
 * Used for both cropping and resizing on import (transparent where the source is).
 */
export const rasterToPngDataUrl = (
  img: HTMLImageElement,
  sx: number,
  sy: number,
  sw: number,
  sh: number,
  dw: number,
  dh: number
): string => {
  const canvas = document.createElement('canvas');
  canvas.width = Math.max(1, Math.round(dw));
  canvas.height = Math.max(1, Math.round(dh));
  const ctx = canvas.getContext('2d');
  if (ctx) {
    ctx.imageSmoothingEnabled = true;
    ctx.imageSmoothingQuality = 'high';
    ctx.drawImage(img, sx, sy, sw, sh, 0, 0, canvas.width, canvas.height);
  }
  return canvas.toDataURL('image/png');
};

/** Convert any supported image file straight to a full-size PNG data URL. */
export const fileToPngDataUrl = async (file: File): Promise<{ url: string; width: number; height: number }> => {
  const img = await loadImageElement(file);
  const w = imgWidth(img);
  const h = imgHeight(img);
  return { url: rasterToPngDataUrl(img, 0, 0, w, h, w, h), width: w, height: h };
};
