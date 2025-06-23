package XOx;

/* loaded from: classes6.dex */
public final class II0xO0 {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f3943oIX0oI = -1;

    public static int I0Io(CharSequence charSequence, CharSequence charSequence2) {
        int i = 0;
        if (XO(charSequence) || XO(charSequence2)) {
            return 0;
        }
        int i2 = 0;
        while (true) {
            int X0o0xo2 = X0o0xo(charSequence, charSequence2, i);
            if (X0o0xo2 == -1) {
                return i2;
            }
            i2++;
            i = X0o0xo2 + charSequence2.length();
        }
    }

    public static char[] II0XooXoX(CharSequence charSequence) {
        if (charSequence instanceof String) {
            return ((String) charSequence).toCharArray();
        }
        int length = charSequence.length();
        char[] cArr = new char[charSequence.length()];
        for (int i = 0; i < length; i++) {
            cArr[i] = charSequence.charAt(i);
        }
        return cArr;
    }

    public static boolean II0xO0(CharSequence charSequence, char[] cArr) {
        if (XO(charSequence) || Oxx0IOOO(cArr)) {
            return false;
        }
        int length = charSequence.length();
        int length2 = cArr.length;
        int i = length - 1;
        int i2 = length2 - 1;
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = charSequence.charAt(i3);
            for (int i4 = 0; i4 < length2; i4++) {
                if (cArr[i4] == charAt) {
                    if (!Character.isHighSurrogate(charAt) || i4 == i2) {
                        return true;
                    }
                    if (i3 < i && cArr[i4 + 1] == charSequence.charAt(i3 + 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean Oxx0IOOO(char[] cArr) {
        if (cArr != null && cArr.length != 0) {
            return false;
        }
        return true;
    }

    public static int X0o0xo(CharSequence charSequence, CharSequence charSequence2, int i) {
        return charSequence.toString().indexOf(charSequence2.toString(), i);
    }

    public static boolean XO(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() != 0) {
            return false;
        }
        return true;
    }

    public static boolean oIX0oI(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence2 == null) {
            return false;
        }
        return II0xO0(charSequence, II0XooXoX(charSequence2));
    }

    public static boolean oxoX(CharSequence charSequence, CharSequence[] charSequenceArr) {
        boolean z;
        if (charSequence == null && charSequenceArr == null) {
            z = true;
        } else {
            z = false;
        }
        if (charSequenceArr != null) {
            for (CharSequence charSequence2 : charSequenceArr) {
                if (!z && !charSequence2.equals(charSequence)) {
                    z = false;
                } else {
                    z = true;
                }
            }
        }
        return z;
    }
}
