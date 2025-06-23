package com.baidu.mapapi.walknavi.controllers.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.entity.pb.WalkPlan;
import com.baidu.mapapi.PermissionUtils;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.common.BaiduMapSDKException;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Polyline;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.walknavi.adapter.IWEngineInitListener;
import com.baidu.mapapi.walknavi.adapter.IWMoreNPCModelOnClickListener;
import com.baidu.mapapi.walknavi.adapter.IWNPCLoadAndInitListener;
import com.baidu.mapapi.walknavi.adapter.IWNaviCalcRouteListener;
import com.baidu.mapapi.walknavi.adapter.IWRouteGuidanceListener;
import com.baidu.mapapi.walknavi.adapter.IWTTSPlayer;
import com.baidu.mapapi.walknavi.controllers.WNavigatorWrapper;
import com.baidu.mapapi.walknavi.model.BaseNpcModel;
import com.baidu.mapapi.walknavi.model.MultiRouteDisplayOption;
import com.baidu.mapapi.walknavi.model.WalkNaviDisplayOption;
import com.baidu.platform.comapi.walknavi.WalkNaviModeSwitchListener;
import com.baidu.platform.comapi.walknavi.b;
import com.baidu.platform.comapi.walknavi.widget.ArCameraView;
import com.baidu.platform.comapi.wnplatform.f;
import com.baidu.platform.comapi.wnplatform.j.h;
import com.baidu.platform.comapi.wnplatform.model.datastruct.WLocData;
import com.baidu.platform.comapi.wnplatform.p.g;
import com.baidu.platform.comapi.wnplatform.walkmap.WNaviBaiduMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class a {
    private FrameLayout b;
    private FrameLayout c;
    private FrameLayout d;
    private RelativeLayout e;
    private RelativeLayout f;
    private ArCameraView g;
    private WalkNaviModeSwitchListener k;
    private com.baidu.platform.comapi.walknavi.d.a l;

    /* renamed from: a, reason: collision with root package name */
    private MapView f6029a = null;
    private View h = null;
    private View i = null;
    private Context j = null;

    private void j() {
        RelativeLayout a2;
        if (this.l == null && (a2 = com.baidu.platform.comapi.walknavi.b.a().a(new c(this))) != null) {
            com.baidu.platform.comapi.walknavi.d.a aVar = new com.baidu.platform.comapi.walknavi.d.a(this.j);
            this.l = aVar;
            aVar.setOnTouchListener(new d(this));
            a2.addView(this.l);
        }
    }

    public ArrayList<BaseNpcModel> b() {
        return com.baidu.platform.comapi.walknavi.b.a().t();
    }

    public void c() {
        com.baidu.platform.comapi.walknavi.b.a().z();
    }

    public void d() {
        if (f.a().c() && com.baidu.platform.comapi.wnplatform.a.a() != null) {
            com.baidu.platform.comapi.wnplatform.a.a().h();
        }
        MapView mapView = this.f6029a;
        if (mapView != null) {
            mapView.onPause();
        }
    }

    public void e() {
        if (f.a().c() && com.baidu.platform.comapi.wnplatform.a.a() != null) {
            com.baidu.platform.comapi.wnplatform.a.a().f();
        }
        MapView mapView = this.f6029a;
        if (mapView != null) {
            mapView.onResume();
        }
    }

    public void f() {
        MapView mapView;
        h.a().b();
        if (f.a().c() && com.baidu.platform.comapi.wnplatform.a.a() != null) {
            com.baidu.platform.comapi.wnplatform.a.a().c();
            com.baidu.platform.comapi.wnplatform.a.a().i();
        }
        MapView mapView2 = this.f6029a;
        if (mapView2 != null) {
            mapView2.getMap().clear();
            this.f6029a.onDestroy();
            this.f6029a = null;
        }
        FrameLayout frameLayout = this.d;
        if (frameLayout != null && (mapView = this.f6029a) != null) {
            frameLayout.removeView(mapView);
        }
        FrameLayout frameLayout2 = this.d;
        if (frameLayout2 != null && frameLayout2.getParent() != null) {
            ((ViewGroup) this.d.getParent()).removeAllViews();
        }
        this.d = null;
        FrameLayout frameLayout3 = this.b;
        if (frameLayout3 != null && frameLayout3.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeAllViews();
        }
        this.b = null;
        FrameLayout frameLayout4 = this.c;
        if (frameLayout4 != null && frameLayout4.getParent() != null) {
            ((ViewGroup) this.c.getParent()).removeAllViews();
        }
        this.c = null;
    }

    public void g() {
        RelativeLayout relativeLayout = this.f;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        MapView mapView = this.f6029a;
        if (mapView != null && this.d != null) {
            if (mapView.getParent() != null) {
                ((ViewGroup) this.f6029a.getParent()).removeView(this.f6029a);
            }
            this.f6029a.getMap().showSDKLayer();
            this.f6029a.getMap().setPixelFormatTransparent(false);
            com.baidu.platform.comapi.walknavi.b.a().N().d();
            com.baidu.platform.comapi.walknavi.b.a().N().a(true);
            com.baidu.platform.comapi.walknavi.b.a().N().e();
            this.f6029a.getMap().setMapStatus(MapStatusUpdateFactory.zoomTo(19.0f));
            this.f6029a.getMap().setBaiduHeatMapEnabled(false);
            this.f6029a.getMap().setTrafficEnabled(false);
            this.d.addView(this.f6029a);
            this.d.setVisibility(0);
        }
    }

    public void h() {
        ArCameraView arCameraView;
        RelativeLayout relativeLayout = this.e;
        if (relativeLayout != null && (arCameraView = this.g) != null) {
            relativeLayout.removeView(arCameraView);
            this.g.releaseCamera();
            this.g = null;
            this.e = null;
        }
    }

    public MapView i() {
        return this.f6029a;
    }

    @TargetApi(11)
    private void c(Activity activity) {
        MapView mapView;
        FrameLayout frameLayout = this.d;
        if (frameLayout != null && (mapView = this.f6029a) != null) {
            frameLayout.removeView(mapView);
            this.d.setVisibility(8);
        }
        this.k.onSuccess();
    }

    public void a(Activity activity, IWEngineInitListener iWEngineInitListener) {
        if (iWEngineInitListener != null) {
            if (SDKInitializer.getAgreePrivacy()) {
                if (this.f6029a == null) {
                    this.f6029a = new MapView(activity);
                }
                com.baidu.platform.comapi.walknavi.b.a().a(activity, this.f6029a);
                com.baidu.platform.comapi.walknavi.b.a().a(activity, WNaviBaiduMap.getId(), new b(this, iWEngineInitListener));
                return;
            }
            iWEngineInitListener.engineInitFail();
            throw new BaiduMapSDKException("not agree privacyMode, if you want to use walk navigation please invoke SDKInitializer.setAgreePrivacy(Context, boolean) function");
        }
        throw new com.baidu.mapapi.walknavi.controllers.a("BDMapSDKException: engine init listener cannot be null");
    }

    public void b(Activity activity) {
        com.baidu.platform.comapi.wnplatform.a.a().a(activity, this.f, true);
        j();
        c(activity);
    }

    public boolean a() {
        return WNavigatorWrapper.getWNavigator().l();
    }

    public void a(Activity activity, IWRouteGuidanceListener iWRouteGuidanceListener) {
        WNavigatorWrapper.getWNavigator().a(activity, iWRouteGuidanceListener);
    }

    public void a(IWTTSPlayer iWTTSPlayer) {
        h.a().a(iWTTSPlayer);
    }

    public void a(WLocData wLocData) {
        com.baidu.platform.comapi.walknavi.b.a().a(wLocData);
    }

    public void a(WalkNaviDisplayOption walkNaviDisplayOption) {
        com.baidu.platform.comapi.walknavi.b.a().a(walkNaviDisplayOption);
    }

    public void a(ArrayList<BaseNpcModel> arrayList) {
        com.baidu.platform.comapi.walknavi.b.a().a(arrayList);
    }

    public void a(BaseNpcModel baseNpcModel) {
        com.baidu.platform.comapi.walknavi.b.a().a(baseNpcModel);
    }

    public void a(IWMoreNPCModelOnClickListener iWMoreNPCModelOnClickListener) {
        com.baidu.platform.comapi.walknavi.b.a().a(iWMoreNPCModelOnClickListener);
    }

    public void a(IWNPCLoadAndInitListener iWNPCLoadAndInitListener) {
        com.baidu.platform.comapi.walknavi.b.a().a(iWNPCLoadAndInitListener);
    }

    public View a(Activity activity) {
        if (activity == null) {
            return null;
        }
        this.j = activity;
        com.baidu.platform.comapi.wnplatform.tts.a.b = activity;
        if (f.a().c() && !PermissionUtils.getInstance().isWalkARNaviAuthorized()) {
            return null;
        }
        activity.getWindow().setFlags(128, 128);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (com.baidu.platform.comapi.walknavi.b.a().R() == b.EnumC0532b.LIGHT.a()) {
            FrameLayout frameLayout = new FrameLayout(activity);
            this.c = frameLayout;
            frameLayout.setLayoutParams(layoutParams);
            this.i = com.baidu.platform.comapi.walknavi.b.a().b(activity);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            FrameLayout frameLayout2 = new FrameLayout(activity);
            this.d = frameLayout2;
            frameLayout2.setLayoutParams(layoutParams2);
            com.baidu.platform.comapi.walknavi.b.a().a(this.d);
            MapView mapView = this.f6029a;
            if (mapView != null && mapView.getParent() != null) {
                ((ViewGroup) this.f6029a.getParent()).removeView(this.f6029a);
            }
            this.d.addView(this.f6029a);
            FrameLayout frameLayout3 = this.d;
            if (frameLayout3 != null && frameLayout3.getParent() != null) {
                ((ViewGroup) this.d.getParent()).removeView(this.d);
            }
            this.c.addView(this.d);
            View view = this.i;
            if (view != null && view.getParent() != null) {
                ((ViewGroup) this.i.getParent()).removeView(this.i);
            }
            this.c.addView(this.i);
            return this.c;
        }
        FrameLayout frameLayout4 = new FrameLayout(activity);
        this.b = frameLayout4;
        frameLayout4.setLayoutParams(layoutParams);
        this.h = com.baidu.platform.comapi.walknavi.b.a().c(activity);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
        RelativeLayout relativeLayout = new RelativeLayout(activity);
        this.f = relativeLayout;
        relativeLayout.setLayoutParams(layoutParams3);
        FrameLayout frameLayout5 = new FrameLayout(activity);
        this.d = frameLayout5;
        frameLayout5.setLayoutParams(layoutParams3);
        com.baidu.platform.comapi.walknavi.b.a().a(this.d);
        MapView mapView2 = this.f6029a;
        if (mapView2 != null && mapView2.getParent() != null) {
            ((ViewGroup) this.f6029a.getParent()).removeView(this.f6029a);
        }
        this.d.addView(this.f6029a);
        RelativeLayout relativeLayout2 = this.f;
        if (relativeLayout2 != null && relativeLayout2.getParent() != null) {
            ((ViewGroup) this.f.getParent()).removeView(this.f);
        }
        this.b.addView(this.f);
        FrameLayout frameLayout6 = this.d;
        if (frameLayout6 != null && frameLayout6.getParent() != null) {
            ((ViewGroup) this.d.getParent()).removeView(this.d);
        }
        this.b.addView(this.d);
        View view2 = this.h;
        if (view2 != null && view2.getParent() != null) {
            ((ViewGroup) this.h.getParent()).removeView(this.h);
        }
        this.b.addView(this.h);
        return this.b;
    }

    public void a(int i) {
        com.baidu.platform.comapi.walknavi.b.a().f(i);
    }

    public void a(Activity activity, int i, WalkNaviModeSwitchListener walkNaviModeSwitchListener) {
        int checkSelfPermission;
        this.k = walkNaviModeSwitchListener;
        if (f.a().b()) {
            g();
            this.k.onSuccess();
            return;
        }
        if (f.a().c()) {
            if (!PermissionUtils.getInstance().isWalkARNaviAuthorized()) {
                this.k.onFailed();
                return;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                checkSelfPermission = activity.checkSelfPermission("android.permission.CAMERA");
                if (checkSelfPermission != 0) {
                    activity.requestPermissions(new String[]{"android.permission.CAMERA"}, 3001);
                    return;
                } else {
                    b(activity);
                    return;
                }
            }
            b(activity);
        }
    }

    public void a(boolean z) {
        if (!z) {
            MapView mapView = this.f6029a;
            if (mapView != null && mapView.getParent() != null) {
                ((ViewGroup) this.f6029a.getParent()).removeView(this.f6029a);
            }
            FrameLayout frameLayout = this.c;
            if (frameLayout != null) {
                frameLayout.addView(this.f6029a);
            }
            com.baidu.platform.comapi.walknavi.b a2 = com.baidu.platform.comapi.walknavi.b.a();
            b.EnumC0532b enumC0532b = b.EnumC0532b.LIGHT;
            a2.f(enumC0532b.a());
            com.baidu.platform.comapi.walknavi.b.a().g(enumC0532b.a());
        }
        com.baidu.platform.comapi.walknavi.b.a().c(z);
    }

    public void a(com.baidu.platform.comapi.walknavi.f.c cVar, int i, IWNaviCalcRouteListener iWNaviCalcRouteListener) {
        WNavigatorWrapper.getWNavigator().J().a(new e(this, iWNaviCalcRouteListener));
        WNavigatorWrapper.getWNavigator().J().a(13, cVar.a("route_data_mode", 0), i, 0, cVar.a("route_buff"));
    }

    public List<Polyline> a(MapView mapView, MultiRouteDisplayOption multiRouteDisplayOption) {
        ArrayList arrayList = new ArrayList();
        WalkPlan V = com.baidu.platform.comapi.walknavi.b.a().V();
        if (V == null) {
            return null;
        }
        if (V.getRoutesCount() > 0) {
            int routesCount = V.getRoutesCount();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < routesCount; i++) {
                ArrayList<LatLng> b = g.b(V, i);
                if (b.size() >= 2) {
                    PolylineOptions polylineOptions = new PolylineOptions();
                    Bundle bundle = new Bundle();
                    bundle.putInt("routeIndex", i);
                    polylineOptions.points(b);
                    polylineOptions.extraInfo(bundle);
                    if (i == 0) {
                        if (multiRouteDisplayOption != null && multiRouteDisplayOption.getFocusRouteBitmapDescriptor() != null) {
                            polylineOptions.customTexture(multiRouteDisplayOption.getFocusRouteBitmapDescriptor()).dottedLine(true);
                        } else if (multiRouteDisplayOption != null && multiRouteDisplayOption.getFocusColor() != 0) {
                            polylineOptions.color(multiRouteDisplayOption.getFocusColor());
                        } else {
                            polylineOptions.color(-11950337);
                        }
                        if (multiRouteDisplayOption != null && multiRouteDisplayOption.getFocusRouteWidth() != 0) {
                            polylineOptions.width(multiRouteDisplayOption.getFocusRouteWidth());
                        } else {
                            polylineOptions.width(20);
                        }
                    } else {
                        if (multiRouteDisplayOption != null && multiRouteDisplayOption.getNoFocusRouteBitmapDescriptor() != null) {
                            polylineOptions.customTexture(multiRouteDisplayOption.getNoFocusRouteBitmapDescriptor()).dottedLine(true);
                        } else if (multiRouteDisplayOption != null && multiRouteDisplayOption.getNoFocusColor() != 0) {
                            polylineOptions.color(multiRouteDisplayOption.getNoFocusColor());
                        } else {
                            polylineOptions.color(-12883501);
                        }
                        if (multiRouteDisplayOption != null && multiRouteDisplayOption.getNoFocusRouteWidth() != 0) {
                            polylineOptions.width(multiRouteDisplayOption.getNoFocusRouteWidth());
                        } else {
                            polylineOptions.width(20);
                        }
                    }
                    if (mapView != null && mapView.getMap() != null) {
                        arrayList.add((Polyline) mapView.getMap().addOverlay(polylineOptions));
                    }
                    arrayList2.addAll(b);
                }
            }
            if (arrayList2.size() < 2) {
                return null;
            }
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                builder.include((LatLng) it.next());
            }
            if (mapView != null && mapView.getMap() != null) {
                mapView.getMap().setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build(), 100, 100, 100, 100));
            }
        }
        return arrayList;
    }
}
