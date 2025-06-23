package com.google.android.gms.internal.fido;

import java.math.RoundingMode;

/* loaded from: classes9.dex */
public final class zzbh {
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003e, code lost:
    
        if (((r0 & 1) & r3) != 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
    
        if (r1 > 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
    
        if (r5 > 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0047, code lost:
    
        if (r5 < 0) goto L27;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x001c. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int zza(int r5, int r6, java.math.RoundingMode r7) {
        /*
            r7.getClass()
            if (r6 == 0) goto L4f
            int r0 = r5 / r6
            int r1 = r6 * r0
            int r1 = r5 - r1
            if (r1 != 0) goto Le
            return r0
        Le:
            r5 = r5 ^ r6
            int[] r2 = com.google.android.gms.internal.fido.zzbg.zza
            int r3 = r7.ordinal()
            r2 = r2[r3]
            int r5 = r5 >> 31
            r3 = 1
            r5 = r5 | r3
            r4 = 0
            switch(r2) {
                case 1: goto L4b;
                case 2: goto L4e;
                case 3: goto L47;
                case 4: goto L49;
                case 5: goto L44;
                case 6: goto L25;
                case 7: goto L25;
                case 8: goto L25;
                default: goto L1f;
            }
        L1f:
            java.lang.AssertionError r5 = new java.lang.AssertionError
            r5.<init>()
            throw r5
        L25:
            int r1 = java.lang.Math.abs(r1)
            int r6 = java.lang.Math.abs(r6)
            int r6 = r6 - r1
            int r1 = r1 - r6
            if (r1 != 0) goto L41
            java.math.RoundingMode r6 = java.math.RoundingMode.HALF_UP
            if (r7 == r6) goto L49
            java.math.RoundingMode r6 = java.math.RoundingMode.HALF_EVEN
            if (r7 != r6) goto L3a
            goto L3b
        L3a:
            r3 = 0
        L3b:
            r6 = r0 & 1
            r6 = r6 & r3
            if (r6 == 0) goto L4e
            goto L49
        L41:
            if (r1 <= 0) goto L4e
            goto L49
        L44:
            if (r5 <= 0) goto L4e
            goto L49
        L47:
            if (r5 >= 0) goto L4e
        L49:
            int r0 = r0 + r5
            return r0
        L4b:
            com.google.android.gms.internal.fido.zzbi.zza(r4)
        L4e:
            return r0
        L4f:
            java.lang.ArithmeticException r5 = new java.lang.ArithmeticException
            java.lang.String r6 = "/ by zero"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fido.zzbh.zza(int, int, java.math.RoundingMode):int");
    }

    public static int zzb(int i, RoundingMode roundingMode) {
        boolean z;
        if (i > 0) {
            switch (zzbg.zza[roundingMode.ordinal()]) {
                case 1:
                    if (((i - 1) & i) == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zzbi.zza(z);
                    break;
                case 2:
                case 3:
                    break;
                case 4:
                case 5:
                    return 32 - Integer.numberOfLeadingZeros(i - 1);
                case 6:
                case 7:
                case 8:
                    int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i);
                    return (31 - numberOfLeadingZeros) + ((((-1257966797) >>> numberOfLeadingZeros) - i) >>> 31);
                default:
                    throw new AssertionError();
            }
            return 31 - Integer.numberOfLeadingZeros(i);
        }
        throw new IllegalArgumentException("x (0) must be > 0");
    }
}
