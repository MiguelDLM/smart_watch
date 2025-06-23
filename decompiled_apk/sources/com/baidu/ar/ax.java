package com.baidu.ar;

import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;

/* loaded from: classes7.dex */
public class ax {
    private static final String TAG = "ax";
    private SurfaceTexture ga;
    private Surface iJ;
    private Canvas iK;
    public int mTextureId;
    private int iH = 500;
    private int iI = 500;
    private boolean iL = true;

    public Surface a(int i, int i2, int i3) {
        this.mTextureId = i;
        this.ga = new SurfaceTexture(i);
        h(i2, i3);
        Surface surface = new Surface(this.ga);
        this.iJ = surface;
        return surface;
    }

    public void bk() {
        Canvas canvas = this.iK;
        if (canvas != null) {
            this.iJ.unlockCanvasAndPost(canvas);
        }
        this.iK = null;
    }

    public void h(int i, int i2) {
        this.iH = i;
        this.iI = i2;
        this.ga.setDefaultBufferSize(i, i2);
    }

    public Canvas lockCanvas() {
        this.iK = null;
        Surface surface = this.iJ;
        if (surface != null) {
            try {
                this.iK = surface.lockCanvas(null);
            } catch (Exception e) {
                Log.e(TAG, "error while rendering view to gl: " + e);
            }
        }
        return this.iK;
    }

    public void release() {
        Surface surface = this.iJ;
        if (surface != null) {
            surface.release();
        }
        SurfaceTexture surfaceTexture = this.ga;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        this.iJ = null;
        this.ga = null;
    }

    public void update() {
        try {
            this.ga.updateTexImage();
        } catch (Exception e) {
            Log.e(TAG, "error while update view to gl: " + e);
        }
    }
}
