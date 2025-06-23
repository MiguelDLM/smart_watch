package xI0OXooO;

import java.util.HashSet;

/* loaded from: classes6.dex */
public class OOXIXo implements OxxIIOOXO<Double> {
    public final Double I0Io(CharSequence charSequence, CharSequence charSequence2) {
        int length = charSequence.length();
        int length2 = charSequence2.length();
        if (length != 0 && length2 != 0) {
            HashSet hashSet = new HashSet();
            for (int i = 0; i < length; i++) {
                hashSet.add(Character.valueOf(charSequence.charAt(i)));
            }
            HashSet hashSet2 = new HashSet();
            for (int i2 = 0; i2 < length2; i2++) {
                hashSet2.add(Character.valueOf(charSequence2.charAt(i2)));
            }
            new HashSet(hashSet).addAll(hashSet2);
            return Double.valueOf((((hashSet.size() + hashSet2.size()) - r8.size()) * 1.0d) / r8.size());
        }
        return Double.valueOf(XIXIX.OOXIXo.f3760XO);
    }

    @Override // xI0OXooO.OxxIIOOXO
    /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
    public Double oIX0oI(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence != null && charSequence2 != null) {
            return I0Io(charSequence, charSequence2);
        }
        throw new IllegalArgumentException("Input cannot be null");
    }
}
