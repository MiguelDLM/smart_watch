package com.realsil.sdk.dfu.utils;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.google.android.exoplayer2.C;
import com.realsil.sdk.bbpro.core.transportlayer.AckPacket;
import com.realsil.sdk.bbpro.core.transportlayer.SppTransportLayer;
import com.realsil.sdk.bbpro.core.transportlayer.TransportLayerCallback;
import com.realsil.sdk.bbpro.core.transportlayer.TransportLayerPacket;
import com.realsil.sdk.core.bluetooth.BluetoothProfileCallback;
import com.realsil.sdk.core.bluetooth.BluetoothProfileManager;
import com.realsil.sdk.core.bluetooth.impl.BluetoothDeviceImpl;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.dfu.exception.ConnectionException;
import com.realsil.sdk.dfu.exception.LoadFileException;
import com.realsil.sdk.dfu.image.FirmwareLoaderX;
import com.realsil.sdk.dfu.image.LoadParams;
import com.realsil.sdk.dfu.image.pack.SubFileInfo;
import com.realsil.sdk.dfu.model.BinInfo;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.realsil.sdk.dfu.model.OtaDeviceInfo;
import com.realsil.sdk.dfu.model.OtaModeInfo;
import com.realsil.sdk.dfu.params.QcConfig;
import com.realsil.sdk.dfu.t.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes11.dex */
public class HeadsetDfuAdapter extends BluetoothDfuAdapter {
    public static volatile HeadsetDfuAdapter N;
    public ThreadPoolExecutor G;
    public SppTransportLayer H;
    public com.realsil.sdk.dfu.t.a I;
    public int J;
    public final Runnable K = new a();
    public TransportLayerCallback L = new c();
    public final a.b M = new d();

    /* loaded from: classes11.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HeadsetDfuAdapter headsetDfuAdapter = HeadsetDfuAdapter.this;
            if (headsetDfuAdapter.p != 512) {
                headsetDfuAdapter.p = 512;
            }
            if (headsetDfuAdapter.g()) {
                HeadsetDfuAdapter.this.e();
                HeadsetDfuAdapter.this.f();
            } else {
                ZLogger.w("device has not been paired, just ignore here");
            }
            HeadsetDfuAdapter headsetDfuAdapter2 = HeadsetDfuAdapter.this;
            headsetDfuAdapter2.notifyStateChanged(headsetDfuAdapter2.p | 23);
            HeadsetDfuAdapter.this.h().register(HeadsetDfuAdapter.this.L);
            if (!HeadsetDfuAdapter.this.h().connect(HeadsetDfuAdapter.this.A, null)) {
                ZLogger.w("connect failed");
                HeadsetDfuAdapter.this.notifyStateChanged(4098);
                return;
            }
            ZLogger.v(HeadsetDfuAdapter.this.j, "wait connect result");
            HeadsetDfuAdapter.this.a(30000L);
            if (HeadsetDfuAdapter.this.h().isConnected(HeadsetDfuAdapter.this.A)) {
                HeadsetDfuAdapter.this.J = 0;
                HeadsetDfuAdapter headsetDfuAdapter3 = HeadsetDfuAdapter.this;
                headsetDfuAdapter3.notifyStateChanged(headsetDfuAdapter3.p, 28);
                if (!HeadsetDfuAdapter.this.h().sendCmd((short) 1548, null)) {
                    HeadsetDfuAdapter headsetDfuAdapter4 = HeadsetDfuAdapter.this;
                    if (headsetDfuAdapter4.h) {
                        ZLogger.d(headsetDfuAdapter4.getOtaDeviceInfo().toString());
                    }
                    HeadsetDfuAdapter.this.notifyStateChanged(527);
                    HeadsetDfuAdapter.this.notifyLock();
                    HeadsetDfuAdapter.this.d();
                    return;
                }
                HeadsetDfuAdapter.this.a(10000L);
                if (HeadsetDfuAdapter.this.checkState(512, 28) || HeadsetDfuAdapter.this.checkState(2048, 28)) {
                    HeadsetDfuAdapter headsetDfuAdapter5 = HeadsetDfuAdapter.this;
                    headsetDfuAdapter5.b(headsetDfuAdapter5.J);
                    HeadsetDfuAdapter.this.I.f();
                    return;
                }
                return;
            }
            ZLogger.d(String.format("connect failed, state=0x%04X", Integer.valueOf(HeadsetDfuAdapter.this.q)));
            HeadsetDfuAdapter.this.notifyStateChanged(4098);
        }
    }

    /* loaded from: classes11.dex */
    public class b extends BluetoothProfileCallback {
        public b() {
        }

