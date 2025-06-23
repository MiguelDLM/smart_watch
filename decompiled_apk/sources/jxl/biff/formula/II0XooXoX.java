package jxl.biff.formula;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.Stack;

/* loaded from: classes6.dex */
public class II0XooXoX extends xII implements o0 {

    /* renamed from: xoIox, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f27657xoIox = XxIIOXIXx.X0o0xo.Oxx0IOOO(II0XooXoX.class);

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public o00 f27658II0XooXoX;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public xIoXXXIXo.O0xOxO f27659xxIXOIIO;

    public II0XooXoX(xIoXXXIXo.O0xOxO o0xOxO) {
        this.f27659xxIXOIIO = o0xOxO;
    }

    @Override // jxl.biff.formula.OI0
    public void I0Io(int i, int i2, boolean z) {
        for (OI0 oi0 : oI0IIXIo()) {
            oi0.I0Io(i, i2, z);
        }
    }

    @Override // jxl.biff.formula.OI0
    public void II0xO0(int i, int i2, boolean z) {
        for (OI0 oi0 : oI0IIXIo()) {
            oi0.II0xO0(i, i2, z);
        }
    }

    @Override // jxl.biff.formula.OI0
    public void OOXIXo(int i, int i2, boolean z) {
        for (OI0 oi0 : oI0IIXIo()) {
            oi0.OOXIXo(i, i2, z);
        }
    }

    @Override // jxl.biff.formula.OI0
    public void Oxx0IOOO() {
        for (OI0 oi0 : oI0IIXIo()) {
            oi0.Oxx0IOOO();
        }
    }

    @Override // jxl.biff.formula.xII
    public void Oxx0xo(Stack stack) {
        OI0[] oi0Arr = new OI0[this.f27658II0XooXoX.XO()];
        for (int XO2 = this.f27658II0XooXoX.XO() - 1; XO2 >= 0; XO2--) {
            oi0Arr[XO2] = (OI0) stack.pop();
        }
        for (int i = 0; i < this.f27658II0XooXoX.XO(); i++) {
            IXxxXO(oi0Arr[i]);
        }
    }

    @Override // jxl.biff.formula.xII
    public int OxxIIOOXO() {
        return 3;
    }

    @Override // jxl.biff.formula.OI0
    public void XO(StringBuffer stringBuffer) {
        stringBuffer.append(this.f27658II0XooXoX.X0o0xo(this.f27659xxIXOIIO));
        stringBuffer.append(HexStringBuilder.COMMENT_BEGIN_CHAR);
        int XO2 = this.f27658II0XooXoX.XO();
        if (XO2 > 0) {
            OI0[] oI0IIXIo2 = oI0IIXIo();
            oI0IIXIo2[0].XO(stringBuffer);
            for (int i = 1; i < XO2; i++) {
                stringBuffer.append(',');
                oI0IIXIo2[i].XO(stringBuffer);
            }
        }
        stringBuffer.append(HexStringBuilder.COMMENT_END_CHAR);
    }

    @Override // jxl.biff.formula.OI0
    public void oIX0oI(int i, int i2) {
        for (OI0 oi0 : oI0IIXIo()) {
            oi0.oIX0oI(i, i2);
        }
    }

    @Override // jxl.biff.formula.OI0
    public byte[] oxoX() {
        byte II0xO02;
        OI0[] oI0IIXIo2 = oI0IIXIo();
        byte[] bArr = new byte[0];
        int i = 0;
        while (i < oI0IIXIo2.length) {
            byte[] oxoX2 = oI0IIXIo2[i].oxoX();
            byte[] bArr2 = new byte[bArr.length + oxoX2.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            System.arraycopy(oxoX2, 0, bArr2, bArr.length, oxoX2.length);
            i++;
            bArr = bArr2;
        }
        byte[] bArr3 = new byte[bArr.length + 3];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        int length = bArr.length;
        if (!Oo()) {
            II0xO02 = xoxXI.f28039oo.oIX0oI();
        } else {
            II0xO02 = xoxXI.f28039oo.II0xO0();
        }
        bArr3[length] = II0xO02;
        OoIXo.oo0xXOI0I.XO(this.f27658II0XooXoX.oIX0oI(), bArr3, bArr.length + 1);
        return bArr3;
    }

    @Override // jxl.biff.formula.o0
    public int read(byte[] bArr, int i) {
        boolean z = true;
        int I0Io2 = OoIXo.oo0xXOI0I.I0Io(bArr[i], bArr[i + 1]);
        o00 II0xO02 = o00.II0xO0(I0Io2);
        this.f27658II0XooXoX = II0xO02;
        if (II0xO02 == o00.f27751IIIxO) {
            z = false;
        }
        XxIIOXIXx.oIX0oI.II0xO0(z, "function code " + I0Io2);
        return 2;
    }

    @Override // jxl.biff.formula.OI0
    public void xoIox(int i, int i2, boolean z) {
        for (OI0 oi0 : oI0IIXIo()) {
            oi0.xoIox(i, i2, z);
        }
    }

    public II0XooXoX(o00 o00Var, xIoXXXIXo.O0xOxO o0xOxO) {
        this.f27658II0XooXoX = o00Var;
        this.f27659xxIXOIIO = o0xOxO;
    }
}
