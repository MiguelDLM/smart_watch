package jxl.write.biff;

/* loaded from: classes6.dex */
public abstract class XO extends oOoXoXO {

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public boolean f28707x0XOIxOo;

    public XO(int i, int i2, boolean z) {
        super(OoIXo.xII.f2498oo, i, i2);
        this.f28707x0XOIxOo = z;
    }

    @Override // xIoXXXIXo.I0Io
    public String IIX0o() {
        return new Boolean(this.f28707x0XOIxOo).toString();
    }

    public void O00XxXI(boolean z) {
        this.f28707x0XOIxOo = z;
    }

    @Override // xIoXXXIXo.I0Io
    public xIoXXXIXo.Oxx0IOOO getType() {
        return xIoXXXIXo.Oxx0IOOO.f34237X0o0xo;
    }

    public boolean getValue() {
        return this.f28707x0XOIxOo;
    }

    @Override // jxl.write.biff.oOoXoXO, OoIXo.OI0
    public byte[] xo0x() {
        byte[] xo0x2 = super.xo0x();
        byte[] bArr = new byte[xo0x2.length + 2];
        System.arraycopy(xo0x2, 0, bArr, 0, xo0x2.length);
        if (this.f28707x0XOIxOo) {
            bArr[xo0x2.length] = 1;
        }
        return bArr;
    }

    public XO(int i, int i2, boolean z, oI0X0.X0o0xo x0o0xo) {
        super(OoIXo.xII.f2498oo, i, i2, x0o0xo);
        this.f28707x0XOIxOo = z;
    }

    public XO(xIoXXXIXo.oIX0oI oix0oi) {
        super(OoIXo.xII.f2498oo, oix0oi);
        this.f28707x0XOIxOo = oix0oi.getValue();
    }

    public XO(int i, int i2, XO xo2) {
        super(OoIXo.xII.f2498oo, i, i2, xo2);
        this.f28707x0XOIxOo = xo2.f28707x0XOIxOo;
    }
}
