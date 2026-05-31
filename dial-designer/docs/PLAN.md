# Implementation Plan: Dial Designer

This document outlines the phased roadmap for building the **Dial Designer** application, supporting both web deployment on GitHub Pages and native installable desktop wrappers.

---

## Phased Roadmap

### Phase 1: Project Scaffolding & Pyodide Integration
* **Goal**: Establish the repository directory, initialize Vite + React (TypeScript), and verify Pyodide execution in the browser.
* **Tasks**:
  1. Initialize Vite project in the `dial-designer` folder.
  2. Create standard boilerplate configuration (`tsconfig.json`, `vite.config.ts`, etc.).
  3. Load Pyodide in a React context and write a script loader for `comp_decomp.py`.
  4. Build a proof-of-concept interface: Upload a `.bin` dial, decompress it using Pyodide in-browser, and render the extracted images on screen.

### Phase 2: Interactive Editor Canvas
* **Goal**: Create the interactive watch face preview canvas.
* **Tasks**:
  1. Integrates Konva.js / React-Konva into the main editor layout.
  2. Implement watch face outline constraints (e.g. 466x466 circular viewport).
  3. Create layer panel (add background block, clock hands, digits).
  4. Implement drag-and-drop movement, snapping, and layout positioning with live coordinates update.
  5. Synchronize canvas elements state to JSON metadata structure.

### Phase 3: Typographic & Sheet Utilities
* **Goal**: Enable custom text rendering using system fonts and resource slicing.
* **Tasks**:
  1. Create a "Font Sheet Generator" dialog allowing users to:
     * Select a font family, size, color, and spacing.
     * Preview and render vertical frame sheets for digits `0-9`, colon `:`, comma `,`, or week days.
     * Export the rendered bitmap as a block asset.
  2. Implement an asset manager for importing custom PNGs and automatic validation of dimensions (checking if the height corresponds to `frms * height`).

### Phase 4: Compiling & Packaging (Tauri & CI/CD)
* **Goal**: Build native desktop installers and automate deployment.
* **Tasks**:
  1. Integrate Tauri command configurations inside the workspace.
  2. Write GitHub Actions workflow for static web app deployment to GitHub Pages.
  3. Write GitHub Actions workflow for cross-compiling Tauri desktop apps (`.exe`, `.deb`, `.dmg`) on release triggers.
  4. Refine look-and-feel using a premium glassmorphic UI design system.
