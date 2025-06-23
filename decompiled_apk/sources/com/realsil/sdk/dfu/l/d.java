package com.realsil.sdk.dfu.l;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.C;
import com.realsil.sdk.core.bluetooth.GlobalGatt;
import com.realsil.sdk.core.bluetooth.impl.BluetoothGattImpl;
import com.realsil.sdk.core.bluetooth.scanner.ExtendedBluetoothDevice;
import com.realsil.sdk.core.bluetooth.scanner.LeScannerPresenter;
import com.realsil.sdk.core.bluetooth.scanner.ScannerCallback;
import com.realsil.sdk.core.bluetooth.scanner.ScannerParams;
import com.realsil.sdk.core.bluetooth.scanner.compat.CompatScanFilter;
import com.realsil.sdk.core.bluetooth.utils.BluetoothHelper;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.core.utility.DataConverter;
import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.exception.OtaException;
import com.realsil.sdk.dfu.internal.base.BaseDfuTask;
import com.realsil.sdk.dfu.internal.base.DfuThreadCallback;
import com.realsil.sdk.dfu.model.DfuConfig;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes11.dex */
public abstract class d extends com.realsil.sdk.dfu.j.b implements o {
    public LeScannerPresenter D;
    public volatile boolean E;
    public b F;
    public GlobalGatt G;
    public BluetoothGatt H;
    public volatile byte[] I;
    public volatile boolean J;
    public volatile boolean K;
    public volatile boolean L;
    public final Handler M;
    public final Runnable N;

