package jxl.biff.formula;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.Stack;

/* loaded from: classes6.dex */
public class X0o0xo extends xII implements o0 {

    /* renamed from: oO, reason: collision with root package name */
    public static final int f27717oO = 4;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f27718oOoXoXO = XxIIOXIXx.X0o0xo.Oxx0IOOO(X0o0xo.class);

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f27719ooOOo0oXI = 16;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f27720x0XOIxOo = 2;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f27721x0xO0oo = 8;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f27722II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public Ioxxx f27723OOXIXo;

    /* renamed from: xoIox, reason: collision with root package name */
    public xIoXXXIXo.O0xOxO f27724xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f27725xxIXOIIO;

    public X0o0xo(xIoXXXIXo.O0xOxO o0xOxO) {
        this.f27724xoIox = o0xOxO;
    }

    @Override // jxl.biff.formula.OI0
    public void I0Io(int i, int i2, boolean z) {
        OI0[] oI0IIXIo2;
        if (X0IIOO()) {
            oI0IIXIo2 = this.f27723OOXIXo.oI0IIXIo();
        } else {
            oI0IIXIo2 = oI0IIXIo();
        }
        for (OI0 oi0 : oI0IIXIo2) {
            oi0.I0Io(i, i2, z);
        }
    }

    @Override // jxl.biff.formula.OI0
    public void II0xO0(int i, int i2, boolean z) {
        OI0[] oI0IIXIo2;
        if (X0IIOO()) {
            oI0IIXIo2 = this.f27723OOXIXo.oI0IIXIo();
        } else {
            oI0IIXIo2 = oI0IIXIo();
        }
        for (OI0 oi0 : oI0IIXIo2) {
            oi0.II0xO0(i, i2, z);
        }
    }

    public boolean O0xOxO() {
        if ((this.f27722II0XooXoX & 8) != 0) {
            return true;
        }
        return false;
    }

    @Override // jxl.biff.formula.OI0
    public void OOXIXo(int i, int i2, boolean z) {
        OI0[] oI0IIXIo2;
        if (X0IIOO()) {
            oI0IIXIo2 = this.f27723OOXIXo.oI0IIXIo();
        } else {
            oI0IIXIo2 = oI0IIXIo();
        }
        for (OI0 oi0 : oI0IIXIo2) {
            oi0.OOXIXo(i, i2, z);
        }
    }

    public boolean OxI() {
        if ((this.f27722II0XooXoX & 18) != 0) {
            return true;
        }
        return false;
    }

    @Override // jxl.biff.formula.OI0
    public void Oxx0IOOO() {
        OI0[] oI0IIXIo2;
        if (X0IIOO()) {
            oI0IIXIo2 = this.f27723OOXIXo.oI0IIXIo();
        } else {
            oI0IIXIo2 = oI0IIXIo();
        }
        for (OI0 oi0 : oI0IIXIo2) {
            oi0.Oxx0IOOO();
        }
    }

    @Override // jxl.biff.formula.xII
    public void Oxx0xo(Stack stack) {
        int i = this.f27722II0XooXoX;
        if ((i & 16) != 0) {
            IXxxXO((OI0) stack.pop());
        } else if ((i & 2) != 0) {
            IXxxXO((OI0) stack.pop());
        }
    }

    @Override // jxl.biff.formula.xII
    public int OxxIIOOXO() {
        return 3;
    }

    public boolean X0IIOO() {
        if ((this.f27722II0XooXoX & 2) != 0) {
            return true;
        }
        return false;
    }

    public boolean XI0IXoo() {
        if ((this.f27722II0XooXoX & 16) != 0) {
            return true;
        }
        return false;
    }

    public void XIxXXX0x0(Ioxxx ioxxx) {
        this.f27723OOXIXo = ioxxx;
        this.f27722II0XooXoX |= 2;
    }

    @Override // jxl.biff.formula.OI0
    public void XO(StringBuffer stringBuffer) {
        int i = this.f27722II0XooXoX;
        if ((i & 16) != 0) {
            OI0[] oI0IIXIo2 = oI0IIXIo();
            stringBuffer.append(o00.f27962xoIox.X0o0xo(this.f27724xoIox));
            stringBuffer.append(HexStringBuilder.COMMENT_BEGIN_CHAR);
            oI0IIXIo2[0].XO(stringBuffer);
            stringBuffer.append(HexStringBuilder.COMMENT_END_CHAR);
            return;
        }
        if ((i & 2) != 0) {
            stringBuffer.append(o00.f27979xxxoo0XI.X0o0xo(this.f27724xoIox));
            stringBuffer.append(HexStringBuilder.COMMENT_BEGIN_CHAR);
            OI0[] oI0IIXIo3 = this.f27723OOXIXo.oI0IIXIo();
            for (int i2 = 0; i2 < oI0IIXIo3.length - 1; i2++) {
                oI0IIXIo3[i2].XO(stringBuffer);
                stringBuffer.append(',');
            }
            oI0IIXIo3[oI0IIXIo3.length - 1].XO(stringBuffer);
            stringBuffer.append(HexStringBuilder.COMMENT_END_CHAR);
        }
    }

    public boolean o00() {
        if ((this.f27722II0XooXoX & 4) != 0) {
            return true;
        }
        return false;
    }

