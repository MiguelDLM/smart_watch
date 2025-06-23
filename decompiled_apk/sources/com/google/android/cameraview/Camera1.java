package com.google.android.cameraview;

import android.annotation.SuppressLint;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import androidx.collection.SparseArrayCompat;
import com.google.android.cameraview.CameraViewImpl;
import com.google.android.cameraview.PreviewImpl;
import com.sma.smartv3.ble.ProductManager;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.XOxIOxOx;

/* loaded from: classes9.dex */
class Camera1 extends CameraViewImpl {
    private static final SparseArrayCompat<String> FLASH_MODES;
    private static final int INVALID_CAMERA_ID = -1;
    private final AtomicBoolean isPictureCaptureInProgress;
    private AspectRatio mAspectRatio;
    private boolean mAutoFocus;
    Camera mCamera;
    private int mCameraId;
    private final Camera.CameraInfo mCameraInfo;
    private Camera.Parameters mCameraParameters;
    private int mDisplayOrientation;
    private int mFacing;
    private int mFlash;
    private final SizeMap mPictureSizes;
    private final SizeMap mPreviewSizes;
    private boolean mShowingPreview;

    static {
        SparseArrayCompat<String> sparseArrayCompat = new SparseArrayCompat<>();
        FLASH_MODES = sparseArrayCompat;
        sparseArrayCompat.put(0, XOxIOxOx.f29771X0o0xo);
        sparseArrayCompat.put(1, XOxIOxOx.f29774oxoX);
        sparseArrayCompat.put(2, "torch");
        sparseArrayCompat.put(3, "auto");
        sparseArrayCompat.put(4, "red-eye");
    }

    public Camera1(CameraViewImpl.Callback callback, PreviewImpl previewImpl) {
        super(callback, previewImpl);
        this.isPictureCaptureInProgress = new AtomicBoolean(false);
        this.mCameraInfo = new Camera.CameraInfo();
        this.mPreviewSizes = new SizeMap();
        this.mPictureSizes = new SizeMap();
        previewImpl.setCallback(new PreviewImpl.Callback() { // from class: com.google.android.cameraview.Camera1.1
            @Override // com.google.android.cameraview.PreviewImpl.Callback
            public void onSurfaceChanged() {
                Camera1 camera1 = Camera1.this;
                if (camera1.mCamera != null) {
                    camera1.setUpPreview();
                    Camera1.this.adjustCameraParameters();
                }
            }
        });
    }

    private int calcCameraRotation(int i) {
        int i2;
        Camera.CameraInfo cameraInfo = this.mCameraInfo;
        if (cameraInfo.facing == 1) {
            return (cameraInfo.orientation + i) % 360;
        }
        if (isLandscape(i)) {
            i2 = 180;
        } else {
            i2 = 0;
        }
        return ((this.mCameraInfo.orientation + i) + i2) % 360;
    }

    private int calcDisplayOrientation(int i) {
        Camera.CameraInfo cameraInfo = this.mCameraInfo;
        if (cameraInfo.facing == 1) {
            return (360 - ((cameraInfo.orientation + i) % 360)) % 360;
        }
        return ((cameraInfo.orientation - i) + 360) % 360;
    }

    private AspectRatio chooseAspectRatio() {
        Iterator<AspectRatio> it = this.mPreviewSizes.ratios().iterator();
        AspectRatio aspectRatio = null;
        while (it.hasNext()) {
            aspectRatio = it.next();
            if (aspectRatio.equals(Constants.DEFAULT_ASPECT_RATIO)) {
                break;
            }
        }
        return aspectRatio;
    }

