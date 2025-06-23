package jxl.write.biff;

/* loaded from: classes6.dex */
public class X00IoxXI extends OoIXo.OI0 {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public byte[] f28691X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public String f28692XO;

    public X00IoxXI(String str) {
        super(OoIXo.xII.f2494oX);
        this.f28692XO = str;
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        String str = this.f28692XO;
        if (str != null && str.length() != 0) {
            this.f28691X0o0xo = new byte[(this.f28692XO.length() * 2) + 3];
            OoIXo.oo0xXOI0I.XO(this.f28692XO.length(), this.f28691X0o0xo, 0);
            byte[] bArr = this.f28691X0o0xo;
            bArr[2] = 1;
            OoIXo.IO.X0o0xo(this.f28692XO, bArr, 3);
            return this.f28691X0o0xo;
        }
        byte[] bArr2 = new byte[0];
        this.f28691X0o0xo = bArr2;
        return bArr2;
    }

    public X00IoxXI(X00IoxXI x00IoxXI) {
        super(OoIXo.xII.f2494oX);
        this.f28692XO = x00IoxXI.f28692XO;
    }
}
