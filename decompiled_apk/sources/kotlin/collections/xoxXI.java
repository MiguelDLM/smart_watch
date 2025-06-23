package kotlin.collections;

import kotlin.OO0x0xX;
import kotlin.OX00O0xII;
import kotlin.xX0IIXIx0;

/* loaded from: classes6.dex */
public final class xoxXI {
    @kotlin.oI0IIXIo
    public static final int I0Io(short[] sArr, int i, int i2) {
        int i3;
        short OOXIXo2 = xX0IIXIx0.OOXIXo(sArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                int OOXIXo3 = xX0IIXIx0.OOXIXo(sArr, i) & OX00O0xII.f29066Oxx0xo;
                i3 = OOXIXo2 & OX00O0xII.f29066Oxx0xo;
                if (kotlin.jvm.internal.IIX0o.oI0IIXIo(OOXIXo3, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (kotlin.jvm.internal.IIX0o.oI0IIXIo(xX0IIXIx0.OOXIXo(sArr, i2) & OX00O0xII.f29066Oxx0xo, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                short OOXIXo4 = xX0IIXIx0.OOXIXo(sArr, i);
                xX0IIXIx0.IXxxXO(sArr, i, xX0IIXIx0.OOXIXo(sArr, i2));
                xX0IIXIx0.IXxxXO(sArr, i2, OOXIXo4);
                i++;
                i2--;
            }
        }
        return i;
    }

    @kotlin.oI0IIXIo
    public static final void II0XooXoX(int[] iArr, int i, int i2) {
        int oxoX2 = oxoX(iArr, i, i2);
        int i3 = oxoX2 - 1;
        if (i < i3) {
            II0XooXoX(iArr, i, i3);
        }
        if (oxoX2 < i2) {
            II0XooXoX(iArr, oxoX2, i2);
        }
    }

    @kotlin.oI0IIXIo
    public static final int II0xO0(byte[] bArr, int i, int i2) {
        int i3;
        byte OOXIXo2 = OO0x0xX.OOXIXo(bArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                i3 = OOXIXo2 & 255;
                if (kotlin.jvm.internal.IIX0o.oI0IIXIo(OO0x0xX.OOXIXo(bArr, i) & 255, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (kotlin.jvm.internal.IIX0o.oI0IIXIo(OO0x0xX.OOXIXo(bArr, i2) & 255, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                byte OOXIXo3 = OO0x0xX.OOXIXo(bArr, i);
                OO0x0xX.IXxxXO(bArr, i, OO0x0xX.OOXIXo(bArr, i2));
                OO0x0xX.IXxxXO(bArr, i2, OOXIXo3);
                i++;
                i2--;
            }
        }
        return i;
    }

    @kotlin.oI0IIXIo
    public static final void OOXIXo(@OXOo.OOXIXo short[] array, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(array, "array");
        Oxx0IOOO(array, i, i2 - 1);
    }

    @kotlin.oI0IIXIo
    public static final void Oxx0IOOO(short[] sArr, int i, int i2) {
        int I0Io2 = I0Io(sArr, i, i2);
        int i3 = I0Io2 - 1;
        if (i < i3) {
            Oxx0IOOO(sArr, i, i3);
        }
        if (I0Io2 < i2) {
            Oxx0IOOO(sArr, I0Io2, i2);
        }
    }

    @kotlin.oI0IIXIo
    public static final void X0o0xo(long[] jArr, int i, int i2) {
        int oIX0oI2 = oIX0oI(jArr, i, i2);
        int i3 = oIX0oI2 - 1;
        if (i < i3) {
            X0o0xo(jArr, i, i3);
        }
        if (oIX0oI2 < i2) {
            X0o0xo(jArr, oIX0oI2, i2);
        }
    }

    @kotlin.oI0IIXIo
    public static final void XO(byte[] bArr, int i, int i2) {
        int II0xO02 = II0xO0(bArr, i, i2);
        int i3 = II0xO02 - 1;
        if (i < i3) {
            XO(bArr, i, i3);
        }
        if (II0xO02 < i2) {
            XO(bArr, II0xO02, i2);
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0012 */
    /* JADX WARN: Incorrect condition in loop: B:8:0x001f */
    @kotlin.oI0IIXIo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int oIX0oI(long[] r6, int r7, int r8) {
        /*
            int r0 = r7 + r8
            int r0 = r0 / 2
            long r0 = kotlin.OOXIxO0.OOXIXo(r6, r0)
        L8:
            if (r7 > r8) goto L39
        La:
            long r2 = kotlin.OOXIxO0.OOXIXo(r6, r7)
            int r2 = androidx.collection.II0xO0.oIX0oI(r2, r0)
            if (r2 >= 0) goto L17
            int r7 = r7 + 1
            goto La
        L17:
            long r2 = kotlin.OOXIxO0.OOXIXo(r6, r8)
            int r2 = androidx.collection.II0xO0.oIX0oI(r2, r0)
            if (r2 <= 0) goto L24
            int r8 = r8 + (-1)
            goto L17
        L24:
            if (r7 > r8) goto L8
            long r2 = kotlin.OOXIxO0.OOXIXo(r6, r7)
            long r4 = kotlin.OOXIxO0.OOXIXo(r6, r8)
            kotlin.OOXIxO0.IXxxXO(r6, r7, r4)
            kotlin.OOXIxO0.IXxxXO(r6, r8, r2)
            int r7 = r7 + 1
            int r8 = r8 + (-1)
            goto L8
        L39:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.xoxXI.oIX0oI(long[], int, int):int");
    }

    @kotlin.oI0IIXIo
    public static final void oOoXoXO(@OXOo.OOXIXo int[] array, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(array, "array");
        II0XooXoX(array, i, i2 - 1);
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0012 */
    /* JADX WARN: Incorrect condition in loop: B:8:0x001f */
    @kotlin.oI0IIXIo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int oxoX(int[] r3, int r4, int r5) {
        /*
            int r0 = r4 + r5
            int r0 = r0 / 2
            int r0 = kotlin.XX0xXo.OOXIXo(r3, r0)
        L8:
            if (r4 > r5) goto L39
        La:
            int r1 = kotlin.XX0xXo.OOXIXo(r3, r4)
            int r1 = kotlin.xoIxX.oIX0oI(r1, r0)
            if (r1 >= 0) goto L17
            int r4 = r4 + 1
            goto La
        L17:
            int r1 = kotlin.XX0xXo.OOXIXo(r3, r5)
            int r1 = kotlin.xoIxX.oIX0oI(r1, r0)
            if (r1 <= 0) goto L24
            int r5 = r5 + (-1)
            goto L17
        L24:
            if (r4 > r5) goto L8
            int r1 = kotlin.XX0xXo.OOXIXo(r3, r4)
            int r2 = kotlin.XX0xXo.OOXIXo(r3, r5)
            kotlin.XX0xXo.IXxxXO(r3, r4, r2)
            kotlin.XX0xXo.IXxxXO(r3, r5, r1)
            int r4 = r4 + 1
            int r5 = r5 + (-1)
            goto L8
        L39:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.xoxXI.oxoX(int[], int, int):int");
    }

    @kotlin.oI0IIXIo
    public static final void xoIox(@OXOo.OOXIXo byte[] array, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(array, "array");
        XO(array, i, i2 - 1);
    }

    @kotlin.oI0IIXIo
    public static final void xxIXOIIO(@OXOo.OOXIXo long[] array, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(array, "array");
        X0o0xo(array, i, i2 - 1);
    }
}
