package jxl.write.biff;

/* loaded from: classes6.dex */
public class IXxxXO extends OoIXo.OI0 {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f28622X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f28623XO;

    public IXxxXO(OoIXo.IXxxXO iXxxXO, OoIXo.IXxxXO iXxxXO2) {
        super(OoIXo.xII.f2505oxXx0IX);
        this.f28622X0o0xo = iXxxXO.oxoX();
        this.f28623XO = iXxxXO2.oxoX();
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        byte[] bArr = new byte[4];
        OoIXo.oo0xXOI0I.XO(this.f28622X0o0xo, bArr, 0);
        OoIXo.oo0xXOI0I.XO(this.f28623XO, bArr, 2);
        return bArr;
    }

    public IXxxXO(jxl.read.biff.IXxxXO iXxxXO) {
        super(OoIXo.xII.f2505oxXx0IX);
        this.f28622X0o0xo = iXxxXO.xo0x();
        this.f28623XO = iXxxXO.xXOx();
    }
}
