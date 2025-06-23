package I0;

import XIXIX.II0XooXoX;
import XIXIX.oOoXoXO;
import XIXIX.xxIXOIIO;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.YAxis;

@SuppressLint({"NewApi"})
/* loaded from: classes9.dex */
public class I0Io extends II0xO0 implements Animator.AnimatorListener {

    /* renamed from: xI, reason: collision with root package name */
    public static II0XooXoX<I0Io> f12xI = II0XooXoX.oIX0oI(8, new I0Io(null, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0));

    /* renamed from: IIX0o, reason: collision with root package name */
    public float f13IIX0o;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public float f14XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public float f15XIxXXX0x0;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public float f16XxX0x0xxx;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public Matrix f17ooXIXxIX;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public YAxis f18xXxxox0I;

    /* renamed from: xxX, reason: collision with root package name */
    public float f19xxX;

    @SuppressLint({"NewApi"})
    public I0Io(oOoXoXO oooxoxo, View view, xxIXOIIO xxixoiio, YAxis yAxis, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, long j) {
        super(oooxoxo, f2, f3, xxixoiio, view, f4, f5, j);
        this.f17ooXIXxIX = new Matrix();
        this.f19xxX = f6;
        this.f16XxX0x0xxx = f7;
        this.f14XI0IXoo = f8;
        this.f15XIxXXX0x0 = f9;
        this.f23o00.addListener(this);
        this.f18xXxxox0I = yAxis;
        this.f13IIX0o = f;
    }

    public static I0Io xoIox(oOoXoXO oooxoxo, View view, xxIXOIIO xxixoiio, YAxis yAxis, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, long j) {
        I0Io II0xO02 = f12xI.II0xO0();
        II0xO02.f26Oxx0xo = oooxoxo;
        II0xO02.f28oI0IIXIo = f2;
        II0xO02.f27OxxIIOOXO = f3;
        II0xO02.f24IIXOooo = xxixoiio;
        II0xO02.f29xoXoI = view;
        II0xO02.f20O0xOxO = f4;
        II0xO02.f22X0IIOO = f5;
        II0xO02.f18xXxxox0I = yAxis;
        II0xO02.f13IIX0o = f;
        II0xO02.II0XooXoX();
        II0xO02.f23o00.setDuration(j);
        return II0xO02;
    }

    @Override // XIXIX.II0XooXoX.oIX0oI
    public II0XooXoX.oIX0oI oIX0oI() {
        return new I0Io(null, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L);
    }

    @Override // I0.II0xO0, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        ((BarLineChartBase) this.f29xoXoI).x0xO0oo();
        this.f29xoXoI.postInvalidate();
    }

    @Override // I0.II0xO0, android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float f = this.f20O0xOxO;
        float f2 = this.f28oI0IIXIo - f;
        float f3 = this.f21OxI;
        float f4 = f + (f2 * f3);
        float f5 = this.f22X0IIOO;
        float f6 = f5 + ((this.f27OxxIIOOXO - f5) * f3);
        Matrix matrix = this.f17ooXIXxIX;
        this.f26Oxx0xo.Xo0(f4, f6, matrix);
        this.f26Oxx0xo.XOxIOxOx(matrix, this.f29xoXoI, false);
        float o002 = this.f18xXxxox0I.f4028xI / this.f26Oxx0xo.o00();
        float xoXoI2 = this.f13IIX0o / this.f26Oxx0xo.xoXoI();
        float[] fArr = this.f25IXxxXO;
        float f7 = this.f14XI0IXoo;
        float f8 = (this.f19xxX - (xoXoI2 / 2.0f)) - f7;
        float f9 = this.f21OxI;
        fArr[0] = f7 + (f8 * f9);
        float f10 = this.f15XIxXXX0x0;
        fArr[1] = f10 + (((this.f16XxX0x0xxx + (o002 / 2.0f)) - f10) * f9);
        this.f24IIXOooo.oO(fArr);
        this.f26Oxx0xo.O0Xx(this.f25IXxxXO, matrix);
        this.f26Oxx0xo.XOxIOxOx(matrix, this.f29xoXoI, true);
    }

    @Override // I0.II0xO0
    public void Oxx0IOOO() {
    }

    @Override // I0.II0xO0, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // I0.II0xO0, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // I0.II0xO0, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }
}
