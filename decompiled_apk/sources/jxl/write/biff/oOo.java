package jxl.write.biff;

/* loaded from: classes6.dex */
public class oOo extends OoIXo.OI0 {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f28849X0o0xo;

    public oOo(int i) {
        super(OoIXo.xII.f2427IXO);
        this.f28849X0o0xo = i;
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        byte[] bArr = new byte[4];
        OoIXo.oo0xXOI0I.XO(this.f28849X0o0xo, bArr, 0);
        OoIXo.oo0xXOI0I.XO(100, bArr, 2);
        return bArr;
    }
}
