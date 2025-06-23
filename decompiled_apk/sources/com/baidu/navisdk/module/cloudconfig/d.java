package com.baidu.navisdk.module.cloudconfig;

import com.baidu.navisdk.module.cloudconfig.f;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.y;
import com.baidu.navisdk.util.http.center.l;
import com.facebook.appevents.UserDataStore;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private g f7096a;
    private int b;
    private h c;

    /* loaded from: classes7.dex */
    public class b extends com.baidu.navisdk.util.worker.lite.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f7098a;
        final /* synthetic */ String b;
        final /* synthetic */ int c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, int i, String str2, int i2) {
            super(str);
            this.f7098a = i;
            this.b = str2;
            this.c = i2;
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            d.this.a(this.f7098a, this.b, this.c);
        }
    }

    /* loaded from: classes7.dex */
    public class c extends com.baidu.navisdk.util.worker.lite.b {
        public c(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            d.this.f();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x02b7 A[Catch: Exception -> 0x0135, TryCatch #0 {Exception -> 0x0135, blocks: (B:3:0x000c, B:5:0x00ff, B:6:0x0138, B:8:0x013c, B:10:0x0166, B:12:0x01bc, B:13:0x01c2, B:16:0x01ca, B:18:0x01f1, B:24:0x0218, B:27:0x0244, B:33:0x0284, B:35:0x02b7, B:36:0x02eb, B:38:0x033a, B:42:0x026f, B:45:0x0203), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x023f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.List<com.baidu.navisdk.util.http.center.l> b(int r13) {
        /*
            Method dump skipped, instructions count: 838
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.module.cloudconfig.d.b(int):java.util.List");
    }

    private void c() {
        h hVar = this.c;
        if (hVar != null) {
            hVar.a();
            this.c = null;
        }
    }

    private boolean d() {
        String jSONObject;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("CloudConfigObtainManager", "useABTestDataFromFile()");
        }
        if (this.f7096a == null) {
            this.f7096a = new g();
        }
        try {
            JSONObject e = this.f7096a.e();
            if (LogUtil.LOGGABLE) {
                StringBuilder sb = new StringBuilder();
                sb.append("useABTestDataFromFile->jSONObject=");
                if (e == null) {
                    jSONObject = "null";
                } else {
                    jSONObject = e.toString();
                }
                sb.append(jSONObject);
                LogUtil.e("EncryptData", sb.toString());
            }
            if (e != null) {
                a(e);
                return true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("CloudConfigObtainManager", "useCloudDataFromFile() fail");
            return false;
        }
        return false;
    }

    private boolean e() {
        JSONObject jSONObject;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("CloudConfigObtainManager", "useCloudDataFromFile()");
        }
        if (this.f7096a == null) {
            this.f7096a = new g();
        }
        try {
            JSONObject f = this.f7096a.f();
            if (f != null) {
                jSONObject = f.getJSONObject("data");
            } else {
                jSONObject = null;
            }
            if (jSONObject != null && a(jSONObject, false)) {
                f.c().o = true;
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("CloudConfigObtainManager", "useCloudDataFromFile() end");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        e();
        c();
    }

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.util.http.center.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f7097a;

        public a(int i) {
            this.f7097a = i;
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str, Throwable th) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("CloudConfigObtainManager", "requestCloudConfig failed " + i);
            }
            d.this.a(i, str, this.f7097a, false);
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("CloudConfigObtainManager", "requestCloudConfig success " + i);
            }
            d.this.a(i, str, this.f7097a, true);
        }
    }

    public void a(h hVar) {
        this.c = hVar;
    }

    public void a() {
        LogUtil.e("CloudConfigObtainManager", "initCloudConfigOutline->");
        a(1003);
    }

    public void a(int i) {
        LogUtil.e("CloudConfigObtainManager", "requestCloudConfigOutline requestType=" + i);
        if (!y.d(com.baidu.navisdk.framework.a.c().a())) {
            f();
            return;
        }
        if (this.f7096a == null) {
            this.f7096a = new g();
        }
        com.baidu.navisdk.util.http.center.e eVar = new com.baidu.navisdk.util.http.center.e();
        eVar.f9300a = true;
        com.baidu.navisdk.util.http.center.b.a().a(com.baidu.navisdk.util.http.b.d().b("InitCloudConfig"), com.baidu.navisdk.util.http.center.c.a(b(i)), new a(i), eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2, boolean z) {
        if (z) {
            com.baidu.navisdk.util.worker.lite.a.a((com.baidu.navisdk.util.worker.lite.b) new b("cloud_success", i, str, i2), 10001);
        } else {
            com.baidu.navisdk.util.worker.lite.a.a((com.baidu.navisdk.util.worker.lite.b) new c("cloud_fail"), 10001);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2) {
        JSONObject jSONObject;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("CloudConfigObtainManager", "cloudConfigSuccess ret = " + i);
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        int a2 = a(jSONObject, i2);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("CloudConfigObtainManager", "handleResult ret = " + a2);
        }
        if (a2 == 0) {
            f.c().o = true;
            c();
            return;
        }
        if (a2 == 2) {
            boolean a3 = a(true, i2);
            if (LogUtil.LOGGABLE) {
                LogUtil.e("CloudConfigObtainManager", "restartQeqData result = " + a3);
            }
            if (a3) {
                return;
            } else {
                this.b = 0;
            }
        }
        f.c().o = false;
        if (i2 == 1003 || i2 == 1001) {
            e();
        } else if (i2 == 1002) {
            d();
        }
        c();
    }

    /* JADX WARN: Code restructure failed: missing block: B:90:0x00c8, code lost:
    
        if (r18.getString("errmsg").equals("success") == false) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00cf A[Catch: Exception -> 0x007d, TRY_ENTER, TryCatch #1 {Exception -> 0x007d, blocks: (B:96:0x0058, B:24:0x008b, B:26:0x008f, B:33:0x00cf, B:36:0x00d7, B:81:0x00af, B:93:0x0149, B:87:0x0098, B:30:0x00a8), top: B:95:0x0058, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e2 A[Catch: Exception -> 0x00ee, TRY_ENTER, TryCatch #0 {Exception -> 0x00ee, blocks: (B:40:0x00e2, B:43:0x00ea, B:45:0x010a, B:50:0x011a, B:52:0x011e, B:55:0x0129, B:58:0x0132, B:59:0x0137, B:62:0x00f3, B:68:0x0103), top: B:38:0x00e0 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010a A[Catch: Exception -> 0x00ee, TryCatch #0 {Exception -> 0x00ee, blocks: (B:40:0x00e2, B:43:0x00ea, B:45:0x010a, B:50:0x011a, B:52:0x011e, B:55:0x0129, B:58:0x0132, B:59:0x0137, B:62:0x00f3, B:68:0x0103), top: B:38:0x00e0 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0172 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int a(org.json.JSONObject r18, int r19) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.module.cloudconfig.d.a(org.json.JSONObject, int):int");
    }

    private int b() {
        return com.baidu.navisdk.framework.b.l();
    }

    private boolean a(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return false;
        }
        try {
            f.c().b = new f.n0(jSONObject.getString("etag"), jSONObject.getLong(UserDataStore.STATE));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (!e.b.isEmpty()) {
            for (Map.Entry<String, i> entry : e.b.entrySet()) {
                try {
                    String key = entry.getKey();
                    i value = entry.getValue();
                    JSONObject optJSONObject = jSONObject.optJSONObject(key);
                    if (optJSONObject == null && LogUtil.LOGGABLE) {
                        LogUtil.e("CloudConfigObtainManager", key + " object is null");
                    }
                    value.a(optJSONObject, z);
                } catch (Throwable th) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("CloudConfigObtainManager", th.getMessage());
                    }
                }
            }
        }
        if (!e.c.isEmpty()) {
            for (Map.Entry<String, j> entry2 : e.c.entrySet()) {
                String key2 = entry2.getKey();
                j value2 = entry2.getValue();
                Object opt = jSONObject.opt(key2);
                if (opt == null && LogUtil.LOGGABLE) {
                    LogUtil.e("CloudConfigObtainManager", key2 + " object is null");
                }
                try {
                    value2.a(opt, z);
                } catch (Exception e2) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("CloudConfigObtainManager", e2.getMessage());
                    }
                }
            }
        }
        h hVar = this.c;
        if (hVar == null) {
            return true;
        }
        hVar.a(jSONObject);
        return true;
    }

    private boolean a(boolean z, int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("CloudConfigObtainManager", "restartQeqData restartNeeded=" + z + ",requestType=" + i + ", mRetryCount= " + this.b);
        }
        if (z) {
            int i2 = this.b + 1;
            this.b = i2;
            if (i2 > 3) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("CloudConfigObtainManager", "restart return, max 3");
                }
                this.b = 0;
                return false;
            }
            if (this.f7096a == null) {
                this.f7096a = new g();
            }
            if (i == 1003 || i == 1001) {
                this.f7096a.b();
            }
            if (i == 1003 || i == 1002) {
                this.f7096a.a();
            }
            a(i);
            return true;
        }
        this.b = 0;
        return false;
    }

    public static String a(List<l> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        int size = list.size();
        String[] strArr = new String[size];
        for (int i = 0; i < list.size(); i++) {
            try {
                try {
                    strArr[i] = (URLEncoder.encode(list.get(i).a(), "utf-8") + "=") + URLEncoder.encode(list.get(i).b().replaceAll("\\\\", ""), "utf-8");
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        Arrays.sort(strArr);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < size; i2++) {
            stringBuffer.append(strArr[i2]);
            if (i2 != size - 1) {
                stringBuffer.append("&");
            }
        }
        LogUtil.e("CloudConfigObtainManagerSortSequenceWithAscendingOder:", stringBuffer.toString());
        return stringBuffer.toString();
    }

    private void a(JSONObject jSONObject) {
        com.baidu.navisdk.framework.interfaces.c.p().a().a(jSONObject);
    }
}
