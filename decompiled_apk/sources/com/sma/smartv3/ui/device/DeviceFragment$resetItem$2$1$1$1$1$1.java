package com.sma.smartv3.ui.device;

import android.os.Handler;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.initializer.BleInitializer;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleDeviceOp;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes12.dex */
public final class DeviceFragment$resetItem$2$1$1$1$1$1 extends Lambda implements Oox.oIX0oI<Boolean> {
    public static final DeviceFragment$resetItem$2$1$1$1$1$1 INSTANCE = new DeviceFragment$resetItem$2$1$1$1$1$1();

    public DeviceFragment$resetItem$2$1$1$1$1$1() {
        super(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0() {
        BleConnector.INSTANCE.closeConnection(true);
        BleInitializer.O0X(BleInitializer.f20700XO, false, 1, null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // Oox.oIX0oI
    @OXOo.OOXIXo
    public final Boolean invoke() {
        if (ProductManager.f20544oIX0oI.x0xOIoO()) {
            BleConnector.sendObject$default(BleConnector.INSTANCE, BleKey.DEVICE_OP, BleKeyFlag.UPDATE, new BleDeviceOp(2), false, false, 24, null);
            new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.device.Xx000oIo
                @Override // java.lang.Runnable
                public final void run() {
                    DeviceFragment$resetItem$2$1$1$1$1$1.invoke$lambda$0();
                }
            }, 300L);
        } else {
            BleInitializer.O0X(BleInitializer.f20700XO, false, 1, null);
        }
        return Boolean.TRUE;
    }
}
