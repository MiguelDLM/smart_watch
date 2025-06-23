package jxl.read.biff;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import jxl.read.biff.o0;

/* loaded from: classes6.dex */
public class I0 implements xIoXXXIXo.IIXOooo {

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28097oOXoIIIo = XxIIOXIXx.X0o0xo.Oxx0IOOO(I0.class);

    /* renamed from: I0Io, reason: collision with root package name */
    public oIX0oI f28098I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f28099II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public XIo0oOXIx f28100II0xO0;

    /* renamed from: IIX0o, reason: collision with root package name */
    public int f28101IIX0o;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public ArrayList f28103IXxxXO;

    /* renamed from: IoOoX, reason: collision with root package name */
    public xIoXXXIXo.O0xOxO f28104IoOoX;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public boolean f28105O0xOxO;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public oO[] f28106OOXIXo;

    /* renamed from: Oo, reason: collision with root package name */
    public ArrayList f28107Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public OoIXo.XOxIOxOx f28108OxI;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f28109Oxx0IOOO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public ArrayList f28110Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public xIoXXXIXo.OxxIIOOXO[] f28111OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public oxXx0IX f28112X0IIOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public OoIXo.xXxxox0I f28113X0o0xo;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public xxIXOIIO f28114XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public xIoXXXIXo.xoXoI f28115XIxXXX0x0;

    /* renamed from: XO, reason: collision with root package name */
    public String f28116XO;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public int[] f28117XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    public boolean f28118o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public OoIXo.OxxIIOOXO f28119oI0IIXIo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public XIxXXX0x0 f28120oIX0oI;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public x0xO[] f28122oOoXoXO;

    /* renamed from: oo, reason: collision with root package name */
    public IIX0 f28123oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public OoIXo.oIX0oI f28124oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public ArrayList f28126ooXIXxIX;

    /* renamed from: oxoX, reason: collision with root package name */
    public oIX0oI f28127oxoX;

    /* renamed from: xI, reason: collision with root package name */
    public ArrayList f28130xI;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public int f28131xXxxox0I;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f28132xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public xIoXXXIXo.I0Io[][] f28134xxIXOIIO;

    /* renamed from: xxX, reason: collision with root package name */
    public int[] f28135xxX;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public ArrayList f28128x0XOIxOo = new ArrayList();

    /* renamed from: oO, reason: collision with root package name */
    public ArrayList f28121oO = new ArrayList();

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public ArrayList f28129x0xO0oo = new ArrayList();

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public ArrayList f28125ooOOo0oXI = new ArrayList(10);

    /* renamed from: IIXOooo, reason: collision with root package name */
    public boolean f28102IIXOooo = false;

    /* renamed from: xoXoI, reason: collision with root package name */
    public boolean f28133xoXoI = false;

    public I0(XIxXXX0x0 xIxXXX0x0, XIo0oOXIx xIo0oOXIx, OoIXo.xXxxox0I xxxxox0i, oIX0oI oix0oi, oIX0oI oix0oi2, boolean z, IIX0 iix0) throws BiffException {
        this.f28120oIX0oI = xIxXXX0x0;
        this.f28100II0xO0 = xIo0oOXIx;
        this.f28113X0o0xo = xxxxox0i;
        this.f28098I0Io = oix0oi;
        this.f28127oxoX = oix0oi2;
        this.f28118o00 = z;
        this.f28123oo = iix0;
        this.f28104IoOoX = iix0.XX();
        this.f28132xoIox = xIxXXX0x0.oxoX();
        if (this.f28098I0Io.I0X0x0oIo()) {
            this.f28132xoIox -= this.f28098I0Io.xo0x() + 4;
        }
        int i = 1;
        while (i >= 1) {
            xoxXI Oxx0IOOO2 = xIxXXX0x0.Oxx0IOOO();
            i = Oxx0IOOO2.II0xO0() == OoIXo.xII.f2459X0o0xo.f2535oIX0oI ? i - 1 : i;
            if (Oxx0IOOO2.II0xO0() == OoIXo.xII.f2506oxoX.f2535oIX0oI) {
                i++;
            }
        }
    }

    public IIX0 I0() {
        return this.f28123oo;
    }

    @Override // xIoXXXIXo.IIXOooo
    public xIoXXXIXo.I0Io I0Io(Pattern pattern, int i, int i2, int i3, int i4, boolean z) {
        return new OoIXo.OOXIXo(this).I0Io(pattern, i, i2, i3, i4, z);
    }

