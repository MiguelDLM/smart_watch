package androidx.core.graphics;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;

/* loaded from: classes.dex */
public final class PorterDuffKt {
    @OXOo.OOXIXo
    public static final PorterDuffColorFilter toColorFilter(@OXOo.OOXIXo PorterDuff.Mode mode, int i) {
        return new PorterDuffColorFilter(i, mode);
    }

    @OXOo.OOXIXo
    public static final PorterDuffXfermode toXfermode(@OXOo.OOXIXo PorterDuff.Mode mode) {
        return new PorterDuffXfermode(mode);
    }
}
