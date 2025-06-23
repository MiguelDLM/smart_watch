package com.kwad.sdk.core.a;

import IIIxO.oIX0oI;
import android.text.TextUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import java.nio.charset.Charset;
import java.util.Arrays;

/* loaded from: classes11.dex */
public final class c {
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

    /* loaded from: classes11.dex */
    public static class b {
        static final b awe = new b(false, null, -1, true);
        static final b awf = new b(true, null, -1, false);
        private static final char[] awg = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', IOUtils.DIR_SEPARATOR_UNIX};
        private static final char[] awh = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'};
        private final boolean awc;
        private final byte[] awi = null;
        private final int awj = -1;
        private final boolean awk;

        private b(boolean z, byte[] bArr, int i, boolean z2) {
            this.awc = z;
            this.awk = z2;
        }

        private int b(byte[] bArr, int i, int i2, byte[] bArr2) {
            char[] cArr;
            int i3;
            if (this.awc) {
                cArr = awh;
            } else {
                cArr = awg;
            }
            int i4 = (i2 / 3) * 3;
            int i5 = this.awj;
            if (i5 > 0 && i4 > (i5 / 4) * 3) {
                i3 = (i5 / 4) * 3;
            } else {
                i3 = i4;
            }
            int i6 = 0;
            int i7 = 0;
            while (i6 < i4) {
                int min = Math.min(i6 + i3, i4);
                int i8 = i6;
                int i9 = i7;
                while (i8 < min) {
                    int i10 = i8 + 2;
                    int i11 = ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8] & 255) << 16);
                    i8 += 3;
                    int i12 = i11 | (bArr[i10] & 255);
                    bArr2[i9] = (byte) cArr[(i12 >>> 18) & 63];
                    bArr2[i9 + 1] = (byte) cArr[(i12 >>> 12) & 63];
                    int i13 = i9 + 3;
                    bArr2[i9 + 2] = (byte) cArr[(i12 >>> 6) & 63];
                    i9 += 4;
                    bArr2[i13] = (byte) cArr[i12 & 63];
                }
                int i14 = ((min - i6) / 3) * 4;
                i7 += i14;
                if (i14 == this.awj && min < i2) {
                    byte[] bArr3 = this.awi;
                    int length = bArr3.length;
                    int i15 = 0;
                    while (i15 < length) {
                        bArr2[i7] = bArr3[i15];
                        i15++;
                        i7++;
                    }
                }
                i6 = min;
            }
            if (i6 < i2) {
                int i16 = i6 + 1;
                int i17 = bArr[i6] & 255;
                int i18 = i7 + 1;
                bArr2[i7] = (byte) cArr[i17 >> 2];
                if (i16 == i2) {
                    int i19 = i7 + 2;
                    bArr2[i18] = (byte) cArr[(i17 << 4) & 63];
                    if (this.awk) {
                        int i20 = i7 + 3;
                        bArr2[i19] = oIX0oI.f236II0XooXoX;
                        int i21 = i7 + 4;
                        bArr2[i20] = oIX0oI.f236II0XooXoX;
                        return i21;
                    }
                    return i19;
                }
                int i22 = bArr[i16] & 255;
                bArr2[i18] = (byte) cArr[((i17 << 4) & 63) | (i22 >> 4)];
                int i23 = i7 + 3;
                bArr2[i7 + 2] = (byte) cArr[(i22 << 2) & 63];
                if (this.awk) {
                    int i24 = i7 + 4;
                    bArr2[i23] = oIX0oI.f236II0XooXoX;
                    return i24;
                }
                return i23;
            }
            return i7;
        }

        private final int dd(int i) {
            int i2;
            int i3;
            if (this.awk) {
                i3 = ((i + 2) / 3) * 4;
            } else {
                int i4 = i % 3;
                int i5 = (i / 3) * 4;
                if (i4 == 0) {
                    i2 = 0;
                } else {
                    i2 = i4 + 1;
                }
                i3 = i5 + i2;
            }
            int i6 = this.awj;
            if (i6 > 0) {
                return i3 + (((i3 - 1) / i6) * this.awi.length);
            }
            return i3;
        }

        public final byte[] encode(byte[] bArr) {
            int dd = dd(bArr.length);
            byte[] bArr2 = new byte[dd];
            int b = b(bArr, 0, bArr.length, bArr2);
            if (b != dd) {
                return Arrays.copyOf(bArr2, b);
            }
            return bArr2;
        }

        public final String encodeToString(byte[] bArr) {
            byte[] encode = encode(bArr);
            return new String(encode, 0, 0, encode.length);
        }
    }

    public static b Ec() {
        return b.awe;
    }

    public static b Ed() {
        return b.awf;
    }

    public static a Ee() {
        return a.avY;
    }

    public static a Ef() {
        return a.avZ;
    }

    public static String dR(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return "sDAkk/dS" + new String(Ec().encode(str.getBytes()), com.kwad.sdk.crash.utils.a.UTF_8);
    }

    public static String dS(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith("sDAkk/dS")) {
            return new String(Ee().decode(str.substring(8)), com.kwad.sdk.crash.utils.a.UTF_8);
        }
        return str;
    }

    public static boolean dT(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("sDAkk/dS");
    }

    /* loaded from: classes11.dex */
    public static class a {
        private static final int[] awa;
        private final boolean awc;
        private final boolean awd = false;
        static final a avY = new a(false, false);
        static final a avZ = new a(true, false);
        private static final int[] awb = new int[256];

        static {
            int[] iArr = new int[256];
            awa = iArr;
            Arrays.fill(iArr, -1);
            for (int i = 0; i < b.awg.length; i++) {
                awa[b.awg[i]] = i;
            }
            awa[61] = -2;
            Arrays.fill(awb, -1);
            for (int i2 = 0; i2 < b.awh.length; i2++) {
                awb[b.awh[i2]] = i2;
            }
            awb[61] = -2;
        }

        private a(boolean z, boolean z2) {
            this.awc = z;
        }

        private int a(byte[] bArr, int i, int i2) {
            int i3;
            int[] iArr = this.awc ? awb : awa;
            int i4 = 0;
            if (i2 == 0) {
                return 0;
            }
            if (i2 < 2) {
                if (this.awd && iArr[0] == -1) {
                    return 0;
                }
                throw new IllegalArgumentException("Input byte[] should at least have 2 bytes for base64 bytes");
            }
            if (this.awd) {
                int i5 = 0;
                while (true) {
                    if (i >= i2) {
                        break;
                    }
                    int i6 = i + 1;
                    int i7 = bArr[i] & 255;
                    if (i7 == 61) {
                        i2 -= (i2 - i6) + 1;
                        break;
                    }
                    if (iArr[i7] == -1) {
                        i5++;
                    }
                    i = i6;
                }
                i2 -= i5;
            } else if (bArr[i2 - 1] == 61) {
                i4 = bArr[i2 + (-2)] == 61 ? 2 : 1;
            }
            if (i4 == 0 && (i3 = i2 & 3) != 0) {
                i4 = 4 - i3;
            }
            return (((i2 + 3) / 4) * 3) - i4;
        }

        public final byte[] decode(byte[] bArr) {
            int a2 = a(bArr, 0, bArr.length);
            byte[] bArr2 = new byte[a2];
            int a3 = a(bArr, 0, bArr.length, bArr2);
            return a3 != a2 ? Arrays.copyOf(bArr2, a3) : bArr2;
        }

        public final byte[] decode(String str) {
            return decode(str.getBytes(c.ISO_8859_1));
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x002c, code lost:
        
            if (r12[r8] == 61) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0030, code lost:
        
            if (r4 != 18) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x007b, code lost:
        
            if (r4 != 6) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x007d, code lost:
        
            r15[r5] = (byte) (r3 >> 16);
            r5 = r5 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x009b, code lost:
        
            if (r13 >= r14) goto L57;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x009f, code lost:
        
            if (r11.awd == false) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00a1, code lost:
        
            r15 = r13 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00a7, code lost:
        
            if (r0[r12[r13]] >= 0) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00a9, code lost:
        
            r13 = r15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00ab, code lost:
        
            r13 = r15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00bf, code lost:
        
            throw new java.lang.IllegalArgumentException("Input byte array has incorrect ending byte at " + r13);
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00c0, code lost:
        
            return r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0086, code lost:
        
            if (r4 != 0) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0088, code lost:
        
            r1 = r5 + 1;
            r15[r5] = (byte) (r3 >> 16);
            r5 = r5 + 2;
            r15[r1] = (byte) (r3 >> 8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0099, code lost:
        
            if (r4 == 12) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00c8, code lost:
        
            throw new java.lang.IllegalArgumentException("Last unit does not have enough valid bits");
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private int a(byte[] r12, int r13, int r14, byte[] r15) {
            /*
                Method dump skipped, instructions count: 201
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.a.c.a.a(byte[], int, int, byte[]):int");
        }
    }
}
