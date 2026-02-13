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
                        selectedBorderColor[0], seekGlow, seekBorder, seekSpacing);
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
                        selectedBorderColor[0], seekGlow, seekBorder, seekSpacing);
            });
            borderColorPalette.addView(swatch);
        }

        // Update preview on any change
        SimpleSeekListener seekListener = new SimpleSeekListener() {
            @Override
            public void onProgressChanged(SeekBar sb, int val, boolean user) {
                updatePreviewAction(imgPreview, spinnerFont, fontFaces, seekSize, selectedColor[0],
                        selectedBorderColor[0], seekGlow, seekBorder, seekSpacing);
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
                        selectedBorderColor[0], seekGlow, seekBorder, seekSpacing);
            }

            @Override
            public void onNothingSelected(android.widget.AdapterView<?> p) {
            }
        });

        // Initial preview
        updatePreviewAction(imgPreview, spinnerFont, fontFaces, seekSize, selectedColor[0],
                selectedBorderColor[0], seekGlow, seekBorder, seekSpacing);

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
                    int spacing = seekSpacing.getProgress();

                    Bitmap[] frames = renderDigitBitmaps(elementType, tf, size, color, borderColor, glow, border,
                            spacing);
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
            SeekBar seekBorder, SeekBar seekSpacing) {
        if (spinnerFont.getSelectedItemPosition() < 0 || spinnerFont.getSelectedItemPosition() >= fontFaces.size())
            return;
        updateFontPreview(imgPreview,
                fontFaces.get(spinnerFont.getSelectedItemPosition()),
                seekSize.getProgress(), color, borderColor, seekGlow.getProgress(), seekBorder.getProgress(),
                seekSpacing.getProgress());
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
        int padding = Math.max(glowRadius * 2, borderWidth * 2) + 4;

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
            int color, int borderColor, int glowRadius, int borderWidth, int spacing) {
        if (size < 16)
            size = 16;
        int expectedFrames = DialCompiler.getDefaultFrameCount(elementType);
        String[] glyphs;

        if (elementType == DialCompiler.TYPE_AMPM) {
            glyphs = new String[] { "AM", "PM" };
        } else if (elementType == DialCompiler.TYPE_WEEKDAY) {
            glyphs = new String[] { "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN" };
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
        int padding = Math.max(glowRadius * 2, borderWidth * 2) + 2;
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
                        InputStream is = getAssets().open(assetPath + "/" + name);
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
                        InputStream is = getAssets().open(assetPath + "/" + i + ".png");
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
                Bitmap scaledPreview = Bitmap.createScaledBitmap(previewBmp, 280, 280, true);

                DialCompiler.DialBlock previewBlock = new DialCompiler.DialBlock();
                previewBlock.type = DialCompiler.TYPE_PREVIEW;
                previewBlock.width = 280;
                previewBlock.height = 280;
                previewBlock.x = 0;
                previewBlock.y = 0;
                previewBlock.frames = 1;
                previewBlock.images = new Bitmap[] { scaledPreview };
                compiler.addBlock(previewBlock);

                for (DialLayer layer : layers) {
                    DialCompiler.DialBlock block = new DialCompiler.DialBlock();
                    block.type = layer.nativeElementType;
                    block.x = (int) layer.posX;
                    block.y = (int) layer.posY;

                    // Background: flatten to canvas-sized RGB composite (no alpha)
                    if (layer.nativeElementType == DialCompiler.TYPE_BACKGROUND) {
                        // Draw onto ARGB first for proper blending, then convert
                        Bitmap bgTemp = Bitmap.createBitmap(canvasWidth, canvasHeight, Bitmap.Config.ARGB_8888);
                        Canvas bgCanvas = new Canvas(bgTemp);
                        bgCanvas.drawColor(Color.BLACK);
                        Bitmap src = (layer.frames != null && layer.frames.length > 0) ? layer.frames[0] : layer.icon;
                        if (src != null) {
                            Matrix bgm = new Matrix();
                            bgm.postScale(layer.scale, layer.scale);
                            if (layer.rotation != 0) {
                                float sw = src.getWidth() * layer.scale;
                                float sh = src.getHeight() * layer.scale;
                                bgm.postRotate(layer.rotation, sw / 2, sh / 2);
                            }
                            bgm.postTranslate(layer.posX, layer.posY);
                            bgCanvas.drawBitmap(src, bgm, null);
                        }
                        // Convert to RGB_565 to strip alpha — prevents comp_decomp RGBA/RGB mismatch
                        Bitmap bgComposite = Bitmap.createBitmap(canvasWidth, canvasHeight, Bitmap.Config.RGB_565);
                        Canvas rgbCanvas = new Canvas(bgComposite);
                        rgbCanvas.drawBitmap(bgTemp, 0, 0, null);
                        bgTemp.recycle();

                        block.images = new Bitmap[] { bgComposite };
                        block.frames = 1;
                        block.width = canvasWidth;
                        block.height = canvasHeight;
                        block.x = 0;
                        block.y = 0;
                        block.hasAlpha = false;
                        compiler.addBlock(block);
                        continue;
                    }

                    // Other elements: scale each frame properly
                    // BUT analog hands are NEVER scaled — firmware requires exact preset dims
                    boolean isHand = (block.type == DialCompiler.TYPE_ARM_HOUR ||
                            block.type == DialCompiler.TYPE_ARM_MIN ||
                            block.type == DialCompiler.TYPE_ARM_SEC);

                    if (layer.frames != null && layer.frames.length > 0) {
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
                                .setMessage(size + " — " + getString(R.string.saved_to_library))
                                .setPositiveButton(R.string.send_dial, (d, w) -> {
                                    Intent sendIntent = new Intent(this, MainActivity.class);
                                    sendIntent.putExtra("dial_file_path", savedFile.getAbsolutePath());
                                    startActivity(sendIntent);
                                })
                                .setNegativeButton(R.string.cancel, null)
                                .setCancelable(true)
                                .show();
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
