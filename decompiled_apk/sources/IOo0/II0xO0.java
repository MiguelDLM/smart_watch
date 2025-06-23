package IOo0;

import OoOoXO0.xoXoI;
import XIXIX.OOXIXo;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import org.apache.commons.lang3.xXOx;
import org.apache.commons.lang3.xoIxX;

/* loaded from: classes6.dex */
public class II0xO0 {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final Long f613oIX0oI = 0L;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final Long f605II0xO0 = 1L;

    /* renamed from: I0Io, reason: collision with root package name */
    public static final Long f603I0Io = -1L;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final Integer f617oxoX = 0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final Integer f611X0o0xo = 1;

    /* renamed from: XO, reason: collision with root package name */
    public static final Integer f612XO = 2;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final Integer f609Oxx0IOOO = -1;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final Short f604II0XooXoX = 0;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final Short f621xxIXOIIO = 1;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final Short f620xoIox = -1;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final Byte f607OOXIXo = (byte) 0;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final Byte f615oOoXoXO = (byte) 1;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final Byte f616ooOOo0oXI = (byte) -1;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final Double f618x0XOIxOo = Double.valueOf(OOXIXo.f3760XO);

    /* renamed from: oO, reason: collision with root package name */
    public static final Double f614oO = Double.valueOf(1.0d);

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final Double f619x0xO0oo = Double.valueOf(-1.0d);

    /* renamed from: Oo, reason: collision with root package name */
    public static final Float f608Oo = Float.valueOf(0.0f);

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final Float f606IXxxXO = Float.valueOf(1.0f);

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final Float f610Oxx0xo = Float.valueOf(-1.0f);

    public static int I0Io(long j, long j2) {
        if (j == j2) {
            return 0;
        }
        if (j < j2) {
            return -1;
        }
        return 1;
    }

    public static BigDecimal I0X0x0oIo(Float f) {
        return oX(f, f612XO.intValue(), RoundingMode.HALF_EVEN);
    }

    public static BigDecimal I0oOIX(BigDecimal bigDecimal, int i, RoundingMode roundingMode) {
        if (bigDecimal == null) {
            return BigDecimal.ZERO;
        }
        if (roundingMode == null) {
            roundingMode = RoundingMode.HALF_EVEN;
        }
        return bigDecimal.setScale(i, roundingMode);
    }

    public static float I0oOoX(String str, float f) {
        if (str == null) {
            return f;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return f;
        }
    }

    public static Float II0XooXoX(String str) {
        if (str == null) {
            return null;
        }
        return Float.valueOf(str);
    }

    public static int II0xO0(int i, int i2) {
        if (i == i2) {
            return 0;
        }
        if (i < i2) {
            return -1;
        }
        return 1;
    }

    public static double IIX0o(double d, double d2, double d3) {
        return Math.min(Math.min(d, d2), d3);
    }

