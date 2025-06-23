package jxl.write.biff;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import jxl.write.biff.Xo0;

/* loaded from: classes6.dex */
public class IOoo extends oIXoXx0.X0IIOO implements jxl.biff.formula.OxxIIOOXO, OoIXo.x0o {

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28600O0xOxO = XxIIOXIXx.X0o0xo.Oxx0IOOO(IOoo.class);

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static Object f28601X0IIOO = new Object();

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public ArrayList f28602II0XooXoX;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public xxIXOIIO f28603IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public ArrayList f28604IXxxXO;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public ArrayList f28605OOXIXo;

    /* renamed from: Oo, reason: collision with root package name */
    public xIoXXXIXo.O0xOxO f28606Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public OoIXo.o0[] f28607OxI;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public IIX0o f28608Oxx0IOOO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public X0xOO.IIXOooo f28609Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public boolean f28610OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    public OoIXo.xXxxox0I f28611XO;

    /* renamed from: o00, reason: collision with root package name */
    public String[] f28612o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public XXoOx0 f28613oI0IIXIo;

    /* renamed from: oO, reason: collision with root package name */
    public boolean f28614oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public ArrayList f28615oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public HashMap f28616ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public IoIOOxIIo f28617x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public boolean f28618x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public xXxxox0I f28619xoIox;

    /* renamed from: xoXoI, reason: collision with root package name */
    public IXxxXO f28620xoXoI;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public OoIXo.xxX f28621xxIXOIIO;

    public IOoo(OutputStream outputStream, boolean z, xIoXXXIXo.O0xOxO o0xOxO) throws IOException {
        this.f28608Oxx0IOOO = new IIX0o(outputStream, o0xOxO, null);
        this.f28602II0XooXoX = new ArrayList();
        this.f28617x0XOIxOo = new IoIOOxIIo();
        this.f28616ooOOo0oXI = new HashMap();
        this.f28614oO = z;
        this.f28618x0xO0oo = false;
        this.f28610OxxIIOOXO = false;
        this.f28606Oo = o0xOxO;
        this.f28604IXxxXO = new ArrayList();
        this.f28613oI0IIXIo = new XXoOx0();
        synchronized (f28601X0IIOO) {
            oIXoXx0.X0IIOO.f31671oIX0oI.OO();
            oIXoXx0.X0IIOO.f31669II0xO0.OO();
            oIXoXx0.X0IIOO.f31668I0Io.OX00O0xII();
            oIXoXx0.X0IIOO.f31672oxoX.OX00O0xII();
            oIXoXx0.X0IIOO.f31670X0o0xo.OX00O0xII();
            IIXOooo.f28593oI0IIXIo.OX00O0xII();
        }
        this.f28621xxIXOIIO = new X0xxXX0(this);
        this.f28611XO = new IO0XoXxO(this.f28621xxIXOIIO, this.f28613oI0IIXIo);
    }

