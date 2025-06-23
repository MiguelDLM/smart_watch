package com.baidu.navisdk.module.ar.view;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.display.DisplayManager;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.WindowManager;
import com.baidu.ar.camera.CameraManager;
import com.baidu.navisdk.module.ar.listener.a;
import com.facebook.internal.ServerProtocol;
import com.sma.smartv3.ble.ProductManager;
import java.util.List;

/* loaded from: classes7.dex */
public class a implements com.baidu.navisdk.module.ar.listener.a {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.module.ar.d f7018a;
    private SurfaceView b;
    private Camera c;
    private boolean d = false;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int h = 1;
    private long i = 0;
    a.InterfaceC0216a j = null;
    private Camera.PreviewCallback k = new C0220a();
    private SurfaceHolder.Callback l = new b();
    private DisplayManager.DisplayListener m = new c();

    /* renamed from: com.baidu.navisdk.module.ar.view.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0220a implements Camera.PreviewCallback {

        /* renamed from: a, reason: collision with root package name */
        final long f7019a = System.currentTimeMillis();

        public C0220a() {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            a.InterfaceC0216a interfaceC0216a;
            if (a.a(a.this) % a.this.h == 0 && (interfaceC0216a = a.this.j) != null) {
                interfaceC0216a.a(bArr, (System.currentTimeMillis() - this.f7019a) + a.this.i, a.this);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements SurfaceHolder.Callback {
        public b() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            a.this.a(surfaceHolder);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            a.this.e();
        }
    }

    /* loaded from: classes7.dex */
    public class c implements DisplayManager.DisplayListener {
        public c() {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
            int a2 = a.a(a.this.f7018a.a(), a.this.f);
            if (a2 != a.this.e) {
                a.this.e = a2;
                a.this.e();
                a aVar = a.this;
                aVar.a(aVar.b.getHolder());
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i) {
        }
    }

    public a(com.baidu.navisdk.module.ar.d dVar) {
        this.f7018a = dVar;
    }

    @Override // com.baidu.navisdk.module.ar.listener.a
    public void a() {
    }

    @Override // com.baidu.navisdk.module.ar.listener.a
    public void b() {
    }

    private void c() {
        DisplayManager displayManager = (DisplayManager) this.f7018a.a().getSystemService(ServerProtocol.DIALOG_PARAM_DISPLAY);
        if (displayManager != null) {
            displayManager.registerDisplayListener(this.m, null);
        }
    }

    private void d() {
        Camera camera = this.c;
        if (camera != null) {
            camera.setPreviewCallback(null);
            this.c.release();
            this.c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.d) {
            f();
            Camera camera = this.c;
            if (camera != null) {
                camera.stopPreview();
            }
            d();
            this.d = false;
        }
    }

    private void f() {
        DisplayManager displayManager = (DisplayManager) this.f7018a.a().getSystemService(ServerProtocol.DIALOG_PARAM_DISPLAY);
        if (displayManager != null) {
            displayManager.unregisterDisplayListener(this.m);
        }
    }

    @Override // com.baidu.navisdk.module.ar.listener.a
    public void a(Context context, TextureView textureView, a.c cVar) {
    }

    public static /* synthetic */ int a(a aVar) {
        int i = aVar.g;
        aVar.g = i + 1;
        return i;
    }

    @Override // com.baidu.navisdk.module.ar.listener.a
    public void a(Context context, SurfaceView surfaceView, a.c cVar) {
        this.b = surfaceView;
        surfaceView.getHolder().addCallback(this.l);
    }

    public void a(Camera camera) {
        Camera.Size a2 = a(camera.getParameters().getSupportedPreviewSizes(), 1280, CameraManager.DEFAULTHEIGHT);
        Camera.Parameters parameters = camera.getParameters();
        parameters.setPreviewSize(a2.width, a2.height);
        if (parameters.getSupportedFocusModes().contains("fixed")) {
            parameters.setFocusMode("fixed");
        } else if (parameters.getSupportedFocusModes().contains(ProductManager.f20587oxIO0IIo)) {
            parameters.setFocusMode(ProductManager.f20587oxIO0IIo);
        }
        a(camera, parameters);
        camera.setParameters(parameters);
        int a3 = a(this.f7018a.a(), this.f);
        this.e = a3;
        this.c.setDisplayOrientation(a3);
        com.baidu.navisdk.module.ar.d dVar = this.f7018a;
        dVar.c = a2;
        dVar.a(this.e);
    }

    private void a(Camera camera, Camera.Parameters parameters) {
        int i;
        List<int[]> supportedPreviewFpsRange = camera.getParameters().getSupportedPreviewFpsRange();
        for (int[] iArr : supportedPreviewFpsRange) {
            int i2 = iArr[0];
            if (i2 >= 12000 && i2 <= 16000 && (i = iArr[1]) >= 12000 && i <= 16000) {
                parameters.setPreviewFpsRange(supportedPreviewFpsRange.get(0)[0], supportedPreviewFpsRange.get(0)[1]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SurfaceHolder surfaceHolder) {
        if (this.d) {
            return;
        }
        try {
            c();
            if (this.c == null) {
                int a2 = a(false);
                this.f = a2;
                this.c = Camera.open(a2);
            }
            this.c.setPreviewDisplay(surfaceHolder);
            a(this.c);
            this.c.startPreview();
            Camera.PreviewCallback previewCallback = this.k;
            if (previewCallback != null) {
                a(previewCallback);
            }
            this.d = true;
        } catch (Exception unused) {
            this.d = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002b A[LOOP:0: B:11:0x0028->B:13:0x002b, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean a(android.hardware.Camera.PreviewCallback r4) {
        /*
            r3 = this;
            android.hardware.Camera r0 = r3.c
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            r0.setPreviewCallbackWithBuffer(r4)
            android.hardware.Camera r4 = r3.c     // Catch: java.lang.Exception -> L18
            android.hardware.Camera$Parameters r4 = r4.getParameters()     // Catch: java.lang.Exception -> L18
            android.hardware.Camera$Size r4 = r4.getPreviewSize()     // Catch: java.lang.Exception -> L18
            int r0 = r4.width     // Catch: java.lang.Exception -> L18
            int r4 = r4.height     // Catch: java.lang.Exception -> L1a
            goto L1c
        L18:
            r0 = 1280(0x500, float:1.794E-42)
        L1a:
            r4 = 720(0x2d0, float:1.009E-42)
        L1c:
            int r0 = r0 * r4
            r4 = 17
            int r4 = android.graphics.ImageFormat.getBitsPerPixel(r4)
            int r0 = r0 * r4
            int r0 = r0 / 8
        L28:
            r4 = 3
            if (r1 >= r4) goto L35
            android.hardware.Camera r4 = r3.c
            byte[] r2 = new byte[r0]
            r4.addCallbackBuffer(r2)
            int r1 = r1 + 1
            goto L28
        L35:
            r4 = 1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.module.ar.view.a.a(android.hardware.Camera$PreviewCallback):boolean");
    }

    @Override // com.baidu.navisdk.module.ar.listener.a
    public void a(byte[] bArr) {
        Camera camera = this.c;
        if (camera != null) {
            camera.addCallbackBuffer(bArr);
        }
    }

    @Override // com.baidu.navisdk.module.ar.listener.a
    public void a(a.b bVar) {
        try {
            Camera.Parameters parameters = this.c.getParameters();
            Camera.Size previewSize = parameters.getPreviewSize();
            bVar.c = previewSize.width;
            bVar.d = previewSize.height;
            bVar.f6990a = parameters.getPreviewFormat();
            bVar.g = parameters.getHorizontalViewAngle();
            bVar.h = parameters.getVerticalViewAngle();
            bVar.i = parameters.getFocalLength();
        } catch (RuntimeException e) {
            com.baidu.navisdk.module.ar.util.a.a("BNAr", e.getLocalizedMessage());
            bVar.c = 1280;
            bVar.d = CameraManager.DEFAULTHEIGHT;
            bVar.g = 65.5f;
            bVar.h = 51.5f;
        }
        bVar.j = this.e;
    }

    @Override // com.baidu.navisdk.module.ar.listener.a
    public void a(a.InterfaceC0216a interfaceC0216a) {
        this.j = interfaceC0216a;
        if (this.c == null) {
            return;
        }
        a(this.k);
    }

    private int a(boolean z) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.getCameraInfo(i, cameraInfo);
            if (z) {
                if (cameraInfo.facing == 1) {
                    return i;
                }
            } else if (cameraInfo.facing == 0) {
                return i;
            }
        }
        return -1;
    }

    public static int a(Context context, int i) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        return ((cameraInfo.orientation - (rotation != 1 ? rotation != 2 ? rotation != 3 ? 0 : 270 : 180 : 90)) + 360) % 360;
    }

    public static Camera.Size a(List<Camera.Size> list, int i, int i2) {
        double d = i / i2;
        Camera.Size size = null;
        if (list == null) {
            return null;
        }
        double d2 = Double.MAX_VALUE;
        double d3 = Double.MAX_VALUE;
        for (Camera.Size size2 : list) {
            if (Math.abs((size2.width / size2.height) - d) <= 0.1d && Math.abs(size2.height - i2) < d3) {
                d3 = Math.abs(size2.height - i2);
                size = size2;
            }
        }
        if (size == null) {
            for (Camera.Size size3 : list) {
                if (Math.abs(size3.height - i2) < d2) {
                    size = size3;
                    d2 = Math.abs(size3.height - i2);
                }
            }
        }
        return size;
    }
}
