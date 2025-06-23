package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private int f6241a = 0;
    private List<a> b = new ArrayList();

    public static b a(String str) {
        b bVar = new b();
        if (TextUtils.isEmpty(str)) {
            return bVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.f6241a = jSONObject.optInt("n", 0);
            int optInt = jSONObject.optInt("enc", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray(MapBundleKey.MapObjKey.OBJ_AD);
            if (optInt == 1) {
                String optString = jSONObject.optString(MapBundleKey.MapObjKey.OBJ_AD);
                if (!TextUtils.isEmpty(optString)) {
                    String b = h.b(optString);
                    if (!TextUtils.isEmpty(b)) {
                        optJSONArray = new JSONArray(b);
                    }
                }
            }
            bVar.b = a.a(optJSONArray);
            return bVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return bVar;
        }
    }

    public List<a> a() {
        return this.b;
    }
}
