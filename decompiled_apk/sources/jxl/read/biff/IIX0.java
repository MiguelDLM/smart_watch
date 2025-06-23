package jxl.read.biff;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import jxl.biff.NameRangeException;
import jxl.read.biff.o0;

/* loaded from: classes6.dex */
public class IIX0 extends xIoXXXIXo.OxI implements jxl.biff.formula.OxxIIOOXO, OoIXo.x0o {

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28161O0xOxO = XxIIOXIXx.X0o0xo.Oxx0IOOO(IIX0.class);

    /* renamed from: I0Io, reason: collision with root package name */
    public int f28162I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public XIxXXX0x0 f28164II0xO0;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public xIoXXXIXo.O0xOxO f28165IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public X0xOO.XxX0x0xxx f28166IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public oIX0oI f28168Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public xxIXOIIO f28171Oxx0xo;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public XIo0oOXIx f28173X0o0xo;

    /* renamed from: o00, reason: collision with root package name */
    public IXxxXO f28175o00;

    /* renamed from: oO, reason: collision with root package name */
    public XI0IXoo f28177oO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public ArrayList f28179ooOOo0oXI;

    /* renamed from: oxoX, reason: collision with root package name */
    public boolean f28180oxoX;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public ArrayList f28181x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    public I0 f28183xoIox;

    /* renamed from: xoXoI, reason: collision with root package name */
    public X0xOO.IIXOooo f28184xoXoI;

    /* renamed from: XO, reason: collision with root package name */
    public ArrayList f28174XO = new ArrayList(10);

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public OoIXo.xxX f28163II0XooXoX = new OoIXo.xxX();

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public OoIXo.xXxxox0I f28170Oxx0IOOO = new OoIXo.xXxxox0I(this.f28163II0XooXoX);

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public ArrayList f28185xxIXOIIO = new ArrayList(10);

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public ArrayList f28182x0xO0oo = new ArrayList(10);

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public HashMap f28178oOoXoXO = new HashMap();

    /* renamed from: OOXIXo, reason: collision with root package name */
    public int f28167OOXIXo = -1;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public boolean f28176oI0IIXIo = false;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public boolean f28172OxxIIOOXO = false;

    /* renamed from: OxI, reason: collision with root package name */
    public ArrayList f28169OxI = new ArrayList(10);

    public IIX0(XIxXXX0x0 xIxXXX0x0, xIoXXXIXo.O0xOxO o0xOxO) {
        this.f28164II0xO0 = xIxXXX0x0;
        this.f28165IIXOooo = o0xOxO;
    }

    @Override // jxl.biff.formula.OxxIIOOXO
    public int I0Io(String str) {
        return 0;
    }

    public xX0IIXIx0[] I0oOoX() {
        return (xX0IIXIx0[]) this.f28182x0xO0oo.toArray(new xX0IIXIx0[this.f28182x0xO0oo.size()]);
    }

    @Override // jxl.biff.formula.OxxIIOOXO
    public oIX0oI II0XooXoX() {
        return this.f28168Oo;
    }

    @Override // jxl.biff.formula.OxxIIOOXO
    public int II0xO0(int i) {
        boolean z;
        if (this.f28168Oo.xXOx()) {
            return i;
        }
        if (this.f28177oO != null) {
            z = true;
        } else {
            z = false;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
        return this.f28177oO.xXOx(i);
    }

    @Override // xIoXXXIXo.OxI
    public boolean IIX0o() {
        return this.f28176oI0IIXIo;
    }

    @Override // xIoXXXIXo.OxI
    public int IIXOooo() {
        return this.f28185xxIXOIIO.size();
    }

    public XI0IXoo IO() {
        return this.f28177oO;
    }

    public X0xOO.XxX0x0xxx Io() {
        return this.f28166IXxxXO;
    }

    public xxIXOIIO IoOoX() {
        return this.f28171Oxx0xo;
    }

    @Override // xIoXXXIXo.OxI
    public String[] O0xOxO() {
        int size = this.f28174XO.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = ((II0XooXoX) this.f28174XO.get(i)).getName();
        }
        return strArr;
    }

    public String OI0(int i) {
        if (this.f28168Oo.xXOx()) {
            return ((II0XooXoX) this.f28174XO.get(i)).getName();
        }
        xX0IIXIx0 xx0iixix0 = (xX0IIXIx0) this.f28182x0xO0oo.get(this.f28177oO.oX(i));
        int XX02 = this.f28177oO.XX0(i);
        String str = "#REF";
        if (xx0iixix0.Xo0() == xX0IIXIx0.f28497II0XooXoX) {
            if (XX02 == 65535) {
                return "#REF";
            }
            return ((II0XooXoX) this.f28174XO.get(XX02)).getName();
        }
        if (xx0iixix0.Xo0() == xX0IIXIx0.f28502xxIXOIIO) {
            StringBuffer stringBuffer = new StringBuffer();
            File file = new File(xx0iixix0.XX0());
            stringBuffer.append("'");
            stringBuffer.append(file.getAbsolutePath());
            stringBuffer.append("[");
            stringBuffer.append(file.getName());
            stringBuffer.append("]");
            if (XX02 != 65535) {
                str = xx0iixix0.oX(XX02);
            }
            stringBuffer.append(str);
            stringBuffer.append("'");
            return stringBuffer.toString();
        }
        f28161O0xOxO.ooOOo0oXI("Unknown Supbook 4");
        return "[UNKNOWN]";
    }

