package com.baidu.navisdk.ui.routeguide.model;

import XIXIX.OOXIXo;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ugc.report.data.datarepository.d;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.g0;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.l;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class q {
    private static final String e = "q";

    /* renamed from: a, reason: collision with root package name */
    public boolean f8961a;
    private boolean b;
    private boolean c;
    public String d;

    /* loaded from: classes8.dex */
    public class b implements l.j {
        public b() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.l.j
        public void a(int i) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.l.j
        public void b() {
            com.baidu.navisdk.ui.routeguide.control.s.T().c(1);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.l.j
        public void a(int i, l.i iVar) {
            q.this.a(iVar.d());
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.l.j
        public void a() {
            q qVar = q.this;
            if (qVar.f8961a) {
                qVar.f8961a = false;
            }
            com.baidu.navisdk.ui.routeguide.asr.c.n().l();
            com.baidu.navisdk.ui.routeguide.control.s.T().c(1);
        }
    }

    /* loaded from: classes8.dex */
    public class c extends g0.f {
        public c() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void a() {
            com.baidu.navisdk.ui.routeguide.control.x.b().I().a(8);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void b() {
            com.baidu.navisdk.ui.routeguide.control.x.b().I().a(0);
            q qVar = q.this;
            if (qVar.f8961a) {
                qVar.f8961a = false;
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void c() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void d() {
            com.baidu.navisdk.ui.routeguide.control.x.b().I().a(8);
        }
    }

    /* loaded from: classes8.dex */
    public class d implements l.j {
        public d() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.l.j
        public void a(int i) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.l.j
        public void b() {
            com.baidu.navisdk.ui.routeguide.control.s.T().c(2);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.l.j
        public void a(int i, l.i iVar) {
            q.this.a(iVar.d());
            com.baidu.navisdk.ui.routeguide.control.s.T().c(2);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.l.j
        public void a() {
            q qVar = q.this;
            if (qVar.f8961a) {
                qVar.f8961a = false;
            }
            com.baidu.navisdk.ui.routeguide.asr.c.n().l();
            com.baidu.navisdk.ui.routeguide.control.s.T().c(2);
        }
    }

    /* loaded from: classes8.dex */
    public class e implements com.baidu.navisdk.ugc.report.voice.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f8965a;

        public e(q qVar, boolean z) {
            this.f8965a = z;
        }

        @Override // com.baidu.navisdk.ugc.report.voice.b
        public void a() {
            String string = JarUtils.getResources().getString(R.string.asr_rg_ugc_report_success);
            if (this.f8965a) {
                com.baidu.navisdk.module.asr.i.b(string);
            } else {
                TTSPlayerControl.playTTS(string, 1);
            }
        }

        @Override // com.baidu.navisdk.ugc.report.voice.b
        public void b() {
            String string = JarUtils.getResources().getString(R.string.asr_rg_ugc_report_fail);
            if (this.f8965a) {
                com.baidu.navisdk.module.asr.i.b(string);
            } else {
                TTSPlayerControl.playTTS(string, 1);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        private static final q f8966a = new q(null);
    }

    /* loaded from: classes8.dex */
    public enum g {
        ACCIDENT(1),
        ROAD_BUILD(2),
        ROAD_CLOSED(3),
        JAM(4),
        NOTIFICATION_CLOSE(5);


        /* renamed from: a, reason: collision with root package name */
        private int f8967a;

        g(int i) {
            this.f8967a = i;
        }

        public int a() {
            return this.f8967a;
        }
    }

    public /* synthetic */ q(a aVar) {
        this();
    }

    private int b(int i) {
        if (i == 2) {
            return 7;
        }
        if (i == 15) {
            return 9;
        }
        if (i == 45) {
            return 10;
        }
        if (i == 47) {
            return 8;
        }
        if (i == 9) {
            return 2;
        }
        if (i == 10) {
            return 3;
        }
        if (i == 4) {
            return 1;
        }
        if (i == 5) {
            return 0;
        }
        if (i != 6) {
            return i != 7 ? -1 : 5;
        }
        return 4;
    }

    public static q d() {
        return f.f8966a;
    }

    private com.baidu.navisdk.ui.routeguide.mapmode.subview.l e() {
        ArrayList arrayList = new ArrayList();
        d.b b2 = com.baidu.navisdk.ugc.report.data.datarepository.d.i().b();
        if (b2 != null && !TextUtils.isEmpty(b2.f8250a)) {
            this.d = b2.f8250a;
        } else {
            this.d = JarUtils.getResources().getString(R.string.nsdk_string_ugc_jam_report_notication_title);
        }
        if (b2 != null) {
            ArrayList<d.b.a> arrayList2 = b2.b;
            if (arrayList2 != null && arrayList2.size() > 0) {
                for (int i = 0; i < arrayList2.size(); i++) {
                    d.b.a aVar = arrayList2.get(i);
                    if (!TextUtils.isEmpty(aVar.b()) && !TextUtils.isEmpty(aVar.c())) {
                        arrayList.add(new l.i(aVar.a(), aVar.b(), aVar.c(), aVar.d()));
                    }
                }
            }
            if (arrayList.size() == 0) {
                a(arrayList);
            }
        } else {
            a(arrayList);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.l a2 = com.baidu.navisdk.ui.routeguide.control.x.b().a(new com.baidu.navisdk.ui.routeguide.model.e().c(1).d(10000).b(this.d).a(1).a(arrayList).a(new b()));
        a2.a(new c());
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.baidu.navisdk.ui.routeguide.control.x.b().j(4).z(100).b(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_notification_fail)).f(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_ugc_cancel_jam_report_title)).y();
    }

    private void g() {
        ArrayList arrayList = new ArrayList();
        l.i iVar = new l.i(JarUtils.getResources().getDrawable(R.drawable.nsdk_type_default_dangerous), null, "危险", 10);
        l.i iVar2 = new l.i(JarUtils.getResources().getDrawable(R.drawable.nsdk_type_default_road_build), null, "施工", 6);
        l.i iVar3 = new l.i(JarUtils.getResources().getDrawable(R.drawable.nsdk_type_default_road_closed), null, "封路", 7);
        arrayList.add(iVar);
        arrayList.add(iVar2);
        arrayList.add(iVar3);
        if (com.baidu.navisdk.ui.routeguide.control.x.b().a(new com.baidu.navisdk.ui.routeguide.model.e().c(2).d(10000).b(this.d).a(1).a(arrayList).a(new d())).y()) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.6", null, null, null);
        }
    }

    public boolean c(boolean z) {
        if (!com.baidu.navisdk.ui.routeguide.control.x.b().s2() && !z) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (!gVar.d()) {
                return false;
            }
            gVar.e(e, "PM让我横屏不要展示的");
            return false;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.l e2 = e();
        boolean y = e2.y();
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e(e, "showJamReportNoticationView, result = " + y);
        }
        if (y) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.6", null, null, null);
            a(e2);
        }
        return y;
    }

    private q() {
        this.f8961a = false;
        this.b = false;
        this.c = false;
        this.d = null;
    }

    public void b(boolean z) {
        this.b = z;
    }

    public boolean a(float f2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(e, "speedCheck: speed --> " + (f2 * 3.6d));
        }
        return ((double) f2) * 3.6d < 20.0d;
    }

    public boolean b() {
        return this.c;
    }

    public void a() {
        if (this.f8961a) {
            this.f8961a = false;
            com.baidu.navisdk.asr.d.B().c();
        }
    }

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.asr.i.b {
        public a() {
        }

        @Override // com.baidu.navisdk.asr.i.b
        public void a(String str, int i) {
            super.a(str, i);
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.c.k.2", "2", null, null);
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.6.1", "2", (i + 1) + "", null);
            if (i == 0) {
                q.this.a(5);
            } else if (i == 1) {
                q.this.a(-1);
            }
            com.baidu.navisdk.asr.d.B().c();
        }

        @Override // com.baidu.navisdk.asr.i.b
        public void c() {
            com.baidu.navisdk.ui.routeguide.control.s.T().c(1);
        }

        @Override // com.baidu.navisdk.asr.i.b
        public void a() {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.c.k.2", "2", null, null);
            q qVar = q.this;
            if (qVar.f8961a) {
                qVar.f8961a = false;
                com.baidu.navisdk.asr.d.B().c();
                q.this.f();
            }
        }
    }

    private void a(com.baidu.navisdk.ui.routeguide.mapmode.subview.l lVar) {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", "事故");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("name", "其他");
            jSONArray.put(jSONObject);
            jSONArray.put(jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        String string = TextUtils.isEmpty(this.d) ? JarUtils.getResources().getString(R.string.nsdk_string_ugc_jam_report_notication_title) : this.d;
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.c.k.2", "1", null, null);
        if (!com.baidu.navisdk.asr.query.a.a(com.baidu.navisdk.framework.a.c().a()).b("ugc_cause")) {
            TTSPlayerControl.playTTS(string, 1);
            return;
        }
        if (lVar != null) {
            lVar.e0();
        }
        com.baidu.navisdk.asr.query.a.a(com.baidu.navisdk.framework.a.c().a()).a("ugc_cause");
        com.baidu.navisdk.asr.d.B().a(string, jSONArray, "ugc_cause", new a(), false);
    }

    public boolean c() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        com.baidu.navisdk.asr.d.B().c();
        if (i == -1) {
            if (this.f8961a) {
                this.f8961a = false;
            }
            com.baidu.navisdk.ui.routeguide.control.s.T().c(1);
            g();
            return;
        }
        if (a(b(i), false)) {
            int a2 = g.NOTIFICATION_CLOSE.a();
            if (i == 4) {
                a2 = g.JAM.a();
            } else if (i == 5) {
                a2 = g.ACCIDENT.a();
            } else if (i == 6) {
                a2 = g.ROAD_BUILD.a();
            } else if (i == 7) {
                a2 = g.ROAD_CLOSED.a();
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.6.1", "1", a2 + "", null);
        }
    }

    private void a(List<l.i> list) {
        l.i iVar = new l.i(JarUtils.getResources().getDrawable(R.drawable.nsdk_type_default_trafic_accident), null, "事故", 5);
        l.i iVar2 = new l.i(JarUtils.getResources().getDrawable(R.drawable.nsdk_ugc_jam_notification_others), null, "其他", -1);
        list.add(iVar);
        list.add(iVar2);
    }

    private boolean a(int i, boolean z) {
        com.baidu.navisdk.ui.routeguide.control.s.T().c(1);
        com.baidu.navisdk.ui.routeguide.asr.c.n().l();
        if (!com.baidu.navisdk.util.common.y.d(com.baidu.navisdk.framework.a.c().a())) {
            com.baidu.navisdk.module.asr.i.b(JarUtils.getResources().getString(R.string.asr_rg_ugc_report_error));
            return false;
        }
        com.baidu.navisdk.model.datastruct.g d2 = com.baidu.navisdk.util.logic.g.j().d();
        if (d2 != null && d2.b > OOXIXo.f3760XO && d2.f6926a > OOXIXo.f3760XO) {
            com.baidu.navisdk.ugc.report.voice.c.c().a(i, 20, new e(this, z), 2, 2);
            return true;
        }
        String string = JarUtils.getResources().getString(R.string.asr_rg_ugc_report_error);
        if (z) {
            TTSPlayerControl.playXDTTSText(string, 1);
        } else {
            TTSPlayerControl.playTTS(string, 1);
        }
        return false;
    }

    public void a(boolean z) {
        this.c = z;
    }
}
