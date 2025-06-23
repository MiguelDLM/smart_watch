package com.baidu.navisdk.module.newguide.viewmodels;

import android.text.TextUtils;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.model.c0;
import com.baidu.navisdk.ui.routeguide.model.h;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.l0;
import com.baidu.navisdk.util.common.p;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/* loaded from: classes7.dex */
public class a extends ViewModel {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.ui.routeguide.repository.b f7355a;
    private MutableLiveData<d> b;
    private LiveData<h> c;
    private MutableLiveData<c> d;
    private d e;
    private c f = new c();

    /* renamed from: com.baidu.navisdk.module.newguide.viewmodels.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0269a implements Function<c0, d> {
        public C0269a() {
        }

        @Override // androidx.arch.core.util.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d apply(c0 c0Var) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGDestinationEtaShowViewModel", "apply: " + c0Var);
            }
            return a.this.a(c0Var);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Function<h, c> {
        public b() {
        }

        @Override // androidx.arch.core.util.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c apply(h hVar) {
            return a.this.a(hVar);
        }
    }

    /* loaded from: classes7.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f7358a = "";
        public String b = "";
        public String c = "";
        public int d = 0;

        public void a() {
            this.f7358a = null;
            this.b = null;
            this.c = null;
            this.d = 0;
        }

        public String toString() {
            return "DestinationShowModel{remainDistS='" + this.f7358a + "', remainTimeS='" + this.b + "', arriveTimeS='" + this.c + "', trafficLight=" + this.d + '}';
        }
    }

    /* loaded from: classes7.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public String f7359a = "";
        public String b = "";
        public int c = 0;
        public String d;

        public boolean a() {
            if (!TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(this.f7359a)) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "ViaPointShowMode{remainDistS='" + this.f7359a + "', remainTimeS='" + this.b + "', trafficLight=" + this.c + ", title='" + this.d + "'}";
        }
    }

    public LiveData<c> b() {
        return this.d;
    }

    public String c() {
        return this.f.c;
    }

    public String d() {
        return this.f.f7358a;
    }

    public String e() {
        return this.f.b;
    }

    public int f() {
        return this.f.d;
    }

    public String g() {
        d dVar = this.e;
        if (dVar != null) {
            return dVar.f7359a;
        }
        return "";
    }

    public String h() {
        d dVar = this.e;
        if (dVar != null) {
            return dVar.b;
        }
        return "";
    }

    public int i() {
        d dVar = this.e;
        if (dVar != null) {
            return dVar.c;
        }
        return 0;
    }

    public boolean j() {
        d dVar = this.e;
        if (dVar != null && dVar.a()) {
            return true;
        }
        return false;
    }

    public void k() {
        this.d.setValue(this.f);
        this.b.setValue(this.e);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
    }

    public void a(com.baidu.navisdk.ui.routeguide.repository.b bVar) {
        if (bVar == null) {
            g gVar = g.PRO_NAV;
            if (gVar.c()) {
                gVar.c("RGDestinationEtaShowViewModel", "init: repository == null ");
                return;
            }
            return;
        }
        this.f7355a = bVar;
        this.b = (MutableLiveData) Transformations.map(bVar.a(), new C0269a());
        LiveData<h> b2 = this.f7355a.b();
        this.c = b2;
        this.d = (MutableLiveData) Transformations.map(b2, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d a(c0 c0Var) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDestinationEtaShowViewModel", "handlerViaPointModel: " + c0Var);
        }
        if (c0Var != null && c0Var.a()) {
            int f = com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE.f();
            if (gVar.d()) {
                gVar.e("RGDestinationEtaShowViewModel", "handlerViaPointModel viaCount: " + f);
            }
            if (f <= 0) {
                if (this.e != null) {
                    this.e = null;
                }
                return null;
            }
            if (this.e == null) {
                this.e = new d();
            }
            if (f > 1) {
                this.e.d = "距最近途经点";
            } else {
                this.e.d = "距途经点";
            }
            StringBuilder sb = new StringBuilder();
            l0.a(c0Var.f8933a, l0.a.ZH, sb);
            this.e.f7359a = sb.toString();
            this.e.b = l0.a(c0Var.b);
            d dVar = this.e;
            dVar.c = c0Var.c;
            return dVar;
        }
        if (this.e != null) {
            this.e = null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c a(h hVar) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDestinationEtaShowViewModel", "handlerDestinationModel: " + hVar);
        }
        if (this.f == null) {
            this.f = new c();
        }
        if (hVar == null) {
            this.f.a();
            return null;
        }
        c cVar = this.f;
        cVar.d = hVar.c;
        cVar.c = a(hVar.d);
        StringBuilder sb = new StringBuilder();
        l0.a(hVar.f8945a, l0.a.ZH, sb);
        this.f.f7358a = sb.toString();
        this.f.b = l0.a(hVar.b);
        return this.f;
    }

    public LiveData<d> a() {
        return this.b;
    }

    private String a(long j) {
        Date date = new Date(System.currentTimeMillis());
        Date date2 = new Date(j);
        String format = new SimpleDateFormat("HH:mm").format(date2);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
        gregorianCalendar2.setTime(date2);
        if (gregorianCalendar.get(5) == gregorianCalendar2.get(5)) {
            return String.format(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_arrive_time), format);
        }
        int a2 = a(date, date2);
        if (a2 == 1) {
            return String.format(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_arrive_time_at_tomorrow), format);
        }
        if (a2 == 2) {
            return String.format(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_arrive_time_at_after_tomorrow), format);
        }
        if (a2 <= 2) {
            return String.format(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_arrive_time), format);
        }
        return String.format(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_arrive_time_at_week_day), p.a(date2), format);
    }

    private int a(Date date, Date date2) {
        if (date == null || date2 == null) {
            return 0;
        }
        long time = date2.getTime() - date.getTime();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            time = simpleDateFormat.parse(simpleDateFormat.format(date2)).getTime() - simpleDateFormat.parse(simpleDateFormat.format(date)).getTime();
        } catch (Exception unused) {
        }
        return (int) (time / 86400000);
    }
}
