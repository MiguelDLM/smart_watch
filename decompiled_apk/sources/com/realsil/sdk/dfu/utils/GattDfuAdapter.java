package com.realsil.sdk.dfu.utils;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.google.android.exoplayer2.C;
import com.realsil.sdk.core.bluetooth.BluetoothProfileManager;
import com.realsil.sdk.core.bluetooth.GlobalGatt;
import com.realsil.sdk.core.bluetooth.impl.BluetoothDeviceImpl;
import com.realsil.sdk.core.bluetooth.impl.BluetoothGattImpl;
import com.realsil.sdk.core.bluetooth.utils.BluetoothHelper;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.dfu.exception.ConnectionException;
import com.realsil.sdk.dfu.l.a;
import com.realsil.sdk.dfu.l.o;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.realsil.sdk.dfu.model.OtaDeviceInfo;
import com.realsil.sdk.dfu.model.OtaModeInfo;
import com.realsil.sdk.dfu.params.QcConfig;
import com.realsil.sdk.dfu.utils.DfuAdapter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes11.dex */
public class GattDfuAdapter extends BluetoothDfuAdapter implements o {
    public static volatile GattDfuAdapter S;
    public GlobalGatt G;
    public BluetoothGatt H;
    public BluetoothGattService I;
    public BluetoothGattService J;
    public BluetoothGattCharacteristic K;
    public com.realsil.sdk.dfu.l.a L;
    public final a.c M = new a();
    public final Runnable N = new b();
    public final Runnable O = new c();
    public final Runnable P = new d();
    public Handler Q = new Handler(Looper.getMainLooper());
    public final BluetoothGattCallback R = new e();

    /* loaded from: classes11.dex */
    public class a implements a.c {
        public a() {
        }

        @Override // com.realsil.sdk.dfu.l.a.c
        public void a(int i) {
            if (GattDfuAdapter.this.isPreparing()) {
                if (i == 1) {
                    if (GattDfuAdapter.this.isBackConnecting()) {
                        GattDfuAdapter.this.notifyStateChanged(DfuAdapter.STATE_BACKCONNECT_SYNC_DATA);
                        return;
                    } else {
                        GattDfuAdapter.this.notifyStateChanged(527);
                        return;
                    }
                }
                if (i == 2) {
                    GattDfuAdapter.this.a(new ConnectionException(5));
                    return;
                }
                return;
            }
            GattDfuAdapter gattDfuAdapter = GattDfuAdapter.this;
            ZLogger.v(gattDfuAdapter.j, String.format("ignore, is not in preparing state: 0x%04X", Integer.valueOf(gattDfuAdapter.q)));
        }
    }

