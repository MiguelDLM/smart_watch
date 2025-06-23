package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class ba {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f18321a;

    public ba(Context context, int i) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.c).intValue(), 2, i < 10 ? 10 : i, "");
                if (!TextUtils.isEmpty(pqr)) {
                    this.f18321a = new JSONObject(pqr);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f18321a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject b(String str) {
        if (this.f18321a != null) {
            try {
                String a2 = a(str);
                if (!TextUtils.isEmpty(a2) && a2.length() > 3) {
                    return new JSONObject(a2);
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public JSONArray c(String str) {
        JSONObject jSONObject = this.f18321a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (!TextUtils.isEmpty(string) && string.length() > 2) {
                    JSONArray jSONArray = new JSONArray(string);
                    HashSet hashSet = new HashSet();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        hashSet.add((String) jSONArray.get(i));
                    }
                    Set a2 = a(hashSet);
                    if (a2 != null && a2.size() > 0) {
                        return new JSONArray((Collection) a2);
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
        if (this.f18321a != null) {
            try {
                String a2 = a(str);
                if (!TextUtils.isEmpty(a2) && a2.length() > 3) {
                    return a(new JSONObject(a2));
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public JSONObject a(String str, boolean z) {
        if (this.f18321a != null) {
            try {
                String a2 = a(str);
                if (!TextUtils.isEmpty(a2) && a2.length() > 3) {
                    JSONObject jSONObject = new JSONObject(a2);
                    if (!z) {
                        return jSONObject;
                    }
                    Iterator<String> keys = jSONObject.keys();
                    boolean z2 = false;
                    while (keys.hasNext()) {
                        if (jSONObject.getInt(keys.next()) == 1) {
                            z2 = true;
                        }
                    }
                    if (z2) {
                        return jSONObject;
                    }
                    return null;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public boolean a(Set set, String str) {
        try {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (!str2.equals(str) && str2.contains(str)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public Set a(Set set) {
        if (set != null) {
            try {
                if (set.size() > 0) {
                    HashSet hashSet = new HashSet();
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        if (!a(set, str)) {
                            hashSet.add(str);
                        }
                    }
                    return hashSet;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public JSONObject a(JSONObject jSONObject) {
        try {
            String a2 = i.a("da4c6c97b9", "0702");
            String a3 = i.a("da4c709eb15f", "0702");
            JSONArray optJSONArray = jSONObject.optJSONArray(a2);
            JSONArray optJSONArray2 = jSONObject.optJSONArray(a3);
            JSONObject jSONObject2 = new JSONObject();
            if (optJSONArray != null && optJSONArray.length() == 3) {
                jSONObject2.put("0", optJSONArray.get(2));
            }
            if (optJSONArray2 != null && optJSONArray2.length() == 3) {
                jSONObject2.put("1", optJSONArray2.get(2));
            }
            if (jSONObject2.length() > 0) {
                return jSONObject2;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
