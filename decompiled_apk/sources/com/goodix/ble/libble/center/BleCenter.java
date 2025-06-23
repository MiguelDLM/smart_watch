package com.goodix.ble.libble.center;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.goodix.ble.libble.v2.gb.GBRemoteDevice;
import com.goodix.ble.libble.v2.impl.BleRemoteDevice;
import com.goodix.ble.libcomx.ILogger;
import com.goodix.ble.libcomx.event.Event;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes9.dex */
public final class BleCenter {
    public static final int EVT_ADDED = 416;
    public static final int EVT_REMOVED = 598;
    public static final int EVT_SELECTED = 269;
    private static final BleCenter h = new BleCenter();
    private static Context i = null;
    private static ILogger j = null;
    private BleItem c;

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, BleItem> f16141a = new HashMap<>();
    private IDeviceModelCreator b = null;
    private int d = 0;
    private Event<BleItem> e = new Event<>(this, 416);
    private Event<BleItem> f = new Event<>(this, EVT_REMOVED);
    private Event<BleItem> g = new Event<>(this, 269);

    /* loaded from: classes9.dex */
    public interface IDeviceModelCreator {
        Object onCreateDeviceModel(BleItem bleItem);
    }

    public static BleCenter get() {
        return h;
    }

    public static Context getContext() {
        return i;
    }

    public static void setContext(Context context) {
        if (context != null) {
            i = context.getApplicationContext();
        }
    }

