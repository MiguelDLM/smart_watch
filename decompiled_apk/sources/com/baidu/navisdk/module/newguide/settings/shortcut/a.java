package com.baidu.navisdk.module.newguide.settings.shortcut;

import androidx.annotation.DrawableRes;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes7.dex */
public final class a {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static com.baidu.navisdk.module.newguide.settings.shortcut.beans.a a(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("createShortcutBaseData:" + i);
        }
        com.baidu.navisdk.module.newguide.settings.shortcut.beans.a aVar = new com.baidu.navisdk.module.newguide.settings.shortcut.beans.a();
        aVar.f7279a = i;
        if (i != 100) {
            switch (i) {
                case 1:
                    aVar.b = "沿途搜索";
                    if (com.baidu.navisdk.function.b.FUNC_NEARBY_SEARCH.a()) {
                        return aVar;
                    }
                    break;
                case 2:
                    aVar.b = "组队出行";
                    if (com.baidu.navisdk.function.b.FUNC_TEAM_TRIP.a()) {
                        return aVar;
                    }
                    break;
                case 3:
                    aVar.b = "分享位置";
                    if (com.baidu.navisdk.function.b.FUNC_TRAVEL_SHARE.a()) {
                        return aVar;
                    }
                    break;
                case 4:
                    aVar.b = "问题上报";
                    if (com.baidu.navisdk.function.b.FUNC_UGC.a()) {
                        return aVar;
                    }
                    break;
                case 5:
                    aVar.b = "自定义导航";
                    if (com.baidu.navisdk.function.b.FUNC_NAVI_DIY.a()) {
                        return aVar;
                    }
                    break;
                case 6:
                    aVar.b = "个性语音包";
                    if (com.baidu.navisdk.function.b.FUNC_CUSTOM_VOICE.a()) {
                        return aVar;
                    }
                    break;
                case 7:
                    aVar.b = "个性车标";
                    if (com.baidu.navisdk.function.b.FUNC_CAR_LOGO_SELECT.a()) {
                        return aVar;
                    }
                    break;
                case 8:
                    aVar.b = "车辆管理";
                    if (com.baidu.navisdk.function.b.FUNC_CAR_MANAGE.a()) {
                        return aVar;
                    }
                    break;
                case 9:
                    aVar.b = JarUtils.getResources().getString(R.string.nsdk_ar_navi);
                    return aVar;
            }
        } else {
            aVar.b = "更多功能";
            if (com.baidu.navisdk.function.b.FUNC_NAVI_MORESTE.a()) {
                return aVar;
            }
        }
        return null;
    }

    @DrawableRes
    public static int b(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("getAllShortcutIcon:" + i);
        }
        switch (i) {
            case 1:
                return R.drawable.bn_shortcut_ic_route_search;
            case 2:
                return R.drawable.bn_shortcut_ic_location_share;
            case 3:
                return R.drawable.bn_shortcut_ic_trip_share;
            case 4:
                return R.drawable.bn_shortcut_ic_ugc_report;
            case 5:
                return R.drawable.bn_shortcut_ic_custom_navi;
            case 6:
                return R.drawable.bn_shortcut_ic_guide_voice;
            case 7:
                return R.drawable.bn_shortcut_ic_car_logo;
            case 8:
                return R.drawable.bn_shortcut_ic_car_manager;
            case 9:
                return R.drawable.bn_shortcut_ic_ar;
            default:
                return 0;
        }
    }

    @DrawableRes
    public static int c(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("getCustomShortcutIcon:" + i);
        }
        if (i != 100) {
            switch (i) {
                case 1:
                    return R.drawable.bn_ic_short_fun_route_search;
                case 2:
                    return R.drawable.bn_ic_short_fun_location_share;
                case 3:
                    return R.drawable.bn_ic_short_fun_trip_share;
                case 4:
                    return R.drawable.bn_ic_short_fun_ugc_report;
                case 5:
                    return R.drawable.bn_ic_short_fun_custom_navi;
                case 6:
                    return R.drawable.bn_ic_short_fun_guide_voice;
                case 7:
                    return R.drawable.bn_ic_short_fun_car_logo;
                case 8:
                    return R.drawable.bn_ic_short_fun_car_manager;
                case 9:
                    return R.drawable.bn_ic_short_fun_ar;
                default:
                    return 0;
            }
        }
        return R.drawable.bn_ic_short_fun_more;
    }
}
