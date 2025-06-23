package com.jieli.jl_rcsp.tool;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import java.util.HashMap;

/* loaded from: classes10.dex */
public class CommandHelper {
    public static volatile CommandHelper b;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap<String, CommandBase> f18001a = new HashMap<>();

    @SuppressLint({"UseSparseArrays"})
    public CommandHelper() {
    }

    public static String getCacheCommandKey(BluetoothDevice bluetoothDevice, int i, int i2) {
        String str;
        if (bluetoothDevice != null) {
            str = bluetoothDevice.getAddress() + HelpFormatter.DEFAULT_OPT_PREFIX;
        } else {
            str = "";
        }
        String str2 = str + String.valueOf(i);
        if (i2 >= 0) {
            return str2 + HelpFormatter.DEFAULT_OPT_PREFIX + i2;
        }
        return str2;
    }

    public static CommandHelper getInstance() {
        if (b == null) {
            synchronized (CommandHelper.class) {
                try {
                    if (b == null) {
                        b = new CommandHelper();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public CommandBase getCommand(BluetoothDevice bluetoothDevice, int i, int i2) {
        return this.f18001a.get(getCacheCommandKey(bluetoothDevice, i, i2));
    }

    public void putCommandBase(BluetoothDevice bluetoothDevice, CommandBase commandBase) {
        if (commandBase != null) {
            if (commandBase.getType() == 2 || commandBase.getType() == 3) {
                this.f18001a.put(getCacheCommandKey(bluetoothDevice, commandBase.getId(), commandBase.getOpCodeSn()), commandBase);
            }
        }
    }

    public void release() {
        this.f18001a.clear();
        b = null;
    }

    public void removeCommandBase(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        if (basePacket != null) {
            removeCommandBase(bluetoothDevice, basePacket.getOpCode(), basePacket.getOpCodeSn());
        }
    }

    public void removeCommandBase(BluetoothDevice bluetoothDevice, int i, int i2) {
        this.f18001a.remove(getCacheCommandKey(bluetoothDevice, i, i2));
    }
}
