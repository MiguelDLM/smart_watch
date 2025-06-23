package X0xOO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class Xx000oIo {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f3456X0o0xo = XxIIOXIXx.X0o0xo.Oxx0IOOO(Xx000oIo.class);

    /* renamed from: I0Io, reason: collision with root package name */
    public X0o0xo[] f3457I0Io = new X0o0xo[0];

    /* renamed from: II0xO0, reason: collision with root package name */
    public boolean f3458II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public ArrayList f3459oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public xIoXXXIXo.O0xOxO f3460oxoX;

    public Xx000oIo(xIoXXXIXo.O0xOxO o0xOxO) {
    }

    public void I0Io(ArrayList arrayList, boolean z) {
        this.f3459oIX0oI = arrayList;
        this.f3458II0xO0 = z;
    }

    public void II0xO0(X0o0xo[] x0o0xoArr) {
        this.f3457I0Io = x0o0xoArr;
    }

    public final void X0o0xo(jxl.write.biff.IIX0o iIX0o) throws IOException {
        if (this.f3457I0Io.length == 0 && this.f3459oIX0oI.size() == 0) {
            return;
        }
        if (this.f3457I0Io.length == 0 && this.f3459oIX0oI.size() != 0) {
            Iterator it = this.f3459oIX0oI.iterator();
            while (it.hasNext()) {
                xoXoI xoxoi = (xoXoI) it.next();
                iIX0o.XO(xoxoi.X0o0xo());
                xoxoi.XO(iIX0o);
            }
            Iterator it2 = this.f3459oIX0oI.iterator();
            while (it2.hasNext()) {
                ((xoXoI) it2.next()).O0xOxO(iIX0o);
            }
            return;
        }
        int i = 0;
        if (this.f3459oIX0oI.size() != 0 || this.f3457I0Io.length == 0) {
            int size = this.f3459oIX0oI.size();
            X0o0xo[] x0o0xoArr = this.f3457I0Io;
            int length = x0o0xoArr.length + size;
            OxI[] oxIArr = new OxI[length];
            boolean[] zArr = new boolean[x0o0xoArr.length + size];
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                xoXoI xoxoi2 = (xoXoI) this.f3459oIX0oI.get(i3);
                OxI oI0IIXIo2 = xoxoi2.oI0IIXIo();
                oxIArr[i3] = oI0IIXIo2;
                if (i3 > 0) {
                    i2 += oI0IIXIo2.XO();
                }
                if (xoxoi2.OOXIXo()) {
                    zArr[i3] = true;
                }
            }
            int i4 = 0;
            while (true) {
                X0o0xo[] x0o0xoArr2 = this.f3457I0Io;
                if (i4 >= x0o0xoArr2.length) {
                    break;
                }
                OxI oxoX2 = x0o0xoArr2[i4].oxoX();
                oxIArr[i4 + size] = oxoX2;
                i2 += oxoX2.XO();
                i4++;
            }
            oO oOVar = new oO();
            oOVar.x0XOIxOo(new x0XOIxOo(this.f3457I0Io.length + size));
            x0o x0oVar = new x0o();
            IO io2 = new IO();
            io2.x0XOIxOo(new xII());
            io2.x0XOIxOo(new X00IoxXI(oOXoIIIo.f3485I0Io, 1024, 5));
            x0oVar.x0XOIxOo(io2);
            x0oVar.x0XOIxOo(oxIArr[0]);
            oOVar.x0XOIxOo(x0oVar);
            byte[] II0xO02 = oOVar.II0xO0();
            OoIXo.oo0xXOI0I.oIX0oI(OoIXo.oo0xXOI0I.oxoX(II0xO02[4], II0xO02[5], II0xO02[6], II0xO02[7]) + i2, II0xO02, 4);
            OoIXo.oo0xXOI0I.oIX0oI(OoIXo.oo0xXOI0I.oxoX(II0xO02[28], II0xO02[29], II0xO02[30], II0xO02[31]) + i2, II0xO02, 28);
            if (zArr[0]) {
                int length2 = II0xO02.length - 8;
                byte[] bArr = new byte[length2];
                System.arraycopy(II0xO02, 0, bArr, 0, length2);
                II0xO02 = bArr;
            }
            iIX0o.XO(new xXxxox0I(II0xO02));
            ((xoXoI) this.f3459oIX0oI.get(0)).XO(iIX0o);
            for (int i5 = 1; i5 < length; i5++) {
                byte[] OOXIXo2 = oxIArr[i5].OOXIXo(oxIArr[i5].oIX0oI());
                if (zArr[i5]) {
                    int length3 = OOXIXo2.length - 8;
                    byte[] bArr2 = new byte[length3];
                    System.arraycopy(OOXIXo2, 0, bArr2, 0, length3);
                    OOXIXo2 = bArr2;
                }
                iIX0o.XO(new xXxxox0I(OOXIXo2));
                if (i5 < size) {
                    ((xoXoI) this.f3459oIX0oI.get(i5)).XO(iIX0o);
                } else {
                    X0o0xo x0o0xo = this.f3457I0Io[i5 - size];
                    iIX0o.XO(x0o0xo.II0xO0());
                    iIX0o.XO(x0o0xo);
                }
            }
            Iterator it3 = this.f3459oIX0oI.iterator();
            while (it3.hasNext()) {
                ((xoXoI) it3.next()).O0xOxO(iIX0o);
            }
            return;
        }
        while (true) {
            X0o0xo[] x0o0xoArr3 = this.f3457I0Io;
            if (i < x0o0xoArr3.length) {
                X0o0xo x0o0xo2 = x0o0xoArr3[i];
                if (x0o0xo2.oIX0oI() != null) {
                    iIX0o.XO(x0o0xo2.oIX0oI());
                }
                if (x0o0xo2.II0xO0() != null) {
                    iIX0o.XO(x0o0xo2.II0xO0());
                }
                iIX0o.XO(x0o0xo2);
                i++;
            } else {
                return;
            }
        }
    }

    public X0o0xo[] oIX0oI() {
        return this.f3457I0Io;
    }

    public void oxoX(jxl.write.biff.IIX0o iIX0o) throws IOException {
        int i;
        if (this.f3459oIX0oI.size() == 0 && this.f3457I0Io.length == 0) {
            return;
        }
        boolean z = this.f3458II0xO0;
        int size = this.f3459oIX0oI.size();
        Iterator it = this.f3459oIX0oI.iterator();
        while (true) {
            if (!it.hasNext() || z) {
                break;
            } else if (((xoXoI) it.next()).Oxx0xo() != oo0xXOI0I.f3515oIX0oI) {
                z = true;
            }
        }
        if (size > 0 && !z && !((xoXoI) this.f3459oIX0oI.get(0)).isFirst()) {
            z = true;
        }
        if (size == 0) {
            X0o0xo[] x0o0xoArr = this.f3457I0Io;
            if (x0o0xoArr.length == 1 && x0o0xoArr[0].oIX0oI() == null) {
                z = false;
            }
        }
        if (!z) {
            X0o0xo(iIX0o);
            return;
        }
        int length = this.f3457I0Io.length + size;
        Object[] objArr = new Object[length];
        OxI oxI = null;
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            OxI oI0IIXIo2 = ((xoXoI) this.f3459oIX0oI.get(i3)).oI0IIXIo();
            if (oI0IIXIo2 != null) {
                byte[] II0xO02 = oI0IIXIo2.II0xO0();
                objArr[i3] = II0xO02;
                if (i3 == 0) {
                    oxI = oI0IIXIo2;
                } else {
                    i2 += II0xO02.length;
                }
            }
        }
        int i4 = 0;
        while (true) {
            X0o0xo[] x0o0xoArr2 = this.f3457I0Io;
            if (i4 >= x0o0xoArr2.length) {
                break;
            }
            OxI oxoX2 = x0o0xoArr2[i4].oxoX();
            byte[] OOXIXo2 = oxoX2.OOXIXo(oxoX2.oIX0oI());
            objArr[i4 + size] = OOXIXo2;
            if (i4 == 0 && size == 0) {
                oxI = oxoX2;
            } else {
                i2 += OOXIXo2.length;
            }
            i4++;
        }
        oO oOVar = new oO();
        oOVar.x0XOIxOo(new x0XOIxOo(this.f3457I0Io.length + size));
        x0o x0oVar = new x0o();
        IO io2 = new IO();
        io2.x0XOIxOo(new xII());
        io2.x0XOIxOo(new X00IoxXI(oOXoIIIo.f3485I0Io, 1024, 5));
        x0oVar.x0XOIxOo(io2);
        x0oVar.x0XOIxOo(oxI);
        oOVar.x0XOIxOo(x0oVar);
        byte[] II0xO03 = oOVar.II0xO0();
        OoIXo.oo0xXOI0I.oIX0oI(OoIXo.oo0xXOI0I.oxoX(II0xO03[4], II0xO03[5], II0xO03[6], II0xO03[7]) + i2, II0xO03, 4);
        OoIXo.oo0xXOI0I.oIX0oI(OoIXo.oo0xXOI0I.oxoX(II0xO03[28], II0xO03[29], II0xO03[30], II0xO03[31]) + i2, II0xO03, 28);
        if (size > 0 && ((xoXoI) this.f3459oIX0oI.get(0)).OOXIXo()) {
            int length2 = II0xO03.length - 8;
            byte[] bArr = new byte[length2];
            System.arraycopy(II0xO03, 0, bArr, 0, length2);
            II0xO03 = bArr;
        }
        iIX0o.XO(new xXxxox0I(II0xO03));
        if (size > 0) {
            ((xoXoI) this.f3459oIX0oI.get(0)).XO(iIX0o);
        } else {
            X0o0xo x0o0xo = this.f3457I0Io[0];
            iIX0o.XO(x0o0xo.II0xO0());
            iIX0o.XO(x0o0xo);
        }
        for (i = 1; i < length; i++) {
            byte[] bArr2 = (byte[]) objArr[i];
            if (i < size && ((xoXoI) this.f3459oIX0oI.get(i)).OOXIXo()) {
                int length3 = bArr2.length - 8;
                byte[] bArr3 = new byte[length3];
                System.arraycopy(bArr2, 0, bArr3, 0, length3);
                bArr2 = bArr3;
            }
            iIX0o.XO(new xXxxox0I(bArr2));
            if (i < size) {
                ((xoXoI) this.f3459oIX0oI.get(i)).XO(iIX0o);
            } else {
                X0o0xo x0o0xo2 = this.f3457I0Io[i - size];
                iIX0o.XO(x0o0xo2.II0xO0());
                iIX0o.XO(x0o0xo2);
            }
        }
        Iterator it2 = this.f3459oIX0oI.iterator();
        while (it2.hasNext()) {
            ((xoXoI) it2.next()).O0xOxO(iIX0o);
        }
    }
}
