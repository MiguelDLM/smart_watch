package com.baidu.ar;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

/* loaded from: classes7.dex */
public class nd implements SensorEventListener {
    private static nd Hg;
    private float Hh = 0.0f;
    private float Hi = 0.0f;
    private float Hj = 0.0f;
    private ne Hk;
    private SensorManager sv;

    private nd() {
    }

    public static synchronized nd iM() {
        nd ndVar;
        synchronized (nd.class) {
            try {
                if (Hg == null) {
                    Hg = new nd();
                }
                ndVar = Hg;
            } catch (Throwable th) {
                throw th;
            }
        }
        return ndVar;
    }

    public void a(Context context, ne neVar) {
        Log.e("Accelerometer", "onStart");
        if (this.Hk != null) {
            return;
        }
        if (this.sv == null) {
            this.sv = (SensorManager) context.getSystemService("sensor");
        }
        SensorManager sensorManager = this.sv;
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(1), 3);
        this.Hk = neVar;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1) {
            float[] fArr = sensorEvent.values;
            float f = fArr[0];
            this.Hh = f;
            float f2 = fArr[1];
            this.Hi = f2;
            float f3 = fArr[2];
            this.Hj = f3;
            this.Hk.d(f, f2, f3);
        }
    }

    public void onStop() {
        Log.e("Accelerometer", "onStop");
        SensorManager sensorManager = this.sv;
        if (sensorManager == null) {
            return;
        }
        sensorManager.unregisterListener(this);
        this.Hk = null;
        this.sv = null;
    }
}
