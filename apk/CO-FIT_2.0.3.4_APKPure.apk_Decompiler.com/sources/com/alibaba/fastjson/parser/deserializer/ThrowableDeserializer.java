package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.ParserConfig;
import java.lang.reflect.Constructor;

public class ThrowableDeserializer extends JavaBeanDeserializer {
    public ThrowableDeserializer(ParserConfig parserConfig, Class<?> cls) {
        super(parserConfig, cls, cls);
    }

    private Throwable createException(String str, Throwable th, Class<?> cls) throws Exception {
        Constructor constructor = null;
        Constructor constructor2 = null;
        Constructor constructor3 = null;
        for (Constructor constructor4 : cls.getConstructors()) {
            Class<Throwable>[] parameterTypes = constructor4.getParameterTypes();
            if (parameterTypes.length == 0) {
                constructor3 = constructor4;
            } else {
                Class<String> cls2 = String.class;
                if (parameterTypes.length == 1 && parameterTypes[0] == cls2) {
                    constructor2 = constructor4;
                } else if (parameterTypes.length == 2 && parameterTypes[0] == cls2 && parameterTypes[1] == Throwable.class) {
                    constructor = constructor4;
                }
            }
        }
        if (constructor != null) {
            return (Throwable) constructor.newInstance(new Object[]{str, th});
        } else if (constructor2 != null) {
            return (Throwable) constructor2.newInstance(new Object[]{str});
        } else if (constructor3 != null) {
            return (Throwable) constructor3.newInstance((Object[]) null);
        } else {
            return null;
        }
    }

