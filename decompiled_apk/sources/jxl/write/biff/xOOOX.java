package jxl.write.biff;

/* loaded from: classes6.dex */
public class xOOOX extends OoIXo.OI0 {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f29018X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public byte[] f29019XO;

    public xOOOX(boolean z) {
        super(OoIXo.xII.f2531xxIO);
        this.f29018X0o0xo = z;
        byte[] bArr = new byte[2];
        this.f29019XO = bArr;
        if (z) {
            OoIXo.oo0xXOI0I.XO(1, bArr, 0);
        }
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        return this.f29019XO;
    }
}