    /* loaded from: classes11.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = d.this;
            if (dVar.mConnectionState == 513) {
                int a2 = dVar.a(dVar.mOtaDeviceAddress);
                ZLogger.v(d.this.DBG, ">> mBondState: " + a2);
                d.this.m();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b extends ScannerCallback {
        public b() {
        }

        @Override // com.realsil.sdk.core.bluetooth.scanner.ScannerCallback
        public void onNewDevice(ExtendedBluetoothDevice extendedBluetoothDevice) {
            super.onNewDevice(extendedBluetoothDevice);
            if (!d.this.E) {
                if (d.this.DBG) {
                    ZLogger.d("is already stop the scan, do nothing");
                }
            } else {
                if (extendedBluetoothDevice == null) {
                    if (d.this.DBG) {
                        ZLogger.d("ignore, device == null");
                        return;
                    }
                    return;
                }
                d.this.a(extendedBluetoothDevice);
            }
        }

        @Override // com.realsil.sdk.core.bluetooth.scanner.ScannerCallback
        public void onScanStateChanged(int i) {
            super.onScanStateChanged(i);
            if (d.this.VDBG) {
                ZLogger.v("state= " + i);
            }
        }

        public /* synthetic */ b(d dVar, a aVar) {
            this();
        }
    }

    public d(Context context, DfuConfig dfuConfig, DfuThreadCallback dfuThreadCallback) {
        super(context, dfuConfig, dfuThreadCallback);
        this.I = null;
        this.J = false;
        this.K = false;
        this.L = false;
        this.M = new Handler(Looper.getMainLooper());
        this.N = new a();
    }

    public void a(boolean z) throws DfuException {
        ScannerParams o = o();
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.add(new CompatScanFilter.Builder().setManufacturerData(getDfuConfig().getManufacturerId(), getOtaDeviceInfo().getDeviceMac()).build());
        } else {
            arrayList.add(new CompatScanFilter.Builder().setManufacturerData(getDfuConfig().getManufacturerId(), BaseDfuTask.convertAddress(this.mDeviceAddress)).build());
        }
        o.setScanFilters(arrayList);
        a(o, 31000L);
    }

    @Override // com.realsil.sdk.dfu.internal.base.BaseDfuTask
    public boolean abort() {
        Handler handler = this.M;
        if (handler != null) {
            handler.removeCallbacks(this.N);
        }
        return super.abort();
    }

    @Override // com.realsil.sdk.dfu.j.b
    public boolean b(ScannerParams scannerParams) {
        if (this.DBG) {
            ZLogger.v("start le scan");
        }
        this.E = true;
        LeScannerPresenter leScannerPresenter = this.D;
        if (leScannerPresenter == null) {
            c(scannerParams);
        } else {
            leScannerPresenter.setScannerParams(scannerParams);
        }
        return this.D.startScan();
    }

    public final void c(ScannerParams scannerParams) {
        if (this.F == null) {
            this.F = new b(this, null);
        }
        this.D = new LeScannerPresenter(this.mContext, scannerParams, this.F);
    }

    public void d(int i) {
        int i2 = 16;
        if (i - 3 > 16) {
            i2 = (i / 16) * 16;
        }
        this.MAX_PACKET_SIZE = i2;
        ZLogger.v("> MAX_PACKET_SIZE=" + this.MAX_PACKET_SIZE);
    }

    public void e(int i) {
        sleepInner(1000L);
        ZLogger.d(this.DBG, String.format("terminateConnection, error = 0x%04X", Integer.valueOf(i)));
        BluetoothGatt bluetoothGatt = this.H;
        if (bluetoothGatt != null) {
            b(bluetoothGatt);
            a(this.H, getDfuConfig().isErrorActionEnabled(2));
            a(this.H);
        }
    }

    @Override // com.realsil.sdk.dfu.j.b, com.realsil.sdk.dfu.internal.base.BaseDfuTask
    public void initialize() {
        super.initialize();
        this.G = GlobalGatt.getInstance();
        c((ScannerParams) null);
    }

    public boolean m() {
        String str;
        if (this.H == null) {
            ZLogger.w("mBluetoothGatt == null");
            this.mErrorState = 258;
            notifyConnectionLock();
            return false;
        }
        if (this.mAborted) {
            ZLogger.w("task already aborted, ignore");
            this.mErrorState = DfuException.ERROR_DFU_ABORTED;
            return false;
        }
        if (this.DBG) {
            ZLogger.d("Attempting to start service discovery...");
        }
        boolean discoverServices = this.H.discoverServices();
        if (this.VDBG) {
            StringBuilder sb = new StringBuilder();
            sb.append("discoverServices ");
            if (discoverServices) {
                str = "succeed";
            } else {
                str = "failed";
            }
            sb.append(str);
            ZLogger.d(sb.toString());
        }
        if (!discoverServices) {
            this.mErrorState = 258;
            notifyConnectionLock();
        }
        return discoverServices;
    }

    public void n() throws DfuException {
        if (getOtaDeviceInfo().icType <= 3) {
            a(false);
        } else {
            a(true);
        }
    }

    public ScannerParams o() {
        ScannerParams scannerParams = new ScannerParams(17);
        scannerParams.setScanPeriod(31000L);
        return scannerParams;
    }

    @Override // com.realsil.sdk.dfu.internal.base.BaseDfuTask
    public void onDestroy() {
        super.onDestroy();
        this.E = false;
        LeScannerPresenter leScannerPresenter = this.D;
        if (leScannerPresenter != null) {
            leScannerPresenter.onDestroy();
        }
    }

    public void p() {
        setConnectionState(513);
        if (this.M != null) {
            ZLogger.v(String.format(Locale.US, "delay to discover service for :%d ms ", 1600));
            this.M.postDelayed(this.N, 1600L);
        } else {
            m();
        }
    }

    public byte[] q() throws DfuException {
        return b(getDfuConfig().getNotificationTimeout());
    }

    public boolean r() {
        if (this.mAborted) {
            ZLogger.w("task already aborted, ignore");
            return false;
        }
        if (getDfuConfig().getPhy() == 0) {
            ZLogger.v(this.VDBG, "no need to set phy");
            return true;
        }
        if (Build.VERSION.SDK_INT < 26) {
            ZLogger.v(this.VDBG, "PHY not supported");
            return true;
        }
        if (this.H == null) {
            ZLogger.w("mBluetoothGatt == null");
            return false;
        }
        ZLogger.v(this.DBG, "setPreferredPhy:" + getDfuConfig().getPhy());
        int phy = getDfuConfig().getPhy();
        if (phy == 0) {
            this.H.setPreferredPhy(1, 1, 0);
        } else if (phy == 1) {
            this.H.setPreferredPhy(2, 2, 0);
        } else if (phy == 2) {
            this.H.setPreferredPhy(4, 4, 1);
        } else if (phy != 3) {
            this.H.setPreferredPhy(2, 2, 0);
        } else {
            this.H.setPreferredPhy(4, 4, 2);
        }
        return true;
    }

    public boolean s() {
        this.E = false;
        LeScannerPresenter leScannerPresenter = this.D;
        if (leScannerPresenter != null) {
            return leScannerPresenter.stopScan();
        }
        return true;
    }

    public void c(int i) {
        if (!getDfuConfig().isBufferCheckMtuUpdateEnabled()) {
            ZLogger.d("not support update buffer check mtu size");
            return;
        }
        this.t = i + (-3) > 16 ? (i / 16) * 16 : 16;
        ZLogger.v("> mBufferCheckMtuSize=" + this.t);
    }

    public void b(BluetoothGatt bluetoothGatt) {
        int i = this.mConnectionState;
        if (i == 0 || i == 1280) {
            if (this.DBG) {
                ZLogger.d("already disconnect");
            }
        } else {
            if (bluetoothGatt != null) {
                setConnectionState(1024);
                if (this.DBG) {
                    ZLogger.v("disconnect()");
                }
                bluetoothGatt.disconnect();
                waitUntilDisconnected();
                return;
            }
            if (this.DBG) {
                ZLogger.v("gatt == null");
            }
            setConnectionState(0);
        }
    }

    public void a(ScannerParams scannerParams, long j) throws DfuException {
        if (!this.mAborted) {
            notifyStateChanged(519);
            this.mErrorState = 0;
            this.B = false;
            b(scannerParams);
            try {
                synchronized (this.A) {
                    try {
                        if (this.mErrorState == 0 && !this.B) {
                            this.A.wait(j);
                        }
                    } finally {
                    }
                }
            } catch (InterruptedException e) {
                ZLogger.w("scanLeDevice interrupted, e = " + e.toString());
                this.mErrorState = 259;
            }
            if (this.mErrorState == 0 && !this.B) {
                ZLogger.w("didn't find the special device");
                this.mErrorState = 265;
            }
            if (this.mErrorState != 0) {
                throw new OtaException("Error while scan remote ota device", this.mErrorState);
            }
            return;
        }
        throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
    }

    public byte[] b(long j) throws DfuException {
        this.mErrorState = 0;
        this.K = true;
        try {
            synchronized (this.p) {
                try {
                    if (this.mErrorState == 0 && this.I == null && this.mConnectionState == 515) {
                        this.K = false;
                        if (this.VDBG) {
                            ZLogger.v("wait for notification, wait for " + j + "ms");
                        }
                        this.p.wait(j);
                    }
                    if (this.mErrorState == 0 && !this.K) {
                        ZLogger.w("wait for notification, but not come");
                        this.mErrorState = DfuException.ERROR_NOTIFICATION_NO_RESPONSE;
                    }
                } finally {
                }
            }
        } catch (InterruptedException e) {
            ZLogger.w("readNotificationResponse interrupted, " + e.toString());
            this.mErrorState = 259;
        }
        if (this.mErrorState == 0) {
            return this.I;
        }
        throw new OtaException("Unable to receive notification", this.mErrorState);
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00fb, code lost:
    
        if (r1.equals(r5.mDeviceAddress) != false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x01be, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01bc, code lost:
    
        if (r1.equals(r0.getAddress()) != false) goto L75;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(com.realsil.sdk.core.bluetooth.scanner.ExtendedBluetoothDevice r6) {
        /*
            Method dump skipped, instructions count: 541
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.realsil.sdk.dfu.l.d.a(com.realsil.sdk.core.bluetooth.scanner.ExtendedBluetoothDevice):void");
    }

    public final void a(BluetoothGatt bluetoothGatt, boolean z) {
        if (z || bluetoothGatt.getDevice().getBondState() == 10) {
            BluetoothGattImpl.refresh(bluetoothGatt);
        }
    }

    public void a(BluetoothGatt bluetoothGatt) {
        if (bluetoothGatt != null) {
            BluetoothDevice device = bluetoothGatt.getDevice();
            boolean isErrorActionEnabled = getDfuConfig().isErrorActionEnabled(4);
            if (this.DBG) {
                ZLogger.v(String.format("close gatt connection: %s, closeClient=%b", BluetoothHelper.formatAddress(device.getAddress(), true), Boolean.valueOf(isErrorActionEnabled)));
            }
            GlobalGatt globalGatt = this.G;
            if (globalGatt != null) {
                globalGatt.closeGatt(device.getAddress(), isErrorActionEnabled);
            } else if (isErrorActionEnabled) {
                bluetoothGatt.close();
            }
        }
        setConnectionState(1280);
    }

    @TargetApi(23)
    public boolean a(BluetoothGatt bluetoothGatt, int i) {
        this.mErrorState = 0;
        this.L = false;
        if (this.DBG) {
            ZLogger.d("requestMtu: " + i);
        }
        if (!bluetoothGatt.requestMtu(i)) {
            ZLogger.w("requestMtu failed");
            return false;
        }
        try {
            synchronized (this.p) {
                try {
                    if (!this.L && this.mErrorState == 0) {
                        if (this.VDBG) {
                            ZLogger.v("wait mtu request callback for 15000ms");
                        }
                        this.p.wait(C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
                    }
                } finally {
                }
            }
        } catch (InterruptedException e) {
            ZLogger.w("requestMtu: Sleeping interrupted, e = " + e);
        }
        if (this.L || this.mErrorState != 0) {
            return true;
        }
        if (this.DBG) {
            ZLogger.d("requestMtu No CallBack");
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0084, code lost:
    
        if (r8.getValue()[1] == 0) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(android.bluetooth.BluetoothGatt r7, android.bluetooth.BluetoothGattCharacteristic r8, boolean r9) throws com.realsil.sdk.dfu.DfuException {
        /*
            Method dump skipped, instructions count: 378
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.realsil.sdk.dfu.l.d.a(android.bluetooth.BluetoothGatt, android.bluetooth.BluetoothGattCharacteristic, boolean):void");
    }

    public boolean a(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, boolean z) throws DfuException {
        return a(this.H, bluetoothGattCharacteristic, bArr, z);
    }

    public final boolean a(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, boolean z) throws DfuException {
        return a(bluetoothGatt, bluetoothGattCharacteristic, bArr, bArr != null ? bArr.length : -1, z);
    }

    public boolean a(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i, boolean z) throws DfuException {
        if (!z && this.mAborted) {
            throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
        }
        if (bluetoothGattCharacteristic == null) {
            ZLogger.w("characteristic == null");
            return false;
        }
        if (bArr != null && i >= 0) {
            this.I = null;
            this.mWriteRetransFlag = true;
            boolean z2 = false;
            int i2 = 0;
            while (this.mWriteRetransFlag) {
                this.mWriteRequestCompleted = false;
                if (i2 > 0) {
                    if (this.DBG) {
                        ZLogger.d("re-send command just wait a while");
                    }
                    sleepInner(1000L);
                    if (!z && this.mAborted) {
                        throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
                    }
                }
                long j = bluetoothGattCharacteristic.getWriteType() == 2 ? 30000L : C.DEFAULT_SEEK_FORWARD_INCREMENT_MS;
                z2 = a(bluetoothGatt, bluetoothGattCharacteristic, bArr, i);
                if (z2) {
                    synchronized (this.j) {
                        try {
                            try {
                                if (!this.mWriteRequestCompleted && this.mConnectionState == 515) {
                                    this.j.wait(j);
                                } else if (this.VDBG) {
                                    ZLogger.v("writePacket success");
                                }
                            } catch (InterruptedException e) {
                                ZLogger.w("mWriteLock Sleeping interrupted,e:" + e);
                                if (this.mErrorState == 0) {
                                    this.mErrorState = 259;
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    if (this.mErrorState == 0 && !this.mWriteRequestCompleted) {
                        ZLogger.w("send command but no callback");
                        this.mErrorState = 261;
                    }
                } else {
                    ZLogger.w("writePacket failed");
                    this.mErrorState = 267;
                    z2 = false;
                }
                if (this.mErrorState != 0 || i2 <= 3) {
                    i2++;
                } else {
                    ZLogger.w("send command reach max try time");
                    this.mErrorState = 268;
                }
                if (this.mErrorState != 0) {
                    throw new OtaException("Error while send command", this.mErrorState);
                }
            }
            return z2;
        }
        ZLogger.w("value == null || size < 0");
        return false;
    }

    public final boolean a(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i) {
        if (bluetoothGatt == null) {
            ZLogger.w("gatt == null");
            return false;
        }
        if (bluetoothGattCharacteristic == null) {
            ZLogger.w("characteristic == null");
            return false;
        }
        if (bArr.length > i) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            bArr = bArr2;
        }
        if (this.DBG) {
            ZLogger.v(String.format(Locale.US, "[TX] WRITE_TYPE_0x%02X, (%d)%s << (%d)%s", Integer.valueOf(bluetoothGattCharacteristic.getWriteType()), Integer.valueOf(bluetoothGattCharacteristic.getInstanceId()), bluetoothGattCharacteristic.getUuid(), Integer.valueOf(bArr.length), DataConverter.bytes2Hex(bArr)));
        }
        bluetoothGattCharacteristic.setValue(bArr);
        return bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
    }

    public byte[] a(BluetoothGattCharacteristic bluetoothGattCharacteristic) throws DfuException {
        return a(this.H, bluetoothGattCharacteristic);
    }

    public byte[] a(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) throws DfuException {
        if (this.mAborted) {
            throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
        }
        if (bluetoothGatt == null) {
            ZLogger.w("gatt == null");
            return null;
        }
        if (bluetoothGattCharacteristic == null) {
            ZLogger.w("characteristic == null");
            return null;
        }
        if ((bluetoothGattCharacteristic.getProperties() & 2) == 0) {
            ZLogger.w("characteristic not support PROPERTY_READ");
            return null;
        }
        ZLogger.v(this.DBG, String.format(Locale.US, "readCharacteristic:(handler=%d) %s", Integer.valueOf(bluetoothGattCharacteristic.getInstanceId()), bluetoothGattCharacteristic.getUuid().toString()));
        this.mErrorState = 0;
        this.mReadRxData = null;
        this.mReadRequestCompleted = false;
        if (bluetoothGatt.readCharacteristic(bluetoothGattCharacteristic)) {
            synchronized (this.mReadLock) {
                try {
                    if (this.mErrorState == 0 && !this.mReadRequestCompleted && this.mConnectionState == 515) {
                        this.mReadLock.wait(C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
                    }
                } catch (InterruptedException e) {
                    ZLogger.w("mCharacteristicReadCalledLock Sleeping interrupted,e:" + e);
                    this.mErrorState = 259;
                }
            }
            if (this.mErrorState == 0 && !this.mReadRequestCompleted) {
                ZLogger.w("read value but no callback");
                this.mErrorState = 261;
            }
        } else {
            ZLogger.d("readCharacteristic failed");
            this.mErrorState = 279;
        }
        if (this.mErrorState == 0) {
            return this.mReadRxData;
        }
        throw new OtaException("Error while send command", this.mErrorState);
    }
}
