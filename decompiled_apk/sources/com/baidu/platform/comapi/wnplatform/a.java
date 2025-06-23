package com.baidu.platform.comapi.wnplatform;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.ar.NavigationController;
import com.baidu.ar.NavigationType;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.ar.marker.IMarkerStateListener;
import com.baidu.ar.marker.model.Segments;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.platform.comapi.util.j;
import com.huawei.openalliance.ad.constant.aw;
import java.util.List;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f9888a = "a";
    private ViewGroup b;
    private Context d;
    private ViewGroup g;
    private NavigationController h;
    private List<Segments> k;
    private double[] l;
    private List<double[]> m;
    private int n;
    private double[] o;
    private double[] p;
    private boolean c = false;
    private boolean e = false;
    private boolean f = false;
    private boolean i = false;
    private int j = 0;
    private NavigationType q = NavigationType.ARIMU;

    /* renamed from: com.baidu.platform.comapi.wnplatform.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0540a {

        /* renamed from: a, reason: collision with root package name */
        static final a f9889a = new a();
    }

    public boolean b() {
        return this.e;
    }

    public void c() {
        ViewGroup viewGroup = this.g;
        if (viewGroup != null) {
            viewGroup.removeView(this.b);
            this.b = null;
        }
    }

    public synchronized boolean d() {
        return this.i;
    }

    public NavigationController e() {
        return this.h;
    }

    public boolean f() {
        ViewGroup viewGroup = this.g;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        try {
            if (this.h != null) {
                com.baidu.platform.comapi.walknavi.b.a().b(aw.ag);
                this.h.onResume();
                return true;
            }
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    public NavigationType g() {
        return this.q;
    }

    public void h() {
        ViewGroup viewGroup = this.g;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        if (this.h != null) {
            com.baidu.platform.comapi.walknavi.b.a().b("onPause");
            com.baidu.platform.comapi.wnplatform.o.a Y = com.baidu.platform.comapi.walknavi.b.a().Y();
            if ((Y instanceof com.baidu.platform.comapi.walknavi.h.b) && ((com.baidu.platform.comapi.walknavi.h.b) Y).x().b()) {
                this.h.onPause();
            }
        }
    }

    public void i() {
        if (this.h != null) {
            com.baidu.platform.comapi.walknavi.b.a().b("onDestroy");
            this.h.onDestroy();
            this.h = null;
            this.k = null;
            this.m = null;
            this.l = null;
            this.p = null;
            this.o = null;
            this.f = false;
            this.e = false;
        }
    }

    public static a a() {
        return C0540a.f9889a;
    }

    public void b(boolean z) {
        if (z) {
            j.a(new b(this), 0L);
        }
        this.e = z;
    }

    public void a(boolean z) {
        List<Segments> list;
        this.c = z;
        if (!z || (list = this.k) == null) {
            return;
        }
        a(list, "caseOK");
    }

    public void a(IMarkerStateListener iMarkerStateListener) {
        NavigationController navigationController = this.h;
        if (navigationController != null) {
            navigationController.setMarkerStateListener(iMarkerStateListener);
        }
    }

    public void a(List<Segments> list, String str) {
        try {
            if (this.c && b()) {
                if (this.h != null) {
                    com.baidu.platform.comapi.wnplatform.o.a Y = com.baidu.platform.comapi.walknavi.b.a().Y();
                    if (Y instanceof com.baidu.platform.comapi.walknavi.h.b) {
                        com.baidu.platform.comapi.walknavi.h.b bVar = (com.baidu.platform.comapi.walknavi.h.b) Y;
                        if (bVar.x() != null) {
                            bVar.x().b(false);
                        }
                    }
                    if (list.size() != 0) {
                        for (int i = 0; i < list.size(); i++) {
                            list.get(i);
                        }
                        this.h.postNavigationRoute(list);
                        com.baidu.platform.comapi.walknavi.b.a().b("postNavigationRoute!!!" + list.size() + str);
                        this.k = null;
                        return;
                    }
                    return;
                }
                return;
            }
            this.k = list;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(int i) {
        NavigationController navigationController = this.h;
        if (navigationController != null) {
            this.n = i;
            navigationController.updateMeters(i);
        }
    }

    public void a(Activity activity, RelativeLayout relativeLayout, boolean z) {
        try {
            if (this.h != null) {
                return;
            }
            this.f = false;
            this.e = false;
            if (activity == null) {
                return;
            }
            this.d = activity;
            this.h = new NavigationController();
            com.baidu.platform.comapi.walknavi.b.a().b("create surface" + this.q);
            this.b = this.h.createGLSurfaceViewWithSize(activity, this.q, z);
            relativeLayout.addView(this.b, 0, new RelativeLayout.LayoutParams(-1, -1));
            this.g = relativeLayout;
            if (z) {
                DuMixARConfig.setCuid(SyncSysInfo.getCid());
            }
            this.c = false;
            this.i = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
