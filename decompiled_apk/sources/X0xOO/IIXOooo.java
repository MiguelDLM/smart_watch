package X0xOO;

import com.google.firebase.crashlytics.buildtools.ndk.internal.elf.EMachine;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import jxl.read.biff.xoxXI;

/* loaded from: classes6.dex */
public class IIXOooo implements xxX {

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f3311x0XOIxOo = XxIIOXIXx.X0o0xo.Oxx0IOOO(IIXOooo.class);

    /* renamed from: I0Io, reason: collision with root package name */
    public oIX0oI f3312I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f3313II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public OxI f3314II0xO0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public HashMap f3315OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f3316Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public ArrayList f3317X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f3318XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public byte[] f3319oIX0oI;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public int f3320oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public int f3321ooOOo0oXI;

    /* renamed from: oxoX, reason: collision with root package name */
    public boolean f3322oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public oo0xXOI0I f3323xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public boolean f3324xxIXOIIO;

    public IIXOooo(oo0xXOI0I oo0xxoi0i) {
        this.f3323xoIox = oo0xxoi0i;
        this.f3322oxoX = oo0xxoi0i == oo0xXOI0I.f3514II0xO0;
        this.f3317X0o0xo = new ArrayList();
        this.f3315OOXIXo = new HashMap();
        this.f3324xxIXOIIO = false;
        this.f3320oOoXoXO = 1;
        this.f3321ooOOo0oXI = 1024;
    }

    private void OOXIXo() {
        boolean z;
        boolean z2 = false;
        XI0IXoo xI0IXoo = new XI0IXoo(this, 0);
        XxIIOXIXx.oIX0oI.oIX0oI(xI0IXoo.xoIox());
        OxI oxI = new OxI(xI0IXoo);
        this.f3314II0xO0 = oxI;
        if (oxI.XO() == this.f3319oIX0oI.length) {
            z = true;
        } else {
            z = false;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
        if (this.f3314II0xO0.xxIXOIIO() == XIxXXX0x0.f3424oxoX) {
            z2 = true;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z2);
        this.f3322oxoX = true;
    }

    private void X0o0xo(byte[] bArr) {
        byte[] bArr2 = this.f3319oIX0oI;
        if (bArr2 == null) {
            byte[] bArr3 = new byte[bArr.length];
            this.f3319oIX0oI = bArr3;
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        } else {
            byte[] bArr4 = new byte[bArr2.length + bArr.length];
            System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length);
            System.arraycopy(bArr, 0, bArr4, this.f3319oIX0oI.length, bArr.length);
            this.f3319oIX0oI = bArr4;
        }
    }

    public void I0Io(XxX0x0xxx xxX0x0xxx) {
        X0o0xo(xxX0x0xxx.xo0x());
    }

