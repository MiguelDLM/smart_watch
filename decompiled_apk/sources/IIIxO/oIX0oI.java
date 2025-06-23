package IIIxO;

import OXOo.OOXIXo;
import java.nio.charset.Charset;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.oxxXoxO;
import okio.Utf8;

@XO
@oxxXoxO(version = "1.8")
/* loaded from: classes6.dex */
public class oIX0oI {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final byte f236II0XooXoX = 61;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final int f238Oxx0IOOO = 4;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f239X0o0xo = 6;

    /* renamed from: XO, reason: collision with root package name */
    public static final int f240XO = 3;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f243oxoX = 8;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f244xoIox = 19;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f245xxIXOIIO = 76;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final boolean f246II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final boolean f247oIX0oI;

    /* renamed from: I0Io, reason: collision with root package name */
    @OOXIXo
    public static final C0004oIX0oI f235I0Io = new C0004oIX0oI(null);

    /* renamed from: OOXIXo, reason: collision with root package name */
    @OOXIXo
    public static final byte[] f237OOXIXo = {13, 10};

    /* renamed from: oOoXoXO, reason: collision with root package name */
    @OOXIXo
    public static final oIX0oI f241oOoXoXO = new oIX0oI(true, false);

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    @OOXIXo
    public static final oIX0oI f242ooOOo0oXI = new oIX0oI(false, true);

    /* renamed from: IIIxO.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0004oIX0oI extends oIX0oI {
        public /* synthetic */ C0004oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final oIX0oI IIX0o() {
            return oIX0oI.f242ooOOo0oXI;
        }

        @OOXIXo
        public final byte[] ooXIXxIX() {
            return oIX0oI.f237OOXIXo;
        }

