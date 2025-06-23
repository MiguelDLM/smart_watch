package com.baidu.ar.camera;

import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import android.view.SurfaceHolder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes7.dex */
public final class CameraManager {
    public static final int DEFAULTHEIGHT = 720;
    public static final int DEFAULTWIDTH = 1280;
    public static final int DESIREDPREVIEWFPS = 30;
    public static final float Ratio11 = 1.0f;
    public static final float Ratio169 = 0.5625f;
    public static final float Ratio43 = 0.75f;
    private static CameraManager mK;
    private Camera mM;
    private int mL = 1;
    private int mN = 0;
    private float mO = 0.5625f;

    /* loaded from: classes7.dex */
    public class a implements Comparator<Camera.Size> {
        private a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Camera.Size size, Camera.Size size2) {
            return Long.signum((size.width * size.height) - (size2.width * size2.height));
        }
    }

    private CameraManager() {
    }

    private Camera.Size a(List<Camera.Size> list, int i, int i2) {
        int i3;
        Object max;
        e(list);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Camera.Size size : list) {
            int i4 = size.height;
            int i5 = (i4 * i) / i2;
            int i6 = size.width;
            if (i5 == i6) {
                if (i6 < i || i4 < i2) {
                    arrayList2.add(size);
                } else {
                    arrayList.add(size);
                }
            }
        }
        if (arrayList.size() > 0) {
            max = Collections.min(arrayList, new a());
        } else {
            if (arrayList2.size() <= 0) {
                boolean z = false;
                Camera.Size size2 = list.get(0);
                for (Camera.Size size3 : list) {
                    int i7 = size3.width;
                    if (i7 != i || (i3 = size3.height) != i2 || i3 / i7 != this.mO) {
                        if (i7 == i) {
                            if (Math.abs(size2.height - i2) > Math.abs(size3.height - i2) && size3.height / size3.width == this.mO) {
                            }
                            z = true;
                        } else if (size3.height == i2) {
                            if (Math.abs(size2.width - i) > Math.abs(size3.width - i) && size3.height / size3.width == this.mO) {
                            }
                            z = true;
                        } else if (!z && Math.abs(size2.width - i) > Math.abs(size3.width - i) && Math.abs(size2.height - i2) > Math.abs(size3.height - i2) && size3.height / size3.width == this.mO) {
                            size2 = size3;
                        }
                    }
                    return size3;
                }
                return size2;
            }
            max = Collections.max(arrayList2, new a());
        }
        return (Camera.Size) max;
    }

    private void e(List<Camera.Size> list) {
        Collections.sort(list, new a());
    }

    public static CameraManager getInstance() {
        if (mK == null) {
            mK = new CameraManager();
        }
        return mK;
    }

    private boolean p(int i) {
        for (int i2 = 0; i2 < 3; i2++) {
            try {
                this.mM = Camera.open(i);
                return true;
            } catch (Exception unused) {
                Log.e("CameraManager", "camera open error!");
                try {
                    Camera camera = this.mM;
                    if (camera != null) {
                        camera.release();
                        this.mM = null;
                    }
                    Thread.sleep(150L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    private int q(int i) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(this.mL, cameraInfo);
        int i2 = 0;
        if (i != 0) {
            if (i == 1) {
                i2 = 90;
            } else if (i == 2) {
                i2 = 180;
            } else if (i == 3) {
                i2 = 270;
            }
        }
        return (cameraInfo.facing == 1 ? 360 - ((cameraInfo.orientation + i2) % 360) : (cameraInfo.orientation - i2) + 360) % 360;
    }

    public void addCameraCallbackBuffer(byte[] bArr) {
        Camera camera = this.mM;
        if (camera != null) {
            camera.addCallbackBuffer(bArr);
        }
    }

    public boolean chooseFixedPreviewFps(int i) {
        try {
            Camera camera = this.mM;
            if (camera != null) {
                Camera.Parameters parameters = camera.getParameters();
                int[] iArr = new int[2];
                for (int[] iArr2 : parameters.getSupportedPreviewFpsRange()) {
                    Log.d("CameraManager", "entry: " + iArr2[0] + " - " + iArr2[1]);
                    int i2 = iArr2[0];
                    int i3 = iArr2[1];
                    if (i2 == i3 && i2 == i) {
                        parameters.setPreviewFpsRange(i2, i3);
                        return true;
                    }
                    if (i2 >= iArr[0] && i3 >= iArr[1]) {
                        iArr[0] = i2;
                        iArr[1] = i3;
                    }
                }
                Log.d("CameraManager", "setting fps: " + iArr[0] + " - " + iArr[1]);
                parameters.setPreviewFpsRange(iArr[0], iArr[1]);
                this.mM.setParameters(parameters);
            }
            return false;
        } catch (Exception e) {
            Log.e("chooseFixedPreviewFps ", e.getLocalizedMessage());
            return false;
        }
    }

    public int getCameraID() {
        return this.mL;
    }

    public Camera.CameraInfo getCameraInfo() {
        if (this.mM == null) {
            return null;
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(this.mL, cameraInfo);
        return cameraInfo;
    }

    public float getCurrentRatio() {
        return this.mO;
    }

    public int getPreviewOrientation() {
        return this.mN;
    }

    public void openCamera(int i) {
        openCamera(i, 1280, DEFAULTHEIGHT, this.mN);
    }

    public void releaseCamera() {
        Camera camera = this.mM;
        if (camera != null) {
            camera.stopPreview();
            this.mM.setPreviewCallback(null);
            this.mM.release();
            this.mM = null;
        }
    }

    public void reopenCamera() {
        releaseCamera();
        openCamera(this.mL);
    }

    public boolean setCameraFlashMode(String str) {
        try {
            Camera camera = this.mM;
            if (camera == null) {
                return false;
            }
            Camera.Parameters parameters = camera.getParameters();
            parameters.setFlashMode(str);
            this.mM.setParameters(parameters);
            return true;
        } catch (Exception e) {
            Log.e("setCameraFlashMode ", e.getLocalizedMessage());
            return false;
        }
    }

    public void setOnCameraError(Camera.ErrorCallback errorCallback) {
        Camera camera = this.mM;
        if (camera != null) {
            camera.setErrorCallback(errorCallback);
        }
    }

    public void setPreviewCallback(Camera.PreviewCallback previewCallback) {
        Camera camera = this.mM;
        if (camera != null) {
            camera.setPreviewCallback(previewCallback);
        }
    }

    public void setPreviewSurface(SurfaceTexture surfaceTexture) {
        Camera camera = this.mM;
        if (camera != null) {
            try {
                camera.setPreviewTexture(surfaceTexture);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void startPreview() {
        Camera.Size size;
        Camera camera = this.mM;
        if (camera != null) {
            try {
                size = camera.getParameters().getPreviewSize();
            } catch (Exception e) {
                e.printStackTrace();
                size = null;
            }
            if (size != null) {
                int bitsPerPixel = ((size.width * size.height) * ImageFormat.getBitsPerPixel(17)) / 8;
                for (int i = 0; i < 3; i++) {
                    this.mM.addCallbackBuffer(new byte[bitsPerPixel]);
                }
            }
            try {
                this.mM.startPreview();
            } catch (Exception unused) {
                Log.e("startPreview camera", "Exception");
            }
        }
    }

    public void stopPreview() {
        Camera camera = this.mM;
        if (camera != null) {
            camera.stopPreview();
        }
    }

    public void switchCamera(int i, int i2, int i3) {
        if (this.mL == i) {
            return;
        }
        this.mL = i;
        releaseCamera();
        openCamera(i, i2, i3, this.mN);
    }

    public void takePicture(Camera.ShutterCallback shutterCallback, Camera.PictureCallback pictureCallback, Camera.PictureCallback pictureCallback2) {
        Camera camera = this.mM;
        if (camera != null) {
            camera.takePicture(shutterCallback, pictureCallback, pictureCallback2);
        }
    }

    private void a(Camera camera, int i, int i2) {
        Camera.Parameters parameters = camera.getParameters();
        Camera.Size a2 = a(parameters.getSupportedPreviewSizes(), i, i2);
        parameters.setPreviewSize(a2.width, a2.height);
        camera.setParameters(parameters);
        Log.d("setPreviewSize", "width = " + a2.width + ", height = " + a2.height);
    }

    public void openCamera(int i, int i2, int i3, int i4) {
        String str;
        Camera camera;
        List<String> supportedAntibanding;
        this.mL = i;
        if (this.mM != null) {
            str = "camera already initialized!";
        } else {
            if (p(i) && (camera = this.mM) != null) {
                try {
                    this.mN = i4;
                    Camera.Parameters parameters = camera.getParameters();
                    if (parameters.getSupportedFocusModes().contains("continuous-video")) {
                        parameters.setFocusMode("continuous-video");
                    }
                    if (i == 0 || !Build.BRAND.contains("Xiaomi")) {
                        parameters.setRecordingHint(true);
                    }
                    if (Build.MODEL.contains("Lenovo K520") && (supportedAntibanding = parameters.getSupportedAntibanding()) != null && supportedAntibanding.contains("50hz")) {
                        parameters.setAntibanding("50hz");
                    }
                    this.mM.setParameters(parameters);
                    try {
                        a(this.mM, i2, i3);
                    } catch (Exception unused) {
                        Log.e("CameraManager", "setPreviewSize Error");
                    }
                    chooseFixedPreviewFps(30000);
                    this.mM.setDisplayOrientation(q(i4));
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            str = "Unable to open camera!";
        }
        Log.e("CameraManager", str);
    }

    public void reopenCamera(int i, int i2) {
        releaseCamera();
        openCamera(this.mL, i, i2, this.mN);
    }

    public void setPreviewSurface(SurfaceHolder surfaceHolder) {
        Camera camera = this.mM;
        if (camera != null) {
            try {
                camera.setPreviewDisplay(surfaceHolder);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
