package com.baidu.navisdk.module.newguide.settings.shortcut.repository;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.function.b;
import com.baidu.navisdk.util.common.g;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes7.dex */
public class a {
    private String d() {
        String str;
        String str2;
        String str3;
        String str4;
        StringBuilder sb = new StringBuilder();
        String str5 = "";
        if (!b.FUNC_SETTING_ROUTE_SEARCH.a()) {
            str = "";
        } else {
            str = "1&";
        }
        sb.append(str);
        if (!b.FUNC_TEAM_TRIP.a()) {
            str2 = "";
        } else {
            str2 = "2&";
        }
        sb.append(str2);
        if (!b.FUNC_TRAVEL_SHARE.a()) {
            str3 = "";
        } else {
            str3 = "3&";
        }
        sb.append(str3);
        sb.append(4);
        sb.append("&");
        sb.append(5);
        sb.append("&");
        if (!b.FUNC_STAR_VOICE.a()) {
            str4 = "";
        } else {
            str4 = "6&";
        }
        sb.append(str4);
        if (b.FUNC_CAR_LOGO_SELECT.a()) {
            str5 = "7&";
        }
        sb.append(str5);
        sb.append(9);
        sb.append("&");
        return sb.toString();
    }

    public SparseArray<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> a() {
        int[] iArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        SparseArray<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> sparseArray = new SparseArray<>(9);
        for (int i = 0; i < 9; i++) {
            int i2 = iArr[i];
            com.baidu.navisdk.module.newguide.settings.shortcut.beans.a a2 = com.baidu.navisdk.module.newguide.settings.shortcut.a.a(i2);
            if (a2 != null) {
                a2.c = com.baidu.navisdk.module.newguide.settings.shortcut.a.b(i2);
                sparseArray.put(i2, a2);
            }
        }
        return sparseArray;
    }

    public ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> b() {
        String d = d();
        String proCustomShortcutFun = BNCommSettingManager.getInstance().getProCustomShortcutFun(d);
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGShortcutRepository", "getCustomFunList:" + proCustomShortcutFun);
        }
        if (!TextUtils.isEmpty(proCustomShortcutFun)) {
            d = proCustomShortcutFun;
        }
        return a(d);
    }

    public ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> c() {
        String d = d();
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGShortcutRepository", "getDefaultFunList:" + d);
        }
        return a(d);
    }

    private ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> a(String str) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGShortcutRepository", "getShortcutFunList:" + str);
        }
        if (TextUtils.isEmpty(str)) {
            return new ArrayList<>();
        }
        String[] split = str.split("&");
        if (split.length == 0) {
            if (gVar.d()) {
                gVar.e("RGShortcutRepository", "getShortcutFunList customIds.length == 0");
            }
            return new ArrayList<>();
        }
        ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> arrayList = new ArrayList<>(split.length);
        for (String str2 : split) {
            try {
                int parseInt = Integer.parseInt(str2);
                com.baidu.navisdk.module.newguide.settings.shortcut.beans.a a2 = com.baidu.navisdk.module.newguide.settings.shortcut.a.a(parseInt);
                if (a2 != null) {
                    a2.c = com.baidu.navisdk.module.newguide.settings.shortcut.a.c(parseInt);
                    arrayList.add(a2);
                }
            } catch (Exception e) {
                g gVar2 = g.PRO_NAV;
                if (gVar2.b()) {
                    gVar2.f(e.getMessage());
                }
            }
        }
        return arrayList;
    }

    public void a(ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> arrayList) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGShortcutRepository", "saveCustomFun:" + Arrays.toString(arrayList.toArray()));
        }
        String str = "";
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            String str2 = "";
            for (int i = 0; i < size; i++) {
                com.baidu.navisdk.module.newguide.settings.shortcut.beans.a aVar = arrayList.get(i);
                if (aVar != null) {
                    str2 = TextUtils.isEmpty(str2) ? aVar.f7279a + "" : str2 + "&" + aVar.f7279a;
                }
            }
            str = str2;
        }
        g gVar2 = g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e("RGShortcutRepository", "saveCustomFun:" + str);
        }
        BNCommSettingManager.getInstance().saveProCustomShortcutFun(str);
    }
}
