package com.baidu.navisdk.module.asr.busi;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.asr.h;
import com.baidu.navisdk.module.asr.i;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.List;

/* loaded from: classes7.dex */
public abstract class b implements g {

    /* renamed from: a, reason: collision with root package name */
    protected com.baidu.navisdk.asr.i.e f7028a;
    protected String b;
    protected List<com.baidu.navisdk.ui.search.model.a> c;
    protected boolean d = false;
    protected int e = -1;
    private int f;

    /* loaded from: classes7.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.baidu.navisdk.asr.model.a f7029a;

        /* renamed from: com.baidu.navisdk.module.asr.busi.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0222a implements Runnable {
            public RunnableC0222a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                b bVar = b.this;
                String str = bVar.b;
                com.baidu.navisdk.asr.model.a aVar2 = aVar.f7029a;
                bVar.a(str, aVar2.f6552a, aVar2.c);
            }
        }

        public a(com.baidu.navisdk.asr.model.a aVar) {
            this.f7029a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f = com.baidu.navisdk.module.asr.busi.c.a();
            i.b("XDVoice", new RunnableC0222a());
        }
    }

    /* renamed from: com.baidu.navisdk.module.asr.busi.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0223b implements com.baidu.navisdk.ui.search.b {
        public C0223b(b bVar) {
        }
    }

    /* loaded from: classes7.dex */
    public class c extends com.baidu.navisdk.asr.i.a {
        public c() {
        }

        @Override // com.baidu.navisdk.asr.i.a
        public void a(String str, boolean z) {
            super.a(str, z);
            if (z) {
                b bVar = b.this;
                bVar.a(bVar.e);
            } else {
                b.this.f7028a.a(com.baidu.navisdk.module.asr.instructions.b.b("将继续当前导航"));
            }
        }

        @Override // com.baidu.navisdk.asr.i.a
        public void b() {
            b.this.e();
        }
    }

    public abstract void a(int i);

    @Override // com.baidu.navisdk.module.asr.busi.g
    public void b() {
        this.d = false;
        this.f7028a.a(com.baidu.navisdk.module.asr.instructions.b.b(JarUtils.getResources().getString(R.string.nav_voice_eta_query_search_error)));
        h();
    }

    public abstract void b(int i);

    @Override // com.baidu.navisdk.module.asr.busi.g
    public void c() {
        this.d = false;
        com.baidu.navisdk.asr.i.e eVar = this.f7028a;
        if (eVar == null) {
            return;
        }
        eVar.c();
        if (TextUtils.isEmpty(this.b)) {
            com.baidu.navisdk.util.common.g.ASR.e("XDVoice", "addSuccessResponse() mKeyWord is null");
            return;
        }
        Bundle bundle = new Bundle();
        BNRouteGuider.getInstance().getRouteInfoInUniform(4, 2, bundle);
        TTSPlayerControl.playXDTTSText(JarUtils.getResources().getString(R.string.asr_rg_route_search_success, this.b, bundle.getString("usWayRoadName")), 1);
    }

    public abstract void c(int i);

    public void d(int i) {
        if (i >= 0 && i <= this.c.size()) {
            this.e = i;
            b(i);
        } else {
            b();
        }
    }

    public void e() {
        com.baidu.navisdk.util.common.g.ASR.e("XDVoice", "exit()");
        this.d = false;
        f();
    }

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public void i() {
        int i = this.e;
        com.baidu.navisdk.util.common.g.ASR.e("XDVoice", "queryNeedVia() , index is " + i);
        if (i >= 0 && i < this.c.size()) {
            com.baidu.navisdk.ui.search.model.a aVar = this.c.get(i);
            Bundle bundle = new Bundle();
            bundle.putDouble("PoiX", aVar.l.getLongitudeE6() / 100000.0d);
            bundle.putDouble("PoiY", aVar.l.getLatitudeE6() / 100000.0d);
            c(BNRouteGuider.getInstance().calcOtherRoute("", 1, 38, 4, 2, aVar.b, bundle));
        }
    }

    @Override // com.baidu.navisdk.module.asr.busi.g
    public void a(com.baidu.navisdk.asr.model.a aVar, com.baidu.navisdk.asr.i.e eVar) {
        this.d = true;
        String str = aVar.v;
        this.b = str;
        if (eVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f7028a = eVar;
        if (h.a()) {
            this.f7028a.a(com.baidu.navisdk.module.asr.instructions.b.b(JarUtils.getResources().getString(R.string.asr_rg_pref_off_line_not_use)));
            g();
            return;
        }
        i.a("XDVoice", new a(aVar));
    }

    @Override // com.baidu.navisdk.module.asr.busi.g
    public void b(String str) {
        com.baidu.navisdk.util.common.g.ASR.e("XDVoice", "noNeedViaPoint()");
        this.f7028a.a(com.baidu.navisdk.module.asr.instructions.b.b(str));
        e();
    }

    @Override // com.baidu.navisdk.module.asr.busi.g
    public boolean d() {
        return this.d;
    }

    public void a(String str, String str2, String str3) {
        com.baidu.navisdk.ui.search.c.INSTANCE.a(str, str2, str3, this.f, new C0223b(this));
    }

    @Override // com.baidu.navisdk.module.asr.busi.g
    public void a(String str) {
        com.baidu.navisdk.util.common.g.ASR.e("XDVoice", "needViaPoint() ");
        this.f7028a.a(str, "eta_query", new c());
    }
}
