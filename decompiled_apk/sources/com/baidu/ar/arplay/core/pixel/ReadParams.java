package com.baidu.ar.arplay.core.pixel;

import android.graphics.Rect;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;

/* loaded from: classes7.dex */
public class ReadParams {
    private static final int DEFAULT_CACHE_SIZE = 3;
    private static final int DEFAULT_ROTATE_DEGREE = 0;
    private PixelType mPixelType;
    private Rect mReadRect;
    private FrameSize mTargetFrameSize;
    private static final PixelReadParams.ScaleType DEFAULT_SCALE_TYPE = PixelReadParams.ScaleType.FIT_XY;
    private static final MirrorType DEFAULT_MIRROR_TYPE = MirrorType.NO_MIRROR;
    private PixelReadParams.ScaleType mScaleType = DEFAULT_SCALE_TYPE;
    private MirrorType mMirrorType = DEFAULT_MIRROR_TYPE;
    private int mRotateDegree = 0;
    private boolean mUsePBO = true;
    private int mCacheSize = 3;

    public ReadParams(PixelType pixelType) {
        this.mPixelType = pixelType;
    }

    public int getCacheSize() {
        return this.mCacheSize;
    }

    public MirrorType getMirrorType() {
        return this.mMirrorType;
    }

    public PixelType getPixelType() {
        return this.mPixelType;
    }

    public Rect getReadRect() {
        return this.mReadRect;
    }

    public int getRotateDegree() {
        return this.mRotateDegree;
    }

    public PixelReadParams.ScaleType getScaleType() {
        return this.mScaleType;
    }

    public FrameSize getTargetFrameSize() {
        return this.mTargetFrameSize;
    }

    public boolean isUsePBO() {
        return this.mUsePBO;
    }

    public void setCacheSize(int i) {
        this.mCacheSize = i;
    }

    public void setMirrorType(MirrorType mirrorType) {
        this.mMirrorType = mirrorType;
    }

    public void setPixelType(PixelType pixelType) {
        this.mPixelType = pixelType;
    }

    public void setReadRect(Rect rect) {
        this.mReadRect = rect;
    }

    public void setRotateDegree(int i) {
        this.mRotateDegree = i;
    }

    public void setScaleType(PixelReadParams.ScaleType scaleType) {
        this.mScaleType = scaleType;
    }

    public void setTargetFrameSize(FrameSize frameSize) {
        this.mTargetFrameSize = frameSize;
    }

    public void setUsePBO(boolean z) {
        this.mUsePBO = z;
    }
}
