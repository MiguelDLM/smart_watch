package jxl.biff.formula;

import java.util.Stack;

/* loaded from: classes6.dex */
public abstract class XO extends xII implements o0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final XxIIOXIXx.X0o0xo f27729II0XooXoX = XxIIOXIXx.X0o0xo.Oxx0IOOO(XO.class);

    @Override // jxl.biff.formula.OI0
    public void I0Io(int i, int i2, boolean z) {
        OI0[] oI0IIXIo2 = oI0IIXIo();
        oI0IIXIo2[1].I0Io(i, i2, z);
        oI0IIXIo2[0].I0Io(i, i2, z);
    }

    @Override // jxl.biff.formula.OI0
    public void II0xO0(int i, int i2, boolean z) {
        OI0[] oI0IIXIo2 = oI0IIXIo();
        oI0IIXIo2[1].II0xO0(i, i2, z);
        oI0IIXIo2[0].II0xO0(i, i2, z);
    }

    @Override // jxl.biff.formula.OI0
    public void OOXIXo(int i, int i2, boolean z) {
        OI0[] oI0IIXIo2 = oI0IIXIo();
        oI0IIXIo2[1].OOXIXo(i, i2, z);
        oI0IIXIo2[0].OOXIXo(i, i2, z);
    }

    @Override // jxl.biff.formula.OI0
    public void Oxx0IOOO() {
        OI0[] oI0IIXIo2 = oI0IIXIo();
        oI0IIXIo2[0].Oxx0IOOO();
        oI0IIXIo2[1].Oxx0IOOO();
    }

    @Override // jxl.biff.formula.xII
    public void Oxx0xo(Stack stack) {
        OI0 oi0 = (OI0) stack.pop();
        OI0 oi02 = (OI0) stack.pop();
        IXxxXO(oi0);
        IXxxXO(oi02);
    }

    @Override // jxl.biff.formula.OI0
    public void XO(StringBuffer stringBuffer) {
        OI0[] oI0IIXIo2 = oI0IIXIo();
        oI0IIXIo2[1].XO(stringBuffer);
        stringBuffer.append(xoXoI());
        oI0IIXIo2[0].XO(stringBuffer);
    }

    public abstract xoxXI o00();

    @Override // jxl.biff.formula.OI0
    public void oIX0oI(int i, int i2) {
        OI0[] oI0IIXIo2 = oI0IIXIo();
        oI0IIXIo2[1].oIX0oI(i, i2);
        oI0IIXIo2[0].oIX0oI(i, i2);
    }

    @Override // jxl.biff.formula.OI0
    public byte[] oxoX() {
        OI0[] oI0IIXIo2 = oI0IIXIo();
        byte[] bArr = new byte[0];
        int length = oI0IIXIo2.length - 1;
        while (length >= 0) {
            byte[] oxoX2 = oI0IIXIo2[length].oxoX();
            byte[] bArr2 = new byte[bArr.length + oxoX2.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            System.arraycopy(oxoX2, 0, bArr2, bArr.length, oxoX2.length);
            length--;
            bArr = bArr2;
        }
        byte[] bArr3 = new byte[bArr.length + 1];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        bArr3[bArr.length] = o00().oIX0oI();
        return bArr3;
    }

    @Override // jxl.biff.formula.o0
    public int read(byte[] bArr, int i) {
        return 0;
    }

    @Override // jxl.biff.formula.OI0
    public void xoIox(int i, int i2, boolean z) {
        OI0[] oI0IIXIo2 = oI0IIXIo();
        oI0IIXIo2[1].xoIox(i, i2, z);
        oI0IIXIo2[0].xoIox(i, i2, z);
    }

    public abstract String xoXoI();
}
