package com.goodix.ble.libble.v2.gb.gatt;

import com.goodix.ble.libble.v2.gb.procedure.GBGattProcedureRead;
import com.goodix.ble.libble.v2.gb.procedure.GBGattProcedureWrite;
import com.goodix.ble.libcomx.event.Event;
import java.util.UUID;

/* loaded from: classes9.dex */
public interface GBGattDescriptor {
    public static final int EVT_READ = 4353;
    public static final int EVT_WRITTEN = 4354;

    void clearEventListener(Object obj);

    Event<byte[]> evtRead();

    Event<byte[]> evtWritten();

    GBGattCharacteristic getCharacteristic();

    int getInstanceId();

    UUID getUuid();

    byte[] getValue();

    GBGattProcedureRead read();

    void setValue(byte[] bArr);

    GBGattProcedureWrite write(byte[] bArr);
}
