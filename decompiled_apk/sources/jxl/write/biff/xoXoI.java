package jxl.write.biff;

/* loaded from: classes6.dex */
public class xoXoI extends OoIXo.OI0 {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f29038X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public byte[] f29039XO;

    public xoXoI(int i) {
        super(OoIXo.xII.f2517xII);
        this.f29038X0o0xo = i;
        byte[] bArr = new byte[2];
        this.f29039XO = bArr;
        OoIXo.oo0xXOI0I.XO(i, bArr, 0);
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        return this.f29039XO;
    }
}
