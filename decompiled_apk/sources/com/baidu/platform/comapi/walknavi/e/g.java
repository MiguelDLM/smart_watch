package com.baidu.platform.comapi.walknavi.e;

import android.text.TextUtils;
import com.baidu.ar.npc.BaiduArView;
import java.util.HashMap;

/* loaded from: classes8.dex */
public class g implements com.baidu.platform.comapi.walknavi.e.a.b.a {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f9747a = true;
    private com.baidu.platform.comapi.walknavi.e.b d;
    private com.baidu.platform.comapi.walknavi.e.a.d e;
    private boolean g;
    private boolean l;
    private a o;
    private boolean h = false;
    private String i = null;
    private boolean j = false;
    private boolean k = true;
    public String c = "";
    private boolean m = true;
    private boolean n = false;
    public b b = new b();
    private com.baidu.platform.comapi.walknavi.e.a.b f = new com.baidu.platform.comapi.walknavi.e.a.b(com.baidu.platform.comapi.wnplatform.p.b.a.a());

    /* loaded from: classes8.dex */
    public interface a {
        void a(b bVar);
    }

    /* loaded from: classes8.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public String f9748a;
        public String b;
        public int c;

        public b() {
        }
    }

    public boolean b() {
        return this.k;
    }

    public boolean c() {
        return this.l;
    }

    public void d() {
        this.e.a(45.0f);
    }

    public boolean e() {
        if (this.e != null) {
            this.g = true;
        } else {
            this.g = false;
        }
        return this.g;
    }

    public void f() {
        if (this.e != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.e.d();
            a(currentTimeMillis, "onPause");
        }
    }

    public void g() {
        if (this.e != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.e.e();
            a(currentTimeMillis, "pauseByUser");
        }
    }

    public void h() {
        if (this.e != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.e.c();
            a(currentTimeMillis, "resumeByUser");
        }
    }

    public void i() {
        if (this.e != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.e.b();
            a(currentTimeMillis, "onResume");
        }
    }

    public void j() {
        if (this.e != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.e.f();
            this.i = null;
            this.g = false;
            this.e = null;
            this.d = null;
            this.h = false;
            this.l = false;
            a(currentTimeMillis, "onDestroy");
        }
    }

    public BaiduArView k() {
        com.baidu.platform.comapi.walknavi.e.a.d dVar = this.e;
        if (dVar != null) {
            return dVar.a();
        }
        return null;
    }

    public void l() {
        com.baidu.platform.comapi.wnplatform.d.a.a("NpcSDKManagerImp", "downloadCancel");
        long currentTimeMillis = System.currentTimeMillis();
        this.f.b();
        a(currentTimeMillis, "downloadCancel");
        this.n = false;
        b bVar = this.b;
        bVar.c = 0;
        bVar.b = "";
    }

    public boolean m() {
        return this.f.a();
    }

    public void b(boolean z) {
        this.l = z;
    }

    public void c(boolean z) {
        this.h = z;
    }

    public String a() {
        return this.c;
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(this.i)) {
            return TextUtils.equals(str, "enter");
        }
        return TextUtils.equals(str, "withoutGPS") || TextUtils.equals(str, "turnRight") || TextUtils.equals(str, "turnLeft") || TextUtils.equals(str, "helpless") || TextUtils.equals(str, "turnAndCry");
    }

    public String c(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        String a2 = this.f.a(str);
        a(currentTimeMillis, "queryLocalResource");
        return a2;
    }

    public void a(String str) {
        com.baidu.platform.comapi.walknavi.b.a().O().b("walknavi_current_npc_token", str);
        this.c = str;
        b bVar = this.b;
        bVar.f9748a = str;
        a aVar = this.o;
        if (aVar != null) {
            aVar.a(bVar);
        }
    }

    public void a(boolean z) {
        this.k = z;
    }

    public void b(String str, c cVar) {
        this.f.b(str, new i(this, cVar));
    }

    @Override // com.baidu.platform.comapi.walknavi.e.a.b.a
    public void a(int i, HashMap<String, Object> hashMap) {
        com.baidu.platform.comapi.walknavi.e.b bVar = this.d;
        if (bVar == null) {
            return;
        }
        bVar.a(i, hashMap);
    }

    private void a(long j, String str) {
        if (f9747a) {
            com.baidu.platform.comapi.wnplatform.d.a.a("NpcSDKManagerImp", str + "time:" + (System.currentTimeMillis() - j));
            return;
        }
        com.baidu.platform.comapi.wnplatform.d.a.a("NpcSDKManagerImp", str);
    }

    public void a(com.baidu.platform.comapi.walknavi.e.b bVar) {
        long currentTimeMillis = System.currentTimeMillis();
        this.d = bVar;
        this.e = new com.baidu.platform.comapi.walknavi.e.a.d(com.baidu.platform.comapi.wnplatform.p.b.a.a(), this);
        a(currentTimeMillis, "createArManager");
    }

    public void a(double d, double d2, double d3, String str) {
        com.baidu.platform.comapi.walknavi.e.a.d dVar;
        if (!this.h || (dVar = this.e) == null) {
            return;
        }
        dVar.a((float) d, (float) d2, (float) d3, str);
    }

    public void a(String str, String str2) {
        if (this.e == null || !this.k) {
            return;
        }
        if (!TextUtils.equals(str2, this.i) || TextUtils.equals(str2, "turnAndSayHi")) {
            this.e.a(str, str2);
            this.i = str2;
        }
    }

    public void a(String str, c cVar) {
        com.baidu.platform.comapi.wnplatform.d.a.a("NpcSDKManagerImp", "download start = ");
        this.n = true;
        b bVar = this.b;
        bVar.b = str;
        a aVar = this.o;
        if (aVar != null) {
            aVar.a(bVar);
        }
        this.f.a(str, new h(this, cVar));
    }

    public boolean a(String str, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean a2 = this.f.a(str, z);
        a(currentTimeMillis, "clearARResource");
        return a2;
    }

    public void a(a aVar) {
        this.o = aVar;
    }
}