    @Override // jxl.biff.formula.OxxIIOOXO
    public int I0Io(String str) {
        boolean z;
        if (this.f28619xoIox == null) {
            this.f28619xoIox = new xXxxox0I();
            ArrayList arrayList = new ArrayList();
            this.f28605OOXIXo = arrayList;
            arrayList.add(new IxIX0I(IXxxXO(), this.f28606Oo));
        }
        Iterator it = this.f28602II0XooXoX.iterator();
        boolean z2 = false;
        int i = 0;
        while (true) {
            z = true;
            if (!it.hasNext() || z2) {
                break;
            }
            if (((XOxxooXI) it.next()).getName().equals(str)) {
                z2 = true;
            } else {
                i++;
            }
        }
        if (!z2) {
            return -1;
        }
        IxIX0I ixIX0I = (IxIX0I) this.f28605OOXIXo.get(0);
        if (ixIX0I.O0Xx() != IxIX0I.f28638oOoXoXO || ixIX0I.oX() != IXxxXO()) {
            z = false;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
        return this.f28619xoIox.I0X0x0oIo(0, i);
    }

    public void I0oOoX(X0xOO.Oxx0xo oxx0xo) {
        boolean z;
        if (this.f28609Oxx0xo != null) {
            z = true;
        } else {
            z = false;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
        this.f28609Oxx0xo.oOoXoXO(oxx0xo);
    }

    @Override // jxl.biff.formula.OxxIIOOXO
    public jxl.read.biff.oIX0oI II0XooXoX() {
        return null;
    }

    @Override // jxl.biff.formula.OxxIIOOXO
    public int II0xO0(int i) {
        boolean z;
        xXxxox0I xxxxox0i = this.f28619xoIox;
        if (xxxxox0i == null) {
            return i;
        }
        if (xxxxox0i != null) {
            z = true;
        } else {
            z = false;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
        return this.f28619xoIox.XX0(i);
    }

    public void IIX0o(X0xOO.xoXoI xoxoi) {
        if (this.f28609Oxx0xo == null) {
            this.f28609Oxx0xo = new X0xOO.IIXOooo(X0xOO.oo0xXOI0I.f3514II0xO0);
        }
        this.f28609Oxx0xo.II0xO0(xoxoi);
    }

    @Override // oIXoXx0.X0IIOO
    public String[] IIXOooo() {
        int IXxxXO2 = IXxxXO();
        String[] strArr = new String[IXxxXO2];
        for (int i = 0; i < IXxxXO2; i++) {
            strArr[i] = oI0IIXIo(i).getName();
        }
        return strArr;
    }

    public final oIXoXx0.O0xOxO IO(String str, int i, boolean z) {
        xXxxox0I xxxxox0i;
        XOxxooXI xOxxooXI = new XOxxooXI(str, this.f28608Oxx0IOOO, this.f28611XO, this.f28617x0XOIxOo, this.f28606Oo, this);
        if (i <= 0) {
            this.f28602II0XooXoX.add(0, xOxxooXI);
            i = 0;
        } else if (i > this.f28602II0XooXoX.size()) {
            i = this.f28602II0XooXoX.size();
            this.f28602II0XooXoX.add(xOxxooXI);
        } else {
            this.f28602II0XooXoX.add(i, xOxxooXI);
        }
        if (z && (xxxxox0i = this.f28619xoIox) != null) {
            xxxxox0i.XoI0Ixx0(i);
        }
        ArrayList arrayList = this.f28605OOXIXo;
        if (arrayList != null && arrayList.size() > 0) {
            IxIX0I ixIX0I = (IxIX0I) this.f28605OOXIXo.get(0);
            if (ixIX0I.O0Xx() == IxIX0I.f28638oOoXoXO) {
                ixIX0I.XX0(this.f28602II0XooXoX.size());
            }
        }
        return xOxxooXI;
    }

    @Override // oIXoXx0.X0IIOO
    public int IXxxXO() {
        return this.f28602II0XooXoX.size();
    }

    public xIoXXXIXo.O0xOxO Io() {
        return this.f28606Oo;
    }

    public void IoOoX(XOxxooXI xOxxooXI, int i) {
        int XO2 = XO(xOxxooXI.getName());
        Iterator it = this.f28604IXxxXO.iterator();
        while (it.hasNext()) {
            ((oOoXoXO) it.next()).oX(xOxxooXI, XO2, i);
        }
        ArrayList arrayList = this.f28615oOoXoXO;
        if (arrayList != null) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((Xo0) it2.next()).XX0(XO2, i);
            }
        }
    }

    @Override // oIXoXx0.X0IIOO
    public oIXoXx0.O0xOxO O0xOxO(int i, int i2) {
        int min = Math.min(Math.max(i, 0), this.f28602II0XooXoX.size() - 1);
        int min2 = Math.min(Math.max(i2, 0), this.f28602II0XooXoX.size() - 1);
        oIXoXx0.O0xOxO o0xOxO = (oIXoXx0.O0xOxO) this.f28602II0XooXoX.remove(min);
        this.f28602II0XooXoX.add(min2, o0xOxO);
        return o0xOxO;
    }

    public String OI0(int i) {
        IxIX0I ixIX0I = (IxIX0I) this.f28605OOXIXo.get(this.f28619xoIox.Xo0(i));
        int oX2 = this.f28619xoIox.oX(i);
        if (ixIX0I.O0Xx() == IxIX0I.f28638oOoXoXO) {
            return oI0IIXIo(oX2).getName();
        }
        if (ixIX0I.O0Xx() == IxIX0I.f28639ooOOo0oXI) {
            XxIIOXIXx.oIX0oI.oIX0oI(false);
        }
        f28600O0xOxO.ooOOo0oXI("Unknown Supbook 2");
        return "[UNKNOWN]";
    }

    @Override // oIXoXx0.X0IIOO
    public void OOXIXo() throws IOException, JxlWriteException {
        this.f28608Oxx0IOOO.oIX0oI(this.f28614oO);
    }

    @Override // oIXoXx0.X0IIOO
    public oIXoXx0.oI0IIXIo Oo(String str) {
        Xo0 xo0 = (Xo0) this.f28616ooOOo0oXI.get(str);
        if (xo0 == null) {
            return null;
        }
        Xo0.oIX0oI[] Xo02 = xo0.Xo0();
        return oI0IIXIo(II0xO0(Xo02[0].XO())).xoIox(Xo02[0].Oxx0IOOO(), Xo02[0].II0XooXoX());
    }

    @Override // oIXoXx0.X0IIOO
    public oIXoXx0.O0xOxO OxI(String str, int i, xIoXXXIXo.IIXOooo iIXOooo) {
        oIXoXx0.O0xOxO oO2 = oO(str, i);
        ((XOxxooXI) oO2).xoO0xx0(iIXOooo);
        return oO2;
    }

    @Override // jxl.biff.formula.OxxIIOOXO
    public int Oxx0IOOO(int i) {
        boolean z;
        xXxxox0I xxxxox0i = this.f28619xoIox;
        if (xxxxox0i == null) {
            return i;
        }
        if (xxxxox0i != null) {
            z = true;
        } else {
            z = false;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
        return this.f28619xoIox.oX(i);
    }

    @Override // oIXoXx0.X0IIOO
    public String[] Oxx0xo() {
        ArrayList arrayList = this.f28615oOoXoXO;
        if (arrayList == null) {
            return new String[0];
        }
        String[] strArr = new String[arrayList.size()];
        for (int i = 0; i < this.f28615oOoXoXO.size(); i++) {
            strArr[i] = ((Xo0) this.f28615oOoXoXO.get(i)).getName();
        }
        return strArr;
    }

    @Override // oIXoXx0.X0IIOO
    public oIXoXx0.O0xOxO OxxIIOOXO(String str) {
        Iterator it = this.f28602II0XooXoX.iterator();
        boolean z = false;
        oIXoXx0.O0xOxO o0xOxO = null;
        while (it.hasNext() && !z) {
            o0xOxO = (oIXoXx0.O0xOxO) it.next();
            if (o0xOxO.getName().equals(str)) {
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return o0xOxO;
    }

    public X0xOO.IIXOooo X00IoxXI() {
        if (this.f28609Oxx0xo == null) {
            this.f28609Oxx0xo = new X0xOO.IIXOooo(X0xOO.oo0xXOI0I.f3514II0xO0);
        }
        return this.f28609Oxx0xo;
    }

    @Override // oIXoXx0.X0IIOO
    public void X0IIOO(String str) {
        Iterator it = this.f28615oOoXoXO.iterator();
        boolean z = false;
        int i = 0;
        while (it.hasNext() && !z) {
            if (((Xo0) it.next()).getName().equals(str)) {
                z = true;
            } else {
                i++;
            }
        }
        if (z) {
            this.f28615oOoXoXO.remove(i);
            if (this.f28616ooOOo0oXI.remove(str) == null) {
                f28600O0xOxO.ooOOo0oXI("Could not remove " + str + " from index lookups");
            }
        }
    }

    @Override // OoIXo.x0o
    public xIoXXXIXo.IIXOooo X0o0xo(int i) {
        return oI0IIXIo(i);
    }

    @Override // oIXoXx0.X0IIOO
    public void XI0IXoo(int i) {
        if (i <= 0) {
            this.f28602II0XooXoX.remove(0);
            i = 0;
        } else if (i >= this.f28602II0XooXoX.size()) {
            i = this.f28602II0XooXoX.size() - 1;
            ArrayList arrayList = this.f28602II0XooXoX;
            arrayList.remove(arrayList.size() - 1);
        } else {
            this.f28602II0XooXoX.remove(i);
        }
        xXxxox0I xxxxox0i = this.f28619xoIox;
        if (xxxxox0i != null) {
            xxxxox0i.O0Xx(i);
        }
        ArrayList arrayList2 = this.f28605OOXIXo;
        if (arrayList2 != null && arrayList2.size() > 0) {
            IxIX0I ixIX0I = (IxIX0I) this.f28605OOXIXo.get(0);
            if (ixIX0I.O0Xx() == IxIX0I.f28638oOoXoXO) {
                ixIX0I.XX0(this.f28602II0XooXoX.size());
            }
        }
        ArrayList arrayList3 = this.f28615oOoXoXO;
        if (arrayList3 != null && arrayList3.size() > 0) {
            for (int i2 = 0; i2 < this.f28615oOoXoXO.size(); i2++) {
                Xo0 xo0 = (Xo0) this.f28615oOoXoXO.get(i2);
                int XoI0Ixx02 = xo0.XoI0Ixx0();
                int i3 = i + 1;
                if (XoI0Ixx02 == i3) {
                    xo0.xoxXI(0);
                } else if (XoI0Ixx02 > i3) {
                    if (XoI0Ixx02 < 1) {
                        XoI0Ixx02 = 1;
                    }
                    xo0.xoxXI(XoI0Ixx02 - 1);
                }
            }
        }
    }

    @Override // oIXoXx0.X0IIOO
    public void XIxXXX0x0(oI0X0.XO xo2, int i, int i2, int i3) {
        this.f28611XO.oO(xo2, i, i2, i3);
    }

    @Override // jxl.biff.formula.OxxIIOOXO
    public int XO(String str) {
        if (this.f28619xoIox == null) {
            this.f28619xoIox = new xXxxox0I();
            ArrayList arrayList = new ArrayList();
            this.f28605OOXIXo = arrayList;
            arrayList.add(new IxIX0I(IXxxXO(), this.f28606Oo));
        }
        Iterator it = this.f28602II0XooXoX.iterator();
        boolean z = false;
        int i = 0;
        while (it.hasNext() && !z) {
            if (((XOxxooXI) it.next()).getName().equals(str)) {
                z = true;
            } else {
                i++;
            }
        }
        if (z) {
            IxIX0I ixIX0I = (IxIX0I) this.f28605OOXIXo.get(0);
            if (ixIX0I.O0Xx() != IxIX0I.f28638oOoXoXO || ixIX0I.oX() != IXxxXO()) {
                f28600O0xOxO.ooOOo0oXI("Cannot find sheet " + str + " in supbook record");
            }
            return this.f28619xoIox.I0X0x0oIo(0, i);
        }
        int lastIndexOf = str.lastIndexOf(93);
        int lastIndexOf2 = str.lastIndexOf(91);
        int i2 = -1;
        if (lastIndexOf != -1 && lastIndexOf2 != -1) {
            String substring = str.substring(lastIndexOf + 1);
            String substring2 = str.substring(lastIndexOf2 + 1, lastIndexOf);
            String str2 = str.substring(0, lastIndexOf2) + substring2;
            IxIX0I ixIX0I2 = null;
            boolean z2 = false;
            for (int i3 = 0; i3 < this.f28605OOXIXo.size() && !z2; i3++) {
                ixIX0I2 = (IxIX0I) this.f28605OOXIXo.get(i3);
                if (ixIX0I2.O0Xx() == IxIX0I.f28639ooOOo0oXI && ixIX0I2.I0X0x0oIo().equals(str2)) {
                    i2 = i3;
                    z2 = true;
                }
            }
            if (!z2) {
                ixIX0I2 = new IxIX0I(str2, this.f28606Oo);
                i2 = this.f28605OOXIXo.size();
                this.f28605OOXIXo.add(ixIX0I2);
            }
            return this.f28619xoIox.I0X0x0oIo(i2, ixIX0I2.Xo0(substring));
        }
        f28600O0xOxO.ooOOo0oXI("Square brackets");
        return -1;
    }

    public final int XOxIOxOx(String str) {
        String[] IIXOooo2 = IIXOooo();
        for (int i = 0; i < IIXOooo2.length; i++) {
            if (str.equals(IIXOooo2[i])) {
                return i;
            }
        }
        return -1;
    }

    public final void XX() {
        OoIXo.xI x0XOIxOo2 = this.f28611XO.x0XOIxOo();
        OoIXo.xI ooOOo0oXI2 = this.f28611XO.ooOOo0oXI();
        OoIXo.xI oOoXoXO2 = this.f28611XO.oOoXoXO(x0XOIxOo2, ooOOo0oXI2);
        for (int i = 0; i < this.f28602II0XooXoX.size(); i++) {
            ((XOxxooXI) this.f28602II0XooXoX.get(i)).xX0IIXIx0(oOoXoXO2, x0XOIxOo2, ooOOo0oXI2);
        }
    }

    public void XoX(XOxxooXI xOxxooXI, int i) {
        int XO2 = XO(xOxxooXI.getName());
        Iterator it = this.f28604IXxxXO.iterator();
        while (it.hasNext()) {
            ((oOoXoXO) it.next()).xxIO(xOxxooXI, XO2, i);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f28615oOoXoXO;
        if (arrayList2 != null) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                Xo0 xo0 = (Xo0) it2.next();
                if (xo0.I0oOIX(XO2, i)) {
                    arrayList.add(xo0);
                }
            }
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                Xo0 xo02 = (Xo0) it3.next();
                XxIIOXIXx.oIX0oI.II0xO0(this.f28615oOoXoXO.remove(xo02), "Could not remove name " + xo02.getName());
            }
        }
    }

    public final void Xx000oIo(xIoXXXIXo.OxI oxI) {
        int IIXOooo2 = oxI.IIXOooo();
        this.f28618x0xO0oo = oxI.IIX0o();
        for (int i = 0; i < IIXOooo2; i++) {
            xIoXXXIXo.IIXOooo o002 = oxI.o00(i);
            ((XOxxooXI) IO(o002.getName(), i, false)).OO0x0xX(o002);
        }
    }

    @Override // oIXoXx0.X0IIOO
    public void XxX0x0xxx(boolean z) {
        this.f28618x0xO0oo = z;
    }

    public XXoOx0 o0() {
        return this.f28613oI0IIXIo;
    }

    @Override // oIXoXx0.X0IIOO
    public oIXoXx0.oI0IIXIo o00(String str) {
        return OxxIIOOXO(OoIXo.oOoXoXO.oOoXoXO(str)).xxIXOIIO(str);
    }

    @Override // oIXoXx0.X0IIOO
    public oIXoXx0.O0xOxO oI0IIXIo(int i) {
        return (oIXoXx0.O0xOxO) this.f28602II0XooXoX.get(i);
    }

    @Override // jxl.biff.formula.OxxIIOOXO
    public String oIX0oI(int i) {
        IxIX0I ixIX0I = (IxIX0I) this.f28605OOXIXo.get(this.f28619xoIox.Xo0(i));
        int XX02 = this.f28619xoIox.XX0(i);
        if (ixIX0I.O0Xx() == IxIX0I.f28638oOoXoXO) {
            return oI0IIXIo(XX02).getName();
        }
        if (ixIX0I.O0Xx() == IxIX0I.f28639ooOOo0oXI) {
            return ixIX0I.I0X0x0oIo() + ixIX0I.XoI0Ixx0(XX02);
        }
        f28600O0xOxO.ooOOo0oXI("Unknown Supbook 1");
        return "[UNKNOWN]";
    }

    @Override // oIXoXx0.X0IIOO
    public oIXoXx0.O0xOxO oO(String str, int i) {
        return IO(str, i, true);
    }

    public void oOXoIIIo(XOxxooXI xOxxooXI, int i) {
        int XO2 = XO(xOxxooXI.getName());
        Iterator it = this.f28604IXxxXO.iterator();
        while (it.hasNext()) {
            ((oOoXoXO) it.next()).Xo0(xOxxooXI, XO2, i);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f28615oOoXoXO;
        if (arrayList2 != null) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                Xo0 xo0 = (Xo0) it2.next();
                if (xo0.I0X0x0oIo(XO2, i)) {
                    arrayList.add(xo0);
                }
            }
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                Xo0 xo02 = (Xo0) it3.next();
                XxIIOXIXx.oIX0oI.II0xO0(this.f28615oOoXoXO.remove(xo02), "Could not remove name " + xo02.getName());
            }
        }
    }

