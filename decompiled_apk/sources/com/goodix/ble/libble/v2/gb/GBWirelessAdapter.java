package com.goodix.ble.libble.v2.gb;

import com.goodix.ble.libble.v2.gb.procedure.GBProcedure;
import com.goodix.ble.libcomx.ILogger;
import com.goodix.ble.libcomx.event.Event;
import java.util.List;

/* loaded from: classes9.dex */
public interface GBWirelessAdapter {
    public static final Integer STATE_INIT = 1;
    public static final Integer STATE_ENABLED = 2;
    public static final Integer STATE_DEINIT = 3;
    public static final Integer STATE_DISABLED = 4;

    GBAdvertiser createAdvertiser();

    GBRemoteDevice createDevice(String str);

    GBPeripheral createPeripheral(String str);

    GBScanner createScanner();

    Event<String> evtError();

    Event<Integer> evtStateChanged();

    List<GBRemoteDevice> getBondDevices();

    boolean isEnabled();

    GBProcedure reset(boolean z);

    GBProcedure setEnable(boolean z);

    void setLogger(ILogger iLogger);
}
