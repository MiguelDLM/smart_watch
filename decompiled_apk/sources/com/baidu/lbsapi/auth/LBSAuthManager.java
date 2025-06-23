package com.baidu.lbsapi.auth;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p0.t;
import com.sma.smartv3.network.BaiDu;
import com.szabh.smable3.entity.Languages;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class LBSAuthManager {
    public static final int CODE_AUTHENTICATE_SUCC = 0;
    public static final int CODE_AUTHENTICATING = 602;
    public static final int CODE_INNER_ERROR = -1;
    public static final int CODE_KEY_NOT_EXIST = 101;
    public static final int CODE_NETWORK_FAILED = -11;
    public static final int CODE_NETWORK_INVALID = -10;
    public static final int CODE_UNAUTHENTICATE = 601;
    public static final String VERSION = "1.0.28";

    /* renamed from: a, reason: collision with root package name */
    private static Context f5583a = null;
    private static String b = null;
    private static int c = -1;
    private static String d;
    private static String e;
    private static p h;
    private static int i;
    private static LBSAuthManager k;
    private byte[] m;
    private static Hashtable<String, LBSAuthManagerListener> j = new Hashtable<>();
    private static String n = "";
    private static String o = "";
    private static String p = "";
    private static boolean q = false;
    private static String r = null;
    private e f = null;
    private g g = null;
    private boolean l = false;
    private final Handler s = new l(this, Looper.getMainLooper());

    private LBSAuthManager(Context context) {
        f5583a = context;
        p pVar = h;
        if (pVar != null && !pVar.isAlive()) {
            h = null;
        }
        b.b("BaiduApiAuth SDK Version:1.0.28");
        h();
    }

    private int a(String str) {
        int i2 = -1;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("status")) {
                jSONObject.put("status", -1);
            }
            i2 = jSONObject.getInt("status");
            if (jSONObject.has("current") && i2 == 0) {
                long j2 = jSONObject.getLong("current");
                long currentTimeMillis = System.currentTimeMillis();
                if ((currentTimeMillis - j2) / 3600000.0d < 24.0d) {
                    if (this.l) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        if (!simpleDateFormat.format(Long.valueOf(currentTimeMillis)).equals(simpleDateFormat.format(Long.valueOf(j2)))) {
                        }
                    }
                }
                i2 = 601;
            }
            if (jSONObject.has("current") && i2 == 602) {
                if ((System.currentTimeMillis() - jSONObject.getLong("current")) / 1000 > 180.0d) {
                    return 601;
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return i2;
    }

    public static LBSAuthManager getInstance(Context context) {
        if (k == null) {
            synchronized (LBSAuthManager.class) {
                try {
                    if (k == null) {
                        k = new LBSAuthManager(context);
                    }
                } finally {
                }
            }
        } else if (context != null) {
            f5583a = context;
        } else if (b.f5584a) {
            b.c("input context is null");
            new RuntimeException("here").printStackTrace();
        }
        return k;
    }

    private void h() {
        synchronized (LBSAuthManager.class) {
            if (h == null) {
                p pVar = new p("auth");
                h = pVar;
                pVar.start();
                while (h.f5597a == null) {
                    try {
                        b.a("wait for create auth thread.");
                        Thread.sleep(3L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    private String i() {
        try {
            JSONObject jSONObject = new JSONObject(j());
            return !jSONObject.has("extend") ? "" : jSONObject.getString("extend");
        } catch (JSONException unused) {
            return "";
        }
    }

    private String j() {
        return f5583a.getSharedPreferences("authStatus_" + a(f5583a), 0).getString("status", "{\"status\":601}");
    }

    public int authenticate(boolean z, String str, Hashtable<String, String> hashtable, LBSAuthManagerListener lBSAuthManagerListener) {
        synchronized (LBSAuthManager.class) {
            boolean z2 = false;
            if (hashtable != null) {
                try {
                    String str2 = hashtable.get("zero_auth");
                    if (str2 != null && Integer.valueOf(str2).intValue() == 1) {
                        z2 = true;
                    }
                } finally {
                }
            }
            this.l = z2;
            String str3 = System.currentTimeMillis() + "";
            if (lBSAuthManagerListener != null) {
                j.put(str3, lBSAuthManagerListener);
            }
            String a2 = a(f5583a, str3);
            if (a2 != null && !a2.equals("")) {
                i++;
                b.a(" mAuthCounter  ++ = " + i);
                String j2 = j();
                b.a("getAuthMessage from cache:" + j2);
                int a3 = a(j2);
                if (a3 == 601) {
                    try {
                        c(new JSONObject().put("status", 602).toString());
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                h();
                p pVar = h;
                if (pVar != null && pVar.f5597a != null) {
                    b.a("mThreadLooper.mHandler = " + h.f5597a);
                    h.f5597a.post(new m(this, a3, z, str3, str, hashtable));
                    return a3;
                }
                return -1;
            }
            return 101;
        }
    }

    public String decodeAESMessage(String str) {
        byte[] bArr;
        if (str != null && str.length() > 0 && (bArr = this.m) != null && bArr.length > 0) {
            try {
                Charset charset = StandardCharsets.UTF_8;
                byte[] a2 = c.a(str.getBytes(charset));
                byte[] bArr2 = this.m;
                return new String(a.a(bArr2, bArr2, a2), charset);
            } catch (Exception e2) {
                Log.e("LBSAuthManager", "decodeAESMessage", e2);
            }
        }
        return null;
    }

    public String getCUID() {
        if (!TextUtils.isEmpty(r)) {
            return r;
        }
        String str = "";
        if (f5583a == null) {
            return "";
        }
        try {
            b.a("mIsPrivacyMode " + q);
            if (q) {
                str = com.baidu.android.bbalbs.common.util.c.a(f5583a);
                r = str;
                b.a("getCUID: " + str);
            } else {
                SharedPreferences sharedPreferences = f5583a.getSharedPreferences("Map_Privacy", 0);
                if (sharedPreferences.contains("cuid")) {
                    str = sharedPreferences.getString("cuid", "");
                } else {
                    str = q.a(UUID.randomUUID().toString().getBytes(), true) + "|MAPSDK001";
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("cuid", str);
                    edit.apply();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return str;
    }

    public String getKey() {
        Context context = f5583a;
        if (context == null) {
            return "";
        }
        try {
            return getPublicKey(context);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public String getMCode() {
        Context context = f5583a;
        return context == null ? "" : d.a(context);
    }

    public boolean getPrivacyMode() {
        return q;
    }

    public String getPublicKey(Context context) throws PackageManager.NameNotFoundException {
        if (!TextUtils.isEmpty(n)) {
            return n;
        }
        return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("com.baidu.lbsapi.API_KEY");
    }

    public void setAndroidId(String str) {
        if (f5583a == null || TextUtils.isEmpty(str)) {
            return;
        }
        o = str;
    }

    public void setHttpProxyUsernameAndPassword(String str, String str2) {
        d = str;
        e = str2;
    }

    public void setKey(String str) {
        if (f5583a == null || TextUtils.isEmpty(str)) {
            return;
        }
        n = str;
    }

    public void setPackageName(String str) {
        p = str;
    }

    public void setPrivacyMode(boolean z) {
        Context context = f5583a;
        if (context == null) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("Map_Privacy", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (z) {
            edit.putBoolean("privacyMode", z);
            edit.apply();
        } else {
            z = sharedPreferences.getBoolean("privacyMode", false);
        }
        q = z;
    }

    public void setProxy(String str, int i2) {
        b = str;
        c = i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x008e, code lost:
    
        if (r6 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0081, code lost:
    
        if (r6 == null) goto L46;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007e  */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String a(int r6) throws java.io.IOException {
        /*
            r5 = this;
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5f java.io.FileNotFoundException -> L63
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5f java.io.FileNotFoundException -> L63
            r2.<init>()     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5f java.io.FileNotFoundException -> L63
            java.lang.String r3 = "/proc/"
            r2.append(r3)     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5f java.io.FileNotFoundException -> L63
            r2.append(r6)     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5f java.io.FileNotFoundException -> L63
            java.lang.String r6 = "/cmdline"
            r2.append(r6)     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5f java.io.FileNotFoundException -> L63
            java.lang.String r6 = r2.toString()     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5f java.io.FileNotFoundException -> L63
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5f java.io.FileNotFoundException -> L63
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5f java.io.FileNotFoundException -> L63
            r6.<init>(r1)     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5f java.io.FileNotFoundException -> L63
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L51 java.io.FileNotFoundException -> L55
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L51 java.io.FileNotFoundException -> L55
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L46 java.io.FileNotFoundException -> L49
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L46 java.io.FileNotFoundException -> L49
            java.lang.String r0 = r2.readLine()     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3c java.io.FileNotFoundException -> L3e
            r2.close()
            r1.close()
        L35:
            r6.close()
            goto L91
        L3a:
            r0 = move-exception
            goto L67
        L3c:
            goto L77
        L3e:
            goto L84
        L41:
            r2 = move-exception
            r4 = r2
            r2 = r0
            r0 = r4
            goto L67
        L46:
            r2 = r0
            goto L77
        L49:
            r2 = r0
            goto L84
        L4c:
            r1 = move-exception
            r2 = r0
            r0 = r1
            r1 = r2
            goto L67
        L51:
            r1 = r0
        L53:
            r2 = r1
            goto L77
        L55:
            r1 = r0
        L57:
            r2 = r1
            goto L84
        L59:
            r6 = move-exception
            r1 = r0
            r2 = r1
            r0 = r6
            r6 = r2
            goto L67
        L5f:
            r6 = r0
            r1 = r6
            goto L53
        L63:
            r6 = r0
            r1 = r6
            goto L57
        L67:
            if (r2 == 0) goto L6c
            r2.close()
        L6c:
            if (r1 == 0) goto L71
            r1.close()
        L71:
            if (r6 == 0) goto L76
            r6.close()
        L76:
            throw r0
        L77:
            if (r2 == 0) goto L7c
            r2.close()
        L7c:
            if (r1 == 0) goto L81
            r1.close()
        L81:
            if (r6 == 0) goto L91
            goto L35
        L84:
            if (r2 == 0) goto L89
            r2.close()
        L89:
            if (r1 == 0) goto L8e
            r1.close()
        L8e:
            if (r6 == 0) goto L91
            goto L35
        L91:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.lbsapi.auth.LBSAuthManager.a(int):java.lang.String");
    }

    private void b(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        if (jSONObject.has("ck")) {
            jSONObject.remove("ck");
        }
        if (jSONObject.has(Languages.DEFAULT_LANGUAGE)) {
            jSONObject.remove(Languages.DEFAULT_LANGUAGE);
        }
    }

    private void c(String str) {
        f5583a.getSharedPreferences("authStatus_" + a(f5583a), 0).edit().putString("status", str).apply();
    }

    private String a(Context context) {
        String str;
        try {
            str = a(Process.myPid());
        } catch (IOException unused) {
            str = null;
        }
        return str != null ? str : f5583a.getPackageName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        String str2;
        JSONObject jSONObject;
        String a2 = a(f5583a, str);
        try {
            jSONObject = new JSONObject(j());
        } catch (JSONException e2) {
            e2.printStackTrace();
            str2 = "";
        }
        if (!jSONObject.has(BaiDu.AK_SERVICE_KEY)) {
            return true;
        }
        str2 = jSONObject.getString(BaiDu.AK_SERVICE_KEY);
        return (a2 == null || str2 == null || a2.equals(str2)) ? false : true;
    }

    private String a(Context context, String str) {
        String str2 = "";
        if (!TextUtils.isEmpty(n)) {
            return n;
        }
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null) {
                LBSAuthManagerListener lBSAuthManagerListener = j.get(str);
                if (lBSAuthManagerListener != null) {
                    lBSAuthManagerListener.onAuthResult(101, ErrorMessage.a(101, "AndroidManifest.xml的application中没有meta-data标签"));
                }
            } else {
                String string = bundle.getString("com.baidu.lbsapi.API_KEY");
                if (string != null) {
                    try {
                        if (string.equals("")) {
                        }
                        str2 = string;
                    } catch (PackageManager.NameNotFoundException unused) {
                        str2 = string;
                        LBSAuthManagerListener lBSAuthManagerListener2 = j.get(str);
                        if (lBSAuthManagerListener2 != null) {
                            lBSAuthManagerListener2.onAuthResult(101, ErrorMessage.a(101, "无法在AndroidManifest.xml中获取com.baidu.android.lbs.API_KEY的值"));
                        }
                        return str2;
                    }
                }
                LBSAuthManagerListener lBSAuthManagerListener3 = j.get(str);
                if (lBSAuthManagerListener3 != null) {
                    lBSAuthManagerListener3.onAuthResult(101, ErrorMessage.a(101, "无法在AndroidManifest.xml中获取com.baidu.android.lbs.API_KEY的值"));
                }
                str2 = string;
            }
        } catch (PackageManager.NameNotFoundException unused2) {
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(String str, String str2) {
        p pVar;
        if (str == null) {
            try {
                str = j();
            } catch (Throwable th) {
                throw th;
            }
        }
        Message obtainMessage = this.s.obtainMessage();
        int i2 = -1;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("status")) {
                jSONObject.put("status", -1);
            }
            if (!jSONObject.has("current")) {
                jSONObject.put("current", System.currentTimeMillis());
            }
            c(jSONObject.toString());
            if (jSONObject.has("current")) {
                jSONObject.remove("current");
            }
            i2 = jSONObject.getInt("status");
            obtainMessage.what = i2;
            obtainMessage.obj = jSONObject;
            Bundle bundle = new Bundle();
            bundle.putString("listenerKey", str2);
            obtainMessage.setData(bundle);
            this.s.sendMessage(obtainMessage);
        } catch (JSONException e2) {
            e2.printStackTrace();
            obtainMessage.what = i2;
            obtainMessage.obj = new JSONObject();
            Bundle bundle2 = new Bundle();
            bundle2.putString("listenerKey", str2);
            obtainMessage.setData(bundle2);
            this.s.sendMessage(obtainMessage);
        }
        p pVar2 = h;
        if (pVar2 != null) {
            pVar2.c();
        }
        i--;
        b.a("httpRequest called mAuthCounter-- = " + i);
        if (i == 0 && (pVar = h) != null) {
            pVar.a();
            h = null;
        }
    }

    private void a(HashMap<String, String> hashMap, String str, String str2) {
        if (hashMap == null || hashMap.size() <= 0 || str == null || str.length() <= 0 || str2 == null || str2.length() <= 0) {
            return;
        }
        try {
            String a2 = r.a(str2);
            if (a2 == null || a2.length() <= 0) {
                hashMap.put(str, str2);
            } else {
                hashMap.put(str, a2);
            }
        } catch (Exception e2) {
            hashMap.put(str, str2);
            Log.e("LBSAuthManager", "encodeAuthParam", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0 || !jSONObject.has(Languages.DEFAULT_LANGUAGE)) {
            return;
        }
        if (jSONObject.optInt(Languages.DEFAULT_LANGUAGE, 0) == 0) {
            if (jSONObject.optString("ck").length() > 0) {
                this.m = c.a(jSONObject.optString("ck").getBytes(StandardCharsets.UTF_8));
            }
        } else {
            a(jSONObject, BaiDu.AK_SERVICE_KEY);
            a(jSONObject, "ck");
            a(jSONObject, "sk");
            a(jSONObject, "uid");
            b(jSONObject);
        }
    }

    private void a(JSONObject jSONObject, String str) {
        if (jSONObject == null || jSONObject.length() <= 0 || str == null || str.length() <= 0 || !jSONObject.has(str)) {
            return;
        }
        try {
            byte[] b2 = r.b(jSONObject.optString(str));
            if (b2 != null && b2.length > 0) {
                jSONObject.put(str, new String(b2, StandardCharsets.UTF_8));
                if ("ck".equals(str)) {
                    this.m = b2;
                    return;
                }
                return;
            }
            jSONObject.put(str, "");
            jSONObject.put("decode_status", -1);
        } catch (Exception e2) {
            Log.e("LBSAuthManager", " decodeAuthResult ", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, Hashtable<String, String> hashtable, String str2, String str3, int i2, String str4, String str5) {
        String str6;
        String a2 = a(f5583a, str2);
        if (a2 == null || a2.equals("")) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        r.a();
        hashMap.put("pk", r.b() != null ? r.b() : "");
        hashMap.put("url", "https://api.map.baidu.com/sdkcs/verify");
        b.a("url:https://api.map.baidu.com/sdkcs/verify");
        hashMap.put("output", "json");
        a(hashMap, BaiDu.AK_SERVICE_KEY, a2);
        b.a("ak:" + hashMap.get(BaiDu.AK_SERVICE_KEY));
        a(hashMap, BaiDu.MCODE_KEY, d.a(f5583a));
        hashMap.put(TypedValues.TransitionType.S_FROM, "lbs_yunsdk");
        if (hashtable != null && hashtable.size() > 0) {
            for (Map.Entry<String, String> entry : hashtable.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                    hashMap.put(key, value);
                }
            }
        }
        String cuid = !TextUtils.isEmpty(o) ? getCUID() : r;
        b.a("cuid:" + r);
        if (TextUtils.isEmpty(cuid)) {
            hashMap.put("cuid", "");
        } else {
            hashMap.put("cuid", cuid);
        }
        hashMap.put(t.r, f5583a.getPackageName());
        hashMap.put("version", VERSION);
        hashMap.put("macaddr", "");
        try {
            str6 = d.a();
        } catch (Exception unused) {
            str6 = "";
        }
        if (TextUtils.isEmpty(str6)) {
            hashMap.put("language", "");
        } else {
            hashMap.put("language", str6);
        }
        if (z) {
            hashMap.put(TTDownloadField.TT_FORCE, z ? "1" : "0");
        }
        if (str == null) {
            hashMap.put("from_service", "");
        } else {
            hashMap.put("from_service", str);
        }
        String i3 = i();
        if (!TextUtils.isEmpty(i3)) {
            hashMap.put("extend", i3);
        }
        e eVar = new e(f5583a);
        this.f = eVar;
        eVar.a(hashMap, str3, i2, str4, str5, new n(this, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, Hashtable<String, String> hashtable, String[] strArr, String str2, String str3, int i2, String str4, String str5) {
        String str6;
        String a2 = a(f5583a, str2);
        if (a2 == null || a2.equals("")) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        r.a();
        hashMap.put("pk", r.b() != null ? r.b() : "");
        hashMap.put("url", "https://api.map.baidu.com/sdkcs/verify");
        hashMap.put("output", "json");
        a(hashMap, BaiDu.AK_SERVICE_KEY, a2);
        hashMap.put(TypedValues.TransitionType.S_FROM, "lbs_yunsdk");
        if (hashtable != null && hashtable.size() > 0) {
            for (Map.Entry<String, String> entry : hashtable.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                    hashMap.put(key, value);
                }
            }
        }
        String cuid = !TextUtils.isEmpty(o) ? getCUID() : r;
        b.a("sendAuthRequests : cuid: " + cuid);
        if (TextUtils.isEmpty(cuid)) {
            hashMap.put("cuid", "");
        } else {
            hashMap.put("cuid", cuid);
        }
        hashMap.put(t.r, f5583a.getPackageName());
        hashMap.put("version", VERSION);
        hashMap.put("macaddr", "");
        try {
            str6 = d.a();
        } catch (Exception unused) {
            str6 = "";
        }
        if (TextUtils.isEmpty(str6)) {
            hashMap.put("language", "");
        } else {
            hashMap.put("language", str6);
        }
        if (z) {
            hashMap.put(TTDownloadField.TT_FORCE, z ? "1" : "0");
        }
        if (str == null) {
            hashMap.put("from_service", "");
        } else {
            hashMap.put("from_service", str);
        }
        String i3 = i();
        if (!TextUtils.isEmpty(i3)) {
            hashMap.put("extend", i3);
        }
        String[] strArr2 = new String[strArr.length];
        for (int i4 = 0; i4 < strArr.length; i4++) {
            String a3 = r.a(strArr[i4]);
            if (a3 == null || a3.length() <= 0) {
                strArr2[i4] = strArr[i4];
            } else {
                strArr2[i4] = a3;
            }
        }
        g gVar = new g(f5583a);
        this.g = gVar;
        gVar.a(hashMap, strArr2, str3, i2, str4, str5, new o(this, str2));
    }
}
