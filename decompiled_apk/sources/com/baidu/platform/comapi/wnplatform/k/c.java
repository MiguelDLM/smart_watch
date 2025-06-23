package com.baidu.platform.comapi.wnplatform.k;

import XIXIX.OOXIXo;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes8.dex */
public class c extends a implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    public static int f9932a;
    private Context b;
    private SensorManager f;
    private Sensor g;
    private boolean h;
    private Handler j;
    private com.baidu.platform.comapi.wnplatform.model.datastruct.a r;
    private double s;
    private double t;
    private double u;
    private int c = -1;
    private float[] d = new float[3];
    private float[] e = new float[9];
    private Object i = new Object();
    private ArrayList<b> k = new ArrayList<>();
    private float[] l = new float[3];
    private float[] m = new float[3];
    private com.baidu.platform.comapi.wnplatform.model.datastruct.a n = new com.baidu.platform.comapi.wnplatform.model.datastruct.a();
    private com.baidu.platform.comapi.wnplatform.model.datastruct.a o = new com.baidu.platform.comapi.wnplatform.model.datastruct.a();
    private float[] p = new float[9];
    private float[] q = new float[3];

    public c() {
        this.f = null;
        this.g = null;
        Context a2 = com.baidu.platform.comapi.wnplatform.p.b.a.a();
        this.b = a2;
        try {
            SensorManager sensorManager = (SensorManager) a2.getSystemService("sensor");
            this.f = sensorManager;
            this.g = sensorManager.getDefaultSensor(11);
        } catch (Exception unused) {
            this.f = null;
            this.g = null;
        }
        this.h = false;
    }

    private double a(double d) {
        return (((d + 90.0d) / 90.0d) * (-30.0d)) + d;
    }

    private boolean b() {
        synchronized (this.i) {
            try {
                if (this.h) {
                    return true;
                }
                if (((SensorManager) this.b.getSystemService("sensor")) == null) {
                    return false;
                }
                boolean c = c();
                this.h = c;
                return c;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean c() {
        SensorManager sensorManager;
        boolean registerListener;
        try {
            sensorManager = (SensorManager) this.b.getSystemService("sensor");
        } catch (Exception unused) {
            sensorManager = null;
        }
        boolean z = false;
        if (sensorManager == null) {
            return false;
        }
        Sensor defaultSensor = sensorManager.getDefaultSensor(11);
        Sensor defaultSensor2 = sensorManager.getDefaultSensor(1);
        Sensor defaultSensor3 = sensorManager.getDefaultSensor(2);
        if (defaultSensor != null) {
            try {
                registerListener = sensorManager.registerListener(this, defaultSensor, 2);
            } catch (Exception unused2) {
            }
            if (registerListener && defaultSensor2 != null && defaultSensor3 != null) {
                try {
                    boolean registerListener2 = sensorManager.registerListener(this, defaultSensor2, 2);
                    boolean registerListener3 = sensorManager.registerListener(this, defaultSensor3, 2);
                    if (registerListener2 && registerListener3) {
                        z = true;
                    }
                    return z;
                } catch (Exception unused3) {
                    return registerListener;
                }
            }
            return registerListener;
        }
        registerListener = false;
        return registerListener ? registerListener : registerListener;
    }

    private void d() {
        synchronized (this.i) {
            try {
                if (!this.h) {
                    return;
                }
                SensorManager sensorManager = (SensorManager) this.b.getSystemService("sensor");
                if (sensorManager == null) {
                    return;
                }
                this.h = false;
                try {
                    sensorManager.unregisterListener(this);
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
        Handler handler;
        if ((i == 1 || i == 0 || i == -1) && (handler = this.j) != null) {
            handler.sendEmptyMessage(3);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        com.baidu.platform.comapi.wnplatform.model.datastruct.a a2;
        com.baidu.platform.comapi.wnplatform.d.a.b("onSensorChanged acc:" + sensorEvent.accuracy);
        if (this.f == null) {
            return;
        }
        if (sensorEvent.sensor.getType() == 11) {
            a2 = b(sensorEvent);
        } else if (sensorEvent.sensor.getType() != 1 && sensorEvent.sensor.getType() != 2) {
            a2 = null;
        } else {
            a2 = a(sensorEvent);
        }
        Iterator<b> it = this.k.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (a2 != null) {
                next.a(a2);
            }
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return false;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        a();
    }

    public void a(Context context, Handler handler) {
        b();
        this.j = handler;
    }

    public void a() {
        d();
    }

    public void a(b bVar) {
        this.k.add(bVar);
    }

    private com.baidu.platform.comapi.wnplatform.model.datastruct.a a(SensorEvent sensorEvent) {
        com.baidu.platform.comapi.wnplatform.model.datastruct.a clone;
        com.baidu.platform.comapi.wnplatform.d.a.a("onSensorChanged type:" + sensorEvent.sensor.getType());
        sensorEvent.values.clone();
        int type = sensorEvent.sensor.getType();
        if (1 == type) {
            this.l = a((float[]) sensorEvent.values.clone(), this.l);
        }
        if (2 == type) {
            this.m = a((float[]) sensorEvent.values.clone(), this.m);
        }
        SensorManager.getRotationMatrix(this.p, null, this.l, this.m);
        SensorManager.getOrientation(this.p, this.q);
        synchronized (this.o) {
            com.baidu.platform.comapi.wnplatform.model.datastruct.a aVar = this.o;
            float[] fArr = this.l;
            aVar.f9939a = fArr[0];
            aVar.b = fArr[1];
            aVar.c = fArr[2];
            float degrees = (float) Math.toDegrees(this.q[0]);
            if (degrees < 0.0f && degrees > -180.0f) {
                degrees += 360.0f;
            }
            this.o.d = degrees;
            this.o.e = (float) Math.toDegrees(this.q[1]);
            float degrees2 = (float) Math.toDegrees(this.q[2]);
            com.baidu.platform.comapi.wnplatform.model.datastruct.a aVar2 = this.o;
            aVar2.f = degrees2;
            clone = aVar2.clone();
            this.n = clone;
        }
        return clone;
    }

    private com.baidu.platform.comapi.wnplatform.model.datastruct.a b(SensorEvent sensorEvent) {
        WindowManager windowManager;
        Display defaultDisplay;
        double degrees;
        int type = sensorEvent.sensor.getType();
        if (this.g != null && 11 == type) {
            try {
                SensorManager.getRotationMatrixFromVector(this.e, sensorEvent.values);
                SensorManager.getOrientation(this.e, this.d);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                windowManager = (WindowManager) this.b.getSystemService("window");
            } catch (Exception unused) {
                windowManager = null;
            }
            if (windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
                return null;
            }
            try {
                int rotation = defaultDisplay.getRotation() * 90;
                int i = 0;
                if (type == 11) {
                    if (rotation == 0) {
                        float[] fArr = this.d;
                        degrees = Math.toDegrees(fArr[0] - fArr[2]);
                    } else {
                        float[] fArr2 = this.d;
                        degrees = Math.toDegrees(fArr2[0] - fArr2[1]);
                    }
                    i = ((((int) degrees) + rotation) + 360) % 360;
                }
                this.c = i;
                double d = i;
                a(d, Math.toDegrees(this.d[1]), Math.toDegrees(this.d[2]));
                com.baidu.platform.comapi.wnplatform.model.datastruct.a aVar = new com.baidu.platform.comapi.wnplatform.model.datastruct.a();
                this.r = aVar;
                aVar.d = d;
                aVar.e = a(this.t - 90.0d);
                com.baidu.platform.comapi.wnplatform.model.datastruct.a aVar2 = this.r;
                aVar2.f = OOXIXo.f3760XO;
                aVar2.g = sensorEvent.accuracy;
                if (this.j != null) {
                    Message message = new Message();
                    message.what = 2;
                    message.obj = this.r;
                    this.j.sendMessage(message);
                }
            } catch (ArrayIndexOutOfBoundsException unused2) {
                return null;
            }
        }
        return this.r;
    }

    private void a(double d, double d2, double d3) {
        double atan2;
        double d4;
        double d5;
        double d6;
        double radians = Math.toRadians(d);
        double radians2 = OOXIXo.f3760XO - Math.toRadians(d2);
        double radians3 = Math.toRadians(d3);
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);
        double cos2 = Math.cos(radians2);
        double sin2 = Math.sin(radians2);
        double cos3 = Math.cos(radians3);
        double sin3 = Math.sin(radians3);
        double d7 = cos * sin2;
        double[] dArr = {(sin * sin3) - (d7 * cos3), (-cos) * cos2, (d7 * sin3) + (sin * cos3), cos2 * cos3, -sin2, (-cos2) * sin3, (sin * sin2 * cos3) + (cos * sin3), cos2 * sin, ((-sin) * sin2 * sin3) + (cos * cos3)};
        double d8 = dArr[3];
        if (d8 > 0.9999d) {
            atan2 = Math.atan2(dArr[2], dArr[8]);
            d6 = 1.5707963267948966d;
        } else if (d8 < -0.9999d) {
            atan2 = Math.atan2(dArr[2], dArr[8]);
            d6 = -1.5707963267948966d;
        } else {
            atan2 = Math.atan2(-dArr[6], dArr[0]);
            double atan22 = Math.atan2(-dArr[5], dArr[4]);
            double asin = Math.asin(dArr[3]);
            if (Double.isNaN(asin)) {
                d4 = atan22;
                d5 = OOXIXo.f3760XO;
            } else {
                d4 = atan22;
                d5 = asin;
            }
            this.s = (atan2 * 180.0d) / 3.141592653589793d;
            this.t = (d5 * 180.0d) / 3.141592653589793d;
            this.u = (d4 * 180.0d) / 3.141592653589793d;
        }
        d5 = d6;
        d4 = OOXIXo.f3760XO;
        this.s = (atan2 * 180.0d) / 3.141592653589793d;
        this.t = (d5 * 180.0d) / 3.141592653589793d;
        this.u = (d4 * 180.0d) / 3.141592653589793d;
    }

    private float[] a(float[] fArr, float[] fArr2) {
        if (fArr2 == null || fArr == null) {
            return fArr;
        }
        int length = fArr2.length <= fArr.length ? fArr2.length : fArr.length;
        for (int i = 0; i < length; i++) {
            float f = fArr2[i];
            fArr2[i] = f + ((fArr[i] - f) * 0.1f);
        }
        return fArr2;
    }
}
