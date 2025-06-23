package androidx.core.graphics;

import OXOo.OOXIXo;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;

public final class PorterDuffKt {
    @OOXIXo
    public static final PorterDuffColorFilter toColorFilter(@OOXIXo PorterDuff.Mode mode, int i) {
        return new PorterDuffColorFilter(i, mode);
    }

    @OOXIXo
    public static final PorterDuffXfermode toXfermode(@OOXIXo PorterDuff.Mode mode) {
        return new PorterDuffXfermode(mode);
    }
}
