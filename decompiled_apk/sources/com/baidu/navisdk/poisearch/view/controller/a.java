package com.baidu.navisdk.poisearch.view.controller;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.baidunavis.maplayer.d;
import com.baidu.baidunavis.maplayer.e;
import com.baidu.baidunavis.maplayer.i;
import com.baidu.entity.pb.Cars;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.poisearch.view.RouteCarPopup;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.util.j;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.o;
import com.baidu.navisdk.util.worker.c;
import com.baidu.navisdk.util.worker.f;
import com.baidu.navisdk.util.worker.g;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class a {
    private long c;
    private d d;
    private b e;

    /* renamed from: a, reason: collision with root package name */
    private final com.baidu.navisdk.poisearch.view.model.a f7639a = new com.baidu.navisdk.poisearch.view.model.a();
    private com.baidu.navisdk.poisearch.view.model.a b = new com.baidu.navisdk.poisearch.view.model.a();
    private final f<String, String> f = new C0306a(this, "mHideRouteNearbySearchOverlay-BNRouteResultBubbleController", null);

    /* renamed from: com.baidu.navisdk.poisearch.view.controller.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0306a extends f<String, String> {
        public C0306a(a aVar, String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            e.k().g();
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        boolean a();
    }

    private void e() {
        c.a().a((g) this.f, false);
        c.a().a(this.f, new com.baidu.navisdk.util.worker.e(99, 0), 300L);
    }

    private ArrayList<d> f() {
        Cars d = ((com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel")).d();
        ArrayList arrayList = new ArrayList();
        if (d != null && d.hasOption() && d.getOption().getEndCount() > 1) {
            List<Cars.Option.End> endList = d.getOption().getEndList();
            for (int i = 0; i < endList.size() - 1; i++) {
                arrayList.add(new com.baidu.nplatform.comapi.basestruct.c(a(endList.get(i).getSptList())));
            }
        }
        if (arrayList.size() > 0) {
            ArrayList<d> arrayList2 = new ArrayList<>();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = new d((com.baidu.nplatform.comapi.basestruct.c) arrayList.get(i2), "throughNode", "");
                dVar.a(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_drawable_route_result_icon_through_node));
                arrayList2.add(dVar);
            }
            return arrayList2;
        }
        return null;
    }

    public void a(Context context, com.baidu.navisdk.poisearch.view.model.a aVar, boolean z, i iVar, int i, boolean z2) {
        a(context, aVar, z, iVar, i);
        if (z2) {
            this.b = aVar;
        }
    }

    public d b() {
        return this.d;
    }

    public com.baidu.navisdk.poisearch.view.model.a c() {
        return this.b;
    }

    public void d() {
        if (!a(300L)) {
            e.k().g();
        } else {
            LogUtil.e("BNRouteResultBubbleController", "hideRouteNearbySearchItemizedOverlay --> duplicate execute!!!");
            e();
        }
    }

    public void a(Context context, com.baidu.navisdk.poisearch.view.model.a aVar, boolean z, i iVar, int i) {
        a(context, aVar, z, null, null, ScreenUtil.getInstance().dip2px(56), iVar, i, false);
    }

    public void a(Context context, @NonNull com.baidu.navisdk.poisearch.view.model.a aVar, boolean z, String str, String str2, int i, i iVar, int i2, boolean z2) {
        int i3;
        if (LogUtil.LOGGABLE) {
            if (aVar != null && aVar.b() != null) {
                Bundle b2 = o.b(aVar.b().c(), aVar.b().d());
                GeoPoint geoPoint = new GeoPoint();
                geoPoint.setLongitudeE6(b2.getInt("LLx"));
                geoPoint.setLatitudeE6(b2.getInt("LLy"));
                com.baidu.navisdk.module.nearbysearch.model.a a2 = com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE.a(aVar.a(), geoPoint);
                if (a2 != null) {
                    TipTool.onCreateToastDialog(context, "category is " + a2.b() + ", brandName is " + a2.a());
                }
            } else {
                TipTool.onCreateToastDialog(context, "ApproachPoint or approachPoint.point is null!!!");
            }
        }
        LogUtil.e("BNRouteResultBubbleController", "showRouteNearbySearchPopup ");
        c.a().a((g) this.f, false);
        this.b = null;
        RouteCarPopup routeCarPopup = new RouteCarPopup(context);
        routeCarPopup.setPoiName(aVar.a());
        routeCarPopup.setPoiInfo(str);
        routeCarPopup.setShopOpenTime(str2);
        routeCarPopup.setPinPlaceholderHeight(i);
        if (z) {
            routeCarPopup.a("途经点", context.getResources().getColor(R.color.nsdk_route_nearby_add_color));
            routeCarPopup.setRightBtnDrawable(R.drawable.nsdk_drawable_route_result_nearby_search_add_viapoint);
            routeCarPopup.setRightBtnBackgroundDrawable(R.drawable.nsdk_drawable_route_result_dest_pop_bg_right_blue);
            i3 = 0;
        } else {
            routeCarPopup.a("删除", context.getResources().getColor(R.color.nsdk_route_nearby_del_color));
            routeCarPopup.setRightBtnDrawable(R.drawable.nsdk_drawable_route_result_nearby_search_del_viapoint);
            routeCarPopup.setRightBtnBackgroundDrawable(R.drawable.nsdk_drawable_route_result_dest_pop_bg_right_red);
            i3 = 1;
        }
        a(context, routeCarPopup, aVar, iVar, i2, z2, i3);
        com.baidu.baidunavis.maplayer.a.h().a(aVar.b().a(), aVar.b().b(), 300);
    }

    public void a(d dVar) {
        if (dVar != null) {
            dVar.a(j.a(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_drawable_route_result_regeo_poiont), 1.0f));
        }
        this.d = dVar;
    }

    private d a(RouteCarPopup routeCarPopup, com.baidu.navisdk.poisearch.view.model.a aVar) {
        com.baidu.nplatform.comapi.basestruct.c a2 = e.k().a(new com.baidu.nplatform.comapi.basestruct.c(aVar.b().a(), aVar.b().b()));
        d dVar = new d(e.k().a(a2.c(), a2.d()), aVar.a(), "");
        dVar.a(0.5f, 1.0f);
        routeCarPopup.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        routeCarPopup.layout(0, 0, routeCarPopup.getMeasuredWidth(), routeCarPopup.getMeasuredHeight());
        routeCarPopup.buildDrawingCache();
        Bitmap drawingCache = routeCarPopup.getDrawingCache();
        dVar.a(routeCarPopup.getLeftContentSizeBundle());
        dVar.a(routeCarPopup.getRightContentSizeBundle());
        if (drawingCache == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(drawingCache);
        routeCarPopup.setDrawingCacheEnabled(false);
        dVar.a(bitmapDrawable);
        return dVar;
    }

    public void a(Context context, RouteCarPopup routeCarPopup, com.baidu.navisdk.poisearch.view.model.a aVar, i iVar, int i, boolean z, int i2) {
        b bVar = this.e;
        ArrayList<d> f = (bVar == null || !bVar.a()) ? null : f();
        d a2 = a(routeCarPopup, aVar);
        if (a2 == null) {
            return;
        }
        if (i == 1) {
            a2.a(0.5f, 0.85f);
        } else if (i == 2) {
            a2.a(0.5f, 0.7f);
        } else if (i == 3) {
            a2.a(0.5f, 0.9f);
        } else if (i == 4) {
            a2.a(1);
        } else if (i == 5) {
            a2.a(0.5f, 0.7f);
        }
        if (f == null) {
            f = new ArrayList<>();
        }
        Drawable drawable = (i2 == 0 || i2 == 1) ? context.getResources().getDrawable(R.drawable.nsdk_drawable_route_result_regeo_poiont) : null;
        f.add(a2);
        d b2 = b();
        if (b2 != null) {
            f.add(b2);
        }
        e.k().a(drawable, f, iVar, z);
    }

    private boolean a(long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = elapsedRealtime - this.c;
        if (0 < j2 && j2 < j) {
            return true;
        }
        this.c = elapsedRealtime;
        return false;
    }

    public com.baidu.navisdk.poisearch.view.model.a a() {
        return this.f7639a;
    }

    private com.baidu.nplatform.comapi.basestruct.c a(List<? extends Number> list) {
        if (list != null && list.size() >= 2) {
            return new com.baidu.nplatform.comapi.basestruct.c(list.get(0).doubleValue(), list.get(1).doubleValue());
        }
        return new com.baidu.nplatform.comapi.basestruct.c();
    }
}
