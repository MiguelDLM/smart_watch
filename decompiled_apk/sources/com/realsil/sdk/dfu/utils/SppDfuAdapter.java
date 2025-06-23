package com.realsil.sdk.dfu.utils;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.realsil.sdk.bbpro.core.transportlayer.AckPacket;
import com.realsil.sdk.bbpro.core.transportlayer.SppTransportLayer;
import com.realsil.sdk.bbpro.core.transportlayer.TransportLayerCallback;
import com.realsil.sdk.bbpro.core.transportlayer.TransportLayerPacket;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.dfu.exception.ConnectionException;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.realsil.sdk.dfu.model.OtaDeviceInfo;
import com.realsil.sdk.dfu.model.OtaModeInfo;
import com.realsil.sdk.dfu.params.QcConfig;
import com.realsil.sdk.dfu.t.a;
import com.realsil.sdk.dfu.utils.DfuAdapter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.Locale;

/* loaded from: classes11.dex */
public class SppDfuAdapter extends BluetoothDfuAdapter {
    public static volatile SppDfuAdapter K;
    public SppTransportLayer G;
    public com.realsil.sdk.dfu.t.a H;
    public TransportLayerCallback I = new a();
    public final a.b J = new b();

    /* loaded from: classes11.dex */
    public class a extends TransportLayerCallback {
        public a() {
        }

        @Override // com.realsil.sdk.bbpro.core.transportlayer.TransportLayerCallback
        public void onAckReceive(AckPacket ackPacket) {
            super.onAckReceive(ackPacket);
            SppDfuAdapter.this.a(ackPacket);
        }

        @Override // com.realsil.sdk.bbpro.core.transportlayer.TransportLayerCallback
        public void onConnectionStateChanged(BluetoothDevice bluetoothDevice, boolean z, int i) {
            super.onConnectionStateChanged(bluetoothDevice, z, i);
            if (i == 2) {
                SppDfuAdapter.this.notifyLock();
                if (SppDfuAdapter.this.isPreparing()) {
                    SppDfuAdapter.this.notifyStateChanged(539);
                    if (!SppDfuAdapter.this.d().sendCmd((short) 1548, null)) {
                        SppDfuAdapter sppDfuAdapter = SppDfuAdapter.this;
                        if (sppDfuAdapter.h) {
                            ZLogger.d(sppDfuAdapter.getOtaDeviceInfo().toString());
                        }
                        SppDfuAdapter.this.notifyStateChanged(527);
                        return;
                    }
                    return;
                }
                ZLogger.d(String.format("ignore connection update when state=0x%04X", Integer.valueOf(SppDfuAdapter.this.q)));
                return;
            }
            if (i == 0) {
                SppDfuAdapter sppDfuAdapter2 = SppDfuAdapter.this;
                if (sppDfuAdapter2.q == 535) {
                    sppDfuAdapter2.a(new ConnectionException(6));
                }
                SppDfuAdapter.this.notifyStateChanged(4097);
            }
        }

