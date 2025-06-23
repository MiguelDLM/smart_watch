package com.baidu.ar.camera;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.SurfaceHolder;

/* loaded from: classes7.dex */
public class CameraHandlerThread extends HandlerThread {
    private final Handler mHandler;

    public CameraHandlerThread() {
        super("CameraHandlerThread");
        start();
        this.mHandler = new Handler(getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SurfaceTexture surfaceTexture) {
        CameraManager.getInstance().setPreviewSurface(surfaceTexture);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, int i2, int i3) {
        CameraManager.getInstance().switchCamera(i, i2, i3);
    }

    private void cs() {
        if (this.mHandler == null) {
            throw new NullPointerException("Handler is not available!");
        }
    }

    private void ct() {
        try {
            wait();
        } catch (InterruptedException unused) {
            Log.w("CameraHandlerThread", "wait was interrupted");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cu() {
        notify();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cv() {
        notify();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw() {
        CameraManager.getInstance().startPreview();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cx() {
        CameraManager.getInstance().stopPreview();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cy() {
        CameraManager.getInstance().releaseCamera();
    }

    public void addCameraCallbackBuffer(final byte[] bArr) {
        cs();
        this.mHandler.post(new Runnable() { // from class: com.baidu.ar.camera.CameraHandlerThread.3
            @Override // java.lang.Runnable
            public void run() {
                CameraManager.getInstance().addCameraCallbackBuffer(bArr);
            }
        });
    }

    public void destoryThread() {
        this.mHandler.removeCallbacksAndMessages(null);
        quitSafely();
    }

    public int getCameraId() {
        return CameraManager.getInstance().getCameraID();
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public void internalReopenCamera(int i, int i2) {
        CameraManager.getInstance().reopenCamera(i, i2);
    }

    public synchronized void openCamera(final int i, final int i2, final int i3, final int i4) {
        cs();
        this.mHandler.post(new Runnable() { // from class: com.baidu.ar.camera.CameraHandlerThread.1
            @Override // java.lang.Runnable
            public void run() {
                CameraHandlerThread.this.c(i, i2, i3, i4);
                CameraHandlerThread.this.cu();
            }
        });
        ct();
    }

    public synchronized void releaseCamera() {
        cs();
        this.mHandler.post(new Runnable() { // from class: com.baidu.ar.camera.CameraHandlerThread.11
            @Override // java.lang.Runnable
            public void run() {
                CameraHandlerThread.this.cy();
                CameraHandlerThread.this.cv();
            }
        });
        ct();
    }

    public synchronized void reopenCamera(final int i, final int i2) {
        cs();
        this.mHandler.post(new Runnable() { // from class: com.baidu.ar.camera.CameraHandlerThread.4
            @Override // java.lang.Runnable
            public void run() {
                CameraHandlerThread.this.internalReopenCamera(i, i2);
                CameraHandlerThread.this.cu();
            }
        });
        ct();
    }

    public boolean setCameraFlashMode(String str) {
        return CameraManager.getInstance().setCameraFlashMode(str);
    }

    public void setOnCameraError(final Camera.ErrorCallback errorCallback) {
        cs();
        this.mHandler.post(new Runnable() { // from class: com.baidu.ar.camera.CameraHandlerThread.2
            @Override // java.lang.Runnable
            public void run() {
                CameraManager.getInstance().setOnCameraError(errorCallback);
            }
        });
    }

    public void setPreviewCallback(final Camera.PreviewCallback previewCallback) {
        cs();
        this.mHandler.post(new Runnable() { // from class: com.baidu.ar.camera.CameraHandlerThread.7
            @Override // java.lang.Runnable
            public void run() {
                CameraHandlerThread.this.a(previewCallback);
            }
        });
    }

    public void setPreviewSurface(final SurfaceTexture surfaceTexture) {
        cs();
        this.mHandler.post(new Runnable() { // from class: com.baidu.ar.camera.CameraHandlerThread.6
            @Override // java.lang.Runnable
            public void run() {
                CameraHandlerThread.this.a(surfaceTexture);
            }
        });
    }

    public void startPreview() {
        cs();
        this.mHandler.post(new Runnable() { // from class: com.baidu.ar.camera.CameraHandlerThread.8
            @Override // java.lang.Runnable
            public void run() {
                CameraHandlerThread.this.cw();
            }
        });
    }

    public void stopPreview() {
        cs();
        this.mHandler.post(new Runnable() { // from class: com.baidu.ar.camera.CameraHandlerThread.9
            @Override // java.lang.Runnable
            public void run() {
                CameraHandlerThread.this.cx();
            }
        });
    }

    public void switchCamera(final int i, final int i2, final int i3) {
        cs();
        this.mHandler.post(new Runnable() { // from class: com.baidu.ar.camera.CameraHandlerThread.10
            @Override // java.lang.Runnable
            public void run() {
                CameraHandlerThread.this.c(i, i2, i3);
            }
        });
    }

    public CameraHandlerThread(String str) {
        super(str);
        start();
        this.mHandler = new Handler(getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Camera.PreviewCallback previewCallback) {
        CameraManager.getInstance().setPreviewCallback(previewCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, int i2, int i3, int i4) {
        CameraManager.getInstance().openCamera(i, i2, i3, i4);
    }

    public void setPreviewSurface(final SurfaceHolder surfaceHolder) {
        cs();
        this.mHandler.post(new Runnable() { // from class: com.baidu.ar.camera.CameraHandlerThread.5
            @Override // java.lang.Runnable
            public void run() {
                CameraHandlerThread.this.a(surfaceHolder);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SurfaceHolder surfaceHolder) {
        CameraManager.getInstance().setPreviewSurface(surfaceHolder);
    }
}
