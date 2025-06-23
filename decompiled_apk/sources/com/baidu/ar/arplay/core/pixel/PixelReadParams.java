package com.baidu.ar.arplay.core.pixel;

import android.graphics.Rect;
import com.baidu.ar.arplay.core.renderer.ARPRenderer;

/* loaded from: classes7.dex */
public class PixelReadParams {
    private static final int DEFAULT_CACHE_SIZE = 3;
    public static final String DEFAULT_FILTER_ID = "camera";
    private static final int DEFAULT_ROTATE_DEGREE = 0;
    private static final ScaleType DEFAULT_SCALE_TYPE = ScaleType.FIT_XY;
    public static final String TERMINAL_FILTER_ID = "target";
    private int mOutputHeight;
    private int mOutputWidth;
    private PixelType mPixelType;
    private Rect mReadRect;
    private ScaleType mScaleType = DEFAULT_SCALE_TYPE;
    private PixelRotation mPixelRotation = PixelRotation.NoRotation;
    private int mCacheSize = 3;
    private boolean mIsPortrait = false;
    private String mPreFilterID = "";
    private FrameType mFrameType = FrameType.STREAM_FRAME;

    /* loaded from: classes7.dex */
    public enum FrameType {
        STREAM_FRAME(0),
        SINGLE_FRAME(1);

        private final int value;

        FrameType(int i) {
            this.value = i;
        }

        public static FrameType valueOf(int i) {
            FrameType frameType = STREAM_FRAME;
            if (i == frameType.getValue()) {
                return frameType;
            }
            FrameType frameType2 = SINGLE_FRAME;
            return i == frameType2.getValue() ? frameType2 : frameType;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: classes7.dex */
    public enum ScaleType {
        FIT_XY,
        FIT_CENTER,
        CENTER_CROP,
        EQUAL_SCALE
    }

    public PixelReadParams(PixelType pixelType) {
        this.mPixelType = pixelType;
    }

    public boolean equals(Object obj) {
        Rect rect;
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PixelReadParams pixelReadParams = (PixelReadParams) obj;
            if (this.mPixelType == pixelReadParams.mPixelType && this.mOutputWidth == pixelReadParams.mOutputWidth && this.mOutputHeight == pixelReadParams.mOutputHeight && this.mPixelRotation == pixelReadParams.mPixelRotation && this.mScaleType == pixelReadParams.mScaleType && (((rect = this.mReadRect) == null && pixelReadParams.mReadRect == null) || (rect != null && rect.equals(pixelReadParams.mReadRect)))) {
                return true;
            }
        }
        return false;
    }

    public int getAlgoHeight() {
        return ARPRenderer.needRotate(this.mPixelRotation.getValue()) ? this.mOutputWidth : this.mOutputHeight;
    }

    public int getAlgoWidth() {
        return ARPRenderer.needRotate(this.mPixelRotation.getValue()) ? this.mOutputHeight : this.mOutputWidth;
    }

    public int getCacheSize() {
        return this.mCacheSize;
    }

    public FrameType getFrameType() {
        return this.mFrameType;
    }

    public boolean getIsPortrait() {
        return this.mIsPortrait;
    }

    public int getOutputHeight() {
        return this.mOutputHeight;
    }

    public int getOutputWidth() {
        return this.mOutputWidth;
    }

    public PixelRotation getPixelRotate() {
        return this.mPixelRotation;
    }

    public PixelType getPixelType() {
        return this.mPixelType;
    }

    public String getPreFilterID() {
        return this.mPreFilterID;
    }

    public Rect getReadRect() {
        return this.mReadRect;
    }

    public ScaleType getScaleType() {
        return this.mScaleType;
    }

    public void setCacheSize(int i) {
        this.mCacheSize = i;
    }

    public void setFrameType(FrameType frameType) {
        this.mFrameType = frameType;
    }

    public void setIsPortrait(boolean z) {
        this.mIsPortrait = z;
    }

    public void setOutputHeight(int i) {
        this.mOutputHeight = i;
    }

    public void setOutputWidth(int i) {
        this.mOutputWidth = i;
    }

    public void setPixelRotate(PixelRotation pixelRotation) {
        this.mPixelRotation = pixelRotation;
    }

    public void setPixelType(PixelType pixelType) {
        this.mPixelType = pixelType;
    }

    public void setPreFilterID(String str) {
        this.mPreFilterID = str;
    }

    public void setReadRect(Rect rect) {
        this.mReadRect = rect;
    }

    public void setScaleType(ScaleType scaleType) {
        this.mScaleType = scaleType;
    }
}
