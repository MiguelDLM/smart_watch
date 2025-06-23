package oI00o;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.util.Arrays;

/* loaded from: classes6.dex */
public final class I0Io implements Cloneable {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int[] f31344IXxxXO = new int[0];

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final float f31345Oxx0xo = 0.75f;

    /* renamed from: Oo, reason: collision with root package name */
    public int f31346Oo;

    /* renamed from: XO, reason: collision with root package name */
    public int[] f31347XO;

    public I0Io() {
        this.f31346Oo = 0;
        this.f31347XO = f31344IXxxXO;
    }

    public static int[] oO(int i) {
        return new int[(i + 31) / 32];
    }

    public void I0Io(int i, int i2) {
        if (i2 >= 0 && i2 <= 32) {
            int i3 = this.f31346Oo;
            XO(i3 + i2);
            for (int i4 = i2 - 1; i4 >= 0; i4--) {
                if (((1 << i4) & i) != 0) {
                    int[] iArr = this.f31347XO;
                    int i5 = i3 / 32;
                    iArr[i5] = iArr[i5] | (1 << (i3 & 31));
                }
                i3++;
            }
            this.f31346Oo = i3;
            return;
        }
        throw new IllegalArgumentException("Num bits must be between 0 and 32");
    }

    public boolean II0XooXoX(int i) {
        if (((1 << (i & 31)) & this.f31347XO[i / 32]) != 0) {
            return true;
        }
        return false;
    }

    public void II0xO0(I0Io i0Io) {
        int i = i0Io.f31346Oo;
        XO(this.f31346Oo + i);
        for (int i2 = 0; i2 < i; i2++) {
            oIX0oI(i0Io.II0XooXoX(i2));
        }
    }

    public void IXxxXO(int i, int i2) {
        this.f31347XO[i / 32] = i2;
    }

    public int OOXIXo(int i) {
        int i2 = this.f31346Oo;
        if (i >= i2) {
            return i2;
        }
        int i3 = i / 32;
        int i4 = (-(1 << (i & 31))) & (~this.f31347XO[i3]);
        while (i4 == 0) {
            i3++;
            int[] iArr = this.f31347XO;
            if (i3 == iArr.length) {
                return this.f31346Oo;
            }
            i4 = ~iArr[i3];
        }
        return Math.min((i3 * 32) + Integer.numberOfTrailingZeros(i4), this.f31346Oo);
    }

    public void Oo(int i) {
        int[] iArr = this.f31347XO;
        int i2 = i / 32;
        iArr[i2] = (1 << (i & 31)) | iArr[i2];
    }

    public void Oxx0IOOO(int i) {
        int[] iArr = this.f31347XO;
        int i2 = i / 32;
        iArr[i2] = (1 << (i & 31)) ^ iArr[i2];
    }

