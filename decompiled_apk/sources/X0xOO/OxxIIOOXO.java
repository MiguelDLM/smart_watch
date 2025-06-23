package X0xOO;

import java.util.ArrayList;
import jxl.biff.drawing.DrawingDataException;

/* loaded from: classes6.dex */
public class OxxIIOOXO implements xxX {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f3378X0o0xo = XxIIOXIXx.X0o0xo.Oxx0IOOO(OxxIIOOXO.class);

    /* renamed from: oxoX, reason: collision with root package name */
    public X0IIOO[] f3382oxoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f3380II0xO0 = 0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public byte[] f3381oIX0oI = null;

    /* renamed from: I0Io, reason: collision with root package name */
    public boolean f3379I0Io = false;

    private void XO() {
        boolean z;
        XI0IXoo xI0IXoo = new XI0IXoo(this, 0);
        XxIIOXIXx.oIX0oI.oIX0oI(xI0IXoo.xoIox());
        OxI oxI = new OxI(xI0IXoo);
        oxI.oO();
        X0IIOO[] oO2 = oxI.oO();
        OxI oxI2 = null;
        for (int i = 0; i < oO2.length && oxI2 == null; i++) {
            X0IIOO x0iioo = oO2[i];
            if (x0iioo.xxIXOIIO() == XIxXXX0x0.f3418Oxx0IOOO) {
                oxI2 = (OxI) x0iioo;
            }
        }
        if (oxI2 != null) {
            z = true;
        } else {
            z = false;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
        X0IIOO[] oO3 = oxI2.oO();
        boolean z2 = false;
        for (int i2 = 0; i2 < oO3.length && !z2; i2++) {
            if (oO3[i2].xxIXOIIO() == XIxXXX0x0.f3418Oxx0IOOO) {
                z2 = true;
            }
        }
        if (!z2) {
            this.f3382oxoX = oO3;
        } else {
            ArrayList arrayList = new ArrayList();
            X0o0xo(oxI2, arrayList);
            X0IIOO[] x0iiooArr = new X0IIOO[arrayList.size()];
            this.f3382oxoX = x0iiooArr;
            this.f3382oxoX = (X0IIOO[]) arrayList.toArray(x0iiooArr);
        }
        this.f3379I0Io = true;
    }

    public final int I0Io() {
        return this.f3380II0xO0;
    }

    public void II0xO0(byte[] bArr) {
        byte[] bArr2 = this.f3381oIX0oI;
        if (bArr2 == null) {
            this.f3381oIX0oI = bArr;
            return;
        }
        byte[] bArr3 = new byte[bArr2.length + bArr.length];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, 0, bArr3, this.f3381oIX0oI.length, bArr.length);
        this.f3381oIX0oI = bArr3;
        this.f3379I0Io = false;
    }

    public final void X0o0xo(OxI oxI, ArrayList arrayList) {
        X0IIOO[] oO2 = oxI.oO();
        for (int i = 0; i < oO2.length; i++) {
            if (oO2[i].xxIXOIIO() == XIxXXX0x0.f3413II0XooXoX) {
                arrayList.add(oO2[i]);
            } else if (oO2[i].xxIXOIIO() == XIxXXX0x0.f3418Oxx0IOOO) {
                X0o0xo((OxI) oO2[i], arrayList);
            } else {
                f3378X0o0xo.ooOOo0oXI("Spgr Containers contains a record other than Sp/Spgr containers");
            }
        }
    }

    @Override // X0xOO.xxX
    public byte[] getData() {
        return this.f3381oIX0oI;
    }

    public void oIX0oI(byte[] bArr) {
        II0xO0(bArr);
        this.f3380II0xO0++;
    }

    public OxI oxoX(int i) {
        if (!this.f3379I0Io) {
            XO();
        }
        boolean z = true;
        int i2 = i + 1;
        X0IIOO[] x0iiooArr = this.f3382oxoX;
        if (i2 < x0iiooArr.length) {
            OxI oxI = (OxI) x0iiooArr[i2];
            if (oxI == null) {
                z = false;
            }
            XxIIOXIXx.oIX0oI.oIX0oI(z);
            return oxI;
        }
        throw new DrawingDataException();
    }
}
