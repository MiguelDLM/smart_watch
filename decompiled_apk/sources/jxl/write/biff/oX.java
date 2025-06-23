package jxl.write.biff;

import java.util.List;

/* loaded from: classes6.dex */
public class oX extends OoIXo.OI0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int[] f28860II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f28861Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f28862X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f28863XO;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int[] f28864xxIXOIIO;

    public oX(List list) {
        super(OoIXo.xII.f2450Oo);
        this.f28862X0o0xo = ((oIXoXx0.x0XOIxOo) list.get(0)).II0xO0();
        this.f28863XO = ((oIXoXx0.x0XOIxOo) list.get(0)).oIX0oI();
        this.f28861Oxx0IOOO = (r1 + list.size()) - 1;
        this.f28860II0XooXoX = new int[list.size()];
        this.f28864xxIXOIIO = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.f28860II0XooXoX[i] = (int) ((oIXoXx0.x0XOIxOo) list.get(i)).getValue();
            this.f28864xxIXOIIO[i] = ((oOoXoXO) list.get(i)).xoxXI();
        }
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        byte[] bArr = new byte[(this.f28860II0XooXoX.length * 6) + 6];
        OoIXo.oo0xXOI0I.XO(this.f28862X0o0xo, bArr, 0);
        OoIXo.oo0xXOI0I.XO(this.f28863XO, bArr, 2);
        int i = 4;
        for (int i2 = 0; i2 < this.f28860II0XooXoX.length; i2++) {
            OoIXo.oo0xXOI0I.XO(this.f28864xxIXOIIO[i2], bArr, i);
            OoIXo.oo0xXOI0I.oIX0oI((this.f28860II0XooXoX[i2] << 2) | 2, bArr, i + 2);
            i += 6;
        }
        OoIXo.oo0xXOI0I.XO(this.f28861Oxx0IOOO, bArr, i);
        return bArr;
    }
}
