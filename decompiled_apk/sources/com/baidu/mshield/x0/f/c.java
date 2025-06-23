package com.baidu.mshield.x0.f;

import android.content.Context;
import android.os.Binder;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.x;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: classes7.dex */
public class c {
    public static int a(Context context) {
        String b;
        String[] c;
        int i;
        int length;
        try {
            b = b(context);
            c = c(context);
            try {
                i = Binder.getCallingUid();
            } catch (Throwable th) {
                com.baidu.mshield.x0.b.d.a(th);
                i = 0;
            }
            length = String.valueOf(i).length();
        } catch (Throwable th2) {
            com.baidu.mshield.x0.b.d.a(th2);
        }
        if (a(c) && a(b) && length < 6) {
            return 1;
        }
        if (!(a(c) && a(b)) && length >= 6) {
            return 2;
        }
        if (a(c)) {
            if (a(b) && length >= 6) {
                return 3;
            }
        }
        return 0;
    }

    public static String b(Context context) {
        try {
            Class d = com.baidu.mshield.b.e.a.d(context);
            if (d != null) {
                return d.getMethod("getService", String.class).invoke(d.newInstance(), "phone").getClass().getCanonicalName();
            }
            return null;
        } catch (Throwable th) {
            com.baidu.mshield.x0.b.d.a(th);
            return null;
        }
    }

    public static String[] c(Context context) {
        String[] strArr = new String[2];
        try {
            if (com.baidu.mshield.x0.b.d.a(context, "plc94", false)) {
                return strArr;
            }
            long currentTimeMillis = System.currentTimeMillis();
            d dVar = new d(context.getMainLooper(), strArr);
            dVar.sendEmptyMessage(1);
            while (System.currentTimeMillis() - currentTimeMillis < 100) {
                Thread.sleep(10L);
                if (TextUtils.isEmpty(strArr[0]) && TextUtils.isEmpty(strArr[1])) {
                    break;
                }
            }
            dVar.removeCallbacksAndMessages(null);
            com.baidu.mshield.b.c.a.b(" spend time : " + (System.currentTimeMillis() - currentTimeMillis) + "");
            return strArr;
        } catch (Throwable th) {
            com.baidu.mshield.x0.b.d.a(th);
            return strArr;
        }
    }

    public static String d(Context context) {
        try {
            Object invoke = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", null).invoke(null, null);
            Field declaredField = invoke.getClass().getDeclaredField("mPackages");
            boolean z = true;
            declaredField.setAccessible(true);
            Map map = (Map) declaredField.get(invoke);
            if (map != null && map.size() > 0) {
                ArrayList<String> arrayList = new ArrayList();
                for (Object obj : map.keySet()) {
                    String obj2 = obj.toString();
                    if (obj.toString().length() > 1 && !obj2.equals(context.getPackageName()) && !obj2.endsWith("android.webview") && !obj2.startsWith("com.baidu.")) {
                        context.getPackageManager().getApplicationInfo(obj.toString(), 0);
                        File file = new File("/data/data/" + obj.toString());
                        if (file.exists() && file.canWrite()) {
                            arrayList.add(obj.toString());
                        }
                    }
                }
                StringBuffer stringBuffer = new StringBuffer();
                for (String str : arrayList) {
                    if (!z) {
                        stringBuffer.append(x.aL);
                    }
                    stringBuffer.append(str);
                    z = false;
                }
                return stringBuffer.toString();
            }
            return "";
        } catch (Throwable th) {
            com.baidu.mshield.x0.b.d.a(th);
            return "";
        }
    }

    public static List<String> e(Context context) {
        try {
            List<String> a2 = a(context, com.baidu.mshield.x0.b.d.f());
            if (a2 != null && a2.size() > 0) {
                Iterator<String> it = a2.iterator();
                while (it.hasNext()) {
                    com.baidu.mshield.b.c.a.b("vpn app:" + it.next());
                }
            }
            return a2;
        } catch (Throwable th) {
            com.baidu.mshield.x0.b.d.a(th);
            return null;
        }
    }

    public static boolean a(String[] strArr) {
        String str;
        if (strArr == null) {
            return false;
        }
        try {
            str = strArr[0];
        } catch (Throwable th) {
            com.baidu.mshield.x0.b.d.a(th);
        }
        if (str != null && !str.equals("android.app.Instrumentation")) {
            return true;
        }
        String str2 = strArr[1];
        if (str2 != null) {
            if (!str2.equals("android.app.ActivityManagerProxy")) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(String str) {
        try {
        } catch (Throwable th) {
            com.baidu.mshield.x0.b.d.a(th);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return !"android.os.BinderProxy".equals(str);
    }

    public static List<String> a(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                String string = jSONArray.getString(i);
                if (com.baidu.mshield.b.e.c.a(context, string, 0) != null) {
                    arrayList.add(string);
                }
            }
            return arrayList;
        } catch (Throwable th) {
            com.baidu.mshield.x0.b.d.a(th);
            return null;
        }
    }
}
