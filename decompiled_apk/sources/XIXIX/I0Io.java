package XIXIX;

import XIXIX.II0XooXoX;
import java.util.List;

/* loaded from: classes9.dex */
public final class I0Io extends II0XooXoX.oIX0oI {

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static II0XooXoX<I0Io> f3742oI0IIXIo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public float f3743IXxxXO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public float f3744Oxx0xo;

    static {
        II0XooXoX<I0Io> oIX0oI2 = II0XooXoX.oIX0oI(256, new I0Io(0.0f, 0.0f));
        f3742oI0IIXIo = oIX0oI2;
        oIX0oI2.oOoXoXO(0.5f);
    }

    public I0Io() {
    }

    public static void I0Io(I0Io i0Io) {
        f3742oI0IIXIo.Oxx0IOOO(i0Io);
    }

    public static I0Io II0xO0(float f, float f2) {
        I0Io II0xO02 = f3742oI0IIXIo.II0xO0();
        II0xO02.f3743IXxxXO = f;
        II0xO02.f3744Oxx0xo = f2;
        return II0xO02;
    }

    public static void oxoX(List<I0Io> list) {
        f3742oI0IIXIo.II0XooXoX(list);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof I0Io)) {
            return false;
        }
        I0Io i0Io = (I0Io) obj;
        if (this.f3743IXxxXO != i0Io.f3743IXxxXO || this.f3744Oxx0xo != i0Io.f3744Oxx0xo) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f3743IXxxXO) ^ Float.floatToIntBits(this.f3744Oxx0xo);
    }

    @Override // XIXIX.II0XooXoX.oIX0oI
    public II0XooXoX.oIX0oI oIX0oI() {
        return new I0Io(0.0f, 0.0f);
    }

    public String toString() {
        return this.f3743IXxxXO + "x" + this.f3744Oxx0xo;
    }

    public I0Io(float f, float f2) {
        this.f3743IXxxXO = f;
        this.f3744Oxx0xo = f2;
    }
}
