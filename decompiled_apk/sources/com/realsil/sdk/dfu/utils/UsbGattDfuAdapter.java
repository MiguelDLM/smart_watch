package com.realsil.sdk.dfu.utils;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.C;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.core.usb.GlobalUsbGatt;
import com.realsil.sdk.core.usb.UsbGatt;
import com.realsil.sdk.core.usb.UsbGattCallback;
import com.realsil.sdk.core.usb.UsbGattCharacteristic;
import com.realsil.sdk.dfu.exception.ConnectionException;
import com.realsil.sdk.dfu.l.o;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.realsil.sdk.dfu.model.OtaDeviceInfo;
import com.realsil.sdk.dfu.model.OtaModeInfo;
import com.realsil.sdk.dfu.utils.DfuAdapter;
import com.realsil.sdk.dfu.w.b;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes11.dex */
public class UsbGattDfuAdapter extends com.realsil.sdk.dfu.w.e implements o {
    public static volatile UsbGattDfuAdapter L;
    public GlobalUsbGatt B;
    public UsbGatt C;
    public UsbGattCharacteristic D;
    public com.realsil.sdk.dfu.w.b E;
    public b.InterfaceC0923b F = new a();
    public Runnable G = new b();
    public Runnable H = new c();
    public Runnable I = new d();
    public Handler J = new Handler(Looper.getMainLooper());
    public UsbGattCallback K = new e();

    /* loaded from: classes11.dex */
    public class a implements b.InterfaceC0923b {
        public a() {
        }

