package com.alibaba.fastjson.util;

import java.lang.reflect.Array;
import java.math.BigInteger;

public final class RyuDouble {
    private static final int[][] POW5_INV_SPLIT;
    private static final int[][] POW5_SPLIT;

    static {
        int i;
        int[] iArr = new int[2];
        iArr[1] = 4;
        iArr[0] = 326;
        Class cls = Integer.TYPE;
        POW5_SPLIT = (int[][]) Array.newInstance(cls, iArr);
        int[] iArr2 = new int[2];
        iArr2[1] = 4;
        iArr2[0] = 291;
        POW5_INV_SPLIT = (int[][]) Array.newInstance(cls, iArr2);
        BigInteger bigInteger = BigInteger.ONE;
        BigInteger subtract = bigInteger.shiftLeft(31).subtract(bigInteger);
        BigInteger subtract2 = bigInteger.shiftLeft(31).subtract(bigInteger);
        int i2 = 0;
        while (i2 < 326) {
            BigInteger pow = BigInteger.valueOf(5).pow(i2);
            int bitLength = pow.bitLength();
            if (i2 == 0) {
                i = 1;
            } else {
                i = (int) (((((long) i2) * 23219280) + 9999999) / 10000000);
            }
            if (i == bitLength) {
                if (i2 < POW5_SPLIT.length) {
                    for (int i3 = 0; i3 < 4; i3++) {
                        POW5_SPLIT[i2][i3] = pow.shiftRight((bitLength - 121) + ((3 - i3) * 31)).and(subtract).intValue();
                    }
                }
                if (i2 < POW5_INV_SPLIT.length) {
                    BigInteger bigInteger2 = BigInteger.ONE;
                    BigInteger add = bigInteger2.shiftLeft(bitLength + 121).divide(pow).add(bigInteger2);
                    for (int i4 = 0; i4 < 4; i4++) {
                        if (i4 == 0) {
                            POW5_INV_SPLIT[i2][i4] = add.shiftRight((3 - i4) * 31).intValue();
                        } else {
                            POW5_INV_SPLIT[i2][i4] = add.shiftRight((3 - i4) * 31).and(subtract2).intValue();
                        }
                    }
                }
                i2++;
            } else {
                throw new IllegalStateException(bitLength + " != " + i);
            }
        }
    }

    public static String toString(double d) {
        char[] cArr = new char[24];
        return new String(cArr, 0, toString(d, cArr, 0));
    }