    @Override // xIoXXXIXo.IIXOooo
    public int I0X0x0oIo(int i) {
        return X0IIOO(i).oxoX() / 256;
    }

    public void I0oOIX(o0 o0Var) {
        if (this.f28126ooXIXxIX == null) {
            this.f28126ooXIXxIX = new ArrayList();
        }
        this.f28126ooXIXxIX.add(o0Var);
    }

    @Override // xIoXXXIXo.IIXOooo
    public int I0oOoX(int i) {
        return Oo(i).II0xO0();
    }

    @Override // xIoXXXIXo.IIXOooo
    public xIoXXXIXo.I0Io[] II0xO0(int i) {
        if (this.f28134xxIXOIIO == null) {
            xX0IIXIx0();
        }
        int i2 = this.f28109Oxx0IOOO - 1;
        boolean z = false;
        while (i2 >= 0 && !z) {
            if (this.f28134xxIXOIIO[i2][i] != null) {
                z = true;
            } else {
                i2--;
            }
        }
        xIoXXXIXo.I0Io[] i0IoArr = new xIoXXXIXo.I0Io[i2 + 1];
        for (int i3 = 0; i3 <= i2; i3++) {
            i0IoArr[i3] = XX(i, i3);
        }
        return i0IoArr;
    }

    @Override // xIoXXXIXo.IIXOooo
    public xIoXXXIXo.I0Io IIX0o(String str) {
        return XX(OoIXo.oOoXoXO.Oxx0IOOO(str), OoIXo.oOoXoXO.OOXIXo(str));
    }

    public oIX0oI IIxOXoOo0() {
        return this.f28098I0Io;
    }

    @Override // xIoXXXIXo.IIXOooo
    public xIoXXXIXo.oO[] Io() {
        xIoXXXIXo.oO[] oOVarArr = new xIoXXXIXo.oO[this.f28129x0xO0oo.size()];
        for (int i = 0; i < this.f28129x0xO0oo.size(); i++) {
            oOVarArr[i] = (xIoXXXIXo.oO) this.f28129x0xO0oo.get(i);
        }
        return oOVarArr;
    }

    public xxIXOIIO IoOoo() {
        return this.f28114XI0IXoo;
    }

    public OoIXo.OxxIIOOXO Ioxxx() {
        return this.f28119oI0IIXIo;
    }

    public int O00XxXI() {
        return this.f28131xXxxox0I;
    }

    public OoIXo.oIX0oI OO() {
        return this.f28124oo0xXOI0I;
    }

    public oO[] OO0x0xX() {
        oO[] oOVarArr = new oO[this.f28128x0XOIxOo.size()];
        for (int i = 0; i < this.f28128x0XOIxOo.size(); i++) {
            oOVarArr[i] = (oO) this.f28128x0XOIxOo.get(i);
        }
        return oOVarArr;
    }

    @Override // xIoXXXIXo.IIXOooo
    public xIoXXXIXo.OxxIIOOXO[] OOXIXo() {
        xIoXXXIXo.OxxIIOOXO[] oxxIIOOXOArr = this.f28111OxxIIOOXO;
        if (oxxIIOOXOArr == null) {
            return new xIoXXXIXo.OxxIIOOXO[0];
        }
        return oxxIIOOXOArr;
    }

    public x0xO[] OOXIxO0() {
        int size = this.f28125ooOOo0oXI.size();
        x0xO[] x0xoArr = new x0xO[size];
        for (int i = 0; i < size; i++) {
            x0xoArr[i] = (x0xO) this.f28125ooOOo0oXI.get(i);
        }
        return x0xoArr;
    }

    public final void OX00O0xII() {
        if (this.f28110Oxx0xo != null) {
            return;
        }
        this.f28110Oxx0xo = new ArrayList();
        for (X0xOO.xoXoI xoxoi : XX0xXo()) {
            if (xoxoi instanceof X0xOO.Oxx0xo) {
                this.f28110Oxx0xo.add(xoxoi);
            }
        }
    }

