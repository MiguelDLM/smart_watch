package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;

public class AnnotationSerializer implements ObjectSerializer {
    public static AnnotationSerializer instance = new AnnotationSerializer();
    private static volatile Class sun_AnnotationType = null;
    private static volatile boolean sun_AnnotationType_error = false;
    private static volatile Method sun_AnnotationType_getInstance;
    private static volatile Method sun_AnnotationType_members;

    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        Class[] interfaces = obj.getClass().getInterfaces();
        if (interfaces.length == 1 && interfaces[0].isAnnotation()) {
            Class cls = interfaces[0];
            if (sun_AnnotationType == null && !sun_AnnotationType_error) {
                try {
                    sun_AnnotationType = Class.forName("sun.reflect.annotation.AnnotationType");
                } catch (Throwable th) {
                    sun_AnnotationType_error = true;
                    throw new JSONException("not support Type Annotation.", th);
                }
            }
            if (sun_AnnotationType != null) {
                if (sun_AnnotationType_getInstance == null && !sun_AnnotationType_error) {
                    try {
                        sun_AnnotationType_getInstance = sun_AnnotationType.getMethod("getInstance", new Class[]{Class.class});
                    } catch (Throwable th2) {
                        sun_AnnotationType_error = true;
                        throw new JSONException("not support Type Annotation.", th2);
                    }
                }
                if (sun_AnnotationType_members == null && !sun_AnnotationType_error) {
                    try {
                        sun_AnnotationType_members = sun_AnnotationType.getMethod("members", (Class[]) null);
                    } catch (Throwable th3) {
                        sun_AnnotationType_error = true;
                        throw new JSONException("not support Type Annotation.", th3);
                    }
                }
                if (sun_AnnotationType_getInstance == null || sun_AnnotationType_error) {
                    throw new JSONException("not support Type Annotation.");
                }
                try {
                    try {
                        Map map = (Map) sun_AnnotationType_members.invoke(sun_AnnotationType_getInstance.invoke((Object) null, new Object[]{cls}), (Object[]) null);
                        JSONObject jSONObject = new JSONObject(map.size());
                        Object obj3 = null;
                        for (Map.Entry entry : map.entrySet()) {
                            try {
                                obj3 = ((Method) entry.getValue()).invoke(obj, (Object[]) null);
                            } catch (IllegalAccessException | InvocationTargetException unused) {
                            }
                            jSONObject.put((String) entry.getKey(), JSON.toJSON(obj3));
                        }
                        jSONSerializer.write((Object) jSONObject);
                    } catch (Throwable th4) {
                        throw new JSONException("not support Type Annotation.", th4);
                    }
                } finally {
                    sun_AnnotationType_error = true;
                    JSONException jSONException = new JSONException("not support Type Annotation.", th4);
                }
            } else {
                throw new JSONException("not support Type Annotation.");
            }
        }
    }
}
