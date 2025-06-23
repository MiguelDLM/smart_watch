package oI0;

import java.util.Arrays;

/* loaded from: classes6.dex */
public abstract class XO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final int f31336oIX0oI;

    /* loaded from: classes6.dex */
    public static class oIX0oI {

        /* renamed from: I0Io, reason: collision with root package name */
        public int f31337I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public byte[] f31338II0xO0;

        /* renamed from: Oxx0IOOO, reason: collision with root package name */
        public int f31339Oxx0IOOO;

        /* renamed from: X0o0xo, reason: collision with root package name */
        public boolean f31340X0o0xo;

        /* renamed from: XO, reason: collision with root package name */
        public int f31341XO;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public int f31342oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        public int f31343oxoX;

        public String toString() {
            return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", oIX0oI.class.getSimpleName(), Arrays.toString(this.f31338II0xO0), Integer.valueOf(this.f31341XO), Boolean.valueOf(this.f31340X0o0xo), Integer.valueOf(this.f31342oIX0oI), 0L, Integer.valueOf(this.f31339Oxx0IOOO), Integer.valueOf(this.f31337I0Io), Integer.valueOf(this.f31343oxoX));
        }
    }

    public XO(int i, int i2, int i3, int i4) {
        int i5;
        if (i3 > 0 && i4 > 0) {
            i5 = (i3 / i2) * i2;
        } else {
            i5 = 0;
        }
        this.f31336oIX0oI = i5;
    }

    public byte[] I0Io(int i, oIX0oI oix0oi) {
        byte[] bArr = oix0oi.f31338II0xO0;
        if (bArr != null && bArr.length >= oix0oi.f31337I0Io + i) {
            return bArr;
        }
        if (bArr == null) {
            oix0oi.f31338II0xO0 = new byte[8192];
            oix0oi.f31337I0Io = 0;
            oix0oi.f31343oxoX = 0;
        } else {
            byte[] bArr2 = new byte[bArr.length * 2];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            oix0oi.f31338II0xO0 = bArr2;
        }
        return oix0oi.f31338II0xO0;
    }

    public boolean II0xO0(byte[] bArr) {
        for (byte b : bArr) {
            if (61 != b) {
                if (b >= 0) {
                    byte[] bArr2 = X0o0xo.f31331xxIXOIIO;
                    if (b < bArr2.length && bArr2[b] != -1) {
                        return true;
                    }
                }
            } else {
                return true;
            }
        }
        return false;
    }

    public int oIX0oI(byte[] bArr, int i, int i2, oIX0oI oix0oi) {
        if (oix0oi.f31338II0xO0 != null) {
            int min = Math.min(oix0oi.f31337I0Io - oix0oi.f31343oxoX, i2);
            System.arraycopy(oix0oi.f31338II0xO0, oix0oi.f31343oxoX, bArr, i, min);
            int i3 = oix0oi.f31343oxoX + min;
            oix0oi.f31343oxoX = i3;
            if (i3 >= oix0oi.f31337I0Io) {
                oix0oi.f31338II0xO0 = null;
            }
            return min;
        }
        if (oix0oi.f31340X0o0xo) {
            return -1;
        }
        return 0;
    }
}
