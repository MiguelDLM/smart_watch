package com.baidu.navisdk.skyeye.log;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.navisdk.framework.message.a;
import com.baidu.navisdk.skyeye.event.d;
import com.baidu.navisdk.skyeye.event.f;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.y;
import com.sma.smartv3.network.BaiDu;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class c {
    private Context b;
    private SharedPreferences c;
    private SharedPreferences.Editor d;

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.skyeye.log.a f8007a = null;
    public boolean e = false;
    private String f = null;
    private int g = 0;
    private long h = 0;
    private a.InterfaceC0201a i = new a();
    private Handler j = new Handler(Looper.getMainLooper());
    private Runnable k = new b();

    /* loaded from: classes7.dex */
    public class a implements a.InterfaceC0201a {
        public a() {
        }

        @Override // com.baidu.navisdk.framework.message.a.InterfaceC0201a
        public void onEvent(Object obj) {
            boolean a2 = c.this.a(obj);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - c.this.h >= 60000) {
                c.this.h = elapsedRealtime;
            } else {
                g gVar = g.EYE_SPY;
                if (gVar.b()) {
                    gVar.b("time < 60");
                }
                a2 = false;
            }
            g gVar2 = g.EYE_SPY;
            if (gVar2.d()) {
                gVar2.e(obj.getClass().getSimpleName() + " canUpload " + a2);
            }
            if (!a2) {
                return;
            }
            c.b(c.this);
            gVar2.a("start auto upload" + obj.getClass().getSimpleName());
            if (!TextUtils.isEmpty(c.this.f)) {
                com.baidu.navisdk.skyeye.a.n().a(512, 2, "致命错误" + c.this.f);
                com.baidu.navisdk.util.statistic.userop.b.r().d("7.2.3.2", c.this.f);
            } else if (obj instanceof com.baidu.navisdk.skyeye.event.a) {
                com.baidu.navisdk.skyeye.a.n().a(128, 2, "拉取历史日志");
                com.baidu.navisdk.util.statistic.userop.b.r().b("7.2.3.3");
            } else {
                com.baidu.navisdk.skyeye.a.n().a(1024, 2, "自动回传");
                com.baidu.navisdk.util.statistic.userop.b.r().b("7.2.3.1");
            }
            c.this.f = null;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.k();
        }
    }

    public c(Context context) {
        this.b = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("nav_eye_spy", 0);
        this.c = sharedPreferences;
        this.d = sharedPreferences.edit();
    }

    public static /* synthetic */ int b(c cVar) {
        int i = cVar.g;
        cVar.g = i + 1;
        return i;
    }

    private void e() {
        if (this.c.contains("record_config") || this.c.contains(BaiDu.START_TIME)) {
            this.d.remove("record_config");
            this.d.remove(BaiDu.START_TIME);
            this.d.apply();
        }
    }

    private void f() {
        this.e = false;
        g.b(0);
        g.a(0L);
    }

    private void g() {
        com.baidu.navisdk.debug.b.k().a();
    }

    private int h() {
        return this.c.getInt("id", -1);
    }

    private void i() {
        this.e = true;
        g.b(this.f8007a.c);
        g.a(this.f8007a.d);
    }

    private void j() {
        this.j.removeCallbacks(this.k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        g gVar = g.EYE_SPY;
        if (gVar.d()) {
            gVar.e("setRecordTimeOut");
        }
        d();
        f();
        e();
        j();
        com.baidu.navisdk.skyeye.log.a aVar = this.f8007a;
        if (aVar != null) {
            a(aVar.f8005a);
        }
    }

    public com.baidu.navisdk.skyeye.log.a b() {
        return this.f8007a;
    }

    public void c() {
        if ((this.f8007a.h & 2) == 0) {
            g gVar = g.EYE_SPY;
            if (gVar.d()) {
                gVar.e("startMonitor fail " + this.f8007a.h);
                return;
            }
            return;
        }
        g gVar2 = g.EYE_SPY;
        if (gVar2.d()) {
            gVar2.e("startMonitor mReportConfig = " + this.f8007a.i);
        }
        com.baidu.navisdk.skyeye.log.b bVar = this.f8007a.i;
        if (bVar == null) {
            if (gVar2.d()) {
                gVar2.e("reportConfig is null ");
                return;
            }
            return;
        }
        if (bVar.k != 0) {
            com.baidu.navisdk.skyeye.b.a().a(this.i, d.class, new Class[0]);
        }
        if (bVar.l != 0) {
            com.baidu.navisdk.skyeye.b.a().a(this.i, f.class, new Class[0]);
        }
        if (!TextUtils.isEmpty(bVar.n)) {
            com.baidu.navisdk.skyeye.b.a().a(this.i, com.baidu.navisdk.skyeye.event.c.class, new Class[0]);
        }
        if (TextUtils.isEmpty(bVar.m) || !bVar.m.contains("[AppStart]")) {
            return;
        }
        com.baidu.navisdk.skyeye.b.a().a(this.i, com.baidu.navisdk.skyeye.event.a.class, new Class[0]);
    }

    public void d() {
        com.baidu.navisdk.skyeye.b.a().a(this.i);
    }

    public void b(String str) {
        com.baidu.navisdk.skyeye.log.b bVar;
        this.f = str;
        com.baidu.navisdk.skyeye.log.a aVar = this.f8007a;
        if (aVar == null || (bVar = aVar.i) == null || TextUtils.isEmpty(bVar.n)) {
            return;
        }
        com.baidu.navisdk.skyeye.b.a().b(new com.baidu.navisdk.skyeye.event.c(str), 2000);
    }

    public void a() {
        String string = this.c.getString("record_config", null);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            a(new JSONObject(string), true);
        } catch (Exception e) {
            g gVar = g.COMMON;
            if (gVar.d()) {
                gVar.e("LOG", e.toString());
            }
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            if (this.f8007a != null) {
                k();
            }
            if (h() != -1) {
                g();
                a(-1);
                return;
            }
            return;
        }
        if (TextUtils.equals(this.c.getString("record_config", null), str)) {
            return;
        }
        try {
            a(new JSONObject(str), false);
        } catch (Exception e) {
            g gVar = g.EYE_SPY;
            if (gVar.d()) {
                gVar.e("LOG", e.toString());
            }
        }
    }

    private void c(String str) {
        this.d.putString("record_config", str);
        this.d.putLong(BaiDu.START_TIME, System.currentTimeMillis());
        this.d.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Object obj) {
        com.baidu.navisdk.skyeye.log.b bVar = this.f8007a.i;
        if (bVar == null) {
            return false;
        }
        int i = bVar.h;
        if (i >= 0 && this.g >= i) {
            g gVar = g.EYE_SPY;
            if (gVar.b()) {
                gVar.b("mUploadTimes fail " + this.g);
            }
            return false;
        }
        if (bVar.j && this.f == null) {
            g gVar2 = g.EYE_SPY;
            if (gVar2.b()) {
                gVar2.b("mAutoUploadNeedFatal fatal is null");
            }
            return false;
        }
        if (bVar.f8006a == 1 && !y.e(this.b)) {
            g gVar3 = g.EYE_SPY;
            if (gVar3.b()) {
                gVar3.b("wifi not connected");
            }
            return false;
        }
        if (!TextUtils.isEmpty(bVar.m) && (obj instanceof com.baidu.navisdk.skyeye.event.a) && bVar.m.contains("[AppStart]")) {
            return true;
        }
        int i2 = bVar.k;
        if (i2 != 0 && (obj instanceof d) && (i2 & ((d) obj).f8004a) != 0) {
            return true;
        }
        int i3 = bVar.l;
        if (i3 != 0 && (obj instanceof f) && (i3 & ((f) obj).f8004a) != 0) {
            return true;
        }
        if (!TextUtils.isEmpty(bVar.n) && (obj instanceof com.baidu.navisdk.skyeye.event.c)) {
            String str = ((com.baidu.navisdk.skyeye.event.c) obj).f8003a;
            if (bVar.n.contains("[" + str + "]") || bVar.n.equals("[all]")) {
                return true;
            }
        }
        return false;
    }

    private void a(JSONObject jSONObject, boolean z) {
        g gVar = g.EYE_SPY;
        if (gVar.d()) {
            gVar.e("handleRecord isLocal " + z + " obj :" + jSONObject);
        }
        com.baidu.navisdk.skyeye.log.a aVar = new com.baidu.navisdk.skyeye.log.a();
        this.f8007a = aVar;
        aVar.a(jSONObject);
        com.baidu.navisdk.debug.b.k().a(this.f8007a.g);
        if (this.f8007a.f8005a == h()) {
            if (gVar.d()) {
                gVar.e("handleRecord return id hasTimeOut ");
                return;
            }
            return;
        }
        com.baidu.navisdk.skyeye.log.a aVar2 = this.f8007a;
        if (!aVar2.b) {
            k();
            return;
        }
        long a2 = a(aVar2, z);
        if (gVar.b()) {
            gVar.b("getDelayTime " + a2);
        }
        if (a2 <= 0) {
            k();
            return;
        }
        i();
        a(a2);
        c();
        if (z) {
            return;
        }
        c(jSONObject.toString());
        this.d.putLong(BaiDu.START_TIME, System.currentTimeMillis()).apply();
    }

    private long a(com.baidu.navisdk.skyeye.log.a aVar, boolean z) {
        long j = aVar.f * 1000;
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = j - currentTimeMillis;
        if (j2 < 0) {
            return -1L;
        }
        if (z) {
            return Math.min((aVar.e * 1000) - (currentTimeMillis - this.c.getLong(BaiDu.START_TIME, 0L)), j2);
        }
        return Math.min(j2, this.f8007a.e * 1000);
    }

    private void a(long j) {
        g gVar = g.EYE_SPY;
        if (gVar.d()) {
            gVar.e("startTimeOut duration :" + j);
        }
        j();
        this.j.postDelayed(this.k, j);
    }

    private void a(int i) {
        this.d.putInt("id", i);
        this.d.apply();
    }
}