    /* JADX WARNING: Removed duplicated region for block: B:237:0x0580  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x0582  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int toString(double r43, char[] r45, int r46) {
        /*
            boolean r0 = java.lang.Double.isNaN(r43)
            if (r0 == 0) goto L_0x001b
            int r0 = r46 + 1
            r1 = 78
            r45[r46] = r1
            int r1 = r46 + 2
            r2 = 97
            r45[r0] = r2
            int r0 = r46 + 3
            r2 = 78
            r45[r1] = r2
        L_0x0018:
            int r0 = r0 - r46
            return r0
        L_0x001b:
            r0 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            r2 = 121(0x79, float:1.7E-43)
            r3 = 105(0x69, float:1.47E-43)
            r4 = 110(0x6e, float:1.54E-43)
            int r5 = (r43 > r0 ? 1 : (r43 == r0 ? 0 : -1))
            if (r5 != 0) goto L_0x0050
            int r0 = r46 + 1
            r1 = 73
            r45[r46] = r1
            int r1 = r46 + 2
            r45[r0] = r4
            int r0 = r46 + 3
            r5 = 102(0x66, float:1.43E-43)
            r45[r1] = r5
            int r1 = r46 + 4
            r45[r0] = r3
            int r0 = r46 + 5
            r45[r1] = r4
            int r1 = r46 + 6
            r45[r0] = r3
            int r0 = r46 + 7
            r3 = 116(0x74, float:1.63E-43)
            r45[r1] = r3
            int r1 = r46 + 8
            r45[r0] = r2
        L_0x004d:
            int r1 = r1 - r46
            return r1
        L_0x0050:
            r0 = -4503599627370496(0xfff0000000000000, double:-Infinity)
            int r5 = (r43 > r0 ? 1 : (r43 == r0 ? 0 : -1))
            if (r5 != 0) goto L_0x0083
            int r0 = r46 + 1
            r1 = 45
            r45[r46] = r1
            int r1 = r46 + 2
            r5 = 73
            r45[r0] = r5
            int r0 = r46 + 3
            r45[r1] = r4
            int r1 = r46 + 4
            r5 = 102(0x66, float:1.43E-43)
            r45[r0] = r5
            int r0 = r46 + 5
            r45[r1] = r3
            int r1 = r46 + 6
            r45[r0] = r4
            int r0 = r46 + 7
            r45[r1] = r3
            int r1 = r46 + 8
            r3 = 116(0x74, float:1.63E-43)
            r45[r0] = r3
            int r0 = r46 + 9
            r45[r1] = r2
            goto L_0x0018
        L_0x0083:
            long r0 = java.lang.Double.doubleToLongBits(r43)
            r3 = 46
            r4 = 48
            r5 = 0
            int r7 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x009f
            int r0 = r46 + 1
            r45[r46] = r4
            int r1 = r46 + 2
            r45[r0] = r3
            int r0 = r46 + 3
            r45[r1] = r4
            goto L_0x0018
        L_0x009f:
            r8 = -9223372036854775808
            int r10 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r10 != 0) goto L_0x00b8
            int r0 = r46 + 1
            r1 = 45
            r45[r46] = r1
            int r1 = r46 + 2
            r45[r0] = r4
            int r0 = r46 + 3
            r45[r1] = r3
            int r1 = r46 + 4
            r45[r0] = r4
            goto L_0x004d
        L_0x00b8:
            r8 = 52
            long r8 = r0 >>> r8
            r10 = 2047(0x7ff, double:1.0114E-320)
            long r8 = r8 & r10
            int r9 = (int) r8
            r10 = 4503599627370495(0xfffffffffffff, double:2.225073858507201E-308)
            long r0 = r0 & r10
            if (r9 != 0) goto L_0x00cb
            r8 = -1074(0xfffffffffffffbce, float:NaN)
            goto L_0x00d0
        L_0x00cb:
            int r8 = r9 + -1075
            r10 = 4503599627370496(0x10000000000000, double:2.2250738585072014E-308)
            long r0 = r0 | r10
        L_0x00d0:
            r10 = 0
            r11 = 1
            if (r7 >= 0) goto L_0x00d6
            r7 = 1
            goto L_0x00d7
        L_0x00d6:
            r7 = 0
        L_0x00d7:
            r12 = 1
            long r14 = r0 & r12
            int r16 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r16 != 0) goto L_0x00e1
            r14 = 1
            goto L_0x00e2
        L_0x00e1:
            r14 = 0
        L_0x00e2:
            r15 = 4
            long r15 = r15 * r0
            r17 = 2
            long r17 = r15 + r17
            r19 = 4503599627370496(0x10000000000000, double:2.2250738585072014E-308)
            int r21 = (r0 > r19 ? 1 : (r0 == r19 ? 0 : -1))
            if (r21 != 0) goto L_0x00f5
            if (r9 > r11) goto L_0x00f3
            goto L_0x00f5
        L_0x00f3:
            r0 = 0
            goto L_0x00f6
        L_0x00f5:
            r0 = 1
        L_0x00f6:
            long r19 = r15 - r12
            long r3 = (long) r0
            long r19 = r19 - r3
            int r8 = r8 + -2
            r3 = 10000000(0x989680, double:4.9406565E-317)
            r21 = 2147483647(0x7fffffff, double:1.060997895E-314)
            r23 = 3
            r24 = 2
            r25 = 31
            if (r8 < 0) goto L_0x0301
            long r12 = (long) r8
            r26 = 3010299(0x2deefb, double:1.4872853E-317)
            long r12 = r12 * r26
            long r12 = r12 / r3
            int r0 = (int) r12
            int r0 = r0 - r11
            int r0 = java.lang.Math.max(r10, r0)
            if (r0 != 0) goto L_0x011c
            r13 = 1
            goto L_0x0129
        L_0x011c:
            long r12 = (long) r0
            r26 = 23219280(0x1624c50, double:1.14718486E-316)
            long r12 = r12 * r26
            r26 = 9999999(0x98967f, double:4.940656E-317)
            long r12 = r12 + r26
            long r12 = r12 / r3
            int r13 = (int) r12
        L_0x0129:
            int r13 = r13 + r2
            int r2 = -r8
            int r2 = r2 + r0
            int r2 = r2 + r13
            int r2 = r2 + -114
            if (r2 < 0) goto L_0x02e6
            int[][] r8 = POW5_INV_SPLIT
            r8 = r8[r0]
            long r12 = r15 >>> r25
            long r26 = r15 & r21
            r3 = r8[r10]
            long r5 = (long) r3
            long r5 = r5 * r12
            long r9 = (long) r3
            long r9 = r9 * r26
            r4 = r8[r11]
            r29 = r2
            long r1 = (long) r4
            long r1 = r1 * r12
            r30 = r12
            long r11 = (long) r4
            long r11 = r11 * r26
            r13 = r8[r24]
            r32 = r14
            r33 = r15
            long r14 = (long) r13
            long r14 = r14 * r30
            r16 = r3
            r35 = r4
            long r3 = (long) r13
            long r3 = r3 * r26
            r8 = r8[r23]
            r36 = r5
            long r5 = (long) r8
            long r5 = r5 * r30
            r30 = r0
            r38 = r1
            long r0 = (long) r8
            long r26 = r26 * r0
            long r0 = r26 >>> r25
            long r0 = r0 + r3
            long r0 = r0 + r5
            long r0 = r0 >>> r25
            long r0 = r0 + r11
            long r0 = r0 + r14
            long r0 = r0 >>> r25
            long r0 = r0 + r9
            long r0 = r0 + r38
            r2 = 21
            long r0 = r0 >>> r2
            r2 = 10
            long r3 = r36 << r2
            long r0 = r0 + r3
            long r0 = r0 >>> r29
            long r2 = r17 >>> r25
            long r4 = r17 & r21
            r6 = r16
            long r9 = (long) r6
            long r9 = r9 * r2
            long r11 = (long) r6
            long r11 = r11 * r4
            r15 = r0
            r14 = r35
            long r0 = (long) r14
            long r0 = r0 * r2
            r27 = r6
            r26 = r7
            long r6 = (long) r14
            long r6 = r6 * r4
            r36 = r15
            long r14 = (long) r13
            long r14 = r14 * r2
            r38 = r9
            long r9 = (long) r13
            long r9 = r9 * r4
            r40 = r0
            long r0 = (long) r8
            long r2 = r2 * r0
            long r0 = (long) r8
            long r4 = r4 * r0
            long r0 = r4 >>> r25
            long r0 = r0 + r9
            long r0 = r0 + r2
            long r0 = r0 >>> r25
            long r0 = r0 + r6
            long r0 = r0 + r14
            long r0 = r0 >>> r25
            long r0 = r0 + r11
            long r0 = r0 + r40
            r2 = 21
            long r0 = r0 >>> r2
            r2 = 10
            long r3 = r38 << r2
            long r0 = r0 + r3
            long r0 = r0 >>> r29
            long r2 = r19 >>> r25
            long r4 = r19 & r21
            r6 = r27
            long r9 = (long) r6
            long r9 = r9 * r2
            long r6 = (long) r6
            long r6 = r6 * r4
            r11 = r35
            long r14 = (long) r11
            long r14 = r14 * r2
            long r11 = (long) r11
            long r11 = r11 * r4
            r38 = r0
            long r0 = (long) r13
            long r0 = r0 * r2
            r21 = r9
            long r9 = (long) r13
            long r9 = r9 * r4
            r40 = r14
            long r13 = (long) r8
            long r2 = r2 * r13
            long r13 = (long) r8
            long r4 = r4 * r13
            long r4 = r4 >>> r25
            long r4 = r4 + r9
            long r4 = r4 + r2
            long r2 = r4 >>> r25
            long r2 = r2 + r11
            long r2 = r2 + r0
            long r0 = r2 >>> r25
            long r0 = r0 + r6
            long r0 = r0 + r40
            r2 = 21
            long r0 = r0 >>> r2
            r3 = 10
            long r4 = r21 << r3
            long r0 = r0 + r4
            long r0 = r0 >>> r29
            r3 = r30
            if (r3 > r2) goto L_0x02d8
            r4 = 5
            long r15 = r33 % r4
            r6 = 625(0x271, double:3.09E-321)
            r8 = 0
            int r2 = (r15 > r8 ? 1 : (r15 == r8 ? 0 : -1))
            if (r2 != 0) goto L_0x024f
            if (r2 == 0) goto L_0x0215
            r4 = 0
            goto L_0x0246
        L_0x0215:
            r10 = 25
            long r15 = r33 % r10
            int r2 = (r15 > r8 ? 1 : (r15 == r8 ? 0 : -1))
            if (r2 == 0) goto L_0x021f
            r4 = 1
            goto L_0x0246
        L_0x021f:
            r10 = 125(0x7d, double:6.2E-322)
            long r15 = r33 % r10
            int r2 = (r15 > r8 ? 1 : (r15 == r8 ? 0 : -1))
            if (r2 == 0) goto L_0x0229
            r4 = 2
            goto L_0x0246
        L_0x0229:
            long r15 = r33 % r6
            int r2 = (r15 > r8 ? 1 : (r15 == r8 ? 0 : -1))
            if (r2 == 0) goto L_0x0231
            r4 = 3
            goto L_0x0246
        L_0x0231:
            long r15 = r33 / r6
            r2 = 4
        L_0x0234:
            int r6 = (r15 > r8 ? 1 : (r15 == r8 ? 0 : -1))
            if (r6 <= 0) goto L_0x0245
            long r6 = r15 % r4
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x023f
            goto L_0x0245
        L_0x023f:
            long r15 = r15 / r4
            int r2 = r2 + 1
            r8 = 0
            goto L_0x0234
        L_0x0245:
            r4 = r2
        L_0x0246:
            if (r4 < r3) goto L_0x024a
            r4 = 1
            goto L_0x024b
        L_0x024a:
            r4 = 0
        L_0x024b:
            r2 = r4
        L_0x024c:
            r4 = 0
            goto L_0x02db
        L_0x024f:
            if (r32 == 0) goto L_0x0294
            long r8 = r19 % r4
            r10 = 0
            int r2 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r2 == 0) goto L_0x025b
            r4 = 0
            goto L_0x028d
        L_0x025b:
            r8 = 25
            long r8 = r19 % r8
            int r2 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r2 == 0) goto L_0x0265
            r4 = 1
            goto L_0x028d
        L_0x0265:
            r8 = 125(0x7d, double:6.2E-322)
            long r8 = r19 % r8
            int r2 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r2 == 0) goto L_0x026f
            r4 = 2
            goto L_0x028d
        L_0x026f:
            long r8 = r19 % r6
            int r2 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r2 == 0) goto L_0x0277
            r4 = 3
            goto L_0x028d
        L_0x0277:
            long r19 = r19 / r6
            r2 = 4
        L_0x027a:
            int r6 = (r19 > r10 ? 1 : (r19 == r10 ? 0 : -1))
            if (r6 <= 0) goto L_0x028c
            long r6 = r19 % r4
            int r8 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r8 == 0) goto L_0x0285
            goto L_0x028c
        L_0x0285:
            long r19 = r19 / r4
            int r2 = r2 + 1
            r10 = 0
            goto L_0x027a
        L_0x028c:
            r4 = r2
        L_0x028d:
            if (r4 < r3) goto L_0x0291
            r4 = 1
            goto L_0x0292
        L_0x0291:
            r4 = 0
        L_0x0292:
            r2 = 0
            goto L_0x02db
        L_0x0294:
            long r8 = r17 % r4
            r10 = 0
            int r2 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r2 == 0) goto L_0x029e
            r4 = 0
            goto L_0x02d0
        L_0x029e:
            r8 = 25
            long r8 = r17 % r8
            int r2 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r2 == 0) goto L_0x02a8
            r4 = 1
            goto L_0x02d0
        L_0x02a8:
            r8 = 125(0x7d, double:6.2E-322)
            long r8 = r17 % r8
            int r2 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r2 == 0) goto L_0x02b2
            r4 = 2
            goto L_0x02d0
        L_0x02b2:
            long r8 = r17 % r6
            int r2 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r2 == 0) goto L_0x02ba
            r4 = 3
            goto L_0x02d0
        L_0x02ba:
            long r17 = r17 / r6
            r2 = 4
        L_0x02bd:
            int r6 = (r17 > r10 ? 1 : (r17 == r10 ? 0 : -1))
            if (r6 <= 0) goto L_0x02cf
            long r6 = r17 % r4
            int r8 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r8 == 0) goto L_0x02c8
            goto L_0x02cf
        L_0x02c8:
            long r17 = r17 / r4
            int r2 = r2 + 1
            r10 = 0
            goto L_0x02bd
        L_0x02cf:
            r4 = r2
        L_0x02d0:
            if (r4 < r3) goto L_0x02d8
            r4 = 1
            long r4 = r38 - r4
            r38 = r4
        L_0x02d8:
            r2 = 0
            goto L_0x024c
        L_0x02db:
            r17 = r36
            r28 = 0
            r42 = r3
            r3 = r2
            r2 = r42
            goto L_0x042f
        L_0x02e6:
            r29 = r2
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = ""
            r1.append(r2)
            r2 = r29
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0301:
            r26 = r7
            r32 = r14
            r33 = r15
            int r1 = -r8
            long r3 = (long) r1
            r5 = 6989700(0x6aa784, double:3.4533706E-317)
            long r3 = r3 * r5
            r5 = 10000000(0x989680, double:4.9406565E-317)
            long r3 = r3 / r5
            int r4 = (int) r3
            r3 = 1
            int r4 = r4 - r3
            r3 = 0
            int r5 = java.lang.Math.max(r3, r4)
            int r1 = r1 - r5
            if (r1 != 0) goto L_0x031f
            r3 = 1
            goto L_0x032e
        L_0x031f:
            long r6 = (long) r1
            r9 = 23219280(0x1624c50, double:1.14718486E-316)
            long r6 = r6 * r9
            r9 = 9999999(0x98967f, double:4.940656E-317)
            long r6 = r6 + r9
            r9 = 10000000(0x989680, double:4.9406565E-317)
            long r6 = r6 / r9
            int r3 = (int) r6
        L_0x032e:
            int r3 = r3 - r2
            int r2 = r5 - r3
            int r2 = r2 + -114
            if (r2 < 0) goto L_0x06cb
            int[][] r3 = POW5_SPLIT
            r1 = r3[r1]
            long r6 = r33 >>> r25
            long r9 = r33 & r21
            r28 = 0
            r3 = r1[r28]
            long r11 = (long) r3
            long r11 = r11 * r6
            long r13 = (long) r3
            long r13 = r13 * r9
            r4 = 1
            r15 = r1[r4]
            r16 = r5
            long r4 = (long) r15
            long r4 = r4 * r6
            r27 = r2
            r29 = r3
            long r2 = (long) r15
            long r2 = r2 * r9
            r30 = r0
            r0 = r1[r24]
            r35 = r11
            long r11 = (long) r0
            long r11 = r11 * r6
            r37 = r4
            long r4 = (long) r0
            long r4 = r4 * r9
            r1 = r1[r23]
            r39 = r13
            long r13 = (long) r1
            long r6 = r6 * r13
            long r13 = (long) r1
            long r9 = r9 * r13
            long r9 = r9 >>> r25
            long r9 = r9 + r4
            long r9 = r9 + r6
            long r4 = r9 >>> r25
            long r4 = r4 + r2
            long r4 = r4 + r11
            long r2 = r4 >>> r25
            long r2 = r2 + r39
            long r2 = r2 + r37
            r4 = 21
            long r2 = r2 >>> r4
            r4 = 10
            long r5 = r35 << r4
            long r2 = r2 + r5
            long r2 = r2 >>> r27
            long r4 = r17 >>> r25
            long r6 = r17 & r21
            r9 = r29
            long r10 = (long) r9
            long r10 = r10 * r4
            long r12 = (long) r9
            long r12 = r12 * r6
            r17 = r2
            long r2 = (long) r15
            long r2 = r2 * r4
            r14 = r8
            long r8 = (long) r15
            long r8 = r8 * r6
            r35 = r14
            r31 = r15
            long r14 = (long) r0
            long r14 = r14 * r4
            r36 = r10
            long r10 = (long) r0
            long r10 = r10 * r6
            r38 = r2
            long r2 = (long) r1
            long r4 = r4 * r2
            long r2 = (long) r1
            long r6 = r6 * r2
            long r2 = r6 >>> r25
            long r2 = r2 + r10
            long r2 = r2 + r4
            long r2 = r2 >>> r25
            long r2 = r2 + r8
            long r2 = r2 + r14
            long r2 = r2 >>> r25
            long r2 = r2 + r12
            long r2 = r2 + r38
            r4 = 21
            long r2 = r2 >>> r4
            r4 = 10
            long r5 = r36 << r4
            long r2 = r2 + r5
            long r38 = r2 >>> r27
            long r2 = r19 >>> r25
            long r4 = r19 & r21
            r6 = r29
            long r7 = (long) r6
            long r7 = r7 * r2
            long r9 = (long) r6
            long r9 = r9 * r4
            r6 = r31
            long r11 = (long) r6
            long r11 = r11 * r2
            long r13 = (long) r6
            long r13 = r13 * r4
            r19 = r7
            long r6 = (long) r0
            long r6 = r6 * r2
            r21 = r11
            long r11 = (long) r0
            long r11 = r11 * r4
            r36 = r9
            long r8 = (long) r1
            long r2 = r2 * r8
            long r0 = (long) r1
            long r4 = r4 * r0
            long r0 = r4 >>> r25
            long r0 = r0 + r11
            long r0 = r0 + r2
            long r0 = r0 >>> r25
            long r0 = r0 + r13
            long r0 = r0 + r6
            long r0 = r0 >>> r25
            long r0 = r0 + r36
            long r0 = r0 + r21
            r2 = 21
            long r0 = r0 >>> r2
            r2 = 10
            long r3 = r19 << r2
            long r0 = r0 + r3
            long r0 = r0 >>> r27
            int r2 = r16 + r35
            r4 = r16
            r3 = 1
            if (r4 > r3) goto L_0x0419
            if (r32 == 0) goto L_0x0413
            r10 = r30
            if (r10 != r3) goto L_0x0417
            r4 = 1
            goto L_0x042f
        L_0x0413:
            r5 = 1
            long r38 = r38 - r5
        L_0x0417:
            r4 = 0
            goto L_0x042f
        L_0x0419:
            r5 = 1
            r7 = 63
            if (r4 >= r7) goto L_0x042d
            int r4 = r4 - r3
            long r3 = r5 << r4
            long r3 = r3 - r5
            long r3 = r33 & r3
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x042d
            r3 = 1
            goto L_0x0417
        L_0x042d:
            r3 = 0
            goto L_0x0417
        L_0x042f:
            r5 = 1000000000000000000(0xde0b6b3a7640000, double:7.832953389245686E-242)
            r7 = 7
            r8 = 5
            r9 = 10
            int r11 = (r38 > r5 ? 1 : (r38 == r5 ? 0 : -1))
            if (r11 < 0) goto L_0x0440
            r23 = 19
            goto L_0x04fb
        L_0x0440:
            r5 = 100000000000000000(0x16345785d8a0000, double:5.620395787888205E-302)
            int r11 = (r38 > r5 ? 1 : (r38 == r5 ? 0 : -1))
            if (r11 < 0) goto L_0x044d
            r23 = 18
            goto L_0x04fb
        L_0x044d:
            r5 = 10000000000000000(0x2386f26fc10000, double:5.431165199810528E-308)
            int r11 = (r38 > r5 ? 1 : (r38 == r5 ? 0 : -1))
            if (r11 < 0) goto L_0x045a
            r23 = 17
            goto L_0x04fb
        L_0x045a:
            r5 = 1000000000000000(0x38d7ea4c68000, double:4.940656458412465E-309)
            int r11 = (r38 > r5 ? 1 : (r38 == r5 ? 0 : -1))
            if (r11 < 0) goto L_0x0467
            r23 = 16
            goto L_0x04fb
        L_0x0467:
            r5 = 100000000000000(0x5af3107a4000, double:4.94065645841247E-310)
            int r11 = (r38 > r5 ? 1 : (r38 == r5 ? 0 : -1))
            if (r11 < 0) goto L_0x0474
            r23 = 15
            goto L_0x04fb
        L_0x0474:
            r5 = 10000000000000(0x9184e72a000, double:4.9406564584125E-311)
            int r11 = (r38 > r5 ? 1 : (r38 == r5 ? 0 : -1))
            if (r11 < 0) goto L_0x0481
            r23 = 14
            goto L_0x04fb
        L_0x0481:
            r5 = 1000000000000(0xe8d4a51000, double:4.94065645841E-312)
            int r11 = (r38 > r5 ? 1 : (r38 == r5 ? 0 : -1))
            if (r11 < 0) goto L_0x048e
            r23 = 13
            goto L_0x04fb
        L_0x048e:
            r5 = 100000000000(0x174876e800, double:4.9406564584E-313)
            int r11 = (r38 > r5 ? 1 : (r38 == r5 ? 0 : -1))
            if (r11 < 0) goto L_0x049b
            r23 = 12
            goto L_0x04fb
        L_0x049b:
            r5 = 10000000000(0x2540be400, double:4.9406564584E-314)
            int r11 = (r38 > r5 ? 1 : (r38 == r5 ? 0 : -1))
            if (r11 < 0) goto L_0x04a7
            r23 = 11
            goto L_0x04fb
        L_0x04a7:
            r5 = 1000000000(0x3b9aca00, double:4.94065646E-315)
            int r11 = (r38 > r5 ? 1 : (r38 == r5 ? 0 : -1))
            if (r11 < 0) goto L_0x04b1
            r23 = 10
            goto L_0x04fb
        L_0x04b1:
            r5 = 100000000(0x5f5e100, double:4.94065646E-316)
            int r11 = (r38 > r5 ? 1 : (r38 == r5 ? 0 : -1))
            if (r11 < 0) goto L_0x04bb
            r23 = 9
            goto L_0x04fb
        L_0x04bb:
            r5 = 10000000(0x989680, double:4.9406565E-317)
            int r11 = (r38 > r5 ? 1 : (r38 == r5 ? 0 : -1))
            if (r11 < 0) goto L_0x04c5
            r23 = 8
            goto L_0x04fb
        L_0x04c5:
            r5 = 1000000(0xf4240, double:4.940656E-318)
            int r11 = (r38 > r5 ? 1 : (r38 == r5 ? 0 : -1))
            if (r11 < 0) goto L_0x04cf
            r23 = 7
            goto L_0x04fb
        L_0x04cf:
            r5 = 100000(0x186a0, double:4.94066E-319)
            int r11 = (r38 > r5 ? 1 : (r38 == r5 ? 0 : -1))
            if (r11 < 0) goto L_0x04d9
            r23 = 6
            goto L_0x04fb
        L_0x04d9:
            r5 = 10000(0x2710, double:4.9407E-320)
            int r11 = (r38 > r5 ? 1 : (r38 == r5 ? 0 : -1))
            if (r11 < 0) goto L_0x04e2
            r23 = 5
            goto L_0x04fb
        L_0x04e2:
            r5 = 1000(0x3e8, double:4.94E-321)
            int r11 = (r38 > r5 ? 1 : (r38 == r5 ? 0 : -1))
            if (r11 < 0) goto L_0x04eb
            r23 = 4
            goto L_0x04fb
        L_0x04eb:
            r5 = 100
            int r11 = (r38 > r5 ? 1 : (r38 == r5 ? 0 : -1))
            if (r11 < 0) goto L_0x04f2
            goto L_0x04fb
        L_0x04f2:
            int r5 = (r38 > r9 ? 1 : (r38 == r9 ? 0 : -1))
            if (r5 < 0) goto L_0x04f9
            r23 = 2
            goto L_0x04fb
        L_0x04f9:
            r23 = 1
        L_0x04fb:
            int r2 = r2 + r23
            int r5 = r2 + -1
            r6 = -3
            if (r5 < r6) goto L_0x0507
            if (r5 < r7) goto L_0x0505
            goto L_0x0507
        L_0x0505:
            r6 = 0
            goto L_0x0508
        L_0x0507:
            r6 = 1
        L_0x0508:
            if (r4 != 0) goto L_0x053a
            if (r3 == 0) goto L_0x050d
            goto L_0x053a
        L_0x050d:
            r3 = 0
            r4 = 0
        L_0x050f:
            long r11 = r38 / r9
            long r13 = r0 / r9
            int r7 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r7 <= 0) goto L_0x052b
            r15 = 100
            int r7 = (r38 > r15 ? 1 : (r38 == r15 ? 0 : -1))
            if (r7 >= 0) goto L_0x0520
            if (r6 == 0) goto L_0x0520
            goto L_0x052b
        L_0x0520:
            long r0 = r17 % r9
            int r4 = (int) r0
            long r17 = r17 / r9
            int r3 = r3 + 1
            r38 = r11
            r0 = r13
            goto L_0x050f
        L_0x052b:
            int r7 = (r17 > r0 ? 1 : (r17 == r0 ? 0 : -1))
            if (r7 == 0) goto L_0x0534
            if (r4 < r8) goto L_0x0532
            goto L_0x0534
        L_0x0532:
            r0 = 0
            goto L_0x0535
        L_0x0534:
            r0 = 1
        L_0x0535:
            long r0 = (long) r0
            long r17 = r17 + r0
            goto L_0x05af
        L_0x053a:
            r7 = 0
            r11 = 0
        L_0x053c:
            long r12 = r38 / r9
            long r14 = r0 / r9
            int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r16 <= 0) goto L_0x0569
            r19 = 100
            int r16 = (r38 > r19 ? 1 : (r38 == r19 ? 0 : -1))
            if (r16 >= 0) goto L_0x054d
            if (r6 == 0) goto L_0x054d
            goto L_0x0569
        L_0x054d:
            long r0 = r0 % r9
            r19 = 0
            int r16 = (r0 > r19 ? 1 : (r0 == r19 ? 0 : -1))
            if (r16 != 0) goto L_0x0556
            r0 = 1
            goto L_0x0557
        L_0x0556:
            r0 = 0
        L_0x0557:
            r4 = r4 & r0
            if (r7 != 0) goto L_0x055c
            r0 = 1
            goto L_0x055d
        L_0x055c:
            r0 = 0
        L_0x055d:
            r3 = r3 & r0
            long r0 = r17 % r9
            int r7 = (int) r0
            long r17 = r17 / r9
            int r11 = r11 + 1
            r38 = r12
            r0 = r14
            goto L_0x053c
        L_0x0569:
            if (r4 == 0) goto L_0x058f
            if (r32 == 0) goto L_0x058f
        L_0x056d:
            long r12 = r0 % r9
            r14 = 0
            int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r16 != 0) goto L_0x058f
            r12 = 100
            int r14 = (r38 > r12 ? 1 : (r38 == r12 ? 0 : -1))
            if (r14 >= 0) goto L_0x057e
            if (r6 == 0) goto L_0x057e
            goto L_0x058f
        L_0x057e:
            if (r7 != 0) goto L_0x0582
            r7 = 1
            goto L_0x0583
        L_0x0582:
            r7 = 0
        L_0x0583:
            r3 = r3 & r7
            long r12 = r17 % r9
            int r7 = (int) r12
            long r38 = r38 / r9
            long r17 = r17 / r9
            long r0 = r0 / r9
            int r11 = r11 + 1
            goto L_0x056d
        L_0x058f:
            if (r3 == 0) goto L_0x059e
            if (r7 != r8) goto L_0x059e
            r12 = 2
            long r12 = r17 % r12
            r14 = 0
            int r3 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r3 != 0) goto L_0x059e
            r7 = 4
        L_0x059e:
            int r3 = (r17 > r0 ? 1 : (r17 == r0 ? 0 : -1))
            if (r3 != 0) goto L_0x05a6
            if (r4 == 0) goto L_0x05a8
            if (r32 == 0) goto L_0x05a8
        L_0x05a6:
            if (r7 < r8) goto L_0x05aa
        L_0x05a8:
            r0 = 1
            goto L_0x05ab
        L_0x05aa:
            r0 = 0
        L_0x05ab:
            long r0 = (long) r0
            long r17 = r17 + r0
            r3 = r11
        L_0x05af:
            int r0 = r23 - r3
            if (r26 == 0) goto L_0x05ba
            int r1 = r46 + 1
            r3 = 45
            r45[r46] = r3
            goto L_0x05bc
        L_0x05ba:
            r1 = r46
        L_0x05bc:
            if (r6 == 0) goto L_0x0634
            r2 = 0
        L_0x05bf:
            int r3 = r0 + -1
            if (r2 >= r3) goto L_0x05d4
            long r3 = r17 % r9
            int r4 = (int) r3
            long r17 = r17 / r9
            int r3 = r1 + r0
            int r3 = r3 - r2
            r6 = 48
            int r4 = r4 + r6
            char r4 = (char) r4
            r45[r3] = r4
            int r2 = r2 + 1
            goto L_0x05bf
        L_0x05d4:
            r2 = 48
            long r17 = r17 % r9
            long r2 = r17 + r2
            int r3 = (int) r2
            char r2 = (char) r3
            r45[r1] = r2
            int r2 = r1 + 1
            r3 = 46
            r45[r2] = r3
            int r2 = r0 + 1
            int r1 = r1 + r2
            r2 = 1
            if (r0 != r2) goto L_0x05f1
            int r0 = r1 + 1
            r2 = 48
            r45[r1] = r2
            r1 = r0
        L_0x05f1:
            int r0 = r1 + 1
            r2 = 69
            r45[r1] = r2
            if (r5 >= 0) goto L_0x0601
            int r1 = r1 + 2
            r2 = 45
            r45[r0] = r2
            int r5 = -r5
            r0 = r1
        L_0x0601:
            r1 = 100
            if (r5 < r1) goto L_0x061a
            int r1 = r0 + 1
            int r2 = r5 / 100
            r3 = 48
            int r2 = r2 + r3
            char r2 = (char) r2
            r45[r0] = r2
            int r5 = r5 % 100
            int r0 = r0 + 2
            int r2 = r5 / 10
            int r2 = r2 + r3
            char r2 = (char) r2
            r45[r1] = r2
            goto L_0x0629
        L_0x061a:
            r1 = 10
            r3 = 48
            if (r5 < r1) goto L_0x0629
            int r1 = r0 + 1
            int r2 = r5 / 10
            int r2 = r2 + r3
            char r2 = (char) r2
            r45[r0] = r2
            r0 = r1
        L_0x0629:
            int r1 = r0 + 1
            r2 = 10
            int r5 = r5 % r2
            int r5 = r5 + r3
            char r2 = (char) r5
            r45[r0] = r2
            goto L_0x004d
        L_0x0634:
            r3 = 48
            if (r5 >= 0) goto L_0x0668
            int r2 = r1 + 1
            r45[r1] = r3
            int r1 = r1 + 2
            r4 = 46
            r45[r2] = r4
            r2 = -1
        L_0x0643:
            if (r2 <= r5) goto L_0x064f
            int r4 = r1 + 1
            r45[r1] = r3
            int r2 = r2 + -1
            r1 = r4
            r3 = 48
            goto L_0x0643
        L_0x064f:
            r3 = r1
            r2 = 0
        L_0x0651:
            if (r2 >= r0) goto L_0x06c8
            int r4 = r1 + r0
            int r4 = r4 - r2
            r5 = 1
            int r4 = r4 - r5
            r5 = 48
            long r7 = r17 % r9
            long r7 = r7 + r5
            int r5 = (int) r7
            char r5 = (char) r5
            r45[r4] = r5
            long r17 = r17 / r9
            int r3 = r3 + 1
            int r2 = r2 + 1
            goto L_0x0651
        L_0x0668:
            if (r2 < r0) goto L_0x069a
            r3 = 0
        L_0x066b:
            if (r3 >= r0) goto L_0x0680
            int r4 = r1 + r0
            int r4 = r4 - r3
            r5 = 1
            int r4 = r4 - r5
            r5 = 48
            long r7 = r17 % r9
            long r7 = r7 + r5
            int r5 = (int) r7
            char r5 = (char) r5
            r45[r4] = r5
            long r17 = r17 / r9
            int r3 = r3 + 1
            goto L_0x066b
        L_0x0680:
            int r1 = r1 + r0
        L_0x0681:
            if (r0 >= r2) goto L_0x068d
            int r3 = r1 + 1
            r4 = 48
            r45[r1] = r4
            int r0 = r0 + 1
            r1 = r3
            goto L_0x0681
        L_0x068d:
            r4 = 48
            int r0 = r1 + 1
            r2 = 46
            r45[r1] = r2
            int r3 = r1 + 2
            r45[r0] = r4
            goto L_0x06c8
        L_0x069a:
            int r2 = r1 + 1
            r3 = 0
        L_0x069d:
            if (r3 >= r0) goto L_0x06c4
            int r4 = r0 - r3
            r6 = 1
            int r4 = r4 - r6
            if (r4 != r5) goto L_0x06b0
            int r4 = r2 + r0
            int r4 = r4 - r3
            int r4 = r4 - r6
            r7 = 46
            r45[r4] = r7
            int r2 = r2 + -1
            goto L_0x06b2
        L_0x06b0:
            r7 = 46
        L_0x06b2:
            int r4 = r2 + r0
            int r4 = r4 - r3
            int r4 = r4 - r6
            r11 = 48
            long r13 = r17 % r9
            long r13 = r13 + r11
            int r8 = (int) r13
            char r8 = (char) r8
            r45[r4] = r8
            long r17 = r17 / r9
            int r3 = r3 + 1
            goto L_0x069d
        L_0x06c4:
            r6 = 1
            int r0 = r0 + r6
            int r3 = r1 + r0
        L_0x06c8:
            int r3 = r3 - r46
            return r3
        L_0x06cb:
            r27 = r2
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = ""
            r1.append(r2)
            r2 = r27
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.RyuDouble.toString(double, char[], int):int");
    }
}
