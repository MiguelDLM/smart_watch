package com.example.dialsender;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DialEditorActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_CODE = 100;

    private FrameLayout previewContainer;
    private ImageView previewImage;
    private RecyclerView layerRecycler;
    private LinearLayout selectedLayerControls;
    private TextView txtSelectedLayer, txtLayerCount;
    private SeekBar seekScale, seekRotation;
    private Button btnUpload;

    private List<DialLayer> layers = new ArrayList<>();
    private int selectedLayerIndex = -1;
    private int pendingElementType = -1;
    private LayerAdapter layerAdapter;

    private int canvasWidth = 466;
    private int canvasHeight = 466;

    // Drag state
    private float dragStartX, dragStartY;
    private float layerStartX, layerStartY;
    private boolean isDragging = false;

    // Element categories - no more "preview" option since it's auto-generated
    private static final int[][] ELEMENT_CATEGORIES = {
        { DialCompiler.TYPE_DIGITAL_HOUR, DialCompiler.TYPE_DIGITAL_MIN, DialCompiler.TYPE_SECONDS,
          DialCompiler.TYPE_AMPM, DialCompiler.TYPE_WEEKDAY },
        { DialCompiler.TYPE_DAY, DialCompiler.TYPE_MONTH, DialCompiler.TYPE_YEAR },
        { DialCompiler.TYPE_ARM_HOUR, DialCompiler.TYPE_ARM_MIN, DialCompiler.TYPE_ARM_SEC },
        { DialCompiler.TYPE_STEPS, DialCompiler.TYPE_HEART, DialCompiler.TYPE_CALORIE, DialCompiler.TYPE_DISTANCE },
        { DialCompiler.TYPE_BATTERY, DialCompiler.TYPE_BATT_STRIP, DialCompiler.TYPE_CONNECT,
          DialCompiler.TYPE_WEATHER, DialCompiler.TYPE_TEMP },
        { DialCompiler.TYPE_ANIM, DialCompiler.TYPE_BERRY, DialCompiler.TYPE_LABEL,
          DialCompiler.TYPE_PROGRESS1, DialCompiler.TYPE_PROGRESS2 }
    };

    private String[] getCategoryNames() {
        return new String[]{
            getString(R.string.cat_time), getString(R.string.cat_date), getString(R.string.cat_analog),
            getString(R.string.cat_health), getString(R.string.cat_status), getString(R.string.cat_deco)
        };
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        SettingsActivity.applyGlobalTheme(this);
        super.onCreate(savedInstanceState);

        if (!Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }

        setContentView(R.layout.activity_dial_editor);

        previewContainer = findViewById(R.id.previewContainer);
        layerRecycler = findViewById(R.id.layerRecycler);
        selectedLayerControls = findViewById(R.id.selectedLayerControls);
        txtSelectedLayer = findViewById(R.id.txtSelectedLayer);
        txtLayerCount = findViewById(R.id.txtLayerCount);
        seekScale = findViewById(R.id.seekScale);
        seekRotation = findViewById(R.id.seekRotation);
        btnUpload = findViewById(R.id.btnUpload);

        findViewById(R.id.btnBackEditor).setOnClickListener(v -> finish());
        findViewById(R.id.btnAddElement).setOnClickListener(v -> showAddElementDialog());

        findViewById(R.id.btnMoveUp).setOnClickListener(v -> {
            if (selectedLayerIndex > 0) {
                DialLayer l = layers.remove(selectedLayerIndex);
                selectedLayerIndex--;
                layers.add(selectedLayerIndex, l);
                refreshAll();
            }
        });
        findViewById(R.id.btnMoveDown).setOnClickListener(v -> {
            if (selectedLayerIndex < layers.size() - 1) {
                DialLayer l = layers.remove(selectedLayerIndex);
                selectedLayerIndex++;
                layers.add(selectedLayerIndex, l);
                refreshAll();
            }
        });

        seekScale.setOnSeekBarChangeListener(new SimpleSeekListener() {
            @Override public void onProgressChanged(SeekBar sb, int progress, boolean fromUser) {
                if (fromUser && selectedLayerIndex >= 0 && selectedLayerIndex < layers.size()) {
                    layers.get(selectedLayerIndex).scale = progress / 100.0f;
                    updatePreview();
                }
            }
        });

        seekRotation.setOnSeekBarChangeListener(new SimpleSeekListener() {
            @Override public void onProgressChanged(SeekBar sb, int progress, boolean fromUser) {
                if (fromUser && selectedLayerIndex >= 0 && selectedLayerIndex < layers.size()) {
                    layers.get(selectedLayerIndex).rotation = progress;
                    updatePreview();
                }
            }
        });

        btnUpload.setOnClickListener(v -> showNameDialogThenCompile());

        layerAdapter = new LayerAdapter();
        layerRecycler.setLayoutManager(new LinearLayoutManager(this));
        layerRecycler.setAdapter(layerAdapter);

        // Setup preview with touch drag support
        setupPreviewTouch();

        refreshAll();
    }

    // ===================== TOUCH DRAG ON PREVIEW =====================

    private void setupPreviewTouch() {
        previewContainer.setOnTouchListener((v, event) -> {
            float viewW = v.getWidth();
            float viewH = v.getHeight();
            // Convert view touch coordinates to canvas coordinates
            float tx = event.getX() / viewW * canvasWidth;
            float ty = event.getY() / viewH * canvasHeight;

            switch (event.getActionMasked()) {
                case MotionEvent.ACTION_DOWN:
                    // Find which layer was tapped
                    int hitIdx = findLayerAt(tx, ty);
                    if (hitIdx >= 0) {
                        selectedLayerIndex = hitIdx;
                        isDragging = true;
                        dragStartX = tx;
                        dragStartY = ty;
                        DialLayer l = layers.get(hitIdx);
                        layerStartX = l.posX;
                        layerStartY = l.posY;
                        refreshAll();
                    }
                    return true;

                case MotionEvent.ACTION_MOVE:
                    if (isDragging && selectedLayerIndex >= 0 && selectedLayerIndex < layers.size()) {
                        float dx = tx - dragStartX;
                        float dy = ty - dragStartY;
                        DialLayer l = layers.get(selectedLayerIndex);
                        l.posX = layerStartX + dx;
                        l.posY = layerStartY + dy;
                        updatePreview();
                    }
                    return true;

                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    isDragging = false;
                    updateControls();
                    return true;
            }
            return false;
        });
    }

    private int findLayerAt(float x, float y) {
        for (int i = layers.size() - 1; i >= 0; i--) {
            DialLayer l = layers.get(i);
            Bitmap bmp = (l.frames != null && l.frames.length > 0) ? l.frames[0] : l.icon;
            if (bmp == null) continue;
            float w = bmp.getWidth() * l.scale;
            float h = bmp.getHeight() * l.scale;
            if (x >= l.posX && x <= l.posX + w && y >= l.posY && y <= l.posY + h) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns a localized label for a block type.
     */
    private String getBlockLabel(int type) {
        return getString(DialCompiler.blockTypeLabelRes(type));
    }

    // ===================== LAYER PANEL =====================

    private class LayerAdapter extends RecyclerView.Adapter<LayerAdapter.VH> {
        @NonNull
        @Override
        public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layer, parent, false);
            return new VH(v);
        }

        @Override
        public void onBindViewHolder(@NonNull VH holder, int position) {
            int layerIdx = layers.size() - 1 - position;
            DialLayer layer = layers.get(layerIdx);

            holder.txtName.setText(layer.name);
            holder.txtType.setText(DialCompiler.blockTypeToString(layer.nativeElementType));

            Bitmap thumb = (layer.frames != null && layer.frames.length > 0) ? layer.frames[0] : layer.icon;
            if (thumb != null) {
                holder.imgThumb.setImageBitmap(thumb);
            } else {
                holder.imgThumb.setImageBitmap(null);
            }

            if (layer.isSpriteSheet && layer.frameCount > 1) {
                holder.txtFrameBadge.setVisibility(View.VISIBLE);
                holder.txtFrameBadge.setText(layer.frameCount + "f");
            } else {
                holder.txtFrameBadge.setVisibility(View.GONE);
            }

            boolean isSelected = (layerIdx == selectedLayerIndex);
            holder.itemView.setAlpha(isSelected ? 1.0f : 0.7f);
            holder.itemView.setBackgroundColor(getResources().getColor(
                    isSelected ? R.color.bg_elevated : R.color.bg_card));

            holder.itemView.setOnClickListener(v -> {
                selectedLayerIndex = layerIdx;
                refreshAll();
            });

            holder.btnDelete.setOnClickListener(v -> {
                layers.remove(layerIdx);
                if (selectedLayerIndex >= layers.size()) {
                    selectedLayerIndex = layers.size() - 1;
                }
                refreshAll();
            });
        }

        @Override
        public int getItemCount() { return layers.size(); }

        class VH extends RecyclerView.ViewHolder {
            ImageView imgThumb;
            TextView txtName, txtType, txtFrameBadge, btnDelete;
            VH(View v) {
                super(v);
                imgThumb = v.findViewById(R.id.imgLayerThumb);
                txtName = v.findViewById(R.id.txtLayerName);
                txtType = v.findViewById(R.id.txtLayerType);
                txtFrameBadge = v.findViewById(R.id.txtFrameBadge);
                btnDelete = v.findViewById(R.id.btnDeleteLayer);
            }
        }
    }

    // ===================== ADD ELEMENT DIALOG =====================

    private void showAddElementDialog() {
        String[] catNames = getCategoryNames();
        // Top-level: Background, Scale (hour ring), then categories
        String[] topLevel = new String[catNames.length + 2];
        topLevel[0] = getString(R.string.bg_image);
        topLevel[1] = getString(R.string.cat_scale);
        System.arraycopy(catNames, 0, topLevel, 2, catNames.length);

        new AlertDialog.Builder(this)
            .setTitle(R.string.add_layer)
            .setItems(topLevel, (dialog, which) -> {
                if (which == 0) {
                    pendingElementType = DialCompiler.TYPE_BACKGROUND;
                    pickImageFromGallery();
                } else if (which == 1) {
                    showScalePicker(); // Watch face ring / scale
                } else {
                    showCategoryPicker(which - 2);
                }
            })
            .show();
    }

    private void showScalePicker() {
        // Load scale presets from time/pointer/scale/
        List<String> presetPaths = new ArrayList<>();
        String scaleBase = "dial_customize_2/time/pointer/scale";
        String[] scaleFiles = safeListAssets(scaleBase);
        for (String f : scaleFiles) {
            if (f.endsWith(".png")) {
                presetPaths.add(scaleBase + "/" + f);
            }
        }

        if (presetPaths.isEmpty()) {
            pendingElementType = DialCompiler.TYPE_BERRY;
            pickImageFromGallery();
            return;
        }

        List<String> options = new ArrayList<>();
        options.add(getString(R.string.from_gallery));
        for (int i = 0; i < presetPaths.size(); i++) {
            options.add("🔘  " + getString(R.string.style_label, String.valueOf(i + 1)));
        }

        new AlertDialog.Builder(this)
            .setTitle(R.string.cat_scale)
            .setItems(options.toArray(new String[0]), (dialog, which) -> {
                if (which == 0) {
                    pendingElementType = DialCompiler.TYPE_BERRY;
                    pickImageFromGallery();
                } else {
                    loadScalePreset(presetPaths.get(which - 1));
                }
            })
            .show();
    }

    private void loadScalePreset(String assetPath) {
        try {
            InputStream is = getAssets().open(assetPath);
            Bitmap bmp = BitmapFactory.decodeStream(is);
            is.close();
            if (bmp == null) {
                Toast.makeText(this, R.string.no_preset_images, Toast.LENGTH_SHORT).show();
                return;
            }
            // Scale is typically a full-size decoration overlay
            String name = getString(R.string.blk_scale);
            DialLayer layer = new DialLayer(DialLayer.TYPE_ELEMENT, bmp, name, DialCompiler.TYPE_BERRY);
            layer.frames = new Bitmap[]{bmp};
            layer.frameCount = 1;
            layer.isSpriteSheet = false;
            layer.alpha = 1.0f;
            layer.posX = 0;
            layer.posY = 0;
            // Auto-scale to canvas
            layer.scale = (float) canvasWidth / bmp.getWidth();

            layers.add(layer);
            selectedLayerIndex = layers.size() - 1;
            refreshAll();

            Toast.makeText(this, "✓ " + name, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void showCategoryPicker(int categoryIndex) {
        String[] catNames = getCategoryNames();
        int[] types = ELEMENT_CATEGORIES[categoryIndex];
        String[] labels = new String[types.length];
        for (int i = 0; i < types.length; i++) {
            int frames = DialCompiler.getDefaultFrameCount(types[i]);
            String frameLabel = frames > 1 ? " (" + frames + " frames)" : "";
            labels[i] = getBlockLabel(types[i]) + frameLabel;
        }

        new AlertDialog.Builder(this)
            .setTitle(catNames[categoryIndex])
            .setItems(labels, (dialog, which) -> {
                int selectedType = types[which];
                showSourcePicker(selectedType);
            })
            .show();
    }

    private void showSourcePicker(int elementType) {
        List<String> presetPaths = findPresetFolders(elementType);

        List<String> options = new ArrayList<>();
        options.add(getString(R.string.from_gallery));
        for (String p : presetPaths) {
            int lastSlash = p.lastIndexOf('/');
            String styleName = lastSlash >= 0
                    ? getString(R.string.style_label, p.substring(lastSlash + 1))
                    : p;
            options.add("🎨  " + styleName);
        }

        new AlertDialog.Builder(this)
            .setTitle(getBlockLabel(elementType))
            .setItems(options.toArray(new String[0]), (dialog, which) -> {
                if (which == 0) {
                    pendingElementType = elementType;
                    pickImageFromGallery();
                } else {
                    loadPreset(presetPaths.get(which - 1), elementType);
                }
            })
            .show();
    }

    // ===================== ASSET PRESET LOADING =====================

    private List<String> findPresetFolders(int elementType) {
        List<String> found = new ArrayList<>();
        String base = "dial_customize_2";

        try {
            switch (elementType) {
                // === ANALOG HANDS (pointer/pointer/hour|minute|second) ===
                case DialCompiler.TYPE_ARM_HOUR: {
                    String pointerDir = base + "/time/pointer/pointer/hour";
                    String[] files = safeListAssets(pointerDir);
                    for (String f : files) {
                        if (f.endsWith(".png")) {
                            found.add(pointerDir + "/" + f);
                        }
                    }
                    break;
                }
                case DialCompiler.TYPE_ARM_MIN: {
                    String pointerDir = base + "/time/pointer/pointer/minute";
                    String[] files = safeListAssets(pointerDir);
                    for (String f : files) {
                        if (f.endsWith(".png")) {
                            found.add(pointerDir + "/" + f);
                        }
                    }
                    break;
                }
                case DialCompiler.TYPE_ARM_SEC: {
                    String pointerDir = base + "/time/pointer/pointer/second";
                    String[] files = safeListAssets(pointerDir);
                    for (String f : files) {
                        if (f.endsWith(".png")) {
                            found.add(pointerDir + "/" + f);
                        }
                    }
                    break;
                }

                // === DIGITAL DIGITS (time/digital/X/hour_minute) ===
                case DialCompiler.TYPE_DIGITAL_HOUR:
                case DialCompiler.TYPE_DIGITAL_MIN:
                case DialCompiler.TYPE_SECONDS:
                case DialCompiler.TYPE_HOUR_HI:
                case DialCompiler.TYPE_HOUR_LO:
                case DialCompiler.TYPE_MIN_HI:
                case DialCompiler.TYPE_MIN_LO: {
                    String digitalBase = base + "/time/digital";
                    String[] styles = safeListAssets(digitalBase);
                    for (String style : styles) {
                        String path = digitalBase + "/" + style + "/hour_minute";
                        if (hasAssetFile(path + "/0.png")) {
                            found.add(path);
                        }
                    }
                    break;
                }
                case DialCompiler.TYPE_WEEKDAY: {
                    String digitalBase = base + "/time/digital";
                    String[] styles = safeListAssets(digitalBase);
                    for (String style : styles) {
                        String path = digitalBase + "/" + style + "/week";
                        if (hasAssetFile(path + "/0.png")) {
                            found.add(path);
                        }
                    }
                    break;
                }
                case DialCompiler.TYPE_AMPM: {
                    String digitalBase = base + "/time/digital";
                    String[] styles = safeListAssets(digitalBase);
                    for (String style : styles) {
                        String path = digitalBase + "/" + style + "/am_pm";
                        if (hasAssetFile(path + "/am.png")) {
                            found.add(path);
                        }
                    }
                    break;
                }

                // === DATE DIGITS ===
                case DialCompiler.TYPE_DAY:
                case DialCompiler.TYPE_MONTH:
                case DialCompiler.TYPE_YEAR: {
                    String digitalBase = base + "/time/digital";
                    String[] styles = safeListAssets(digitalBase);
                    for (String style : styles) {
                        String path = digitalBase + "/" + style + "/date";
                        if (hasAssetFile(path + "/0.png")) {
                            found.add(path);
                        }
                    }
                    break;
                }

                // === HEALTH/VALUE DIGITS ===
                case DialCompiler.TYPE_STEPS:
                case DialCompiler.TYPE_HEART:
                case DialCompiler.TYPE_CALORIE:
                case DialCompiler.TYPE_DISTANCE:
                case DialCompiler.TYPE_TEMP:
                case DialCompiler.TYPE_BATTERY: {
                    String valueBase = base + "/value";
                    String[] styles = safeListAssets(valueBase);
                    for (String style : styles) {
                        String path = valueBase + "/" + style;
                        if (hasAssetFile(path + "/0.png")) {
                            found.add(path);
                        }
                    }
                    break;
                }
            }
        } catch (Exception e) {
            // Directory doesn't exist
        }
        return found;
    }

    private String[] safeListAssets(String path) {
        try {
            String[] list = getAssets().list(path);
            return list != null ? list : new String[0];
        } catch (Exception e) {
            return new String[0];
        }
    }

    private boolean hasAssetFile(String path) {
        try {
            InputStream is = getAssets().open(path);
            is.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void loadPreset(String assetPath, int elementType) {
        try {
            // Check if this is a single file (pointer hand) or a folder (digit set)
            boolean isSingleFile = assetPath.endsWith(".png");

            if (isSingleFile) {
                // Single image file (analog hand)
                InputStream is = getAssets().open(assetPath);
                Bitmap bmp = BitmapFactory.decodeStream(is);
                is.close();
                if (bmp == null) {
                    Toast.makeText(this, R.string.no_preset_images, Toast.LENGTH_SHORT).show();
                    return;
                }
                String name = getBlockLabel(elementType);
                DialLayer layer = new DialLayer(DialLayer.TYPE_ARM, bmp, name, elementType);
                layer.frames = new Bitmap[]{bmp};
                layer.frameCount = 1;
                layer.isSpriteSheet = false;
                layer.alpha = 1.0f;
                // Center analog hands
                layer.posX = (canvasWidth - bmp.getWidth()) / 2f;
                layer.posY = (canvasHeight - bmp.getHeight()) / 2f;

                layers.add(layer);
                selectedLayerIndex = layers.size() - 1;
                refreshAll();
                Toast.makeText(this, "✓ " + name, Toast.LENGTH_SHORT).show();
                return;
            }

            // Folder with numbered images (digit set)
            int expectedFrames = DialCompiler.getDefaultFrameCount(elementType);
            List<Bitmap> loadedFrames = new ArrayList<>();

            if (elementType == DialCompiler.TYPE_AMPM) {
                for (String name : new String[]{"am.png", "pm.png"}) {
                    try {
                        InputStream is = getAssets().open(assetPath + "/" + name);
                        Bitmap bmp = BitmapFactory.decodeStream(is);
                        is.close();
                        if (bmp != null) loadedFrames.add(bmp);
                    } catch (Exception e) { /* skip */ }
                }
            } else {
                for (int i = 0; i < expectedFrames; i++) {
                    try {
                        InputStream is = getAssets().open(assetPath + "/" + i + ".png");
                        Bitmap bmp = BitmapFactory.decodeStream(is);
                        is.close();
                        if (bmp != null) loadedFrames.add(bmp);
                    } catch (Exception e) { /* skip */ }
                }
            }

            if (loadedFrames.isEmpty()) {
                Toast.makeText(this, R.string.no_preset_images, Toast.LENGTH_SHORT).show();
                return;
            }

            Bitmap[] frames = loadedFrames.toArray(new Bitmap[0]);
            String name = getBlockLabel(elementType);
            DialLayer layer = new DialLayer(DialLayer.TYPE_ELEMENT, frames[0], name, elementType);
            layer.frames = frames;
            layer.frameCount = frames.length;
            layer.isSpriteSheet = frames.length > 1;
            layer.alpha = 1.0f;
            layer.posX = canvasWidth / 4f;
            layer.posY = canvasHeight / 4f;

            layers.add(layer);
            selectedLayerIndex = layers.size() - 1;
            refreshAll();

            Toast.makeText(this, "✓ " + name + " — " + frames.length + " frames", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    // ===================== GALLERY PICK =====================

    private void pickImageFromGallery() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, PICK_IMAGE_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_CODE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            try {
                InputStream is = getContentResolver().openInputStream(data.getData());
                Bitmap bmp = BitmapFactory.decodeStream(is);
                is.close();

                if (pendingElementType == DialCompiler.TYPE_BACKGROUND) {
                    addBackgroundLayer(bmp);
                } else {
                    addSpriteSheetLayer(bmp, pendingElementType);
                }
                pendingElementType = -1;
            } catch (Exception e) {
                Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void addBackgroundLayer(Bitmap bmp) {
        Bitmap scaled = Bitmap.createScaledBitmap(bmp, canvasWidth, canvasHeight, true);
        DialLayer layer = new DialLayer(DialLayer.TYPE_BACKGROUND, scaled,
                getBlockLabel(DialCompiler.TYPE_BACKGROUND), DialCompiler.TYPE_BACKGROUND);
        layer.frames = new Bitmap[]{scaled};
        layers.add(0, layer);
        selectedLayerIndex = 0;
        refreshAll();
    }

    private void addSpriteSheetLayer(Bitmap compositeBmp, int elementType) {
        int expectedFrames = DialCompiler.getDefaultFrameCount(elementType);

        Bitmap[] frames;
        if (expectedFrames > 1 && compositeBmp.getHeight() > compositeBmp.getWidth()) {
            // Vertical sprite sheet
            int frameWidth = compositeBmp.getWidth();
            int frameHeight = compositeBmp.getHeight() / expectedFrames;
            frames = new Bitmap[expectedFrames];
            for (int i = 0; i < expectedFrames; i++) {
                int y = i * frameHeight;
                if (y + frameHeight > compositeBmp.getHeight()) {
                    frames[i] = Bitmap.createBitmap(frameWidth, frameHeight, Bitmap.Config.ARGB_8888);
                } else {
                    frames[i] = Bitmap.createBitmap(compositeBmp, 0, y, frameWidth, frameHeight);
                }
            }
        } else {
            frames = new Bitmap[]{compositeBmp};
        }

        String name = getBlockLabel(elementType);
        DialLayer layer = new DialLayer(DialLayer.TYPE_ELEMENT, frames[0], name, elementType);
        layer.frames = frames;
        layer.frameCount = frames.length;
        layer.isSpriteSheet = frames.length > 1;
        layer.compositeImage = compositeBmp;
        layer.alpha = 1.0f;
        layer.posX = canvasWidth / 4f;
        layer.posY = canvasHeight / 4f;

        layers.add(layer);
        selectedLayerIndex = layers.size() - 1;
        refreshAll();
    }

    // ===================== PREVIEW + CONTROLS =====================

    private void refreshAll() {
        updatePreview();
        layerAdapter.notifyDataSetChanged();
        updateControls();
    }

    private void updatePreview() {
        Bitmap preview = Bitmap.createBitmap(canvasWidth, canvasHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(preview);
        canvas.drawColor(Color.BLACK);

        for (int i = 0; i < layers.size(); i++) {
            DialLayer layer = layers.get(i);
            Bitmap drawBmp = (layer.frames != null && layer.frames.length > 0) ? layer.frames[0] : layer.icon;
            if (drawBmp == null) continue;

            Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            paint.setAlpha((int)(layer.alpha * 255));

            Matrix m = new Matrix();
            float scaledW = drawBmp.getWidth() * layer.scale;
            float scaledH = drawBmp.getHeight() * layer.scale;
            m.postScale(layer.scale, layer.scale);
            if (layer.rotation != 0) {
                m.postRotate(layer.rotation, scaledW / 2, scaledH / 2);
            }
            m.postTranslate(layer.posX, layer.posY);
            canvas.drawBitmap(drawBmp, m, paint);

            if (i == selectedLayerIndex) {
                Paint border = new Paint();
                border.setStyle(Paint.Style.STROKE);
                border.setColor(Color.parseColor("#58A6FF"));
                border.setStrokeWidth(2);
                canvas.drawRect(layer.posX, layer.posY,
                    layer.posX + scaledW, layer.posY + scaledH, border);
            }
        }

        // Use a single ImageView managed by the container
        if (previewImage == null) {
            previewImage = new ImageView(this);
            previewImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
            previewContainer.addView(previewImage,
                new FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT));
        }
        previewImage.setImageBitmap(preview);

        txtLayerCount.setText(String.valueOf(layers.size()));
    }

    private void updateControls() {
        if (selectedLayerIndex >= 0 && selectedLayerIndex < layers.size()) {
            selectedLayerControls.setVisibility(View.VISIBLE);
            DialLayer layer = layers.get(selectedLayerIndex);
            String info = layer.name;
            if (layer.isSpriteSheet) info += " • " + layer.frameCount + " frames";
            txtSelectedLayer.setText(info);
            seekScale.setProgress((int)(layer.scale * 100));
            seekRotation.setProgress((int)layer.rotation);
        } else {
            selectedLayerControls.setVisibility(View.GONE);
        }
    }

    // ===================== COMPILE WITH NAME =====================

    private void showNameDialogThenCompile() {
        if (layers.isEmpty()) {
            Toast.makeText(this, R.string.add_one_layer, Toast.LENGTH_SHORT).show();
            return;
        }

        EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        input.setHint(R.string.dial_name_hint);
        input.setPadding(48, 24, 48, 24);

        new AlertDialog.Builder(this)
            .setTitle(R.string.enter_dial_name)
            .setView(input)
            .setPositiveButton(R.string.save, (dialog, which) -> {
                String name = input.getText().toString().trim();
                if (name.isEmpty()) name = "dial";
                // Sanitize: replace spaces with _, remove non-alphanumeric except _-
                name = name.replaceAll("[^a-zA-Z0-9_\\-]", "_");
                
                // Check for duplicates
                File userDialsDir = DialLibraryActivity.getUserDialsDir(this);
                File targetFile = new File(userDialsDir, name + ".bin");
                if (targetFile.exists()) {
                    Toast.makeText(this, "Name already exists. Please choose another.", Toast.LENGTH_LONG).show();
                    return;
                }
                
                compileAndFinish(name);
            })
            .setNegativeButton(R.string.cancel, null)
            .show();
    }

    private void compileAndFinish(String dialName) {
        btnUpload.setEnabled(false);
        btnUpload.setText(R.string.compiling);

        new Thread(() -> {
            try {
                DialCompiler compiler = new DialCompiler(canvasWidth, canvasHeight);

                // Auto-generate preview from current canvas state
                Bitmap previewBmp = Bitmap.createBitmap(canvasWidth, canvasHeight, Bitmap.Config.ARGB_8888);
                Canvas c = new Canvas(previewBmp);
                c.drawColor(Color.BLACK);
                for (DialLayer l : layers) {
                    Bitmap bmp = (l.frames != null && l.frames.length > 0) ? l.frames[0] : l.icon;
                    if (bmp != null) {
                        Matrix m = new Matrix();
                        m.postScale(l.scale, l.scale);
                        if (l.rotation != 0) {
                            float sw = bmp.getWidth() * l.scale;
                            float sh = bmp.getHeight() * l.scale;
                            m.postRotate(l.rotation, sw / 2, sh / 2);
                        }
                        m.postTranslate(l.posX, l.posY);
                        c.drawBitmap(bmp, m, null);
                    }
                }
                
                // RESIZE PREVIEW TO 280x280 (Required by chipset)
                Bitmap scaledPreview = Bitmap.createScaledBitmap(previewBmp, 280, 280, true);
                
                DialCompiler.DialBlock previewBlock = new DialCompiler.DialBlock();
                previewBlock.type = DialCompiler.TYPE_PREVIEW;
                previewBlock.width = 280;
                previewBlock.height = 280;
                previewBlock.x = 0;
                previewBlock.y = 0;
                previewBlock.frames = 1;
                previewBlock.images = new Bitmap[]{scaledPreview};
                compiler.addBlock(previewBlock);

                for (DialLayer layer : layers) {
                    DialCompiler.DialBlock block = new DialCompiler.DialBlock();
                    block.type = layer.nativeElementType;
                    block.x = (int) layer.posX;
                    block.y = (int) layer.posY;

                    if (layer.frames != null && layer.frames.length > 0) {
                        block.images = layer.frames;
                        block.frames = layer.frames.length;
                        block.width = layer.frames[0].getWidth();
                        block.height = layer.frames[0].getHeight();
                    } else if (layer.icon != null) {
                        block.images = new Bitmap[]{layer.icon};
                        block.frames = 1;
                        block.width = layer.icon.getWidth();
                        block.height = layer.icon.getHeight();
                    }

                    block.width = (int)(block.width * layer.scale);
                    block.height = (int)(block.height * layer.scale);
                    block.hasAlpha = (block.type != DialCompiler.TYPE_BACKGROUND &&
                                     block.type != DialCompiler.TYPE_PREVIEW);

                    // Analog hands use RAW compression (0) instead of RLE (4)
                    if (block.type == DialCompiler.TYPE_ARM_HOUR ||
                        block.type == DialCompiler.TYPE_ARM_MIN ||
                        block.type == DialCompiler.TYPE_ARM_SEC) {
                        block.compress = 0;
                    }

                    compiler.addBlock(block);
                }

                String filename = dialName + ".bin";

                File cacheDir = getCacheDir();
                File outFile = compiler.compile(cacheDir, filename);

                if (outFile != null && outFile.exists()) {
                    File userDialsDir = DialLibraryActivity.getUserDialsDir(this);
                    File savedFile = new File(userDialsDir, filename);
                    copyFile(outFile, savedFile);

                    String size = outFile.length() > 1024
                            ? String.format("%.1f KB", outFile.length() / 1024.0)
                            : outFile.length() + " bytes";

                    runOnUiThread(() -> {
                        btnUpload.setEnabled(true);
                        btnUpload.setText(R.string.compile);
                        Toast.makeText(this, "✅ " + filename + " (" + size + ")\n" +
                                getString(R.string.saved_to_library), Toast.LENGTH_LONG).show();
                    });
                }
            } catch (Exception e) {
                runOnUiThread(() -> {
                    btnUpload.setEnabled(true);
                    btnUpload.setText(R.string.compile);
                    Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                });
            }
        }).start();
    }

    private void copyFile(File src, File dst) throws IOException {
        java.io.FileInputStream fis = new java.io.FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(dst);
        byte[] buf = new byte[4096];
        int len;
        while ((len = fis.read(buf)) > 0) fos.write(buf, 0, len);
        fos.close();
        fis.close();
    }

    private static abstract class SimpleSeekListener implements SeekBar.OnSeekBarChangeListener {
        @Override public void onStartTrackingTouch(SeekBar sb) {}
        @Override public void onStopTrackingTouch(SeekBar sb) {}
    }
}