    @Override // xIoXXXIXo.OxI
    public xIoXXXIXo.IIXOooo OxI(String str) {
        Iterator it = this.f28174XO.iterator();
        boolean z = false;
        int i = 0;
        while (it.hasNext() && !z) {
            if (((II0XooXoX) it.next()).getName().equals(str)) {
                z = true;
            } else {
                i++;
            }
        }
        if (z) {
            return o00(i);
        }
        return null;
    }

    @Override // jxl.biff.formula.OxxIIOOXO
    public int Oxx0IOOO(int i) {
        boolean z;
        if (this.f28168Oo.xXOx()) {
            return i;
        }
        if (this.f28177oO != null) {
            z = true;
        } else {
            z = false;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
        return this.f28177oO.XX0(i);
    }

    @Override // xIoXXXIXo.OxI
    public xIoXXXIXo.OxxIIOOXO[] Oxx0xo(String str) {
        o0 o0Var = (o0) this.f28178oOoXoXO.get(str);
        if (o0Var == null) {
            return null;
        }
        o0.I0Io[] I0X0x0oIo2 = o0Var.I0X0x0oIo();
        xIoXXXIXo.OxxIIOOXO[] oxxIIOOXOArr = new xIoXXXIXo.OxxIIOOXO[I0X0x0oIo2.length];
        for (int i = 0; i < I0X0x0oIo2.length; i++) {
            oxxIIOOXOArr[i] = new OoIXo.oOXoIIIo(this, II0xO0(I0X0x0oIo2[i].oIX0oI()), I0X0x0oIo2[i].II0xO0(), I0X0x0oIo2[i].I0Io(), Oxx0IOOO(I0X0x0oIo2[i].oIX0oI()), I0X0x0oIo2[i].oxoX(), I0X0x0oIo2[i].X0o0xo());
        }
        return oxxIIOOXOArr;
    }

    @Override // xIoXXXIXo.OxI
    public xIoXXXIXo.I0Io OxxIIOOXO(String str) {
        return OxI(OoIXo.oOoXoXO.oOoXoXO(str)).IIX0o(str);
    }

    public X0xOO.IIXOooo X00IoxXI() {
        return this.f28184xoXoI;
    }

    @Override // xIoXXXIXo.OxI
    public xIoXXXIXo.IIXOooo[] X0IIOO() {
        return (xIoXXXIXo.IIXOooo[]) this.f28185xxIXOIIO.toArray(new xIoXXXIXo.IIXOooo[IIXOooo()]);
    }

    @Override // OoIXo.x0o
    public xIoXXXIXo.IIXOooo X0o0xo(int i) {
        return o00(i);
    }

    @Override // jxl.biff.formula.OxxIIOOXO
    public int XO(String str) {
        return 0;
    }

    public int XOxIOxOx(xIoXXXIXo.IIXOooo iIXOooo) {
        String name = iIXOooo.getName();
        Iterator it = this.f28174XO.iterator();
        int i = 0;
        int i2 = -1;
        while (it.hasNext() && i2 == -1) {
            if (((II0XooXoX) it.next()).getName().equals(name)) {
                i2 = i;
            } else {
                i++;
            }
        }
        return i2;
    }

    public xIoXXXIXo.O0xOxO XX() {
        return this.f28165IIXOooo;
    }

    public IXxxXO Xx000oIo() {
        return this.f28175o00;
    }

    public o0[] o0() {
        return (o0[]) this.f28179ooOOo0oXI.toArray(new o0[this.f28179ooOOo0oXI.size()]);
    }

    @Override // xIoXXXIXo.OxI
    public xIoXXXIXo.IIXOooo o00(int i) {
        I0 i0 = this.f28183xoIox;
        if (i0 != null && this.f28167OOXIXo == i) {
            return i0;
        }
        if (i0 != null) {
            i0.xoxXI();
            if (!this.f28165IIXOooo.oOoXoXO()) {
                System.gc();
            }
        }
        I0 i02 = (I0) this.f28185xxIXOIIO.get(i);
        this.f28183xoIox = i02;
        this.f28167OOXIXo = i;
        i02.xX0IIXIx0();
        return this.f28183xoIox;
    }

    @Override // xIoXXXIXo.OxI
    public xIoXXXIXo.I0Io oI0IIXIo(String str) {
        o0 o0Var = (o0) this.f28178oOoXoXO.get(str);
        if (o0Var == null) {
            return null;
        }
        o0.I0Io[] I0X0x0oIo2 = o0Var.I0X0x0oIo();
        xIoXXXIXo.IIXOooo o002 = o00(II0xO0(I0X0x0oIo2[0].oIX0oI()));
        int II0xO02 = I0X0x0oIo2[0].II0xO0();
        int I0Io2 = I0X0x0oIo2[0].I0Io();
        if (II0xO02 <= o002.XoI0Ixx0() && I0Io2 <= o002.OxxIIOOXO()) {
            return o002.XX(II0xO02, I0Io2);
        }
        return new OoIXo.O0xOxO(II0xO02, I0Io2);
    }

    @Override // jxl.biff.formula.OxxIIOOXO
    public String oIX0oI(int i) {
        String name;
        if (this.f28168Oo.xXOx()) {
            return ((II0XooXoX) this.f28174XO.get(i)).getName();
        }
        xX0IIXIx0 xx0iixix0 = (xX0IIXIx0) this.f28182x0xO0oo.get(this.f28177oO.oX(i));
        int xXOx2 = this.f28177oO.xXOx(i);
        int XX02 = this.f28177oO.XX0(i);
        String str = "#REF";
        if (xx0iixix0.Xo0() == xX0IIXIx0.f28497II0XooXoX) {
            if (xXOx2 == 65535) {
                name = "#REF";
            } else {
                name = ((II0XooXoX) this.f28174XO.get(xXOx2)).getName();
            }
            if (XX02 != 65535) {
                str = ((II0XooXoX) this.f28174XO.get(XX02)).getName();
            }
            if (xXOx2 != XX02) {
                name = name + ':' + str;
            }
            if (name.indexOf(39) != -1) {
                name = OoIXo.IO.II0XooXoX(name, "'", "''");
            }
            if (name.indexOf(32) != -1) {
                return '\'' + name + '\'';
            }
            return name;
        }
        if (xx0iixix0.Xo0() == xX0IIXIx0.f28502xxIXOIIO) {
            StringBuffer stringBuffer = new StringBuffer();
            File file = new File(xx0iixix0.XX0());
            stringBuffer.append("'");
            stringBuffer.append(file.getAbsolutePath());
            stringBuffer.append("[");
            stringBuffer.append(file.getName());
            stringBuffer.append("]");
            if (xXOx2 != 65535) {
                str = xx0iixix0.oX(xXOx2);
            }
            stringBuffer.append(str);
            if (XX02 != xXOx2) {
                stringBuffer.append(xx0iixix0.oX(XX02));
            }
            stringBuffer.append("'");
            return stringBuffer.toString();
        }
        f28161O0xOxO.ooOOo0oXI("Unknown Supbook 3");
        return "[UNKNOWN]";
    }

    public x0xO0oo oOXoIIIo() {
        return this.f28164II0xO0.I0Io();
    }

    public String[] oo() {
        return (String[]) this.f28181x0XOIxOo.toArray(new String[0]);
    }

    public boolean oo0xXOI0I() {
        return this.f28172OxxIIOOXO;
    }

    /* JADX WARN: Removed duplicated region for block: B:257:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0482  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x03ce A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0427  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x04a1  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:194:0x03ce -> B:156:0x03cf). Please report as a decompilation issue!!! */
    @Override // xIoXXXIXo.OxI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void ooXIXxIX() throws jxl.read.biff.BiffException, jxl.read.biff.PasswordException {
        /*
            Method dump skipped, instructions count: 1247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: jxl.read.biff.IIX0.ooXIXxIX():void");
    }

    @Override // OoIXo.x0o
    public String oxoX(int i) throws NameRangeException {
        if (i >= 0 && i < this.f28179ooOOo0oXI.size()) {
            return ((o0) this.f28179ooOOo0oXI.get(i)).getName();
        }
        throw new NameRangeException();
    }

    public OoIXo.o0[] oxxXoxO() {
        return (OoIXo.o0[]) this.f28169OxI.toArray(new OoIXo.o0[0]);
    }

    public OoIXo.xXxxox0I x0o() {
        return this.f28170Oxx0IOOO;
    }

    public final void xI(xIoXXXIXo.IIXOooo iIXOooo) {
        this.f28185xxIXOIIO.add(iIXOooo);
    }

    public OoIXo.xxX xII() {
        return this.f28163II0XooXoX;
    }

    @Override // xIoXXXIXo.OxI
    public void xoIox() {
        I0 i0 = this.f28183xoIox;
        if (i0 != null) {
            i0.xoxXI();
        }
        this.f28164II0xO0.oIX0oI();
        if (!this.f28165IIXOooo.oOoXoXO()) {
            System.gc();
        }
    }

    @Override // xIoXXXIXo.OxI
    public String[] xoXoI() {
        Object[] array = this.f28178oOoXoXO.keySet().toArray();
        String[] strArr = new String[array.length];
        System.arraycopy(array, 0, strArr, 0, array.length);
        return strArr;
    }

    @Override // OoIXo.x0o
    public int xxIXOIIO(String str) {
        o0 o0Var = (o0) this.f28178oOoXoXO.get(str);
        if (o0Var != null) {
            return o0Var.XX0();
        }
        return 0;
    }
}
