package com.goodix.ble.libcomx.trx;

import com.goodix.ble.libcomx.event.Event;

/* loaded from: classes9.dex */
public interface ITrx {
    public static final int EVT_READY = -274142511;
    public static final int EVT_RX = -274142510;
    public static final int EVT_TX = -274142509;

    Event<Boolean> evtReady();

    Event<Object> evtRx();

    Event<Object> evtTx();

    boolean isReady();

    void send(Object obj);
}
