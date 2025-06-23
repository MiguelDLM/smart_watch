package com.baidu.navisdk.b4nav.utils;

import android.app.Activity;
import androidx.annotation.RequiresApi;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes7.dex */
public class a {
    public static String a(int i) {
        g gVar = g.B4NAV;
        if (!gVar.e() && !gVar.b()) {
            return null;
        }
        if (i == 1020) {
            return "MSG_NAVI_NAME_SEARCH_FOR_PB_SUCCESS";
        }
        if (i == 1031) {
            return "MSG_NAVI_DIMISS_LOADDING";
        }
        if (i == 3010) {
            return "MSG_NAVI_DRIVING_CAR_POINT";
        }
        if (i == 3030) {
            return "MSG_NAVI_RP_IPO_SUCCESS_NORMAL";
        }
        if (i == 3040) {
            return "MSG_NAVI_DRIVING_CAR_ARRIVE_DEST";
        }
        if (i == 3050) {
            return "MSG_NAVI_DRIVING_CAR_SELECT_ROUTE_SUCCESS";
        }
        if (i == 3060) {
            return "MSG_NAVI_RP_IPO_FAIL_NORMAL";
        }
        if (i == 4007) {
            return "MSG_NAVI_PARSE_ROUTE_RESULT_YAWING_PB_SUCCESS";
        }
        if (i == 4008) {
            return "MSG_NAVI_PARSE_ROUTE_RESULT_YAWING_PB_FAILED";
        }
        if (i == 4011) {
            return "MSG_NAVI_PARSE_POILIST_PB_SUCCESS";
        }
        if (i == 4012) {
            return "MSG_NAVI_PARSE_POILIST_PB_FAILED";
        }
        if (i == 4014) {
            return "MSG_NAVI_PARSE_WEATHER_PB_SUCCESS";
        }
        if (i == 4015) {
            return "MSG_NAVI_PARSE_WEATHER_PB_FAILED";
        }
        switch (i) {
            case 1000:
                return "MSG_NAVI_ROUTE_PLAN_START";
            case 1001:
                return "MSG_NAVI_ROUTE_PLAN_CANCELED";
            case 1002:
                return "MSG_NAVI_ROUTE_PLAN_SUCCESS";
            case 1003:
                return "MSG_NAVI_ROUTE_PLAN_FAILED";
            case 1004:
                return "MSG_NAVI_ROUTE_PLAN_BUILD_SUCCESS";
            case 1005:
                return "MSG_NAVI_ROUTE_PLAN_BUILD_FAILED";
            default:
                switch (i) {
                    case 1012:
                        return "MSG_NAVI_SHOW_UGC_BUTTON";
                    case 1013:
                        return "MSG_NAVI_START_YAWING";
                    case 1014:
                        return "MSG_NAVI_ROUTE_RESULT_YAWING_SUCCESS";
                    case 1015:
                        return "MSG_NAVI_ROUTE_RESULT_YAWING_FAILED";
                    default:
                        switch (i) {
                            case 1051:
                                return "MSG_NAVI_RC_PREDICTION";
                            case 1052:
                                return "MSG_NAVI_WEATHER_UPDATE_SUCCESS";
                            case 1053:
                                return "MSG_NAVI_WEATHER_UPDATE_FAILED";
                            default:
                                switch (i) {
                                    case 4001:
                                        return "MSG_NAVI_PARSE_RP_NORMAL_PB_SUCCESS";
                                    case 4002:
                                        return "MSG_NAVI_PARSE_RP_NORMAL_PB_FAILED";
                                    case 4003:
                                        return "MSG_NAVI_PARSE_RP_BUILD_PB_SUCCESS";
                                    case 4004:
                                        return "MSG_NAVI_PARSE_RP_BUILD_PB_FAILED";
                                    default:
                                        return String.valueOf(i);
                                }
                        }
                }
        }
    }

    @RequiresApi(api = 23)
    public static boolean a(Activity activity) {
        int checkSelfPermission;
        if (activity == null) {
            return false;
        }
        checkSelfPermission = activity.checkSelfPermission(com.kuaishou.weapon.p0.g.g);
        return checkSelfPermission == 0;
    }
}
