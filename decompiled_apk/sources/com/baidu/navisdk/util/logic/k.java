package com.baidu.navisdk.util.logic;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.model.datastruct.u;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes8.dex */
public class k extends com.baidu.navisdk.comapi.base.a {
    private static volatile k h;

    /* renamed from: a, reason: collision with root package name */
    private SensorManager f9334a = null;
    private ArrayList<com.baidu.navisdk.comapi.geolocate.c> b;
    private u c;
    private u d;
    private float[] e;
    private boolean f;
    private SensorEventListener g;

    /* loaded from: classes8.dex */
    public class a implements SensorEventListener {
        public a() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            float[] fArr = (float[]) sensorEvent.values.clone();
            int type = sensorEvent.sensor.getType();
            if (type == 3) {
                synchronized (k.this.d) {
                    try {
                        if (k.this.e != null) {
                            k.this.d.f6943a = k.this.e[0];
                            k.this.d.b = k.this.e[1];
                            k.this.d.c = k.this.e[2];
                            k.this.d.d = fArr[0];
                            k.this.d.e = -fArr[2];
                            k.this.d.f = -fArr[1];
                            k kVar = k.this;
                            kVar.c = kVar.d.m92clone();
                            Iterator it = k.this.b.iterator();
                            while (it.hasNext()) {
                                ((com.baidu.navisdk.comapi.geolocate.c) it.next()).a(k.this.c);
                            }
                        } else {
                            return;
                        }
                    } finally {
                    }
                }
            }
            if (type == 1) {
                k.this.e = (float[]) fArr.clone();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements SensorEventListener {
        public b(k kVar) {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            int i;
            float[] fArr = (float[]) sensorEvent.values.clone();
            int type = sensorEvent.sensor.getType();
            if (type != 1) {
                if (type != 2) {
                    i = 4;
                    if (type != 3) {
                        if (type != 4) {
                            if (type != 6) {
                                if (type == 9) {
                                    i = 2;
                                }
                            } else {
                                BNRoutePlaner.getInstance().a(fArr[0]);
                            }
                            i = 0;
                        } else {
                            i = 3;
                        }
                    }
                } else {
                    i = 5;
                }
            } else {
                i = 1;
            }
            if (i != 0) {
                BNRouteGuider.getInstance().triggerRecordSensorData(fArr[0], fArr[1], fArr[2], i);
            }
        }
    }

    private k() {
        new ArrayList();
        this.b = new ArrayList<>();
        this.c = new u();
        this.d = new u();
        this.e = new float[3];
        this.f = false;
        new a();
        this.g = new b(this);
    }

    public static k getInstance() {
        if (h == null) {
            h = new k();
        }
        return h;
    }

    public void a(Context context) {
        try {
            if (this.f9334a == null) {
                this.f9334a = (SensorManager) context.getSystemService("sensor");
            }
            if (this.f) {
                return;
            }
            LogUtil.e("Location", "[SensorFinger] initSensorFinger");
            Sensor defaultSensor = this.f9334a.getDefaultSensor(6);
            if (defaultSensor != null) {
                this.f9334a.registerListener(this.g, defaultSensor, 3);
            }
            this.f = true;
        } catch (Exception unused) {
        }
    }

    public void a() {
        try {
            if (this.f9334a == null || !this.f) {
                return;
            }
            LogUtil.e("Location", "[SensorFinger] uninitSensorFinger");
            this.f9334a.unregisterListener(this.g);
            this.f = false;
        } catch (Exception unused) {
        }
    }
}
