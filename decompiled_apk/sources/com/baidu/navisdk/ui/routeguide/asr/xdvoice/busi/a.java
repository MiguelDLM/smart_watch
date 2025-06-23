package com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.interfaces.asr.a;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.module.asr.h;
import com.baidu.navisdk.module.asr.i;
import com.baidu.navisdk.ui.routeguide.control.s;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.List;

/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected int f8495a;
    protected String b;
    protected String c;
    protected List<com.baidu.navisdk.ui.search.model.a> d;
    protected boolean e;
    protected int f;
    protected boolean g;
    protected boolean h;
    protected String i;
    protected com.baidu.navisdk.asr.i.e j;

    /* renamed from: com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC0426a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8496a;
        final /* synthetic */ String b;

        /* renamed from: com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0427a implements Runnable {
            public RunnableC0427a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                RunnableC0426a runnableC0426a = RunnableC0426a.this;
                a.this.a(runnableC0426a.f8496a, runnableC0426a.b);
            }
        }

        public RunnableC0426a(String str, String str2) {
            this.f8496a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.i();
            i.b(a.class.getSimpleName(), new RunnableC0427a());
        }
    }

    /* loaded from: classes8.dex */
    public class b implements com.baidu.navisdk.ui.search.b {
        public b(a aVar) {
        }
    }

    public a(com.baidu.navisdk.asr.i.e eVar) {
        this.j = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        com.baidu.navisdk.model.datastruct.f fVar;
        GeoPoint e = com.baidu.navisdk.model.a.g().e();
        if (e != null) {
            fVar = com.baidu.navisdk.poisearch.c.a(e, 0);
        } else {
            fVar = null;
        }
        if (fVar == null) {
            this.f = com.baidu.navisdk.module.base.b.a();
        } else {
            this.f = fVar.d;
        }
    }

    public abstract void a();

    public abstract void a(com.baidu.navisdk.ui.search.model.a aVar, int i);

    public abstract String b(String str);

    public boolean b() {
        g.ASR.e("XDVoiceModifyDestination", "exit()");
        this.e = false;
        return f();
    }

    public void c(String str) {
        this.c = "";
        this.i = str;
        Bundle j = com.baidu.navisdk.framework.b.j();
        if (j == null) {
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.j.3.1", "2", d());
            this.j.a(new a.C0199a().a("当前未设置去公司地址,滴声后请说您要去哪里?").e(true).c(true).b(b("company")).a());
            return;
        }
        String string = j.getString("addr");
        int i = j.getInt("LLx");
        int i2 = j.getInt("LLy");
        if (i > 0 && i2 > 0) {
            com.baidu.navisdk.ui.search.model.a aVar = new com.baidu.navisdk.ui.search.model.a();
            aVar.l = new GeoPoint(i, i2);
            aVar.c = string;
            aVar.b = string;
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.j.3.1", "1", d());
            this.b = string;
            a(aVar, 5);
            return;
        }
        com.baidu.navisdk.ui.routeguide.asr.c.n().l();
    }

    public abstract String d();

    public void d(String str) {
        this.c = "";
        this.i = str;
        Bundle m = com.baidu.navisdk.framework.b.m();
        if (m == null) {
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.j.2.1", "2", d());
            this.j.a(new a.C0199a().a("当前未设置回家地址,滴声后请说您要去哪里?").e(true).c(true).b(b("home")).a());
            return;
        }
        String string = m.getString("addr");
        int i = m.getInt("LLx");
        int i2 = m.getInt("LLy");
        if (i <= 0 || i2 <= 0) {
            return;
        }
        com.baidu.navisdk.ui.search.model.a aVar = new com.baidu.navisdk.ui.search.model.a();
        aVar.l = new GeoPoint(i, i2);
        aVar.c = string;
        aVar.b = string;
        com.baidu.navisdk.module.asr.instructions.b.a("3.c.j.2.1", "1", d());
        this.b = string;
        a(aVar, 4);
    }

    public boolean e() {
        return this.e;
    }

    public abstract boolean f();

    public abstract void g();

    public void h() {
        String string;
        this.j.c();
        Bundle bundle = new Bundle();
        BNRouteGuider.getInstance().getRouteInfoInUniform(4, 1, bundle);
        String string2 = bundle.getString("usWayRoadName");
        if (!TextUtils.isEmpty(string2)) {
            string = JarUtils.getResources().getString(R.string.nsdk_string_rg_voice_change_route_success_adapt_yueyu, this.b, string2);
        } else {
            string = JarUtils.getResources().getString(R.string.nsdk_string_rg_voice_change_route_success, this.b);
        }
        int selectRouteIdx = JNIGuidanceControl.getInstance().getSelectRouteIdx();
        Bundle bundle2 = new Bundle();
        JNIGuidanceControl.getInstance().GetRouteInfo(selectRouteIdx, bundle2);
        if (bundle2.getInt("totaldistance", 0) >= 100000) {
            string = string + JarUtils.getResources().getString(R.string.nsdk_string_rg_voice_change_route_long_tip);
        }
        e(string);
        String str = "0";
        if (TextUtils.equals(this.c, "home")) {
            com.baidu.navisdk.util.statistic.userop.b r = com.baidu.navisdk.util.statistic.userop.b.r();
            String d = d();
            if (this.j.d()) {
                str = "1";
            }
            r.a("3.c.j.2.2", "1", d, str);
        } else if (TextUtils.equals(this.c, "company")) {
            com.baidu.navisdk.util.statistic.userop.b r2 = com.baidu.navisdk.util.statistic.userop.b.r();
            String d2 = d();
            if (this.j.d()) {
                str = "1";
            }
            r2.a("3.c.j.3.2", "1", d2, str);
        }
        if (this.g) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.c.h.2", null, "3", d());
        } else {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.c.h.2", null, null, d());
        }
        a();
    }

    public void e(String str) {
        i.b(str);
    }

    public void a(int i) {
        if (i >= 0 && i < this.d.size()) {
            a(this.d.get(i), 1);
            com.baidu.navisdk.ui.routeguide.asr.c.n().l();
            b();
            return;
        }
        g();
    }

    public void a(String str, String str2, String str3, String str4) {
        this.b = str;
        this.c = str4;
        this.i = str3;
        if (h.a()) {
            String string = JarUtils.getResources().getString(R.string.asr_rg_pref_change_route_not_use);
            i.c(string);
            s.T().a(string, false);
            return;
        }
        i.a(a.class.getSimpleName(), new RunnableC0426a(str, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        com.baidu.navisdk.ui.search.c.INSTANCE.a(str, str2, this.i, this.f, new b(this));
    }

    public int a(float f) {
        return (int) ((f * JarUtils.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public String a(String str) {
        return (!TextUtils.isEmpty(str) && str.contains(".0")) ? str.replace(".0", "") : str;
    }

    public void a(boolean z) {
        this.g = z;
    }

    public String c() {
        return this.b;
    }
}
