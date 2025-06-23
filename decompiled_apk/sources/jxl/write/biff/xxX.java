package jxl.write.biff;

/* loaded from: classes6.dex */
public class xxX extends OoIXo.OI0 {

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f29052xxIXOIIO = 8;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f29053II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int[] f29054Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f29055X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int[] f29056XO;

    public xxX(int i) {
        super(OoIXo.xII.f2422IIXOooo);
        this.f29053II0XooXoX = 0;
        this.f29055X0o0xo = i;
        int I0X0x0oIo2 = I0X0x0oIo();
        this.f29056XO = new int[I0X0x0oIo2];
        this.f29054Oxx0IOOO = new int[I0X0x0oIo2];
        this.f29053II0XooXoX = 0;
    }

    public int I0X0x0oIo() {
        int oX2 = oX();
        if (oX2 != 0) {
            return ((this.f29055X0o0xo + oX2) - 1) / oX2;
        }
        return 0;
    }

    public void XX0(int i, int i2) {
        int[] iArr = this.f29056XO;
        int i3 = this.f29053II0XooXoX;
        iArr[i3] = i + i2;
        this.f29054Oxx0IOOO[i3] = i2;
        this.f29053II0XooXoX = i3 + 1;
    }

    public int oX() {
        return (this.f29055X0o0xo + 127) / 128;
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        int I0X0x0oIo2 = I0X0x0oIo();
        byte[] bArr = new byte[(I0X0x0oIo2 * 8) + 2];
        OoIXo.oo0xXOI0I.XO(oX(), bArr, 0);
        for (int i = 0; i < I0X0x0oIo2; i++) {
            int i2 = i * 8;
            OoIXo.oo0xXOI0I.oIX0oI(this.f29056XO[i], bArr, i2 + 2);
            OoIXo.oo0xXOI0I.XO(this.f29054Oxx0IOOO[i], bArr, i2 + 6);
        }
        return bArr;
    }
}
