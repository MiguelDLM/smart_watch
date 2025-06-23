package com.baidu.ar;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;

/* loaded from: classes7.dex */
public class fm extends ff {
    private float[] tv;
    private float[] tw;

    public fm(SensorManager sensorManager) {
        super(sensorManager);
        this.tn.add(sensorManager.getDefaultSensor(9));
        this.tn.add(sensorManager.getDefaultSensor(4));
        this.tn.add(sensorManager.getDefaultSensor(11));
    }

    @Override // com.baidu.ar.ff, android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr;
        if (sensorEvent.sensor.getType() == 11 || sensorEvent.sensor.getType() == 4) {
            super.onSensorChanged(sensorEvent);
        } else if (sensorEvent.sensor.getType() == 2) {
            this.tv = (float[]) sensorEvent.values.clone();
        } else if (sensorEvent.sensor.getType() == 9) {
            float[] fArr2 = (float[]) sensorEvent.values.clone();
            this.tw = fArr2;
            this.sS = fArr2;
        }
        float[] fArr3 = this.tv;
        if (fArr3 == null || (fArr = this.tw) == null) {
            return;
        }
        SensorManager.getRotationMatrix(this.to.matrix, new float[16], fArr, fArr3);
        this.tp.setRowMajor(this.to.matrix);
    }
}
