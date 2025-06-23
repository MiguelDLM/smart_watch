package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class at {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f18313a;
    private boolean b;
    private boolean c;

    public at(Context context) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.g).intValue(), 0, 100, "");
                if (!TextUtils.isEmpty(pqr)) {
                    this.f18313a = new JSONObject(pqr);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f18313a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONArray b(String str) {
        JSONObject jSONObject = this.f18313a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string) || string.length() <= 3) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(string);
            HashSet hashSet = new HashSet();
            for (int i = 0; i < jSONArray.length(); i++) {
                hashSet.add(jSONArray.getString(i));
            }
            JSONArray jSONArray2 = new JSONArray();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                jSONArray2.put(it.next());
            }
            return jSONArray2;
        } catch (Exception unused) {
            return null;
        }
    }

    public Set c(String str) {
        JSONObject jSONObject = this.f18313a;
        if (jSONObject != null) {
            try {
                String optString = jSONObject.optString(str, null);
                if (!TextUtils.isEmpty(optString) && optString.length() > 3) {
                    HashSet hashSet = new HashSet();
                    JSONArray jSONArray = new JSONArray(optString);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        Integer valueOf = Integer.valueOf((String) jSONArray.get(i), 16);
                        valueOf.intValue();
                        hashSet.add(valueOf);
                    }
                    return hashSet;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public JSONArray d(String str) {
        JSONObject jSONObject = this.f18313a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                int i = 0;
                if (TextUtils.equals(str, "46")) {
                    if (!TextUtils.isEmpty(string) && string.length() > 3) {
                        JSONArray jSONArray = new JSONArray(string);
                        JSONArray jSONArray2 = new JSONArray();
                        while (i < jSONArray.length()) {
                            jSONArray2.put(jSONArray.getString(i).replaceAll(" ", "").replace("\n", "").replace(">", ""));
                            i++;
                        }
                        return jSONArray2;
                    }
                    return null;
                }
                if (TextUtils.equals(str, "45")) {
                    String a2 = i.a("aae31bed33c490b6613a", "0701");
                    String a3 = i.a("99e111e83fc4d0a7662b", "0701");
                    if (!TextUtils.isEmpty(string) && string.length() > 3) {
                        JSONArray jSONArray3 = new JSONArray(string);
                        HashSet hashSet = new HashSet();
                        while (i < jSONArray3.length()) {
                            hashSet.add(jSONArray3.getString(i).replaceAll(" ", "").replace("\n", ""));
                            i++;
                        }
                        JSONArray jSONArray4 = new JSONArray();
                        for (Object obj : hashSet) {
                            jSONArray4.put(obj);
                            String str2 = (String) obj;
                            if (str2.contains(a2)) {
                                this.b = true;
                            }
                            if (str2.contains(a3)) {
                                this.c = true;
                            }
                        }
                        return jSONArray4;
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

    public Set a(int i) {
        HashSet hashSet = new HashSet();
        if (i == 0) {
            hashSet.add("/preas/chi");
        }
        return hashSet;
    }

    public Set a(Context context, String str, int i) {
        JSONObject jSONObject = this.f18313a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            Set a2 = a(i);
            if (TextUtils.isEmpty(string) || string.length() <= 3) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(string);
            HashSet hashSet = new HashSet();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String replace = jSONArray.getString(i2).replaceAll(" ", "").replace("\n", "").replace("\t", "").replace("\u200b", "");
                boolean startsWith = replace.startsWith(":");
                String str2 = replace;
                if (startsWith) {
                    str2 = replace.substring(1);
                }
                String substring = str2.length() > 10 ? str2.substring(0, 10) : str2;
                String packageName = context.getPackageName();
                if (!str2.contains(packageName) && !packageName.contains(str2) && !a2.contains(substring)) {
                    hashSet.add(str2);
                }
            }
            if (hashSet.size() > 0) {
                return hashSet;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean b() {
        return this.c;
    }

    public boolean a() {
        return this.b;
    }
}
