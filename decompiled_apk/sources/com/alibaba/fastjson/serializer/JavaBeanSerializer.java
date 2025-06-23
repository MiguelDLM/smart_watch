package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class JavaBeanSerializer extends SerializeFilterable implements ObjectSerializer {
    protected final SerializeBeanInfo beanInfo;
    protected final FieldSerializer[] getters;
    private volatile transient long[] hashArray;
    private volatile transient short[] hashArrayMapping;
    protected final FieldSerializer[] sortedGetters;

    public JavaBeanSerializer(Class<?> cls) {
        this(cls, (Map<String, String>) null);
    }

    public static Map<String, String> createAliasMap(String... strArr) {
        HashMap hashMap = new HashMap();
        for (String str : strArr) {
            hashMap.put(str, str);
        }
        return hashMap;
    }

    public boolean applyLabel(JSONSerializer jSONSerializer, String str) {
        List<LabelFilter> list = jSONSerializer.labelFilters;
        if (list != null) {
            Iterator<LabelFilter> it = list.iterator();
            while (it.hasNext()) {
                if (!it.next().apply(str)) {
                    return false;
                }
            }
        }
        List<LabelFilter> list2 = this.labelFilters;
        if (list2 != null) {
            Iterator<LabelFilter> it2 = list2.iterator();
            while (it2.hasNext()) {
                if (!it2.next().apply(str)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public BeanContext getBeanContext(int i) {
        return this.sortedGetters[i].fieldContext;
    }

    public Set<String> getFieldNames(Object obj) throws Exception {
        HashSet hashSet = new HashSet();
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            if (fieldSerializer.getPropertyValueDirect(obj) != null) {
                hashSet.add(fieldSerializer.fieldInfo.name);
            }
        }
        return hashSet;
    }

    public FieldSerializer getFieldSerializer(String str) {
        if (str == null) {
            return null;
        }
        int length = this.sortedGetters.length - 1;
        int i = 0;
        while (i <= length) {
            int i2 = (i + length) >>> 1;
            int compareTo = this.sortedGetters[i2].fieldInfo.name.compareTo(str);
            if (compareTo < 0) {
                i = i2 + 1;
            } else {
                if (compareTo <= 0) {
                    return this.sortedGetters[i2];
                }
                length = i2 - 1;
            }
        }
        return null;
    }

    public Type getFieldType(int i) {
        return this.sortedGetters[i].fieldInfo.fieldType;
    }

    public Object getFieldValue(Object obj, String str) {
        FieldSerializer fieldSerializer = getFieldSerializer(str);
        if (fieldSerializer != null) {
            try {
                return fieldSerializer.getPropertyValue(obj);
            } catch (IllegalAccessException e) {
                throw new JSONException("getFieldValue error." + str, e);
            } catch (InvocationTargetException e2) {
                throw new JSONException("getFieldValue error." + str, e2);
            }
        }
        throw new JSONException("field not found. " + str);
    }

    public List<Object> getFieldValues(Object obj) throws Exception {
        ArrayList arrayList = new ArrayList(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            arrayList.add(fieldSerializer.getPropertyValue(obj));
        }
        return arrayList;
    }

    public Map<String, Object> getFieldValuesMap(Object obj) throws Exception {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            boolean isEnabled = SerializerFeature.isEnabled(fieldSerializer.features, SerializerFeature.SkipTransientField);
            FieldInfo fieldInfo = fieldSerializer.fieldInfo;
            if (!isEnabled || fieldInfo == null || !fieldInfo.fieldTransient) {
                if (fieldInfo.unwrapped) {
                    Object json = JSON.toJSON(fieldSerializer.getPropertyValue(obj));
                    if (json instanceof Map) {
                        linkedHashMap.putAll((Map) json);
                    } else {
                        linkedHashMap.put(fieldSerializer.fieldInfo.name, fieldSerializer.getPropertyValue(obj));
                    }
                } else {
                    linkedHashMap.put(fieldInfo.name, fieldSerializer.getPropertyValue(obj));
                }
            }
        }
        return linkedHashMap;
    }

    public JSONType getJSONType() {
        return this.beanInfo.jsonType;
    }

    public List<Object> getObjectFieldValues(Object obj) throws Exception {
        ArrayList arrayList = new ArrayList(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            Class<?> cls = fieldSerializer.fieldInfo.fieldClass;
            if (!cls.isPrimitive() && !cls.getName().startsWith("java.lang.")) {
                arrayList.add(fieldSerializer.getPropertyValue(obj));
            }
        }
        return arrayList;
    }

    public int getSize(Object obj) throws Exception {
        int i = 0;
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            if (fieldSerializer.getPropertyValueDirect(obj) != null) {
                i++;
            }
        }
        return i;
    }

    public Class<?> getType() {
        return this.beanInfo.beanType;
    }

    public boolean isWriteAsArray(JSONSerializer jSONSerializer) {
        return isWriteAsArray(jSONSerializer, 0);
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i, false);
    }

    public char writeAfter(JSONSerializer jSONSerializer, Object obj, char c) {
        List<AfterFilter> list = jSONSerializer.afterFilters;
        if (list != null) {
            Iterator<AfterFilter> it = list.iterator();
            while (it.hasNext()) {
                c = it.next().writeAfter(jSONSerializer, obj, c);
            }
        }
        List<AfterFilter> list2 = this.afterFilters;
        if (list2 != null) {
            Iterator<AfterFilter> it2 = list2.iterator();
            while (it2.hasNext()) {
                c = it2.next().writeAfter(jSONSerializer, obj, c);
            }
        }
        return c;
    }

    public void writeAsArray(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i);
    }

    public void writeAsArrayNonContext(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i);
    }

    public char writeBefore(JSONSerializer jSONSerializer, Object obj, char c) {
        List<BeforeFilter> list = jSONSerializer.beforeFilters;
        if (list != null) {
            Iterator<BeforeFilter> it = list.iterator();
            while (it.hasNext()) {
                c = it.next().writeBefore(jSONSerializer, obj, c);
            }
        }
        List<BeforeFilter> list2 = this.beforeFilters;
        if (list2 != null) {
            Iterator<BeforeFilter> it2 = list2.iterator();
            while (it2.hasNext()) {
                c = it2.next().writeBefore(jSONSerializer, obj, c);
            }
        }
        return c;
    }

    public void writeClassName(JSONSerializer jSONSerializer, String str, Object obj) {
        if (str == null) {
            str = jSONSerializer.config.typeKey;
        }
        jSONSerializer.out.writeFieldName(str, false);
        String str2 = this.beanInfo.typeName;
        if (str2 == null) {
            Class<?> cls = obj.getClass();
            if (TypeUtils.isProxy(cls)) {
                cls = cls.getSuperclass();
            }
            str2 = cls.getName();
        }
        jSONSerializer.write(str2);
    }

    public void writeDirectNonContext(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i);
    }

    public void writeNoneASM(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i, false);
    }

    public boolean writeReference(JSONSerializer jSONSerializer, Object obj, int i) {
        IdentityHashMap<Object, SerialContext> identityHashMap;
        SerialContext serialContext = jSONSerializer.context;
        int i2 = SerializerFeature.DisableCircularReferenceDetect.mask;
        if (serialContext == null || (serialContext.features & i2) != 0 || (i & i2) != 0 || (identityHashMap = jSONSerializer.references) == null || !identityHashMap.containsKey(obj)) {
            return false;
        }
        jSONSerializer.writeReference(obj);
        return true;
    }

    public JavaBeanSerializer(Class<?> cls, String... strArr) {
        this(cls, createAliasMap(strArr));
    }

    public boolean isWriteAsArray(JSONSerializer jSONSerializer, int i) {
        int i2 = SerializerFeature.BeanToArray.mask;
        return ((this.beanInfo.features & i2) == 0 && !jSONSerializer.out.beanToArray && (i & i2) == 0) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:172:0x02d9, code lost:
    
        if ((r31.beanInfo.features & r4) == 0) goto L263;
     */
    /* JADX WARN: Code restructure failed: missing block: B:394:0x00fa, code lost:
    
        if (r11.fieldTransient != false) goto L69;
     */
    /* JADX WARN: Removed duplicated region for block: B:242:0x046c A[Catch: all -> 0x03a8, Exception -> 0x03ab, TryCatch #4 {Exception -> 0x03ab, blocks: (B:238:0x03a2, B:240:0x0468, B:242:0x046c, B:244:0x0470, B:247:0x0479, B:249:0x0481, B:250:0x0489, B:252:0x048f, B:299:0x03b6, B:300:0x03b9, B:302:0x03bf, B:304:0x03cb, B:308:0x03e0, B:314:0x03ed, B:316:0x03fb, B:319:0x0403, B:322:0x040d, B:324:0x0415, B:325:0x041e, B:327:0x0427, B:329:0x042e, B:330:0x0432, B:332:0x0435, B:333:0x0439, B:334:0x043d, B:336:0x0442, B:337:0x0446, B:338:0x044a, B:340:0x044e, B:342:0x0452, B:346:0x0461, B:347:0x0465, B:348:0x03f5), top: B:237:0x03a2 }] */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0478  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0479 A[Catch: all -> 0x03a8, Exception -> 0x03ab, TryCatch #4 {Exception -> 0x03ab, blocks: (B:238:0x03a2, B:240:0x0468, B:242:0x046c, B:244:0x0470, B:247:0x0479, B:249:0x0481, B:250:0x0489, B:252:0x048f, B:299:0x03b6, B:300:0x03b9, B:302:0x03bf, B:304:0x03cb, B:308:0x03e0, B:314:0x03ed, B:316:0x03fb, B:319:0x0403, B:322:0x040d, B:324:0x0415, B:325:0x041e, B:327:0x0427, B:329:0x042e, B:330:0x0432, B:332:0x0435, B:333:0x0439, B:334:0x043d, B:336:0x0442, B:337:0x0446, B:338:0x044a, B:340:0x044e, B:342:0x0452, B:346:0x0461, B:347:0x0465, B:348:0x03f5), top: B:237:0x03a2 }] */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0540 A[Catch: all -> 0x0553, TRY_ENTER, TryCatch #10 {all -> 0x0553, blocks: (B:265:0x051b, B:268:0x0540, B:269:0x0590, B:271:0x0596, B:272:0x05ae, B:274:0x05b2, B:277:0x05bb, B:278:0x05c0, B:282:0x0557, B:284:0x055b, B:286:0x055f, B:287:0x057a), top: B:264:0x051b }] */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0596 A[Catch: all -> 0x0553, TryCatch #10 {all -> 0x0553, blocks: (B:265:0x051b, B:268:0x0540, B:269:0x0590, B:271:0x0596, B:272:0x05ae, B:274:0x05b2, B:277:0x05bb, B:278:0x05c0, B:282:0x0557, B:284:0x055b, B:286:0x055f, B:287:0x057a), top: B:264:0x051b }] */
    /* JADX WARN: Removed duplicated region for block: B:274:0x05b2 A[Catch: all -> 0x0553, TryCatch #10 {all -> 0x0553, blocks: (B:265:0x051b, B:268:0x0540, B:269:0x0590, B:271:0x0596, B:272:0x05ae, B:274:0x05b2, B:277:0x05bb, B:278:0x05c0, B:282:0x0557, B:284:0x055b, B:286:0x055f, B:287:0x057a), top: B:264:0x051b }] */
    /* JADX WARN: Removed duplicated region for block: B:276:0x05b8  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x05b9  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0555  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x03fb A[Catch: all -> 0x03a8, Exception -> 0x03ab, TryCatch #4 {Exception -> 0x03ab, blocks: (B:238:0x03a2, B:240:0x0468, B:242:0x046c, B:244:0x0470, B:247:0x0479, B:249:0x0481, B:250:0x0489, B:252:0x048f, B:299:0x03b6, B:300:0x03b9, B:302:0x03bf, B:304:0x03cb, B:308:0x03e0, B:314:0x03ed, B:316:0x03fb, B:319:0x0403, B:322:0x040d, B:324:0x0415, B:325:0x041e, B:327:0x0427, B:329:0x042e, B:330:0x0432, B:332:0x0435, B:333:0x0439, B:334:0x043d, B:336:0x0442, B:337:0x0446, B:338:0x044a, B:340:0x044e, B:342:0x0452, B:346:0x0461, B:347:0x0465, B:348:0x03f5), top: B:237:0x03a2 }] */
    /* JADX WARN: Removed duplicated region for block: B:347:0x0465 A[Catch: all -> 0x03a8, Exception -> 0x03ab, TryCatch #4 {Exception -> 0x03ab, blocks: (B:238:0x03a2, B:240:0x0468, B:242:0x046c, B:244:0x0470, B:247:0x0479, B:249:0x0481, B:250:0x0489, B:252:0x048f, B:299:0x03b6, B:300:0x03b9, B:302:0x03bf, B:304:0x03cb, B:308:0x03e0, B:314:0x03ed, B:316:0x03fb, B:319:0x0403, B:322:0x040d, B:324:0x0415, B:325:0x041e, B:327:0x0427, B:329:0x042e, B:330:0x0432, B:332:0x0435, B:333:0x0439, B:334:0x043d, B:336:0x0442, B:337:0x0446, B:338:0x044a, B:340:0x044e, B:342:0x0452, B:346:0x0461, B:347:0x0465, B:348:0x03f5), top: B:237:0x03a2 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:415:0x04ef  */
    /* JADX WARN: Removed duplicated region for block: B:423:0x050d A[Catch: all -> 0x03a8, Exception -> 0x0508, TRY_LEAVE, TryCatch #5 {all -> 0x03a8, blocks: (B:238:0x03a2, B:240:0x0468, B:242:0x046c, B:244:0x0470, B:247:0x0479, B:249:0x0481, B:250:0x0489, B:252:0x048f, B:299:0x03b6, B:300:0x03b9, B:302:0x03bf, B:304:0x03cb, B:308:0x03e0, B:314:0x03ed, B:316:0x03fb, B:319:0x0403, B:322:0x040d, B:324:0x0415, B:325:0x041e, B:327:0x0427, B:329:0x042e, B:330:0x0432, B:332:0x0435, B:333:0x0439, B:334:0x043d, B:336:0x0442, B:337:0x0446, B:338:0x044a, B:340:0x044e, B:342:0x0452, B:346:0x0461, B:347:0x0465, B:348:0x03f5, B:383:0x04ad, B:417:0x04f1, B:419:0x04f9, B:421:0x0501, B:423:0x050d), top: B:237:0x03a2 }] */
    /* JADX WARN: Removed duplicated region for block: B:437:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x016e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void write(com.alibaba.fastjson.serializer.JSONSerializer r32, java.lang.Object r33, java.lang.Object r34, java.lang.reflect.Type r35, int r36, boolean r37) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1476
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.JavaBeanSerializer.write(com.alibaba.fastjson.serializer.JSONSerializer, java.lang.Object, java.lang.Object, java.lang.reflect.Type, int, boolean):void");
    }

    public JavaBeanSerializer(Class<?> cls, Map<String, String> map) {
        this(TypeUtils.buildBeanInfo(cls, map, null));
    }

    public JavaBeanSerializer(SerializeBeanInfo serializeBeanInfo) {
        FieldSerializer[] fieldSerializerArr;
        this.beanInfo = serializeBeanInfo;
        this.sortedGetters = new FieldSerializer[serializeBeanInfo.sortedFields.length];
        int i = 0;
        while (true) {
            fieldSerializerArr = this.sortedGetters;
            if (i >= fieldSerializerArr.length) {
                break;
            }
            fieldSerializerArr[i] = new FieldSerializer(serializeBeanInfo.beanType, serializeBeanInfo.sortedFields[i]);
            i++;
        }
        FieldInfo[] fieldInfoArr = serializeBeanInfo.fields;
        if (fieldInfoArr == serializeBeanInfo.sortedFields) {
            this.getters = fieldSerializerArr;
        } else {
            this.getters = new FieldSerializer[fieldInfoArr.length];
            int i2 = 0;
            while (true) {
                if (i2 >= this.getters.length) {
                    break;
                }
                FieldSerializer fieldSerializer = getFieldSerializer(serializeBeanInfo.fields[i2].name);
                if (fieldSerializer == null) {
                    FieldSerializer[] fieldSerializerArr2 = this.sortedGetters;
                    System.arraycopy(fieldSerializerArr2, 0, this.getters, 0, fieldSerializerArr2.length);
                    break;
                } else {
                    this.getters[i2] = fieldSerializer;
                    i2++;
                }
            }
        }
        JSONType jSONType = serializeBeanInfo.jsonType;
        if (jSONType != null) {
            for (Class<? extends SerializeFilter> cls : jSONType.serialzeFilters()) {
                try {
                    addFilter(cls.getConstructor(null).newInstance(null));
                } catch (Exception unused) {
                }
            }
        }
    }

    public FieldSerializer getFieldSerializer(long j) {
        PropertyNamingStrategy[] propertyNamingStrategyArr;
        int binarySearch;
        if (this.hashArray == null) {
            propertyNamingStrategyArr = PropertyNamingStrategy.values();
            long[] jArr = new long[this.sortedGetters.length * propertyNamingStrategyArr.length];
            int i = 0;
            int i2 = 0;
            while (true) {
                FieldSerializer[] fieldSerializerArr = this.sortedGetters;
                if (i >= fieldSerializerArr.length) {
                    break;
                }
                String str = fieldSerializerArr[i].fieldInfo.name;
                jArr[i2] = TypeUtils.fnv1a_64(str);
                i2++;
                for (PropertyNamingStrategy propertyNamingStrategy : propertyNamingStrategyArr) {
                    String translate = propertyNamingStrategy.translate(str);
                    if (!str.equals(translate)) {
                        jArr[i2] = TypeUtils.fnv1a_64(translate);
                        i2++;
                    }
                }
                i++;
            }
            Arrays.sort(jArr, 0, i2);
            this.hashArray = new long[i2];
            System.arraycopy(jArr, 0, this.hashArray, 0, i2);
        } else {
            propertyNamingStrategyArr = null;
        }
        int binarySearch2 = Arrays.binarySearch(this.hashArray, j);
        if (binarySearch2 < 0) {
            return null;
        }
        if (this.hashArrayMapping == null) {
            if (propertyNamingStrategyArr == null) {
                propertyNamingStrategyArr = PropertyNamingStrategy.values();
            }
            short[] sArr = new short[this.hashArray.length];
            Arrays.fill(sArr, (short) -1);
            int i3 = 0;
            while (true) {
                FieldSerializer[] fieldSerializerArr2 = this.sortedGetters;
                if (i3 >= fieldSerializerArr2.length) {
                    break;
                }
                String str2 = fieldSerializerArr2[i3].fieldInfo.name;
                int binarySearch3 = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(str2));
                if (binarySearch3 >= 0) {
                    sArr[binarySearch3] = (short) i3;
                }
                for (PropertyNamingStrategy propertyNamingStrategy2 : propertyNamingStrategyArr) {
                    String translate2 = propertyNamingStrategy2.translate(str2);
                    if (!str2.equals(translate2) && (binarySearch = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(translate2))) >= 0) {
                        sArr[binarySearch] = (short) i3;
                    }
                }
                i3++;
            }
            this.hashArrayMapping = sArr;
        }
        short s = this.hashArrayMapping[binarySearch2];
        if (s != -1) {
            return this.sortedGetters[s];
        }
        return null;
    }

    public Object getFieldValue(Object obj, String str, long j, boolean z) {
        FieldSerializer fieldSerializer = getFieldSerializer(j);
        if (fieldSerializer == null) {
            if (!z) {
                return null;
            }
            throw new JSONException("field not found. " + str);
        }
        try {
            return fieldSerializer.getPropertyValue(obj);
        } catch (IllegalAccessException e) {
            throw new JSONException("getFieldValue error." + str, e);
        } catch (InvocationTargetException e2) {
            throw new JSONException("getFieldValue error." + str, e2);
        }
    }
}
