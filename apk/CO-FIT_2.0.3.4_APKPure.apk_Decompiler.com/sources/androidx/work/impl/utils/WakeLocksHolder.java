package androidx.work.impl.utils;

import OXOo.OOXIXo;
import android.os.PowerManager;
import java.util.WeakHashMap;

final class WakeLocksHolder {
    @OOXIXo
    public static final WakeLocksHolder INSTANCE = new WakeLocksHolder();
    @OOXIXo
    private static final WeakHashMap<PowerManager.WakeLock, String> wakeLocks = new WeakHashMap<>();

    private WakeLocksHolder() {
    }

    @OOXIXo
    public final WeakHashMap<PowerManager.WakeLock, String> getWakeLocks() {
        return wakeLocks;
    }
}
