package jxl.read.biff;

/* loaded from: classes6.dex */
public class II0XooXoX extends OoIXo.Xx000oIo {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static II0xO0 f28150II0XooXoX = new II0xO0();

    /* renamed from: I0Io, reason: collision with root package name */
    public int f28151I0Io;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public String f28152Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public byte f28153X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f28154XO;

    /* renamed from: oxoX, reason: collision with root package name */
    public byte f28155oxoX;

    /* loaded from: classes6.dex */
    public static class II0xO0 {
        public II0xO0() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public II0XooXoX(xoxXI xoxxi, xIoXXXIXo.O0xOxO o0xOxO) {
        super(xoxxi);
        byte[] I0Io2 = oxXx0IX().I0Io();
        this.f28151I0Io = OoIXo.oo0xXOI0I.oxoX(I0Io2[0], I0Io2[1], I0Io2[2], I0Io2[3]);
        this.f28155oxoX = I0Io2[5];
        this.f28153X0o0xo = I0Io2[4];
        int i = I0Io2[6];
        this.f28154XO = i;
        if (I0Io2[7] == 0) {
            byte[] bArr = new byte[i];
            System.arraycopy(I0Io2, 8, bArr, 0, i);
            this.f28152Oxx0IOOO = OoIXo.IO.oxoX(bArr, this.f28154XO, 0, o0xOxO);
        } else {
            byte[] bArr2 = new byte[i * 2];
            System.arraycopy(I0Io2, 8, bArr2, 0, i * 2);
            this.f28152Oxx0IOOO = OoIXo.IO.Oxx0IOOO(bArr2, this.f28154XO, 0);
        }
    }

    public String getName() {
        return this.f28152Oxx0IOOO;
    }

    public boolean isHidden() {
        if (this.f28153X0o0xo != 0) {
            return true;
        }
        return false;
    }

    public boolean xXOx() {
        if (this.f28155oxoX == 0) {
            return true;
        }
        return false;
    }

    public boolean xo0x() {
        if (this.f28155oxoX == 2) {
            return true;
        }
        return false;
    }

    public II0XooXoX(xoxXI xoxxi, II0xO0 iI0xO0) {
        super(xoxxi);
        byte[] I0Io2 = oxXx0IX().I0Io();
        this.f28151I0Io = OoIXo.oo0xXOI0I.oxoX(I0Io2[0], I0Io2[1], I0Io2[2], I0Io2[3]);
        this.f28155oxoX = I0Io2[5];
        this.f28153X0o0xo = I0Io2[4];
        int i = I0Io2[6];
        this.f28154XO = i;
        byte[] bArr = new byte[i];
        System.arraycopy(I0Io2, 7, bArr, 0, i);
        this.f28152Oxx0IOOO = new String(bArr);
    }
}
