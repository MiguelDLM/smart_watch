package com.baidu.navisdk.framework.vmsr;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class c extends d {
    private volatile boolean j0;
    private volatile boolean k0;
    private SensorManager l0;
    private SensorEventListener m0;
    private Timer n0;

    /* renamed from: o0, reason: collision with root package name */
    private TimerTask f6836o0;
    private int p0;

    /* loaded from: classes7.dex */
    public class a implements SensorEventListener {
        public a() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            int type = sensorEvent.sensor.getType();
            if (type != 1) {
                if (type != 9) {
                    if (type == 15) {
                        float[] fArr = c.this.X;
                        float[] fArr2 = sensorEvent.values;
                        fArr[0] = fArr2[0];
                        fArr[1] = fArr2[1];
                        fArr[2] = fArr2[2];
                        return;
                    }
                    return;
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                c cVar = c.this;
                if (elapsedRealtime - cVar.K > 200) {
                    cVar.K = elapsedRealtime;
                    cVar.L[0] = (int) Math.floor(Math.toDegrees(Math.acos(sensorEvent.values[0] / 9.81f)));
                    c.this.L[1] = (int) Math.floor(Math.toDegrees(Math.acos(sensorEvent.values[1] / 9.81f)));
                    c.this.L[2] = (int) Math.floor(Math.toDegrees(Math.acos(sensorEvent.values[2] / 9.81f)));
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("Vmsr", "monitorAngle angleX:" + c.this.L[0] + ", angleY:" + c.this.L[1] + ", angleZ:" + c.this.L[2]);
                        return;
                    }
                    return;
                }
                return;
            }
            c cVar2 = c.this;
            float[] fArr3 = sensorEvent.values;
            cVar2.Z = fArr3[0] / (-9.81f);
            cVar2.a0 = fArr3[1] / (-9.81f);
            cVar2.b0 = fArr3[2] / (-9.81f);
        }
    }

    /* loaded from: classes7.dex */
    public class b extends TimerTask {
        public b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            c.this.F();
        }
    }

    public c(Context context) {
        super(context);
        this.j0 = false;
        this.k0 = false;
        this.m0 = new a();
        this.n0 = null;
        this.f6836o0 = null;
        this.p0 = 0;
        this.l0 = (SensorManager) context.getSystemService("sensor");
    }

    private void A() {
        if (LogUtil.LOGGABLE) {
            d.a(this.V, "Aux_" + Math.round(f()) + "_", 100);
        }
        if (h()) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("Vmsr", "Aux isOnInterruptTime");
                return;
            }
            return;
        }
        m mVar = this.f0;
        if (!b()) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("Vmsr", "Aux predict angle change over max value");
                LogUtil.e("Vmsr", "Aux mStartPoseDiff angleX:" + this.N[0] + ", angleY:" + this.N[1] + ", angleZ:" + this.N[2]);
            }
            if (mVar != null) {
                mVar.a(4);
                mVar.a(0, "aux pose diff over max value");
            }
            L();
        }
        int y = y();
        int a2 = a(y);
        e(a2);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "Auxiliary stop:" + this.E + "/" + this.D + "/" + this.F);
            StringBuilder sb = new StringBuilder();
            sb.append("Auxiliary curModel:");
            sb.append(this.z);
            sb.append("/");
            sb.append(this.y);
            LogUtil.e("Vmsr", sb.toString());
        }
        if (mVar != null) {
            mVar.a(a2);
        }
        if (!v()) {
            this.j0 = false;
            this.q++;
            if (mVar != null) {
                mVar.a(6, this.y + "", null, null);
            }
            L();
            D();
            p();
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "auxiliary result : " + y + ", speed:" + f());
            LogUtil.e("Vmsr", "auxiliary result : " + y + ", isStop:" + t.d(f()));
        }
        a(y, 1.0f);
    }

    private void B() {
        m mVar = this.f0;
        boolean h = h();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "aux handleAutoTrainData onTouchMode:" + h);
        }
        if (h) {
            if (mVar != null) {
                mVar.a(1, null, "3", "2");
                mVar.a(0, "onTouchMode");
            }
            N();
            return;
        }
        if (!d()) {
            n();
            this.o++;
            if (mVar != null) {
                mVar.a(1, null, "3", "1");
                mVar.a(0, "aux pose diff too large : " + this.o);
            }
            N();
            return;
        }
        if (!c(3)) {
            if (mVar != null) {
                mVar.a(1, null, "3", "4");
                mVar.a(0, "aux speed not 3 zero");
            }
            N();
            return;
        }
        if (!c()) {
            this.o++;
            if (mVar != null) {
                mVar.a(1, null, "3", "3");
                mVar.a(0, "aux Stop Data too large : " + this.o);
            }
            N();
            return;
        }
        if (mVar != null) {
            mVar.a(1, null, "2", null);
        }
        if (LogUtil.LOGGABLE) {
            d.a(this.V, "Aux_Train_" + Math.round(f()) + "_", 300);
        }
        for (int i = 0; i < 100; i++) {
            float[][] fArr = this.V;
            System.arraycopy(fArr[i + 100], 0, fArr[i], 0, 2);
        }
        com.baidu.navisdk.framework.vmsr.b.c(this.V, 300, 3);
        this.W[0] = com.baidu.navisdk.framework.vmsr.b.d(this.V, 300, 0);
        this.W[1] = com.baidu.navisdk.framework.vmsr.b.d(this.V, 300, 1);
        this.W[2] = com.baidu.navisdk.framework.vmsr.b.d(this.V, 300, 2);
        this.Y[0] = com.baidu.navisdk.framework.vmsr.b.b(this.V, 300, 0);
        this.Y[1] = com.baidu.navisdk.framework.vmsr.b.b(this.V, 300, 1);
        this.Y[2] = com.baidu.navisdk.framework.vmsr.b.b(this.V, 300, 2);
        int[] iArr = this.O;
        int[] iArr2 = this.M;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        iArr[2] = iArr2[2];
        this.j0 = true;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "aux mStopGyroscope:" + this.W[0] + "," + this.W[1] + "," + this.W[2]);
            LogUtil.e("Vmsr", "aux mStopStandardDiviation:" + this.Y[0] + "," + this.Y[1] + "," + this.Y[0]);
            LogUtil.e("Vmsr", "aux ready:");
        }
        if (mVar != null) {
            mVar.a(0, "aux mStopGyroscope = " + this.W[0] + "," + this.W[1] + "," + this.W[2]);
            mVar.a(0, "aux div = " + this.Y[0] + "," + this.Y[1] + "," + this.Y[2]);
        }
        float[] fArr2 = this.W;
        fArr2[0] = Math.max(this.f6839a, fArr2[0]);
        float[] fArr3 = this.W;
        fArr3[1] = Math.max(this.f6839a, fArr3[1]);
        float[] fArr4 = this.W;
        fArr4[2] = Math.max(this.f6839a, fArr4[2]);
        float[] fArr5 = this.Y;
        fArr5[0] = Math.max(0.001f, fArr5[0]);
        float[] fArr6 = this.Y;
        fArr6[1] = Math.max(0.001f, fArr6[1]);
        float[] fArr7 = this.Y;
        fArr7[2] = Math.max(0.001f, fArr7[2]);
        a(this.W, this.Y, this.O);
        r();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "aux auto train end:");
        }
        if (mVar != null) {
            mVar.b(3);
        }
        if (this.P) {
            J();
        } else {
            N();
        }
    }

    private boolean C() {
        if (this.U == null) {
            this.U = com.baidu.navisdk.framework.vmsr.b.a(0.0f, 300, 4);
        }
        if (this.V == null) {
            this.V = com.baidu.navisdk.framework.vmsr.b.a(0.0f, 300, 3);
        }
        try {
            String e = com.baidu.navisdk.util.common.s.e(z());
            if (!TextUtils.isEmpty(e)) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("Vmsr", "cacheStr:" + e);
                }
                JSONObject jSONObject = new JSONObject(e);
                JSONArray optJSONArray = jSONObject.optJSONArray("gyroscope");
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    this.W[i] = Float.valueOf(optJSONArray.optString(i)).floatValue();
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("sdiviation");
                int length2 = optJSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    this.Y[i2] = Float.valueOf(optJSONArray2.optString(i2)).floatValue();
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("angle");
                int length3 = optJSONArray3.length();
                for (int i3 = 0; i3 < length3; i3++) {
                    this.O[i3] = optJSONArray3.optInt(i3);
                }
                return true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    private void D() {
        this.j0 = false;
        N();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "aux invalidSys");
        }
        try {
            com.baidu.navisdk.util.common.s.a(z());
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("aux invalidSys", e);
            }
        }
    }

    private void E() {
        if (this.p0 == 300) {
            this.p0 = 0;
            this.c0 = 0.0f;
            B();
        } else {
            j();
            g(this.p0);
            f(this.p0);
            this.p0++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        if (this.Q) {
            E();
        } else {
            G();
        }
    }

    private void G() {
        if (this.p0 > 100) {
            this.p0 = 0;
            this.c0 = 0.0f;
        }
        if (this.p0 == 100) {
            this.p0 = 0;
            this.c0 = 0.0f;
            A();
        } else {
            j();
            g(this.p0);
            f(this.p0);
            this.p0++;
        }
    }

    private void H() {
        if (!this.k0) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("Vmsr", "aux registerSensor");
            }
            try {
                this.k0 = true;
                this.l0.registerListener(this.m0, this.l0.getDefaultSensor(1), 0, p.d().a());
                this.l0.registerListener(this.m0, this.l0.getDefaultSensor(15), 0, p.d().a());
                this.l0.registerListener(this.m0, this.l0.getDefaultSensor(9), 3, p.d().a());
                K();
            } catch (Exception e) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.printException("registerSensor", e);
                }
            }
        }
    }

    private void I() {
        if (this.o < 20 && this.n < 5) {
            boolean h = h();
            if (LogUtil.LOGGABLE) {
                LogUtil.e("Vmsr", "aux mAutoTrainRunnable onTouchMode: " + h);
            }
            if (h) {
                return;
            }
            if (this.k0) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("Vmsr", "aux mAutoTrainRunnable hasRegisterSensor: " + this.k0);
                    return;
                }
                return;
            }
            m mVar = this.f0;
            if (c(2)) {
                if (mVar != null) {
                    mVar.a(1, null, "1", null);
                }
                H();
                return;
            }
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "aux model train mStopSampleFailTimes:" + this.o);
            LogUtil.e("Vmsr", "aux model train mModelTrainTimes:" + this.n);
        }
        r();
        L();
        D();
    }

    private void J() {
        m mVar = this.f0;
        if (!this.j0) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("Vmsr", "aux startPredictInner return not ready");
            }
            if (mVar != null) {
                mVar.a(1);
                return;
            }
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "aux startPredictInner");
        }
        H();
        n();
        if (mVar != null) {
            mVar.b(22);
        }
    }

    private void K() {
        Timer timer = this.n0;
        if (timer != null) {
            timer.cancel();
        }
        this.n0 = new Timer("BNav_AuxiliaryRecognizeSys");
        b bVar = new b();
        this.f6836o0 = bVar;
        this.n0.schedule(bVar, 1000L, 10L);
    }

    private void L() {
        N();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "aux stopPredict");
        }
    }

    private void M() {
        Timer timer = this.n0;
        if (timer != null) {
            try {
                timer.cancel();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.n0 = null;
        }
    }

    private void N() {
        if (this.k0) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("Vmsr", "aux unRegisterSensor");
            }
            M();
            this.k0 = false;
            this.l0.unregisterListener(this.m0);
        }
    }

    private void f(int i) {
        float[] fArr = this.U[i];
        float f = this.c0;
        fArr[0] = f;
        fArr[1] = this.Z;
        fArr[2] = this.a0;
        fArr[3] = this.b0;
        this.c0 = f + 0.01f;
    }

    private void g(int i) {
        float[] fArr = this.V[i];
        float[] fArr2 = this.X;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        fArr[2] = fArr2[2];
    }

    private int y() {
        int i;
        com.baidu.navisdk.framework.vmsr.b.c(this.V, 100, 3);
        float d = com.baidu.navisdk.framework.vmsr.b.d(this.V, 100, 0);
        float d2 = com.baidu.navisdk.framework.vmsr.b.d(this.V, 100, 1);
        float d3 = com.baidu.navisdk.framework.vmsr.b.d(this.V, 100, 2);
        float[] fArr = this.W;
        float f = d / fArr[0];
        float f2 = d2 / fArr[1];
        float f3 = d3 / fArr[2];
        if (f <= 2.0f && f2 <= 2.0f && f3 <= 2.0f) {
            i = 32;
        } else {
            i = 8;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "aux calcResult maxValue, x:" + d + ", y:" + d2 + ", z:" + d3);
            LogUtil.e("Vmsr", "aux calcResult factor, x:" + f + ", y:" + f2 + ", z:" + f3 + ", max:" + Math.max(f, Math.max(f2, f3)));
            m mVar = this.f0;
            if (mVar != null && i == 32 && !t.d(f())) {
                mVar.a(0, "aux stop err F=" + String.format("%.2f", Float.valueOf(f)) + " , " + String.format("%.2f", Float.valueOf(f2)) + " , " + String.format("%.2f", Float.valueOf(f3)));
                StringBuilder sb = new StringBuilder();
                sb.append("aux cm : ");
                sb.append(this.z);
                sb.append("/");
                sb.append(this.y);
                mVar.a(0, sb.toString());
            } else if (mVar != null && i == 8 && t.d(f())) {
                mVar.a(0, "aux move err F=" + String.format("%.2f", Float.valueOf(f)) + " , " + String.format("%.2f", Float.valueOf(f2)) + " , " + String.format("%.2f", Float.valueOf(f3)));
                StringBuilder sb2 = new StringBuilder();
                sb2.append("aux cm : ");
                sb2.append(this.z);
                sb2.append("/");
                sb2.append(this.y);
                mVar.a(0, sb2.toString());
            }
        }
        return i;
    }

    private String z() {
        return this.e0.getFilesDir().getPath() + "/vmsr/config_aux.png";
    }

    @Override // com.baidu.navisdk.framework.vmsr.d
    public boolean o() {
        super.o();
        boolean C = C();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "aux start ret:" + C);
        }
        if (!C) {
            p();
        } else {
            this.j0 = true;
        }
        return true;
    }

    @Override // com.baidu.navisdk.framework.vmsr.d
    public void p() {
        super.p();
        n();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "aux startAutoTrain");
        }
    }

    @Override // com.baidu.navisdk.framework.vmsr.d
    public void q() {
        super.q();
        J();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "aux startPredict");
        }
    }

    @Override // com.baidu.navisdk.framework.vmsr.d
    public void r() {
        super.r();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "aux stopAutoTrain");
        }
    }

    @Override // com.baidu.navisdk.framework.vmsr.d
    public void s() {
        super.s();
        if (!this.j0) {
            return;
        }
        L();
    }

    public boolean v() {
        if (this.d0) {
            return true;
        }
        if (this.y <= 50) {
            if (this.z < 10) {
                return true;
            }
            return false;
        }
        if (this.A <= 0.2d) {
            return true;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "checkSuccessRate fail:" + this.A);
            LogUtil.e("Vmsr", "Auxiliary stop:" + this.E + "/" + this.D);
            LogUtil.e("Vmsr", "Auxiliary curModel:" + this.z + "/" + this.y);
        }
        try {
            m mVar = this.f0;
            if (mVar != null) {
                mVar.b(20);
            }
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("checkSuccessRate error", e);
            }
        }
        return false;
    }

    public boolean w() {
        String[] strArr = this.l;
        if (strArr != null && strArr.length != 0) {
            String u = d.u();
            if (TextUtils.isEmpty(u)) {
                return false;
            }
            for (String str : this.l) {
                if (u.contains(str)) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("Vmsr", "isInBlackList mb: " + str);
                        return true;
                    }
                    return true;
                }
            }
            return false;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "mBlackList is Empty");
        }
        return false;
    }

    public boolean x() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "aux stop");
        }
        s();
        r();
        return true;
    }

    @Override // com.baidu.navisdk.framework.vmsr.l
    public boolean a() {
        return this.j0;
    }

    @Override // com.baidu.navisdk.framework.vmsr.d
    public void a(float f, float f2, int i) {
        super.a(f, f2, i);
        if (this.Q && c(2)) {
            I();
        }
    }

    private void a(float[] fArr, float[] fArr2, int[] iArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            int length = fArr.length;
            for (int i = 0; i < length; i++) {
                jSONArray.put(i, String.valueOf(fArr[i]));
            }
            jSONObject.put("gyroscope", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            int length2 = fArr2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                jSONArray2.put(i2, String.valueOf(fArr2[i2]));
            }
            jSONObject.put("sdiviation", jSONArray2);
            JSONArray jSONArray3 = new JSONArray();
            int length3 = iArr.length;
            for (int i3 = 0; i3 < length3; i3++) {
                jSONArray3.put(i3, iArr[i3]);
            }
            jSONObject.put("angle", jSONArray3);
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("storeData", e);
            }
        }
        com.baidu.navisdk.util.common.s.b(z(), jSONObject.toString());
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "storeData");
        }
    }
}
