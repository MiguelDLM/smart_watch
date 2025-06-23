package org.apache.commons.lang3;

import com.szabh.smable3.entity.BleWatchFaceId;
import java.util.UUID;
import kotlin.OX00O0xII;

/* loaded from: classes6.dex */
public class x0xO0oo {

    /* renamed from: Oo, reason: collision with root package name */
    public static final /* synthetic */ boolean f32930Oo = false;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final boolean[] f32934oIX0oI = {true, true, true, true};

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final boolean[] f32928II0xO0 = {false, true, true, true};

    /* renamed from: I0Io, reason: collision with root package name */
    public static final boolean[] f32926I0Io = {true, false, true, true};

    /* renamed from: oxoX, reason: collision with root package name */
    public static final boolean[] f32938oxoX = {false, false, true, true};

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final boolean[] f32932X0o0xo = {true, true, false, true};

    /* renamed from: XO, reason: collision with root package name */
    public static final boolean[] f32933XO = {false, true, false, true};

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final boolean[] f32931Oxx0IOOO = {true, false, false, true};

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final boolean[] f32927II0XooXoX = {false, false, false, true};

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final boolean[] f32942xxIXOIIO = {true, true, true, false};

    /* renamed from: xoIox, reason: collision with root package name */
    public static final boolean[] f32941xoIox = {false, true, true, false};

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final boolean[] f32929OOXIXo = {true, false, true, false};

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final boolean[] f32936oOoXoXO = {false, false, true, false};

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final boolean[] f32937ooOOo0oXI = {true, true, false, false};

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final boolean[] f32939x0XOIxOo = {false, true, false, false};

    /* renamed from: oO, reason: collision with root package name */
    public static final boolean[] f32935oO = {true, false, false, false};

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final boolean[] f32940x0xO0oo = {false, false, false, false};

