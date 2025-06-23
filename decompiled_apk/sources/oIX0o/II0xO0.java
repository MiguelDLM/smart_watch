package oIX0o;

import org.apache.log4j.o00;

/* loaded from: classes6.dex */
public class II0xO0 extends o00 {

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final String f31620Oxx0xo = "RollOver";

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final String f31621oI0IIXIo = "OK";

    /* renamed from: IXxxXO, reason: collision with root package name */
    public oxoX f31622IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public int f31623Oo = 0;

    public void I0X0x0oIo(int i) {
        this.f31623Oo = i;
    }

    public int XX0() {
        return this.f31623Oo;
    }

    @Override // org.apache.log4j.OOXIXo, org.apache.log4j.X0IIOO, org.apache.log4j.II0xO0, org.apache.log4j.spi.OOXIXo
    public void oI0IIXIo() {
        super.oI0IIXIo();
        if (this.f31623Oo != 0) {
            oxoX oxox = this.f31622IXxxXO;
            if (oxox != null) {
                oxox.interrupt();
            }
            oxoX oxox2 = new oxoX(this, this.f31623Oo);
            this.f31622IXxxXO = oxox2;
            oxox2.setDaemon(true);
            this.f31622IXxxXO.start();
        }
    }
}
