package xI0OXooO;

/* loaded from: classes6.dex */
public class Oxx0IOOO implements oxoX<Integer> {
    @Override // xI0OXooO.oxoX, xI0OXooO.OxxIIOOXO
    /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
    public Integer oIX0oI(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence != null && charSequence2 != null) {
            if (charSequence.length() == charSequence2.length()) {
                int i = 0;
                for (int i2 = 0; i2 < charSequence.length(); i2++) {
                    if (charSequence.charAt(i2) != charSequence2.charAt(i2)) {
                        i++;
                    }
                }
                return Integer.valueOf(i);
            }
            throw new IllegalArgumentException("CharSequences must have the same length");
        }
        throw new IllegalArgumentException("CharSequences must not be null");
    }
}
