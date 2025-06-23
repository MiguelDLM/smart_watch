package com.baidu.platform.comapi.walknavi.segmentbrowse;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.inner.MapBound;
import com.baidu.mapapi.walknavi.model.RouteGuideKind;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.walknavi.segmentbrowse.widget.e;
import java.util.HashMap;

/* loaded from: classes8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static int f9832a = 0;
    public static int b = -1;
    public static int c = -1;
    public static int d = 99999;
    private static a f = null;
    private static int g = -1;
    public static b e = b.FIRST_GUIDANCE;
    private static HashMap<Integer, a> h = new HashMap<>();

    public static int a() {
        return b;
    }

    public static int b() {
        return g;
    }

    public static a c() {
        return h.get(Integer.valueOf(g));
    }

    public static a d() {
        return a(g, -1);
    }

    public static a e() {
        return a(g, 1);
    }

    public static double f(int i) {
        if (i <= 30 && i > 0) {
            return 1.0d;
        }
        if (i > 150 || i <= 30) {
            return i > 150 ? 2.0d : -1.0d;
        }
        return 1.5d;
    }

    public static int g() {
        return d;
    }

    public static double h() {
        a a2 = a(g, -2);
        if (a2 != null && a2.g() >= 0) {
            return f(a2.g());
        }
        return -1.0d;
    }

    public static double i() {
        a a2 = a(g, -1);
        if (a2 != null && a2.g() >= 0) {
            return f(a2.g());
        }
        return -1.0d;
    }

    public static double j() {
        if (h.get(Integer.valueOf(g)) != null && h.get(Integer.valueOf(g)).g() >= 0) {
            return f(h.get(Integer.valueOf(g)).g());
        }
        return -1.0d;
    }

    public static double k() {
        a a2 = a(g, 1);
        if (a2 != null && a2.g() >= 0) {
            return f(a2.g());
        }
        return -1.0d;
    }

    public static int l() {
        if (h() == -1.0d) {
            return -1;
        }
        return (int) (h() * f9832a);
    }

    public static int m() {
        if (i() == -1.0d) {
            return -1;
        }
        return (int) (i() * f9832a);
    }

    public static int n() {
        if (j() == -1.0d) {
            return -1;
        }
        return (int) (j() * f9832a);
    }

    public static int o() {
        if (k() == -1.0d) {
            return -1;
        }
        return (int) (k() * f9832a);
    }

    public static double p() {
        return 0.7d;
    }

    public static int q() {
        a c2 = c();
        if (c2 != null && c2.g() >= 0) {
            double g2 = c2.g();
            return n() - ((int) ((((g2 - a()) / g2) * (j() - p())) * f9832a));
        }
        return -1;
    }

    public static void r() {
        g = -1;
        c = -1;
        d = 99999;
        e = b.FIRST_GUIDANCE;
        b = -1;
        HashMap<Integer, a> hashMap = h;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public static b s() {
        return e;
    }

    public static void a(int i) {
        b = i;
    }

    public static void b(int i) {
        g = i;
        c(i);
        e();
        d();
    }

    public static void c(int i) {
        if (c != -1 || i == -1) {
            return;
        }
        c = i;
    }

    public static void d(int i) {
        if (d != 99999 || i == -1) {
            return;
        }
        d = i;
    }

    public static a e(int i) {
        HashMap<Integer, a> hashMap = h;
        if (hashMap == null || hashMap.size() < 1 || !h.containsKey(Integer.valueOf(i))) {
            return null;
        }
        com.baidu.platform.comapi.wnplatform.d.a.a("route hashmap", h.toString());
        return h.get(Integer.valueOf(i));
    }

    public static int f() {
        return c;
    }

    public static void g(int i) {
        int b2 = com.baidu.platform.comapi.wnplatform.p.b.b.a().b();
        int c2 = com.baidu.platform.comapi.wnplatform.p.b.b.a().c();
        int q = com.baidu.platform.comapi.walknavi.b.a().Y().q();
        MapBound h2 = com.baidu.platform.comapi.walknavi.b.a().h(i);
        MapStatus h3 = com.baidu.platform.comapi.walknavi.b.a().N().h();
        if (h3 != null) {
            MapStatus.Builder builder = new MapStatus.Builder(h3);
            builder.rotate(0.0f);
            builder.overlook(0.0f);
            if (h2 != null) {
                float a2 = com.baidu.platform.comapi.walknavi.b.a().N().a(h2, b2, c2 - (q * 2));
                builder.target(CoordUtil.mc2ll(new GeoPoint((h2.getPtLB().getIntY() + h2.getPtRT().getIntY()) / 2, (h2.getPtLB().getIntX() + h2.getPtRT().getIntX()) / 2)));
                builder.zoom(a2);
                com.baidu.platform.comapi.wnplatform.d.a.b("setMapHighLightByUid: height:" + c2);
                com.baidu.platform.comapi.wnplatform.d.a.b("setMapHighLightByUid: topUIHeight:" + q);
                com.baidu.platform.comapi.wnplatform.d.a.b("setMapHighLightByUid: width:" + b2);
                com.baidu.platform.comapi.wnplatform.d.a.b("setMapHighLightByUid: level:" + a2);
            }
            com.baidu.platform.comapi.walknavi.b.a().N().a(builder.build(), 500);
        }
        com.baidu.platform.comapi.walknavi.b.a().K().f(i);
    }

    public static void a(a aVar) {
        f = aVar;
        HashMap<Integer, a> hashMap = h;
        if (hashMap != null) {
            hashMap.put(Integer.valueOf(b()), aVar);
        }
        e();
        d();
    }

    public static int a(Context context) {
        Paint paint = new Paint();
        paint.setTextSize(com.baidu.platform.comapi.walknavi.segmentbrowse.widget.b.a(context, 17.0f));
        int measureText = (int) paint.measureText("任");
        double d2 = (f9832a * 0.7d) / measureText;
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "singleCharwidth:" + measureText);
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "num:" + d2);
        return (int) d2;
    }

    public static a a(int i, int i2) {
        HashMap<Integer, a> hashMap = h;
        if (hashMap != null) {
            int i3 = i + i2;
            if (hashMap.containsKey(Integer.valueOf(i3))) {
                return h.get(Integer.valueOf(i3));
            }
        }
        a aVar = new a();
        Bundle bundle = new Bundle();
        com.baidu.platform.comapi.wnplatform.d.a.a("uid******offset", "uid**" + i + TypedValues.CycleType.S_WAVE_OFFSET + i2);
        com.baidu.platform.comapi.walknavi.b.a().K().a(i, i2, bundle);
        if (!bundle.containsKey("uid")) {
            return null;
        }
        aVar.f(bundle.getInt("uid"));
        aVar.c(e.a(bundle, "seg"));
        aVar.b(bundle.getString("usGuideText"));
        aVar.a(e.a(bundle, false));
        aVar.b(e.a(bundle));
        int i4 = bundle.getInt("nParagraphLength");
        if (bundle.containsKey("maneuverKind")) {
            String a2 = com.baidu.platform.comapi.wnplatform.i.c.a(RouteGuideKind.values()[bundle.getInt("maneuverKind")]);
            if (i4 == 0 && a2.equals("wn_dest.png")) {
                aVar.e(20);
                d(bundle.getInt("uid"));
            } else {
                aVar.e(i4);
            }
            aVar.a(a2);
        }
        com.baidu.platform.comapi.wnplatform.d.a.a("getRouteMessageModelByUid", "wroutemessagemodel" + aVar.toString());
        h.put(Integer.valueOf(i + i2), aVar);
        return aVar;
    }

    public static void a(b bVar) {
        e = bVar;
    }
}
