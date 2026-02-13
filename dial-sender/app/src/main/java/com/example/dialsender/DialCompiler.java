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

    // ======== Block Types (matching comp_decomp.py BlockType enum) ========
    // Preview/Background
    public static final int TYPE_PREVIEW = 0x01;
    public static final int TYPE_BACKGROUND = 0x02;
    // Analog clock hands
    public static final int TYPE_ARM_HOUR = 0x03;
    public static final int TYPE_ARM_MIN = 0x04;
    public static final int TYPE_ARM_SEC = 0x05;
    // Date/Time
    public static final int TYPE_YEAR = 0x06;
    public static final int TYPE_MONTH = 0x07;
    public static final int TYPE_DAY = 0x08;
    public static final int TYPE_DIGITAL_HOUR = 0x09;
    public static final int TYPE_DIGITAL_MIN = 0x0A;
    public static final int TYPE_SECONDS = 0x0B;
    public static final int TYPE_AMPM = 0x0C;
    public static final int TYPE_WEEKDAY = 0x0D;
    // Health/Activity
    public static final int TYPE_STEPS = 0x0E;
    public static final int TYPE_HEART = 0x0F;
    public static final int TYPE_CALORIE = 0x10;
    public static final int TYPE_DISTANCE = 0x11;
    // Status
    public static final int TYPE_BATTERY = 0x12;
    public static final int TYPE_CONNECT = 0x13;
    // Decoration
    public static final int TYPE_BERRY = 0x16;
    public static final int TYPE_ANIM = 0x17;
    public static final int TYPE_BATT_STRIP = 0x18;
    public static final int TYPE_WEATHER = 0x19;
    public static final int TYPE_TEMP = 0x1A;
    // Progress bars
    public static final int TYPE_PROGRESS2 = 0x1E;
    public static final int TYPE_PROGRESS1 = 0x20;
    // Labels
    public static final int TYPE_LABEL = 0x25;
    // Digit splits
    public static final int TYPE_HOUR_LO = 0x27;
    public static final int TYPE_HOUR_HI = 0x28;
    public static final int TYPE_MIN_HI = 0x29;
    public static final int TYPE_MIN_LO = 0x2A;

    /**
     * Returns the BLK_xxx type string for a given block type code.
     * Used to populate dial_desc.json for comp_decomp.py.
     */
    public static String blockTypeToString(int type) {
        switch (type) {
            case TYPE_PREVIEW:
                return "BLK_PREV";
            case TYPE_BACKGROUND:
                return "BLK_BGIMG";
            case TYPE_ARM_HOUR:
                return "BLK_ARMH";
            case TYPE_ARM_MIN:
                return "BLK_ARMM";
            case TYPE_ARM_SEC:
                return "BLK_ARMS";
            case TYPE_YEAR:
                return "BLK_YEAR";
            case TYPE_MONTH:
                return "BLK_MONTH";
            case TYPE_DAY:
                return "BLK_DAY";
            case TYPE_DIGITAL_HOUR:
                return "BLK_HOUR";
            case TYPE_DIGITAL_MIN:
                return "BLK_MIN";
            case TYPE_SECONDS:
                return "BLK_SEC";
            case TYPE_AMPM:
                return "BLK_AMPM";
            case TYPE_WEEKDAY:
                return "BLK_WEEKD";
            case TYPE_STEPS:
                return "BLK_STEPS";
            case TYPE_HEART:
                return "BLK_PULSE";
            case TYPE_CALORIE:
                return "BLK_CALOR";
            case TYPE_DISTANCE:
                return "BLK_DIST";
            case TYPE_BATTERY:
                return "BLK_BATTN";
            case TYPE_CONNECT:
                return "BLK_CONN";
            case TYPE_BERRY:
                return "BLK_BERRY";
            case TYPE_ANIM:
                return "BLK_ANIM";
            case TYPE_BATT_STRIP:
                return "BLK_BATTS";
            case TYPE_WEATHER:
                return "BLK_WEAT";
            case TYPE_TEMP:
                return "BLK_TEMP";
            case TYPE_PROGRESS2:
                return "BLK_PROG2";
            case TYPE_PROGRESS1:
                return "BLK_PROG1";
            case TYPE_LABEL:
                return "BLK_LABEL";
            case TYPE_HOUR_LO:
                return "BLK_HOURL";
            case TYPE_HOUR_HI:
                return "BLK_HOURH";
            case TYPE_MIN_HI:
                return "BLK_MINH";
            case TYPE_MIN_LO:
                return "BLK_MINL";
            default:
                return "BLK_UNKNOWN";
        }
    }

    /**
     * Returns the expected frame count for a given block type.
     * This is how many sub-images a vertical sprite-sheet should contain.
     */
    public static int getDefaultFrameCount(int type) {
        switch (type) {
            case TYPE_DIGITAL_HOUR:
            case TYPE_DIGITAL_MIN:
            case TYPE_SECONDS:
            case TYPE_STEPS:
            case TYPE_HEART:
            case TYPE_CALORIE:
            case TYPE_DISTANCE:
            case TYPE_DAY:
            case TYPE_YEAR:
            case TYPE_HOUR_LO:
            case TYPE_HOUR_HI:
            case TYPE_MIN_HI:
            case TYPE_MIN_LO:
            case TYPE_TEMP:
                return 10; // digits 0-9
            case TYPE_WEEKDAY:
                return 7; // Mon-Sun
            case TYPE_MONTH:
                return 12; // Jan-Dec
            case TYPE_AMPM:
                return 2; // AM, PM
            case TYPE_BATTERY:
                return 5; // battery levels
            case TYPE_BATT_STRIP:
                return 5; // battery strip levels
            case TYPE_WEATHER:
                return 7; // weather icons
            case TYPE_CONNECT:
                return 2; // connected, disconnected
            default:
                return 1; // single image
        }
    }

    /**
     * Returns a user-friendly label for a block type.
     */
    public static String blockTypeLabel(int type) {
        switch (type) {
            case TYPE_PREVIEW:
                return "Vista previa";
            case TYPE_BACKGROUND:
                return "Fondo";
            case TYPE_ARM_HOUR:
                return "Manecilla Hora";
            case TYPE_ARM_MIN:
                return "Manecilla Minuto";
            case TYPE_ARM_SEC:
                return "Manecilla Segundo";
            case TYPE_YEAR:
                return "Año";
            case TYPE_MONTH:
                return "Mes";
            case TYPE_DAY:
                return "Día";
            case TYPE_DIGITAL_HOUR:
                return "Hora (digital)";
            case TYPE_DIGITAL_MIN:
                return "Minuto (digital)";
            case TYPE_SECONDS:
                return "Segundos";
            case TYPE_AMPM:
                return "AM/PM";
            case TYPE_WEEKDAY:
                return "Día de semana";
            case TYPE_STEPS:
                return "Pasos";
            case TYPE_HEART:
                return "Pulso";
            case TYPE_CALORIE:
                return "Calorías";
            case TYPE_DISTANCE:
                return "Distancia";
            case TYPE_BATTERY:
                return "Batería (número)";
            case TYPE_CONNECT:
                return "Conexión";
            case TYPE_BERRY:
                return "Decoración";
            case TYPE_ANIM:
                return "Animación";
            case TYPE_BATT_STRIP:
                return "Batería (barra)";
            case TYPE_WEATHER:
                return "Clima";
            case TYPE_TEMP:
                return "Temperatura";
            case TYPE_PROGRESS2:
                return "Barra progreso 2";
            case TYPE_PROGRESS1:
                return "Barra progreso 1";
            case TYPE_LABEL:
                return "Etiqueta";
            case TYPE_HOUR_LO:
                return "Hora dígito bajo";
            case TYPE_HOUR_HI:
                return "Hora dígito alto";
            case TYPE_MIN_HI:
                return "Minuto dígito alto";
            case TYPE_MIN_LO:
                return "Minuto dígito bajo";
            default:
                return "Desconocido";
        }
    }

    /**
     * Returns the string resource ID for a given block type,
     * for use with getString() in activities.
     */
    public static int blockTypeLabelRes(int type) {
        switch (type) {
            case TYPE_PREVIEW:
                return R.string.blk_preview;
            case TYPE_BACKGROUND:
                return R.string.blk_background;
            case TYPE_ARM_HOUR:
                return R.string.blk_arm_hour;
            case TYPE_ARM_MIN:
                return R.string.blk_arm_min;
            case TYPE_ARM_SEC:
                return R.string.blk_arm_sec;
            case TYPE_YEAR:
                return R.string.blk_year;
            case TYPE_MONTH:
                return R.string.blk_month;
            case TYPE_DAY:
                return R.string.blk_day;
            case TYPE_DIGITAL_HOUR:
                return R.string.blk_hour;
            case TYPE_DIGITAL_MIN:
                return R.string.blk_min;
            case TYPE_SECONDS:
                return R.string.blk_sec;
            case TYPE_AMPM:
                return R.string.blk_ampm;
            case TYPE_WEEKDAY:
                return R.string.blk_weekday;
            case TYPE_STEPS:
                return R.string.blk_steps;
            case TYPE_HEART:
                return R.string.blk_heart;
            case TYPE_CALORIE:
                return R.string.blk_calorie;
            case TYPE_DISTANCE:
                return R.string.blk_distance;
            case TYPE_BATTERY:
                return R.string.blk_battery;
            case TYPE_CONNECT:
                return R.string.blk_connect;
            case TYPE_BERRY:
                return R.string.blk_berry;
            case TYPE_ANIM:
                return R.string.blk_anim;
            case TYPE_BATT_STRIP:
                return R.string.blk_batt_strip;
            case TYPE_WEATHER:
                return R.string.blk_weather;
            case TYPE_TEMP:
                return R.string.blk_temp;
            case TYPE_PROGRESS2:
                return R.string.blk_prog2;
            case TYPE_PROGRESS1:
                return R.string.blk_prog1;
            case TYPE_LABEL:
                return R.string.blk_label;
            case TYPE_HOUR_LO:
                return R.string.blk_hour_lo;
            case TYPE_HOUR_HI:
                return R.string.blk_hour_hi;
            case TYPE_MIN_HI:
                return R.string.blk_min_hi;
            case TYPE_MIN_LO:
                return R.string.blk_min_lo;
            default:
                return R.string.blk_unknown;
        }
    }

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
        public int compress = 4; // Default to RLE (4=RLE in comp_decomp)
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
        Log.d(TAG, "Starting comp_decomp Compilation...");

        if (!Python.isStarted()) {
            throw new RuntimeException("Python not started. Initialize in Application or Activity.");
        }

        // 1. Prepare temp directory
        File tempDir = new File(outputDir, "temp_compile_" + System.currentTimeMillis());
        if (!tempDir.exists() && !tempDir.mkdirs()) {
            throw new IOException("Failed to create temp directory");
        }

        // 2. Build dial_desc.json for comp_decomp.py
        JSONObject root = new JSONObject();
        root.put("dial_name", filename);
        JSONArray jsonBlocks = new JSONArray();

        int nextPicIdx = 0;
        int blockIndex = 0;
        for (DialBlock block : blocks) {
            if (block.images == null || block.images.length == 0) {
                blockIndex++;
                continue;
            }

            JSONObject cb = new JSONObject();
            cb.put("type", blockTypeToString(block.type));
            cb.put("frms", Math.max(1, block.frames));
            String imgFilename = "block_" + blockIndex + ".png";
            cb.put("fname", imgFilename);
            cb.put("reuse", false);
            cb.put("colsp", block.hasAlpha ? "RGBA" : "RGB");
            cb.put("width", block.width);
            cb.put("height", block.height);
            cb.put("posx", block.x);
            cb.put("posy", block.y);
            cb.put("alnx", 9);
            cb.put("comp", block.compress);
            cb.put("ctx", 0);
            cb.put("cty", 0);

            jsonBlocks.put(cb);

            // Save combined image (vertical sprite sheet)
            Bitmap imageToSave = combineBitmapsVertically(block.images);
            File imgFile = new File(tempDir, imgFilename);
            try (FileOutputStream fos = new FileOutputStream(imgFile)) {
                imageToSave.compress(Bitmap.CompressFormat.PNG, 100, fos);
            }

            nextPicIdx += block.images.length;
            blockIndex++;
        }

        root.put("blocks", jsonBlocks);

        // Save dial_desc.json
        File jsonFile = new File(tempDir, "dial_desc.json");
        try (FileOutputStream fos = new FileOutputStream(jsonFile)) {
            fos.write(root.toString(2).getBytes());
        }
        Log.d(TAG, "Wrote dial_desc.json to " + jsonFile.getAbsolutePath());

        // 3. Call comp_decomp.compile_dial()
        Python py = Python.getInstance();
        File outFile = new File(outputDir, filename);

        try {
            PyObject compMod = py.getModule("comp_decomp");
            Log.d(TAG, "Using comp_decomp.compile_dial() to build dial");
            PyObject res = compMod.callAttr("compile_dial", tempDir.getAbsolutePath(), outFile.getAbsolutePath());
            if (res != null && res.toBoolean()) {
                Log.d(TAG, "Compilation Success: " + outFile.length() + " bytes");
                deleteRecursive(tempDir);
                return outFile;
            } else {
                throw new Exception("comp_decomp.compile_dial() returned false");
            }
        } catch (Exception e) {
            throw new Exception("Python compilation failed: " + e.getMessage());
        }
    }

    private Bitmap combineBitmapsVertically(Bitmap[] bitmaps) {
        if (bitmaps.length == 1)
            return bitmaps[0];
        int w = bitmaps[0].getWidth();
        int h = 0;
        for (Bitmap b : bitmaps)
            h += b.getHeight();

        // Preserve the input config (RGB_565 for backgrounds, ARGB_8888 for RGBA)
        Bitmap.Config config = bitmaps[0].getConfig();
        if (config == null)
            config = Bitmap.Config.ARGB_8888;
        Bitmap combined = Bitmap.createBitmap(w, h, config);
        Canvas c = new Canvas(combined);
        if (config == Bitmap.Config.RGB_565) {
            // Fill black for RGB (no alpha) to avoid uninitialized pixels
            c.drawColor(android.graphics.Color.BLACK);
        }
        int y = 0;
        for (Bitmap b : bitmaps) {
            c.drawBitmap(b, 0, y, null);
            y += b.getHeight();
        }
        return combined;
    }

    private void deleteRecursive(File fileOrDirectory) {
        if (fileOrDirectory.isDirectory()) {
            File[] children = fileOrDirectory.listFiles();
            if (children != null) {
                for (File child : children) {
                    deleteRecursive(child);
                }
            }
        }
        fileOrDirectory.delete();
    }
}
