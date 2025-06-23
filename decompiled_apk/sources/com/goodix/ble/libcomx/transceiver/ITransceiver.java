package com.goodix.ble.libcomx.transceiver;

import com.goodix.ble.libcomx.event.Event;

/* loaded from: classes9.dex */
public interface ITransceiver {
    public static final int EVT_READY = -274142511;

    Event<IFrameSdu4Rx> evtRcvFrame();

    Event<Boolean> evtReady();

    void handleRcvData(byte[] bArr, int i, int i2);

    boolean isReady();

    void reset();

    boolean send(int i, IFrameSdu4Tx iFrameSdu4Tx);
}
