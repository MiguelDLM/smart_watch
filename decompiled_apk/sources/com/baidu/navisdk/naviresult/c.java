package com.baidu.navisdk.naviresult;

import OXOo.OOXIXo;
import XO0OX.x0XOIxOo;
import com.baidu.navisdk.comapi.trajectory.NaviTrajectory;
import com.baidu.navisdk.comapi.trajectory.NaviTrajectoryGPSData;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.common.e0;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.m;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @OOXIXo
    public static final c f7627a = new c();

    private c() {
    }

    @x0XOIxOo
    @OOXIXo
    public static final String a() {
        String a2 = e0.a(com.baidu.navisdk.framework.a.c().a()).a("ugc_fee_tmp_id", "");
        return (a2 == null || a2.length() == 0) ? b() : a2;
    }

    @x0XOIxOo
    @OOXIXo
    public static final String b() {
        String uuid = UUID.randomUUID().toString();
        e0.a(com.baidu.navisdk.framework.a.c().a()).b("ugc_fee_tmp_id", uuid);
        return uuid;
    }

    @x0XOIxOo
    public static final boolean a(int i, int i2) {
        boolean z = i == 1 || i == 3 || i == 2;
        int u = com.baidu.navisdk.framework.b.u();
        if (z) {
            return u < 1 || i2 <= u;
        }
        return false;
    }

    @x0XOIxOo
    @OOXIXo
    public static final HashMap<String, String> a(@OOXIXo String str, int i, int i2) {
        String str2;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("tmp_id", a());
        hashMap.put("cuid", a0.e());
        hashMap.put("guid", str);
        hashMap.put("classify", String.valueOf(i2));
        hashMap.put("operate", "query");
        hashMap.put("update_time", String.valueOf(System.currentTimeMillis()));
        NaviTrajectory a2 = com.baidu.navisdk.comapi.trajectory.c.c().a().a(str);
        ArrayList<NaviTrajectoryGPSData> b = com.baidu.navisdk.comapi.trajectory.c.c().a().b(str);
        String str3 = a2 != null ? a2.mDataVersion : null;
        String str4 = "";
        if (str3 != null && str3.length() != 0 && !m.a(b)) {
            if (a2 != null && (str2 = a2.mDataVersion) != null) {
                str4 = str2;
            }
            str4 = a(i, str4, b);
        }
        hashMap.put("data", str4);
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00c7  */
    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String a(int r15, @OXOo.OOXIXo java.lang.String r16, @OXOo.OOXIXo java.util.ArrayList<com.baidu.navisdk.comapi.trajectory.NaviTrajectoryGPSData> r17) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.naviresult.c.a(int, java.lang.String, java.util.ArrayList):java.lang.String");
    }

    private final JSONArray a(ArrayList<NaviTrajectoryGPSData> arrayList) {
        JSONArray jSONArray = new JSONArray();
        if (arrayList != null && !arrayList.isEmpty()) {
            HashSet hashSet = new HashSet();
            Iterator<NaviTrajectoryGPSData> it = arrayList.iterator();
            while (it.hasNext()) {
                NaviTrajectoryGPSData next = it.next();
                if (!hashSet.contains(Long.valueOf(next.mLinkId))) {
                    long j = next.mLinkId;
                    if (j > 0) {
                        hashSet.add(Long.valueOf(j));
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("ld", next.mLinkId);
                            jSONObject.put(MapBundleKey.MapObjKey.OBJ_SL_TIME, next.mGpsTime);
                        } catch (Exception e) {
                            g.TRAJECTORY.c("UgcFeeUtils", "getLinkIdJSONArray error!" + e);
                        }
                        jSONArray.put(jSONObject);
                    }
                }
            }
        }
        return jSONArray;
    }
}
