package com.baidu.navisdk.ugc;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.framework.interfaces.r;
import com.baidu.navisdk.ugc.report.ui.innavi.main.e;
import com.baidu.navisdk.util.common.g;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class b implements r {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.ugc.report.ui.innavi.main.f f8015a;
    private com.baidu.navisdk.ugc.report.ui.innavi.main.e b;
    private AbstractC0368b c;
    private e.i d = new a();

    /* renamed from: com.baidu.navisdk.ugc.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static abstract class AbstractC0368b {
        public abstract int a();

        public abstract void a(boolean z);

        public abstract ArrayList<View> b();

        public abstract int c();

        public abstract void d();
    }

    public b(Activity activity, AbstractC0368b abstractC0368b, int i, int i2, ViewGroup viewGroup, com.baidu.navisdk.ugc.report.data.datarepository.e eVar, boolean z, com.baidu.navisdk.ugc.report.data.datarepository.e eVar2) {
        this.c = abstractC0368b;
        this.f8015a = new com.baidu.navisdk.ugc.report.ui.innavi.main.f(activity, i, viewGroup);
        com.baidu.navisdk.ugc.report.ui.innavi.main.e eVar3 = new com.baidu.navisdk.ugc.report.ui.innavi.main.e(this.f8015a, eVar, this.d, i2, z);
        this.b = eVar3;
        this.f8015a.a((com.baidu.navisdk.ugc.report.ui.innavi.main.c) eVar3);
        this.b.a(eVar2);
    }

    @Override // com.baidu.navisdk.framework.interfaces.r
    public void M() {
        com.baidu.navisdk.ugc.report.ui.innavi.main.e eVar = this.b;
        if (eVar != null) {
            eVar.D();
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.r
    public void n() {
        com.baidu.navisdk.ugc.report.ui.innavi.main.e eVar = this.b;
        if (eVar != null) {
            eVar.B();
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.p
    public boolean n0() {
        com.baidu.navisdk.ugc.report.ui.innavi.main.e eVar = this.b;
        if (eVar != null && eVar.y()) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.navisdk.framework.interfaces.p
    public void onActivityResult(int i, int i2, Intent intent) {
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcNaviReport", "onActivityResult: " + i + "," + i2);
        }
        com.baidu.navisdk.ugc.report.ui.innavi.main.e eVar = this.b;
        if (eVar != null) {
            eVar.a(i, i2, intent);
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.p
    public void onDestroy() {
        com.baidu.navisdk.ugc.report.ui.innavi.main.e eVar = this.b;
        if (eVar != null) {
            eVar.z();
        }
    }

    /* loaded from: classes8.dex */
    public class a implements e.i {
        public a() {
        }

        @Override // com.baidu.navisdk.ugc.report.ui.innavi.main.e.i
        public void a(boolean z) {
            if (b.this.c != null) {
                b.this.c.a(z);
            }
        }

        @Override // com.baidu.navisdk.ugc.report.ui.innavi.main.e.i
        public ArrayList<View> b() {
            if (b.this.c != null) {
                return b.this.c.b();
            }
            return null;
        }

        @Override // com.baidu.navisdk.ugc.report.ui.innavi.main.e.i
        public void c() {
            if (b.this.c != null) {
                b.this.c.d();
            }
        }

        @Override // com.baidu.navisdk.ugc.report.ui.innavi.main.e.i
        public int a() {
            if (b.this.c != null) {
                return b.this.c.c();
            }
            return 0;
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.p
    public boolean a(int i) {
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcNaviReport", "isActivityResult: " + i);
        }
        com.baidu.navisdk.ugc.report.ui.innavi.main.e eVar = this.b;
        return eVar != null && eVar.c(i);
    }

    @Override // com.baidu.navisdk.framework.interfaces.r
    public void a(Activity activity, int i, ViewGroup viewGroup) {
        com.baidu.navisdk.ugc.report.ui.innavi.main.e eVar;
        com.baidu.navisdk.ugc.report.ui.innavi.main.f fVar = this.f8015a;
        if (fVar != null) {
            fVar.onDestroy();
        }
        com.baidu.navisdk.ugc.report.ui.innavi.main.f fVar2 = new com.baidu.navisdk.ugc.report.ui.innavi.main.f(activity, i, viewGroup);
        this.f8015a = fVar2;
        com.baidu.navisdk.ugc.report.ui.innavi.main.e eVar2 = this.b;
        if (eVar2 != null) {
            eVar2.a(fVar2);
        }
        this.f8015a.a((com.baidu.navisdk.ugc.report.ui.innavi.main.c) this.b);
        if (viewGroup == null || (eVar = this.b) == null) {
            return;
        }
        eVar.w().a(this.f8015a);
        this.b.a(i, this.f8015a.d());
    }

    @Override // com.baidu.navisdk.framework.interfaces.r
    public void a(String str, int i, int i2, String str2, String str3) {
        if (this.b != null) {
            this.b.a(new com.baidu.navisdk.ugc.report.ui.innavi.verifyevent.b(str, i, str2, i2, str3), false);
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.r
    public void a(String str, Object obj) {
        com.baidu.navisdk.ugc.report.ui.innavi.main.e eVar = this.b;
        if (eVar == null || !(obj instanceof com.baidu.navisdk.ugc.report.data.datastatus.a)) {
            return;
        }
        eVar.a(str, (com.baidu.navisdk.ugc.report.data.datastatus.a) obj, false, 3);
    }

    @Override // com.baidu.navisdk.framework.interfaces.r
    public void a(Object obj) {
        com.baidu.navisdk.ugc.report.ui.innavi.main.e eVar = this.b;
        if (eVar != null) {
            eVar.a((com.baidu.navisdk.ugc.replenishdetails.b) obj);
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.r
    public void a(String str, Object obj, boolean z) {
        com.baidu.navisdk.ugc.report.ui.innavi.main.e eVar = this.b;
        if (eVar != null) {
            if ((obj instanceof com.baidu.navisdk.ugc.report.data.datastatus.a) || (z && obj == null)) {
                eVar.a(str, obj, z);
            }
        }
    }
}
