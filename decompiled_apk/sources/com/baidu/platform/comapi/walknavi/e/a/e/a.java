package com.baidu.platform.comapi.walknavi.e.a.e;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.ar.constants.ARConfigKey;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.platform.comapi.walknavi.e.a.f.d;
import com.baidu.platform.comapi.walknavi.e.a.g.b;
import com.baidu.platform.comapi.walknavi.e.a.g.e;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static a f9733a;
    private d b;
    private com.baidu.platform.comapi.walknavi.e.a.a.a c;
    private String d;
    private Context e;

    private a() {
    }

    public static a a() {
        if (f9733a == null) {
            synchronized (a.class) {
                try {
                    if (f9733a == null) {
                        f9733a = new a();
                    }
                } finally {
                }
            }
        }
        return f9733a;
    }

    public void b() {
        d dVar = this.b;
        if (dVar != null && !dVar.isCancelled()) {
            this.b.cancel(true);
            this.b = null;
        }
        if (f9733a != null) {
            f9733a = null;
        }
        this.d = null;
    }

    public void a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_id", str);
        hashMap.put("request_id", this.d);
        com.baidu.platform.comapi.walknavi.e.a.a.a aVar = this.c;
        if (aVar != null) {
            hashMap.put("ar_type", String.valueOf(aVar.c()));
        }
        com.baidu.platform.comapi.walknavi.e.a.g.a.a("params is : " + hashMap.toString());
        Context context = this.e;
        if (context != null) {
            a(context, hashMap);
        }
    }

    private void a(Context context, Map<String, String> map) {
        String str = com.baidu.platform.comapi.walknavi.e.a.g.d.f9738a + com.baidu.platform.comapi.walknavi.e.a.g.d.c + "/count_ar";
        String uuid = new e(context).a().toString();
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            com.baidu.platform.comapi.walknavi.e.a.a.a aVar = this.c;
            if (aVar != null) {
                if (!TextUtils.isEmpty(aVar.a())) {
                    jSONObject.put("ar_key", this.c.a());
                }
                jSONObject.put(ARConfigKey.AR_ID, this.c.b());
            }
            com.baidu.platform.comapi.walknavi.e.a.f.e.a(context, jSONObject);
            jSONObject.put("time", String.valueOf(Long.valueOf(System.currentTimeMillis())));
            jSONObject.put(HttpConstants.HTTP_OS_TYPE, "android");
            jSONObject.put(HttpConstants.OS_VERSION, Build.MODEL);
            jSONObject.put(HttpConstants.DEVICE_TYPE, Build.BRAND);
            jSONObject.put("device_id", uuid);
            int i = Build.VERSION.SDK_INT;
            jSONObject.put(HttpConstants.OS_VERSION, i);
            jSONObject.put(HttpConstants.APP_VERSION, b.a());
            jSONObject.put(HttpConstants.HTTP_ENGINE_VERSION, b.a());
            if (!TextUtils.isEmpty(b.a(context))) {
                jSONObject.put("app_id", b.a(context));
            }
            jSONObject.put(HttpConstants.HTTP_SYSTEM_VERSION, i);
        } catch (Exception unused) {
        }
        d dVar = new d(str, null);
        this.b = dVar;
        dVar.execute(jSONObject.toString());
    }
}
