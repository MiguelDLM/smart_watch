package com.goodix.ble.libble.v2.profile;

import com.goodix.ble.libble.BleUuid;
import com.goodix.ble.libble.v2.gb.GBRemoteDevice;
import com.goodix.ble.libble.v2.gb.gatt.GBGattCharacteristic;
import com.goodix.ble.libble.v2.gb.gatt.GBGattService;
import com.goodix.ble.libble.v2.gb.gatt.profile.GBGattProfile;
import com.goodix.ble.libble.v2.gb.procedure.GBGattProcedureRead;
import com.goodix.ble.libcomx.event.Event;
import com.goodix.ble.libcomx.event.IEventListener;
import java.util.UUID;

/* loaded from: classes9.dex */
public class BatteryService implements IEventListener, GBGattProfile {
    public static final int EVT_BATTERY_UPDATE = 745;
    private static final UUID f = BleUuid.from(6159);
    private static final UUID g = BleUuid.from(10777);

    /* renamed from: a, reason: collision with root package name */
    private GBGattService f16192a;
    private GBGattCharacteristic b;
    private boolean c;
    private int d;
    private Event<Integer> e;

    @Override // com.goodix.ble.libble.v2.gb.gatt.profile.GBGattProfile
    public boolean bindTo(GBRemoteDevice gBRemoteDevice) {
        if (gBRemoteDevice == null) {
            return false;
        }
        GBGattCharacteristic gBGattCharacteristic = this.b;
        if (gBGattCharacteristic != null) {
            gBGattCharacteristic.evtNotify().remove(this);
            this.b.evtRead().clear(this);
        }
        GBGattService requireService = gBRemoteDevice.requireService(f, false);
        this.f16192a = requireService;
        GBGattCharacteristic requireCharacteristic = requireService.requireCharacteristic(g, true, false, true);
        this.b = requireCharacteristic;
        requireCharacteristic.evtNotify().register(this);
        return true;
    }

    public Event<Integer> evtUpdate() {
        if (this.e == null) {
            this.e = new Event<>(this, EVT_BATTERY_UPDATE);
        }
        this.d = -1;
        return this.e;
    }

    public int getLastLevel() {
        return this.d;
    }

    public GBGattCharacteristic getLevel() {
        return this.b;
    }

    public GBGattService getService() {
        return this.f16192a;
    }

    @Override // com.goodix.ble.libcomx.event.IEventListener
    public void onEvent(Object obj, int i, Object obj2) {
        if (obj != this.b || i != 55) {
            if (i == 342 && (obj instanceof GBGattProcedureRead)) {
                onEvent(this.b, 55, ((GBGattProcedureRead) obj).getValue());
                return;
            }
            return;
        }
        byte[] bArr = (byte[]) obj2;
        Event<Integer> event = this.e;
        if (event == null || bArr == null || bArr.length != 1) {
            return;
        }
        int i2 = bArr[0] & 255;
        if (this.c && this.d == i2) {
            return;
        }
        this.d = i2;
        event.postEvent(this, EVT_BATTERY_UPDATE, Integer.valueOf(i2));
    }

    public void requestUpdate() {
        GBGattProcedureRead read = this.b.read();
        read.evtFinished().register(this);
        read.startProcedure();
    }

    public void setNoRepeat() {
        this.c = true;
    }
}
