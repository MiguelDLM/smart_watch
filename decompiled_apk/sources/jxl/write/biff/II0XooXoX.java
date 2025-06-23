package jxl.write.biff;

/* loaded from: classes6.dex */
public class II0XooXoX extends OoIXo.OI0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public byte[] f28567II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public String f28568Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f28569X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f28570XO;

    public II0XooXoX(String str) {
        super(OoIXo.xII.f2469XO);
        this.f28568Oxx0IOOO = str;
        this.f28569X0o0xo = false;
        this.f28570XO = false;
    }

    public void I0X0x0oIo() {
        this.f28569X0o0xo = true;
    }

    public void XX0() {
        this.f28570XO = true;
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        byte[] bArr = new byte[(this.f28568Oxx0IOOO.length() * 2) + 8];
        this.f28567II0XooXoX = bArr;
        if (this.f28570XO) {
            bArr[5] = 2;
        } else {
            bArr[5] = 0;
        }
        if (this.f28569X0o0xo) {
            bArr[4] = 1;
            bArr[5] = 0;
        }
        bArr[6] = (byte) this.f28568Oxx0IOOO.length();
        byte[] bArr2 = this.f28567II0XooXoX;
        bArr2[7] = 1;
        OoIXo.IO.X0o0xo(this.f28568Oxx0IOOO, bArr2, 8);
        return this.f28567II0XooXoX;
    }
}
