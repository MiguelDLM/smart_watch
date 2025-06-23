package com.realsil.sdk.core.d;

import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.ParcelUuid;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.realsil.sdk.core.bluetooth.impl.BluetoothClassImpl;
import com.realsil.sdk.core.bluetooth.scanner.ScannerCallback;
import com.realsil.sdk.core.bluetooth.scanner.ScannerParams;
import com.realsil.sdk.core.bluetooth.utils.BluetoothHelper;
import com.realsil.sdk.core.bluetooth.utils.BluetoothUuid;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.core.utility.DataConverter;
import java.util.Locale;

/* loaded from: classes11.dex */
public class b extends com.realsil.sdk.core.d.a {
    public final a q;

    /* loaded from: classes11.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (!"android.bluetooth.device.action.FOUND".equals(action) && !"android.bluetooth.device.action.CLASS_CHANGED".equals(action)) {
                if (!"android.bluetooth.device.action.NAME_CHANGED".equals(action) && !"android.bluetooth.device.action.UUID".equals(action)) {
                    if ("android.bluetooth.adapter.action.DISCOVERY_STARTED".equals(action)) {
                        b.this.a(2);
                        return;
                    } else {
                        if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(action)) {
                            b.this.a(3);
                            return;
                        }
                        return;
                    }
                }
                BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                short shortExtra = intent.getShortExtra("android.bluetooth.device.extra.RSSI", (short) 0);
                if (bluetoothDevice != null) {
                    if (b.this.b) {
                        ZLogger.v(String.format("%s %s/%s", action, bluetoothDevice.getName(), bluetoothDevice.toString()));
                    }
                    b bVar = b.this;
                    if (bVar.i == 2) {
                        bVar.a(bluetoothDevice, shortExtra, null);
                        return;
                    }
                    return;
                }
                if (b.this.b) {
                    ZLogger.v(String.format("%s", action));
                    return;
                }
                return;
            }
            BluetoothDevice bluetoothDevice2 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            short shortExtra2 = intent.getShortExtra("android.bluetooth.device.extra.RSSI", (short) 0);
            if (bluetoothDevice2 != null) {
                if (b.this.b) {
                    ZLogger.v(String.format("%s %s", action, BluetoothHelper.dumpBluetoothDevice(bluetoothDevice2)));
                }
                b.this.a(bluetoothDevice2, shortExtra2, null);
            } else if (b.this.b) {
                ZLogger.v(String.format("%s", action));
            }
        }
    }

    public b(Context context) {
        this(context, null, null, null);
    }

    @Override // com.realsil.sdk.core.d.a
    public final boolean a(@NonNull BluetoothDevice bluetoothDevice) {
        int type = bluetoothDevice.getType();
        if (this.d.getScanMode() == 33) {
            if (type != 1) {
                if (this.b) {
                    ZLogger.v(String.format(Locale.US, "filter, invalid type: %d, expect type is %d", Integer.valueOf(type), 1));
                }
                return false;
            }
        } else if (this.d.getScanMode() == 32 && type != 1 && type != 3 && type != 0) {
            if (this.b) {
                ZLogger.v(String.format(Locale.US, "filter, invalid type: %d, expect type is %d/%d/%d", Integer.valueOf(type), 0, 1, 3));
            }
            return false;
        }
        if (!b(bluetoothDevice)) {
            return false;
        }
        if (!TextUtils.isEmpty(this.d.getAddressFilter()) && !DataConverter.equals(this.d.getAddressFilter(), bluetoothDevice.getAddress())) {
            if (this.b) {
                StringBuilder a2 = com.realsil.sdk.core.a.a.a("address not match:");
                a2.append(BluetoothHelper.formatAddress(bluetoothDevice.getAddress(), true));
                ZLogger.v(a2.toString());
            }
            return false;
        }
        ParcelUuid[] uuids = bluetoothDevice.getUuids();
        if (1 == this.d.getFilterProfile()) {
            BluetoothClass bluetoothClass = bluetoothDevice.getBluetoothClass();
            if (bluetoothClass.getMajorDeviceClass() != 1024 && (BluetoothClassImpl.doesClassMatch(bluetoothClass, 0) || BluetoothClassImpl.doesClassMatch(bluetoothClass, 1))) {
                if (this.b) {
                    ZLogger.v("major device class filter failed");
                }
                return false;
            }
            if (bluetoothDevice.getBondState() == 12 && !BluetoothUuid.containsAnyUuid(uuids, BluetoothUuid.HEADSET_PROFILE_UUIDS)) {
                if (this.b) {
                    ZLogger.v("profile filter failed");
                }
                return false;
            }
        }
        if (bluetoothDevice.getBondState() != 12 || BluetoothUuid.containsAllUuids(uuids, this.d.getFilterUuids())) {
            return true;
        }
        if (this.b) {
            ZLogger.v("uuid filter failed");
        }
        return false;
    }

    @Override // com.realsil.sdk.core.d.a
    public final boolean b() {
        if (!super.b()) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.device.action.FOUND");
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_STARTED");
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        intentFilter.addAction("android.bluetooth.device.action.UUID");
        this.c.registerReceiver(this.q, intentFilter);
        ZLogger.v(this.b, "scanner initialized");
        return true;
    }

    @Override // com.realsil.sdk.core.d.a
    public final boolean e() {
        if (this.h.isDiscovering()) {
            ZLogger.v(this.b, "cancelDiscovery");
            if (!this.h.cancelDiscovery()) {
                ZLogger.d("cancelDiscovery failed");
                return false;
            }
        }
        a(0);
        return true;
    }

    @Override // com.realsil.sdk.core.d.a
    public void onDestroy() {
        Context context = this.c;
        if (context != null) {
            try {
                context.unregisterReceiver(this.q);
            } catch (Exception e) {
                ZLogger.w(this.b, e.toString());
            }
        }
        super.onDestroy();
    }

    @Override // com.realsil.sdk.core.d.a
    public boolean startScan() {
        if (!d()) {
            return true;
        }
        if (this.h.isDiscovering()) {
            this.h.cancelDiscovery();
        }
        if (this.b) {
            boolean z = this.f19509a;
            StringBuilder a2 = com.realsil.sdk.core.a.a.a("startDiscovery for ");
            a2.append(this.d.toString());
            ZLogger.v(z, a2.toString());
        } else {
            boolean z2 = this.f19509a;
            StringBuilder a3 = com.realsil.sdk.core.a.a.a("startDiscovery for ");
            a3.append(this.d.getScanPeriod());
            a3.append("ms");
            ZLogger.v(z2, a3.toString());
        }
        if (!this.h.startDiscovery()) {
            ZLogger.d("startDiscovery failed");
            stopScan();
            return false;
        }
        c();
        return true;
    }

    public b(Context context, ScannerParams scannerParams, ScannerCallback scannerCallback) {
        this(context, null, scannerParams, scannerCallback);
    }

    public b(Context context, Handler handler, ScannerParams scannerParams, ScannerCallback scannerCallback) {
        this.q = new a();
        this.c = context.getApplicationContext();
        this.g = handler;
        this.d = scannerParams;
        this.e = scannerCallback;
        b();
    }
}
