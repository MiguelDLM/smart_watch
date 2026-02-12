package com.example.dialsender;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DialEditorActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    
    private FrameLayout previewContainer;
    private Button btnAddElement, btnUpload, btnRemoveLayer, btnMoveUp, btnMoveDown;
    private TextView txtSelectedLayer;
    private SeekBar seekScale, seekRotation;
    
    private List<DialLayer> layers = new ArrayList<>();
    private int selectedLayerIndex = -1;
    private int pendingElementType = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Initialize Python if needed
        if (!Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }

        setContentView(R.layout.activity_dial_editor);

        // Bind Views
        previewContainer = findViewById(R.id.previewContainer);
        btnAddElement = findViewById(R.id.btnAddElement);
        btnUpload = findViewById(R.id.btnUpload);
        btnRemoveLayer = findViewById(R.id.btnRemoveLayer);
        btnMoveUp = findViewById(R.id.btnMoveUp);
        btnMoveDown = findViewById(R.id.btnMoveDown);
        txtSelectedLayer = findViewById(R.id.txtSelectedLayer);
        seekScale = findViewById(R.id.seekScale);
        seekRotation = findViewById(R.id.seekRotation);

        // Listeners
        btnAddElement.setOnClickListener(v -> showElementTypeDialog());
        btnUpload.setOnClickListener(v -> compileAndFinish());
        
        btnRemoveLayer.setOnClickListener(v -> {
            if (selectedLayerIndex >= 0 && selectedLayerIndex < layers.size()) {
                layers.remove(selectedLayerIndex);
                selectedLayerIndex = -1;
                updatePreview();
                updateControls();
            }
        });

        btnMoveUp.setOnClickListener(v -> moveLayer(-1));
        btnMoveDown.setOnClickListener(v -> moveLayer(1));

        seekScale.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (selectedLayerIndex >= 0 && fromUser) {
                    layers.get(selectedLayerIndex).scale = progress / 100f;
                    updatePreview(); 
                }
            }
            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        seekRotation.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (selectedLayerIndex >= 0 && fromUser) {
                    layers.get(selectedLayerIndex).rotation = (float) progress;
                    updatePreview();
                }
            }
            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        
        updateControls();
    }

    private void moveLayer(int direction) {
        if (selectedLayerIndex < 0) return;
        int newIndex = selectedLayerIndex + direction;
        if (newIndex < 0 || newIndex >= layers.size()) return;
        
        Collections.swap(layers, selectedLayerIndex, newIndex);
        selectedLayerIndex = newIndex;
        updatePreview();
        updateControls();
    }

    private void showElementTypeDialog() {
        String[] types = {"Background (Gallery)", "Digital Hour", "Digital Minute", "Steps (Value)", "Heart (Value)"};
        int[] typeCodes = {
            DialCompiler.TYPE_BACKGROUND, 
            DialCompiler.TYPE_DIGITAL_HOUR, 
            DialCompiler.TYPE_DIGITAL_MIN,
            DialCompiler.TYPE_STEPS,
            DialCompiler.TYPE_HEART
        };

        new AlertDialog.Builder(this)
            .setTitle("Add Layer Type")
            .setItems(types, (dialog, which) -> {
                pendingElementType = typeCodes[which];
                if (pendingElementType == DialCompiler.TYPE_BACKGROUND) {
                    openImagePicker();
                } else {
                    showAssetGallery(pendingElementType);
                }
            })
            .show();
    }

    private void showAssetGallery(int elementType) {
        // Determine asset path based on type
        String basePath = "dial_customize_2";
        List<String> styles = new ArrayList<>();
        
        try {
            // Simple logic: list top level folders. 
            // In a real app we'd scan recursively. Here we hardcode known paths from ls output.
            if (elementType == DialCompiler.TYPE_DIGITAL_HOUR || elementType == DialCompiler.TYPE_DIGITAL_MIN) {
                // time/digital/0..6
                String[] variants = getAssets().list(basePath + "/time/digital");
                if (variants != null) {
                    for (String v : variants) styles.add(basePath + "/time/digital/" + v + "/hour_minute");
                }
            } else {
                // value/0..6
                String[] variants = getAssets().list(basePath + "/value");
                if (variants != null) {
                    for (String v : variants) styles.add(basePath + "/value/" + v);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String[] styleNames = new String[styles.size()];
        for (int i = 0; i < styles.size(); i++) styleNames[i] = "Style " + (i + 1);

        new AlertDialog.Builder(this)
            .setTitle("Select Style")
            .setItems(styleNames, (dialog, which) -> {
                addAssetLayer(styles.get(which), elementType);
            })
            .show();
    }

    private void openImagePicker() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            addBackgroundLayer(data.getData());
        }
    }

    private void addBackgroundLayer(Uri uri) {
        try {
            InputStream is = getContentResolver().openInputStream(uri);
            Bitmap original = BitmapFactory.decodeStream(is);
            
            // Resize background to fit
            Bitmap scaled = Bitmap.createScaledBitmap(original, 466, 466, true);
            
            DialLayer layer = new DialLayer(DialLayer.TYPE_BACKGROUND, scaled, "Background", DialCompiler.TYPE_BACKGROUND);
            
            // Put background at bottom
            if (!layers.isEmpty() && layers.get(0).type == DialLayer.TYPE_BACKGROUND) {
                layers.set(0, layer);
            } else {
                layers.add(0, layer);
            }
            selectedLayerIndex = 0;
            
            updatePreview();
            updateControls();
            
        } catch (Exception e) {
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void addAssetLayer(String assetFolder, int type) {
        try {
            // Load frames 0-9
            Bitmap[] frames = new Bitmap[10];
            for (int i = 0; i < 10; i++) {
                InputStream is = getAssets().open(assetFolder + "/" + i + ".png");
                frames[i] = BitmapFactory.decodeStream(is);
            }

            String name = (type == DialCompiler.TYPE_DIGITAL_HOUR) ? "Hour" : 
                          (type == DialCompiler.TYPE_DIGITAL_MIN) ? "Min" : "Value";

            DialLayer layer = new DialLayer(DialLayer.TYPE_ELEMENT, frames[0], name, type);
            layer.frames = frames; // Store full animation set
            
            layer.x = 100;
            layer.y = 100;
            layer.hasAlpha = true;
            
            layers.add(layer);
            selectedLayerIndex = layers.size() - 1;
            
            updatePreview();
            updateControls();

        } catch (Exception e) {
            Toast.makeText(this, "Error loading assets: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void updatePreview() {
        previewContainer.removeAllViews();
        
        for (int i = 0; i < layers.size(); i++) {
            DialLayer layer = layers.get(i);
            final int index = i;
            
            ImageView iv = new ImageView(this);
            iv.setImageBitmap(layer.originalBitmap); // Show first frame
            iv.setScaleX(layer.scale);
            iv.setScaleY(layer.scale);
            iv.setRotation(layer.rotation);
            iv.setX(layer.x);
            iv.setY(layer.y);
            
            if (i == selectedLayerIndex) {
                iv.setAlpha(1.0f);
                iv.setBackgroundResource(R.drawable.circle_mask);
            } else {
                iv.setAlpha(1.0f); 
                iv.setBackground(null);
            }
            
            iv.setOnTouchListener(new View.OnTouchListener() {
                float dX, dY;
                @Override
                public boolean onTouch(View view, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            dX = view.getX() - event.getRawX();
                            dY = view.getY() - event.getRawY();
                            selectedLayerIndex = index;
                            updateControls();
                            updatePreview(); // Redraw selection
                            return true;
                        case MotionEvent.ACTION_MOVE:
                            if (selectedLayerIndex == index) {
                                float newX = event.getRawX() + dX;
                                float newY = event.getRawY() + dY;
                                view.setX(newX);
                                view.setY(newY);
                                layer.x = newX;
                                layer.y = newY;
                            }
                            return true;
                    }
                    return false;
                }
            });
            
            previewContainer.addView(iv);
        }
    }

    private void updateControls() {
        if (selectedLayerIndex >= 0 && selectedLayerIndex < layers.size()) {
            DialLayer layer = layers.get(selectedLayerIndex);
            txtSelectedLayer.setText("Selected: " + layer.name + " (" + layer.elementType + ")");
            seekScale.setProgress((int)(layer.scale * 100));
            seekRotation.setProgress((int)layer.rotation);
            
            btnRemoveLayer.setEnabled(true);
            seekScale.setEnabled(true);
            seekRotation.setEnabled(true);
        } else {
            txtSelectedLayer.setText("No Layer Selected");
            btnRemoveLayer.setEnabled(false);
            seekScale.setEnabled(false);
            seekRotation.setEnabled(false);
        }
    }

    private void compileAndFinish() {
        btnUpload.setEnabled(false);
        btnUpload.setText("Compiling...");
        
        new Thread(() -> {
            try {
                DialCompiler compiler = new DialCompiler(466, 466);
                
                // Add Preview Image (Snapshot)
                if (!layers.isEmpty()) {
                    DialCompiler.DialBlock preview = new DialCompiler.DialBlock();
                    preview.type = DialCompiler.TYPE_PREVIEW;
                    // Use background for preview
                    Bitmap bg = layers.get(0).originalBitmap; 
                    preview.images = new Bitmap[]{Bitmap.createScaledBitmap(bg, 240, 240, true)};
                    preview.width = 240;
                    preview.height = 240;
                    preview.picIdx = 0;
                    compiler.addBlock(preview);
                }

                // Add Layers
                for (int i = 0; i < layers.size(); i++) {
                    DialLayer layer = layers.get(i);
                    DialCompiler.DialBlock block = new DialCompiler.DialBlock();
                    block.type = layer.elementType;
                    block.x = (int) layer.x;
                    block.y = (int) layer.y;
                    
                    // Zzuler picIdx logic: 
                    // 0=Preview, 1=Bg, 2..N=Elements
                    // If layer 0 is background, it gets picIdx 1.
                    // Subsequent layers get 2, 3, etc.
                    // We assume layer 0 is ALWAYS background for simplicity
                    block.picIdx = i + 1; 

                    // Transform ALL frames
                    Bitmap[] processedFrames = new Bitmap[layer.frames.length];
                    for(int f=0; f<layer.frames.length; f++) {
                        Bitmap src = layer.frames[f];
                        Matrix matrix = new Matrix();
                        matrix.postScale(layer.scale, layer.scale);
                        matrix.postRotate(layer.rotation);
                        processedFrames[f] = Bitmap.createBitmap(src, 0, 0, src.getWidth(), src.getHeight(), matrix, true);
                    }
                    
                    block.images = processedFrames;
                    block.frames = processedFrames.length;
                    block.width = processedFrames[0].getWidth();
                    block.height = processedFrames[0].getHeight();
                    block.hasAlpha = (layer.type != DialLayer.TYPE_BACKGROUND);
                    
                    compiler.addBlock(block);
                }
                
                File cacheDir = getCacheDir();
                File outFile = compiler.compile(cacheDir, "custom_dial.bin");
                
                runOnUiThread(() -> {
                    Toast.makeText(this, "Dial Ready! " + outFile.length() + " bytes", Toast.LENGTH_LONG).show();
                    Intent result = new Intent();
                    result.setData(Uri.fromFile(outFile));
                    setResult(RESULT_OK, result);
                    finish();
                });
                
            } catch (Exception e) {
                e.printStackTrace();
                runOnUiThread(() -> {
                    Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                    btnUpload.setEnabled(true);
                    btnUpload.setText("RETRY");
                });
            }
        }).start();
    }
}
