package androidx.core.text;

import OXOo.OOXIXo;
import android.text.Spanned;
import android.text.SpannedString;
import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.internal.IIX0o;

public final class SpannedStringKt {
    public static /* synthetic */ Object[] getSpans$default(Spanned spanned, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = spanned.length();
        }
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        return spanned.getSpans(i, i2, Object.class);
    }

    @OOXIXo
    public static final Spanned toSpanned(@OOXIXo CharSequence charSequence) {
        return SpannedString.valueOf(charSequence);
    }
}
