package com.facebook.internal;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class BundleJSONConverter {

    @OXOo.OOXIXo
    public static final BundleJSONConverter INSTANCE = new BundleJSONConverter();

    @OXOo.OOXIXo
    private static final Map<Class<?>, Setter> SETTERS;

    /* loaded from: classes8.dex */
    public interface Setter {
        void setOnBundle(@OXOo.OOXIXo Bundle bundle, @OXOo.OOXIXo String str, @OXOo.OOXIXo Object obj) throws JSONException;

        void setOnJSON(@OXOo.OOXIXo JSONObject jSONObject, @OXOo.OOXIXo String str, @OXOo.OOXIXo Object obj) throws JSONException;
    }

    static {
        HashMap hashMap = new HashMap();
        SETTERS = hashMap;
        hashMap.put(Boolean.class, new Setter() { // from class: com.facebook.internal.BundleJSONConverter.1
            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnBundle(@OXOo.OOXIXo Bundle bundle, @OXOo.OOXIXo String key, @OXOo.OOXIXo Object value) throws JSONException {
                IIX0o.x0xO0oo(bundle, "bundle");
                IIX0o.x0xO0oo(key, "key");
                IIX0o.x0xO0oo(value, "value");
                bundle.putBoolean(key, ((Boolean) value).booleanValue());
            }

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnJSON(@OXOo.OOXIXo JSONObject json, @OXOo.OOXIXo String key, @OXOo.OOXIXo Object value) throws JSONException {
                IIX0o.x0xO0oo(json, "json");
                IIX0o.x0xO0oo(key, "key");
                IIX0o.x0xO0oo(value, "value");
                json.put(key, value);
            }
        });
        hashMap.put(Integer.class, new Setter() { // from class: com.facebook.internal.BundleJSONConverter.2
            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnBundle(@OXOo.OOXIXo Bundle bundle, @OXOo.OOXIXo String key, @OXOo.OOXIXo Object value) throws JSONException {
                IIX0o.x0xO0oo(bundle, "bundle");
                IIX0o.x0xO0oo(key, "key");
                IIX0o.x0xO0oo(value, "value");
                bundle.putInt(key, ((Integer) value).intValue());
            }

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnJSON(@OXOo.OOXIXo JSONObject json, @OXOo.OOXIXo String key, @OXOo.OOXIXo Object value) throws JSONException {
                IIX0o.x0xO0oo(json, "json");
                IIX0o.x0xO0oo(key, "key");
                IIX0o.x0xO0oo(value, "value");
                json.put(key, value);
            }
        });
        hashMap.put(Long.class, new Setter() { // from class: com.facebook.internal.BundleJSONConverter.3
            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnBundle(@OXOo.OOXIXo Bundle bundle, @OXOo.OOXIXo String key, @OXOo.OOXIXo Object value) throws JSONException {
                IIX0o.x0xO0oo(bundle, "bundle");
                IIX0o.x0xO0oo(key, "key");
                IIX0o.x0xO0oo(value, "value");
                bundle.putLong(key, ((Long) value).longValue());
            }

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnJSON(@OXOo.OOXIXo JSONObject json, @OXOo.OOXIXo String key, @OXOo.OOXIXo Object value) throws JSONException {
                IIX0o.x0xO0oo(json, "json");
                IIX0o.x0xO0oo(key, "key");
                IIX0o.x0xO0oo(value, "value");
                json.put(key, value);
            }
        });
        hashMap.put(Double.class, new Setter() { // from class: com.facebook.internal.BundleJSONConverter.4
            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnBundle(@OXOo.OOXIXo Bundle bundle, @OXOo.OOXIXo String key, @OXOo.OOXIXo Object value) throws JSONException {
                IIX0o.x0xO0oo(bundle, "bundle");
                IIX0o.x0xO0oo(key, "key");
                IIX0o.x0xO0oo(value, "value");
                bundle.putDouble(key, ((Double) value).doubleValue());
            }

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnJSON(@OXOo.OOXIXo JSONObject json, @OXOo.OOXIXo String key, @OXOo.OOXIXo Object value) throws JSONException {
                IIX0o.x0xO0oo(json, "json");
                IIX0o.x0xO0oo(key, "key");
                IIX0o.x0xO0oo(value, "value");
                json.put(key, value);
            }
        });
        hashMap.put(String.class, new Setter() { // from class: com.facebook.internal.BundleJSONConverter.5
            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnBundle(@OXOo.OOXIXo Bundle bundle, @OXOo.OOXIXo String key, @OXOo.OOXIXo Object value) throws JSONException {
                IIX0o.x0xO0oo(bundle, "bundle");
                IIX0o.x0xO0oo(key, "key");
                IIX0o.x0xO0oo(value, "value");
                bundle.putString(key, (String) value);
            }

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnJSON(@OXOo.OOXIXo JSONObject json, @OXOo.OOXIXo String key, @OXOo.OOXIXo Object value) throws JSONException {
                IIX0o.x0xO0oo(json, "json");
                IIX0o.x0xO0oo(key, "key");
                IIX0o.x0xO0oo(value, "value");
                json.put(key, value);
            }
        });
        hashMap.put(String[].class, new Setter() { // from class: com.facebook.internal.BundleJSONConverter.6
            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnBundle(@OXOo.OOXIXo Bundle bundle, @OXOo.OOXIXo String key, @OXOo.OOXIXo Object value) throws JSONException {
                IIX0o.x0xO0oo(bundle, "bundle");
                IIX0o.x0xO0oo(key, "key");
                IIX0o.x0xO0oo(value, "value");
                throw new IllegalArgumentException("Unexpected type from JSON");
            }

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnJSON(@OXOo.OOXIXo JSONObject json, @OXOo.OOXIXo String key, @OXOo.OOXIXo Object value) throws JSONException {
                IIX0o.x0xO0oo(json, "json");
                IIX0o.x0xO0oo(key, "key");
                IIX0o.x0xO0oo(value, "value");
                JSONArray jSONArray = new JSONArray();
                String[] strArr = (String[]) value;
                int length = strArr.length;
                int i = 0;
                while (i < length) {
                    String str = strArr[i];
                    i++;
                    jSONArray.put(str);
                }
                json.put(key, jSONArray);
            }
        });
        hashMap.put(JSONArray.class, new Setter() { // from class: com.facebook.internal.BundleJSONConverter.7
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnBundle(@OXOo.OOXIXo Bundle bundle, @OXOo.OOXIXo String key, @OXOo.OOXIXo Object value) throws JSONException {
                IIX0o.x0xO0oo(bundle, "bundle");
                IIX0o.x0xO0oo(key, "key");
                IIX0o.x0xO0oo(value, "value");
                JSONArray jSONArray = (JSONArray) value;
                ArrayList arrayList = new ArrayList();
                if (jSONArray.length() == 0) {
                    bundle.putStringArrayList(key, arrayList);
                    return;
                }
                int length = jSONArray.length();
                if (length > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i + 1;
                        Object obj = jSONArray.get(i);
                        if (obj instanceof String) {
                            arrayList.add(obj);
                            if (i2 >= length) {
                                break;
                            } else {
                                i = i2;
                            }
                        } else {
                            throw new IllegalArgumentException(IIX0o.XIxXXX0x0("Unexpected type in an array: ", obj.getClass()));
                        }
                    }
                }
                bundle.putStringArrayList(key, arrayList);
            }

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnJSON(@OXOo.OOXIXo JSONObject json, @OXOo.OOXIXo String key, @OXOo.OOXIXo Object value) throws JSONException {
                IIX0o.x0xO0oo(json, "json");
                IIX0o.x0xO0oo(key, "key");
                IIX0o.x0xO0oo(value, "value");
                throw new IllegalArgumentException("JSONArray's are not supported in bundles.");
            }
        });
    }

    private BundleJSONConverter() {
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final Bundle convertToBundle(@OXOo.OOXIXo JSONObject jsonObject) throws JSONException {
        IIX0o.x0xO0oo(jsonObject, "jsonObject");
        Bundle bundle = new Bundle();
        Iterator<String> keys = jsonObject.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            Object value = jsonObject.get(key);
            if (value != JSONObject.NULL) {
                if (value instanceof JSONObject) {
                    bundle.putBundle(key, convertToBundle((JSONObject) value));
                } else {
                    Setter setter = SETTERS.get(value.getClass());
                    if (setter != null) {
                        IIX0o.oO(key, "key");
                        IIX0o.oO(value, "value");
                        setter.setOnBundle(bundle, key, value);
                    } else {
                        throw new IllegalArgumentException(IIX0o.XIxXXX0x0("Unsupported type: ", value.getClass()));
                    }
                }
            }
        }
        return bundle;
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final JSONObject convertToJSON(@OXOo.OOXIXo Bundle bundle) throws JSONException {
        IIX0o.x0xO0oo(bundle, "bundle");
        JSONObject jSONObject = new JSONObject();
        for (String key : bundle.keySet()) {
            Object obj = bundle.get(key);
            if (obj != null) {
                if (obj instanceof List) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = ((List) obj).iterator();
                    while (it.hasNext()) {
                        jSONArray.put((String) it.next());
                    }
                    jSONObject.put(key, jSONArray);
                } else if (obj instanceof Bundle) {
                    jSONObject.put(key, convertToJSON((Bundle) obj));
                } else {
                    Setter setter = SETTERS.get(obj.getClass());
                    if (setter != null) {
                        IIX0o.oO(key, "key");
                        setter.setOnJSON(jSONObject, key, obj);
                    } else {
                        throw new IllegalArgumentException(IIX0o.XIxXXX0x0("Unsupported type: ", obj.getClass()));
                    }
                }
            }
        }
        return jSONObject;
    }
}
