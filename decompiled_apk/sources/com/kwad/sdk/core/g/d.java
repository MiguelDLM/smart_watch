package com.kwad.sdk.core.g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import androidx.annotation.Nullable;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.utils.bb;
import java.util.Random;

/* loaded from: classes11.dex */
public final class d {
    private static double aBA = 0.01d;
    private static float aBz = 9.81f;

    @Nullable
    private b aBB;

    @Nullable
    private a aBC;
    private volatile boolean aBp = true;
    private final bb.b aBw = new bb.b() { // from class: com.kwad.sdk.core.g.d.1
        @Override // com.kwad.sdk.utils.bb.b
        public final void onFailed() {
            if (d.this.aBB != null) {
                d.this.aBB.aV();
            }
        }
    };
    private float aBy;

    /* loaded from: classes11.dex */
    public class a implements SensorEventListener {
        private boolean aBF;
        private Random axO;
        private final float[] aBE = {0.0f, 0.0f, 9.8f};
        private final float[] aBG = {0.0f, 0.0f, 0.0f};

        public a() {
            this.aBF = false;
            if (((DevelopMangerComponents) com.kwad.sdk.components.c.f(DevelopMangerComponents.class)) != null) {
                this.aBF = false;
            }
        }

        private void Gh() {
            if (this.axO == null) {
                this.axO = new Random();
            }
            if (this.axO.nextInt(100) == 1) {
                a(this.aBE);
            }
        }

        private void a(float[] fArr) {
            c(fArr);
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            double abs = Math.abs(Math.sqrt((f * f) + (f2 * f2) + (f3 * f3)));
            if (b(fArr)) {
                abs = Math.abs(abs - d.aBz);
            }
            if (d.this.aBp && abs >= d.this.aBy && d.this.aBB != null) {
                d.a(d.this, false);
                d.this.aBB.a(abs);
            }
        }

        private static boolean b(float[] fArr) {
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            if (Math.abs(Math.abs(Math.sqrt(((f * f) + (f2 * f2)) + (f3 * f3))) - d.aBz) > d.aBA) {
                return false;
            }
            return true;
        }

        private void c(float[] fArr) {
            float f;
            float[] fArr2 = this.aBG;
            float f2 = fArr2[0];
            if (f2 == 0.0f && fArr2[1] == 0.0f && fArr2[2] == 0.0f) {
                f = 1.0f;
            } else {
                f = 0.6f;
            }
            float f3 = 1.0f - f;
            fArr[0] = (fArr[0] * f) + (f2 * f3);
            fArr[1] = (fArr[1] * f) + (fArr2[1] * f3);
            fArr[2] = (f * fArr[2]) + (f3 * fArr2[2]);
            System.arraycopy(fArr, 0, fArr2, 0, 3);
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            a(sensorEvent.values);
            if (this.aBF) {
                Gh();
            }
        }
    }

    public d(float f) {
        if (f <= 0.0f) {
            this.aBy = 5.0f;
        } else {
            this.aBy = f;
        }
    }

    public final synchronized void Ge() {
        this.aBp = true;
    }

    public final void bv(Context context) {
        if (context == null) {
            com.kwad.sdk.core.e.c.d("ShakeDetector", "startDetect context is null");
            return;
        }
        this.aBp = true;
        if (this.aBC == null) {
            this.aBC = new a();
        }
        bb.Nn().a(1, 2, this.aBC, this.aBw);
    }

    public final synchronized void bw(Context context) {
        if (context != null) {
            if (this.aBC != null) {
                bb.Nn().a(this.aBC);
                this.aBC = null;
            }
        }
    }

    public final void g(float f) {
        this.aBy = f;
    }

    public static /* synthetic */ boolean a(d dVar, boolean z) {
        dVar.aBp = false;
        return false;
    }

    public final void a(@Nullable b bVar) {
        this.aBB = bVar;
    }
}
