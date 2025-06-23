package com.jieli.jl_rcsp.tool;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.bluetooth.CmdSnGenerator;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* loaded from: classes10.dex */
public class SnGenerator implements CmdSnGenerator {
    public final Map<String, Integer> b = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public int f18029a = (new Random().nextInt(255) + 1) % 256;

    public synchronized int autoIncSN(BluetoothDevice bluetoothDevice) {
        int cmdSequence;
        try {
            cmdSequence = getCmdSequence(bluetoothDevice);
            int i = 0;
            if (bluetoothDevice != null) {
                int i2 = cmdSequence + 1;
                if (i2 < 256) {
                    i = i2;
                }
                this.b.put(bluetoothDevice.getAddress(), Integer.valueOf(i));
            } else {
                int i3 = cmdSequence + 1;
                if (i3 < 256) {
                    i = i3;
                }
                this.f18029a = i;
            }
        } catch (Throwable th) {
            throw th;
        }
        return cmdSequence;
    }

    public void destroy() {
        this.b.clear();
    }

    public int getCmdSequence(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return this.f18029a;
        }
        Integer num = this.b.get(bluetoothDevice.getAddress());
        if (num == null) {
            return this.f18029a;
        }
        return num.intValue();
    }

    @Override // com.jieli.jl_rcsp.interfaces.bluetooth.CmdSnGenerator
    public int getRcspCmdSeq(BluetoothDevice bluetoothDevice) {
        return autoIncSN(bluetoothDevice);
    }

    public void removeCmdSequence(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice != null && !this.b.isEmpty()) {
            this.b.remove(bluetoothDevice.getAddress());
        }
    }
}
