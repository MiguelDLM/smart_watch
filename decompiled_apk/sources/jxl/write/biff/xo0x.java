package jxl.write.biff;

/* loaded from: classes6.dex */
public abstract class xo0x extends OoIXo.OI0 {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public double f29033X0o0xo;

    public xo0x(OoIXo.xII xii, double d) {
        super(xii);
        this.f29033X0o0xo = d;
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        byte[] bArr = new byte[8];
        OoIXo.OxI.oIX0oI(this.f29033X0o0xo, bArr, 0);
        return bArr;
    }
}
