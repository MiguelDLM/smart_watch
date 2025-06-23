package xI0OXooO;

import java.util.Arrays;

/* loaded from: classes6.dex */
public class oO implements oxoX<Integer> {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final oO f34132II0xO0 = new oO();

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Integer f34133oIX0oI;

    public oO() {
        this(null);
    }

    public static oO I0Io() {
        return f34132II0xO0;
    }

    public static int X0o0xo(CharSequence charSequence, CharSequence charSequence2, int i) {
        int i2;
        int i3;
        CharSequence charSequence3;
        CharSequence charSequence4;
        int min;
        if (charSequence != null && charSequence2 != null) {
            if (i >= 0) {
                int length = charSequence.length();
                int length2 = charSequence2.length();
                if (length == 0) {
                    if (length2 > i) {
                        return -1;
                    }
                    return length2;
                }
                if (length2 == 0) {
                    if (length > i) {
                        return -1;
                    }
                    return length;
                }
                if (length > length2) {
                    i3 = charSequence.length();
                    i2 = length2;
                    charSequence4 = charSequence;
                    charSequence3 = charSequence2;
                } else {
                    i2 = length;
                    i3 = length2;
                    charSequence3 = charSequence;
                    charSequence4 = charSequence2;
                }
                if (i3 - i2 > i) {
                    return -1;
                }
                int i4 = i2 + 1;
                int[] iArr = new int[i4];
                int[] iArr2 = new int[i4];
                int min2 = Math.min(i2, i) + 1;
                char c = 0;
                for (int i5 = 0; i5 < min2; i5++) {
                    iArr[i5] = i5;
                }
                int i6 = Integer.MAX_VALUE;
                Arrays.fill(iArr, min2, i4, Integer.MAX_VALUE);
                Arrays.fill(iArr2, Integer.MAX_VALUE);
                int i7 = 1;
                while (i7 <= i3) {
                    char charAt = charSequence4.charAt(i7 - 1);
                    iArr2[c] = i7;
                    int max = Math.max(1, i7 - i);
                    if (i7 > i6 - i) {
                        min = i2;
                    } else {
                        min = Math.min(i2, i7 + i);
                    }
                    if (max > 1) {
                        iArr2[max - 1] = i6;
                    }
                    while (max <= min) {
                        int i8 = max - 1;
                        if (charSequence3.charAt(i8) == charAt) {
                            iArr2[max] = iArr[i8];
                        } else {
                            iArr2[max] = Math.min(Math.min(iArr2[i8], iArr[max]), iArr[i8]) + 1;
                        }
                        max++;
                    }
                    i7++;
                    c = 0;
                    i6 = Integer.MAX_VALUE;
                    int[] iArr3 = iArr2;
                    iArr2 = iArr;
                    iArr = iArr3;
                }
                int i9 = iArr[i2];
                if (i9 > i) {
                    return -1;
                }
                return i9;
            }
            throw new IllegalArgumentException("Threshold must not be negative");
        }
        throw new IllegalArgumentException("CharSequences must not be null");
    }

    public static int XO(CharSequence charSequence, CharSequence charSequence2) {
        int i;
        if (charSequence != null && charSequence2 != null) {
            int length = charSequence.length();
            int length2 = charSequence2.length();
            if (length == 0) {
                return length2;
            }
            if (length2 == 0) {
                return length;
            }
            if (length > length2) {
                length2 = charSequence.length();
                length = length2;
            } else {
                charSequence2 = charSequence;
                charSequence = charSequence2;
            }
            int[] iArr = new int[length + 1];
            for (int i2 = 0; i2 <= length; i2++) {
                iArr[i2] = i2;
            }
            for (int i3 = 1; i3 <= length2; i3++) {
                int i4 = iArr[0];
                char charAt = charSequence.charAt(i3 - 1);
                iArr[0] = i3;
                int i5 = 1;
                while (i5 <= length) {
                    int i6 = iArr[i5];
                    int i7 = i5 - 1;
                    if (charSequence2.charAt(i7) == charAt) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    iArr[i5] = Math.min(Math.min(iArr[i7] + 1, iArr[i5] + 1), i4 + i);
                    i5++;
                    i4 = i6;
                }
            }
            return iArr[length];
        }
        throw new IllegalArgumentException("CharSequences must not be null");
    }

    @Override // xI0OXooO.oxoX, xI0OXooO.OxxIIOOXO
    /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
    public Integer oIX0oI(CharSequence charSequence, CharSequence charSequence2) {
        Integer num = this.f34133oIX0oI;
        if (num != null) {
            return Integer.valueOf(X0o0xo(charSequence, charSequence2, num.intValue()));
        }
        return Integer.valueOf(XO(charSequence, charSequence2));
    }

    public Integer oxoX() {
        return this.f34133oIX0oI;
    }

    public oO(Integer num) {
        if (num != null && num.intValue() < 0) {
            throw new IllegalArgumentException("Threshold must not be negative");
        }
        this.f34133oIX0oI = num;
    }
}
