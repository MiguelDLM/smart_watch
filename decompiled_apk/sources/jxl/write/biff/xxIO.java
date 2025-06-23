package jxl.write.biff;

/* loaded from: classes6.dex */
public class xxIO extends OoIXo.OI0 {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public byte[] f29049X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f29050XO;

    public xxIO(boolean z) {
        super(OoIXo.xII.f2445OO);
        this.f29050XO = z;
        byte[] bArr = new byte[2];
        this.f29049X0o0xo = bArr;
        if (z) {
            bArr[0] = 1;
        }
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        return this.f29049X0o0xo;
    }
}
