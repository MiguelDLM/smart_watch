package xI0OXooO;

/* loaded from: classes6.dex */
public class Oxx0xo implements oxoX<Integer> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final IXxxXO f34125oIX0oI = new IXxxXO();

    @Override // xI0OXooO.oxoX, xI0OXooO.OxxIIOOXO
    /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
    public Integer oIX0oI(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence != null && charSequence2 != null) {
            return Integer.valueOf((charSequence.length() + charSequence2.length()) - (this.f34125oIX0oI.oIX0oI(charSequence, charSequence2).intValue() * 2));
        }
        throw new IllegalArgumentException("Inputs must not be null");
    }
}
