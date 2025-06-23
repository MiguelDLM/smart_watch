package com.baidu.mshield.x0;

import OoOoXO0.xoXoI;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.mshield.x0.b.g;
import com.baidu.mshield.x0.b.i;
import com.baidu.mshield.x0.h.a;
import com.baidu.mshield.x0.receiver.ReceiverWork;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class EngineImpl {
    public static final String KEY_ACCOUNT_ID = "aid";
    public static final String KEY_ANDROID_ID = "arid";
    public static final String KEY_ANDROID_LEVEL = "arl";
    public static final String KEY_ANDROID_VERSION = "arv";
    public static final String KEY_CUID = "cuid";
    public static final String KEY_MODEL = "mod";
    public static final String KEY_PACKAGE = "p";
    public static final String KEY_SENSOR_LIST = "sl";
    public static final String KEY_SIGNATURE = "s";
    public static final String KEY_WIFI_STATE = "ws";
    public static boolean isUnload = false;
    public static Context mContext = null;
    public static String sAppkey = "";
    private static EngineImpl sInstance = null;
    public static boolean sIsArm = true;
    public static boolean sIsX86 = false;
    public static String sSecKey = "";
    public String ids = "{}";
    private IntentFilter mSecAlarmFilter;
    private IntentFilter mSecSystemFilter;
    private com.baidu.mshield.x0.j.a pref;
    private ReceiverWork secReceiver;
    private com.baidu.mshield.x0.j.c sofirePreferences;
    public static final HashMap<String, String> PROPERTY_MAP = new HashMap<>();
    public static int sScreenStatus = 1;
    public static String sLoadVersion = d.c;
    public static String secName = d.d;
    public static String secPackageName = d.f6411a;

    private EngineImpl(Context context) {
        mContext = context;
        this.pref = new com.baidu.mshield.x0.j.a(context);
        this.sofirePreferences = new com.baidu.mshield.x0.j.c(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doInit(int i, boolean z) {
        try {
            isUnload = false;
            com.baidu.mshield.x0.b.d.m(mContext);
            com.baidu.xclient.gdid.a.a(mContext, sAppkey, sSecKey);
            this.pref.e(sLoadVersion);
            registerReceiver();
            com.baidu.mshield.x0.b.b.a(mContext, true);
            initReport();
            setAlarms();
            com.baidu.mshield.x0.a.a.a(mContext);
            com.baidu.mshield.x0.a.d.a(mContext);
            com.baidu.mshield.x6.EngineImpl.getInstance(mContext).init(i, z);
            com.baidu.mshield.x6.EngineImpl.getInstance(mContext).setSecImpl(new e());
        } catch (Throwable th) {
            com.baidu.mshield.x0.b.d.a(th);
        }
    }

    public static synchronized EngineImpl getInstance(Context context) {
        EngineImpl engineImpl;
        synchronized (EngineImpl.class) {
            try {
                if (sInstance == null) {
                    sInstance = new EngineImpl(context);
                }
                engineImpl = sInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return engineImpl;
    }

    private void handleTokenLogic() {
        JSONArray jSONArray;
        try {
            if (!com.baidu.mshield.x0.b.d.a(mContext, "plc95", false, this.pref)) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.mshield.x6.a.b bVar = new com.baidu.mshield.x6.a.b(mContext);
            String F = bVar.F();
            int L = bVar.L();
            int M = bVar.M();
            if (TextUtils.isEmpty(F)) {
                jSONArray = new JSONArray();
            } else {
                jSONArray = new JSONArray(F);
            }
            if (jSONArray.length() + 1 > L) {
                jSONArray.remove(0);
            }
            StringBuilder sb = new StringBuilder();
            int i = M + 1;
            sb.append(i);
            sb.append(xoXoI.f2670oxoX);
            sb.append(this.sofirePreferences.a());
            sb.append(xoXoI.f2670oxoX);
            sb.append(currentTimeMillis);
            jSONArray.put(sb.toString());
            bVar.m(i);
            bVar.v(jSONArray.toString());
            String b = this.sofirePreferences.b();
            long j = this.pref.j();
            long currentTimeMillis2 = System.currentTimeMillis();
            com.baidu.mshield.x0.b.d.a(mContext, "plc95", new com.baidu.mshield.x0.b.c(), this.pref);
            long j2 = r7.d * 60000;
            if (TextUtils.isEmpty(b)) {
                new com.baidu.mshield.x0.f.a().a(mContext, 6, 1, j2);
                this.pref.d(currentTimeMillis2);
            } else if (currentTimeMillis2 - j >= j2) {
                this.sofirePreferences.a(b);
                this.sofirePreferences.b("");
                this.pref.d(currentTimeMillis2);
                new com.baidu.mshield.x0.f.a().a(mContext, 6, 1, j2);
            }
        } catch (Throwable th) {
            com.baidu.mshield.x0.b.d.a(th);
        }
    }

    private void initReport() {
        com.baidu.mshield.x0.b.a.d.a().a(new b(this));
    }

    private void registerReceiver() {
        try {
            this.secReceiver = new ReceiverWork();
            if (this.mSecAlarmFilter == null) {
                IntentFilter intentFilter = new IntentFilter();
                this.mSecAlarmFilter = intentFilter;
                intentFilter.addAction("com.baidu.mshield.x0.alarm.action");
                mContext.registerReceiver(this.secReceiver, this.mSecAlarmFilter);
            }
        } catch (Throwable th) {
            com.baidu.mshield.x0.b.d.a(th);
        }
    }

    private void setAlarms() {
        long currentTimeMillis;
        try {
            com.baidu.mshield.x0.j.a aVar = new com.baidu.mshield.x0.j.a(mContext);
            com.baidu.mshield.x0.b.b.a(mContext, false);
            long i = aVar.i();
            if (i == 0) {
                currentTimeMillis = com.baidu.mshield.x0.b.b.a(mContext) * 60000;
                aVar.c(System.currentTimeMillis() + currentTimeMillis);
            } else {
                currentTimeMillis = i - System.currentTimeMillis();
                if (currentTimeMillis < 0) {
                    currentTimeMillis = 50;
                }
            }
            com.baidu.mshield.x0.b.b.a(mContext, currentTimeMillis);
        } catch (Throwable th) {
            com.baidu.mshield.x0.b.d.a(th);
        }
    }

    public int adm(String str) {
        return 0;
    }

    public int aen(String str) {
        return 0;
    }

    public String getAidFWM() {
        return g.b(mContext);
    }

    public String getIccFWM() {
        return "";
    }

    public String getIds() {
        return this.ids;
    }

    public String getImeFWM() {
        return "";
    }

    public String getImsFWM() {
        return "";
    }

    public String getMaFWM() {
        return "";
    }

    public String getNui() {
        return i.a(mContext);
    }

    public String getPropertyByType(String str) {
        try {
            HashMap<String, String> hashMap = PROPERTY_MAP;
            if (hashMap.size() > 0) {
                synchronized (hashMap) {
                    try {
                        if (hashMap.containsKey(str)) {
                            return hashMap.get(str);
                        }
                        return "";
                    } finally {
                    }
                }
            }
            return "";
        } catch (Throwable th) {
            com.baidu.mshield.x0.b.d.a(th);
            return "";
        }
    }

    public int gpol() {
        return com.baidu.mshield.x0.h.a.a(mContext).a((a.InterfaceC0148a) null, false);
    }

    public String gtdid() {
        try {
            return com.baidu.xclient.gdid.a.b();
        } catch (Throwable th) {
            com.baidu.mshield.x0.b.d.a(th);
            return "";
        }
    }

    public String ice() {
        return ice(-1);
    }

    public synchronized boolean init(int i, boolean z) {
        new Thread(new a(this, i, z)).start();
        return true;
    }

    public String mqa(int i, String str, int i2) {
        return "";
    }

    public void reportAlive() {
        com.baidu.mshield.x0.b.d.k(mContext);
    }

    public void sendWMCrashLog(int i) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", i);
            jSONArray.put(jSONObject);
            com.baidu.mshield.x0.b.d.a(mContext, jSONArray, "1001133");
        } catch (Throwable th) {
            com.baidu.mshield.x0.b.d.a(th);
        }
    }

    public void setBusy(boolean z) {
    }

    public void setPkgNameVersion(String str, String str2) {
        try {
            com.baidu.mshield.b.c.a.b("p : " + str + " : v : " + str2);
            com.baidu.mshield.x6.EngineImpl.getInstance(mContext).setPkgNameVersion(str, str2);
            if (!TextUtils.isEmpty(str)) {
                d.f6411a = str;
            }
            if (!TextUtils.isEmpty(str2)) {
                sLoadVersion = str2;
                this.pref.e(str2);
            }
        } catch (Throwable th) {
            com.baidu.mshield.x0.b.d.a(th);
        }
    }

    public void setRunStatus(int i) {
        try {
            this.pref.a(i);
            com.baidu.mshield.x6.EngineImpl.getInstance(mContext).setRunStatus(i);
        } catch (Throwable th) {
            com.baidu.mshield.x0.b.d.a(th);
        }
    }

    public void setSecurityVerifyInfo(String str, String str2, HashMap<String, String> hashMap) {
        try {
            com.baidu.mshield.b.c.a.b("a : " + str + " s : " + str2);
            com.baidu.mshield.x6.EngineImpl.getInstance(mContext).setSecurityVerifyInfo(str, str2, hashMap);
            com.baidu.xclient.gdid.a.a(mContext, str, str2, hashMap);
            sAppkey = str;
            sSecKey = str2;
            if (hashMap != null) {
                HashMap<String, String> hashMap2 = PROPERTY_MAP;
                synchronized (hashMap2) {
                    hashMap2.putAll(hashMap);
                }
            }
        } catch (Throwable th) {
            com.baidu.mshield.x0.b.d.a(th);
        }
    }

    public Boolean stop() {
        return Boolean.TRUE;
    }

    public void ud(HashMap<String, String> hashMap) {
        if (hashMap != null) {
            try {
                if (hashMap.size() != 0) {
                    synchronized (PROPERTY_MAP) {
                        try {
                            for (String str : hashMap.keySet()) {
                                PROPERTY_MAP.put(str, hashMap.get(str));
                            }
                        } finally {
                        }
                    }
                    com.baidu.mshield.x6.EngineImpl.getInstance(mContext).ud(hashMap);
                }
            } catch (Throwable th) {
                com.baidu.mshield.x0.b.d.a(th);
            }
        }
    }

    public void unload() {
        try {
            mContext.unregisterReceiver(this.secReceiver);
        } catch (Throwable th) {
            com.baidu.mshield.x0.b.d.a(th);
        }
        com.baidu.mshield.x0.b.b.b(mContext);
        stop();
        com.baidu.mshield.x0.c.a.a().b();
        com.baidu.xclient.gdid.a.c();
        com.baidu.mshield.x0.b.a.d.a().b();
        com.baidu.mshield.x6.EngineImpl.getInstance(mContext).unload();
        isUnload = true;
    }

    public String uqi() {
        return "";
    }

    public String xgz(String str) {
        return "";
    }

    public String ice(int i) {
        return ice("", i);
    }

    public String ice(String str, int i) {
        return ice(str, i, "");
    }

    public String ice(String str, int i, String str2) {
        handleTokenLogic();
        return com.baidu.mshield.x0.e.a.a(mContext, str, i, str2);
    }
}
