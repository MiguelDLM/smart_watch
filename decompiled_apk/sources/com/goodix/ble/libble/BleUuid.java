package com.goodix.ble.libble;

import android.util.SparseArray;
import com.szabh.smable3.entity.BleWatchFaceId;
import java.util.HashMap;
import java.util.UUID;

/* loaded from: classes9.dex */
public class BleUuid {
    public static final UUID CCCD = from(10498);
    public static final UUID GENERIC_ATTRIBUTE_SERVICE = from(6145);
    public static final UUID SERVICE_CHANGED_CHARACTERISTIC = from(10757);

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, UUID> f16140a;
    private static SparseArray<UUID> b;

    public static synchronized UUID from(int i) {
        UUID uuid;
        synchronized (BleUuid.class) {
            try {
                if (b == null) {
                    b = new SparseArray<>(64);
                }
                uuid = b.get(i);
                if (uuid == null) {
                    uuid = new UUID((i << 32) | 4096, -9223371485494954757L);
                    b.put(i, uuid);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return uuid;
    }

    public static int get16bit32bitUuid(UUID uuid) {
        if (uuid != null) {
            return (int) ((uuid.getMostSignificantBits() >> 32) & BleWatchFaceId.WATCHFACE_ID_INVALID);
        }
        return 0;
    }

    public static boolean is16bit32bitUuid(UUID uuid) {
        return uuid != null && uuid.getLeastSignificantBits() == -9223371485494954757L && (uuid.getMostSignificantBits() & BleWatchFaceId.WATCHFACE_ID_INVALID) == 4096;
    }

    public static synchronized UUID from(String str) {
        UUID uuid;
        synchronized (BleUuid.class) {
            try {
                String upperCase = str.toUpperCase();
                if (f16140a == null) {
                    f16140a = new HashMap<>(64);
                }
                uuid = f16140a.get(upperCase);
                if (uuid == null) {
                    uuid = UUID.fromString(upperCase);
                    f16140a.put(upperCase, uuid);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return uuid;
    }
}
