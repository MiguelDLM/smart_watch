package jxl.write.biff;

/* loaded from: classes6.dex */
public class XxX0x0xxx extends OoIXo.OI0 {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public XxIIOXIXx.X0o0xo f28801X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public String f28802XO;

    public XxX0x0xxx(String str) {
        super(OoIXo.xII.f2476XXoOx0);
        this.f28801X0o0xo = XxIIOXIXx.X0o0xo.Oxx0IOOO(XxX0x0xxx.class);
        this.f28802XO = str;
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        byte[] bArr = new byte[(this.f28802XO.length() * 2) + 12];
        bArr[6] = (byte) this.f28802XO.length();
        bArr[7] = 1;
        OoIXo.IO.X0o0xo(this.f28802XO, bArr, 8);
        int length = this.f28802XO.length() * 2;
        bArr[length + 8] = 2;
        bArr[length + 9] = 0;
        bArr[length + 10] = 28;
        bArr[length + 11] = 23;
        return bArr;
    }
}
