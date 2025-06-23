package com.baidu.ar;

import XIXIX.OOXIXo;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import com.baidu.ar.arplay.representation.Quaternion;

/* loaded from: classes7.dex */
public class fc extends fl {
    private static final String TAG = "fc";
    private final Quaternion so;
    private int sp;
    private double sq;
    private long timestamp;

    public fc(SensorManager sensorManager) {
        super(sensorManager);
        this.so = new Quaternion();
        this.sp = 0;
        this.sq = OOXIXo.f3760XO;
        kf.c(TAG, "sensorList size " + String.valueOf(this.tn.size()));
        if (this.tn.size() > 120) {
            this.tn.clear();
        }
        this.tn.add(sensorManager.getDefaultSensor(4));
    }

    private void dQ() {
        if (this.tr) {
            fl.a(this.tu.matrix, this.to.matrix, this.ts.matrix);
            return;
        }
        float[] fArr = this.to.matrix;
        float[] fArr2 = this.ts.matrix;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        Matrix.setIdentityM(this.tu.matrix, 0);
        this.tr = true;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 4) {
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
                }
                double d = (sqrt * f) / 2.0d;
                double sin = Math.sin(d);
                double cos = Math.cos(d);
                this.so.setX((float) (f2 * sin));
                this.so.setY((float) (f3 * sin));
                this.so.setZ((float) (sin * f4));
                this.so.setW(-((float) cos));
                synchronized (this.tm) {
                    Quaternion quaternion = this.so;
                    Quaternion quaternion2 = this.tp;
                    quaternion.multiplyByQuat(quaternion2, quaternion2);
                }
                Quaternion m46clone = this.tp.m46clone();
                m46clone.w(-m46clone.w());
                synchronized (this.tm) {
                    SensorManager.getRotationMatrixFromVector(this.to.matrix, m46clone.toArray());
                }
            }
            this.timestamp = sensorEvent.timestamp;
            int i = this.sp + 1;
            this.sp = i;
            if (i > 20) {
                dQ();
                setChanged();
                notifyObservers();
            }
        }
    }
}
