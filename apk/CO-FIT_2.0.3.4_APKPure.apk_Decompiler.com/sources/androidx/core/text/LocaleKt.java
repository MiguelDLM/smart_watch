package androidx.core.text;

import OXOo.OOXIXo;
import android.text.TextUtils;
import java.util.Locale;

public final class LocaleKt {
    public static final int getLayoutDirection(@OOXIXo Locale locale) {
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }
}
