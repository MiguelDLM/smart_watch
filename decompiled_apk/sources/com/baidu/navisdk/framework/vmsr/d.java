package com.baidu.navisdk.framework.vmsr;

import XXO0.oIX0oI;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.m0;
import com.facebook.login.widget.ToolTipPopup;
import com.google.android.exoplayer2.ExoPlayer;
import java.io.File;

/* loaded from: classes7.dex */
public abstract class d implements l {
    protected float[][] U;
    protected float[][] V;
    protected Context e0;
    protected m f0;

    /* renamed from: a, reason: collision with root package name */
    public float f6839a = 0.0015f;
    public boolean b = false;
    public boolean c = true;
    public boolean d = false;
    public float e = 15.0f;
    public float f = 30.0f;
    public int g = 3;
    protected int h = 180;
    protected float[] i = {0.0f, 1.0f};
    protected float[] j = {15.0f, 40.0f};
    public float k = 0.002f;
    public String[] l = null;
    public long m = 0;
    public int n = -1;
    public volatile int o = -1;
    public volatile int p = -1;
    public volatile int q = -1;
    public volatile int r = -1;
    public volatile int s = -1;
    public volatile int t = -1;
    public volatile int u = -1;
    public volatile int v = -1;
    public volatile int w = -1;
    public volatile int x = -1;
    protected volatile int y = 0;
    protected volatile int z = 0;
    protected volatile float A = 0.0f;
    public volatile int B = 0;
    public volatile int C = 0;
    public volatile int D = 0;
    public volatile int E = 0;
    public volatile int F = 0;
    public int G = -1;
    public int H = -1;
    protected String[] I = {"", ""};
    protected float[] J = {1.0f, 1.0f};
    protected long K = 0;
    protected int[] L = {-1, -1, -1};
    protected int[] M = {-1, -1, -1};
    protected int[] N = {-1, -1, -1};
    protected int[] O = {-1, -1, -1};
    protected volatile boolean P = false;
    protected volatile boolean Q = false;
    private float R = -1.0f;
    private long S = 0;
    private k[] T = new k[5];
    protected float[] W = new float[3];
    protected float[] X = new float[3];
    protected float[] Y = new float[3];
    protected float Z = 0.0f;
    protected float a0 = 0.0f;
    protected float b0 = 0.0f;
    protected float c0 = 0.0f;
    public boolean d0 = false;
    protected Handler g0 = new com.baidu.navisdk.util.worker.loop.a();
    private long h0 = 0;
    private boolean i0 = false;

    public d(Context context) {
        this.e0 = context;
        this.T[0] = new k();
        this.T[1] = new k();
        this.T[2] = new k();
        this.T[3] = new k();
        this.T[4] = new k();
    }

    public static String u() {
        String str = Build.MODEL;
        if (str == null || str.length() == 0) {
            str = "unknown";
        }
        return str.trim();
    }

    public void a(float f, float f2, int i) {
        this.R = f * 3.6f;
        this.S = SystemClock.elapsedRealtime();
        b(this.R, f2, i);
        if (i()) {
            this.G++;
            if (t.d(f())) {
                this.H++;
            }
        }
    }

    public void b(float f, float f2, int i) {
        k[] kVarArr = this.T;
        k kVar = kVarArr[0];
        k kVar2 = kVarArr[1];
        kVar.f6844a = kVar2.f6844a;
        kVar.b = kVar2.b;
        kVar.c = kVar2.c;
        k kVar3 = kVarArr[2];
        kVar2.f6844a = kVar3.f6844a;
        kVar2.b = kVar3.b;
        kVar2.c = kVar3.c;
        k kVar4 = kVarArr[3];
        kVar3.f6844a = kVar4.f6844a;
        kVar3.b = kVar4.b;
        kVar3.c = kVar4.c;
        k kVar5 = kVarArr[4];
        kVar4.f6844a = kVar5.f6844a;
        kVar4.b = kVar5.b;
        kVar4.c = kVar5.c;
        kVar5.f6844a = f;
        kVar5.b = f2;
        kVar5.c = i;
    }

