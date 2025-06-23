package jxl.write.biff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class oXIO0o0XI extends OoIXo.OI0 {

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f28867Oxx0xo = 10;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f28868OxxIIOOXO = -536870912;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f28869oI0IIXIo = 536870911;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public boolean f28871II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public int f28872OOXIXo;

    /* renamed from: Oo, reason: collision with root package name */
    public oIXoXx0.O0xOxO f28873Oo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f28874Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public byte[] f28875X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public oOoXoXO[] f28876XO;

    /* renamed from: oO, reason: collision with root package name */
    public int f28877oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public OoIXo.XX f28878oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public boolean f28879ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public boolean f28880x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public boolean f28881x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f28882xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f28883xxIXOIIO;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final XxIIOXIXx.X0o0xo f28866IXxxXO = XxIIOXIXx.X0o0xo.Oxx0IOOO(oXIO0o0XI.class);

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static int f28865IIXOooo = 255;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static int f28870xoXoI = 256;

    public oXIO0o0XI(int i, oIXoXx0.O0xOxO o0xOxO) {
        super(OoIXo.xII.f2493oOoXoXO);
        this.f28883xxIXOIIO = i;
        this.f28876XO = new oOoXoXO[0];
        this.f28882xoIox = 0;
        this.f28874Oxx0IOOO = f28865IIXOooo;
        this.f28871II0XooXoX = false;
        this.f28880x0XOIxOo = true;
        this.f28873Oo = o0xOxO;
    }

    public void I0(int i, boolean z, boolean z2, int i2, boolean z3, OoIXo.XX xx2) {
        this.f28874Oxx0IOOO = i;
        this.f28871II0XooXoX = z2;
        this.f28880x0XOIxOo = z;
        this.f28877oO = i2;
        this.f28881x0xO0oo = z3;
        if (xx2 != null) {
            this.f28879ooOOo0oXI = true;
            this.f28878oOoXoXO = xx2;
            this.f28872OOXIXo = xx2.XoI0Ixx0();
        }
    }

    public void I0X0x0oIo() {
        int i = this.f28877oO;
        if (i > 0) {
            this.f28877oO = i - 1;
        }
        if (this.f28877oO == 0) {
            this.f28871II0XooXoX = false;
        }
    }

    public int I0oOIX() {
        return this.f28877oO;
    }

    public void IIxOXoOo0(int i) {
        this.f28877oO = i;
    }

    public OoIXo.XX IoOoo() {
        return this.f28878oOoXoXO;
    }

    public boolean Ioxxx() {
        return this.f28871II0XooXoX;
    }

    public void O00XxXI(int i) {
        if (i >= this.f28882xoIox) {
            return;
        }
        this.f28876XO[i] = null;
    }

    public int O0Xx() {
        return this.f28882xoIox;
    }

    public int OO() {
        return this.f28883xxIXOIIO;
    }

    public void OO0x0xX() {
        this.f28883xxIXOIIO++;
        int i = 0;
        while (true) {
            oOoXoXO[] oooxoxoArr = this.f28876XO;
            if (i < oooxoxoArr.length) {
                oOoXoXO oooxoxo = oooxoxoArr[i];
                if (oooxoxo != null) {
                    oooxoxo.IoOoo();
                }
                i++;
            } else {
                return;
            }
        }
    }

    public void OOXIxO0(boolean z) {
        this.f28881x0xO0oo = z;
    }

    public void OX00O0xII(IIX0o iIX0o) throws IOException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f28882xoIox; i++) {
            oOoXoXO oooxoxo = this.f28876XO[i];
            if (oooxoxo != null) {
                if (oooxoxo.getType() == xIoXXXIXo.Oxx0IOOO.f34240oxoX) {
                    oIXoXx0.x0XOIxOo x0xoixoo = (oIXoXx0.x0XOIxOo) this.f28876XO[i];
                    if (x0xoixoo.getValue() == ((int) x0xoixoo.getValue()) && x0xoixoo.getValue() < 5.36870911E8d && x0xoixoo.getValue() > -5.36870912E8d && x0xoixoo.XO() == null) {
                        arrayList.add(this.f28876XO[i]);
                    }
                }
                xX0IIXIx0(arrayList, iIX0o);
                iIX0o.XO(this.f28876XO[i]);
                if (this.f28876XO[i].getType() == xIoXXXIXo.Oxx0IOOO.f34242xxIXOIIO) {
                    iIX0o.XO(new OIOoIIOIx(this.f28876XO[i].IIX0o()));
                }
            } else {
                xX0IIXIx0(arrayList, iIX0o);
            }
        }
        xX0IIXIx0(arrayList, iIX0o);
    }

    public void XI0oooXX(boolean z) {
        this.f28871II0XooXoX = z;
    }

    public void XIo0oOXIx(int i) {
        int i2 = this.f28882xoIox;
        if (i >= i2) {
            return;
        }
        oOoXoXO[] oooxoxoArr = this.f28876XO;
        if (i2 >= oooxoxoArr.length - 1) {
            this.f28876XO = new oOoXoXO[oooxoxoArr.length + 10];
        } else {
            this.f28876XO = new oOoXoXO[oooxoxoArr.length];
        }
        System.arraycopy(oooxoxoArr, 0, this.f28876XO, 0, i);
        int i3 = i + 1;
        System.arraycopy(oooxoxoArr, i, this.f28876XO, i3, this.f28882xoIox - i);
        while (true) {
            int i4 = this.f28882xoIox;
            if (i3 <= i4) {
                oOoXoXO oooxoxo = this.f28876XO[i3];
                if (oooxoxo != null) {
                    oooxoxo.OO();
                }
                i3++;
            } else {
                this.f28882xoIox = Math.min(i4 + 1, f28870xoXoI);
                return;
            }
        }
    }

    public void XX0(oOoXoXO oooxoxo) {
        oIXoXx0.OxxIIOOXO Io2;
        int oIX0oI2 = oooxoxo.oIX0oI();
        if (oIX0oI2 >= f28870xoXoI) {
            f28866IXxxXO.ooOOo0oXI("Could not add cell at " + OoIXo.oOoXoXO.oIX0oI(oooxoxo.II0xO0(), oooxoxo.oIX0oI()) + " because it exceeds the maximum column limit");
            return;
        }
        oOoXoXO[] oooxoxoArr = this.f28876XO;
        if (oIX0oI2 >= oooxoxoArr.length) {
            oOoXoXO[] oooxoxoArr2 = new oOoXoXO[Math.max(oooxoxoArr.length + 10, oIX0oI2 + 1)];
            this.f28876XO = oooxoxoArr2;
            System.arraycopy(oooxoxoArr, 0, oooxoxoArr2, 0, oooxoxoArr.length);
        }
        oOoXoXO oooxoxo2 = this.f28876XO[oIX0oI2];
        if (oooxoxo2 != null && (Io2 = oooxoxo2.Io()) != null) {
            Io2.OOXIXo();
            if (Io2.XO() != null && !Io2.XO().I0Io()) {
                Io2.oOoXoXO();
            }
        }
        this.f28876XO[oIX0oI2] = oooxoxo;
        this.f28882xoIox = Math.max(oIX0oI2 + 1, this.f28882xoIox);
    }

    public boolean XX0xXo() {
        return this.f28880x0XOIxOo;
    }

    public oOoXoXO Xo0(int i) {
        if (i >= 0 && i < this.f28882xoIox) {
            return this.f28876XO[i];
        }
        return null;
    }

    public boolean XoI0Ixx0() {
        return this.f28881x0xO0oo;
    }

    public void o0xxxXXxX(OoIXo.xI xIVar) {
        if (this.f28879ooOOo0oXI) {
            this.f28872OOXIXo = xIVar.oIX0oI(this.f28872OOXIXo);
        }
    }

    public void oX() {
        this.f28883xxIXOIIO--;
        int i = 0;
        while (true) {
            oOoXoXO[] oooxoxoArr = this.f28876XO;
            if (i < oooxoxoArr.length) {
                oOoXoXO oooxoxo = oooxoxoArr[i];
                if (oooxoxo != null) {
                    oooxoxo.O0Xx();
                }
                i++;
            } else {
                return;
            }
        }
    }

    public void ooOx(int i) {
        if (i == 0) {
            XI0oooXX(true);
            this.f28880x0XOIxOo = false;
        } else {
            this.f28874Oxx0IOOO = i;
            this.f28880x0XOIxOo = false;
        }
    }

    public void ox(int i) {
        if (i >= this.f28882xoIox) {
            return;
        }
        oOoXoXO[] oooxoxoArr = this.f28876XO;
        oOoXoXO[] oooxoxoArr2 = new oOoXoXO[oooxoxoArr.length];
        this.f28876XO = oooxoxoArr2;
        System.arraycopy(oooxoxoArr, 0, oooxoxoArr2, 0, i);
        int i2 = i + 1;
        System.arraycopy(oooxoxoArr, i2, this.f28876XO, i, this.f28882xoIox - i2);
        while (true) {
            int i3 = this.f28882xoIox;
            if (i < i3) {
                oOoXoXO oooxoxo = this.f28876XO[i];
                if (oooxoxo != null) {
                    oooxoxo.XoI0Ixx0();
                }
                i++;
            } else {
                this.f28882xoIox = i3 - 1;
                return;
            }
        }
    }

    public void x0xO() {
        this.f28877oO++;
    }

    public final void xX0IIXIx0(ArrayList arrayList, IIX0o iIX0o) throws IOException {
        if (arrayList.size() == 0) {
            return;
        }
        if (arrayList.size() >= 3) {
            iIX0o.XO(new oX(arrayList));
        } else {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                iIX0o.XO((oOoXoXO) it.next());
            }
        }
        arrayList.clear();
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        byte[] bArr = new byte[16];
        int i = this.f28874Oxx0IOOO;
        if (this.f28873Oo.X0o0xo().XO() != 255 && i == f28865IIXOooo) {
            i = this.f28873Oo.X0o0xo().XO();
        }
        OoIXo.oo0xXOI0I.XO(this.f28883xxIXOIIO, bArr, 0);
        OoIXo.oo0xXOI0I.XO(this.f28882xoIox, bArr, 4);
        OoIXo.oo0xXOI0I.XO(i, bArr, 6);
        int i2 = this.f28877oO + 256;
        if (this.f28881x0xO0oo) {
            i2 |= 16;
        }
        if (this.f28871II0XooXoX) {
            i2 |= 32;
        }
        if (!this.f28880x0XOIxOo) {
            i2 |= 64;
        }
        if (this.f28879ooOOo0oXI) {
            i2 = i2 | 128 | (this.f28872OOXIXo << 16);
        }
        OoIXo.oo0xXOI0I.oIX0oI(i2, bArr, 12);
        return bArr;
    }

    public boolean xoIxX() {
        return this.f28879ooOOo0oXI;
    }

    public void xoO0xx0(IIX0o iIX0o) throws IOException {
        iIX0o.XO(this);
    }

    public int xoxXI() {
        return this.f28874Oxx0IOOO;
    }

    public boolean xxIO() {
        if (this.f28874Oxx0IOOO == f28865IIXOooo) {
            return true;
        }
        return false;
    }
}
