package org.apache.commons.lang3.text;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.util.Formattable;
import java.util.Formatter;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.xoIxX;

@Deprecated
/* loaded from: classes6.dex */
public class II0xO0 {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final String f32776oIX0oI = "%s";

    public static Formatter I0Io(CharSequence charSequence, Formatter formatter, int i, int i2, int i3, char c, CharSequence charSequence2) {
        boolean z;
        boolean z2;
        int i4;
        if (charSequence2 != null && i3 >= 0 && charSequence2.length() > i3) {
            z = false;
        } else {
            z = true;
        }
        xoIxX.XI0IXoo(z, "Specified ellipsis '%1$s' exceeds precision of %2$s", charSequence2, Integer.valueOf(i3));
        StringBuilder sb = new StringBuilder(charSequence);
        if (i3 >= 0 && i3 < charSequence.length()) {
            CharSequence charSequence3 = (CharSequence) ObjectUtils.oI0IIXIo(charSequence2, "");
            sb.replace(i3 - charSequence3.length(), charSequence.length(), charSequence3.toString());
        }
        if ((i & 1) == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        for (int length = sb.length(); length < i2; length++) {
            if (z2) {
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
