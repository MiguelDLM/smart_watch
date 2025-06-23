package jxl.biff.formula;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.Stack;

/* loaded from: classes6.dex */
public class x0o extends xII implements o0 {
    @Override // jxl.biff.formula.OI0
    public void I0Io(int i, int i2, boolean z) {
        oI0IIXIo()[0].I0Io(i, i2, z);
    }

    @Override // jxl.biff.formula.OI0
    public void II0xO0(int i, int i2, boolean z) {
        oI0IIXIo()[0].II0xO0(i, i2, z);
    }

    @Override // jxl.biff.formula.OI0
    public void OOXIXo(int i, int i2, boolean z) {
        oI0IIXIo()[0].OOXIXo(i, i2, z);
    }

    @Override // jxl.biff.formula.OI0
    public void Oxx0IOOO() {
        oI0IIXIo()[0].Oxx0IOOO();
    }

    @Override // jxl.biff.formula.xII
    public void Oxx0xo(Stack stack) {
        IXxxXO((OI0) stack.pop());
    }

    @Override // jxl.biff.formula.xII
    public int OxxIIOOXO() {
        return 4;
    }

    @Override // jxl.biff.formula.OI0
    public void XO(StringBuffer stringBuffer) {
        OI0[] oI0IIXIo2 = oI0IIXIo();
        stringBuffer.append(HexStringBuilder.COMMENT_BEGIN_CHAR);
        oI0IIXIo2[0].XO(stringBuffer);
        stringBuffer.append(HexStringBuilder.COMMENT_END_CHAR);
    }

    @Override // jxl.biff.formula.OI0
    public void oIX0oI(int i, int i2) {
        oI0IIXIo()[0].oIX0oI(i, i2);
    }

    @Override // jxl.biff.formula.OI0
    public byte[] oxoX() {
        byte[] oxoX2 = oI0IIXIo()[0].oxoX();
        byte[] bArr = new byte[oxoX2.length + 1];
        System.arraycopy(oxoX2, 0, bArr, 0, oxoX2.length);
        bArr[oxoX2.length] = xoXoI().oIX0oI();
        return bArr;
    }

    @Override // jxl.biff.formula.o0
    public int read(byte[] bArr, int i) {
        return 0;
    }

    @Override // jxl.biff.formula.OI0
    public void xoIox(int i, int i2, boolean z) {
        oI0IIXIo()[0].xoIox(i, i2, z);
    }

    public xoxXI xoXoI() {
        return xoxXI.f28016IIXOooo;
    }
}
