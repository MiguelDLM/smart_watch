package jxl.read.biff;

/* loaded from: classes6.dex */
public class xoO0xx0 extends OoIXo.Xx000oIo {

    /* renamed from: I0Io, reason: collision with root package name */
    public int f28516I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public String f28517II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public boolean f28518OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public String f28519Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f28520X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public String f28521XO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public boolean f28522oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public boolean f28523ooOOo0oXI;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f28524oxoX;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public boolean f28525x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    public boolean f28526xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public byte f28527xxIXOIIO;

    public xoO0xx0(xoxXI xoxxi) {
        super(OoIXo.xII.f2439O0IxXx);
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        this.f28526xoIox = false;
        this.f28518OOXIXo = false;
        this.f28522oOoXoXO = false;
        this.f28523ooOOo0oXI = false;
        this.f28525x0XOIxOo = false;
        byte[] I0Io2 = xoxxi.I0Io();
        byte b = I0Io2[0];
        this.f28527xxIXOIIO = b;
        if ((b & 1) != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f28526xoIox = z;
        if ((b & 2) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f28518OOXIXo = z2;
        if ((b & 4) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.f28522oOoXoXO = z3;
        if ((b & 8) != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f28523ooOOo0oXI = z4;
        this.f28525x0XOIxOo = (b & 16) != 0;
        byte b2 = I0Io2[2];
        this.f28516I0Io = b2;
        this.f28524oxoX = I0Io2[3];
        this.f28520X0o0xo = I0Io2[4];
        if (I0Io2[5] == 0) {
            this.f28521XO = new String(I0Io2, 6, (int) b2);
            i = this.f28516I0Io;
        } else {
            this.f28521XO = OoIXo.IO.Oxx0IOOO(I0Io2, b2, 6);
            i = this.f28516I0Io * 2;
        }
        int i2 = 6 + i;
        int i3 = this.f28524oxoX;
        if (i3 > 0) {
            int i4 = i2 + 1;
            if (I0Io2[i2] == 0) {
                this.f28519Oxx0IOOO = new String(I0Io2, i4, i3);
                i2 = i4 + this.f28524oxoX;
            } else {
                this.f28519Oxx0IOOO = OoIXo.IO.Oxx0IOOO(I0Io2, i3, i4);
                i2 = i4 + (this.f28524oxoX * 2);
            }
        } else {
            this.f28519Oxx0IOOO = "";
        }
        int i5 = this.f28520X0o0xo;
        if (i5 > 0) {
            int i6 = i2 + 1;
            if (I0Io2[i2] == 0) {
                this.f28517II0XooXoX = new String(I0Io2, i6, i5);
                return;
            } else {
                this.f28517II0XooXoX = OoIXo.IO.Oxx0IOOO(I0Io2, i5, i6);
                return;
            }
        }
        this.f28517II0XooXoX = "";
    }

    public String I0X0x0oIo() {
        return this.f28517II0XooXoX;
    }

    public boolean O0Xx() {
        return this.f28523ooOOo0oXI;
    }

    public String XX0() {
        return this.f28519Oxx0IOOO;
    }

    public boolean Xo0() {
        return this.f28518OOXIXo;
    }

    public boolean XoI0Ixx0() {
        return this.f28522oOoXoXO;
    }

    public boolean oX() {
        return this.f28526xoIox;
    }

    public String xXOx() {
        return this.f28521XO;
    }

    public boolean xo0x() {
        return this.f28525x0XOIxOo;
    }
}
