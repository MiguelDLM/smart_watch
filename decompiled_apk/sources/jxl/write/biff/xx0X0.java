package jxl.write.biff;

/* loaded from: classes6.dex */
public class xx0X0 extends OoIXo.OI0 {

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f29045Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public oIX0oI f29046X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f29047XO;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final oIX0oI f29041II0XooXoX = new oIX0oI(0);

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final oIX0oI f29044xxIXOIIO = new oIX0oI(1);

    /* renamed from: xoIox, reason: collision with root package name */
    public static final oIX0oI f29043xoIox = new oIX0oI(2);

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final oIX0oI f29042OOXIXo = new oIX0oI(3);

    /* loaded from: classes6.dex */
    public static class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public int f29048oIX0oI;

        public oIX0oI(int i) {
            this.f29048oIX0oI = i;
        }
    }

    public xx0X0(oIX0oI oix0oi, int i, int i2) {
        super(OoIXo.xII.f2530xx0X0);
        this.f29047XO = i;
        this.f29045Oxx0IOOO = i2;
        this.f29046X0o0xo = oix0oi;
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        byte[] bArr = new byte[15];
        bArr[0] = (byte) this.f29046X0o0xo.f29048oIX0oI;
        OoIXo.oo0xXOI0I.XO(this.f29045Oxx0IOOO, bArr, 1);
        OoIXo.oo0xXOI0I.XO(this.f29047XO, bArr, 3);
        bArr[7] = 1;
        OoIXo.oo0xXOI0I.XO(this.f29045Oxx0IOOO, bArr, 9);
        OoIXo.oo0xXOI0I.XO(this.f29045Oxx0IOOO, bArr, 11);
        int i = this.f29047XO;
        bArr[13] = (byte) i;
        bArr[14] = (byte) i;
        return bArr;
    }
}
