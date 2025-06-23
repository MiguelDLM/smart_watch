package com.goodix.ble.libble.v2.gb.gatt;

import com.goodix.ble.libble.v2.gb.GBRemoteDevice;
import java.util.List;
import java.util.UUID;

/* loaded from: classes9.dex */
public interface GBGattService {
    void clearEventListener(Object obj);

    GBGattCharacteristic defineCharacteristic(UUID uuid, boolean z, boolean z2, boolean z3);

    List<GBGattCharacteristic> getCharacteristic(UUID uuid);

    List<GBGattCharacteristic> getCharacteristics();

    List<GBGattService> getIncludeService();

    int getInstanceId();

    GBRemoteDevice getRemoteDevice();

    UUID getUuid();

    GBGattCharacteristic requireCharacteristic(UUID uuid, boolean z, boolean z2, boolean z3);

    boolean undefineService();
}
