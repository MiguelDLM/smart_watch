package com.baidu.platform.comapi.walknavi.widget;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;
import com.baidu.platform.comapi.wnplatform.p.h;
import java.util.List;

/* loaded from: classes8.dex */
public class ArCameraView extends SurfaceView implements SurfaceHolder.Callback {
    public static final int WALK_AR_PERMISSION = 3001;

    /* renamed from: a, reason: collision with root package name */
    SurfaceHolder f9841a;
    Camera b;
    private Context c;

    public ArCameraView(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        try {
            this.c = context;
            SurfaceHolder holder = getHolder();
            this.f9841a = holder;
            holder.addCallback(this);
            this.f9841a.setType(3);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(com.baidu.platform.comapi.wnplatform.p.b.a.a(), "相机出现错误", 0).show();
        }
    }

    public static int getBackCameraId() {
        try {
            int numberOfCameras = Camera.getNumberOfCameras();
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i = 0; i < numberOfCameras; i++) {
                Camera.getCameraInfo(i, cameraInfo);
                if (cameraInfo.facing == 0) {
                    return i;
                }
            }
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("ARCamera", "GetBackCameraID error!");
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032 A[Catch: Exception -> 0x003c, TryCatch #0 {Exception -> 0x003c, blocks: (B:6:0x0005, B:14:0x002e, B:16:0x0032, B:17:0x0045, B:20:0x003e), top: B:5:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003e A[Catch: Exception -> 0x003c, TryCatch #0 {Exception -> 0x003c, blocks: (B:6:0x0005, B:14:0x002e, B:16:0x0032, B:17:0x0045, B:20:0x003e), top: B:5:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean setCameraDisplayOrientation(android.app.Activity r3, int r4, android.hardware.Camera r5) {
        /*
            r0 = -1
            r1 = 0
            if (r4 != r0) goto L5
            return r1
        L5:
            android.hardware.Camera$CameraInfo r0 = new android.hardware.Camera$CameraInfo     // Catch: java.lang.Exception -> L3c
            r0.<init>()     // Catch: java.lang.Exception -> L3c
            android.hardware.Camera.getCameraInfo(r4, r0)     // Catch: java.lang.Exception -> L3c
            android.view.WindowManager r3 = r3.getWindowManager()     // Catch: java.lang.Exception -> L3c
            android.view.Display r3 = r3.getDefaultDisplay()     // Catch: java.lang.Exception -> L3c
            int r3 = r3.getRotation()     // Catch: java.lang.Exception -> L3c
            r4 = 1
            if (r3 == 0) goto L24
            if (r3 == r4) goto L2c
            r2 = 2
            if (r3 == r2) goto L29
            r2 = 3
            if (r3 == r2) goto L26
        L24:
            r3 = 0
            goto L2e
        L26:
            r3 = 270(0x10e, float:3.78E-43)
            goto L2e
        L29:
            r3 = 180(0xb4, float:2.52E-43)
            goto L2e
        L2c:
            r3 = 90
        L2e:
            int r2 = r0.facing     // Catch: java.lang.Exception -> L3c
            if (r2 != r4) goto L3e
            int r0 = r0.orientation     // Catch: java.lang.Exception -> L3c
            int r0 = r0 + r3
            int r0 = r0 % 360
            int r3 = 360 - r0
            int r3 = r3 % 360
            goto L45
        L3c:
            r3 = move-exception
            goto L4a
        L3e:
            int r0 = r0.orientation     // Catch: java.lang.Exception -> L3c
            int r0 = r0 - r3
            int r0 = r0 + 360
            int r3 = r0 % 360
        L45:
            r5.setDisplayOrientation(r3)     // Catch: java.lang.Exception -> L3c
            r1 = 1
            goto L53
        L4a:
            java.lang.String r4 = "ARCamera"
            java.lang.String r3 = r3.getMessage()
            android.util.Log.d(r4, r3)
        L53:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.walknavi.widget.ArCameraView.setCameraDisplayOrientation(android.app.Activity, int, android.hardware.Camera):boolean");
    }

    public Camera.Size getBestPreSize(int i, int i2, List<Camera.Size> list) {
        for (Camera.Size size : list) {
            if (size.width == i && size.height == i2) {
                return size;
            }
        }
        float f = i / i2;
        float f2 = 0.1f;
        Camera.Size size2 = null;
        for (Camera.Size size3 : list) {
            float abs = Math.abs(f - (size3.width / size3.height));
            if (abs < f2) {
                size2 = size3;
                f2 = abs;
            }
        }
        if (size2 == null) {
            double d = Double.MAX_VALUE;
            for (Camera.Size size4 : list) {
                if (Math.abs(size4.height - i2) < d) {
                    d = Math.abs(size4.height - i2);
                    size2 = size4;
                }
            }
        }
        return size2;
    }

    public void pauseCamera() {
        try {
            Camera camera = this.b;
            if (camera != null) {
                camera.stopPreview();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void releaseCamera() {
        try {
            Camera camera = this.b;
            if (camera != null) {
                try {
                    camera.setPreviewCallback(null);
                    this.b.stopPreview();
                } catch (Exception unused) {
                }
                try {
                    this.b.release();
                } catch (Exception unused2) {
                }
                this.b = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void resumeCamera() {
        try {
            Camera camera = this.b;
            if (camera != null) {
                camera.startPreview();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(com.baidu.platform.comapi.wnplatform.p.b.a.a(), "相机出现错误", 0).show();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (!setCameraDisplayOrientation((Activity) this.c, getBackCameraId(), this.b)) {
            a(90);
        }
        resumeCamera();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Log.e("CameraView", "surfaceCreated");
        try {
            if (this.b == null) {
                this.b = Camera.open();
            }
            Camera.Parameters parameters = this.b.getParameters();
            Camera.Size bestPreSize = getBestPreSize(h.c(this.c), h.b(this.c), parameters.getSupportedPreviewSizes());
            parameters.setPreviewSize(bestPreSize.width, bestPreSize.height);
            Camera camera = this.b;
            if (camera != null) {
                camera.setParameters(parameters);
                this.b.setPreviewDisplay(surfaceHolder);
            }
            resumeCamera();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(com.baidu.platform.comapi.wnplatform.p.b.a.a(), "相机出现错误", 0).show();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Log.e("CameraView", "surfaceDestroyed");
        releaseCamera();
    }

    public ArCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(int i) {
        try {
            Camera camera = this.b;
            if (camera != null) {
                camera.setDisplayOrientation(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
