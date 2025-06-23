package com.baidu.mshield.x0.a;

import android.content.Context;
import android.text.TextUtils;
import java.util.Timer;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class d extends c {

    /* renamed from: a, reason: collision with root package name */
    public static String f6397a;
    public static String b;

    public static void a(Context context) {
        try {
            com.baidu.mshield.x0.j.a aVar = new com.baidu.mshield.x0.j.a(context);
            String a2 = aVar.a("plc115");
            com.baidu.mshield.b.c.a.b("handleCollectRoutine: policy=" + a2);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(a2);
            boolean z = true;
            if (jSONObject.optInt("1", 0) != 1) {
                z = false;
            }
            com.baidu.mshield.b.c.a.b("handleCollectRoutine: sw=" + z);
            if (z) {
                if (System.currentTimeMillis() - aVar.l() < jSONObject.optInt("3", 24) * 3600000) {
                    com.baidu.mshield.b.c.a.b("handleCollectRoutine not time");
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("5").optJSONObject("uv4");
                if (optJSONObject != null) {
                    int optInt = optJSONObject.optInt("3", 10);
                    if ((optJSONObject.has("7") ? optJSONObject.optJSONObject("7").optInt("2", 0) : 0) == 0) {
                        b = f6397a;
                    } else {
                        b = optJSONObject.optString("2");
                    }
                    if (TextUtils.isEmpty(b)) {
                        return;
                    }
                    new Timer().schedule(new e(optJSONObject, context), optInt * 1000);
                }
            }
        } catch (Throwable th) {
            com.baidu.mshield.x0.b.d.a(th);
        }
    }
}
