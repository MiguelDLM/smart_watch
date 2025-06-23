package com.baidu.navisdk.module.navisafeguard;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.common.z;
import com.baidu.navisdk.util.http.center.f;
import com.baidu.navisdk.util.http.center.i;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private boolean f7207a = false;

    /* loaded from: classes7.dex */
    public interface b {
        void a(boolean z);
    }

    /* loaded from: classes7.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public static final a f7209a = new a();
    }

    public static a c() {
        return c.f7209a;
    }

    public void b() {
        this.f7207a = false;
    }

    public boolean a() {
        return com.baidu.navisdk.module.vehiclemanager.b.i().b() == 1 && this.f7207a;
    }

    public void a(Context context, int i, String str, b bVar) {
        if (!z.a(context)) {
            LogUtil.e("BNSafeguardController", "requestSafeguard--> isNetworkAvailable = false!");
            return;
        }
        if (!TextUtils.isEmpty(str) && com.baidu.navisdk.framework.b.e0() && i == 1) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNSafeguardController", "requestSafeguard--> plate=" + str + ", userIsLogin=" + com.baidu.navisdk.framework.b.e0() + ", vehicle=" + i);
            }
            this.f7207a = false;
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new i("token", "43704ecb98e2b6d4ed45586d7edb211a"));
                arrayList.add(new i("source", "violation"));
                arrayList.add(new i("vehicle_type", String.valueOf(i)));
                arrayList.add(new i("cuid", a0.e()));
                arrayList.add(new i("plate", str));
                com.baidu.navisdk.util.http.center.b.a().a(com.baidu.navisdk.util.http.b.d().b("naviSafeActivity"), com.baidu.navisdk.util.http.center.c.a(arrayList), new C0245a(bVar), null);
                return;
            } catch (Exception e) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.printException("BNSafeguardController", e);
                    return;
                }
                return;
            }
        }
        LogUtil.e("BNSafeguardController", "requestSafeguard--> plate=" + str + ", userIsLogin=" + com.baidu.navisdk.framework.b.e0() + ", vehicle=" + i);
    }

    /* renamed from: com.baidu.navisdk.module.navisafeguard.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0245a extends f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f7208a;

        public C0245a(b bVar) {
            this.f7208a = bVar;
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str) {
            LogUtil.e("BNSafeguardController", "requestSafeguard().ok statusCode=" + i + ", s=" + str);
            if (i == 200) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.getInt("error") == 0) {
                        a.this.f7207a = jSONObject.getBoolean("data");
                        b bVar = this.f7208a;
                        if (bVar != null) {
                            bVar.a(a.this.f7207a);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str, Throwable th) {
            LogUtil.e("BNSafeguardController", "requestSafeguard().err statusCode=" + i + ", s=" + str);
        }
    }
}
