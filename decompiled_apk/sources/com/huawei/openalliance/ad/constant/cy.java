package com.huawei.openalliance.ad.constant;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.ed;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.beans.metadata.TrustAppList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes10.dex */
public class cy {
    private static final String B = "com.huawei.fastapp.dev";
    private static final String[] C;
    private static final String Code = "WhiteListPkgList";
    private static final String D = "com.huawei.browser";
    private static final String[] F;
    private static final String[] I;
    private static final String[] L;
    private static final String S = "com.hihonor.fastapp";
    private static final String V = "com.huawei.appmarket";
    private static final String Z = "com.huawei.fastapp";

    /* renamed from: a, reason: collision with root package name */
    private static final String f17378a = "com.hicloud.browser";
    private static final String[] b;
    private static final String c = "com.android.browser";
    private static final String[] d;
    private static final String e = "com.hihonor.browser";
    private static final String[] f;
    private static final Map<String, List<String>> g;
    private static final String h = "com.petal.litegames";
    private static final List<String> i;
    private static final String[] j;

    static {
        String[] strArr = {"ffe391e0ea186d0734ed601e4e70e3224b7309d48e2075bac46d8c667eae7212", "3baf59a2e5331c30675fab35ff5fff0d116142d3d4664f1c3cb804068b40614f", "a9436644e0bd71ff512c63839f8ac27114399f36956958688555dfcc63257ede"};
        I = strArr;
        String[] strArr2 = {"b92825c2bd5d6d6d1e7f39eecd17843b7d9016f611136b75441bc6f4d3f00f05", "59321357AB0A6BACBE3D32665B0084DCBB709B1D234EC684431AAEC5A0F0B8B1"};
        C = strArr2;
        String[] strArr3 = {x.be};
        F = strArr3;
        String[] strArr4 = {x.bg};
        L = strArr4;
        String[] strArr5 = {x.bi};
        b = strArr5;
        String[] strArr6 = {"bbe2ff269828a0d922498ee87f65afe769c27d62f489d5c19b9cc6c444c80811", "d8a4db56b7ebc39fe5f3004215f0e0decb43b9cfcbe9b2d948383fedd434e7d9", x.bg};
        d = strArr6;
        String[] strArr7 = {"22dcb04cfaa28f382b613794eba4441a8bcb1dbc8576776f1b1e6a457b00d449"};
        f = strArr7;
        HashMap hashMap = new HashMap();
        g = hashMap;
        i = Arrays.asList("com.taobao.taobao");
        String[] strArr8 = {"A9436644E0BD71FF512C63839F8AC27114399F36956958688555DFCC63257EDE"};
        j = strArr8;
        hashMap.put(e, Arrays.asList(strArr7));
        hashMap.put("com.android.browser", Arrays.asList(strArr6));
        hashMap.put("com.huawei.browser", Arrays.asList(strArr4));
        hashMap.put("com.huawei.appmarket", Arrays.asList(strArr));
        hashMap.put("com.huawei.hwid", Arrays.asList("b92825c2bd5d6d6d1e7f39eecd17843b7d9016f611136b75441bc6f4d3f00f05"));
        hashMap.put("com.huawei.hwid.tv", Arrays.asList("3517262215d8d3008cbf888750b6418edc4d562ac33ed6874e0d73aba667bc3c"));
        hashMap.put("com.huawei.hms", Arrays.asList("e49d5c2c0e11b3b1b96ca56c6de2a14ec7dab5ccc3b5f300d03e5b4dba44f539"));
        hashMap.put("com.huawei.fastapp", Arrays.asList(strArr2));
        hashMap.put("com.huawei.fastapp.dev", Arrays.asList(strArr2));
        hashMap.put("com.hihonor.fastapp", Arrays.asList(strArr3));
        hashMap.put("com.hicloud.browser", Arrays.asList(strArr5));
        hashMap.put(h, Arrays.asList(strArr8));
    }

    public static boolean Code(Context context, String str, String str2) {
        boolean Code2 = Code(str, str2);
        return !Code2 ? V(context, str, str2) : Code2;
    }

    private static boolean V(Context context, String str, String str2) {
        String str3;
        String Code2 = ed.Code(context).Code();
        if (TextUtils.isEmpty(Code2)) {
            str3 = "inTrustAppList trustAppList is empty";
        } else {
            TrustAppList trustAppList = (TrustAppList) com.huawei.openalliance.ad.utils.aa.V(Code2, TrustAppList.class, new Class[0]);
            if (trustAppList == null) {
                str3 = "inTrustAppList toObjectNoException is null";
            } else {
                Map<String, List<String>> Code3 = trustAppList.Code();
                if (Code3 == null) {
                    str3 = "inTrustAppList map is null";
                } else {
                    List<String> list = Code3.get(str);
                    if (list != null) {
                        return Code(list, str2);
                    }
                    str3 = "inTrustAppList signList is null";
                }
            }
        }
        fb.V(Code, str3);
        return false;
    }

    public static boolean Code(String str) {
        return e.equalsIgnoreCase(str) || "com.huawei.browser".equalsIgnoreCase(str) || "com.hicloud.browser".equalsIgnoreCase(str) || "com.android.browser".equalsIgnoreCase(str);
    }

    public static boolean V(String str) {
        if (str == null) {
            return false;
        }
        return i.contains(str);
    }

    public static boolean Code(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return Code(g.get(str), str2);
        }
        fb.Z(Code, "inWhiteList invalid input");
        return false;
    }

    private static boolean Code(List<String> list, String str) {
        if (list == null) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.equalsIgnoreCase(it.next())) {
                return true;
            }
        }
        return false;
    }
}