    @Override // xIoXXXIXo.IIXOooo
    public xIoXXXIXo.II0XooXoX Oo(int i) {
        x0xO XI0oooXX2 = XI0oooXX(i);
        xIoXXXIXo.II0XooXoX iI0XooXoX = new xIoXXXIXo.II0XooXoX();
        if (XI0oooXX2 != null) {
            iI0XooXoX.II0XooXoX(XI0oooXX2.XX0());
            iI0XooXoX.OOXIXo(XI0oooXX2.XX0());
            iI0XooXoX.xoIox(XI0oooXX2.XoI0Ixx0());
            if (XI0oooXX2.Xo0()) {
                iI0XooXoX.xxIXOIIO(this.f28113X0o0xo.xoIox(XI0oooXX2.oX()));
            }
        } else {
            iI0XooXoX.II0XooXoX(this.f28115XIxXXX0x0.XO());
            iI0XooXoX.OOXIXo(this.f28115XIxXXX0x0.XO());
        }
        return iI0XooXoX;
    }

    @Override // xIoXXXIXo.IIXOooo
    public int OxxIIOOXO() {
        if (this.f28134xxIXOIIO == null) {
            xX0IIXIx0();
        }
        return this.f28109Oxx0IOOO;
    }

    @Override // xIoXXXIXo.IIXOooo
    public xIoXXXIXo.II0XooXoX X0IIOO(int i) {
        oO x0xO2 = x0xO(i);
        xIoXXXIXo.II0XooXoX iI0XooXoX = new xIoXXXIXo.II0XooXoX();
        if (x0xO2 != null) {
            iI0XooXoX.II0XooXoX(x0xO2.Xo0() / 256);
            iI0XooXoX.OOXIXo(x0xO2.Xo0());
            iI0XooXoX.xoIox(x0xO2.XX0());
            iI0XooXoX.xxIXOIIO(this.f28113X0o0xo.xoIox(x0xO2.XoI0Ixx0()));
        } else {
            iI0XooXoX.II0XooXoX(this.f28115XIxXXX0x0.oxoX());
            iI0XooXoX.OOXIXo(this.f28115XIxXXX0x0.oxoX() * 256);
        }
        return iI0XooXoX;
    }

    @Override // xIoXXXIXo.IIXOooo
    public xIoXXXIXo.xoXoI X0o0xo() {
        return this.f28115XIxXXX0x0;
    }

    public x0xO XI0oooXX(int i) {
        if (!this.f28133xoXoI) {
            this.f28122oOoXoXO = new x0xO[OxxIIOOXO()];
            Iterator it = this.f28125ooOOo0oXI.iterator();
            while (it.hasNext()) {
                x0xO x0xo = (x0xO) it.next();
                int I0X0x0oIo2 = x0xo.I0X0x0oIo();
                x0xO[] x0xoArr = this.f28122oOoXoXO;
                if (I0X0x0oIo2 < x0xoArr.length) {
                    x0xoArr[I0X0x0oIo2] = x0xo;
                }
            }
            this.f28133xoXoI = true;
        }
        x0xO[] x0xoArr2 = this.f28122oOoXoXO;
        if (i < x0xoArr2.length) {
            return x0xoArr2[i];
        }
        return null;
    }

    public OoIXo.ooOOo0oXI[] XIo0oOXIx() {
        return (OoIXo.ooOOo0oXI[]) this.f28130xI.toArray(new OoIXo.ooOOo0oXI[this.f28130xI.size()]);
    }

    @Override // xIoXXXIXo.IIXOooo
    public final int[] XO() {
        return this.f28117XxX0x0xxx;
    }

    @Override // xIoXXXIXo.IIXOooo
    public xIoXXXIXo.I0Io XX(int i, int i2) {
        if (this.f28134xxIXOIIO == null) {
            xX0IIXIx0();
        }
        xIoXXXIXo.I0Io i0Io = this.f28134xxIXOIIO[i2][i];
        if (i0Io == null) {
            OoIXo.O0xOxO o0xOxO = new OoIXo.O0xOxO(i, i2);
            this.f28134xxIXOIIO[i2][i] = o0xOxO;
            return o0xOxO;
        }
        return i0Io;
    }

    public final X0xOO.xoXoI[] XX0xXo() {
        return (X0xOO.xoXoI[]) this.f28103IXxxXO.toArray(new X0xOO.xoXoI[this.f28103IXxxXO.size()]);
    }

    @Override // xIoXXXIXo.IIXOooo
    public int XoI0Ixx0() {
        if (this.f28134xxIXOIIO == null) {
            xX0IIXIx0();
        }
        return this.f28099II0XooXoX;
    }

    @Override // xIoXXXIXo.IIXOooo
    public boolean XxX0x0xxx() {
        return this.f28115XIxXXX0x0.xII();
    }

