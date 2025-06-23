package androidx.work.impl.utils;

import OXOo.OOXIXo;
import XO0OX.xxIXOIIO;
import android.content.Context;
import android.os.PowerManager;
import androidx.work.Logger;
import com.huawei.openalliance.ad.constant.bn;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nWakeLocks.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WakeLocks.kt\nandroidx/work/impl/utils/WakeLocks\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,71:1\n1#2:72\n215#3,2:73\n*S KotlinDebug\n*F\n+ 1 WakeLocks.kt\nandroidx/work/impl/utils/WakeLocks\n*L\n63#1:73,2\n*E\n"})
@xxIXOIIO(name = "WakeLocks")
public final class WakeLocks {
    @OOXIXo
    private static final String TAG;

    static {
        String tagWithPrefix = Logger.tagWithPrefix("WakeLocks");
        IIX0o.oO(tagWithPrefix, "tagWithPrefix(\"WakeLocks\")");
        TAG = tagWithPrefix;
    }

    public static final void checkWakeLocks() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        WakeLocksHolder wakeLocksHolder = WakeLocksHolder.INSTANCE;
        synchronized (wakeLocksHolder) {
            linkedHashMap.putAll(wakeLocksHolder.getWakeLocks());
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            PowerManager.WakeLock wakeLock = (PowerManager.WakeLock) entry.getKey();
            String str = (String) entry.getValue();
            if (wakeLock != null && wakeLock.isHeld()) {
                Logger logger = Logger.get();
                String str2 = TAG;
                logger.warning(str2, "WakeLock held for " + str);
            }
        }
    }

    @OOXIXo
    public static final PowerManager.WakeLock newWakeLock(@OOXIXo Context context, @OOXIXo String str) {
        IIX0o.x0xO0oo(context, bn.f.o);
        IIX0o.x0xO0oo(str, "tag");
        Object systemService = context.getApplicationContext().getSystemService("power");
        IIX0o.x0XOIxOo(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        String str2 = "WorkManager: " + str;
        PowerManager.WakeLock newWakeLock = ((PowerManager) systemService).newWakeLock(1, str2);
        WakeLocksHolder wakeLocksHolder = WakeLocksHolder.INSTANCE;
        synchronized (wakeLocksHolder) {
            String put = wakeLocksHolder.getWakeLocks().put(newWakeLock, str2);
        }
        IIX0o.oO(newWakeLock, "wakeLock");
        return newWakeLock;
    }
}
