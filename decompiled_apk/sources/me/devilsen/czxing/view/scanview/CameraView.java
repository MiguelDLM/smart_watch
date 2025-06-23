package me.devilsen.czxing.view.scanview;

import IOOXOOOOo.II0xO0;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import me.devilsen.czxing.view.AutoFitSurfaceView;
import oI00o.Oxx0IOOO;

/* loaded from: classes6.dex */
public class CameraView extends FrameLayout implements II0xO0.oIX0oI {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public Oxx0IOOO f30870IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public AutoFitSurfaceView f30871Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public ValueAnimator f30872Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public IOOXOOOOo.II0xO0 f30873XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public long f30874oI0IIXIo;

    /* loaded from: classes6.dex */
    public class II0xO0 implements ValueAnimator.AnimatorUpdateListener {
        public II0xO0() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (CameraView.this.f30871Oo == null) {
                return;
            }
            CameraView.this.f30873XO.OxxIIOOXO(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* loaded from: classes6.dex */
    public class oIX0oI implements Runnable {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ int f30876IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ int f30877Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ int f30879XO;

        public oIX0oI(int i, int i2, int i3) {
            this.f30879XO = i;
            this.f30877Oo = i2;
            this.f30876IXxxXO = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraView cameraView = CameraView.this;
            int i = this.f30879XO;
            cameraView.OOXIXo(i, Math.min(this.f30877Oo + i, this.f30876IXxxXO));
        }
    }

    public CameraView(Context context) {
        this(context, null);
    }

    public void II0XooXoX() {
        if (ContextCompat.checkSelfPermission(getContext(), "android.permission.CAMERA") == 0) {
            this.f30873XO.x0XOIxOo();
        }
    }

    public final void OOXIXo(int i, int i2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
        this.f30872Oxx0xo = ofInt;
        ofInt.addUpdateListener(new II0xO0());
        this.f30872Oxx0xo.setDuration(200L);
        this.f30872Oxx0xo.setInterpolator(new DecelerateInterpolator());
        this.f30872Oxx0xo.start();
        this.f30874oI0IIXIo = SystemClock.uptimeMillis();
    }

    public void Oxx0IOOO() {
        IOOXOOOOo.II0xO0 iI0xO0 = this.f30873XO;
        if (iI0xO0 != null) {
            iI0xO0.oO();
            this.f30873XO = null;
        }
    }

    public void X0o0xo() {
        IOOXOOOOo.II0xO0 iI0xO0 = this.f30873XO;
        if (iI0xO0 != null) {
            iI0xO0.XO();
        }
    }

    public final void XO(Context context) {
        setBackground(null);
        AutoFitSurfaceView autoFitSurfaceView = new AutoFitSurfaceView(context);
        this.f30871Oo = autoFitSurfaceView;
        XXx0OXXXo.II0xO0 iI0xO0 = new XXx0OXXXo.II0xO0(context, autoFitSurfaceView);
        this.f30873XO = iI0xO0;
        iI0xO0.x0XOIxOo();
        this.f30873XO.Oxx0xo(this);
        addView(this.f30871Oo, new FrameLayout.LayoutParams(-1, -1));
        this.f30870IXxxXO = new Oxx0IOOO();
    }

    @Override // IOOXOOOOo.II0xO0.oIX0oI
    public void oIX0oI(byte[] bArr, int i, int i2) {
    }

    public void oOoXoXO() {
        this.f30873XO.x0xO0oo();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f30872Oxx0xo;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f30870IXxxXO.X0o0xo(i3 - i, i4 - i2);
    }

    public void ooOOo0oXI(int[] iArr) {
        int i = 0;
        if (iArr.length > 3) {
            float f = iArr[0];
            float f2 = iArr[1];
            float f3 = iArr[2];
            float f4 = iArr[3];
            float abs = Math.abs(f - f3);
            float abs2 = Math.abs(f2 - f4);
            i = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
        }
        if (iArr.length > 5) {
            float f5 = iArr[2];
            float f6 = iArr[3];
            float f7 = iArr[4];
            float f8 = iArr[5];
            float abs3 = Math.abs(f5 - f7);
            float abs4 = Math.abs(f6 - f8);
            int sqrt = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
            if (sqrt < i) {
                i = sqrt;
            }
        }
        try {
            oI00o.II0xO0.oIX0oI("len: " + i);
            IOOXOOOOo.II0xO0 iI0xO0 = this.f30873XO;
            if (iI0xO0 != null && i > 0 && !iI0xO0.xoIox()) {
                ValueAnimator valueAnimator = this.f30872Oxx0xo;
                if ((valueAnimator != null && valueAnimator.isRunning()) || SystemClock.uptimeMillis() - this.f30874oI0IIXIo < 220 || !this.f30873XO.ooOOo0oXI()) {
                    return;
                }
                int II0XooXoX2 = (int) this.f30873XO.II0XooXoX();
                oOIXoIXXI.oIX0oI.Oxx0IOOO(new oIX0oI((int) this.f30873XO.xxIXOIIO(), II0XooXoX2 / 6, II0XooXoX2 / 2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void oxoX() {
        this.f30873XO.x0xO0oo();
    }

    public void xoIox() {
        if (ContextCompat.checkSelfPermission(getContext(), "android.permission.CAMERA") == 0) {
            this.f30873XO.OxxIIOOXO(0.0f);
        }
    }

    public void xxIXOIIO() {
        IOOXOOOOo.II0xO0 iI0xO0 = this.f30873XO;
        if (iI0xO0 != null) {
            iI0xO0.IXxxXO();
        }
    }

    public CameraView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        XO(context);
    }
}
