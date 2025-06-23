package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.ParserConfig;
import java.lang.reflect.Constructor;

/* loaded from: classes.dex */
public class ThrowableDeserializer extends JavaBeanDeserializer {
    public ThrowableDeserializer(ParserConfig parserConfig, Class<?> cls) {
        super(parserConfig, cls, cls);
    }

    private Throwable createException(String str, Throwable th, Class<?> cls) throws Exception {
        Constructor<?> constructor = null;
        Constructor<?> constructor2 = null;
        Constructor<?> constructor3 = null;
        for (Constructor<?> constructor4 : cls.getConstructors()) {
            Class<?>[] parameterTypes = constructor4.getParameterTypes();
            if (parameterTypes.length == 0) {
                constructor3 = constructor4;
            } else if (parameterTypes.length == 1 && parameterTypes[0] == String.class) {
                constructor2 = constructor4;
            } else if (parameterTypes.length == 2 && parameterTypes[0] == String.class && parameterTypes[1] == Throwable.class) {
                constructor = constructor4;
            }
        }
        if (constructor != null) {
            return (Throwable) constructor.newInstance(str, th);
        }
        if (constructor2 != null) {
            return (Throwable) constructor2.newInstance(str);
        }
        if (constructor3 == null) {
            return null;
        }
        return (Throwable) constructor3.newInstance(null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
    
        if (java.lang.Throwable.class.isAssignableFrom(r2) != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00f2, code lost:
    
        if (r2 != null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f4, code lost:
    
        r3 = (T) new java.lang.Exception(r10, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x010e, code lost:
    
        if (r11 == null) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0110, code lost:
    
        ((java.lang.Throwable) r3).setStackTrace(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0113, code lost:
    
        if (r7 == null) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0115, code lost:
    
        if (r2 == null) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0119, code lost:
    
        if (r2 != r16.clazz) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x011b, code lost:
    
        r5 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x011d, code lost:
    
        r2 = r17.getConfig().getDeserializer(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0127, code lost:
    
        if ((r2 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0129, code lost:
    
        r5 = (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x012c, code lost:
    
        if (r5 == null) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x012e, code lost:
    
        r2 = r7.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x013a, code lost:
    
        if (r2.hasNext() == false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x013c, code lost:
    
        r4 = (java.util.Map.Entry) r2.next();
        r6 = (java.lang.String) r4.getKey();
        r4 = r4.getValue();
        r6 = r5.getFieldDeserializer(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0150, code lost:
    
        if (r6 == null) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0152, code lost:
    
        r7 = r6.fieldInfo;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x015a, code lost:
    
        if (r7.fieldClass.isInstance(r4) != false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x015c, code lost:
    
        r4 = com.alibaba.fastjson.util.TypeUtils.cast(r4, r7.fieldType, r17.getConfig());
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0166, code lost:
    
        r6.setValue(r3, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x016a, code lost:
    
        return (T) r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00fe, code lost:
    
        if (java.lang.Throwable.class.isAssignableFrom(r2) == false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x018d, code lost:
    
        throw new com.alibaba.fastjson.JSONException("type not match, not Throwable. " + r2.getName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0100, code lost:
    
        r3 = (T) createException(r10, r9, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0104, code lost:
    
        if (r3 != null) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0106, code lost:
    
        r3 = (T) new java.lang.Exception(r10, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x010c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0172, code lost:
    
        throw new com.alibaba.fastjson.JSONException("create instance error", r0);
     */
    @Override // com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser r17, java.lang.reflect.Type r18, java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 404
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer.deserialze(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object):java.lang.Object");
    }

    @Override // com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }
}
