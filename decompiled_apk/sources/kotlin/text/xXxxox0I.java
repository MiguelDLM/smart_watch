package kotlin.text;

import java.util.Locale;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class xXxxox0I {
    @OXOo.OOXIXo
    public static final String oIX0oI(char c) {
        String valueOf = String.valueOf(c);
        IIX0o.x0XOIxOo(valueOf, "null cannot be cast to non-null type java.lang.String");
        Locale locale = Locale.ROOT;
        String upperCase = valueOf.toUpperCase(locale);
        IIX0o.oO(upperCase, "toUpperCase(...)");
        if (upperCase.length() > 1) {
            if (c != 329) {
                char charAt = upperCase.charAt(0);
                IIX0o.x0XOIxOo(upperCase, "null cannot be cast to non-null type java.lang.String");
                String substring = upperCase.substring(1);
                IIX0o.oO(substring, "substring(...)");
                IIX0o.x0XOIxOo(substring, "null cannot be cast to non-null type java.lang.String");
                String lowerCase = substring.toLowerCase(locale);
                IIX0o.oO(lowerCase, "toLowerCase(...)");
                return charAt + lowerCase;
            }
            return upperCase;
        }
        return String.valueOf(Character.toTitleCase(c));
    }
}