    @Override // xIoXXXIXo.IIXOooo
    public String getName() {
        return this.f28116XO;
    }

    @Override // xIoXXXIXo.IIXOooo
    public boolean isHidden() {
        return this.f28105O0xOxO;
    }

    public int o0xxxXXxX() {
        return this.f28101IIX0o;
    }

    @Override // xIoXXXIXo.IIXOooo
    public int oIX0oI() {
        if (this.f28110Oxx0xo == null) {
            OX00O0xII();
        }
        return this.f28110Oxx0xo.size();
    }

    @Override // xIoXXXIXo.IIXOooo
    public xIoXXXIXo.IXxxXO oOoXoXO(String str) {
        return new OoIXo.OOXIXo(this).oxoX(str);
    }

    @Override // xIoXXXIXo.IIXOooo
    public xIoXXXIXo.I0Io oX(String str, int i, int i2, int i3, int i4, boolean z) {
        return new OoIXo.OOXIXo(this).II0xO0(str, i, i2, i3, i4, z);
    }

    public oIX0oI ooOx() {
        return this.f28127oxoX;
    }

    @Override // xIoXXXIXo.IIXOooo
    public final int[] ooXIXxIX() {
        return this.f28135xxX;
    }

    public oxXx0IX ox() {
        return this.f28112X0IIOO;
    }

    @Override // xIoXXXIXo.IIXOooo
    public xIoXXXIXo.I0Io oxxXoxO(String str) {
        return new OoIXo.OOXIXo(this).oIX0oI(str);
    }

    public final void setName(String str) {
        this.f28116XO = str;
    }

    @Override // xIoXXXIXo.IIXOooo
    public xIoXXXIXo.I0Io[] x0o(int i) {
        if (this.f28134xxIXOIIO == null) {
            xX0IIXIx0();
        }
        int i2 = this.f28099II0XooXoX - 1;
        boolean z = false;
        while (i2 >= 0 && !z) {
            if (this.f28134xxIXOIIO[i][i2] != null) {
                z = true;
            } else {
                i2--;
            }
        }
        xIoXXXIXo.I0Io[] i0IoArr = new xIoXXXIXo.I0Io[i2 + 1];
        for (int i3 = 0; i3 <= i2; i3++) {
            i0IoArr[i3] = XX(i3, i);
        }
        return i0IoArr;
    }

    public oO x0xO(int i) {
        if (!this.f28102IIXOooo) {
            Iterator it = this.f28128x0XOIxOo.iterator();
            while (it.hasNext()) {
                oO oOVar = (oO) it.next();
                int max = Math.max(0, oOVar.oX());
                int min = Math.min(this.f28106OOXIXo.length - 1, oOVar.xXOx());
                for (int i2 = max; i2 <= min; i2++) {
                    this.f28106OOXIXo[i2] = oOVar;
                }
                if (min < max) {
                    this.f28106OOXIXo[max] = oOVar;
                }
            }
            this.f28102IIXOooo = true;
        }
        oO[] oOVarArr = this.f28106OOXIXo;
        if (i < oOVarArr.length) {
            return oOVarArr[i];
        }
        return null;
    }

    public final void x0xO0oo(boolean z) {
        this.f28105O0xOxO = z;
    }

    @Override // xIoXXXIXo.IIXOooo
    public xIoXXXIXo.x0xO0oo xI(int i) {
        if (this.f28110Oxx0xo == null) {
            OX00O0xII();
        }
        return (xIoXXXIXo.x0xO0oo) this.f28110Oxx0xo.get(i);
    }

