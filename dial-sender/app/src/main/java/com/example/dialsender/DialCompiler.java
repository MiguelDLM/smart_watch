package com.example.dialsender;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Log;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DialCompiler {
    private static final String TAG = "DialCompiler";

    // Standard Types
    public static final int TYPE_PREVIEW = 0x01;
    public static final int TYPE_BACKGROUND = 0x02;
    public static final int TYPE_DIGITAL_HOUR = 0x09;
    public static final int TYPE_DIGITAL_MIN = 0x0A;
    public static final int TYPE_STEPS = 0x0E;
    public static final int TYPE_HEART = 0x0F;
    public static final int TYPE_CALORIE = 0x10;

    public static class DialBlock {
        public int type;
        public int x;
        public int y;
        public int width;
        public int height;
        public int frames = 1;
        public int picIdx;
        public Bitmap[] images;
        public boolean hasAlpha = false;
        public int compress = 1; // Default to RLE
    }

    private List<DialBlock> blocks = new ArrayList<>();
    private int deviceWidth = 466;
    private int deviceHeight = 466;

    public DialCompiler(int width, int height) {
        this.deviceWidth = width;
        this.deviceHeight = height;
    }

    public void addBlock(DialBlock block) {
        blocks.add(block);
    }

    public File compile(File outputDir, String filename) throws Exception {
        Log.d(TAG, "Starting Python-based Compilation...");

        if (!Python.isStarted()) {
            throw new RuntimeException("Python not started. Initialize in Application or Activity.");
        }

        // 1. Prepare temp directory
        File tempDir = new File(outputDir, "temp_compile_" + System.currentTimeMillis());
        if (!tempDir.exists() && !tempDir.mkdirs()) {
            throw new IOException("Failed to create temp directory");
        }

        // 2. Prepare JSON Config
        JSONObject root = new JSONObject();
        root.put("format_version", "2.0");
        root.put("source_format", "hk_traditional"); // Force traditional format for now

        JSONObject header = new JSONObject();
        header.put("format", "hk_traditional");
        root.put("header", header);

        JSONArray jsonBlocks = new JSONArray();

        // 3. Process blocks
        for (DialBlock block : blocks) {
            if (block.images == null || block.images.length == 0) continue;

            JSONObject jsonBlock = new JSONObject();
            jsonBlock.put("picidx", block.picIdx);
            jsonBlock.put("blocktype", block.type);
            jsonBlock.put("x", block.x);
            jsonBlock.put("y", block.y);
            jsonBlock.put("w", block.width);
            jsonBlock.put("h", block.height); // Per frame height
            jsonBlock.put("format", "RGB565"); // Standard
            jsonBlock.put("compression", block.compress == 0 ? "none" : "rle");

            // Combine frames if multiple
            Bitmap imageToSave = combineBitmapsVertically(block.images);
            String imgFilename = "block_" + block.picIdx + ".png";
            File imgFile = new File(tempDir, imgFilename);
            
            try (FileOutputStream fos = new FileOutputStream(imgFile)) {
                imageToSave.compress(Bitmap.CompressFormat.PNG, 100, fos);
            }
            
            jsonBlock.put("image_file", imgFile.getAbsolutePath());
            jsonBlocks.put(jsonBlock);
        }

        root.put("blocks", jsonBlocks);

        // Save JSON
        File jsonFile = new File(tempDir, "config.json");
        try (FileOutputStream fos = new FileOutputStream(jsonFile)) {
            fos.write(root.toString(2).getBytes());
        }

        // 4. Call Python
        Python py = Python.getInstance();
        PyObject composerModule = py.getModule("hkcomposer");
        PyObject composer = composerModule.callAttr("HKDialComposerEnhanced");
        
        File outFile = new File(outputDir, filename);
        
        // compile_dial(json_path, output_path, format_override)
        PyObject result = composer.callAttr("compile_dial", 
            jsonFile.getAbsolutePath(), 
            outFile.getAbsolutePath(), 
            "hk_traditional");

        if (result != null && result.toBoolean()) {
            Log.d(TAG, "Compilation Success: " + outFile.length() + " bytes");
            // Clean up temp
            deleteRecursive(tempDir);
            return outFile;
        } else {
            throw new Exception("Python compilation returned false");
        }
    }

    private Bitmap combineBitmapsVertically(Bitmap[] bitmaps) {
        if (bitmaps.length == 1) return bitmaps[0];
        int w = bitmaps[0].getWidth();
        int h = 0;
        for(Bitmap b : bitmaps) h += b.getHeight();
        
        Bitmap combined = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(combined);
        int y = 0;
        for(Bitmap b : bitmaps) {
            c.drawBitmap(b, 0, y, null);
            y += b.getHeight();
        }
        return combined;
    }

    private void deleteRecursive(File fileOrDirectory) {
        if (fileOrDirectory.isDirectory()) {
            for (File child : fileOrDirectory.listFiles()) {
                deleteRecursive(child);
            }
        }
        fileOrDirectory.delete();
    }
}
