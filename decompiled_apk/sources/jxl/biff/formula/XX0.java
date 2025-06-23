package jxl.biff.formula;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/* loaded from: classes6.dex */
public class XX0 implements XX {

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f27732xxIXOIIO = XxIIOXIXx.X0o0xo.Oxx0IOOO(XX0.class);

    /* renamed from: I0Io, reason: collision with root package name */
    public OI0 f27733I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public XOxIOxOx f27734II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f27735II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public OoIXo.x0o f27736Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public xIoXXXIXo.O0xOxO f27737X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public OxxIIOOXO f27738XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public String f27739oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public Stack f27740oxoX;

    public XX0(String str, OxxIIOOXO oxxIIOOXO, OoIXo.x0o x0oVar, xIoXXXIXo.O0xOxO o0xOxO, XOxIOxOx xOxIOxOx) {
        this.f27739oIX0oI = str;
        this.f27737X0o0xo = o0xOxO;
        this.f27738XO = oxxIIOOXO;
        this.f27736Oxx0IOOO = x0oVar;
        this.f27734II0XooXoX = xOxIOxOx;
    }

    @Override // jxl.biff.formula.XX
    public byte[] I0Io() {
        byte[] oxoX2 = this.f27733I0Io.oxoX();
        if (this.f27733I0Io.xxIXOIIO()) {
            byte[] bArr = new byte[oxoX2.length + 4];
            System.arraycopy(oxoX2, 0, bArr, 4, oxoX2.length);
            bArr[0] = xoxXI.f28037oOXoIIIo.oIX0oI();
            bArr[1] = 1;
            return bArr;
        }
        return oxoX2;
    }

    @Override // jxl.biff.formula.XX
    public boolean II0XooXoX() {
        this.f27733I0Io.Oxx0IOOO();
        return this.f27733I0Io.II0XooXoX();
    }

    public final void II0xO0(I0X0x0oIo i0X0x0oIo, Iterator it, Stack stack) throws FormulaException {
        OI0 X0o0xo2 = X0o0xo(it);
        if (i0X0x0oIo.IXxxXO(this.f27737X0o0xo) != o00.f27751IIIxO) {
            if (i0X0x0oIo.IXxxXO(this.f27737X0o0xo) == o00.f27962xoIox && this.f27740oxoX == null) {
                X0o0xo x0o0xo = new X0o0xo(i0X0x0oIo, this.f27737X0o0xo);
                x0o0xo.IXxxXO(X0o0xo2);
                stack.push(x0o0xo);
                return;
            }
            int i = 0;
            if (i0X0x0oIo.IXxxXO(this.f27737X0o0xo) == o00.f27979xxxoo0XI) {
                X0o0xo x0o0xo2 = new X0o0xo(i0X0x0oIo, this.f27737X0o0xo);
                Ioxxx ioxxx = new Ioxxx(this.f27737X0o0xo);
                int size = this.f27740oxoX.size();
                while (i < size) {
                    ioxxx.IXxxXO((OI0) this.f27740oxoX.get(i));
                    i++;
                }
                x0o0xo2.XIxXXX0x0(ioxxx);
                stack.push(x0o0xo2);
                return;
            }
            if (i0X0x0oIo.IXxxXO(this.f27737X0o0xo).XO() == 255) {
                Stack stack2 = this.f27740oxoX;
                if (stack2 == null) {
                    if (X0o0xo2 != null) {
                        i = 1;
                    }
                    Ioxxx ioxxx2 = new Ioxxx(i0X0x0oIo.IXxxXO(this.f27737X0o0xo), i, this.f27737X0o0xo);
                    if (X0o0xo2 != null) {
                        ioxxx2.IXxxXO(X0o0xo2);
                    }
                    stack.push(ioxxx2);
                    return;
                }
                int size2 = stack2.size();
                Ioxxx ioxxx3 = new Ioxxx(i0X0x0oIo.IXxxXO(this.f27737X0o0xo), size2, this.f27737X0o0xo);
                OI0[] oi0Arr = new OI0[size2];
                for (int i2 = 0; i2 < size2; i2++) {
                    oi0Arr[(size2 - i2) - 1] = (OI0) this.f27740oxoX.pop();
                }
                while (i < size2) {
                    ioxxx3.IXxxXO(oi0Arr[i]);
                    i++;
                }
                stack.push(ioxxx3);
                this.f27740oxoX.clear();
                this.f27740oxoX = null;
                return;
            }
            II0XooXoX iI0XooXoX = new II0XooXoX(i0X0x0oIo.IXxxXO(this.f27737X0o0xo), this.f27737X0o0xo);
            int XO2 = i0X0x0oIo.IXxxXO(this.f27737X0o0xo).XO();
            if (XO2 == 1) {
                iI0XooXoX.IXxxXO(X0o0xo2);
            } else {
                Stack stack3 = this.f27740oxoX;
                if ((stack3 == null && XO2 != 0) || (stack3 != null && XO2 != stack3.size())) {
                    throw new FormulaException(FormulaException.INCORRECT_ARGUMENTS);
                }
                while (i < XO2) {
                    iI0XooXoX.IXxxXO((OI0) this.f27740oxoX.get(i));
                    i++;
                }
            }
            stack.push(iI0XooXoX);
            return;
        }
        throw new FormulaException(FormulaException.UNRECOGNIZED_FUNCTION);
    }

    @Override // jxl.biff.formula.XX
    public void OOXIXo(int i, int i2, boolean z) {
        this.f27733I0Io.II0xO0(i, i2, z);
    }

