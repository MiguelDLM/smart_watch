package com.jieli.jl_bt_ota.tool;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_bt_ota.model.base.BasePacket;
import com.jieli.jl_bt_ota.model.base.CommandBase;
import com.jieli.jl_bt_ota.util.CommonUtil;
import com.jieli.jl_rcsp.model.device.settings.v0.DeviceState;
import java.util.HashMap;

/* loaded from: classes10.dex */
public final class CommandCache {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, CommandBase> f17738a = new HashMap<>();

    public static String getCacheCommandKey(BluetoothDevice bluetoothDevice, int i, int i2) {
        return getCacheCommandKey(bluetoothDevice == null ? DeviceState.INVALID_ADDRESS : bluetoothDevice.getAddress(), i, i2);
    }

    public CommandBase getCommand(BluetoothDevice bluetoothDevice, int i, int i2) {
        return this.f17738a.get(getCacheCommandKey(bluetoothDevice, i, i2));
    }

    public void putCommandBase(BluetoothDevice bluetoothDevice, CommandBase commandBase) {
        if (commandBase != null) {
            if (commandBase.getType() == 2 || commandBase.getType() == 3) {
                this.f17738a.put(getCacheCommandKey(bluetoothDevice, commandBase.getId(), commandBase.getOpCodeSn()), commandBase);
            }
        }
    }

    public void release() {
        this.f17738a.clear();
    }

    public void removeCommandBase(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        if (basePacket != null) {
            removeCommandBase(bluetoothDevice, basePacket.getOpCode(), basePacket.getOpCodeSn());
        }
    }

    public void removeCommandBase(BluetoothDevice bluetoothDevice, int i, int i2) {
        this.f17738a.remove(getCacheCommandKey(bluetoothDevice, i, i2));
    }

    public static String getCacheCommandKey(String str, int i, int i2) {
        return CommonUtil.formatString("%s-%s-%s", str, Integer.valueOf(i), Integer.valueOf(i2));
    }
}