    /* loaded from: classes11.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            GattDfuAdapter.this.a(C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
            try {
                Thread.sleep(800L);
            } catch (InterruptedException e) {
                ZLogger.w(e.toString());
            }
            GattDfuAdapter.this.d();
        }
    }

    /* loaded from: classes11.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            GattDfuAdapter.this.d();
        }
    }

    /* loaded from: classes11.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            GattDfuAdapter gattDfuAdapter = GattDfuAdapter.this;
            if (gattDfuAdapter.q == 536) {
                gattDfuAdapter.B = gattDfuAdapter.getBondState(gattDfuAdapter.C);
                if (GattDfuAdapter.this.B == 11) {
                    ZLogger.v("BOND_BONDING: wait to discover service");
                    new Thread(GattDfuAdapter.this.N).start();
                    return;
                }
                ZLogger.v(">> mBondState: " + GattDfuAdapter.this.B);
                new Thread(GattDfuAdapter.this.O).start();
                return;
            }
            ZLogger.d("ignore state:" + GattDfuAdapter.this.q);
        }
    }

    public GattDfuAdapter(Context context) {
        this.mContext = context;
        c();
    }

    public static GattDfuAdapter getInstance(Context context) {
        if (S == null) {
            synchronized (GattDfuAdapter.class) {
                try {
                    if (S == null) {
                        S = new GattDfuAdapter(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return S;
    }

    public int checkBatteryLevel(int i, int i2) {
        int primaryBat = getOtaDeviceInfo().getPrimaryBat();
        if (getOtaDeviceInfo().icType <= 3 && i2 == 1) {
            primaryBat = (((primaryBat * 2) - 210) * 100) / 90;
        }
        if (primaryBat <= i) {
            return 269;
        }
        if (primaryBat > 110 && primaryBat <= 140) {
            return 269;
        }
        return 0;
    }

    @Override // com.realsil.sdk.dfu.utils.BluetoothDfuAdapter, com.realsil.sdk.dfu.utils.DfuAdapter
    public boolean connectDevice(ConnectParams connectParams) {
        boolean a2;
        if (!super.connectDevice(connectParams)) {
            return false;
        }
        String str = this.C;
        if (str != null && !str.equals(this.l.getAddress())) {
            this.G.unRegisterCallback(this.C, this.R);
            this.G.close(this.C);
        }
        this.A = getRemoteDevice(this.l.getAddress());
        String address = this.l.getAddress();
        this.C = address;
        int bondState = getBondState(address);
        this.B = bondState;
        ZLogger.v(this.h, String.format(Locale.US, ">> mBondState: %d", Integer.valueOf(bondState)));
        if (this.l.isHid()) {
            a2 = b(this.C);
            if (!a2) {
                a2 = a(this.C);
            }
        } else {
            a2 = a(this.C);
        }
        if (!a2) {
            notifyStateChanged(4098);
        }
        return a2;
    }

    @Override // com.realsil.sdk.dfu.utils.BluetoothDfuAdapter, com.realsil.sdk.dfu.utils.DfuAdapter
    public void destroy() {
        super.destroy();
        GlobalGatt globalGatt = this.G;
        if (globalGatt != null) {
            globalGatt.unRegisterCallback(this.C, this.R);
        }
        com.realsil.sdk.dfu.l.a aVar = this.L;
        if (aVar != null) {
            aVar.a();
        }
        S = null;
    }

    @Override // com.realsil.sdk.dfu.utils.DfuAdapter
    public void disconnect() {
        super.disconnect();
        String str = this.C;
        if (str == null) {
            ZLogger.d("no device registered");
            notifyStateChanged(4097);
        } else {
            GlobalGatt globalGatt = this.G;
            if (globalGatt != null) {
                if (globalGatt.isConnected(str)) {
                    if (this.G.isCallbackRegisted(this.C, this.R)) {
                        notifyStateChanged(4096);
                        this.G.close(this.C);
                    } else {
                        ZLogger.v(this.i, "no gatt callback registered");
                        notifyStateChanged(4097);
                    }
                } else {
                    ZLogger.v("already disconnected");
                    notifyStateChanged(4097);
                }
            } else {
                notifyStateChanged(4097);
            }
        }
        this.H = null;
    }

    @Override // com.realsil.sdk.dfu.utils.BluetoothDfuAdapter
    public OtaDeviceInfo getOtaDeviceInfo() {
        com.realsil.sdk.dfu.l.a aVar = this.L;
        if (aVar != null) {
            return aVar.b();
        }
        return super.getOtaDeviceInfo();
    }

    @Override // com.realsil.sdk.dfu.utils.DfuAdapter
    public OtaModeInfo getPriorityWorkMode(int i) {
        com.realsil.sdk.dfu.l.a aVar = this.L;
        if (aVar != null) {
            return aVar.a(i);
        }
        return super.getPriorityWorkMode(i);
    }

    @Override // com.realsil.sdk.dfu.utils.DfuAdapter
    public List<OtaModeInfo> getSupportedModes() {
        com.realsil.sdk.dfu.l.a aVar = this.L;
        if (aVar != null) {
            return aVar.c();
        }
        return super.getSupportedModes();
    }

    public boolean isHogpConnect(String str) {
        return isHogpConnect(getRemoteDevice(str));
    }

    @Override // com.realsil.sdk.dfu.utils.BluetoothDfuAdapter
    public void processBondStateChanged(int i) {
        switch (i) {
            case 10:
                ZLogger.v(this.h, "BOND_NONE");
                if (this.q == 533 && this.A != null) {
                    ZLogger.v(this.h, "createBond");
                    this.A.createBond();
                    return;
                }
                return;
            case 11:
                ZLogger.v(this.h, "BOND_BONDING");
                return;
            case 12:
                ZLogger.v(this.h, "BOND_BONDED");
                if (this.q == 532) {
                    if (this.A != null) {
                        if (!isHogpConnect(this.C)) {
                            ZLogger.v(this.j, "hid not connect");
                            notifyStateChanged(BNMapObserver.EventMapView.EVENT_CLICKED_DEST_NODE_BUBBLE);
                            BluetoothProfileManager.getInstance().connectHid(this.A);
                            return;
                        } else {
                            ZLogger.v(this.j, "hid already connected");
                            a(this.C);
                            return;
                        }
                    }
                    return;
                }
                notifyLock();
                return;
            default:
                return;
        }
    }

    @Override // com.realsil.sdk.dfu.utils.BluetoothDfuAdapter
    public void processHidStateChanged(int i) {
        super.processHidStateChanged(i);
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        ZLogger.v(this.h, " Broadcast: RCU Disconnecting!");
                        return;
                    }
                    return;
                }
                ZLogger.v(this.h, "RCU Connected!");
                if (this.q == 529) {
                    ZLogger.v(this.h, "connect gatt: " + this.C);
                    notifyStateChanged(DfuAdapter.STATE_PREPARE_CONNECTING);
                    this.G.connect(this.C, this.R);
                    return;
                }
                return;
            }
            ZLogger.v(this.h, "RCU Connecting!");
            return;
        }
        ZLogger.v(this.h, " Broadcast: RCU Disconnected!");
        if (this.q == 529) {
            a(new ConnectionException(0));
        }
    }

    public void readDeviceInfo() {
        BluetoothGattService service;
        BluetoothGattService service2;
        BluetoothGatt bluetoothGatt = this.H;
        if (bluetoothGatt == null) {
            return;
        }
        if (this.j) {
            ZLogger.v(BluetoothHelper.dumpBluetoothGattService(bluetoothGatt));
        }
        ConnectParams connectParams = this.l;
        if (connectParams != null) {
            service = this.H.getService(connectParams.getOtaServiceUuid());
            service2 = this.H.getService(this.l.getDfuServiceUuid());
        } else {
            service = this.H.getService(o.c);
            service2 = this.H.getService(o.e);
        }
        this.I = service;
        this.J = service2;
        if (service == null) {
            ZLogger.d(this.i, "not find OTA_SERVICE = " + o.c);
            this.K = null;
        } else {
            ZLogger.v(this.j, "find OTA_SERVICE = " + o.c);
            this.K = service.getCharacteristic(o.d);
        }
        if (this.K != null) {
            ZLogger.v(this.i, "find CHARACTERISTIC_PROTOCOL_TYPE = " + o.d);
            notifyStateChanged(540);
            a(this.K);
            return;
        }
        b(0);
    }

    @Override // com.realsil.sdk.dfu.utils.BluetoothDfuAdapter
    public boolean startOtaProcedure(OtaDeviceInfo otaDeviceInfo, DfuConfig dfuConfig, QcConfig qcConfig, boolean z) {
        if (!super.startOtaProcedure(otaDeviceInfo, dfuConfig, qcConfig, z)) {
            return false;
        }
        notifyStateChanged(1025);
        GlobalGatt globalGatt = this.G;
        if (globalGatt != null) {
            globalGatt.unRegisterCallback(this.C, this.R);
        }
        com.realsil.sdk.dfu.l.a aVar = this.L;
        if (aVar != null) {
            aVar.a();
        }
        boolean a2 = this.k.a(dfuConfig);
        if (!a2) {
            notifyStateChanged(1026);
        }
        return a2;
    }

    /* loaded from: classes11.dex */
    public class e extends BluetoothGattCallback {
        public e() {
        }