    public void oo(oOoXoXO oooxoxo) {
        this.f28604IXxxXO.add(oooxoxo);
    }

    public void oo0xXOI0I(String str, oIXoXx0.O0xOxO o0xOxO, int i, int i2, int i3, int i4, boolean z) {
        if (this.f28615oOoXoXO == null) {
            this.f28615oOoXoXO = new ArrayList();
        }
        Xo0 xo0 = new Xo0(str, this.f28615oOoXoXO.size(), XO(o0xOxO.getName()), i2, i4, i, i3, z);
        this.f28615oOoXoXO.add(xo0);
        this.f28616ooOOo0oXI.put(str, xo0);
    }

    @Override // oIXoXx0.X0IIOO
    public void ooOOo0oXI(int i, String str, int i2) {
        ((XOxxooXI) oO(str, i2)).x0xO(oI0IIXIo(i));
    }

    public void ooXIXxIX(OoIXo.Oxx0IOOO oxx0IOOO, oIXoXx0.O0xOxO o0xOxO, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        if (this.f28615oOoXoXO == null) {
            this.f28615oOoXoXO = new ArrayList();
        }
        Xo0 xo0 = new Xo0(oxx0IOOO, XOxIOxOx(o0xOxO.getName()), XO(o0xOxO.getName()), i6, i8, i5, i7, i2, i4, i, i3, z);
        this.f28615oOoXoXO.add(xo0);
        this.f28616ooOOo0oXI.put(oxx0IOOO, xo0);
    }