    public boolean c(int i) {
        k[] e = e();
        int length = e.length;
        for (int i2 = length - 1; i2 >= length - i; i2--) {
            k kVar = e[i2];
            if (kVar.c <= 4 || kVar.b >= 30.0f || Math.round(kVar.f6844a) < 0 || e[i2].f6844a > this.i[1]) {
                return false;
            }
        }
        return true;
    }

    public boolean d(int i) {
        k[] e = e();
        int length = e.length;
        for (int i2 = length - 1; i2 >= length - i; i2--) {
            k kVar = e[i2];
            if (kVar.c <= 4 || kVar.b >= 15.0f || kVar.f6844a < this.j[0]) {
                return false;
            }
        }
        return true;
    }

    public k[] e() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - this.S > ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
            b(-1.0f, -1.0f, -1);
        }
        if (elapsedRealtime - this.S > 3000) {
            b(-1.0f, -1.0f, -1);
        }
        if (elapsedRealtime - this.S > 4000) {
            b(-1.0f, -1.0f, -1);
        }
        if (elapsedRealtime - this.S > 5000) {
            b(-1.0f, -1.0f, -1);
        }
        if (elapsedRealtime - this.S > ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME) {
            b(-1.0f, -1.0f, -1);
        }
        if (LogUtil.LOGGABLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("getHistoryGpsInfo");
            for (int i = 0; i < this.T.length; i++) {
                sb.append(" gps");
                sb.append(i);
                sb.append(oIX0oI.I0Io.f4096II0xO0);
                sb.append(this.T[i].f6844a);
                sb.append(",");
                sb.append(this.T[i].b);
                sb.append(",");
                sb.append(this.T[i].c);
                sb.append(oIX0oI.I0Io.f4095I0Io);
            }
            LogUtil.e("Vmsr", sb.toString());
        }
        return this.T;
    }

    public float f() {
        if (SystemClock.elapsedRealtime() - this.S < ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
            return this.R;
        }
        return -1.0f;
    }

    public boolean g() {
        if (Math.round(f()) >= 0 && f() <= this.i[1]) {
            return true;
        }
        return false;
    }

    public boolean h() {
        if (!this.i0 && SystemClock.elapsedRealtime() - this.h0 >= 10000) {
            return false;
        }
        return true;
    }

    public boolean i() {
        return this.P;
    }

    public final void j() {
        int[] iArr = this.L;
        int i = iArr[0];
        if (i < 0 && iArr[1] < 0 && iArr[2] < 0) {
            return;
        }
        int[] iArr2 = this.M;
        int i2 = iArr2[0];
        if (i2 < 0 && iArr2[1] < 0 && iArr2[2] < 0) {
            iArr2[0] = i;
            iArr2[1] = iArr[1];
            iArr2[2] = iArr[2];
            return;
        }
        if (this.N[0] < Math.abs(i - i2)) {
            this.N[0] = Math.abs(this.L[0] - this.M[0]);
        }
        if (this.N[1] < Math.abs(this.L[1] - this.M[1])) {
            this.N[1] = Math.abs(this.L[1] - this.M[1]);
        }
        if (this.N[2] < Math.abs(this.L[2] - this.M[2])) {
            this.N[2] = Math.abs(this.L[2] - this.M[2]);
        }
    }

    public void k() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "onBackground");
        }
        this.i0 = true;
    }

    public void l() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "onForground");
        }
        this.i0 = false;
    }

    public void m() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "onUserEvent mAutoPredictionStarted:" + this.P);
        }
        if (this.P) {
            m mVar = this.f0;
            if (a()) {
                if (mVar != null) {
                    mVar.a(4);
                }
            } else if (mVar != null) {
                mVar.a(1);
            }
        }
    }

    public final void n() {
        int[] iArr = this.L;
        iArr[0] = -1;
        iArr[1] = -1;
        iArr[2] = -1;
        int[] iArr2 = this.M;
        iArr2[0] = -1;
        iArr2[1] = -1;
        iArr2[2] = -1;
        int[] iArr3 = this.N;
        iArr3[0] = -1;
        iArr3[1] = -1;
        iArr3[2] = -1;
    }

    public boolean o() {
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.D = 0;
        this.E = 0;
        this.B = 0;
        this.C = 0;
        this.n = 0;
        this.G = 0;
        this.H = 0;
        this.F = 0;
        this.y = 0;
        this.z = 0;
        this.A = 0.0f;
        this.f6839a = Math.min(0.0015f, this.k);
        return true;
    }

    public void p() {
        this.Q = true;
        this.y = 0;
        this.z = 0;
        this.A = 0.0f;
    }

    public void q() {
        this.P = true;
        String[] strArr = this.I;
        strArr[0] = "";
        strArr[1] = "";
    }

    public void r() {
        this.Q = false;
    }

    public void s() {
        this.P = false;
    }

    public void t() {
        this.f0 = null;
    }

    public boolean c() {
        return j.a(this.U, 0.25f);
    }

    public boolean d() {
        int[] iArr = this.N;
        float f = iArr[0];
        float f2 = this.e;
        return f <= f2 && ((float) iArr[1]) <= f2 && ((float) iArr[2]) <= f2;
    }

    public void a(int i, KeyEvent keyEvent) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "onKeyDown keyCode:" + i + ", event:" + keyEvent.getAction());
        }
        this.h0 = SystemClock.elapsedRealtime();
        m();
    }

    public void a(m mVar) {
        this.f0 = mVar;
    }

    public static void a(float[][] fArr, String str, int i) {
        if (LogUtil.LOGGABLE) {
            Log.e("Vmsr", "Exporting");
            String a2 = b.a(fArr, 0, i);
            String str2 = str + com.baidu.navisdk.util.common.p.c();
            String str3 = m0.j().c() + File.separator + "vmsr";
            SDKDebugFileUtil.get(str3, str2, false, false).add(a2);
            SDKDebugFileUtil.end(str3, str2);
        }
    }

    public boolean b(int i) {
        k[] e = e();
        int length = e.length;
        for (int i2 = length - 1; i2 >= length - i; i2--) {
            k kVar = e[i2];
            if (kVar.c > 4 && kVar.b < 15.0f) {
                float f = kVar.f6844a;
                float[] fArr = this.j;
                if (f >= fArr[0] && f <= fArr[1]) {
                }
            }
            return false;
        }
        return true;
    }

    public boolean b() {
        int[] iArr = this.N;
        float f = iArr[0];
        float f2 = this.f;
        return f <= f2 && ((float) iArr[1]) <= f2 && ((float) iArr[2]) <= f2;
    }

    public void a(int i, float f) {
        float[] fArr = this.J;
        fArr[0] = fArr[1];
        fArr[1] = f;
        String[] strArr = this.I;
        strArr[0] = strArr[1];
        strArr[1] = i == 32 ? ExifInterface.LATITUDE_SOUTH : "M";
    }

    public int a(int i) {
        if (TextUtils.isEmpty(this.I[1]) && TextUtils.isEmpty(this.I[0])) {
            return i;
        }
        if (i == 8) {
            if (this.I[1].equals("M")) {
                return 8;
            }
        } else {
            if (i != 32) {
                return 0;
            }
            if (this.I[1].equals(ExifInterface.LATITUDE_SOUTH)) {
                if (!this.d || !t.a(e(), 3)) {
                    return 32;
                }
                if (!LogUtil.LOGGABLE) {
                    return 2;
                }
                LogUtil.e("Vmsr", "isMoveForResult true");
                return 2;
            }
        }
        return 16;
    }

    public void e(int i) {
        float f = f();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "updateStatData curSpeed = " + f);
        }
        this.r++;
        this.y++;
        if (t.d(f)) {
            this.F++;
        }
        if (i == 8) {
            this.B++;
            if (!t.b(f) && !t.a(f)) {
                this.s++;
                this.z++;
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("Vmsr", "recode move error speed = " + f);
                }
            } else {
                this.t++;
                this.C++;
            }
        } else if (i != 16) {
            if (i == 32) {
                this.D++;
                if (t.d(f)) {
                    this.t++;
                    this.E++;
                } else if (t.a(f)) {
                    this.t++;
                    this.D--;
                } else {
                    this.s++;
                    this.z++;
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("Vmsr", "recode stop error speed = " + f);
                    }
                }
            }
        } else if (!t.c(f) && !t.a(f)) {
            this.s++;
            this.z++;
            if (LogUtil.LOGGABLE) {
                LogUtil.e("Vmsr", "recode slow error speed = " + f);
            }
        } else {
            this.t++;
        }
        this.A = this.z / this.y;
    }
}
