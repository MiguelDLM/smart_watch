package org.apache.commons.text;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.util.Formattable;
import java.util.Formatter;

/* loaded from: classes6.dex */
public class XO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final String f33047oIX0oI = "%s";

    public static Formatter I0Io(CharSequence charSequence, Formatter formatter, int i, int i2, int i3, char c, CharSequence charSequence2) {
        boolean z;
        int i4;
        if (charSequence2 != null && i3 >= 0 && charSequence2.length() > i3) {
            throw new IllegalArgumentException(String.format("Specified ellipsis '%s' exceeds precision of %s", charSequence2, Integer.valueOf(i3)));
        }
        StringBuilder sb = new StringBuilder(charSequence);
        if (i3 >= 0 && i3 < charSequence.length()) {
            if (charSequence2 == null) {
                charSequence2 = "";
            }
            sb.replace(i3 - charSequence2.length(), charSequence.length(), charSequence2.toString());
        }
        if ((i & 1) == 1) {
            z = true;
        } else {
            z = false;
        }
        for (int length = sb.length(); length < i2; length++) {
            if (z) {
                i4 = length;
            } else {
                i4 = 0;
            }
            sb.insert(i4, c);
        }
        formatter.format(sb.toString(), new Object[0]);
        return formatter;
    }

    public static Formatter II0xO0(CharSequence charSequence, Formatter formatter, int i, int i2, int i3, char c) {
        return I0Io(charSequence, formatter, i, i2, i3, c, null);
    }

    public static String X0o0xo(Formattable formattable) {
        return String.format("%s", formattable);
    }

    public static Formatter oIX0oI(CharSequence charSequence, Formatter formatter, int i, int i2, int i3) {
        return I0Io(charSequence, formatter, i, i2, i3, TokenParser.SP, null);
    }

    public static Formatter oxoX(CharSequence charSequence, Formatter formatter, int i, int i2, int i3, CharSequence charSequence2) {
        return I0Io(charSequence, formatter, i, i2, i3, TokenParser.SP, charSequence2);
    }
}
