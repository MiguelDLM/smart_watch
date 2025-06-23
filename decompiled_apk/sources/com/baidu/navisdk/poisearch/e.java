package com.baidu.navisdk.poisearch;

import android.text.TextUtils;
import com.baidu.navisdk.adapter.IBNRouteResultManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.e0;
import com.realsil.sdk.dfu.utils.DfuAdapter;
import com.szabh.smable3.entity.BleNewsFeed;
import com.tencent.connect.common.II0xO0;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<String, ArrayList<String>> f7635a;
    private static final HashMap<String, String> b;
    private static int c;
    private static int d;
    private static int e;

    static {
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        f7635a = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        b = hashMap2;
        c = 1;
        d = 1;
        e = 1;
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("特斯拉");
        arrayList.add("国家电网");
        arrayList.add("特来电");
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("中国石油");
        arrayList2.add("中国石化");
        ArrayList<String> arrayList3 = new ArrayList<>();
        arrayList3.add("工商银行");
        arrayList3.add("建设银行");
        arrayList3.add("农业银行");
        arrayList3.add("中国银行");
        hashMap.put(IBNRouteResultManager.NearbySearchKeyword.Charging_Station, arrayList);
        hashMap.put(IBNRouteResultManager.NearbySearchKeyword.Gas_Station, arrayList2);
        hashMap.put(IBNRouteResultManager.NearbySearchKeyword.Bank, arrayList3);
        hashMap2.put("特斯拉", "特斯拉");
        hashMap2.put("国家电网", "国家电网");
        hashMap2.put("特来电", "特来电");
        hashMap2.put("中石油", "中国石油");
        hashMap2.put("中石化", "中国石化");
        hashMap2.put("工商银行", "工商银行");
        hashMap2.put("建设银行", "建设银行");
        hashMap2.put("农业银行", "农业银行");
        hashMap2.put("中国银行", "中国银行");
    }

    public static String a(String str) {
        return TextUtils.isEmpty(str) ? "" : str.equals("中国石油") ? "10" : str.equals("中国石化") ? "11" : str.equals("特斯拉") ? "20" : str.equals("国家电网") ? "21" : str.equals("特来电") ? II0xO0.f26892xOOxIO : str.equals("工商银行") ? "30" : str.equals("建设银行") ? "31" : str.equals("农业银行") ? "32" : str.equals("中国银行") ? "33" : "";
    }

    public static ArrayList<String> b(String str) {
        HashMap<String, ArrayList<String>> hashMap = f7635a;
        if (hashMap.containsKey(str)) {
            return hashMap.get(str);
        }
        return null;
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.equals(IBNRouteResultManager.NearbySearchKeyword.Gas_Station)) {
            return "1";
        }
        if (str.equals(IBNRouteResultManager.NearbySearchKeyword.Park)) {
            return "2";
        }
        if (str.equals(IBNRouteResultManager.NearbySearchKeyword.Toilet)) {
            return "3";
        }
        if (!str.equals(IBNRouteResultManager.NearbySearchKeyword.Restaurant) && !str.equals("餐饮美食")) {
            if (str.equals(IBNRouteResultManager.NearbySearchKeyword.Bank)) {
                return "6";
            }
            if (!str.equals(IBNRouteResultManager.NearbySearchKeyword.Hotel) && !str.equals("酒店住宿")) {
                if (str.equals(IBNRouteResultManager.NearbySearchKeyword.Charging_Station)) {
                    return "7";
                }
                if (!str.equals(IBNRouteResultManager.NearbySearchKeyword.Spots) && !str.equals("旅游景点")) {
                    if (!str.equals("其它")) {
                        return "";
                    }
                    return "0";
                }
                return "8";
            }
            return "5";
        }
        return "4";
    }

    public static int d(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.equalsIgnoreCase("中国石化")) {
            return 460;
        }
        if (str.equalsIgnoreCase("中国石油")) {
            return BleNewsFeed.CONTENT_MAX_LENGTH;
        }
        if (str.equalsIgnoreCase("建设银行")) {
            return 480;
        }
        if (str.equalsIgnoreCase("中国银行")) {
            return 492;
        }
        if (str.equalsIgnoreCase("农业银行")) {
            return DfuAdapter.STATE_PREPARE_PAIRING_REQUEST;
        }
        if (!str.equalsIgnoreCase("工商银行")) {
            return 0;
        }
        return 649;
    }

    public static int e(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (str.equalsIgnoreCase(IBNRouteResultManager.NearbySearchKeyword.Spots)) {
            return 4;
        }
        if (str.equalsIgnoreCase(IBNRouteResultManager.NearbySearchKeyword.Hotel)) {
            return 5;
        }
        if (str.equalsIgnoreCase(IBNRouteResultManager.NearbySearchKeyword.Gas_Station)) {
            return 0;
        }
        if (str.equalsIgnoreCase(IBNRouteResultManager.NearbySearchKeyword.Restaurant)) {
            return 6;
        }
        if (str.equalsIgnoreCase(IBNRouteResultManager.NearbySearchKeyword.Bank)) {
            return 7;
        }
        if (str.equalsIgnoreCase(IBNRouteResultManager.NearbySearchKeyword.Charging_Station)) {
            return 8;
        }
        if (str.equalsIgnoreCase(IBNRouteResultManager.NearbySearchKeyword.Toilet)) {
            return 1;
        }
        if (str.equalsIgnoreCase(IBNRouteResultManager.NearbySearchKeyword.Service)) {
            return 3;
        }
        if (!str.equalsIgnoreCase(IBNRouteResultManager.NearbySearchKeyword.Park)) {
            return -1;
        }
        return 2;
    }

    public static boolean f(String str) {
        return f7635a.containsKey(str);
    }

    public static boolean g(String str) {
        if (str.equals(IBNRouteResultManager.NearbySearchKeyword.Bank) && e == 1) {
            return true;
        }
        if (str.equals(IBNRouteResultManager.NearbySearchKeyword.Charging_Station) && d == 1) {
            return true;
        }
        if (str.equals(IBNRouteResultManager.NearbySearchKeyword.Gas_Station) && c == 1) {
            return true;
        }
        return false;
    }

    public static String h(String str) {
        HashMap<String, String> hashMap = b;
        if (hashMap.containsKey(str)) {
            return hashMap.get(str);
        }
        return str;
    }

    public static void a(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("alongroute_search");
        if (optJSONObject != null) {
            c = optJSONObject.optInt("gas_station", 1);
            d = optJSONObject.optInt("charge_station", 1);
            e = optJSONObject.optInt("atm", 1);
            LogUtil.e("PoiSearchModel", "cloud_control: gas_station = " + c + ", charge_station = " + d + ", atm = " + e);
        }
        if (com.baidu.navisdk.framework.a.c().a() == null) {
            return;
        }
        if (c == 0) {
            e0.a(com.baidu.navisdk.framework.a.c().a()).b(IBNRouteResultManager.NearbySearchKeyword.Gas_Station, "");
        }
        if (d == 0) {
            e0.a(com.baidu.navisdk.framework.a.c().a()).b(IBNRouteResultManager.NearbySearchKeyword.Charging_Station, "");
        }
        if (e == 0) {
            e0.a(com.baidu.navisdk.framework.a.c().a()).b(IBNRouteResultManager.NearbySearchKeyword.Bank, "");
        }
    }
}
