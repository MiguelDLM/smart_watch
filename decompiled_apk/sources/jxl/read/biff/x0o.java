package jxl.read.biff;

/* loaded from: classes6.dex */
public class x0o implements xIoXXXIXo.I0Io, OOXIXo {

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28458xxIXOIIO = XxIIOXIXx.X0o0xo.Oxx0IOOO(x0o.class);

    /* renamed from: I0Io, reason: collision with root package name */
    public oI0X0.X0o0xo f28459I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public xIoXXXIXo.oxoX f28460II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f28461II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public I0 f28462Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public OoIXo.xXxxox0I f28463X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f28464XO = false;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f28465oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f28466oxoX;

    public x0o(int i, int i2, int i3, OoIXo.xXxxox0I xxxxox0i, I0 i0) {
        this.f28465oIX0oI = i;
        this.f28461II0xO0 = i2;
        this.f28466oxoX = i3;
        this.f28463X0o0xo = xxxxox0i;
        this.f28462Oxx0IOOO = i0;
    }

    @Override // xIoXXXIXo.I0Io
    public final int II0xO0() {
        return this.f28465oIX0oI;
    }

    @Override // xIoXXXIXo.I0Io
    public String IIX0o() {
        return "";
    }

    @Override // xIoXXXIXo.I0Io
    public xIoXXXIXo.oxoX XO() {
        return this.f28460II0XooXoX;
    }

    @Override // xIoXXXIXo.I0Io
    public xIoXXXIXo.Oxx0IOOO getType() {
        return xIoXXXIXo.Oxx0IOOO.f34234II0xO0;
    }

    @Override // xIoXXXIXo.I0Io
    public boolean isHidden() {
        oO x0xO2 = this.f28462Oxx0IOOO.x0xO(this.f28461II0xO0);
        if (x0xO2 != null && x0xO2.Xo0() == 0) {
            return true;
        }
        x0xO XI0oooXX2 = this.f28462Oxx0IOOO.XI0oooXX(this.f28465oIX0oI);
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
        return this.f28461II0xO0;
    }

    @Override // jxl.read.biff.OOXIXo
    public void oO(xIoXXXIXo.oxoX oxox) {
        if (this.f28460II0XooXoX != null) {
            f28458xxIXOIIO.ooOOo0oXI("current cell features not null - overwriting");
        }
        this.f28460II0XooXoX = oxox;
    }

    @Override // xIoXXXIXo.I0Io
    public oI0X0.X0o0xo xoIox() {
        if (!this.f28464XO) {
            this.f28459I0Io = this.f28463X0o0xo.xoIox(this.f28466oxoX);
            this.f28464XO = true;
        }
        return this.f28459I0Io;
    }
}
