package com.baidu.ar;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.ar.arrender.Texture;
import com.baidu.ar.bean.MirriorType;
import com.baidu.ar.bean.RotationType;
import com.baidu.ar.bean.ScaleType;
import com.baidu.ar.bean.Watermark;

/* loaded from: classes7.dex */
public class DuMixOutput {
    private MirriorType bP;
    private Object bS;
    private boolean bT;
    private ScaleType bU;
    private boolean bV;
    private int bW;
    private int bX;
    private Watermark bY;
    private int mOutputHeight;
    private int mOutputWidth;
    private RotationType mRotationType;

    public DuMixOutput() {
        this.bS = null;
        this.bT = false;
        this.bU = ScaleType.CENTER_CROP;
        this.bV = true;
        this.bW = 1;
        this.mRotationType = RotationType.ROTATE_0;
        this.bP = MirriorType.NO_MIRRIOR;
        this.bX = 0;
    }

    public MirriorType getMirriorType() {
        return this.bP;
    }

    public int getOutputFPS() {
        return this.bX;
    }

    public int getOutputHeight() {
        return this.mOutputHeight;
    }

    public Object getOutputSurface() {
        return this.bS;
    }

    public Texture getOutputTexture() {
        Object obj = this.bS;
        if (obj == null || !(obj instanceof Texture)) {
            return null;
        }
        return (Texture) obj;
    }

    public int getOutputWidth() {
        return this.mOutputWidth;
    }

    public RotationType getRotationType() {
        return this.mRotationType;
    }

    public ScaleType getScaleType() {
        return this.bU;
    }

    public int getScreenOrientation() {
        return this.bW;
    }

    public Watermark getWatermark() {
        return this.bY;
    }

    public boolean isFitScreenAuto() {
        return this.bV;
    }

    public boolean isNeedDetach() {
        return this.bT;
    }

    public void setFitScreenAuto(boolean z) {
        this.bV = z;
    }

    public void setMirriorType(MirriorType mirriorType) {
        this.bP = mirriorType;
    }

    public void setNeedDetach(boolean z) {
        this.bT = z;
    }

    public void setOutputFPS(int i) {
        this.bX = i;
    }

    public void setOutputHeight(int i) {
        this.mOutputHeight = i;
    }

    public void setOutputSurface(SurfaceTexture surfaceTexture) {
        this.bS = surfaceTexture;
    }

    public void setOutputTexture(Texture texture) {
        this.bS = texture;
    }

    public void setOutputWidth(int i) {
        this.mOutputWidth = i;
    }

    public void setRotationType(RotationType rotationType) {
        this.mRotationType = rotationType;
    }

    public void setScaleType(ScaleType scaleType) {
        this.bU = scaleType;
    }

    public void setScreenOrientation(int i) {
        this.bW = i;
    }

    public void setWatermark(Watermark watermark) {
        this.bY = watermark;
    }

    public DuMixOutput(int i, int i2) {
        this.bS = null;
        this.bT = false;
        this.bU = ScaleType.CENTER_CROP;
        this.bV = true;
        this.bW = 1;
        this.mRotationType = RotationType.ROTATE_0;
        this.bP = MirriorType.NO_MIRRIOR;
        this.bX = 0;
        this.mOutputWidth = i;
        this.mOutputHeight = i2;
    }

    public void setOutputSurface(Surface surface) {
        this.bS = surface;
    }

    public DuMixOutput(SurfaceTexture surfaceTexture, int i, int i2) {
        this.bS = null;
        this.bT = false;
        this.bU = ScaleType.CENTER_CROP;
        this.bV = true;
        this.bW = 1;
        this.mRotationType = RotationType.ROTATE_0;
        this.bP = MirriorType.NO_MIRRIOR;
        this.bX = 0;
        this.bS = surfaceTexture;
        this.mOutputWidth = i;
        this.mOutputHeight = i2;
    }

    public void setOutputSurface(SurfaceHolder surfaceHolder) {
        this.bS = surfaceHolder;
    }

    public DuMixOutput(Surface surface, int i, int i2) {
        this.bS = null;
        this.bT = false;
        this.bU = ScaleType.CENTER_CROP;
        this.bV = true;
        this.bW = 1;
        this.mRotationType = RotationType.ROTATE_0;
        this.bP = MirriorType.NO_MIRRIOR;
        this.bX = 0;
        this.bS = surface;
        this.mOutputWidth = i;
        this.mOutputHeight = i2;
    }

    public DuMixOutput(SurfaceHolder surfaceHolder, int i, int i2) {
        this.bS = null;
        this.bT = false;
        this.bU = ScaleType.CENTER_CROP;
        this.bV = true;
        this.bW = 1;
        this.mRotationType = RotationType.ROTATE_0;
        this.bP = MirriorType.NO_MIRRIOR;
        this.bX = 0;
        this.bS = surfaceHolder;
        this.mOutputWidth = i;
        this.mOutputHeight = i2;
    }

    public DuMixOutput(Texture texture, int i, int i2) {
        this.bS = null;
        this.bT = false;
        this.bU = ScaleType.CENTER_CROP;
        this.bV = true;
        this.bW = 1;
        this.mRotationType = RotationType.ROTATE_0;
        this.bP = MirriorType.NO_MIRRIOR;
        this.bX = 0;
        this.bS = texture;
        this.mOutputWidth = i;
        this.mOutputHeight = i2;
    }
}
