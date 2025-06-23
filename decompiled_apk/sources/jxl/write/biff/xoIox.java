package jxl.write.biff;

/* loaded from: classes6.dex */
public class xoIox extends OoIXo.OI0 {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f29034X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public byte[] f29035XO;

    public xoIox(int i) {
        super(OoIXo.xII.f2449OX00O0xII);
        this.f29034X0o0xo = i;
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        byte[] bArr = new byte[2];
        OoIXo.oo0xXOI0I.XO(this.f29034X0o0xo, bArr, 0);
        return bArr;
    }
}
