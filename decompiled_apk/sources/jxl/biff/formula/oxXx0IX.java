package jxl.biff.formula;

/* loaded from: classes6.dex */
public class oxXx0IX extends XO implements o0 {
    @Override // jxl.biff.formula.xII
    public int OxxIIOOXO() {
        return 1;
    }

    @Override // jxl.biff.formula.XO
    public xoxXI o00() {
        return xoxXI.f28040oo0xXOI0I;
    }

    @Override // jxl.biff.formula.XO, jxl.biff.formula.OI0
    public byte[] oxoX() {
        x0xO0oo();
        IIXOooo();
        byte[] oxoX2 = super.oxoX();
        byte[] bArr = new byte[oxoX2.length + 3];
        System.arraycopy(oxoX2, 0, bArr, 3, oxoX2.length);
        bArr[0] = xoxXI.f28032Xx000oIo.oIX0oI();
        OoIXo.oo0xXOI0I.XO(oxoX2.length, bArr, 1);
        return bArr;
    }

    @Override // jxl.biff.formula.XO
    public String xoXoI() {
        return ":";
    }
}
