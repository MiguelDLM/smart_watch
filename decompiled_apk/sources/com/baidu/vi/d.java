package com.baidu.vi;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/* loaded from: classes8.dex */
class d implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VCompass f10218a;

    public d(VCompass vCompass) {
        this.f10218a = vCompass;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float a2;
        if (sensorEvent.sensor.getType() == 3) {
            a2 = this.f10218a.a(sensorEvent.values[0]);
            this.f10218a.updateCompass((int) a2);
        }
    }
}
