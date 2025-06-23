package com.baidu.ar;

import XIXIX.OOXIXo;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.LinkedList;

/* loaded from: classes7.dex */
public class ig implements SensorEventListener {
    private Context mContext;
    private SensorManager sv;
    private Sensor ys;
    private a yt;
    private boolean yu = true;
    private LinkedList<Double> yv = new LinkedList<>();
    private LinkedList<Float> yw = new LinkedList<>();
    private LinkedList<Float> yx = new LinkedList<>();
    private LinkedList<Float> yy = new LinkedList<>();
    private int yz = 10;
    private double yA = OOXIXo.f3760XO;
    private boolean yB = true;
    private boolean yC = false;

    /* loaded from: classes7.dex */
    public interface a {
        void b(float f, float f2, float f3, float f4);

        void destroy();
    }

    public ig(Context context) {
        this.mContext = context;
    }

    public void Q(boolean z) {
        this.yu = z;
    }

    public void a(a aVar) {
        this.yt = aVar;
    }

    public void b(float f, float f2, float f3) {
        a aVar;
        double sqrt = Math.sqrt((f * f) + (f2 * f2) + (f3 * f3));
        if (sqrt > this.yA) {
            this.yA = sqrt;
        }
        kf.cj("max acc is : " + this.yA);
        a(this.yv, sqrt);
        a((LinkedList) this.yw, Math.abs(f));
        a((LinkedList) this.yx, Math.abs(f2));
        a((LinkedList) this.yy, Math.abs(f3));
        if (this.yv.size() == this.yz) {
            float f4 = 0.0f;
            double d = 0.0d;
            float f5 = 0.0f;
            float f6 = 0.0f;
            for (int i = 0; i < this.yv.size(); i++) {
                d += this.yv.get(i).doubleValue();
                f4 += this.yw.get(i).floatValue();
                f5 += this.yx.get(i).floatValue();
                f6 += this.yy.get(i).floatValue();
            }
            int i2 = this.yz;
            double d2 = d / i2;
            float f7 = f4 / i2;
            float f8 = f5 / i2;
            float f9 = f6 / i2;
            if (this.yC) {
                if (!this.yB) {
                    if (d2 < 10.0d) {
                        this.yB = true;
                        aVar = this.yt;
                        if (aVar == null) {
                            return;
                        }
                        aVar.b(f7, f8, f9, (float) this.yA);
                        this.yA = OOXIXo.f3760XO;
                    }
                    return;
                }
                if (d2 <= 10.0d) {
                    return;
                }
                this.yB = false;
            }
            if (this.yB) {
                if (d2 <= 5.0d) {
                    return;
                }
                this.yB = false;
            } else if (d2 < 5.0d) {
                this.yB = true;
                aVar = this.yt;
                if (aVar == null) {
                    return;
                }
                aVar.b(f7, f8, f9, (float) this.yA);
                this.yA = OOXIXo.f3760XO;
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.yu) {
            float[] fArr = sensorEvent.values;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            b(f, f2, f3);
            kf.cj("acc  x : " + f + " , y : " + f2 + ", z : " + f3);
        }
    }

    public void start() {
        SensorManager sensorManager;
        SensorManager sensorManager2 = (SensorManager) this.mContext.getSystemService("sensor");
        this.sv = sensorManager2;
        if (sensorManager2 != null) {
            Sensor defaultSensor = sensorManager2.getDefaultSensor(10);
            this.ys = defaultSensor;
            if (defaultSensor == null) {
                this.ys = this.sv.getDefaultSensor(1);
                this.yC = true;
            }
        }
        Sensor sensor = this.ys;
        if (sensor == null || (sensorManager = this.sv) == null) {
            return;
        }
        sensorManager.registerListener(this, sensor, 1);
    }

    public void stop() {
        a aVar = this.yt;
        if (aVar != null) {
            aVar.destroy();
            this.yt = null;
        }
        SensorManager sensorManager = this.sv;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
            this.sv = null;
        }
        this.yC = false;
    }

    public void a(LinkedList linkedList, double d) {
        if (linkedList.size() >= this.yz) {
            linkedList.poll();
        }
        linkedList.offer(Double.valueOf(d));
    }

    public void a(LinkedList linkedList, float f) {
        if (linkedList.size() >= this.yz) {
            linkedList.poll();
        }
        linkedList.offer(Float.valueOf(f));
    }
}
