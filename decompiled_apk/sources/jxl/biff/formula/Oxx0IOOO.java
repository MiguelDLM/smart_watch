package jxl.biff.formula;

/* loaded from: classes6.dex */
public class Oxx0IOOO extends IO implements o0 {

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public boolean f27716Oxx0IOOO;

    public Oxx0IOOO() {
    }

    @Override // jxl.biff.formula.OI0
    public void Oxx0IOOO() {
    }

    @Override // jxl.biff.formula.OI0
    public void XO(StringBuffer stringBuffer) {
        stringBuffer.append(new Boolean(this.f27716Oxx0IOOO).toString());
    }

    @Override // jxl.biff.formula.OI0
    public byte[] oxoX() {
        int i;
        byte oIX0oI2 = xoxXI.f28013II0XooXoX.oIX0oI();
        if (this.f27716Oxx0IOOO) {
            i = 1;
        } else {
            i = 0;
        }
        return new byte[]{oIX0oI2, (byte) i};
    }

    @Override // jxl.biff.formula.o0
    public int read(byte[] bArr, int i) {
        boolean z;
        if (bArr[i] == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f27716Oxx0IOOO = z;
        return 1;
    }

    public Oxx0IOOO(String str) {
        this.f27716Oxx0IOOO = Boolean.valueOf(str).booleanValue();
    }
}
