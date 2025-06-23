package com.jd.ad.sdk.bl.dynamicrender;

import XIXIX.OOXIXo;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.jd.ad.sdk.logger.Logger;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes10.dex */
public abstract class ShakeListener implements SensorEventListener, Handler.Callback {
    public SensorManager jad_an;
    public float jad_bo;
    public float[] jad_cp;
    public float[] jad_dq;
    public boolean jad_er;
    public float jad_fs;
    public double jad_hu;
    public List<Long> jad_iv;
    public float jad_jt;
    public List<Long> jad_jw;
    public long jad_kx;
    public long jad_ly;
    public Handler jad_mz;
    public long jad_na;
    public double jad_ob;

    public ShakeListener(Context context) {
        this.jad_bo = 0.0f;
        this.jad_cp = new float[4];
        this.jad_dq = new float[4];
        this.jad_er = false;
        this.jad_fs = 0.0f;
        this.jad_jt = 0.0f;
        this.jad_hu = 1500.0d;
        this.jad_iv = new ArrayList();
        this.jad_jw = new ArrayList();
        this.jad_kx = 0L;
        this.jad_na = 0L;
        this.jad_ob = 2000.0d;
        try {
            this.jad_an = (SensorManager) context.getSystemService("sensor");
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        jad_an();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x003e, code lost:
    
        if (r7.jad_bo > 0.0f) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void jad_an() {
        /*
            r7 = this;
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L34
            long r2 = r7.jad_na     // Catch: java.lang.Exception -> L34
            long r2 = r0 - r2
            double r2 = (double) r2     // Catch: java.lang.Exception -> L34
            double r4 = r7.jad_ob     // Catch: java.lang.Exception -> L34
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 > 0) goto L10
            return
        L10:
            r7.jad_na = r0     // Catch: java.lang.Exception -> L34
            java.util.List<java.lang.Long> r0 = r7.jad_iv     // Catch: java.lang.Exception -> L34
            boolean r0 = r7.jad_an(r0)     // Catch: java.lang.Exception -> L34
            java.util.List<java.lang.Long> r1 = r7.jad_jw     // Catch: java.lang.Exception -> L34
            boolean r1 = r7.jad_an(r1)     // Catch: java.lang.Exception -> L34
            float r2 = r7.jad_fs     // Catch: java.lang.Exception -> L34
            r3 = 0
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L36
            float r5 = r7.jad_bo     // Catch: java.lang.Exception -> L34
            int r5 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r5 <= 0) goto L36
            if (r0 == 0) goto L32
            if (r1 == 0) goto L32
            r0 = 1
            goto L40
        L32:
            r0 = 0
            goto L40
        L34:
            r0 = move-exception
            goto L4d
        L36:
            if (r2 <= 0) goto L3a
            r0 = r1
            goto L40
        L3a:
            float r1 = r7.jad_bo     // Catch: java.lang.Exception -> L34
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 <= 0) goto L32
        L40:
            if (r0 == 0) goto L49
            r7.onShake()     // Catch: java.lang.Exception -> L34
            r7.jad_dq()     // Catch: java.lang.Exception -> L34
            goto L53
        L49:
            r7.jad_dq()     // Catch: java.lang.Exception -> L34
            goto L53
        L4d:
            r7.jad_dq()
            r0.printStackTrace()
        L53:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.bl.dynamicrender.ShakeListener.jad_an():void");
    }

    public final synchronized void jad_bo() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.jad_jt > 0.0f) {
                if (currentTimeMillis - this.jad_kx > this.jad_hu) {
                    this.jad_iv = new ArrayList();
                    this.jad_jw = new ArrayList();
                    jad_dq();
                }
                Handler handler = this.jad_mz;
                if (handler == null) {
                    if (handler == null) {
                        this.jad_mz = new Handler(Looper.getMainLooper(), this);
                    }
                    Handler handler2 = this.jad_mz;
                    if (handler2 != null) {
                        handler2.sendEmptyMessageDelayed(1, this.jad_jt * 1000.0f);
                    }
                }
            }
            this.jad_kx = currentTimeMillis;
            if (this.jad_iv == null) {
                this.jad_iv = new ArrayList();
            }
            this.jad_iv.add(Long.valueOf(currentTimeMillis));
            if (this.jad_jt == 0.0f) {
                jad_an();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void jad_cp() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.jad_jt > 0.0f) {
                if (currentTimeMillis - this.jad_ly > this.jad_hu) {
                    this.jad_jw = new ArrayList();
                    this.jad_iv = new ArrayList();
                    jad_dq();
                }
                Handler handler = this.jad_mz;
                if (handler == null) {
                    if (handler == null) {
                        this.jad_mz = new Handler(Looper.getMainLooper(), this);
                    }
                    Handler handler2 = this.jad_mz;
                    if (handler2 != null) {
                        handler2.sendEmptyMessageDelayed(1, this.jad_jt * 1000.0f);
                    }
                }
            }
            this.jad_ly = currentTimeMillis;
            if (this.jad_jw == null) {
                this.jad_jw = new ArrayList();
            }
            this.jad_jw.add(Long.valueOf(currentTimeMillis));
            if (this.jad_jt == 0.0f) {
                jad_an();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void jad_dq() {
        Handler handler = this.jad_mz;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.jad_mz = null;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        try {
            if (sensorEvent.sensor.getType() == 1) {
                if (this.jad_bo > 0.0f) {
                    float[] fArr = sensorEvent.values;
                    if (Math.sqrt(Math.pow(fArr[0], 2.0d) + Math.pow(fArr[1], 2.0d) + Math.pow(fArr[2], 2.0d)) > this.jad_bo) {
                        jad_bo();
                    }
                }
            } else if (sensorEvent.sensor.getType() == 11 && this.jad_fs > 0.0f) {
                float[] fArr2 = sensorEvent.values;
                float[] fArr3 = this.jad_dq;
                System.arraycopy(fArr2, 0, fArr3, 0, fArr3.length);
                if (!this.jad_er) {
                    float[] fArr4 = this.jad_dq;
                    System.arraycopy(fArr4, 0, this.jad_cp, 0, fArr4.length);
                    this.jad_er = true;
                } else {
                    float[] fArr5 = new float[4];
                    SensorManager.getQuaternionFromVector(fArr5, this.jad_cp);
                    float[] fArr6 = new float[4];
                    SensorManager.getQuaternionFromVector(fArr6, this.jad_dq);
                    float f = fArr5[0];
                    float f2 = fArr6[0];
                    float f3 = fArr5[1];
                    float f4 = fArr6[1];
                    float f5 = fArr5[2];
                    float f6 = fArr6[2];
                    float f7 = f5 * f6;
                    float f8 = fArr5[3] * fArr6[3];
                    if (this.jad_fs <= Math.toDegrees(Math.acos(Math.min(Math.max(((f8 + (f7 + ((f3 * f4) + (f * f2)))) * (((r9 * r11) + ((f5 * f6) + ((f3 * f4) + (f * f2)))) * 2.0f)) - 1.0f, -1.0d), 1.0d)))) {
                        this.jad_cp = fArr5;
                        jad_cp();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public abstract void onShake();

    public void register() {
        try {
            SensorManager sensorManager = this.jad_an;
            if (sensorManager != null) {
                sensorManager.registerListener(this, sensorManager.getDefaultSensor(1), 2);
                SensorManager sensorManager2 = this.jad_an;
                sensorManager2.registerListener(this, sensorManager2.getDefaultSensor(11), 3);
            }
        } catch (Exception e) {
            Logger.w("Exception while register shake listener: " + e, new Object[0]);
        }
    }

    public void unregister() {
        jad_dq();
        SensorManager sensorManager = this.jad_an;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
    }

    public final boolean jad_an(List<Long> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        if (this.jad_jt == 0.0f) {
            return true;
        }
        if (list.size() < 2) {
            return false;
        }
        int size = list.size();
        double longValue = list.get(0).longValue();
        int i = size - 1;
        double longValue2 = list.get(i).longValue();
        if (longValue2 - longValue <= OOXIXo.f3760XO) {
            return false;
        }
        double d = 0.0d;
        for (int i2 = 1; i2 < size; i2++) {
            double longValue3 = list.get(i2).longValue() - list.get(i2 - 1).longValue();
            if (longValue3 < OOXIXo.f3760XO) {
                return false;
            }
            d += longValue3;
        }
        double d2 = i;
        return d / d2 <= ((double) (this.jad_jt * 1000.0f)) / d2 && ((double) System.currentTimeMillis()) - longValue2 < this.jad_hu;
    }

    public ShakeListener(Context context, float f, float f2, float f3) {
        this.jad_bo = 0.0f;
        this.jad_cp = new float[4];
        this.jad_dq = new float[4];
        this.jad_er = false;
        this.jad_fs = 0.0f;
        this.jad_jt = 0.0f;
        this.jad_hu = 1500.0d;
        this.jad_iv = new ArrayList();
        this.jad_jw = new ArrayList();
        this.jad_kx = 0L;
        this.jad_na = 0L;
        this.jad_ob = 2000.0d;
        try {
            this.jad_an = (SensorManager) context.getSystemService("sensor");
            this.jad_bo = f;
            this.jad_fs = f2;
            this.jad_jt = f3;
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    public ShakeListener(Context context, float f, float f2, float f3, boolean z) {
        this.jad_bo = 0.0f;
        this.jad_cp = new float[4];
        this.jad_dq = new float[4];
        this.jad_er = false;
        this.jad_fs = 0.0f;
        this.jad_jt = 0.0f;
        this.jad_hu = 1500.0d;
        this.jad_iv = new ArrayList();
        this.jad_jw = new ArrayList();
        this.jad_kx = 0L;
        this.jad_na = 0L;
        this.jad_ob = 2000.0d;
        try {
            this.jad_an = (SensorManager) context.getSystemService("sensor");
            this.jad_bo = f;
            this.jad_fs = f2;
            this.jad_jt = f3;
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }
}
