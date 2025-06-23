package jxl.write.biff;

/* loaded from: classes6.dex */
public class OxI extends OoIXo.OI0 {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public byte[] f28685X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public double f28686XO;

    public OxI(double d) {
        super(OoIXo.xII.f2495oXIO0o0XI);
        this.f28686XO = d;
        this.f28685X0o0xo = new byte[8];
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        OoIXo.OxI.oIX0oI(this.f28686XO, this.f28685X0o0xo, 0);
        return this.f28685X0o0xo;
    }
}
