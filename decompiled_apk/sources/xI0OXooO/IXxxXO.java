package xI0OXooO;

import java.lang.reflect.Array;

/* loaded from: classes6.dex */
public class IXxxXO implements OxxIIOOXO<Integer> {
    @Deprecated
    public CharSequence I0Io(CharSequence charSequence, CharSequence charSequence2) {
        return oxoX(charSequence, charSequence2);
    }

    @Override // xI0OXooO.OxxIIOOXO
    /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
    public Integer oIX0oI(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence != null && charSequence2 != null) {
            return Integer.valueOf(oxoX(charSequence, charSequence2).length());
        }
        throw new IllegalArgumentException("Inputs must not be null");
    }

    public int[][] X0o0xo(CharSequence charSequence, CharSequence charSequence2) {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, charSequence.length() + 1, charSequence2.length() + 1);
        for (int i = 0; i < charSequence.length(); i++) {
            for (int i2 = 0; i2 < charSequence2.length(); i2++) {
                if (i == 0) {
                    iArr[i][i2] = 0;
                }
                if (i2 == 0) {
                    iArr[i][i2] = 0;
                }
                if (charSequence.charAt(i) == charSequence2.charAt(i2)) {
                    iArr[i + 1][i2 + 1] = iArr[i][i2] + 1;
                } else {
                    int[] iArr2 = iArr[i + 1];
                    int i3 = i2 + 1;
                    iArr2[i3] = Math.max(iArr2[i2], iArr[i][i3]);
                }
            }
        }
        return iArr;
    }

    public CharSequence oxoX(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence != null && charSequence2 != null) {
            StringBuilder sb = new StringBuilder(Math.max(charSequence.length(), charSequence2.length()));
            int[][] X0o0xo2 = X0o0xo(charSequence, charSequence2);
            int length = charSequence.length() - 1;
            int length2 = charSequence2.length() - 1;
            int i = X0o0xo2[charSequence.length()][charSequence2.length()];
            while (true) {
                i--;
                while (i >= 0) {
                    if (charSequence.charAt(length) == charSequence2.charAt(length2)) {
                        break;
                    }
                    if (X0o0xo2[length + 1][length2] < X0o0xo2[length][length2 + 1]) {
                        length--;
                    } else {
                        length2--;
                    }
                }
                return sb.reverse().toString();
                sb.append(charSequence.charAt(length));
                length--;
                length2--;
            }
        } else {
            throw new IllegalArgumentException("Inputs must not be null");
        }
    }
}
