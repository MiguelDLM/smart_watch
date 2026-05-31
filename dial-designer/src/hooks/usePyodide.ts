import { useState, useEffect, useCallback } from 'react';

// Global singleton references to prevent re-initializing Pyodide on component re-renders
let pyodidePromise: Promise<any> | null = null;
let cachedPyodide: any = null;

export type PyodideStatus = 
  | 'idle'
  | 'loading_engine'
  | 'loading_packages'
  | 'loading_script'
  | 'ready'
  | 'error';

export interface DecompressedDial {
  metadata: any;
  images: Record<string, string>; // Maps relative filename (e.g. "zz06/prev.png") to blob objectURL
}

// Helper to recursively create directories in Pyodide FS
// Handles both POSIX and WebAssembly (WASI/Emscripten) error codes
// In WASI: EEXIST is 20 (standard Unix: 17), ENOENT is 44 (standard Unix: 2)
const isEexist = (e: any): boolean => {
  return !!(e && (e.errno === 17 || e.errno === 20 || e.code === 'EEXIST' || (e.message && e.message.includes('EEXIST'))));
};

const isEnoent = (e: any): boolean => {
  return !!(e && (e.errno === 2 || e.errno === 44 || e.code === 'ENOENT' || (e.message && e.message.includes('ENOENT'))));
};

const ensureDirectoryExists = (pyodide: any, path: string) => {
  const parts = path.split('/').filter(p => p);
  let currentPath = '';
  for (const part of parts) {
    currentPath += '/' + part;
    try {
      const status = pyodide.FS.stat(currentPath);
      // Path exists, verify it is a directory
      if (!pyodide.FS.isDir(status.mode)) {
        console.warn(`ensureDirectoryExists: "${currentPath}" exists but is a file. Unlinking to create directory.`);
        pyodide.FS.unlink(currentPath);
        pyodide.FS.mkdir(currentPath);
      }
    } catch (e: any) {
      if (isEnoent(e)) {
        try {
          pyodide.FS.mkdir(currentPath);
        } catch (mkdirErr: any) {
          if (!isEexist(mkdirErr)) {
            console.error(`ensureDirectoryExists: Failed to mkdir "${currentPath}":`, mkdirErr);
            throw mkdirErr;
          }
        }
      } else if (!isEexist(e)) {
        console.error(`ensureDirectoryExists: Unexpected stat error for "${currentPath}":`, e);
        throw e;
      }
    }
  }
};