    public static double IIXOooo(double... dArr) {
        IoOoo(dArr);
        double d = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            if (Double.isNaN(dArr[i])) {
                return Double.NaN;
            }
            double d2 = dArr[i];
            if (d2 > d) {
                d = d2;
            }
        }
        return d;
    }

    public static short IO(short... sArr) {
        IoOoo(sArr);
        short s = sArr[0];
        for (int i = 1; i < sArr.length; i++) {
            short s2 = sArr[i];
            if (s2 < s) {
                s = s2;
            }
        }
        return s;
    }

    public static boolean IXxxXO(String str) {
        if (xXOx.XIXIX(str) || str.charAt(str.length() - 1) == '.') {
            return false;
        }
        if (str.charAt(0) == '-') {
            if (str.length() == 1) {
                return false;
            }
            return xoIxX(str, 1);
        }
        return xoIxX(str, 0);
    }

    public static double Io(BigDecimal bigDecimal) {
        return o0(bigDecimal, OOXIXo.f3760XO);
    }

    public static int IoOoX(int... iArr) {
        IoOoo(iArr);
        int i = iArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            int i3 = iArr[i2];
            if (i3 < i) {
                i = i3;
            }
        }
        return i;
    }

    public static void IoOoo(Object obj) {
        boolean z;
        xoIxX.xo0x(obj, "The Array must not be null", new Object[0]);
        if (Array.getLength(obj) != 0) {
            z = true;
        } else {
            z = false;
        }
        xoIxX.XI0IXoo(z, "Array cannot be empty.", new Object[0]);
    }

    public static BigDecimal O0Xx(BigDecimal bigDecimal) {
        return I0oOIX(bigDecimal, f612XO.intValue(), RoundingMode.HALF_EVEN);
    }

    public static int O0xOxO(int... iArr) {
        IoOoo(iArr);
        int i = iArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            int i3 = iArr[i2];
            if (i3 > i) {
                i = i3;
            }
        }
        return i;
    }

    public static double OI0(String str, double d) {
        if (str == null) {
            return d;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return d;
        }
    }

    public static short OO(String str, short s) {
        if (str == null) {
            return s;
        }
        try {
            return Short.parseShort(str);
        } catch (NumberFormatException unused) {
            return s;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x0137, code lost:
    
        if (r1 == 'l') goto L83;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Number OOXIXo(java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 586
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: IOo0.II0xO0.OOXIXo(java.lang.String):java.lang.Number");
    }

    @Deprecated
    public static boolean Oo(String str) {
        return oO(str);
    }

    public static int OxI(int i, int i2, int i3) {
        if (i2 > i) {
            i = i2;
        }
        if (i3 <= i) {
            return i;
        }
        return i3;
    }

    public static Double Oxx0IOOO(String str) {
        if (str == null) {
            return null;
        }
        return Double.valueOf(str);
    }

    public static byte Oxx0xo(byte b, byte b2, byte b3) {
        if (b2 > b) {
            b = b2;
        }
        if (b3 <= b) {
            return b;
        }
        return b3;
    }

    public static double OxxIIOOXO(double d, double d2, double d3) {
        return Math.max(Math.max(d, d2), d3);
    }

    public static short X00IoxXI(short s, short s2, short s3) {
        if (s2 < s) {
            s = s2;
        }
        if (s3 >= s) {
            return s;
        }
        return s3;
    }

    public static long X0IIOO(long j, long j2, long j3) {
        if (j2 > j) {
            j = j2;
        }
        if (j3 <= j) {
            return j;
        }
        return j3;
    }

    public static BigDecimal X0o0xo(String str) {
        if (str == null) {
            return null;
        }
        if (!xXOx.xOOOX(str)) {
            return new BigDecimal(str);
        }
        throw new NumberFormatException("A blank string is not a valid number");
    }

    public static long XI0IXoo(long... jArr) {
        IoOoo(jArr);
        long j = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            long j2 = jArr[i];
            if (j2 > j) {
                j = j2;
            }
        }
        return j;
    }

    public static short XIxXXX0x0(short s, short s2, short s3) {
        if (s2 > s) {
            s = s2;
        }
        if (s3 <= s) {
            return s;
        }
        return s3;
    }

    public static BigInteger XO(String str) {
        int i;
        if (str == null) {
            return null;
        }
        boolean startsWith = str.startsWith(HelpFormatter.DEFAULT_OPT_PREFIX);
        int i2 = 16;
        if (!str.startsWith(HexStringBuilder.DEFAULT_PREFIX, startsWith ? 1 : 0) && !str.startsWith("0X", startsWith ? 1 : 0)) {
            if (str.startsWith(xoXoI.f2670oxoX, startsWith ? 1 : 0)) {
                i = (startsWith ? 1 : 0) + 1;
            } else {
                if (str.startsWith("0", startsWith ? 1 : 0)) {
                    int length = str.length();
                    int i3 = (startsWith ? 1 : 0) + 1;
                    if (length > i3) {
                        i = i3;
                        i2 = 8;
                    }
                }
                i2 = 10;
                i = startsWith ? 1 : 0;
            }
        } else {
            i = (startsWith ? 1 : 0) + 2;
        }
        BigInteger bigInteger = new BigInteger(str.substring(i), i2);
        if (startsWith) {
            return bigInteger.negate();
        }
        return bigInteger;
    }

    public static double XOxIOxOx(String str) {
        return OI0(str, OOXIXo.f3760XO);
    }

    public static float XX(String str) {
        return I0oOoX(str, 0.0f);
    }

    public static BigDecimal XX0(Double d, int i, RoundingMode roundingMode) {
        if (d == null) {
            return BigDecimal.ZERO;
        }
        return I0oOIX(BigDecimal.valueOf(d.doubleValue()), i, roundingMode);
    }

    public static BigDecimal Xo0(String str) {
        return XoI0Ixx0(str, f612XO.intValue(), RoundingMode.HALF_EVEN);
    }

    public static BigDecimal XoI0Ixx0(String str, int i, RoundingMode roundingMode) {
        if (str == null) {
            return BigDecimal.ZERO;
        }
        return I0oOIX(X0o0xo(str), i, roundingMode);
    }

    public static int XoX(String str, int i) {
        if (str == null) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static long Xx000oIo(long... jArr) {
        IoOoo(jArr);
        long j = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            long j2 = jArr[i];
            if (j2 < j) {
                j = j2;
            }
        }
        return j;
    }

    public static byte XxX0x0xxx(byte b, byte b2, byte b3) {
        if (b2 < b) {
            b = b2;
        }
        if (b3 >= b) {
            return b;
        }
        return b3;
    }

    public static double o0(BigDecimal bigDecimal, double d) {
        if (bigDecimal != null) {
            return bigDecimal.doubleValue();
        }
        return d;
    }

    public static float o00(float... fArr) {
        IoOoo(fArr);
        float f = fArr[0];
        for (int i = 1; i < fArr.length; i++) {
            if (Float.isNaN(fArr[i])) {
                return Float.NaN;
            }
            float f2 = fArr[i];
            if (f2 > f) {
                f = f2;
            }
        }
        return f;
    }

    public static byte oI0IIXIo(byte... bArr) {
        IoOoo(bArr);
        byte b = bArr[0];
        for (int i = 1; i < bArr.length; i++) {
            byte b2 = bArr[i];
            if (b2 > b) {
                b = b2;
            }
        }
        return b;
    }

    public static int oIX0oI(byte b, byte b2) {
        return b - b2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x00c9, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x00e6, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x008d, code lost:
    
        if (r3 >= r0.length) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x008f, code lost:
    
        r0 = r0[r3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0091, code lost:
    
        if (r0 < '0') goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0093, code lost:
    
        if (r0 > '9') goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0095, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0096, code lost:
    
        if (r0 == 'e') goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0098, code lost:
    
        if (r0 != 'E') goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x009b, code lost:
    
        if (r0 != '.') goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x009d, code lost:
    
        if (r16 != false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x009f, code lost:
    
        if (r15 == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00a2, code lost:
    
        return r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00a3, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00a4, code lost:
    
        if (r13 != false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00a8, code lost:
    
        if (r0 == 'd') goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00ac, code lost:
    
        if (r0 == 'D') goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00ae, code lost:
    
        if (r0 == 'f') goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00b0, code lost:
    
        if (r0 != 'F') goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00b2, code lost:
    
        return r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00b5, code lost:
    
        if (r0 == 'l') goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x00b9, code lost:
    
        if (r0 != 'L') goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x00bc, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x00bd, code lost:
    
        if (r14 == false) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x00bf, code lost:
    
        if (r15 != false) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x00c1, code lost:
    
        if (r16 != false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x00c3, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x00c5, code lost:
    
        if (r13 != false) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x00c7, code lost:
    
        if (r14 == false) goto L152;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean oO(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: IOo0.II0xO0.oO(java.lang.String):boolean");
    }

    public static long oOXoIIIo(long j, long j2, long j3) {
        if (j2 < j) {
            j = j2;
        }
        if (j3 >= j) {
            return j;
        }
        return j3;
    }

    public static String oOoXoXO(String str) {
        return ooOOo0oXI(str, str.length());
    }

    public static BigDecimal oX(Float f, int i, RoundingMode roundingMode) {
        if (f == null) {
            return BigDecimal.ZERO;
        }
        return I0oOIX(BigDecimal.valueOf(f.floatValue()), i, roundingMode);
    }

    public static int oo(int i, int i2, int i3) {
        if (i2 < i) {
            i = i2;
        }
        if (i3 >= i) {
            return i;
        }
        return i3;
    }

    public static float oo0xXOI0I(float... fArr) {
        IoOoo(fArr);
        float f = fArr[0];
        for (int i = 1; i < fArr.length; i++) {
            if (Float.isNaN(fArr[i])) {
                return Float.NaN;
            }
            float f2 = fArr[i];
            if (f2 < f) {
                f = f2;
            }
        }
        return f;
    }

    public static String ooOOo0oXI(String str, int i) {
        int i2 = 0;
        char charAt = str.charAt(0);
        if (charAt == '-' || charAt == '+') {
            i2 = 1;
        }
        return str.substring(i2, i);
    }

    public static double ooXIXxIX(double... dArr) {
        IoOoo(dArr);
        double d = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            if (Double.isNaN(dArr[i])) {
                return Double.NaN;
            }
            double d2 = dArr[i];
            if (d2 < d) {
                d = d2;
            }
        }
        return d;
    }

    public static long oxXx0IX(String str) {
        return xo0x(str, 0L);
    }

    public static int oxoX(short s, short s2) {
        if (s == s2) {
            return 0;
        }
        if (s < s2) {
            return -1;
        }
        return 1;
    }

    public static int oxxXoxO(String str) {
        return XoX(str, 0);
    }

    public static boolean x0XOIxOo(String str) {
        if (str == null) {
            return true;
        }
        for (int length = str.length() - 1; length >= 0; length--) {
            if (str.charAt(length) != '0') {
                return false;
            }
        }
        return !str.isEmpty();
    }

    public static byte x0o(String str, byte b) {
        if (str == null) {
            return b;
        }
        try {
            return Byte.parseByte(str);
        } catch (NumberFormatException unused) {
            return b;
        }
    }

    public static boolean x0xO0oo(String str) {
        return xXOx.Ox0O(str);
    }

    public static float xI(float f, float f2, float f3) {
        return Math.min(Math.min(f, f2), f3);
    }

    public static byte xII(String str) {
        return x0o(str, (byte) 0);
    }

    public static BigDecimal xXOx(Double d) {
        return XX0(d, f612XO.intValue(), RoundingMode.HALF_EVEN);
    }

    public static byte xXxxox0I(byte... bArr) {
        IoOoo(bArr);
        byte b = bArr[0];
        for (int i = 1; i < bArr.length; i++) {
            byte b2 = bArr[i];
            if (b2 < b) {
                b = b2;
            }
        }
        return b;
    }

    public static long xo0x(String str, long j) {
        if (str == null) {
            return j;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    public static Long xoIox(String str) {
        if (str == null) {
            return null;
        }
        return Long.decode(str);
    }

    public static boolean xoIxX(String str, int i) {
        boolean z;
        int i2 = 0;
        while (i < str.length()) {
            if (str.charAt(i) == '.') {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i2++;
            }
            if (i2 > 1) {
                return false;
            }
            if (!z && !Character.isDigit(str.charAt(i))) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static float xoXoI(float f, float f2, float f3) {
        return Math.max(Math.max(f, f2), f3);
    }

    public static short xoxXI(String str) {
        return OO(str, (short) 0);
    }

    public static Integer xxIXOIIO(String str) {
        if (str == null) {
            return null;
        }
        return Integer.decode(str);
    }

    public static short xxX(short... sArr) {
        IoOoo(sArr);
        short s = sArr[0];
        for (int i = 1; i < sArr.length; i++) {
            short s2 = sArr[i];
            if (s2 > s) {
                s = s2;
            }
        }
        return s;
    }
}
