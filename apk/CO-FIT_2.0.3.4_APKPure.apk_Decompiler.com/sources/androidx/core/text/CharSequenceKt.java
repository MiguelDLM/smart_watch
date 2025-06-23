package androidx.core.text;

import OXOo.OOXIXo;
import android.text.TextUtils;

public final class CharSequenceKt {
    public static final boolean isDigitsOnly(@OOXIXo CharSequence charSequence) {
        return TextUtils.isDigitsOnly(charSequence);
    }

    public static final int trimmedLength(@OOXIXo CharSequence charSequence) {
        return TextUtils.getTrimmedLength(charSequence);
    }
}