    @Override // jxl.biff.formula.XX
    public String Oxx0IOOO() {
        if (this.f27735II0xO0 == null) {
            StringBuffer stringBuffer = new StringBuffer();
            this.f27733I0Io.XO(stringBuffer);
            this.f27735II0xO0 = stringBuffer.toString();
        }
        return this.f27735II0xO0;
    }

    public final OI0 X0o0xo(Iterator it) throws FormulaException {
        Stack stack = new Stack();
        Stack stack2 = new Stack();
        OI0 oi0 = null;
        boolean z = false;
        Stack stack3 = null;
        OI0 oi02 = null;
        while (it.hasNext() && !z) {
            OI0 oi03 = (OI0) it.next();
            oi03.oO(this.f27734II0XooXoX);
            if (oi03 instanceof IO) {
                oxoX((IO) oi03, stack);
            } else if (oi03 instanceof I0X0x0oIo) {
                II0xO0((I0X0x0oIo) oi03, it, stack);
            } else if (oi03 instanceof xII) {
                xII xii = (xII) oi03;
                if (xii instanceof oX) {
                    oX oXVar = (oX) xii;
                    if (!stack.isEmpty() && !(oi02 instanceof xII)) {
                        xii = oXVar.xoXoI();
                    } else {
                        xii = oXVar.o00();
                    }
                }
                if (stack2.empty()) {
                    stack2.push(xii);
                } else {
                    xII xii2 = (xII) stack2.peek();
                    if (xii.OxxIIOOXO() < xii2.OxxIIOOXO()) {
                        stack2.push(xii);
                    } else if (xii.OxxIIOOXO() == xii2.OxxIIOOXO() && (xii instanceof x0xO)) {
                        stack2.push(xii);
                    } else {
                        stack2.pop();
                        xii2.Oxx0xo(stack);
                        stack.push(xii2);
                        stack2.push(xii);
                    }
                }
            } else if (oi03 instanceof oxoX) {
                while (!stack2.isEmpty()) {
                    xII xii3 = (xII) stack2.pop();
                    xii3.Oxx0xo(stack);
                    stack.push(xii3);
                }
                if (stack3 == null) {
                    stack3 = new Stack();
                }
                stack3.push(stack.pop());
                stack.clear();
            } else if (oi03 instanceof X00IoxXI) {
                OI0 X0o0xo2 = X0o0xo(it);
                x0o x0oVar = new x0o();
                X0o0xo2.x0XOIxOo(x0oVar);
                x0oVar.IXxxXO(X0o0xo2);
                stack.push(x0oVar);
            } else if (oi03 instanceof oOoXoXO) {
                z = true;
            }
            oi02 = oi03;
        }
        while (!stack2.isEmpty()) {
            xII xii4 = (xII) stack2.pop();
            xii4.Oxx0xo(stack);
            stack.push(xii4);
        }
        if (!stack.empty()) {
            oi0 = (OI0) stack.pop();
        }
        if (stack3 != null && oi0 != null) {
            stack3.push(oi0);
        }
        this.f27740oxoX = stack3;
        if (!stack.empty() || !stack2.empty()) {
            f27732xxIXOIIO.ooOOo0oXI("Formula " + this.f27739oIX0oI + " has a non-empty parse stack");
        }
        return oi0;
    }

    public final ArrayList oIX0oI() throws FormulaException {
        ArrayList arrayList = new ArrayList();
        xxIO xxio = new xxIO(new StringReader(this.f27739oIX0oI));
        xxio.II0xO0(this.f27738XO);
        xxio.I0Io(this.f27736Oxx0IOOO);
        try {
            for (OI0 II0XooXoX2 = xxio.II0XooXoX(); II0XooXoX2 != null; II0XooXoX2 = xxio.II0XooXoX()) {
                arrayList.add(II0XooXoX2);
            }
        } catch (IOException e) {
            f27732xxIXOIIO.ooOOo0oXI(e.toString());
        } catch (Error unused) {
            throw new FormulaException(FormulaException.LEXICAL_ERROR, this.f27739oIX0oI + " at char  " + xxio.oIX0oI());
        }
        return arrayList;
    }

    @Override // jxl.biff.formula.XX
    public void oOoXoXO(int i, int i2, boolean z) {
        this.f27733I0Io.I0Io(i, i2, z);
    }

    @Override // jxl.biff.formula.XX
    public void ooOOo0oXI(int i, int i2, boolean z) {
        this.f27733I0Io.OOXIXo(i, i2, z);
    }

    public final void oxoX(IO io2, Stack stack) {
        if (!(io2 instanceof XI0IXoo)) {
            stack.push(io2);
            return;
        }
        if (io2 instanceof XI0IXoo) {
            XI0IXoo xI0IXoo = (XI0IXoo) io2;
            if (!xI0IXoo.Oxx0xo()) {
                stack.push(xI0IXoo);
            } else {
                stack.push(new IXxxXO(xI0IXoo.IXxxXO()));
            }
        }
    }

    @Override // jxl.biff.formula.XX
    public void parse() throws FormulaException {
        this.f27733I0Io = X0o0xo(oIX0oI().iterator());
    }

    @Override // jxl.biff.formula.XX
    public void xoIox(int i, int i2, boolean z) {
        this.f27733I0Io.xoIox(i, i2, z);
    }

    @Override // jxl.biff.formula.XX
    public void xxIXOIIO(int i, int i2) {
        this.f27733I0Io.oIX0oI(i, i2);
    }
}
