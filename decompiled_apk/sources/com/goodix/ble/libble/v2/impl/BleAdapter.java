package com.goodix.ble.libble.v2.impl;

import com.goodix.ble.libble.v2.gb.GBAdvertiser;
import com.goodix.ble.libble.v2.gb.GBPeripheral;
import com.goodix.ble.libble.v2.gb.GBRemoteDevice;
import com.goodix.ble.libble.v2.gb.GBScanner;
import com.goodix.ble.libble.v2.gb.GBWirelessAdapter;
import com.goodix.ble.libble.v2.gb.procedure.GBProcedure;
import com.goodix.ble.libcomx.ILogger;
import com.goodix.ble.libcomx.event.Event;
import java.util.List;

/* loaded from: classes9.dex */
public class BleAdapter implements GBWirelessAdapter {
    @Override // com.goodix.ble.libble.v2.gb.GBWirelessAdapter
    public GBAdvertiser createAdvertiser() {
        return null;
    }

    @Override // com.goodix.ble.libble.v2.gb.GBWirelessAdapter
    public GBRemoteDevice createDevice(String str) {
        return null;
    }

    @Override // com.goodix.ble.libble.v2.gb.GBWirelessAdapter
    public GBPeripheral createPeripheral(String str) {
        return null;
    }

    @Override // com.goodix.ble.libble.v2.gb.GBWirelessAdapter
    public GBScanner createScanner() {
        return null;
    }

    @Override // com.goodix.ble.libble.v2.gb.GBWirelessAdapter
    public Event<String> evtError() {
        return null;
    }

    @Override // com.goodix.ble.libble.v2.gb.GBWirelessAdapter
    public Event<Integer> evtStateChanged() {
        return null;
    }

    @Override // com.goodix.ble.libble.v2.gb.GBWirelessAdapter
    public List<GBRemoteDevice> getBondDevices() {
        return null;
    }

    @Override // com.goodix.ble.libble.v2.gb.GBWirelessAdapter
    public boolean isEnabled() {
        return false;
    }

    @Override // com.goodix.ble.libble.v2.gb.GBWirelessAdapter
    public GBProcedure reset(boolean z) {
        return null;
    }

    @Override // com.goodix.ble.libble.v2.gb.GBWirelessAdapter
    public GBProcedure setEnable(boolean z) {
        return null;
    }

    @Override // com.goodix.ble.libble.v2.gb.GBWirelessAdapter
    public void setLogger(ILogger iLogger) {
    }
}
