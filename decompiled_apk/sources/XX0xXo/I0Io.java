package XX0xXo;

import XIXIX.OOXIXo;
import XIXIX.Oxx0IOOO;
import android.graphics.Paint;

/* loaded from: classes9.dex */
public class I0Io extends II0xO0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public Oxx0IOOO f3989II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public String f3990Oxx0IOOO = "Description Label";

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public Paint.Align f3991xxIXOIIO = Paint.Align.RIGHT;

    public I0Io() {
        this.f3994X0o0xo = OOXIXo.X0o0xo(8.0f);
    }

    public void IXxxXO(Paint.Align align) {
        this.f3991xxIXOIIO = align;
    }

    public void Oo(String str) {
        this.f3990Oxx0IOOO = str;
    }

    public Paint.Align oO() {
        return this.f3991xxIXOIIO;
    }

    public Oxx0IOOO ooOOo0oXI() {
        return this.f3989II0XooXoX;
    }

    public String x0XOIxOo() {
        return this.f3990Oxx0IOOO;
    }

    public void x0xO0oo(float f, float f2) {
        Oxx0IOOO oxx0IOOO = this.f3989II0XooXoX;
        if (oxx0IOOO == null) {
            this.f3989II0XooXoX = Oxx0IOOO.I0Io(f, f2);
        } else {
            oxx0IOOO.f3771IXxxXO = f;
            oxx0IOOO.f3772Oxx0xo = f2;
        }
    }
}