        @Override // com.realsil.sdk.core.bluetooth.BluetoothProfileCallback
        public void onA2dpStateChanged(BluetoothDevice bluetoothDevice, int i) {
            super.onA2dpStateChanged(bluetoothDevice, i);
            if (HeadsetDfuAdapter.this.checkState(512, 18)) {
                BluetoothDevice bluetoothDevice2 = HeadsetDfuAdapter.this.A;
                if (bluetoothDevice2 == null) {
                    ZLogger.v("device has already been clean");
                    HeadsetDfuAdapter.this.notifyStateChanged(4098);
                    return;
                }
                if (!bluetoothDevice2.equals(bluetoothDevice)) {
                    HeadsetDfuAdapter headsetDfuAdapter = HeadsetDfuAdapter.this;
                    ZLogger.v(headsetDfuAdapter.i, String.format("target device is %s, ignore device:%s", headsetDfuAdapter.A.toString(), bluetoothDevice.toString()));
                    return;
                } else if (i == 2) {
                    ZLogger.v("A2DP connected");
                    HeadsetDfuAdapter.this.notifyLock();
                    return;
                } else {
                    if (i == 0) {
                        ZLogger.v("A2DP disconnected");
                        HeadsetDfuAdapter.this.notifyLock();
                        return;
                    }
                    return;
                }
            }
            HeadsetDfuAdapter headsetDfuAdapter2 = HeadsetDfuAdapter.this;
            ZLogger.v(headsetDfuAdapter2.j, String.format("ignore a2dp state change, when state=0x%04X", Integer.valueOf(headsetDfuAdapter2.q)));
        }

        @Override // com.realsil.sdk.core.bluetooth.BluetoothProfileCallback
        public void onHfpConnectionStateChanged(BluetoothDevice bluetoothDevice, int i) {
            super.onHfpConnectionStateChanged(bluetoothDevice, i);
            if (HeadsetDfuAdapter.this.checkState(512, 19)) {
                BluetoothDevice bluetoothDevice2 = HeadsetDfuAdapter.this.A;
                if (bluetoothDevice2 == null) {
                    ZLogger.v("device has already been clean");
                    HeadsetDfuAdapter.this.notifyStateChanged(4098);
                    return;
                }
                if (!bluetoothDevice2.equals(bluetoothDevice)) {
                    HeadsetDfuAdapter headsetDfuAdapter = HeadsetDfuAdapter.this;
                    ZLogger.v(headsetDfuAdapter.i, String.format("target device is %s, ignore device:%s", headsetDfuAdapter.A.toString(), bluetoothDevice.toString()));
                    return;
                } else if (i == 2) {
                    ZLogger.v("hfp connected");
                    HeadsetDfuAdapter.this.notifyLock();
                    return;
                } else {
                    if (i == 0) {
                        ZLogger.v("hfp disconnected");
                        HeadsetDfuAdapter.this.notifyLock();
                        return;
                    }
                    return;
                }
            }
            if (HeadsetDfuAdapter.this.checkState(2048, 19)) {
                BluetoothDevice bluetoothDevice3 = HeadsetDfuAdapter.this.A;
                if (bluetoothDevice3 == null) {
                    ZLogger.v("device has already been clean");
                    HeadsetDfuAdapter.this.notifyStateChanged(DfuAdapter.STATE_BACKCONNECT_FAILED);
                    return;
                }
                if (bluetoothDevice3.equals(bluetoothDevice)) {
                    if (i == 2) {
                        ZLogger.v("pending to back connect with previous device");
                        HeadsetDfuAdapter headsetDfuAdapter2 = HeadsetDfuAdapter.this;
                        headsetDfuAdapter2.connectDevice(headsetDfuAdapter2.l);
                        return;
                    } else {
                        if (i == 0) {
                            ZLogger.v("proile disconnected");
                            HeadsetDfuAdapter.this.notifyStateChanged(DfuAdapter.STATE_BACKCONNECT_FAILED);
                            return;
                        }
                        return;
                    }
                }
                ZLogger.v(String.format("target device is %s, ignore device:%s", HeadsetDfuAdapter.this.A.toString(), bluetoothDevice.toString()));
                return;
            }
            HeadsetDfuAdapter headsetDfuAdapter3 = HeadsetDfuAdapter.this;
            ZLogger.v(headsetDfuAdapter3.i, String.format("ignore hfp state change when state is 0x%04X", Integer.valueOf(headsetDfuAdapter3.q)));
        }
    }

