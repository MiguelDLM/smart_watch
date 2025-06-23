package com.baidu.navisdk.adapter.impl.base.mapsensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.WindowManager;
import com.baidu.navisdk.util.worker.e;
import com.baidu.navisdk.util.worker.f;

/* loaded from: classes7.dex */
public class b implements SensorEventListener {
    private static b n;

    /* renamed from: a, reason: collision with root package name */
    private Context f6493a;
    private SensorManager f;
    private WindowManager g;
    private Sensor h;
    private boolean i;
    private HandlerThread k;
    private Handler l;
    private int c = -1;
    private float[] d = new float[3];
    private float[] e = new float[9];
    private Object j = new Object();
    private c m = null;
    private com.baidu.navisdk.adapter.impl.base.mapsensor.a b = new com.baidu.navisdk.adapter.impl.base.mapsensor.a();

    /* loaded from: classes7.dex */
    public class a extends f<String, String> {
        public a(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            b.this.f();
            return null;
        }
    }

    /* renamed from: com.baidu.navisdk.adapter.impl.base.mapsensor.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0160b {
        void onSensorChanged(int i);
    }

    /* loaded from: classes7.dex */
    public interface c extends InterfaceC0160b {
        void onSensorChanged(int i, float[] fArr);
    }

    public b(Context context) {
        this.f = null;
        this.g = null;
        this.h = null;
        this.f6493a = context;
        try {
            Context context2 = this.f6493a;
            if (context2 != null) {
                this.f = (SensorManager) context2.getSystemService("sensor");
                this.g = (WindowManager) this.f6493a.getSystemService("window");
                this.h = this.f.getDefaultSensor(11);
            } else {
                this.f = null;
                this.h = null;
                this.g = null;
            }
        } catch (Exception unused) {
            this.f = null;
            this.h = null;
            this.g = null;
        }
        this.i = false;
    }

    public static b c() {
        if (n == null) {
            n = new b(com.baidu.navisdk.framework.a.c().a());
        }
        return n;
    }

    private boolean d() {
        String str = Build.BRAND;
        if (str.equals("Huawei")) {
            String str2 = Build.MODEL;
            if (str2.equals("PE-TL10") || str2.equals("PE-CL00") || str2.equals("PE-TL00M") || str2.equals("PE-TL20") || str2.equals("PE-UL00")) {
                return true;
            }
        }
        if ("Meizu".equalsIgnoreCase(str)) {
            return true;
        }
        return false;
    }

