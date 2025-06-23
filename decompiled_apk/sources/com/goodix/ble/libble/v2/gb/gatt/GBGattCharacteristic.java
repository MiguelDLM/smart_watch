package com.goodix.ble.libble.v2.gb.gatt;

import com.goodix.ble.libble.v2.gb.procedure.GBGattProcedureRead;
import com.goodix.ble.libble.v2.gb.procedure.GBGattProcedureWrite;
import com.goodix.ble.libble.v2.gb.procedure.GBProcedure;
import com.goodix.ble.libcomx.event.Event;
import java.util.List;
import java.util.UUID;

/* loaded from: classes9.dex */
public interface GBGattCharacteristic {
    public static final int EVT_INDICATE = 66;
    public static final int EVT_NOTIFY = 55;
    public static final int EVT_READ = 33;
    public static final int EVT_WRITTEN = 44;

    void clearEventListener(Object obj);

    GBGattDescriptor defineDescriptor(UUID uuid, boolean z);

    Event<byte[]> evtIndicate();

    Event<byte[]> evtNotify();

    Event<byte[]> evtRead();

    Event<byte[]> evtWritten();

    List<GBGattDescriptor> getDescriptor(UUID uuid);

    List<GBGattDescriptor> getDescriptors();

    int getInstanceId();

    int getProperty();

    GBGattService getService();

    UUID getUuid();

    byte[] getValue();

    boolean isIndicateEnabled();

    boolean isNotifyEnabled();

    GBGattProcedureRead read();

    GBGattDescriptor requireDescriptor(UUID uuid, boolean z);

    GBProcedure setEnableIndicate(boolean z);

    GBProcedure setEnableNotify(boolean z);

    void setValue(byte[] bArr);

    GBGattProcedureWrite writeByCommand(byte[] bArr, boolean z);

    GBGattProcedureWrite writeByRequest(byte[] bArr);

    boolean writeDirectly(boolean z, boolean z2, byte[] bArr);
}
