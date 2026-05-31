# Architecture Design: Dial Designer

This document outlines the architectural design for the **Dial Designer**, an interactive desktop and web application for designing and compiling watch faces (dials) for HK89 smartwatches.

## 1. Overview & Requirements
The goal of this application is to provide a user-friendly, interactive, and visual editor to design smartwatch dials, eliminating the need to write JSON metadata or align assets manually on a device.

### Key Requirements
* **Zero Infrastructure Backend (Serverless Web)**: The web app must run completely client-side in the browser, allowing hosting on static site platforms like GitHub Pages.
* **Installable Desktop Application**: Packaged as a native application for Windows, Linux, and macOS using the same codebase.
* **Visual Canvas Editor**: A drag-and-drop workspace representing the smartwatch screen, displaying layers, guides, coordinates, and supporting element alignment.
* **Asset & Sheet Generator**: Ability to generate number/text font sheets from system fonts and slice images into vertical frame-sheets.
* **Binary Compilation**: Direct integration with the existing Python-based decompilation/compilation tool (`comp_decomp.py`).

---

## 2. Technology Stack

```
+-------------------------------------------------------------+
|                      React UI (Vite)                        |
|   (Interactive Canvas via Konva.js / Layer Management)       |
+-------------------------------------------------------------+
                              |
       +----------------------+----------------------+
       | (Web / Static App)   | (Desktop App)        |
       v                      v                      v
+--------------+      +---------------+      +----------------+
|   Pyodide    |      | Tauri Wrapper |      | GitHub Actions |
| (Wasm Python)|      |  (Rust / C++) |      | (Build & Deploy|
+--------------+      +---------------+      +----------------+
```

### Frontend Framework
* **Vite + React (TypeScript)**: For building a fast, modular, and type-safe Single Page Application (SPA).
* **Styling**: Vanilla CSS with modern custom properties (CSS variables), gradients, and glassmorphism design for a premium appearance.

### Interactive Canvas Engine
* **Konva.js / React-Konva**: An HTML5 2D Canvas library. It provides high-performance rendering for hundreds of shapes, drag-and-drop layers, rotation, scaling, and pixel-perfect element bounds detection.

### Serverless Python Runtime (Wasm)
* **Pyodide**: Runs the Python 3 interpreter in WebAssembly (Wasm) inside the browser.
  * Allows direct execution of `comp_decomp.py` within the web page.
  * Dynamically loads `Pillow` and `NumPy` Wasm packages (standard dependencies of our Python script).
  * Avoids rewriting complex RLE (Run-Length Encoding) compression/decompression algorithms in JavaScript, preserving compatibility with original tools.

### Desktop Shell Wrapper
* **Tauri**: Wraps the compiled static assets into a native desktop shell. Tauri has a minimal memory footprint and small bundle size compared to Electron, rendering UI using the system's native Webview (WebKit on Linux/macOS, WebView2 on Windows).

---

## 3. Core Modules & Data Flow

### A. The Canvas & Editor State
The editor maintains a state resembling the structure of `dial_desc.json` (see sample in `zzuler/hkcomposer-1.9.6-linux/dialzz_006.json`).

* **State Schema**:
  ```typescript
  interface Block {
    type: string;        // e.g., "BLK_BGIMG", "BLK_HOUR", "BLK_MIN"
    frms: number;        // Number of vertical frames/slices
    fname: string;       // Sliced sheet path or asset key
    reuse: boolean;
    colsp: 'RGB' | 'RGBA';
    width: number;       // Frame width
    height: number;      // Frame height
    posx: number;        // X coordinate
    posy: number;        // Y coordinate
    alnx: number;        // Alignment flags
    ctx: number;         // Center X (for rotation hands)
    cty: number;         // Center Y (for rotation hands)
  }
  ```

### B. Font Sheet Generator
Smartwatches represent numbers (hours, battery, steps) as multi-frame image sheets containing digits from `0` to `9`. The application includes a utility to:
1. Accept a user text input and selected system typography (using the Web Font API or canvas text rendering).
2. Render each glyph onto a vertical canvas strips (e.g. 10 frames stacked vertically for numbers `0-9`).
3. Export it as a PNG sheet to be packed by the compiler.

### C. Binary Compiler Interceptor (Pyodide Connector)
```
[User Interface] ──(Click Compile)──> [Generate dial_desc.json & Images]
                                                    │
                                                    v
[Output .bin file] <──(Run script)─── [Pyodide WASM Runtime (comp_decomp.py)]
```
1. When compiling, the app constructs a virtual folder in the Pyodide filesystem.
2. It writes `dial_desc.json` and the source PNG files.
3. It executes `comp_decomp.py` via Python-in-Wasm.
4. It reads the compiled `.bin` file from Pyodide's virtual output and triggers a browser file download.

---

## 4. Deployment Pipeline
* **GitHub Actions** will be set up to:
  * Deploy the Vite-compiled static site to **GitHub Pages** on every merge to `main`.
  * Build Tauri desktop installers (`.exe`, `.deb`, `.dmg`) whenever a new release tag is pushed.
