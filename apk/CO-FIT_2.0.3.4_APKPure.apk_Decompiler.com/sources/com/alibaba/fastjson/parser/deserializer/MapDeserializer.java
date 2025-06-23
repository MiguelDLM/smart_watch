package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.ParseContext;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class MapDeserializer extends ContextObjectDeserializer implements ObjectDeserializer {
    public static MapDeserializer instance = new MapDeserializer();

    public static Map parseMap(DefaultJSONParser defaultJSONParser, Map<String, Object> map, Type type, Object obj) {
        return parseMap(defaultJSONParser, map, type, obj, 0);
    }

    public Map<Object, Object> createMap(Type type) {
        return createMap(type, JSON.DEFAULT_GENERATE_FEATURE);
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, String str, int i) {
        Map<Object, Object> createMap;
        if (type == JSONObject.class && defaultJSONParser.getFieldTypeResolver() == null) {
            return defaultJSONParser.parseObject();
        }
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 8) {
            jSONLexer.nextToken(16);
            return null;
        }
        boolean z = (type instanceof Class) && "java.util.Collections$UnmodifiableMap".equals(((Class) type).getName());
        if ((jSONLexer.getFeatures() & Feature.OrderedField.mask) != 0) {
            createMap = createMap(type, jSONLexer.getFeatures());
        } else {
            createMap = createMap(type);
        }
        Map<Object, Object> map = createMap;
        ParseContext context = defaultJSONParser.getContext();
        try {
            defaultJSONParser.setContext(context, map, obj);
            T deserialze = deserialze(defaultJSONParser, type, obj, (Map) map, i);
            if (z) {
                deserialze = Collections.unmodifiableMap((Map) deserialze);
            }
            return deserialze;
        } finally {
            defaultJSONParser.setContext(context);
        }
    }

    public int getFastMatchToken() {
        return 12;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
        r12 = r5.getDeserializer((java.lang.reflect.Type) r9);
        r0.nextToken(16);
        r11.setResolveStatus(2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01d9, code lost:
        if (r1 == null) goto L_0x01e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01dd, code lost:
        if ((r14 instanceof java.lang.Integer) != false) goto L_0x01e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01df, code lost:
        r11.popContext();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01e2, code lost:
        r12 = (java.util.Map) r12.deserialze(r11, r9, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01e8, code lost:
        r11.setContext(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01eb, code lost:
        return r12;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map parseMap(com.alibaba.fastjson.parser.DefaultJSONParser r11, java.util.Map<java.lang.String, java.lang.Object> r12, java.lang.reflect.Type r13, java.lang.Object r14, int r15) {
        /*
            com.alibaba.fastjson.parser.JSONLexer r0 = r11.lexer
            int r1 = r0.token()
            r2 = 12
            r3 = 0
            r4 = 0
            if (r1 == r2) goto L_0x00a1
            r12 = 4
            if (r1 != r12) goto L_0x0022
            java.lang.String r13 = r0.stringVal()
            int r15 = r13.length()
            if (r15 == 0) goto L_0x0021
            java.lang.String r15 = "null"
            boolean r13 = r13.equals(r15)
            if (r13 == 0) goto L_0x0022
        L_0x0021:
            return r4
        L_0x0022:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r15 = "syntax error, expect {, actual "
            r13.append(r15)
            java.lang.String r15 = r0.tokenName()
            r13.append(r15)
            java.lang.String r13 = r13.toString()
            boolean r15 = r14 instanceof java.lang.String
            if (r15 == 0) goto L_0x005b
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r15.append(r13)
            java.lang.String r13 = ", fieldName "
            r15.append(r13)
            java.lang.String r13 = r15.toString()
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r15.append(r13)
            r15.append(r14)
            java.lang.String r13 = r15.toString()
        L_0x005b:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r15.append(r13)
            java.lang.String r13 = ", "
            r15.append(r13)
            java.lang.String r13 = r15.toString()
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r15.append(r13)
            java.lang.String r13 = r0.info()
            r15.append(r13)
            java.lang.String r13 = r15.toString()
            if (r1 == r12) goto L_0x009b
            com.alibaba.fastjson.JSONArray r12 = new com.alibaba.fastjson.JSONArray
            r12.<init>()
            r11.parseArray((java.util.Collection) r12, (java.lang.Object) r14)
            int r11 = r12.size()
            r14 = 1
            if (r11 != r14) goto L_0x009b
            java.lang.Object r11 = r12.get(r3)
            boolean r12 = r11 instanceof com.alibaba.fastjson.JSONObject
            if (r12 == 0) goto L_0x009b
            com.alibaba.fastjson.JSONObject r11 = (com.alibaba.fastjson.JSONObject) r11
            return r11
        L_0x009b:
            com.alibaba.fastjson.JSONException r11 = new com.alibaba.fastjson.JSONException
            r11.<init>(r13)
            throw r11
        L_0x00a1:
            com.alibaba.fastjson.parser.ParseContext r1 = r11.getContext()
        L_0x00a5:
            r0.skipWhitespace()     // Catch:{ all -> 0x00c3 }
            char r2 = r0.getCurrent()     // Catch:{ all -> 0x00c3 }
            com.alibaba.fastjson.parser.Feature r5 = com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas     // Catch:{ all -> 0x00c3 }
            boolean r5 = r0.isEnabled((com.alibaba.fastjson.parser.Feature) r5)     // Catch:{ all -> 0x00c3 }
            if (r5 == 0) goto L_0x00c6
        L_0x00b4:
            r5 = 44
            if (r2 != r5) goto L_0x00c6
            r0.next()     // Catch:{ all -> 0x00c3 }
            r0.skipWhitespace()     // Catch:{ all -> 0x00c3 }
            char r2 = r0.getCurrent()     // Catch:{ all -> 0x00c3 }
            goto L_0x00b4
        L_0x00c3:
            r12 = move-exception
            goto L_0x0256
        L_0x00c6:
            java.lang.String r5 = "expect ':' at "
            r6 = 58
            r7 = 34
            r8 = 16
            if (r2 != r7) goto L_0x00fc
            com.alibaba.fastjson.parser.SymbolTable r2 = r11.getSymbolTable()     // Catch:{ all -> 0x00c3 }
            java.lang.String r2 = r0.scanSymbol(r2, r7)     // Catch:{ all -> 0x00c3 }
            r0.skipWhitespace()     // Catch:{ all -> 0x00c3 }
            char r9 = r0.getCurrent()     // Catch:{ all -> 0x00c3 }
            if (r9 != r6) goto L_0x00e3
            goto L_0x0165
        L_0x00e3:
            com.alibaba.fastjson.JSONException r12 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x00c3 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c3 }
            r13.<init>()     // Catch:{ all -> 0x00c3 }
            r13.append(r5)     // Catch:{ all -> 0x00c3 }
            int r14 = r0.pos()     // Catch:{ all -> 0x00c3 }
            r13.append(r14)     // Catch:{ all -> 0x00c3 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x00c3 }
            r12.<init>(r13)     // Catch:{ all -> 0x00c3 }
            throw r12     // Catch:{ all -> 0x00c3 }
        L_0x00fc:
            r9 = 125(0x7d, float:1.75E-43)
            if (r2 != r9) goto L_0x010d
            r0.next()     // Catch:{ all -> 0x00c3 }
            r0.resetStringPosition()     // Catch:{ all -> 0x00c3 }
            r0.nextToken(r8)     // Catch:{ all -> 0x00c3 }
            r11.setContext(r1)
            return r12
        L_0x010d:
            java.lang.String r9 = "syntax error"
            r10 = 39
            if (r2 != r10) goto L_0x014c
            com.alibaba.fastjson.parser.Feature r2 = com.alibaba.fastjson.parser.Feature.AllowSingleQuotes     // Catch:{ all -> 0x00c3 }
            boolean r2 = r0.isEnabled((com.alibaba.fastjson.parser.Feature) r2)     // Catch:{ all -> 0x00c3 }
            if (r2 == 0) goto L_0x0146
            com.alibaba.fastjson.parser.SymbolTable r2 = r11.getSymbolTable()     // Catch:{ all -> 0x00c3 }
            java.lang.String r2 = r0.scanSymbol(r2, r10)     // Catch:{ all -> 0x00c3 }
            r0.skipWhitespace()     // Catch:{ all -> 0x00c3 }
            char r9 = r0.getCurrent()     // Catch:{ all -> 0x00c3 }
            if (r9 != r6) goto L_0x012d
            goto L_0x0165
        L_0x012d:
            com.alibaba.fastjson.JSONException r12 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x00c3 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c3 }
            r13.<init>()     // Catch:{ all -> 0x00c3 }
            r13.append(r5)     // Catch:{ all -> 0x00c3 }
            int r14 = r0.pos()     // Catch:{ all -> 0x00c3 }
            r13.append(r14)     // Catch:{ all -> 0x00c3 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x00c3 }
            r12.<init>(r13)     // Catch:{ all -> 0x00c3 }
            throw r12     // Catch:{ all -> 0x00c3 }
        L_0x0146:
            com.alibaba.fastjson.JSONException r12 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x00c3 }
            r12.<init>(r9)     // Catch:{ all -> 0x00c3 }
            throw r12     // Catch:{ all -> 0x00c3 }
        L_0x014c:
            com.alibaba.fastjson.parser.Feature r2 = com.alibaba.fastjson.parser.Feature.AllowUnQuotedFieldNames     // Catch:{ all -> 0x00c3 }
            boolean r2 = r0.isEnabled((com.alibaba.fastjson.parser.Feature) r2)     // Catch:{ all -> 0x00c3 }
            if (r2 == 0) goto L_0x0250
            com.alibaba.fastjson.parser.SymbolTable r2 = r11.getSymbolTable()     // Catch:{ all -> 0x00c3 }
            java.lang.String r2 = r0.scanSymbolUnQuoted(r2)     // Catch:{ all -> 0x00c3 }
            r0.skipWhitespace()     // Catch:{ all -> 0x00c3 }
            char r9 = r0.getCurrent()     // Catch:{ all -> 0x00c3 }
            if (r9 != r6) goto L_0x022f
        L_0x0165:
            r0.next()     // Catch:{ all -> 0x00c3 }
            r0.skipWhitespace()     // Catch:{ all -> 0x00c3 }
            r0.getCurrent()     // Catch:{ all -> 0x00c3 }
            r0.resetStringPosition()     // Catch:{ all -> 0x00c3 }
            java.lang.String r5 = com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY     // Catch:{ all -> 0x00c3 }
            r6 = 13
            if (r2 != r5) goto L_0x01ec
            com.alibaba.fastjson.parser.Feature r5 = com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect     // Catch:{ all -> 0x00c3 }
            boolean r9 = r0.isEnabled((com.alibaba.fastjson.parser.Feature) r5)     // Catch:{ all -> 0x00c3 }
            if (r9 != 0) goto L_0x01ec
            boolean r5 = com.alibaba.fastjson.parser.Feature.isEnabled(r15, r5)     // Catch:{ all -> 0x00c3 }
            if (r5 != 0) goto L_0x01ec
            com.alibaba.fastjson.parser.SymbolTable r2 = r11.getSymbolTable()     // Catch:{ all -> 0x00c3 }
            java.lang.String r2 = r0.scanSymbol(r2, r7)     // Catch:{ all -> 0x00c3 }
            com.alibaba.fastjson.parser.ParserConfig r5 = r11.getConfig()     // Catch:{ all -> 0x00c3 }
            java.lang.String r7 = "java.util.HashMap"
            boolean r7 = r2.equals(r7)     // Catch:{ all -> 0x00c3 }
            java.lang.Class<java.util.HashMap> r9 = java.util.HashMap.class
            if (r7 == 0) goto L_0x019c
            goto L_0x01b6
        L_0x019c:
            java.lang.String r7 = "java.util.LinkedHashMap"
            boolean r7 = r2.equals(r7)     // Catch:{ all -> 0x00c3 }
            if (r7 == 0) goto L_0x01a7
            java.lang.Class<java.util.LinkedHashMap> r9 = java.util.LinkedHashMap.class
            goto L_0x01b6
        L_0x01a7:
            boolean r7 = r5.isSafeMode()     // Catch:{ all -> 0x00c3 }
            if (r7 == 0) goto L_0x01ae
            goto L_0x01b6
        L_0x01ae:
            int r7 = r0.getFeatures()     // Catch:{ JSONException -> 0x01b6 }
            java.lang.Class r9 = r5.checkAutoType(r2, r4, r7)     // Catch:{ JSONException -> 0x01b6 }
        L_0x01b6:
            java.lang.Class<java.util.Map> r2 = java.util.Map.class
            boolean r2 = r2.isAssignableFrom(r9)     // Catch:{ all -> 0x00c3 }
            if (r2 == 0) goto L_0x01ce
            r0.nextToken(r8)     // Catch:{ all -> 0x00c3 }
            int r2 = r0.token()     // Catch:{ all -> 0x00c3 }
            if (r2 != r6) goto L_0x0227
            r0.nextToken(r8)     // Catch:{ all -> 0x00c3 }
            r11.setContext(r1)
            return r12
        L_0x01ce:
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r12 = r5.getDeserializer((java.lang.reflect.Type) r9)     // Catch:{ all -> 0x00c3 }
            r0.nextToken(r8)     // Catch:{ all -> 0x00c3 }
            r13 = 2
            r11.setResolveStatus(r13)     // Catch:{ all -> 0x00c3 }
            if (r1 == 0) goto L_0x01e2
            boolean r13 = r14 instanceof java.lang.Integer     // Catch:{ all -> 0x00c3 }
            if (r13 != 0) goto L_0x01e2
            r11.popContext()     // Catch:{ all -> 0x00c3 }
        L_0x01e2:
            java.lang.Object r12 = r12.deserialze(r11, r9, r14)     // Catch:{ all -> 0x00c3 }
            java.util.Map r12 = (java.util.Map) r12     // Catch:{ all -> 0x00c3 }
            r11.setContext(r1)
            return r12
        L_0x01ec:
            r0.nextToken()     // Catch:{ all -> 0x00c3 }
            if (r3 == 0) goto L_0x01f4
            r11.setContext(r1)     // Catch:{ all -> 0x00c3 }
        L_0x01f4:
            int r5 = r0.token()     // Catch:{ all -> 0x00c3 }
            r7 = 8
            if (r5 != r7) goto L_0x0201
            r0.nextToken()     // Catch:{ all -> 0x00c3 }
            r5 = r4
            goto L_0x0205
        L_0x0201:
            java.lang.Object r5 = r11.parseObject((java.lang.reflect.Type) r13, (java.lang.Object) r2)     // Catch:{ all -> 0x00c3 }
        L_0x0205:
            r12.put(r2, r5)     // Catch:{ all -> 0x00c3 }
            r11.checkMapResolve(r12, r2)     // Catch:{ all -> 0x00c3 }
            r11.setContext(r1, r5, r2)     // Catch:{ all -> 0x00c3 }
            r11.setContext(r1)     // Catch:{ all -> 0x00c3 }
            int r2 = r0.token()     // Catch:{ all -> 0x00c3 }
            r5 = 20
            if (r2 == r5) goto L_0x022b
            r5 = 15
            if (r2 != r5) goto L_0x021e
            goto L_0x022b
        L_0x021e:
            if (r2 != r6) goto L_0x0227
            r0.nextToken()     // Catch:{ all -> 0x00c3 }
            r11.setContext(r1)
            return r12
        L_0x0227:
            int r3 = r3 + 1
            goto L_0x00a5
        L_0x022b:
            r11.setContext(r1)
            return r12
        L_0x022f:
            com.alibaba.fastjson.JSONException r12 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x00c3 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c3 }
            r13.<init>()     // Catch:{ all -> 0x00c3 }
            r13.append(r5)     // Catch:{ all -> 0x00c3 }
            int r14 = r0.pos()     // Catch:{ all -> 0x00c3 }
            r13.append(r14)     // Catch:{ all -> 0x00c3 }
            java.lang.String r14 = ", actual "
            r13.append(r14)     // Catch:{ all -> 0x00c3 }
            r13.append(r9)     // Catch:{ all -> 0x00c3 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x00c3 }
            r12.<init>(r13)     // Catch:{ all -> 0x00c3 }
            throw r12     // Catch:{ all -> 0x00c3 }
        L_0x0250:
            com.alibaba.fastjson.JSONException r12 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x00c3 }
            r12.<init>(r9)     // Catch:{ all -> 0x00c3 }
            throw r12     // Catch:{ all -> 0x00c3 }
        L_0x0256:
            r11.setContext(r1)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.MapDeserializer.parseMap(com.alibaba.fastjson.parser.DefaultJSONParser, java.util.Map, java.lang.reflect.Type, java.lang.Object, int):java.util.Map");
    }

    public Map<Object, Object> createMap(Type type, int i) {
        if (type == Properties.class) {
            return new Properties();
        }
        if (type == Hashtable.class) {
            return new Hashtable();
        }
        if (type == IdentityHashMap.class) {
            return new IdentityHashMap();
        }
        if (type == SortedMap.class || type == TreeMap.class) {
            return new TreeMap();
        }
        if (type == ConcurrentMap.class || type == ConcurrentHashMap.class) {
            return new ConcurrentHashMap();
        }
        if (type == Map.class) {
            return (Feature.OrderedField.mask & i) != 0 ? new LinkedHashMap() : new HashMap();
        }
        if (type == HashMap.class) {
            return new HashMap();
        }
        if (type == LinkedHashMap.class) {
            return new LinkedHashMap();
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type rawType = parameterizedType.getRawType();
            if (EnumMap.class.equals(rawType)) {
                return new EnumMap((Class) parameterizedType.getActualTypeArguments()[0]);
            }
            return createMap(rawType, i);
        }
        Class cls = (Class) type;
        if (cls.isInterface()) {
            throw new JSONException("unsupport type " + type);
        } else if ("java.util.Collections$UnmodifiableMap".equals(cls.getName())) {
            return new HashMap();
        } else {
            try {
                return (Map) cls.newInstance();
            } catch (Exception e) {
                throw new JSONException("unsupport type " + type, e);
            }
        }
    }

    public Object deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, Map map) {
        return deserialze(defaultJSONParser, type, obj, map, 0);
    }

    public Object deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, Map map, int i) {
        Type type2;
        if (!(type instanceof ParameterizedType)) {
            return defaultJSONParser.parseObject(map, obj);
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type type3 = parameterizedType.getActualTypeArguments()[0];
        if (map.getClass().getName().equals("org.springframework.util.LinkedMultiValueMap")) {
            type2 = List.class;
        } else {
            type2 = parameterizedType.getActualTypeArguments()[1];
        }
        if (String.class == type3) {
            return parseMap(defaultJSONParser, (Map<String, Object>) map, type2, obj, i);
        }
        return parseMap(defaultJSONParser, (Map<Object, Object>) map, type3, type2, obj);
    }

    public static Object parseMap(DefaultJSONParser defaultJSONParser, Map<Object, Object> map, Type type, Type type2, Object obj) {
        Object obj2;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 12 || jSONLexer.token() == 16) {
            ObjectDeserializer deserializer = defaultJSONParser.getConfig().getDeserializer(type);
            ObjectDeserializer deserializer2 = defaultJSONParser.getConfig().getDeserializer(type2);
            jSONLexer.nextToken(deserializer.getFastMatchToken());
            ParseContext context = defaultJSONParser.getContext();
            while (jSONLexer.token() != 13) {
                try {
                    Object obj3 = null;
                    if (jSONLexer.token() != 4 || !jSONLexer.isRef() || jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                        if (map.size() == 0 && jSONLexer.token() == 4 && JSON.DEFAULT_TYPE_KEY.equals(jSONLexer.stringVal()) && !jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                            jSONLexer.nextTokenWithColon(4);
                            jSONLexer.nextToken(16);
                            if (jSONLexer.token() == 13) {
                                jSONLexer.nextToken();
                                return map;
                            }
                            jSONLexer.nextToken(deserializer.getFastMatchToken());
                        }
                        if (jSONLexer.token() != 4 || !(deserializer instanceof JavaBeanDeserializer)) {
                            obj2 = deserializer.deserialze(defaultJSONParser, type, (Object) null);
                        } else {
                            String stringVal = jSONLexer.stringVal();
                            jSONLexer.nextToken();
                            DefaultJSONParser defaultJSONParser2 = new DefaultJSONParser(stringVal, defaultJSONParser.getConfig(), defaultJSONParser.getLexer().getFeatures());
                            defaultJSONParser2.setDateFormat(defaultJSONParser.getDateFomartPattern());
                            obj2 = deserializer.deserialze(defaultJSONParser2, type, (Object) null);
                        }
                        if (jSONLexer.token() == 17) {
                            jSONLexer.nextToken(deserializer2.getFastMatchToken());
                            Object deserialze = deserializer2.deserialze(defaultJSONParser, type2, obj2);
                            defaultJSONParser.checkMapResolve(map, obj2);
                            map.put(obj2, deserialze);
                            if (jSONLexer.token() == 16) {
                                jSONLexer.nextToken(deserializer.getFastMatchToken());
                            }
                        } else {
                            throw new JSONException("syntax error, expect :, actual " + jSONLexer.token());
                        }
                    } else {
                        jSONLexer.nextTokenWithColon(4);
                        if (jSONLexer.token() == 4) {
                            String stringVal2 = jSONLexer.stringVal();
                            if ("..".equals(stringVal2)) {
                                obj3 = context.parent.object;
                            } else if ("$".equals(stringVal2)) {
                                ParseContext parseContext = context;
                                while (true) {
                                    ParseContext parseContext2 = parseContext.parent;
                                    if (parseContext2 == null) {
                                        break;
                                    }
                                    parseContext = parseContext2;
                                }
                                obj3 = parseContext.object;
                            } else {
                                defaultJSONParser.addResolveTask(new DefaultJSONParser.ResolveTask(context, stringVal2));
                                defaultJSONParser.setResolveStatus(1);
                            }
                            jSONLexer.nextToken(13);
                            if (jSONLexer.token() == 13) {
                                jSONLexer.nextToken(16);
                                defaultJSONParser.setContext(context);
                                return obj3;
                            }
                            throw new JSONException("illegal ref");
                        }
                        throw new JSONException("illegal ref, " + JSONToken.name(jSONLexer.token()));
                    }
                } finally {
                    defaultJSONParser.setContext(context);
                }
            }
            jSONLexer.nextToken(16);
            defaultJSONParser.setContext(context);
            return map;
        }
        throw new JSONException("syntax error, expect {, actual " + jSONLexer.tokenName());
    }
}
