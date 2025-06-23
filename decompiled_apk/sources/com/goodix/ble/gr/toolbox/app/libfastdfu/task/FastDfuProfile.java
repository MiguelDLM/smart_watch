package com.goodix.ble.gr.toolbox.app.libfastdfu.task;

import com.goodix.ble.libble.v2.gb.GBRemoteDevice;
import com.goodix.ble.libble.v2.gb.gatt.GBGattCharacteristic;
import com.goodix.ble.libble.v2.gb.gatt.GBGattService;
import com.goodix.ble.libble.v2.gb.gatt.profile.GBGattProfile;
import com.goodix.ble.libcomx.util.DataRateMeter;
import java.util.UUID;

/* loaded from: classes9.dex */
public class FastDfuProfile implements GBGattProfile {

    /* renamed from: a, reason: collision with root package name */
    private GBRemoteDevice f16135a;
    private GBGattService b;
    private GBGattCharacteristic c;
    private GBGattCharacteristic d;
    private final DataRateMeter e = new DataRateMeter();
    public int version = 1;
    public static final UUID FAST_DFU_SERVICE_UUID = UUID.fromString("a6ed0701-d344-460a-8075-b9e8ec90d71b");
    public static final UUID FAST_DFU_CMD_CHARAC_UUID = UUID.fromString("a6ed0702-d344-460a-8075-b9e8ec90d71b");
    public static final UUID FAST_DFU_DAT_CHARAC_UUID = UUID.fromString("a6ed0703-d344-460a-8075-b9e8ec90d71b");

    @Override // com.goodix.ble.libble.v2.gb.gatt.profile.GBGattProfile
    public boolean bindTo(GBRemoteDevice gBRemoteDevice) {
        if (gBRemoteDevice == null) {
            return false;
        }
        this.f16135a = gBRemoteDevice;
        GBGattService requireService = gBRemoteDevice.requireService(FAST_DFU_SERVICE_UUID, true);
        this.b = requireService;
        this.c = requireService.requireCharacteristic(FAST_DFU_CMD_CHARAC_UUID, true, false, true);
        GBGattCharacteristic requireCharacteristic = this.b.requireCharacteristic(FAST_DFU_DAT_CHARAC_UUID, true, false, false);
        this.d = requireCharacteristic;
        requireCharacteristic.evtWritten().register2(this.e);
        return true;
    }

    public GBGattCharacteristic getFdsCmd() {
        return this.c;
    }

    public GBGattCharacteristic getFdsDat() {
        return this.d;
    }

    public GBRemoteDevice getRemoteDevice() {
        return this.f16135a;
    }

    public DataRateMeter getSpeedometer() {
        return this.e;
    }
}
