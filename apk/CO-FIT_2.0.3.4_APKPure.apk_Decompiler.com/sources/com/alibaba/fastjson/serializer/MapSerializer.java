package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

public class MapSerializer extends SerializeFilterable implements ObjectSerializer {
    private static final int NON_STRINGKEY_AS_STRING = SerializerFeature.of(new SerializerFeature[]{SerializerFeature.BrowserCompatible, SerializerFeature.WriteNonStringKeyAsString, SerializerFeature.BrowserSecure});
    public static MapSerializer instance = new MapSerializer();

    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: com.alibaba.fastjson.serializer.JavaBeanSerializer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v6, resolved type: com.alibaba.fastjson.serializer.JavaBeanSerializer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: java.util.TreeMap} */
    /* JADX WARNING: type inference failed for: r0v8, types: [boolean] */
    /* JADX WARNING: type inference failed for: r0v14 */
    /* JADX WARNING: type inference failed for: r0v18 */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00d5, code lost:
        if ((r1 instanceof java.lang.Number) == false) goto L_0x00f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00df, code lost:
        if (applyName(r9, r0, com.alibaba.fastjson.JSON.toJSONString(r1)) != false) goto L_0x00f0;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0255 A[Catch:{ all -> 0x0059 }] */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x026c A[Catch:{ all -> 0x0059 }] */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0297 A[Catch:{ all -> 0x0059 }] */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x02a4 A[Catch:{ all -> 0x0059 }] */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x030e  */
    /* JADX WARNING: Removed duplicated region for block: B:219:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00aa A[Catch:{ all -> 0x0059 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void write(com.alibaba.fastjson.serializer.JSONSerializer r24, java.lang.Object r25, java.lang.Object r26, java.lang.reflect.Type r27, int r28, boolean r29) throws java.io.IOException {
        /*
            r23 = this;
            r8 = r23
            r9 = r24
            r0 = r25
            r10 = r27
            r11 = r28
            com.alibaba.fastjson.serializer.SerializeWriter r12 = r9.out
            if (r0 != 0) goto L_0x0012
            r12.writeNull()
            return
        L_0x0012:
            r1 = r0
            java.util.Map r1 = (java.util.Map) r1
            com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.MapSortField
            int r2 = r2.mask
            int r3 = r12.features
            r3 = r3 & r2
            if (r3 != 0) goto L_0x0024
            r2 = r2 & r11
            if (r2 == 0) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            r13 = r1
            goto L_0x003f
        L_0x0024:
            boolean r2 = r1 instanceof com.alibaba.fastjson.JSONObject
            if (r2 == 0) goto L_0x002e
            com.alibaba.fastjson.JSONObject r1 = (com.alibaba.fastjson.JSONObject) r1
            java.util.Map r1 = r1.getInnerMap()
        L_0x002e:
            boolean r2 = r1 instanceof java.util.SortedMap
            if (r2 != 0) goto L_0x0022
            boolean r2 = r1 instanceof java.util.LinkedHashMap
            if (r2 != 0) goto L_0x0022
            java.util.TreeMap r2 = new java.util.TreeMap     // Catch:{ Exception -> 0x003d }
            r2.<init>(r1)     // Catch:{ Exception -> 0x003d }
            r13 = r2
            goto L_0x003f
        L_0x003d:
            goto L_0x0022
        L_0x003f:
            boolean r1 = r24.containsReference(r25)
            if (r1 == 0) goto L_0x0049
            r24.writeReference(r25)
            return
        L_0x0049:
            com.alibaba.fastjson.serializer.SerialContext r14 = r9.context
            r15 = 0
            r1 = r26
            r9.setContext(r14, r0, r1, r15)
            if (r29 != 0) goto L_0x005c
            r1 = 123(0x7b, float:1.72E-43)
            r12.write((int) r1)     // Catch:{ all -> 0x0059 }
            goto L_0x005c
        L_0x0059:
            r0 = move-exception
            goto L_0x0314
        L_0x005c:
            r24.incrementIndent()     // Catch:{ all -> 0x0059 }
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName     // Catch:{ all -> 0x0059 }
            boolean r1 = r12.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r1)     // Catch:{ all -> 0x0059 }
            r7 = 1
            if (r1 == 0) goto L_0x0093
            com.alibaba.fastjson.serializer.SerializeConfig r1 = r9.config     // Catch:{ all -> 0x0059 }
            java.lang.String r1 = r1.typeKey     // Catch:{ all -> 0x0059 }
            java.lang.Class r2 = r13.getClass()     // Catch:{ all -> 0x0059 }
            java.lang.Class<com.alibaba.fastjson.JSONObject> r3 = com.alibaba.fastjson.JSONObject.class
            if (r2 == r3) goto L_0x007c
            java.lang.Class<java.util.HashMap> r3 = java.util.HashMap.class
            if (r2 == r3) goto L_0x007c
            java.lang.Class<java.util.LinkedHashMap> r3 = java.util.LinkedHashMap.class
            if (r2 != r3) goto L_0x0083
        L_0x007c:
            boolean r2 = r13.containsKey(r1)     // Catch:{ all -> 0x0059 }
            if (r2 == 0) goto L_0x0083
            goto L_0x0093
        L_0x0083:
            r12.writeFieldName(r1)     // Catch:{ all -> 0x0059 }
            java.lang.Class r1 = r25.getClass()     // Catch:{ all -> 0x0059 }
            java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x0059 }
            r12.writeString((java.lang.String) r1)     // Catch:{ all -> 0x0059 }
            r1 = 0
            goto L_0x0094
        L_0x0093:
            r1 = 1
        L_0x0094:
            java.util.Set r2 = r13.entrySet()     // Catch:{ all -> 0x0059 }
            java.util.Iterator r16 = r2.iterator()     // Catch:{ all -> 0x0059 }
            r17 = 0
            r18 = r1
            r6 = r17
            r19 = r6
        L_0x00a4:
            boolean r1 = r16.hasNext()     // Catch:{ all -> 0x0059 }
            if (r1 == 0) goto L_0x02f6
            java.lang.Object r1 = r16.next()     // Catch:{ all -> 0x0059 }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x0059 }
            java.lang.Object r5 = r1.getValue()     // Catch:{ all -> 0x0059 }
            java.lang.Object r1 = r1.getKey()     // Catch:{ all -> 0x0059 }
            java.util.List<com.alibaba.fastjson.serializer.PropertyPreFilter> r2 = r9.propertyPreFilters     // Catch:{ all -> 0x0059 }
            if (r2 == 0) goto L_0x00f0
            int r2 = r2.size()     // Catch:{ all -> 0x0059 }
            if (r2 <= 0) goto L_0x00f0
            if (r1 == 0) goto L_0x00e6
            boolean r2 = r1 instanceof java.lang.String     // Catch:{ all -> 0x0059 }
            if (r2 == 0) goto L_0x00c9
            goto L_0x00e6
        L_0x00c9:
            java.lang.Class r2 = r1.getClass()     // Catch:{ all -> 0x0059 }
            boolean r2 = r2.isPrimitive()     // Catch:{ all -> 0x0059 }
            if (r2 != 0) goto L_0x00d7
            boolean r2 = r1 instanceof java.lang.Number     // Catch:{ all -> 0x0059 }
            if (r2 == 0) goto L_0x00f0
        L_0x00d7:
            java.lang.String r2 = com.alibaba.fastjson.JSON.toJSONString(r1)     // Catch:{ all -> 0x0059 }
            boolean r2 = r8.applyName(r9, r0, r2)     // Catch:{ all -> 0x0059 }
            if (r2 != 0) goto L_0x00f0
        L_0x00e1:
            r22 = r6
            r0 = 1
            goto L_0x0247
        L_0x00e6:
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0059 }
            boolean r2 = r8.applyName(r9, r0, r2)     // Catch:{ all -> 0x0059 }
            if (r2 != 0) goto L_0x00f0
            goto L_0x00e1
        L_0x00f0:
            java.util.List<com.alibaba.fastjson.serializer.PropertyPreFilter> r2 = r8.propertyPreFilters     // Catch:{ all -> 0x0059 }
            if (r2 == 0) goto L_0x0124
            int r2 = r2.size()     // Catch:{ all -> 0x0059 }
            if (r2 <= 0) goto L_0x0124
            if (r1 == 0) goto L_0x011a
            boolean r2 = r1 instanceof java.lang.String     // Catch:{ all -> 0x0059 }
            if (r2 == 0) goto L_0x0101
            goto L_0x011a
        L_0x0101:
            java.lang.Class r2 = r1.getClass()     // Catch:{ all -> 0x0059 }
            boolean r2 = r2.isPrimitive()     // Catch:{ all -> 0x0059 }
            if (r2 != 0) goto L_0x010f
            boolean r2 = r1 instanceof java.lang.Number     // Catch:{ all -> 0x0059 }
            if (r2 == 0) goto L_0x0124
        L_0x010f:
            java.lang.String r2 = com.alibaba.fastjson.JSON.toJSONString(r1)     // Catch:{ all -> 0x0059 }
            boolean r2 = r8.applyName(r9, r0, r2)     // Catch:{ all -> 0x0059 }
            if (r2 != 0) goto L_0x0124
            goto L_0x00e1
        L_0x011a:
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0059 }
            boolean r2 = r8.applyName(r9, r0, r2)     // Catch:{ all -> 0x0059 }
            if (r2 != 0) goto L_0x0124
            goto L_0x00e1
        L_0x0124:
            java.util.List<com.alibaba.fastjson.serializer.PropertyFilter> r2 = r9.propertyFilters     // Catch:{ all -> 0x0059 }
            if (r2 == 0) goto L_0x0158
            int r2 = r2.size()     // Catch:{ all -> 0x0059 }
            if (r2 <= 0) goto L_0x0158
            if (r1 == 0) goto L_0x014e
            boolean r2 = r1 instanceof java.lang.String     // Catch:{ all -> 0x0059 }
            if (r2 == 0) goto L_0x0135
            goto L_0x014e
        L_0x0135:
            java.lang.Class r2 = r1.getClass()     // Catch:{ all -> 0x0059 }
            boolean r2 = r2.isPrimitive()     // Catch:{ all -> 0x0059 }
            if (r2 != 0) goto L_0x0143
            boolean r2 = r1 instanceof java.lang.Number     // Catch:{ all -> 0x0059 }
            if (r2 == 0) goto L_0x0158
        L_0x0143:
            java.lang.String r2 = com.alibaba.fastjson.JSON.toJSONString(r1)     // Catch:{ all -> 0x0059 }
            boolean r2 = r8.apply(r9, r0, r2, r5)     // Catch:{ all -> 0x0059 }
            if (r2 != 0) goto L_0x0158
            goto L_0x00e1
        L_0x014e:
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0059 }
            boolean r2 = r8.apply(r9, r0, r2, r5)     // Catch:{ all -> 0x0059 }
            if (r2 != 0) goto L_0x0158
            goto L_0x00e1
        L_0x0158:
            java.util.List<com.alibaba.fastjson.serializer.PropertyFilter> r2 = r8.propertyFilters     // Catch:{ all -> 0x0059 }
            if (r2 == 0) goto L_0x018e
            int r2 = r2.size()     // Catch:{ all -> 0x0059 }
            if (r2 <= 0) goto L_0x018e
            if (r1 == 0) goto L_0x0183
            boolean r2 = r1 instanceof java.lang.String     // Catch:{ all -> 0x0059 }
            if (r2 == 0) goto L_0x0169
            goto L_0x0183
        L_0x0169:
            java.lang.Class r2 = r1.getClass()     // Catch:{ all -> 0x0059 }
            boolean r2 = r2.isPrimitive()     // Catch:{ all -> 0x0059 }
            if (r2 != 0) goto L_0x0177
            boolean r2 = r1 instanceof java.lang.Number     // Catch:{ all -> 0x0059 }
            if (r2 == 0) goto L_0x018e
        L_0x0177:
            java.lang.String r2 = com.alibaba.fastjson.JSON.toJSONString(r1)     // Catch:{ all -> 0x0059 }
            boolean r2 = r8.apply(r9, r0, r2, r5)     // Catch:{ all -> 0x0059 }
            if (r2 != 0) goto L_0x018e
            goto L_0x00e1
        L_0x0183:
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0059 }
            boolean r2 = r8.apply(r9, r0, r2, r5)     // Catch:{ all -> 0x0059 }
            if (r2 != 0) goto L_0x018e
            goto L_0x00e1
        L_0x018e:
            java.util.List<com.alibaba.fastjson.serializer.NameFilter> r2 = r9.nameFilters     // Catch:{ all -> 0x0059 }
            if (r2 == 0) goto L_0x01bc
            int r2 = r2.size()     // Catch:{ all -> 0x0059 }
            if (r2 <= 0) goto L_0x01bc
            if (r1 == 0) goto L_0x01b6
            boolean r2 = r1 instanceof java.lang.String     // Catch:{ all -> 0x0059 }
            if (r2 == 0) goto L_0x019f
            goto L_0x01b6
        L_0x019f:
            java.lang.Class r2 = r1.getClass()     // Catch:{ all -> 0x0059 }
            boolean r2 = r2.isPrimitive()     // Catch:{ all -> 0x0059 }
            if (r2 != 0) goto L_0x01ad
            boolean r2 = r1 instanceof java.lang.Number     // Catch:{ all -> 0x0059 }
            if (r2 == 0) goto L_0x01bc
        L_0x01ad:
            java.lang.String r1 = com.alibaba.fastjson.JSON.toJSONString(r1)     // Catch:{ all -> 0x0059 }
            java.lang.String r1 = r8.processKey(r9, r0, r1, r5)     // Catch:{ all -> 0x0059 }
            goto L_0x01bc
        L_0x01b6:
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0059 }
            java.lang.String r1 = r8.processKey(r9, r0, r1, r5)     // Catch:{ all -> 0x0059 }
        L_0x01bc:
            java.util.List<com.alibaba.fastjson.serializer.NameFilter> r2 = r8.nameFilters     // Catch:{ all -> 0x0059 }
            if (r2 == 0) goto L_0x01e3
            int r2 = r2.size()     // Catch:{ all -> 0x0059 }
            if (r2 <= 0) goto L_0x01e3
            if (r1 == 0) goto L_0x01e5
            boolean r2 = r1 instanceof java.lang.String     // Catch:{ all -> 0x0059 }
            if (r2 == 0) goto L_0x01cd
            goto L_0x01e5
        L_0x01cd:
            java.lang.Class r2 = r1.getClass()     // Catch:{ all -> 0x0059 }
            boolean r2 = r2.isPrimitive()     // Catch:{ all -> 0x0059 }
            if (r2 != 0) goto L_0x01db
            boolean r2 = r1 instanceof java.lang.Number     // Catch:{ all -> 0x0059 }
            if (r2 == 0) goto L_0x01e3
        L_0x01db:
            java.lang.String r1 = com.alibaba.fastjson.JSON.toJSONString(r1)     // Catch:{ all -> 0x0059 }
            java.lang.String r1 = r8.processKey(r9, r0, r1, r5)     // Catch:{ all -> 0x0059 }
        L_0x01e3:
            r4 = r1
            goto L_0x01ec
        L_0x01e5:
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0059 }
            java.lang.String r1 = r8.processKey(r9, r0, r1, r5)     // Catch:{ all -> 0x0059 }
            goto L_0x01e3
        L_0x01ec:
            if (r4 == 0) goto L_0x01f2
            boolean r1 = r4 instanceof java.lang.String     // Catch:{ all -> 0x0059 }
            if (r1 == 0) goto L_0x01f9
        L_0x01f2:
            r15 = r4
            r21 = r5
            r22 = r6
            r0 = 1
            goto L_0x0228
        L_0x01f9:
            boolean r1 = r4 instanceof java.util.Map     // Catch:{ all -> 0x0059 }
            if (r1 != 0) goto L_0x0201
            boolean r1 = r4 instanceof java.util.Collection     // Catch:{ all -> 0x0059 }
            if (r1 == 0) goto L_0x0208
        L_0x0201:
            r15 = r4
            r21 = r5
            r22 = r6
            r0 = 1
            goto L_0x0225
        L_0x0208:
            java.lang.String r20 = com.alibaba.fastjson.JSON.toJSONString(r4)     // Catch:{ all -> 0x0059 }
            r3 = 0
            r1 = r23
            r2 = r24
            r15 = r4
            r4 = r25
            r21 = r5
            r5 = r20
            r22 = r6
            r6 = r21
            r0 = 1
            r7 = r28
            java.lang.Object r1 = r1.processValue(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0059 }
        L_0x0223:
            r3 = r1
            goto L_0x023b
        L_0x0225:
            r3 = r21
            goto L_0x023b
        L_0x0228:
            r5 = r15
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0059 }
            r3 = 0
            r1 = r23
            r2 = r24
            r4 = r25
            r6 = r21
            r7 = r28
            java.lang.Object r1 = r1.processValue(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0059 }
            goto L_0x0223
        L_0x023b:
            if (r3 != 0) goto L_0x024f
            int r1 = r12.features     // Catch:{ all -> 0x0059 }
            com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch:{ all -> 0x0059 }
            boolean r1 = com.alibaba.fastjson.serializer.SerializerFeature.isEnabled(r1, r11, r2)     // Catch:{ all -> 0x0059 }
            if (r1 != 0) goto L_0x024f
        L_0x0247:
            r0 = r25
            r6 = r22
            r7 = 1
            r15 = 0
            goto L_0x00a4
        L_0x024f:
            boolean r1 = r15 instanceof java.lang.String     // Catch:{ all -> 0x0059 }
            r2 = 44
            if (r1 == 0) goto L_0x026c
            r4 = r15
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0059 }
            if (r18 != 0) goto L_0x025d
            r12.write((int) r2)     // Catch:{ all -> 0x0059 }
        L_0x025d:
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat     // Catch:{ all -> 0x0059 }
            boolean r1 = r12.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r1)     // Catch:{ all -> 0x0059 }
            if (r1 == 0) goto L_0x0268
            r24.println()     // Catch:{ all -> 0x0059 }
        L_0x0268:
            r12.writeFieldName(r4, r0)     // Catch:{ all -> 0x0059 }
            goto L_0x0295
        L_0x026c:
            if (r18 != 0) goto L_0x0271
            r12.write((int) r2)     // Catch:{ all -> 0x0059 }
        L_0x0271:
            int r1 = NON_STRINGKEY_AS_STRING     // Catch:{ all -> 0x0059 }
            boolean r1 = r12.isEnabled((int) r1)     // Catch:{ all -> 0x0059 }
            if (r1 != 0) goto L_0x0281
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNonStringKeyAsString     // Catch:{ all -> 0x0059 }
            boolean r1 = com.alibaba.fastjson.serializer.SerializerFeature.isEnabled(r11, r1)     // Catch:{ all -> 0x0059 }
            if (r1 == 0) goto L_0x028d
        L_0x0281:
            boolean r1 = r15 instanceof java.lang.Enum     // Catch:{ all -> 0x0059 }
            if (r1 != 0) goto L_0x028d
            java.lang.String r1 = com.alibaba.fastjson.JSON.toJSONString(r15)     // Catch:{ all -> 0x0059 }
            r9.write((java.lang.String) r1)     // Catch:{ all -> 0x0059 }
            goto L_0x0290
        L_0x028d:
            r9.write((java.lang.Object) r15)     // Catch:{ all -> 0x0059 }
        L_0x0290:
            r1 = 58
            r12.write((int) r1)     // Catch:{ all -> 0x0059 }
        L_0x0295:
            if (r3 != 0) goto L_0x02a4
            r12.writeNull()     // Catch:{ all -> 0x0059 }
            r0 = r25
            r6 = r22
        L_0x029e:
            r7 = 1
            r15 = 0
            r18 = 0
            goto L_0x00a4
        L_0x02a4:
            java.lang.Class r1 = r3.getClass()     // Catch:{ all -> 0x0059 }
            r2 = r22
            if (r1 == r2) goto L_0x02b3
            com.alibaba.fastjson.serializer.ObjectSerializer r2 = r9.getObjectWriter(r1)     // Catch:{ all -> 0x0059 }
            r7 = r1
            r6 = r2
            goto L_0x02b6
        L_0x02b3:
            r7 = r2
            r6 = r19
        L_0x02b6:
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName     // Catch:{ all -> 0x0059 }
            boolean r1 = com.alibaba.fastjson.serializer.SerializerFeature.isEnabled(r11, r1)     // Catch:{ all -> 0x0059 }
            if (r1 == 0) goto L_0x02e5
            boolean r1 = r6 instanceof com.alibaba.fastjson.serializer.JavaBeanSerializer     // Catch:{ all -> 0x0059 }
            if (r1 == 0) goto L_0x02e5
            boolean r1 = r10 instanceof java.lang.reflect.ParameterizedType     // Catch:{ all -> 0x0059 }
            if (r1 == 0) goto L_0x02d5
            r1 = r10
            java.lang.reflect.ParameterizedType r1 = (java.lang.reflect.ParameterizedType) r1     // Catch:{ all -> 0x0059 }
            java.lang.reflect.Type[] r1 = r1.getActualTypeArguments()     // Catch:{ all -> 0x0059 }
            int r2 = r1.length     // Catch:{ all -> 0x0059 }
            r4 = 2
            if (r2 != r4) goto L_0x02d5
            r1 = r1[r0]     // Catch:{ all -> 0x0059 }
            r5 = r1
            goto L_0x02d7
        L_0x02d5:
            r5 = r17
        L_0x02d7:
            r1 = r6
            com.alibaba.fastjson.serializer.JavaBeanSerializer r1 = (com.alibaba.fastjson.serializer.JavaBeanSerializer) r1     // Catch:{ all -> 0x0059 }
            r2 = r24
            r4 = r15
            r19 = r6
            r6 = r28
            r1.writeNoneASM(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0059 }
            goto L_0x02f2
        L_0x02e5:
            r19 = r6
            r5 = 0
            r1 = r19
            r2 = r24
            r4 = r15
            r6 = r28
            r1.write(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0059 }
        L_0x02f2:
            r0 = r25
            r6 = r7
            goto L_0x029e
        L_0x02f6:
            r9.context = r14
            r24.decrementIdent()
            com.alibaba.fastjson.serializer.SerializerFeature r0 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat
            boolean r0 = r12.isEnabled((com.alibaba.fastjson.serializer.SerializerFeature) r0)
            if (r0 == 0) goto L_0x030c
            int r0 = r13.size()
            if (r0 <= 0) goto L_0x030c
            r24.println()
        L_0x030c:
            if (r29 != 0) goto L_0x0313
            r0 = 125(0x7d, float:1.75E-43)
            r12.write((int) r0)
        L_0x0313:
            return
        L_0x0314:
            r9.context = r14
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.MapSerializer.write(com.alibaba.fastjson.serializer.JSONSerializer, java.lang.Object, java.lang.Object, java.lang.reflect.Type, int, boolean):void");
    }
}