    /* loaded from: classes11.dex */
    public class c extends TransportLayerCallback {
        public c() {
        }

        @Override // com.realsil.sdk.bbpro.core.transportlayer.TransportLayerCallback
        public void onAckReceive(AckPacket ackPacket) {
            super.onAckReceive(ackPacket);
            HeadsetDfuAdapter.this.a(ackPacket);
        }

        @Override // com.realsil.sdk.bbpro.core.transportlayer.TransportLayerCallback
        public void onConnectionStateChanged(BluetoothDevice bluetoothDevice, boolean z, int i) {
            super.onConnectionStateChanged(bluetoothDevice, z, i);
            if (i == 2) {
                if (!HeadsetDfuAdapter.this.isPreparing() && !HeadsetDfuAdapter.this.isBackConnecting()) {
                    HeadsetDfuAdapter.this.notifyLock();
                    ZLogger.d(String.format("ignore connection update when state=0x%04X", Integer.valueOf(HeadsetDfuAdapter.this.q)));
                    return;
                } else {
                    HeadsetDfuAdapter.this.notifyLock();
                    return;
                }
            }
            if (i == 0) {
                if (HeadsetDfuAdapter.this.isStageBusy(512) || HeadsetDfuAdapter.this.isStageBusy(2048)) {
                    HeadsetDfuAdapter.this.a(new ConnectionException(6));
                }
                HeadsetDfuAdapter.this.notifyStateChanged(4097);
            }
        }

        @Override // com.realsil.sdk.bbpro.core.transportlayer.TransportLayerCallback
        public void onDataReceive(TransportLayerPacket transportLayerPacket) {
            super.onDataReceive(transportLayerPacket);
            try {
                HeadsetDfuAdapter.this.a(transportLayerPacket);
            } catch (Exception e) {
                ZLogger.e(e.toString());
            }
        }

        @Override // com.realsil.sdk.bbpro.core.transportlayer.TransportLayerCallback
        public void onError(int i) {
            super.onError(i);
        }
    }

    /* loaded from: classes11.dex */
    public class d implements a.b {
        public d() {
        }

