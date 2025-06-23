package xI0OXooO;

import java.util.Arrays;
import org.apache.commons.lang3.xXOx;

/* loaded from: classes6.dex */
public class ooOOo0oXI implements OxxIIOOXO<Double> {
    public static int[] I0Io(CharSequence charSequence, CharSequence charSequence2) {
        CharSequence charSequence3;
        CharSequence charSequence4;
        if (charSequence.length() > charSequence2.length()) {
            charSequence4 = charSequence;
            charSequence3 = charSequence2;
        } else {
            charSequence3 = charSequence;
            charSequence4 = charSequence2;
        }
        int max = Math.max((charSequence4.length() / 2) - 1, 0);
        int[] iArr = new int[charSequence3.length()];
        Arrays.fill(iArr, -1);
        boolean[] zArr = new boolean[charSequence4.length()];
        int i = 0;
        for (int i2 = 0; i2 < charSequence3.length(); i2++) {
            char charAt = charSequence3.charAt(i2);
            int max2 = Math.max(i2 - max, 0);
            int min = Math.min(i2 + max + 1, charSequence4.length());
            while (true) {
                if (max2 >= min) {
                    break;
                }
                if (!zArr[max2] && charAt == charSequence4.charAt(max2)) {
                    iArr[i2] = max2;
                    zArr[max2] = true;
                    i++;
                    break;
                }
                max2++;
            }
        }
        char[] cArr = new char[i];
        char[] cArr2 = new char[i];
        int i3 = 0;
        for (int i4 = 0; i4 < charSequence3.length(); i4++) {
            if (iArr[i4] != -1) {
                cArr[i3] = charSequence3.charAt(i4);
                i3++;
            }
        }
        int i5 = 0;
        for (int i6 = 0; i6 < charSequence4.length(); i6++) {
            if (zArr[i6]) {
                cArr2[i5] = charSequence4.charAt(i6);
                i5++;
            }
        }
        int i7 = 0;
        for (int i8 = 0; i8 < i; i8++) {
            if (cArr[i8] != cArr2[i8]) {
                i7++;
            }
        }
        int i9 = 0;
        for (int i10 = 0; i10 < Math.min(4, charSequence3.length()) && charSequence.charAt(i10) == charSequence2.charAt(i10); i10++) {
            i9++;
        }
        return new int[]{i, i7, i9};
    }

    @Override // xI0OXooO.OxxIIOOXO
    /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
    public Double oIX0oI(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence != null && charSequence2 != null) {
            if (xXOx.x0o(charSequence, charSequence2)) {
                return Double.valueOf(1.0d);
            }
            double d = I0Io(charSequence, charSequence2)[0];
            if (d == XIXIX.OOXIXo.f3760XO) {
                return Double.valueOf(XIXIX.OOXIXo.f3760XO);
            }
            double length = (((d / charSequence.length()) + (d / charSequence2.length())) + ((d - (r0[1] / 2.0d)) / d)) / 3.0d;
            if (length >= 0.7d) {
                length += r0[2] * 0.1d * (1.0d - length);
            }
            return Double.valueOf(length);
        }
        throw new IllegalArgumentException("CharSequences must not be null");
    }
}