    /* JADX WARNING: type inference failed for: r2v7, types: [com.alibaba.fastjson.parser.deserializer.ObjectDeserializer] */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0039, code lost:
        if (r4.isAssignableFrom(r2) != false) goto L_0x003d;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser r17, java.lang.reflect.Type r18, java.lang.Object r19) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            r2 = r18
            com.alibaba.fastjson.parser.JSONLexer r3 = r0.lexer
            int r4 = r3.token()
            r5 = 0
            r6 = 8
            if (r4 != r6) goto L_0x0015
            r3.nextToken()
            return r5
        L_0x0015:
            int r4 = r17.getResolveStatus()
            r7 = 2
            java.lang.String r8 = "syntax error"
            if (r4 != r7) goto L_0x0023
            r4 = 0
            r0.setResolveStatus(r4)
            goto L_0x002b
        L_0x0023:
            int r4 = r3.token()
            r7 = 12
            if (r4 != r7) goto L_0x018e
        L_0x002b:
            java.lang.Class<java.lang.Throwable> r4 = java.lang.Throwable.class
            if (r2 == 0) goto L_0x003c
            boolean r7 = r2 instanceof java.lang.Class
            if (r7 == 0) goto L_0x003c
            java.lang.Class r2 = (java.lang.Class) r2
            boolean r7 = r4.isAssignableFrom(r2)
            if (r7 == 0) goto L_0x003c
            goto L_0x003d
        L_0x003c:
            r2 = r5
        L_0x003d:
            r7 = r5
            r9 = r7
            r10 = r9
            r11 = r10
        L_0x0041:
            com.alibaba.fastjson.parser.SymbolTable r12 = r17.getSymbolTable()
            java.lang.String r12 = r3.scanSymbol(r12)
            r13 = 13
            r14 = 16
            if (r12 != 0) goto L_0x0069
            int r15 = r3.token()
            if (r15 != r13) goto L_0x005a
            r3.nextToken(r14)
            goto L_0x00f2
        L_0x005a:
            int r15 = r3.token()
            if (r15 != r14) goto L_0x0069
            com.alibaba.fastjson.parser.Feature r15 = com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas
            boolean r15 = r3.isEnabled((com.alibaba.fastjson.parser.Feature) r15)
            if (r15 == 0) goto L_0x0069
            goto L_0x0041
        L_0x0069:
            r15 = 4
            r3.nextTokenWithColon(r15)
            java.lang.String r13 = com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY
            boolean r13 = r13.equals(r12)
            if (r13 == 0) goto L_0x0095
            int r2 = r3.token()
            if (r2 != r15) goto L_0x008f
            java.lang.String r2 = r3.stringVal()
            com.alibaba.fastjson.parser.ParserConfig r12 = r17.getConfig()
            int r13 = r3.getFeatures()
            java.lang.Class r2 = r12.checkAutoType(r2, r4, r13)
            r3.nextToken(r14)
            goto L_0x00e7
        L_0x008f:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            r0.<init>(r8)
            throw r0
        L_0x0095:
            java.lang.String r13 = "message"
            boolean r13 = r13.equals(r12)
            if (r13 == 0) goto L_0x00b9
            int r10 = r3.token()
            if (r10 != r6) goto L_0x00a5
            r10 = r5
            goto L_0x00af
        L_0x00a5:
            int r10 = r3.token()
            if (r10 != r15) goto L_0x00b3
            java.lang.String r10 = r3.stringVal()
        L_0x00af:
            r3.nextToken()
            goto L_0x00e7
        L_0x00b3:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            r0.<init>(r8)
            throw r0
        L_0x00b9:
            java.lang.String r13 = "cause"
            boolean r15 = r13.equals(r12)
            if (r15 == 0) goto L_0x00c8
            java.lang.Object r9 = r1.deserialze(r0, r5, r13)
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            goto L_0x00e7
        L_0x00c8:
            java.lang.String r13 = "stackTrace"
            boolean r13 = r13.equals(r12)
            if (r13 == 0) goto L_0x00d9
            java.lang.Class<java.lang.StackTraceElement[]> r11 = java.lang.StackTraceElement[].class
            java.lang.Object r11 = r0.parseObject(r11)
            java.lang.StackTraceElement[] r11 = (java.lang.StackTraceElement[]) r11
            goto L_0x00e7
        L_0x00d9:
            if (r7 != 0) goto L_0x00e0
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
        L_0x00e0:
            java.lang.Object r13 = r17.parse()
            r7.put(r12, r13)
        L_0x00e7:
            int r12 = r3.token()
            r13 = 13
            if (r12 != r13) goto L_0x0041
            r3.nextToken(r14)
        L_0x00f2:
            if (r2 != 0) goto L_0x00fa
            java.lang.Exception r3 = new java.lang.Exception
            r3.<init>(r10, r9)
            goto L_0x010e
        L_0x00fa:
            boolean r3 = r4.isAssignableFrom(r2)
            if (r3 == 0) goto L_0x0173
            java.lang.Throwable r3 = r1.createException(r10, r9, r2)     // Catch:{ Exception -> 0x010c }
            if (r3 != 0) goto L_0x010e
            java.lang.Exception r3 = new java.lang.Exception     // Catch:{ Exception -> 0x010c }
            r3.<init>(r10, r9)     // Catch:{ Exception -> 0x010c }
            goto L_0x010e
        L_0x010c:
            r0 = move-exception
            goto L_0x016b
        L_0x010e:
            if (r11 == 0) goto L_0x0113
            r3.setStackTrace(r11)
        L_0x0113:
            if (r7 == 0) goto L_0x016a
            if (r2 == 0) goto L_0x012c
            java.lang.Class<?> r4 = r1.clazz
            if (r2 != r4) goto L_0x011d
            r5 = r1
            goto L_0x012c
        L_0x011d:
            com.alibaba.fastjson.parser.ParserConfig r4 = r17.getConfig()
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r2 = r4.getDeserializer((java.lang.reflect.Type) r2)
            boolean r4 = r2 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer
            if (r4 == 0) goto L_0x012c
            r5 = r2
            com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer r5 = (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) r5
        L_0x012c:
            if (r5 == 0) goto L_0x016a
            java.util.Set r2 = r7.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0136:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x016a
            java.lang.Object r4 = r2.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r6 = r4.getKey()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r4 = r4.getValue()
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r6 = r5.getFieldDeserializer((java.lang.String) r6)
            if (r6 == 0) goto L_0x0136
            com.alibaba.fastjson.util.FieldInfo r7 = r6.fieldInfo
            java.lang.Class<?> r8 = r7.fieldClass
            boolean r8 = r8.isInstance(r4)
            if (r8 != 0) goto L_0x0166
            java.lang.reflect.Type r7 = r7.fieldType
            com.alibaba.fastjson.parser.ParserConfig r8 = r17.getConfig()
            java.lang.Object r4 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r4, (java.lang.reflect.Type) r7, (com.alibaba.fastjson.parser.ParserConfig) r8)
        L_0x0166:
            r6.setValue((java.lang.Object) r3, (java.lang.Object) r4)
            goto L_0x0136
        L_0x016a:
            return r3
        L_0x016b:
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException
            java.lang.String r3 = "create instance error"
            r2.<init>(r3, r0)
            throw r2
        L_0x0173:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "type not match, not Throwable. "
            r3.append(r4)
            java.lang.String r2 = r2.getName()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r0.<init>(r2)
            throw r0
        L_0x018e:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            r0.<init>(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer.deserialze(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object):java.lang.Object");
    }

    public int getFastMatchToken() {
        return 12;
    }
}
