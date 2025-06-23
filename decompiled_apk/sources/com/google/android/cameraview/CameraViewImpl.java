package com.google.android.cameraview;

import android.view.View;
import java.util.Set;

/* loaded from: classes9.dex */
abstract class CameraViewImpl {
    protected final Callback mCallback;
    protected final PreviewImpl mPreview;

    /* loaded from: classes9.dex */
    public interface Callback {
        void onCameraClosed();

        void onCameraOpened();

        void onPictureTaken(byte[] bArr);
    }

    public CameraViewImpl(Callback callback, PreviewImpl previewImpl) {
        this.mCallback = callback;
        this.mPreview = previewImpl;
    }

    public abstract AspectRatio getAspectRatio();

    public abstract boolean getAutoFocus();

    public abstract int getFacing();

    public abstract int getFlash();

    public abstract Set<AspectRatio> getSupportedAspectRatios();

    public View getView() {
        return this.mPreview.getView();
    }

    public abstract boolean isCameraOpened();

    public abstract boolean setAspectRatio(AspectRatio aspectRatio);

    public abstract void setAutoFocus(boolean z);

    public abstract void setDisplayOrientation(int i);

    public abstract void setFacing(int i);

    public abstract void setFlash(int i);

    public abstract boolean start();

    public abstract void stop();

    public abstract void takePicture();
}
