package oI0;

import IIIxO.oIX0oI;
import oI0.XO;
import okio.Utf8;

/* loaded from: classes6.dex */
public class X0o0xo extends XO {

    /* renamed from: I0Io, reason: collision with root package name */
    public final byte[] f31332I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final byte[] f31333II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final int f31334X0o0xo;

    /* renamed from: oxoX, reason: collision with root package name */
    public final int f31335oxoX;

    /* renamed from: XO, reason: collision with root package name */
    public static final byte[] f31330XO = {13, 10};

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final byte[] f31329Oxx0IOOO = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final byte[] f31328II0XooXoX = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final byte[] f31331xxIXOIIO = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, oIX0oI.f236II0XooXoX, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, Utf8.REPLACEMENT_BYTE, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};

    public X0o0xo(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    public void X0o0xo(byte[] bArr, int i, int i2, XO.oIX0oI oix0oi) {
        if (oix0oi.f31340X0o0xo) {
            return;
        }
        if (i2 < 0) {
            oix0oi.f31340X0o0xo = true;
            if (oix0oi.f31339Oxx0IOOO == 0 && this.f31336oIX0oI == 0) {
                return;
            }
            byte[] I0Io2 = I0Io(this.f31334X0o0xo, oix0oi);
            int i3 = oix0oi.f31337I0Io;
            int i4 = oix0oi.f31339Oxx0IOOO;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 == 2) {
                        int i5 = i3 + 1;
                        oix0oi.f31337I0Io = i5;
                        byte[] bArr2 = this.f31333II0xO0;
                        int i6 = oix0oi.f31342oIX0oI;
                        I0Io2[i3] = bArr2[(i6 >> 10) & 63];
                        int i7 = i3 + 2;
                        oix0oi.f31337I0Io = i7;
                        I0Io2[i5] = bArr2[(i6 >> 4) & 63];
                        int i8 = i3 + 3;
                        oix0oi.f31337I0Io = i8;
                        I0Io2[i7] = bArr2[(i6 << 2) & 63];
                        if (bArr2 == f31329Oxx0IOOO) {
                            oix0oi.f31337I0Io = i3 + 4;
                            I0Io2[i8] = oIX0oI.f236II0XooXoX;
                        }
                    } else {
                        throw new IllegalStateException("Impossible modulus " + oix0oi.f31339Oxx0IOOO);
                    }
                } else {
                    int i9 = i3 + 1;
                    oix0oi.f31337I0Io = i9;
                    byte[] bArr3 = this.f31333II0xO0;
                    int i10 = oix0oi.f31342oIX0oI;
                    I0Io2[i3] = bArr3[(i10 >> 2) & 63];
                    int i11 = i3 + 2;
                    oix0oi.f31337I0Io = i11;
                    I0Io2[i9] = bArr3[(i10 << 4) & 63];
                    if (bArr3 == f31329Oxx0IOOO) {
                        int i12 = i3 + 3;
                        oix0oi.f31337I0Io = i12;
                        I0Io2[i11] = oIX0oI.f236II0XooXoX;
                        oix0oi.f31337I0Io = i3 + 4;
                        I0Io2[i12] = oIX0oI.f236II0XooXoX;
                    }
                }
            }
            int i13 = oix0oi.f31341XO;
            int i14 = oix0oi.f31337I0Io;
            int i15 = i13 + (i14 - i3);
            oix0oi.f31341XO = i15;
            if (this.f31336oIX0oI > 0 && i15 > 0) {
                byte[] bArr4 = this.f31332I0Io;
                System.arraycopy(bArr4, 0, I0Io2, i14, bArr4.length);
                oix0oi.f31337I0Io += this.f31332I0Io.length;
                return;
            }
            return;
        }
        int i16 = 0;
        while (i16 < i2) {
            byte[] I0Io3 = I0Io(this.f31334X0o0xo, oix0oi);
            int i17 = (oix0oi.f31339Oxx0IOOO + 1) % 3;
            oix0oi.f31339Oxx0IOOO = i17;
            int i18 = i + 1;
            int i19 = bArr[i];
            if (i19 < 0) {
                i19 += 256;
            }
            int i20 = (oix0oi.f31342oIX0oI << 8) + i19;
            oix0oi.f31342oIX0oI = i20;
            if (i17 == 0) {
                int i21 = oix0oi.f31337I0Io;
                int i22 = i21 + 1;
                oix0oi.f31337I0Io = i22;
                byte[] bArr5 = this.f31333II0xO0;
                I0Io3[i21] = bArr5[(i20 >> 18) & 63];
                int i23 = i21 + 2;
                oix0oi.f31337I0Io = i23;
                I0Io3[i22] = bArr5[(i20 >> 12) & 63];
                int i24 = i21 + 3;
                oix0oi.f31337I0Io = i24;
                I0Io3[i23] = bArr5[(i20 >> 6) & 63];
                int i25 = i21 + 4;
                oix0oi.f31337I0Io = i25;
                I0Io3[i24] = bArr5[i20 & 63];
                int i26 = oix0oi.f31341XO + 4;
                oix0oi.f31341XO = i26;
                int i27 = this.f31336oIX0oI;
                if (i27 > 0 && i27 <= i26) {
                    byte[] bArr6 = this.f31332I0Io;
                    System.arraycopy(bArr6, 0, I0Io3, i25, bArr6.length);
                    oix0oi.f31337I0Io += this.f31332I0Io.length;
                    oix0oi.f31341XO = 0;
                }
            }
            i16++;
            i = i18;
        }
    }

    public void oxoX(byte[] bArr, int i, int i2, XO.oIX0oI oix0oi) {
        byte b;
        if (oix0oi.f31340X0o0xo) {
            return;
        }
        if (i2 < 0) {
            oix0oi.f31340X0o0xo = true;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            byte[] I0Io2 = I0Io(this.f31335oxoX, oix0oi);
            int i4 = i + 1;
            byte b2 = bArr[i];
            if (b2 == 61) {
                oix0oi.f31340X0o0xo = true;
                break;
            }
            if (b2 >= 0) {
                byte[] bArr2 = f31331xxIXOIIO;
                if (b2 < bArr2.length && (b = bArr2[b2]) >= 0) {
                    int i5 = (oix0oi.f31339Oxx0IOOO + 1) % 4;
                    oix0oi.f31339Oxx0IOOO = i5;
                    int i6 = (oix0oi.f31342oIX0oI << 6) + b;
                    oix0oi.f31342oIX0oI = i6;
                    if (i5 == 0) {
                        int i7 = oix0oi.f31337I0Io;
                        int i8 = i7 + 1;
                        oix0oi.f31337I0Io = i8;
                        I0Io2[i7] = (byte) ((i6 >> 16) & 255);
                        int i9 = i7 + 2;
                        oix0oi.f31337I0Io = i9;
                        I0Io2[i8] = (byte) ((i6 >> 8) & 255);
                        oix0oi.f31337I0Io = i7 + 3;
                        I0Io2[i9] = (byte) (i6 & 255);
                    }
                }
            }
            i3++;
            i = i4;
        }
        if (oix0oi.f31340X0o0xo && oix0oi.f31339Oxx0IOOO != 0) {
            byte[] I0Io3 = I0Io(this.f31335oxoX, oix0oi);
            int i10 = oix0oi.f31339Oxx0IOOO;
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 == 3) {
                        int i11 = oix0oi.f31342oIX0oI;
                        int i12 = i11 >> 2;
                        oix0oi.f31342oIX0oI = i12;
                        int i13 = oix0oi.f31337I0Io;
                        int i14 = i13 + 1;
                        oix0oi.f31337I0Io = i14;
                        I0Io3[i13] = (byte) ((i11 >> 10) & 255);
                        oix0oi.f31337I0Io = i13 + 2;
                        I0Io3[i14] = (byte) (i12 & 255);
                        return;
                    }
                    throw new IllegalStateException("Impossible modulus " + oix0oi.f31339Oxx0IOOO);
                }
                int i15 = oix0oi.f31342oIX0oI >> 4;
                oix0oi.f31342oIX0oI = i15;
                int i16 = oix0oi.f31337I0Io;
                oix0oi.f31337I0Io = i16 + 1;
                I0Io3[i16] = (byte) (i15 & 255);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public X0o0xo(int r5, byte[] r6, boolean r7) {
        /*
            r4 = this;
            r0 = 0
            if (r6 != 0) goto L5
            r1 = 0
            goto L6
        L5:
            int r1 = r6.length
        L6:
            r2 = 3
            r3 = 4
            r4.<init>(r2, r3, r5, r1)
            if (r6 == 0) goto L43
            boolean r1 = r4.II0xO0(r6)
            if (r1 != 0) goto L23
            if (r5 <= 0) goto L43
            int r5 = r6.length
            int r5 = r5 + r3
            r4.f31334X0o0xo = r5
            int r5 = r6.length
            byte[] r5 = new byte[r5]
            r4.f31332I0Io = r5
            int r1 = r6.length
            java.lang.System.arraycopy(r6, r0, r5, r0, r1)
            goto L48
        L23:
            java.lang.String r5 = oI0.Oxx0IOOO.oIX0oI(r6)
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "lineSeparator must not contain base64 characters: ["
            r7.append(r0)
            r7.append(r5)
            java.lang.String r5 = "]"
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r6.<init>(r5)
            throw r6
        L43:
            r4.f31334X0o0xo = r3
            r5 = 0
            r4.f31332I0Io = r5
        L48:
            int r5 = r4.f31334X0o0xo
            int r5 = r5 + (-1)
            r4.f31335oxoX = r5
            if (r7 == 0) goto L53
            byte[] r5 = oI0.X0o0xo.f31328II0XooXoX
            goto L55
        L53:
            byte[] r5 = oI0.X0o0xo.f31329Oxx0IOOO
        L55:
            r4.f31333II0xO0 = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: oI0.X0o0xo.<init>(int, byte[], boolean):void");
    }
}