    @Override // jxl.biff.formula.OI0
    public void oIX0oI(int i, int i2) {
        OI0[] oI0IIXIo2;
        if (X0IIOO()) {
            oI0IIXIo2 = this.f27723OOXIXo.oI0IIXIo();
        } else {
            oI0IIXIo2 = oI0IIXIo();
        }
        for (OI0 oi0 : oI0IIXIo2) {
            oi0.oIX0oI(i, i2);
        }
    }

    @Override // jxl.biff.formula.OI0
    public byte[] oxoX() {
        byte[] bArr = new byte[0];
        if (XI0IXoo()) {
            OI0[] oI0IIXIo2 = oI0IIXIo();
            int length = oI0IIXIo2.length - 1;
            while (length >= 0) {
                byte[] oxoX2 = oI0IIXIo2[length].oxoX();
                byte[] bArr2 = new byte[bArr.length + oxoX2.length];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                System.arraycopy(oxoX2, 0, bArr2, bArr.length, oxoX2.length);
                length--;
                bArr = bArr2;
            }
            byte[] bArr3 = new byte[bArr.length + 4];
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            bArr3[bArr.length] = xoxXI.f28037oOXoIIIo.oIX0oI();
            bArr3[bArr.length + 1] = 16;
            return bArr3;
        }
        if (X0IIOO()) {
            return xoXoI();
        }
        return bArr;
    }

    @Override // jxl.biff.formula.o0
    public int read(byte[] bArr, int i) {
        this.f27722II0XooXoX = bArr[i];
        this.f27725xxIXOIIO = OoIXo.oo0xXOI0I.I0Io(bArr[i + 1], bArr[i + 2]);
        if (!o00()) {
            return 3;
        }
        return ((this.f27725xxIXOIIO + 1) * 2) + 3;
    }

    @Override // jxl.biff.formula.OI0
    public void xoIox(int i, int i2, boolean z) {
        OI0[] oI0IIXIo2;
        if (X0IIOO()) {
            oI0IIXIo2 = this.f27723OOXIXo.oI0IIXIo();
        } else {
            oI0IIXIo2 = oI0IIXIo();
        }
        for (OI0 oi0 : oI0IIXIo2) {
            oi0.xoIox(i, i2, z);
        }
    }

    public final byte[] xoXoI() {
        OI0[] oI0IIXIo2 = this.f27723OOXIXo.oI0IIXIo();
        int length = oI0IIXIo2.length;
        byte[] oxoX2 = oI0IIXIo2[0].oxoX();
        int length2 = oxoX2.length;
        int length3 = oxoX2.length + 4;
        byte[] bArr = new byte[length3];
        System.arraycopy(oxoX2, 0, bArr, 0, oxoX2.length);
        xoxXI xoxxi = xoxXI.f28037oOXoIIIo;
        bArr[length2] = xoxxi.oIX0oI();
        bArr[length2 + 1] = 2;
        int i = length2 + 2;
        byte[] oxoX3 = oI0IIXIo2[1].oxoX();
        int length4 = oxoX3.length + length3;
        byte[] bArr2 = new byte[length4];
        System.arraycopy(bArr, 0, bArr2, 0, length3);
        System.arraycopy(oxoX3, 0, bArr2, length3, oxoX3.length);
        int i2 = length4 + 4;
        byte[] bArr3 = new byte[i2];
        System.arraycopy(bArr2, 0, bArr3, 0, length4);
        bArr3[length4] = xoxxi.oIX0oI();
        bArr3[length4 + 1] = 8;
        int i3 = length4 + 2;
        if (length > 2) {
            OoIXo.oo0xXOI0I.XO((i2 - i) - 2, bArr3, i);
            byte[] oxoX4 = oI0IIXIo2[length - 1].oxoX();
            int length5 = oxoX4.length + i2;
            byte[] bArr4 = new byte[length5];
            System.arraycopy(bArr3, 0, bArr4, 0, i2);
            System.arraycopy(oxoX4, 0, bArr4, i2, oxoX4.length);
            bArr3 = new byte[length5 + 4];
            System.arraycopy(bArr4, 0, bArr3, 0, length5);
            bArr3[length5] = xoxxi.oIX0oI();
            bArr3[length5 + 1] = 8;
            bArr3[length5 + 2] = 3;
        }
        int length6 = bArr3.length;
        int length7 = bArr3.length;
        byte[] bArr5 = new byte[length7 + 4];
        System.arraycopy(bArr3, 0, bArr5, 0, bArr3.length);
        bArr5[length6] = xoxXI.f28018IoOoX.oIX0oI();
        bArr5[length6 + 1] = (byte) length;
        bArr5[length6 + 2] = 1;
        bArr5[length6 + 3] = 0;
        int i4 = length7 + 3;
        if (length < 3) {
            OoIXo.oo0xXOI0I.XO((i4 - i) - 5, bArr5, i);
        }
        OoIXo.oo0xXOI0I.XO((i4 - i3) - 2, bArr5, i3);
        return bArr5;
    }

    public X0o0xo(I0X0x0oIo i0X0x0oIo, xIoXXXIXo.O0xOxO o0xOxO) {
        this.f27724xoIox = o0xOxO;
        if (i0X0x0oIo.IXxxXO(o0xOxO) == o00.f27962xoIox) {
            this.f27722II0XooXoX |= 16;
        } else if (i0X0x0oIo.IXxxXO(this.f27724xoIox) == o00.f27979xxxoo0XI) {
            this.f27722II0XooXoX |= 2;
        }
    }
}