export const usePyodide = () => {
  const [status, setStatus] = useState<PyodideStatus>('idle');
  const [error, setError] = useState<string | null>(null);

  // Initialize Pyodide
  const initPyodide = useCallback(async () => {
    if (cachedPyodide) {
      setStatus('ready');
      return cachedPyodide;
    }

    if (pyodidePromise) {
      return pyodidePromise;
    }

    // Create initialization promise
    pyodidePromise = (async () => {
      try {
        // 1. Load Pyodide Engine
        setStatus('loading_engine');
        if (!window.loadPyodide) {
          throw new Error(
            'Pyodide script not loaded. Check if the script tag in index.html is correct.'
          );
        }
        const pyodide = await window.loadPyodide({
          indexURL: 'https://cdn.jsdelivr.net/pyodide/v0.26.4/full/',
        });

        // 2. Load Python Packages (Pillow and NumPy)
        setStatus('loading_packages');
        await pyodide.loadPackage(['pillow', 'numpy']);

        // 3. Load comp_decomp.py script
        setStatus('loading_script');
        const scriptResponse = await fetch('comp_decomp.py');
        if (!scriptResponse.ok) {
          throw new Error('Failed to fetch comp_decomp.py from public folder');
        }
        const scriptCode = await scriptResponse.text();

        // Write script to Pyodide's virtual filesystem
        pyodide.FS.writeFile('/comp_decomp.py', scriptCode);

        // Mount / import the script into Python sys path
        await pyodide.runPythonAsync(`
          import sys
          sys.path.append('/')
          import comp_decomp
        `);

        cachedPyodide = pyodide;
        setStatus('ready');
        return pyodide;
      } catch (err: any) {
        console.error('Pyodide Init Error:', err);
        setError(err.message || 'Failed to initialize Python engine');
        setStatus('error');
        pyodidePromise = null; // Reset promise to allow retrying
        throw err;
      }
    })();

    return pyodidePromise;
  }, []);

  // Initialize on mount
  useEffect(() => {
    initPyodide().catch(() => {});
  }, [initPyodide]);

  // Decompress .bin file using Pyodide
  const decompressDial = useCallback(async (file: File): Promise<DecompressedDial> => {
    const py = await initPyodide();
    
    // Clear previous output directory
    await py.runPythonAsync(`
      import os
      import shutil
      if os.path.exists('/output'):
          shutil.rmtree('/output')
      os.makedirs('/output', exist_ok=True)
    `);

    // Read upload file into buffer
    const arrayBuffer = await file.arrayBuffer();
    const uint8Array = new Uint8Array(arrayBuffer);

    // Write file to Pyodide FS
    py.FS.writeFile('/input.bin', uint8Array);

    // Execute decompression
    const decompressResultProxy = await py.runPythonAsync(`
      import io
      import sys
      import traceback

      _buf = io.StringIO()
      _old_out = sys.stdout
      _old_err = sys.stderr
      sys.stdout = _buf
      sys.stderr = _buf

      success = False
      try:
        success = comp_decomp.extract_dial('/input.bin', '/output')
      except Exception as e:
        print("Python Exception occurred during extract_dial:")
        print(traceback.format_exc())
      finally:
        sys.stdout = _old_out
        sys.stderr = _old_err

      _output = _buf.getvalue().strip()
      (success, _output)
    `);

    const decompressResult = decompressResultProxy.toJs();
    decompressResultProxy.destroy();
    const decompressSuccess = decompressResult[0];
    const decompressOutput = decompressResult[1];
    if (!decompressSuccess) {
      throw new Error(decompressOutput || "Extraction failed in comp_decomp.py");
    }

    // Read metadata
    const jsonContent = py.FS.readFile('/output/dial_desc.json', { encoding: 'utf8' });
    const metadata = JSON.parse(jsonContent);

    // Normalize block types to keep compatibility with editor's expected values
    if (metadata && metadata.blocks) {
      metadata.blocks = metadata.blocks.map((b: any) => {
        const t = b.type;
        let normalizedType = t;
        let isLocked = b.locked;
        let frms = b.frms;
        if (t === 'BLK_BACKGROUND' || t === 'BLK_BACKGROUND2' || t === 'BLK_BACKGROUND3' || t === 'BLK_BG' || t === 'BLK_BGIMG') {
          normalizedType = 'BLK_BGIMG';
          isLocked = true; // Always lock background layer
          frms = 1; // Background must have exactly 1 frame
        } else if (t === 'BLK_PREV' || t === 'BLK_PREVI') {
          normalizedType = 'BLK_PREVI';
          frms = 1; // Preview must have exactly 1 frame
        } else if (t === 'BLK_HOURS') {
          normalizedType = 'BLK_HOUR';
        } else if (t === 'BLK_MINUTES') {
          normalizedType = 'BLK_MIN';
        } else if (t === 'BLK_SECONDS') {
          normalizedType = 'BLK_SEC';
        } else if (t === 'BLK_BATTERY') {
          normalizedType = 'BLK_BATTN';
        } else if (t === 'BLK_CONNECT') {
          normalizedType = 'BLK_CONN';
        } else if (t === 'BLK_WEATHER') {
          normalizedType = 'BLK_WEAT';
        } else if (t === 'BLK_WEEKDAY') {
          normalizedType = 'BLK_WEEKD';
        }
        return { ...b, type: normalizedType, frms, locked: isLocked };
      });
    }

    // Read and create URLs for all extracted images
    const images: Record<string, string> = {};
    for (const block of metadata.blocks) {
      if (block.fname) {
        const filePath = `/output/${block.fname}`;
        try {
          const fileData = py.FS.readFile(filePath);
          const blob = new Blob([fileData], { type: 'image/png' });
          const url = URL.createObjectURL(blob);
          images[block.fname] = url;
        } catch (err) {
          console.warn(`Failed to read extracted asset ${block.fname}:`, err);
        }
      }
    }

    // Clean up file in memory
    try {
      py.FS.unlink('/input.bin');
    } catch (e) {}

    return { metadata, images };
  }, [initPyodide]);

  // Compress block data back into a .bin dial file
  const compressDial = useCallback(async (
    metadata: any, 
    images: Record<string, string | ArrayBuffer>
  ): Promise<Blob> => {
    const py = await initPyodide();

    // Clean previous input and output directories
    await py.runPythonAsync(`
      import os
      import shutil
      if os.path.exists('/input'):
          shutil.rmtree('/input')
      os.makedirs('/input', exist_ok=True)
      
      if os.path.exists('/output.bin'):
          os.unlink('/output.bin')
    `);

    // Write dial_desc.json
    py.FS.writeFile('/input/dial_desc.json', JSON.stringify(metadata, null, 2));

    // Write all images
    for (const [fname, content] of Object.entries(images)) {
      const filePath = `/input/${fname}`;
      
      // Ensure subdirectories exist (e.g. "/input/zz06/")
      const lastSlashIdx = filePath.lastIndexOf('/');
      if (lastSlashIdx !== -1) {
        const dirPath = filePath.substring(0, lastSlashIdx);
        try {
          ensureDirectoryExists(py, dirPath);
        } catch (dirErr: any) {
          console.error(`compressDial: Failed ensuring directory structure for "${dirPath}":`, dirErr);
          throw new Error(`Failed to create directory "${dirPath}" in virtual FS: ${dirErr.message || dirErr} (errno: ${dirErr.errno})`);
        }
      }

      let uint8: Uint8Array;
      if (content instanceof ArrayBuffer) {
        uint8 = new Uint8Array(content);
      } else if (typeof content === 'string' && content.startsWith('data:')) {
        // Base64 data URL
        const base64Str = content.split(',')[1];
        const binaryStr = atob(base64Str);
        uint8 = new Uint8Array(binaryStr.length);
        for (let i = 0; i < binaryStr.length; i++) {
          uint8[i] = binaryStr.charCodeAt(i);
        }
      } else if (typeof content === 'string' && content.startsWith('blob:')) {
        // Fetch blob from URL to ArrayBuffer
        const response = await fetch(content);
        const buffer = await response.arrayBuffer();
        uint8 = new Uint8Array(buffer);
      } else {
        throw new Error(`Unsupported image content format for ${fname}`);
      }

      try {
        py.FS.writeFile(filePath, uint8);
      } catch (writeErr: any) {
        console.error(`compressDial: Failed writing file to Pyodide FS: filePath="${filePath}", fname="${fname}", errno=${writeErr.errno}, error=`, writeErr);
        throw new Error(`Failed writing virtual file "${filePath}": ${writeErr.message || writeErr} (errno: ${writeErr.errno})`);
      }
    }

    // Execute compilation and capture stdout/stderr for diagnostics
    const compileResultProxy = await py.runPythonAsync(`
      import io
      import sys
      import traceback

      _buf = io.StringIO()
      _old_out = sys.stdout
      _old_err = sys.stderr
      sys.stdout = _buf
      sys.stderr = _buf

      success = False
      try:
        success = comp_decomp.compile_dial('/input', '/output.bin')
      except Exception as e:
        print("Python Exception occurred during compile_dial:")
        print(traceback.format_exc())
      finally:
        sys.stdout = _old_out
        sys.stderr = _old_err

      _output = _buf.getvalue().strip()
      (success, _output)
    `);

    const compileResult = compileResultProxy.toJs();
    compileResultProxy.destroy();
    const compileSuccess = compileResult[0];
    const compileOutput = compileResult[1];
    if (!compileSuccess) {
      throw new Error(compileOutput || "Compilation failed in comp_decomp.py");
    }

    // Read final output file
    const outputData = py.FS.readFile('/output.bin');
    const compiledBlob = new Blob([outputData], { type: 'application/octet-stream' });

    // Cleanup input files
    await py.runPythonAsync(`
      import shutil
      shutil.rmtree('/input')
    `);

    return compiledBlob;
  }, [initPyodide]);

  return {
    status,
    error,
    isLoading: status !== 'ready' && status !== 'error',
    decompressDial,
    compressDial,
  };
};
