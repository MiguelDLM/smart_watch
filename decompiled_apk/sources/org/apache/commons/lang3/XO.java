package org.apache.commons.lang3;

/* loaded from: classes6.dex */
public class XO {
    public static int I0Io(boolean z, boolean z2) {
        if (z == z2) {
            return 0;
        }
        return z ? 1 : -1;
    }

    public static Boolean II0XooXoX(Boolean bool) {
        if (bool == null) {
            return null;
        }
        if (bool.booleanValue()) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public static boolean II0xO0(boolean... zArr) {
        if (zArr != null) {
            if (zArr.length != 0) {
                for (boolean z : zArr) {
                    if (!z) {
                        return false;
                    }
                }
                return true;
            }
            throw new IllegalArgumentException("Array is empty");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static String IIX0o(Boolean bool) {
        return XxX0x0xxx(bool, kotlinx.coroutines.XOxIOxOx.f29774oxoX, kotlinx.coroutines.XOxIOxOx.f29771X0o0xo, null);
    }

    public static Boolean IIXOooo(String str) {
        if (str == "true") {
            return Boolean.TRUE;
        }
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length != 1) {
            if (length != 2) {
                if (length != 3) {
                    if (length != 4) {
                        if (length != 5) {
                            return null;
                        }
                        char charAt = str.charAt(0);
                        char charAt2 = str.charAt(1);
                        char charAt3 = str.charAt(2);
                        char charAt4 = str.charAt(3);
                        char charAt5 = str.charAt(4);
                        if (charAt != 'f' && charAt != 'F') {
                            return null;
                        }
                        if (charAt2 != 'a' && charAt2 != 'A') {
                            return null;
                        }
                        if (charAt3 != 'l' && charAt3 != 'L') {
                            return null;
                        }
                        if (charAt4 != 's' && charAt4 != 'S') {
                            return null;
                        }
                        if (charAt5 != 'e' && charAt5 != 'E') {
                            return null;
                        }
                        return Boolean.FALSE;
                    }
                    char charAt6 = str.charAt(0);
                    char charAt7 = str.charAt(1);
                    char charAt8 = str.charAt(2);
                    char charAt9 = str.charAt(3);
                    if (charAt6 != 't' && charAt6 != 'T') {
                        return null;
                    }
                    if (charAt7 != 'r' && charAt7 != 'R') {
                        return null;
                    }
                    if (charAt8 != 'u' && charAt8 != 'U') {
                        return null;
                    }
                    if (charAt9 != 'e' && charAt9 != 'E') {
                        return null;
                    }
                    return Boolean.TRUE;
                }
                char charAt10 = str.charAt(0);
                char charAt11 = str.charAt(1);
                char charAt12 = str.charAt(2);
                if ((charAt10 != 'y' && charAt10 != 'Y') || ((charAt11 != 'e' && charAt11 != 'E') || (charAt12 != 's' && charAt12 != 'S'))) {
                    if (charAt10 != 'o' && charAt10 != 'O') {
                        return null;
                    }
                    if (charAt11 != 'f' && charAt11 != 'F') {
                        return null;
                    }
                    if (charAt12 != 'f' && charAt12 != 'F') {
                        return null;
                    }
                    return Boolean.FALSE;
                }
                return Boolean.TRUE;
            }
            char charAt13 = str.charAt(0);
            char charAt14 = str.charAt(1);
            if ((charAt13 != 'o' && charAt13 != 'O') || (charAt14 != 'n' && charAt14 != 'N')) {
                if (charAt13 != 'n' && charAt13 != 'N') {
                    return null;
                }
                if (charAt14 != 'o' && charAt14 != 'O') {
                    return null;
                }
                return Boolean.FALSE;
            }
            return Boolean.TRUE;
        }
        char charAt15 = str.charAt(0);
        if (charAt15 != 'y' && charAt15 != 'Y' && charAt15 != 't' && charAt15 != 'T' && charAt15 != '1') {
            if (charAt15 != 'n' && charAt15 != 'N' && charAt15 != 'f' && charAt15 != 'F' && charAt15 != '0') {
                return null;
            }
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public static Boolean IXxxXO(int i) {
        if (i == 0) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public static String IoOoX(boolean z) {
        return xXxxox0I(z, "yes", "no");
    }

    public static int O0xOxO(boolean z, int i, int i2) {
        return z ? i : i2;
    }

    public static boolean OOXIXo(int i) {
        return i != 0;
    }

    public static boolean Oo(Boolean bool, boolean z) {
        if (bool == null) {
            return z;
        }
        return bool.booleanValue();
    }

    public static int OxI(boolean z) {
        return z ? 1 : 0;
    }

    public static boolean Oxx0IOOO(Boolean bool) {
        return Boolean.TRUE.equals(bool);
    }

    public static Boolean Oxx0xo(int i, int i2, int i3, int i4) {
        if (i == i2) {
            return Boolean.TRUE;
        }
        if (i == i3) {
            return Boolean.FALSE;
        }
        if (i == i4) {
            return null;
        }
        throw new IllegalArgumentException("The Integer did not match any specified value");
    }

    public static Boolean OxxIIOOXO(Integer num, Integer num2, Integer num3, Integer num4) {
        if (num == null) {
            if (num2 == null) {
                return Boolean.TRUE;
            }
            if (num3 == null) {
                return Boolean.FALSE;
            }
            if (num4 == null) {
                return null;
            }
        } else {
            if (num.equals(num2)) {
                return Boolean.TRUE;
            }
            if (num.equals(num3)) {
                return Boolean.FALSE;
            }
            if (num.equals(num4)) {
                return null;
            }
        }
        throw new IllegalArgumentException("The Integer did not match any specified value");
    }

    public static Integer X0IIOO(Boolean bool) {
        if (bool == null) {
            return null;
        }
        if (bool.booleanValue()) {
            return IOo0.II0xO0.f611X0o0xo;
        }
        return IOo0.II0xO0.f617oxoX;
    }

    public static boolean X0o0xo(Boolean bool) {
        return !oxoX(bool);
    }

    public static Integer XI0IXoo(Boolean bool, Integer num, Integer num2, Integer num3) {
        if (bool == null) {
            return num3;
        }
        if (!bool.booleanValue()) {
            return num2;
        }
        return num;
    }

    public static Integer XIxXXX0x0(boolean z) {
        if (z) {
            return IOo0.II0xO0.f611X0o0xo;
        }
        return IOo0.II0xO0.f617oxoX;
    }

    public static boolean XO(Boolean bool) {
        return !Oxx0IOOO(bool);
    }

    public static boolean Xx000oIo(boolean... zArr) {
        if (zArr != null) {
            if (zArr.length != 0) {
                boolean z = false;
                for (boolean z2 : zArr) {
                    z ^= z2;
                }
                return z;
            }
            throw new IllegalArgumentException("Array is empty");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static String XxX0x0xxx(Boolean bool, String str, String str2, String str3) {
        if (bool == null) {
            return str3;
        }
        if (!bool.booleanValue()) {
            return str2;
        }
        return str;
    }

    public static int o00(Boolean bool, int i, int i2, int i3) {
        if (bool == null) {
            return i3;
        }
        if (!bool.booleanValue()) {
            return i2;
        }
        return i;
    }

    public static Boolean oI0IIXIo(Integer num) {
        if (num == null) {
            return null;
        }
        if (num.intValue() == 0) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public static Boolean oIX0oI(Boolean... boolArr) {
        if (boolArr != null) {
            if (boolArr.length != 0) {
                try {
                    if (II0xO0(oxoX.X0oX(boolArr))) {
                        return Boolean.TRUE;
                    }
                    return Boolean.FALSE;
                } catch (NullPointerException unused) {
                    throw new IllegalArgumentException("The array must not contain any null elements");
                }
            }
            throw new IllegalArgumentException("Array is empty");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static boolean oO(String str) {
        if (IIXOooo(str) == Boolean.TRUE) {
            return true;
        }
        return false;
    }

    public static Boolean oOXoIIIo(Boolean... boolArr) {
        if (boolArr != null) {
            if (boolArr.length != 0) {
                try {
                    if (Xx000oIo(oxoX.X0oX(boolArr))) {
                        return Boolean.TRUE;
                    }
                    return Boolean.FALSE;
                } catch (NullPointerException unused) {
                    throw new IllegalArgumentException("The array must not contain any null elements");
                }
            }
            throw new IllegalArgumentException("Array is empty");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static boolean oOoXoXO(int i, int i2, int i3) {
        if (i == i2) {
            return true;
        }
        if (i == i3) {
            return false;
        }
        throw new IllegalArgumentException("The Integer did not match either specified value");
    }

    public static String oo(Boolean bool) {
        return XxX0x0xxx(bool, "yes", "no", null);
    }

    public static String oo0xXOI0I(boolean z) {
        return xXxxox0I(z, "true", "false");
    }

    public static boolean ooOOo0oXI(Boolean bool) {
        if (bool != null && bool.booleanValue()) {
            return true;
        }
        return false;
    }

    public static String ooXIXxIX(boolean z) {
        return xXxxox0I(z, kotlinx.coroutines.XOxIOxOx.f29774oxoX, kotlinx.coroutines.XOxIOxOx.f29771X0o0xo);
    }

    public static boolean oxoX(Boolean bool) {
        return Boolean.FALSE.equals(bool);
    }

    public static boolean x0XOIxOo(Integer num, Integer num2, Integer num3) {
        if (num == null) {
            if (num2 == null) {
                return true;
            }
            if (num3 == null) {
                return false;
            }
        } else {
            if (num.equals(num2)) {
                return true;
            }
            if (num.equals(num3)) {
                return false;
            }
        }
        throw new IllegalArgumentException("The Integer did not match either specified value");
    }

    public static boolean x0xO0oo(String str, String str2, String str3) {
        if (str == str2) {
            return true;
        }
        if (str == str3) {
            return false;
        }
        if (str != null) {
            if (str.equals(str2)) {
                return true;
            }
            if (str.equals(str3)) {
                return false;
            }
        }
        throw new IllegalArgumentException("The String did not match either specified value");
    }

    public static String xI(Boolean bool) {
        return XxX0x0xxx(bool, "true", "false", null);
    }

    public static String xXxxox0I(boolean z, String str, String str2) {
        return z ? str : str2;
    }

    public static boolean xoIox(boolean... zArr) {
        if (zArr != null) {
            if (zArr.length != 0) {
                for (boolean z : zArr) {
                    if (z) {
                        return true;
                    }
                }
                return false;
            }
            throw new IllegalArgumentException("Array is empty");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static Boolean xoXoI(String str, String str2, String str3, String str4) {
        if (str == null) {
            if (str2 == null) {
                return Boolean.TRUE;
            }
            if (str3 == null) {
                return Boolean.FALSE;
            }
            if (str4 == null) {
                return null;
            }
        } else {
            if (str.equals(str2)) {
                return Boolean.TRUE;
            }
            if (str.equals(str3)) {
                return Boolean.FALSE;
            }
            if (str.equals(str4)) {
                return null;
            }
        }
        throw new IllegalArgumentException("The String did not match any specified value");
    }

    public static Boolean xxIXOIIO(Boolean... boolArr) {
        if (boolArr != null) {
            if (boolArr.length != 0) {
                try {
                    if (xoIox(oxoX.X0oX(boolArr))) {
                        return Boolean.TRUE;
                    }
                    return Boolean.FALSE;
                } catch (NullPointerException unused) {
                    throw new IllegalArgumentException("The array must not contain any null elements");
                }
            }
            throw new IllegalArgumentException("Array is empty");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static Integer xxX(boolean z, Integer num, Integer num2) {
        return z ? num : num2;
    }
}
