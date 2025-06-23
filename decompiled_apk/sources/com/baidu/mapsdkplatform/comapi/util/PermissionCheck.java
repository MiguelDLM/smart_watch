package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.alimm.tanx.core.constant.TanxAdType;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.lbsapi.auth.LBSAuthManagerListener;
import com.baidu.mapapi.CommonInfo;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p0.t;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.Hashtable;
import o0oIxXOx.oO;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class PermissionCheck {

    /* renamed from: a, reason: collision with root package name */
    public static int f6198a = 200;
    public static int b = 202;
    public static int c = 252;
    private static final String d = "PermissionCheck";
    private static Context e = null;
    private static String f = null;
    private static Hashtable<String, String> g = null;
    private static LBSAuthManager h = null;
    private static LBSAuthManagerListener i = null;
    private static c j = null;
    private static int k = 601;
    private static boolean l = false;

    /* loaded from: classes7.dex */
    public static class a implements LBSAuthManagerListener {
        private a() {
        }

        @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
        public void onAuthResult(int i, String str) {
            if (str == null) {
                Log.e(PermissionCheck.d, "The result is null");
                int permissionCheck = PermissionCheck.permissionCheck();
                Log.d(PermissionCheck.d, "onAuthResult try permissionCheck result is: " + permissionCheck);
                return;
            }
            b bVar = new b();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("status")) {
                    bVar.f6199a = jSONObject.optInt("status");
                }
                if (jSONObject.has("appid")) {
                    bVar.c = jSONObject.optString("appid");
                }
                if (jSONObject.has("uid")) {
                    bVar.b = jSONObject.optString("uid");
                }
                if (jSONObject.has("message")) {
                    bVar.d = jSONObject.optString("message");
                }
                if (jSONObject.has("token")) {
                    bVar.e = jSONObject.optString("token");
                }
                if (jSONObject.has("ak_permission")) {
                    bVar.f = jSONObject.optInt("ak_permission");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            int unused = PermissionCheck.k = bVar.f6199a;
            if (PermissionCheck.j != null && PermissionCheck.l) {
                PermissionCheck.j.a(bVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f6199a = 0;
        public String b = "-1";
        public String c = "-1";
        public String d = "";
        public String e;
        public int f;

        public String toString() {
            return String.format("=============================================\n----------------- 鉴权错误信息 ------------\nsha1;package:%s\nkey:%s\nerrorcode: %d uid: %s appid %s msg: %s\n请仔细核查 SHA1、package与key申请信息是否对应，key是否删除，平台是否匹配\n=============================================\n", com.baidu.mapsdkplatform.comapi.util.a.a(PermissionCheck.e), PermissionCheck.f, Integer.valueOf(this.f6199a), this.b, this.c, this.d);
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(b bVar);
    }

    public static void destory() {
        j = null;
        e = null;
        i = null;
    }

    public static int getPermissionResult() {
        return k;
    }

    public static void init(Context context) {
        ApplicationInfo applicationInfo;
        String str;
        e = context;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(e.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            applicationInfo = null;
        }
        if (applicationInfo != null && TextUtils.isEmpty(f)) {
            f = applicationInfo.metaData.getString("com.baidu.lbsapi.API_KEY");
        }
        if (g == null) {
            g = new Hashtable<>();
        }
        if (h == null) {
            h = LBSAuthManager.getInstance(e);
        }
        if (i == null) {
            i = new a();
        }
        try {
            str = context.getPackageManager().getPackageInfo(e.getPackageName(), 0).applicationInfo.loadLabel(e.getPackageManager()).toString();
        } catch (Exception e3) {
            e3.printStackTrace();
            str = "";
        }
        try {
            JSONObject jSONObject = new JSONObject(i.d());
            g.put("mb", jSONObject.optString("mb"));
            g.put(oO.f31192XO, jSONObject.optString(oO.f31192XO));
            g.put("sv", jSONObject.optString("sv"));
            g.put("imt", "1");
            g.put(TKDownloadReason.KSAD_TK_NET, jSONObject.optString(TKDownloadReason.KSAD_TK_NET));
            g.put(IAdInterListener.AdProdType.PRODUCT_CPU, jSONObject.optString(IAdInterListener.AdProdType.PRODUCT_CPU));
            g.put("glr", jSONObject.optString("glr"));
            g.put("glv", jSONObject.optString("glv"));
            g.put("resid", jSONObject.optString("resid"));
            g.put("appid", "-1");
            g.put("ver", "1");
            g.put(TanxAdType.SPLASH_STRING, String.format("(%d,%d)", Integer.valueOf(jSONObject.optInt("screen_x")), Integer.valueOf(jSONObject.optInt("screen_y"))));
            g.put("dpi", String.format("(%d,%d)", Integer.valueOf(jSONObject.optInt("dpi_x")), Integer.valueOf(jSONObject.optInt("dpi_y"))));
            g.put(t.r, jSONObject.optString(t.r));
            g.put("cuid", jSONObject.optString("cuid"));
            g.put("name", str);
        } catch (Exception unused) {
        }
    }

    public static synchronized int permissionCheck() {
        synchronized (PermissionCheck.class) {
            try {
                LBSAuthManager lBSAuthManager = h;
                if (lBSAuthManager != null && i != null && e != null) {
                    lBSAuthManager.setKey(f);
                    CommonInfo b2 = com.baidu.mapsdkplatform.comapi.b.b();
                    if (b2 != null) {
                        String androidID = b2.getAndroidID();
                        if (!TextUtils.isEmpty(androidID)) {
                            h.setAndroidId(androidID);
                        }
                    }
                    int authenticate = h.authenticate(false, "lbs_androidmapsdk", g, i);
                    if (authenticate != 0) {
                        Log.e(d, "permission check result is: " + authenticate);
                    }
                    return authenticate;
                }
                Log.e(d, "The authManager is: " + h + "; the authCallback is: " + i + "; the mContext is: " + e);
                return 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void setApiKey(String str) {
        if (str != null && str.trim().length() > 0) {
            f = str;
        }
    }

    public static void setPermissionCheckResultListener(c cVar) {
        j = cVar;
    }

    public static void setPrivacyMode(boolean z) {
        l = z;
        if (z) {
            permissionCheck();
        } else {
            i.a();
        }
    }
}
