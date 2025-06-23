package androidx.core.util;

import OXOo.OOXIXo;
import android.annotation.SuppressLint;
import android.util.Size;
import android.util.SizeF;
import androidx.annotation.RequiresApi;

@SuppressLint({"ClassVerificationFailure"})
public final class SizeKt {
    @RequiresApi(21)
    public static final int component1(@OOXIXo Size size) {
        return size.getWidth();
    }

    @RequiresApi(21)
    public static final int component2(@OOXIXo Size size) {
        return size.getHeight();
    }

    @RequiresApi(21)
    public static final float component1(@OOXIXo SizeF sizeF) {
        return sizeF.getWidth();
    }

    @RequiresApi(21)
    public static final float component2(@OOXIXo SizeF sizeF) {
        return sizeF.getHeight();
    }

    public static final float component1(@OOXIXo SizeFCompat sizeFCompat) {
        return sizeFCompat.getWidth();
    }

    public static final float component2(@OOXIXo SizeFCompat sizeFCompat) {
        return sizeFCompat.getHeight();
    }
}
