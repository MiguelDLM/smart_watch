package kotlin.text;

import com.google.android.exoplayer2.C;
import kotlin.jvm.internal.IIX0o;
import kotlin.oxxXoxO;

/* loaded from: classes6.dex */
public class o00 extends xoXoI {
    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007a  */
    @kotlin.oxxXoxO(version = "1.1")
    @OXOo.oOoXoXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Long IXO(@OXOo.OOXIXo java.lang.String r18, int r19) {
        /*
            r0 = r18
            r1 = r19
            java.lang.String r2 = "<this>"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r0, r2)
            kotlin.text.II0xO0.oIX0oI(r19)
            int r2 = r18.length()
            r3 = 0
            if (r2 != 0) goto L14
            return r3
        L14:
            r4 = 0
            char r5 = r0.charAt(r4)
            r6 = 48
            int r6 = kotlin.jvm.internal.IIX0o.oI0IIXIo(r5, r6)
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r6 >= 0) goto L37
            r6 = 1
            if (r2 != r6) goto L2a
            return r3
        L2a:
            r9 = 45
            if (r5 != r9) goto L32
            r7 = -9223372036854775808
            r4 = 1
            goto L3a
        L32:
            r9 = 43
            if (r5 != r9) goto L39
            r4 = 1
        L37:
            r6 = 0
            goto L3a
        L39:
            return r3
        L3a:
            r9 = -256204778801521550(0xfc71c71c71c71c72, double:-2.772000429909333E291)
            r11 = 0
            r13 = r9
        L42:
            if (r4 >= r2) goto L73
            char r5 = r0.charAt(r4)
            int r5 = kotlin.text.II0xO0.II0xO0(r5, r1)
            if (r5 >= 0) goto L4f
            return r3
        L4f:
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 >= 0) goto L5f
            int r15 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
            if (r15 != 0) goto L5e
            long r13 = (long) r1
            long r13 = r7 / r13
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 >= 0) goto L5f
        L5e:
            return r3
        L5f:
            long r9 = (long) r1
            long r11 = r11 * r9
            long r9 = (long) r5
            long r16 = r7 + r9
            int r5 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r5 >= 0) goto L6a
            return r3
        L6a:
            long r11 = r11 - r9
            int r4 = r4 + 1
            r9 = -256204778801521550(0xfc71c71c71c71c72, double:-2.772000429909333E291)
            goto L42
        L73:
            if (r6 == 0) goto L7a
            java.lang.Long r0 = java.lang.Long.valueOf(r11)
            goto L7f
        L7a:
            long r0 = -r11
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
        L7f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.o00.IXO(java.lang.String, int):java.lang.Long");
    }

    @oxxXoxO(version = "1.1")
    @OXOo.oOoXoXO
    public static final Short Ix00oIoI(@OXOo.OOXIXo String str, int i) {
        int intValue;
        IIX0o.x0xO0oo(str, "<this>");
        Integer IxIX0I2 = IxIX0I(str, i);
        if (IxIX0I2 == null || (intValue = IxIX0I2.intValue()) < -32768 || intValue > 32767) {
            return null;
        }
        return Short.valueOf((short) intValue);
    }

    @oxxXoxO(version = "1.1")
    @OXOo.oOoXoXO
    public static final Integer IxIX0I(@OXOo.OOXIXo String str, int i) {
        boolean z;
        int i2;
        int i3;
        IIX0o.x0xO0oo(str, "<this>");
        II0xO0.oIX0oI(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i4 = 0;
        char charAt = str.charAt(0);
        int oI0IIXIo2 = IIX0o.oI0IIXIo(charAt, 48);
        int i5 = C.RATE_UNSET_INT;
        if (oI0IIXIo2 < 0) {
            i2 = 1;
            if (length == 1) {
                return null;
            }
            if (charAt == '-') {
                i5 = Integer.MIN_VALUE;
                z = true;
            } else {
                if (charAt != '+') {
                    return null;
                }
                z = false;
            }
        } else {
            z = false;
            i2 = 0;
        }
        int i6 = -59652323;
        while (i2 < length) {
            int II0xO02 = II0xO0.II0xO0(str.charAt(i2), i);
            if (II0xO02 < 0) {
                return null;
            }
            if ((i4 < i6 && (i6 != -59652323 || i4 < (i6 = i5 / i))) || (i3 = i4 * i) < i5 + II0xO02) {
                return null;
            }
            i4 = i3 - II0xO02;
            i2++;
        }
        if (z) {
            return Integer.valueOf(i4);
        }
        return Integer.valueOf(-i4);
    }

    @oxxXoxO(version = "1.1")
    @OXOo.oOoXoXO
    public static final Byte OIOoIIOIx(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<this>");
        return x0OIX00oO(str, 10);
    }

    @OXOo.OOXIXo
    public static final Void OoO(@OXOo.OOXIXo String input) {
        IIX0o.x0xO0oo(input, "input");
        throw new NumberFormatException("Invalid number format: '" + input + '\'');
    }

    @oxxXoxO(version = "1.1")
    @OXOo.oOoXoXO
    public static Integer XXoOx0(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<this>");
        return IxIX0I(str, 10);
    }

    @oxxXoxO(version = "1.1")
    @OXOo.oOoXoXO
    public static final Short oI(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<this>");
        return Ix00oIoI(str, 10);
    }

    @oxxXoxO(version = "1.1")
    @OXOo.oOoXoXO
    public static Long oOoIIO0(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<this>");
        return IXO(str, 10);
    }

    @oxxXoxO(version = "1.1")
    @OXOo.oOoXoXO
    public static final Byte x0OIX00oO(@OXOo.OOXIXo String str, int i) {
        int intValue;
        IIX0o.x0xO0oo(str, "<this>");
        Integer IxIX0I2 = IxIX0I(str, i);
        if (IxIX0I2 == null || (intValue = IxIX0I2.intValue()) < -128 || intValue > 127) {
            return null;
        }
        return Byte.valueOf((byte) intValue);
    }
}