        public final void a() {
            if (GattDfuAdapter.this.isPreparing()) {
                GattDfuAdapter.this.notifyLock();
                GattDfuAdapter.this.a(new ConnectionException(0));
            } else {
                GattDfuAdapter.this.notifyStateChanged(4097);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i) {
            super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, bArr, i);
            a(bluetoothGatt, bluetoothGattCharacteristic, bArr, i);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (i == 0) {
                if (i2 == 2) {
                    GattDfuAdapter gattDfuAdapter = GattDfuAdapter.this;
                    gattDfuAdapter.H = gattDfuAdapter.G.getBluetoothGatt(GattDfuAdapter.this.C);
                    ConnectParams connectParams = GattDfuAdapter.this.l;
                    if (connectParams != null && connectParams.isRefreshCache()) {
                        BluetoothGattImpl.refresh(bluetoothGatt);
                    }
                    if (bluetoothGatt != null) {
                        GattDfuAdapter gattDfuAdapter2 = GattDfuAdapter.this;
                        if (gattDfuAdapter2.q != 536) {
                            gattDfuAdapter2.notifyStateChanged(DfuAdapter.STATE_PENDDING_DISCOVERY_SERVICE);
                            if (GattDfuAdapter.this.Q != null) {
                                ZLogger.v("delay to discover service for : 1600");
                                GattDfuAdapter.this.Q.removeCallbacks(GattDfuAdapter.this.P);
                                boolean postDelayed = GattDfuAdapter.this.Q.postDelayed(GattDfuAdapter.this.P, 1600L);
                                if (!postDelayed) {
                                    ZLogger.v(GattDfuAdapter.this.h, "postDelayed:" + postDelayed);
                                    return;
                                }
                                return;
                            }
                            ZLogger.v(GattDfuAdapter.this.h, "mHandler == null");
                            return;
                        }
                        return;
                    }
                    a();
                    return;
                }
                if (i2 == 0) {
                    GattDfuAdapter.this.disconnect();
                    a();
                    return;
                }
                return;
            }
            a();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            GattDfuAdapter gattDfuAdapter = GattDfuAdapter.this;
            int i2 = gattDfuAdapter.q;
            if (i2 == 1025) {
                ZLogger.d("ignore, when it is ota processing");
                return;
            }
            if (i == 0) {
                if (i2 == 537) {
                    gattDfuAdapter.notifyStateChanged(539);
                    GattDfuAdapter.this.notifyLock();
                    return;
                } else {
                    gattDfuAdapter.notifyStateChanged(539);
                    return;
                }
            }
            ZLogger.w("service discovery failed !!!");
            if (GattDfuAdapter.this.isPreparing()) {
                GattDfuAdapter.this.a(new ConnectionException(1));
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
            a(bluetoothGatt, bluetoothGattCharacteristic, bluetoothGattCharacteristic.getValue(), i);
        }

        public final void a(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i) {
            UUID uuid = bluetoothGattCharacteristic.getUuid();
            if (i == 0) {
                if (o.d.equals(uuid)) {
                    GattDfuAdapter gattDfuAdapter = GattDfuAdapter.this;
                    if (gattDfuAdapter.q == 540) {
                        ByteBuffer wrap = ByteBuffer.wrap(bArr);
                        wrap.order(ByteOrder.LITTLE_ENDIAN);
                        GattDfuAdapter.this.b(wrap.getShort(0));
                        return;
                    }
                    ZLogger.v(gattDfuAdapter.i, "ignore duplicate data");
                    return;
                }
                return;
            }
            ZLogger.d(GattDfuAdapter.this.i, String.format("Characteristic read error:0x%04X ", Integer.valueOf(i)));
            if (o.d.equals(uuid)) {
                if (GattDfuAdapter.this.isPreparing()) {
                    GattDfuAdapter.this.a(new ConnectionException(5));
                    return;
                }
                return;
            }
            ZLogger.v(GattDfuAdapter.this.j, "ignore exctption when read other info");
        }
    }

