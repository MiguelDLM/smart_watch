package I0;

import XIXIX.II0XooXoX;
import XIXIX.oOoXoXO;
import XIXIX.xxIXOIIO;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;

@SuppressLint({"NewApi"})
/* loaded from: classes9.dex */
public class oIX0oI extends II0xO0 {

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public static II0XooXoX<oIX0oI> f35XI0IXoo;

    static {
        II0XooXoX<oIX0oI> oIX0oI2 = II0XooXoX.oIX0oI(4, new oIX0oI(null, 0.0f, 0.0f, null, null, 0.0f, 0.0f, 0L));
        f35XI0IXoo = oIX0oI2;
        oIX0oI2.oOoXoXO(0.5f);
    }

    public oIX0oI(oOoXoXO oooxoxo, float f, float f2, xxIXOIIO xxixoiio, View view, float f3, float f4, long j) {
        super(oooxoxo, f, f2, xxixoiio, view, f3, f4, j);
    }

    public static void OOXIXo(oIX0oI oix0oi) {
        f35XI0IXoo.Oxx0IOOO(oix0oi);
    }

    public static oIX0oI xoIox(oOoXoXO oooxoxo, float f, float f2, xxIXOIIO xxixoiio, View view, float f3, float f4, long j) {
        oIX0oI II0xO02 = f35XI0IXoo.II0xO0();
        II0xO02.f26Oxx0xo = oooxoxo;
        II0xO02.f28oI0IIXIo = f;
        II0xO02.f27OxxIIOOXO = f2;
        II0xO02.f24IIXOooo = xxixoiio;
        II0xO02.f29xoXoI = view;
        II0xO02.f20O0xOxO = f3;
        II0xO02.f22X0IIOO = f4;
        II0xO02.f23o00.setDuration(j);
        return II0xO02;
    }

    @Override // I0.II0xO0
    public void Oxx0IOOO() {
        OOXIXo(this);
    }

    @Override // XIXIX.II0XooXoX.oIX0oI
    public II0XooXoX.oIX0oI oIX0oI() {
        return new oIX0oI(null, 0.0f, 0.0f, null, null, 0.0f, 0.0f, 0L);
    }

    @Override // I0.II0xO0, android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float[] fArr = this.f25IXxxXO;
        float f = this.f20O0xOxO;
        float f2 = this.f28oI0IIXIo - f;
        float f3 = this.f21OxI;
        fArr[0] = f + (f2 * f3);
        float f4 = this.f22X0IIOO;
        fArr[1] = f4 + ((this.f27OxxIIOOXO - f4) * f3);
        this.f24IIXOooo.oO(fArr);
        this.f26Oxx0xo.X0o0xo(this.f25IXxxXO, this.f29xoXoI);
    }
}
