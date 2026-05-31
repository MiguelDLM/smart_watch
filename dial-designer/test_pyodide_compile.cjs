const { loadPyodide } = require('pyodide');
const fs = require('fs');
const path = require('path');

async function run() {
  console.log("Loading Pyodide...");
  const pyodide = await loadPyodide();

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

  console.log("Preparing virtual FS...");
  await pyodide.runPythonAsync(`
    import os
    import shutil
    if os.path.exists('/input'):
        shutil.rmtree('/input')
    os.makedirs('/input', exist_ok=True)
  `);

  // Copy dial_desc.json
  const extractedDir = path.join(__dirname, '../dialzz_006_extracted');
  const metadataJson = fs.readFileSync(path.join(extractedDir, 'dial_desc.json'), 'utf8');
  pyodide.FS.writeFile('/input/dial_desc.json', metadataJson);

  // Copy all PNGs
  const metadata = JSON.parse(metadataJson);
  for (const block of metadata.blocks) {
    if (block.fname) {
      const pngPath = path.join(extractedDir, block.fname);
      const pngBytes = fs.readFileSync(pngPath);
      
      // Ensure subdirectories in Pyodide
      const parts = block.fname.split('/');
      if (parts.length > 1) {
        let current = '/input';
        for (let i = 0; i < parts.length - 1; i++) {
          current += '/' + parts[i];
          try {
            pyodide.FS.mkdir(current);
          } catch (e) {
            if (e.errno !== 17) throw e;
          }
        }
      }
      pyodide.FS.writeFile(`/input/${block.fname}`, new Uint8Array(pngBytes));
      console.log(`Wrote /input/${block.fname}`);
    }
  }

  console.log("Compiling in Pyodide...");
  const resultProxy = await pyodide.runPythonAsync(`
    success = comp_decomp.compile_dial('/input', '/output.bin')
    success
  `);
  console.log("Compile success:", resultProxy);

  const outputBytes = pyodide.FS.readFile('/output.bin');
  fs.writeFileSync(path.join(__dirname, '../test_compiled_pyodide.bin'), Buffer.from(outputBytes));
  console.log("Wrote test_compiled_pyodide.bin successfully.");
}

run().catch(console.error);
