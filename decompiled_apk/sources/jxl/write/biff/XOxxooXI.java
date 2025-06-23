package jxl.write.biff;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.regex.Pattern;
import jxl.biff.NumFormatRecordsException;
import jxl.write.WriteException;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.log4j.spi.LocationInfo;

/* loaded from: classes6.dex */
public class XOxxooXI implements oIXoXx0.O0xOxO {

    /* renamed from: IIX0o, reason: collision with root package name */
    public static final int f28727IIX0o = 65536;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public static final int f28730ooXIXxIX = 31;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public static final int f28732xXxxox0I = 10;

    /* renamed from: II0xO0, reason: collision with root package name */
    public IIX0o f28735II0xO0;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public int f28738O0xOxO;

    /* renamed from: OxI, reason: collision with root package name */
    public int f28741OxI;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public OoIXo.oIX0oI f28744OxxIIOOXO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public IoIOOxIIo f28746X0o0xo;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public o0oIxOo f28747XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public xIoXXXIXo.O0xOxO f28748XIxXXX0x0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public String f28752oIX0oI;

    /* renamed from: oO, reason: collision with root package name */
    public OoIXo.OxxIIOOXO f28753oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public xoIxX f28754oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public xxIXOIIO f28755ooOOo0oXI;

    /* renamed from: oxoX, reason: collision with root package name */
    public OoIXo.xXxxox0I f28756oxoX;

    /* renamed from: xoXoI, reason: collision with root package name */
    public X0xOO.oOoXoXO f28760xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public IOoo f28762xxX;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28728XxX0x0xxx = XxIIOXIXx.X0o0xo.Oxx0IOOO(XOxxooXI.class);

    /* renamed from: xI, reason: collision with root package name */
    public static final char[] f28731xI = {'*', ':', '?', '\\'};

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public static final String[] f28729oo0xXOI0I = {"png"};

    /* renamed from: I0Io, reason: collision with root package name */
    public oXIO0o0XI[] f28733I0Io = new oXIO0o0XI[0];

    /* renamed from: xoIox, reason: collision with root package name */
    public int f28759xoIox = 0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public int f28739OOXIXo = 0;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public boolean f28757x0XOIxOo = false;

    /* renamed from: o00, reason: collision with root package name */
    public boolean f28750o00 = false;

    /* renamed from: XO, reason: collision with root package name */
    public TreeSet f28749XO = new TreeSet(new II0xO0());

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public TreeSet f28742Oxx0IOOO = new TreeSet();

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public ArrayList f28734II0XooXoX = new ArrayList();

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public XX0 f28761xxIXOIIO = new XX0(this);

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public ArrayList f28758x0xO0oo = new ArrayList();

    /* renamed from: Oo, reason: collision with root package name */
    public ArrayList f28740Oo = new ArrayList();

    /* renamed from: IXxxXO, reason: collision with root package name */
    public ArrayList f28737IXxxXO = new ArrayList();

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public ArrayList f28743Oxx0xo = new ArrayList();

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public ArrayList f28751oI0IIXIo = new ArrayList();

    /* renamed from: IIXOooo, reason: collision with root package name */
    public ArrayList f28736IIXOooo = new ArrayList();

    /* renamed from: X0IIOO, reason: collision with root package name */
    public xIoXXXIXo.xoXoI f28745X0IIOO = new xIoXXXIXo.xoXoI(this);

    /* loaded from: classes6.dex */
    public static class II0xO0 implements Comparator {
        public II0xO0() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            if (obj == obj2) {
                return 0;
            }
            XxIIOXIXx.oIX0oI.oIX0oI(obj instanceof oO);
            XxIIOXIXx.oIX0oI.oIX0oI(obj2 instanceof oO);
            return ((oO) obj).oIX0oI() - ((oO) obj2).oIX0oI();
        }