    @Override // com.realsil.sdk.dfu.utils.DfuAdapter
    public boolean b() {
        boolean a2;
        if (!super.b()) {
            notifyStateChanged(4098);
            return false;
        }
        if (this.l.isHid()) {
            a2 = b(this.C);
            if (!a2) {
                a2 = a(this.C);
            }
        } else {
            a2 = a(this.C);
        }
        if (!a2) {
            notifyStateChanged(4098);
        }
        return a2;
    }

    @Override // com.realsil.sdk.dfu.utils.BluetoothDfuAdapter
    public void c() {
        super.c();
        GlobalGatt globalGatt = GlobalGatt.getInstance();
        this.G = globalGatt;
        if (globalGatt == null) {
            GlobalGatt.initial(this.mContext);
            this.G = GlobalGatt.getInstance();
        }
    }

    public final boolean d() {
        boolean z;
        if (this.q == 537) {
            ZLogger.w("discoverServices already started");
            return false;
        }
        notifyStateChanged(DfuAdapter.STATE_DISCOVERY_SERVICE);
        ZLogger.v(this.j, "discoverServices...");
        BluetoothGatt bluetoothGatt = this.H;
        if (bluetoothGatt != null) {
            z = bluetoothGatt.discoverServices();
        } else {
            ZLogger.d("mBtGatt is null");
            z = false;
        }
        if (!z) {
            ZLogger.d(this.i, "discoverServices failed");
            if (isPreparing()) {
                a(new ConnectionException(1));
            }
            return false;
        }
        synchronized (this.o) {
            try {
                ZLogger.v(this.j, "wait discover service complete");
                this.o.wait(30000L);
            } catch (InterruptedException e2) {
                ZLogger.d(this.i, e2.toString());
            }
        }
        if (this.q == 537) {
            ZLogger.w("discoverServices timeout");
            disconnect();
            return false;
        }
        readDeviceInfo();
        return true;
    }

