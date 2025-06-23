package com.goodix.ble.libble.misc;

import XXO0.oIX0oI;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.os.Build;
import android.os.ParcelUuid;
import androidx.annotation.RequiresApi;
import com.goodix.ble.libcomx.task.Task;
import com.goodix.ble.libcomx.task.TaskOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* loaded from: classes9.dex */
public class FindDeviceTask extends Task {
    private String c;
    private String d;
    private UUID e;
    private BluetoothManager j;

    @TaskOutput
    private BluetoothDevice k;
    private BluetoothAdapter l;
    private b m;
    private a n;

    /* renamed from: a, reason: collision with root package name */
    private int f16145a = 30000;
    private int b = 10000;
    private int f = -127;
    private boolean g = false;
    private boolean h = false;
    private boolean i = false;

    /* loaded from: classes9.dex */
    public class a implements BluetoothAdapter.LeScanCallback {
        public a() {
        }

        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            String name;
            if (((Task) FindDeviceTask.this).taskState == 2 && i >= FindDeviceTask.this.f) {
                if (FindDeviceTask.this.c == null || FindDeviceTask.this.c.equals(bluetoothDevice.getAddress())) {
                    if (FindDeviceTask.this.d == null || ((name = bluetoothDevice.getName()) != null && name.contains(FindDeviceTask.this.d))) {
                        if (((Task) FindDeviceTask.this).logger != null) {
                            ((Task) FindDeviceTask.this).logger.v(FindDeviceTask.this.getName(), "Found device: " + bluetoothDevice);
                        }
                        FindDeviceTask.this.a(bluetoothDevice);
                    }
                }
            }
        }
    }

    @RequiresApi(api = 21)
    /* loaded from: classes9.dex */
    public class b extends ScanCallback {
        public b() {
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onBatchScanResults(List<ScanResult> list) {
            ScanRecord scanRecord;
            String deviceName;
            if (list.size() <= 0 || ((Task) FindDeviceTask.this).taskState != 2) {
                return;
            }
            ScanResult scanResult = list.get(0);
            if (scanResult.getRssi() < FindDeviceTask.this.f) {
                return;
            }
            if (FindDeviceTask.this.d == null || !((scanRecord = scanResult.getScanRecord()) == null || (deviceName = scanRecord.getDeviceName()) == null || !deviceName.contains(FindDeviceTask.this.d))) {
                BluetoothDevice device = scanResult.getDevice();
                if (((Task) FindDeviceTask.this).logger != null) {
                    ((Task) FindDeviceTask.this).logger.v(FindDeviceTask.this.getName(), "Found device: " + device);
                }
                FindDeviceTask.this.a(device);
            }
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanFailed(int i) {
            String str;
            if (i == 1) {
                str = "Fails to start scan as BLE scan with the same settings is already started by the app.";
            } else if (i == 2) {
                str = "Fails to start scan as app cannot be registered.";
            } else if (i == 3) {
                str = "Fails to start scan due an internal error.";
            } else if (i != 4) {
                str = "UNKNOWN(" + i + oIX0oI.I0Io.f4095I0Io;
            } else {
                str = "Fails to start power optimized scan as this feature is not supported.";
            }
            FindDeviceTask.this.finishedWithError("Scan Failed: [" + i + "] " + str);
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i, ScanResult scanResult) {
            ScanRecord scanRecord;
            String deviceName;
            if (i == 1 && ((Task) FindDeviceTask.this).taskState == 2 && scanResult.getRssi() >= FindDeviceTask.this.f) {
                if (FindDeviceTask.this.d == null || !((scanRecord = scanResult.getScanRecord()) == null || (deviceName = scanRecord.getDeviceName()) == null || !deviceName.contains(FindDeviceTask.this.d))) {
                    BluetoothDevice device = scanResult.getDevice();
                    if (((Task) FindDeviceTask.this).logger != null) {
                        ((Task) FindDeviceTask.this).logger.v(FindDeviceTask.this.getName(), "Found device: " + device);
                    }
                    FindDeviceTask.this.a(device);
                }
            }
        }
    }

    @Override // com.goodix.ble.libcomx.task.Task
    public int doWork() {
        this.l = BluetoothAdapter.getDefaultAdapter();
        if (a()) {
            return 0;
        }
        onTimeout(525);
        return this.f16145a;
    }

    public BluetoothDevice getFoundDevice() {
        return this.k;
    }

    @Override // com.goodix.ble.libcomx.task.Task
    public void onCleanup() {
        super.onCleanup();
        stopScan();
    }

    @Override // com.goodix.ble.libcomx.task.Task
    public void onTaskExpired() {
        if (this.g) {
            finishedWithDone();
        } else {
            super.onTaskExpired();
        }
    }

    @Override // com.goodix.ble.libcomx.task.Task
    public void onTimeout(int i) {
        if (i == 521) {
            stopScan();
            startTimer(525, 1000L);
        }
        if (i != 525 || a()) {
            return;
        }
        b();
        int i2 = this.b;
        if (i2 > 0) {
            startTimer(521, i2);
        }
    }

    public FindDeviceTask setCheckBond(boolean z) {
        this.i = z;
        return this;
    }

    public FindDeviceTask setCheckConnected(boolean z, Context context) {
        this.h = z;
        if (context == null) {
            this.h = false;
        } else {
            this.j = (BluetoothManager) context.getSystemService("bluetooth");
        }
        return this;
    }

    public FindDeviceTask setCheckNonExistent(boolean z) {
        this.g = z;
        return this;
    }

    public FindDeviceTask setNameFilter(String str) {
        this.d = str;
        return this;
    }

    public FindDeviceTask setRetryPeriod(int i) {
        this.b = i;
        return this;
    }

    public FindDeviceTask setScanFilter(int i) {
        this.f = i;
        return this;
    }

    public FindDeviceTask setTimeout(int i) {
        this.f16145a = i;
        return this;
    }

    public void stopScan() {
        this.l.getBluetoothLeScanner().stopScan(this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BluetoothDevice bluetoothDevice) {
        this.k = bluetoothDevice;
        setParameter(BluetoothDevice.class, bluetoothDevice);
        if (!this.g || bluetoothDevice == null) {
            finishedWithDone();
            return;
        }
        finishedWithError("Found device: " + bluetoothDevice);
    }

    private void b() {
        boolean isLeCodedPhySupported;
        ScanSettings.Builder legacy;
        int i = Build.VERSION.SDK_INT;
        ScanSettings.Builder builder = new ScanSettings.Builder();
        builder.setScanMode(2).setReportDelay(0L);
        if (i >= 26) {
            isLeCodedPhySupported = this.l.isLeCodedPhySupported();
            if (isLeCodedPhySupported) {
                legacy = builder.setLegacy(false);
                legacy.setPhy(255);
            }
        }
        if (this.m == null) {
            this.m = new b();
        }
        if (this.c == null && this.e == null) {
            this.l.getBluetoothLeScanner().startScan((List<ScanFilter>) null, builder.build(), this.m);
            return;
        }
        ScanFilter.Builder builder2 = new ScanFilter.Builder();
        ArrayList arrayList = new ArrayList(1);
        String str = this.c;
        if (str != null) {
            builder2.setDeviceAddress(str);
        }
        if (this.e != null) {
            builder2.setServiceUuid(new ParcelUuid(this.e));
        }
        arrayList.add(builder2.build());
        this.l.getBluetoothLeScanner().startScan(arrayList, builder.build(), this.m);
    }

    public FindDeviceTask setScanFilter(String str) {
        this.c = str;
        return this;
    }

    public FindDeviceTask setScanFilter(UUID uuid) {
        this.e = uuid;
        return this;
    }

    private boolean a() {
        BluetoothManager bluetoothManager;
        if (this.c == null) {
            return false;
        }
        if (this.i) {
            for (BluetoothDevice bluetoothDevice : this.l.getBondedDevices()) {
                if (this.c.equals(bluetoothDevice.getAddress())) {
                    a(bluetoothDevice);
                    return true;
                }
            }
        }
        if (!this.h || (bluetoothManager = this.j) == null) {
            return false;
        }
        for (BluetoothDevice bluetoothDevice2 : bluetoothManager.getConnectedDevices(7)) {
            if (this.c.equals(bluetoothDevice2.getAddress())) {
                a(bluetoothDevice2);
                return true;
            }
        }
        return false;
    }
}