        @Override // java.util.Comparator
        public boolean equals(Object obj) {
            return obj == this;
        }
    }

    public XOxxooXI(String str, IIX0o iIX0o, OoIXo.xXxxox0I xxxxox0i, IoIOOxIIo ioIOOxIIo, xIoXXXIXo.O0xOxO o0xOxO, IOoo iOoo) {
        this.f28752oIX0oI = O0X(str);
        this.f28735II0xO0 = iIX0o;
        this.f28762xxX = iOoo;
        this.f28756oxoX = xxxxox0i;
        this.f28746X0o0xo = ioIOOxIIo;
        this.f28748XIxXXX0x0 = o0xOxO;
        this.f28747XI0IXoo = new o0oIxOo(this.f28735II0xO0, this, this.f28748XIxXXX0x0);
    }

    private X0xOO.xoXoI[] o0xxxXXxX() {
        return (X0xOO.xoXoI[]) this.f28737IXxxXO.toArray(new X0xOO.xoXoI[this.f28737IXxxXO.size()]);
    }

    private OoIXo.XOxIOxOx ooOx() {
        return this.f28747XI0IXoo.XO();
    }

    public xIoXXXIXo.O0xOxO I0() {
        return this.f28748XIxXXX0x0;
    }

    @Override // xIoXXXIXo.IIXOooo
    public xIoXXXIXo.I0Io I0Io(Pattern pattern, int i, int i2, int i3, int i4, boolean z) {
        return new OoIXo.OOXIXo(this).I0Io(pattern, i, i2, i3, i4, z);
    }

    @Override // xIoXXXIXo.IIXOooo
    public int I0X0x0oIo(int i) {
        return X0IIOO(i).II0xO0();
    }

    public void I0oOIX(X0xOO.xoXoI xoxoi) {
        this.f28737IXxxXO.add(xoxoi);
        XxIIOXIXx.oIX0oI.oIX0oI(!(xoxoi instanceof X0xOO.Oxx0xo));
    }

    @Override // xIoXXXIXo.IIXOooo
    public int I0oOoX(int i) {
        return Oo(i).II0xO0();
    }

    @Override // oIXoXx0.O0xOxO
    public void II0XooXoX(oIXoXx0.o00 o00Var, boolean z) {
        boolean z2;
        ArrayList arrayList = this.f28734II0XooXoX;
        arrayList.remove(arrayList.indexOf(o00Var));
        if (!z) {
            if (this.f28733I0Io.length > o00Var.II0xO0() && this.f28733I0Io[o00Var.II0xO0()] != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            XxIIOXIXx.oIX0oI.oIX0oI(z2);
            this.f28733I0Io[o00Var.II0xO0()].O00XxXI(o00Var.oIX0oI());
        }
    }

    @Override // xIoXXXIXo.IIXOooo
    public xIoXXXIXo.I0Io[] II0xO0(int i) {
        int i2 = this.f28759xoIox - 1;
        boolean z = false;
        while (i2 >= 0 && !z) {
            if (XX(i, i2).getType() != xIoXXXIXo.Oxx0IOOO.f34234II0xO0) {
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

    public void IIX0() throws IOException {
        boolean z = this.f28750o00;
        if (this.f28762xxX.x0o() != null) {
            z |= this.f28762xxX.x0o().xoIox();
        }
        if (this.f28742Oxx0IOOO.size() > 0) {
            IoOoo();
        }
        this.f28747XI0IXoo.IXxxXO(this.f28733I0Io, this.f28758x0xO0oo, this.f28740Oo, this.f28734II0XooXoX, this.f28761xxIXOIIO, this.f28749XO, this.f28741OxI, this.f28738O0xOxO);
        this.f28747XI0IXoo.ooOOo0oXI(OxxIIOOXO(), XoI0Ixx0());
        this.f28747XI0IXoo.x0xO0oo(this.f28745X0IIOO);
        this.f28747XI0IXoo.oO(this.f28754oOoXoXO);
        this.f28747XI0IXoo.x0XOIxOo(this.f28737IXxxXO, z);
        this.f28747XI0IXoo.II0XooXoX(this.f28755ooOOo0oXI);
        this.f28747XI0IXoo.oOoXoXO(this.f28753oO, this.f28736IIXOooo);
        this.f28747XI0IXoo.OOXIXo(this.f28751oI0IIXIo);
        this.f28747XI0IXoo.Oxx0IOOO(this.f28744OxxIIOOXO);
        this.f28747XI0IXoo.Oxx0xo();
    }

    @Override // xIoXXXIXo.IIXOooo
    public xIoXXXIXo.I0Io IIX0o(String str) {
        return XX(xIoXXXIXo.XO.OOXIXo(str), xIoXXXIXo.XO.ooOOo0oXI(str));
    }

    @Override // oIXoXx0.O0xOxO
    public void IIXOooo(int i) {
        Iterator it = this.f28740Oo.iterator();
        boolean z = false;
        while (it.hasNext() && !z) {
            if (((Integer) it.next()).intValue() == i) {
                z = true;
            }
        }
        if (!z) {
            this.f28740Oo.add(new Integer(i));
        }
    }

    public IOoo IIxOXoOo0() {
        return this.f28762xxX;
    }

    @Override // oIXoXx0.O0xOxO
    public void IO(oIXoXx0.o00 o00Var) throws WriteException, RowsExceededException {
        String IIX0o2;
        oXIO0o0XI oxio0o0xi;
        xIoXXXIXo.I0Io XX2 = XX(o00Var.oIX0oI(), o00Var.II0xO0());
        if (!o00Var.ooOOo0oXI() && !o00Var.xoIxX()) {
            if (o00Var.x0XOIxOo()) {
                IIX0o2 = o00Var.IIX0o();
                if (IIX0o2 == null) {
                    IIX0o2 = o00Var.IIXOooo().toString();
                }
            } else if (o00Var.ooXIXxIX()) {
                IIX0o2 = o00Var.IIX0o();
            } else {
                IIX0o2 = null;
            }
        } else {
            IIX0o2 = o00Var.IIX0o();
            if (IIX0o2 == null) {
                IIX0o2 = o00Var.Oo().getPath();
            }
        }
        if (XX2.getType() == xIoXXXIXo.Oxx0IOOO.f34232I0Io) {
            oIXoXx0.ooOOo0oXI ooooo0oxi = (oIXoXx0.ooOOo0oXI) XX2;
            ooooo0oxi.O00XxXI(IIX0o2);
            oIXoXx0.IIXOooo iIXOooo = new oIXoXx0.IIXOooo(ooooo0oxi.xoIox());
            iIXOooo.x0xO(oIXoXx0.X0IIOO.f31669II0xO0);
            ooooo0oxi.xxX(iIXOooo);
        } else {
            o00(new oIXoXx0.ooOOo0oXI(o00Var.oIX0oI(), o00Var.II0xO0(), IIX0o2, oIXoXx0.X0IIOO.f31672oxoX));
        }
        for (int II0xO02 = o00Var.II0xO0(); II0xO02 <= o00Var.Oxx0xo(); II0xO02++) {
            for (int oIX0oI2 = o00Var.oIX0oI(); oIX0oI2 <= o00Var.Xx000oIo(); oIX0oI2++) {
                if (II0xO02 != o00Var.II0xO0() && oIX0oI2 != o00Var.oIX0oI() && this.f28733I0Io.length < o00Var.Xx000oIo() && (oxio0o0xi = this.f28733I0Io[II0xO02]) != null) {
                    oxio0o0xi.O00XxXI(oIX0oI2);
                }
            }
        }
        o00Var.xoxXI(this);
        this.f28734II0XooXoX.add(o00Var);
    }

    @Override // oIXoXx0.O0xOxO
    public void IXxxXO(oIXoXx0.oI0IIXIo oi0iixio, int i, int i2) throws WriteException {
        oOoXoXO Xo02;
        if (oi0iixio.Io() != null && oi0iixio.Io().xxIXOIIO()) {
            int oIX0oI2 = oi0iixio.oIX0oI();
            int II0xO02 = oi0iixio.II0xO0();
            int i3 = II0xO02 + i2;
            int min = Math.min(this.f28759xoIox - 1, i3);
            for (int i4 = II0xO02; i4 <= min; i4++) {
                if (this.f28733I0Io[i4] != null) {
                    int i5 = oIX0oI2 + i;
                    int min2 = Math.min(r5.O0Xx() - 1, i5);
                    for (int i6 = oIX0oI2; i6 <= min2; i6++) {
                        if ((i6 != oIX0oI2 || i4 != II0xO02) && (Xo02 = this.f28733I0Io[i4].Xo0(i6)) != null && Xo02.Io() != null && Xo02.Io().xxIXOIIO()) {
                            f28728XxX0x0xxx.ooOOo0oXI("Cannot apply data validation from " + xIoXXXIXo.XO.oIX0oI(oIX0oI2, II0xO02) + " to " + xIoXXXIXo.XO.oIX0oI(i5, i3) + " as cell " + xIoXXXIXo.XO.oIX0oI(i6, i4) + " already has a data validation");
                            return;
                        }
                    }
                }
            }
            oIXoXx0.OxxIIOOXO Io2 = oi0iixio.Io();
            Io2.XO().II0xO0(i, i2);
            for (int i7 = II0xO02; i7 <= i3; i7++) {
                oXIO0o0XI OOXIxO02 = OOXIxO0(i7);
                for (int i8 = oIX0oI2; i8 <= oIX0oI2 + i; i8++) {
                    if (i8 != oIX0oI2 || i7 != II0xO02) {
                        oOoXoXO Xo03 = OOXIxO02.Xo0(i8);
                        if (Xo03 == null) {
                            oIXoXx0.II0xO0 iI0xO0 = new oIXoXx0.II0xO0(i8, i7);
                            oIXoXx0.OxxIIOOXO oxxIIOOXO = new oIXoXx0.OxxIIOOXO();
                            oxxIIOOXO.O0xOxO(Io2);
                            iI0xO0.xxIXOIIO(oxxIIOOXO);
                            o00(iI0xO0);
                        } else {
                            oIXoXx0.OxxIIOOXO Io3 = Xo03.Io();
                            if (Io3 != null) {
                                Io3.O0xOxO(Io2);
                            } else {
                                oIXoXx0.OxxIIOOXO oxxIIOOXO2 = new oIXoXx0.OxxIIOOXO();
                                oxxIIOOXO2.O0xOxO(Io2);
                                Xo03.xxIXOIIO(oxxIIOOXO2);
                            }
                        }
                    }
                }
            }
            return;
        }
        f28728XxX0x0xxx.ooOOo0oXI("Cannot extend data validation for " + xIoXXXIXo.XO.oIX0oI(oi0iixio.oIX0oI(), oi0iixio.II0xO0()) + " as it has no data validation");
    }

    @Override // xIoXXXIXo.IIXOooo
    public xIoXXXIXo.oO[] Io() {
        xIoXXXIXo.oO[] oOVarArr = new xIoXXXIXo.oO[this.f28734II0XooXoX.size()];
        for (int i = 0; i < this.f28734II0XooXoX.size(); i++) {
            oOVarArr[i] = (xIoXXXIXo.oO) this.f28734II0XooXoX.get(i);
        }
        return oOVarArr;
    }

    @Override // oIXoXx0.O0xOxO
    public void IoOoX(int i, int i2) throws RowsExceededException {
        xIoXXXIXo.II0XooXoX iI0XooXoX = new xIoXXXIXo.II0XooXoX();
        iI0XooXoX.OOXIXo(i2);
        iI0XooXoX.xoIox(false);
        xoXoI(i, iI0XooXoX);
    }

    public final void IoOoo() {
        Iterator it = this.f28742Oxx0IOOO.iterator();
        while (it.hasNext()) {
            OO(((Integer) it.next()).intValue());
        }
    }

    public oO Ioxxx(int i) {
        Iterator it = this.f28749XO.iterator();
        boolean z = false;
        oO oOVar = null;
        while (it.hasNext() && !z) {
            oOVar = (oO) it.next();
            if (oOVar.oIX0oI() >= i) {
                z = true;
            }
        }
        if (!z || oOVar.oIX0oI() != i) {
            return null;
        }
        return oOVar;
    }

    public final xI O00XxXI() {
        return this.f28747XI0IXoo.oxoX();
    }

    public final String O0X(String str) {
        int i = 0;
        if (str.length() > 31) {
            f28728XxX0x0xxx.ooOOo0oXI("Sheet name " + str + " too long - truncating");
            str = str.substring(0, 31);
        }
        if (str.charAt(0) == '\'') {
            f28728XxX0x0xxx.ooOOo0oXI("Sheet naming cannot start with ' - removing");
            str = str.substring(1);
        }
        while (true) {
            char[] cArr = f28731xI;
            if (i < cArr.length) {
                String replace = str.replace(cArr[i], ObjectUtils.f32506oIX0oI);
                if (str != replace) {
                    f28728XxX0x0xxx.ooOOo0oXI(cArr[i] + " is not a valid character within a sheet name - replacing");
                }
                i++;
                str = replace;
            } else {
                return str;
            }
        }
    }

    @Override // oIXoXx0.O0xOxO
    public void O0Xx(int i) {
        int i2;
        if (i >= 0 && i < (i2 = this.f28759xoIox)) {
            oXIO0o0XI[] oxio0o0xiArr = this.f28733I0Io;
            if (i2 == oxio0o0xiArr.length) {
                this.f28733I0Io = new oXIO0o0XI[oxio0o0xiArr.length + 10];
            } else {
                this.f28733I0Io = new oXIO0o0XI[oxio0o0xiArr.length];
            }
            System.arraycopy(oxio0o0xiArr, 0, this.f28733I0Io, 0, i);
            int i3 = i + 1;
            System.arraycopy(oxio0o0xiArr, i, this.f28733I0Io, i3, this.f28759xoIox - i);
            while (i3 <= this.f28759xoIox) {
                oXIO0o0XI oxio0o0xi = this.f28733I0Io[i3];
                if (oxio0o0xi != null) {
                    oxio0o0xi.OO0x0xX();
                }
                i3++;
            }
            Iterator it = this.f28734II0XooXoX.iterator();
            while (it.hasNext()) {
                ((XOxIOxOx) it.next()).IoOoo(i);
            }
            OoIXo.OxxIIOOXO oxxIIOOXO = this.f28753oO;
            if (oxxIIOOXO != null) {
                oxxIIOOXO.Oxx0IOOO(i);
            }
            ArrayList arrayList = this.f28736IIXOooo;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it2 = this.f28736IIXOooo.iterator();
                while (it2.hasNext()) {
                    xIoXXXIXo.oxoX XO2 = ((oOoXoXO) it2.next()).XO();
                    if (XO2.XO() != null) {
                        XO2.XO().OOXIXo(i);
                    }
                }
            }
            this.f28761xxIXOIIO.XO(i);
            ArrayList arrayList2 = new ArrayList();
            Iterator it3 = this.f28758x0xO0oo.iterator();
            while (it3.hasNext()) {
                int intValue = ((Integer) it3.next()).intValue();
                if (intValue >= i) {
                    intValue++;
                }
                arrayList2.add(new Integer(intValue));
            }
            this.f28758x0xO0oo = arrayList2;
            Iterator it4 = this.f28751oI0IIXIo.iterator();
            while (it4.hasNext()) {
                ((OoIXo.ooOOo0oXI) it4.next()).I0Io(i);
            }
            if (this.f28748XIxXXX0x0.xoIox()) {
                this.f28762xxX.oxxXoxO(this, i);
            }
            this.f28759xoIox++;
        }
    }

    @Override // oIXoXx0.O0xOxO
    public void O0xOxO(int i) {
        if (i >= 0 && i < this.f28739OOXIXo) {
            for (int i2 = 0; i2 < this.f28759xoIox; i2++) {
                oXIO0o0XI oxio0o0xi = this.f28733I0Io[i2];
                if (oxio0o0xi != null) {
                    oxio0o0xi.XIo0oOXIx(i);
                }
            }
            Iterator it = this.f28734II0XooXoX.iterator();
            while (it.hasNext()) {
                ((XOxIOxOx) it.next()).OO(i);
            }
            Iterator it2 = this.f28749XO.iterator();
            while (it2.hasNext()) {
                oO oOVar = (oO) it2.next();
                if (oOVar.oIX0oI() >= i) {
                    oOVar.OO();
                }
            }
            if (this.f28742Oxx0IOOO.size() > 0) {
                TreeSet treeSet = new TreeSet();
                Iterator it3 = this.f28742Oxx0IOOO.iterator();
                while (it3.hasNext()) {
                    Integer num = (Integer) it3.next();
                    if (num.intValue() >= i) {
                        treeSet.add(new Integer(num.intValue() + 1));
                    } else {
                        treeSet.add(num);
                    }
                }
                this.f28742Oxx0IOOO = treeSet;
            }
            OoIXo.OxxIIOOXO oxxIIOOXO = this.f28753oO;
            if (oxxIIOOXO != null) {
                oxxIIOOXO.XO(i);
            }
            ArrayList arrayList = this.f28736IIXOooo;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it4 = this.f28736IIXOooo.iterator();
                while (it4.hasNext()) {
                    xIoXXXIXo.oxoX XO2 = ((oOoXoXO) it4.next()).XO();
                    if (XO2.XO() != null) {
                        XO2.XO().xoIox(i);
                    }
                }
            }
            this.f28761xxIXOIIO.X0o0xo(i);
            ArrayList arrayList2 = new ArrayList();
            Iterator it5 = this.f28740Oo.iterator();
            while (it5.hasNext()) {
                int intValue = ((Integer) it5.next()).intValue();
                if (intValue >= i) {
                    intValue++;
                }
                arrayList2.add(new Integer(intValue));
            }
            this.f28740Oo = arrayList2;
            Iterator it6 = this.f28751oI0IIXIo.iterator();
            while (it6.hasNext()) {
                ((OoIXo.ooOOo0oXI) it6.next()).II0xO0(i);
            }
            if (this.f28748XIxXXX0x0.xoIox()) {
                this.f28762xxX.IoOoX(this, i);
            }
            this.f28739OOXIXo++;
        }
    }

    @Override // oIXoXx0.O0xOxO
    public xIoXXXIXo.OxxIIOOXO OI0(int i, int i2, int i3, int i4) throws WriteException, RowsExceededException {
        if (i3 < i || i4 < i2) {
            f28728XxX0x0xxx.ooOOo0oXI("Cannot merge cells - top left and bottom right incorrectly specified");
        }
        if (i3 >= this.f28739OOXIXo || i4 >= this.f28759xoIox) {
            o00(new oIXoXx0.II0xO0(i3, i4));
        }
        OoIXo.X00IoxXI x00IoxXI = new OoIXo.X00IoxXI(this, i, i2, i3, i4);
        this.f28761xxIXOIIO.oIX0oI(x00IoxXI);
        return x00IoxXI;
    }

    public final void OO(int i) {
        oOoXoXO oooxoxo;
        oO Ioxxx2 = Ioxxx(i);
        oI0X0.Oxx0IOOO XIxXXX0x02 = Ioxxx2.oX().XIxXXX0x0();
        oI0X0.Oxx0IOOO XIxXXX0x03 = oIXoXx0.X0IIOO.f31668I0Io.XIxXXX0x0();
        int i2 = 0;
        for (int i3 = 0; i3 < this.f28759xoIox; i3++) {
            oXIO0o0XI oxio0o0xi = this.f28733I0Io[i3];
            if (oxio0o0xi != null) {
                oooxoxo = oxio0o0xi.Xo0(i);
            } else {
                oooxoxo = null;
            }
            if (oooxoxo != null) {
                String IIX0o2 = oooxoxo.IIX0o();
                oI0X0.Oxx0IOOO XIxXXX0x04 = oooxoxo.xoIox().XIxXXX0x0();
                if (XIxXXX0x04.equals(XIxXXX0x03)) {
                    XIxXXX0x04 = XIxXXX0x02;
                }
                int xoXoI2 = XIxXXX0x04.xoXoI();
                int length = IIX0o2.length();
                if (XIxXXX0x04.OI0() || XIxXXX0x04.XOxIOxOx() > 400) {
                    length += 2;
                }
                i2 = Math.max(i2, length * xoXoI2 * 256);
            }
        }
        Ioxxx2.xxIO(i2 / XIxXXX0x03.xoXoI());
    }

    public void OO0x0xX(xIoXXXIXo.IIXOooo iIXOooo) {
        this.f28745X0IIOO = new xIoXXXIXo.xoXoI(iIXOooo.X0o0xo(), this);
        oxIIX0o oxiix0o = new oxIIX0o(iIXOooo, this);
        oxiix0o.IXxxXO(this.f28749XO);
        oxiix0o.OxxIIOOXO(this.f28756oxoX);
        oxiix0o.IIXOooo(this.f28734II0XooXoX);
        oxiix0o.o00(this.f28761xxIXOIIO);
        oxiix0o.OxI(this.f28758x0xO0oo);
        oxiix0o.Oo(this.f28740Oo);
        oxiix0o.O0xOxO(this.f28747XI0IXoo);
        oxiix0o.oI0IIXIo(this.f28737IXxxXO);
        oxiix0o.xoXoI(this.f28743Oxx0xo);
        oxiix0o.Oxx0xo(this.f28751oI0IIXIo);
        oxiix0o.X0IIOO(this.f28736IIXOooo);
        oxiix0o.II0xO0();
        this.f28753oO = oxiix0o.xxIXOIIO();
        this.f28760xoXoI = oxiix0o.II0XooXoX();
        this.f28754oOoXoXO = oxiix0o.oOoXoXO();
        this.f28757x0XOIxOo = oxiix0o.x0xO0oo();
        this.f28755ooOOo0oXI = oxiix0o.Oxx0IOOO();
        this.f28759xoIox = oxiix0o.ooOOo0oXI();
        this.f28744OxxIIOOXO = oxiix0o.XO();
        this.f28741OxI = oxiix0o.OOXIXo();
        this.f28738O0xOxO = oxiix0o.xoIox();
    }

    @Override // xIoXXXIXo.IIXOooo
    public xIoXXXIXo.OxxIIOOXO[] OOXIXo() {
        return this.f28761xxIXOIIO.oxoX();
    }

    public oXIO0o0XI OOXIxO0(int i) throws RowsExceededException {
        if (i < 65536) {
            oXIO0o0XI[] oxio0o0xiArr = this.f28733I0Io;
            if (i >= oxio0o0xiArr.length) {
                oXIO0o0XI[] oxio0o0xiArr2 = new oXIO0o0XI[Math.max(oxio0o0xiArr.length + 10, i + 1)];
                this.f28733I0Io = oxio0o0xiArr2;
                System.arraycopy(oxio0o0xiArr, 0, oxio0o0xiArr2, 0, oxio0o0xiArr.length);
            }
            oXIO0o0XI oxio0o0xi = this.f28733I0Io[i];
            if (oxio0o0xi == null) {
                oXIO0o0XI oxio0o0xi2 = new oXIO0o0XI(i, this);
                this.f28733I0Io[i] = oxio0o0xi2;
                return oxio0o0xi2;
            }
            return oxio0o0xi;
        }
        throw new RowsExceededException();
    }

    public boolean OX00O0xII() {
        return this.f28757x0XOIxOo;
    }

    @Override // xIoXXXIXo.IIXOooo
    public xIoXXXIXo.II0XooXoX Oo(int i) {
        xIoXXXIXo.II0XooXoX iI0XooXoX = new xIoXXXIXo.II0XooXoX();
        try {
            oXIO0o0XI OOXIxO02 = OOXIxO0(i);
            if (OOXIxO02 != null && !OOXIxO02.xxIO()) {
                if (OOXIxO02.Ioxxx()) {
                    iI0XooXoX.xoIox(true);
                } else {
                    iI0XooXoX.II0XooXoX(OOXIxO02.xoxXI());
                    iI0XooXoX.OOXIXo(OOXIxO02.xoxXI());
                }
                return iI0XooXoX;
            }
            iI0XooXoX.II0XooXoX(this.f28745X0IIOO.XO());
            iI0XooXoX.OOXIXo(this.f28745X0IIOO.XO());
            return iI0XooXoX;
        } catch (RowsExceededException unused) {
            iI0XooXoX.II0XooXoX(this.f28745X0IIOO.XO());
            iI0XooXoX.OOXIXo(this.f28745X0IIOO.XO());
            return iI0XooXoX;
        }
    }

    @Override // oIXoXx0.O0xOxO
    public void OxI(int i, int i2, oI0X0.X0o0xo x0o0xo) {
        xIoXXXIXo.II0XooXoX iI0XooXoX = new xIoXXXIXo.II0XooXoX();
        iI0XooXoX.OOXIXo(i2 * 256);
        iI0XooXoX.xxIXOIIO(x0o0xo);
        Oxx0xo(i, iI0XooXoX);
    }

    @Override // oIXoXx0.O0xOxO
    public void Oxx0IOOO(String str, String str2, String str3) {
        xIoXXXIXo.x0XOIxOo x0xoixoo = new xIoXXXIXo.x0XOIxOo();
        x0xoixoo.xxIXOIIO().oIX0oI(str);
        x0xoixoo.II0XooXoX().oIX0oI(str2);
        x0xoixoo.xoIox().oIX0oI(str3);
        this.f28745X0IIOO.xXOx(x0xoixoo);
    }

    @Override // oIXoXx0.O0xOxO
    public void Oxx0xo(int i, xIoXXXIXo.II0XooXoX iI0XooXoX) {
        int oxoX2;
        OoIXo.XX xx2 = (OoIXo.XX) iI0XooXoX.I0Io();
        if (xx2 == null) {
            xx2 = IIxOXoOo0().o0().Oxx0IOOO();
        }
        try {
            if (!xx2.isInitialized()) {
                this.f28756oxoX.II0xO0(xx2);
            }
            if (iI0XooXoX.oIX0oI()) {
                oxoX2 = iI0XooXoX.II0xO0() * 256;
            } else {
                oxoX2 = iI0XooXoX.oxoX();
            }
            if (iI0XooXoX.X0o0xo()) {
                this.f28742Oxx0IOOO.add(new Integer(i));
            }
            oO oOVar = new oO(i, oxoX2, xx2);
            if (iI0XooXoX.XO()) {
                oOVar.XIo0oOXIx(true);
            }
            if (!this.f28749XO.contains(oOVar)) {
                this.f28749XO.add(oOVar);
            } else {
                this.f28749XO.remove(oOVar);
                this.f28749XO.add(oOVar);
            }
        } catch (NumFormatRecordsException unused) {
            f28728XxX0x0xxx.ooOOo0oXI("Maximum number of format records exceeded.  Using default format.");
            oO oOVar2 = new oO(i, iI0XooXoX.II0xO0() * 256, oIXoXx0.X0IIOO.f31668I0Io);
            if (!this.f28749XO.contains(oOVar2)) {
                this.f28749XO.add(oOVar2);
            }
        }
    }

    @Override // xIoXXXIXo.IIXOooo
    public int OxxIIOOXO() {
        return this.f28759xoIox;
    }

    @Override // oIXoXx0.O0xOxO
    public void X00IoxXI(oIXoXx0.OxI oxI) {
        String str;
        boolean z;
        File IXxxXO2 = oxI.IXxxXO();
        int i = 1;
        if (IXxxXO2 != null) {
            String name = IXxxXO2.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf != -1) {
                str = name.substring(lastIndexOf + 1);
            } else {
                str = "";
            }
            int i2 = 0;
            z = false;
            while (true) {
                String[] strArr = f28729oo0xXOI0I;
                if (i2 >= strArr.length || z) {
                    break;
                }
                if (str.equalsIgnoreCase(strArr[i2])) {
                    z = true;
                }
                i2++;
            }
        } else {
            str = LocationInfo.NA;
            z = true;
        }
        if (z) {
            this.f28762xxX.IIX0o(oxI);
            this.f28737IXxxXO.add(oxI);
            this.f28743Oxx0xo.add(oxI);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer("Image type ");
        stringBuffer.append(str);
        stringBuffer.append(" not supported.  Supported types are ");
        stringBuffer.append(f28729oo0xXOI0I[0]);
        while (true) {
            String[] strArr2 = f28729oo0xXOI0I;
            if (i < strArr2.length) {
                stringBuffer.append(", ");
                stringBuffer.append(strArr2[i]);
                i++;
            } else {
                f28728XxX0x0xxx.ooOOo0oXI(stringBuffer.toString());
                return;
            }
        }
    }

    @Override // xIoXXXIXo.IIXOooo
    public xIoXXXIXo.II0XooXoX X0IIOO(int i) {
        oO Ioxxx2 = Ioxxx(i);
        xIoXXXIXo.II0XooXoX iI0XooXoX = new xIoXXXIXo.II0XooXoX();
        if (Ioxxx2 != null) {
            iI0XooXoX.II0XooXoX(Ioxxx2.I0oOIX() / 256);
            iI0XooXoX.OOXIXo(Ioxxx2.I0oOIX());
            iI0XooXoX.xoIox(Ioxxx2.XoI0Ixx0());
            iI0XooXoX.xxIXOIIO(Ioxxx2.oX());
        } else {
            iI0XooXoX.II0XooXoX(this.f28745X0IIOO.oxoX() / 256);
            iI0XooXoX.OOXIXo(this.f28745X0IIOO.oxoX() * 256);
        }
        return iI0XooXoX;
    }

    @Override // xIoXXXIXo.IIXOooo
    public xIoXXXIXo.xoXoI X0o0xo() {
        return this.f28745X0IIOO;
    }

    @Override // oIXoXx0.O0xOxO
    public void XI0IXoo(xIoXXXIXo.OxxIIOOXO oxxIIOOXO) {
        this.f28761xxIXOIIO.xxIXOIIO(oxxIIOOXO);
    }

    public oXIO0o0XI XI0oooXX(int i) {
        if (i >= 0) {
            oXIO0o0XI[] oxio0o0xiArr = this.f28733I0Io;
            if (i <= oxio0o0xiArr.length) {
                return oxio0o0xiArr[i];
            }
            return null;
        }
        return null;
    }

    public void XIXIX(X0xOO.xoXoI xoxoi) {
        int size = this.f28737IXxxXO.size();
        this.f28737IXxxXO.remove(xoxoi);
        int size2 = this.f28737IXxxXO.size();
        boolean z = true;
        this.f28750o00 = true;
        if (size2 != size - 1) {
            z = false;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
    }

    public X0xOO.X0o0xo[] XIo0oOXIx() {
        return this.f28747XI0IXoo.II0xO0();
    }

    @Override // oIXoXx0.O0xOxO
    public void XIxXXX0x0(int i) {
        if (i >= 0 && i < this.f28739OOXIXo) {
            for (int i2 = 0; i2 < this.f28759xoIox; i2++) {
                oXIO0o0XI oxio0o0xi = this.f28733I0Io[i2];
                if (oxio0o0xi != null) {
                    oxio0o0xi.ox(i);
                }
            }
            Iterator it = this.f28734II0XooXoX.iterator();
            while (it.hasNext()) {
                XOxIOxOx xOxIOxOx = (XOxIOxOx) it.next();
                if (xOxIOxOx.oIX0oI() == i && xOxIOxOx.Xx000oIo() == i) {
                    it.remove();
                } else {
                    xOxIOxOx.x0xO(i);
                }
            }
            OoIXo.OxxIIOOXO oxxIIOOXO = this.f28753oO;
            if (oxxIIOOXO != null) {
                oxxIIOOXO.II0XooXoX(i);
            }
            ArrayList arrayList = this.f28736IIXOooo;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it2 = this.f28736IIXOooo.iterator();
                while (it2.hasNext()) {
                    xIoXXXIXo.oxoX XO2 = ((oOoXoXO) it2.next()).XO();
                    if (XO2.XO() != null) {
                        XO2.XO().oOoXoXO(i);
                    }
                }
            }
            this.f28761xxIXOIIO.Oxx0IOOO(i);
            ArrayList arrayList2 = new ArrayList();
            Iterator it3 = this.f28740Oo.iterator();
            while (it3.hasNext()) {
                int intValue = ((Integer) it3.next()).intValue();
                if (intValue != i) {
                    if (intValue > i) {
                        intValue--;
                    }
                    arrayList2.add(new Integer(intValue));
                }
            }
            this.f28740Oo = arrayList2;
            Iterator it4 = this.f28749XO.iterator();
            oO oOVar = null;
            while (it4.hasNext()) {
                oO oOVar2 = (oO) it4.next();
                if (oOVar2.oIX0oI() == i) {
                    oOVar = oOVar2;
                } else if (oOVar2.oIX0oI() > i) {
                    oOVar2.XX0();
                }
            }
            if (oOVar != null) {
                this.f28749XO.remove(oOVar);
            }
            if (this.f28742Oxx0IOOO.size() > 0) {
                TreeSet treeSet = new TreeSet();
                Iterator it5 = this.f28742Oxx0IOOO.iterator();
                while (it5.hasNext()) {
                    Integer num = (Integer) it5.next();
                    if (num.intValue() != i) {
                        if (num.intValue() > i) {
                            treeSet.add(new Integer(num.intValue() - 1));
                        } else {
                            treeSet.add(num);
                        }
                    }
                }
                this.f28742Oxx0IOOO = treeSet;
            }
            Iterator it6 = this.f28751oI0IIXIo.iterator();
            while (it6.hasNext()) {
                ((OoIXo.ooOOo0oXI) it6.next()).oxoX(i);
            }
            if (this.f28748XIxXXX0x0.xoIox()) {
                this.f28762xxX.oOXoIIIo(this, i);
            }
            this.f28739OOXIXo--;
        }
    }

    @Override // xIoXXXIXo.IIXOooo
    public int[] XO() {
        int[] iArr = new int[this.f28740Oo.size()];
        Iterator it = this.f28740Oo.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = ((Integer) it.next()).intValue();
            i++;
        }
        return iArr;
    }

    @Override // oIXoXx0.O0xOxO
    public void XOxIOxOx(int i) {
        if (i >= 0 && i < this.f28759xoIox) {
            oXIO0o0XI[] oxio0o0xiArr = this.f28733I0Io;
            oXIO0o0XI[] oxio0o0xiArr2 = new oXIO0o0XI[oxio0o0xiArr.length];
            this.f28733I0Io = oxio0o0xiArr2;
            System.arraycopy(oxio0o0xiArr, 0, oxio0o0xiArr2, 0, i);
            int i2 = i + 1;
            System.arraycopy(oxio0o0xiArr, i2, this.f28733I0Io, i, this.f28759xoIox - i2);
            for (int i3 = i; i3 < this.f28759xoIox; i3++) {
                oXIO0o0XI oxio0o0xi = this.f28733I0Io[i3];
                if (oxio0o0xi != null) {
                    oxio0o0xi.oX();
                }
            }
            Iterator it = this.f28734II0XooXoX.iterator();
            while (it.hasNext()) {
                XOxIOxOx xOxIOxOx = (XOxIOxOx) it.next();
                if (xOxIOxOx.II0xO0() == i && xOxIOxOx.Oxx0xo() == i) {
                    it.remove();
                } else {
                    xOxIOxOx.OO0x0xX(i);
                }
            }
            OoIXo.OxxIIOOXO oxxIIOOXO = this.f28753oO;
            if (oxxIIOOXO != null) {
                oxxIIOOXO.xoIox(i);
            }
            ArrayList arrayList = this.f28736IIXOooo;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it2 = this.f28736IIXOooo.iterator();
                while (it2.hasNext()) {
                    xIoXXXIXo.oxoX XO2 = ((oOoXoXO) it2.next()).XO();
                    if (XO2.XO() != null) {
                        XO2.XO().ooOOo0oXI(i);
                    }
                }
            }
            this.f28761xxIXOIIO.II0XooXoX(i);
            ArrayList arrayList2 = new ArrayList();
            Iterator it3 = this.f28758x0xO0oo.iterator();
            while (it3.hasNext()) {
                int intValue = ((Integer) it3.next()).intValue();
                if (intValue != i) {
                    if (intValue > i) {
                        intValue--;
                    }
                    arrayList2.add(new Integer(intValue));
                }
            }
            this.f28758x0xO0oo = arrayList2;
            Iterator it4 = this.f28751oI0IIXIo.iterator();
            while (it4.hasNext()) {
                ((OoIXo.ooOOo0oXI) it4.next()).X0o0xo(i);
            }
            if (this.f28748XIxXXX0x0.xoIox()) {
                this.f28762xxX.XoX(this, i);
            }
            this.f28759xoIox--;
            return;
        }
        if (this.f28748XIxXXX0x0.xoIox()) {
            this.f28762xxX.XoX(this, i);
        }
    }

    @Override // xIoXXXIXo.IIXOooo
    public xIoXXXIXo.I0Io XX(int i, int i2) {
        return xoIox(i, i2);
    }

    @Override // oIXoXx0.O0xOxO
    public void XX0(oIXoXx0.oI0IIXIo oi0iixio) throws WriteException {
        oIXoXx0.OxxIIOOXO Io2 = oi0iixio.Io();
        if (Io2 != null && Io2.xxIXOIIO()) {
            OoIXo.Oxx0xo XO2 = Io2.XO();
            if (!XO2.I0Io()) {
                Io2.oOoXoXO();
                return;
            }
            if (XO2.I0Io() && (oi0iixio.oIX0oI() != XO2.X0o0xo() || oi0iixio.II0xO0() != XO2.XO())) {
                f28728XxX0x0xxx.ooOOo0oXI("Cannot remove data validation from " + xIoXXXIXo.XO.oIX0oI(XO2.X0o0xo(), XO2.XO()) + HelpFormatter.DEFAULT_OPT_PREFIX + xIoXXXIXo.XO.oIX0oI(XO2.Oxx0IOOO(), XO2.II0XooXoX()) + " because the selected cell " + xIoXXXIXo.XO.oxoX(oi0iixio) + " is not the top left cell in the range");
                return;
            }
            for (int XO3 = XO2.XO(); XO3 <= XO2.II0XooXoX(); XO3++) {
                for (int X0o0xo2 = XO2.X0o0xo(); X0o0xo2 <= XO2.Oxx0IOOO(); X0o0xo2++) {
                    oOoXoXO Xo02 = this.f28733I0Io[XO3].Xo0(X0o0xo2);
                    if (Xo02 != null) {
                        Xo02.Io().ooOOo0oXI();
                        Xo02.x0xO();
                    }
                }
            }
            OoIXo.OxxIIOOXO oxxIIOOXO = this.f28753oO;
            if (oxxIIOOXO != null) {
                oxxIIOOXO.OOXIXo(XO2.X0o0xo(), XO2.XO(), XO2.Oxx0IOOO(), XO2.II0XooXoX());
            }
        }
    }

    public OoIXo.OxxIIOOXO XX0xXo() {
        return this.f28753oO;
    }

    @Override // oIXoXx0.O0xOxO
    public void Xo0(int i, int i2) {
        xIoXXXIXo.II0XooXoX iI0XooXoX = new xIoXXXIXo.II0XooXoX();
        iI0XooXoX.OOXIXo(i2 * 256);
        Oxx0xo(i, iI0XooXoX);
    }

    @Override // xIoXXXIXo.IIXOooo
    public int XoI0Ixx0() {
        return this.f28739OOXIXo;
    }

    @Override // oIXoXx0.O0xOxO
    public void XoX(oI0X0.OOXIXo oOXIXo) {
        this.f28745X0IIOO.IoOoo(oOXIXo);
    }

    @Override // oIXoXx0.O0xOxO
    public void Xx000oIo(int i) {
        Iterator it = this.f28758x0xO0oo.iterator();
        boolean z = false;
        while (it.hasNext() && !z) {
            if (((Integer) it.next()).intValue() == i) {
                z = true;
            }
        }
        if (!z) {
            this.f28758x0xO0oo.add(new Integer(i));
        }
    }

    @Override // xIoXXXIXo.IIXOooo
    public boolean XxX0x0xxx() {
        return this.f28745X0IIOO.xII();
    }

    @Override // xIoXXXIXo.IIXOooo
    public String getName() {
        return this.f28752oIX0oI;
    }

    @Override // xIoXXXIXo.IIXOooo
    public boolean isHidden() {
        return this.f28745X0IIOO.X00IoxXI();
    }

    @Override // oIXoXx0.O0xOxO
    public void o0(oIXoXx0.o00 o00Var) {
        II0XooXoX(o00Var, false);
    }

    @Override // oIXoXx0.O0xOxO
    public void o00(oIXoXx0.oI0IIXIo oi0iixio) throws WriteException, RowsExceededException {
        boolean z;
        if (oi0iixio.getType() == xIoXXXIXo.Oxx0IOOO.f34234II0xO0 && oi0iixio.xoIox() == null) {
            return;
        }
        oOoXoXO oooxoxo = (oOoXoXO) oi0iixio;
        if (!oooxoxo.xoIxX()) {
            int II0xO02 = oi0iixio.II0xO0();
            oXIO0o0XI OOXIxO02 = OOXIxO0(II0xO02);
            oOoXoXO Xo02 = OOXIxO02.Xo0(oooxoxo.oIX0oI());
            if (Xo02 != null && Xo02.XO() != null && Xo02.XO().XO() != null && Xo02.XO().XO().I0Io()) {
                z = true;
            } else {
                z = false;
            }
            if (oi0iixio.XO() != null && oi0iixio.XO().xxIXOIIO() && z) {
                OoIXo.Oxx0xo XO2 = Xo02.XO().XO();
                f28728XxX0x0xxx.ooOOo0oXI("Cannot add cell at " + xIoXXXIXo.XO.oxoX(oooxoxo) + " because it is part of the shared cell validation group " + xIoXXXIXo.XO.oIX0oI(XO2.X0o0xo(), XO2.XO()) + HelpFormatter.DEFAULT_OPT_PREFIX + xIoXXXIXo.XO.oIX0oI(XO2.Oxx0IOOO(), XO2.II0XooXoX()));
                return;
            }
            if (z) {
                oIXoXx0.OxxIIOOXO Io2 = oi0iixio.Io();
                if (Io2 == null) {
                    Io2 = new oIXoXx0.OxxIIOOXO();
                    oi0iixio.xxIXOIIO(Io2);
                }
                Io2.O0xOxO(Xo02.XO());
            }
            OOXIxO02.XX0(oooxoxo);
            this.f28759xoIox = Math.max(II0xO02 + 1, this.f28759xoIox);
            this.f28739OOXIXo = Math.max(this.f28739OOXIXo, OOXIxO02.O0Xx());
            oooxoxo.XX0xXo(this.f28756oxoX, this.f28746X0o0xo, this);
            return;
        }
        throw new JxlWriteException(JxlWriteException.cellReferenced);
    }

    @Override // oIXoXx0.O0xOxO
    public void oI0IIXIo(oIXoXx0.OxI oxI) {
        this.f28737IXxxXO.remove(oxI);
        this.f28743Oxx0xo.remove(oxI);
        this.f28750o00 = true;
        this.f28762xxX.I0oOoX(oxI);
    }

    @Override // oIXoXx0.O0xOxO, xIoXXXIXo.IIXOooo
    public int oIX0oI() {
        return this.f28743Oxx0xo.size();
    }

    @Override // oIXoXx0.O0xOxO
    public void oO(String str, String str2, String str3) {
        xIoXXXIXo.x0XOIxOo x0xoixoo = new xIoXXXIXo.x0XOIxOo();
        x0xoixoo.xxIXOIIO().oIX0oI(str);
        x0xoixoo.II0XooXoX().oIX0oI(str2);
        x0xoixoo.xoIox().oIX0oI(str3);
        this.f28745X0IIOO.I0X0x0oIo(x0xoixoo);
    }

    @Override // oIXoXx0.O0xOxO
    public void oOXoIIIo(boolean z) {
        this.f28745X0IIOO.I0(z);
    }

    public void oOo() {
        this.f28745X0IIOO.xX0IIXIx0();
    }

    @Override // xIoXXXIXo.IIXOooo
    public xIoXXXIXo.IXxxXO oOoXoXO(String str) {
        return new OoIXo.OOXIXo(this).oxoX(str);
    }

    @Override // xIoXXXIXo.IIXOooo
    public xIoXXXIXo.I0Io oX(String str, int i, int i2, int i3, int i4, boolean z) {
        return new OoIXo.OOXIXo(this).II0xO0(str, i, i2, i3, i4, z);
    }

    public void oXIO0o0XI(X0xOO.oOoXoXO oooxoxo) {
        this.f28760xoXoI = oooxoxo;
    }

    @Override // oIXoXx0.O0xOxO
    public void oo(oI0X0.OOXIXo oOXIXo, double d, double d2) {
        this.f28745X0IIOO.IoOoo(oOXIXo);
        this.f28745X0IIOO.oX(d);
        this.f28745X0IIOO.XX0(d2);
    }

    @Override // oIXoXx0.O0xOxO
    public void oo0xXOI0I(int i, boolean z) throws RowsExceededException {
        xIoXXXIXo.II0XooXoX iI0XooXoX = new xIoXXXIXo.II0XooXoX();
        iI0XooXoX.xoIox(z);
        xoXoI(i, iI0XooXoX);
    }

    @Override // oIXoXx0.O0xOxO
    public void ooOOo0oXI(int i, int i2, boolean z) throws WriteException, RowsExceededException {
        if (i2 < i) {
            f28728XxX0x0xxx.ooOOo0oXI("Cannot merge cells - top and bottom rows incorrectly specified");
        }
        while (i <= i2) {
            oO Ioxxx2 = Ioxxx(i);
            if (Ioxxx2 == null) {
                Oxx0xo(i, new xIoXXXIXo.II0XooXoX());
                Ioxxx2 = Ioxxx(i);
            }
            Ioxxx2.IoOoo();
            Ioxxx2.OO0x0xX(z);
            this.f28738O0xOxO = Math.max(this.f28738O0xOxO, Ioxxx2.O0Xx());
            i++;
        }
    }

    @Override // xIoXXXIXo.IIXOooo
    public int[] ooXIXxIX() {
        int[] iArr = new int[this.f28758x0xO0oo.size()];
        Iterator it = this.f28758x0xO0oo.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = ((Integer) it.next()).intValue();
            i++;
        }
        return iArr;
    }

    public final X00IoxXI ox() {
        return this.f28747XI0IXoo.X0o0xo();
    }

    @Override // oIXoXx0.O0xOxO
    public void oxXx0IX(oI0X0.OOXIXo oOXIXo, oI0X0.oOoXoXO oooxoxo, double d, double d2) {
        this.f28745X0IIOO.Ioxxx(oooxoxo);
        this.f28745X0IIOO.IoOoo(oOXIXo);
        this.f28745X0IIOO.oX(d);
        this.f28745X0IIOO.XX0(d2);
    }

    @Override // oIXoXx0.O0xOxO
    public oIXoXx0.OxI oxoX(int i) {
        return (oIXoXx0.OxI) this.f28743Oxx0xo.get(i);
    }

    @Override // xIoXXXIXo.IIXOooo
    public xIoXXXIXo.I0Io oxxXoxO(String str) {
        return new OoIXo.OOXIXo(this).oIX0oI(str);
    }

    @Override // oIXoXx0.O0xOxO
    public void setName(String str) {
        this.f28752oIX0oI = str;
    }

    @Override // oIXoXx0.O0xOxO
    public void x0XOIxOo(int i, int i2, boolean z) throws RowsExceededException {
        xIoXXXIXo.II0XooXoX iI0XooXoX = new xIoXXXIXo.II0XooXoX();
        iI0XooXoX.OOXIXo(i2);
        iI0XooXoX.xoIox(z);
        xoXoI(i, iI0XooXoX);
    }

    @Override // xIoXXXIXo.IIXOooo
    public xIoXXXIXo.I0Io[] x0o(int i) {
        int i2 = this.f28739OOXIXo - 1;
        boolean z = false;
        while (i2 >= 0 && !z) {
            if (XX(i2, i).getType() != xIoXXXIXo.Oxx0IOOO.f34234II0xO0) {
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

    public void x0xO(oIXoXx0.O0xOxO o0xOxO) {
        this.f28745X0IIOO = new xIoXXXIXo.xoXoI(o0xOxO.X0o0xo(), this);
        XOxxooXI xOxxooXI = (XOxxooXI) o0xOxO;
        oXxOI0oIx oxxoi0oix = new oXxOI0oIx(o0xOxO, this);
        oxxoi0oix.ooOOo0oXI(xOxxooXI.f28749XO, this.f28749XO);
        oxxoi0oix.Oo(xOxxooXI.f28761xxIXOIIO, this.f28761xxIXOIIO);
        oxxoi0oix.oI0IIXIo(xOxxooXI.f28733I0Io);
        oxxoi0oix.Oxx0xo(xOxxooXI.f28758x0xO0oo, this.f28758x0xO0oo);
        oxxoi0oix.oOoXoXO(xOxxooXI.f28740Oo, this.f28740Oo);
        oxxoi0oix.x0XOIxOo(xOxxooXI.f28753oO);
        oxxoi0oix.OxxIIOOXO(this.f28747XI0IXoo);
        oxxoi0oix.oO(xOxxooXI.f28737IXxxXO, this.f28737IXxxXO, this.f28743Oxx0xo);
        oxxoi0oix.xoXoI(xOxxooXI.ooOx());
        oxxoi0oix.IXxxXO(xOxxooXI.f28754oOoXoXO);
        oxxoi0oix.OOXIXo(xOxxooXI.f28755ooOOo0oXI);
        oxxoi0oix.x0xO0oo(xOxxooXI.f28734II0XooXoX, this.f28734II0XooXoX);
        oxxoi0oix.IIXOooo(this.f28736IIXOooo);
        oxxoi0oix.II0xO0();
        this.f28753oO = oxxoi0oix.XO();
        this.f28754oOoXoXO = oxxoi0oix.xxIXOIIO();
        this.f28755ooOOo0oXI = oxxoi0oix.X0o0xo();
    }

    @Override // oIXoXx0.O0xOxO
    public void x0xO0oo(boolean z) {
        this.f28745X0IIOO.Xo0(z);
    }

    @Override // xIoXXXIXo.IIXOooo
    public xIoXXXIXo.x0xO0oo xI(int i) {
        return (xIoXXXIXo.x0xO0oo) this.f28743Oxx0xo.get(i);
    }

    @Override // oIXoXx0.O0xOxO
    public oIXoXx0.o00[] xII() {
        oIXoXx0.o00[] o00VarArr = new oIXoXx0.o00[this.f28734II0XooXoX.size()];
        for (int i = 0; i < this.f28734II0XooXoX.size(); i++) {
            o00VarArr[i] = (oIXoXx0.o00) this.f28734II0XooXoX.get(i);
        }
        return o00VarArr;
    }

    public void xOOOX(oOoXoXO oooxoxo) {
        OoIXo.OxxIIOOXO oxxIIOOXO = this.f28753oO;
        if (oxxIIOOXO != null) {
            oxxIIOOXO.xxIXOIIO(oooxoxo.oIX0oI(), oooxoxo.II0xO0());
        }
        ArrayList arrayList = this.f28736IIXOooo;
        if (arrayList != null && !arrayList.remove(oooxoxo)) {
            f28728XxX0x0xxx.ooOOo0oXI("Could not remove validated cell " + xIoXXXIXo.XO.oxoX(oooxoxo));
        }
    }

    public void xX0IIXIx0(OoIXo.xI xIVar, OoIXo.xI xIVar2, OoIXo.xI xIVar3) {
        Iterator it = this.f28749XO.iterator();
        while (it.hasNext()) {
            ((oO) it.next()).xoIxX(xIVar);
        }
        int i = 0;
        while (true) {
            oXIO0o0XI[] oxio0o0xiArr = this.f28733I0Io;
            if (i >= oxio0o0xiArr.length) {
                break;
            }
            oXIO0o0XI oxio0o0xi = oxio0o0xiArr[i];
            if (oxio0o0xi != null) {
                oxio0o0xi.o0xxxXXxX(xIVar);
            }
            i++;
        }
        for (X0xOO.X0o0xo x0o0xo : XIo0oOXIx()) {
            x0o0xo.XO(xIVar, xIVar2, xIVar3);
        }
    }

    @Override // oIXoXx0.O0xOxO
    public void xXOx(int i, int i2) throws WriteException, RowsExceededException {
        if (i2 < i) {
            f28728XxX0x0xxx.ooOOo0oXI("Cannot merge cells - top and bottom rows incorrectly specified");
        }
        while (i <= i2) {
            Ioxxx(i).I0X0x0oIo();
            i++;
        }
        this.f28738O0xOxO = 0;
        Iterator it = this.f28749XO.iterator();
        while (it.hasNext()) {
            this.f28738O0xOxO = Math.max(this.f28738O0xOxO, ((oO) it.next()).O0Xx());
        }
    }

    @Override // oIXoXx0.O0xOxO
    public void xXxxox0I(int i, int i2, boolean z) throws WriteException, RowsExceededException {
        if (i2 < i) {
            f28728XxX0x0xxx.ooOOo0oXI("Cannot merge cells - top and bottom rows incorrectly specified");
        }
        while (i <= i2) {
            oXIO0o0XI OOXIxO02 = OOXIxO0(i);
            i++;
            this.f28759xoIox = Math.max(i, this.f28759xoIox);
            OOXIxO02.x0xO();
            OOXIxO02.XI0oooXX(z);
            this.f28741OxI = Math.max(this.f28741OxI, OOXIxO02.I0oOIX());
        }
    }

    @Override // oIXoXx0.O0xOxO
    public void xo0x(int i, int i2) throws WriteException, RowsExceededException {
        if (i2 < i) {
            f28728XxX0x0xxx.ooOOo0oXI("Cannot merge cells - top and bottom rows incorrectly specified");
        }
        if (i2 >= this.f28759xoIox) {
            f28728XxX0x0xxx.ooOOo0oXI("" + i2 + " is greater than the sheet bounds");
            i2 = this.f28759xoIox + (-1);
        }
        while (i <= i2) {
            this.f28733I0Io[i].I0X0x0oIo();
            i++;
        }
        this.f28741OxI = 0;
        int length = this.f28733I0Io.length;
        while (true) {
            int i3 = length - 1;
            if (length > 0) {
                this.f28741OxI = Math.max(this.f28741OxI, this.f28733I0Io[i3].I0oOIX());
                length = i3;
            } else {
                return;
            }
        }
    }

    @Override // oIXoXx0.O0xOxO
    public oIXoXx0.oI0IIXIo xoIox(int i, int i2) {
        oOoXoXO oooxoxo;
        oXIO0o0XI oxio0o0xi;
        oXIO0o0XI[] oxio0o0xiArr = this.f28733I0Io;
        if (i2 < oxio0o0xiArr.length && (oxio0o0xi = oxio0o0xiArr[i2]) != null) {
            oooxoxo = oxio0o0xi.Xo0(i);
        } else {
            oooxoxo = null;
        }
        if (oooxoxo == null) {
            return new OoIXo.O0xOxO(i, i2);
        }
        return oooxoxo;
    }

    public void xoIxX() {
        this.f28747XI0IXoo.IXxxXO(this.f28733I0Io, this.f28758x0xO0oo, this.f28740Oo, this.f28734II0XooXoX, this.f28761xxIXOIIO, this.f28749XO, this.f28741OxI, this.f28738O0xOxO);
        this.f28747XI0IXoo.ooOOo0oXI(OxxIIOOXO(), XoI0Ixx0());
        this.f28747XI0IXoo.oIX0oI();
    }

    public void xoO0xx0(xIoXXXIXo.IIXOooo iIXOooo) {
        this.f28745X0IIOO = new xIoXXXIXo.xoXoI(iIXOooo.X0o0xo(), this);
        oxIIX0o oxiix0o = new oxIIX0o(iIXOooo, this);
        oxiix0o.IXxxXO(this.f28749XO);
        oxiix0o.OxxIIOOXO(this.f28756oxoX);
        oxiix0o.IIXOooo(this.f28734II0XooXoX);
        oxiix0o.o00(this.f28761xxIXOIIO);
        oxiix0o.OxI(this.f28758x0xO0oo);
        oxiix0o.Oo(this.f28740Oo);
        oxiix0o.O0xOxO(this.f28747XI0IXoo);
        oxiix0o.oI0IIXIo(this.f28737IXxxXO);
        oxiix0o.xoXoI(this.f28743Oxx0xo);
        oxiix0o.X0IIOO(this.f28736IIXOooo);
        oxiix0o.oO();
        this.f28753oO = oxiix0o.xxIXOIIO();
        this.f28760xoXoI = oxiix0o.II0XooXoX();
        this.f28754oOoXoXO = oxiix0o.oOoXoXO();
        this.f28757x0XOIxOo = oxiix0o.x0xO0oo();
        this.f28755ooOOo0oXI = oxiix0o.Oxx0IOOO();
        this.f28759xoIox = oxiix0o.ooOOo0oXI();
        this.f28741OxI = oxiix0o.OOXIXo();
        this.f28738O0xOxO = oxiix0o.xoIox();
    }

    @Override // oIXoXx0.O0xOxO
    public void xoXoI(int i, xIoXXXIXo.II0XooXoX iI0XooXoX) throws RowsExceededException {
        oXIO0o0XI OOXIxO02 = OOXIxO0(i);
        OoIXo.XX xx2 = (OoIXo.XX) iI0XooXoX.I0Io();
        if (xx2 != null) {
            try {
                if (!xx2.isInitialized()) {
                    this.f28756oxoX.II0xO0(xx2);
                }
            } catch (NumFormatRecordsException unused) {
                f28728XxX0x0xxx.ooOOo0oXI("Maximum number of format records exceeded.  Using default format.");
                xx2 = null;
            }
        }
        OOXIxO02.I0(iI0XooXoX.oxoX(), false, iI0XooXoX.XO(), 0, false, xx2);
        this.f28759xoIox = Math.max(this.f28759xoIox, i + 1);
    }

    public void xoxXI(oOoXoXO oooxoxo) {
        this.f28736IIXOooo.add(oooxoxo);
    }

    public X0xOO.oOoXoXO xxIO() {
        return this.f28760xoXoI;
    }

    @Override // oIXoXx0.O0xOxO
    public oIXoXx0.oI0IIXIo xxIXOIIO(String str) {
        return xoIox(xIoXXXIXo.XO.OOXIXo(str), xIoXXXIXo.XO.ooOOo0oXI(str));
    }

    @Override // xIoXXXIXo.IIXOooo
    public oI0X0.X0o0xo xxX(int i) {
        return X0IIOO(i).I0Io();
    }
}
