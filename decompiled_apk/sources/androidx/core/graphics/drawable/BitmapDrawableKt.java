package androidx.core.graphics.drawable;

import OXOo.OOXIXo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

/* loaded from: classes.dex */
public final class BitmapDrawableKt {
    @OOXIXo
    public static final BitmapDrawable toDrawable(@OOXIXo Bitmap bitmap, @OOXIXo Resources resources) {
        return new BitmapDrawable(resources, bitmap);
    }
}
