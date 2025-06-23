package com.baidu.mshield.x0.e;

import android.content.Context;
import android.os.Debug;
import android.text.TextUtils;
import com.baidu.mshield.b.f.e;
import com.baidu.mshield.x0.b.d;
import com.baidu.mshield.x0.f.c;
import com.baidu.mshield.x6.EngineImpl;
import com.huawei.openalliance.ad.activity.PPSLauncherActivity;
import com.huawei.openalliance.ad.constant.x;
import com.tencent.connect.common.II0xO0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.text.ooOOo0oXI;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static int f6414a = -1;
    public static int b = -1;
    public static String c = "";
    public static long d = -1;
    public static long e;
    public static Map<Integer, Boolean> f = new HashMap(100);

    public static String a(Context context, String str, int i, String str2) {
        com.baidu.mshield.x0.j.a aVar;
        ArrayList arrayList;
        synchronized (a.class) {
            try {
                com.baidu.mshield.b.c.a.b("accountId: " + str + " eventId: " + i);
                aVar = new com.baidu.mshield.x0.j.a(context);
                arrayList = new ArrayList();
                try {
                    String a2 = d.a(context, aVar, "plc104", "7");
                    if (!TextUtils.isEmpty(a2)) {
                        JSONArray jSONArray = new JSONArray(a2);
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            arrayList.add(jSONArray.getString(i2));
                        }
                    }
                } catch (Throwable th) {
                    d.a(th);
                }
                if (d == -1) {
                    d = aVar.m();
                }
                if (e == 0) {
                    e = aVar.n();
                }
            } catch (Throwable th2) {
                d.a(th2);
            }
            if (!arrayList.contains(String.valueOf(i))) {
                return "";
            }
            if (f.get(Integer.valueOf(i)) == null && f.size() <= 100) {
                f.put(Integer.valueOf(i), Boolean.TRUE);
            } else if (System.currentTimeMillis() - e < d * 1000) {
                return "";
            }
            new com.baidu.mshield.x0.f.a().a(context, 2, 0, 0L);
            EngineImpl.getInstance(context).bdsd(4, false);
            aVar.f(System.currentTimeMillis());
            e = System.currentTimeMillis();
            return "";
        }
    }

    public static void b(Context context, JSONObject jSONObject) {
        try {
            if (d.a(context, "plc36", true)) {
                jSONObject.put("30", String.valueOf(c.a(context)));
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public static void c(Context context, JSONObject jSONObject) {
        String str;
        try {
            if (d.a(context, "plc84", true)) {
                try {
                    str = c.d(context);
                } catch (Throwable th) {
                    d.a(th);
                    str = "";
                }
                jSONObject.put("71", str);
            }
        } catch (Throwable th2) {
            d.a(th2);
        }
    }

    public static void d(Context context, JSONObject jSONObject) {
        try {
            if (d.a(context, "plc71", false)) {
                jSONObject.put("59", a(c.e(context)));
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public static boolean e(Context context, JSONObject jSONObject) {
        String a2;
        try {
            boolean a3 = d.a(context, "plc18", true);
            com.baidu.mshield.b.c.a.b("getSafetyFactor status key : KEY_POLICY_PROXY  status : " + a3);
            if (a3) {
                c = d.e();
                com.baidu.mshield.x0.j.a aVar = new com.baidu.mshield.x0.j.a(context);
                String b2 = aVar.b("n_l_c_n_k_p_p");
                if (TextUtils.isEmpty(c)) {
                    a2 = " ";
                } else {
                    a2 = e.a(c);
                }
                aVar.b("n_l_c_n_k_p_p", a2);
                com.baidu.mshield.b.c.a.b("report debug : 10 compare: " + b2 + " : " + a2);
                jSONObject.put("10", c);
                if (a2 != null && !a2.equalsIgnoreCase(b2)) {
                    return true;
                }
            } else {
                c = "";
            }
            com.baidu.mshield.b.c.a.b("getSafetyFactor proxyIp finish Time:" + c);
            return false;
        } catch (Throwable th) {
            d.a(th);
            return false;
        }
    }

    public static boolean f(Context context, JSONObject jSONObject) {
        String[] strArr;
        try {
            boolean a2 = d.a(context, "plc15", true);
            com.baidu.mshield.b.c.a.b("getSafetyFactor status key : KEY_POLICY_SAFE_SCAN_COMMON status : " + a2);
            if (a2) {
                JSONObject o = d.o(context);
                com.baidu.mshield.x0.j.a aVar = new com.baidu.mshield.x0.j.a(context);
                String b2 = aVar.b("n_l_c_n_k_i_r");
                StringBuilder sb = new StringBuilder();
                int i = 0;
                while (true) {
                    strArr = d.b;
                    if (i >= strArr.length) {
                        break;
                    }
                    sb.append(o.opt(Integer.toString(i)));
                    i++;
                }
                sb.append(o.opt(Integer.toString(strArr.length)));
                sb.toString().contains("1");
                String a3 = e.a(sb.toString());
                aVar.b("n_l_c_n_k_i_r", a3);
                com.baidu.mshield.b.c.a.b("report debug : " + II0xO0.f26834o0IXXIx + " compare: " + b2 + " : " + a3);
                jSONObject.put(II0xO0.f26834o0IXXIx, o);
                if (a3 != null) {
                    if (!a3.equalsIgnoreCase(b2)) {
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            d.a(th);
        }
        return false;
    }

    public static boolean g(Context context, JSONObject jSONObject) {
        try {
            boolean a2 = d.a(context, "plc20", true);
            com.baidu.mshield.b.c.a.b("getSafetyFactor status key : KEY_POLICY_USB_DEBUG  status : " + a2);
            if (a2) {
                b = d.n(context) ? 1 : 0;
                com.baidu.mshield.x0.j.a aVar = new com.baidu.mshield.x0.j.a(context);
                String b2 = aVar.b("n_l_c_n_k_d_m");
                String valueOf = String.valueOf(b);
                aVar.b("n_l_c_n_k_d_m", valueOf);
                com.baidu.mshield.b.c.a.b("report debug : 7 compare: " + b2 + " : " + valueOf);
                jSONObject.put("7", valueOf);
                StringBuilder sb = new StringBuilder();
                sb.append("getSafetyFactor isDebugMode finish Time:");
                sb.append(b);
                com.baidu.mshield.b.c.a.b(sb.toString());
                if (!valueOf.equalsIgnoreCase(b2)) {
                    return true;
                }
            } else {
                b = -1;
            }
            return false;
        } catch (Throwable th) {
            d.a(th);
            return false;
        }
    }

    public static void h(Context context, JSONObject jSONObject) {
        String str;
        try {
            int i = 1;
            if (d.a(context, "plc03", true)) {
                com.baidu.mshield.b.c.a.b("injectStatus is true");
                com.baidu.mshield.x0.j.a aVar = new com.baidu.mshield.x0.j.a(context);
                long currentTimeMillis = System.currentTimeMillis();
                String str2 = (String) com.baidu.xclient.gdid.a.a(19, context.getPackageName(), d.p(context), Integer.valueOf(aVar.o()));
                com.baidu.mshield.b.c.a.b("jni inject result=" + str2 + " , time cost=" + (System.currentTimeMillis() - currentTimeMillis));
                if (!TextUtils.isEmpty(str2)) {
                    if (!str2.startsWith("1")) {
                        if (str2.startsWith("-1")) {
                            i = -1;
                        } else {
                            i = 0;
                        }
                    }
                    f6414a = i;
                    com.baidu.mshield.b.c.a.b("injectRet is not empty, isjnject: " + f6414a);
                }
                if (TextUtils.isEmpty(str2)) {
                    str = "";
                } else {
                    str = str2;
                }
                jSONObject.put("1", str);
                com.baidu.mshield.b.c.a.b("getSafetyFactor isInject finish Time: " + str2);
                return;
            }
            f6414a = -1;
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.b("load jni lib fail: " + th);
            d.a(th);
        }
    }

    public static boolean i(Context context, JSONObject jSONObject) {
        String a2;
        try {
            boolean a3 = d.a(context, "plc16", true);
            com.baidu.mshield.b.c.a.b("getSafetyFactor status key : KEY_POLICY_APP_DEBUG  status : " + a3);
            if (a3) {
                long currentTimeMillis = System.currentTimeMillis();
                String str = (String) com.baidu.xclient.gdid.a.a(18, d.p(context), (Object) null, (Object) null);
                com.baidu.mshield.b.c.a.b("jni debug result=" + str + ", time cost=" + (System.currentTimeMillis() - currentTimeMillis));
                StringBuilder sb = new StringBuilder();
                sb.append("Debug.isDebuggerConnected()=");
                sb.append(Debug.isDebuggerConnected());
                com.baidu.mshield.b.c.a.b(sb.toString());
                if (!TextUtils.isEmpty(str) && !str.startsWith("1")) {
                    str.startsWith("-1");
                }
                if (TextUtils.isEmpty(str)) {
                    a2 = " ";
                } else {
                    a2 = e.a(str);
                }
                com.baidu.mshield.x0.j.a aVar = new com.baidu.mshield.x0.j.a(context);
                String b2 = aVar.b("n_l_c_n_k_i_d");
                aVar.b("n_l_c_n_k_i_d", a2);
                com.baidu.mshield.b.c.a.b("report debug : 2 compare: " + b2 + " : " + a2 + ooOOo0oXI.f33072OOXIXo + str);
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                jSONObject.put("2", str);
                if (a2 != null) {
                    if (!a2.equalsIgnoreCase(b2)) {
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            d.a(th);
            return false;
        }
    }

    public static void j(Context context, JSONObject jSONObject) {
        try {
            boolean a2 = d.a(context, "plc83", true);
            com.baidu.mshield.b.c.a.b("new roo=" + a2);
            if (a2) {
                jSONObject.put(PPSLauncherActivity.Code, "");
                long currentTimeMillis = System.currentTimeMillis();
                String str = (String) com.baidu.xclient.gdid.a.a(20, (Object) null, (Object) null, (Object) null);
                com.baidu.mshield.b.c.a.b("jni root result=" + str + " , time cost=" + (System.currentTimeMillis() - currentTimeMillis));
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put(PPSLauncherActivity.Code, str);
                }
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public static void a(Context context, JSONObject jSONObject) {
        h(context, jSONObject);
        i(context, jSONObject);
        g(context, jSONObject);
        f(context, jSONObject);
        b(context, jSONObject);
        c(context, jSONObject);
        d(context, jSONObject);
        e(context, jSONObject);
        j(context, jSONObject);
    }

    public static String a(List<String> list) {
        if (list == null) {
            return "";
        }
        try {
            if (list.size() <= 0) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next());
                stringBuffer.append(x.aL);
            }
            return stringBuffer.substring(0, stringBuffer.length() - 1);
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }
}
