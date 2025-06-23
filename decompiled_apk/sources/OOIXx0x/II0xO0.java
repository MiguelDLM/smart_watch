package OOIXx0x;

import android.text.InputFilter;
import android.text.Spanned;

/* loaded from: classes13.dex */
public class II0xO0 implements InputFilter {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public StringBuilder f1718oIX0oI = new StringBuilder(32);

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        StringBuilder sb = this.f1718oIX0oI;
        sb.delete(0, sb.length());
        int length = charSequence.length();
        for (int i5 = 0; i5 < length; i5++) {
            char charAt = charSequence.charAt(i5);
            boolean z = true;
            if ((charAt < '0' || charAt > '9') && (charAt < 'A' || charAt > 'F')) {
                if (charAt >= 'a' && charAt <= 'f') {
                    charAt = (char) (charAt - ' ');
                } else {
                    z = false;
                }
            }
            if (z) {
                this.f1718oIX0oI.append(charAt);
            }
        }
        return this.f1718oIX0oI;
    }
}
