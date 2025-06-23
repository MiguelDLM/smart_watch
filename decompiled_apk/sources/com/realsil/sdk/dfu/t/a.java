package com.realsil.sdk.dfu.t;

import com.realsil.sdk.bbpro.core.transportlayer.AckPacket;
import com.realsil.sdk.bbpro.core.transportlayer.SppTransportLayer;
import com.realsil.sdk.bbpro.core.transportlayer.TransportLayerCallback;
import com.realsil.sdk.bbpro.core.transportlayer.TransportLayerPacket;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.dfu.RtkDfu;
import com.realsil.sdk.dfu.model.OtaDeviceInfo;
import com.realsil.sdk.dfu.model.OtaModeInfo;
import com.realsil.sdk.dfu.params.QcConfig;
import com.realsil.sdk.dfu.utils.ConnectParams;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes11.dex */
public class a {
    public static boolean k = true;
    public static boolean l = false;
    public static boolean m = false;

    /* renamed from: a, reason: collision with root package name */
    public int f19607a;
    public ConnectParams b;
    public int c;
    public SppTransportLayer d;
    public OtaDeviceInfo e;
    public b g;
    public List<OtaModeInfo> f = new ArrayList();
    public int h = 0;
    public final TransportLayerCallback i = new C0918a();
    public Object j = new Object();

    /* renamed from: com.realsil.sdk.dfu.t.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0918a extends TransportLayerCallback {
        public C0918a() {
        }

        @Override // com.realsil.sdk.bbpro.core.transportlayer.TransportLayerCallback
        public void onAckReceive(AckPacket ackPacket) {
            super.onAckReceive(ackPacket);
            a.this.a(ackPacket);
        }

        @Override // com.realsil.sdk.bbpro.core.transportlayer.TransportLayerCallback
        public void onDataReceive(TransportLayerPacket transportLayerPacket) {
            super.onDataReceive(transportLayerPacket);
            try {
                a.this.a(transportLayerPacket);
            } catch (Exception e) {
                ZLogger.w(e.toString());
            }
        }

        @Override // com.realsil.sdk.bbpro.core.transportlayer.TransportLayerCallback
        public void onError(int i) {
            super.onError(i);
        }
    }

    /* loaded from: classes11.dex */
    public interface b {
        void a(int i);
    }

    public void a(AckPacket ackPacket) {
    }

    public OtaDeviceInfo b() {
        if (this.e == null) {
            this.e = new OtaDeviceInfo(this.f19607a, 2);
        }
        return this.e;
    }

    public SppTransportLayer c() {
        if (this.d == null) {
            SppTransportLayer sppTransportLayer = SppTransportLayer.getInstance();
            this.d = sppTransportLayer;
            sppTransportLayer.register(this.i);
        }
        return this.d;
    }

    public List<OtaModeInfo> d() {
        return this.f;
    }

    public boolean e() {
        if ((this.c & 256) == 256) {
            return true;
        }
        return false;
    }

    public void f() {
        ArrayList arrayList = new ArrayList();
        this.f = arrayList;
        arrayList.add(new OtaModeInfo(16));
    }

    public void g() {
        if (m) {
            ZLogger.v("triggleSyncLock");
        }
        synchronized (this.j) {
            this.j.notifyAll();
        }
    }

    public void h() {
        if (m) {
            ZLogger.v("waitSyncLock");
        }
        synchronized (this.j) {
            try {
                this.j.wait(5000L);
            } catch (InterruptedException e) {
                ZLogger.v("wait sync data interrupted: " + e.toString());
            }
        }
    }

    public void a(TransportLayerPacket transportLayerPacket) {
    }

    public boolean a(OtaDeviceInfo otaDeviceInfo, QcConfig qcConfig) {
        return false;
    }

    public void a(ConnectParams connectParams, int i, b bVar) {
        boolean z = RtkDfu.DEBUG_ENABLE;
        k = z;
        l = z;
        m = RtkDfu.VDBG;
        this.b = connectParams;
        this.h = i;
        this.g = bVar;
        this.e = new OtaDeviceInfo(this.f19607a, 2);
        this.f = new ArrayList();
        SppTransportLayer sppTransportLayer = SppTransportLayer.getInstance();
        this.d = sppTransportLayer;
        sppTransportLayer.register(this.i);
    }

    public void b(int i) {
        ZLogger.d(String.format("syncState 0x%04X >> 0x%04X", Integer.valueOf(this.c), Integer.valueOf(i)));
        this.c = i;
        b bVar = this.g;
        if (bVar != null) {
            bVar.a(i);
        } else {
            ZLogger.v(m, "no callback registered");
        }
    }

    public void a() {
        this.c = 0;
        SppTransportLayer sppTransportLayer = this.d;
        if (sppTransportLayer != null) {
            sppTransportLayer.unregister(this.i);
        }
    }

    public OtaModeInfo a(int i) {
        List<OtaModeInfo> list = this.f;
        if (list != null && list.size() > 0) {
            for (OtaModeInfo otaModeInfo : this.f) {
                if (otaModeInfo != null && otaModeInfo.getWorkmode() == i) {
                    return otaModeInfo;
                }
            }
            return this.f.get(0);
        }
        return new OtaModeInfo(0);
    }
}
