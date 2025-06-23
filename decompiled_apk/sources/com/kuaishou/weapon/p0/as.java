package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class as extends dg {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f18312a;

    public as(Context context, int i) {
        if (Engine.loadSuccess) {
            try {
                Engine engine = Engine.getInstance(context);
                int intValue = Integer.valueOf(ck.c).intValue();
                String a2 = a(context);
                if (!TextUtils.isEmpty(a2)) {
                    String eopq = engine.eopq(intValue, 0, i, a2);
                    if (!TextUtils.isEmpty(eopq)) {
                        this.f18312a = new JSONObject(eopq);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public JSONObject a() {
        return this.f18312a;
    }

    public String b(String str) {
        JSONObject jSONObject = this.f18312a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (!TextUtils.isEmpty(string)) {
                    return string.replace("\n", "").replace("\t", " ");
                }
                return string;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public JSONArray c(String str) {
        JSONObject jSONObject = this.f18312a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (!TextUtils.isEmpty(string) && string.length() > 3) {
                    String replaceAll = string.replaceAll("\\n", "");
                    if (!TextUtils.isEmpty(replaceAll)) {
                        string = replaceAll;
                    }
                    JSONArray jSONArray = new JSONArray(string);
                    if (jSONArray.length() > 1) {
                        return jSONArray;
                    }
                    return null;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public JSONObject d(String str) {
        JSONObject jSONObject = this.f18312a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (!TextUtils.isEmpty(string) && string.length() > 2) {
                    JSONObject jSONObject2 = new JSONObject(string);
                    if (jSONObject2.length() > 1) {
                        return jSONObject2;
                    }
                    return null;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public String e(String str) {
        JSONObject jSONObject = this.f18312a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (!TextUtils.isEmpty(string)) {
                    if (string.length() > 2) {
                        return string;
                    }
                    return null;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public String a(String str) {
        JSONObject jSONObject = this.f18312a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    private String a(Context context) {
        try {
            StringBuilder sb = new StringBuilder();
            h a2 = h.a(context, "re_po_rt");
            sb.append(a2.b(df.aa, 1));
            sb.append(a2.b(df.X, 1));
            sb.append(a2.b(df.V, 1));
            sb.append(a2.b(df.Z, 1));
            sb.append(a2.b(df.ab, 1));
            sb.append(a2.b(df.aj, 1));
            sb.append(a2.b(df.Y, 1));
            sb.append(a2.b(df.U, 1));
            sb.append(a2.b(df.am, 1));
            sb.append(a2.b(df.ak, 1));
            sb.append(a2.b(df.al, 1));
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
