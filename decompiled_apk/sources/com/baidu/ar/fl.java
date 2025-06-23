package com.baidu.ar;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.ar.arplay.representation.Matrix;
import com.baidu.ar.arplay.representation.Matrixf4x4;
import com.baidu.ar.arplay.representation.Quaternion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

/* loaded from: classes7.dex */
public abstract class fl extends Observable implements SensorEventListener {
    private static final String TAG = "fl";
    protected float[] sS;
    private SensorManager tq;
    protected Object tk = new Object();
    protected Boolean tl = Boolean.TRUE;
    protected final Object tm = new Object();
    protected List<Sensor> tn = new ArrayList();
    boolean tr = false;
    protected final Matrixf4x4 to = new Matrixf4x4();
    protected final Quaternion tp = new Quaternion();
    protected final Matrixf4x4 ts = new Matrixf4x4();
    protected final Matrixf4x4 tt = new Matrixf4x4();
    protected final Matrixf4x4 tu = new Matrixf4x4();

    public fl(SensorManager sensorManager) {
        this.tq = sensorManager;
        kf.c(TAG, "sensorList size " + String.valueOf(this.tn.size()));
        if (this.tn.size() > 120) {
            this.tn.clear();
        }
    }

    public static void a(float[] fArr, float[] fArr2, float[] fArr3) {
        float[] fArr4 = new float[16];
        Matrix.setIdentityM(fArr4, 0);
        Matrix.invertM(fArr4, 0, fArr3, 0);
        Matrix.multiplyMM(fArr, 0, fArr2, 0, fArr4, 0);
    }

    public static void b(float[] fArr, float[] fArr2) {
        System.arraycopy(fArr2, 0, fArr, 0, fArr2.length);
    }

    public float[] dV() {
        return this.sS;
    }

    public boolean ed() {
        Iterator<Sensor> it = this.tn.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                return false;
            }
        }
        return true;
    }

    public Matrixf4x4 ee() {
        return this.tu;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void release() {
        deleteObservers();
        Iterator<Sensor> it = this.tn.iterator();
        while (it.hasNext()) {
            this.tq.unregisterListener(this, it.next());
        }
        this.tn.clear();
    }

    public void start() {
        Iterator<Sensor> it = this.tn.iterator();
        while (it.hasNext()) {
            this.tq.registerListener(this, it.next(), 1);
        }
    }

    public static boolean a(float[] fArr, float[] fArr2) {
        float f;
        float[] fArr3 = new float[4];
        float[] fArr4 = {1.0f, 0.0f, 0.0f, 0.0f};
        Matrix.multiplyMV(fArr3, fArr2, fArr4);
        if (Float.compare(fArr3[0], fArr4[0]) == 0 && Float.compare(fArr3[1], fArr4[1]) == 0 && Float.compare(fArr3[2], fArr4[2]) == 0) {
            return false;
        }
        int compare = Float.compare(fArr3[0], 0.0f);
        int compare2 = Float.compare(fArr3[1], 0.0f);
        if (compare != 0) {
            double d = fArr3[1] / fArr3[0];
            f = (compare <= 0 || compare2 < 0) ? (compare <= 0 || compare2 >= 0) ? ((float) ((Math.atan(d) * 180.0d) / 3.141592653589793d)) + 180.0f : ((float) ((Math.atan(d) * 180.0d) / 3.141592653589793d)) + 360.0f : (float) ((Math.atan(d) * 180.0d) / 3.141592653589793d);
        } else {
            f = (Float.compare(fArr3[1], 1.0f) != 0 && Float.compare(fArr3[1], -1.0f) == 0) ? 180.0f : 0.0f;
        }
        kf.c(TAG, "orientation: outputV[0] = " + fArr3[0] + ", outputV[1] = " + fArr3[1] + ", angleZ = " + f);
        Matrix.setIdentityM(fArr, 0);
        Matrix.rotateM(fArr, 0, f, 0.0f, 0.0f, 1.0f);
        return true;
    }
}
