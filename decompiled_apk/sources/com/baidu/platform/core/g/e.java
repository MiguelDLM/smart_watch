package com.baidu.platform.core.g;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.share.RouteShareURLOption;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.platform.comapi.basestruct.Point;
import com.szabh.smable3.entity.Languages;

/* loaded from: classes8.dex */
public class e extends com.baidu.platform.base.e {
    public e(RouteShareURLOption routeShareURLOption) {
        a(routeShareURLOption);
    }

    private void a(RouteShareURLOption routeShareURLOption) {
        String str;
        String str2;
        com.baidu.platform.util.a aVar = new com.baidu.platform.util.a();
        Point ll2point = CoordUtil.ll2point(routeShareURLOption.mFrom.getLocation());
        Point ll2point2 = CoordUtil.ll2point(routeShareURLOption.mTo.getLocation());
        String str3 = "2$$$$$$";
        if (ll2point == null) {
            str = "2$$$$$$";
        } else {
            str = "1$$$$" + ll2point.x + "," + ll2point.y + "$$";
        }
        String name = routeShareURLOption.mFrom.getName();
        String str4 = "";
        if (name == null || name.equals("")) {
            name = "起点";
        }
        String str5 = str + name + "$$0$$$$";
        if (ll2point2 != null) {
            str3 = "1$$$$" + ll2point2.x + "," + ll2point2.y + "$$";
        }
        String name2 = routeShareURLOption.mTo.getName();
        if (name2 == null || name2.equals("")) {
            name2 = "终点";
        }
        String str6 = str3 + name2 + "$$0$$$$";
        int ordinal = routeShareURLOption.mMode.ordinal();
        if (ordinal == 0) {
            aVar.a("sc", a(routeShareURLOption.mFrom.getCity()) + "");
            aVar.a("ec", a(routeShareURLOption.mTo.getCity()) + "");
            str4 = "&sharecallbackflag=carRoute";
            str2 = "nav";
        } else if (ordinal == 1) {
            aVar.a("sc", a(routeShareURLOption.mFrom.getCity()) + "");
            aVar.a("ec", a(routeShareURLOption.mTo.getCity()) + "");
            str4 = "&sharecallbackflag=footRoute";
            str2 = "walk";
        } else if (ordinal == 2) {
            aVar.a("sc", a(routeShareURLOption.mFrom.getCity()) + "");
            aVar.a("ec", a(routeShareURLOption.mTo.getCity()) + "");
            str4 = "&sharecallbackflag=cycleRoute";
            str2 = "cycle";
        } else if (ordinal != 3) {
            str2 = "";
        } else {
            String str7 = "&i=" + routeShareURLOption.mPn + ",1,1&sharecallbackflag=busRoute";
            aVar.a("c", routeShareURLOption.mCityCode + "");
            str2 = "bt";
            str4 = str7;
        }
        aVar.a("sn", str5);
        aVar.a(Languages.DEFAULT_LANGUAGE, str6);
        this.f9530a.a("url", "https://map.baidu.com/?newmap=1&s=" + str2 + (AppMD5.encodeUrlParamsValue("&" + aVar.a() + ("&start=" + name + "&end=" + name2)) + str4));
        this.f9530a.a(TypedValues.TransitionType.S_FROM, "android_map_sdk");
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.r();
    }

    private int a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }
}
