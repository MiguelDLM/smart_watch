package com.goodix.ble.libcomx.util;

/* loaded from: classes9.dex */
public class HexStringParser {
    /* JADX WARN: Removed duplicated region for block: B:50:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0096 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int parse(java.lang.CharSequence r12, byte[] r13, int r14, int r15) {
        /*
            r0 = 0
            if (r12 == 0) goto La5
            if (r13 == 0) goto La5
            if (r14 < 0) goto La5
            r1 = 1
            if (r15 >= r1) goto Lc
            goto La5
        Lc:
            int r2 = r12.length()
            int r15 = r15 + r14
            int r3 = r13.length
            if (r15 <= r3) goto L15
            int r15 = r13.length
        L15:
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
        L19:
            if (r3 >= r2) goto L98
            if (r14 < r15) goto L1f
            goto L98
        L1f:
            char r7 = r12.charAt(r3)
            r8 = 40
            if (r7 != r8) goto L44
            int r9 = r3 + 1
            if (r9 >= r2) goto L44
            r3 = r9
            r7 = 1
        L2d:
            if (r3 >= r2) goto L96
            char r9 = r12.charAt(r3)
            if (r9 != r8) goto L38
            int r7 = r7 + 1
            goto L41
        L38:
            r10 = 41
            if (r9 != r10) goto L41
            int r7 = r7 + (-1)
            if (r7 > 0) goto L41
            goto L96
        L41:
            int r3 = r3 + 1
            goto L2d
        L44:
            r8 = 48
            if (r7 != r8) goto L5a
            int r9 = r3 + 1
            if (r9 >= r2) goto L5a
            char r10 = r12.charAt(r9)
            r11 = 120(0x78, float:1.68E-43)
            if (r10 == r11) goto L58
            r11 = 88
            if (r10 != r11) goto L5a
        L58:
            r3 = r9
            goto L96
        L5a:
            if (r7 < r8) goto L68
            r8 = 57
            if (r7 > r8) goto L68
            int r5 = r5 << 4
            int r4 = r4 + 4
            int r7 = r7 + (-48)
        L66:
            r5 = r5 | r7
            goto L86
        L68:
            r8 = 65
            if (r7 < r8) goto L77
            r8 = 70
            if (r7 > r8) goto L77
            int r5 = r5 << 4
            int r4 = r4 + 4
            int r7 = r7 + (-55)
            goto L66
        L77:
            r8 = 97
            if (r7 < r8) goto L86
            r8 = 102(0x66, float:1.43E-43)
            if (r7 > r8) goto L86
            int r5 = r5 << 4
            int r4 = r4 + 4
            int r7 = r7 + (-87)
            goto L66
        L86:
            r7 = 8
            if (r4 < r7) goto L96
            int r4 = r14 + 1
            r5 = r5 & 255(0xff, float:3.57E-43)
            byte r5 = (byte) r5
            r13[r14] = r5
            int r6 = r6 + 1
            r14 = r4
            r4 = 0
            r5 = 0
        L96:
            int r3 = r3 + r1
            goto L19
        L98:
            r12 = 4
            if (r4 != r12) goto La4
            if (r14 >= r15) goto La4
            r12 = r5 & 15
            byte r12 = (byte) r12
            r13[r14] = r12
            int r6 = r6 + 1
        La4:
            return r6
        La5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.goodix.ble.libcomx.util.HexStringParser.parse(java.lang.CharSequence, byte[], int, int):int");
    }

    public static int parseInt(CharSequence charSequence, int i, int i2) {
        int i3;
        int i4;
        int i5;
        char charAt;
        int i6;
        int i7 = 0;
        if (charSequence != null && i >= 0 && i2 >= 1) {
            int length = charSequence.length();
            int i8 = i2 + i;
            if (i > length) {
                i = length;
            }
            if (i8 <= length) {
                length = i8;
            }
            while (i < length) {
                char charAt2 = charSequence.charAt(i);
                if (charAt2 == '(' && (i6 = i + 1) < length) {
                    i = i6;
                    int i9 = 1;
                    while (i < length) {
                        char charAt3 = charSequence.charAt(i);
                        if (charAt3 != '(') {
                            if (charAt3 == ')' && i9 - 1 <= 0) {
                                break;
                            }
                        } else {
                            i9++;
                        }
                        i++;
                    }
                } else if (charAt2 == '0' && (i5 = i + 1) < length && ((charAt = charSequence.charAt(i5)) == 'x' || charAt == 'X')) {
                    i = i5;
                } else {
                    if (charAt2 >= '0' && charAt2 <= '9') {
                        i3 = i7 << 4;
                        i4 = charAt2 - '0';
                    } else if (charAt2 >= 'A' && charAt2 <= 'F') {
                        i3 = i7 << 4;
                        i4 = charAt2 - '7';
                    } else if (charAt2 >= 'a' && charAt2 <= 'f') {
                        i3 = i7 << 4;
                        i4 = charAt2 - 'W';
                    }
                    i7 = i4 | i3;
                }
                i++;
            }
        }
        return i7;
    }

    public static int parseInt(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return 0;
        }
        return parseInt(charSequence, 0, charSequence.length());
    }
}
