package kotlin.text;

import kotlin.IIX0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oxxXoxO;

@XX({"SMAP\nChar.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Char.kt\nkotlin/text/CharsKt__CharKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,344:1\n1#2:345\n*E\n"})
/* loaded from: classes6.dex */
public class I0Io extends II0xO0 {
    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @oxxXoxO(version = "1.5")
    public static final int IIX0o(char c, int i) {
        Integer xI2 = xI(c, i);
        if (xI2 != null) {
            return xI2.intValue();
        }
        throw new IllegalArgumentException("Char " + c + " is not a digit in the given radix=" + i);
    }

    public static final boolean IoOoX(char c) {
        return new X0.I0Io((char) 55296, (char) 57343).xxIXOIIO(c);
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = "1.5")
    public static String Xx000oIo(char c) {
        return xXxxox0I.oIX0oI(c);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @oxxXoxO(version = "1.5")
    public static final char XxX0x0xxx(int i, int i2) {
        int i3;
        if (new X0.oOoXoXO(2, 36).xxIXOIIO(i2)) {
            if (i >= 0 && i < i2) {
                if (i < 10) {
                    i3 = i + 48;
                } else {
                    i3 = ((char) (i + 65)) - '\n';
                }
                return (char) i3;
            }
            throw new IllegalArgumentException("Digit " + i + " does not represent a valid digit in radix " + i2);
        }
        throw new IllegalArgumentException("Invalid radix: " + i2 + ". Valid radix values are in range 2..36");
    }

    @xx0o0O.XO
    public static final String oOXoIIIo(char c, String other) {
        IIX0o.x0xO0oo(other, "other");
        return c + other;
    }

    public static /* synthetic */ boolean oo(char c, char c2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return oo0xXOI0I(c, c2, z);
    }

    public static final boolean oo0xXOI0I(char c, char c2, boolean z) {
        if (c == c2) {
            return true;
        }
        if (!z) {
            return false;
        }
        char upperCase = Character.toUpperCase(c);
        char upperCase2 = Character.toUpperCase(c2);
        if (upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2)) {
            return true;
        }
        return false;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @oxxXoxO(version = "1.5")
    @OXOo.oOoXoXO
    public static final Integer ooXIXxIX(char c) {
        Integer valueOf = Integer.valueOf(II0xO0.II0xO0(c, 10));
        if (valueOf.intValue() < 0) {
            return null;
        }
        return valueOf;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @oxxXoxO(version = "1.5")
    @OXOo.oOoXoXO
    public static final Integer xI(char c, int i) {
        II0xO0.oIX0oI(i);
        Integer valueOf = Integer.valueOf(II0xO0.II0xO0(c, i));
        if (valueOf.intValue() < 0) {
            return null;
        }
        return valueOf;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @oxxXoxO(version = "1.5")
    public static int xXxxox0I(char c) {
        int II0xO02 = II0xO0.II0xO0(c, 10);
        if (II0xO02 >= 0) {
            return II0xO02;
        }
        throw new IllegalArgumentException("Char " + c + " is not a decimal digit");
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @oxxXoxO(version = "1.5")
    public static final char xxX(int i) {
        if (new X0.oOoXoXO(0, 9).xxIXOIIO(i)) {
            return (char) (i + 48);
        }
        throw new IllegalArgumentException("Int " + i + " is not a decimal digit");
    }
}