        @Override // com.realsil.sdk.bbpro.core.transportlayer.TransportLayerCallback
        public void onDataReceive(TransportLayerPacket transportLayerPacket) {
            super.onDataReceive(transportLayerPacket);
            try {
                SppDfuAdapter.this.a(transportLayerPacket);
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
    public class b implements a.b {
        public b() {
        }

        @Override // com.realsil.sdk.dfu.t.a.b
        public void a(int i) {
            if (i != 1) {
                if (i == 2) {
                    SppDfuAdapter sppDfuAdapter = SppDfuAdapter.this;
                    if (sppDfuAdapter.q == 535) {
                        sppDfuAdapter.a(new ConnectionException(5));
                        return;
                    }
                    return;
                }
                return;
            }
            if (SppDfuAdapter.this.isPreparing()) {
                SppDfuAdapter sppDfuAdapter2 = SppDfuAdapter.this;
                sppDfuAdapter2.t = sppDfuAdapter2.getOtaDeviceInfo();
                SppDfuAdapter.this.notifyStateChanged(527);
            }
        }
    }

    public SppDfuAdapter(Context context) {
        this.mContext = context;
        c();
    }

    public static SppDfuAdapter getInstance(Context context) {
        if (K == null) {
            synchronized (SppDfuAdapter.class) {
                try {
                    if (K == null) {
                        K = new SppDfuAdapter(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return K;
    }

    @Override // com.realsil.sdk.dfu.utils.DfuAdapter
    public boolean b() {
        if (!super.b()) {
            notifyStateChanged(4098);
            return false;
        }
        notifyStateChanged(DfuAdapter.STATE_PREPARE_CONNECTING);
        d().register(this.I);
        boolean connect = d().connect(this.A, null);
        if (!connect) {
            notifyStateChanged(4098);
        }
        return connect;
    }

    @Override // com.realsil.sdk.dfu.utils.BluetoothDfuAdapter
    public void c() {
        super.c();
        d();
    }

    @Override // com.realsil.sdk.dfu.utils.BluetoothDfuAdapter, com.realsil.sdk.dfu.utils.DfuAdapter
    public boolean connectDevice(ConnectParams connectParams) {
        if (!super.connectDevice(connectParams)) {
            return false;
        }
        this.C = connectParams.getAddress();
        this.A = getRemoteDevice(connectParams.getAddress());
        int bondState = getBondState(connectParams.getAddress());
        this.B = bondState;
        ZLogger.v(this.h, String.format(Locale.US, ">> mBondState: %d", Integer.valueOf(bondState)));
        if (this.l.isCreateBond() && this.B != 12) {
            notifyStateChanged(512, 20);
            return this.A.createBond();
        }
        notifyStateChanged(DfuAdapter.STATE_PREPARE_CONNECTING);
        d().register(this.I);
        return d().connect(this.A, null);
    }

    public final SppTransportLayer d() {
        if (this.G == null) {
            SppTransportLayer sppTransportLayer = SppTransportLayer.getInstance();
            this.G = sppTransportLayer;
            sppTransportLayer.register(this.I);
        }
        return this.G;
    }

    @Override // com.realsil.sdk.dfu.utils.BluetoothDfuAdapter, com.realsil.sdk.dfu.utils.DfuAdapter
    public void destroy() {
        super.destroy();
        SppTransportLayer sppTransportLayer = this.G;
        if (sppTransportLayer != null) {
            sppTransportLayer.unregister(this.I);
        }
        com.realsil.sdk.dfu.t.a aVar = this.H;
        if (aVar != null) {
            aVar.a();
        }
        K = null;
    }

    @Override // com.realsil.sdk.dfu.utils.DfuAdapter
    public void disconnect() {
        super.disconnect();
        notifyStateChanged(4096);
        d().disconnect();
    }

    @Override // com.realsil.sdk.dfu.utils.BluetoothDfuAdapter
    public OtaDeviceInfo getOtaDeviceInfo() {
        com.realsil.sdk.dfu.t.a aVar = this.H;
        if (aVar != null) {
            return aVar.b();
        }
        return super.getOtaDeviceInfo();
    }

    @Override // com.realsil.sdk.dfu.utils.DfuAdapter
    public OtaModeInfo getPriorityWorkMode(int i) {
        com.realsil.sdk.dfu.t.a aVar = this.H;
        if (aVar != null) {
            return aVar.a(i);
        }
        return super.getPriorityWorkMode(i);
    }

    @Override // com.realsil.sdk.dfu.utils.DfuAdapter
    public List<OtaModeInfo> getSupportedModes() {
        com.realsil.sdk.dfu.t.a aVar = this.H;
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
                if (this.q == 532) {
                    if (this.A != null) {
                        notifyStateChanged(DfuAdapter.STATE_PREPARE_CONNECTING);
                        d().register(this.I);
                        d().connect(this.A, null);
                        return;
                    }
                    return;
                }
                notifyLock();
                return;
            default:
                return;
        }
    }

    @Override // com.realsil.sdk.dfu.utils.DfuAdapter
    public boolean setTestParams(OtaDeviceInfo otaDeviceInfo, QcConfig qcConfig) {
        if (otaDeviceInfo != null && qcConfig != null) {
            com.realsil.sdk.dfu.t.a aVar = this.H;
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
        d().unregister(this.I);
        com.realsil.sdk.dfu.t.a aVar = this.H;
        if (aVar != null) {
            aVar.a();
        }
        boolean a2 = this.k.a(dfuConfig, qcConfig);
        if (!a2) {
            notifyStateChanged(1026);
        }
        return a2;
    }

    public final void a(AckPacket ackPacket) {
        short toAckId = ackPacket.getToAckId();
        byte status = ackPacket.getStatus();
        if (toAckId != 1548) {
            return;
        }
        if (status != 2 && status != 1) {
            ZLogger.v(this.j, "ACK-CMD_OTA_PROTOCOL_TYPE");
            return;
        }
        ZLogger.d("CMD_OTA_PROTOCOL_TYPE not support");
        if (this.q == 539) {
            b(0);
            this.H.f();
        }
    }

    public SppDfuAdapter(Context context, DfuAdapter.DfuHelperCallback dfuHelperCallback) {
        this.mContext = context;
        this.n = dfuHelperCallback;
        c();
    }

    public static SppDfuAdapter getInstance(Context context, DfuAdapter.DfuHelperCallback dfuHelperCallback) {
        if (K == null) {
            synchronized (SppDfuAdapter.class) {
                try {
                    if (K == null) {
                        K = new SppDfuAdapter(context.getApplicationContext(), dfuHelperCallback);
                    }
                } finally {
                }
            }
        }
        return K;
    }

    public final void b(int i) {
        ZLogger.v(String.format("protocolType=0x%04X", Integer.valueOf(i)));
        com.realsil.sdk.dfu.t.a aVar = this.H;
        if (aVar != null) {
            aVar.a();
        }
        if (i == 17) {
            this.H = new com.realsil.sdk.dfu.v.a();
        } else {
            this.H = new com.realsil.sdk.dfu.u.a();
        }
        this.H.a(this.l, this.r, this.J);
    }

    public final void a(TransportLayerPacket transportLayerPacket) {
        short opcode = transportLayerPacket.getOpcode();
        transportLayerPacket.getPayload();
        byte[] parameters = transportLayerPacket.getParameters();
        if (opcode != 1546) {
            return;
        }
        ByteBuffer wrap = ByteBuffer.wrap(parameters);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        short s = wrap.getShort(0);
        ZLogger.v(this.i, String.format("protocolType=0x%04X, specVersion=0x%04X", Integer.valueOf(s), Integer.valueOf(parameters.length > 2 ? wrap.get(2) : (byte) -1)));
        b(s);
        this.H.f();
    }
}
