package jxl.write.biff;

/* loaded from: classes6.dex */
public class x0OxxIOxX extends OoIXo.OI0 {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public byte[] f28968X0o0xo;

    public x0OxxIOxX(xIoXXXIXo.xoXoI xoxoi) {
        super(OoIXo.xII.f2485o0xxxXXxX);
        int i;
        if (xoxoi.oo0xXOI0I()) {
            i = 2;
        } else {
            i = 0;
        }
        int i2 = xoxoi.II0XooXoX() ? i | 20 : i | 4;
        int i3 = (xoxoi.x0xO0oo() == 0 && xoxoi.IoOoX() == 0) ? i2 | 160 : i2 | 424;
        i3 = xoxoi.x0o() ? i3 | jxl.read.biff.oIX0oI.f28372XO : i3;
        i3 = xoxoi.IIXOooo() ? i3 | 2048 : i3;
        byte[] bArr = new byte[18];
        this.f28968X0o0xo = bArr;
        OoIXo.oo0xXOI0I.XO(i3, bArr, 0);
        OoIXo.oo0xXOI0I.XO(64, this.f28968X0o0xo, 6);
        OoIXo.oo0xXOI0I.XO(xoxoi.OxxIIOOXO(), this.f28968X0o0xo, 10);
        OoIXo.oo0xXOI0I.XO(xoxoi.Oxx0xo(), this.f28968X0o0xo, 12);
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        return this.f28968X0o0xo;
    }
}
