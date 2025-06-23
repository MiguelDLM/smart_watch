package jxl.write.biff;

/* loaded from: classes6.dex */
public class xXoOI00O extends OoIXo.OI0 {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public byte[] f29026X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f29027XO;

    public xXoOI00O(int i) {
        super(OoIXo.xII.f2474XX0xXo);
        this.f29027XO = i;
        byte[] bArr = {104, 1, 14, 1, 92, 58, -66, 35, 56, 0, 0, 0, 0, 0, 1, 0, 88, 2};
        this.f29026X0o0xo = bArr;
        OoIXo.oo0xXOI0I.XO(i, bArr, 10);
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        return this.f29026X0o0xo;
    }
}
