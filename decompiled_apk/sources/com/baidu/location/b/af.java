package com.baidu.location.b;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* loaded from: classes7.dex */
public class af implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    private float[] f5618a;
    private SensorManager b;
    private float c;
    private boolean d;
    private boolean e;
    private boolean f;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final af f5619a = new af();
    }

    private af() {
        this.d = false;
        this.e = false;
        this.f = false;
    }

    public static af a() {
        return a.f5619a;
    }

    public synchronized void b() {
        Sensor defaultSensor;
        try {
            if (this.f) {
                return;
            }
            if (this.d) {
                if (this.b == null) {
                    this.b = (SensorManager) com.baidu.location.f.getServiceContext().getSystemService("sensor");
                }
                SensorManager sensorManager = this.b;
                if (sensorManager != null && (defaultSensor = sensorManager.getDefaultSensor(11)) != null && this.d) {
                    this.b.registerListener(this, defaultSensor, 3);
                }
                this.f = true;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void c() {
        try {
            if (this.f) {
                SensorManager sensorManager = this.b;
                if (sensorManager != null) {
                    sensorManager.unregisterListener(this);
                    this.b = null;
                }
                this.f = false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean d() {
        return this.d;
    }

    public float e() {
        return this.c;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    @SuppressLint({"NewApi"})
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() != 11) {
            return;
        }
        float[] fArr = (float[]) sensorEvent.values.clone();
        this.f5618a = fArr;
        float[] fArr2 = new float[9];
        try {
            SensorManager.getRotationMatrixFromVector(fArr2, fArr);
            SensorManager.getOrientation(fArr2, new float[3]);
            float degrees = (float) Math.toDegrees(r5[0]);
            this.c = degrees;
            if (degrees < 0.0f) {
                degrees += 360.0f;
            }
            this.c = (float) Math.floor(degrees);
        } catch (Exception unused) {
            this.c = 0.0f;
        }
    }

    public void a(boolean z) {
        this.d = z;
    }
}
