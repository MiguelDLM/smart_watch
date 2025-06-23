package com.baidu.navisdk.ui.routeguide.collisions;

import android.view.View;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.lite.b;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private View f8523a;
    private int b;
    private int c;
    private View.OnLayoutChangeListener d;
    private b e;

    /* renamed from: com.baidu.navisdk.ui.routeguide.collisions.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class ViewOnLayoutChangeListenerC0435a implements View.OnLayoutChangeListener {

        /* renamed from: com.baidu.navisdk.ui.routeguide.collisions.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0436a extends b {
            public C0436a(String str) {
                super(str);
            }

            @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
            public void run() {
                a.this.c();
            }
        }

        public ViewOnLayoutChangeListenerC0435a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (!a.this.e()) {
                return;
            }
            if (a.this.e != null) {
                com.baidu.navisdk.util.worker.lite.a.a(a.this.e);
            }
            if (a.this.e == null) {
                a.this.e = new C0436a("SetBtnVisibleStrategy");
            }
            com.baidu.navisdk.util.worker.lite.a.c(a.this.e);
        }
    }

    public a() {
        d();
    }

    private void d() {
        int dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_control_panel_btn_height_new);
        this.b = dimensionPixelOffset;
        this.c = dimensionPixelOffset * 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        View view = this.f8523a;
        if (view != null && view.getVisibility() == 0 && BNSettingManager.getIsShowMapSwitch() != 0 && x.b().d0() == 1 && com.baidu.navisdk.module.newguide.a.e().d()) {
            return true;
        }
        return false;
    }

    private void f() {
        View view;
        View.OnLayoutChangeListener onLayoutChangeListener = this.d;
        if (onLayoutChangeListener != null && (view = this.f8523a) != null) {
            view.removeOnLayoutChangeListener(onLayoutChangeListener);
        }
        this.d = null;
    }

    private void b() {
        if (this.f8523a != null) {
            if (this.d == null) {
                this.d = new ViewOnLayoutChangeListenerC0435a();
            }
            this.f8523a.addOnLayoutChangeListener(this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (e()) {
            int height = this.f8523a.getHeight();
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGSettingBtnVisibleStra", "RoadConditionHeight = " + height + ", " + this.b + ", " + this.c);
            }
        }
    }

    public void a(View view) {
        f();
        this.f8523a = view;
        b();
    }

    public void a() {
        f();
        b bVar = this.e;
        if (bVar != null) {
            com.baidu.navisdk.util.worker.lite.a.a(bVar);
            this.e = null;
        }
    }
}
