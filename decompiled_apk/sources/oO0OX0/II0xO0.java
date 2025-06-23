package oO0OX0;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;

@Deprecated
/* loaded from: classes6.dex */
public abstract class II0xO0 {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final char[] f31965oIX0oI = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String oIX0oI(int i) {
        return Integer.toHexString(i).toUpperCase(Locale.ENGLISH);
    }

    public final String I0Io(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter(charSequence.length() * 2);
            oxoX(charSequence, stringWriter);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public abstract int II0xO0(CharSequence charSequence, int i, Writer writer) throws IOException;

    public final II0xO0 X0o0xo(II0xO0... iI0xO0Arr) {
        II0xO0[] iI0xO0Arr2 = new II0xO0[iI0xO0Arr.length + 1];
        iI0xO0Arr2[0] = this;
        System.arraycopy(iI0xO0Arr, 0, iI0xO0Arr2, 1, iI0xO0Arr.length);
        return new oIX0oI(iI0xO0Arr2);
    }

    public final void oxoX(CharSequence charSequence, Writer writer) throws IOException {
        if (writer != null) {
            if (charSequence == null) {
                return;
            }
            int length = charSequence.length();
            int i = 0;
            while (i < length) {
                int II0xO02 = II0xO0(charSequence, i, writer);
                if (II0xO02 == 0) {
                    char charAt = charSequence.charAt(i);
                    writer.write(charAt);
                    int i2 = i + 1;
                    if (Character.isHighSurrogate(charAt) && i2 < length) {
                        char charAt2 = charSequence.charAt(i2);
                        if (Character.isLowSurrogate(charAt2)) {
                            writer.write(charAt2);
                            i += 2;
                        }
                    }
                    i = i2;
                } else {
                    for (int i3 = 0; i3 < II0xO02; i3++) {
                        i += Character.charCount(Character.codePointAt(charSequence, i));
                    }
                }
            }
            return;
        }
        throw new IllegalArgumentException("The Writer must not be null");
    }
}
