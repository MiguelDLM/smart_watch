package androidx.activity;

import android.window.BackEvent;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.IIX0o;

@RequiresApi(34)
/* loaded from: classes.dex */
public final class Api34Impl {

    @OXOo.OOXIXo
    public static final Api34Impl INSTANCE = new Api34Impl();

    private Api34Impl() {
    }

    @OXOo.OOXIXo
    public final BackEvent createOnBackEvent(float f, float f2, float f3, int i) {
        return new BackEvent(f, f2, f3, i);
    }

    public final float progress(@OXOo.OOXIXo BackEvent backEvent) {
        IIX0o.x0xO0oo(backEvent, "backEvent");
        return backEvent.getProgress();
    }

    public final int swipeEdge(@OXOo.OOXIXo BackEvent backEvent) {
        IIX0o.x0xO0oo(backEvent, "backEvent");
        return backEvent.getSwipeEdge();
    }

    public final float touchX(@OXOo.OOXIXo BackEvent backEvent) {
        IIX0o.x0xO0oo(backEvent, "backEvent");
        return backEvent.getTouchX();
    }

    public final float touchY(@OXOo.OOXIXo BackEvent backEvent) {
        IIX0o.x0xO0oo(backEvent, "backEvent");
        return backEvent.getTouchY();
    }
}
