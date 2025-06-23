package com.baidu.navisdk.ui.routeguide.mapmode.subview.highway;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    protected ViewGroup f8768a;
    protected com.baidu.navisdk.module.pronavi.model.d b;
    protected int c;
    protected ArrayList<ImageView> d;

    public b(Context context, int i) {
        this.c = i;
        int f = f();
        if (f > 0) {
            this.f8768a = (ViewGroup) JarUtils.inflate(context, f, null);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(d(), "BNServiceAreaBasePanel: " + this.f8768a);
            }
            a(this.f8768a);
        }
    }

    public int a(int i) {
        return i.a(i, com.baidu.navisdk.ui.routeguide.b.V().D() ? i.b : i.f8769a);
    }

    public abstract void a(View view);

    public com.baidu.navisdk.module.pronavi.model.d b() {
        return this.b;
    }

    public abstract int c();

    public int c(com.baidu.navisdk.module.pronavi.model.d dVar) {
        if (dVar.p() == 1) {
            return R.drawable.nsdk_drawable_rg_hw_service_toll_station;
        }
        int a2 = !dVar.o().isEmpty() ? a(dVar.o().get(0).intValue()) : -1;
        return a2 == -1 ? R.drawable.nsdk_drawable_rg_hw_service_park : a2;
    }

    public abstract String d();

    public abstract void d(com.baidu.navisdk.module.pronavi.model.d dVar);

    public View e() {
        return this.f8768a;
    }

    public abstract int f();

    public void g() {
        ImageView imageView = (ImageView) this.f8768a.findViewById(R.id.bnavi_hw_service_normal_panel_ic_1);
        ImageView imageView2 = (ImageView) this.f8768a.findViewById(R.id.bnavi_hw_service_normal_panel_ic_2);
        ImageView imageView3 = (ImageView) this.f8768a.findViewById(R.id.bnavi_hw_service_normal_panel_ic_3);
        ImageView imageView4 = (ImageView) this.f8768a.findViewById(R.id.bnavi_hw_service_normal_panel_ic_4);
        ImageView imageView5 = (ImageView) this.f8768a.findViewById(R.id.bnavi_hw_service_normal_panel_ic_5);
        ImageView imageView6 = (ImageView) this.f8768a.findViewById(R.id.bnavi_hw_service_normal_panel_ic_6);
        ImageView imageView7 = (ImageView) this.f8768a.findViewById(R.id.bnavi_hw_service_normal_panel_ic_7);
        ImageView imageView8 = (ImageView) this.f8768a.findViewById(R.id.bnavi_hw_service_normal_panel_ic_8);
        ImageView imageView9 = (ImageView) this.f8768a.findViewById(R.id.bnavi_hw_service_normal_panel_ic_9);
        ArrayList<ImageView> arrayList = new ArrayList<>(9);
        this.d = arrayList;
        if (imageView != null) {
            arrayList.add(imageView);
        }
        if (imageView2 != null) {
            this.d.add(imageView2);
        }
        if (imageView3 != null) {
            this.d.add(imageView3);
        }
        if (imageView4 != null) {
            this.d.add(imageView4);
        }
        if (imageView5 != null) {
            this.d.add(imageView5);
        }
        if (imageView6 != null) {
            this.d.add(imageView6);
        }
        if (imageView7 != null) {
            this.d.add(imageView7);
        }
        if (imageView8 != null) {
            this.d.add(imageView8);
        }
        if (imageView9 != null) {
            this.d.add(imageView9);
        }
    }

    public boolean h() {
        if (!i() && com.baidu.navisdk.module.newguide.a.e().d()) {
            return com.baidu.navisdk.ui.routeguide.utils.b.c(com.baidu.navisdk.ui.routeguide.utils.b.o().f6817a);
        }
        return true;
    }

    public boolean i() {
        if (this.c == 1) {
            return true;
        }
        return false;
    }

    public void b(com.baidu.navisdk.module.pronavi.model.d dVar) {
        i.a(new ArrayList(dVar.o()), this.d, com.baidu.navisdk.ui.routeguide.b.V().D() ? i.b : i.f8769a);
    }

    public void a() {
        this.b = null;
    }

    public boolean a(com.baidu.navisdk.module.pronavi.model.d dVar) {
        com.baidu.navisdk.module.pronavi.model.d dVar2 = this.b;
        return (dVar2 != null && dVar2.g().equals(dVar.g()) && this.b.p() == dVar.p() && TextUtils.equals(this.b.h(), dVar.h())) ? false : true;
    }
}
