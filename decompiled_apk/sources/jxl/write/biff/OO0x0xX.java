package jxl.write.biff;

/* loaded from: classes6.dex */
public class OO0x0xX extends OoIXo.OI0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f28671II0XooXoX = 2;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final int f28672Oxx0IOOO = 3;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f28673xoIox = 0;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f28674xxIXOIIO = 1;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f28675X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f28676XO;

    public OO0x0xX(int i, int i2) {
        super(OoIXo.xII.f2486oI);
        this.f28675X0o0xo = i2;
        this.f28676XO = i;
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        byte[] bArr = new byte[10];
        int i = 0;
        OoIXo.oo0xXOI0I.XO(this.f28676XO, bArr, 0);
        OoIXo.oo0xXOI0I.XO(this.f28675X0o0xo, bArr, 2);
        int i2 = this.f28675X0o0xo;
        if (i2 > 0) {
            OoIXo.oo0xXOI0I.XO(i2, bArr, 4);
        }
        int i3 = this.f28676XO;
        if (i3 > 0) {
            OoIXo.oo0xXOI0I.XO(i3, bArr, 6);
        }
        int i4 = this.f28675X0o0xo;
        if (i4 > 0 && this.f28676XO == 0) {
            i = 2;
        } else if (i4 == 0 && this.f28676XO > 0) {
            i = 1;
        } else if (i4 <= 0 || this.f28676XO <= 0) {
            i = 3;
        }
        OoIXo.oo0xXOI0I.XO(i, bArr, 8);
        return bArr;
    }
}
