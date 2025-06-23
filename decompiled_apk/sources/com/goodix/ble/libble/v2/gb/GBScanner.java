package com.goodix.ble.libble.v2.gb;

import com.goodix.ble.libble.v2.gb.pojo.GBAdvReport;
import com.goodix.ble.libcomx.ILogger;
import com.goodix.ble.libcomx.event.Event;
import java.util.List;

/* loaded from: classes9.dex */
public interface GBScanner {
    Event<String> evtError();

    Event<List<GBAdvReport>> evtFound();

    Event<Boolean> evtScan();

    boolean isScanning();

    void setLogger(ILogger iLogger);

    void start();

    void stop();
}
