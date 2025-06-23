package jxl.write.biff;

/* loaded from: classes6.dex */
public class x0 extends OoIXo.OI0 {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f28966X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public byte[] f28967XO;

    public x0(boolean z) {
        super(OoIXo.xII.f2513x0xO);
        this.f28966X0o0xo = z;
        byte[] bArr = new byte[2];
        this.f28967XO = bArr;
        if (z) {
            OoIXo.oo0xXOI0I.XO(1, bArr, 0);
        }
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        return this.f28967XO;
    }
}