    private void chooseCamera() {
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.getCameraInfo(i, this.mCameraInfo);
            if (this.mCameraInfo.facing == this.mFacing) {
                this.mCameraId = i;
                return;
            }
        }
        this.mCameraId = -1;
    }

    private Size chooseOptimalSize(SortedSet<Size> sortedSet) {
        if (!this.mPreview.isReady()) {
            return sortedSet.first();
        }
        int width = this.mPreview.getWidth();
        int height = this.mPreview.getHeight();
        if (isLandscape(this.mDisplayOrientation)) {
            height = width;
            width = height;
        }
        Iterator<Size> it = sortedSet.iterator();
        Size size = null;
        while (it.hasNext()) {
            size = it.next();
            if (width <= size.getWidth() && height <= size.getHeight()) {
                break;
            }
        }
        return size;
    }

    private boolean isLandscape(int i) {
        return i == 90 || i == 270;
    }

    private void openCamera() {
        if (this.mCamera != null) {
            releaseCamera();
        }
        Camera open = Camera.open(this.mCameraId);
        this.mCamera = open;
        this.mCameraParameters = open.getParameters();
        this.mPreviewSizes.clear();
        for (Camera.Size size : this.mCameraParameters.getSupportedPreviewSizes()) {
            this.mPreviewSizes.add(new Size(size.width, size.height));
        }
        this.mPictureSizes.clear();
        for (Camera.Size size2 : this.mCameraParameters.getSupportedPictureSizes()) {
            this.mPictureSizes.add(new Size(size2.width, size2.height));
        }
        if (this.mAspectRatio == null) {
            this.mAspectRatio = Constants.DEFAULT_ASPECT_RATIO;
        }
        adjustCameraParameters();
        this.mCamera.setDisplayOrientation(calcDisplayOrientation(this.mDisplayOrientation));
        this.mCallback.onCameraOpened();
    }

    private void releaseCamera() {
        Camera camera = this.mCamera;
        if (camera != null) {
            camera.release();
            this.mCamera = null;
            this.mCallback.onCameraClosed();
        }
    }

    private boolean setAutoFocusInternal(boolean z) {
        this.mAutoFocus = z;
        if (!isCameraOpened()) {
            return false;
        }
        List<String> supportedFocusModes = this.mCameraParameters.getSupportedFocusModes();
        if (z && supportedFocusModes.contains("continuous-picture")) {
            this.mCameraParameters.setFocusMode("continuous-picture");
            return true;
        }
        if (supportedFocusModes.contains("fixed")) {
            this.mCameraParameters.setFocusMode("fixed");
            return true;
        }
        if (supportedFocusModes.contains(ProductManager.f20587oxIO0IIo)) {
            this.mCameraParameters.setFocusMode(ProductManager.f20587oxIO0IIo);
            return true;
        }
        this.mCameraParameters.setFocusMode(supportedFocusModes.get(0));
        return true;
    }

    private boolean setFlashInternal(int i) {
        if (isCameraOpened()) {
            List<String> supportedFlashModes = this.mCameraParameters.getSupportedFlashModes();
            SparseArrayCompat<String> sparseArrayCompat = FLASH_MODES;
            String str = sparseArrayCompat.get(i);
            if (supportedFlashModes != null && supportedFlashModes.contains(str)) {
                this.mCameraParameters.setFlashMode(str);
                this.mFlash = i;
                return true;
            }
            String str2 = sparseArrayCompat.get(this.mFlash);
            if (supportedFlashModes != null && supportedFlashModes.contains(str2)) {
                return false;
            }
            this.mCameraParameters.setFlashMode(XOxIOxOx.f29771X0o0xo);
            this.mFlash = 0;
            return true;
        }
        this.mFlash = i;
        return false;
    }

    public void adjustCameraParameters() {
        SortedSet<Size> sizes = this.mPreviewSizes.sizes(this.mAspectRatio);
        if (sizes == null) {
            AspectRatio chooseAspectRatio = chooseAspectRatio();
            this.mAspectRatio = chooseAspectRatio;
            sizes = this.mPreviewSizes.sizes(chooseAspectRatio);
        }
        Size chooseOptimalSize = chooseOptimalSize(sizes);
        Size last = this.mPictureSizes.sizes(this.mAspectRatio).last();
        if (this.mShowingPreview) {
            this.mCamera.stopPreview();
        }
        this.mCameraParameters.setPreviewSize(chooseOptimalSize.getWidth(), chooseOptimalSize.getHeight());
        this.mCameraParameters.setPictureSize(last.getWidth(), last.getHeight());
        this.mCameraParameters.setRotation(calcCameraRotation(this.mDisplayOrientation));
        setAutoFocusInternal(this.mAutoFocus);
        setFlashInternal(this.mFlash);
        this.mCamera.setParameters(this.mCameraParameters);
        if (this.mShowingPreview) {
            this.mCamera.startPreview();
        }
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    public AspectRatio getAspectRatio() {
        return this.mAspectRatio;
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    public boolean getAutoFocus() {
        if (!isCameraOpened()) {
            return this.mAutoFocus;
        }
        String focusMode = this.mCameraParameters.getFocusMode();
        if (focusMode != null && focusMode.contains("continuous")) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    public int getFacing() {
        return this.mFacing;
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    public int getFlash() {
        return this.mFlash;
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    public Set<AspectRatio> getSupportedAspectRatios() {
        SizeMap sizeMap = this.mPreviewSizes;
        for (AspectRatio aspectRatio : sizeMap.ratios()) {
            if (this.mPictureSizes.sizes(aspectRatio) == null) {
                sizeMap.remove(aspectRatio);
            }
        }
        return sizeMap.ratios();
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    public boolean isCameraOpened() {
        if (this.mCamera != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    public boolean setAspectRatio(AspectRatio aspectRatio) {
        if (this.mAspectRatio != null && isCameraOpened()) {
            if (!this.mAspectRatio.equals(aspectRatio)) {
                if (this.mPreviewSizes.sizes(aspectRatio) != null) {
                    this.mAspectRatio = aspectRatio;
                    adjustCameraParameters();
                    return true;
                }
                throw new UnsupportedOperationException(aspectRatio + " is not supported");
            }
            return false;
        }
        this.mAspectRatio = aspectRatio;
        return true;
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    public void setAutoFocus(boolean z) {
        if (this.mAutoFocus != z && setAutoFocusInternal(z)) {
            this.mCamera.setParameters(this.mCameraParameters);
        }
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    public void setDisplayOrientation(int i) {
        if (this.mDisplayOrientation == i) {
            return;
        }
        this.mDisplayOrientation = i;
        if (isCameraOpened()) {
            this.mCameraParameters.setRotation(calcCameraRotation(i));
            this.mCamera.setParameters(this.mCameraParameters);
            this.mCamera.setDisplayOrientation(calcDisplayOrientation(i));
        }
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    public void setFacing(int i) {
        if (this.mFacing == i) {
            return;
        }
        this.mFacing = i;
        if (isCameraOpened()) {
            stop();
            start();
        }
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    public void setFlash(int i) {
        if (i != this.mFlash && setFlashInternal(i)) {
            this.mCamera.setParameters(this.mCameraParameters);
        }
    }

    @SuppressLint({"NewApi"})
    public void setUpPreview() {
        try {
            if (this.mPreview.getOutputClass() == SurfaceHolder.class) {
                this.mCamera.setPreviewDisplay(this.mPreview.getSurfaceHolder());
            } else {
                this.mCamera.setPreviewTexture((SurfaceTexture) this.mPreview.getSurfaceTexture());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    public boolean start() {
        chooseCamera();
        openCamera();
        if (this.mPreview.isReady()) {
            setUpPreview();
        }
        this.mShowingPreview = true;
        this.mCamera.startPreview();
        return true;
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    public void stop() {
        Camera camera = this.mCamera;
        if (camera != null) {
            camera.stopPreview();
        }
        this.mShowingPreview = false;
        releaseCamera();
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    public void takePicture() {
        if (isCameraOpened()) {
            if (getAutoFocus()) {
                this.mCamera.cancelAutoFocus();
                this.mCamera.autoFocus(new Camera.AutoFocusCallback() { // from class: com.google.android.cameraview.Camera1.2
                    @Override // android.hardware.Camera.AutoFocusCallback
                    public void onAutoFocus(boolean z, Camera camera) {
                        Camera1.this.takePictureInternal();
                    }
                });
                return;
            } else {
                takePictureInternal();
                return;
            }
        }
        throw new IllegalStateException("Camera is not ready. Call start() before takePicture().");
    }

    public void takePictureInternal() {
        if (!this.isPictureCaptureInProgress.getAndSet(true)) {
            this.mCamera.takePicture(null, null, null, new Camera.PictureCallback() { // from class: com.google.android.cameraview.Camera1.3
                @Override // android.hardware.Camera.PictureCallback
                public void onPictureTaken(byte[] bArr, Camera camera) {
                    Camera1.this.isPictureCaptureInProgress.set(false);
                    Camera1.this.mCallback.onPictureTaken(bArr);
                    camera.cancelAutoFocus();
                    camera.startPreview();
                }
            });
        }
    }
}
