package com.facebook.share.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import com.facebook.share.model.CameraEffectArguments;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Xo0;
import kotlin.collections.o0;
import kotlin.jvm.internal.IIX0o;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class CameraEffectJSONUtility {

    @OOXIXo
    public static final CameraEffectJSONUtility INSTANCE = new CameraEffectJSONUtility();

    @OOXIXo
    private static final HashMap<Class<?>, Setter> SETTERS = o0.oOXoIIIo(Xo0.oIX0oI(String.class, new Setter() { // from class: com.facebook.share.internal.CameraEffectJSONUtility$SETTERS$1
        @Override // com.facebook.share.internal.CameraEffectJSONUtility.Setter
        public void setOnArgumentsBuilder(@OOXIXo CameraEffectArguments.Builder builder, @OOXIXo String key, @oOoXoXO Object obj) throws JSONException {
            IIX0o.x0xO0oo(builder, "builder");
            IIX0o.x0xO0oo(key, "key");
            if (obj != null) {
                builder.putArgument(key, (String) obj);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }

        @Override // com.facebook.share.internal.CameraEffectJSONUtility.Setter
        public void setOnJSON(@OOXIXo JSONObject json, @OOXIXo String key, @oOoXoXO Object obj) throws JSONException {
            IIX0o.x0xO0oo(json, "json");
            IIX0o.x0xO0oo(key, "key");
            json.put(key, obj);
        }
    }), Xo0.oIX0oI(String[].class, new Setter() { // from class: com.facebook.share.internal.CameraEffectJSONUtility$SETTERS$2
        @Override // com.facebook.share.internal.CameraEffectJSONUtility.Setter
        public void setOnArgumentsBuilder(@OOXIXo CameraEffectArguments.Builder builder, @OOXIXo String key, @oOoXoXO Object obj) throws JSONException {
            IIX0o.x0xO0oo(builder, "builder");
            IIX0o.x0xO0oo(key, "key");
            throw new IllegalArgumentException("Unexpected type from JSON");
        }

        @Override // com.facebook.share.internal.CameraEffectJSONUtility.Setter
        public void setOnJSON(@OOXIXo JSONObject json, @OOXIXo String key, @oOoXoXO Object obj) throws JSONException {
            IIX0o.x0xO0oo(json, "json");
            IIX0o.x0xO0oo(key, "key");
            JSONArray jSONArray = new JSONArray();
            if (obj != null) {
                String[] strArr = (String[]) obj;
                int length = strArr.length;
                int i = 0;
                while (i < length) {
                    String str = strArr[i];
                    i++;
                    jSONArray.put(str);
                }
                json.put(key, jSONArray);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String?>");
        }
    }), Xo0.oIX0oI(JSONArray.class, new Setter() { // from class: com.facebook.share.internal.CameraEffectJSONUtility$SETTERS$3
        @Override // com.facebook.share.internal.CameraEffectJSONUtility.Setter
        public void setOnArgumentsBuilder(@OOXIXo CameraEffectArguments.Builder builder, @OOXIXo String key, @oOoXoXO Object obj) throws JSONException {
            IIX0o.x0xO0oo(builder, "builder");
            IIX0o.x0xO0oo(key, "key");
            if (obj != null) {
                JSONArray jSONArray = (JSONArray) obj;
                ArrayList arrayList = new ArrayList();
                int length = jSONArray.length();
                if (length > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i + 1;
                        Object obj2 = jSONArray.get(i);
                        if (obj2 instanceof String) {
                            arrayList.add(obj2);
                            if (i2 >= length) {
                                break;
                            } else {
                                i = i2;
                            }
                        } else {
                            throw new IllegalArgumentException(IIX0o.XIxXXX0x0("Unexpected type in an array: ", obj2.getClass()));
                        }
                    }
                }
                Object[] array = arrayList.toArray(new String[0]);
                if (array != null) {
                    builder.putArgument(key, (String[]) array);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
        }

        @Override // com.facebook.share.internal.CameraEffectJSONUtility.Setter
        public void setOnJSON(@OOXIXo JSONObject json, @OOXIXo String key, @oOoXoXO Object obj) throws JSONException {
            IIX0o.x0xO0oo(json, "json");
            IIX0o.x0xO0oo(key, "key");
            throw new IllegalArgumentException("JSONArray's are not supported in bundles.");
        }
    }));

    /* loaded from: classes8.dex */
    public interface Setter {
        void setOnArgumentsBuilder(@OOXIXo CameraEffectArguments.Builder builder, @OOXIXo String str, @oOoXoXO Object obj) throws JSONException;

        void setOnJSON(@OOXIXo JSONObject jSONObject, @OOXIXo String str, @oOoXoXO Object obj) throws JSONException;
    }

    private CameraEffectJSONUtility() {
    }

    @x0XOIxOo
    @oOoXoXO
    public static final CameraEffectArguments convertToCameraEffectArguments(@oOoXoXO JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        CameraEffectArguments.Builder builder = new CameraEffectArguments.Builder();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            Object obj = jSONObject.get(key);
            if (obj != JSONObject.NULL) {
                Setter setter = SETTERS.get(obj.getClass());
                if (setter != null) {
                    IIX0o.oO(key, "key");
                    setter.setOnArgumentsBuilder(builder, key, obj);
                } else {
                    throw new IllegalArgumentException(IIX0o.XIxXXX0x0("Unsupported type: ", obj.getClass()));
                }
            }
        }
        return builder.build();
    }

    @x0XOIxOo
    @oOoXoXO
    public static final JSONObject convertToJSON(@oOoXoXO CameraEffectArguments cameraEffectArguments) throws JSONException {
        if (cameraEffectArguments == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : cameraEffectArguments.keySet()) {
            Object obj = cameraEffectArguments.get(str);
            if (obj != null) {
                Setter setter = SETTERS.get(obj.getClass());
                if (setter != null) {
                    setter.setOnJSON(jSONObject, str, obj);
                } else {
                    throw new IllegalArgumentException(IIX0o.XIxXXX0x0("Unsupported type: ", obj.getClass()));
                }
            }
        }
        return jSONObject;
    }
}