    @Override // OoIXo.x0o
    public String oxoX(int i) {
        boolean z;
        if (i >= 0 && i < this.f28615oOoXoXO.size()) {
            z = true;
        } else {
            z = false;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
        return ((Xo0) this.f28615oOoXoXO.get(i)).getName();
    }

    public void oxxXoxO(XOxxooXI xOxxooXI, int i) {
        int XO2 = XO(xOxxooXI.getName());
        Iterator it = this.f28604IXxxXO.iterator();
        while (it.hasNext()) {
            ((oOoXoXO) it.next()).Ioxxx(xOxxooXI, XO2, i);
        }
        ArrayList arrayList = this.f28615oOoXoXO;
        if (arrayList != null) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((Xo0) it2.next()).O0Xx(XO2, i);
            }
        }
    }

    @Override // oIXoXx0.X0IIOO
    public void x0XOIxOo(String str, String str2, int i) {
        ((XOxxooXI) oO(str2, i)).x0xO(OxxIIOOXO(str));
    }

    public X0xOO.IIXOooo x0o() {
        return this.f28609Oxx0xo;
    }

    @Override // oIXoXx0.X0IIOO
    public xIoXXXIXo.OxxIIOOXO[] x0xO0oo(String str) {
        Xo0 xo0 = (Xo0) this.f28616ooOOo0oXI.get(str);
        if (xo0 == null) {
            return null;
        }
        Xo0.oIX0oI[] Xo02 = xo0.Xo0();
        xIoXXXIXo.OxxIIOOXO[] oxxIIOOXOArr = new xIoXXXIXo.OxxIIOOXO[Xo02.length];
        for (int i = 0; i < Xo02.length; i++) {
            oxxIIOOXOArr[i] = new OoIXo.oOXoIIIo(this, II0xO0(Xo02[i].XO()), Xo02[i].Oxx0IOOO(), Xo02[i].II0XooXoX(), Oxx0IOOO(Xo02[i].XO()), Xo02[i].xxIXOIIO(), Xo02[i].xoIox());
        }
        return oxxIIOOXOArr;
    }

    public void xI(OoIXo.Oxx0IOOO oxx0IOOO, oIXoXx0.O0xOxO o0xOxO, int i, int i2, int i3, int i4, boolean z) {
        if (this.f28615oOoXoXO == null) {
            this.f28615oOoXoXO = new ArrayList();
        }
        Xo0 xo0 = new Xo0(oxx0IOOO, XOxIOxOx(o0xOxO.getName()), XO(o0xOxO.getName()), i2, i4, i, i3, z);
        this.f28615oOoXoXO.add(xo0);
        this.f28616ooOOo0oXI.put(oxx0IOOO, xo0);
    }

    public oI0X0.x0XOIxOo xII(oI0X0.XO xo2) {
        return this.f28611XO.I0Io(xo2);
    }

    @Override // oIXoXx0.X0IIOO
    public void xXxxox0I() throws IOException {
        for (int i = 0; i < IXxxXO(); i++) {
            XOxxooXI xOxxooXI = (XOxxooXI) oI0IIXIo(i);
            xOxxooXI.xoIxX();
            xIoXXXIXo.OxxIIOOXO XI0IXoo2 = xOxxooXI.X0o0xo().XI0IXoo();
            if (XI0IXoo2 != null) {
                xI(OoIXo.Oxx0IOOO.f2103xoIox, xOxxooXI, XI0IXoo2.oIX0oI().oIX0oI(), XI0IXoo2.oIX0oI().II0xO0(), XI0IXoo2.II0xO0().oIX0oI(), XI0IXoo2.II0xO0().II0xO0(), false);
            }
            xIoXXXIXo.OxxIIOOXO xXxxox0I2 = xOxxooXI.X0o0xo().xXxxox0I();
            xIoXXXIXo.OxxIIOOXO XxX0x0xxx2 = xOxxooXI.X0o0xo().XxX0x0xxx();
            if (xXxxox0I2 != null && XxX0x0xxx2 != null) {
                ooXIXxIX(OoIXo.Oxx0IOOO.f2092OOXIXo, xOxxooXI, xXxxox0I2.oIX0oI().oIX0oI(), xXxxox0I2.oIX0oI().II0xO0(), xXxxox0I2.II0xO0().oIX0oI(), xXxxox0I2.II0xO0().II0xO0(), XxX0x0xxx2.oIX0oI().oIX0oI(), XxX0x0xxx2.oIX0oI().II0xO0(), XxX0x0xxx2.II0xO0().oIX0oI(), XxX0x0xxx2.II0xO0().II0xO0(), false);
            } else if (xXxxox0I2 != null) {
                xI(OoIXo.Oxx0IOOO.f2092OOXIXo, xOxxooXI, xXxxox0I2.oIX0oI().oIX0oI(), xXxxox0I2.oIX0oI().II0xO0(), xXxxox0I2.II0xO0().oIX0oI(), xXxxox0I2.II0xO0().II0xO0(), false);
            } else if (XxX0x0xxx2 != null) {
                xI(OoIXo.Oxx0IOOO.f2092OOXIXo, xOxxooXI, XxX0x0xxx2.oIX0oI().oIX0oI(), XxX0x0xxx2.oIX0oI().II0xO0(), XxX0x0xxx2.II0xO0().oIX0oI(), XxX0x0xxx2.II0xO0().II0xO0(), false);
            }
        }
        if (!this.f28606Oo.oI0IIXIo()) {
            XX();
        }
        this.f28608Oxx0IOOO.XO(new II0xO0(II0xO0.f28572XO));
        if (this.f28606Oo.IIXOooo()) {
            this.f28608Oxx0IOOO.XO(new IXO());
        }
        this.f28608Oxx0IOOO.XO(new XX());
        this.f28608Oxx0IOOO.XO(new oxXx0IX(0, 0));
        this.f28608Oxx0IOOO.XO(new o0());
        this.f28608Oxx0IOOO.XO(new oIIxXoo(this.f28606Oo.O0xOxO()));
        this.f28608Oxx0IOOO.XO(new x0XOIxOo());
        this.f28608Oxx0IOOO.XO(new oI0IIXIo());
        if (this.f28606Oo.Oxx0IOOO()) {
            this.f28608Oxx0IOOO.XO(new XI0IXoo());
        }
        this.f28608Oxx0IOOO.XO(new oOoIIO0(IXxxXO()));
        if (this.f28610OxxIIOOXO) {
            this.f28608Oxx0IOOO.XO(new xoxXI());
        }
        xxIXOIIO xxixoiio = this.f28603IIXOooo;
        if (xxixoiio != null) {
            this.f28608Oxx0IOOO.XO(xxixoiio);
        }
        this.f28608Oxx0IOOO.XO(new IoOoX());
        this.f28608Oxx0IOOO.XO(new x0(this.f28606Oo.OxI()));
        this.f28608Oxx0IOOO.XO(new XI0oooXX(this.f28618x0xO0oo));
        this.f28608Oxx0IOOO.XO(new XIo0oOXIx((String) null));
        this.f28608Oxx0IOOO.XO(new O00XxXI(false));
        this.f28608Oxx0IOOO.XO(new o0xxxXXxX());
        boolean z = false;
        int i2 = 0;
        for (int i3 = 0; i3 < IXxxXO() && !z; i3++) {
            if (((XOxxooXI) oI0IIXIo(i3)).X0o0xo().x0o()) {
                i2 = i3;
                z = true;
            }
        }
        if (!z) {
            ((XOxxooXI) oI0IIXIo(0)).X0o0xo().xOOOX(true);
            i2 = 0;
        }
        this.f28608Oxx0IOOO.XO(new xXoOI00O(i2));
        this.f28608Oxx0IOOO.XO(new I0Io(false));
        this.f28608Oxx0IOOO.XO(new IO(this.f28606Oo.ooOOo0oXI()));
        this.f28608Oxx0IOOO.XO(new XoI0Ixx0(false));
        this.f28608Oxx0IOOO.XO(new Ioxxx(false));
        this.f28608Oxx0IOOO.XO(new xOOOX(this.f28606Oo.OxxIIOOXO()));
        this.f28608Oxx0IOOO.XO(new X0o0xo(true));
        this.f28621xxIXOIIO.oxoX(this.f28608Oxx0IOOO);
        this.f28611XO.Oo(this.f28608Oxx0IOOO);
        if (this.f28611XO.xxIXOIIO() != null) {
            this.f28608Oxx0IOOO.XO(this.f28611XO.xxIXOIIO());
        }
        this.f28608Oxx0IOOO.XO(new Ix00oIoI());
        int[] iArr = new int[IXxxXO()];
        for (int i4 = 0; i4 < IXxxXO(); i4++) {
            iArr[i4] = this.f28608Oxx0IOOO.I0Io();
            oIXoXx0.O0xOxO oI0IIXIo2 = oI0IIXIo(i4);
            II0XooXoX iI0XooXoX = new II0XooXoX(oI0IIXIo2.getName());
            if (oI0IIXIo2.X0o0xo().X00IoxXI()) {
                iI0XooXoX.I0X0x0oIo();
            }
            if (((XOxxooXI) this.f28602II0XooXoX.get(i4)).OX00O0xII()) {
                iI0XooXoX.XX0();
            }
            this.f28608Oxx0IOOO.XO(iI0XooXoX);
        }
        if (this.f28620xoXoI == null) {
            OoIXo.IXxxXO I0Io2 = OoIXo.IXxxXO.I0Io(this.f28606Oo.II0XooXoX());
            OoIXo.IXxxXO iXxxXO = OoIXo.IXxxXO.f2075xoXoI;
            if (I0Io2 == iXxxXO) {
                XxIIOXIXx.X0o0xo x0o0xo = f28600O0xOxO;
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown country code ");
                sb.append(this.f28606Oo.II0XooXoX());
                sb.append(" using ");
                OoIXo.IXxxXO iXxxXO2 = OoIXo.IXxxXO.f2066XO;
                sb.append(iXxxXO2.II0xO0());
                x0o0xo.ooOOo0oXI(sb.toString());
                I0Io2 = iXxxXO2;
            }
            OoIXo.IXxxXO I0Io3 = OoIXo.IXxxXO.I0Io(this.f28606Oo.xxIXOIIO());
            this.f28620xoXoI = new IXxxXO(I0Io2, I0Io3);
            if (I0Io3 == iXxxXO) {
                f28600O0xOxO.ooOOo0oXI("Unknown country code " + this.f28606Oo.II0XooXoX() + " using " + OoIXo.IXxxXO.f2068oO.II0xO0());
            }
        }
        this.f28608Oxx0IOOO.XO(this.f28620xoXoI);
        String[] strArr = this.f28612o00;
        if (strArr != null && strArr.length > 0) {
            for (int i5 = 0; i5 < this.f28612o00.length; i5++) {
                this.f28608Oxx0IOOO.XO(new XxX0x0xxx(this.f28612o00[i5]));
            }
        }
        if (this.f28607OxI != null) {
            int i6 = 0;
            while (true) {
                OoIXo.o0[] o0VarArr = this.f28607OxI;
                if (i6 >= o0VarArr.length) {
                    break;
                }
                this.f28608Oxx0IOOO.XO(o0VarArr[i6]);
                i6++;
            }
        }
        if (this.f28619xoIox != null) {
            for (int i7 = 0; i7 < this.f28605OOXIXo.size(); i7++) {
                this.f28608Oxx0IOOO.XO((IxIX0I) this.f28605OOXIXo.get(i7));
            }
            this.f28608Oxx0IOOO.XO(this.f28619xoIox);
        }
        if (this.f28615oOoXoXO != null) {
            for (int i8 = 0; i8 < this.f28615oOoXoXO.size(); i8++) {
                this.f28608Oxx0IOOO.XO((Xo0) this.f28615oOoXoXO.get(i8));
            }
        }
        X0xOO.IIXOooo iIXOooo = this.f28609Oxx0xo;
        if (iIXOooo != null) {
            iIXOooo.oO(this.f28608Oxx0IOOO);
        }
        this.f28617x0XOIxOo.oxoX(this.f28608Oxx0IOOO);
        this.f28608Oxx0IOOO.XO(new X0IIOO());
        for (int i9 = 0; i9 < IXxxXO(); i9++) {
            IIX0o iIX0o = this.f28608Oxx0IOOO;
            iIX0o.oxoX(OoIXo.oo0xXOI0I.II0xO0(iIX0o.I0Io()), iArr[i9] + 4);
            ((XOxxooXI) oI0IIXIo(i9)).IIX0();
        }
    }

    @Override // oIXoXx0.X0IIOO
    public void xoIox(String str, oIXoXx0.O0xOxO o0xOxO, int i, int i2, int i3, int i4) {
        oo0xXOI0I(str, o0xOxO, i, i2, i3, i4, true);
    }

    @Override // oIXoXx0.X0IIOO
    public oIXoXx0.O0xOxO[] xoXoI() {
        oIXoXx0.O0xOxO[] o0xOxOArr = new oIXoXx0.O0xOxO[IXxxXO()];
        for (int i = 0; i < IXxxXO(); i++) {
            o0xOxOArr[i] = oI0IIXIo(i);
        }
        return o0xOxOArr;
    }

    @Override // OoIXo.x0o
    public int xxIXOIIO(String str) {
        Xo0 xo0 = (Xo0) this.f28616ooOOo0oXI.get(str);
        if (xo0 != null) {
            return xo0.oX();
        }
        return -1;
    }

    @Override // oIXoXx0.X0IIOO
    public void xxX(File file) throws IOException {
        this.f28608Oxx0IOOO.X0o0xo(new FileOutputStream(file));
    }

    public IOoo(OutputStream outputStream, xIoXXXIXo.OxI oxI, boolean z, xIoXXXIXo.O0xOxO o0xOxO) throws IOException {
        jxl.read.biff.IIX0 iix0 = (jxl.read.biff.IIX0) oxI;
        synchronized (f28601X0IIOO) {
            oIXoXx0.X0IIOO.f31671oIX0oI.OO();
            oIXoXx0.X0IIOO.f31669II0xO0.OO();
            oIXoXx0.X0IIOO.f31668I0Io.OX00O0xII();
            oIXoXx0.X0IIOO.f31672oxoX.OX00O0xII();
            oIXoXx0.X0IIOO.f31670X0o0xo.OX00O0xII();
            IIXOooo.f28593oI0IIXIo.OX00O0xII();
        }
        this.f28614oO = z;
        this.f28602II0XooXoX = new ArrayList();
        this.f28617x0XOIxOo = new IoIOOxIIo();
        this.f28616ooOOo0oXI = new HashMap();
        this.f28621xxIXOIIO = iix0.xII();
        this.f28611XO = iix0.x0o();
        this.f28618x0xO0oo = false;
        this.f28606Oo = o0xOxO;
        this.f28604IXxxXO = new ArrayList();
        this.f28613oI0IIXIo = new XXoOx0();
        this.f28608Oxx0IOOO = new IIX0o(outputStream, o0xOxO, iix0.oOXoIIIo());
        this.f28610OxxIIOOXO = false;
        if (!o0xOxO.Oxx0xo()) {
            this.f28610OxxIIOOXO = iix0.oo0xXOI0I();
        }
        if (iix0.Xx000oIo() != null) {
            this.f28620xoXoI = new IXxxXO(iix0.Xx000oIo());
        }
        this.f28612o00 = iix0.oo();
        this.f28607OxI = iix0.oxxXoxO();
        if (iix0.IO() != null) {
            this.f28619xoIox = new xXxxox0I(iix0.IO());
            jxl.read.biff.xX0IIXIx0[] I0oOoX2 = iix0.I0oOoX();
            this.f28605OOXIXo = new ArrayList(I0oOoX2.length);
            for (jxl.read.biff.xX0IIXIx0 xx0iixix0 : I0oOoX2) {
                if (xx0iixix0.Xo0() != jxl.read.biff.xX0IIXIx0.f28497II0XooXoX && xx0iixix0.Xo0() != jxl.read.biff.xX0IIXIx0.f28502xxIXOIIO) {
                    if (xx0iixix0.Xo0() != jxl.read.biff.xX0IIXIx0.f28501xoIox) {
                        f28600O0xOxO.ooOOo0oXI("unsupported supbook type - ignoring");
                    }
                } else {
                    this.f28605OOXIXo.add(new IxIX0I(xx0iixix0, this.f28606Oo));
                }
            }
        }
        if (iix0.X00IoxXI() != null) {
            this.f28609Oxx0xo = new X0xOO.IIXOooo(iix0.X00IoxXI());
        }
        if (this.f28610OxxIIOOXO && iix0.IoOoX() != null) {
            this.f28603IIXOooo = new xxIXOIIO(iix0.IoOoX());
        }
        if (!this.f28606Oo.IXxxXO()) {
            jxl.read.biff.o0[] o02 = iix0.o0();
            this.f28615oOoXoXO = new ArrayList(o02.length);
            for (int i = 0; i < o02.length; i++) {
                if (o02[i].Xo0()) {
                    Xo0 xo0 = new Xo0(o02[i], i);
                    this.f28615oOoXoXO.add(xo0);
                    this.f28616ooOOo0oXI.put(xo0.getName(), xo0);
                } else {
                    f28600O0xOxO.ooOOo0oXI("Cannot copy Biff7 name records - ignoring");
                }
            }
        }
        Xx000oIo(oxI);
        X0xOO.IIXOooo iIXOooo = this.f28609Oxx0xo;
        if (iIXOooo != null) {
            iIXOooo.x0XOIxOo(iix0.X00IoxXI());
        }
    }
}