    private boolean e() {
        SensorManager sensorManager;
        try {
            sensorManager = (SensorManager) this.f6493a.getSystemService("sensor");
        } catch (Exception unused) {
            sensorManager = null;
        }
        boolean z = false;
        if (sensorManager == null) {
            return false;
        }
        Sensor defaultSensor = sensorManager.getDefaultSensor(11);
        Sensor defaultSensor2 = sensorManager.getDefaultSensor(3);
        if (defaultSensor != null && defaultSensor2 != null && !d()) {
            try {
                z = sensorManager.registerListener(this, defaultSensor, 1, this.l);
            } catch (Exception unused2) {
            }
        }
        if (!z && defaultSensor2 != null) {
            try {
                return sensorManager.registerListener(this, defaultSensor2, 1, this.l);
            } catch (Exception unused3) {
                return z;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        synchronized (this.j) {
            try {
                if (this.i) {
                    return true;
                }
                if (((SensorManager) this.f6493a.getSystemService("sensor")) == null) {
                    return false;
                }
                g();
                boolean e = e();
                this.i = e;
                if (!e) {
                    this.k.quit();
                }
                return this.i;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void g() {
        try {
            HandlerThread handlerThread = new HandlerThread("BMSensorThread");
            this.k = handlerThread;
            handlerThread.start();
            this.l = new Handler(this.k.getLooper());
        } catch (Exception unused) {
        }
    }

    public static void h() {
        b bVar = n;
        if (bVar != null) {
            bVar.i();
            n = null;
        }
    }

    private void i() {
        synchronized (this.j) {
            try {
                HandlerThread handlerThread = this.k;
                if (handlerThread != null) {
                    handlerThread.quit();
                }
                if (!this.i) {
                    this.f6493a = null;
                    return;
                }
                SensorManager sensorManager = (SensorManager) this.f6493a.getSystemService("sensor");
                if (sensorManager == null) {
                    this.f6493a = null;
                    return;
                }
                Sensor defaultSensor = sensorManager.getDefaultSensor(3);
                Sensor defaultSensor2 = sensorManager.getDefaultSensor(11);
                if (defaultSensor == null && defaultSensor2 == null) {
                    this.f6493a = null;
                    return;
                }
                this.i = false;
                try {
                    sensorManager.unregisterListener(this);
                    this.f6493a = null;
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b() {
        com.baidu.navisdk.util.worker.c.a().c(new a("BNSensorManager", null), new e(99, 0));
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0059  */
    @Override // android.hardware.SensorEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onSensorChanged(android.hardware.SensorEvent r6) {
        /*
            r5 = this;
            android.hardware.Sensor r0 = r6.sensor
            int r0 = r0.getType()
            r1 = 11
            r2 = 3
            if (r0 == r2) goto L14
            android.hardware.Sensor r0 = r6.sensor
            int r0 = r0.getType()
            if (r0 == r1) goto L14
            return
        L14:
            android.hardware.SensorManager r0 = r5.f
            if (r0 != 0) goto L19
            return
        L19:
            android.hardware.Sensor r0 = r6.sensor
            int r0 = r0.getType()
            android.hardware.Sensor r3 = r5.h
            if (r3 == 0) goto L35
            if (r1 != r0) goto L35
            if (r1 != r0) goto L35
            float[] r3 = r5.e
            float[] r4 = r6.values
            com.baidu.navisdk.adapter.impl.base.mapsensor.c.a(r3, r4)
            float[] r3 = r5.e
            float[] r4 = r5.d
            android.hardware.SensorManager.getOrientation(r3, r4)
        L35:
            android.view.WindowManager r3 = r5.g
            r4 = 0
            if (r3 == 0) goto L48
            android.view.Display r3 = r3.getDefaultDisplay()     // Catch: java.lang.Exception -> L47
            if (r3 == 0) goto L48
            int r3 = r3.getRotation()     // Catch: java.lang.Exception -> L47
            int r3 = r3 * 90
            goto L49
        L47:
        L48:
            r3 = 0
        L49:
            if (r2 != r0) goto L59
            com.baidu.navisdk.adapter.impl.base.mapsensor.a r0 = r5.b
            float[] r1 = r6.values
            r1 = r1[r4]
            float r0 = r0.a(r1)
            int r0 = (int) r0
            int r4 = r0 + r3
            goto L7f
        L59:
            if (r0 != r1) goto L7f
            if (r3 != 0) goto L6d
            float[] r0 = r5.d
            r1 = r0[r4]
            r2 = 2
            r0 = r0[r2]
            float r1 = r1 - r0
            double r0 = (double) r1
            double r0 = java.lang.Math.toDegrees(r0)
        L6a:
            int r0 = (int) r0
            int r0 = r0 + r3
            goto L7b
        L6d:
            float[] r0 = r5.d
            r1 = r0[r4]
            r2 = 1
            r0 = r0[r2]
            float r1 = r1 - r0
            double r0 = (double) r1
            double r0 = java.lang.Math.toDegrees(r0)
            goto L6a
        L7b:
            int r0 = r0 + 360
            int r4 = r0 % 360
        L7f:
            com.baidu.navisdk.adapter.impl.base.mapsensor.b$c r0 = r5.m
            if (r0 == 0) goto L88
            float[] r6 = r6.values
            r0.onSensorChanged(r4, r6)
        L88:
            int r6 = r5.c
            int r6 = r6 - r4
            int r6 = java.lang.Math.abs(r6)
            r0 = 30
            if (r6 >= r0) goto L9c
            float r6 = (float) r4
            int r0 = r5.c
            float r0 = (float) r0
            float r6 = com.baidu.navisdk.adapter.impl.base.mapsensor.c.a(r6, r0)
            int r4 = (int) r6
        L9c:
            r5.c = r4
            com.baidu.navisdk.adapter.impl.base.mapsensor.b$c r6 = r5.m
            if (r6 == 0) goto La5
            r6.onSensorChanged(r4)
        La5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.adapter.impl.base.mapsensor.b.onSensorChanged(android.hardware.SensorEvent):void");
    }

    public void a(c cVar) {
        this.m = cVar;
    }

    public int a() {
        return this.c;
    }
}
