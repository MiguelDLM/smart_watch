package androidx.core.text;

import android.text.Spanned;
import android.text.SpannedString;
import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class SpannedStringKt {
    public static final /* synthetic */ <T> T[] getSpans(Spanned spanned, int i, int i2) {
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T[]) spanned.getSpans(i, i2, Object.class);
    }

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

    @OXOo.OOXIXo
    public static final Spanned toSpanned(@OXOo.OOXIXo CharSequence charSequence) {
        return SpannedString.valueOf(charSequence);
    }
}
