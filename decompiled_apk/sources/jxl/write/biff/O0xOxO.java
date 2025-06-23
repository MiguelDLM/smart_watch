package jxl.write.biff;

/* loaded from: classes6.dex */
public class O0xOxO extends OoIXo.OI0 {

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public byte[] f28662Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f28663X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f28664XO;

    public O0xOxO(int i, int i2) {
        super(OoIXo.xII.f2532xxIXOIIO);
        this.f28663X0o0xo = i;
        this.f28664XO = i2;
        byte[] bArr = new byte[14];
        this.f28662Oxx0IOOO = bArr;
        OoIXo.oo0xXOI0I.oIX0oI(i, bArr, 4);
        OoIXo.oo0xXOI0I.XO(this.f28664XO, this.f28662Oxx0IOOO, 10);
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        return this.f28662Oxx0IOOO;
    }
}
