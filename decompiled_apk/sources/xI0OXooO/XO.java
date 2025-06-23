package xI0OXooO;

import java.util.Locale;

/* loaded from: classes6.dex */
public class XO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Locale f34128oIX0oI;

    public XO(Locale locale) {
        if (locale != null) {
            this.f34128oIX0oI = locale;
            return;
        }
        throw new IllegalArgumentException("Locale must not be null");
    }

    public Locale II0xO0() {
        return this.f34128oIX0oI;
    }

    public Integer oIX0oI(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence != null && charSequence2 != null) {
            String lowerCase = charSequence.toString().toLowerCase(this.f34128oIX0oI);
            String lowerCase2 = charSequence2.toString().toLowerCase(this.f34128oIX0oI);
            int i = Integer.MIN_VALUE;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < lowerCase2.length(); i4++) {
                char charAt = lowerCase2.charAt(i4);
                boolean z = false;
                while (i3 < lowerCase.length() && !z) {
                    if (charAt == lowerCase.charAt(i3)) {
                        int i5 = i2 + 1;
                        if (i + 1 == i3) {
                            i5 = i2 + 3;
                        }
                        i = i3;
                        i2 = i5;
                        z = true;
                    }
                    i3++;
                }
            }
            return Integer.valueOf(i2);
        }
        throw new IllegalArgumentException("CharSequences must not be null");
    }
}
