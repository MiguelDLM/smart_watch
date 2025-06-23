package jxl.write.biff;

/* loaded from: classes6.dex */
public class OOXIXo extends OoIXo.OI0 {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public oIX0oI f28680X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public static oIX0oI f28679XO = new oIX0oI(0);

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static oIX0oI f28678Oxx0IOOO = new oIX0oI(1);

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static oIX0oI f28677II0XooXoX = new oIX0oI(-1);

    /* loaded from: classes6.dex */
    public static class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public int f28681oIX0oI;

        public oIX0oI(int i) {
            this.f28681oIX0oI = i;
        }
    }

    public OOXIXo(oIX0oI oix0oi) {
        super(OoIXo.xII.f2527xoO0xx0);
        this.f28680X0o0xo = oix0oi;
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        byte[] bArr = new byte[2];
        OoIXo.oo0xXOI0I.XO(this.f28680X0o0xo.f28681oIX0oI, bArr, 0);
        return bArr;
    }
}
