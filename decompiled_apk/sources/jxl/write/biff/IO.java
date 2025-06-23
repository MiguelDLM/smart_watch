package jxl.write.biff;

/* loaded from: classes6.dex */
public class IO extends OoIXo.OI0 {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f28597X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public byte[] f28598XO;

    public IO(int i) {
        super(OoIXo.xII.f2503ox);
        this.f28597X0o0xo = i;
        byte[] bArr = new byte[2];
        this.f28598XO = bArr;
        OoIXo.oo0xXOI0I.XO(i, bArr, 0);
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        return this.f28598XO;
    }
}
