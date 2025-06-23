package jxl.write.biff;

/* loaded from: classes6.dex */
public class Xx000oIo extends OoIXo.OI0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f28796II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f28797Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public byte[] f28798X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f28799XO;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f28800xxIXOIIO;

    public Xx000oIo() {
        super(OoIXo.xII.f2526xoIxX);
    }

    public int I0X0x0oIo() {
        return this.f28796II0XooXoX;
    }

    public int XX0() {
        return this.f28800xxIXOIIO;
    }

    public void Xo0(int i) {
        this.f28796II0XooXoX = i;
        this.f28799XO = (i * 14) + 1;
    }

    public void oX(int i) {
        this.f28800xxIXOIIO = i;
        this.f28797Oxx0IOOO = (i * 14) + 1;
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        byte[] bArr = new byte[8];
        this.f28798X0o0xo = bArr;
        OoIXo.oo0xXOI0I.XO(this.f28799XO, bArr, 0);
        OoIXo.oo0xXOI0I.XO(this.f28797Oxx0IOOO, this.f28798X0o0xo, 2);
        OoIXo.oo0xXOI0I.XO(this.f28796II0XooXoX, this.f28798X0o0xo, 4);
        OoIXo.oo0xXOI0I.XO(this.f28800xxIXOIIO, this.f28798X0o0xo, 6);
        return this.f28798X0o0xo;
    }
}
