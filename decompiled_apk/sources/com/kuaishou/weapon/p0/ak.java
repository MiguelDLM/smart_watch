package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class ak {
    private static final String A = "b3JnLnNhbmRyb3Byb3h5LmRyb255";
    private static final String B = "aW8ueHVkd29mdGVuY2VudG1t";
    private static final String C = "Y29tLmp0anNiLnZpcnR1YWxkd3Nx";
    private static final String D = "Y29tLnR4eS5hbnl3aGVyZQ==";
    private static final String E = "Y29tLmRpbmd3ZWkueHVuaWpp";
    private static final String F = "bWUud2Vpc2h1LmV4cA==";
    private static final String G = "Y29tLnZhcmlhYmxlLmFwa2hvb2s=";
    private static final String H = "ZXUuZmFpcmNvZGUueGx1YQ==";
    private static final String I = "Y29tLnRvcGpvaG53dS5tYWdpc2s=";
    private static final String J = "Y29tLndpbmQuY290dGVy";
    private static final String K = "bW9iaS5hY3BtLmluc3BlY2thZ2U=";

    /* renamed from: a, reason: collision with root package name */
    private static final String f18306a = "Y29tLmdpdGh1Yi51aWF1dG9tYXRvcg==";
    private static final String b = "Y29tLmJ1c2NvZGUud2hhdHNpbnB1dA==";
    private static final String c = "b3JnLmF1dG9qcy5hdXRvanM=";
    private static final String d = "ZGUucm9idi5hbmRyb2lkLnhwb3NlZC5pbnN0YWxsZXI=";
    private static final String e = "Y29tLnNhbmZlbmdhbmRyb2lkLmRhdGFmaWx0ZXI=";
    private static final String f = "aXQuZXZpbHNvY2tldC5kc3Bsb2l0";
    private static final String g = "dWsuZGlnaXRhbHNxdWlkLm5ldHNwb29mZXI=";
    private static final String h = "Y29tLm13ci5keg==";
    private static final String i = "Y29tLm1ldGFzcGxvaXQuc3RhZ2U=";
    private static final String j = "Y29tLng4enMuc2FuZGJveA==";
    private static final String k = "Y29tLmYxcGxheWVy";
    private static final String l = "Y29tLmNvZmZhY2UuaXZhZGVy";
    private static final String m = "Y29tLmRldmljZS5lbXVsYXRvci5wcnA=";
    private static final String n = "Y29tLnVuaXF1ZS5tb2JpbGVmYWtlcg==";
    private static final String o = "bmV0LmdkaS5tb2R1bGUuYXBweA==";
    private static final String p = "b3JnLm1va2VlLm1rc2V0dGluZ3M=";
    private static final String q = "Y29tLm1pbmkubGl2ZS5saXZl";
    private static final String r = "dG9wLm5pdW5haWp1bi5ibGFja2JveGEzMg==";
    private static final String s = "dG9wLm5pdW5haWp1bi5ibGFja2JveGE2NA==";
    private static final String t = "dG9wLm5pdW5haWp1bi5ibGFja2RleGEzMg==";
    private static final String u = "dG9wLm5pdW5haWp1bi5ibGFja2RleGE2NA==";
    private static final String v = "aW8udmlydHVhbGFwcC5zYW5kdnhwb3NlZDMy";
    private static final String w = "aW8udmlydHVhbGFwcC5zYW5kdnhwb3NlZDY0";
    private static final String x = "enBwLndqeS56cG9zZWQuaW5zdGFsbGVy";
    private static final String y = "Y29tLnNrLnNwcm9tb3Rlcg==";
    private static final String z = "Y29tLnNlc2FtZS5wcm94eQ==";

    private JSONObject n(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (a(context, f)) {
                jSONObject.put("0", 1);
            }
            if (a(context, g)) {
                jSONObject.put("1", 1);
            }
            if (a(context, h)) {
                jSONObject.put("2", 1);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private JSONObject o(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (a(context, f18306a)) {
                jSONObject.put("0", 1);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private JSONObject p(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (a(context, j)) {
                jSONObject.put("0", 1);
            }
            if (a(context, k)) {
                jSONObject.put("1", 1);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private JSONObject q(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (a(context, l)) {
                jSONObject.put("0", 1);
            }
            if (a(context, m)) {
                jSONObject.put("1", 1);
            }
            if (a(context, n)) {
                jSONObject.put("2", 1);
            }
            if (a(context, o)) {
                jSONObject.put("3", 1);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private JSONObject r(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (a(context, p)) {
                jSONObject.put("0", 1);
            }
            if (a(context, q)) {
                jSONObject.put("1", 1);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", a(context, f18306a) ? 1 : 0);
            jSONObject.put("1", a(context, b) ? 1 : 0);
            jSONObject.put("2", a(context, c) ? 1 : 0);
            jSONObject.put("3", a(context, d) ? 1 : 0);
            jSONObject.put("4", a(context, e) ? 1 : 0);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public int b(Context context) {
        if (a(context, i)) {
            return 1;
        }
        return 0;
    }

    public JSONObject c(Context context) {
        try {
            JSONObject o2 = o(context);
            if (o2 != null) {
                if (o2.length() > 0) {
                    return o2;
                }
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject d(Context context) {
        try {
            JSONObject n2 = n(context);
            if (n2 != null) {
                if (n2.length() > 0) {
                    return n2;
                }
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject e(Context context) {
        try {
            JSONObject p2 = p(context);
            if (p2 != null) {
                if (p2.length() > 0) {
                    return p2;
                }
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject f(Context context) {
        try {
            JSONObject q2 = q(context);
            if (q2 != null) {
                if (q2.length() > 0) {
                    return q2;
                }
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject g(Context context) {
        try {
            JSONObject r2 = r(context);
            if (r2 != null) {
                if (r2.length() > 0) {
                    return r2;
                }
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject h(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(r);
            arrayList.add(s);
            JSONObject a2 = a(context, arrayList);
            if (a2 != null) {
                if (a2.length() > 0) {
                    return a2;
                }
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject i(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(v);
            arrayList.add(w);
            arrayList.add(J);
            arrayList.add(K);
            JSONObject a2 = a(context, arrayList);
            if (a2 != null) {
                if (a2.length() > 0) {
                    return a2;
                }
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject j(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(x);
            arrayList.add(y);
            arrayList.add(G);
            arrayList.add(H);
            arrayList.add(I);
            JSONObject a2 = a(context, arrayList);
            if (a2 != null) {
                if (a2.length() > 0) {
                    return a2;
                }
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject k(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(z);
            arrayList.add(A);
            JSONObject a2 = a(context, arrayList);
            if (a2 != null) {
                if (a2.length() > 0) {
                    return a2;
                }
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject l(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(B);
            arrayList.add(C);
            arrayList.add(D);
            arrayList.add(E);
            arrayList.add(F);
            JSONObject a2 = a(context, arrayList);
            if (a2 != null) {
                if (a2.length() > 0) {
                    return a2;
                }
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject m(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(t);
            arrayList.add(u);
            JSONObject a2 = a(context, arrayList);
            if (a2 != null) {
                if (a2.length() > 0) {
                    return a2;
                }
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private static boolean a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (!str.contains(FileUtils.FILE_EXTENSION_SEPARATOR)) {
                str = new String(c.a(str.getBytes(), 2));
            }
            context.getPackageManager().getApplicationInfo(str, 0);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private JSONObject a(Context context, List<String> list) {
        if (list == null) {
            return null;
        }
        try {
            if (list.size() <= 0) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (a(context, list.get(i2))) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(i2);
                    jSONObject.put(sb.toString(), 1);
                }
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a() {
        try {
            StringBuilder sb = new StringBuilder();
            String[] strArr = {"/data/dalvik-cache/xposed_XResourcesSuperClass.dex", "data/dalvik-cache/xposed_XTypedArraySuperClass.dex", "/system/bin/androVM-prop", "/system/bin/nemuVM-prop", "/system/bin/ldmountsf", "/system/bin/noxspeedup", "/system/bin/nox-vbox-sf", "/system/bin/nox-prop", "/dev/qemu_pipe", "/dev/socket/qemud", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/genyd", "/dev/socket/baseband_genyd", "/system/bin/ttVM-prop", "/system/bin/3btrans", "/system/bin/droid4x-prop", "/ueventd.nox.rc", "/init.nox.rc"};
            for (int i2 = 0; i2 < 20; i2++) {
                if (new File(strArr[i2]).exists()) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
