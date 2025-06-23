package X0xOO;

import java.io.IOException;

/* loaded from: classes6.dex */
public class II0xO0 extends o00 {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f3299OOXIXo = 61;

    /* renamed from: xoIox, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f3300xoIox = XxIIOXIXx.X0o0xo.Oxx0IOOO(II0xO0.class);

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f3301II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f3302Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public I0Io f3303X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public byte[] f3304XO;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public boolean f3305xxIXOIIO;

    public II0xO0(XI0IXoo xI0IXoo) {
        super(xI0IXoo);
        this.f3303X0o0xo = I0Io.II0xO0(X0o0xo());
        this.f3305xxIXOIIO = false;
        byte[] oIX0oI2 = oIX0oI();
        this.f3301II0XooXoX = OoIXo.oo0xXOI0I.oxoX(oIX0oI2[24], oIX0oI2[25], oIX0oI2[26], oIX0oI2[27]);
    }

    @Override // X0xOO.o00, X0xOO.X0IIOO
    public byte[] II0xO0() {
        if (this.f3305xxIXOIIO) {
            this.f3304XO[0] = (byte) this.f3303X0o0xo.I0Io();
            this.f3304XO[1] = (byte) this.f3303X0o0xo.I0Io();
            OoIXo.oo0xXOI0I.oIX0oI(this.f3302Oxx0IOOO + 25, this.f3304XO, 20);
            OoIXo.oo0xXOI0I.oIX0oI(this.f3301II0XooXoX, this.f3304XO, 24);
            OoIXo.oo0xXOI0I.oIX0oI(0, this.f3304XO, 28);
            byte[] bArr = this.f3304XO;
            bArr[32] = 0;
            bArr[33] = 0;
            bArr[34] = 126;
            bArr[35] = 1;
            bArr[36] = 0;
            bArr[37] = 110;
            OoIXo.oo0xXOI0I.XO(61470, bArr, 38);
            OoIXo.oo0xXOI0I.oIX0oI(this.f3302Oxx0IOOO + 17, this.f3304XO, 40);
        } else {
            this.f3304XO = oIX0oI();
        }
        return OOXIXo(this.f3304XO);
    }

    public int Oo() {
        return this.f3301II0XooXoX;
    }

    public I0Io oO() {
        return this.f3303X0o0xo;
    }

    public void x0XOIxOo() {
        boolean z = true;
        int i = this.f3301II0XooXoX - 1;
        this.f3301II0XooXoX = i;
        if (i < 0) {
            z = false;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
    }

    public byte[] x0xO0oo() {
        byte[] oIX0oI2 = oIX0oI();
        int length = oIX0oI2.length - 61;
        byte[] bArr = new byte[length];
        System.arraycopy(oIX0oI2, 61, bArr, 0, length);
        return bArr;
    }

    public II0xO0(Oxx0xo oxx0xo) throws IOException {
        super(XIxXXX0x0.f3427xoIox);
        this.f3303X0o0xo = I0Io.f3288xoIox;
        ooOOo0oXI(2);
        oOoXoXO(this.f3303X0o0xo.I0Io());
        byte[] XIxXXX0x02 = oxx0xo.XIxXXX0x0();
        int length = XIxXXX0x02.length;
        this.f3302Oxx0IOOO = length;
        byte[] bArr = new byte[length + 61];
        this.f3304XO = bArr;
        System.arraycopy(XIxXXX0x02, 0, bArr, 61, length);
        this.f3301II0XooXoX = oxx0xo.x0XOIxOo();
        this.f3305xxIXOIIO = true;
    }
}
