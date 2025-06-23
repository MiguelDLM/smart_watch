package com.baidu.navisdk.framework.vmsr;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.navisdk.util.common.LogUtil;
import java.lang.reflect.Array;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class n extends d {
    private o A0;
    private int B0;
    private boolean C0;
    private boolean D0;
    private boolean E0;
    private boolean F0;
    private boolean G0;
    private long H0;

    /* renamed from: I0, reason: collision with root package name */
    private boolean f6845I0;
    private boolean J0;
    private volatile boolean K0;
    private SensorManager L0;
    private volatile boolean M0;
    private Timer N0;

    /* renamed from: O0, reason: collision with root package name */
    private TimerTask f6846O0;
    private long P0;
    private SensorEventListener Q0;
    private float j0;
    private float k0;
    private float l0;
    private float m0;
    private int n0;

    /* renamed from: o0, reason: collision with root package name */
    private float[][] f6847o0;
    private float[][][] p0;
    private boolean q0;
    private boolean r0;
    private boolean s0;
    private boolean t0;
    private boolean u0;
    private volatile String v0;
    private String[] w0;

    /* renamed from: x0, reason: collision with root package name */
    private float[] f6848x0;
    private q y0;
    private f z0;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n.this.w();
        }
    }

    /* loaded from: classes7.dex */
    public class b extends TimerTask {
        public b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            n.this.v();
        }
    }

    /* loaded from: classes7.dex */
    public class c implements SensorEventListener {
        public c() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            int type = sensorEvent.sensor.getType();
            if (type != 1) {
                if (type != 15) {
                    if (type != 9) {
                        if (type != 10) {
                            return;
                        }
                    } else {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (elapsedRealtime - n.this.P0 > 200) {
                            n.this.P0 = elapsedRealtime;
                            n.this.L[0] = (int) Math.floor(Math.toDegrees(Math.acos(sensorEvent.values[0] / 9.81f)));
                            n.this.L[1] = (int) Math.floor(Math.toDegrees(Math.acos(sensorEvent.values[1] / 9.81f)));
                            n.this.L[2] = (int) Math.floor(Math.toDegrees(Math.acos(sensorEvent.values[2] / 9.81f)));
                            if (LogUtil.LOGGABLE) {
                                LogUtil.e("Vmsr", "monitorAngle angleX:" + n.this.L[0] + ", angleY:" + n.this.L[1] + ", angleZ:" + n.this.L[2]);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                } else {
                    float[] fArr = n.this.X;
                    float[] fArr2 = sensorEvent.values;
                    fArr[0] = fArr2[0];
                    fArr[1] = fArr2[1];
                    fArr[2] = fArr2[2];
                    return;
                }
            }
            n.this.j0 = sensorEvent.values[0] / (-9.81f);
            n.this.k0 = sensorEvent.values[1] / (-9.81f);
            n.this.l0 = sensorEvent.values[2] / (-9.81f);
        }
    }

    public n(Context context) {
        super(context);
        this.j0 = 0.0f;
        this.k0 = 0.0f;
        this.l0 = 0.0f;
        this.m0 = 0.0f;
        this.n0 = 0;
        this.q0 = false;
        this.r0 = false;
        this.s0 = false;
        this.t0 = false;
        this.u0 = false;
        this.v0 = ExifInterface.LATITUDE_SOUTH;
        this.w0 = new String[]{ExifInterface.LATITUDE_SOUTH, "M"};
        this.f6848x0 = null;
        this.C0 = false;
        this.D0 = false;
        this.E0 = true;
        this.F0 = true;
        this.G0 = true;
        this.H0 = 0L;
        this.f6845I0 = false;
        this.J0 = false;
        this.K0 = false;
        this.M0 = false;
        this.N0 = null;
        this.f6846O0 = null;
        this.P0 = 0L;
        this.Q0 = new c();
    }

    private boolean A() {
        String str;
        boolean h = h();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "handleAutoTrainData onTouchMode:" + h);
        }
        if (d() && !h) {
            return true;
        }
        if (!h) {
            this.q0 = false;
            this.r0 = false;
        }
        n();
        m mVar = this.f0;
        if (mVar != null) {
            if (h) {
                str = "2";
            } else {
                str = "1";
            }
            if (ExifInterface.LATITUDE_SOUTH.equals(this.v0)) {
                if (!h) {
                    this.o++;
                    mVar.a(0, "main stop pose diff too large : " + this.o);
                } else {
                    mVar.a(0, "main stop onTouch : " + this.o);
                }
                mVar.a(1, "3", null, str);
            } else {
                if (!h) {
                    this.p++;
                    mVar.a(0, "main move pose diff too large : " + this.o);
                } else {
                    mVar.a(0, "main move onTouch : " + this.o);
                }
                mVar.a(1, "6", null, str);
            }
        }
        return false;
    }

    private boolean B() {
        if (this.d0 || this.y >= 100 || this.z < 30) {
            return true;
        }
        return false;
    }

    private void C() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "firstVerifySuccess");
        }
        V();
        m mVar = this.f0;
        if (mVar != null) {
            mVar.a(3, "1", null, null);
            mVar.b(12);
            mVar.a(1, true);
        }
        this.D0 = true;
        this.E0 = true;
        a(this.f6848x0, this.w0, this.O, this.W, this.Y);
        n();
        this.H0 = SystemClock.elapsedRealtime();
        if (this.P) {
            S();
        }
    }

    private String D() {
        return this.e0.getFilesDir().getPath() + "/vmsr/config.png";
    }

    private int E() {
        int i;
        com.baidu.navisdk.framework.vmsr.b.c(this.V, 100, 3);
        float d = com.baidu.navisdk.framework.vmsr.b.d(this.V, 100, 0);
        float d2 = com.baidu.navisdk.framework.vmsr.b.d(this.V, 100, 1);
        float d3 = com.baidu.navisdk.framework.vmsr.b.d(this.V, 100, 2);
        float[] fArr = this.W;
        float f = d / fArr[0];
        float f2 = d2 / fArr[1];
        float f3 = d3 / fArr[2];
        float max = Math.max(f, Math.max(f2, f3));
        if (f <= 2.0f && f2 <= 2.0f && f3 <= 2.0f) {
            i = 32;
        } else {
            i = 8;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "getGyroscopeResult maxValue:" + d + "," + d2 + "," + d3);
            LogUtil.e("Vmsr", "mian getGyroscopeResult factor, x:" + f + ", y:" + f2 + ", z:" + f3 + ", max:" + max);
        }
        if (LogUtil.LOGGABLE) {
            m mVar = this.f0;
            if (mVar != null && i == 32 && !t.d(f()) && !t.a(f())) {
                mVar.a(0, "m stop err F=" + String.format("%.2f", Float.valueOf(f)) + " , " + String.format("%.2f", Float.valueOf(f2)) + " , " + String.format("%.2f", Float.valueOf(f3)));
                StringBuilder sb = new StringBuilder();
                sb.append("m cm : ");
                sb.append(this.z);
                sb.append("/");
                sb.append(this.y);
                mVar.a(0, sb.toString());
            } else if (mVar != null && i == 8 && (t.d(f()) || t.a(f()))) {
                mVar.a(0, "m move err F=" + String.format("%.2f", Float.valueOf(f)) + " , " + String.format("%.2f", Float.valueOf(f2)) + " , " + String.format("%.2f", Float.valueOf(f3)));
                StringBuilder sb2 = new StringBuilder();
                sb2.append("m cm :: ");
                sb2.append(this.z);
                sb2.append("/");
                sb2.append(this.y);
                mVar.a(0, sb2.toString());
            }
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x046c  */
    /* JADX WARN: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void F() {
        /*
            Method dump skipped, instructions count: 1141
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.framework.vmsr.n.F():void");
    }

    private void G() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "mStartPoseDiff  " + this.N[0] + " , " + this.N[1] + " , " + this.N[2]);
        }
        if (this.q0) {
            if (this.r0 || this.J0) {
                y();
            }
        }
    }

    private boolean H() {
        if (this.J0) {
            return false;
        }
        m mVar = this.f0;
        if ("M".equals(this.v0)) {
            if (b(3)) {
                if (j.a(this.U, 0.5f)) {
                    this.r0 = true;
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("Vmsr", "mAutoTrainMovementDataOk");
                    }
                    if (mVar != null) {
                        mVar.a(1, "5", null, null);
                        mVar.b(6);
                    }
                } else {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("Vmsr", "record move Data invalidate");
                    }
                    this.p++;
                    if (mVar != null) {
                        mVar.a(1, "6", null, null);
                        mVar.a(this.B0, 1);
                    }
                }
            } else {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("Vmsr", "movement Data fail");
                }
                this.p++;
                if (mVar != null) {
                    mVar.a(1, "6", null, null);
                    mVar.a(this.B0, 1);
                }
            }
        }
        return this.r0;
    }

    private boolean I() {
        m mVar = this.f0;
        if (ExifInterface.LATITUDE_SOUTH.equals(this.v0)) {
            if (c(3)) {
                if (c()) {
                    this.q0 = true;
                    int[] iArr = this.O;
                    int[] iArr2 = this.M;
                    iArr[0] = iArr2[0];
                    iArr[1] = iArr2[1];
                    iArr[2] = iArr2[2];
                    com.baidu.navisdk.framework.vmsr.b.c(this.V, 300, 3);
                    this.W[0] = com.baidu.navisdk.framework.vmsr.b.d(this.V, 300, 0);
                    this.W[1] = com.baidu.navisdk.framework.vmsr.b.d(this.V, 300, 1);
                    this.W[2] = com.baidu.navisdk.framework.vmsr.b.d(this.V, 300, 2);
                    this.Y[0] = com.baidu.navisdk.framework.vmsr.b.b(this.V, 300, 0);
                    this.Y[1] = com.baidu.navisdk.framework.vmsr.b.b(this.V, 300, 1);
                    this.Y[2] = com.baidu.navisdk.framework.vmsr.b.b(this.V, 300, 2);
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("Vmsr", "gmStopDataOk");
                        LogUtil.e("Vmsr", "handleAutoTrainStopData mStopGyroscope:" + this.W[0] + "," + this.W[1] + "," + this.W[2]);
                        LogUtil.e("Vmsr", "handleAutoTrainStopData mStopStandardDiviation:" + this.Y[0] + "," + this.Y[1] + "," + this.Y[2]);
                    }
                    float[] fArr = this.W;
                    fArr[0] = Math.max(this.f6839a, fArr[0]);
                    float[] fArr2 = this.W;
                    fArr2[1] = Math.max(this.f6839a, fArr2[1]);
                    float[] fArr3 = this.W;
                    fArr3[2] = Math.max(this.f6839a, fArr3[2]);
                    float[] fArr4 = this.Y;
                    fArr4[0] = Math.max(0.0015f, fArr4[0]);
                    float[] fArr5 = this.Y;
                    fArr5[1] = Math.max(0.0015f, fArr5[1]);
                    float[] fArr6 = this.Y;
                    fArr6[2] = Math.max(0.0015f, fArr6[2]);
                    if (mVar != null) {
                        mVar.a(1, "2", null, null);
                        mVar.b(5);
                    }
                } else {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("Vmsr", "record stop Data invalidate");
                    }
                    this.o++;
                    if (mVar != null) {
                        mVar.a(1, "3", null, "3");
                        mVar.a(this.B0, 0);
                        mVar.a(0, "main Stop Data too large : " + this.o);
                    }
                }
            } else {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("Vmsr", "stop Data fail");
                }
                if (mVar != null) {
                    mVar.a(1, "3", null, "4");
                    mVar.a(this.B0, 0);
                    mVar.a(0, "main gps not all stop : " + this.o);
                }
            }
        }
        return this.q0;
    }

    private boolean J() {
        m mVar = this.f0;
        if (!this.f6845I0 && L()) {
            R();
        }
        if (this.f6845I0 && !TextUtils.isEmpty(this.I[0]) && !TextUtils.isEmpty(this.I[1])) {
            float[] fArr = this.J;
            if (fArr[0] < 0.6f && fArr[1] < 0.6f) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("Vmsr", "handlePeriodVerify");
                }
                return true;
            }
            if (!this.G0 && d(5)) {
                if (!this.I[1].equals("M") && !this.I[0].equals("M")) {
                    this.G0 = false;
                    this.E0 = false;
                    if (mVar != null) {
                        mVar.a(5, "2", "2", null);
                    }
                } else {
                    this.G0 = true;
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("Vmsr", "mPeriodVerify MoveDataOK:");
                    }
                    if (mVar != null) {
                        mVar.b(19);
                    }
                }
            } else if (!this.F0 && c(5)) {
                if (!this.I[1].equals(ExifInterface.LATITUDE_SOUTH) && !this.I[0].equals(ExifInterface.LATITUDE_SOUTH)) {
                    if (this.r > 100 && this.A < 0.1f) {
                        if (LogUtil.LOGGABLE) {
                            LogUtil.e("Vmsr", "mFailRate is low");
                        }
                    } else {
                        this.F0 = false;
                        this.E0 = false;
                        if (mVar != null) {
                            mVar.a(5, "2", "1", null);
                        }
                    }
                } else {
                    this.F0 = true;
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("Vmsr", "mPeriodVerify StopDataOK:");
                    }
                    if (mVar != null) {
                        mVar.b(18);
                    }
                }
            }
            boolean z = this.E0;
            if (z && this.G0 && this.F0) {
                W();
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("Vmsr", "mPeriodVerifySuccess :" + this.E0);
                }
                if (mVar != null) {
                    mVar.a(5, "1", null, null);
                    mVar.b(17);
                }
            } else {
                if (!z) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("Vmsr", "mPeriodVerifySuccess :" + this.E0 + ", mPeriodVerifyMoveOk" + this.G0 + ", mPeriodVerifyStopOk" + this.F0);
                    }
                    this.x++;
                    if (mVar != null) {
                        mVar.b(16);
                    }
                    try {
                        com.baidu.navisdk.util.common.s.a(D());
                    } catch (Exception e) {
                        if (LogUtil.LOGGABLE) {
                            LogUtil.printException("del config", e);
                        }
                    }
                    X();
                    W();
                    a(true);
                    return false;
                }
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("Vmsr", "PeriodVerifyResult :" + this.E0 + ", mPeriodVerifyMoveOk" + this.G0 + ", mPeriodVerifyStopOk" + this.F0);
                }
            }
        }
        return true;
    }

    private boolean K() {
        try {
            String e = com.baidu.navisdk.util.common.s.e(D());
            if (!TextUtils.isEmpty(e)) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("Vmsr", "cacheStr:" + e);
                }
                JSONObject jSONObject = new JSONObject(e);
                JSONArray optJSONArray = jSONObject.optJSONArray("weight");
                int length = optJSONArray.length();
                this.f6848x0 = new float[length];
                for (int i = 0; i < length; i++) {
                    this.f6848x0[i] = Float.valueOf(optJSONArray.optString(i)).floatValue();
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("action");
                int length2 = optJSONArray2.length();
                this.w0 = new String[length2];
                for (int i2 = 0; i2 < length2; i2++) {
                    this.w0[i2] = optJSONArray2.optString(i2);
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("angle");
                int length3 = optJSONArray3.length();
                this.O = new int[length3];
                for (int i3 = 0; i3 < length3; i3++) {
                    this.O[i3] = optJSONArray3.optInt(i3);
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("gyroscope");
                int length4 = optJSONArray4.length();
                for (int i4 = 0; i4 < length4; i4++) {
                    this.W[i4] = Float.valueOf(optJSONArray4.optString(i4)).floatValue();
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("sdiviation");
                int length5 = optJSONArray5.length();
                for (int i5 = 0; i5 < length5; i5++) {
                    this.Y[i5] = Float.valueOf(optJSONArray5.optString(i5)).floatValue();
                }
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("Vmsr", "init mStopGyroscope:" + this.W[0] + "," + this.W[1] + "," + this.W[2]);
                    LogUtil.e("Vmsr", "init mStopStandardDiviation:" + this.Y[0] + "," + this.Y[1] + "," + this.Y[0]);
                }
            } else {
                this.f6848x0 = null;
                this.w0 = new String[]{ExifInterface.LATITUDE_SOUTH, "M"};
            }
            this.y0 = new q(300, r.f6854a, this.w0.length);
            f fVar = new f(com.baidu.navisdk.framework.vmsr.a.a(1), com.baidu.navisdk.framework.vmsr.a.a(2), g.a(0), 0.4f, 0.2f);
            this.z0 = fVar;
            this.A0 = new o(this.y0, fVar, this.f6848x0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.U = com.baidu.navisdk.framework.vmsr.b.a(0.0f, 300, 4);
        this.V = com.baidu.navisdk.framework.vmsr.b.a(0.0f, 300, 3);
        this.f6847o0 = com.baidu.navisdk.framework.vmsr.b.a(0.0f, 10, 300);
        if (this.f6848x0 != null && this.w0.length > 1 && this.O[0] != -1) {
            return true;
        }
        return false;
    }

    private boolean L() {
        if (this.d0) {
            return false;
        }
        if (this.A <= 0.1f) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("Vmsr", "mFailRate is low no needPeriodVerify ");
            }
            return false;
        }
        if (SystemClock.elapsedRealtime() - this.H0 <= this.h * 1000) {
            return false;
        }
        return true;
    }

    private void M() {
        boolean z;
        float f;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "recordDataReady start");
        }
        this.K0 = true;
        if (LogUtil.LOGGABLE) {
            d.a(this.U, this.v0 + "_main_" + f() + "_", 300);
            d.a(this.V, this.v0 + "_main_Gyroscope_" + f() + "_", 300);
        }
        m mVar = this.f0;
        if (mVar != null) {
            mVar.b(1);
        }
        if (this.B0 == 3 && A() && ((ExifInterface.LATITUDE_SOUTH.equals(this.v0) && I()) || ("M".equals(this.v0) && H()))) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.w0 = a(this.w0, this.v0);
            if (this.p0 == null) {
                this.p0 = (float[][][]) Array.newInstance((Class<?>) Float.TYPE, 2, 300, 4);
            }
            String[] strArr = this.w0;
            int length = strArr.length;
            int a2 = com.baidu.navisdk.framework.vmsr.b.a(strArr, this.v0);
            int length2 = this.w0.length;
            float[][][] fArr = this.p0;
            if (length2 > fArr.length) {
                float[][][] fArr2 = (float[][][]) Array.newInstance((Class<?>) Float.TYPE, length, 300, 4);
                int i = 0;
                while (true) {
                    float[][][] fArr3 = this.p0;
                    if (i >= fArr3.length) {
                        break;
                    }
                    fArr2[i] = fArr3[i];
                    i++;
                }
                fArr2[a2] = this.U;
                this.p0 = fArr2;
            } else {
                fArr[a2] = this.U;
            }
            if (this.J0) {
                float a3 = j.a(this.U);
                if (a3 < 0.01f) {
                    f = 5.0f;
                } else if (a3 < 0.05f) {
                    f = 2.5f;
                } else if (a3 < 0.1f) {
                    f = 2.1f;
                } else if (a3 < 0.15f) {
                    f = 2.0f;
                } else if (a3 < 0.2f) {
                    f = 1.7f;
                } else {
                    f = 1.4f;
                }
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("Vmsr", "scale:" + f);
                }
                for (int i2 = 0; i2 < this.U.length; i2++) {
                    int i3 = 0;
                    while (true) {
                        float[][] fArr4 = this.U;
                        if (i3 < fArr4[0].length) {
                            this.p0[1][i2][i3] = fArr4[i2][i3] * f;
                            i3++;
                        }
                    }
                }
            }
        }
        if (this.B0 == 3) {
            G();
        }
        if (z) {
            this.U = com.baidu.navisdk.framework.vmsr.b.a(0.0f, 300, 4);
        }
        this.K0 = false;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "recordDataReady end");
        }
    }

    private boolean N() {
        return false;
    }

    private void O() {
        if (!this.q0 && c(2)) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("Vmsr", "startAutoTrainCheck can record stop");
            }
        } else if (!this.r0 && !this.J0 && b(1)) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("Vmsr", "startAutoTrainCheck can record move");
            }
        } else {
            return;
        }
        if (!this.K0 && !this.M0) {
            if (this.n < this.g && this.o < 20) {
                boolean h = h();
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("Vmsr", "startAutoTrainCheck onTouchMode: " + h);
                }
                if (h) {
                    return;
                }
                m mVar = this.f0;
                if (!this.q0 && c(2)) {
                    if (mVar != null) {
                        mVar.a(1, "1", null, null);
                    }
                    this.v0 = ExifInterface.LATITUDE_SOUTH;
                    T();
                    return;
                }
                if (!this.r0 && !this.J0 && b(1)) {
                    if (mVar != null) {
                        mVar.a(1, "4", null, null);
                    }
                    this.v0 = "M";
                    T();
                    return;
                }
                return;
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e("Vmsr", "model train times over times:" + this.n);
                LogUtil.e("Vmsr", "model train mStopSampleFailTimes:" + this.o);
            }
            X();
            W();
            this.q0 = false;
            this.r0 = false;
            a(false);
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "startAutoTrainCheck isTrainning: " + this.K0 + ", isSensorInitialized" + this.M0);
        }
    }

    private void P() {
        this.B0 = 5;
        this.t0 = false;
        this.u0 = false;
        this.u++;
        n();
        m mVar = this.f0;
        if (mVar != null) {
            mVar.b(9);
        }
    }

    private void Q() {
        if (this.d0) {
            this.t0 = true;
            this.u0 = true;
            C();
            return;
        }
        if (!this.K0 && !this.M0) {
            boolean h = h();
            if (h) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("Vmsr", "startFirstVerifyCheck !! notTouch: " + h);
                    return;
                }
                return;
            }
            if ((!this.s0 || this.u0) && !this.t0 && c(2)) {
                T();
                return;
            }
            if (!this.u0 && b(1)) {
                T();
                return;
            } else {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("Vmsr", "startFirstVerifyCheck !! continue");
                    return;
                }
                return;
            }
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "startFirstVerifyCheck isTrainning: " + this.K0 + ", isSensorInitialized" + this.M0);
        }
    }

    private void R() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "startPeriodVerify :" + this.f6845I0);
        }
        if (!this.f6845I0) {
            this.E0 = true;
            this.f6845I0 = true;
            this.F0 = false;
            this.G0 = false;
            this.w++;
            m mVar = this.f0;
            if (mVar != null) {
                mVar.b(15);
            }
        }
    }

    private void S() {
        if (this.B0 == 4) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("Vmsr", "startPredictInner return 1");
                return;
            }
            return;
        }
        m mVar = this.f0;
        if (!a()) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("Vmsr", "startPredictInner return 2");
            }
            if (mVar != null && !this.c) {
                mVar.a(1);
                return;
            }
            return;
        }
        if (mVar != null) {
            mVar.b(21);
        }
        this.B0 = 4;
        n();
        this.g0.postDelayed(new a(), 0L);
    }

    private void T() {
        m mVar;
        int i = this.B0;
        if ((i == 2 || i == 1 || i == 3) && (mVar = this.f0) != null) {
            mVar.b(0);
        }
        w();
    }

    private void U() {
        Timer timer = this.N0;
        if (timer != null) {
            timer.cancel();
        }
        this.N0 = new Timer("BNav_MainRecognizeSys");
        b bVar = new b();
        this.f6846O0 = bVar;
        this.N0.schedule(bVar, 1000L, 10L);
    }

    private void V() {
        this.B0 = -1;
    }

    private void W() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "stopPeriodVerify :" + this.f6845I0 + ", mPeriodVerifyStopOk:" + this.F0 + ", mPeriodVerifyMoveOk:" + this.G0);
        }
        if (this.f6845I0 && this.F0 && this.G0) {
            this.H0 = SystemClock.elapsedRealtime();
        }
        this.f6845I0 = false;
    }

    private void X() {
        W();
        if (a() && this.B0 == 4) {
            this.B0 = -1;
            z();
        }
    }

    private void Y() {
        Timer timer = this.N0;
        if (timer != null) {
            timer.cancel();
            this.N0 = null;
        }
    }

    private void f(int i) {
        float[] fArr = this.V[i];
        float[] fArr2 = this.X;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        fArr[2] = fArr2[2];
    }

    @Override // com.baidu.navisdk.framework.vmsr.d
    public void m() {
        if (this.c && !a()) {
            return;
        }
        super.m();
    }

    @Override // com.baidu.navisdk.framework.vmsr.d
    public boolean o() {
        super.o();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "start");
        }
        this.D0 = false;
        this.E0 = true;
        m mVar = this.f0;
        if (a()) {
            if (mVar != null) {
                mVar.b(7);
            }
        } else if (!K()) {
            a(true);
        } else {
            if (mVar != null) {
                mVar.b(7);
            }
            this.C0 = true;
            this.s0 = true;
            P();
        }
        return true;
    }

    @Override // com.baidu.navisdk.framework.vmsr.d
    public void p() {
        super.p();
        m mVar = this.f0;
        if (this.B0 != 3) {
            this.s0 = false;
            this.q0 = false;
            this.r0 = false;
            this.D0 = false;
            this.E0 = true;
            this.n0 = 0;
            this.m0 = 0.0f;
            this.B0 = 3;
            n();
            try {
                com.baidu.navisdk.util.common.s.a(D());
            } catch (Exception e) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.printException("del config", e);
                }
            }
            if (mVar != null) {
                mVar.b(2);
                mVar.a(1, false);
            }
        }
    }

    @Override // com.baidu.navisdk.framework.vmsr.d
    public void q() {
        super.q();
        S();
    }

    @Override // com.baidu.navisdk.framework.vmsr.d
    public void r() {
        super.r();
        m mVar = this.f0;
        if (this.B0 == 3) {
            this.B0 = -1;
            z();
            if (mVar != null) {
                mVar.b(3);
            }
        }
    }

    @Override // com.baidu.navisdk.framework.vmsr.d
    public void s() {
        super.s();
        X();
    }

    public boolean v() {
        j();
        int i = this.B0;
        if ((i == 1 || i == 4) && this.n0 == 100) {
            LogUtil.e("VmsrControl", "Finished logging data");
            this.n0 = 0;
            this.m0 = 0.0f;
            F();
            return true;
        }
        int i2 = this.n0;
        if (i2 == 300) {
            LogUtil.e("VmsrControl", "Finished logging data");
            this.n0 = 0;
            this.m0 = 0.0f;
            int i3 = this.B0;
            if (i3 != 2 && i3 != 3) {
                if (i3 == 5) {
                    this.K0 = true;
                    z();
                    F();
                    this.K0 = false;
                }
            } else {
                this.K0 = true;
                z();
                M();
                this.K0 = false;
            }
        } else {
            f(i2);
            float[][] fArr = this.U;
            int i4 = this.n0;
            float[] fArr2 = fArr[i4];
            float f = this.m0;
            fArr2[0] = f;
            fArr2[1] = this.j0;
            fArr2[2] = this.k0;
            fArr2[3] = this.l0;
            this.n0 = i4 + 1;
            this.m0 = f + 0.01f;
        }
        return false;
    }

    public void w() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "startLoggingData");
        }
        a(this.e0);
    }

    public boolean x() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "STOP");
        }
        s();
        W();
        V();
        a(false);
        z();
        this.q0 = false;
        this.r0 = false;
        return true;
    }

    public void y() {
        this.B0 = 0;
        boolean N = N();
        m mVar = this.f0;
        if (N && mVar != null) {
            mVar.b(4);
        }
        a(300, r.f6854a, this.w0);
        a(this.A0, this.y0, this.p0, this.w0, 0.05f, 300, 30, 10, 150, 5, 100, 300);
    }

    public void z() {
        try {
            if (this.L0 != null && this.M0) {
                Log.e("VmsrControl", "[system] unInitSensor");
                this.L0.unregisterListener(this.Q0);
                Y();
                this.M0 = false;
            }
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("Vmsr", "e:" + e.getMessage());
            }
        }
    }

    private boolean b(int i, float f) {
        m mVar = this.f0;
        if (i != 2 && f >= 0.6f) {
            if (!this.t0 && c(3)) {
                if (i != 32 && i != 16) {
                    this.t0 = false;
                    this.v++;
                    if (mVar != null) {
                        mVar.a(3, "2", "1", null);
                        mVar.b(11);
                    }
                } else {
                    this.t0 = true;
                    if (mVar != null) {
                        mVar.b(13);
                    }
                }
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("Vmsr", "mFirstVerifyStopDataOk:" + this.t0);
                }
                return this.t0;
            }
            if (!this.u0 && b(3)) {
                if (i == 8) {
                    this.u0 = true;
                    if (mVar != null) {
                        mVar.b(14);
                    }
                } else {
                    this.u0 = false;
                    this.v++;
                    if (mVar != null) {
                        mVar.a(3, "2", "2", null);
                        mVar.b(11);
                    }
                }
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("Vmsr", "mFirstVerifyMoveDataOk ：" + this.u0);
                }
                return this.u0;
            }
        }
        return true;
    }

    @Override // com.baidu.navisdk.framework.vmsr.l
    public boolean a() {
        return this.C0 && this.D0 && this.E0;
    }

    public void a(int i, int i2, String[] strArr) {
        try {
            this.y0 = new q(i, i2, strArr.length);
            f fVar = new f(com.baidu.navisdk.framework.vmsr.a.a(1), com.baidu.navisdk.framework.vmsr.a.a(2), g.a(0), 0.4f, 0.2f);
            this.z0 = fVar;
            this.A0 = new o(this.y0, fVar);
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                e.printStackTrace();
                LogUtil.printException("nnInit", e);
            }
        }
    }

    public void a(boolean z) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "setAutoTrainEnable :" + z);
        }
        if (!z) {
            r();
        } else if (z) {
            p();
        }
    }

    @Override // com.baidu.navisdk.framework.vmsr.d
    public void a(float f, float f2, int i) {
        super.a(f, f2, i);
        if (this.Q) {
            O();
        } else if (this.B0 == 5) {
            Q();
        }
    }

    private int a(String str, float f) {
        m mVar;
        if (ExifInterface.LATITUDE_SOUTH.equals(str)) {
            int E = E();
            if (E != 32 && LogUtil.LOGGABLE) {
                LogUtil.e("Vmsr", "main Gyroscope result :" + E + ", inference" + f);
                StringBuilder sb = new StringBuilder();
                sb.append("main Gyroscope correct S TO M right:");
                sb.append(g() ^ true);
                LogUtil.e("Vmsr", sb.toString());
            }
            return E;
        }
        if ("M".equals(str) && LogUtil.LOGGABLE && (mVar = this.f0) != null && t.d(f()) && !t.a(f())) {
            mVar.a(0, "m move err : inference" + f);
            mVar.a(0, "m cm : " + this.z + "/" + this.y);
        }
        return 8;
    }

    public void a(Context context) {
        try {
            if (this.L0 == null) {
                this.L0 = (SensorManager) context.getSystemService("sensor");
            }
            if (this.M0) {
                return;
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e("VmsrControl", "[system] initSensor");
            }
            this.L0.registerListener(this.Q0, this.L0.getDefaultSensor(10), 0, p.d().a());
            this.L0.registerListener(this.Q0, this.L0.getDefaultSensor(9), 3, p.d().a());
            this.L0.registerListener(this.Q0, this.L0.getDefaultSensor(15), 0, p.d().a());
            U();
            this.M0 = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public float[][] a(float[][] fArr, int i, int i2, int i3, int i4, int i5, int i6) {
        float[] a2 = a(fArr, i5, i6);
        float b2 = com.baidu.navisdk.framework.vmsr.b.b(a2);
        if (com.baidu.navisdk.framework.vmsr.b.a(a2) >= 0.0f) {
            int i7 = (b2 > 0.0f ? 1 : (b2 == 0.0f ? 0 : -1));
        }
        float f = b2 * (-1.0f);
        int length = a2.length;
        for (int i8 = 0; i8 < length; i8++) {
            a2[i8] = a2[i8] + f;
        }
        float[][] a3 = com.baidu.navisdk.framework.vmsr.b.a(com.baidu.navisdk.framework.vmsr.b.a(0.0f, i4), i);
        for (int i9 = 0; i9 < i; i9++) {
            System.arraycopy(a2, i2, a3[i9], 0, i4);
            i2 += i3;
        }
        return a3;
    }

    public float[] a(float[][] fArr, int i, int i2) {
        float[] a2 = com.baidu.navisdk.framework.vmsr.b.a(0.0f, i);
        for (int i3 = 0; i3 < i; i3++) {
            a2[i3] = fArr[i3][i2];
        }
        return a2;
    }

    public float[][] a(float[][] fArr, int i, int i2, int i3, int i4, int i5) {
        float[][] a2 = com.baidu.navisdk.framework.vmsr.b.a(0.0f, i, i4 * 3);
        float[][] a3 = a(fArr, i, i2, i3, i4, i5, 1);
        float[][] a4 = a(fArr, i, i2, i3, i4, i5, 2);
        float[][] a5 = a(fArr, i, i2, i3, i4, i5, 3);
        for (int i6 = 0; i6 < i; i6++) {
            com.baidu.navisdk.framework.vmsr.b.a(a3[i6], a4[i6], a5[i6], a2[i6]);
        }
        return a2;
    }

    public String[] a(String[] strArr, String str) {
        if (com.baidu.navisdk.framework.vmsr.b.a(strArr, str) >= 0) {
            return strArr;
        }
        String[] strArr2 = new String[strArr.length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[strArr.length] = str;
        return strArr2;
    }

    public void a(o oVar, q qVar, float[][][] fArr, String[] strArr, float f, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8;
        float[][] fArr2;
        int i9;
        float[][] a2;
        float[][] a3;
        String[] strArr2 = strArr;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "trainNNMisc start");
        }
        int length = strArr2.length;
        float[][] a4 = com.baidu.navisdk.framework.vmsr.b.a(0.0f, i2 * length, length);
        float[][] a5 = com.baidu.navisdk.framework.vmsr.b.a(0.0f, i3 * length, length);
        for (int i10 = 0; i10 < length; i10++) {
            for (int i11 = 0; i11 < i2; i11++) {
                a4[(i2 * i10) + i11][i10] = 1.0f;
            }
        }
        for (int i12 = 0; i12 < length; i12++) {
            for (int i13 = 0; i13 < i3; i13++) {
                a5[(i3 * i12) + i13][i12] = 1.0f;
            }
        }
        int length2 = strArr2.length;
        float[][] fArr3 = null;
        float[][] fArr4 = null;
        int i14 = 0;
        while (i14 < length2) {
            int a6 = com.baidu.navisdk.framework.vmsr.b.a(strArr2, strArr2[i14]);
            if (fArr4 == null) {
                i8 = i14;
                fArr2 = fArr3;
                i9 = length2;
                a2 = com.baidu.navisdk.framework.vmsr.b.a(fArr4, a(fArr[a6], i2, 0, i5, i6, i7));
            } else {
                i8 = i14;
                fArr2 = fArr3;
                i9 = length2;
                a2 = com.baidu.navisdk.framework.vmsr.b.a(fArr4, a(fArr[a6], i2, 0, i5, i6, i7));
            }
            float[][] fArr5 = a2;
            if (fArr2 == null) {
                a3 = com.baidu.navisdk.framework.vmsr.b.a(fArr2, a(fArr[a6], i3, i4, i5, i6, i7));
            } else {
                a3 = com.baidu.navisdk.framework.vmsr.b.a(fArr2, a(fArr[a6], i3, i4, i5, i6, i7));
            }
            fArr3 = a3;
            i14 = i8 + 1;
            strArr2 = strArr;
            fArr4 = fArr5;
            length2 = i9;
        }
        float[][] fArr6 = fArr3;
        float[][] fArr7 = fArr4;
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            float[] a7 = oVar.a(new h(fArr7, a4, fArr6, a5, qVar), f, this.J0 ? 30 : 10);
            float f2 = oVar.f;
            boolean z = f2 < f && ((double) f2) > 0.001d;
            this.C0 = z;
            this.n++;
            this.m = SystemClock.elapsedRealtime() - elapsedRealtime;
            if (!z) {
                this.q++;
            }
            m mVar = this.f0;
            if (mVar != null) {
                mVar.a(2, z ? "1" : "2", "" + oVar.f, null);
                mVar.a(z, oVar.f);
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e("Vmsr", "success: " + oVar.f);
            }
            if (!this.C0) {
                this.q0 = false;
                this.r0 = false;
                p();
            } else {
                this.f6848x0 = a7;
                r();
                P();
            }
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                e.printStackTrace();
                LogUtil.printException("trainNNMisc", e);
            }
        }
    }

    private void a(float[] fArr, String[] strArr, int[] iArr, float[] fArr2, float[] fArr3) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                jSONArray.put(i, strArr[i]);
            }
            jSONObject.put("action", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            int length2 = iArr.length;
            for (int i2 = 0; i2 < length2; i2++) {
                jSONArray2.put(i2, iArr[i2]);
            }
            jSONObject.put("angle", jSONArray2);
            JSONArray jSONArray3 = new JSONArray();
            int length3 = fArr2.length;
            for (int i3 = 0; i3 < length3; i3++) {
                jSONArray3.put(i3, String.valueOf(fArr2[i3]));
            }
            jSONObject.put("gyroscope", jSONArray3);
            JSONArray jSONArray4 = new JSONArray();
            int length4 = fArr3.length;
            for (int i4 = 0; i4 < length4; i4++) {
                jSONArray4.put(i4, String.valueOf(fArr3[i4]));
            }
            jSONObject.put("sdiviation", jSONArray4);
            JSONArray jSONArray5 = new JSONArray();
            int length5 = fArr.length;
            for (int i5 = 0; i5 < length5; i5++) {
                jSONArray5.put(i5, String.valueOf(fArr[i5]));
            }
            jSONObject.put("weight", jSONArray5);
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("storeData", e);
            }
        }
        com.baidu.navisdk.util.common.s.b(D(), jSONObject.toString());
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "storeData");
        }
    }
}
