package com.baidu.ar;

import XIXIX.OOXIXo;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import com.baidu.ar.arplay.representation.Quaternion;

/* loaded from: classes7.dex */
public class ff extends fl {
    private static final String TAG = "ff";
    private int sA;
    private final Quaternion so;
    private int sp;
    private double sq;
    private Quaternion sx;
    private Quaternion sy;
    private boolean sz;
    private long timestamp;

    public ff(SensorManager sensorManager) {
        super(sensorManager);
        this.so = new Quaternion();
        this.sx = new Quaternion();
        this.sy = new Quaternion();
        this.sq = OOXIXo.f3760XO;
        this.sz = false;
        this.sp = 0;
        this.tn.add(sensorManager.getDefaultSensor(4));
        this.tn.add(sensorManager.getDefaultSensor(11));
    }

    private void a(Quaternion quaternion) {
        Quaternion m46clone = quaternion.m46clone();
        m46clone.w(-m46clone.w());
        synchronized (this.tm) {
            try {
                this.tp.copyVec4(quaternion);
                SensorManager.getRotationMatrixFromVector(this.to.matrix, m46clone.toArray());
                dQ();
                int i = this.sp + 1;
                this.sp = i;
                if (i > 100) {
                    setChanged();
                } else if (!dR()) {
                    setChanged();
                }
                notifyObservers();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean dR() {
        return ((double) Math.abs(1.0f - this.tu.matrix[0])) < 0.001d && ((double) Math.abs(1.0f - this.tu.matrix[5])) < 0.001d && ((double) Math.abs(1.0f - this.tu.matrix[10])) < 0.001d && ((double) Math.abs(1.0f - this.tu.matrix[15])) < 0.001d;
    }

    public static void getQuaternionFromVector(float[] fArr, float[] fArr2) {
        if (fArr2.length >= 4) {
            fArr[0] = fArr2[3];
        } else {
            float f = fArr2[0];
            float f2 = 1.0f - (f * f);
            float f3 = fArr2[1];
            float f4 = f2 - (f3 * f3);
            float f5 = fArr2[2];
            float f6 = f4 - (f5 * f5);
            fArr[0] = f6;
            fArr[0] = f6 > 0.0f ? (float) Math.sqrt(f6) : 0.0f;
        }
        fArr[1] = fArr2[0];
        fArr[2] = fArr2[1];
        fArr[3] = fArr2[2];
    }

    public void dQ() {
        if (this.tr) {
            fl.a(this.tt.matrix, this.to.matrix, this.ts.matrix);
            fl.b(this.tu.matrix, this.tt.matrix);
        } else if (fl.a(this.ts.matrix, this.to.matrix)) {
            this.tr = true;
            fl.a(this.tt.matrix, this.to.matrix, this.ts.matrix);
            fl.b(this.tu.matrix, this.tt.matrix);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() != 11) {
            if (sensorEvent.sensor.getType() == 4) {
                synchronized (this.tk) {
                    try {
                        if (this.tl.booleanValue()) {
                            long j = this.timestamp;
                            if (j != 0) {
                                float f = ((float) (sensorEvent.timestamp - j)) * 1.0E-9f;
                                float[] fArr = sensorEvent.values;
                                float f2 = fArr[0];
                                float f3 = fArr[1];
                                float f4 = fArr[2];
                                double sqrt = Math.sqrt((f2 * f2) + (f3 * f3) + (f4 * f4));
                                this.sq = sqrt;
                                if (sqrt > 0.10000000149011612d) {
                                    f2 = (float) (f2 / sqrt);
                                    f3 = (float) (f3 / sqrt);
                                    f4 = (float) (f4 / sqrt);
                                } else {
                                    this.sq = OOXIXo.f3760XO;
                                }
                                double d = (this.sq * f) / 2.0d;
                                double sin = Math.sin(d);
                                double cos = Math.cos(d);
                                this.so.setX((float) (f2 * sin));
                                this.so.setY((float) (f3 * sin));
                                this.so.setZ((float) (sin * f4));
                                this.so.setW(-((float) cos));
                                Quaternion quaternion = this.so;
                                Quaternion quaternion2 = this.sx;
                                quaternion.multiplyByQuat(quaternion2, quaternion2);
                                float dotProduct = this.sx.dotProduct(this.sy);
                                if (Math.abs(dotProduct) < 0.0f) {
                                    if (Math.abs(dotProduct) < 0.0f) {
                                        this.sA++;
                                    }
                                    a(this.sx);
                                } else {
                                    Quaternion quaternion3 = new Quaternion();
                                    this.sx.slerp(this.sy, quaternion3, (float) (this.sq * 0.009999999776482582d));
                                    a(quaternion3);
                                    this.sx.copyVec4(quaternion3);
                                    this.sA = 0;
                                }
                                if (this.sA > 60) {
                                    String str = TAG;
                                    kf.c(str, "Rotation VectorPanic counter is bigger than threshold; this indicates a Gyroscope failure. Panic reset is imminent.");
                                    double d2 = this.sq;
                                    if (d2 < 3.0d) {
                                        kf.c(str, "Rotation VectorPerforming Panic-reset. Resetting orientation to rotation-vector value.");
                                        a(this.sy);
                                        this.sx.copyVec4(this.sy);
                                        this.sA = 0;
                                    } else {
                                        kf.c(str, "Rotation Vector" + String.format("Panic reset delayed due to ongoing motion (user is still shaking the device). Gyroscope Velocity: %.2f > 3", Double.valueOf(d2)));
                                    }
                                }
                            }
                            this.timestamp = sensorEvent.timestamp;
                            return;
                        }
                        return;
                    } finally {
                    }
                }
            }
            return;
        }
        synchronized (this.tk) {
            int i = 0;
            while (true) {
                try {
                    float[] fArr2 = sensorEvent.values;
                    if (i >= fArr2.length) {
                        float[] fArr3 = new float[4];
                        try {
                            SensorManager.getQuaternionFromVector(fArr3, fArr2);
                        } catch (Exception unused) {
                            getQuaternionFromVector(fArr3, sensorEvent.values);
                        }
                        this.sy.setXYZW(fArr3[1], fArr3[2], fArr3[3], -fArr3[0]);
                        if (this.sz) {
                            return;
                        }
                        this.sx.set(this.sy);
                        this.sz = true;
                        return;
                    }
                    if (Float.isNaN(fArr2[i])) {
                        this.tl = Boolean.FALSE;
                        return;
                    }
                    i++;
                } finally {
                }
            }
        }
    }
}