        @Override // com.realsil.sdk.dfu.w.b.InterfaceC0923b
        public void a(int i) {
            if (i == 1) {
                if (UsbGattDfuAdapter.this.isPreparing()) {
                    UsbGattDfuAdapter.this.notifyStateChanged(527);
                } else {
                    ZLogger.d(String.format("ignore, is not in preparing state: 0x%04X", Integer.valueOf(UsbGattDfuAdapter.this.q)));
                }
            }
            if (i == 2) {
                if (UsbGattDfuAdapter.this.isPreparing()) {
                    UsbGattDfuAdapter.this.a(new ConnectionException(5));
                } else {
                    ZLogger.d(String.format("ignore, is not in preparing state: 0x%04X", Integer.valueOf(UsbGattDfuAdapter.this.q)));
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            UsbGattDfuAdapter.this.a(C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
            try {
                Thread.sleep(800L);
            } catch (InterruptedException e) {
                ZLogger.v(UsbGattDfuAdapter.this.j, e.toString());
            }
            if (UsbGattDfuAdapter.this.d()) {
                ZLogger.v("wait discover service ...");
                UsbGattDfuAdapter.this.a(30000L);
                if (UsbGattDfuAdapter.this.q == 537) {
                    ZLogger.w("discoverServices timeout");
                    UsbGattDfuAdapter.this.disconnect();
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (UsbGattDfuAdapter.this.d()) {
                ZLogger.d("wait discover service commplete");
                synchronized (UsbGattDfuAdapter.this.o) {
                    try {
                        UsbGattDfuAdapter.this.o.wait(30000L);
                    } catch (InterruptedException e) {
                        ZLogger.v(UsbGattDfuAdapter.this.j, e.toString());
                    }
                }
                if (UsbGattDfuAdapter.this.q == 537) {
                    ZLogger.w("discoverServices timeout");
                    UsbGattDfuAdapter.this.disconnect();
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (UsbGattDfuAdapter.this.q == 536) {
                new Thread(UsbGattDfuAdapter.this.H).start();
                return;
            }
            ZLogger.d("ignore state:" + UsbGattDfuAdapter.this.q);
        }
    }

    /* loaded from: classes11.dex */
    public class e extends UsbGattCallback {
        public e() {
        }

        public final void a() {
            if (UsbGattDfuAdapter.this.isPreparing()) {
                UsbGattDfuAdapter.this.notifyLock();
                UsbGattDfuAdapter.this.a(new ConnectionException(0));
            } else {
                UsbGattDfuAdapter.this.notifyStateChanged(4097);
            }
        }

        public void onCharacteristicRead(UsbGatt usbGatt, UsbGattCharacteristic usbGattCharacteristic, int i) {
            super.onCharacteristicRead(usbGatt, usbGattCharacteristic, i);
            UUID uuid = usbGattCharacteristic.getUuid();
            usbGattCharacteristic.getValue();
            if (i == 0) {
                byte[] value = usbGattCharacteristic.getValue();
                if (o.d.equals(uuid)) {
                    ByteBuffer wrap = ByteBuffer.wrap(value);
                    wrap.order(ByteOrder.LITTLE_ENDIAN);
                    ZLogger.d(String.format("protocolType=0x%04X", Integer.valueOf(wrap.getShort(0))));
                    UsbGattDfuAdapter.this.E = new com.realsil.sdk.dfu.w.a(0);
                    UsbGattDfuAdapter.this.E.a(UsbGattDfuAdapter.this.z, UsbGattDfuAdapter.this.C, UsbGattDfuAdapter.this.F);
                    UsbGattDfuAdapter.this.E.e();
                    return;
                }
                return;
            }
            ZLogger.e(UsbGattDfuAdapter.this.h, "Characteristic read error: " + i);
            if (o.d.equals(uuid)) {
                if (UsbGattDfuAdapter.this.isPreparing()) {
                    UsbGattDfuAdapter.this.a(new ConnectionException(5));
                    return;
                }
                return;
            }
            ZLogger.d("ignore exctption when read other info");
        }

        public void onConnectionStateChange(UsbGatt usbGatt, int i, int i2) {
            if (i == 0) {
                if (i2 == 2) {
                    UsbGattDfuAdapter usbGattDfuAdapter = UsbGattDfuAdapter.this;
                    usbGattDfuAdapter.C = usbGattDfuAdapter.B.getUsbGatt(UsbGattDfuAdapter.this.z);
                    if (usbGatt != null) {
                        UsbGattDfuAdapter.this.e();
                        return;
                    } else {
                        a();
                        return;
                    }
                }
                if (i2 == 0) {
                    UsbGattDfuAdapter.this.disconnect();
                    a();
                    return;
                }
                return;
            }
            a();
        }

        public void onServicesDiscovered(UsbGatt usbGatt, int i) {
            UsbGattDfuAdapter usbGattDfuAdapter = UsbGattDfuAdapter.this;
            int i2 = usbGattDfuAdapter.q;
            if (i2 == 1025) {
                ZLogger.d("ignore, when it is ota processing");
                return;
            }
            if (i == 0) {
                if (i2 == 537) {
                    usbGattDfuAdapter.notifyStateChanged(539);
                    UsbGattDfuAdapter.this.notifyLock();
                } else {
                    usbGattDfuAdapter.notifyStateChanged(539);
                }
                UsbGattDfuAdapter.this.readDeviceInfo();
                return;
            }
            ZLogger.w("service discovery failed !!!");
            if (UsbGattDfuAdapter.this.isPreparing()) {
                UsbGattDfuAdapter.this.a(new ConnectionException(1));
            }
        }
    }

    public UsbGattDfuAdapter(Context context) {
        this.mContext = context;
        c();
    }

    public static UsbGattDfuAdapter getInstance(Context context) {
        if (L == null) {
            synchronized (UsbGattDfuAdapter.class) {
                try {
                    if (L == null) {
                        L = new UsbGattDfuAdapter(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return L;
    }

    @Override // com.realsil.sdk.dfu.utils.DfuAdapter
    public boolean connectDevice(ConnectParams connectParams) {
        if (!super.connectDevice(connectParams)) {
            return false;
        }
        if (this.l.getAddress() == null) {
            ZLogger.w("address is null");
            return false;
        }
        String str = this.z;
        if (str != null && !str.equals(this.l.getAddress())) {
            this.B.unRegisterCallback(this.z, this.K);
            this.B.close(this.z);
        }
        this.y = getRemoteDevice(this.l.getAddress());
        this.z = this.l.getAddress();
        this.m = this.l.getReconnectTimes();
        boolean a2 = a(this.y);
        if (!a2) {
            notifyStateChanged(4098);
        }
        return a2;
    }

    @Override // com.realsil.sdk.dfu.w.e, com.realsil.sdk.dfu.utils.DfuAdapter
    public void destroy() {
        super.destroy();
        GlobalUsbGatt globalUsbGatt = this.B;
        if (globalUsbGatt != null) {
            globalUsbGatt.unRegisterCallback(this.z, this.K);
        }
        com.realsil.sdk.dfu.w.b bVar = this.E;
        if (bVar != null) {
            bVar.a();
        }
        L = null;
    }

    @Override // com.realsil.sdk.dfu.utils.DfuAdapter
    public void disconnect() {
        super.disconnect();
        String str = this.z;
        if (str == null) {
            ZLogger.d("no device registered");
            notifyStateChanged(4097);
        } else {
            GlobalUsbGatt globalUsbGatt = this.B;
            if (globalUsbGatt != null) {
                if (globalUsbGatt.isConnected(str)) {
                    if (this.B.isCallbackRegisted(this.z, this.K)) {
                        notifyStateChanged(4096);
                        this.B.close(this.z);
                    } else {
                        ZLogger.v(this.i, "no gatt callback registered");
                        notifyStateChanged(4097);
                    }
                } else {
                    ZLogger.v("already disconnected");
                    notifyStateChanged(4097);
                }
            } else {
                ZLogger.d("mGlobalGatt == null");
                notifyStateChanged(4097);
            }
        }
        this.C = null;
    }

    @Override // com.realsil.sdk.dfu.w.e
    public OtaDeviceInfo getOtaDeviceInfo() {
        com.realsil.sdk.dfu.w.b bVar = this.E;
        if (bVar != null) {
            return bVar.b();
        }
        return super.getOtaDeviceInfo();
    }

    @Override // com.realsil.sdk.dfu.utils.DfuAdapter
    public OtaModeInfo getPriorityWorkMode(int i) {
        com.realsil.sdk.dfu.w.b bVar = this.E;
        if (bVar != null) {
            return bVar.a(i);
        }
        return super.getPriorityWorkMode(i);
    }

    @Override // com.realsil.sdk.dfu.utils.DfuAdapter
    public List<OtaModeInfo> getSupportedModes() {
        com.realsil.sdk.dfu.w.b bVar = this.E;
        if (bVar != null) {
            return bVar.c();
        }
        return super.getSupportedModes();
    }

    public final void readDeviceInfo() {
        UsbGatt usbGatt = this.C;
        if (usbGatt == null) {
            notifyStateChanged(527);
            return;
        }
        List<UsbGattCharacteristic> characteristics = usbGatt.getCharacteristics();
        if (characteristics != null && characteristics.size() > 0) {
            for (UsbGattCharacteristic usbGattCharacteristic : characteristics) {
                ZLogger.v(String.format(Locale.US, "instanceId=%d(0x%02X), uuid=%s", Integer.valueOf(usbGattCharacteristic.getInstanceId()), Integer.valueOf(usbGattCharacteristic.getInstanceId()), usbGattCharacteristic.getUuid().toString()));
            }
        } else {
            ZLogger.d("no characteristic found");
        }
        notifyStateChanged(540);
        UsbGatt usbGatt2 = this.C;
        UUID uuid = o.d;
        UsbGattCharacteristic characteristic = usbGatt2.getCharacteristic(uuid);
        this.D = characteristic;
        if (characteristic == null) {
            ZLogger.d("CHARACTERISTIC_PROTOCOL_TYPE not found");
            com.realsil.sdk.dfu.w.a aVar = new com.realsil.sdk.dfu.w.a(0);
            this.E = aVar;
            aVar.a(this.z, this.C, this.F);
            this.E.e();
            return;
        }
        ZLogger.v(this.h, "find CHARACTERISTIC_PROTOCOL_TYPE = " + uuid);
        a(this.D);
    }

    @Override // com.realsil.sdk.dfu.w.e
    public boolean startOtaProcedure(DfuConfig dfuConfig, boolean z) {
        if (!super.startOtaProcedure(dfuConfig, z)) {
            return false;
        }
        notifyStateChanged(1025);
        GlobalUsbGatt globalUsbGatt = this.B;
        if (globalUsbGatt != null) {
            globalUsbGatt.unRegisterCallback(this.z, this.K);
        }
        com.realsil.sdk.dfu.w.b bVar = this.E;
        if (bVar != null) {
            bVar.a();
        }
        boolean a2 = this.k.a(dfuConfig);
        if (!a2) {
            notifyStateChanged(1026);
        }
        return a2;
    }

    public final void e() {
        if (this.q != 536) {
            notifyStateChanged(DfuAdapter.STATE_PENDDING_DISCOVERY_SERVICE);
            if (this.J != null) {
                ZLogger.d("delay to discover service for : 1600");
                this.J.removeCallbacks(this.I);
                boolean postDelayed = this.J.postDelayed(this.I, 1600L);
                ZLogger.v(this.h, "postDelayed:" + postDelayed);
                return;
            }
            ZLogger.v(this.h, "mHandler == null");
        }
    }

    @Override // com.realsil.sdk.dfu.utils.DfuAdapter
    public boolean b() {
        if (!super.b()) {
            notifyStateChanged(4098);
            return false;
        }
        boolean a2 = a(this.y);
        if (!a2) {
            notifyStateChanged(4098);
        }
        return a2;
    }

    @Override // com.realsil.sdk.dfu.w.e
    public void c() {
        super.c();
        GlobalUsbGatt globalUsbGatt = GlobalUsbGatt.getInstance();
        this.B = globalUsbGatt;
        if (globalUsbGatt == null) {
            GlobalUsbGatt.initial(this.mContext);
            this.B = GlobalUsbGatt.getInstance();
        }
    }

    public final boolean d() {
        boolean z;
        if (this.q == 537) {
            ZLogger.w("discoverServices already started");
            return false;
        }
        notifyStateChanged(DfuAdapter.STATE_DISCOVERY_SERVICE);
        if (this.C != null) {
            ZLogger.v("discoverServices...");
            z = this.C.discoverServices();
        } else {
            ZLogger.w("mBtGatt == null");
            z = false;
        }
        if (z) {
            return true;
        }
        ZLogger.w("discoverServices failed");
        if (isPreparing()) {
            a(new ConnectionException(1));
        }
        return false;
    }

    public final boolean a(UsbDevice usbDevice) {
        notifyStateChanged(DfuAdapter.STATE_PREPARE_CONNECTING);
        return this.B.connect(usbDevice, this.mContext, this.K);
    }

    public static UsbGattDfuAdapter getInstance(Context context, DfuAdapter.DfuHelperCallback dfuHelperCallback) {
        if (L == null) {
            synchronized (UsbGattDfuAdapter.class) {
                try {
                    if (L == null) {
                        L = new UsbGattDfuAdapter(context.getApplicationContext(), dfuHelperCallback);
                    }
                } finally {
                }
            }
        }
        return L;
    }

    public final boolean a(UsbGattCharacteristic usbGattCharacteristic) {
        if (this.C != null && usbGattCharacteristic != null) {
            ZLogger.v(this.h, "readCharacteristic:" + usbGattCharacteristic.getUuid());
            return this.C.readCharacteristic(usbGattCharacteristic);
        }
        ZLogger.w("mBtGatt is null maybe disconnected just now");
        return false;
    }

    public UsbGattDfuAdapter(Context context, DfuAdapter.DfuHelperCallback dfuHelperCallback) {
        this.mContext = context;
        this.n = dfuHelperCallback;
        c();
    }
}
