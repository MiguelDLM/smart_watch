package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.util.FieldInfo;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public final class ResolveFieldDeserializer extends FieldDeserializer {
    private final Collection collection;
    private final int index;
    private final Object key;
    private final List list;
    private final Map map;
    private final DefaultJSONParser parser;

    public ResolveFieldDeserializer(DefaultJSONParser defaultJSONParser, List list2, int i) {
        super((Class<?>) null, (FieldInfo) null);
        this.parser = defaultJSONParser;
        this.index = i;
        this.list = list2;
        this.key = null;
        this.map = null;
        this.collection = null;
    }

    public void parseField(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map2) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
        r4 = (com.alibaba.fastjson.JSONArray) r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setValue(java.lang.Object r4, java.lang.Object r5) {
        /*
            r3 = this;
            java.util.Map r4 = r3.map
            if (r4 == 0) goto L_0x000a
            java.lang.Object r0 = r3.key
            r4.put(r0, r5)
            return
        L_0x000a:
            java.util.Collection r4 = r3.collection
            if (r4 == 0) goto L_0x0012
            r4.add(r5)
            return
        L_0x0012:
            java.util.List r4 = r3.list
            int r0 = r3.index
            r4.set(r0, r5)
            java.util.List r4 = r3.list
            boolean r0 = r4 instanceof com.alibaba.fastjson.JSONArray
            if (r0 == 0) goto L_0x0048
            com.alibaba.fastjson.JSONArray r4 = (com.alibaba.fastjson.JSONArray) r4
            java.lang.Object r0 = r4.getRelatedArray()
            if (r0 == 0) goto L_0x0048
            int r1 = java.lang.reflect.Array.getLength(r0)
            int r2 = r3.index
            if (r1 <= r2) goto L_0x0048
            java.lang.reflect.Type r1 = r4.getComponentType()
            if (r1 == 0) goto L_0x0043
            java.lang.reflect.Type r4 = r4.getComponentType()
            com.alibaba.fastjson.parser.DefaultJSONParser r1 = r3.parser
            com.alibaba.fastjson.parser.ParserConfig r1 = r1.getConfig()
            java.lang.Object r5 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r5, (java.lang.reflect.Type) r4, (com.alibaba.fastjson.parser.ParserConfig) r1)
        L_0x0043:
            int r4 = r3.index
            java.lang.reflect.Array.set(r0, r4, r5)
        L_0x0048:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.ResolveFieldDeserializer.setValue(java.lang.Object, java.lang.Object):void");
    }

    public ResolveFieldDeserializer(Map map2, Object obj) {
        super((Class<?>) null, (FieldInfo) null);
        this.parser = null;
        this.index = -1;
        this.list = null;
        this.key = obj;
        this.map = map2;
        this.collection = null;
    }

    public ResolveFieldDeserializer(Collection collection2) {
        super((Class<?>) null, (FieldInfo) null);
        this.parser = null;
        this.index = -1;
        this.list = null;
        this.key = null;
        this.map = null;
        this.collection = collection2;
    }
}
