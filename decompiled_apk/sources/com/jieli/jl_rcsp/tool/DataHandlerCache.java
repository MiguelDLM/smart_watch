package com.jieli.jl_rcsp.tool;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.tool.datahandles.DataHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes10.dex */
public class DataHandlerCache {
    public static volatile DataHandlerCache c;

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, DataHandler> f18002a = Collections.synchronizedMap(new HashMap());
    public final List<BluetoothDevice> b = Collections.synchronizedList(new ArrayList());

    public static DataHandlerCache getInstance() {
        if (c == null) {
            synchronized (DataHandlerCache.class) {
                try {
                    if (c == null) {
                        c = new DataHandlerCache();
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public final void a() {
        Iterator it = new HashSet(this.f18002a.keySet()).iterator();
        while (it.hasNext()) {
            DataHandler dataHandler = this.f18002a.get((String) it.next());
            if (dataHandler != null) {
                dataHandler.release();
            }
        }
        this.f18002a.clear();
        this.b.clear();
    }

    public void addDataHandler(BluetoothDevice bluetoothDevice, DataHandler dataHandler) {
        if (bluetoothDevice != null && dataHandler != null) {
            if (!this.b.contains(bluetoothDevice)) {
                this.b.add(bluetoothDevice);
            }
            if (!this.f18002a.containsKey(bluetoothDevice.getAddress())) {
                this.f18002a.put(bluetoothDevice.getAddress(), dataHandler);
            }
        }
    }

    public void destroy() {
        a();
        c = null;
    }

    public DataHandler getDataHandler(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return null;
        }
        return this.f18002a.get(bluetoothDevice.getAddress());
    }

    public List<BluetoothDevice> getDeviceList() {
        return this.b;
    }

    public void removeDataHandler(BluetoothDevice bluetoothDevice) {
        DataHandler remove;
        if (bluetoothDevice != null && (remove = this.f18002a.remove(bluetoothDevice.getAddress())) != null) {
            this.b.remove(bluetoothDevice);
            remove.release();
        }
    }
}
