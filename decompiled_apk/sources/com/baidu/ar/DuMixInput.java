package com.baidu.ar;

import android.graphics.SurfaceTexture;
import com.baidu.ar.arrender.Texture;
import com.baidu.ar.bean.MirriorType;
import com.baidu.ar.bean.RotationType;

/* loaded from: classes7.dex */
public class DuMixInput {
    private SurfaceTexture bL;
    private Texture bM;
    private boolean bN;
    private boolean bO;
    private MirriorType bP;
    private boolean bQ;
    private boolean bR;
    private boolean mFrontCamera;
    private int mInputHeight;
    private int mInputWidth;
    private RotationType mRotationType;

    public DuMixInput() {
        this.mInputWidth = 0;
        this.mInputHeight = 0;
        this.bN = true;
        this.mFrontCamera = true;
        this.bO = true;
        this.mRotationType = RotationType.ROTATE_90;
        this.bP = MirriorType.NO_MIRRIOR;
        this.bQ = false;
        this.bR = false;
    }

    public int getInputDegree() {
        return this.mRotationType.getDegree();
    }

    public int getInputHeight() {
        return this.mInputHeight;
    }

    public SurfaceTexture getInputSurface() {
        return this.bL;
    }

    public Texture getInputTexture() {
        return this.bM;
    }

    public int getInputWidth() {
        return this.mInputWidth;
    }

    public MirriorType getMirriorType() {
        return this.bP;
    }

    public RotationType getRotationType() {
        return this.mRotationType;
    }

    public boolean isCameraInput() {
        return this.bN;
    }

    public boolean isFitCameraAuto() {
        return this.bO;
    }

    public boolean isFrontCamera() {
        return this.mFrontCamera;
    }

    public boolean isSingleFrame() {
        return this.bR;
    }

    public boolean isSyncInputContent() {
        return this.bQ;
    }

    public void setCameraInput(boolean z) {
        this.bN = z;
    }

    public void setFitCameraAuto(boolean z) {
        this.bO = z;
    }

    public void setFrontCamera(boolean z) {
        this.mFrontCamera = z;
    }

    public void setInputDegree(int i) {
        RotationType rotationType;
        if (i == 0) {
            rotationType = RotationType.ROTATE_0;
        } else if (i == 90) {
            rotationType = RotationType.ROTATE_90;
        } else if (i == 180) {
            rotationType = RotationType.ROTATE_180;
        } else if (i != 270) {
            return;
        } else {
            rotationType = RotationType.ROTATE_270;
        }
        this.mRotationType = rotationType;
    }

    public void setInputHeight(int i) {
        this.mInputHeight = i;
    }

    public void setInputSurface(SurfaceTexture surfaceTexture) {
        this.bL = surfaceTexture;
    }

    public void setInputTexture(Texture texture) {
        this.bM = texture;
    }

    public void setInputWidth(int i) {
        this.mInputWidth = i;
    }

    public void setMirriorType(MirriorType mirriorType) {
        this.bP = mirriorType;
    }

    public void setRotationType(RotationType rotationType) {
        this.mRotationType = rotationType;
    }

    public void setSingleFrame(boolean z) {
        this.bR = z;
        if (z) {
            this.bQ = true;
            this.bN = false;
            this.mFrontCamera = false;
        }
    }

    public void setSyncInputContent(boolean z) {
        this.bQ = z;
    }

    public DuMixInput(int i, int i2) {
        this.mInputWidth = 0;
        this.mInputHeight = 0;
        this.bN = true;
        this.mFrontCamera = true;
        this.bO = true;
        this.mRotationType = RotationType.ROTATE_90;
        this.bP = MirriorType.NO_MIRRIOR;
        this.bQ = false;
        this.bR = false;
        this.mInputWidth = i;
        this.mInputHeight = i2;
    }

    public DuMixInput(SurfaceTexture surfaceTexture, int i, int i2) {
        this.mInputWidth = 0;
        this.mInputHeight = 0;
        this.bN = true;
        this.mFrontCamera = true;
        this.bO = true;
        this.mRotationType = RotationType.ROTATE_90;
        this.bP = MirriorType.NO_MIRRIOR;
        this.bQ = false;
        this.bR = false;
        this.bL = surfaceTexture;
        this.mInputWidth = i;
        this.mInputHeight = i2;
    }

    public DuMixInput(Texture texture, int i, int i2) {
        this.mInputWidth = 0;
        this.mInputHeight = 0;
        this.bN = true;
        this.mFrontCamera = true;
        this.bO = true;
        this.mRotationType = RotationType.ROTATE_90;
        this.bP = MirriorType.NO_MIRRIOR;
        this.bQ = false;
        this.bR = false;
        this.bM = texture;
        this.mInputWidth = i;
        this.mInputHeight = i2;
    }
}
