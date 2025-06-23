package jxl.read.biff;

/* loaded from: classes6.dex */
public class oIX0oI extends OoIXo.Xx000oIo {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f28368II0XooXoX = 5;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f28369OOXIXo = 64;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final int f28370Oxx0IOOO = 1280;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28371X0o0xo = XxIIOXIXx.X0o0xo.Oxx0IOOO(oIX0oI.class);

    /* renamed from: XO, reason: collision with root package name */
    public static final int f28372XO = 1536;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f28373xoIox = 32;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f28374xxIXOIIO = 16;

    /* renamed from: I0Io, reason: collision with root package name */
    public int f28375I0Io;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f28376oxoX;

    public oIX0oI(xoxXI xoxxi) {
        super(xoxxi);
        byte[] I0Io2 = oxXx0IX().I0Io();
        this.f28375I0Io = OoIXo.oo0xXOI0I.I0Io(I0Io2[0], I0Io2[1]);
        this.f28376oxoX = OoIXo.oo0xXOI0I.I0Io(I0Io2[2], I0Io2[3]);
    }

    public boolean I0X0x0oIo() {
        if (this.f28376oxoX == 32) {
            return true;
        }
        return false;
    }

    public boolean XX0() {
        if (this.f28375I0Io == 1536) {
            return true;
        }
        return false;
    }

    public boolean Xo0() {
        if (this.f28376oxoX == 5) {
            return true;
        }
        return false;
    }

    public boolean XoI0Ixx0() {
        if (this.f28376oxoX == 16) {
            return true;
        }
        return false;
    }

    public boolean oX() {
        if (this.f28376oxoX == 64) {
            return true;
        }
        return false;
    }

    public boolean xXOx() {
        if (this.f28375I0Io == 1280) {
            return true;
        }
        return false;
    }

    public int xo0x() {
        return oxXx0IX().oxoX();
    }
}
