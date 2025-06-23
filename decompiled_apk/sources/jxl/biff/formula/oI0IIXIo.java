package jxl.biff.formula;

/* loaded from: classes6.dex */
public class oI0IIXIo extends IO implements o0 {

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public IIXOooo f27983Oxx0IOOO;

    public oI0IIXIo() {
    }

    @Override // jxl.biff.formula.OI0
    public void Oxx0IOOO() {
    }

    @Override // jxl.biff.formula.OI0
    public void XO(StringBuffer stringBuffer) {
        stringBuffer.append(this.f27983Oxx0IOOO.II0xO0());
    }

    @Override // jxl.biff.formula.OI0
    public byte[] oxoX() {
        return new byte[]{xoxXI.f28023Oxx0IOOO.oIX0oI(), (byte) this.f27983Oxx0IOOO.oIX0oI()};
    }

    @Override // jxl.biff.formula.o0
    public int read(byte[] bArr, int i) {
        this.f27983Oxx0IOOO = IIXOooo.I0Io(bArr[i]);
        return 1;
    }

    public oI0IIXIo(String str) {
        this.f27983Oxx0IOOO = IIXOooo.oxoX(str);
    }
}
