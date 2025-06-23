package jxl.biff.formula;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.Stack;

/* loaded from: classes6.dex */
public class Ioxxx extends xII implements o0 {

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f27699oOoXoXO = XxIIOXIXx.X0o0xo.Oxx0IOOO(Ioxxx.class);

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public o00 f27700II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public xIoXXXIXo.O0xOxO f27701OOXIXo;

    /* renamed from: xoIox, reason: collision with root package name */
    public boolean f27702xoIox = false;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f27703xxIXOIIO;

    public Ioxxx(xIoXXXIXo.O0xOxO o0xOxO) {
        this.f27701OOXIXo = o0xOxO;
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
        int i = this.f27703xxIXOIIO;
        OI0[] oi0Arr = new OI0[i];
        for (int i2 = i - 1; i2 >= 0; i2--) {
            oi0Arr[i2] = (OI0) stack.pop();
        }
        for (int i3 = 0; i3 < this.f27703xxIXOIIO; i3++) {
            IXxxXO(oi0Arr[i3]);
        }
    }

    @Override // jxl.biff.formula.xII
    public int OxxIIOOXO() {
        return 3;
    }

    @Override // jxl.biff.formula.OI0
    public void XO(StringBuffer stringBuffer) {
        stringBuffer.append(this.f27700II0XooXoX.X0o0xo(this.f27701OOXIXo));
        stringBuffer.append(HexStringBuilder.COMMENT_BEGIN_CHAR);
        if (this.f27703xxIXOIIO > 0) {
            OI0[] oI0IIXIo2 = oI0IIXIo();
            if (this.f27702xoIox) {
                oI0IIXIo2[0].XO(stringBuffer);
                for (int i = 1; i < this.f27703xxIXOIIO; i++) {
                    stringBuffer.append(',');
                    oI0IIXIo2[i].XO(stringBuffer);
                }
            } else {
                oI0IIXIo2[this.f27703xxIXOIIO - 1].XO(stringBuffer);
                for (int i2 = this.f27703xxIXOIIO - 2; i2 >= 0; i2--) {
                    stringBuffer.append(',');
                    oI0IIXIo2[i2].XO(stringBuffer);
                }
            }
        }
        stringBuffer.append(HexStringBuilder.COMMENT_END_CHAR);
    }

    public final void o00() {
        if (this.f27700II0XooXoX == o00.f27824OxO) {
            OI0[] oI0IIXIo2 = oI0IIXIo();
            for (int length = oI0IIXIo2.length - 1; length >= 0; length--) {
                OI0 oi0 = oI0IIXIo2[length];
                if (oi0 instanceof I0Io) {
                    oi0.oOoXoXO();
                }
            }
        }
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
        o00();
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
        byte[] bArr3 = new byte[bArr.length + 4];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        int length = bArr.length;
        if (!Oo()) {
            II0xO02 = xoxXI.f28018IoOoX.oIX0oI();
        } else {
            II0xO02 = xoxXI.f28018IoOoX.II0xO0();
        }
        bArr3[length] = II0xO02;
        bArr3[bArr.length + 1] = (byte) this.f27703xxIXOIIO;
        OoIXo.oo0xXOI0I.XO(this.f27700II0XooXoX.oIX0oI(), bArr3, bArr.length + 2);
        return bArr3;
    }

    @Override // jxl.biff.formula.o0
    public int read(byte[] bArr, int i) throws FormulaException {
        this.f27703xxIXOIIO = bArr[i];
        int I0Io2 = OoIXo.oo0xXOI0I.I0Io(bArr[i + 1], bArr[i + 2]);
        o00 II0xO02 = o00.II0xO0(I0Io2);
        this.f27700II0XooXoX = II0xO02;
        if (II0xO02 != o00.f27751IIIxO) {
            return 3;
        }
        throw new FormulaException(FormulaException.UNRECOGNIZED_FUNCTION, I0Io2);
    }

    @Override // jxl.biff.formula.OI0
    public void xoIox(int i, int i2, boolean z) {
        for (OI0 oi0 : oI0IIXIo()) {
            oi0.xoIox(i, i2, z);
        }
    }

    public o00 xoXoI() {
        return this.f27700II0XooXoX;
    }

    public Ioxxx(o00 o00Var, int i, xIoXXXIXo.O0xOxO o0xOxO) {
        this.f27700II0XooXoX = o00Var;
        this.f27703xxIXOIIO = i;
        this.f27701OOXIXo = o0xOxO;
    }
}
