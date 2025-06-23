package kotlin.text;

import java.util.Locale;
import kotlin.IIX0;
import kotlin.XX;
import kotlin.jvm.internal.IIX0o;
import kotlin.o0;
import kotlin.oxxXoxO;

/* loaded from: classes6.dex */
public class II0xO0 {
    @OXOo.OOXIXo
    public static final CharCategory I0Io(char c) {
        return CharCategory.Companion.oIX0oI(Character.getType(c));
    }

    @xx0o0O.XO
    public static final boolean II0XooXoX(char c) {
        return Character.isISOControl(c);
    }

    public static final int II0xO0(char c, int i) {
        return Character.digit((int) c, i);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @OXOo.OOXIXo
    @oxxXoxO(version = "1.5")
    public static final String IIXOooo(char c, @OXOo.OOXIXo Locale locale) {
        IIX0o.x0xO0oo(locale, "locale");
        String XI0IXoo2 = XI0IXoo(c, locale);
        if (XI0IXoo2.length() > 1) {
            if (c != 329) {
                char charAt = XI0IXoo2.charAt(0);
                IIX0o.x0XOIxOo(XI0IXoo2, "null cannot be cast to non-null type java.lang.String");
                String substring = XI0IXoo2.substring(1);
                IIX0o.oO(substring, "substring(...)");
                IIX0o.x0XOIxOo(substring, "null cannot be cast to non-null type java.lang.String");
                String lowerCase = substring.toLowerCase(Locale.ROOT);
                IIX0o.oO(lowerCase, "toLowerCase(...)");
                return charAt + lowerCase;
            }
            return XI0IXoo2;
        }
        String valueOf = String.valueOf(c);
        IIX0o.x0XOIxOo(valueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = valueOf.toUpperCase(Locale.ROOT);
        IIX0o.oO(upperCase, "toUpperCase(...)");
        if (!IIX0o.Oxx0IOOO(XI0IXoo2, upperCase)) {
            return XI0IXoo2;
        }
        return String.valueOf(Character.toTitleCase(c));
    }

    public static final boolean IXxxXO(char c) {
        if (!Character.isWhitespace(c) && !Character.isSpaceChar(c)) {
            return false;
        }
        return true;
    }

    @kotlin.OOXIXo(message = "Use uppercaseChar() instead.", replaceWith = @XX(expression = "uppercaseChar()", imports = {}))
    @xx0o0O.XO
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final char O0xOxO(char c) {
        return Character.toUpperCase(c);
    }

    @xx0o0O.XO
    public static final boolean OOXIXo(char c) {
        return Character.isJavaIdentifierStart(c);
    }

    @xx0o0O.XO
    public static final boolean Oo(char c) {
        return Character.isUpperCase(c);
    }

    @kotlin.OOXIXo(message = "Use titlecaseChar() instead.", replaceWith = @XX(expression = "titlecaseChar()", imports = {}))
    @xx0o0O.XO
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final char OxI(char c) {
        return Character.toTitleCase(c);
    }

    @xx0o0O.XO
    public static final boolean Oxx0IOOO(char c) {
        return Character.isHighSurrogate(c);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final String Oxx0xo(char c) {
        String valueOf = String.valueOf(c);
        IIX0o.x0XOIxOo(valueOf, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = valueOf.toLowerCase(Locale.ROOT);
        IIX0o.oO(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final char OxxIIOOXO(char c) {
        return Character.toLowerCase(c);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final String X0IIOO(char c) {
        String valueOf = String.valueOf(c);
        IIX0o.x0XOIxOo(valueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = valueOf.toUpperCase(Locale.ROOT);
        IIX0o.oO(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    @xx0o0O.XO
    public static final boolean X0o0xo(char c) {
        return Character.isDefined(c);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @OXOo.OOXIXo
    @oxxXoxO(version = "1.5")
    public static final String XI0IXoo(char c, @OXOo.OOXIXo Locale locale) {
        IIX0o.x0xO0oo(locale, "locale");
        String valueOf = String.valueOf(c);
        IIX0o.x0XOIxOo(valueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = valueOf.toUpperCase(locale);
        IIX0o.oO(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final char XIxXXX0x0(char c) {
        return Character.toUpperCase(c);
    }

    @xx0o0O.XO
    public static final boolean XO(char c) {
        return Character.isDigit(c);
    }

    @kotlin.OOXIXo(message = "Use lowercaseChar() instead.", replaceWith = @XX(expression = "lowercaseChar()", imports = {}))
    @xx0o0O.XO
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final char o00(char c) {
        return Character.toLowerCase(c);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @OXOo.OOXIXo
    @oxxXoxO(version = "1.5")
    public static final String oI0IIXIo(char c, @OXOo.OOXIXo Locale locale) {
        IIX0o.x0xO0oo(locale, "locale");
        String valueOf = String.valueOf(c);
        IIX0o.x0XOIxOo(valueOf, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = valueOf.toLowerCase(locale);
        IIX0o.oO(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    @o0
    public static int oIX0oI(int i) {
        if (new X0.oOoXoXO(2, 36).xxIXOIIO(i)) {
            return i;
        }
        throw new IllegalArgumentException("radix " + i + " was not in valid range " + new X0.oOoXoXO(2, 36));
    }

    @xx0o0O.XO
    public static final boolean oO(char c) {
        return Character.isLowerCase(c);
    }

    @xx0o0O.XO
    public static final boolean oOoXoXO(char c) {
        return Character.isLetter(c);
    }

    @xx0o0O.XO
    public static final boolean ooOOo0oXI(char c) {
        return Character.isLetterOrDigit(c);
    }

    @OXOo.OOXIXo
    public static final CharDirectionality oxoX(char c) {
        return CharDirectionality.Companion.II0xO0(Character.getDirectionality(c));
    }

    @xx0o0O.XO
    public static final boolean x0XOIxOo(char c) {
        return Character.isLowSurrogate(c);
    }

    @xx0o0O.XO
    public static final boolean x0xO0oo(char c) {
        return Character.isTitleCase(c);
    }

    @xx0o0O.XO
    public static final boolean xoIox(char c) {
        return Character.isJavaIdentifierPart(c);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final char xoXoI(char c) {
        return Character.toTitleCase(c);
    }

    @xx0o0O.XO
    public static final boolean xxIXOIIO(char c) {
        return Character.isIdentifierIgnorable(c);
    }
}
