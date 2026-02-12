package com.example.dialsender;

import android.graphics.Bitmap;
import android.graphics.Matrix;

public class DialLayer {
    public static final int TYPE_BACKGROUND = 0;
    public static final int TYPE_ELEMENT = 1;

    public int type;
    public Bitmap originalBitmap; // La imagen original cargada
    public String name;
    
    // Propiedades de transformación
    public float x = 0;
    public float y = 0;
    public float scale = 1.0f;
    public float rotation = 0;
    
    // Propiedades nativas
    public int elementType; // ID del tipo nativo (ej: 9 para hora)
    public int picIdx; // For sorting
    public boolean hasAlpha = false; // Add this field
    
    public Bitmap[] frames; // For animation/digits (0-9)

    public DialLayer(int type, Bitmap bitmap, String name, int elementType) {
        this.type = type;
        this.originalBitmap = bitmap;
        this.name = name;
        this.elementType = elementType;
        
        // Default frames to single image
        this.frames = new Bitmap[]{bitmap};
        
        if (type == TYPE_BACKGROUND) {
            this.x = 0;
            this.y = 0;
            this.picIdx = 1;
        } else {
            this.x = 100;
            this.y = 100;
            this.picIdx = 2; // Will be re-assigned
        }
    }

    // Obtener el bitmap con las transformaciones aplicadas para compilar
    public Bitmap getTransformedBitmap() {
        if (type == TYPE_BACKGROUND) {
            // El fondo siempre se escala a 466x466 exactos
            return Bitmap.createScaledBitmap(originalBitmap, 466, 466, true);
        }

        Matrix matrix = new Matrix();
        matrix.postScale(scale, scale);
        matrix.postRotate(rotation);

        return Bitmap.createBitmap(originalBitmap, 0, 0, 
            originalBitmap.getWidth(), originalBitmap.getHeight(), matrix, true);
    }
}