    public final void xX0IIXIx0() {
        if (!this.f28098I0Io.XoI0Ixx0()) {
            this.f28109Oxx0IOOO = 0;
            this.f28099II0XooXoX = 0;
            this.f28134xxIXOIIO = (xIoXXXIXo.I0Io[][]) Array.newInstance((Class<?>) xIoXXXIXo.I0Io.class, 0, 0);
        }
        ooOx ooox = new ooOx(this.f28120oIX0oI, this.f28100II0xO0, this.f28113X0o0xo, this.f28098I0Io, this.f28127oxoX, this.f28118o00, this.f28123oo, this.f28132xoIox, this);
        ooox.XI0IXoo();
        this.f28109Oxx0IOOO = ooox.oI0IIXIo();
        this.f28099II0XooXoX = ooox.Oxx0xo();
        this.f28134xxIXOIIO = ooox.Oxx0IOOO();
        this.f28125ooOOo0oXI = ooox.xoXoI();
        this.f28128x0XOIxOo = ooox.xoIox();
        this.f28129x0xO0oo = ooox.oO();
        this.f28130xI = ooox.OOXIXo();
        this.f28124oo0xXOI0I = ooox.X0o0xo();
        this.f28107Oo = ooox.II0XooXoX();
        this.f28103IXxxXO = ooox.x0XOIxOo();
        this.f28119oI0IIXIo = ooox.oOoXoXO();
        this.f28111OxxIIOOXO = ooox.IXxxXO();
        xIoXXXIXo.xoXoI o002 = ooox.o00();
        this.f28115XIxXXX0x0 = o002;
        o002.Xo0(this.f28105O0xOxO);
        this.f28135xxX = ooox.IIXOooo();
        this.f28117XxX0x0xxx = ooox.xxIXOIIO();
        this.f28108OxI = ooox.OxI();
        this.f28112X0IIOO = ooox.OxxIIOOXO();
        this.f28114XI0IXoo = ooox.XO();
        this.f28131xXxxox0I = ooox.Oo();
        this.f28101IIX0o = ooox.x0xO0oo();
        if (!this.f28104IoOoX.oOoXoXO()) {
            System.gc();
        }
        if (this.f28128x0XOIxOo.size() > 0) {
            ArrayList arrayList = this.f28128x0XOIxOo;
            this.f28106OOXIXo = new oO[((oO) arrayList.get(arrayList.size() - 1)).xXOx() + 1];
        } else {
            this.f28106OOXIXo = new oO[0];
        }
        ArrayList arrayList2 = this.f28126ooXIXxIX;
        if (arrayList2 != null) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                o0 o0Var = (o0) it.next();
                if (o0Var.xo0x() == OoIXo.Oxx0IOOO.f2103xoIox) {
                    if (o0Var.I0X0x0oIo().length > 0) {
                        o0.I0Io i0Io = o0Var.I0X0x0oIo()[0];
                        this.f28115XIxXXX0x0.o0xxxXXxX(i0Io.II0xO0(), i0Io.I0Io(), i0Io.oxoX(), i0Io.X0o0xo());
                    }
                } else if (o0Var.xo0x() == OoIXo.Oxx0IOOO.f2092OOXIXo) {
                    for (int i = 0; i < o0Var.I0X0x0oIo().length; i++) {
                        o0.I0Io i0Io2 = o0Var.I0X0x0oIo()[i];
                        if (i0Io2.II0xO0() == 0 && i0Io2.oxoX() == 255) {
                            this.f28115XIxXXX0x0.IIxOXoOo0(i0Io2.I0Io(), i0Io2.X0o0xo());
                        } else {
                            this.f28115XIxXXX0x0.OOXIxO0(i0Io2.II0xO0(), i0Io2.oxoX());
                        }
                    }
                }
            }
        }
    }

    public final X0xOO.X0o0xo[] xoIxX() {
        int size = this.f28107Oo.size();
        X0xOO.X0o0xo[] x0o0xoArr = new X0xOO.X0o0xo[size];
        for (int i = 0; i < size; i++) {
            x0o0xoArr[i] = (X0xOO.X0o0xo) this.f28107Oo.get(i);
        }
        return x0o0xoArr;
    }

    public OoIXo.XOxIOxOx xoO0xx0() {
        return this.f28108OxI;
    }

    public final void xoxXI() {
        this.f28134xxIXOIIO = null;
        this.f28111OxxIIOOXO = null;
        this.f28128x0XOIxOo.clear();
        this.f28121oO.clear();
        this.f28129x0xO0oo.clear();
        this.f28102IIXOooo = false;
        if (!this.f28104IoOoX.oOoXoXO()) {
            System.gc();
        }
    }

    public X0xOO.OxxIIOOXO xxIO() {
        ooOx ooox = new ooOx(this.f28120oIX0oI, this.f28100II0xO0, this.f28113X0o0xo, this.f28098I0Io, this.f28127oxoX, this.f28118o00, this.f28123oo, this.f28132xoIox, this);
        ooox.XI0IXoo();
        return ooox.ooOOo0oXI();
    }

    @Override // xIoXXXIXo.IIXOooo
    public oI0X0.X0o0xo xxX(int i) {
        return X0IIOO(i).I0Io();
    }
}
