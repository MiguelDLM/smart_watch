package jxl.write.biff;

/* loaded from: classes6.dex */
public class OIOoIIOIx extends OoIXo.OI0 {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public String f28670X0o0xo;

    public OIOoIIOIx(String str) {
        super(OoIXo.xII.f2481XxX0x0xxx);
        this.f28670X0o0xo = str;
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        byte[] bArr = new byte[(this.f28670X0o0xo.length() * 2) + 3];
        OoIXo.oo0xXOI0I.XO(this.f28670X0o0xo.length(), bArr, 0);
        bArr[2] = 1;
        OoIXo.IO.X0o0xo(this.f28670X0o0xo, bArr, 3);
        return bArr;
    }
}