        @Override // com.realsil.sdk.dfu.t.a.b
        public void a(int i) {
            if (i != 1) {
                if (i == 2) {
                    if (HeadsetDfuAdapter.this.isPreparing() || HeadsetDfuAdapter.this.isBackConnecting()) {
                        HeadsetDfuAdapter.this.a(new ConnectionException(5));
                        return;
                    }
                    return;
                }
                return;
            }
            if (HeadsetDfuAdapter.this.isPreparing()) {
                HeadsetDfuAdapter headsetDfuAdapter = HeadsetDfuAdapter.this;
                headsetDfuAdapter.t = headsetDfuAdapter.getOtaDeviceInfo();
                HeadsetDfuAdapter.this.notifyStateChanged(527);
            } else {
                if (HeadsetDfuAdapter.this.isBackConnecting()) {
                    if (HeadsetDfuAdapter.this.a()) {
                        HeadsetDfuAdapter.this.notifyStateChanged(DfuAdapter.STATE_BACKCONNECT_VALIDATE);
                        HeadsetDfuAdapter headsetDfuAdapter2 = HeadsetDfuAdapter.this;
                        if (!headsetDfuAdapter2.validate(headsetDfuAdapter2.getOtaDeviceInfo())) {
                            HeadsetDfuAdapter.this.notifyStateChanged(2061);
                            return;
                        } else {
                            HeadsetDfuAdapter.this.notifyStateChanged(DfuAdapter.STATE_BACKCONNECT_COMPLETED);
                            return;
                        }
                    }
                    HeadsetDfuAdapter.this.notifyStateChanged(DfuAdapter.STATE_BACKCONNECT_COMPLETED);
                    return;
                }
                HeadsetDfuAdapter headsetDfuAdapter3 = HeadsetDfuAdapter.this;
                ZLogger.v(headsetDfuAdapter3.j, String.format("ignore, is not in preparing or backconnect state: 0x%04X", Integer.valueOf(headsetDfuAdapter3.q)));
            }
        }
    }

    public HeadsetDfuAdapter(Context context) {
        this.mContext = context;
        c();
    }

