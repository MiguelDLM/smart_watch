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
import android.widget.CheckBox;
import android.graphics.Rect;
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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Typeface;
import android.graphics.BlurMaskFilter;
import android.graphics.drawable.GradientDrawable;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

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
import java.text.DateFormatSymbols;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.PreserveAspectRatio;

public class DialEditorActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_CODE = 100;
    private static final int PICK_SVG_CODE = 101;

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
    private String suggestedDialName;

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
        return new String[] {
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
            @Override
            public void onProgressChanged(SeekBar sb, int progress, boolean fromUser) {
                if (fromUser && selectedLayerIndex >= 0 && selectedLayerIndex < layers.size()) {
                    layers.get(selectedLayerIndex).scale = progress / 100.0f;
                    updatePreview();
                }
            }
        });

        seekRotation.setOnSeekBarChangeListener(new SimpleSeekListener() {
            @Override
            public void onProgressChanged(SeekBar sb, int progress, boolean fromUser) {
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

        loadEditableDialPreview();
        refreshAll();
    }

    private void loadEditableDialPreview() {
        suggestedDialName = getIntent().getStringExtra("edit_dial_name");
        String editFolder = getIntent().getStringExtra("edit_dial_folder");
        String previewPath = getIntent().getStringExtra("edit_preview_path");

        if (editFolder != null) {
            File folder = new File(editFolder);
            File jsonFile = new File(folder, "dial_desc.json");
            if (jsonFile.exists()) {
                try {
                    String jsonStr = new String(java.nio.file.Files.readAllBytes(jsonFile.toPath()));
                    org.json.JSONObject desc = new org.json.JSONObject(jsonStr);
                    org.json.JSONArray blocks = desc.getJSONArray("blocks");

                    for (int i = 0; i < blocks.length(); i++) {
                        org.json.JSONObject b = blocks.getJSONObject(i);
                        String typeStr = b.getString("type");
                        int elementType = DialCompiler.getTypeFromString(typeStr);

                        if (elementType == DialCompiler.TYPE_PREVIEW) {
                            continue;
                        }

                        String fname = b.optString("fname", null);

                        if (fname == null || fname.isEmpty() || fname.equals("null")) {
                            continue;
                        }

                        File imgFile = new File(folder, fname);
                        if (!imgFile.exists())
                            continue;

                        BitmapFactory.Options opts = new BitmapFactory.Options();
                        opts.inPreferredConfig = b.optString("colsp", "RGB").equals("RGB") ? Bitmap.Config.RGB_565
                                : Bitmap.Config.ARGB_8888;
                        Bitmap fullBmp = BitmapFactory.decodeFile(imgFile.getAbsolutePath(), opts);

                        if (fullBmp == null)
                            continue;

                        int frms = b.optInt("frms", 1);
                        int frameH = fullBmp.getHeight() / frms;
                        Bitmap[] frames = new Bitmap[frms];

                        for (int f = 0; f < frms; f++) {
                            frames[f] = Bitmap.createBitmap(fullBmp, 0, f * frameH, fullBmp.getWidth(), frameH);
                        }

                        DialLayer layer = new DialLayer(
                                frms > 1 ? DialLayer.TYPE_ELEMENT
                                        : (elementType == DialCompiler.TYPE_BACKGROUND ? DialLayer.TYPE_BACKGROUND
                                                : DialLayer.TYPE_ARM),
                                frames[0], getBlockLabel(elementType), elementType);

                        layer.frames = frames;
                        layer.frameCount = frms;
                        layer.isSpriteSheet = frms > 1;
                        layer.posX = b.optInt("posx", 0);
                        layer.posY = b.optInt("posy", 0);
                        layer.scale = 1.0f;

                        layers.add(layer);
                    }
                    Toast.makeText(this, "Loaded dial elements", Toast.LENGTH_SHORT).show();
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(this, "Failed parsing edit folder", Toast.LENGTH_SHORT).show();
                }
            }
        }

        // Fallback to preview
        if (previewPath == null)
            return;
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inPreferredConfig = Bitmap.Config.RGB_565;
        Bitmap bmp = BitmapFactory.decodeFile(previewPath, opts);
        if (bmp != null) {
            addBackgroundLayer(ensureRgb565(bmp), DialCompiler.TYPE_BACKGROUND);
            Toast.makeText(this, R.string.editing_dial, Toast.LENGTH_SHORT).show();
        }
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
            if (l.locked)
                continue; // Skip locked layers
            Bitmap bmp = (l.frames != null && l.frames.length > 0) ? l.frames[0] : l.icon;
            if (bmp == null)
                continue;
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
            holder.itemView.setAlpha(isSelected ? 1.0f : (layer.locked ? 0.5f : 0.7f));
            holder.itemView.setBackgroundColor(getResources().getColor(
                    isSelected ? R.color.bg_elevated : R.color.bg_card));

            // Lock toggle
            holder.btnLock.setText(layer.locked ? "🔒" : "🔓");
            holder.btnLock.setOnClickListener(v -> {
                layer.locked = !layer.locked;
                refreshAll();
            });

            holder.itemView.setOnClickListener(v -> {
                selectedLayerIndex = layerIdx;
                refreshAll();
            });

            holder.itemView.setOnLongClickListener(v -> {
                saveLayerAsPreset(layer);
                return true;
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
        public int getItemCount() {
            return layers.size();
        }

        class VH extends RecyclerView.ViewHolder {
            ImageView imgThumb;
            TextView txtName, txtType, txtFrameBadge, btnDelete, btnLock;

            VH(View v) {
                super(v);
                imgThumb = v.findViewById(R.id.imgLayerThumb);
                txtName = v.findViewById(R.id.txtLayerName);
                txtType = v.findViewById(R.id.txtLayerType);
                txtFrameBadge = v.findViewById(R.id.txtFrameBadge);
                btnLock = v.findViewById(R.id.btnLockLayer);
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

        // Gallery-style visual grid (same as element picker)
        View galleryView = LayoutInflater.from(this).inflate(R.layout.dialog_preset_gallery, null);
        TextView titleView = galleryView.findViewById(R.id.txtGalleryTitle);
        titleView.setText(getString(R.string.cat_scale));
        RecyclerView grid = galleryView.findViewById(R.id.gridPresets);
        grid.setLayoutManager(new GridLayoutManager(this, 3));

        List<Object[]> scaleItems = new ArrayList<>();
        scaleItems.add(new Object[] { getString(R.string.from_gallery), null, null });
        for (int i = 0; i < presetPaths.size(); i++) {
            String p = presetPaths.get(i);
            Bitmap thumb = null;
            try {
                InputStream is = getAssets().open(p);
                thumb = BitmapFactory.decodeStream(is);
                is.close();
            } catch (Exception ignored) {
            }
            scaleItems.add(new Object[] { getString(R.string.style_label, String.valueOf(i + 1)), p, thumb });
        }

        AlertDialog scaleDialog = new AlertDialog.Builder(this)
                .setView(galleryView)
                .setNegativeButton(R.string.cancel, null)
                .create();

        grid.setAdapter(new RecyclerView.Adapter<PresetVH>() {
            @NonNull
            @Override
            public PresetVH onCreateViewHolder(@NonNull ViewGroup parent, int vt) {
                View v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_preset_thumb, parent, false);
                return new PresetVH(v);
            }

            @Override
            public void onBindViewHolder(@NonNull PresetVH h, int pos) {
                Object[] item = scaleItems.get(pos);
                h.txtName.setText((String) item[0]);
                Bitmap t = (Bitmap) item[2];
                if (t != null)
                    h.imgThumb.setImageBitmap(t);
                else if (pos == 0)
                    h.imgThumb.setImageResource(android.R.drawable.ic_menu_gallery);
                else
                    h.imgThumb.setImageBitmap(null);
                h.itemView.setOnClickListener(v -> {
                    scaleDialog.dismiss();
                    String path = (String) item[1];
                    if (path == null) {
                        pendingElementType = DialCompiler.TYPE_BERRY;
                        pickImageFromGallery();
                    } else {
                        loadScalePreset(path);
                    }
                });
            }

            @Override
            public int getItemCount() {
                return scaleItems.size();
            }
        });
        scaleDialog.show();
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
            layer.frames = new Bitmap[] { bmp };
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

        // Build gallery dialog with visual thumbnails
        View galleryView = LayoutInflater.from(this).inflate(R.layout.dialog_preset_gallery, null);
        TextView title = galleryView.findViewById(R.id.txtGalleryTitle);
        title.setText(getString(R.string.select_style) + " \u2014 " + getBlockLabel(elementType));
        RecyclerView grid = galleryView.findViewById(R.id.gridPresets);
        grid.setLayoutManager(new GridLayoutManager(this, 3));

        // Build items: gallery option + font option + presets
        List<Object[]> items = new ArrayList<>();
        items.add(new Object[] { getString(R.string.from_gallery), null, null });

        // Font creator option for digit types
        boolean isDigitType = isDigitElementType(elementType);
        if (isDigitType) {
            items.add(new Object[] { getString(R.string.from_font), "__FONT__", null });
        }

        // SVG Option for all supported types
        items.add(new Object[] { getString(R.string.from_svg), "__SVG__", null });

        // Load thumbnails for presets
        for (String p : presetPaths) {
            Bitmap thumb = loadPresetThumbnail(p, elementType);
            int lastSlash = p.lastIndexOf('/');
            String styleName = lastSlash >= 0 ? p.substring(lastSlash + 1) : p;
            items.add(new Object[] { styleName, p, thumb });
        }

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setView(galleryView)
                .setNegativeButton(R.string.cancel, null)
                .create();

        grid.setAdapter(new RecyclerView.Adapter<PresetVH>() {
            @NonNull
            @Override
            public PresetVH onCreateViewHolder(@NonNull ViewGroup parent, int vt) {
                View v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_preset_thumb, parent, false);
                return new PresetVH(v);
            }

            @Override
            public void onBindViewHolder(@NonNull PresetVH h, int pos) {
                Object[] item = items.get(pos);
                h.txtName.setText((String) item[0]);
                Bitmap thumb = (Bitmap) item[2];
                if (thumb != null) {
                    h.imgThumb.setImageBitmap(thumb);
                } else if (pos == 0) {
                    h.imgThumb.setImageResource(android.R.drawable.ic_menu_gallery);
                } else if ("__FONT__".equals(item[1])) {
                    h.imgThumb.setImageResource(android.R.drawable.ic_menu_edit);
                } else {
                    h.imgThumb.setImageBitmap(null);
                }
                h.itemView.setOnClickListener(v -> {
                    dialog.dismiss();
                    String path = (String) item[1];
                    if (path == null) {
                        pendingElementType = elementType;
                        pickImageFromGallery();
                    } else if ("__FONT__".equals(path)) {
                        showFontCreator(elementType);
                    } else if ("__SVG__".equals(path)) {
                        pendingElementType = elementType;
                        pickSvgFromGallery();
                    } else if (path.endsWith(".svg")) {
                        // Open SVG Editor with asset
                        showSVGEditor(elementType, path);
                    } else {
                        loadPreset(path, elementType);
                    }
                });
            }

            @Override
            public int getItemCount() {
                return items.size();
            }
        });

        dialog.show();
    }

    private static class PresetVH extends RecyclerView.ViewHolder {
        ImageView imgThumb;
        TextView txtName;

        PresetVH(View v) {
            super(v);
            imgThumb = v.findViewById(R.id.imgPresetThumb);
            txtName = v.findViewById(R.id.txtPresetName);
        }
    }

    private boolean isDigitElementType(int type) {
        return type == DialCompiler.TYPE_DIGITAL_HOUR || type == DialCompiler.TYPE_DIGITAL_MIN ||
                type == DialCompiler.TYPE_SECONDS || type == DialCompiler.TYPE_HOUR_HI ||
                type == DialCompiler.TYPE_HOUR_LO || type == DialCompiler.TYPE_MIN_HI ||
                type == DialCompiler.TYPE_MIN_LO || type == DialCompiler.TYPE_DAY ||
                type == DialCompiler.TYPE_MONTH || type == DialCompiler.TYPE_YEAR ||
                type == DialCompiler.TYPE_STEPS || type == DialCompiler.TYPE_HEART ||
                type == DialCompiler.TYPE_CALORIE || type == DialCompiler.TYPE_DISTANCE ||
                type == DialCompiler.TYPE_BATTERY || type == DialCompiler.TYPE_TEMP;
    }

    /**
     * Load a representative thumbnail from a preset folder/file.
     */
    private Bitmap loadPresetThumbnail(String assetPath, int elementType) {
        try {
            if (assetPath.endsWith(".png")) {
                InputStream is = getAssets().open(assetPath);
                Bitmap bmp = BitmapFactory.decodeStream(is);
                is.close();
                return bmp;
            } else if (assetPath.endsWith(".svg")) {
                // Render SVG thumbnail
                InputStream is = getAssets().open(assetPath);
                com.caverock.androidsvg.SVG svg = com.caverock.androidsvg.SVG.getFromInputStream(is);
                is.close();
                // Render to small thumb
                Bitmap bmp = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
                Canvas c = new Canvas(bmp);
                // Fit to 100x100
                float docW = svg.getDocumentWidth();
                float docH = svg.getDocumentHeight();
                if (docW <= 0)
                    docW = 100;
                if (docH <= 0)
                    docH = 100;
                float scale = Math.min(100f / docW, 100f / docH);
                c.scale(scale, scale);
                svg.renderToCanvas(c);
                return bmp;
            }
            String thumbFile;
            if (elementType == DialCompiler.TYPE_AMPM) {
                thumbFile = "am.png";
            } else if (elementType == DialCompiler.TYPE_WEEKDAY) {
                thumbFile = "2.png";
            } else {
                thumbFile = "5.png";
            }
            try {
                InputStream is = getAssets().open(assetPath + "/" + thumbFile);
                Bitmap bmp = BitmapFactory.decodeStream(is);
                is.close();
                return bmp;
            } catch (Exception e) {
                InputStream is = getAssets().open(assetPath + "/0.png");
                Bitmap bmp = BitmapFactory.decodeStream(is);
                is.close();
                return bmp;
            }
        } catch (Exception e) {
            return null;
        }
    }

    // ===================== FONT-BASED DIGIT CREATOR =====================

    private void showFontCreator(int elementType) {
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_font_creator, null);
        ImageView imgPreview = view.findViewById(R.id.imgFontPreview);
        Spinner spinnerFont = view.findViewById(R.id.spinnerFont);
        SeekBar seekSize = view.findViewById(R.id.seekDigitSize);
        SeekBar seekGlow = view.findViewById(R.id.seekGlow);
        SeekBar seekBorder = view.findViewById(R.id.seekBorder);
        SeekBar seekSpacing = view.findViewById(R.id.seekSpacing);
        Spinner spinnerLang = view.findViewById(R.id.spinnerLang);
        View containerLang = view.findViewById(R.id.containerCustom); // Using containerCustom as per XML
        EditText edtCustomText = view.findViewById(R.id.edtCustom);
        View containerCustomText = view.findViewById(R.id.containerCustom);

        // Setup Language Spinner
        ArrayAdapter<String> langAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,
                new String[] { getString(R.string.lang_en), getString(R.string.lang_es) });
        spinnerLang.setAdapter(langAdapter);

        if (elementType == DialCompiler.TYPE_WEEKDAY || elementType == DialCompiler.TYPE_MONTH) {
            containerLang.setVisibility(View.VISIBLE);
        } else {
            containerLang.setVisibility(View.GONE);
        }

        if (elementType == DialCompiler.TYPE_BERRY || elementType == DialCompiler.TYPE_LABEL) {
            containerCustomText.setVisibility(View.VISIBLE);
        } else {
            containerCustomText.setVisibility(View.GONE);
        }

        seekSpacing.setMax(100);
        seekSpacing.setProgress(50); // Center = 0 spacing
        LinearLayout colorPalette = view.findViewById(R.id.colorPalette);
        LinearLayout borderColorPalette = view.findViewById(R.id.borderColorPalette);

        // Font options: system fonts + any bundled .ttf in assets/fonts/
        List<String> fontNames = new ArrayList<>();
        List<Typeface> fontFaces = new ArrayList<>();
        fontNames.add("Sans Serif");
        fontFaces.add(Typeface.SANS_SERIF);
        fontNames.add("Serif");
        fontFaces.add(Typeface.SERIF);
        fontNames.add("Monospace");
        fontFaces.add(Typeface.MONOSPACE);
        fontNames.add("Sans Bold");
        fontFaces.add(Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD));
        fontNames.add("Serif Bold");
        fontFaces.add(Typeface.create(Typeface.SERIF, Typeface.BOLD));

        // Try to load bundled .ttf fonts from assets/fonts/
        String[] bundledFonts = safeListAssets("fonts");
        for (String f : bundledFonts) {
            if (f.endsWith(".ttf") || f.endsWith(".otf")) {
                try {
                    Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/" + f);
                    fontNames.add(f.replace(".ttf", "").replace(".otf", ""));
                    fontFaces.add(tf);
                } catch (Exception e) {
                    /* skip */ }
            }
        }

        ArrayAdapter<String> fontAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, fontNames);
        spinnerFont.setAdapter(fontAdapter);

        // Color palette
        final int[] colors = {
                Color.WHITE, Color.BLACK, Color.parseColor("#FF4444"), Color.parseColor("#44FF44"),
                Color.parseColor("#4488FF"), Color.parseColor("#FFDD44"),
                Color.parseColor("#FF44FF"), Color.parseColor("#44FFFF"),
                Color.parseColor("#FF8844"), Color.parseColor("#88FF44")
        };
        final int[] selectedColor = { Color.WHITE };
        final int[] selectedBorderColor = { Color.BLACK };

        // Helper to setup a palette
        View.OnClickListener colorClickListener = v -> {
            int clr = (int) v.getTag();
            selectedColor[0] = clr;
            // Update UI
            for (int i = 0; i < colorPalette.getChildCount(); i++) {
                View child = colorPalette.getChildAt(i);
                GradientDrawable bg = (GradientDrawable) child.getBackground();
                bg.setStroke(3, ((int) child.getTag() == clr) ? Color.parseColor("#58A6FF") : Color.TRANSPARENT);
            }
            updatePreviewAction(imgPreview, spinnerFont, fontFaces, seekSize, selectedColor[0],
                    selectedBorderColor[0], seekGlow, seekBorder, seekSpacing, spinnerLang, edtCustomText, elementType);
        };

        for (int clr : colors) {
            View swatch = new View(this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            lp.setMargins(2, 2, 2, 2);
            swatch.setLayoutParams(lp);
            swatch.setTag(clr);
            GradientDrawable gd = new GradientDrawable();
            gd.setColor(clr);
            gd.setCornerRadius(6);
            if (clr == selectedColor[0])
                gd.setStroke(3, Color.parseColor("#58A6FF"));
            swatch.setBackground(gd);
            swatch.setOnClickListener(v -> {
                selectedColor[0] = clr;
                for (int i = 0; i < colorPalette.getChildCount(); i++) {
                    View child = colorPalette.getChildAt(i);
                    GradientDrawable bg = (GradientDrawable) child.getBackground();
                    bg.setStroke(3, ((int) child.getTag() == clr) ? Color.parseColor("#58A6FF") : Color.TRANSPARENT);
                }
                updatePreviewAction(imgPreview, spinnerFont, fontFaces, seekSize, selectedColor[0],
                        selectedBorderColor[0], seekGlow, seekBorder, seekSpacing, spinnerLang, edtCustomText,
                        elementType);
            });
            colorPalette.addView(swatch);
        }

        // Border Color Palette
        for (int clr : colors) {
            View swatch = new View(this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            lp.setMargins(2, 2, 2, 2);
            swatch.setLayoutParams(lp);
            swatch.setTag(clr);
            GradientDrawable gd = new GradientDrawable();
            gd.setColor(clr);
            gd.setCornerRadius(6);
            if (clr == selectedBorderColor[0])
                gd.setStroke(3, Color.parseColor("#58A6FF"));
            swatch.setBackground(gd);
            swatch.setOnClickListener(v -> {
                selectedBorderColor[0] = clr;
                for (int i = 0; i < borderColorPalette.getChildCount(); i++) {
                    View child = borderColorPalette.getChildAt(i);
                    GradientDrawable bg = (GradientDrawable) child.getBackground();
                    bg.setStroke(3, ((int) child.getTag() == clr) ? Color.parseColor("#58A6FF") : Color.TRANSPARENT);
                }
                updatePreviewAction(imgPreview, spinnerFont, fontFaces, seekSize, selectedColor[0],
                        selectedBorderColor[0], seekGlow, seekBorder, seekSpacing, spinnerLang, edtCustomText,
                        elementType);
            });
            borderColorPalette.addView(swatch);
        }

        // Update preview on any change
        SimpleSeekListener seekListener = new SimpleSeekListener() {
            @Override
            public void onProgressChanged(SeekBar sb, int val, boolean user) {
                updatePreviewAction(imgPreview, spinnerFont, fontFaces, seekSize, selectedColor[0],
                        selectedBorderColor[0], seekGlow, seekBorder, seekSpacing, spinnerLang, edtCustomText,
                        elementType);
            }
        };

        seekSize.setOnSeekBarChangeListener(seekListener);
        seekGlow.setOnSeekBarChangeListener(seekListener);
        seekBorder.setOnSeekBarChangeListener(seekListener);
        seekSpacing.setOnSeekBarChangeListener(seekListener);

        spinnerFont.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(android.widget.AdapterView<?> p, View v, int pos, long id) {
                updatePreviewAction(imgPreview, spinnerFont, fontFaces, seekSize, selectedColor[0],
                        selectedBorderColor[0], seekGlow, seekBorder, seekSpacing, spinnerLang, edtCustomText,
                        elementType);
            }

            @Override
            public void onNothingSelected(android.widget.AdapterView<?> p) {
            }
        });

        // Update when custom text changes
        edtCustomText.addTextChangedListener(new android.text.TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updatePreviewAction(imgPreview, spinnerFont, fontFaces, seekSize, selectedColor[0],
                        selectedBorderColor[0], seekGlow, seekBorder, seekSpacing, spinnerLang, edtCustomText,
                        elementType);
            }

            @Override
            public void afterTextChanged(android.text.Editable s) {
            }
        });

        // Update when language changes
        spinnerLang.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(android.widget.AdapterView<?> parent, View view, int position, long id) {
                updatePreviewAction(imgPreview, spinnerFont, fontFaces, seekSize, selectedColor[0],
                        selectedBorderColor[0], seekGlow, seekBorder, seekSpacing, spinnerLang, edtCustomText,
                        elementType);
            }

            @Override
            public void onNothingSelected(android.widget.AdapterView<?> parent) {
            }
        });

        // Initial preview
        updatePreviewAction(imgPreview, spinnerFont, fontFaces, seekSize, selectedColor[0],
                selectedBorderColor[0], seekGlow, seekBorder, seekSpacing, spinnerLang, edtCustomText, elementType);

        new AlertDialog.Builder(this)
                .setTitle(R.string.font_creator_title)
                .setView(view)
                .setPositiveButton(R.string.create_digits, (dialog, which) -> {
                    Typeface tf = fontFaces.get(spinnerFont.getSelectedItemPosition());
                    int size = seekSize.getProgress();
                    int color = selectedColor[0];
                    int borderColor = selectedBorderColor[0];
                    int glow = seekGlow.getProgress();
                    int border = seekBorder.getProgress();
                    int spacing = seekSpacing.getProgress() - 50; // Allow negative spacing
                    String lang = (spinnerLang.getSelectedItemPosition() == 1) ? "es" : "en";
                    String custom = edtCustomText.getText().toString();

                    Bitmap[] frames = renderDigitBitmaps(elementType, tf, size, color, borderColor, glow, border,
                            spacing, lang, custom);
                    if (frames != null && frames.length > 0) {
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
                        Toast.makeText(this, "\u2713 " + name + " \u2014 " + frames.length + " frames",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton(R.string.cancel, null)
                .show();
    }

    private void updatePreviewAction(ImageView imgPreview, Spinner spinnerFont, List<Typeface> fontFaces,
            SeekBar seekSize, int color, int borderColor, SeekBar seekGlow,
            SeekBar seekBorder, SeekBar seekSpacing, Spinner spinnerLang, EditText edtCustom, int elementType) {

        if (spinnerFont.getSelectedItemPosition() < 0 || spinnerFont.getSelectedItemPosition() >= fontFaces.size())
            return;

        Typeface tf = fontFaces.get(spinnerFont.getSelectedItemPosition());
        int size = seekSize.getProgress();
        int glow = seekGlow.getProgress();
        int border = seekBorder.getProgress();
        int spacing = seekSpacing.getProgress() - 50;
        String lang = (spinnerLang != null && spinnerLang.getSelectedItemPosition() == 1) ? "es" : "en";
        String custom = (edtCustom != null) ? edtCustom.getText().toString() : "";

        Bitmap[] frames = renderDigitBitmaps(elementType, tf, size, color, borderColor, glow, border, spacing, lang,
                custom);

        if (frames != null && frames.length > 0) {
            // For preview, maybe combinine hi/lo if digit? Or just show first frame?
            // Since it's a font preview, let's show the first generated glyph or a sample.
            // If Weekday/Month, frames[0] is MON/JAN.
            imgPreview.setImageBitmap(frames[0]);
            // If simple number, frames[0] is '0'.
            // To be fancier for numbers, we could combine '1' and '2'.
            if (frames.length >= 10 && elementType != DialCompiler.TYPE_WEEKDAY
                    && elementType != DialCompiler.TYPE_MONTH && elementType != DialCompiler.TYPE_BERRY) {
                // It's likely 0-9. Construct "12"
                // ... (Optional, stick to simple first frame for now or custom logic)
                // But renderDigitBitmaps returns 0..9 for digits.
                // So frames[1] and frames[2] would be '1' and '2'.
                if (frames.length > 2) {
                    // Combine 1 and 2
                    Bitmap one = frames[1];
                    Bitmap two = frames[2];
                    Bitmap combined = Bitmap.createBitmap(one.getWidth() + two.getWidth() + 5,
                            Math.max(one.getHeight(), two.getHeight()), Bitmap.Config.ARGB_8888);
                    Canvas c = new Canvas(combined);
                    c.drawBitmap(one, 0, 0, null);
                    c.drawBitmap(two, one.getWidth() + 5, 0, null);
                    imgPreview.setImageBitmap(combined);
                }
            }
        }
    }

    private void updateFontPreview(ImageView target, Typeface tf, int size,
            int color, int borderColor, int glowRadius, int borderWidth, int spacing) {
        if (size < 16)
            size = 16;
        String sampleText = "12"; // Show fewer digits to fit preview better
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTypeface(tf);
        paint.setTextSize(size);
        // We only use paint for metrics here, individual drawing below

        Paint.FontMetrics fm = paint.getFontMetrics();
        int textH = (int) (fm.descent - fm.ascent + 0.5f);
        int padding = Math.max(glowRadius, borderWidth) + 4;

        // Render "1" and "2" separately with spacing
        float digit1W = paint.measureText("1");
        float digit2W = paint.measureText("2");
        int frameW1 = (int) digit1W + padding * 2 + spacing;
        int frameW2 = (int) digit2W + padding * 2 + spacing;

        int bmpW = frameW1 + frameW2;
        int bmpH = textH + padding * 2;

        Bitmap bmp = Bitmap.createBitmap(Math.max(1, bmpW), Math.max(1, bmpH), Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bmp);

        // Draw digit 1
        float y = padding - fm.ascent;
        drawDigitOnCanvas(c, "1", padding + spacing / 2f, y, paint, color, borderColor, glowRadius, borderWidth);
        // Draw digit 2
        drawDigitOnCanvas(c, "2", frameW1 + padding + spacing / 2f, y, paint, color, borderColor, glowRadius,
                borderWidth);

        target.setImageBitmap(bmp);
    }

    private void drawDigitOnCanvas(Canvas c, String text, float x, float y, Paint basePaint,
            int color, int borderColor, int glowRadius, int borderWidth) {
        if (glowRadius > 0) {
            Paint glowPaint = new Paint(basePaint);
            glowPaint.setColor(color);
            glowPaint.setMaskFilter(new BlurMaskFilter(glowRadius, BlurMaskFilter.Blur.NORMAL));
            glowPaint.setAlpha(180);
            c.drawText(text, x, y, glowPaint);
        }
        if (borderWidth > 0) {
            Paint strokePaint = new Paint(basePaint);
            strokePaint.setStyle(Paint.Style.STROKE);
            strokePaint.setStrokeWidth(borderWidth);
            strokePaint.setColor(borderColor);
            c.drawText(text, x, y, strokePaint);
        }
        basePaint.setColor(color);
        c.drawText(text, x, y, basePaint);
    }

    /**
     * Render individual digit bitmaps from a font with effects.
     */
    private Bitmap[] renderDigitBitmaps(int elementType, Typeface tf, int size,
            int color, int borderColor, int glowRadius, int borderWidth, int spacing, String language,
            String customText) {
        if (size < 16)
            size = 16;
        int expectedFrames = DialCompiler.getDefaultFrameCount(elementType);
        String[] glyphs;

        if (elementType == DialCompiler.TYPE_AMPM) {
            glyphs = new String[] { "AM", "PM" };
        } else if (elementType == DialCompiler.TYPE_WEEKDAY) {
            if ("es".equals(language)) {
                glyphs = new String[] { "LUN", "MAR", "MIE", "JUE", "VIE", "SAB", "DOM" };
            } else {
                glyphs = new String[] { "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN" };
            }
        } else if (elementType == DialCompiler.TYPE_MONTH) {
            // 1-12 (Jan-Dec)
            if ("es".equals(language)) {
                glyphs = new String[] { "ENE", "FEB", "MAR", "ABR", "MAY", "JUN", "JUL", "AGO", "SEP", "OCT", "NOV",
                        "DIC" };
            } else {
                glyphs = new String[] { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV",
                        "DEC" };
            }
        } else if (elementType == DialCompiler.TYPE_BERRY || elementType == DialCompiler.TYPE_LABEL) {
            // Decoration / Label: Use custom text if provided, else default
            if (customText != null && !customText.isEmpty()) {
                glyphs = new String[] { customText };
            } else {
                glyphs = new String[] { ":" }; // Default decoration
            }
        } else {
            // Numeric digits 0-9
            glyphs = new String[expectedFrames];
            for (int i = 0; i < expectedFrames; i++) {
                glyphs[i] = String.valueOf(i);
            }
        }

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTypeface(tf);
        paint.setTextSize(size);
        paint.setColor(color);

        // Find max dimensions across all glyphs
        Paint.FontMetrics fm = paint.getFontMetrics();
        int textH = (int) (fm.descent - fm.ascent + 0.5f);
        int maxW = 0;
        for (String g : glyphs) {
            maxW = Math.max(maxW, (int) (paint.measureText(g) + 0.5f));
        }
        int padding = Math.max(glowRadius, borderWidth) + 2;
        int frameW = maxW + padding * 2 + spacing;
        int frameH = textH + padding * 2;

        Bitmap[] frames = new Bitmap[glyphs.length];
        for (int i = 0; i < glyphs.length; i++) {
            Bitmap bmp = Bitmap.createBitmap(Math.max(1, frameW), Math.max(1, frameH), Bitmap.Config.ARGB_8888);
            Canvas c = new Canvas(bmp);
            float textW = paint.measureText(glyphs[i]);
            float x = (frameW - textW) / 2f;
            float y = padding - fm.ascent;

            if (glowRadius > 0) {
                Paint gp = new Paint(paint);
                gp.setMaskFilter(new BlurMaskFilter(glowRadius, BlurMaskFilter.Blur.NORMAL));
                gp.setAlpha(180);
                c.drawText(glyphs[i], x, y, gp);
            }
            if (borderWidth > 0) {
                Paint sp = new Paint(paint);
                sp.setStyle(Paint.Style.STROKE);
                sp.setStrokeWidth(borderWidth);
                sp.setColor(borderColor);
                c.drawText(glyphs[i], x, y, sp);
            }
            c.drawText(glyphs[i], x, y, paint);
            frames[i] = bmp;
        }
        return frames;
    }

    // ===================== ASSET PRESET LOADING =====================

    private List<String> findPresetFolders(int elementType) {
        List<String> found = new ArrayList<>();
        List<String> allBases = new ArrayList<>();
        try {
            String[] assets = getAssets().list("");
            if (assets != null) {
                for (String a : assets) {
                    if (a.startsWith("dial_customize_")) {
                        allBases.add(a);
                    }
                }
            }
        } catch (Exception e) {
        }
        if (allBases.isEmpty())
            allBases.add("dial_customize_2");

        try {
            for (String base : allBases) {
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
                    case DialCompiler.TYPE_BATTERY: {
                        // Look in assets/battery/*.svg
                        String batDir = "battery";
                        String[] files = safeListAssets(batDir);
                        for (String f : files) {
                            if (f.endsWith(".svg")) {
                                found.add(batDir + "/" + f);
                            }
                        }
                        // Also look in standard value folder
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
                    case DialCompiler.TYPE_TEMP: {
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
            }
        } catch (Exception e) {
            // Directory doesn't exist
        }
        return found;
    }

    private InputStream openAssetOrFile(String path) throws java.io.IOException {
        if (path.startsWith("FILE:")) {
            return new java.io.FileInputStream(path.substring(5));
        }
        return getAssets().open(path);
    }

    private void saveLayerAsPreset(DialLayer layer) {
        if (layer == null || layer.frames == null || layer.frames.length == 0)
            return;
        try {
            java.io.File presetsDir = new java.io.File(getFilesDir(), "presets");
            String customName = "dial_customize_user_" + System.currentTimeMillis();
            java.io.File newPresetDir = new java.io.File(presetsDir, customName);
            newPresetDir.mkdirs();

            String subPath = "";
            int type = layer.nativeElementType;
            if (type == DialCompiler.TYPE_ARM_HOUR)
                subPath = "time/pointer/pointer/hour";
            else if (type == DialCompiler.TYPE_ARM_MIN)
                subPath = "time/pointer/pointer/minute";
            else if (type == DialCompiler.TYPE_ARM_SEC)
                subPath = "time/pointer/pointer/second";
            else if (type == DialCompiler.TYPE_HOUR_LO || type == DialCompiler.TYPE_HOUR_HI
                    || type == DialCompiler.TYPE_MIN_LO || type == DialCompiler.TYPE_MIN_HI
                    || type == DialCompiler.TYPE_DIGITAL_HOUR || type == DialCompiler.TYPE_DIGITAL_MIN)
                subPath = "time/digital/1/hour_minute";
            else if (type == DialCompiler.TYPE_SECONDS)
                subPath = "time/digital/1/second";
            else if (type == DialCompiler.TYPE_DAY)
                subPath = "time/digital/1/day";
            else if (type == DialCompiler.TYPE_MONTH)
                subPath = "time/digital/1/month";
            else if (type == DialCompiler.TYPE_YEAR)
                subPath = "time/digital/1/year";
            else if (type == DialCompiler.TYPE_WEEKDAY)
                subPath = "time/digital/1/weekday";
            else if (type == DialCompiler.TYPE_AMPM)
                subPath = "time/digital/1/ampm";
            else if (type == DialCompiler.TYPE_STEPS)
                subPath = "control/step";
            else if (type == DialCompiler.TYPE_HEART)
                subPath = "control/heart_rate";
            else if (type == DialCompiler.TYPE_CALORIE)
                subPath = "control/calories";
            else if (type == DialCompiler.TYPE_DISTANCE)
                subPath = "control/distance";
            else if (type == DialCompiler.TYPE_BATTERY)
                subPath = "control/battery";
            else if (type == DialCompiler.TYPE_BATT_STRIP)
                subPath = "control/battery_strip";
            else {
                Toast.makeText(this, "Cannot save this type as preset", Toast.LENGTH_SHORT).show();
                return;
            }

            java.io.File targetDir = new java.io.File(newPresetDir, subPath);
            targetDir.mkdirs();

            if (type == DialCompiler.TYPE_AMPM && layer.frames.length >= 2) {
                layer.frames[0].compress(Bitmap.CompressFormat.PNG, 100,
                        new java.io.FileOutputStream(new java.io.File(targetDir, "am.png")));
                layer.frames[1].compress(Bitmap.CompressFormat.PNG, 100,
                        new java.io.FileOutputStream(new java.io.File(targetDir, "pm.png")));
            } else {
                for (int i = 0; i < layer.frames.length; i++) {
                    String fname = (i + ".png");
                    if (layer.frames.length == 1 && (type == DialCompiler.TYPE_ARM_HOUR
                            || type == DialCompiler.TYPE_ARM_MIN || type == DialCompiler.TYPE_ARM_SEC))
                        fname = "0.png";
                    layer.frames[i].compress(Bitmap.CompressFormat.PNG, 100,
                            new java.io.FileOutputStream(new java.io.File(targetDir, fname)));
                }
            }
            Toast.makeText(this, "Layer saved as custom preset!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Error saving preset: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private String[] safeListAssets(String path) {
        if (path.startsWith("FILE:")) {
            java.io.File d = new java.io.File(path.substring(5));
            if (d.exists() && d.isDirectory()) {
                String[] list = d.list();
                return list != null ? list : new String[0];
            }
            return new String[0];
        }
        try {
            String[] list = getAssets().list(path);
            return list != null ? list : new String[0];
        } catch (Exception e) {
            return new String[0];
        }
    }

    private boolean hasAssetFile(String path) {
        if (path.startsWith("FILE:")) {
            return new java.io.File(path.substring(5)).exists();
        }
        try {
            InputStream is = openAssetOrFile(path);
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
                layer.frames = new Bitmap[] { bmp };
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
                for (String name : new String[] { "am.png", "pm.png" }) {
                    try {
                        InputStream is = openAssetOrFile(assetPath + "/" + name);
                        Bitmap bmp = BitmapFactory.decodeStream(is);
                        is.close();
                        if (bmp != null)
                            loadedFrames.add(bmp);
                    } catch (Exception e) {
                        /* skip */ }
                }
            } else {
                for (int i = 0; i < expectedFrames; i++) {
                    try {
                        InputStream is = openAssetOrFile(assetPath + "/" + i + ".png");
                        Bitmap bmp = BitmapFactory.decodeStream(is);
                        is.close();
                        if (bmp != null)
                            loadedFrames.add(bmp);
                    } catch (Exception e) {
                        /* skip */ }
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

    private void pickSvgFromGallery() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/svg+xml");
        startActivityForResult(intent, PICK_SVG_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_CODE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri imageUri = data.getData();
            try {
                InputStream is = getContentResolver().openInputStream(imageUri);
                BitmapFactory.Options opts = new BitmapFactory.Options();
                // Always load as ARGB_8888 — the watch firmware expects RGBA blocks
                opts.inPreferredConfig = Bitmap.Config.ARGB_8888;
                Bitmap bmp = BitmapFactory.decodeStream(is, null, opts);
                is.close();

                if (bmp == null) {
                    Toast.makeText(this, "Failed to load image", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (pendingElementType == DialCompiler.TYPE_BACKGROUND) {
                    addBackgroundLayer(bmp, pendingElementType);
                    pendingElementType = -1;
                } else {
                    addBackgroundLayer(bmp, -1);
                }
            } catch (Exception e) {
                Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == PICK_SVG_CODE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            showSVGEditor(data.getData(), pendingElementType);
            pendingElementType = -1;
        }
    }

    private void addBackgroundLayer(Bitmap bmp) {
        // Preserve aspect ratio: scale to cover canvas, let user reposition
        float scaleToCover = Math.max(
                (float) canvasWidth / bmp.getWidth(),
                (float) canvasHeight / bmp.getHeight());
        DialLayer layer = new DialLayer(DialLayer.TYPE_BACKGROUND, bmp,
                getBlockLabel(DialCompiler.TYPE_BACKGROUND), DialCompiler.TYPE_BACKGROUND);
        layer.frames = new Bitmap[] { bmp };
        layer.scale = scaleToCover;
        // Center on canvas
        layer.posX = (canvasWidth - bmp.getWidth() * scaleToCover) / 2f;
        layer.posY = (canvasHeight - bmp.getHeight() * scaleToCover) / 2f;
        layer.locked = true; // Auto-lock background
        layers.add(0, layer);
        selectedLayerIndex = 0;
        refreshAll();
    }

    private void addBackgroundLayer(Bitmap bmp, int elementType) {
        // Ensure no other background exists? Or just add on top?
        // Usually only 1 background. Remove existing if any?
        // For now, just add.

        // Ensure it's exactly canvas size (already done in onActivityResult for
        // background type,
        // but good to be safe if called from elsewhere)
        if (elementType == DialCompiler.TYPE_BACKGROUND) {
            if (bmp.getWidth() != canvasWidth || bmp.getHeight() != canvasHeight) {
                bmp = Bitmap.createScaledBitmap(bmp, canvasWidth, canvasHeight, true);
            }
            // Ensure ARGB_8888 for firmware compatibility
            if (bmp.getConfig() != Bitmap.Config.ARGB_8888) {
                Bitmap argb = Bitmap.createBitmap(bmp.getWidth(), bmp.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas c = new Canvas(argb);
                c.drawBitmap(bmp, 0, 0, null);
                bmp = argb;
            }
        }

        float scaleToCover = 1.0f; // For background, it's already scaled to cover
        if (elementType != DialCompiler.TYPE_BACKGROUND) {
            scaleToCover = Math.max(
                    (float) canvasWidth / bmp.getWidth(),
                    (float) canvasHeight / bmp.getHeight());
        }

        DialLayer layer = new DialLayer(DialLayer.TYPE_BACKGROUND, bmp,
                getBlockLabel(DialCompiler.TYPE_BACKGROUND), DialCompiler.TYPE_BACKGROUND);
        layer.frames = new Bitmap[] { bmp };
        layer.scale = scaleToCover;
        // Center on canvas
        layer.posX = (canvasWidth - bmp.getWidth() * scaleToCover) / 2f;
        layer.posY = (canvasHeight - bmp.getHeight() * scaleToCover) / 2f;
        layer.locked = true; // Auto-lock background
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
            frames = new Bitmap[] { compositeBmp };
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

    /**
     * Returns a representative frame index for preview display.
     * Instead of always showing digit "0", shows a realistic-looking time like
     * "2:56".
     */
    private int getPreviewFrameIndex(int elementType, int frameCount) {
        if (frameCount <= 1)
            return 0;
        int idx;
        switch (elementType) {
            case DialCompiler.TYPE_DIGITAL_HOUR:
            case DialCompiler.TYPE_HOUR_HI:
                idx = 2;
                break; // "2" → 2:56
            case DialCompiler.TYPE_HOUR_LO:
                idx = 1;
                break; // "1" → 12:56
            case DialCompiler.TYPE_DIGITAL_MIN:
            case DialCompiler.TYPE_MIN_HI:
                idx = 5;
                break; // "5" → X:56
            case DialCompiler.TYPE_SECONDS:
            case DialCompiler.TYPE_MIN_LO:
                idx = 6;
                break; // "6"
            case DialCompiler.TYPE_WEEKDAY:
                idx = 2;
                break; // Wednesday
            case DialCompiler.TYPE_DAY:
                idx = 5;
                break; // 15th
            case DialCompiler.TYPE_MONTH:
                idx = 1;
                break; // February
            case DialCompiler.TYPE_YEAR:
                idx = 6;
                break; // "6" → 2026
            case DialCompiler.TYPE_STEPS:
                idx = 7;
                break;
            case DialCompiler.TYPE_HEART:
                idx = 8;
                break;
            case DialCompiler.TYPE_CALORIE:
                idx = 3;
                break;
            case DialCompiler.TYPE_DISTANCE:
                idx = 4;
                break;
            case DialCompiler.TYPE_BATTERY:
            case DialCompiler.TYPE_BATT_STRIP:
                idx = 3;
                break; // mid-level
            case DialCompiler.TYPE_TEMP:
                idx = 2;
                break;
            case DialCompiler.TYPE_WEATHER:
                idx = 0;
                break;
            case DialCompiler.TYPE_CONNECT:
                idx = 0;
                break;
            default:
                idx = 0;
                break;
        }
        return Math.min(idx, frameCount - 1);
    }

    /**
     * For multi-digit types, creates a combined two-digit bitmap.
     * For other types, returns a single representative frame.
     */
    private Bitmap getPreviewBitmap(DialLayer layer) {
        if (layer.frames == null || layer.frames.length < 10) {
            // Not a digit sprite-sheet, return single frame
            int fi = 0;
            if (layer.frames != null && layer.frames.length > 0) {
                fi = getPreviewFrameIndex(layer.nativeElementType, layer.frames.length);
                fi = Math.min(fi, layer.frames.length - 1);
            }
            return (layer.frames != null && layer.frames.length > 0) ? layer.frames[fi] : layer.icon;
        }
        // Two-digit pairs for time/date types
        int hiIdx, loIdx;
        switch (layer.nativeElementType) {
            case DialCompiler.TYPE_DIGITAL_HOUR:
                hiIdx = 1;
                loIdx = 2;
                break; // "12"
            case DialCompiler.TYPE_DIGITAL_MIN:
                hiIdx = 5;
                loIdx = 6;
                break; // "56"
            case DialCompiler.TYPE_SECONDS:
                hiIdx = 3;
                loIdx = 4;
                break; // "34"
            case DialCompiler.TYPE_DAY:
                hiIdx = 1;
                loIdx = 5;
                break; // "15"
            case DialCompiler.TYPE_YEAR:
                hiIdx = 2;
                loIdx = 6;
                break; // "26"
            default:
                // Single digit preview for split types and others
                int fi = getPreviewFrameIndex(layer.nativeElementType, layer.frames.length);
                return layer.frames[Math.min(fi, layer.frames.length - 1)];
        }
        hiIdx = Math.min(hiIdx, layer.frames.length - 1);
        loIdx = Math.min(loIdx, layer.frames.length - 1);
        Bitmap hi = layer.frames[hiIdx];
        Bitmap lo = layer.frames[loIdx];
        // Combine side-by-side
        int w = hi.getWidth() + lo.getWidth();
        int h = Math.max(hi.getHeight(), lo.getHeight());
        Bitmap combined = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas cc = new Canvas(combined);
        cc.drawBitmap(hi, 0, 0, null);
        cc.drawBitmap(lo, hi.getWidth(), 0, null);
        return combined;
    }

    private void updatePreview() {
        Bitmap preview = Bitmap.createBitmap(canvasWidth, canvasHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(preview);
        canvas.drawColor(Color.BLACK);

        for (int i = 0; i < layers.size(); i++) {
            DialLayer layer = layers.get(i);
            Bitmap drawBmp = getPreviewBitmap(layer);
            if (drawBmp == null)
                continue;

            Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            paint.setAlpha((int) (layer.alpha * 255));

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
            if (layer.isSpriteSheet)
                info += " • " + layer.frameCount + " frames";
            txtSelectedLayer.setText(info);
            seekScale.setProgress((int) (layer.scale * 100));
            seekRotation.setProgress((int) layer.rotation);
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
        if (suggestedDialName != null && !suggestedDialName.isEmpty()) {
            input.setText(suggestedDialName);
        }
        input.setPadding(48, 24, 48, 24);

        new AlertDialog.Builder(this)
                .setTitle(R.string.enter_dial_name)
                .setView(input)
                .setPositiveButton(R.string.save, (dialog, which) -> {
                    String name = input.getText().toString().trim();
                    if (name.isEmpty())
                        name = "dial";
                    // Sanitize: replace spaces with _, remove non-alphanumeric except _-
                    name = name.replaceAll("[^a-zA-Z0-9_\\-]", "_");

                    // Check for duplicates
                    File userDialsDir = DialLibraryActivity.getUserDialsDir(this);
                    File targetFile = new File(userDialsDir, name + ".bin");
                    boolean isSameNameAsEditing = suggestedDialName != null && suggestedDialName.equals(name);
                    if (targetFile.exists() && !isSameNameAsEditing) {
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
                // Use representative frames (including two-digit pairs)
                Bitmap previewBmp = Bitmap.createBitmap(canvasWidth, canvasHeight, Bitmap.Config.ARGB_8888);
                Canvas c = new Canvas(previewBmp);
                c.drawColor(Color.BLACK);
                for (DialLayer l : layers) {
                    Bitmap bmp = getPreviewBitmap(l);
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
                // normalizeForWatch quantizes to RGB565 + flattens alpha
                Bitmap normalizedPreview = DialCompiler.normalizeForWatch(previewBmp, 280, 280);

                DialCompiler.DialBlock previewBlock = new DialCompiler.DialBlock();
                previewBlock.type = DialCompiler.TYPE_PREVIEW;
                previewBlock.width = 280;
                previewBlock.height = 280;
                previewBlock.x = 0;
                previewBlock.y = 0;
                previewBlock.frames = 1;
                previewBlock.hasAlpha = false; // Preview is always RGB
                previewBlock.images = new Bitmap[] { normalizedPreview };
                compiler.addBlock(previewBlock);

                for (DialLayer layer : layers) {
                    DialCompiler.DialBlock block = new DialCompiler.DialBlock();
                    block.type = layer.nativeElementType;
                    block.x = (int) layer.posX;
                    block.y = (int) layer.posY;

                    // Other elements: scale each frame properly
                    // BUT analog hands are NEVER scaled — firmware requires exact preset dims
                    boolean isHand = (block.type == DialCompiler.TYPE_ARM_HOUR ||
                            block.type == DialCompiler.TYPE_ARM_MIN ||
                            block.type == DialCompiler.TYPE_ARM_SEC);

                    if (block.type == DialCompiler.TYPE_BACKGROUND) {
                        // Backgrounds must be EXACTLY canvasWidth x canvasHeight at 0,0
                        Bitmap bgBitmap = Bitmap.createBitmap(canvasWidth, canvasHeight, Bitmap.Config.ARGB_8888);
                        Canvas bgCanvas = new Canvas(bgBitmap);
                        bgCanvas.drawColor(Color.BLACK);
                        Bitmap layerBmp = (layer.frames != null && layer.frames.length > 0) ? layer.frames[0]
                                : layer.icon;
                        if (layerBmp != null) {
                            Matrix m = new Matrix();
                            m.postScale(layer.scale, layer.scale);
                            if (layer.rotation != 0) {
                                float sw = layerBmp.getWidth() * layer.scale;
                                float sh = layerBmp.getHeight() * layer.scale;
                                m.postRotate(layer.rotation, sw / 2, sh / 2);
                            }
                            m.postTranslate(layer.posX, layer.posY);
                            bgCanvas.drawBitmap(layerBmp, m, null);
                        }
                        // Quantize to RGB565 for firmware compatibility
                        Bitmap normalizedBg = DialCompiler.normalizeForWatch(bgBitmap, canvasWidth, canvasHeight);
                        block.images = new Bitmap[] { normalizedBg };
                        block.width = canvasWidth;
                        block.height = canvasHeight;
                        block.frames = 1;
                        block.x = 0;
                        block.y = 0;
                    } else if (layer.frames != null && layer.frames.length > 0) {
                        if (isHand) {
                            // Hands: use original dimensions, ignore scale
                            block.images = layer.frames;
                            block.width = layer.frames[0].getWidth();
                            block.height = layer.frames[0].getHeight();
                        } else {
                            int scaledW = Math.max(1, (int) (layer.frames[0].getWidth() * layer.scale));
                            int scaledH = Math.max(1, (int) (layer.frames[0].getHeight() * layer.scale));
                            if (Math.abs(layer.scale - 1.0f) > 0.01f) {
                                // Scale each frame individually
                                Bitmap[] scaledFrames = new Bitmap[layer.frames.length];
                                for (int fi = 0; fi < layer.frames.length; fi++) {
                                    scaledFrames[fi] = Bitmap.createScaledBitmap(
                                            layer.frames[fi], scaledW, scaledH, true);
                                }
                                block.images = scaledFrames;
                            } else {
                                block.images = layer.frames;
                            }
                            block.width = scaledW;
                            block.height = scaledH;
                        }
                        block.frames = layer.frames.length;
                    } else if (layer.icon != null) {
                        int scaledW = Math.max(1, (int) (layer.icon.getWidth() * layer.scale));
                        int scaledH = Math.max(1, (int) (layer.icon.getHeight() * layer.scale));
                        if (Math.abs(layer.scale - 1.0f) > 0.01f) {
                            block.images = new Bitmap[] { Bitmap.createScaledBitmap(
                                    layer.icon, scaledW, scaledH, true) };
                        } else {
                            block.images = new Bitmap[] { layer.icon };
                        }
                        block.frames = 1;
                        block.width = scaledW;
                        block.height = scaledH;
                    }

                    block.hasAlpha = (block.type != DialCompiler.TYPE_BACKGROUND &&
                            block.type != DialCompiler.TYPE_PREVIEW);

                    // Analog hands: use RAW compression & set pivot to canvas center
                    if (block.type == DialCompiler.TYPE_ARM_HOUR ||
                            block.type == DialCompiler.TYPE_ARM_MIN ||
                            block.type == DialCompiler.TYPE_ARM_SEC) {
                        block.compress = 0;
                        // Watch firmware uses pos_x/pos_y as the rotation pivot point.
                        // Center of 466x466 canvas = (233, 233)
                        block.x = canvasWidth / 2;
                        block.y = canvasHeight / 2;
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
                        // Show success dialog with Send option
                        new AlertDialog.Builder(this)
                                .setTitle("✅ " + filename)
                                .setMessage(size)
                                .setPositiveButton(R.string.send_dial, (d, w) -> {
                                    try {
                                        java.io.FileInputStream fis = new java.io.FileInputStream(savedFile);
                                        java.io.ByteArrayOutputStream byteBuffer = new java.io.ByteArrayOutputStream();
                                        byte[] buffer = new byte[4096];
                                        int len;
                                        while ((len = fis.read(buffer)) != -1)
                                            byteBuffer.write(buffer, 0, len);
                                        fis.close();
                                        byte[] fileBytesToSend = byteBuffer.toByteArray();

                                        com.example.dialsender.ble.BleManager bleManager = com.example.dialsender.ble.BleManager
                                                .getInstance(DialEditorActivity.this);

                                        android.app.ProgressDialog progressDialog = new android.app.ProgressDialog(
                                                DialEditorActivity.this);
                                        progressDialog.setTitle(getString(R.string.transfer));
                                        progressDialog.setMessage(getString(R.string.waiting));
                                        progressDialog.setProgressStyle(android.app.ProgressDialog.STYLE_HORIZONTAL);
                                        progressDialog.setMax(100);
                                        progressDialog.setIndeterminate(false);
                                        progressDialog.setCancelable(false);
                                        progressDialog.show();

                                        bleManager.setListener(
                                                new com.example.dialsender.ble.BleManager.BleStateListener() {
                                                    @Override
                                                    public void onConnectionStateChange(boolean connected,
                                                            boolean sessionReady) {
                                                    }

                                                    @Override
                                                    public void onHealthDataReceived(String keyName, byte[] payload) {
                                                    }

                                                    @Override
                                                    public void onHealthSyncComplete() {
                                                    }

                                                    @Override
                                                    public void onTransferProgress(int percent, long bytesTransferred,
                                                            long totalBytes) {
                                                        progressDialog.setProgress(percent);
                                                        progressDialog.setMessage(
                                                                bytesTransferred + " / " + totalBytes + " bytes");
                                                    }

                                                    @Override
                                                    public void onTransferComplete() {
                                                        progressDialog.dismiss();
                                                        Toast.makeText(DialEditorActivity.this, R.string.dial_sent_ok,
                                                                Toast.LENGTH_LONG).show();
                                                        bleManager.setListener(null);
                                                    }

                                                    @Override
                                                    public void onLogUpdated() {
                                                    }
                                                });

                                        bleManager.startFileTransfer(fileBytesToSend);
                                    } catch (Exception e) {
                                        Toast.makeText(DialEditorActivity.this, "Error: " + e.getMessage(),
                                                Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .setNegativeButton(R.string.close, null)
                                .show();
                    });
                } else {
                    runOnUiThread(() -> {
                        btnUpload.setEnabled(true);
                        btnUpload.setText(R.string.compile);
                        Toast.makeText(this, "Compilation failed", Toast.LENGTH_SHORT).show();
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
                runOnUiThread(() -> {
                    btnUpload.setEnabled(true);
                    btnUpload.setText(R.string.compile);
                    Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                });
            }
        }).start();
    }

    private Bitmap ensureRgb565(Bitmap source) {
        if (source.getConfig() == Bitmap.Config.RGB_565 && !source.hasAlpha())
            return source;
        Bitmap rgb565Bmp = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(rgb565Bmp);
        canvas.drawColor(android.graphics.Color.BLACK);
        canvas.drawBitmap(source, 0, 0, null);
        return rgb565Bmp;
    }

    // ===================== SVG EDITOR =====================

    private void showSVGEditor(Uri svgUri, int elementType) {
        AlertDialog dialog;
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_svg_editor, null);
        ImageView imgPreview = view.findViewById(R.id.imgSvgPreview);
        LinearLayout colorPalette = view.findViewById(R.id.svgColorPalette);
        LinearLayout containerBattery = view.findViewById(R.id.containerBatteryOpts);
        SeekBar seekLevels = view.findViewById(R.id.seekLevels);
        TextView txtLevels = view.findViewById(R.id.txtLevelsVal);
        android.widget.CheckBox chkClip = view.findViewById(R.id.chkClipVertical);

        boolean isBattery = (elementType == DialCompiler.TYPE_BATTERY ||
                elementType == DialCompiler.TYPE_BATT_STRIP ||
                elementType == DialCompiler.TYPE_PROGRESS1 ||
                elementType == DialCompiler.TYPE_PROGRESS2);

        if (isBattery) {
            containerBattery.setVisibility(View.VISIBLE);
            int defFrames = DialCompiler.getDefaultFrameCount(elementType);
            seekLevels.setProgress(defFrames);
            txtLevels.setText(defFrames + " levels");
        } else {
            containerBattery.setVisibility(View.GONE);
        }

        seekLevels.setOnSeekBarChangeListener(new SimpleSeekListener() {
            @Override
            public void onProgressChanged(SeekBar sb, int val, boolean user) {
                txtLevels.setText(val + " levels");
            }
        });

        // Color Palette
        final int[] colors = {
                Color.WHITE, Color.BLACK, Color.parseColor("#FF4444"), Color.parseColor("#44FF44"),
                Color.parseColor("#4488FF"), Color.parseColor("#FFDD44"),
                Color.parseColor("#FF44FF"), Color.parseColor("#44FFFF"),
                Color.parseColor("#FF8844"), Color.parseColor("#88FF44"),
                Color.TRANSPARENT // Original color
        };
        final int[] selectedColor = { Color.WHITE }; // Default tint white

        for (int clr : colors) {
            View swatch = new View(this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            lp.setMargins(2, 2, 2, 2);
            swatch.setLayoutParams(lp);
            swatch.setTag(clr);
            GradientDrawable gd = new GradientDrawable();
            if (clr == Color.TRANSPARENT) {
                gd.setColor(Color.LTGRAY); // visual placeholder for "None"
            } else {
                gd.setColor(clr);
            }
            gd.setCornerRadius(6);
            if (clr == selectedColor[0])
                gd.setStroke(3, Color.parseColor("#58A6FF"));
            swatch.setBackground(gd);
            swatch.setOnClickListener(v -> {
                selectedColor[0] = clr;
                for (int i = 0; i < colorPalette.getChildCount(); i++) {
                    View child = colorPalette.getChildAt(i);
                    GradientDrawable bg = (GradientDrawable) child.getBackground();
                    bg.setStroke(3, ((int) child.getTag() == clr) ? Color.parseColor("#58A6FF") : Color.TRANSPARENT);
                }
                // Update preview
                updateSVGPreview(imgPreview, svgUri, selectedColor[0]);
            });
            colorPalette.addView(swatch);
        }

        // Initial Preview
        updateSVGPreview(imgPreview, svgUri, selectedColor[0]);

        new AlertDialog.Builder(this)
                .setTitle(R.string.svg_generator)
                .setView(view)
                .setPositiveButton(R.string.save, (d, w) -> {
                    generateSVGLayer(svgUri, elementType, selectedColor[0],
                            isBattery ? seekLevels.getProgress() : 1,
                            isBattery && chkClip.isChecked());
                })
                .setNegativeButton(R.string.cancel, null)
                .show();
    }

    private void updateSVGPreview(ImageView target, Uri uri, int tintColor) {
        try {
            InputStream is = getContentResolver().openInputStream(uri);
            SVG svg = SVG.getFromInputStream(is);
            is.close();

            if (tintColor != Color.TRANSPARENT) {
                // Apply tint to document locally for preview?
                // AndroidSVG doesn't easily support dynamic tinting of the whole doc structure
                // without CSS
                // Easier: Rasterize then tint Bitmap
            }

            // Render to a decent preview size (e.g. 200x200)
            // But preserve aspect ratio
            float docW = svg.getDocumentWidth();
            float docH = svg.getDocumentHeight();
            if (docW <= 0 || docH <= 0) {
                // Try viewBox
                if (svg.getDocumentViewBox() != null) {
                    docW = svg.getDocumentViewBox().width();
                    docH = svg.getDocumentViewBox().height();
                } else {
                    docW = 100;
                    docH = 100;
                }
            }

            float scale = Math.min(200f / docW, 200f / docH);
            int w = (int) (docW * scale);
            int h = (int) (docH * scale);

            Bitmap bmp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            Canvas c = new Canvas(bmp);

            if (tintColor != Color.TRANSPARENT) {
                // Not fully supported by AndroidSVG directly, use Paint/PorterDuff on the
                // bitmap later?
                // Actually, let's just render standard, then apply Tint filter if needed?
                // Or better: render standard, then apply ColorFilter to the ImageView?
                // But we need to generate correct bitmaps later.

                // For valid generation, we need to rasterize with tint.
                // Since AndroidSVG is read-only mostly, good trick: use CSS?
                // Or: Render to bitmap, then draw that bitmap with ColorFilter to a new bitmap.
            }

            svg.setDocumentWidth(w);
            svg.setDocumentHeight(h);
            svg.renderToCanvas(c);

            if (tintColor != Color.TRANSPARENT) {
                Bitmap tinted = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
                Canvas tc = new Canvas(tinted);
                Paint p = new Paint();
                p.setColorFilter(
                        new android.graphics.PorterDuffColorFilter(tintColor, android.graphics.PorterDuff.Mode.SRC_IN));
                tc.drawBitmap(bmp, 0, 0, p);
                bmp.recycle();
                target.setImageBitmap(tinted);
            } else {
                target.setImageBitmap(bmp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showSVGEditor(int elementType, String assetPath) {
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_svg_editor, null);
        ImageView imgPreview = view.findViewById(R.id.imgSvgPreview);
        SeekBar seekLevels = view.findViewById(R.id.seekLevels);
        TextView txtLevels = view.findViewById(R.id.txtLevelsVal);
        CheckBox switchClip = view.findViewById(R.id.chkClipVertical);
        LinearLayout colorPalette = view.findViewById(R.id.svgColorPalette);
        // Button btnPickColor = view.findViewById(R.id.btnPickColor); // Removed as not
        // in XML
        // Assuming user wants to pick tint from palette or wheel.
        // XML had colorPalette.

        final int[] tintColor = { Color.WHITE }; // Default tint
        final int[] levels = { 5 }; // Default levels for battery
        final boolean[] clip = { true };

        // Helper to update preview
        Runnable updatePreview = () -> {
            try {
                InputStream is = getAssets().open(assetPath);
                com.caverock.androidsvg.SVG svg = com.caverock.androidsvg.SVG.getFromInputStream(is);
                is.close();
                // We need to simulate clipping/tinting for preview
                // It's complex to preview clipping exactly without generating bitmaps
                // Let's just show the tinted SVG for now
                // Render to a decent preview size (e.g. 200x200)
                float docW = svg.getDocumentWidth();
                float docH = svg.getDocumentHeight();
                if (docW <= 0)
                    docW = 100;
                if (docH <= 0)
                    docH = 100;

                float scale = Math.min(200f / docW, 200f / docH);
                int w = (int) (docW * scale);
                int h = (int) (docH * scale);

                Bitmap bmp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
                Canvas c = new Canvas(bmp);
                c.scale(scale, scale);
                svg.renderToCanvas(c);

                // apply tint
                Bitmap tinted = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
                Canvas tc = new Canvas(tinted);
                Paint p = new Paint();
                p.setColorFilter(new android.graphics.PorterDuffColorFilter(tintColor[0],
                        android.graphics.PorterDuff.Mode.SRC_IN));
                tc.drawBitmap(bmp, 0, 0, p);
                bmp.recycle();
                imgPreview.setImageBitmap(tinted);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        // ... Setup UI listeners (simplified for brevity, copy from existing
        // showSVGEditor or refactor to share)
        // Actually, showSVGEditor(Uri) is not fully visible in snippet, but I should
        // use the same logic overloads.
        // I will implement a shared helper ShowSVGEditor(Uri uri, String assetPath, int
        // elementType)
        // But for now, let's just duplicate the essentials for asset path to be safe
        // and quick.

        // Color Palette
        int[] colors = { Color.WHITE, Color.BLACK, Color.RED, Color.GREEN, Color.BLUE, Color.CYAN, Color.MAGENTA,
                Color.YELLOW };
        for (int c : colors) {
            View swatch = new View(this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0, 100, 1);
            lp.setMargins(4, 4, 4, 4);
            swatch.setLayoutParams(lp);
            swatch.setBackgroundColor(c);
            swatch.setOnClickListener(v -> {
                tintColor[0] = c;
                updatePreview.run();
            });
            colorPalette.addView(swatch);
        }

        seekLevels.setOnSeekBarChangeListener(new SimpleSeekListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                levels[0] = Math.max(1, progress);
                txtLevels.setText("Levels: " + levels[0]);
            }
        });

        if (elementType == DialCompiler.TYPE_BATTERY) {
            seekLevels.setVisibility(View.VISIBLE);
            txtLevels.setVisibility(View.VISIBLE);
            switchClip.setVisibility(View.VISIBLE);
        } else {
            seekLevels.setVisibility(View.GONE);
            txtLevels.setVisibility(View.GONE);
            switchClip.setVisibility(View.GONE);
        }

        updatePreview.run();

        new AlertDialog.Builder(this)
                .setTitle("SVG Editor")
                .setView(view)
                .setPositiveButton("Add", (dialog, which) -> {
                    // Generate Layer
                    generateSVGLayerFromAsset(assetPath, elementType, tintColor[0], levels[0], switchClip.isChecked());
                })
                .setNegativeButton("Cancel", null)
                .show();
    }

    private void generateSVGLayerFromAsset(String assetPath, int elementType, int tintColor, int levels,
            boolean clipVertical) {
        try {
            InputStream is = getAssets().open(assetPath);
            com.caverock.androidsvg.SVG svg = com.caverock.androidsvg.SVG.getFromInputStream(is);
            is.close();

            // Common logic with generateSVGLayer(Uri).
            // Reuse logic?
            // Yes, extract core logic.
            // For now, implement inline to avoid disturbing existing method too much.

            float docW = svg.getDocumentWidth();
            float docH = svg.getDocumentHeight();
            if (docW <= 0)
                docW = 100;
            if (docH <= 0)
                docH = 100;

            // Render to Bitmap
            // Scale to fit screen logic? Or fixed size?
            // Let's assume reasonable icon size relative to canvas (e.g. 1/4 width?)
            // Or keep original density?
            // Assets might be small.
            // Let's render at 100x100 or 200x200 if no size.
            // Better: Render at a size suitable for the watch face (e.g. 50-100px).
            int w = (int) docW;
            int h = (int) docH;
            if (w < 50) {
                w *= 4;
                h *= 4;
            } // Scale up small icons

            Bitmap bmp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            Canvas c = new Canvas(bmp);
            c.scale((float) w / docW, (float) h / docH);
            svg.renderToCanvas(c);

            // Tint
            Bitmap tinted = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            Canvas tc = new Canvas(tinted);
            Paint p = new Paint();
            p.setColorFilter(
                    new android.graphics.PorterDuffColorFilter(tintColor, android.graphics.PorterDuff.Mode.SRC_IN));
            tc.drawBitmap(bmp, 0, 0, p);
            bmp.recycle();
            bmp = tinted;

            if (elementType == DialCompiler.TYPE_BATTERY) {
                // Clip for levels
                int frameH = h / levels;
                if (clipVertical) {
                    // We need 'levels' frames.
                    // If 'clipVertical' is true, we assume the SVG is a full battery and we crop
                    // it?
                    // Or we assume the SVG is one state and we duplicate it?
                    // The user said "Clip Vertical".
                    // Usually implies the battery icon is full, and we mask it.
                    // ... (Implementation detail: create frames by cropping the full icon)
                    // Actually, if we just want a static icon that changes color or shape, we need
                    // multiple frames.
                    // If the SVG is just one static icon, we can't magically make it empty unless
                    // we mask it.
                    // Let's assume the user wants to generate a "strip" of images by cropping the
                    // single SVG?
                    // Simple approach: Generate 'levels' frames.
                    // Frame 0: Empty (or 1 segment). Frame N: Full.
                    // If clipVertical:
                    // Loop i from 0 to levels-1:
                    // Crop rect: (0, H - (i+1)*frameH/levels, W, H) -> draw bottom part?
                    // Or draw full bitmap masked?
                    Bitmap[] frames = new Bitmap[levels];
                    for (int i = 0; i < levels; i++) {
                        Bitmap frame = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
                        Canvas fc = new Canvas(frame);
                        // Draw only a portion
                        // Percentage height
                        int visibleH = (int) ((float) (i + 1) / levels * h);
                        Rect src = new Rect(0, h - visibleH, w, h); // Bottom up
                        Rect dst = new Rect(0, h - visibleH, w, h);
                        fc.drawBitmap(bmp, src, dst, null);
                        frames[i] = frame;
                    }

                    DialLayer layer = new DialLayer(DialLayer.TYPE_ELEMENT, frames[0], "Battery (SVG)", elementType);
                    layer.frames = frames;
                    layer.frameCount = levels;
                    layers.add(layer);
                    refreshAll();
                } else {
                    // Just use as static icon?
                    DialLayer layer = new DialLayer(DialLayer.TYPE_ELEMENT, bmp, "Icon (SVG)", elementType);
                    layer.frames = new Bitmap[] { bmp };
                    layers.add(layer);
                    refreshAll();
                }
            } else {
                DialLayer layer = new DialLayer(DialLayer.TYPE_ELEMENT, bmp, "Icon (SVG)", elementType);
                layer.frames = new Bitmap[] { bmp };
                layers.add(layer);
                refreshAll();
            }
            Toast.makeText(this, "Added SVG Layer", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void generateSVGLayer(Uri uri, int elementType, int tintColor, int levels, boolean clipVertical) {
        try {
            InputStream is = getContentResolver().openInputStream(uri);
            SVG svg = SVG.getFromInputStream(is);
            is.close();

            // Determine target size
            // Default to some reasonable size if not battery?
            // Or use original size?
            float docW = svg.getDocumentWidth();
            float docH = svg.getDocumentHeight();
            if (docW <= 0 || docH <= 0) {
                if (svg.getDocumentViewBox() != null) {
                    docW = svg.getDocumentViewBox().width();
                    docH = svg.getDocumentViewBox().height();
                } else {
                    docW = 50;
                    docH = 50;
                }
            }

            // If it's too big, scale down? Or keep original?
            // Let's limit max dimension to 466 (screen size) to avoid huge heap usage
            float maxDim = Math.max(docW, docH);
            if (maxDim > 466) {
                float s = 466 / maxDim;
                docW *= s;
                docH *= s;
            }

            int w = (int) Math.ceil(docW);
            int h = (int) Math.ceil(docH);

            Bitmap baseBmp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            Canvas c = new Canvas(baseBmp);
            svg.setDocumentWidth(w);
            svg.setDocumentHeight(h);
            svg.renderToCanvas(c);

            // Apply tint
            if (tintColor != Color.TRANSPARENT) {
                Bitmap tinted = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
                Canvas tc = new Canvas(tinted);
                Paint p = new Paint();
                p.setColorFilter(
                        new android.graphics.PorterDuffColorFilter(tintColor, android.graphics.PorterDuff.Mode.SRC_IN));
                tc.drawBitmap(baseBmp, 0, 0, p);
                baseBmp.recycle();
                baseBmp = tinted;
            }

            Bitmap[] frames;

            if (levels > 1 && clipVertical) {
                // Generate clipped frames
                frames = new Bitmap[levels];
                // Frame 0..N-1.
                // Usually Frame 0 is lowest (empty?) or 1/N?
                // Let's assume linear fill from bottom.
                // Frame i (0-based) represents state i/(N-1) ?
                // Battery 6 levels: 0, 20, 40, 60, 80, 100?
                // If N=6.

                for (int i = 0; i < levels; i++) {
                    Bitmap frame = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
                    Canvas fc = new Canvas(frame);

                    // Ratio of fill
                    // If levels=5. i=0 -> 20%? or 0%?
                    // Typically index 0 is "empty" or "lowest".
                    // Let's say we split height into 'levels' chunks.
                    // But we want "accumulative" fill?
                    // Let's do: fillHeight = (i + 1) * (h / levels);

                    float fillRatio = (float) (i + 1) / levels;
                    // For battery, often index 0 is empty/low.
                    // If N=5. i=0->20%, i=4->100%.

                    int clipTop = (int) (h * (1 - fillRatio));

                    fc.save();
                    fc.clipRect(0, clipTop, w, h); // Keep bottom part
                    fc.drawBitmap(baseBmp, 0, 0, null);
                    fc.restore();

                    // If we want the "empty" part to be dim?
                    // User said "substitute logic... use fonts".
                    // For battery, usually 100% lit is full. 0% is empty.
                    // Currently we just clip. The "empty" part is transparent.
                    // This works if there is a background or if the user supplies a "dim" layer
                    // behind it.

                    frames[i] = frame;
                }
                baseBmp.recycle();

            } else if (levels > 1) {
                // Just repeat the same image?
                // Or maybe user wants identical frames for state-based logic?
                frames = new Bitmap[levels];
                for (int i = 0; i < levels; i++) {
                    frames[i] = baseBmp.copy(Bitmap.Config.ARGB_8888, false);
                }
                baseBmp.recycle();
            } else {
                frames = new Bitmap[] { baseBmp };
            }

            // Add layer
            String name = getBlockLabel(elementType);
            DialLayer layer = new DialLayer(DialLayer.TYPE_ELEMENT, frames[0], name, elementType);
            layer.frames = frames;
            layer.frameCount = frames.length;
            layer.isSpriteSheet = frames.length > 1;
            layer.alpha = 1.0f;
            layer.posX = canvasWidth / 2f - w / 2f;
            layer.posY = canvasHeight / 2f - h / 2f;
            layers.add(layer);
            selectedLayerIndex = layers.size() - 1;
            refreshAll();

            Toast.makeText(this, "✓ " + name, Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "SVG Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void copyFile(File src, File dst) throws IOException {
        java.io.FileInputStream fis = new java.io.FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(dst);
        byte[] buf = new byte[4096];
        int len;
        while ((len = fis.read(buf)) > 0)
            fos.write(buf, 0, len);
        fos.close();
        fis.close();
    }

    private static abstract class SimpleSeekListener implements SeekBar.OnSeekBarChangeListener {
        @Override
        public void onStartTrackingTouch(SeekBar sb) {
        }

        @Override
        public void onStopTrackingTouch(SeekBar sb) {
        }
    }
}
