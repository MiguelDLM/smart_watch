package com.baidu.ar;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;

/* loaded from: classes7.dex */
public class DuMixTarget {
    private SurfaceTexture cg;
    private SurfaceTexture.OnFrameAvailableListener ch;
    private SurfaceHolder ci;
    private int cj;
    private int ck;
    private a cl;
    private boolean cm;

    /* loaded from: classes7.dex */
    public enum a {
        MATRIX,
        FIT_XY,
        FIT_START,
        FIT_CENTER,
        FIT_END,
        CENTER,
        CENTER_CROP,
        CENTER_INSIDE
    }

    public DuMixTarget(SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, int i, int i2, boolean z) {
        this.cg = surfaceTexture;
        this.ch = onFrameAvailableListener;
        this.cj = i;
        this.ck = i2;
        this.cm = z;
    }

    public SurfaceTexture getDrawTarget() {
        return this.cg;
    }

    public a getScaleType() {
        return this.cl;
    }

    public SurfaceHolder getSurfaceHolder() {
        return this.ci;
    }

    public SurfaceTexture.OnFrameAvailableListener getTargetFrameAvailableListener() {
        return this.ch;
    }

    public int getTargetHeight() {
        return this.ck;
    }

    public int getTargetWidth() {
        return this.cj;
    }

    public boolean isDrawPreview() {
        return this.cm;
    }

    public void setDrawPreview(boolean z) {
        this.cm = z;
    }

    public void setDrawTarget(SurfaceTexture surfaceTexture) {
        this.cg = surfaceTexture;
    }

    public void setScaleType(a aVar) {
        this.cl = aVar;
    }

    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        this.ci = surfaceHolder;
    }

    public void setTargetFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        this.ch = onFrameAvailableListener;
    }

    public void setTargetHeight(int i) {
        this.ck = i;
    }

    public void setTargetWidth(int i) {
        this.cj = i;
    }

    public DuMixTarget(SurfaceHolder surfaceHolder, int i, int i2, boolean z) {
        this.ci = surfaceHolder;
        this.cj = i;
        this.ck = i2;
        this.cm = z;
    }
}
