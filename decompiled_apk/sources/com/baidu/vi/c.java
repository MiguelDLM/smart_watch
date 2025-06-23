package com.baidu.vi;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;
import java.util.List;

/* loaded from: classes8.dex */
final class c extends Handler {
    @Override // android.os.Handler
    public void handleMessage(Message message) {
        SensorManager sensorManager;
        SensorManager sensorManager2;
        SensorManager sensorManager3;
        SensorEventListener sensorEventListener;
        SensorManager sensorManager4;
        SensorEventListener sensorEventListener2;
        VCompass vCompass = (VCompass) message.obj;
        if (vCompass == null) {
            return;
        }
        int i = message.what;
        if (i != 1) {
            if (i == 2) {
                sensorManager4 = vCompass.f10213a;
                sensorEventListener2 = vCompass.f;
                sensorManager4.unregisterListener(sensorEventListener2);
                return;
            }
            return;
        }
        Context context = VIContext.getContext();
        sensorManager = vCompass.f10213a;
        if (sensorManager == null) {
            vCompass.f10213a = (SensorManager) context.getSystemService("sensor");
        }
        sensorManager2 = vCompass.f10213a;
        List<Sensor> sensorList = sensorManager2.getSensorList(3);
        if (sensorList.size() > 0) {
            Sensor sensor = sensorList.get(0);
            sensorManager3 = vCompass.f10213a;
            sensorEventListener = vCompass.f;
            sensorManager3.registerListener(sensorEventListener, sensor, 1);
        }
    }
}