        @OOXIXo
        public final oIX0oI xI() {
            return oIX0oI.f241oOoXoXO;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public C0004oIX0oI() {
            /*
                r2 = this;
                r0 = 0
                r1 = 0
                r2.<init>(r0, r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: IIIxO.oIX0oI.C0004oIX0oI.<init>():void");
        }
    }

    public /* synthetic */ oIX0oI(boolean z, boolean z2, IIXOooo iIXOooo) {
        this(z, z2);
    }

    public static /* synthetic */ byte[] OOXIXo(oIX0oI oix0oi, byte[] bArr, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = bArr.length;
            }
            return oix0oi.xxIXOIIO(bArr, i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
    }

    public static /* synthetic */ Appendable OxI(oIX0oI oix0oi, byte[] bArr, Appendable appendable, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                i = 0;
            }
            if ((i3 & 8) != 0) {
                i2 = bArr.length;
            }
            return oix0oi.o00(bArr, appendable, i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeToAppendable");
    }

    public static /* synthetic */ String Oxx0xo(oIX0oI oix0oi, byte[] bArr, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = bArr.length;
            }
            return oix0oi.IXxxXO(bArr, i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encode");
    }

    public static /* synthetic */ int OxxIIOOXO(oIX0oI oix0oi, byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, Object obj) {
        int i5;
        int i6;
        if (obj == null) {
            if ((i4 & 4) != 0) {
                i5 = 0;
            } else {
                i5 = i;
            }
            if ((i4 & 8) != 0) {
                i6 = 0;
            } else {
                i6 = i2;
            }
            if ((i4 & 16) != 0) {
                i3 = bArr.length;
            }
            return oix0oi.oI0IIXIo(bArr, bArr2, i5, i6, i3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeIntoByteArray");
    }

    public static /* synthetic */ byte[] X0IIOO(oIX0oI oix0oi, byte[] bArr, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = bArr.length;
            }
            return oix0oi.O0xOxO(bArr, i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeToByteArray");
    }

    public static /* synthetic */ int oO(oIX0oI oix0oi, CharSequence charSequence, byte[] bArr, int i, int i2, int i3, int i4, Object obj) {
        int i5;
        int i6;
        if (obj == null) {
            if ((i4 & 4) != 0) {
                i5 = 0;
            } else {
                i5 = i;
            }
            if ((i4 & 8) != 0) {
                i6 = 0;
            } else {
                i6 = i2;
            }
            if ((i4 & 16) != 0) {
                i3 = charSequence.length();
            }
            return oix0oi.ooOOo0oXI(charSequence, bArr, i5, i6, i3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeIntoByteArray");
    }

    public static /* synthetic */ int x0xO0oo(oIX0oI oix0oi, byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, Object obj) {
        int i5;
        int i6;
        if (obj == null) {
            if ((i4 & 4) != 0) {
                i5 = 0;
            } else {
                i5 = i;
            }
            if ((i4 & 8) != 0) {
                i6 = 0;
            } else {
                i6 = i2;
            }
            if ((i4 & 16) != 0) {
                i3 = bArr.length;
            }
            return oix0oi.x0XOIxOo(bArr, bArr2, i5, i6, i3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeIntoByteArray");
    }

    public static /* synthetic */ byte[] xoIox(oIX0oI oix0oi, CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = charSequence.length();
            }
            return oix0oi.II0XooXoX(charSequence, i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
    }

    @OOXIXo
    public final byte[] II0XooXoX(@OOXIXo CharSequence source, int i, int i2) {
        byte[] X0o0xo2;
        IIX0o.x0xO0oo(source, "source");
        if (source instanceof String) {
            Oxx0IOOO(source.length(), i, i2);
            String substring = ((String) source).substring(i, i2);
            IIX0o.oO(substring, "substring(...)");
            Charset charset = kotlin.text.oxoX.f29582Oxx0IOOO;
            IIX0o.x0XOIxOo(substring, "null cannot be cast to non-null type java.lang.String");
            X0o0xo2 = substring.getBytes(charset);
            IIX0o.oO(X0o0xo2, "getBytes(...)");
        } else {
            X0o0xo2 = X0o0xo(source, i, i2);
        }
        return OOXIXo(this, X0o0xo2, 0, 0, 6, null);
    }

    public final int IIXOooo(@OOXIXo byte[] source, @OOXIXo byte[] destination, int i, int i2, int i3) {
        byte[] II0xO02;
        int i4;
        int i5 = i2;
        IIX0o.x0xO0oo(source, "source");
        IIX0o.x0xO0oo(destination, "destination");
        Oxx0IOOO(source.length, i5, i3);
        XO(destination.length, i, xoXoI(i3 - i5));
        if (this.f247oIX0oI) {
            II0xO02 = I0Io.oxoX();
        } else {
            II0xO02 = I0Io.II0xO0();
        }
        if (this.f246II0xO0) {
            i4 = 19;
        } else {
            i4 = Integer.MAX_VALUE;
        }
        int i6 = i;
        while (i5 + 2 < i3) {
            int min = Math.min((i3 - i5) / 3, i4);
            for (int i7 = 0; i7 < min; i7++) {
                int i8 = source[i5] & 255;
                int i9 = i5 + 2;
                int i10 = source[i5 + 1] & 255;
                i5 += 3;
                int i11 = (i10 << 8) | (i8 << 16) | (source[i9] & 255);
                destination[i6] = II0xO02[i11 >>> 18];
                destination[i6 + 1] = II0xO02[(i11 >>> 12) & 63];
                int i12 = i6 + 3;
                destination[i6 + 2] = II0xO02[(i11 >>> 6) & 63];
                i6 += 4;
                destination[i12] = II0xO02[i11 & 63];
            }
            if (min == i4 && i5 != i3) {
                int i13 = i6 + 1;
                byte[] bArr = f237OOXIXo;
                destination[i6] = bArr[0];
                i6 += 2;
                destination[i13] = bArr[1];
            }
        }
        int i14 = i3 - i5;
        if (i14 != 1) {
            if (i14 == 2) {
                int i15 = i5 + 1;
                int i16 = source[i5] & 255;
                i5 += 2;
                int i17 = ((source[i15] & 255) << 2) | (i16 << 10);
                destination[i6] = II0xO02[i17 >>> 12];
                destination[i6 + 1] = II0xO02[(i17 >>> 6) & 63];
                int i18 = i6 + 3;
                destination[i6 + 2] = II0xO02[i17 & 63];
                i6 += 4;
                destination[i18] = f236II0XooXoX;
            }
        } else {
            int i19 = (source[i5] & 255) << 4;
            destination[i6] = II0xO02[i19 >>> 6];
            destination[i6 + 1] = II0xO02[i19 & 63];
            int i20 = i6 + 3;
            destination[i6 + 2] = f236II0XooXoX;
            i6 += 4;
            destination[i20] = f236II0XooXoX;
            i5++;
        }
        if (i5 == i3) {
            return i6 - i;
        }
        throw new IllegalStateException("Check failed.");
    }

    @OOXIXo
    public final String IXxxXO(@OOXIXo byte[] source, int i, int i2) {
        IIX0o.x0xO0oo(source, "source");
        return new String(XI0IXoo(source, i, i2), kotlin.text.oxoX.f29582Oxx0IOOO);
    }

    @OOXIXo
    public final byte[] O0xOxO(@OOXIXo byte[] source, int i, int i2) {
        IIX0o.x0xO0oo(source, "source");
        return XI0IXoo(source, i, i2);
    }

    public final int Oo(byte[] bArr, int i, int i2) {
        int i3 = i2 - i;
        if (i3 == 0) {
            return 0;
        }
        if (i3 != 1) {
            if (this.f246II0xO0) {
                while (true) {
                    if (i >= i2) {
                        break;
                    }
                    int i4 = I0Io.oIX0oI()[bArr[i] & 255];
                    if (i4 < 0) {
                        if (i4 == -2) {
                            i3 -= i2 - i;
                            break;
                        }
                        i3--;
                    }
                    i++;
                }
            } else if (bArr[i2 - 1] == 61) {
                int i5 = i3 - 1;
                if (bArr[i2 - 2] == 61) {
                    i3 -= 2;
                } else {
                    i3 = i5;
                }
            }
            return (int) ((i3 * 6) / 8);
        }
        throw new IllegalArgumentException("Input should have at list 2 symbols for Base64 decoding, startIndex: " + i + ", endIndex: " + i2);
    }

    public final void Oxx0IOOO(int i, int i2, int i3) {
        kotlin.collections.II0xO0.Companion.oIX0oI(i2, i3, i);
    }

    @OOXIXo
    public final byte[] X0o0xo(@OOXIXo CharSequence source, int i, int i2) {
        IIX0o.x0xO0oo(source, "source");
        Oxx0IOOO(source.length(), i, i2);
        byte[] bArr = new byte[i2 - i];
        int i3 = 0;
        while (i < i2) {
            char charAt = source.charAt(i);
            if (charAt <= 255) {
                bArr[i3] = (byte) charAt;
                i3++;
            } else {
                bArr[i3] = Utf8.REPLACEMENT_BYTE;
                i3++;
            }
            i++;
        }
        return bArr;
    }

    @OOXIXo
    public final byte[] XI0IXoo(@OOXIXo byte[] source, int i, int i2) {
        IIX0o.x0xO0oo(source, "source");
        Oxx0IOOO(source.length, i, i2);
        byte[] bArr = new byte[xoXoI(i2 - i)];
        IIXOooo(source, bArr, 0, i, i2);
        return bArr;
    }

    public final int XIxXXX0x0(byte[] bArr, int i, int i2, int i3) {
        if (i3 != -8) {
            if (i3 != -6) {
                if (i3 != -4) {
                    if (i3 != -2) {
                        throw new IllegalStateException("Unreachable");
                    }
                } else {
                    i = xXxxox0I(bArr, i + 1, i2);
                    if (i == i2 || bArr[i] != 61) {
                        throw new IllegalArgumentException("Missing one pad character at index " + i);
                    }
                }
            }
            return i + 1;
        }
        throw new IllegalArgumentException("Redundant pad character at index " + i);
    }

    public final void XO(int i, int i2, int i3) {
        if (i2 >= 0 && i2 <= i) {
            int i4 = i2 + i3;
            if (i4 >= 0 && i4 <= i) {
                return;
            }
            throw new IndexOutOfBoundsException("The destination array does not have enough capacity, destination offset: " + i2 + ", destination size: " + i + ", capacity needed: " + i3);
        }
        throw new IndexOutOfBoundsException("destination offset: " + i2 + ", destination size: " + i);
    }

    public final boolean XxX0x0xxx() {
        return this.f247oIX0oI;
    }

    @OOXIXo
    public final <A extends Appendable> A o00(@OOXIXo byte[] source, @OOXIXo A destination, int i, int i2) {
        IIX0o.x0xO0oo(source, "source");
        IIX0o.x0xO0oo(destination, "destination");
        destination.append(new String(XI0IXoo(source, i, i2), kotlin.text.oxoX.f29582Oxx0IOOO));
        return destination;
    }

    public final int oI0IIXIo(@OOXIXo byte[] source, @OOXIXo byte[] destination, int i, int i2, int i3) {
        IIX0o.x0xO0oo(source, "source");
        IIX0o.x0xO0oo(destination, "destination");
        return IIXOooo(source, destination, i, i2, i3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00cf, code lost:
    
        if (r7 == (-2)) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00d1, code lost:
    
        r3 = xXxxox0I(r19, r5, r23);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00d5, code lost:
    
        if (r3 < r23) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00d9, code lost:
    
        return r8 - r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00da, code lost:
    
        r1 = r19[r3] & 255;
        r4 = new java.lang.StringBuilder();
        r4.append("Symbol '");
        r4.append((char) r1);
        r4.append("'(");
        r1 = java.lang.Integer.toString(r1, kotlin.text.II0xO0.oIX0oI(8));
        kotlin.jvm.internal.IIX0o.oO(r1, "toString(...)");
        r4.append(r1);
        r4.append(") at index ");
        r4.append(r3 - 1);
        r4.append(" is prohibited after the pad character");
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0115, code lost:
    
        throw new java.lang.IllegalArgumentException(r4.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x011d, code lost:
    
        throw new java.lang.IllegalArgumentException("The last unit of input does not have enough bits");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int oOoXoXO(byte[] r19, byte[] r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: IIIxO.oIX0oI.oOoXoXO(byte[], byte[], int, int, int):int");
    }

    public final int ooOOo0oXI(@OOXIXo CharSequence source, @OOXIXo byte[] destination, int i, int i2, int i3) {
        byte[] X0o0xo2;
        IIX0o.x0xO0oo(source, "source");
        IIX0o.x0xO0oo(destination, "destination");
        if (source instanceof String) {
            Oxx0IOOO(source.length(), i2, i3);
            String substring = ((String) source).substring(i2, i3);
            IIX0o.oO(substring, "substring(...)");
            Charset charset = kotlin.text.oxoX.f29582Oxx0IOOO;
            IIX0o.x0XOIxOo(substring, "null cannot be cast to non-null type java.lang.String");
            X0o0xo2 = substring.getBytes(charset);
            IIX0o.oO(X0o0xo2, "getBytes(...)");
        } else {
            X0o0xo2 = X0o0xo(source, i2, i3);
        }
        return x0xO0oo(this, X0o0xo2, destination, i, 0, 0, 24, null);
    }

    @OOXIXo
    public final String oxoX(@OOXIXo byte[] source) {
        IIX0o.x0xO0oo(source, "source");
        StringBuilder sb = new StringBuilder(source.length);
        for (byte b : source) {
            sb.append((char) b);
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "toString(...)");
        return sb2;
    }

    public final int x0XOIxOo(@OOXIXo byte[] source, @OOXIXo byte[] destination, int i, int i2, int i3) {
        IIX0o.x0xO0oo(source, "source");
        IIX0o.x0xO0oo(destination, "destination");
        Oxx0IOOO(source.length, i2, i3);
        XO(destination.length, i, Oo(source, i2, i3));
        return oOoXoXO(source, destination, i, i2, i3);
    }

    public final int xXxxox0I(byte[] bArr, int i, int i2) {
        if (!this.f246II0xO0) {
            return i;
        }
        while (i < i2) {
            if (I0Io.oIX0oI()[bArr[i] & 255] != -1) {
                return i;
            }
            i++;
        }
        return i;
    }

    public final int xoXoI(int i) {
        int i2;
        int i3 = (i + 2) / 3;
        if (this.f246II0xO0) {
            i2 = (i3 - 1) / 19;
        } else {
            i2 = 0;
        }
        int i4 = (i3 * 4) + (i2 * 2);
        if (i4 >= 0) {
            return i4;
        }
        throw new IllegalArgumentException("Input is too big");
    }

    @OOXIXo
    public final byte[] xxIXOIIO(@OOXIXo byte[] source, int i, int i2) {
        IIX0o.x0xO0oo(source, "source");
        Oxx0IOOO(source.length, i, i2);
        int Oo2 = Oo(source, i, i2);
        byte[] bArr = new byte[Oo2];
        if (oOoXoXO(source, bArr, 0, i, i2) == Oo2) {
            return bArr;
        }
        throw new IllegalStateException("Check failed.");
    }

    public final boolean xxX() {
        return this.f246II0xO0;
    }

    public oIX0oI(boolean z, boolean z2) {
        this.f247oIX0oI = z;
        this.f246II0xO0 = z2;
        if (z && z2) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }
}
