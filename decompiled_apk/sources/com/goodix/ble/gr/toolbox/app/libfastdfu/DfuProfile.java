package com.goodix.ble.gr.toolbox.app.libfastdfu;

import com.goodix.ble.gr.libdfu.define.DfuUuid;
import com.goodix.ble.gr.libdfu.dfu.DfuTxRxFactory;
import com.goodix.ble.libble.v2.gb.GBRemoteDevice;
import com.goodix.ble.libble.v2.gb.gatt.GBGattCharacteristic;
import com.goodix.ble.libble.v2.gb.gatt.GBGattService;
import com.goodix.ble.libble.v2.gb.gatt.profile.GBGattProfile;
import com.goodix.ble.libble.v2.misc.BleTransceiver;
import com.goodix.ble.libcomx.transceiver.Transceiver;

/* loaded from: classes9.dex */
public class DfuProfile implements GBGattProfile {

    /* renamed from: a, reason: collision with root package name */
    private GBRemoteDevice f16120a;
    private GBGattService b;
    private GBGattCharacteristic c;
    private GBGattCharacteristic d;
    private GBGattCharacteristic e;
    private Transceiver f = new DfuTxRxFactory().create();

    @Override // com.goodix.ble.libble.v2.gb.gatt.profile.GBGattProfile
    public boolean bindTo(GBRemoteDevice gBRemoteDevice) {
        if (gBRemoteDevice == null || this.b != null) {
            return false;
        }
        this.f16120a = gBRemoteDevice;
        GBGattService requireService = gBRemoteDevice.requireService(DfuUuid.DFU_SERVICE_UUID, true);
        this.b = requireService;
        this.c = requireService.requireCharacteristic(DfuUuid.DFU_WRITE_CHARACTERISTIC_UUID, true, false, false);
        this.d = this.b.requireCharacteristic(DfuUuid.DFU_RECEIVE_CHARACTERISTIC_UUID, true, false, true);
        this.e = this.b.requireCharacteristic(DfuUuid.DFU_CONTROL_CHARACTERISTIC_UUID, true, false, false);
        new BleTransceiver(this.d).bindTransceiver(this.f).setSender(new BleTransceiver(this.c).getBufferedFrameSender(4096));
        return true;
    }

    public GBGattCharacteristic getCtrl() {
        return this.e;
    }

    public GBGattService getOtas() {
        return this.b;
    }

    public GBRemoteDevice getRemoteDevice() {
        return this.f16120a;
    }

    public GBGattCharacteristic getRx() {
        return this.d;
    }

    public Transceiver getTransceiver() {
        return this.f;
    }
}
