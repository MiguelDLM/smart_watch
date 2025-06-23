package androidx.work.impl.constraints.trackers;

import OXOo.OOXIXo;
import androidx.work.Logger;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class BatteryNotLowTrackerKt {
    public static final float BATTERY_LOW_THRESHOLD = 0.15f;

    @OOXIXo
    private static final String TAG;

    static {
        String tagWithPrefix = Logger.tagWithPrefix("BatteryNotLowTracker");
        IIX0o.oO(tagWithPrefix, "tagWithPrefix(\"BatteryNotLowTracker\")");
        TAG = tagWithPrefix;
    }
}
