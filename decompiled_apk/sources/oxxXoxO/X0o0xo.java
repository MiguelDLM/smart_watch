package oxxXoxO;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;

/* loaded from: classes8.dex */
public final class X0o0xo {

    /* renamed from: I0Io, reason: collision with root package name */
    public final int f33635I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final int f33636II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final int f33637oIX0oI;

    public X0o0xo(int i, int i2, int i3) {
        this.f33637oIX0oI = i;
        this.f33636II0xO0 = i2;
        this.f33635I0Io = i3;
    }

    public static /* synthetic */ X0o0xo X0o0xo(X0o0xo x0o0xo, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = x0o0xo.f33637oIX0oI;
        }
        if ((i4 & 2) != 0) {
            i2 = x0o0xo.f33636II0xO0;
        }
        if ((i4 & 4) != 0) {
            i3 = x0o0xo.f33635I0Io;
        }
        return x0o0xo.oxoX(i, i2, i3);
    }

    public final int I0Io() {
        return this.f33635I0Io;
    }

    public final int II0XooXoX() {
        return this.f33635I0Io;
    }

    public final int II0xO0() {
        return this.f33636II0xO0;
    }

    public final int Oxx0IOOO() {
        return this.f33636II0xO0;
    }

    public final int XO() {
        return this.f33637oIX0oI;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof X0o0xo)) {
            return false;
        }
        X0o0xo x0o0xo = (X0o0xo) obj;
        if (this.f33637oIX0oI == x0o0xo.f33637oIX0oI && this.f33636II0xO0 == x0o0xo.f33636II0xO0 && this.f33635I0Io == x0o0xo.f33635I0Io) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f33637oIX0oI * 31) + this.f33636II0xO0) * 31) + this.f33635I0Io;
    }

    public final int oIX0oI() {
        return this.f33637oIX0oI;
    }

    @OOXIXo
    public final X0o0xo oxoX(int i, int i2, int i3) {
        return new X0o0xo(i, i2, i3);
    }

    @OOXIXo
    public String toString() {
        return "User(age=" + this.f33637oIX0oI + ", gender=" + this.f33636II0xO0 + ", height=" + this.f33635I0Io + HexStringBuilder.COMMENT_END_CHAR;
    }
}