    public byte[] II0XooXoX(int i) {
        boolean z;
        int Oxx0xo2 = Oxx0IOOO().Oxx0xo();
        this.f3318XO = Oxx0xo2;
        boolean z2 = false;
        if (i <= Oxx0xo2) {
            z = true;
        } else {
            z = false;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
        oo0xXOI0I oo0xxoi0i = this.f3323xoIox;
        if (oo0xxoi0i == oo0xXOI0I.f3515oIX0oI || oo0xxoi0i == oo0xXOI0I.f3513I0Io) {
            z2 = true;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z2);
        return ((II0xO0) Oxx0IOOO().oO()[i - 1]).x0xO0oo();
    }

    public void II0xO0(xoXoI xoxoi) {
        int i;
        if (this.f3323xoIox == oo0xXOI0I.f3515oIX0oI) {
            this.f3323xoIox = oo0xXOI0I.f3513I0Io;
            oIX0oI Oxx0IOOO2 = Oxx0IOOO();
            boolean z = false;
            this.f3313II0XooXoX = (((x0xO0oo) this.f3314II0xO0.oO()[0]).oO(1).f3619oIX0oI - this.f3318XO) - 1;
            if (Oxx0IOOO2 != null) {
                i = Oxx0IOOO2.Oxx0xo();
            } else {
                i = 0;
            }
            this.f3318XO = i;
            if (Oxx0IOOO2 != null) {
                if (i == Oxx0IOOO2.Oxx0xo()) {
                    z = true;
                }
                XxIIOXIXx.oIX0oI.oIX0oI(z);
            }
        }
        if (!(xoxoi instanceof Oxx0xo)) {
            this.f3320oOoXoXO++;
            this.f3321ooOOo0oXI++;
            xoxoi.IIXOooo(this);
            xoxoi.X0IIOO(this.f3320oOoXoXO, this.f3318XO + 1, this.f3321ooOOo0oXI);
            if (this.f3317X0o0xo.size() > this.f3320oOoXoXO) {
                f3311x0XOIxOo.ooOOo0oXI("drawings length " + this.f3317X0o0xo.size() + " exceeds the max object id " + this.f3320oOoXoXO);
                return;
            }
            return;
        }
        Oxx0xo oxx0xo = (Oxx0xo) xoxoi;
        Oxx0xo oxx0xo2 = (Oxx0xo) this.f3315OOXIXo.get(xoxoi.oOoXoXO());
        if (oxx0xo2 == null) {
            this.f3320oOoXoXO++;
            this.f3321ooOOo0oXI++;
            this.f3317X0o0xo.add(oxx0xo);
            oxx0xo.IIXOooo(this);
            oxx0xo.X0IIOO(this.f3320oOoXoXO, this.f3318XO + 1, this.f3321ooOOo0oXI);
            this.f3318XO++;
            this.f3315OOXIXo.put(oxx0xo.oOoXoXO(), oxx0xo);
            return;
        }
        oxx0xo2.II0XooXoX(oxx0xo2.x0XOIxOo() + 1);
        oxx0xo.IIXOooo(this);
        oxx0xo.X0IIOO(oxx0xo2.Oxx0IOOO(), oxx0xo2.oxoX(), oxx0xo2.oO());
    }

    public final oIX0oI Oxx0IOOO() {
        if (this.f3312I0Io == null) {
            if (!this.f3322oxoX) {
                OOXIXo();
            }
            X0IIOO[] oO2 = this.f3314II0xO0.oO();
            if (oO2.length > 1 && oO2[1].xxIXOIIO() == XIxXXX0x0.f3419X0o0xo) {
                this.f3312I0Io = (oIX0oI) oO2[1];
            }
        }
        return this.f3312I0Io;
    }

    public final void XO(xoXoI xoxoi) {
        this.f3317X0o0xo.add(xoxoi);
        this.f3320oOoXoXO = Math.max(this.f3320oOoXoXO, xoxoi.Oxx0IOOO());
        this.f3321ooOOo0oXI = Math.max(this.f3321ooOOo0oXI, xoxoi.oO());
    }

    @Override // X0xOO.xxX
    public byte[] getData() {
        return this.f3319oIX0oI;
    }

    public void oIX0oI(X0o0xo x0o0xo) {
        this.f3316Oxx0IOOO++;
    }

    public void oO(jxl.write.biff.IIX0o iIX0o) throws IOException {
        oo0xXOI0I oo0xxoi0i = this.f3323xoIox;
        int i = 0;
        if (oo0xxoi0i == oo0xXOI0I.f3514II0xO0) {
            IXxxXO iXxxXO = new IXxxXO();
            int i2 = this.f3318XO;
            x0xO0oo x0xo0oo = new x0xO0oo(this.f3316Oxx0IOOO + i2 + 1, i2);
            x0xo0oo.x0XOIxOo(1, 0);
            x0xo0oo.x0XOIxOo(this.f3318XO + 1, 0);
            iXxxXO.x0XOIxOo(x0xo0oo);
            oIX0oI oix0oi = new oIX0oI();
            Iterator it = this.f3317X0o0xo.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof Oxx0xo) {
                    oix0oi.x0XOIxOo(new II0xO0((Oxx0xo) next));
                    i++;
                }
            }
            if (i > 0) {
                oix0oi.oI0IIXIo(i);
                iXxxXO.x0XOIxOo(oix0oi);
            }
            iXxxXO.x0XOIxOo(new xI());
            iXxxXO.x0XOIxOo(new XOxIOxOx());
            this.f3319oIX0oI = iXxxXO.II0xO0();
        } else if (oo0xxoi0i == oo0xXOI0I.f3513I0Io) {
            IXxxXO iXxxXO2 = new IXxxXO();
            int i3 = this.f3318XO;
            x0xO0oo x0xo0oo2 = new x0xO0oo(this.f3316Oxx0IOOO + i3 + 1, i3);
            x0xo0oo2.x0XOIxOo(1, 0);
            x0xo0oo2.x0XOIxOo(this.f3313II0XooXoX + this.f3318XO + 1, 0);
            iXxxXO2.x0XOIxOo(x0xo0oo2);
            oIX0oI oix0oi2 = new oIX0oI();
            oix0oi2.oI0IIXIo(this.f3318XO);
            oIX0oI Oxx0IOOO2 = Oxx0IOOO();
            if (Oxx0IOOO2 != null) {
                for (X0IIOO x0iioo : Oxx0IOOO2.oO()) {
                    oix0oi2.x0XOIxOo((II0xO0) x0iioo);
                }
            }
            Iterator it2 = this.f3317X0o0xo.iterator();
            while (it2.hasNext()) {
                xoXoI xoxoi = (xoXoI) it2.next();
                if (xoxoi instanceof Oxx0xo) {
                    Oxx0xo oxx0xo = (Oxx0xo) xoxoi;
                    if (oxx0xo.Oxx0xo() == oo0xXOI0I.f3514II0xO0) {
                        oix0oi2.x0XOIxOo(new II0xO0(oxx0xo));
                    }
                }
            }
            iXxxXO2.x0XOIxOo(oix0oi2);
            xI xIVar = new xI();
            xIVar.x0XOIxOo(EMachine.EM_TILEGX, false, false, 524296);
            xIVar.x0XOIxOo(385, false, false, 134217737);
            xIVar.x0XOIxOo(448, false, false, 134217792);
            iXxxXO2.x0XOIxOo(xIVar);
            iXxxXO2.x0XOIxOo(new XOxIOxOx());
            this.f3319oIX0oI = iXxxXO2.II0xO0();
        }
        iIX0o.XO(new XxX0x0xxx(this.f3319oIX0oI));
    }

    public void oOoXoXO(xoXoI xoxoi) {
        if (Oxx0IOOO() == null) {
            return;
        }
        if (this.f3323xoIox == oo0xXOI0I.f3515oIX0oI) {
            this.f3323xoIox = oo0xXOI0I.f3513I0Io;
            this.f3318XO = Oxx0IOOO().Oxx0xo();
            this.f3313II0XooXoX = (((x0xO0oo) this.f3314II0xO0.oO()[0]).oO(1).f3619oIX0oI - this.f3318XO) - 1;
        }
        II0xO0 iI0xO0 = (II0xO0) Oxx0IOOO().oO()[xoxoi.oxoX() - 1];
        iI0xO0.x0XOIxOo();
        if (iI0xO0.Oo() == 0) {
            Oxx0IOOO().Oo(iI0xO0);
            Iterator it = this.f3317X0o0xo.iterator();
            while (it.hasNext()) {
                xoXoI xoxoi2 = (xoXoI) it.next();
                if (xoxoi2.oxoX() > xoxoi.oxoX()) {
                    xoxoi2.X0IIOO(xoxoi2.Oxx0IOOO(), xoxoi2.oxoX() - 1, xoxoi2.oO());
                }
            }
            this.f3318XO--;
        }
    }

    public void ooOOo0oXI(xXxxox0I xxxxox0i, ooXIXxIX ooxixxix) {
        this.f3324xxIXOIIO = true;
        if (ooxixxix != null) {
            this.f3320oOoXoXO = Math.max(this.f3320oOoXoXO, ooxixxix.oX());
        }
    }

    public void oxoX(xoxXI xoxxi) {
        X0o0xo(xoxxi.I0Io());
    }

    public void x0XOIxOo(IIXOooo iIXOooo) {
        this.f3324xxIXOIIO = iIXOooo.f3324xxIXOIIO;
        this.f3320oOoXoXO = iIXOooo.f3320oOoXoXO;
        this.f3321ooOOo0oXI = iIXOooo.f3321ooOOo0oXI;
    }

    public boolean xoIox() {
        return this.f3324xxIXOIIO;
    }

    public final int xxIXOIIO() {
        return this.f3318XO;
    }

    public IIXOooo(IIXOooo iIXOooo) {
        this.f3319oIX0oI = iIXOooo.f3319oIX0oI;
        this.f3314II0xO0 = iIXOooo.f3314II0xO0;
        this.f3312I0Io = iIXOooo.f3312I0Io;
        this.f3322oxoX = iIXOooo.f3322oxoX;
        this.f3319oIX0oI = iIXOooo.f3319oIX0oI;
        this.f3314II0xO0 = iIXOooo.f3314II0xO0;
        this.f3312I0Io = iIXOooo.f3312I0Io;
        this.f3318XO = iIXOooo.f3318XO;
        this.f3316Oxx0IOOO = iIXOooo.f3316Oxx0IOOO;
        this.f3313II0XooXoX = iIXOooo.f3313II0XooXoX;
        this.f3324xxIXOIIO = iIXOooo.f3324xxIXOIIO;
        this.f3323xoIox = iIXOooo.f3323xoIox;
        this.f3315OOXIXo = (HashMap) iIXOooo.f3315OOXIXo.clone();
        this.f3320oOoXoXO = iIXOooo.f3320oOoXoXO;
        this.f3321ooOOo0oXI = iIXOooo.f3321ooOOo0oXI;
        this.f3317X0o0xo = new ArrayList();
    }
}
