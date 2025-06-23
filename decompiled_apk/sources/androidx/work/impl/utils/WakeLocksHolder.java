package androidx.work.impl.utils;

import android.os.PowerManager;
import java.util.WeakHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class WakeLocksHolder {

    @OXOo.OOXIXo
    public static final WakeLocksHolder INSTANCE = new WakeLocksHolder();

    @OXOo.OOXIXo
    private static final WeakHashMap<PowerManager.WakeLock, String> wakeLocks = new WeakHashMap<>();

    private WakeLocksHolder() {
    }

    @OXOo.OOXIXo
    public final WeakHashMap<PowerManager.WakeLock, String> getWakeLocks() {
        return wakeLocks;
    }
}
