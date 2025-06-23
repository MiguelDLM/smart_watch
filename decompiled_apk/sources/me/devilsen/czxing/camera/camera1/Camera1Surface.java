package me.devilsen.czxing.camera.camera1;

import IOOXOOOOo.I0Io;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import java.util.Collections;
import oI00o.X0o0xo;

/* loaded from: classes6.dex */
public class Camera1Surface extends SurfaceView implements I0Io.oIX0oI, SurfaceHolder.Callback {

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public static final long f30838XIxXXX0x0 = 1000;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public boolean f30839IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public boolean f30840IXxxXO;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public final I0Io f30841O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    public float f30842Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public long f30843OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public boolean f30844Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public boolean f30845OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public XXx0OXXXo.oIX0oI f30846X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public II0xO0 f30847XI0IXoo;

    /* renamed from: XO, reason: collision with root package name */
    public Camera f30848XO;

    /* renamed from: o00, reason: collision with root package name */
    public long f30849o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public boolean f30850oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public Point f30851xoXoI;

    /* loaded from: classes6.dex */
    public interface II0xO0 {
        void oIX0oI();
    }

    /* loaded from: classes6.dex */
    public class oIX0oI implements Camera.AutoFocusCallback {
        public oIX0oI() {
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            if (z) {
                oI00o.II0xO0.oIX0oI("对焦测光成功");
            } else {
                oI00o.II0xO0.I0Io("对焦测光失败");
            }
            Camera1Surface.this.oO();
        }
    }

    public Camera1Surface(Context context) {
        this(context, null);
    }

    private void Oxx0IOOO(float f, float f2) {
        if (X0o0xo.XO(getContext())) {
            f2 = f;
            f = f2;
        }
        int oxoX2 = X0o0xo.oxoX(getContext(), 80.0f);
        II0XooXoX(f, f2, oxoX2, oxoX2);
    }

