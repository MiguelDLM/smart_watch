package org.apache.commons.lang3;

import XXO0.oIX0oI;
import java.util.Random;
import org.apache.commons.text.Oxx0IOOO;

/* loaded from: classes6.dex */
public class X00IoxXI {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final Random f32515oIX0oI = new Random();

    public static String I0Io(int i, int i2, int i3, boolean z, boolean z2, char... cArr) {
        return oxoX(i, i2, i3, z, z2, cArr, f32515oIX0oI);
    }

    public static String II0XooXoX(int i) {
        return XO(i, true, false);
    }

    public static String II0xO0(int i, int i2, int i3, boolean z, boolean z2) {
        return oxoX(i, i2, i3, z, z2, null, f32515oIX0oI);
    }

    public static String IXxxXO(int i) {
        return II0xO0(i, 32, 126, false, false);
    }

    public static String OOXIXo(int i, int i2) {
        return xoIox(IO.II0XooXoX(i, i2));
    }

    public static String Oo(int i, int i2) {
        return x0xO0oo(IO.II0XooXoX(i, i2));
    }

    public static String Oxx0IOOO(int i, char... cArr) {
        if (cArr == null) {
            return oxoX(i, 0, 0, false, false, null, f32515oIX0oI);
        }
        return oxoX(i, 0, cArr.length, false, false, cArr, f32515oIX0oI);
    }

    public static String Oxx0xo(int i, int i2) {
        return IXxxXO(IO.II0XooXoX(i, i2));
    }

    public static String X0o0xo(int i, String str) {
        if (str == null) {
            return oxoX(i, 0, 0, false, false, null, f32515oIX0oI);
        }
        return Oxx0IOOO(i, str.toCharArray());
    }

    public static String XO(int i, boolean z, boolean z2) {
        return II0xO0(i, 0, 0, z, z2);
    }

    public static String oIX0oI(int i) {
        return XO(i, false, false);
    }

    public static String oO(int i, int i2) {
        return x0XOIxOo(IO.II0XooXoX(i, i2));
    }

    public static String oOoXoXO(int i) {
        return II0xO0(i, 32, 127, false, false);
    }

    public static String ooOOo0oXI(int i, int i2) {
        return oOoXoXO(IO.II0XooXoX(i, i2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String oxoX(int i, int i2, int i3, boolean z, boolean z2, char[] cArr, Random random) {
        char c;
        if (i == 0) {
            return "";
        }
        if (i >= 0) {
            if (cArr != 0 && cArr.length == 0) {
                throw new IllegalArgumentException("The chars array must not be empty");
            }
            if (i2 == 0 && i3 == 0) {
                if (cArr != 0) {
                    i3 = cArr.length;
                } else if (!z && !z2) {
                    i3 = Oxx0IOOO.II0xO0.f33030OxxIIOOXO;
                } else {
                    i3 = 123;
                    i2 = 32;
                }
            } else if (i3 <= i2) {
                throw new IllegalArgumentException("Parameter end (" + i3 + ") must be greater than start (" + i2 + oIX0oI.I0Io.f4095I0Io);
            }
            if (cArr == 0 && ((z2 && i3 <= 48) || (z && i3 <= 65))) {
                throw new IllegalArgumentException("Parameter end (" + i3 + ") must be greater then (48) for generating digits or greater then (65) for generating letters.");
            }
            StringBuilder sb = new StringBuilder(i);
            int i4 = i3 - i2;
            while (true) {
                int i5 = i - 1;
                if (i != 0) {
                    if (cArr == 0) {
                        c = random.nextInt(i4) + i2;
                        int type = Character.getType(c);
                        if (type != 0 && type != 18 && type != 19) {
                        }
                    } else {
                        c = cArr[random.nextInt(i4) + i2];
                    }
                    int charCount = Character.charCount(c);
                    if (i5 != 0 || charCount <= 1) {
                        if ((z && Character.isLetter(c)) || ((z2 && Character.isDigit(c)) || (!z && !z2))) {
                            sb.appendCodePoint(c);
                            if (charCount == 2) {
                                i -= 2;
                            } else {
                                i = i5;
                            }
                        }
                    }
                } else {
                    return sb.toString();
                }
            }
        } else {
            throw new IllegalArgumentException("Requested random string length " + i + " is less than 0.");
        }
    }

    public static String x0XOIxOo(int i) {
        return II0xO0(i, 33, 126, false, false);
    }

    public static String x0xO0oo(int i) {
        return XO(i, false, true);
    }

    public static String xoIox(int i) {
        return XO(i, true, true);
    }

    public static String xxIXOIIO(int i, int i2) {
        return II0XooXoX(IO.II0XooXoX(i, i2));
    }
}
