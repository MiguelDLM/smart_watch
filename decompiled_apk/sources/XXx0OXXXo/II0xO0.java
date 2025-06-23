package XXx0OXXXo;

import IOOXOOOOo.II0xO0;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import java.util.Collections;
import me.devilsen.czxing.view.AutoFitSurfaceView;
import oI00o.X0o0xo;

/* loaded from: classes6.dex */
public class II0xO0 extends IOOXOOOOo.II0xO0 implements Camera.PreviewCallback {

    /* renamed from: xI, reason: collision with root package name */
    public static final int f4129xI = -1;

    /* renamed from: IIX0o, reason: collision with root package name */
    public Rect f4130IIX0o;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public Camera f4131O0xOxO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public Camera.Parameters f4132X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public int f4133XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public XXx0OXXXo.oIX0oI f4134XIxXXX0x0;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public boolean f4135XxX0x0xxx;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public final SurfaceHolder.Callback f4136ooXIXxIX;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public float f4137xXxxox0I;

    /* renamed from: xxX, reason: collision with root package name */
    public boolean f4138xxX;

    /* renamed from: XXx0OXXXo.II0xO0$II0xO0, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0067II0xO0 implements Camera.AutoFocusCallback {
        public C0067II0xO0() {
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            if (z) {
                oI00o.II0xO0.oIX0oI("对焦测光成功");
            } else {
                oI00o.II0xO0.I0Io("对焦测光失败");
            }
            II0xO0.this.oo();
        }
    }

    /* loaded from: classes6.dex */
    public class oIX0oI implements SurfaceHolder.Callback {
        public oIX0oI() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            if (surfaceHolder.getSurface() == null) {
                return;
            }
            II0xO0.this.IoOoX();
            II0xO0.this.oo0xXOI0I();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
            II0xO0.this.ooXIXxIX();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
            II0xO0.this.IoOoX();
        }
    }

    public II0xO0(Context context, AutoFitSurfaceView autoFitSurfaceView) {
        super(context, autoFitSurfaceView);
        this.f4133XI0IXoo = 0;
        this.f4138xxX = true;
        this.f4136ooXIXxIX = new oIX0oI();
    }

    private void IIX0o(Camera camera) {
        if (camera == null) {
            return;
        }
        this.f4131O0xOxO = camera;
        XXx0OXXXo.oIX0oI oix0oi = new XXx0OXXXo.oIX0oI(this.f546XO);
        this.f4134XIxXXX0x0 = oix0oi;
        oix0oi.xxIXOIIO(this.f4131O0xOxO);
        if (this.f4138xxX) {
            this.f543Oo.requestLayout();
        } else {
            oo0xXOI0I();
        }
        this.f543Oo.getHolder().addCallback(this.f4136ooXIXxIX);
    }

    private void XIxXXX0x0(float f, float f2, int i, int i2) {
        boolean z;
        try {
            Camera.Parameters parameters = this.f4131O0xOxO.getParameters();
            Camera.Size previewSize = parameters.getPreviewSize();
            boolean z2 = true;
            if (parameters.getMaxNumFocusAreas() > 0) {
                oI00o.II0xO0.oIX0oI("支持设置对焦区域");
                Rect II0xO02 = X0o0xo.II0xO0(1.0f, f, f2, i, i2, previewSize.width, previewSize.height);
                X0o0xo.Oxx0IOOO("对焦区域", II0xO02);
                parameters.setFocusAreas(Collections.singletonList(new Camera.Area(II0xO02, 1000)));
                parameters.setFocusMode("macro");
                z = true;
            } else {
                oI00o.II0xO0.oIX0oI("不支持设置对焦区域");
                z = false;
            }
            if (parameters.getMaxNumMeteringAreas() > 0) {
                oI00o.II0xO0.oIX0oI("支持设置测光区域");
                Rect II0xO03 = X0o0xo.II0xO0(1.5f, f, f2, i, i2, previewSize.width, previewSize.height);
                X0o0xo.Oxx0IOOO("测光区域", II0xO03);
                parameters.setMeteringAreas(Collections.singletonList(new Camera.Area(II0xO03, 1000)));
            } else {
                oI00o.II0xO0.oIX0oI("不支持设置测光区域");
                z2 = z;
            }
            if (z2) {
                this.f4131O0xOxO.cancelAutoFocus();
                this.f4131O0xOxO.setParameters(parameters);
                this.f4131O0xOxO.autoFocus(new C0067II0xO0());
                return;
            }
            this.f4135XxX0x0xxx = false;
        } catch (Exception e) {
            e.printStackTrace();
            oI00o.II0xO0.I0Io("对焦测光失败：" + e.getMessage());
            oo();
        }
    }

    @Override // IOOXOOOOo.II0xO0
    public float II0XooXoX() {
        return O0xOxO().getMaxZoom();
    }

    @Override // me.devilsen.czxing.view.AutoFitSurfaceView.oIX0oI
    public void II0xO0(float f) {
        boolean z;
        if (f > 0.0f) {
            z = true;
        } else {
            z = false;
        }
        xxX(z, 1);
    }

    @Override // IOOXOOOOo.II0xO0
    public void IXxxXO() {
        if (OxI()) {
            this.f541IIXOooo = true;
            this.f4134XIxXXX0x0.xoIox(this.f4131O0xOxO);
        }
    }

    public void IoOoX() {
        if (this.f4131O0xOxO == null) {
            return;
        }
        try {
            this.f4138xxX = false;
            if (this.f543Oo.getHolder() != null) {
                this.f543Oo.getHolder().removeCallback(this.f4136ooXIXxIX);
            }
            XO();
            this.f4131O0xOxO.cancelAutoFocus();
            this.f4131O0xOxO.stopPreview();
            this.f4131O0xOxO.setPreviewCallback(null);
        } catch (Exception unused) {
        }
    }

    public final Camera.Parameters O0xOxO() {
        if (this.f4132X0IIOO == null) {
            this.f4132X0IIOO = this.f4131O0xOxO.getParameters();
        }
        return this.f4132X0IIOO;
    }

    @Override // IOOXOOOOo.II0xO0
    public void Oo() {
        XxX0x0xxx();
        if (this.f4131O0xOxO == null) {
            return;
        }
        this.f4138xxX = true;
        oo0xXOI0I();
        this.f542IXxxXO.I0Io();
    }

    public final boolean OxI() {
        if (oOoXoXO() && this.f546XO.getPackageManager().hasSystemFeature("android.hardware.camera.flash")) {
            return true;
        }
        return false;
    }

    @Override // IOOXOOOOo.II0xO0
    public void Oxx0IOOO(float f, float f2) {
        oI00o.II0xO0.oIX0oI("Focus x = " + f + " y = " + f2);
        XI0IXoo(f, f2);
    }

    @Override // IOOXOOOOo.II0xO0
    public float OxxIIOOXO(float f) {
        float II0XooXoX2;
        if (!ooOOo0oXI() || f < 0.0f) {
            return 0.0f;
        }
        try {
            II0XooXoX2 = II0XooXoX();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (f > II0XooXoX2) {
            return II0XooXoX2;
        }
        Camera.Parameters O0xOxO2 = O0xOxO();
        if (f < this.f4137xXxxox0I) {
            oI00o.II0xO0.oIX0oI("缩小");
            this.f545OxxIIOOXO = true;
        }
        this.f4137xXxxox0I = f;
        O0xOxO2.setZoom((int) f);
        this.f4131O0xOxO.setParameters(O0xOxO2);
        return f;
    }

    public Rect X0IIOO() {
        if (this.f4130IIX0o == null) {
            Camera.Size previewSize = this.f4131O0xOxO.getParameters().getPreviewSize();
            this.f4130IIX0o = new Rect(0, 0, previewSize.width, previewSize.height);
        }
        return this.f4130IIX0o;
    }

    @Override // IOOXOOOOo.II0xO0
    public void X0o0xo(byte[] bArr) {
        this.f4131O0xOxO.addCallbackBuffer(bArr);
    }

    public final void XI0IXoo(float f, float f2) {
        if (this.f4135XxX0x0xxx) {
            return;
        }
        this.f4135XxX0x0xxx = true;
        if (X0o0xo.XO(this.f546XO)) {
            f2 = f;
            f = f2;
        }
        int oxoX2 = X0o0xo.oxoX(this.f546XO, 40.0f);
        XIxXXX0x0(f, f2, oxoX2, oxoX2);
    }

    @Override // IOOXOOOOo.II0xO0
    public void XO() {
        if (OxI()) {
            this.f541IIXOooo = false;
            this.f4134XIxXXX0x0.II0xO0(this.f4131O0xOxO);
        }
    }

    public void XxX0x0xxx() {
        int i = this.f4133XI0IXoo;
        if (this.f4131O0xOxO == null && Camera.getNumberOfCameras() != 0) {
            int o002 = o00(i);
            if (o002 != -1) {
                xI(o002);
                return;
            }
            if (i == 0) {
                o002 = o00(1);
            } else if (i == 1) {
                o002 = o00(0);
            }
            if (o002 != -1) {
                xI(o002);
            }
        }
    }

    public final int o00(int i) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
            try {
                Camera.getCameraInfo(i2, cameraInfo);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (cameraInfo.facing == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // IOOXOOOOo.II0xO0
    public void oO() {
        if (this.f4131O0xOxO != null) {
            xXxxox0I();
        }
    }

    @Override // IOOXOOOOo.II0xO0
    public boolean oOoXoXO() {
        if (this.f4131O0xOxO != null && this.f4138xxX) {
            return true;
        }
        return false;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        II0xO0.oIX0oI oix0oi = this.f547o00;
        if (oix0oi != null) {
            oix0oi.oIX0oI(bArr, X0IIOO().width(), X0IIOO().height());
        }
    }

    public final void oo() {
        this.f4135XxX0x0xxx = false;
        Camera camera = this.f4131O0xOxO;
        if (camera == null) {
            return;
        }
        try {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setFocusMode("continuous-picture");
            this.f4131O0xOxO.setParameters(parameters);
            this.f4131O0xOxO.cancelAutoFocus();
        } catch (Exception unused) {
            oI00o.II0xO0.I0Io("连续对焦失败");
        }
    }

    public void oo0xXOI0I() {
        if (this.f4131O0xOxO == null) {
            return;
        }
        try {
            this.f4138xxX = true;
            SurfaceHolder holder = this.f543Oo.getHolder();
            holder.setKeepScreenOn(true);
            holder.addCallback(this.f4136ooXIXxIX);
            this.f4131O0xOxO.setPreviewDisplay(holder);
            this.f4134XIxXXX0x0.oOoXoXO(this.f4131O0xOxO);
            this.f4131O0xOxO.startPreview();
            this.f4131O0xOxO.setPreviewCallback(this);
            oo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // IOOXOOOOo.II0xO0
    public boolean ooOOo0oXI() {
        return O0xOxO().isZoomSupported();
    }

    public final void ooXIXxIX() {
        int width = this.f543Oo.getWidth();
        int height = this.f543Oo.getHeight();
        oI00o.II0xO0.oIX0oI("View finder size: " + this.f543Oo.getWidth() + " x " + this.f543Oo.getHeight());
        XXx0OXXXo.oIX0oI oix0oi = this.f4134XIxXXX0x0;
        if (oix0oi != null && oix0oi.XO() != null) {
            Point XO2 = this.f4134XIxXXX0x0.XO();
            float f = width;
            float f2 = height;
            float f3 = f / f2;
            float f4 = XO2.x;
            float f5 = XO2.y;
            float f6 = f4 / f5;
            if (f3 < f6) {
                width = (int) (f2 / (f5 / f4));
            } else {
                height = (int) (f / f6);
            }
        }
        oI00o.II0xO0.oIX0oI("surface view size: " + width + " x " + height);
        this.f543Oo.II0xO0(height, width);
    }

    @Override // me.devilsen.czxing.view.AutoFitSurfaceView.oIX0oI
    public void oxoX() {
        xxX(true, 5);
    }

    @Override // IOOXOOOOo.II0xO0
    public void x0XOIxOo() {
        XxX0x0xxx();
        try {
            SurfaceHolder holder = this.f543Oo.getHolder();
            holder.setKeepScreenOn(true);
            holder.addCallback(this.f4136ooXIXxIX);
            this.f4131O0xOxO.setPreviewDisplay(holder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // IOOXOOOOo.II0xO0
    public void x0xO0oo() {
        this.f541IIXOooo = false;
        this.f4138xxX = false;
        if (this.f4131O0xOxO == null) {
            return;
        }
        this.f542IXxxXO.oxoX();
        IoOoX();
        if (this.f4131O0xOxO != null) {
            xXxxox0I();
            this.f4131O0xOxO = null;
        }
    }

    public final void xI(int i) {
        try {
            this.f4133XI0IXoo = i;
            Camera open = Camera.open(i);
            this.f4131O0xOxO = open;
            IIX0o(open);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void xXxxox0I() {
        try {
            this.f4131O0xOxO.release();
        } catch (Exception e) {
            oI00o.II0xO0.I0Io("release: e = " + e);
        }
    }

    @Override // IOOXOOOOo.II0xO0
    public float xxIXOIIO() {
        return O0xOxO().getZoom();
    }

    public void xxX(boolean z, int i) {
        try {
            Camera.Parameters parameters = this.f4131O0xOxO.getParameters();
            if (parameters.isZoomSupported()) {
                int zoom = parameters.getZoom();
                if (z && zoom < parameters.getMaxZoom()) {
                    oI00o.II0xO0.oIX0oI("放大");
                    zoom += i;
                } else if (!z && zoom > 0) {
                    oI00o.II0xO0.oIX0oI("缩小");
                    this.f545OxxIIOOXO = true;
                    zoom -= i;
                } else {
                    oI00o.II0xO0.oIX0oI("既不放大也不缩小");
                }
                parameters.setZoom(zoom);
                this.f4131O0xOxO.setParameters(parameters);
                return;
            }
            oI00o.II0xO0.oIX0oI("不支持缩放");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
