package OoIXo;

import java.util.regex.Pattern;

/* loaded from: classes6.dex */
public class OOXIXo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public xIoXXXIXo.IIXOooo f2089oIX0oI;

    public OOXIXo(xIoXXXIXo.IIXOooo iIXOooo) {
        this.f2089oIX0oI = iIXOooo;
    }

    public xIoXXXIXo.I0Io I0Io(Pattern pattern, int i, int i2, int i3, int i4, boolean z) {
        int i5;
        int i6 = i3 - i;
        int i7 = i4 - i2;
        if (z) {
            i2 = i4;
        }
        if (z) {
            i = i3;
        }
        if (z) {
            i5 = -1;
        } else {
            i5 = 1;
        }
        xIoXXXIXo.I0Io i0Io = null;
        boolean z2 = false;
        for (int i8 = 0; i8 <= i6 && !z2; i8++) {
            for (int i9 = 0; i9 <= i7 && !z2; i9++) {
                int i10 = (i8 * i5) + i;
                int i11 = (i9 * i5) + i2;
                if (i10 < this.f2089oIX0oI.XoI0Ixx0() && i11 < this.f2089oIX0oI.OxxIIOOXO()) {
                    xIoXXXIXo.I0Io XX2 = this.f2089oIX0oI.XX(i10, i11);
                    if (XX2.getType() != xIoXXXIXo.Oxx0IOOO.f34234II0xO0 && pattern.matcher(XX2.IIX0o()).matches()) {
                        i0Io = XX2;
                        z2 = true;
                    }
                }
            }
        }
        return i0Io;
    }

    public xIoXXXIXo.I0Io II0xO0(String str, int i, int i2, int i3, int i4, boolean z) {
        int i5;
        int i6 = i3 - i;
        int i7 = i4 - i2;
        if (z) {
            i2 = i4;
        }
        if (z) {
            i = i3;
        }
        if (z) {
            i5 = -1;
        } else {
            i5 = 1;
        }
        xIoXXXIXo.I0Io i0Io = null;
        boolean z2 = false;
        for (int i8 = 0; i8 <= i6 && !z2; i8++) {
            for (int i9 = 0; i9 <= i7 && !z2; i9++) {
                int i10 = (i8 * i5) + i;
                int i11 = (i9 * i5) + i2;
                if (i10 < this.f2089oIX0oI.XoI0Ixx0() && i11 < this.f2089oIX0oI.OxxIIOOXO()) {
                    xIoXXXIXo.I0Io XX2 = this.f2089oIX0oI.XX(i10, i11);
                    if (XX2.getType() != xIoXXXIXo.Oxx0IOOO.f34234II0xO0 && XX2.IIX0o().equals(str)) {
                        i0Io = XX2;
                        z2 = true;
                    }
                }
            }
        }
        return i0Io;
    }

    public xIoXXXIXo.I0Io oIX0oI(String str) {
        xIoXXXIXo.I0Io i0Io = null;
        boolean z = false;
        for (int i = 0; i < this.f2089oIX0oI.OxxIIOOXO() && !z; i++) {
            xIoXXXIXo.I0Io[] x0o2 = this.f2089oIX0oI.x0o(i);
            for (int i2 = 0; i2 < x0o2.length && !z; i2++) {
                if (x0o2[i2].IIX0o().equals(str)) {
                    i0Io = x0o2[i2];
                    z = true;
                }
            }
        }
        return i0Io;
    }

    public xIoXXXIXo.IXxxXO oxoX(String str) {
        xIoXXXIXo.IXxxXO iXxxXO = null;
        boolean z = false;
        for (int i = 0; i < this.f2089oIX0oI.OxxIIOOXO() && !z; i++) {
            xIoXXXIXo.I0Io[] x0o2 = this.f2089oIX0oI.x0o(i);
            for (int i2 = 0; i2 < x0o2.length && !z; i2++) {
                if ((x0o2[i2].getType() == xIoXXXIXo.Oxx0IOOO.f34232I0Io || x0o2[i2].getType() == xIoXXXIXo.Oxx0IOOO.f34242xxIXOIIO) && x0o2[i2].IIX0o().equals(str)) {
                    iXxxXO = (xIoXXXIXo.IXxxXO) x0o2[i2];
                    z = true;
                }
            }
        }
        return iXxxXO;
    }
}
