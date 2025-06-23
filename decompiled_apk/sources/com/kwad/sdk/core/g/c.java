package com.kwad.sdk.core.g;

import XIXIX.OOXIXo;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.bb;
import java.util.Arrays;
import org.apache.commons.text.ooOOo0oXI;

/* loaded from: classes11.dex */
public final class c {

    @Nullable
    private com.kwad.sdk.core.g.a aBu;

    @Nullable
    private a aBv;
    private AdMatrixInfo.RotateInfo rotateInfo;
    private volatile boolean aBp = true;
    private long aBq = 0;
    private double aBr = 9.999999717180685E-10d;
    private double[] aBs = {OOXIXo.f3760XO, OOXIXo.f3760XO, OOXIXo.f3760XO};
    private double[] aBt = {OOXIXo.f3760XO, OOXIXo.f3760XO, OOXIXo.f3760XO};
    private final bb.b aBw = new bb.b() { // from class: com.kwad.sdk.core.g.c.1
        @Override // com.kwad.sdk.utils.bb.b
        public final void onFailed() {
            if (c.this.aBu != null) {
                c.this.aBu.ls();
            }
        }
    };

    /* loaded from: classes11.dex */
    public class a implements SensorEventListener {
        private a() {
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            float[] fArr = sensorEvent.values;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            if (c.this.aBq != 0) {
                double d = (sensorEvent.timestamp - c.this.aBq) * c.this.aBr;
                double[] dArr = c.this.aBt;
                dArr[0] = dArr[0] + Math.toDegrees(f * d);
                double[] dArr2 = c.this.aBt;
                dArr2[1] = dArr2[1] + Math.toDegrees(f2 * d);
                double[] dArr3 = c.this.aBt;
                dArr3[2] = dArr3[2] + Math.toDegrees(f3 * d);
                c.this.Gb();
                c.this.Gc();
            }
            c.this.aBq = sensorEvent.timestamp;
        }

        public /* synthetic */ a(c cVar, byte b) {
            this();
        }
    }

    public c(AdMatrixInfo.RotateInfo rotateInfo) {
        this.rotateInfo = rotateInfo;
    }

    private void Ga() {
        Arrays.fill(this.aBs, OOXIXo.f3760XO);
        Arrays.fill(this.aBt, OOXIXo.f3760XO);
        this.aBq = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gb() {
        if (!this.aBp) {
            return;
        }
        if (Math.abs(this.aBt[0]) > Math.abs(this.aBs[0])) {
            this.aBs[0] = this.aBt[0];
        }
        if (Math.abs(this.aBt[1]) > Math.abs(this.aBs[1])) {
            this.aBs[1] = this.aBt[1];
        }
        if (Math.abs(this.aBt[2]) > Math.abs(this.aBs[2])) {
            this.aBs[2] = this.aBt[2];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gc() {
        AdMatrixInfo.RotateInfo rotateInfo;
        if (this.aBp && (rotateInfo = this.rotateInfo) != null && this.aBu != null) {
            if (!a(0, r0.rotateDegree, rotateInfo.x.direction)) {
                if (!a(1, r0.rotateDegree, this.rotateInfo.y.direction)) {
                    if (!a(2, r0.rotateDegree, this.rotateInfo.z.direction)) {
                        return;
                    }
                }
            }
            this.aBp = false;
            this.aBu.V(Gd());
        }
    }

    private String Gd() {
        return "{\"x\": " + this.aBs[0] + ",\"y\":" + this.aBs[1] + ",\"z\":" + this.aBs[2] + ooOOo0oXI.f33074oOoXoXO;
    }

    public final void bv(Context context) {
        if (context == null) {
            return;
        }
        Ga();
        this.aBp = true;
        if (this.aBv == null) {
            this.aBv = new a(this, (byte) 0);
        }
        bb.Nn().a(2, 2, this.aBv, this.aBw);
    }

    public final synchronized void bw(Context context) {
        if (context != null) {
            if (this.aBv != null) {
                bb.Nn().a(this.aBv);
                this.aBv = null;
            }
        }
    }

    public final void a(AdMatrixInfo.RotateInfo rotateInfo) {
        this.rotateInfo = rotateInfo;
    }

    public final void a(@Nullable com.kwad.sdk.core.g.a aVar) {
        this.aBu = aVar;
    }

    private boolean a(int i, double d, int i2) {
        if (d <= OOXIXo.f3760XO || Math.abs(this.aBt[i]) < d) {
            return false;
        }
        double d2 = this.aBt[i];
        return (d2 <= OOXIXo.f3760XO || i2 != 1) && (d2 >= OOXIXo.f3760XO || i2 != 2);
    }
}