    private boolean X0o0xo() {
        if (oOoXoXO() && getContext().getPackageManager().hasSystemFeature("android.hardware.camera.flash")) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oO() {
        this.f30844Oxx0xo = false;
        Camera camera = this.f30848XO;
        if (camera == null) {
            return;
        }
        try {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setFocusMode("continuous-picture");
            this.f30848XO.setParameters(parameters);
            this.f30848XO.cancelAutoFocus();
        } catch (Exception unused) {
            oI00o.II0xO0.I0Io("连续对焦失败");
        }
    }

    private void oxoX() {
        OOXIXo(true, 5);
    }

    @Override // IOOXOOOOo.I0Io.oIX0oI
    public void I0Io() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f30849o00 < 1000) {
            return;
        }
        this.f30849o00 = currentTimeMillis;
        if (this.f30851xoXoI != null) {
            oI00o.II0xO0.oIX0oI("mCamera is frozen, start focus x = " + this.f30851xoXoI.x + " y = " + this.f30851xoXoI.y);
            Point point = this.f30851xoXoI;
            Oxx0IOOO((float) point.x, (float) point.y);
        }
    }

    public void II0XooXoX(float f, float f2, int i, int i2) {
        boolean z;
        try {
            Camera.Parameters parameters = this.f30848XO.getParameters();
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
                this.f30848XO.cancelAutoFocus();
                this.f30848XO.setParameters(parameters);
                this.f30848XO.autoFocus(new oIX0oI());
                return;
            }
            this.f30844Oxx0xo = false;
        } catch (Exception e) {
            e.printStackTrace();
            oI00o.II0xO0.I0Io("对焦测光失败：" + e.getMessage());
            oO();
        }
    }

    public void II0xO0() {
        this.f30845OxxIIOOXO = false;
        if (X0o0xo()) {
            this.f30846X0IIOO.II0xO0(this.f30848XO);
        }
    }

    public void OOXIXo(boolean z, int i) {
        try {
            Camera.Parameters parameters = this.f30848XO.getParameters();
            if (parameters.isZoomSupported()) {
                int zoom = parameters.getZoom();
                if (z && zoom < parameters.getMaxZoom()) {
                    oI00o.II0xO0.oIX0oI("放大");
                    zoom += i;
                } else if (!z && zoom > 0) {
                    oI00o.II0xO0.oIX0oI("缩小");
                    this.f30839IIXOooo = true;
                    zoom -= i;
                } else {
                    oI00o.II0xO0.oIX0oI("既不放大也不缩小");
                }
                parameters.setZoom(zoom);
                this.f30848XO.setParameters(parameters);
                return;
            }
            oI00o.II0xO0.oIX0oI("不支持缩放");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Oo(boolean z) {
        if (this.f30845OxxIIOOXO) {
            II0xO0();
        } else if (z) {
            ooOOo0oXI();
        }
    }

    public boolean XO() {
        return this.f30839IIXOooo;
    }

    public boolean oOoXoXO() {
        if (this.f30848XO != null && this.f30840IXxxXO) {
            return true;
        }
        return false;
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i, int i2) {
        int defaultSize = View.getDefaultSize(getSuggestedMinimumWidth(), i);
        int defaultSize2 = View.getDefaultSize(getSuggestedMinimumHeight(), i2);
        XXx0OXXXo.oIX0oI oix0oi = this.f30846X0IIOO;
        if (oix0oi != null && oix0oi.XO() != null) {
            Point XO2 = this.f30846X0IIOO.XO();
            float f = defaultSize;
            float f2 = defaultSize2;
            float f3 = (f * 1.0f) / f2;
            float f4 = XO2.x;
            float f5 = XO2.y;
            float f6 = (f4 * 1.0f) / f5;
            if (f3 < f6) {
                defaultSize = (int) ((f2 / ((f5 * 1.0f) / f4)) + 0.5f);
            } else {
                defaultSize2 = (int) ((f / f6) + 0.5f);
            }
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(defaultSize, 1073741824), View.MeasureSpec.makeMeasureSpec(defaultSize2, 1073741824));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!oOoXoXO()) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getPointerCount() == 1) {
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f30843OxI < 300) {
                    oxoX();
                    this.f30843OxI = 0L;
                    return true;
                }
                this.f30843OxI = currentTimeMillis;
            } else {
                if (action != 1 || this.f30844Oxx0xo) {
                    return true;
                }
                this.f30844Oxx0xo = true;
                Oxx0IOOO(motionEvent.getX(), motionEvent.getY());
                oI00o.II0xO0.oIX0oI("手指触摸，触发对焦测光");
            }
        } else if (motionEvent.getPointerCount() == 2) {
            xxIXOIIO(motionEvent);
        }
        return true;
    }

    public void ooOOo0oXI() {
        this.f30845OxxIIOOXO = true;
        if (X0o0xo()) {
            this.f30846X0IIOO.xoIox(this.f30848XO);
        }
    }

    public void setCamera(Camera camera) {
        if (camera == null) {
            return;
        }
        this.f30848XO = camera;
        XXx0OXXXo.oIX0oI oix0oi = new XXx0OXXXo.oIX0oI(getContext());
        this.f30846X0IIOO = oix0oi;
        oix0oi.xxIXOIIO(this.f30848XO);
        getHolder().addCallback(this);
        if (this.f30840IXxxXO) {
            requestLayout();
        } else {
            x0XOIxOo();
        }
    }

    public void setPreviewListener(II0xO0 iI0xO0) {
        this.f30847XI0IXoo = iI0xO0;
    }

    public void setScanBoxPoint(Point point) {
        if (this.f30851xoXoI == null) {
            this.f30851xoXoI = point;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (surfaceHolder.getSurface() == null) {
            return;
        }
        x0xO0oo();
        x0XOIxOo();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f30850oI0IIXIo = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f30850oI0IIXIo = false;
        x0xO0oo();
    }

    public void x0XOIxOo() {
        if (this.f30848XO == null) {
            return;
        }
        try {
            this.f30840IXxxXO = true;
            SurfaceHolder holder = getHolder();
            holder.setKeepScreenOn(true);
            holder.addCallback(this);
            this.f30848XO.setPreviewDisplay(holder);
            this.f30846X0IIOO.oOoXoXO(this.f30848XO);
            this.f30848XO.startPreview();
            II0xO0 iI0xO0 = this.f30847XI0IXoo;
            if (iI0xO0 != null) {
                iI0xO0.oIX0oI();
            }
            oO();
            this.f30841O0xOxO.I0Io();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void x0xO0oo() {
        if (this.f30848XO == null) {
            return;
        }
        try {
            this.f30840IXxxXO = false;
            if (getHolder() != null) {
                getHolder().removeCallback(this);
            }
            this.f30848XO.cancelAutoFocus();
            this.f30848XO.stopPreview();
            this.f30848XO.setPreviewCallback(null);
            this.f30841O0xOxO.oxoX();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void xoIox(boolean z) {
        OOXIXo(z, 1);
    }

    public final void xxIXOIIO(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 2) {
            if (action == 5) {
                this.f30842Oo = X0o0xo.oIX0oI(motionEvent);
                return;
            }
            return;
        }
        float oIX0oI2 = X0o0xo.oIX0oI(motionEvent);
        float f = this.f30842Oo;
        if (oIX0oI2 > f) {
            xoIox(true);
        } else if (oIX0oI2 < f) {
            xoIox(false);
        }
    }

    public Camera1Surface(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Camera1Surface(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f30842Oo = 1.0f;
        this.f30840IXxxXO = true;
        I0Io i0Io = new I0Io(context);
        this.f30841O0xOxO = i0Io;
        i0Io.Oxx0IOOO(this);
    }
}