    public static byte I0Io(boolean[] zArr, int i, byte b, int i2, int i3) {
        if ((zArr.length == 0 && i == 0) || i3 == 0) {
            return b;
        }
        if ((i3 - 1) + i2 < 8) {
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = i4 + i2;
                b = (byte) ((b & (~(1 << i5))) | ((zArr[i4 + i] ? 1 : 0) << i5));
            }
            return b;
        }
        throw new IllegalArgumentException("nBools-1+dstPos is greater or equal to than 8");
    }

    public static int II0XooXoX(boolean[] zArr, int i, int i2, int i3, int i4) {
        if ((zArr.length == 0 && i == 0) || i4 == 0) {
            return i2;
        }
        if ((i4 - 1) + i3 < 32) {
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = i5 + i3;
                i2 = (i2 & (~(1 << i6))) | ((zArr[i5 + i] ? 1 : 0) << i6);
            }
            return i2;
        }
        throw new IllegalArgumentException("nBools-1+dstPos is greater or equal to than 32");
    }

    public static char II0xO0(boolean[] zArr, int i) {
        if (zArr.length != 0) {
            int length = ((zArr.length - 1) - i) + 1;
            int min = Math.min(4, length);
            boolean[] zArr2 = new boolean[4];
            System.arraycopy(zArr, length - min, zArr2, 4 - min, min);
            if (zArr2[0]) {
                if (zArr2[1]) {
                    if (zArr2[2]) {
                        if (zArr2[3]) {
                            return 'f';
                        }
                        return 'e';
                    }
                    if (zArr2[3]) {
                        return 'd';
                    }
                    return 'c';
                }
                if (zArr2[2]) {
                    if (zArr2[3]) {
                        return 'b';
                    }
                    return 'a';
                }
                if (zArr2[3]) {
                    return '9';
                }
                return '8';
            }
            if (zArr2[1]) {
                if (zArr2[2]) {
                    if (zArr2[3]) {
                        return '7';
                    }
                    return '6';
                }
                if (zArr2[3]) {
                    return '5';
                }
                return '4';
            }
            if (zArr2[2]) {
                if (zArr2[3]) {
                    return '3';
                }
                return '2';
            }
            if (zArr2[3]) {
                return '1';
            }
            return '0';
        }
        throw new IllegalArgumentException("Cannot convert an empty array.");
    }

    public static byte[] IIX0o(long j, int i, byte[] bArr, int i2, int i3) {
        if (i3 == 0) {
            return bArr;
        }
        if (((i3 - 1) * 8) + i < 64) {
            for (int i4 = 0; i4 < i3; i4++) {
                bArr[i2 + i4] = (byte) (255 & (j >> ((i4 * 8) + i)));
            }
            return bArr;
        }
        throw new IllegalArgumentException("(nBytes-1)*8+srcPos is greater or equal to than 64");
    }

    public static int IIXOooo(String str, int i, int i2, int i3, int i4) {
        if (i4 == 0) {
            return i2;
        }
        if (((i4 - 1) * 4) + i3 < 32) {
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = (i5 * 4) + i3;
                i2 = (i2 & (~(15 << i6))) | ((oI0IIXIo(str.charAt(i5 + i)) & 15) << i6);
            }
            return i2;
        }
        throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greater or equal to than 32");
    }

    public static byte[] IO(UUID uuid, byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return bArr;
        }
        if (i2 <= 16) {
            IIX0o(uuid.getMostSignificantBits(), 0, bArr, i, Math.min(i2, 8));
            if (i2 >= 8) {
                IIX0o(uuid.getLeastSignificantBits(), 0, bArr, i + 8, i2 - 8);
            }
            return bArr;
        }
        throw new IllegalArgumentException("nBytes is greater than 16");
    }

    public static int IXxxXO(char c) {
        switch (c) {
            case '0':
                return 0;
            case '1':
                return 8;
            case '2':
                return 4;
            case '3':
                return 12;
            case '4':
                return 2;
            case '5':
                return 10;
            case '6':
                return 6;
            case '7':
                return 14;
            case '8':
                return 1;
            case '9':
                return 9;
            default:
                switch (c) {
                    case 'A':
                        return 5;
                    case 'B':
                        return 13;
                    case 'C':
                        return 3;
                    case 'D':
                        return 11;
                    case 'E':
                        return 7;
                    case 'F':
                        return 15;
                    default:
                        switch (c) {
                            case 'a':
                                return 5;
                            case 'b':
                                return 13;
                            case 'c':
                                return 3;
                            case 'd':
                                return 11;
                            case 'e':
                                return 7;
                            case 'f':
                                return 15;
                            default:
                                throw new IllegalArgumentException("Cannot interpret '" + c + "' as a hexadecimal digit");
                        }
                }
        }
    }

    public static long IoOoX(short[] sArr, int i, long j, int i2, int i3) {
        if ((sArr.length == 0 && i == 0) || i3 == 0) {
            return j;
        }
        if (((i3 - 1) * 16) + i2 < 64) {
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = (i4 * 16) + i2;
                j = (j & (~(65535 << i5))) | ((sArr[i4 + i] & 65535) << i5);
            }
            return j;
        }
        throw new IllegalArgumentException("(nShorts-1)*16+dstPos is greater or equal to than 64");
    }

    public static boolean[] O0xOxO(int i, int i2, boolean[] zArr, int i3, int i4) {
        if (i4 == 0) {
            return zArr;
        }
        if ((i4 - 1) + i2 < 32) {
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = i3 + i5;
                boolean z = true;
                if (((i >> (i5 + i2)) & 1) == 0) {
                    z = false;
                }
                zArr[i6] = z;
            }
            return zArr;
        }
        throw new IllegalArgumentException("nBools-1+srcPos is greater or equal to than 32");
    }

    public static int OOXIXo(byte[] bArr, int i, int i2, int i3, int i4) {
        if ((bArr.length == 0 && i == 0) || i4 == 0) {
            return i2;
        }
        if (((i4 - 1) * 8) + i3 < 32) {
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = (i5 * 8) + i3;
                i2 = (i2 & (~(255 << i6))) | ((bArr[i5 + i] & 255) << i6);
            }
            return i2;
        }
        throw new IllegalArgumentException("(nBytes-1)*8+dstPos is greater or equal to than 32");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0003. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean[] Oo(char r3) {
        /*
            switch(r3) {
                case 48: goto Lac;
                case 49: goto La3;
                case 50: goto L9a;
                case 51: goto L91;
                case 52: goto L88;
                case 53: goto L7f;
                case 54: goto L76;
                case 55: goto L6d;
                case 56: goto L64;
                case 57: goto L5b;
                default: goto L3;
            }
        L3:
            switch(r3) {
                case 65: goto L52;
                case 66: goto L49;
                case 67: goto L40;
                case 68: goto L37;
                case 69: goto L2e;
                case 70: goto L25;
                default: goto L6;
            }
        L6:
            switch(r3) {
                case 97: goto L52;
                case 98: goto L49;
                case 99: goto L40;
                case 100: goto L37;
                case 101: goto L2e;
                case 102: goto L25;
                default: goto L9;
            }
        L9:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot interpret '"
            r1.append(r2)
            r1.append(r3)
            java.lang.String r3 = "' as a hexadecimal digit"
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            r0.<init>(r3)
            throw r0
        L25:
            boolean[] r3 = org.apache.commons.lang3.x0xO0oo.f32934oIX0oI
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L2e:
            boolean[] r3 = org.apache.commons.lang3.x0xO0oo.f32942xxIXOIIO
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L37:
            boolean[] r3 = org.apache.commons.lang3.x0xO0oo.f32932X0o0xo
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L40:
            boolean[] r3 = org.apache.commons.lang3.x0xO0oo.f32937ooOOo0oXI
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L49:
            boolean[] r3 = org.apache.commons.lang3.x0xO0oo.f32926I0Io
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L52:
            boolean[] r3 = org.apache.commons.lang3.x0xO0oo.f32929OOXIXo
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L5b:
            boolean[] r3 = org.apache.commons.lang3.x0xO0oo.f32931Oxx0IOOO
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L64:
            boolean[] r3 = org.apache.commons.lang3.x0xO0oo.f32935oO
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L6d:
            boolean[] r3 = org.apache.commons.lang3.x0xO0oo.f32928II0xO0
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L76:
            boolean[] r3 = org.apache.commons.lang3.x0xO0oo.f32941xoIox
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L7f:
            boolean[] r3 = org.apache.commons.lang3.x0xO0oo.f32933XO
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L88:
            boolean[] r3 = org.apache.commons.lang3.x0xO0oo.f32939x0XOIxOo
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L91:
            boolean[] r3 = org.apache.commons.lang3.x0xO0oo.f32938oxoX
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L9a:
            boolean[] r3 = org.apache.commons.lang3.x0xO0oo.f32936oOoXoXO
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        La3:
            boolean[] r3 = org.apache.commons.lang3.x0xO0oo.f32927II0XooXoX
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        Lac:
            boolean[] r3 = org.apache.commons.lang3.x0xO0oo.f32940x0xO0oo
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.x0xO0oo.Oo(char):boolean[]");
    }

    public static long OxI(int[] iArr, int i, long j, int i2, int i3) {
        if ((iArr.length == 0 && i == 0) || i3 == 0) {
            return j;
        }
        if (((i3 - 1) * 32) + i2 < 64) {
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = (i4 * 32) + i2;
                j = (j & (~(BleWatchFaceId.WATCHFACE_ID_INVALID << i5))) | ((iArr[i4 + i] & BleWatchFaceId.WATCHFACE_ID_INVALID) << i5);
            }
            return j;
        }
        throw new IllegalArgumentException("(nInts-1)*32+dstPos is greater or equal to than 64");
    }

    public static char Oxx0IOOO(boolean[] zArr, int i) {
        if (zArr.length <= 8) {
            if (zArr.length - i >= 4) {
                if (zArr[i + 3]) {
                    if (zArr[i + 2]) {
                        if (zArr[i + 1]) {
                            if (zArr[i]) {
                                return 'f';
                            }
                            return '7';
                        }
                        if (zArr[i]) {
                            return 'b';
                        }
                        return '3';
                    }
                    if (zArr[i + 1]) {
                        if (zArr[i]) {
                            return 'd';
                        }
                        return '5';
                    }
                    if (zArr[i]) {
                        return '9';
                    }
                    return '1';
                }
                if (zArr[i + 2]) {
                    if (zArr[i + 1]) {
                        if (zArr[i]) {
                            return 'e';
                        }
                        return '6';
                    }
                    if (zArr[i]) {
                        return 'a';
                    }
                    return '2';
                }
                if (zArr[i + 1]) {
                    if (zArr[i]) {
                        return 'c';
                    }
                    return '4';
                }
                if (zArr[i]) {
                    return '8';
                }
                return '0';
            }
            throw new IllegalArgumentException("src.length-srcPos<4: src.length=" + zArr.length + ", srcPos=" + i);
        }
        throw new IllegalArgumentException("src.length>8: src.length=" + zArr.length);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0003. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean[] Oxx0xo(char r3) {
        /*
            switch(r3) {
                case 48: goto Lac;
                case 49: goto La3;
                case 50: goto L9a;
                case 51: goto L91;
                case 52: goto L88;
                case 53: goto L7f;
                case 54: goto L76;
                case 55: goto L6d;
                case 56: goto L64;
                case 57: goto L5b;
                default: goto L3;
            }
        L3:
            switch(r3) {
                case 65: goto L52;
                case 66: goto L49;
                case 67: goto L40;
                case 68: goto L37;
                case 69: goto L2e;
                case 70: goto L25;
                default: goto L6;
            }
        L6:
            switch(r3) {
                case 97: goto L52;
                case 98: goto L49;
                case 99: goto L40;
                case 100: goto L37;
                case 101: goto L2e;
                case 102: goto L25;
                default: goto L9;
            }
        L9:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot interpret '"
            r1.append(r2)
            r1.append(r3)
            java.lang.String r3 = "' as a hexadecimal digit"
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            r0.<init>(r3)
            throw r0
        L25:
            boolean[] r3 = org.apache.commons.lang3.x0xO0oo.f32934oIX0oI
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L2e:
            boolean[] r3 = org.apache.commons.lang3.x0xO0oo.f32928II0xO0
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L37:
            boolean[] r3 = org.apache.commons.lang3.x0xO0oo.f32926I0Io
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L40:
            boolean[] r3 = org.apache.commons.lang3.x0xO0oo.f32938oxoX
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L49:
            boolean[] r3 = org.apache.commons.lang3.x0xO0oo.f32932X0o0xo
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L52:
            boolean[] r3 = org.apache.commons.lang3.x0xO0oo.f32933XO
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L5b:
            boolean[] r3 = org.apache.commons.lang3.x0xO0oo.f32931Oxx0IOOO
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L64:
            boolean[] r3 = org.apache.commons.lang3.x0xO0oo.f32927II0XooXoX
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L6d:
            boolean[] r3 = org.apache.commons.lang3.x0xO0oo.f32942xxIXOIIO
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L76:
            boolean[] r3 = org.apache.commons.lang3.x0xO0oo.f32941xoIox
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L7f:
            boolean[] r3 = org.apache.commons.lang3.x0xO0oo.f32929OOXIXo
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L88:
            boolean[] r3 = org.apache.commons.lang3.x0xO0oo.f32936oOoXoXO
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L91:
            boolean[] r3 = org.apache.commons.lang3.x0xO0oo.f32937ooOOo0oXI
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L9a:
            boolean[] r3 = org.apache.commons.lang3.x0xO0oo.f32939x0XOIxOo
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        La3:
            boolean[] r3 = org.apache.commons.lang3.x0xO0oo.f32935oO
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        Lac:
            boolean[] r3 = org.apache.commons.lang3.x0xO0oo.f32940x0xO0oo
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.x0xO0oo.Oxx0xo(char):boolean[]");
    }

    public static byte OxxIIOOXO(String str, int i, byte b, int i2, int i3) {
        if (i3 == 0) {
            return b;
        }
        if (((i3 - 1) * 4) + i2 < 8) {
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = (i4 * 4) + i2;
                b = (byte) ((b & (~(15 << i5))) | ((oI0IIXIo(str.charAt(i4 + i)) & 15) << i5));
            }
            return b;
        }
        throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greater or equal to than 8");
    }

    public static String X00IoxXI(short s, int i, String str, int i2, int i3) {
        if (i3 == 0) {
            return str;
        }
        if (((i3 - 1) * 4) + i < 16) {
            StringBuilder sb = new StringBuilder(str);
            int length = sb.length();
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = (s >> ((i4 * 4) + i)) & 15;
                int i6 = i2 + i4;
                if (i6 == length) {
                    length++;
                    sb.append(XIxXXX0x0(i5));
                } else {
                    sb.setCharAt(i6, XIxXXX0x0(i5));
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greater or equal to than 16");
    }

    public static byte[] X0IIOO(int i, int i2, byte[] bArr, int i3, int i4) {
        if (i4 == 0) {
            return bArr;
        }
        if (((i4 - 1) * 8) + i2 < 32) {
            for (int i5 = 0; i5 < i4; i5++) {
                bArr[i3 + i5] = (byte) ((i >> ((i5 * 8) + i2)) & 255);
            }
            return bArr;
        }
        throw new IllegalArgumentException("(nBytes-1)*8+srcPos is greater or equal to than 32");
    }

    public static char X0o0xo(boolean[] zArr, int i) {
        if (zArr.length != 0) {
            int i2 = i + 3;
            if (zArr.length > i2 && zArr[i2]) {
                if (zArr[i + 2]) {
                    if (zArr[i + 1]) {
                        if (zArr[i]) {
                            return 'f';
                        }
                        return 'e';
                    }
                    if (zArr[i]) {
                        return 'd';
                    }
                    return 'c';
                }
                if (zArr[i + 1]) {
                    if (zArr[i]) {
                        return 'b';
                    }
                    return 'a';
                }
                if (zArr[i]) {
                    return '9';
                }
                return '8';
            }
            int i3 = i + 2;
            if (zArr.length > i3 && zArr[i3]) {
                if (zArr[i + 1]) {
                    if (zArr[i]) {
                        return '7';
                    }
                    return '6';
                }
                if (zArr[i]) {
                    return '5';
                }
                return '4';
            }
            int i4 = i + 1;
            if (zArr.length > i4 && zArr[i4]) {
                if (zArr[i]) {
                    return '3';
                }
                return '2';
            }
            if (zArr[i]) {
                return '1';
            }
            return '0';
        }
        throw new IllegalArgumentException("Cannot convert an empty array.");
    }

    public static String XI0IXoo(int i, int i2, String str, int i3, int i4) {
        if (i4 == 0) {
            return str;
        }
        if (((i4 - 1) * 4) + i2 < 32) {
            StringBuilder sb = new StringBuilder(str);
            int length = sb.length();
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = (i >> ((i5 * 4) + i2)) & 15;
                int i7 = i3 + i5;
                if (i7 == length) {
                    length++;
                    sb.append(XIxXXX0x0(i6));
                } else {
                    sb.setCharAt(i7, XIxXXX0x0(i6));
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greater or equal to than 32");
    }

    public static char XIxXXX0x0(int i) {
        char forDigit = Character.forDigit(i, 16);
        if (forDigit != 0) {
            return forDigit;
        }
        throw new IllegalArgumentException("nibble value not between 0 and 15: " + i);
    }

    public static char XO(boolean[] zArr) {
        return Oxx0IOOO(zArr, 0);
    }

    public static byte[] Xx000oIo(short s, int i, byte[] bArr, int i2, int i3) {
        if (i3 == 0) {
            return bArr;
        }
        if (((i3 - 1) * 8) + i < 16) {
            for (int i4 = 0; i4 < i3; i4++) {
                bArr[i2 + i4] = (byte) ((s >> ((i4 * 8) + i)) & 255);
            }
            return bArr;
        }
        throw new IllegalArgumentException("(nBytes-1)*8+srcPos is greater or equal to than 16");
    }

    public static short[] XxX0x0xxx(int i, int i2, short[] sArr, int i3, int i4) {
        if (i4 == 0) {
            return sArr;
        }
        if (((i4 - 1) * 16) + i2 < 32) {
            for (int i5 = 0; i5 < i4; i5++) {
                sArr[i3 + i5] = (short) ((i >> ((i5 * 16) + i2)) & 65535);
            }
            return sArr;
        }
        throw new IllegalArgumentException("(nShorts-1)*16+srcPos is greater or equal to than 32");
    }

    public static short o00(String str, int i, short s, int i2, int i3) {
        if (i3 == 0) {
            return s;
        }
        if (((i3 - 1) * 4) + i2 < 16) {
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = (i4 * 4) + i2;
                s = (short) ((s & (~(15 << i5))) | ((oI0IIXIo(str.charAt(i4 + i)) & 15) << i5));
            }
            return s;
        }
        throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greater or equal to than 16");
    }

    public static int oI0IIXIo(char c) {
        int digit = Character.digit(c, 16);
        if (digit >= 0) {
            return digit;
        }
        throw new IllegalArgumentException("Cannot interpret '" + c + "' as a hexadecimal digit");
    }

    public static char oIX0oI(boolean[] zArr) {
        return II0xO0(zArr, 0);
    }

    public static boolean[] oO(byte b, int i, boolean[] zArr, int i2, int i3) {
        if (i3 == 0) {
            return zArr;
        }
        if ((i3 - 1) + i < 8) {
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = i2 + i4;
                boolean z = true;
                if (((b >> (i4 + i)) & 1) == 0) {
                    z = false;
                }
                zArr[i5] = z;
            }
            return zArr;
        }
        throw new IllegalArgumentException("nBools-1+srcPos is greater or equal to than 8");
    }

    public static boolean[] oOXoIIIo(short s, int i, boolean[] zArr, int i2, int i3) {
        if (i3 == 0) {
            return zArr;
        }
        if ((i3 - 1) + i < 16) {
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = i2 + i4;
                boolean z = true;
                if (((s >> (i4 + i)) & 1) == 0) {
                    z = false;
                }
                zArr[i5] = z;
            }
            return zArr;
        }
        throw new IllegalArgumentException("nBools-1+srcPos is greater or equal to than 16");
    }

    public static long oOoXoXO(byte[] bArr, int i, long j, int i2, int i3) {
        if ((bArr.length == 0 && i == 0) || i3 == 0) {
            return j;
        }
        if (((i3 - 1) * 8) + i2 < 64) {
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = (i4 * 8) + i2;
                j = (j & (~(255 << i5))) | ((bArr[i4 + i] & 255) << i5);
            }
            return j;
        }
        throw new IllegalArgumentException("(nBytes-1)*8+dstPos is greater or equal to than 64");
    }

    public static int oo(short[] sArr, int i, int i2, int i3, int i4) {
        if ((sArr.length == 0 && i == 0) || i4 == 0) {
            return i2;
        }
        if (((i4 - 1) * 16) + i3 < 32) {
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = (i5 * 16) + i3;
                i2 = (i2 & (~(65535 << i6))) | ((sArr[i5 + i] & OX00O0xII.f29066Oxx0xo) << i6);
            }
            return i2;
        }
        throw new IllegalArgumentException("(nShorts-1)*16+dstPos is greater or equal to than 32");
    }

    public static short[] oo0xXOI0I(long j, int i, short[] sArr, int i2, int i3) {
        if (i3 == 0) {
            return sArr;
        }
        if (((i3 - 1) * 16) + i < 64) {
            for (int i4 = 0; i4 < i3; i4++) {
                sArr[i2 + i4] = (short) (65535 & (j >> ((i4 * 16) + i)));
            }
            return sArr;
        }
        throw new IllegalArgumentException("(nShorts-1)*16+srcPos is greater or equal to than 64");
    }

    public static short ooOOo0oXI(byte[] bArr, int i, short s, int i2, int i3) {
        if ((bArr.length == 0 && i == 0) || i3 == 0) {
            return s;
        }
        if (((i3 - 1) * 8) + i2 < 16) {
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = (i4 * 8) + i2;
                s = (short) ((s & (~(255 << i5))) | ((bArr[i4 + i] & 255) << i5));
            }
            return s;
        }
        throw new IllegalArgumentException("(nBytes-1)*8+dstPos is greater or equal to than 16");
    }

    public static String ooXIXxIX(long j, int i, String str, int i2, int i3) {
        if (i3 == 0) {
            return str;
        }
        if (((i3 - 1) * 4) + i < 64) {
            StringBuilder sb = new StringBuilder(str);
            int length = sb.length();
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = (int) ((j >> ((i4 * 4) + i)) & 15);
                int i6 = i2 + i4;
                if (i6 == length) {
                    length++;
                    sb.append(XIxXXX0x0(i5));
                } else {
                    sb.setCharAt(i6, XIxXXX0x0(i5));
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greater or equal to than 64");
    }

    public static char oxoX(boolean[] zArr) {
        return X0o0xo(zArr, 0);
    }

    public static UUID x0XOIxOo(byte[] bArr, int i) {
        if (bArr.length - i >= 16) {
            return new UUID(oOoXoXO(bArr, i, 0L, 0, 8), oOoXoXO(bArr, i + 8, 0L, 0, 8));
        }
        throw new IllegalArgumentException("Need at least 16 bytes for UUID");
    }

    public static String x0xO0oo(byte b, int i, String str, int i2, int i3) {
        if (i3 == 0) {
            return str;
        }
        if (((i3 - 1) * 4) + i < 8) {
            StringBuilder sb = new StringBuilder(str);
            int length = sb.length();
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = (b >> ((i4 * 4) + i)) & 15;
                int i6 = i2 + i4;
                if (i6 == length) {
                    length++;
                    sb.append(XIxXXX0x0(i5));
                } else {
                    sb.setCharAt(i6, XIxXXX0x0(i5));
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greater or equal to than 8");
    }

    public static int[] xI(long j, int i, int[] iArr, int i2, int i3) {
        if (i3 == 0) {
            return iArr;
        }
        if (((i3 - 1) * 32) + i < 64) {
            for (int i4 = 0; i4 < i3; i4++) {
                iArr[i2 + i4] = (int) (j >> ((i4 * 32) + i));
            }
            return iArr;
        }
        throw new IllegalArgumentException("(nInts-1)*32+srcPos is greater or equal to than 64");
    }

    public static boolean[] xXxxox0I(long j, int i, boolean[] zArr, int i2, int i3) {
        boolean z;
        if (i3 == 0) {
            return zArr;
        }
        if ((i3 - 1) + i < 64) {
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = i2 + i4;
                if ((1 & (j >> (i4 + i))) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                zArr[i5] = z;
            }
            return zArr;
        }
        throw new IllegalArgumentException("nBools-1+srcPos is greater or equal to than 64");
    }

    public static short xoIox(boolean[] zArr, int i, short s, int i2, int i3) {
        if ((zArr.length == 0 && i == 0) || i3 == 0) {
            return s;
        }
        if ((i3 - 1) + i2 < 16) {
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = i4 + i2;
                s = (short) ((s & (~(1 << i5))) | ((zArr[i4 + i] ? 1 : 0) << i5));
            }
            return s;
        }
        throw new IllegalArgumentException("nBools-1+dstPos is greater or equal to than 16");
    }

    public static long xoXoI(String str, int i, long j, int i2, int i3) {
        if (i3 == 0) {
            return j;
        }
        if (((i3 - 1) * 4) + i2 < 64) {
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = (i4 * 4) + i2;
                j = (j & (~(15 << i5))) | ((oI0IIXIo(str.charAt(i4 + i)) & 15) << i5);
            }
            return j;
        }
        throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greater or equal to than 64");
    }

    public static long xxIXOIIO(boolean[] zArr, int i, long j, int i2, int i3) {
        long j2;
        if ((zArr.length == 0 && i == 0) || i3 == 0) {
            return j;
        }
        if ((i3 - 1) + i2 < 64) {
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = i4 + i2;
                if (zArr[i4 + i]) {
                    j2 = 1;
                } else {
                    j2 = 0;
                }
                j = (j & (~(1 << i5))) | (j2 << i5);
            }
            return j;
        }
        throw new IllegalArgumentException("nBools-1+dstPos is greater or equal to than 64");
    }

    public static char xxX(int i) {
        switch (i) {
            case 0:
                return '0';
            case 1:
                return '8';
            case 2:
                return '4';
            case 3:
                return 'c';
            case 4:
                return '2';
            case 5:
                return 'a';
            case 6:
                return '6';
            case 7:
                return 'e';
            case 8:
                return '1';
            case 9:
                return '9';
            case 10:
                return '5';
            case 11:
                return 'd';
            case 12:
                return '3';
            case 13:
                return 'b';
            case 14:
                return '7';
            case 15:
                return 'f';
            default:
                throw new IllegalArgumentException("nibble value not between 0 and 15: " + i);
        }
    }
}
