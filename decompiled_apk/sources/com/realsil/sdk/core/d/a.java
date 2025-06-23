package com.realsil.sdk.core.d;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.ParcelUuid;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.realsil.sdk.core.RtkCore;
import com.realsil.sdk.core.bluetooth.BluetoothProfileManager;
import com.realsil.sdk.core.bluetooth.impl.BluetoothDeviceImpl;
import com.realsil.sdk.core.bluetooth.scanner.ExtendedBluetoothDevice;
import com.realsil.sdk.core.bluetooth.scanner.ScannerCallback;
import com.realsil.sdk.core.bluetooth.scanner.ScannerParams;
import com.realsil.sdk.core.bluetooth.utils.BluetoothHelper;
import com.realsil.sdk.core.bluetooth.utils.BluetoothUuid;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.core.utility.DataConverter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/* loaded from: classes11.dex */
public abstract class a {
    public static final int STATE_DISCOVERY_FINISHED = 3;
    public static final int STATE_DISCOVERY_STARTED = 2;
    public static final int STATE_DISCOVERY_START_PROCESS = 1;
    public static final int STATE_IDLE = 0;
    public Context c;
    public ScannerParams d;
    public ScannerCallback e;
    public HandlerThread f;
    public Handler g;
    public BluetoothAdapter h;

    /* renamed from: a, reason: collision with root package name */
    public boolean f19509a = false;
    public boolean b = false;
    public int i = 0;
    public boolean j = false;
    public long k = 0;
    public final C0907a l = new C0907a();
    public final b m = new b();
    public final c n = new c();
    public boolean o = false;
    public final d p = new d();

