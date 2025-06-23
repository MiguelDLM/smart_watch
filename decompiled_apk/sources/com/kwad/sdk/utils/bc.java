package com.kwad.sdk.utils;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.kwad.sdk.utils.bb;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes11.dex */
public final class bc implements SensorEventListener {
    private final b aQX;
    private final b aQY;
    private final b aQZ;
    private boolean aRa;
    private boolean aRb;
    private final bb.b aRc;

    /* loaded from: classes11.dex */
    public static class a {
        private static final bc aRe = new bc(0);
    }

    /* loaded from: classes11.dex */
    public static class b {
        private SensorEvent aRf;
        private long timestamp;

        private b() {
        }

        public final void Q(List<com.kwad.sdk.k.a.e> list) {
            if (this.aRf == null) {
                return;
            }
            com.kwad.sdk.k.a.e eVar = new com.kwad.sdk.k.a.e();
            eVar.sensorType = this.aRf.sensor.getType();
            eVar.timestamp = this.timestamp / 1000;
            for (float f : this.aRf.values) {
                eVar.aOj.add(Float.valueOf(f));
            }
            list.add(eVar);
        }

        public final void b(SensorEvent sensorEvent) {
            this.aRf = sensorEvent;
            this.timestamp = System.currentTimeMillis();
        }

        public /* synthetic */ b(byte b) {
            this();
        }
    }

    public /* synthetic */ bc(byte b2) {
        this();
    }

    public static bc No() {
        return a.aRe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Nq() {
        if (!this.aRb) {
            return;
        }
        bb.Nn().a(this);
        this.aRb = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void register() {
        if (!this.aRa && !this.aRb) {
            this.aRb = true;
            try {
                bb.Nn().a(3, 3, this, this.aRc);
                bb.Nn().a(2, 3, this, this.aRc);
                bb.Nn().a(4, 3, this, this.aRc);
            } catch (Throwable unused) {
                this.aRa = true;
            }
        }
    }

    public final synchronized List<com.kwad.sdk.k.a.e> Np() {
        try {
            if (!o.LT()) {
                return null;
            }
            com.kwad.sdk.core.c.b.En();
            if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                register();
            }
            ArrayList arrayList = new ArrayList();
            this.aQX.Q(arrayList);
            this.aQY.Q(arrayList);
            this.aQZ.Q(arrayList);
            return arrayList;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        if (type != 1) {
            if (type != 4) {
                if (type == 9) {
                    this.aQZ.b(sensorEvent);
                    return;
                }
                return;
            }
            this.aQY.b(sensorEvent);
            return;
        }
        this.aQX.b(sensorEvent);
    }

    private bc() {
        byte b2 = 0;
        this.aQX = new b(b2);
        this.aQY = new b(b2);
        this.aQZ = new b(b2);
        this.aRa = false;
        this.aRc = new bb.b() { // from class: com.kwad.sdk.utils.bc.2
            @Override // com.kwad.sdk.utils.bb.b
            public final void onFailed() {
                bc.a(bc.this, true);
            }
        };
        com.kwad.sdk.core.c.b.En();
        com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.sdk.utils.bc.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToBackground() {
                super.onBackToBackground();
                bc.this.Nq();
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                if (o.LT()) {
                    bc.this.register();
                }
            }
        });
    }

    public static /* synthetic */ boolean a(bc bcVar, boolean z) {
        bcVar.aRa = true;
        return true;
    }
}
