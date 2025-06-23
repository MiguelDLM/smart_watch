package com.realsil.sdk.dfu.utils;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.C;
import com.realsil.sdk.core.bluetooth.BluetoothProfileCallback;
import com.realsil.sdk.core.bluetooth.BluetoothProfileManager;
import com.realsil.sdk.core.bluetooth.GlobalGatt;
import com.realsil.sdk.core.bluetooth.impl.BluetoothGattImpl;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.dfu.exception.ConnectionException;
import com.realsil.sdk.dfu.exception.LoadFileException;
import com.realsil.sdk.dfu.image.FirmwareLoaderX;
import com.realsil.sdk.dfu.image.LoadParams;
import com.realsil.sdk.dfu.image.pack.SubFileInfo;
import com.realsil.sdk.dfu.l.a;
import com.realsil.sdk.dfu.l.o;
import com.realsil.sdk.dfu.model.BinInfo;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.realsil.sdk.dfu.model.OtaDeviceInfo;
import com.realsil.sdk.dfu.model.OtaModeInfo;
import com.realsil.sdk.dfu.params.QcConfig;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes11.dex */
public class HidDfuAdapter extends BluetoothDfuAdapter implements o {
    public static volatile HidDfuAdapter R;
    public GlobalGatt G;
    public BluetoothGatt H;
    public BluetoothGattService I;
    public BluetoothGattService J;
    public BluetoothGattCharacteristic K;
    public com.realsil.sdk.dfu.l.a L;
    public final a.c M = new a();
    public Runnable N = new b();
    public Runnable O = new c();
    public Handler P = new Handler(Looper.getMainLooper());
    public final BluetoothGattCallback Q = new d();

    /* loaded from: classes11.dex */
    public class a implements a.c {
        public a() {
        }

