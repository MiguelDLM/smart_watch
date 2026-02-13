package com.example.dialsender;

import android.graphics.Bitmap;

public class DialLayer {
    public static final int TYPE_BACKGROUND = 0;
    public static final int TYPE_ELEMENT = 1;
    public static final int TYPE_ARM = 2;
    public static final int TYPE_PREVIEW = 3;

    public int layerType;
    public Bitmap icon; // Thumbnail or first frame
    public String name;
    public int nativeElementType; // From DialCompiler type constants

    // Transform
    public float scale = 1.0f;
    public float rotation = 0;
    public float posX = 0;
    public float posY = 0;
    public float alpha = 1.0f;

    // Sprite sheet support
    public Bitmap[] frames; // Individual sub-image frames
    public int frameCount = 1;
    public boolean isSpriteSheet = false;
    public boolean locked = false;

    // Full composite bitmap for sprite-sheets loaded from file
    public Bitmap compositeImage;

    public DialLayer(int layerType, Bitmap icon, String name) {
        this.layerType = layerType;
        this.icon = icon;
        this.name = name;
        this.nativeElementType = DialCompiler.TYPE_BACKGROUND;
    }

    public DialLayer(int layerType, Bitmap icon, String name, int nativeElementType) {
        this.layerType = layerType;
        this.icon = icon;
        this.name = name;
        this.nativeElementType = nativeElementType;
        this.frameCount = DialCompiler.getDefaultFrameCount(nativeElementType);
        this.isSpriteSheet = frameCount > 1;
    }
}
