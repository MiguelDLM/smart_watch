package com.tenmeter.smlibrary.utils;

import XIXIX.OOXIXo;
import com.tenmeter.smlibrary.entity.BaseBean;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* loaded from: classes13.dex */
public class JsonConvert {
    private static final String TAG = "jsonUtil";
    private static JSONObject jsonObject;

    private JsonConvert(String str) {
        KLog.i(TAG, "json=" + str);
        JSONObject jsonObject2 = getJsonObject(str);
        jsonObject = jsonObject2;
        if (jsonObject2 == null) {
            KLog.e(TAG, "jsonobject is null");
        }
    }

    public static List<Object> JsonArrayToList(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                Object obj = jSONArray.get(i);
                if (obj != null) {
                    if (obj instanceof JSONObject) {
                        arrayList.add(JsonObjectToMap((JSONObject) obj));
                    } else if (obj instanceof JSONArray) {
                        arrayList.add(JsonArrayToList((JSONArray) obj));
                    } else {
                        arrayList.add(obj);
                    }
                }
            }
        }
        return arrayList;
    }

    public static Map<String, Object> JsonObjectToMap(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                if (obj != null) {
                    if (obj instanceof JSONObject) {
                        hashMap.put(next, JsonObjectToMap((JSONObject) obj));
                    } else if (obj instanceof JSONArray) {
                        hashMap.put(next, JsonArrayToList((JSONArray) obj));
                    } else {
                        hashMap.put(next, obj);
                    }
                } else {
                    hashMap.put(next, null);
                }
            }
        }
        return hashMap;
    }

    public static Object JsonObjectToObject(JSONObject jSONObject, Field field) throws JSONException {
        switch (getType(field.getType())) {
            case 0:
                return jSONObject.opt(field.getName());
            case 1:
                return Integer.valueOf(jSONObject.optInt(field.getName()));
            case 2:
                return Long.valueOf(jSONObject.optLong(field.getName()));
            case 3:
            case 4:
                return Double.valueOf(jSONObject.optDouble(field.getName()));
            case 5:
                return Boolean.valueOf(jSONObject.optBoolean(field.getName()));
            case 6:
            case 7:
            case 8:
                return jSONObject.optJSONArray(field.getName());
            case 9:
                return JsonArrayToList(jSONObject.optJSONArray(field.getName()));
            case 10:
                return JsonObjectToMap(jSONObject.optJSONObject(field.getName()));
            default:
                return null;
        }
    }

    public static Object MapToObject(Object obj, Map<?, ?> map) throws IllegalAccessException {
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            field.set(obj, map.get(field.getName()));
        }
        return obj;
    }

    public static <T> T fromJson(String str, Class<T> cls) throws JSONException, NullPointerException, IllegalAccessException, InstantiationException {
        if (str != null && !str.equals("")) {
            T newInstance = cls.newInstance();
            Field[] declaredFields = cls.getDeclaredFields();
            JSONObject jSONObject = (JSONObject) new JSONTokener(str).nextValue();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                field.set(newInstance, JsonObjectToObject(jSONObject, field));
            }
            return newInstance;
        }
        throw new NullPointerException("JsonString can't be null");
    }

    public static List<String> getAllKey(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                arrayList.add(next.toString());
                if (jSONObject.get(next) instanceof JSONObject) {
                    arrayList.addAll(getAllKey((JSONObject) jSONObject.get(next)));
                } else if (jSONObject.get(next) instanceof JSONArray) {
                    arrayList.addAll(getAllKey((JSONArray) jSONObject.get(next)));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public static String getFieldValue(Class<?> cls, Object obj) throws IllegalArgumentException, IllegalAccessException {
        StringBuffer stringBuffer = new StringBuffer();
        Field[] fields = cls.getFields();
        for (int i = 0; i < fields.length; i++) {
            stringBuffer.append(fields[i].getName() + "=" + fields[i].get(obj));
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }

    public static List<Object> getList(String str, Class<?> cls) throws Exception {
        JSONObject jSONObject = jsonObject;
        if (jSONObject == null) {
            return null;
        }
        JSONArray jSONArray = jSONObject.getJSONArray(str);
        if (jSONArray.isNull(0)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(getObject(jSONArray.getJSONObject(i), null, cls));
        }
        return arrayList;
    }

    public static int getType(Class<?> cls) {
        if (cls != null) {
            if (!String.class.isAssignableFrom(cls) && !Character.class.isAssignableFrom(cls)) {
                Class cls2 = Character.TYPE;
                if (cls2.isAssignableFrom(cls) || cls2.isAssignableFrom(cls)) {
                    return 0;
                }
            } else {
                return 0;
            }
        }
        if (cls != null) {
            Class cls3 = Byte.TYPE;
            if (!cls3.isAssignableFrom(cls)) {
                Class cls4 = Short.TYPE;
                if (!cls4.isAssignableFrom(cls)) {
                    Class cls5 = Integer.TYPE;
                    if (cls5.isAssignableFrom(cls) || Integer.class.isAssignableFrom(cls) || Number.class.isAssignableFrom(cls) || cls5.isAssignableFrom(cls) || cls3.isAssignableFrom(cls) || cls4.isAssignableFrom(cls)) {
                        return 1;
                    }
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }
        if (cls != null) {
            Class cls6 = Long.TYPE;
            if (cls6.isAssignableFrom(cls) || cls6.isAssignableFrom(cls)) {
                return 2;
            }
        }
        if (cls != null) {
            Class cls7 = Float.TYPE;
            if (cls7.isAssignableFrom(cls) || cls7.isAssignableFrom(cls)) {
                return 3;
            }
        }
        if (cls != null) {
            Class cls8 = Double.TYPE;
            if (cls8.isAssignableFrom(cls) || cls8.isAssignableFrom(cls)) {
                return 4;
            }
        }
        if (cls != null) {
            Class cls9 = Boolean.TYPE;
            if (cls9.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls) || cls9.isAssignableFrom(cls)) {
                return 5;
            }
        }
        if (cls != null && cls.isArray()) {
            return 6;
        }
        if (cls != null && Connection.class.isAssignableFrom(cls)) {
            return 7;
        }
        if (cls != null && JSONArray.class.isAssignableFrom(cls)) {
            return 8;
        }
        if (cls != null && List.class.isAssignableFrom(cls)) {
            return 9;
        }
        if (cls != null && Map.class.isAssignableFrom(cls)) {
            return 10;
        }
        return 11;
    }

    public static BaseBean json2array(String str, Class<?> cls) {
        BaseBean baseBean = new BaseBean();
        try {
            JSONObject jSONObject = new JSONObject(str);
            jsonObject = jSONObject;
            baseBean.setCode(jSONObject.optInt("code"));
            baseBean.setMsg(jSONObject.optString("msg"));
            jsonObject = jSONObject.optJSONObject("data");
            baseBean.setData(getList("lists", cls));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baseBean;
    }

    public static BaseBean json2arrayOther(String str, Class<?> cls) {
        BaseBean baseBean = new BaseBean();
        try {
            JSONObject jSONObject = new JSONObject(str);
            jsonObject = jSONObject;
            baseBean.setCode(jSONObject.optInt("code"));
            baseBean.setMsg(jSONObject.optString("msg"));
            baseBean.setData(getList(jSONObject.optJSONArray("data"), cls));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baseBean;
    }

    public static BaseBean json2obj(String str, Class<?> cls) {
        BaseBean baseBean = new BaseBean();
        try {
            JSONObject jSONObject = new JSONObject(str);
            jsonObject = jSONObject;
            baseBean.setCode(jSONObject.optInt("code"));
            baseBean.setMsg(jSONObject.optString("msg"));
            baseBean.setData(getObject(jsonObject, "data", cls));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baseBean;
    }

    public static JsonConvert newJsonUtil(String str) {
        return new JsonConvert(str);
    }

    public static String toJson(Object obj) throws IllegalAccessException, JSONException {
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        JSONObject jSONObject = new JSONObject();
        for (Field field : obj.getClass().getDeclaredFields()) {
            switch (getType(field.getType())) {
                case 0:
                    String name = field.getName();
                    if (field.get(obj) == null) {
                        obj2 = "";
                    } else {
                        obj2 = field.get(obj);
                    }
                    jSONObject.put(name, obj2);
                    break;
                case 1:
                    String name2 = field.getName();
                    if (field.get(obj) == null) {
                        obj3 = 0;
                    } else {
                        obj3 = field.get(obj);
                    }
                    jSONObject.put(name2, ((Integer) obj3).intValue());
                    break;
                case 2:
                    String name3 = field.getName();
                    if (field.get(obj) == null) {
                        obj4 = 0;
                    } else {
                        obj4 = field.get(obj);
                    }
                    jSONObject.put(name3, ((Long) obj4).longValue());
                    break;
                case 3:
                    String name4 = field.getName();
                    if (field.get(obj) == null) {
                        obj5 = 0;
                    } else {
                        obj5 = field.get(obj);
                    }
                    jSONObject.put(name4, ((Float) obj5).floatValue());
                    break;
                case 4:
                    String name5 = field.getName();
                    if (field.get(obj) == null) {
                        obj6 = 0;
                    } else {
                        obj6 = field.get(obj);
                    }
                    jSONObject.put(name5, ((Double) obj6).doubleValue());
                    break;
                case 5:
                    String name6 = field.getName();
                    if (field.get(obj) == null) {
                        obj7 = Boolean.FALSE;
                    } else {
                        obj7 = field.get(obj);
                    }
                    jSONObject.put(name6, ((Boolean) obj7).booleanValue());
                    break;
                case 6:
                case 7:
                case 8:
                    String name7 = field.getName();
                    if (field.get(obj) == null) {
                        obj8 = null;
                    } else {
                        obj8 = field.get(obj);
                    }
                    jSONObject.put(name7, obj8);
                    break;
                case 9:
                    jSONObject.put(field.getName(), new JSONArray((Collection) field.get(obj)));
                    break;
                case 10:
                    jSONObject.put(field.getName(), new JSONObject((HashMap) field.get(obj)));
                    break;
            }
        }
        return jSONObject.toString();
    }

    public double getDouble(String str) throws JSONException {
        JSONObject jSONObject = jsonObject;
        if (jSONObject != null) {
            return jSONObject.getDouble(str);
        }
        return -1.0d;
    }

    public int getInt(String str) throws JSONException {
        JSONObject jSONObject = jsonObject;
        if (jSONObject != null) {
            return jSONObject.getInt(str);
        }
        return -1;
    }

    public JSONObject getJsonObject(String str) {
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            KLog.e(TAG, "create jsonobject exception");
            e.printStackTrace();
            return null;
        }
    }

    public Object getObject(Class<?> cls) throws Exception {
        if (jsonObject != null) {
            return getObject(cls.getSimpleName().toLowerCase(), cls);
        }
        return null;
    }

    public String getString(String str) throws JSONException {
        JSONObject jSONObject = jsonObject;
        if (jSONObject != null) {
            return jSONObject.getString(str);
        }
        return null;
    }

    public Object getObject(String str, Class<?> cls) throws Exception {
        JSONObject jSONObject = jsonObject;
        if (jSONObject != null) {
            return getObject(jSONObject, str, cls);
        }
        return null;
    }

    public JsonConvert() {
    }

    public static Object getObject(JSONObject jSONObject, Class<?> cls) throws Exception {
        return getObject(jSONObject, cls.getSimpleName().toLowerCase(), cls);
    }

    public static Object getObject(JSONObject jSONObject, String str, Class<?> cls) throws Exception {
        KLog.i(TAG, "key ==  " + str);
        if (jSONObject == null) {
            KLog.e(TAG, "current param jsonobject is null");
            return null;
        }
        if (str != null) {
            jSONObject = jSONObject.optJSONObject(str);
        }
        if (jSONObject != null) {
            if (cls.equals(null)) {
                KLog.e(TAG, "class is null");
                return jSONObject.get(str);
            }
            Object newInstance = cls.newInstance();
            for (Field field : cls.getDeclaredFields()) {
                field.setAccessible(true);
                Type genericType = field.getGenericType();
                if (!"serialVersionUID".equals(field.getName()) && !"CREATOR".equals(field.getName())) {
                    String optString = jSONObject.optString(field.getName());
                    KLog.i(TAG, genericType + "-----" + field.getName() + "=" + optString);
                    if (genericType.equals(Integer.TYPE)) {
                        field.setInt(newInstance, (optString == null || optString.trim().equals("")) ? 0 : Integer.valueOf(optString).intValue());
                    } else if (genericType.equals(Double.TYPE)) {
                        field.setDouble(newInstance, (optString == null || optString.trim().equals("")) ? OOXIXo.f3760XO : Double.valueOf(optString).doubleValue());
                    } else if (genericType.equals(Long.TYPE)) {
                        field.setLong(newInstance, (optString == null || optString.trim().equals("")) ? 0L : Long.valueOf(optString).longValue());
                    } else if (genericType.equals(Boolean.TYPE)) {
                        field.setBoolean(newInstance, (optString == null || optString.trim().equals("")) ? false : Boolean.valueOf(optString).booleanValue());
                    } else if (genericType.equals(String.class)) {
                        if (optString.trim().equals("null")) {
                            optString = null;
                        }
                        field.set(newInstance, optString);
                    } else if (genericType.toString().startsWith("java.util.List")) {
                        field.set(newInstance, getList(jSONObject.optJSONArray(field.getName()), (Class<?>) ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0]));
                    } else {
                        field.set(newInstance, optString == null ? null : getObject(jSONObject.optJSONObject(field.getName()), null, field.getType()));
                    }
                }
            }
            return newInstance;
        }
        KLog.e(TAG, "in jsonobject not key ");
        return null;
    }

    public static List<Object> getList(JSONArray jSONArray, Class<?> cls) throws Exception {
        if (jsonObject == null) {
            return null;
        }
        if (jSONArray.isNull(0)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(getObject(jSONArray.getJSONObject(i), null, cls));
        }
        return arrayList;
    }

    public static List<String> getAllKey(JSONArray jSONArray) {
        return new ArrayList();
    }
}
