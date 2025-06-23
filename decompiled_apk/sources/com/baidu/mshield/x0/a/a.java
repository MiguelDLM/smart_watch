package com.baidu.mshield.x0.a;

import android.content.Context;
import android.text.TextUtils;
import java.util.Timer;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class a extends c {

    /* renamed from: a, reason: collision with root package name */
    public static String f6395a = "";

    public static void a(Context context) {
        JSONObject optJSONObject;
        try {
            com.baidu.mshield.x0.j.a aVar = new com.baidu.mshield.x0.j.a(context);
            String a2 = aVar.a("plc114");
            com.baidu.mshield.b.c.a.b("handleNativeCollect: policy=" + a2);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(a2);
            boolean z = false;
            if (jSONObject.optInt("1", 0) == 1) {
                z = true;
            }
            com.baidu.mshield.b.c.a.b("handleNativeCollect: sw=" + z);
            if (z && (optJSONObject = jSONObject.optJSONObject("5").optJSONObject("uv6")) != null) {
                com.baidu.mshield.b.c.a.b("detect app encrypt===" + f6395a);
                int optInt = optJSONObject.optInt("3", 10);
                if (!TextUtils.isEmpty(f6395a)) {
                    new Timer().schedule(new b(optJSONObject, context, aVar), optInt * 1000);
                }
            }
        } catch (Throwable th) {
            com.baidu.mshield.x0.b.d.a(th);
        }
    }
}
