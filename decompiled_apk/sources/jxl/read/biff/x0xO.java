package jxl.read.biff;

/* loaded from: classes6.dex */
public class x0xO extends OoIXo.Xx000oIo {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28467OOXIXo = XxIIOXIXx.X0o0xo.Oxx0IOOO(x0xO.class);

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f28468oOoXoXO = 255;

    /* renamed from: I0Io, reason: collision with root package name */
    public int f28469I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f28470II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public boolean f28471Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f28472X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f28473XO;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f28474oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public boolean f28475xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f28476xxIXOIIO;

    public x0xO(xoxXI xoxxi) {
        super(xoxxi);
        boolean z;
        boolean z2;
        boolean z3;
        byte[] I0Io2 = oxXx0IX().I0Io();
        this.f28469I0Io = OoIXo.oo0xXOI0I.I0Io(I0Io2[0], I0Io2[1]);
        this.f28474oxoX = OoIXo.oo0xXOI0I.I0Io(I0Io2[6], I0Io2[7]);
        int oxoX2 = OoIXo.oo0xXOI0I.oxoX(I0Io2[12], I0Io2[13], I0Io2[14], I0Io2[15]);
        this.f28476xxIXOIIO = oxoX2 & 7;
        if ((oxoX2 & 16) != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f28475xoIox = z;
        if ((oxoX2 & 32) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f28472X0o0xo = z2;
        if ((oxoX2 & 64) == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.f28471Oxx0IOOO = z3;
        this.f28473XO = (oxoX2 & 128) != 0;
        this.f28470II0XooXoX = (oxoX2 & 268369920) >> 16;
    }

    public int I0X0x0oIo() {
        return this.f28469I0Io;
    }

    public boolean I0oOIX() {
        return this.f28471Oxx0IOOO;
    }

    public boolean O0Xx() {
        if (this.f28474oxoX == 255) {
            return true;
        }
        return false;
    }

    public int XX0() {
        return this.f28474oxoX;
    }

    public boolean Xo0() {
        return this.f28473XO;
    }

    public boolean XoI0Ixx0() {
        return this.f28472X0o0xo;
    }

    public int oX() {
        return this.f28470II0XooXoX;
    }

    public int xXOx() {
        return this.f28476xxIXOIIO;
    }

    public boolean xo0x() {
        return this.f28475xoIox;
    }
}
