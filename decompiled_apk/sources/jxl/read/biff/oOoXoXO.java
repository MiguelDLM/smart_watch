package jxl.read.biff;

/* loaded from: classes6.dex */
public abstract class oOoXoXO extends OoIXo.Xx000oIo implements xIoXXXIXo.I0Io, OOXIXo {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28398OOXIXo = XxIIOXIXx.X0o0xo.Oxx0IOOO(oOoXoXO.class);

    /* renamed from: I0Io, reason: collision with root package name */
    public int f28399I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public OoIXo.XX f28400II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public boolean f28401Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f28402X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public OoIXo.xXxxox0I f28403XO;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f28404oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public xIoXXXIXo.oxoX f28405xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public I0 f28406xxIXOIIO;

    public oOoXoXO(xoxXI xoxxi, OoIXo.xXxxox0I xxxxox0i, I0 i0) {
        super(xoxxi);
        byte[] I0Io2 = oxXx0IX().I0Io();
        this.f28399I0Io = OoIXo.oo0xXOI0I.I0Io(I0Io2[0], I0Io2[1]);
        this.f28404oxoX = OoIXo.oo0xXOI0I.I0Io(I0Io2[2], I0Io2[3]);
        this.f28402X0o0xo = OoIXo.oo0xXOI0I.I0Io(I0Io2[4], I0Io2[5]);
        this.f28406xxIXOIIO = i0;
        this.f28403XO = xxxxox0i;
        this.f28401Oxx0IOOO = false;
    }

    @Override // xIoXXXIXo.I0Io
    public final int II0xO0() {
        return this.f28399I0Io;
    }

    @Override // xIoXXXIXo.I0Io
    public xIoXXXIXo.oxoX XO() {
        return this.f28405xoIox;
    }

    @Override // xIoXXXIXo.I0Io
    public boolean isHidden() {
        oO x0xO2 = this.f28406xxIXOIIO.x0xO(this.f28404oxoX);
        if (x0xO2 != null && (x0xO2.Xo0() == 0 || x0xO2.XX0())) {
            return true;
        }
        x0xO XI0oooXX2 = this.f28406xxIXOIIO.XI0oooXX(this.f28399I0Io);
        if (XI0oooXX2 != null) {
            if (XI0oooXX2.XX0() == 0 || XI0oooXX2.XoI0Ixx0()) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // xIoXXXIXo.I0Io
    public final int oIX0oI() {
        return this.f28404oxoX;
    }

    @Override // jxl.read.biff.OOXIXo
    public void oO(xIoXXXIXo.oxoX oxox) {
        if (this.f28405xoIox != null) {
            f28398OOXIXo.ooOOo0oXI("current cell features not null - overwriting");
        }
        this.f28405xoIox = oxox;
    }

    public final int xXOx() {
        return this.f28402X0o0xo;
    }

    public I0 xo0x() {
        return this.f28406xxIXOIIO;
    }

    @Override // xIoXXXIXo.I0Io
    public oI0X0.X0o0xo xoIox() {
        if (!this.f28401Oxx0IOOO) {
            this.f28400II0XooXoX = this.f28403XO.xoIox(this.f28402X0o0xo);
            this.f28401Oxx0IOOO = true;
        }
        return this.f28400II0XooXoX;
    }
}