        @Override // com.realsil.sdk.dfu.l.a.c
        public void a(int i) {
            if (i == 1) {
                if (HidDfuAdapter.this.isPreparing()) {
                    HidDfuAdapter.this.notifyStateChanged(527);
                } else if (HidDfuAdapter.this.isBackConnecting()) {
                    if (HidDfuAdapter.this.a()) {
                        HidDfuAdapter.this.notifyStateChanged(DfuAdapter.STATE_BACKCONNECT_VALIDATE);
                        HidDfuAdapter hidDfuAdapter = HidDfuAdapter.this;
                        if (!hidDfuAdapter.validate(hidDfuAdapter.getOtaDeviceInfo())) {
                            HidDfuAdapter.this.notifyStateChanged(2061);
                        } else {
                            HidDfuAdapter.this.notifyStateChanged(DfuAdapter.STATE_BACKCONNECT_COMPLETED);
                        }
                    } else {
                        HidDfuAdapter.this.notifyStateChanged(DfuAdapter.STATE_BACKCONNECT_COMPLETED);
                    }
                } else {
                    HidDfuAdapter hidDfuAdapter2 = HidDfuAdapter.this;
                    ZLogger.v(hidDfuAdapter2.j, String.format("ignore, is not in preparing or backconnect state: 0x%04X", Integer.valueOf(hidDfuAdapter2.q)));
                }
            }
            if (i == 2) {
                if (!HidDfuAdapter.this.isPreparing() && !HidDfuAdapter.this.isBackConnecting()) {
                    ZLogger.d(String.format("ignore, is not in preparing state: 0x%04X", Integer.valueOf(HidDfuAdapter.this.q)));
                } else {
                    HidDfuAdapter.this.a(new ConnectionException(5));
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
            HidDfuAdapter hidDfuAdapter = HidDfuAdapter.this;
            hidDfuAdapter.B = hidDfuAdapter.getBondState(hidDfuAdapter.C);
            ZLogger.v(">> mBondState: " + HidDfuAdapter.this.B);
            HidDfuAdapter hidDfuAdapter2 = HidDfuAdapter.this;
            if (hidDfuAdapter2.B == 11) {
                hidDfuAdapter2.a(C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
                try {
                    Thread.sleep(800L);
                } catch (InterruptedException e) {
                    ZLogger.v(HidDfuAdapter.this.j, e.toString());
                }
            }
            HidDfuAdapter.this.e();
        }
    }

    /* loaded from: classes11.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!HidDfuAdapter.this.checkState(512, 24) && !HidDfuAdapter.this.checkState(2048, 24)) {
                if (HidDfuAdapter.this.q == 534) {
                    ZLogger.d("STATE_PROCESS_PAIRING_REQUEST: wait to discover service");
                    new Thread(HidDfuAdapter.this.N).start();
                    return;
                } else {
                    ZLogger.d("ignore state:" + HidDfuAdapter.this.q);
                    return;
                }
            }
            new Thread(HidDfuAdapter.this.N).start();
        }
    }

    /* loaded from: classes11.dex */
    public class d extends BluetoothGattCallback {
        public d() {
        }

        public final void a() {
            if (HidDfuAdapter.this.isPreparing()) {
                HidDfuAdapter.this.notifyLock();
                HidDfuAdapter.this.a(new ConnectionException(0));
            } else {
                HidDfuAdapter.this.notifyStateChanged(4097);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
            UUID uuid = bluetoothGattCharacteristic.getUuid();
            bluetoothGattCharacteristic.getValue();
            if (i == 0) {
                byte[] value = bluetoothGattCharacteristic.getValue();
                if (o.d.equals(uuid)) {
                    ByteBuffer wrap = ByteBuffer.wrap(value);
                    wrap.order(ByteOrder.LITTLE_ENDIAN);
                    HidDfuAdapter.this.b(wrap.getShort(0));
                    return;
                }
                return;
            }
            ZLogger.d(HidDfuAdapter.this.h, "Characteristic read error: " + i);
            if (o.d.equals(uuid)) {
                if (HidDfuAdapter.this.isPreparing()) {
                    HidDfuAdapter.this.a(new ConnectionException(5));
                    return;
                }
                return;
            }
            ZLogger.v("ignore exctption when read other info");
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (i == 0) {
                if (i2 == 2) {
                    HidDfuAdapter hidDfuAdapter = HidDfuAdapter.this;
                    hidDfuAdapter.H = hidDfuAdapter.G.getBluetoothGatt(HidDfuAdapter.this.C);
                    ConnectParams connectParams = HidDfuAdapter.this.l;
                    if (connectParams != null && connectParams.isRefreshCache()) {
                        BluetoothGattImpl.refresh(bluetoothGatt);
                    }
                    if (bluetoothGatt != null) {
                        if (HidDfuAdapter.this.isPreparing()) {
                            HidDfuAdapter hidDfuAdapter2 = HidDfuAdapter.this;
                            if (hidDfuAdapter2.q != 536) {
                                hidDfuAdapter2.notifyStateChanged(DfuAdapter.STATE_PENDDING_DISCOVERY_SERVICE);
                                if (HidDfuAdapter.this.P != null) {
                                    ZLogger.v("delay to discover service for : 1600");
                                    HidDfuAdapter.this.P.removeCallbacks(HidDfuAdapter.this.O);
                                    boolean postDelayed = HidDfuAdapter.this.P.postDelayed(HidDfuAdapter.this.O, 1600L);
                                    if (!postDelayed) {
                                        ZLogger.v(HidDfuAdapter.this.h, "postDelayed:" + postDelayed);
                                        return;
                                    }
                                    return;
                                }
                                ZLogger.v(HidDfuAdapter.this.j, "mHandler == null");
                                return;
                            }
                            return;
                        }
                        if (HidDfuAdapter.this.isBackConnecting() && !HidDfuAdapter.this.checkState(2048, 24)) {
                            HidDfuAdapter.this.notifyStateChanged(2048, 24);
                            if (HidDfuAdapter.this.P != null) {
                                ZLogger.v("delay to discover service for : 1600");
                                HidDfuAdapter.this.P.removeCallbacks(HidDfuAdapter.this.O);
                                boolean postDelayed2 = HidDfuAdapter.this.P.postDelayed(HidDfuAdapter.this.O, 1600L);
                                if (!postDelayed2) {
                                    ZLogger.v(HidDfuAdapter.this.h, "postDelayed:" + postDelayed2);
                                    return;
                                }
                                return;
                            }
                            ZLogger.v(HidDfuAdapter.this.j, "mHandler == null");
                            return;
                        }
                        return;
                    }
                    a();
                    return;
                }
                if (i2 == 0) {
                    HidDfuAdapter.this.disconnect();
                    a();
                    return;
                }
                return;
            }
            a();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            HidDfuAdapter hidDfuAdapter = HidDfuAdapter.this;
            if (hidDfuAdapter.q == 1025) {
                ZLogger.d("ignore, when it is ota processing");
                return;
            }
            if (i == 0) {
                if (hidDfuAdapter.checkState(512, 25) || HidDfuAdapter.this.checkState(2048, 25)) {
                    HidDfuAdapter hidDfuAdapter2 = HidDfuAdapter.this;
                    hidDfuAdapter2.notifyStateChanged(hidDfuAdapter2.p, 27);
                    HidDfuAdapter.this.notifyLock();
                    return;
                }
                return;
            }
            ZLogger.w("service discovery failed !!!");
            if (HidDfuAdapter.this.isPreparing()) {
                HidDfuAdapter.this.a(new ConnectionException(1));
            }
        }
    }

    /* loaded from: classes11.dex */
    public class e extends BluetoothProfileCallback {
        public e() {
        }

        @Override // com.realsil.sdk.core.bluetooth.BluetoothProfileCallback
        public void onHidStateChanged(BluetoothDevice bluetoothDevice, int i) {
            super.onHidStateChanged(bluetoothDevice, i);
            HidDfuAdapter hidDfuAdapter = HidDfuAdapter.this;
            int i2 = hidDfuAdapter.q;
            if (i2 == 2065) {
                BluetoothDevice bluetoothDevice2 = hidDfuAdapter.A;
                if (bluetoothDevice2 == null) {
                    ZLogger.v("device has already been clean");
                    HidDfuAdapter.this.notifyStateChanged(DfuAdapter.STATE_BACKCONNECT_FAILED);
                    return;
                }
                if (bluetoothDevice2.equals(bluetoothDevice)) {
                    if (i == 2) {
                        ZLogger.v("pending to back connect with previous device");
                        HidDfuAdapter hidDfuAdapter2 = HidDfuAdapter.this;
                        hidDfuAdapter2.connectDevice(hidDfuAdapter2.l);
                        return;
                    } else {
                        if (i == 0) {
                            ZLogger.v("proile disconnected");
                            HidDfuAdapter.this.notifyStateChanged(DfuAdapter.STATE_BACKCONNECT_FAILED);
                            return;
                        }
                        return;
                    }
                }
                ZLogger.v(String.format("target device is %s, ignore device:%s", HidDfuAdapter.this.A.toString(), bluetoothDevice.toString()));
                return;
            }
            if (i2 == 529) {
                BluetoothDevice bluetoothDevice3 = hidDfuAdapter.A;
                if (bluetoothDevice3 == null) {
                    ZLogger.v("device has already been clean");
                    HidDfuAdapter.this.notifyStateChanged(4098);
                    return;
                }
                if (bluetoothDevice3.equals(bluetoothDevice)) {
                    if (i != 0) {
                        if (i != 1) {
                            if (i != 2) {
                                if (i == 3) {
                                    ZLogger.v(HidDfuAdapter.this.j, " RCU Disconnecting!");
                                    return;
                                }
                                return;
                            } else {
                                ZLogger.v(HidDfuAdapter.this.h, "RCU Connected!");
                                HidDfuAdapter hidDfuAdapter3 = HidDfuAdapter.this;
                                hidDfuAdapter3.a(hidDfuAdapter3.C);
                                return;
                            }
                        }
                        ZLogger.v(HidDfuAdapter.this.j, "RCU Connecting!");
                        return;
                    }
                    ZLogger.v(HidDfuAdapter.this.h, "RCU Disconnected!");
                    HidDfuAdapter.this.a(new ConnectionException(0));
                    return;
                }
                ZLogger.v(String.format("target device is %s, ignore device:%s", HidDfuAdapter.this.A.toString(), bluetoothDevice.toString()));
                return;
            }
            ZLogger.v(hidDfuAdapter.j, String.format("isgnore hid state change, when state is 0x%04X", Integer.valueOf(hidDfuAdapter.p)));
        }
    }

    public HidDfuAdapter(Context context) {
        this.mContext = context;
        c();
    }

    public static HidDfuAdapter getInstance(Context context) {
        if (R == null) {
            synchronized (HidDfuAdapter.class) {
                try {
                    if (R == null) {
                        R = new HidDfuAdapter(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return R;
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

    @Override // com.realsil.sdk.dfu.utils.DfuAdapter
    public boolean connectBack() {
        if (!super.connectBack()) {
            ZLogger.v("connect back failed");
            return false;
        }
        BluetoothDevice bluetoothDevice = this.A;
        if (bluetoothDevice == null) {
            ZLogger.d("device has already been clean, no need to connect back");
            return false;
        }
        int bondState = bluetoothDevice.getBondState();
        this.B = bondState;
        if (bondState != 12) {
            ZLogger.d(this.h, "device is not bonded, maybe has something wrong");
            return false;
        }
        if (this.y.getConnectionState(4, this.A) != 2) {
            ZLogger.v("wait hid profile auto connected");
            notifyStateChanged(2048, 17);
            return true;
        }
        this.p = 2048;
        ZLogger.d(this.h, "profile has already connected, pending to connect");
        return connectDevice(this.l);
    }

    @Override // com.realsil.sdk.dfu.utils.BluetoothDfuAdapter, com.realsil.sdk.dfu.utils.DfuAdapter
    public boolean connectDevice(ConnectParams connectParams) {
        if (!super.connectDevice(connectParams)) {
            return false;
        }
        String str = this.C;
        if (str != null && !str.equals(this.l.getAddress())) {
            this.G.unRegisterCallback(this.C, this.Q);
            this.G.close(this.C);
        }
        this.A = getRemoteDevice(this.l.getAddress());
        this.C = this.l.getAddress();
        if (this.p != 512) {
            this.p = 512;
        }
        boolean d2 = d();
        if (!d2) {
            notifyStateChanged(4098);
        }
        return d2;
    }

    @Override // com.realsil.sdk.dfu.utils.BluetoothDfuAdapter, com.realsil.sdk.dfu.utils.DfuAdapter
    public void destroy() {
        super.destroy();
        GlobalGatt globalGatt = this.G;
        if (globalGatt != null) {
            globalGatt.unRegisterCallback(this.C, this.Q);
        }
        com.realsil.sdk.dfu.l.a aVar = this.L;
        if (aVar != null) {
            aVar.a();
        }
        R = null;
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
                    if (this.G.isCallbackRegisted(this.C, this.Q)) {
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
                ZLogger.d("mGlobalGatt == null");
                notifyStateChanged(4097);
            }
        }
        this.H = null;
    }

    @Override // com.realsil.sdk.dfu.utils.BluetoothDfuAdapter
    public BluetoothProfileCallback getBluetoothProfileCallback() {
        return new e();
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

    public boolean isHogpConnect(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null || BluetoothProfileManager.getInstance().getConnectionState(4, bluetoothDevice) != 2) {
            return false;
        }
        return true;
    }

    @Override // com.realsil.sdk.dfu.utils.BluetoothDfuAdapter
    public void processBondStateChanged(int i) {
        switch (i) {
            case 10:
                ZLogger.v(this.h, "BOND_NONE");
                if (checkState(512, 21)) {
                    if (this.A == null) {
                        ZLogger.v("device has already been clean");
                        notifyStateChanged(4098);
                        return;
                    } else {
                        notifyStateChanged(512, 20);
                        ZLogger.v(this.j, "createBond");
                        this.A.createBond();
                        return;
                    }
                }
                return;
            case 11:
                ZLogger.v(this.h, "BOND_BONDING");
                return;
            case 12:
                ZLogger.v(this.h, "BOND_BONDED");
                if (checkState(512, 20)) {
                    BluetoothDevice bluetoothDevice = this.A;
                    if (bluetoothDevice == null) {
                        ZLogger.v("device has already been clean");
                        notifyStateChanged(4098);
                        return;
                    } else if (!isHogpConnect(bluetoothDevice)) {
                        ZLogger.v("hid not connect");
                        a(this.A);
                        return;
                    } else {
                        ZLogger.v("hid already connected");
                        a(this.C);
                        return;
                    }
                }
                notifyLock();
                return;
            default:
                return;
        }
    }

    public void readDeviceInfo() {
        BluetoothGattService service;
        BluetoothGattService service2;
        BluetoothGatt bluetoothGatt = this.H;
        if (bluetoothGatt == null) {
            return;
        }
        ConnectParams connectParams = this.l;
        if (connectParams != null) {
            service = bluetoothGatt.getService(connectParams.getOtaServiceUuid());
            service2 = this.H.getService(this.l.getDfuServiceUuid());
        } else {
            service = bluetoothGatt.getService(o.c);
            service2 = this.H.getService(o.e);
        }
        this.I = service;
        this.J = service2;
        notifyStateChanged(this.p, 28);
        if (service == null) {
            ZLogger.d(this.h, "not find OTA_SERVICE = " + o.c);
            this.K = null;
        } else {
            ZLogger.v(this.h, "find OTA_SERVICE = " + o.c);
            this.K = service.getCharacteristic(o.d);
        }
        if (this.K != null) {
            ZLogger.v(this.h, "find CHARACTERISTIC_PROTOCOL_TYPE = " + o.d);
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
            globalGatt.unRegisterCallback(this.C, this.Q);
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

    @Override // com.realsil.sdk.dfu.utils.DfuAdapter
    public boolean validate(OtaDeviceInfo otaDeviceInfo) {
        List<SubFileInfo> list;
        if (!super.validate(otaDeviceInfo)) {
            return false;
        }
        if (this.t.isBankEnabled()) {
            if (!otaDeviceInfo.isBankEnabled()) {
                ZLogger.d("conflict: not support bank");
                return false;
            }
            if (this.t.getActiveBank() == otaDeviceInfo.getActiveBank()) {
                ZLogger.d("conflict: active bank not changed");
                return false;
            }
        } else if (this.u != null) {
            try {
                BinInfo loadImageBinInfo = FirmwareLoaderX.loadImageBinInfo(new LoadParams.Builder().with(this.mContext).fileLocation(this.u.getFileLocation()).setFilePath(this.u.getFilePath()).setSectionSizeCheckEnabled(this.u.isSectionSizeCheckEnabled()).setIcCheckEnabled(this.u.isIcCheckEnabled()).setFileSuffix(this.u.getFileSuffix()).versionCheckEnabled(true).setOtaDeviceInfo(otaDeviceInfo).build());
                if (loadImageBinInfo != null && loadImageBinInfo.status == 4096 && (list = loadImageBinInfo.supportSubFileInfos) != null && list.size() > 0) {
                    ZLogger.d("conflict: version not apply");
                    return false;
                }
            } catch (LoadFileException e2) {
                ZLogger.w(e2.toString());
            }
        }
        return true;
    }

    @Override // com.realsil.sdk.dfu.utils.DfuAdapter
    public boolean b() {
        if (!super.b()) {
            notifyStateChanged(4098);
            return false;
        }
        boolean d2 = d();
        if (!d2) {
            notifyStateChanged(4098);
        }
        return d2;
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
        boolean a2;
        int bondState = getBondState(this.C);
        this.B = bondState;
        ZLogger.v(this.h, String.format(Locale.US, ">> mBondState: %d", Integer.valueOf(bondState)));
        if (this.l.isHid()) {
            if (this.B != 12) {
                ZLogger.d(this.h, "connect with not bond device, bond first, current state: " + this.B);
                notifyStateChanged(512, 20);
                a2 = this.A.createBond();
            } else if (isHogpConnect(this.A)) {
                ZLogger.d("hogp already connected");
                a2 = a(this.C);
            } else {
                a2 = a(this.A);
            }
            return !a2 ? a(this.C) : a2;
        }
        return a(this.C);
    }

    public final boolean e() {
        if (this.q == 537) {
            ZLogger.w("discoverServices already started");
            return false;
        }
        if (this.H == null) {
            ZLogger.w("mBtGatt is null");
            return false;
        }
        notifyStateChanged(this.p | 25);
        ZLogger.v(this.j, "discoverServices...");
        if (!this.H.discoverServices()) {
            ZLogger.d("discoverServices failed");
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
                ZLogger.w(e2.toString());
            }
        }
        if (this.q == 537) {
            ZLogger.d("discoverServices timeout");
            disconnect();
            return false;
        }
        readDeviceInfo();
        return true;
    }

    public final boolean a(String str) {
        notifyStateChanged(this.p | 23);
        ZLogger.v(this.j, "connect gatt: " + this.C);
        return this.G.connect(str, this.Q);
    }

    public final void b(int i) {
        ZLogger.v(String.format("protocolType=0x%04X", Integer.valueOf(i)));
        com.realsil.sdk.dfu.l.a aVar = this.L;
        if (aVar != null) {
            aVar.a();
        }
        if (i == 16) {
            this.L = new com.realsil.sdk.dfu.r.a(i, this.l, this.C, this.H, this.I, this.J, this.M);
        } else if (i == 18) {
            this.L = new com.realsil.sdk.dfu.m.a(i, this.l, this.C, this.H, this.I, this.J, this.M);
        } else if (i == 19) {
            this.L = new com.realsil.sdk.dfu.n.a(i, this.l, this.C, this.H, this.I, this.J, this.M);
        } else {
            ConnectParams connectParams = this.l;
            this.L = new com.realsil.sdk.dfu.q.a(0, this.l, this.C, this.H, this.I, this.J, this.M, connectParams != null && "BeeTgt02".equals(connectParams.getLocalName()));
        }
        this.L.h();
    }

    public final boolean a(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return false;
        }
        notifyStateChanged(this.p | 17);
        return BluetoothProfileManager.getInstance().connectHid(bluetoothDevice);
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
