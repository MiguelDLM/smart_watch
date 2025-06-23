package jxl.write.biff;

/* loaded from: classes6.dex */
public class xI extends OoIXo.OI0 {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public byte[] f28999X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public String f29000XO;

    public xI(String str) {
        super(OoIXo.xII.f2477Xo0);
        this.f29000XO = str;
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        String str = this.f29000XO;
        if (str != null && str.length() != 0) {
            this.f28999X0o0xo = new byte[(this.f29000XO.length() * 2) + 3];
            OoIXo.oo0xXOI0I.XO(this.f29000XO.length(), this.f28999X0o0xo, 0);
            byte[] bArr = this.f28999X0o0xo;
            bArr[2] = 1;
            OoIXo.IO.X0o0xo(this.f29000XO, bArr, 3);
            return this.f28999X0o0xo;
        }
        byte[] bArr2 = new byte[0];
        this.f28999X0o0xo = bArr2;
        return bArr2;
    }

    public xI(xI xIVar) {
        super(OoIXo.xII.f2477Xo0);
        this.f29000XO = xIVar.f29000XO;
    }
}
