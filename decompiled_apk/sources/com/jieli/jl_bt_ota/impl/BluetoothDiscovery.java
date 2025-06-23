package com.jieli.jl_bt_ota.impl;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.RequiresApi;
import com.bestmafen.baseble.connector.AbsBleConnector;
import com.jieli.jl_bt_ota.model.BleScanMessage;
import com.jieli.jl_bt_ota.model.OTAError;
import com.jieli.jl_bt_ota.util.BluetoothUtil;
import com.jieli.jl_bt_ota.util.CommonUtil;
import com.jieli.jl_bt_ota.util.JL_Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes10.dex */
public abstract class BluetoothDiscovery extends BluetoothBase {
    private static final int o = 4660;
    private static final int p = 4661;
    private final List<BluetoothDevice> e;
    private final List<BluetoothDevice> f;
    private BluetoothDiscoveryReceiver g;
    private BluetoothLeScanner h;
    private volatile int i;
    private volatile boolean j;
    private volatile boolean k;
    private final Handler l;
    private final BluetoothAdapter.LeScanCallback m;

    @RequiresApi(21)
    private final ScanCallback n;

    /* loaded from: classes10.dex */
    public class BluetoothDiscoveryReceiver extends BroadcastReceiver {
        private BluetoothDiscoveryReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        @SuppressLint({"MissingPermission"})
        public void onReceive(Context context, Intent intent) {
            boolean z;
            String action = intent.getAction();
            if (action == null) {
                return;
            }
            char c = 65535;
            switch (action.hashCode()) {
                case -1780914469:
                    if (action.equals("android.bluetooth.adapter.action.DISCOVERY_FINISHED")) {
                        c = 0;
                        break;
                    }
                    break;
                case 6759640:
                    if (action.equals("android.bluetooth.adapter.action.DISCOVERY_STARTED")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1167529923:
                    if (action.equals("android.bluetooth.device.action.FOUND")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    JL_Log.d(BluetoothDiscovery.this.TAG, "ACTION_DISCOVERY_FINISHED", "---->");
                    BluetoothDiscovery.this.a(false);
                    return;
                case 1:
                    JL_Log.d(BluetoothDiscovery.this.TAG, "ACTION_DISCOVERY_STARTED", "---->");
                    if (!BluetoothDiscovery.this.isDeviceScanning()) {
                        BluetoothDiscovery.this.a(true);
                        return;
                    }
                    return;
                case 2:
                    BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    if (bluetoothDevice != null && !BluetoothDiscovery.this.a("ACTION_FOUND", true)) {
                        if ((BluetoothDiscovery.this.i == 1 && bluetoothDevice.getType() != 2) || ((BluetoothDiscovery.this.i == 0 && bluetoothDevice.getType() != 1) || BluetoothDiscovery.this.i == 2)) {
                            z = true;
                        } else {
                            z = false;
                        }
                        short shortExtra = intent.getShortExtra("android.bluetooth.device.extra.RSSI", (short) 0);
                        if (z && !BluetoothDiscovery.this.f.contains(bluetoothDevice)) {
                            BluetoothDiscovery.this.f.add(bluetoothDevice);
                            BluetoothDiscovery.this.mBtEventCbHelper.onDiscovery(bluetoothDevice, new BleScanMessage().setRssi(shortExtra).setEnableConnect(true));
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public BluetoothDiscovery(Context context) {
        super(context);
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.j = false;
        this.k = false;
        this.l = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.jieli.jl_bt_ota.impl.oIX0oI
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean a2;
                a2 = BluetoothDiscovery.this.a(message);
                return a2;
            }
        });
        this.m = new BluetoothAdapter.LeScanCallback() { // from class: com.jieli.jl_bt_ota.impl.II0xO0
            @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
            public final void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
                BluetoothDiscovery.this.a(bluetoothDevice, i, bArr);
            }
        };
        this.n = new ScanCallback() { // from class: com.jieli.jl_bt_ota.impl.BluetoothDiscovery.1
            @Override // android.bluetooth.le.ScanCallback
            public void onBatchScanResults(List<ScanResult> list) {
                super.onBatchScanResults(list);
            }

            @Override // android.bluetooth.le.ScanCallback
            public void onScanFailed(int i) {
                super.onScanFailed(i);
                BluetoothDiscovery.this.onError(OTAError.buildError(8194, i, "Scan ble error."));
            }

            @Override // android.bluetooth.le.ScanCallback
            public void onScanResult(int i, ScanResult scanResult) {
                boolean z;
                super.onScanResult(i, scanResult);
                if (scanResult != null && scanResult.getScanRecord() != null) {
                    BluetoothDevice device = scanResult.getDevice();
                    if (Build.VERSION.SDK_INT >= 26) {
                        z = scanResult.isConnectable();
                    } else {
                        z = true;
                    }
                    BluetoothDiscovery.this.a(device, scanResult.getRssi(), scanResult.getScanRecord().getBytes(), z);
                }
            }
        };
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        if (bluetoothAdapter != null) {
            this.h = bluetoothAdapter.getBluetoothLeScanner();
        }
    }

    private boolean c() {
        return BluetoothUtil.isBluetoothEnable();
    }

    private void d() {
        a(0);
        this.j = false;
        this.k = false;
        this.e.clear();
        this.f.clear();
    }

    public ArrayList<BluetoothDevice> getDiscoveredBluetoothDevices() {
        if (this.i == 0) {
            return new ArrayList<>(this.e);
        }
        return new ArrayList<>(this.f);
    }

    public int getScanType() {
        return this.i;
    }

    public boolean isBleScanning() {
        return this.j;
    }

    public boolean isDeviceScanning() {
        return this.k;
    }

    public boolean isScanning() {
        if (!this.k && !this.j) {
            return false;
        }
        return true;
    }

    @Override // com.jieli.jl_bt_ota.impl.BluetoothBase
    public void onAdapterStatus(boolean z, boolean z2) {
        super.onAdapterStatus(z, z2);
        if (!z) {
            if (isScanning()) {
                a(false);
            }
            d();
        }
    }

    @Override // com.jieli.jl_bt_ota.impl.BluetoothBase, com.jieli.jl_bt_ota.interfaces.IUpgradeManager
    public void release() {
        super.release();
        b();
        stopDeviceScan();
        stopBLEScan();
        d();
        this.l.removeCallbacksAndMessages(null);
    }

    @SuppressLint({"MissingPermission"})
    public int startBLEScan(long j) {
        ScanSettings build;
        ScanSettings.Builder matchMode;
        if (a("startBLEScan")) {
            return 4113;
        }
        if (isDeviceScanning()) {
            JL_Log.d(this.TAG, "startBLEScan", "stopDeviceScan");
            if (stopDeviceScan() == 0) {
                int i = 0;
                do {
                    SystemClock.sleep(30L);
                    i += 30;
                    if (i > 300) {
                        break;
                    }
                } while (this.mBluetoothAdapter.isDiscovering());
            }
        }
        a(0);
        if (j <= 0) {
            j = AbsBleConnector.TIMEOUT;
        }
        if (isBleScanning()) {
            JL_Log.i(this.TAG, "startBLEScan", "scanning ble ..... timeout = " + j);
            BluetoothLeScanner bluetoothLeScanner = this.h;
            if (bluetoothLeScanner != null) {
                bluetoothLeScanner.flushPendingScanResults(this.n);
            }
            this.l.removeMessages(p);
            this.l.sendEmptyMessageDelayed(p, j);
            a(true);
            return 0;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (this.h != null) {
            if (i2 >= 23) {
                matchMode = new ScanSettings.Builder().setScanMode(this.mBluetoothOption.getBleScanMode()).setMatchMode(1);
                build = matchMode.build();
            } else {
                build = new ScanSettings.Builder().setScanMode(this.mBluetoothOption.getBleScanMode()).build();
            }
            this.h.startScan(new ArrayList(), build, this.n);
            JL_Log.d(this.TAG, "startBLEScan", "startScan : true");
        } else {
            boolean startLeScan = this.mBluetoothAdapter.startLeScan(this.m);
            JL_Log.d(this.TAG, "startBLEScan", "startLeScan : " + startLeScan);
            if (!startLeScan) {
                return 8194;
            }
        }
        JL_Log.i(this.TAG, "startBLEScan", "Ready to scan, timeout : " + j);
        this.l.removeMessages(p);
        this.l.sendEmptyMessageDelayed(p, j);
        a(true);
        return 0;
    }

    @SuppressLint({"MissingPermission"})
    public int startDeviceScan(long j, int i) {
        long j2;
        if (i == 0) {
            return startBLEScan(j);
        }
        if (a("startDeviceScan")) {
            return 4113;
        }
        if (isBleScanning()) {
            stopBLEScan();
            JL_Log.i(this.TAG, "startDeviceScan", "stopBLEScan.");
            SystemClock.sleep(100L);
        }
        a(i);
        if (j <= 0) {
            j2 = AbsBleConnector.TIMEOUT;
        } else {
            j2 = j;
        }
        if (isDeviceScanning()) {
            JL_Log.d(this.TAG, "startDeviceScan", "scanning br/edr ..... timeout = " + j);
            this.l.removeMessages(o);
            this.l.sendEmptyMessageDelayed(o, j2);
            a(true);
            return 0;
        }
        a();
        boolean startDiscovery = this.mBluetoothAdapter.startDiscovery();
        JL_Log.d(this.TAG, "startDeviceScan", "startDiscovery : " + startDiscovery);
        if (!startDiscovery) {
            b();
            return 8194;
        }
        this.l.removeMessages(o);
        this.l.sendEmptyMessageDelayed(o, j2);
        a(true);
        return 0;
    }

    @SuppressLint({"MissingPermission"})
    public int stopBLEScan() {
        if (a("stopBLEScan", true)) {
            return 4113;
        }
        if (!isBleScanning()) {
            this.mBtEventCbHelper.onDiscoveryStatus(true, false);
            return 0;
        }
        try {
            BluetoothLeScanner bluetoothLeScanner = this.h;
            if (bluetoothLeScanner != null) {
                bluetoothLeScanner.stopScan(this.n);
                JL_Log.d(this.TAG, "stopBLEScan", "stopScan");
            } else {
                this.mBluetoothAdapter.stopLeScan(this.m);
                JL_Log.d(this.TAG, "stopBLEScan", "stopLeScan");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.l.removeMessages(p);
        a(false);
        return 0;
    }

    @SuppressLint({"MissingPermission"})
    public int stopDeviceScan() {
        if (a("stopDeviceScan", true)) {
            return 4113;
        }
        if (!isDeviceScanning()) {
            this.mBtEventCbHelper.onDiscoveryStatus(false, false);
            return 0;
        }
        boolean cancelDiscovery = this.mBluetoothAdapter.cancelDiscovery();
        JL_Log.w(this.TAG, "stopDeviceScan", "cancelDiscovery = " + cancelDiscovery);
        if (!cancelDiscovery) {
            return 8194;
        }
        this.l.removeMessages(o);
        return 0;
    }

    @SuppressLint({"MissingPermission"})
    private boolean b(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null || !CommonUtil.checkHasConnectPermission(this.context)) {
            return false;
        }
        return bluetoothDevice.getType() == 2 || bluetoothDevice.getType() == 3;
    }

    private void b(boolean z) {
        List<BluetoothDevice> systemConnectedBtDeviceList = BluetoothUtil.getSystemConnectedBtDeviceList(this.context);
        if (systemConnectedBtDeviceList == null || systemConnectedBtDeviceList.isEmpty()) {
            return;
        }
        for (BluetoothDevice bluetoothDevice : systemConnectedBtDeviceList) {
            if (z && b(bluetoothDevice)) {
                if (!this.e.contains(bluetoothDevice)) {
                    this.e.add(bluetoothDevice);
                    this.mBtEventCbHelper.onDiscovery(bluetoothDevice, new BleScanMessage());
                }
            } else if (!z && !b(bluetoothDevice) && !this.f.contains(bluetoothDevice)) {
                this.f.add(bluetoothDevice);
                this.mBtEventCbHelper.onDiscovery(bluetoothDevice, new BleScanMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(Message message) {
        int i = message.what;
        if (i == o) {
            JL_Log.i(this.TAG, "MSG_STOP_EDR", "stopDeviceScan");
            stopDeviceScan();
            return false;
        }
        if (i != p) {
            return false;
        }
        JL_Log.i(this.TAG, "MSG_STOP_BLE", "stopBLEScan");
        stopBLEScan();
        return false;
    }

    private void a(int i) {
        this.i = i;
    }

    private boolean a(String str) {
        return a(str, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, boolean z) {
        if (!CommonUtil.checkHasScanPermission(this.context)) {
            JL_Log.w(this.TAG, str, "Missing bluetooth scan permissions.");
            return true;
        }
        if (!z && !CommonUtil.checkHasLocationPermission(this.context)) {
            JL_Log.w(this.TAG, str, "Missing location permissions.");
            return true;
        }
        if (!BluetoothUtil.isBluetoothEnable()) {
            JL_Log.w(this.TAG, str, "Bluetooth is off.");
            return true;
        }
        if (this.mBluetoothAdapter != null) {
            return false;
        }
        JL_Log.w(this.TAG, str, "The device is not supported bluetooth.");
        return true;
    }

    private void b() {
        Context context;
        BluetoothDiscoveryReceiver bluetoothDiscoveryReceiver = this.g;
        if (bluetoothDiscoveryReceiver == null || (context = this.context) == null) {
            return;
        }
        context.unregisterReceiver(bluetoothDiscoveryReceiver);
        this.g = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        a(bluetoothDevice, i, bArr, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public void a(BluetoothDevice bluetoothDevice, int i, byte[] bArr, boolean z) {
        if (bluetoothDevice == null || a("filterDevice", true) || this.e.contains(bluetoothDevice)) {
            return;
        }
        this.e.add(bluetoothDevice);
        this.mBtEventCbHelper.onDiscovery(bluetoothDevice, new BleScanMessage().setRawData(bArr).setRssi(i).setEnableConnect(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        boolean z2 = this.i == 0;
        JL_Log.i(this.TAG, "notifyDiscoveryStatus", "scanType : " + this.i + ", bStart : " + z);
        if (z) {
            if (z2) {
                this.j = true;
                this.e.clear();
            } else {
                this.k = true;
                this.f.clear();
            }
        } else if (z2) {
            this.j = false;
        } else {
            this.k = false;
            this.l.removeMessages(o);
            b();
        }
        this.mBtEventCbHelper.onDiscoveryStatus(z2, z);
        if (!z) {
            a(0);
        } else {
            b(z2);
        }
    }

    private void a() {
        if (this.g != null || this.context == null) {
            return;
        }
        this.g = new BluetoothDiscoveryReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_STARTED");
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        intentFilter.addAction("android.bluetooth.device.action.FOUND");
        this.context.registerReceiver(this.g, intentFilter);
    }
}
