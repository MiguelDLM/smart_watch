package com.baidu.mshield.x0.b;

import android.content.Context;
import com.huawei.openalliance.ad.constant.x;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public final class f implements com.baidu.mshield.x0.c.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f6407a;

    public f(Context context) {
        this.f6407a = context;
    }

    @Override // com.baidu.mshield.x0.c.b
    public boolean a() {
        return true;
    }

    @Override // com.baidu.mshield.x0.c.b
    public void a(String str) {
        try {
            if (str.contains("mshield")) {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", "mshield");
                jSONObject.put("1", str.replaceAll("\t", x.aL).replaceAll("\n", x.aL));
                jSONArray.put(jSONObject);
                d.a(this.f6407a, new c(), jSONArray, "1003138");
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }
}