    /* renamed from: com.realsil.sdk.core.d.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0907a extends BroadcastReceiver {

        /* renamed from: com.realsil.sdk.core.d.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public class RunnableC0908a implements Runnable {
            public RunnableC0908a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                a.this.stopScan();
            }
        }

        public C0907a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                ZLogger.v(String.format(Locale.US, "[%s] %d -> %d", action, Integer.valueOf(intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", -1)), Integer.valueOf(intExtra)));
                if (intExtra == 10 && a.this.isScanning()) {
                    new Thread(new RunnableC0908a()).start();
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            long timeInMillis = Calendar.getInstance().getTimeInMillis();
            a aVar = a.this;
            if (timeInMillis < aVar.k) {
                aVar.k = 0L;
            }
            long j = timeInMillis - aVar.k;
            int i = aVar.i;
            if (i == 1) {
                if (j > 30000) {
                    ZLogger.d(String.format(Locale.US, "no scan response received after start scan for %d ms", 30000L));
                    a.this.e();
                    return;
                }
                return;
            }
            if (i == 2) {
                if (j > 30000) {
                    ZLogger.d(String.format(Locale.US, "exceed %d ms , no scan response received since last time", 30000L));
                    a.this.e();
                    return;
                } else {
                    a.a(aVar);
                    return;
                }
            }
            boolean z = aVar.b;
            StringBuilder a2 = com.realsil.sdk.core.a.a.a("ignore state:");
            a2.append(a.this.i);
            ZLogger.v(z, a2.toString());
            a.a(a.this);
        }
    }

    /* loaded from: classes11.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ZLogger.v("scan delay time reached");
            a.this.e();
        }
    }

    /* loaded from: classes11.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            a aVar = a.this;
            ScannerCallback scannerCallback = aVar.e;
            if (scannerCallback != null) {
                scannerCallback.onAutoScanTrigger();
            } else {
                ZLogger.v(aVar.b, "no callback registered");
            }
            a.this.startScan();
        }
    }

    public void a() {
    }

    public abstract boolean a(@NonNull BluetoothDevice bluetoothDevice);

    public boolean b() {
        if (this.j) {
            ZLogger.w("please call onDestroy() method first");
            return false;
        }
        this.f19509a = RtkCore.DEBUG;
        this.b = RtkCore.VDBG;
        this.h = com.realsil.sdk.core.b.a.a(this.c);
        if (this.d == null) {
            ZLogger.v(this.b, "create new ScannerParams");
            this.d = new ScannerParams();
        }
        if (this.g == null) {
            HandlerThread handlerThread = new HandlerThread("ScannerPresenter");
            this.f = handlerThread;
            handlerThread.start();
            this.g = new Handler(this.f.getLooper());
        }
        if (this.e == null) {
            ZLogger.v(this.b, "callback is null");
        }
        this.c.registerReceiver(this.l, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        this.j = true;
        ZLogger.v(this.f19509a, "scan presenter initialized");
        return true;
    }

    public final boolean c() {
        if (this.g != null) {
            ZLogger.v(this.b, String.format(Locale.US, "wait to check scan period(%d)", 30000L));
            this.g.removeCallbacks(this.m);
            return this.g.postDelayed(this.m, 30000L);
        }
        ZLogger.v(this.b, "mHandler == null");
        return false;
    }

    public final boolean d() {
        if (!this.j) {
            ZLogger.w("presenter not initialized");
            return false;
        }
        if (!isBluetoothEnabled()) {
            ZLogger.w("Bluetooth not enabled, ignore scan process.");
            return false;
        }
        int i = this.i;
        if (i != 1 && i != 2) {
            a(1);
            Handler handler = this.g;
            if (handler != null) {
                handler.removeCallbacks(this.n);
                this.g.removeCallbacks(this.m);
                this.g.removeCallbacks(this.p);
            }
            this.k = 0L;
            ScannerParams scannerParams = this.d;
            if (scannerParams != null) {
                this.o = scannerParams.isAutoDiscovery();
            } else {
                this.o = false;
            }
            return true;
        }
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (timeInMillis < this.k) {
            this.k = 0L;
        }
        if (timeInMillis - this.k > 30000) {
            ZLogger.d(String.format(Locale.US, "exceed %d ms , no scan response received since last time", 30000L));
            e();
        } else {
            c();
        }
        return false;
    }

    public abstract boolean e();

    public BluetoothAdapter getBluetoothAdapter() {
        return this.h;
    }

    public List<ExtendedBluetoothDevice> getPairedDevices() {
        ArrayList arrayList = new ArrayList();
        if (this.h == null) {
            return arrayList;
        }
        if (!this.d.isReusePairedDeviceEnabled()) {
            ZLogger.v(this.f19509a, "don't reuse paired device");
            return arrayList;
        }
        for (BluetoothDevice bluetoothDevice : this.h.getBondedDevices()) {
            ZLogger.v(BluetoothHelper.dumpBluetoothDevice(bluetoothDevice));
            if (a(bluetoothDevice)) {
                arrayList.add(new ExtendedBluetoothDevice(bluetoothDevice, bluetoothDevice.getName(), -1000, bluetoothDevice.getBondState() == 12, false));
            }
        }
        return arrayList;
    }

    public List<ExtendedBluetoothDevice> getPairedDevicesByProfile(int i) {
        boolean z;
        boolean z2;
        if (i != 1) {
            return getPairedDevices();
        }
        ParcelUuid[] parcelUuidArr = BluetoothUuid.HEADSET_PROFILE_UUIDS;
        ArrayList arrayList = new ArrayList();
        BluetoothAdapter bluetoothAdapter = this.h;
        if (bluetoothAdapter != null) {
            for (BluetoothDevice bluetoothDevice : bluetoothAdapter.getBondedDevices()) {
                if (BluetoothUuid.containsAnyUuid(bluetoothDevice.getUuids(), parcelUuidArr)) {
                    boolean isConnected = BluetoothDeviceImpl.isConnected(bluetoothDevice);
                    if (!isConnected) {
                        int connectionState = BluetoothProfileManager.getInstance().getConnectionState(1, bluetoothDevice);
                        int connectionState2 = BluetoothProfileManager.getInstance().getConnectionState(2, bluetoothDevice);
                        if (connectionState != 2 && connectionState2 != 2) {
                            z = false;
                        } else {
                            z = true;
                        }
                    } else {
                        z = isConnected;
                    }
                    String name = bluetoothDevice.getName();
                    if (bluetoothDevice.getBondState() == 12) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    arrayList.add(new ExtendedBluetoothDevice(bluetoothDevice, name, -1000, z2, z));
                }
            }
        }
        return arrayList;
    }

    public int getState() {
        return this.i;
    }

    public boolean isBluetoothEnabled() {
        BluetoothAdapter bluetoothAdapter = this.h;
        if (bluetoothAdapter != null && bluetoothAdapter.isEnabled()) {
            return true;
        }
        return false;
    }

    public boolean isBluetoothSupported() {
        if (this.h != null) {
            return true;
        }
        return false;
    }

    public boolean isScanning() {
        int i = this.i;
        if (i == 2 || i == 1) {
            return true;
        }
        return false;
    }

    public void onDestroy() {
        ZLogger.d(this.f19509a, "onDestroy");
        Context context = this.c;
        if (context != null) {
            try {
                context.unregisterReceiver(this.l);
            } catch (Exception unused) {
            }
        }
        this.e = null;
        stopScan();
        Handler handler = this.g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.g = null;
        }
        HandlerThread handlerThread = this.f;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f = null;
        }
        this.j = false;
        ZLogger.v("scan presenter destroyed");
    }

    public synchronized boolean scanDevice(boolean z) {
        if (z) {
            return startScan();
        }
        return stopScan();
    }

    public void setScanMode(int i) {
        ScannerParams scannerParams = this.d;
        if (scannerParams != null) {
            scannerParams.setScanMode(i);
        }
    }

    public void setScannerCallback(ScannerCallback scannerCallback) {
        this.e = scannerCallback;
        if (scannerCallback == null) {
            ZLogger.v(this.b, "callback is null");
        }
    }

    public void setScannerParams(ScannerParams scannerParams) {
        this.d = scannerParams;
    }

    public abstract boolean startScan();

    public boolean stopScan() {
        this.o = false;
        if (!this.j) {
            ZLogger.w("presenter not initialized");
            return false;
        }
        Handler handler = this.g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        return e();
    }

    public final void a(int i) {
        int i2 = this.i;
        if (i2 != i) {
            if (this.f19509a) {
                ZLogger.d(String.format(Locale.US, "ScanState 0x%02X >> 0x%02X", Integer.valueOf(i2), Integer.valueOf(i)));
            }
            this.i = i;
            ScannerCallback scannerCallback = this.e;
            if (scannerCallback != null) {
                scannerCallback.onScanStateChanged(i);
            } else {
                ZLogger.v(this.b, "no callback registered");
            }
        }
        int i3 = this.i;
        if (i3 == 0 || i3 == 3) {
            Handler handler = this.g;
            if (handler != null) {
                handler.removeCallbacks(this.n);
                this.g.removeCallbacks(this.m);
                this.g.removeCallbacks(this.p);
            }
            boolean z = this.o;
            if (z) {
                if (this.g != null) {
                    ZLogger.v(this.f19509a, "wait to start auto scan");
                    this.g.postDelayed(this.p, this.d.getAutoScanDelay());
                    return;
                }
                return;
            }
            if (this.b) {
                ZLogger.v(String.format("continousScanEnabled=%b", Boolean.valueOf(z)));
            }
        }
    }

    public synchronized boolean scanDevice(boolean z, boolean z2) {
        if (z) {
            return startScan();
        }
        return stopScan();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<com.realsil.sdk.core.bluetooth.scanner.ExtendedBluetoothDevice> getPairedDevices(int r14) {
        /*
            r13 = this;
            r0 = 2
            r1 = 1
            r2 = 0
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            android.bluetooth.BluetoothAdapter r4 = r13.h
            if (r4 != 0) goto Ld
            return r3
        Ld:
            java.util.Set r4 = r4.getBondedDevices()
            java.util.Iterator r4 = r4.iterator()
        L15:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L90
            java.lang.Object r5 = r4.next()
            r7 = r5
            android.bluetooth.BluetoothDevice r7 = (android.bluetooth.BluetoothDevice) r7
            android.bluetooth.BluetoothClass r5 = r7.getBluetoothClass()
            int r5 = r5.getMajorDeviceClass()
            r6 = 1024(0x400, float:1.435E-42)
            if (r5 == r14) goto L3b
            if (r6 != r14) goto L15
            android.bluetooth.BluetoothClass r5 = r7.getBluetoothClass()
            boolean r5 = com.realsil.sdk.core.bluetooth.impl.BluetoothClassImpl.doesClassMatch(r5, r2)
            if (r5 != 0) goto L3b
            goto L15
        L3b:
            if (r6 != r14) goto L72
            com.realsil.sdk.core.bluetooth.BluetoothProfileManager r5 = com.realsil.sdk.core.bluetooth.BluetoothProfileManager.getInstance()
            int r5 = r5.getConnectionState(r1, r7)
            com.realsil.sdk.core.bluetooth.BluetoothProfileManager r6 = com.realsil.sdk.core.bluetooth.BluetoothProfileManager.getInstance()
            int r6 = r6.getConnectionState(r0, r7)
            java.util.Locale r8 = java.util.Locale.US
            java.lang.String r9 = r7.getAddress()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r5)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r6)
            r12 = 3
            java.lang.Object[] r12 = new java.lang.Object[r12]
            r12[r2] = r9
            r12[r1] = r10
            r12[r0] = r11
            java.lang.String r9 = "%s, hfpState= %d,a2dpState= %d"
            java.lang.String r8 = java.lang.String.format(r8, r9, r12)
            com.realsil.sdk.core.logger.ZLogger.v(r8)
            if (r0 == r5) goto L74
            if (r0 != r6) goto L72
            goto L74
        L72:
            r11 = 0
            goto L75
        L74:
            r11 = 1
        L75:
            com.realsil.sdk.core.bluetooth.scanner.ExtendedBluetoothDevice r5 = new com.realsil.sdk.core.bluetooth.scanner.ExtendedBluetoothDevice
            java.lang.String r8 = r7.getName()
            int r6 = r7.getBondState()
            r9 = 12
            if (r6 != r9) goto L85
            r10 = 1
            goto L86
        L85:
            r10 = 0
        L86:
            r9 = -1000(0xfffffffffffffc18, float:NaN)
            r6 = r5
            r6.<init>(r7, r8, r9, r10, r11)
            r3.add(r5)
            goto L15
        L90:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.realsil.sdk.core.d.a.getPairedDevices(int):java.util.List");
    }

    public final boolean b(BluetoothDevice bluetoothDevice) {
        String name = bluetoothDevice.getName();
        if (!TextUtils.isEmpty(this.d.getNameFilter())) {
            if (TextUtils.isEmpty(name)) {
                return false;
            }
            if (DataConverter.equals(this.d.getNameFilter(), name)) {
                return true;
            }
            if (this.d.isNameFuzzyMatchEnable() && name.contains(this.d.getNameFilter())) {
                return true;
            }
            if (this.f19509a) {
                ZLogger.v(String.format("conflict name: %s", name));
            }
            return false;
        }
        if (!TextUtils.isEmpty(name) || this.d.isNameNullable()) {
            return true;
        }
        if (this.b) {
            ZLogger.v("name is null, ignore");
        }
        return false;
    }

    public final boolean a(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        boolean a2;
        this.k = Calendar.getInstance().getTimeInMillis();
        int i2 = this.i;
        if (i2 == 1) {
            a(2);
        } else if (i2 != 2) {
            ZLogger.v(String.format("stop to calibration state: 0x%04X", Integer.valueOf(i2)));
            e();
            return false;
        }
        if (bluetoothDevice == null) {
            ZLogger.d("ignore, device is null");
            return false;
        }
        if (this.d.getRssiFilter() > -1000 && this.d.getRssiFilter() > i) {
            ZLogger.w("filter, low rssi:" + i);
            a2 = false;
        } else {
            a2 = a(bluetoothDevice);
        }
        if (!a2) {
            return false;
        }
        ExtendedBluetoothDevice extendedBluetoothDevice = new ExtendedBluetoothDevice(bluetoothDevice, bluetoothDevice.getName(), i, bluetoothDevice.getBondState() == 12, false, bArr);
        a();
        ScannerCallback scannerCallback = this.e;
        if (scannerCallback != null) {
            scannerCallback.onNewDevice(extendedBluetoothDevice);
        } else {
            ZLogger.v(this.b, "no callback registered");
        }
        if (this.d.getScanMechanism() == 1) {
            ZLogger.d("SCAN_MECHANISM_FILTER_ONE > scanDevice(false)");
            e();
        }
        return true;
    }

    public static void a(a aVar) {
        Handler handler = aVar.g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(aVar.n);
            aVar.g.postDelayed(aVar.n, aVar.d.getScanPeriod());
        } else {
            ZLogger.v(aVar.b, "mHandler == null");
        }
    }
}
