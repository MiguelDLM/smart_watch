package jxl.biff.formula;

/* loaded from: classes6.dex */
public class XoI0Ixx0 extends IO implements o0 {

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final XxIIOXIXx.X0o0xo f27741xxIXOIIO = XxIIOXIXx.X0o0xo.Oxx0IOOO(XoI0Ixx0.class);

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public xIoXXXIXo.O0xOxO f27742II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public String f27743Oxx0IOOO;

    public XoI0Ixx0(xIoXXXIXo.O0xOxO o0xOxO) {
        this.f27742II0XooXoX = o0xOxO;
    }

    @Override // jxl.biff.formula.OI0
    public void Oxx0IOOO() {
    }

    @Override // jxl.biff.formula.OI0
    public void XO(StringBuffer stringBuffer) {
        stringBuffer.append("\"");
        stringBuffer.append(this.f27743Oxx0IOOO);
        stringBuffer.append("\"");
    }

    @Override // jxl.biff.formula.OI0
    public byte[] oxoX() {
        byte[] bArr = new byte[(this.f27743Oxx0IOOO.length() * 2) + 3];
        bArr[0] = xoxXI.f28031XO.oIX0oI();
        bArr[1] = (byte) this.f27743Oxx0IOOO.length();
        bArr[2] = 1;
        OoIXo.IO.X0o0xo(this.f27743Oxx0IOOO, bArr, 3);
        return bArr;
    }

    @Override // jxl.biff.formula.o0
    public int read(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        if ((bArr[i + 1] & 1) == 0) {
            this.f27743Oxx0IOOO = OoIXo.IO.oxoX(bArr, i2, i + 2, this.f27742II0XooXoX);
        } else {
            this.f27743Oxx0IOOO = OoIXo.IO.Oxx0IOOO(bArr, i2, i + 2);
            i2 *= 2;
        }
        return i2 + 2;
    }

    public XoI0Ixx0(String str) {
        this.f27743Oxx0IOOO = str;
    }
}
