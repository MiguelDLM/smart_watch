package I0;

import XIXIX.II0XooXoX;
import XIXIX.oOoXoXO;
import XIXIX.xxIXOIIO;
import android.view.View;

/* loaded from: classes9.dex */
public class oxoX extends X0o0xo {

    /* renamed from: o00, reason: collision with root package name */
    public static II0XooXoX<oxoX> f36o00;

    static {
        II0XooXoX<oxoX> oIX0oI2 = II0XooXoX.oIX0oI(2, new oxoX(null, 0.0f, 0.0f, null, null));
        f36o00 = oIX0oI2;
        oIX0oI2.oOoXoXO(0.5f);
    }

    public oxoX(oOoXoXO oooxoxo, float f, float f2, xxIXOIIO xxixoiio, View view) {
        super(oooxoxo, f, f2, xxixoiio, view);
    }

    public static void X0o0xo(oxoX oxox) {
        f36o00.Oxx0IOOO(oxox);
    }

    public static oxoX oxoX(oOoXoXO oooxoxo, float f, float f2, xxIXOIIO xxixoiio, View view) {
        oxoX II0xO02 = f36o00.II0xO0();
        II0xO02.f26Oxx0xo = oooxoxo;
        II0xO02.f28oI0IIXIo = f;
        II0xO02.f27OxxIIOOXO = f2;
        II0xO02.f24IIXOooo = xxixoiio;
        II0xO02.f29xoXoI = view;
        return II0xO02;
    }

    @Override // XIXIX.II0XooXoX.oIX0oI
    public II0XooXoX.oIX0oI oIX0oI() {
        return new oxoX(this.f26Oxx0xo, this.f28oI0IIXIo, this.f27OxxIIOOXO, this.f24IIXOooo, this.f29xoXoI);
    }

    @Override // java.lang.Runnable
    public void run() {
        float[] fArr = this.f25IXxxXO;
        fArr[0] = this.f28oI0IIXIo;
        fArr[1] = this.f27OxxIIOOXO;
        this.f24IIXOooo.oO(fArr);
        this.f26Oxx0xo.X0o0xo(this.f25IXxxXO, this.f29xoXoI);
        X0o0xo(this);
    }
}
