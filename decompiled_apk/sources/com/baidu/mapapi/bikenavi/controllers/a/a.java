package com.baidu.mapapi.bikenavi.controllers.a;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.bikenavi.adapter.IBEngineInitListener;
import com.baidu.mapapi.bikenavi.adapter.IBRouteGuidanceListener;
import com.baidu.mapapi.bikenavi.adapter.IBTTSPlayer;
import com.baidu.mapapi.bikenavi.controllers.BNavigatorWrapper;
import com.baidu.mapapi.bikenavi.controllers.UnsupportedBikeNaviException;
import com.baidu.mapapi.bikenavi.model.BikeNaviDisplayOption;
import com.baidu.mapapi.common.BaiduMapSDKException;
import com.baidu.mapapi.map.MapView;
import com.baidu.platform.comapi.walknavi.b;
import com.baidu.platform.comapi.wnplatform.model.datastruct.WLocData;
import com.baidu.platform.comapi.wnplatform.walkmap.WNaviBaiduMap;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    FrameLayout f5767a;
    FrameLayout b;
    private MapView c = null;
    private View d = null;
    private View e = null;

    public void a(Activity activity, IBEngineInitListener iBEngineInitListener) {
        if (iBEngineInitListener != null) {
            if (SDKInitializer.getAgreePrivacy()) {
                if (this.c == null) {
                    this.c = new MapView(activity);
                }
                com.baidu.platform.comapi.walknavi.b.a().a(activity, this.c);
                long id = WNaviBaiduMap.getId();
                com.baidu.platform.comapi.wnplatform.d.a.b("mapHandle", "mapHandle " + id);
                com.baidu.platform.comapi.walknavi.b.a().a(activity, id, new b(this, iBEngineInitListener));
                return;
            }
            iBEngineInitListener.engineInitFail();
            throw new BaiduMapSDKException("not agree privacyMode, if you want to use bike navigation, please invoke SDKInitializer.setAgreePrivacy(Context, boolean) function");
        }
        throw new UnsupportedBikeNaviException("BDMapSDKException: engine init listener cannot be null");
    }

    public void b() {
        MapView mapView = this.c;
        if (mapView != null) {
            mapView.onPause();
        }
    }

    public void c() {
        MapView mapView = this.c;
        if (mapView != null) {
            mapView.onResume();
        }
    }

    public void d() {
        com.baidu.platform.comapi.wnplatform.j.a.a().b();
        MapView mapView = this.c;
        if (mapView != null) {
            mapView.getMap().clear();
            this.c.onDestroy();
        }
        this.c = null;
        FrameLayout frameLayout = this.f5767a;
        if (frameLayout != null && frameLayout.getParent() != null) {
            ((ViewGroup) this.f5767a.getParent()).removeAllViews();
        }
        this.f5767a = null;
        FrameLayout frameLayout2 = this.b;
        if (frameLayout2 != null && frameLayout2.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeAllViews();
        }
        this.b = null;
    }

    public MapView e() {
        return this.c;
    }

    public void f() {
        BNavigatorWrapper.getWNavigator().z();
    }

    public boolean a() {
        return BNavigatorWrapper.getWNavigator().l();
    }

    public void a(Activity activity, IBRouteGuidanceListener iBRouteGuidanceListener) {
        BNavigatorWrapper.getWNavigator().a(activity, iBRouteGuidanceListener);
    }

    public void a(IBTTSPlayer iBTTSPlayer) {
        com.baidu.platform.comapi.wnplatform.j.a.a().a(iBTTSPlayer);
    }

    public void a(WLocData wLocData) {
        com.baidu.platform.comapi.walknavi.b.a().a(wLocData);
    }

    public void a(BikeNaviDisplayOption bikeNaviDisplayOption) {
        com.baidu.platform.comapi.walknavi.b.a().a(bikeNaviDisplayOption);
    }

    public View a(Activity activity) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        com.baidu.platform.comapi.wnplatform.tts.a.b = activity;
        if (com.baidu.platform.comapi.walknavi.b.a().R() == b.EnumC0532b.LIGHT.a()) {
            FrameLayout frameLayout = new FrameLayout(activity);
            this.b = frameLayout;
            frameLayout.setLayoutParams(layoutParams);
            this.e = BNavigatorWrapper.getWNavigator().b(activity);
            MapView mapView = this.c;
            if (mapView != null && mapView.getParent() != null) {
                ((ViewGroup) this.c.getParent()).removeView(this.c);
            }
            this.b.addView(this.c);
            View view = this.e;
            if (view != null && view.getParent() != null) {
                ((ViewGroup) this.e.getParent()).removeView(this.e);
            }
            this.b.addView(this.e);
            return this.b;
        }
        FrameLayout frameLayout2 = new FrameLayout(activity);
        this.f5767a = frameLayout2;
        frameLayout2.setLayoutParams(layoutParams);
        this.d = BNavigatorWrapper.getWNavigator().c(activity);
        MapView mapView2 = this.c;
        if (mapView2 != null && mapView2.getParent() != null) {
            ((ViewGroup) this.c.getParent()).removeView(this.c);
        }
        this.f5767a.addView(this.c);
        View view2 = this.d;
        if (view2 != null && view2.getParent() != null) {
            ((ViewGroup) this.d.getParent()).removeView(this.d);
        }
        this.f5767a.addView(this.d);
        return this.f5767a;
    }

    public void a(String str) {
        BNavigatorWrapper.getWNavigator().Y().a(str);
    }

    public void a(int i) {
        com.baidu.platform.comapi.walknavi.b.a().f(i);
    }

    public void a(boolean z) {
        if (!z) {
            MapView mapView = this.c;
            if (mapView != null && mapView.getParent() != null) {
                ((ViewGroup) this.c.getParent()).removeView(this.c);
            }
            FrameLayout frameLayout = this.b;
            if (frameLayout != null) {
                frameLayout.addView(this.c);
            }
            com.baidu.platform.comapi.walknavi.b a2 = com.baidu.platform.comapi.walknavi.b.a();
            b.EnumC0532b enumC0532b = b.EnumC0532b.LIGHT;
            a2.f(enumC0532b.a());
            com.baidu.platform.comapi.walknavi.b.a().g(enumC0532b.a());
        }
        com.baidu.platform.comapi.walknavi.b.a().c(z);
    }
}
