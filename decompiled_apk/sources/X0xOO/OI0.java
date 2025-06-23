package X0xOO;

import jxl.read.biff.xoxXI;

/* loaded from: classes6.dex */
public class OI0 extends OoIXo.OI0 {

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f3336Oxx0IOOO = XxIIOXIXx.X0o0xo.Oxx0IOOO(OI0.class);

    /* renamed from: X0o0xo, reason: collision with root package name */
    public byte[] f3337X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f3338XO;

    public OI0(String str) {
        super(OoIXo.xII.f2511x0XOIxOo);
        this.f3338XO = str.length();
    }

    public int XX0() {
        return this.f3338XO;
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        byte[] bArr = this.f3337X0o0xo;
        if (bArr != null) {
            return bArr;
        }
        byte[] bArr2 = new byte[18];
        this.f3337X0o0xo = bArr2;
        OoIXo.oo0xXOI0I.XO(530, bArr2, 0);
        OoIXo.oo0xXOI0I.XO(this.f3338XO, this.f3337X0o0xo, 10);
        OoIXo.oo0xXOI0I.XO(16, this.f3337X0o0xo, 12);
        return this.f3337X0o0xo;
    }

    public OI0(xoxXI xoxxi) {
        super(xoxxi);
        byte[] I0Io2 = oxXx0IX().I0Io();
        this.f3337X0o0xo = I0Io2;
        this.f3338XO = OoIXo.oo0xXOI0I.I0Io(I0Io2[10], I0Io2[11]);
    }

    public OI0(byte[] bArr) {
        super(OoIXo.xII.f2511x0XOIxOo);
        this.f3337X0o0xo = bArr;
    }
}
