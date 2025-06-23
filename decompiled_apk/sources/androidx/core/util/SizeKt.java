package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.Size;
import android.util.SizeF;
import androidx.annotation.RequiresApi;

@SuppressLint({"ClassVerificationFailure"})
/* loaded from: classes.dex */
public final class SizeKt {
    @RequiresApi(21)
    public static final int component1(@OXOo.OOXIXo Size size) {
        return size.getWidth();
    }

    @RequiresApi(21)
    public static final int component2(@OXOo.OOXIXo Size size) {
        return size.getHeight();
    }

    @RequiresApi(21)
    public static final float component1(@OXOo.OOXIXo SizeF sizeF) {
        return sizeF.getWidth();
    }

    @RequiresApi(21)
    public static final float component2(@OXOo.OOXIXo SizeF sizeF) {
        return sizeF.getHeight();
    }

    public static final float component1(@OXOo.OOXIXo SizeFCompat sizeFCompat) {
        return sizeFCompat.getWidth();
    }

    public static final float component2(@OXOo.OOXIXo SizeFCompat sizeFCompat) {
        return sizeFCompat.getHeight();
    }
}