    public void Oxx0xo(int i, int i2) {
        int i3;
        if (i2 >= i && i >= 0 && i2 <= this.f31346Oo) {
            if (i2 == i) {
                return;
            }
            int i4 = i2 - 1;
            int i5 = i / 32;
            int i6 = i4 / 32;
            for (int i7 = i5; i7 <= i6; i7++) {
                int i8 = 31;
                if (i7 > i5) {
                    i3 = 0;
                } else {
                    i3 = i & 31;
                }
                if (i7 >= i6) {
                    i8 = 31 & i4;
                }
                int i9 = (2 << i8) - (1 << i3);
                int[] iArr = this.f31347XO;
                iArr[i7] = i9 | iArr[i7];
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    public void OxxIIOOXO(I0Io i0Io) {
        if (this.f31346Oo == i0Io.f31346Oo) {
            int i = 0;
            while (true) {
                int[] iArr = this.f31347XO;
                if (i < iArr.length) {
                    iArr[i] = iArr[i] ^ i0Io.f31347XO[i];
                    i++;
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("Sizes don't match");
        }
    }

    /* renamed from: X0o0xo, reason: merged with bridge method [inline-methods] */
    public I0Io clone() {
        return new I0Io((int[]) this.f31347XO.clone(), this.f31346Oo);
    }

    public final void XO(int i) {
        if (i > this.f31347XO.length * 32) {
            int[] oO2 = oO((int) Math.ceil(i / 0.75f));
            int[] iArr = this.f31347XO;
            System.arraycopy(iArr, 0, oO2, 0, iArr.length);
            this.f31347XO = oO2;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof I0Io)) {
            return false;
        }
        I0Io i0Io = (I0Io) obj;
        if (this.f31346Oo != i0Io.f31346Oo || !Arrays.equals(this.f31347XO, i0Io.f31347XO)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f31346Oo * 31) + Arrays.hashCode(this.f31347XO);
    }

    public void oI0IIXIo(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = 0;
            for (int i6 = 0; i6 < 8; i6++) {
                if (II0XooXoX(i)) {
                    i5 |= 1 << (7 - i6);
                }
                i++;
            }
            bArr[i2 + i4] = (byte) i5;
        }
    }

    public void oIX0oI(boolean z) {
        XO(this.f31346Oo + 1);
        if (z) {
            int[] iArr = this.f31347XO;
            int i = this.f31346Oo;
            int i2 = i / 32;
            iArr[i2] = (1 << (i & 31)) | iArr[i2];
        }
        this.f31346Oo++;
    }

    public int oOoXoXO() {
        return this.f31346Oo;
    }

    public int ooOOo0oXI() {
        return (this.f31346Oo + 7) / 8;
    }

    public void oxoX() {
        int length = this.f31347XO.length;
        for (int i = 0; i < length; i++) {
            this.f31347XO[i] = 0;
        }
    }

    public String toString() {
        char c;
        int i = this.f31346Oo;
        StringBuilder sb = new StringBuilder(i + (i / 8) + 1);
        for (int i2 = 0; i2 < this.f31346Oo; i2++) {
            if ((i2 & 7) == 0) {
                sb.append(TokenParser.SP);
            }
            if (II0XooXoX(i2)) {
                c = 'X';
            } else {
                c = '.';
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public boolean x0XOIxOo(int i, int i2, boolean z) {
        int i3;
        if (i2 >= i && i >= 0 && i2 <= this.f31346Oo) {
            if (i2 == i) {
                return true;
            }
            int i4 = i2 - 1;
            int i5 = i / 32;
            int i6 = i4 / 32;
            for (int i7 = i5; i7 <= i6; i7++) {
                int i8 = 31;
                if (i7 > i5) {
                    i3 = 0;
                } else {
                    i3 = i & 31;
                }
                if (i7 >= i6) {
                    i8 = 31 & i4;
                }
                int i9 = (2 << i8) - (1 << i3);
                int i10 = this.f31347XO[i7] & i9;
                if (!z) {
                    i9 = 0;
                }
                if (i10 != i9) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalArgumentException();
    }

    public void x0xO0oo() {
        int[] iArr = new int[this.f31347XO.length];
        int i = (this.f31346Oo - 1) / 32;
        int i2 = i + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i - i3] = Integer.reverse(this.f31347XO[i3]);
        }
        int i4 = this.f31346Oo;
        int i5 = i2 * 32;
        if (i4 != i5) {
            int i6 = i5 - i4;
            int i7 = iArr[0] >>> i6;
            for (int i8 = 1; i8 < i2; i8++) {
                int i9 = iArr[i8];
                iArr[i8 - 1] = i7 | (i9 << (32 - i6));
                i7 = i9 >>> i6;
            }
            iArr[i] = i7;
        }
        this.f31347XO = iArr;
    }

    public int xoIox(int i) {
        int i2 = this.f31346Oo;
        if (i >= i2) {
            return i2;
        }
        int i3 = i / 32;
        int i4 = (-(1 << (i & 31))) & this.f31347XO[i3];
        while (i4 == 0) {
            i3++;
            int[] iArr = this.f31347XO;
            if (i3 == iArr.length) {
                return this.f31346Oo;
            }
            i4 = iArr[i3];
        }
        return Math.min((i3 * 32) + Integer.numberOfTrailingZeros(i4), this.f31346Oo);
    }

    public int[] xxIXOIIO() {
        return this.f31347XO;
    }

    public I0Io(int i) {
        this.f31346Oo = i;
        this.f31347XO = oO(i);
    }

    public I0Io(int[] iArr, int i) {
        this.f31347XO = iArr;
        this.f31346Oo = i;
    }
}
