package com.kwad.sdk.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class t {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static <T> JSONArray O(List<T> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    for (T t : list) {
                        if (t != null) {
                            if (t instanceof JSONObject) {
                                jSONArray.put(t);
                            } else if (t instanceof com.kwad.sdk.core.b) {
                                jSONArray.put(((com.kwad.sdk.core.b) t).toJson());
                            } else if (t instanceof String) {
                                jSONArray.put(t);
                            } else {
                                throw new IllegalArgumentException("<T> now suppprt type: " + t.getClass().getName());
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
        return jSONArray;
    }

    public static void a(JSONObject jSONObject, String str, com.kwad.sdk.core.b bVar) {
        if (jSONObject == null || bVar == null) {
            return;
        }
        try {
            jSONObject.put(str, bVar.toJson());
        } catch (JSONException unused) {
        }
    }

    @NonNull
    public static <T extends com.kwad.sdk.core.b> T b(@Nullable String str, @NonNull com.kwad.sdk.core.c<T> cVar) {
        T BE = cVar.BE();
        try {
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        if (TextUtils.isEmpty(str)) {
            return BE;
        }
        try {
            BE.parseJson(new JSONObject(str));
        } catch (Throwable th2) {
            com.kwad.sdk.core.e.c.printStackTrace(th2);
        }
        return BE;
    }

    public static <T> List<T> gG(String str) {
        return u.gG(str);
    }

    public static <T> List<T> h(JSONArray jSONArray) {
        return u.h(jSONArray);
    }

    public static Map<String, String> parseJSON2MapString(String str) {
        return u.parseJSON2MapString(str);
    }

    public static JSONObject parseMap2JSON(Map<String, String> map) {
        return u.parseMap2JSON(map);
    }

    public static void putValue(JSONObject jSONObject, String str, String str2) {
        if (jSONObject == null) {
            return;
        }
        u.putValue(jSONObject, str, str2);
    }

    public static JSONArray toJsonArray(@NonNull List<String> list) {
        return u.toJsonArray(list);
    }

    public static JSONArray a(JSONArray jSONArray, JSONObject jSONObject) {
        try {
            jSONArray.put(jSONObject);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return jSONArray;
    }

    public static void putValue(JSONObject jSONObject, String str, double d) {
        if (jSONObject == null) {
            return;
        }
        u.putValue(jSONObject, str, d);
    }

    public static void putValue(JSONObject jSONObject, String str, int i) {
        if (jSONObject == null) {
            return;
        }
        u.putValue(jSONObject, str, i);
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2, boolean z) {
        try {
            u.a(jSONObject, jSONObject2, z);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void putValue(JSONObject jSONObject, String str, float f) {
        if (jSONObject == null) {
            return;
        }
        u.putValue(jSONObject, str, f);
    }

    public static void putValue(JSONObject jSONObject, String str, byte b) {
        if (jSONObject == null) {
            return;
        }
        u.putValue(jSONObject, str, b);
    }

    public static <T extends com.kwad.sdk.core.b> List<T> a(String str, @NonNull com.kwad.sdk.core.c<T> cVar) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                T BE = cVar.BE();
                BE.parseJson(jSONObject);
                arrayList.add(BE);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return arrayList;
    }

    public static void putValue(JSONObject jSONObject, String str, long j) {
        if (jSONObject == null) {
            return;
        }
        u.putValue(jSONObject, str, j);
    }

    public static void putValue(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject == null) {
            return;
        }
        u.putValue(jSONObject, str, z);
    }

    public static void putValue(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return;
        }
        u.putValue(jSONObject, str, jSONObject2);
    }

    public static void putValue(JSONObject jSONObject, String str, JSONArray jSONArray) {
        if (jSONObject == null) {
            return;
        }
        u.putValue(jSONObject, str, jSONArray);
    }

    public static void putValue(JSONObject jSONObject, String str, List<?> list) {
        if (jSONObject == null || list == null) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            boolean z = false;
            for (Object obj : list) {
                if (obj instanceof com.kwad.sdk.core.b) {
                    a(jSONArray, ((com.kwad.sdk.core.b) obj).toJson());
                } else {
                    if (!(obj instanceof String) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof JSONObject) && !(obj instanceof JSONArray) && !(obj instanceof Double) && !(obj instanceof Boolean)) {
                        if (!(obj instanceof Float)) {
                            break;
                        } else {
                            try {
                                jSONArray.put(((Float) obj).floatValue());
                            } catch (JSONException unused) {
                            }
                        }
                    }
                    jSONArray.put(obj);
                }
                z = true;
            }
            if (z) {
                putValue(jSONObject, str, jSONArray);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
