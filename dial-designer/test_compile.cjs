const { loadPyodide } = require('pyodide');
const fs = require('fs');
const path = require('path');

async function run() {
  console.log("Loading Pyodide...");
  const pyodide = await loadPyodide({
    indexURL: 'https://cdn.jsdelivr.net/pyodide/v0.26.4/full/',
  });

  console.log("Loading packages...");
  await pyodide.loadPackage(['pillow', 'numpy']);

  console.log("Reading comp_decomp.py...");
  const scriptCode = fs.readFileSync(path.join(__dirname, 'public/comp_decomp.py'), 'utf8');
  pyodide.FS.writeFile('/comp_decomp.py', scriptCode);

  await pyodide.runPythonAsync(`
    import sys
    sys.path.append('/')
    import comp_decomp
  `);

  console.log("Creating dummy dial...");
  // Create /input dir
  pyodide.runPythonAsync(`
    import os
    import shutil
    if os.path.exists('/input'):
        shutil.rmtree('/input')
    os.makedirs('/input', exist_ok=True)
  `);

  const metadata = {
    dial_name: "test_dial",
    blocks: [
      {
        type: "BLK_BGIMG",
        frms: 1,
        fname: "bg.png",
        width: 720,
        height: 1280,
        posx: 0,
        posy: 0,
        alnx: 0,
        comp: 6,
        ctx: 0,
        cty: 0
      },
      {
        type: "BLK_HOUR",
        frms: 10,
        fname: "generated/font_hour.png",
        width: 32,
        height: 48,
        posx: 10,
        posy: 20,
        alnx: 0,
        comp: 6,
        ctx: 0,
        cty: 0
      }
    ]
  };

  pyodide.FS.writeFile('/input/dial_desc.json', JSON.stringify(metadata, null, 2));

  // Helper to ensure dirs exist
  const ensureDirectoryExists = (py, path) => {
    const parts = path.split('/').filter(p => p);
    let currentPath = '';
    for (const part of parts) {
      currentPath += '/' + part;
      try {
        py.FS.mkdir(currentPath);
      } catch (e) {
        if (e.errno !== 17) {
          throw e;
        }
      }
    }
  };

  // Create dummy image files
  const dummyPng = Buffer.alloc(100); // Dummy empty bytes, not a real PNG, but let's see if FS allows writing it

  const images = {
    "bg.png": dummyPng,
    "generated/font_hour.png": dummyPng
  };

  for (const [fname, content] of Object.entries(images)) {
    const filePath = `/input/${fname}`;
    const lastSlashIdx = filePath.lastIndexOf('/');
    if (lastSlashIdx !== -1) {
      const dirPath = filePath.substring(0, lastSlashIdx);
      ensureDirectoryExists(pyodide, dirPath);
    }
    pyodide.FS.writeFile(filePath, new Uint8Array(content));
    console.log(`Wrote ${filePath}`);
  }

  console.log("Running compilation...");
  try {
    const resultProxy = await pyodide.runPythonAsync(`
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

    const result = resultProxy.toJs();
    resultProxy.destroy();
    console.log("Compile result:", result);
  } catch (err) {
    console.error("Compilation failed with JS error:", err);
  }
}

run().catch(console.error);
