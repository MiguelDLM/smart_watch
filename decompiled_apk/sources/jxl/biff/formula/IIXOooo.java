package jxl.biff.formula;

import org.apache.log4j.spi.LocationInfo;

/* loaded from: classes6.dex */
public class IIXOooo {

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f27681II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f27682oIX0oI;

    /* renamed from: I0Io, reason: collision with root package name */
    public static IIXOooo[] f27672I0Io = new IIXOooo[0];

    /* renamed from: oxoX, reason: collision with root package name */
    public static final IIXOooo f27678oxoX = new IIXOooo(255, LocationInfo.NA);

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final IIXOooo f27676X0o0xo = new IIXOooo(0, "#NULL!");

    /* renamed from: XO, reason: collision with root package name */
    public static final IIXOooo f27677XO = new IIXOooo(7, "#DIV/0!");

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final IIXOooo f27675Oxx0IOOO = new IIXOooo(15, "#VALUE!");

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final IIXOooo f27673II0XooXoX = new IIXOooo(23, "#REF!");

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final IIXOooo f27680xxIXOIIO = new IIXOooo(29, "#NAME?");

    /* renamed from: xoIox, reason: collision with root package name */
    public static final IIXOooo f27679xoIox = new IIXOooo(36, "#NUM!");

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final IIXOooo f27674OOXIXo = new IIXOooo(42, "#N/A!");

    public IIXOooo(int i, String str) {
        this.f27682oIX0oI = i;
        this.f27681II0xO0 = str;
        IIXOooo[] iIXOoooArr = f27672I0Io;
        IIXOooo[] iIXOoooArr2 = new IIXOooo[iIXOoooArr.length + 1];
        System.arraycopy(iIXOoooArr, 0, iIXOoooArr2, 0, iIXOoooArr.length);
        iIXOoooArr2[f27672I0Io.length] = this;
        f27672I0Io = iIXOoooArr2;
    }

    public static IIXOooo I0Io(int i) {
        IIXOooo iIXOooo = f27678oxoX;
        int i2 = 0;
        boolean z = false;
        while (true) {
            IIXOooo[] iIXOoooArr = f27672I0Io;
            if (i2 >= iIXOoooArr.length || z) {
                break;
            }
            IIXOooo iIXOooo2 = iIXOoooArr[i2];
            if (iIXOooo2.f27682oIX0oI == i) {
                iIXOooo = iIXOooo2;
                z = true;
            }
            i2++;
        }
        return iIXOooo;
    }

    public static IIXOooo oxoX(String str) {
        IIXOooo iIXOooo = f27678oxoX;
        if (str != null && str.length() != 0) {
            int i = 0;
            boolean z = false;
            while (true) {
                IIXOooo[] iIXOoooArr = f27672I0Io;
                if (i >= iIXOoooArr.length || z) {
                    break;
                }
                if (iIXOoooArr[i].f27681II0xO0.equals(str)) {
                    iIXOooo = f27672I0Io[i];
                    z = true;
                }
                i++;
            }
        }
        return iIXOooo;
    }

    public String II0xO0() {
        return this.f27681II0xO0;
    }

    public int oIX0oI() {
        return this.f27682oIX0oI;
    }
}