    public boolean isHogpConnect(BluetoothDevice bluetoothDevice) {
        return bluetoothDevice != null && BluetoothProfileManager.getInstance().getConnectionState(4, bluetoothDevice) == 2;
    }

    public final boolean a(String str) {
        notifyStateChanged(DfuAdapter.STATE_PREPARE_CONNECTING);
        return this.G.connect(str, this.R);
    }

    public final boolean a(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return false;
        }
        if (!BluetoothProfileManager.getInstance().isProfileSupported(4)) {
            ZLogger.w("HID_HOST not supported");
            return false;
        }
        int bondState = bluetoothDevice.getBondState();
        if (bondState != 12) {
            ZLogger.d(this.h, "connect with not bond device, bond first, current state: " + bondState);
            notifyStateChanged(512, 20);
            return bluetoothDevice.createBond();
        }
        if (isHogpConnect(bluetoothDevice.getAddress())) {
            ZLogger.d("hogp already connected");
            return a(bluetoothDevice.getAddress());
        }
        if (BluetoothDeviceImpl.removeBond(bluetoothDevice)) {
            ZLogger.d("remove bond first");
            notifyStateChanged(533);
            return false;
        }
        ZLogger.d("remove bond failed");
        notifyStateChanged(BNMapObserver.EventMapView.EVENT_CLICKED_DEST_NODE_BUBBLE);
        return BluetoothProfileManager.getInstance().connectHid(bluetoothDevice);
    }

    public static GattDfuAdapter getInstance(Context context, DfuAdapter.DfuHelperCallback dfuHelperCallback) {
        if (S == null) {
            synchronized (GattDfuAdapter.class) {
                try {
                    if (S == null) {
                        S = new GattDfuAdapter(context.getApplicationContext(), dfuHelperCallback);
                    }
                } finally {
                }
            }
        }
        return S;
    }

    public final boolean b(String str) {
        return a(getRemoteDevice(str));
    }

    public GattDfuAdapter(Context context, DfuAdapter.DfuHelperCallback dfuHelperCallback) {
        this.mContext = context;
        this.n = dfuHelperCallback;
        c();
    }

    public final void b(int i) {
        ZLogger.v(String.format("protocolType=0x%04X", Integer.valueOf(i)));
        com.realsil.sdk.dfu.l.a aVar = this.L;
        if (aVar != null) {
            aVar.a();
        }
        if (i == 16) {
            this.L = new com.realsil.sdk.dfu.r.a(i, this.l, this.C, this.H, this.I, this.J, this.M);
        } else if (i == 20) {
            this.L = new com.realsil.sdk.dfu.o.a(i, this.l, this.C, this.H, this.I, this.J, this.M);
        } else if (i == 21) {
            this.L = new com.realsil.sdk.dfu.p.a(i, this.l, this.C, this.H, this.I, this.J, this.M);
        } else if (i == 18) {
            this.L = new com.realsil.sdk.dfu.m.a(i, this.l, this.C, this.H, this.I, this.J, this.M);
        } else if (i == 19) {
            this.L = new com.realsil.sdk.dfu.n.a(i, this.l, this.C, this.H, this.I, this.J, this.M);
        } else {
            ConnectParams connectParams = this.l;
            this.L = new com.realsil.sdk.dfu.q.a(0, this.l, this.C, this.H, this.I, this.J, this.M, connectParams != null && "BeeTgt02".equals(connectParams.getLocalName()));
        }
        notifyStateChanged(DfuAdapter.STATE_SYNC_SUB_INFO);
        this.L.h();
    }

    public final boolean a(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (this.H != null && bluetoothGattCharacteristic != null) {
            if (this.h) {
                ZLogger.v(String.format(Locale.US, "readCharacteristic:(%d) %s", Integer.valueOf(bluetoothGattCharacteristic.getInstanceId()), bluetoothGattCharacteristic.getUuid().toString()));
            }
            return this.H.readCharacteristic(bluetoothGattCharacteristic);
        }
        ZLogger.w("mBtGatt is null maybe disconnected just now");
        return false;
    }
}