    public static void setRootLogger(ILogger iLogger) {
        j = iLogger;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0057 A[Catch: all -> 0x0046, TryCatch #0 {all -> 0x0046, blocks: (B:6:0x0007, B:8:0x0015, B:10:0x0032, B:11:0x0042, B:12:0x0053, B:14:0x0057, B:16:0x0061, B:22:0x0048, B:24:0x004e), top: B:5:0x0007 }] */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.goodix.ble.libble.center.BleItem addDevice(android.bluetooth.BluetoothDevice r5) {
        /*
            r4 = this;
            android.content.Context r0 = com.goodix.ble.libble.center.BleCenter.i
            if (r0 == 0) goto L74
            if (r5 == 0) goto L6c
            monitor-enter(r4)
            java.util.HashMap<java.lang.String, com.goodix.ble.libble.center.BleItem> r1 = r4.f16141a     // Catch: java.lang.Throwable -> L46
            java.lang.String r2 = r5.getAddress()     // Catch: java.lang.Throwable -> L46
            java.lang.Object r1 = r1.get(r2)     // Catch: java.lang.Throwable -> L46
            com.goodix.ble.libble.center.BleItem r1 = (com.goodix.ble.libble.center.BleItem) r1     // Catch: java.lang.Throwable -> L46
            if (r1 != 0) goto L60
            com.goodix.ble.libble.center.BleItem r1 = new com.goodix.ble.libble.center.BleItem     // Catch: java.lang.Throwable -> L46
            r1.<init>()     // Catch: java.lang.Throwable -> L46
            java.util.HashMap<java.lang.String, com.goodix.ble.libble.center.BleItem> r2 = r4.f16141a     // Catch: java.lang.Throwable -> L46
            java.lang.String r3 = r5.getAddress()     // Catch: java.lang.Throwable -> L46
            r2.put(r3, r1)     // Catch: java.lang.Throwable -> L46
            com.goodix.ble.libble.v2.impl.BleRemoteDevice r2 = new com.goodix.ble.libble.v2.impl.BleRemoteDevice     // Catch: java.lang.Throwable -> L46
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L46
            r2.setBluetoothDevice(r5)     // Catch: java.lang.Throwable -> L46
            r1.a(r2)     // Catch: java.lang.Throwable -> L46
            int r5 = r4.d     // Catch: java.lang.Throwable -> L46
            if (r5 <= 0) goto L48
            com.goodix.ble.libcomx.logger.RingLogger r5 = new com.goodix.ble.libcomx.logger.RingLogger     // Catch: java.lang.Throwable -> L46
            int r0 = r4.d     // Catch: java.lang.Throwable -> L46
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L46
            r1.logger = r5     // Catch: java.lang.Throwable -> L46
            com.goodix.ble.libcomx.ILogger r0 = com.goodix.ble.libble.center.BleCenter.j     // Catch: java.lang.Throwable -> L46
            r5.setLogger(r0)     // Catch: java.lang.Throwable -> L46
            com.goodix.ble.libcomx.logger.RingLogger r5 = r1.logger     // Catch: java.lang.Throwable -> L46
        L42:
            r2.setLogger(r5)     // Catch: java.lang.Throwable -> L46
            goto L53
        L46:
            r5 = move-exception
            goto L6a
        L48:
            com.goodix.ble.libcomx.ILogger r5 = com.goodix.ble.libble.center.BleCenter.j     // Catch: java.lang.Throwable -> L46
            boolean r0 = r5 instanceof com.goodix.ble.libcomx.logger.RingLogger     // Catch: java.lang.Throwable -> L46
            if (r0 == 0) goto L53
            com.goodix.ble.libcomx.logger.RingLogger r5 = (com.goodix.ble.libcomx.logger.RingLogger) r5     // Catch: java.lang.Throwable -> L46
            r1.logger = r5     // Catch: java.lang.Throwable -> L46
            goto L42
        L53:
            com.goodix.ble.libble.center.BleCenter$IDeviceModelCreator r5 = r4.b     // Catch: java.lang.Throwable -> L46
            if (r5 == 0) goto L5e
            java.lang.Object r5 = r5.onCreateDeviceModel(r1)     // Catch: java.lang.Throwable -> L46
            r1.a(r5)     // Catch: java.lang.Throwable -> L46
        L5e:
            r5 = 1
            goto L61
        L60:
            r5 = 0
        L61:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L46
            if (r5 == 0) goto L69
            com.goodix.ble.libcomx.event.Event<com.goodix.ble.libble.center.BleItem> r5 = r4.e
            r5.postEvent(r1)
        L69:
            return r1
        L6a:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L46
            throw r5
        L6c:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "BluetoothDevice is null."
            r5.<init>(r0)
            throw r5
        L74:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Please call setContext() before calling addDevice()."
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.goodix.ble.libble.center.BleCenter.addDevice(android.bluetooth.BluetoothDevice):com.goodix.ble.libble.center.BleItem");
    }

    public Event<BleItem> evtAdded() {
        return this.e;
    }

    public Event<BleItem> evtRemoved() {
        return this.f;
    }

    public Event<BleItem> evtSelected() {
        return this.g;
    }

    public BleItem getDevice(BluetoothDevice bluetoothDevice) {
        BleItem bleItem;
        if (bluetoothDevice == null) {
            return null;
        }
        synchronized (this) {
            bleItem = this.f16141a.get(bluetoothDevice.getAddress());
        }
        return bleItem;
    }

    public List<BleItem> getDevices(List<BleItem> list) {
        if (list == null) {
            list = new ArrayList<>(this.f16141a.size());
        }
        synchronized (this) {
            list.addAll(this.f16141a.values());
        }
        return list;
    }

    public BleItem getSelectedDevice() {
        return this.c;
    }

    public <M> M getSelectedDeviceModel() {
        BleItem bleItem = this.c;
        if (bleItem != null) {
            return (M) bleItem.getDeviceModel();
        }
        return null;
    }

    public BleItem remove(String str) {
        BleItem device = getDevice(str);
        remove(device);
        return device;
    }

    public void setDeviceModelCreator(IDeviceModelCreator iDeviceModelCreator) {
        this.b = iDeviceModelCreator;
    }

    public void setMaxDeviceLogCount(int i2) {
        this.d = i2;
    }

    public void setSelectedDevice(BleItem bleItem) {
        boolean z;
        if (this.c != bleItem) {
            synchronized (this) {
                try {
                    if (this.c != bleItem) {
                        this.c = bleItem;
                        z = true;
                    } else {
                        z = false;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z) {
                this.g.postEvent(bleItem);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0057 A[Catch: all -> 0x0039, TryCatch #0 {all -> 0x0039, blocks: (B:7:0x000f, B:9:0x0019, B:11:0x002a, B:13:0x0035, B:14:0x0053, B:16:0x0057, B:18:0x0061, B:24:0x003b, B:25:0x0042, B:26:0x0046, B:28:0x004c), top: B:6:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.goodix.ble.libble.center.BleItem wrapDevice(com.goodix.ble.libble.v2.gb.GBRemoteDevice r5) {
        /*
            r4 = this;
            android.content.Context r0 = com.goodix.ble.libble.center.BleCenter.i
            if (r0 == 0) goto L74
            if (r5 == 0) goto L6c
            java.lang.String r0 = r5.getAddress()
            com.goodix.ble.libcomx.ILogger r1 = r5.getLogger()
            monitor-enter(r4)
            java.util.HashMap<java.lang.String, com.goodix.ble.libble.center.BleItem> r2 = r4.f16141a     // Catch: java.lang.Throwable -> L39
            java.lang.Object r2 = r2.get(r0)     // Catch: java.lang.Throwable -> L39
            com.goodix.ble.libble.center.BleItem r2 = (com.goodix.ble.libble.center.BleItem) r2     // Catch: java.lang.Throwable -> L39
            if (r2 != 0) goto L60
            com.goodix.ble.libble.center.BleItem r2 = new com.goodix.ble.libble.center.BleItem     // Catch: java.lang.Throwable -> L39
            r2.<init>()     // Catch: java.lang.Throwable -> L39
            java.util.HashMap<java.lang.String, com.goodix.ble.libble.center.BleItem> r3 = r4.f16141a     // Catch: java.lang.Throwable -> L39
            r3.put(r0, r2)     // Catch: java.lang.Throwable -> L39
            r2.a(r5)     // Catch: java.lang.Throwable -> L39
            int r0 = r4.d     // Catch: java.lang.Throwable -> L39
            if (r0 <= 0) goto L46
            com.goodix.ble.libcomx.logger.RingLogger r0 = new com.goodix.ble.libcomx.logger.RingLogger     // Catch: java.lang.Throwable -> L39
            int r3 = r4.d     // Catch: java.lang.Throwable -> L39
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L39
            r2.logger = r0     // Catch: java.lang.Throwable -> L39
            if (r1 == 0) goto L3b
            r0.setLogger(r1)     // Catch: java.lang.Throwable -> L39
            goto L53
        L39:
            r5 = move-exception
            goto L6a
        L3b:
            com.goodix.ble.libcomx.ILogger r1 = com.goodix.ble.libble.center.BleCenter.j     // Catch: java.lang.Throwable -> L39
            r0.setLogger(r1)     // Catch: java.lang.Throwable -> L39
            com.goodix.ble.libcomx.logger.RingLogger r0 = r2.logger     // Catch: java.lang.Throwable -> L39
        L42:
            r5.setLogger(r0)     // Catch: java.lang.Throwable -> L39
            goto L53
        L46:
            com.goodix.ble.libcomx.ILogger r0 = com.goodix.ble.libble.center.BleCenter.j     // Catch: java.lang.Throwable -> L39
            boolean r3 = r0 instanceof com.goodix.ble.libcomx.logger.RingLogger     // Catch: java.lang.Throwable -> L39
            if (r3 == 0) goto L53
            com.goodix.ble.libcomx.logger.RingLogger r0 = (com.goodix.ble.libcomx.logger.RingLogger) r0     // Catch: java.lang.Throwable -> L39
            r2.logger = r0     // Catch: java.lang.Throwable -> L39
            if (r1 != 0) goto L53
            goto L42
        L53:
            com.goodix.ble.libble.center.BleCenter$IDeviceModelCreator r5 = r4.b     // Catch: java.lang.Throwable -> L39
            if (r5 == 0) goto L5e
            java.lang.Object r5 = r5.onCreateDeviceModel(r2)     // Catch: java.lang.Throwable -> L39
            r2.a(r5)     // Catch: java.lang.Throwable -> L39
        L5e:
            r5 = 1
            goto L61
        L60:
            r5 = 0
        L61:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L39
            if (r5 == 0) goto L69
            com.goodix.ble.libcomx.event.Event<com.goodix.ble.libble.center.BleItem> r5 = r4.e
            r5.postEvent(r2)
        L69:
            return r2
        L6a:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L39
            throw r5
        L6c:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "GBRemoteDevice is null."
            r5.<init>(r0)
            throw r5
        L74:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Please call setContext() before calling addDevice()."
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.goodix.ble.libble.center.BleCenter.wrapDevice(com.goodix.ble.libble.v2.gb.GBRemoteDevice):com.goodix.ble.libble.center.BleItem");
    }

    public BleItem addDevice(String str) {
        return addDevice(BluetoothAdapter.getDefaultAdapter().getRemoteDevice(str));
    }

    public BleItem getDevice(String str) {
        BleItem bleItem;
        if (str == null) {
            return null;
        }
        synchronized (this) {
            bleItem = this.f16141a.get(str);
        }
        return bleItem;
    }

    public void remove(BleItem bleItem) {
        boolean z;
        if (bleItem == null) {
            return;
        }
        GBRemoteDevice gatt = bleItem.getGatt();
        synchronized (this) {
            z = this.f16141a.remove(gatt.getAddress()) != null;
        }
        if (z) {
            if (gatt.isDisconnected()) {
                ((BleRemoteDevice) gatt).dispose();
            } else {
                gatt.disconnect(false).startProcedure();
            }
            this.f.postEvent(bleItem);
            if (this.c == bleItem) {
                setSelectedDevice(null);
            }
        }
    }
}