    public static HeadsetDfuAdapter getInstance(Context context) {
        if (N == null) {
            synchronized (HeadsetDfuAdapter.class) {
                try {
                    if (N == null) {
                        N = new HeadsetDfuAdapter(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return N;
    }

    @Override // com.realsil.sdk.dfu.utils.DfuAdapter
    public boolean connectBack() {
        if (!super.connectBack()) {
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
        if (this.y.getConnectionState(1, this.A) != 2) {
            ZLogger.v("wait hfp profile auto connected");
            notifyStateChanged(2048, 19);
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
        this.C = connectParams.getAddress();
        this.A = getRemoteDevice(connectParams.getAddress());
        this.G.execute(this.K);
        return true;
    }

    @Override // com.realsil.sdk.dfu.utils.BluetoothDfuAdapter, com.realsil.sdk.dfu.utils.DfuAdapter
    public void destroy() {
        super.destroy();
        SppTransportLayer sppTransportLayer = this.H;
        if (sppTransportLayer != null) {
            sppTransportLayer.unregister(this.L);
        }
        com.realsil.sdk.dfu.t.a aVar = this.I;
        if (aVar != null) {
            aVar.a();
        }
        ThreadPoolExecutor threadPoolExecutor = this.G;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdown();
        }
        N = null;
    }

    @Override // com.realsil.sdk.dfu.utils.DfuAdapter
    public void disconnect() {
        super.disconnect();
        notifyStateChanged(4096);
        h().disconnect();
        this.G.remove(this.K);
    }

    @Override // com.realsil.sdk.dfu.utils.BluetoothDfuAdapter
    public BluetoothProfileCallback getBluetoothProfileCallback() {
        return new b();
    }

    @Override // com.realsil.sdk.dfu.utils.BluetoothDfuAdapter
    public OtaDeviceInfo getOtaDeviceInfo() {
        com.realsil.sdk.dfu.t.a aVar = this.I;
        if (aVar != null) {
            return aVar.b();
        }
        return super.getOtaDeviceInfo();
    }

    @Override // com.realsil.sdk.dfu.utils.DfuAdapter
    public OtaModeInfo getPriorityWorkMode(int i) {
        com.realsil.sdk.dfu.t.a aVar = this.I;
        if (aVar != null) {
            return aVar.a(i);
        }
        return super.getPriorityWorkMode(i);
    }

    @Override // com.realsil.sdk.dfu.utils.DfuAdapter
    public List<OtaModeInfo> getSupportedModes() {
        com.realsil.sdk.dfu.t.a aVar = this.I;
        if (aVar != null) {
            return aVar.d();
        }
        return super.getSupportedModes();
    }

    @Override // com.realsil.sdk.dfu.utils.BluetoothDfuAdapter
    public void processBondStateChanged(int i) {
        switch (i) {
            case 10:
                ZLogger.v(this.h, "BOND_NONE");
                return;
            case 11:
                ZLogger.v(this.h, "BOND_BONDING");
                return;
            case 12:
                ZLogger.v(this.h, "BOND_BONDED");
                if (checkState(512, 20)) {
                    notifyLock();
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.realsil.sdk.dfu.utils.DfuAdapter
    public boolean setTestParams(OtaDeviceInfo otaDeviceInfo, QcConfig qcConfig) {
        if (otaDeviceInfo != null && qcConfig != null) {
            com.realsil.sdk.dfu.t.a aVar = this.I;
            if (aVar == null) {
                return false;
            }
            return aVar.a(otaDeviceInfo, qcConfig);
        }
        ZLogger.d("IllegalArgumentException: deviceInfo and params can not be null");
        return false;
    }

    @Override // com.realsil.sdk.dfu.utils.BluetoothDfuAdapter
    public boolean startOtaProcedure(OtaDeviceInfo otaDeviceInfo, DfuConfig dfuConfig, QcConfig qcConfig, boolean z) {
        if (!super.startOtaProcedure(otaDeviceInfo, dfuConfig, qcConfig, z)) {
            return false;
        }
        notifyStateChanged(1025);
        h().unregister(this.L);
        com.realsil.sdk.dfu.t.a aVar = this.I;
        if (aVar != null) {
            aVar.a();
        }
        boolean a2 = this.k.a(dfuConfig, qcConfig);
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
            } catch (LoadFileException e) {
                ZLogger.w(e.toString());
            }
        }
        return true;
    }

    @Override // com.realsil.sdk.dfu.utils.BluetoothDfuAdapter
    public void c() {
        super.c();
        h();
        this.G = new ThreadPoolExecutor(10, 10, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadPoolExecutor.AbortPolicy());
    }

    public final void d() {
        int connectionState = BluetoothProfileManager.getInstance().getConnectionState(2, this.A);
        ZLogger.v(this.j, String.format("a2dpState = 0x%02X", Integer.valueOf(connectionState)));
        if (connectionState == 0 && !BluetoothProfileManager.getInstance().connectA2dpSource(this.C)) {
            ZLogger.w("connect A2DP failed");
        }
        int connectionState2 = BluetoothProfileManager.getInstance().getConnectionState(1, this.A);
        ZLogger.v(this.j, String.format("hfpState = 0x%02X", Integer.valueOf(connectionState2)));
        if (connectionState2 != 0 || BluetoothProfileManager.getInstance().connectHfpAg(this.C)) {
            return;
        }
        ZLogger.w("connect Hfp failed");
    }

    public final void e() {
        int connectionState = BluetoothProfileManager.getInstance().getConnectionState(2, this.A);
        if (2 == connectionState) {
            ZLogger.v("A2DP already connected");
            return;
        }
        if (1 == connectionState) {
            ZLogger.d(this.i, "A2DP already connecting..., wait create A2DP result");
            notifyStateChanged(this.p, 18);
            a(30000L);
            int connectionState2 = BluetoothProfileManager.getInstance().getConnectionState(2, this.A);
            ZLogger.v(this.j, String.format("a2dpState = 0x%02X", Integer.valueOf(connectionState2)));
            if (2 == connectionState2) {
                return;
            } else {
                ZLogger.d("A2DP back connect failed");
            }
        } else {
            ZLogger.v(this.j, String.format("a2dpState = 0x%02X", Integer.valueOf(connectionState)));
        }
        notifyStateChanged(this.p, 18);
        if (!BluetoothProfileManager.getInstance().connectA2dpSource(this.C)) {
            ZLogger.w("connect A2DP failed");
            return;
        }
        ZLogger.v(this.j, "wait create A2DP result");
        a(C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
        int connectionState3 = BluetoothProfileManager.getInstance().getConnectionState(2, this.A);
        ZLogger.v(this.j, String.format("a2dpState = 0x%02X", Integer.valueOf(connectionState3)));
        if (2 != connectionState3) {
            ZLogger.d("A2DP connect failed");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f() {
        /*
            r9 = this;
            com.realsil.sdk.core.bluetooth.BluetoothProfileManager r0 = com.realsil.sdk.core.bluetooth.BluetoothProfileManager.getInstance()
            android.bluetooth.BluetoothDevice r1 = r9.A
            r2 = 1
            int r0 = r0.getConnectionState(r2, r1)
            r1 = 19
            java.lang.String r3 = "hfpState = 0x%02X"
            r4 = 0
            r5 = 2
            if (r5 != r0) goto L1a
            java.lang.String r6 = "HFP already connected"
            com.realsil.sdk.core.logger.ZLogger.v(r6)
        L18:
            r6 = 0
            goto L50
        L1a:
            if (r2 != r0) goto L4f
            boolean r0 = r9.i
            java.lang.String r6 = "HFP already connecting..., wait create hfp result"
            com.realsil.sdk.core.logger.ZLogger.d(r0, r6)
            int r0 = r9.p
            r9.notifyStateChanged(r0, r1)
            r6 = 15000(0x3a98, double:7.411E-320)
            r9.a(r6)
            com.realsil.sdk.core.bluetooth.BluetoothProfileManager r0 = com.realsil.sdk.core.bluetooth.BluetoothProfileManager.getInstance()
            android.bluetooth.BluetoothDevice r6 = r9.A
            int r0 = r0.getConnectionState(r2, r6)
            boolean r6 = r9.j
            java.lang.Integer r7 = java.lang.Integer.valueOf(r0)
            java.lang.Object[] r8 = new java.lang.Object[r2]
            r8[r4] = r7
            java.lang.String r7 = java.lang.String.format(r3, r8)
            com.realsil.sdk.core.logger.ZLogger.v(r6, r7)
            if (r5 == r0) goto L18
            java.lang.String r6 = "hfp back connect failed"
            com.realsil.sdk.core.logger.ZLogger.d(r6)
        L4f:
            r6 = 1
        L50:
            if (r6 == 0) goto La8
            boolean r6 = r9.j
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Object[] r7 = new java.lang.Object[r2]
            r7[r4] = r0
            java.lang.String r0 = java.lang.String.format(r3, r7)
            com.realsil.sdk.core.logger.ZLogger.v(r6, r0)
            int r0 = r9.p
            r9.notifyStateChanged(r0, r1)
            com.realsil.sdk.core.bluetooth.BluetoothProfileManager r0 = com.realsil.sdk.core.bluetooth.BluetoothProfileManager.getInstance()
            java.lang.String r1 = r9.C
            boolean r0 = r0.connectHfpAg(r1)
            if (r0 != 0) goto L7a
            java.lang.String r0 = "connect Hfp failed"
            com.realsil.sdk.core.logger.ZLogger.w(r0)
            goto La8
        L7a:
            boolean r0 = r9.j
            java.lang.String r1 = "wait create hfp result"
            com.realsil.sdk.core.logger.ZLogger.v(r0, r1)
            r0 = 30000(0x7530, double:1.4822E-319)
            r9.a(r0)
            com.realsil.sdk.core.bluetooth.BluetoothProfileManager r0 = com.realsil.sdk.core.bluetooth.BluetoothProfileManager.getInstance()
            android.bluetooth.BluetoothDevice r1 = r9.A
            int r0 = r0.getConnectionState(r2, r1)
            boolean r1 = r9.j
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r4] = r6
            java.lang.String r2 = java.lang.String.format(r3, r2)
            com.realsil.sdk.core.logger.ZLogger.v(r1, r2)
            if (r5 == r0) goto La8
            java.lang.String r0 = "hfp connect failed"
            com.realsil.sdk.core.logger.ZLogger.d(r0)
        La8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.realsil.sdk.dfu.utils.HeadsetDfuAdapter.f():void");
    }

    public final boolean g() {
        int bondState = getBondState(this.C);
        this.B = bondState;
        if (bondState == 11) {
            ZLogger.v(this.j, "is bonding..., wait bonding result");
            a(30000L);
            int bondState2 = getBondState(this.C);
            this.B = bondState2;
            if (bondState2 != 12) {
                ZLogger.d(this.h, "bonding failed, maybe link key lost, force to remove bond here");
                BluetoothDeviceImpl.removeBond(this.A);
                a(1000L);
            }
        }
        if (this.B == 10) {
            notifyStateChanged(this.p, 20);
            if (!this.A.createBond()) {
                ZLogger.w(this.h, "createBond failed");
            } else {
                ZLogger.v(this.j, "wait create bond result");
                a(30000L);
            }
        }
        int bondState3 = getBondState(this.C);
        this.B = bondState3;
        ZLogger.v(this.j, String.format(Locale.US, ">> mBondState: %d", Integer.valueOf(bondState3)));
        return this.B == 12;
    }

    public final SppTransportLayer h() {
        if (this.H == null) {
            SppTransportLayer sppTransportLayer = SppTransportLayer.getInstance();
            this.H = sppTransportLayer;
            sppTransportLayer.register(this.L);
        }
        return this.H;
    }

    @Override // com.realsil.sdk.dfu.utils.DfuAdapter
    public boolean b() {
        if (!super.b()) {
            notifyStateChanged(4098);
            return false;
        }
        notifyStateChanged(DfuAdapter.STATE_PREPARE_CONNECTING);
        h().register(this.L);
        boolean connect = h().connect(this.A, null);
        if (!connect) {
            notifyStateChanged(4098);
        }
        return connect;
    }

    public final void a(AckPacket ackPacket) {
        short toAckId = ackPacket.getToAckId();
        byte status = ackPacket.getStatus();
        if (toAckId != 1548) {
            return;
        }
        if (checkState(512, 28) || checkState(2048, 28)) {
            if (status != 2 && status != 1) {
                ZLogger.v(this.j, "ACK-CMD_OTA_PROTOCOL_TYPE");
                return;
            }
            ZLogger.d("CMD_OTA_PROTOCOL_TYPE not support");
            this.J = 0;
            notifyLock();
        }
    }

    public final synchronized void b(int i) {
        try {
            ZLogger.v(this.i, String.format("initSubAdapter, protocolType=0x%04X", Integer.valueOf(i)));
            com.realsil.sdk.dfu.t.a aVar = this.I;
            if (aVar != null) {
                aVar.a();
            }
            if (i == 17) {
                this.I = new com.realsil.sdk.dfu.v.a();
            } else {
                this.I = new com.realsil.sdk.dfu.u.a();
            }
            this.I.a(this.l, this.r, this.M);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void a(TransportLayerPacket transportLayerPacket) {
        short opcode = transportLayerPacket.getOpcode();
        transportLayerPacket.getPayload();
        byte[] parameters = transportLayerPacket.getParameters();
        if (opcode != 1546) {
            return;
        }
        if (checkState(512, 28) || checkState(2048, 28)) {
            ByteBuffer wrap = ByteBuffer.wrap(parameters);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            this.J = wrap.getShort(0);
            ZLogger.v(this.i, String.format("protocolType=0x%04X, specVersion=0x%04X", Integer.valueOf(this.J), Integer.valueOf(parameters.length > 2 ? wrap.get(2) : (byte) -1)));
            notifyLock();
        }
    }
}
