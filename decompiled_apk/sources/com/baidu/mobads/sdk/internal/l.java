package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.CpuChannelResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private int f6331a;
    private String b;

    public static List<CpuChannelResponse> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    l a2 = a(jSONArray.getJSONObject(i));
                    if (a2 != null) {
                        arrayList.add(new CpuChannelResponse(a2));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public String b() {
        return this.b;
    }

    private static l a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int optInt = jSONObject.optInt("id", -1);
        String optString = jSONObject.optString("name", "");
        if (optInt == -1 || TextUtils.isEmpty(optString)) {
            return null;
        }
        l lVar = new l();
        lVar.f6331a = optInt;
        lVar.b = optString;
        return lVar;
    }

    public int a() {
        return this.f6331a;
    }
}
