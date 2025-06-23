package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.JSONPathException;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessable;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.ResolveFieldDeserializer;
import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class DefaultJSONParser implements Closeable {
    public static final int NONE = 0;
    public static final int NeedToResolve = 1;
    public static final int TypeNameRedirect = 2;
    private static final Set<Class<?>> primitiveClasses;
    private String[] autoTypeAccept;
    private boolean autoTypeEnable;
    protected ParserConfig config;
    protected ParseContext context;
    private ParseContext[] contextArray;
    private int contextArrayIndex;
    private DateFormat dateFormat;
    private String dateFormatPattern;
    private List<ExtraProcessor> extraProcessors;
    private List<ExtraTypeProvider> extraTypeProviders;
    protected FieldTypeResolver fieldTypeResolver;
    public final Object input;
    protected transient BeanContext lastBeanContext;
    public final JSONLexer lexer;
    private int objectKeyLevel;
    public int resolveStatus;
    private List<ResolveTask> resolveTaskList;
    public final SymbolTable symbolTable;

    public static class ResolveTask {
        public final ParseContext context;
        public FieldDeserializer fieldDeserializer;
        public ParseContext ownerContext;
        public final String referenceValue;

        public ResolveTask(ParseContext parseContext, String str) {
            this.context = parseContext;
            this.referenceValue = str;
        }
    }

    static {
        HashSet hashSet = new HashSet();
        primitiveClasses = hashSet;
        hashSet.addAll(Arrays.asList(new Class[]{Boolean.TYPE, Byte.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Boolean.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, BigInteger.class, BigDecimal.class, String.class}));
    }

    public DefaultJSONParser(String str) {
        this(str, ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);
    }

    private void addContext(ParseContext parseContext) {
        int i = this.contextArrayIndex;
        this.contextArrayIndex = i + 1;
        ParseContext[] parseContextArr = this.contextArray;
        if (parseContextArr == null) {
            this.contextArray = new ParseContext[8];
        } else if (i >= parseContextArr.length) {
            ParseContext[] parseContextArr2 = new ParseContext[((parseContextArr.length * 3) / 2)];
            System.arraycopy(parseContextArr, 0, parseContextArr2, 0, parseContextArr.length);
            this.contextArray = parseContextArr2;
        }
        this.contextArray[i] = parseContext;
    }

    public final void accept(int i) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == i) {
            jSONLexer.nextToken();
            return;
        }
        throw new JSONException("syntax error, expect " + JSONToken.name(i) + ", actual " + JSONToken.name(jSONLexer.token()));
    }

    public void acceptType(String str) {
        JSONLexer jSONLexer = this.lexer;
        jSONLexer.nextTokenWithColon();
        if (jSONLexer.token() != 4) {
            throw new JSONException("type not match error");
        } else if (str.equals(jSONLexer.stringVal())) {
            jSONLexer.nextToken();
            if (jSONLexer.token() == 16) {
                jSONLexer.nextToken();
            }
        } else {
            throw new JSONException("type not match error");
        }
    }

    public void addResolveTask(ResolveTask resolveTask) {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        this.resolveTaskList.add(resolveTask);
    }

    public void checkListResolve(Collection collection) {
        if (this.resolveStatus != 1) {
            return;
        }
        if (collection instanceof List) {
            ResolveTask lastResolveTask = getLastResolveTask();
            lastResolveTask.fieldDeserializer = new ResolveFieldDeserializer(this, (List) collection, collection.size() - 1);
            lastResolveTask.ownerContext = this.context;
            setResolveStatus(0);
            return;
        }
        ResolveTask lastResolveTask2 = getLastResolveTask();
        lastResolveTask2.fieldDeserializer = new ResolveFieldDeserializer(collection);
        lastResolveTask2.ownerContext = this.context;
        setResolveStatus(0);
    }

    public void checkMapResolve(Map map, Object obj) {
        if (this.resolveStatus == 1) {
            ResolveFieldDeserializer resolveFieldDeserializer = new ResolveFieldDeserializer(map, obj);
            ResolveTask lastResolveTask = getLastResolveTask();
            lastResolveTask.fieldDeserializer = resolveFieldDeserializer;
            lastResolveTask.ownerContext = this.context;
            setResolveStatus(0);
        }
    }

    public void close() {
        JSONLexer jSONLexer = this.lexer;
        try {
            if (jSONLexer.isEnabled(Feature.AutoCloseSource)) {
                if (jSONLexer.token() != 20) {
                    throw new JSONException("not close json text, token : " + JSONToken.name(jSONLexer.token()));
                }
            }
        } finally {
            jSONLexer.close();
        }
    }

    public void config(Feature feature, boolean z) {
        this.lexer.config(feature, z);
    }

    public ParserConfig getConfig() {
        return this.config;
    }

    public ParseContext getContext() {
        return this.context;
    }

    public String getDateFomartPattern() {
        return this.dateFormatPattern;
    }

    public DateFormat getDateFormat() {
        if (this.dateFormat == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.dateFormatPattern, this.lexer.getLocale());
            this.dateFormat = simpleDateFormat;
            simpleDateFormat.setTimeZone(this.lexer.getTimeZone());
        }
        return this.dateFormat;
    }

    public List<ExtraProcessor> getExtraProcessors() {
        if (this.extraProcessors == null) {
            this.extraProcessors = new ArrayList(2);
        }
        return this.extraProcessors;
    }

    public List<ExtraTypeProvider> getExtraTypeProviders() {
        if (this.extraTypeProviders == null) {
            this.extraTypeProviders = new ArrayList(2);
        }
        return this.extraTypeProviders;
    }

    public FieldTypeResolver getFieldTypeResolver() {
        return this.fieldTypeResolver;
    }

    public String getInput() {
        Object obj = this.input;
        if (obj instanceof char[]) {
            return new String((char[]) obj);
        }
        return obj.toString();
    }

    public ResolveTask getLastResolveTask() {
        List<ResolveTask> list = this.resolveTaskList;
        return list.get(list.size() - 1);
    }

    public JSONLexer getLexer() {
        return this.lexer;
    }

    public Object getObject(String str) {
        for (int i = 0; i < this.contextArrayIndex; i++) {
            if (str.equals(this.contextArray[i].toString())) {
                return this.contextArray[i].object;
            }
        }
        return null;
    }

    public ParseContext getOwnerContext() {
        return this.context.parent;
    }

    public int getResolveStatus() {
        return this.resolveStatus;
    }

    public List<ResolveTask> getResolveTaskList() {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        return this.resolveTaskList;
    }

    public SymbolTable getSymbolTable() {
        return this.symbolTable;
    }

    public void handleResovleTask(Object obj) {
        Object obj2;
        Object obj3;
        ParseContext parseContext;
        FieldInfo fieldInfo;
        List<ResolveTask> list = this.resolveTaskList;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ResolveTask resolveTask = this.resolveTaskList.get(i);
                String str = resolveTask.referenceValue;
                ParseContext parseContext2 = resolveTask.ownerContext;
                if (parseContext2 != null) {
                    obj2 = parseContext2.object;
                } else {
                    obj2 = null;
                }
                if (str.startsWith("$")) {
                    obj3 = getObject(str);
                    if (obj3 == null) {
                        try {
                            JSONPath jSONPath = new JSONPath(str, SerializeConfig.getGlobalInstance(), this.config, true);
                            if (jSONPath.isRef()) {
                                obj3 = jSONPath.eval(obj);
                            }
                        } catch (JSONPathException unused) {
                        }
                    }
                } else {
                    obj3 = resolveTask.context.object;
                }
                FieldDeserializer fieldDeserializer = resolveTask.fieldDeserializer;
                if (fieldDeserializer != null) {
                    if (obj3 != null && obj3.getClass() == JSONObject.class && (fieldInfo = fieldDeserializer.fieldInfo) != null && !Map.class.isAssignableFrom(fieldInfo.fieldClass)) {
                        Object obj4 = this.contextArray[0].object;
                        JSONPath compile = JSONPath.compile(str);
                        if (compile.isRef()) {
                            obj3 = compile.eval(obj4);
                        }
                    }
                    if (fieldDeserializer.getOwnerClass() != null && !fieldDeserializer.getOwnerClass().isInstance(obj2) && (parseContext = resolveTask.ownerContext.parent) != null) {
                        while (true) {
                            if (parseContext == null) {
                                break;
                            } else if (fieldDeserializer.getOwnerClass().isInstance(parseContext.object)) {
                                obj2 = parseContext.object;
                                break;
                            } else {
                                parseContext = parseContext.parent;
                            }
                        }
                    }
                    fieldDeserializer.setValue(obj2, obj3);
                }
            }
        }
    }

    public boolean isEnabled(Feature feature) {
        return this.lexer.isEnabled(feature);
    }

    public Object parse() {
        return parse((Object) null);
    }

    public <T> List<T> parseArray(Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        parseArray((Class<?>) cls, (Collection) arrayList);
        return arrayList;
    }

    public Object parseArrayWithType(Type type) {
        if (this.lexer.token() == 8) {
            this.lexer.nextToken();
            return null;
        }
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        if (actualTypeArguments.length == 1) {
            Type type2 = actualTypeArguments[0];
            if (type2 instanceof Class) {
                ArrayList arrayList = new ArrayList();
                parseArray((Class<?>) (Class) type2, (Collection) arrayList);
                return arrayList;
            } else if (type2 instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type2;
                Type type3 = wildcardType.getUpperBounds()[0];
                if (!Object.class.equals(type3)) {
                    ArrayList arrayList2 = new ArrayList();
                    parseArray((Class<?>) (Class) type3, (Collection) arrayList2);
                    return arrayList2;
                } else if (wildcardType.getLowerBounds().length == 0) {
                    return parse();
                } else {
                    throw new JSONException("not support type : " + type);
                }
            } else {
                if (type2 instanceof TypeVariable) {
                    TypeVariable typeVariable = (TypeVariable) type2;
                    Type[] bounds = typeVariable.getBounds();
                    if (bounds.length == 1) {
                        Type type4 = bounds[0];
                        if (type4 instanceof Class) {
                            ArrayList arrayList3 = new ArrayList();
                            parseArray((Class<?>) (Class) type4, (Collection) arrayList3);
                            return arrayList3;
                        }
                    } else {
                        throw new JSONException("not support : " + typeVariable);
                    }
                }
                if (type2 instanceof ParameterizedType) {
                    ArrayList arrayList4 = new ArrayList();
                    parseArray((Type) (ParameterizedType) type2, (Collection) arrayList4);
                    return arrayList4;
                }
                throw new JSONException("TODO : " + type);
            }
        } else {
            throw new JSONException("not support type " + type);
        }
    }

    public void parseExtra(Object obj, String str) {
        Object obj2;
        this.lexer.nextTokenWithColon();
        List<ExtraTypeProvider> list = this.extraTypeProviders;
        Type type = null;
        if (list != null) {
            for (ExtraTypeProvider extraType : list) {
                type = extraType.getExtraType(obj, str);
            }
        }
        if (type == null) {
            obj2 = parse();
        } else {
            obj2 = parseObject(type);
        }
        if (obj instanceof ExtraProcessable) {
            ((ExtraProcessable) obj).processExtra(str, obj2);
            return;
        }
        List<ExtraProcessor> list2 = this.extraProcessors;
        if (list2 != null) {
            for (ExtraProcessor processExtra : list2) {
                processExtra.processExtra(obj, str, obj2);
            }
        }
        if (this.resolveStatus == 1) {
            this.resolveStatus = 0;
        }
    }

    public Object parseKey() {
        if (this.lexer.token() != 18) {
            return parse((Object) null);
        }
        String stringVal = this.lexer.stringVal();
        this.lexer.nextToken(16);
        return stringVal;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v22, resolved type: com.alibaba.fastjson.JSONArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v25, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v26, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v27, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v28, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v46, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v49, resolved type: com.alibaba.fastjson.JSONArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v50, resolved type: com.alibaba.fastjson.JSONArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v51, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v52, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v53, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v54, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v55, resolved type: java.util.Date} */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x028e, code lost:
        r13 = null;
        r8 = r1.config.checkAutoType(r7, (java.lang.Class<?>) null, r5.getFeatures());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x02a6, code lost:
        r5.nextToken(16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x02b1, code lost:
        if (r5.token() != 13) goto L_0x0305;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x02b3, code lost:
        r5.nextToken(16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x02be, code lost:
        if ((r1.config.getDeserializer((java.lang.reflect.Type) r8) instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) == false) goto L_0x02ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x02c0, code lost:
        r13 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r0, r8, r1.config);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x02ca, code lost:
        if (r13 != null) goto L_0x02f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x02ce, code lost:
        if (r8 != java.lang.Cloneable.class) goto L_0x02d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x02d0, code lost:
        r13 = new java.util.HashMap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x02dc, code lost:
        if ("java.util.Collections$EmptyMap".equals(r7) == false) goto L_0x02e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x02de, code lost:
        r13 = java.util.Collections.emptyMap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x02e9, code lost:
        if ("java.util.Collections$UnmodifiableMap".equals(r7) == false) goto L_0x02f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x02eb, code lost:
        r13 = java.util.Collections.unmodifiableMap(new java.util.HashMap());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x02f5, code lost:
        r13 = r8.newInstance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x02f9, code lost:
        setContext(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x02fc, code lost:
        return r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0305, code lost:
        setResolveStatus(2);
        r3 = r1.context;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x030b, code lost:
        if (r3 == null) goto L_0x031c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x030d, code lost:
        if (r2 == null) goto L_0x031c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0311, code lost:
        if ((r2 instanceof java.lang.Integer) != false) goto L_0x031c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0317, code lost:
        if ((r3.fieldName instanceof java.lang.Integer) != false) goto L_0x031c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0319, code lost:
        popContext();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x0320, code lost:
        if (r18.size() <= 0) goto L_0x0333;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0322, code lost:
        r0 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r0, r8, r1.config);
        setResolveStatus(0);
        parseObject(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x032f, code lost:
        setContext(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0332, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:?, code lost:
        r0 = r1.config.getDeserializer((java.lang.reflect.Type) r8);
        r3 = r0.getClass();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0343, code lost:
        if (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.class.isAssignableFrom(r3) == false) goto L_0x0352;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x0347, code lost:
        if (r3 == com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.class) goto L_0x0352;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x034b, code lost:
        if (r3 == com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer.class) goto L_0x0352;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x034d, code lost:
        setResolveStatus(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x0354, code lost:
        if ((r0 instanceof com.alibaba.fastjson.parser.deserializer.MapDeserializer) == false) goto L_0x035a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x0356, code lost:
        setResolveStatus(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x035a, code lost:
        r0 = r0.deserialze(r1, r8, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x035e, code lost:
        setContext(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x0361, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x03aa, code lost:
        if ("@".equals(r7) == false) goto L_0x03c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x03ac, code lost:
        r0 = r1.context;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x03ae, code lost:
        if (r0 == null) goto L_0x0417;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x03b0, code lost:
        r2 = r0.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x03b4, code lost:
        if ((r2 instanceof java.lang.Object[]) != false) goto L_0x03c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x03b8, code lost:
        if ((r2 instanceof java.util.Collection) == false) goto L_0x03bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x03bb, code lost:
        r0 = r0.parent;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x03bd, code lost:
        if (r0 == null) goto L_0x0417;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x03bf, code lost:
        r8 = r0.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x03c3, code lost:
        r8 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x03cb, code lost:
        if ("..".equals(r7) == false) goto L_0x03e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x03cd, code lost:
        r0 = r6.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x03cf, code lost:
        if (r0 == null) goto L_0x03d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x03d1, code lost:
        r8 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x03d3, code lost:
        addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r6, r7));
        setResolveStatus(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x03e6, code lost:
        if ("$".equals(r7) == false) goto L_0x0401;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x03e8, code lost:
        r0 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x03e9, code lost:
        r2 = r0.parent;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x03eb, code lost:
        if (r2 == null) goto L_0x03ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x03ed, code lost:
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x03ef, code lost:
        r2 = r0.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x03f1, code lost:
        if (r2 == null) goto L_0x03f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x03f4, code lost:
        addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r0, r7));
        setResolveStatus(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x0409, code lost:
        if (com.alibaba.fastjson.JSONPath.compile(r7).isRef() == false) goto L_0x0419;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x040b, code lost:
        addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r6, r7));
        setResolveStatus(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:0x0417, code lost:
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x0419, code lost:
        r8 = new com.alibaba.fastjson.JSONObject().fluentPut("$ref", r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x042a, code lost:
        if (r5.token() != 13) goto L_0x0435;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x042c, code lost:
        r5.nextToken(16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:0x0431, code lost:
        setContext(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x0434, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:0x044f, code lost:
        throw new com.alibaba.fastjson.JSONException("syntax error, " + r5.info());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:305:0x04fe, code lost:
        if (r8 != '}') goto L_0x0510;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:306:0x0500, code lost:
        r5.next();
        r5.resetStringPosition();
        r5.nextToken();
        setContext(r7, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:307:0x050c, code lost:
        setContext(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:308:0x050f, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:311:0x0530, code lost:
        throw new com.alibaba.fastjson.JSONException("syntax error, position at " + r5.pos() + ", name " + r15);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x021e A[Catch:{ Exception -> 0x02c8, NumberFormatException -> 0x01a6, all -> 0x0080 }] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0237 A[Catch:{ Exception -> 0x02c8, NumberFormatException -> 0x01a6, all -> 0x0080 }] */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x029e A[Catch:{ Exception -> 0x02c8, NumberFormatException -> 0x01a6, all -> 0x0080 }] */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x0362  */
    /* JADX WARNING: Removed duplicated region for block: B:361:0x05f3 A[Catch:{ Exception -> 0x02c8, NumberFormatException -> 0x01a6, all -> 0x0080 }] */
    /* JADX WARNING: Removed duplicated region for block: B:366:0x05ff A[Catch:{ Exception -> 0x02c8, NumberFormatException -> 0x01a6, all -> 0x0080 }] */
    /* JADX WARNING: Removed duplicated region for block: B:369:0x060b A[Catch:{ Exception -> 0x02c8, NumberFormatException -> 0x01a6, all -> 0x0080 }] */
    /* JADX WARNING: Removed duplicated region for block: B:375:0x0620 A[SYNTHETIC, Splitter:B:375:0x0620] */
    /* JADX WARNING: Removed duplicated region for block: B:403:0x0616 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:407:0x02a6 A[EDGE_INSN: B:407:0x02a6->B:150:0x02a6 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:418:0x018d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x018b A[Catch:{ Exception -> 0x02c8, NumberFormatException -> 0x01a6, all -> 0x0080 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object parseObject(java.util.Map r18, java.lang.Object r19) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r2 = r19
            java.lang.String r3 = "parse number key error"
            java.lang.Class<java.util.Map> r4 = java.util.Map.class
            com.alibaba.fastjson.parser.JSONLexer r5 = r1.lexer
            int r6 = r5.token()
            r7 = 8
            r8 = 0
            if (r6 != r7) goto L_0x0019
            r5.nextToken()
            return r8
        L_0x0019:
            int r6 = r5.token()
            r7 = 13
            if (r6 != r7) goto L_0x0025
            r5.nextToken()
            return r0
        L_0x0025:
            int r6 = r5.token()
            r9 = 4
            if (r6 != r9) goto L_0x003a
            java.lang.String r6 = r5.stringVal()
            int r6 = r6.length()
            if (r6 != 0) goto L_0x003a
            r5.nextToken()
            return r0
        L_0x003a:
            int r6 = r5.token()
            r10 = 12
            r11 = 16
            if (r6 == r10) goto L_0x0072
            int r6 = r5.token()
            if (r6 != r11) goto L_0x004b
            goto L_0x0072
        L_0x004b:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "syntax error, expect {, actual "
            r2.append(r3)
            java.lang.String r3 = r5.tokenName()
            r2.append(r3)
            java.lang.String r3 = ", "
            r2.append(r3)
            java.lang.String r3 = r5.info()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x0072:
            com.alibaba.fastjson.parser.ParseContext r6 = r1.context
            boolean r10 = r0 instanceof com.alibaba.fastjson.JSONObject     // Catch:{ all -> 0x0080 }
            if (r10 == 0) goto L_0x0083
            r12 = r0
            com.alibaba.fastjson.JSONObject r12 = (com.alibaba.fastjson.JSONObject) r12     // Catch:{ all -> 0x0080 }
            java.util.Map r12 = r12.getInnerMap()     // Catch:{ all -> 0x0080 }
            goto L_0x0084
        L_0x0080:
            r0 = move-exception
            goto L_0x06ab
        L_0x0083:
            r12 = r0
        L_0x0084:
            r14 = 0
        L_0x0085:
            r5.skipWhitespace()     // Catch:{ all -> 0x0080 }
            char r15 = r5.getCurrent()     // Catch:{ all -> 0x0080 }
            com.alibaba.fastjson.parser.Feature r9 = com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas     // Catch:{ all -> 0x0080 }
            boolean r9 = r5.isEnabled((com.alibaba.fastjson.parser.Feature) r9)     // Catch:{ all -> 0x0080 }
            r13 = 44
            if (r9 == 0) goto L_0x00a3
        L_0x0096:
            if (r15 != r13) goto L_0x00a3
            r5.next()     // Catch:{ all -> 0x0080 }
            r5.skipWhitespace()     // Catch:{ all -> 0x0080 }
            char r15 = r5.getCurrent()     // Catch:{ all -> 0x0080 }
            goto L_0x0096
        L_0x00a3:
            java.lang.String r11 = ", name "
            java.lang.String r7 = "expect ':' at "
            r13 = 34
            java.lang.String r8 = "syntax error"
            if (r15 != r13) goto L_0x00e0
            com.alibaba.fastjson.parser.SymbolTable r15 = r1.symbolTable     // Catch:{ all -> 0x0080 }
            java.lang.String r15 = r5.scanSymbol(r15, r13)     // Catch:{ all -> 0x0080 }
            r5.skipWhitespace()     // Catch:{ all -> 0x0080 }
            char r13 = r5.getCurrent()     // Catch:{ all -> 0x0080 }
            r9 = 58
            if (r13 != r9) goto L_0x00c1
        L_0x00be:
            r7 = 0
            goto L_0x021c
        L_0x00c1:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0080 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0080 }
            r2.<init>()     // Catch:{ all -> 0x0080 }
            r2.append(r7)     // Catch:{ all -> 0x0080 }
            int r3 = r5.pos()     // Catch:{ all -> 0x0080 }
            r2.append(r3)     // Catch:{ all -> 0x0080 }
            r2.append(r11)     // Catch:{ all -> 0x0080 }
            r2.append(r15)     // Catch:{ all -> 0x0080 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0080 }
            r0.<init>(r2)     // Catch:{ all -> 0x0080 }
            throw r0     // Catch:{ all -> 0x0080 }
        L_0x00e0:
            r9 = 125(0x7d, float:1.75E-43)
            if (r15 != r9) goto L_0x0108
            r5.next()     // Catch:{ all -> 0x0080 }
            r5.resetStringPosition()     // Catch:{ all -> 0x0080 }
            r5.nextToken()     // Catch:{ all -> 0x0080 }
            if (r14 != 0) goto L_0x0104
            com.alibaba.fastjson.parser.ParseContext r3 = r1.context     // Catch:{ all -> 0x0080 }
            if (r3 == 0) goto L_0x00fd
            java.lang.Object r4 = r3.fieldName     // Catch:{ all -> 0x0080 }
            if (r2 != r4) goto L_0x00fd
            java.lang.Object r4 = r3.object     // Catch:{ all -> 0x0080 }
            if (r0 != r4) goto L_0x00fd
            r6 = r3
            goto L_0x0104
        L_0x00fd:
            com.alibaba.fastjson.parser.ParseContext r2 = r17.setContext(r18, r19)     // Catch:{ all -> 0x0080 }
            if (r6 != 0) goto L_0x0104
            r6 = r2
        L_0x0104:
            r1.setContext(r6)
            return r0
        L_0x0108:
            r9 = 39
            if (r15 != r9) goto L_0x0145
            com.alibaba.fastjson.parser.Feature r13 = com.alibaba.fastjson.parser.Feature.AllowSingleQuotes     // Catch:{ all -> 0x0080 }
            boolean r13 = r5.isEnabled((com.alibaba.fastjson.parser.Feature) r13)     // Catch:{ all -> 0x0080 }
            if (r13 == 0) goto L_0x013f
            com.alibaba.fastjson.parser.SymbolTable r13 = r1.symbolTable     // Catch:{ all -> 0x0080 }
            java.lang.String r15 = r5.scanSymbol(r13, r9)     // Catch:{ all -> 0x0080 }
            r5.skipWhitespace()     // Catch:{ all -> 0x0080 }
            char r9 = r5.getCurrent()     // Catch:{ all -> 0x0080 }
            r13 = 58
            if (r9 != r13) goto L_0x0126
            goto L_0x00be
        L_0x0126:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0080 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0080 }
            r2.<init>()     // Catch:{ all -> 0x0080 }
            r2.append(r7)     // Catch:{ all -> 0x0080 }
            int r3 = r5.pos()     // Catch:{ all -> 0x0080 }
            r2.append(r3)     // Catch:{ all -> 0x0080 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0080 }
            r0.<init>(r2)     // Catch:{ all -> 0x0080 }
            throw r0     // Catch:{ all -> 0x0080 }
        L_0x013f:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0080 }
            r0.<init>(r8)     // Catch:{ all -> 0x0080 }
            throw r0     // Catch:{ all -> 0x0080 }
        L_0x0145:
            r9 = 26
            if (r15 == r9) goto L_0x06a5
            r9 = 44
            if (r15 == r9) goto L_0x069f
            r9 = 48
            if (r15 < r9) goto L_0x0155
            r9 = 57
            if (r15 <= r9) goto L_0x0159
        L_0x0155:
            r9 = 45
            if (r15 != r9) goto L_0x01bf
        L_0x0159:
            r5.resetStringPosition()     // Catch:{ all -> 0x0080 }
            r5.scanNumber()     // Catch:{ all -> 0x0080 }
            int r7 = r5.token()     // Catch:{ NumberFormatException -> 0x01a6 }
            r9 = 2
            if (r7 != r9) goto L_0x016b
            java.lang.Number r7 = r5.integerValue()     // Catch:{ NumberFormatException -> 0x01a6 }
            goto L_0x0171
        L_0x016b:
            r7 = 1
            java.lang.Number r9 = r5.decimalValue(r7)     // Catch:{ NumberFormatException -> 0x01a6 }
            r7 = r9
        L_0x0171:
            com.alibaba.fastjson.parser.Feature r9 = com.alibaba.fastjson.parser.Feature.NonStringKeyAsString     // Catch:{ NumberFormatException -> 0x01a6 }
            boolean r9 = r5.isEnabled((com.alibaba.fastjson.parser.Feature) r9)     // Catch:{ NumberFormatException -> 0x01a6 }
            if (r9 != 0) goto L_0x017e
            if (r10 == 0) goto L_0x017c
            goto L_0x017e
        L_0x017c:
            r15 = r7
            goto L_0x0183
        L_0x017e:
            java.lang.String r7 = r7.toString()     // Catch:{ NumberFormatException -> 0x01a6 }
            goto L_0x017c
        L_0x0183:
            char r7 = r5.getCurrent()     // Catch:{ all -> 0x0080 }
            r9 = 58
            if (r7 != r9) goto L_0x018d
            goto L_0x00be
        L_0x018d:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0080 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0080 }
            r2.<init>()     // Catch:{ all -> 0x0080 }
            r2.append(r3)     // Catch:{ all -> 0x0080 }
            java.lang.String r3 = r5.info()     // Catch:{ all -> 0x0080 }
            r2.append(r3)     // Catch:{ all -> 0x0080 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0080 }
            r0.<init>(r2)     // Catch:{ all -> 0x0080 }
            throw r0     // Catch:{ all -> 0x0080 }
        L_0x01a6:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0080 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0080 }
            r2.<init>()     // Catch:{ all -> 0x0080 }
            r2.append(r3)     // Catch:{ all -> 0x0080 }
            java.lang.String r3 = r5.info()     // Catch:{ all -> 0x0080 }
            r2.append(r3)     // Catch:{ all -> 0x0080 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0080 }
            r0.<init>(r2)     // Catch:{ all -> 0x0080 }
            throw r0     // Catch:{ all -> 0x0080 }
        L_0x01bf:
            r9 = 123(0x7b, float:1.72E-43)
            if (r15 == r9) goto L_0x020a
            r9 = 91
            if (r15 != r9) goto L_0x01c8
            goto L_0x020a
        L_0x01c8:
            com.alibaba.fastjson.parser.Feature r9 = com.alibaba.fastjson.parser.Feature.AllowUnQuotedFieldNames     // Catch:{ all -> 0x0080 }
            boolean r9 = r5.isEnabled((com.alibaba.fastjson.parser.Feature) r9)     // Catch:{ all -> 0x0080 }
            if (r9 == 0) goto L_0x0204
            com.alibaba.fastjson.parser.SymbolTable r9 = r1.symbolTable     // Catch:{ all -> 0x0080 }
            java.lang.String r15 = r5.scanSymbolUnQuoted(r9)     // Catch:{ all -> 0x0080 }
            r5.skipWhitespace()     // Catch:{ all -> 0x0080 }
            char r9 = r5.getCurrent()     // Catch:{ all -> 0x0080 }
            r13 = 58
            if (r9 != r13) goto L_0x01e3
            goto L_0x00be
        L_0x01e3:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0080 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0080 }
            r2.<init>()     // Catch:{ all -> 0x0080 }
            r2.append(r7)     // Catch:{ all -> 0x0080 }
            int r3 = r5.pos()     // Catch:{ all -> 0x0080 }
            r2.append(r3)     // Catch:{ all -> 0x0080 }
            java.lang.String r3 = ", actual "
            r2.append(r3)     // Catch:{ all -> 0x0080 }
            r2.append(r9)     // Catch:{ all -> 0x0080 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0080 }
            r0.<init>(r2)     // Catch:{ all -> 0x0080 }
            throw r0     // Catch:{ all -> 0x0080 }
        L_0x0204:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0080 }
            r0.<init>(r8)     // Catch:{ all -> 0x0080 }
            throw r0     // Catch:{ all -> 0x0080 }
        L_0x020a:
            int r7 = r1.objectKeyLevel     // Catch:{ all -> 0x0080 }
            int r9 = r7 + 1
            r1.objectKeyLevel = r9     // Catch:{ all -> 0x0080 }
            r9 = 512(0x200, float:7.175E-43)
            if (r7 > r9) goto L_0x0697
            r5.nextToken()     // Catch:{ all -> 0x0080 }
            java.lang.Object r15 = r17.parse()     // Catch:{ all -> 0x0080 }
            r7 = 1
        L_0x021c:
            if (r7 != 0) goto L_0x0224
            r5.next()     // Catch:{ all -> 0x0080 }
            r5.skipWhitespace()     // Catch:{ all -> 0x0080 }
        L_0x0224:
            char r7 = r5.getCurrent()     // Catch:{ all -> 0x0080 }
            r5.resetStringPosition()     // Catch:{ all -> 0x0080 }
            java.lang.String r9 = com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY     // Catch:{ all -> 0x0080 }
            if (r15 != r9) goto L_0x0362
            com.alibaba.fastjson.parser.Feature r9 = com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect     // Catch:{ all -> 0x0080 }
            boolean r9 = r5.isEnabled((com.alibaba.fastjson.parser.Feature) r9)     // Catch:{ all -> 0x0080 }
            if (r9 != 0) goto L_0x0362
            com.alibaba.fastjson.parser.SymbolTable r7 = r1.symbolTable     // Catch:{ all -> 0x0080 }
            r8 = 34
            java.lang.String r7 = r5.scanSymbol(r7, r8)     // Catch:{ all -> 0x0080 }
            com.alibaba.fastjson.parser.Feature r8 = com.alibaba.fastjson.parser.Feature.IgnoreAutoType     // Catch:{ all -> 0x0080 }
            boolean r8 = r5.isEnabled((com.alibaba.fastjson.parser.Feature) r8)     // Catch:{ all -> 0x0080 }
            if (r8 == 0) goto L_0x024b
            r9 = 4
            r13 = 0
            goto L_0x039d
        L_0x024b:
            if (r0 == 0) goto L_0x0261
            java.lang.Class r8 = r18.getClass()     // Catch:{ all -> 0x0080 }
            java.lang.String r8 = r8.getName()     // Catch:{ all -> 0x0080 }
            boolean r8 = r8.equals(r7)     // Catch:{ all -> 0x0080 }
            if (r8 == 0) goto L_0x0261
            java.lang.Class r8 = r18.getClass()     // Catch:{ all -> 0x0080 }
        L_0x025f:
            r13 = 0
            goto L_0x029c
        L_0x0261:
            java.lang.String r8 = "java.util.HashMap"
            boolean r8 = r8.equals(r7)     // Catch:{ all -> 0x0080 }
            if (r8 == 0) goto L_0x026c
            java.lang.Class<java.util.HashMap> r8 = java.util.HashMap.class
            goto L_0x025f
        L_0x026c:
            java.lang.String r8 = "java.util.LinkedHashMap"
            boolean r8 = r8.equals(r7)     // Catch:{ all -> 0x0080 }
            if (r8 == 0) goto L_0x0277
            java.lang.Class<java.util.LinkedHashMap> r8 = java.util.LinkedHashMap.class
            goto L_0x025f
        L_0x0277:
            r8 = 0
        L_0x0278:
            int r9 = r7.length()     // Catch:{ all -> 0x0080 }
            if (r8 >= r9) goto L_0x029a
            char r9 = r7.charAt(r8)     // Catch:{ all -> 0x0080 }
            r11 = 48
            if (r9 < r11) goto L_0x028e
            r11 = 57
            if (r9 <= r11) goto L_0x028b
            goto L_0x028e
        L_0x028b:
            int r8 = r8 + 1
            goto L_0x0278
        L_0x028e:
            com.alibaba.fastjson.parser.ParserConfig r8 = r1.config     // Catch:{ all -> 0x0080 }
            int r9 = r5.getFeatures()     // Catch:{ all -> 0x0080 }
            r13 = 0
            java.lang.Class r8 = r8.checkAutoType(r7, r13, r9)     // Catch:{ all -> 0x0080 }
            goto L_0x029c
        L_0x029a:
            r13 = 0
            r8 = r13
        L_0x029c:
            if (r8 != 0) goto L_0x02a6
            java.lang.String r8 = com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY     // Catch:{ all -> 0x0080 }
            r12.put(r8, r7)     // Catch:{ all -> 0x0080 }
            r9 = 4
            goto L_0x039d
        L_0x02a6:
            r3 = 16
            r5.nextToken(r3)     // Catch:{ all -> 0x0080 }
            int r4 = r5.token()     // Catch:{ all -> 0x0080 }
            r9 = 13
            if (r4 != r9) goto L_0x0305
            r5.nextToken(r3)     // Catch:{ all -> 0x0080 }
            com.alibaba.fastjson.parser.ParserConfig r2 = r1.config     // Catch:{ Exception -> 0x02c8 }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r2 = r2.getDeserializer((java.lang.reflect.Type) r8)     // Catch:{ Exception -> 0x02c8 }
            boolean r2 = r2 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer     // Catch:{ Exception -> 0x02c8 }
            if (r2 == 0) goto L_0x02ca
            com.alibaba.fastjson.parser.ParserConfig r2 = r1.config     // Catch:{ Exception -> 0x02c8 }
            java.lang.Object r0 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r0, r8, (com.alibaba.fastjson.parser.ParserConfig) r2)     // Catch:{ Exception -> 0x02c8 }
            r13 = r0
            goto L_0x02ca
        L_0x02c8:
            r0 = move-exception
            goto L_0x02fd
        L_0x02ca:
            if (r13 != 0) goto L_0x02f9
            java.lang.Class<java.lang.Cloneable> r0 = java.lang.Cloneable.class
            if (r8 != r0) goto L_0x02d6
            java.util.HashMap r13 = new java.util.HashMap     // Catch:{ Exception -> 0x02c8 }
            r13.<init>()     // Catch:{ Exception -> 0x02c8 }
            goto L_0x02f9
        L_0x02d6:
            java.lang.String r0 = "java.util.Collections$EmptyMap"
            boolean r0 = r0.equals(r7)     // Catch:{ Exception -> 0x02c8 }
            if (r0 == 0) goto L_0x02e3
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch:{ Exception -> 0x02c8 }
            goto L_0x02f9
        L_0x02e3:
            java.lang.String r0 = "java.util.Collections$UnmodifiableMap"
            boolean r0 = r0.equals(r7)     // Catch:{ Exception -> 0x02c8 }
            if (r0 == 0) goto L_0x02f5
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x02c8 }
            r0.<init>()     // Catch:{ Exception -> 0x02c8 }
            java.util.Map r13 = java.util.Collections.unmodifiableMap(r0)     // Catch:{ Exception -> 0x02c8 }
            goto L_0x02f9
        L_0x02f5:
            java.lang.Object r13 = r8.newInstance()     // Catch:{ Exception -> 0x02c8 }
        L_0x02f9:
            r1.setContext(r6)
            return r13
        L_0x02fd:
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0080 }
            java.lang.String r3 = "create instance error"
            r2.<init>(r3, r0)     // Catch:{ all -> 0x0080 }
            throw r2     // Catch:{ all -> 0x0080 }
        L_0x0305:
            r3 = 2
            r1.setResolveStatus(r3)     // Catch:{ all -> 0x0080 }
            com.alibaba.fastjson.parser.ParseContext r3 = r1.context     // Catch:{ all -> 0x0080 }
            if (r3 == 0) goto L_0x031c
            if (r2 == 0) goto L_0x031c
            boolean r4 = r2 instanceof java.lang.Integer     // Catch:{ all -> 0x0080 }
            if (r4 != 0) goto L_0x031c
            java.lang.Object r3 = r3.fieldName     // Catch:{ all -> 0x0080 }
            boolean r3 = r3 instanceof java.lang.Integer     // Catch:{ all -> 0x0080 }
            if (r3 != 0) goto L_0x031c
            r17.popContext()     // Catch:{ all -> 0x0080 }
        L_0x031c:
            int r3 = r18.size()     // Catch:{ all -> 0x0080 }
            if (r3 <= 0) goto L_0x0333
            com.alibaba.fastjson.parser.ParserConfig r2 = r1.config     // Catch:{ all -> 0x0080 }
            java.lang.Object r0 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r0, r8, (com.alibaba.fastjson.parser.ParserConfig) r2)     // Catch:{ all -> 0x0080 }
            r2 = 0
            r1.setResolveStatus(r2)     // Catch:{ all -> 0x0080 }
            r1.parseObject((java.lang.Object) r0)     // Catch:{ all -> 0x0080 }
            r1.setContext(r6)
            return r0
        L_0x0333:
            com.alibaba.fastjson.parser.ParserConfig r0 = r1.config     // Catch:{ all -> 0x0080 }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r0 = r0.getDeserializer((java.lang.reflect.Type) r8)     // Catch:{ all -> 0x0080 }
            java.lang.Class r3 = r0.getClass()     // Catch:{ all -> 0x0080 }
            java.lang.Class<com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer> r4 = com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.class
            boolean r4 = r4.isAssignableFrom(r3)     // Catch:{ all -> 0x0080 }
            if (r4 == 0) goto L_0x0352
            java.lang.Class<com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer> r4 = com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.class
            if (r3 == r4) goto L_0x0352
            java.lang.Class<com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer> r4 = com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer.class
            if (r3 == r4) goto L_0x0352
            r3 = 0
            r1.setResolveStatus(r3)     // Catch:{ all -> 0x0080 }
            goto L_0x035a
        L_0x0352:
            boolean r3 = r0 instanceof com.alibaba.fastjson.parser.deserializer.MapDeserializer     // Catch:{ all -> 0x0080 }
            if (r3 == 0) goto L_0x035a
            r9 = 0
            r1.setResolveStatus(r9)     // Catch:{ all -> 0x0080 }
        L_0x035a:
            java.lang.Object r0 = r0.deserialze(r1, r8, r2)     // Catch:{ all -> 0x0080 }
            r1.setContext(r6)
            return r0
        L_0x0362:
            r13 = 0
            java.lang.String r9 = "$ref"
            if (r15 != r9) goto L_0x0372
            if (r6 == 0) goto L_0x0372
            if (r0 == 0) goto L_0x0377
            int r9 = r18.size()     // Catch:{ all -> 0x0080 }
            if (r9 != 0) goto L_0x0372
            goto L_0x0377
        L_0x0372:
            r9 = 4
            r16 = 1
            goto L_0x046f
        L_0x0377:
            com.alibaba.fastjson.parser.Feature r9 = com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect     // Catch:{ all -> 0x0080 }
            boolean r9 = r5.isEnabled((com.alibaba.fastjson.parser.Feature) r9)     // Catch:{ all -> 0x0080 }
            if (r9 != 0) goto L_0x0372
            r9 = 4
            r5.nextToken(r9)     // Catch:{ all -> 0x0080 }
            int r7 = r5.token()     // Catch:{ all -> 0x0080 }
            if (r7 != r9) goto L_0x0450
            java.lang.String r7 = r5.stringVal()     // Catch:{ all -> 0x0080 }
            r8 = 13
            r5.nextToken(r8)     // Catch:{ all -> 0x0080 }
            int r8 = r5.token()     // Catch:{ all -> 0x0080 }
            r11 = 16
            if (r8 != r11) goto L_0x03a4
            r12.put(r15, r7)     // Catch:{ all -> 0x0080 }
        L_0x039d:
            r8 = r13
            r7 = 13
        L_0x03a0:
            r11 = 16
            goto L_0x0085
        L_0x03a4:
            java.lang.String r0 = "@"
            boolean r0 = r0.equals(r7)     // Catch:{ all -> 0x0080 }
            if (r0 == 0) goto L_0x03c5
            com.alibaba.fastjson.parser.ParseContext r0 = r1.context     // Catch:{ all -> 0x0080 }
            if (r0 == 0) goto L_0x0417
            java.lang.Object r2 = r0.object     // Catch:{ all -> 0x0080 }
            boolean r3 = r2 instanceof java.lang.Object[]     // Catch:{ all -> 0x0080 }
            if (r3 != 0) goto L_0x03c3
            boolean r3 = r2 instanceof java.util.Collection     // Catch:{ all -> 0x0080 }
            if (r3 == 0) goto L_0x03bb
            goto L_0x03c3
        L_0x03bb:
            com.alibaba.fastjson.parser.ParseContext r0 = r0.parent     // Catch:{ all -> 0x0080 }
            if (r0 == 0) goto L_0x0417
            java.lang.Object r8 = r0.object     // Catch:{ all -> 0x0080 }
            goto L_0x0424
        L_0x03c3:
            r8 = r2
            goto L_0x0424
        L_0x03c5:
            java.lang.String r0 = ".."
            boolean r0 = r0.equals(r7)     // Catch:{ all -> 0x0080 }
            if (r0 == 0) goto L_0x03e0
            java.lang.Object r0 = r6.object     // Catch:{ all -> 0x0080 }
            if (r0 == 0) goto L_0x03d3
            r8 = r0
            goto L_0x0424
        L_0x03d3:
            com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask r0 = new com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask     // Catch:{ all -> 0x0080 }
            r0.<init>(r6, r7)     // Catch:{ all -> 0x0080 }
            r1.addResolveTask(r0)     // Catch:{ all -> 0x0080 }
            r0 = 1
            r1.setResolveStatus(r0)     // Catch:{ all -> 0x0080 }
            goto L_0x0417
        L_0x03e0:
            java.lang.String r0 = "$"
            boolean r0 = r0.equals(r7)     // Catch:{ all -> 0x0080 }
            if (r0 == 0) goto L_0x0401
            r0 = r6
        L_0x03e9:
            com.alibaba.fastjson.parser.ParseContext r2 = r0.parent     // Catch:{ all -> 0x0080 }
            if (r2 == 0) goto L_0x03ef
            r0 = r2
            goto L_0x03e9
        L_0x03ef:
            java.lang.Object r2 = r0.object     // Catch:{ all -> 0x0080 }
            if (r2 == 0) goto L_0x03f4
            goto L_0x03c3
        L_0x03f4:
            com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask r2 = new com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask     // Catch:{ all -> 0x0080 }
            r2.<init>(r0, r7)     // Catch:{ all -> 0x0080 }
            r1.addResolveTask(r2)     // Catch:{ all -> 0x0080 }
            r0 = 1
            r1.setResolveStatus(r0)     // Catch:{ all -> 0x0080 }
            goto L_0x0417
        L_0x0401:
            com.alibaba.fastjson.JSONPath r0 = com.alibaba.fastjson.JSONPath.compile(r7)     // Catch:{ all -> 0x0080 }
            boolean r0 = r0.isRef()     // Catch:{ all -> 0x0080 }
            if (r0 == 0) goto L_0x0419
            com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask r0 = new com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask     // Catch:{ all -> 0x0080 }
            r0.<init>(r6, r7)     // Catch:{ all -> 0x0080 }
            r1.addResolveTask(r0)     // Catch:{ all -> 0x0080 }
            r0 = 1
            r1.setResolveStatus(r0)     // Catch:{ all -> 0x0080 }
        L_0x0417:
            r8 = r13
            goto L_0x0424
        L_0x0419:
            com.alibaba.fastjson.JSONObject r0 = new com.alibaba.fastjson.JSONObject     // Catch:{ all -> 0x0080 }
            r0.<init>()     // Catch:{ all -> 0x0080 }
            java.lang.String r2 = "$ref"
            com.alibaba.fastjson.JSONObject r8 = r0.fluentPut(r2, r7)     // Catch:{ all -> 0x0080 }
        L_0x0424:
            int r0 = r5.token()     // Catch:{ all -> 0x0080 }
            r2 = 13
            if (r0 != r2) goto L_0x0435
            r0 = 16
            r5.nextToken(r0)     // Catch:{ all -> 0x0080 }
            r1.setContext(r6)
            return r8
        L_0x0435:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0080 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0080 }
            r2.<init>()     // Catch:{ all -> 0x0080 }
            java.lang.String r3 = "syntax error, "
            r2.append(r3)     // Catch:{ all -> 0x0080 }
            java.lang.String r3 = r5.info()     // Catch:{ all -> 0x0080 }
            r2.append(r3)     // Catch:{ all -> 0x0080 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0080 }
            r0.<init>(r2)     // Catch:{ all -> 0x0080 }
            throw r0     // Catch:{ all -> 0x0080 }
        L_0x0450:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0080 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0080 }
            r2.<init>()     // Catch:{ all -> 0x0080 }
            java.lang.String r3 = "illegal ref, "
            r2.append(r3)     // Catch:{ all -> 0x0080 }
            int r3 = r5.token()     // Catch:{ all -> 0x0080 }
            java.lang.String r3 = com.alibaba.fastjson.parser.JSONToken.name(r3)     // Catch:{ all -> 0x0080 }
            r2.append(r3)     // Catch:{ all -> 0x0080 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0080 }
            r0.<init>(r2)     // Catch:{ all -> 0x0080 }
            throw r0     // Catch:{ all -> 0x0080 }
        L_0x046f:
            if (r14 != 0) goto L_0x0487
            com.alibaba.fastjson.parser.ParseContext r9 = r1.context     // Catch:{ all -> 0x0080 }
            if (r9 == 0) goto L_0x047f
            java.lang.Object r13 = r9.fieldName     // Catch:{ all -> 0x0080 }
            if (r2 != r13) goto L_0x047f
            java.lang.Object r13 = r9.object     // Catch:{ all -> 0x0080 }
            if (r0 != r13) goto L_0x047f
            r6 = r9
            goto L_0x0487
        L_0x047f:
            com.alibaba.fastjson.parser.ParseContext r9 = r17.setContext(r18, r19)     // Catch:{ all -> 0x0080 }
            if (r6 != 0) goto L_0x0486
            r6 = r9
        L_0x0486:
            r14 = 1
        L_0x0487:
            java.lang.Class r9 = r18.getClass()     // Catch:{ all -> 0x0080 }
            java.lang.Class<com.alibaba.fastjson.JSONObject> r13 = com.alibaba.fastjson.JSONObject.class
            if (r9 != r13) goto L_0x0493
            if (r15 != 0) goto L_0x0493
            java.lang.String r15 = "null"
        L_0x0493:
            r9 = 34
            if (r7 != r9) goto L_0x04c0
            r5.scanString()     // Catch:{ all -> 0x0080 }
            java.lang.String r7 = r5.stringVal()     // Catch:{ all -> 0x0080 }
            com.alibaba.fastjson.parser.Feature r8 = com.alibaba.fastjson.parser.Feature.AllowISO8601DateFormat     // Catch:{ all -> 0x0080 }
            boolean r8 = r5.isEnabled((com.alibaba.fastjson.parser.Feature) r8)     // Catch:{ all -> 0x0080 }
            if (r8 == 0) goto L_0x04bc
            com.alibaba.fastjson.parser.JSONScanner r8 = new com.alibaba.fastjson.parser.JSONScanner     // Catch:{ all -> 0x0080 }
            r8.<init>(r7)     // Catch:{ all -> 0x0080 }
            boolean r9 = r8.scanISO8601DateIfMatch()     // Catch:{ all -> 0x0080 }
            if (r9 == 0) goto L_0x04b9
            java.util.Calendar r7 = r8.getCalendar()     // Catch:{ all -> 0x0080 }
            java.util.Date r7 = r7.getTime()     // Catch:{ all -> 0x0080 }
        L_0x04b9:
            r8.close()     // Catch:{ all -> 0x0080 }
        L_0x04bc:
            r12.put(r15, r7)     // Catch:{ all -> 0x0080 }
            goto L_0x04e8
        L_0x04c0:
            r9 = 48
            if (r7 < r9) goto L_0x04c8
            r9 = 57
            if (r7 <= r9) goto L_0x04cc
        L_0x04c8:
            r9 = 45
            if (r7 != r9) goto L_0x0531
        L_0x04cc:
            r5.scanNumber()     // Catch:{ all -> 0x0080 }
            int r7 = r5.token()     // Catch:{ all -> 0x0080 }
            r8 = 2
            if (r7 != r8) goto L_0x04db
            java.lang.Number r7 = r5.integerValue()     // Catch:{ all -> 0x0080 }
            goto L_0x04e5
        L_0x04db:
            com.alibaba.fastjson.parser.Feature r7 = com.alibaba.fastjson.parser.Feature.UseBigDecimal     // Catch:{ all -> 0x0080 }
            boolean r7 = r5.isEnabled((com.alibaba.fastjson.parser.Feature) r7)     // Catch:{ all -> 0x0080 }
            java.lang.Number r7 = r5.decimalValue(r7)     // Catch:{ all -> 0x0080 }
        L_0x04e5:
            r12.put(r15, r7)     // Catch:{ all -> 0x0080 }
        L_0x04e8:
            r5.skipWhitespace()     // Catch:{ all -> 0x0080 }
            char r8 = r5.getCurrent()     // Catch:{ all -> 0x0080 }
            r9 = 44
            if (r8 != r9) goto L_0x04fc
            r5.next()     // Catch:{ all -> 0x0080 }
        L_0x04f6:
            r8 = 13
            r9 = 16
            goto L_0x0670
        L_0x04fc:
            r2 = 125(0x7d, float:1.75E-43)
            if (r8 != r2) goto L_0x0510
            r5.next()     // Catch:{ all -> 0x0080 }
            r5.resetStringPosition()     // Catch:{ all -> 0x0080 }
            r5.nextToken()     // Catch:{ all -> 0x0080 }
            r1.setContext(r7, r15)     // Catch:{ all -> 0x0080 }
            r1.setContext(r6)
            return r0
        L_0x0510:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0080 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0080 }
            r2.<init>()     // Catch:{ all -> 0x0080 }
            java.lang.String r3 = "syntax error, position at "
            r2.append(r3)     // Catch:{ all -> 0x0080 }
            int r3 = r5.pos()     // Catch:{ all -> 0x0080 }
            r2.append(r3)     // Catch:{ all -> 0x0080 }
            r2.append(r11)     // Catch:{ all -> 0x0080 }
            r2.append(r15)     // Catch:{ all -> 0x0080 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0080 }
            r0.<init>(r2)     // Catch:{ all -> 0x0080 }
            throw r0     // Catch:{ all -> 0x0080 }
        L_0x0531:
            r9 = 91
            if (r7 != r9) goto L_0x057d
            r5.nextToken()     // Catch:{ all -> 0x0080 }
            com.alibaba.fastjson.JSONArray r7 = new com.alibaba.fastjson.JSONArray     // Catch:{ all -> 0x0080 }
            r7.<init>()     // Catch:{ all -> 0x0080 }
            if (r2 == 0) goto L_0x0545
            java.lang.Class r9 = r19.getClass()     // Catch:{ all -> 0x0080 }
            java.lang.Class<java.lang.Integer> r11 = java.lang.Integer.class
        L_0x0545:
            if (r2 != 0) goto L_0x054a
            r1.setContext(r6)     // Catch:{ all -> 0x0080 }
        L_0x054a:
            r1.parseArray((java.util.Collection) r7, (java.lang.Object) r15)     // Catch:{ all -> 0x0080 }
            com.alibaba.fastjson.parser.Feature r9 = com.alibaba.fastjson.parser.Feature.UseObjectArray     // Catch:{ all -> 0x0080 }
            boolean r9 = r5.isEnabled((com.alibaba.fastjson.parser.Feature) r9)     // Catch:{ all -> 0x0080 }
            if (r9 == 0) goto L_0x0559
            java.lang.Object[] r7 = r7.toArray()     // Catch:{ all -> 0x0080 }
        L_0x0559:
            r12.put(r15, r7)     // Catch:{ all -> 0x0080 }
            int r7 = r5.token()     // Catch:{ all -> 0x0080 }
            r9 = 13
            if (r7 != r9) goto L_0x056b
            r5.nextToken()     // Catch:{ all -> 0x0080 }
            r1.setContext(r6)
            return r0
        L_0x056b:
            int r7 = r5.token()     // Catch:{ all -> 0x0080 }
            r9 = 16
            if (r7 != r9) goto L_0x0577
            r8 = 13
            goto L_0x0670
        L_0x0577:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0080 }
            r0.<init>(r8)     // Catch:{ all -> 0x0080 }
            throw r0     // Catch:{ all -> 0x0080 }
        L_0x057d:
            r8 = 123(0x7b, float:1.72E-43)
            if (r7 != r8) goto L_0x064f
            r5.nextToken()     // Catch:{ all -> 0x0080 }
            if (r2 == 0) goto L_0x0590
            java.lang.Class r7 = r19.getClass()     // Catch:{ all -> 0x0080 }
            java.lang.Class<java.lang.Integer> r8 = java.lang.Integer.class
            if (r7 != r8) goto L_0x0590
            r7 = 1
            goto L_0x0591
        L_0x0590:
            r7 = 0
        L_0x0591:
            com.alibaba.fastjson.parser.Feature r8 = com.alibaba.fastjson.parser.Feature.CustomMapDeserializer     // Catch:{ all -> 0x0080 }
            boolean r8 = r5.isEnabled((com.alibaba.fastjson.parser.Feature) r8)     // Catch:{ all -> 0x0080 }
            if (r8 == 0) goto L_0x05ba
            com.alibaba.fastjson.parser.ParserConfig r8 = r1.config     // Catch:{ all -> 0x0080 }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r8 = r8.getDeserializer((java.lang.reflect.Type) r4)     // Catch:{ all -> 0x0080 }
            com.alibaba.fastjson.parser.deserializer.MapDeserializer r8 = (com.alibaba.fastjson.parser.deserializer.MapDeserializer) r8     // Catch:{ all -> 0x0080 }
            int r9 = r5.getFeatures()     // Catch:{ all -> 0x0080 }
            com.alibaba.fastjson.parser.Feature r11 = com.alibaba.fastjson.parser.Feature.OrderedField     // Catch:{ all -> 0x0080 }
            int r11 = r11.mask     // Catch:{ all -> 0x0080 }
            r9 = r9 & r11
            if (r9 == 0) goto L_0x05b5
            int r9 = r5.getFeatures()     // Catch:{ all -> 0x0080 }
            java.util.Map r8 = r8.createMap(r4, r9)     // Catch:{ all -> 0x0080 }
            goto L_0x05c5
        L_0x05b5:
            java.util.Map r8 = r8.createMap(r4)     // Catch:{ all -> 0x0080 }
            goto L_0x05c5
        L_0x05ba:
            com.alibaba.fastjson.JSONObject r8 = new com.alibaba.fastjson.JSONObject     // Catch:{ all -> 0x0080 }
            com.alibaba.fastjson.parser.Feature r9 = com.alibaba.fastjson.parser.Feature.OrderedField     // Catch:{ all -> 0x0080 }
            boolean r9 = r5.isEnabled((com.alibaba.fastjson.parser.Feature) r9)     // Catch:{ all -> 0x0080 }
            r8.<init>((boolean) r9)     // Catch:{ all -> 0x0080 }
        L_0x05c5:
            if (r7 != 0) goto L_0x05ce
            com.alibaba.fastjson.parser.ParseContext r9 = r1.context     // Catch:{ all -> 0x0080 }
            com.alibaba.fastjson.parser.ParseContext r9 = r1.setContext(r9, r8, r15)     // Catch:{ all -> 0x0080 }
            goto L_0x05cf
        L_0x05ce:
            r9 = 0
        L_0x05cf:
            com.alibaba.fastjson.parser.deserializer.FieldTypeResolver r11 = r1.fieldTypeResolver     // Catch:{ all -> 0x0080 }
            if (r11 == 0) goto L_0x05ee
            if (r15 == 0) goto L_0x05da
            java.lang.String r11 = r15.toString()     // Catch:{ all -> 0x0080 }
            goto L_0x05db
        L_0x05da:
            r11 = 0
        L_0x05db:
            com.alibaba.fastjson.parser.deserializer.FieldTypeResolver r13 = r1.fieldTypeResolver     // Catch:{ all -> 0x0080 }
            java.lang.reflect.Type r11 = r13.resolve(r0, r11)     // Catch:{ all -> 0x0080 }
            if (r11 == 0) goto L_0x05ee
            com.alibaba.fastjson.parser.ParserConfig r13 = r1.config     // Catch:{ all -> 0x0080 }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r13 = r13.getDeserializer((java.lang.reflect.Type) r11)     // Catch:{ all -> 0x0080 }
            java.lang.Object r11 = r13.deserialze(r1, r11, r15)     // Catch:{ all -> 0x0080 }
            goto L_0x05f1
        L_0x05ee:
            r11 = 0
            r16 = 0
        L_0x05f1:
            if (r16 != 0) goto L_0x05f7
            java.lang.Object r11 = r1.parseObject((java.util.Map) r8, (java.lang.Object) r15)     // Catch:{ all -> 0x0080 }
        L_0x05f7:
            if (r9 == 0) goto L_0x05fd
            if (r8 == r11) goto L_0x05fd
            r9.object = r0     // Catch:{ all -> 0x0080 }
        L_0x05fd:
            if (r15 == 0) goto L_0x0606
            java.lang.String r8 = r15.toString()     // Catch:{ all -> 0x0080 }
            r1.checkMapResolve(r0, r8)     // Catch:{ all -> 0x0080 }
        L_0x0606:
            r12.put(r15, r11)     // Catch:{ all -> 0x0080 }
            if (r7 == 0) goto L_0x060e
            r1.setContext(r11, r15)     // Catch:{ all -> 0x0080 }
        L_0x060e:
            int r8 = r5.token()     // Catch:{ all -> 0x0080 }
            r9 = 13
            if (r8 != r9) goto L_0x0620
            r5.nextToken()     // Catch:{ all -> 0x0080 }
            r1.setContext(r6)     // Catch:{ all -> 0x0080 }
            r1.setContext(r6)
            return r0
        L_0x0620:
            int r8 = r5.token()     // Catch:{ all -> 0x0080 }
            r9 = 16
            if (r8 != r9) goto L_0x0634
            if (r7 == 0) goto L_0x062f
            r17.popContext()     // Catch:{ all -> 0x0080 }
            goto L_0x04f6
        L_0x062f:
            r1.setContext(r6)     // Catch:{ all -> 0x0080 }
            goto L_0x04f6
        L_0x0634:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0080 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0080 }
            r2.<init>()     // Catch:{ all -> 0x0080 }
            java.lang.String r3 = "syntax error, "
            r2.append(r3)     // Catch:{ all -> 0x0080 }
            java.lang.String r3 = r5.tokenName()     // Catch:{ all -> 0x0080 }
            r2.append(r3)     // Catch:{ all -> 0x0080 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0080 }
            r0.<init>(r2)     // Catch:{ all -> 0x0080 }
            throw r0     // Catch:{ all -> 0x0080 }
        L_0x064f:
            r5.nextToken()     // Catch:{ all -> 0x0080 }
            java.lang.Object r7 = r17.parse()     // Catch:{ all -> 0x0080 }
            r12.put(r15, r7)     // Catch:{ all -> 0x0080 }
            int r7 = r5.token()     // Catch:{ all -> 0x0080 }
            r8 = 13
            if (r7 != r8) goto L_0x0668
            r5.nextToken()     // Catch:{ all -> 0x0080 }
            r1.setContext(r6)
            return r0
        L_0x0668:
            int r7 = r5.token()     // Catch:{ all -> 0x0080 }
            r9 = 16
            if (r7 != r9) goto L_0x0676
        L_0x0670:
            r7 = 13
            r8 = 0
            r9 = 4
            goto L_0x03a0
        L_0x0676:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0080 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0080 }
            r2.<init>()     // Catch:{ all -> 0x0080 }
            java.lang.String r3 = "syntax error, position at "
            r2.append(r3)     // Catch:{ all -> 0x0080 }
            int r3 = r5.pos()     // Catch:{ all -> 0x0080 }
            r2.append(r3)     // Catch:{ all -> 0x0080 }
            r2.append(r11)     // Catch:{ all -> 0x0080 }
            r2.append(r15)     // Catch:{ all -> 0x0080 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0080 }
            r0.<init>(r2)     // Catch:{ all -> 0x0080 }
            throw r0     // Catch:{ all -> 0x0080 }
        L_0x0697:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0080 }
            java.lang.String r2 = "object key level > 512"
            r0.<init>(r2)     // Catch:{ all -> 0x0080 }
            throw r0     // Catch:{ all -> 0x0080 }
        L_0x069f:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0080 }
            r0.<init>(r8)     // Catch:{ all -> 0x0080 }
            throw r0     // Catch:{ all -> 0x0080 }
        L_0x06a5:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0080 }
            r0.<init>(r8)     // Catch:{ all -> 0x0080 }
            throw r0     // Catch:{ all -> 0x0080 }
        L_0x06ab:
            r1.setContext(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.DefaultJSONParser.parseObject(java.util.Map, java.lang.Object):java.lang.Object");
    }

    public void popContext() {
        if (!this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            this.context = this.context.parent;
            int i = this.contextArrayIndex;
            if (i > 0) {
                int i2 = i - 1;
                this.contextArrayIndex = i2;
                this.contextArray[i2] = null;
            }
        }
    }

    public Object resolveReference(String str) {
        if (this.contextArray == null) {
            return null;
        }
        int i = 0;
        while (true) {
            ParseContext[] parseContextArr = this.contextArray;
            if (i >= parseContextArr.length || i >= this.contextArrayIndex) {
                return null;
            }
            ParseContext parseContext = parseContextArr[i];
            if (parseContext.toString().equals(str)) {
                return parseContext.object;
            }
            i++;
        }
        return null;
    }

    public void setConfig(ParserConfig parserConfig) {
        this.config = parserConfig;
    }

    public void setContext(ParseContext parseContext) {
        if (!this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            this.context = parseContext;
        }
    }

    public void setDateFomrat(DateFormat dateFormat2) {
        setDateFormat(dateFormat2);
    }

    public void setDateFormat(String str) {
        this.dateFormatPattern = str;
        this.dateFormat = null;
    }

    public void setFieldTypeResolver(FieldTypeResolver fieldTypeResolver2) {
        this.fieldTypeResolver = fieldTypeResolver2;
    }

    public void setResolveStatus(int i) {
        this.resolveStatus = i;
    }

    public void throwException(int i) {
        throw new JSONException("syntax error, expect " + JSONToken.name(i) + ", actual " + JSONToken.name(this.lexer.token()));
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig) {
        this((Object) str, (JSONLexer) new JSONScanner(str, JSON.DEFAULT_PARSER_FEATURE), parserConfig);
    }

    public Object parse(Object obj) {
        Map map;
        JSONLexer jSONLexer = this.lexer;
        int i = jSONLexer.token();
        if (i == 2) {
            Number integerValue = jSONLexer.integerValue();
            jSONLexer.nextToken();
            return integerValue;
        } else if (i == 3) {
            Number decimalValue = jSONLexer.decimalValue(jSONLexer.isEnabled(Feature.UseBigDecimal));
            jSONLexer.nextToken();
            return decimalValue;
        } else if (i == 4) {
            String stringVal = jSONLexer.stringVal();
            jSONLexer.nextToken(16);
            if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                JSONScanner jSONScanner = new JSONScanner(stringVal);
                try {
                    if (jSONScanner.scanISO8601DateIfMatch()) {
                        return jSONScanner.getCalendar().getTime();
                    }
                    jSONScanner.close();
                } finally {
                    jSONScanner.close();
                }
            }
            return stringVal;
        } else if (i == 12) {
            if (isEnabled(Feature.UseNativeJavaObject)) {
                map = jSONLexer.isEnabled(Feature.OrderedField) ? new HashMap() : new LinkedHashMap();
            } else {
                map = new JSONObject(jSONLexer.isEnabled(Feature.OrderedField));
            }
            return parseObject(map, obj);
        } else if (i == 14) {
            Collection arrayList = isEnabled(Feature.UseNativeJavaObject) ? new ArrayList() : new JSONArray();
            parseArray(arrayList, obj);
            return jSONLexer.isEnabled(Feature.UseObjectArray) ? arrayList.toArray() : arrayList;
        } else if (i != 18) {
            if (i != 26) {
                switch (i) {
                    case 6:
                        jSONLexer.nextToken();
                        return Boolean.TRUE;
                    case 7:
                        jSONLexer.nextToken();
                        return Boolean.FALSE;
                    case 8:
                        jSONLexer.nextToken();
                        return null;
                    case 9:
                        jSONLexer.nextToken(18);
                        if (jSONLexer.token() == 18) {
                            jSONLexer.nextToken(10);
                            accept(10);
                            long longValue = jSONLexer.integerValue().longValue();
                            accept(2);
                            accept(11);
                            return new Date(longValue);
                        }
                        throw new JSONException("syntax error");
                    default:
                        switch (i) {
                            case 20:
                                if (jSONLexer.isBlankInput()) {
                                    return null;
                                }
                                throw new JSONException("unterminated json string, " + jSONLexer.info());
                            case 21:
                                jSONLexer.nextToken();
                                HashSet hashSet = new HashSet();
                                parseArray((Collection) hashSet, obj);
                                return hashSet;
                            case 22:
                                jSONLexer.nextToken();
                                TreeSet treeSet = new TreeSet();
                                parseArray((Collection) treeSet, obj);
                                return treeSet;
                            case 23:
                                jSONLexer.nextToken();
                                return null;
                            default:
                                throw new JSONException("syntax error, " + jSONLexer.info());
                        }
                }
            } else {
                byte[] bytesValue = jSONLexer.bytesValue();
                jSONLexer.nextToken();
                return bytesValue;
            }
        } else if ("NaN".equals(jSONLexer.stringVal())) {
            jSONLexer.nextToken();
            return null;
        } else {
            throw new JSONException("syntax error, " + jSONLexer.info());
        }
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig, int i) {
        this((Object) str, (JSONLexer) new JSONScanner(str, i), parserConfig);
    }

    public void parseArray(Class<?> cls, Collection collection) {
        parseArray((Type) cls, collection);
    }

    public ParseContext setContext(Object obj, Object obj2) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        return setContext(this.context, obj, obj2);
    }

    public void setDateFormat(DateFormat dateFormat2) {
        this.dateFormat = dateFormat2;
    }

    public DefaultJSONParser(char[] cArr, int i, ParserConfig parserConfig, int i2) {
        this((Object) cArr, (JSONLexer) new JSONScanner(cArr, i, i2), parserConfig);
    }

    public void parseArray(Type type, Collection collection) {
        parseArray(type, collection, (Object) null);
    }

    public DefaultJSONParser(JSONLexer jSONLexer) {
        this(jSONLexer, ParserConfig.getGlobalInstance());
    }

    public void parseArray(Type type, Collection collection, Object obj) {
        ObjectDeserializer objectDeserializer;
        int i = this.lexer.token();
        if (i == 21 || i == 22) {
            this.lexer.nextToken();
            i = this.lexer.token();
        }
        if (i == 14) {
            Class<String> cls = String.class;
            if (Integer.TYPE == type) {
                objectDeserializer = IntegerCodec.instance;
                this.lexer.nextToken(2);
            } else if (cls == type) {
                objectDeserializer = StringCodec.instance;
                this.lexer.nextToken(4);
            } else {
                objectDeserializer = this.config.getDeserializer(type);
                this.lexer.nextToken(objectDeserializer.getFastMatchToken());
            }
            ParseContext parseContext = this.context;
            setContext(collection, obj);
            int i2 = 0;
            while (true) {
                try {
                    if (this.lexer.isEnabled(Feature.AllowArbitraryCommas)) {
                        while (this.lexer.token() == 16) {
                            this.lexer.nextToken();
                        }
                    }
                    if (this.lexer.token() == 15) {
                        setContext(parseContext);
                        this.lexer.nextToken(16);
                        return;
                    }
                    Object obj2 = null;
                    if (Integer.TYPE == type) {
                        collection.add(IntegerCodec.instance.deserialze(this, (Type) null, (Object) null));
                    } else if (cls == type) {
                        if (this.lexer.token() == 4) {
                            obj2 = this.lexer.stringVal();
                            this.lexer.nextToken(16);
                        } else {
                            Object parse = parse();
                            if (parse != null) {
                                obj2 = parse.toString();
                            }
                        }
                        collection.add(obj2);
                    } else {
                        if (this.lexer.token() == 8) {
                            this.lexer.nextToken();
                        } else {
                            obj2 = objectDeserializer.deserialze(this, type, Integer.valueOf(i2));
                        }
                        collection.add(obj2);
                        checkListResolve(collection);
                    }
                    if (this.lexer.token() == 16) {
                        this.lexer.nextToken(objectDeserializer.getFastMatchToken());
                    }
                    i2++;
                } catch (Throwable th) {
                    setContext(parseContext);
                    throw th;
                }
            }
        } else {
            throw new JSONException("field " + obj + " expect '[', but " + JSONToken.name(i) + ", " + this.lexer.info());
        }
    }

    public ParseContext setContext(ParseContext parseContext, Object obj, Object obj2) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        ParseContext parseContext2 = new ParseContext(parseContext, obj, obj2);
        this.context = parseContext2;
        addContext(parseContext2);
        return this.context;
    }

    public DefaultJSONParser(JSONLexer jSONLexer, ParserConfig parserConfig) {
        this((Object) null, jSONLexer, parserConfig);
    }

    public final void accept(int i, int i2) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == i) {
            jSONLexer.nextToken(i2);
        } else {
            throwException(i);
        }
    }

    public DefaultJSONParser(Object obj, JSONLexer jSONLexer, ParserConfig parserConfig) {
        this.dateFormatPattern = JSON.DEFFAULT_DATE_FORMAT;
        this.contextArrayIndex = 0;
        this.resolveStatus = 0;
        this.extraTypeProviders = null;
        this.extraProcessors = null;
        this.fieldTypeResolver = null;
        this.objectKeyLevel = 0;
        this.autoTypeAccept = null;
        this.lexer = jSONLexer;
        this.input = obj;
        this.config = parserConfig;
        this.symbolTable = parserConfig.symbolTable;
        char current = jSONLexer.getCurrent();
        if (current == '{') {
            jSONLexer.next();
            ((JSONLexerBase) jSONLexer).token = 12;
        } else if (current == '[') {
            jSONLexer.next();
            ((JSONLexerBase) jSONLexer).token = 14;
        } else {
            jSONLexer.nextToken();
        }
    }

    public Object[] parseArray(Type[] typeArr) {
        Object obj;
        Class<?> cls;
        boolean z;
        Class<char[]> cls2;
        Type[] typeArr2 = typeArr;
        int i = 8;
        if (this.lexer.token() == 8) {
            this.lexer.nextToken(16);
            return null;
        }
        int i2 = 14;
        if (this.lexer.token() == 14) {
            Object[] objArr = new Object[typeArr2.length];
            if (typeArr2.length == 0) {
                this.lexer.nextToken(15);
                if (this.lexer.token() == 15) {
                    this.lexer.nextToken(16);
                    return new Object[0];
                }
                throw new JSONException("syntax error");
            }
            this.lexer.nextToken(2);
            int i3 = 0;
            while (i3 < typeArr2.length) {
                if (this.lexer.token() == i) {
                    this.lexer.nextToken(16);
                    obj = null;
                } else {
                    Type type = typeArr2[i3];
                    if (type == Integer.TYPE || type == Integer.class) {
                        if (this.lexer.token() == 2) {
                            obj = Integer.valueOf(this.lexer.intValue());
                            this.lexer.nextToken(16);
                        } else {
                            obj = TypeUtils.cast(parse(), type, this.config);
                        }
                    } else if (type != String.class) {
                        if (i3 != typeArr2.length - 1 || !(type instanceof Class) || (((cls2 = (Class) type) == byte[].class || cls2 == char[].class) && this.lexer.token() == 4)) {
                            cls = null;
                            z = false;
                        } else {
                            z = cls2.isArray();
                            cls = cls2.getComponentType();
                        }
                        if (!z || this.lexer.token() == i2) {
                            obj = this.config.getDeserializer(type).deserialze(this, type, Integer.valueOf(i3));
                        } else {
                            ArrayList arrayList = new ArrayList();
                            ObjectDeserializer deserializer = this.config.getDeserializer((Type) cls);
                            int fastMatchToken = deserializer.getFastMatchToken();
                            if (this.lexer.token() != 15) {
                                while (true) {
                                    arrayList.add(deserializer.deserialze(this, type, (Object) null));
                                    if (this.lexer.token() != 16) {
                                        break;
                                    }
                                    this.lexer.nextToken(fastMatchToken);
                                }
                                if (this.lexer.token() != 15) {
                                    throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
                                }
                            }
                            obj = TypeUtils.cast((Object) arrayList, type, this.config);
                        }
                    } else if (this.lexer.token() == 4) {
                        obj = this.lexer.stringVal();
                        this.lexer.nextToken(16);
                    } else {
                        obj = TypeUtils.cast(parse(), type, this.config);
                    }
                }
                objArr[i3] = obj;
                if (this.lexer.token() == 15) {
                    break;
                } else if (this.lexer.token() == 16) {
                    if (i3 == typeArr2.length - 1) {
                        this.lexer.nextToken(15);
                    } else {
                        this.lexer.nextToken(2);
                    }
                    i3++;
                    i = 8;
                    i2 = 14;
                } else {
                    throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
                }
            }
            if (this.lexer.token() == 15) {
                this.lexer.nextToken(16);
                return objArr;
            }
            throw new JSONException("syntax error");
        }
        throw new JSONException("syntax error : " + this.lexer.tokenName());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        r11 = r10.config.getDeserializer((java.lang.reflect.Type) r1);
        r10.lexer.nextToken(16);
        setResolveStatus(2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01da, code lost:
        if (r0 == null) goto L_0x01e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01de, code lost:
        if ((r12 instanceof java.lang.Integer) != false) goto L_0x01e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01e0, code lost:
        popContext();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01e3, code lost:
        r11 = (java.util.Map) r11.deserialze(r10, r1, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01e9, code lost:
        setContext(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01ec, code lost:
        return r11;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object parse(com.alibaba.fastjson.parser.deserializer.PropertyProcessable r11, java.lang.Object r12) {
        /*
            r10 = this;
            com.alibaba.fastjson.parser.JSONLexer r0 = r10.lexer
            int r0 = r0.token()
            r1 = 12
            r2 = 0
            if (r0 == r1) goto L_0x008c
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "syntax error, expect {, actual "
            r11.append(r0)
            com.alibaba.fastjson.parser.JSONLexer r0 = r10.lexer
            java.lang.String r0 = r0.tokenName()
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            boolean r0 = r12 instanceof java.lang.String
            if (r0 == 0) goto L_0x0046
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r11)
            java.lang.String r11 = ", fieldName "
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r11)
            r0.append(r12)
            java.lang.String r11 = r0.toString()
        L_0x0046:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r11)
            java.lang.String r11 = ", "
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r11)
            com.alibaba.fastjson.parser.JSONLexer r11 = r10.lexer
            java.lang.String r11 = r11.info()
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            com.alibaba.fastjson.JSONArray r0 = new com.alibaba.fastjson.JSONArray
            r0.<init>()
            r10.parseArray((java.util.Collection) r0, (java.lang.Object) r12)
            int r12 = r0.size()
            r1 = 1
            if (r12 != r1) goto L_0x0086
            java.lang.Object r12 = r0.get(r2)
            boolean r0 = r12 instanceof com.alibaba.fastjson.JSONObject
            if (r0 == 0) goto L_0x0086
            com.alibaba.fastjson.JSONObject r12 = (com.alibaba.fastjson.JSONObject) r12
            return r12
        L_0x0086:
            com.alibaba.fastjson.JSONException r12 = new com.alibaba.fastjson.JSONException
            r12.<init>(r11)
            throw r12
        L_0x008c:
            com.alibaba.fastjson.parser.ParseContext r0 = r10.context
        L_0x008e:
            com.alibaba.fastjson.parser.JSONLexer r1 = r10.lexer     // Catch:{ all -> 0x00b8 }
            r1.skipWhitespace()     // Catch:{ all -> 0x00b8 }
            com.alibaba.fastjson.parser.JSONLexer r1 = r10.lexer     // Catch:{ all -> 0x00b8 }
            char r1 = r1.getCurrent()     // Catch:{ all -> 0x00b8 }
            com.alibaba.fastjson.parser.JSONLexer r3 = r10.lexer     // Catch:{ all -> 0x00b8 }
            com.alibaba.fastjson.parser.Feature r4 = com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas     // Catch:{ all -> 0x00b8 }
            boolean r3 = r3.isEnabled((com.alibaba.fastjson.parser.Feature) r4)     // Catch:{ all -> 0x00b8 }
            if (r3 == 0) goto L_0x00bb
        L_0x00a3:
            r3 = 44
            if (r1 != r3) goto L_0x00bb
            com.alibaba.fastjson.parser.JSONLexer r1 = r10.lexer     // Catch:{ all -> 0x00b8 }
            r1.next()     // Catch:{ all -> 0x00b8 }
            com.alibaba.fastjson.parser.JSONLexer r1 = r10.lexer     // Catch:{ all -> 0x00b8 }
            r1.skipWhitespace()     // Catch:{ all -> 0x00b8 }
            com.alibaba.fastjson.parser.JSONLexer r1 = r10.lexer     // Catch:{ all -> 0x00b8 }
            char r1 = r1.getCurrent()     // Catch:{ all -> 0x00b8 }
            goto L_0x00a3
        L_0x00b8:
            r11 = move-exception
            goto L_0x0263
        L_0x00bb:
            java.lang.String r3 = "expect ':' at "
            r4 = 58
            r5 = 34
            r6 = 16
            if (r1 != r5) goto L_0x00f7
            com.alibaba.fastjson.parser.JSONLexer r1 = r10.lexer     // Catch:{ all -> 0x00b8 }
            com.alibaba.fastjson.parser.SymbolTable r7 = r10.symbolTable     // Catch:{ all -> 0x00b8 }
            java.lang.String r1 = r1.scanSymbol(r7, r5)     // Catch:{ all -> 0x00b8 }
            com.alibaba.fastjson.parser.JSONLexer r7 = r10.lexer     // Catch:{ all -> 0x00b8 }
            r7.skipWhitespace()     // Catch:{ all -> 0x00b8 }
            com.alibaba.fastjson.parser.JSONLexer r7 = r10.lexer     // Catch:{ all -> 0x00b8 }
            char r7 = r7.getCurrent()     // Catch:{ all -> 0x00b8 }
            if (r7 != r4) goto L_0x00dc
            goto L_0x0174
        L_0x00dc:
            com.alibaba.fastjson.JSONException r11 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x00b8 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b8 }
            r12.<init>()     // Catch:{ all -> 0x00b8 }
            r12.append(r3)     // Catch:{ all -> 0x00b8 }
            com.alibaba.fastjson.parser.JSONLexer r1 = r10.lexer     // Catch:{ all -> 0x00b8 }
            int r1 = r1.pos()     // Catch:{ all -> 0x00b8 }
            r12.append(r1)     // Catch:{ all -> 0x00b8 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x00b8 }
            r11.<init>(r12)     // Catch:{ all -> 0x00b8 }
            throw r11     // Catch:{ all -> 0x00b8 }
        L_0x00f7:
            r7 = 125(0x7d, float:1.75E-43)
            if (r1 != r7) goto L_0x010e
            com.alibaba.fastjson.parser.JSONLexer r12 = r10.lexer     // Catch:{ all -> 0x00b8 }
            r12.next()     // Catch:{ all -> 0x00b8 }
            com.alibaba.fastjson.parser.JSONLexer r12 = r10.lexer     // Catch:{ all -> 0x00b8 }
            r12.resetStringPosition()     // Catch:{ all -> 0x00b8 }
            com.alibaba.fastjson.parser.JSONLexer r12 = r10.lexer     // Catch:{ all -> 0x00b8 }
            r12.nextToken(r6)     // Catch:{ all -> 0x00b8 }
            r10.setContext(r0)
            return r11
        L_0x010e:
            java.lang.String r7 = "syntax error"
            r8 = 39
            if (r1 != r8) goto L_0x0155
            com.alibaba.fastjson.parser.JSONLexer r1 = r10.lexer     // Catch:{ all -> 0x00b8 }
            com.alibaba.fastjson.parser.Feature r9 = com.alibaba.fastjson.parser.Feature.AllowSingleQuotes     // Catch:{ all -> 0x00b8 }
            boolean r1 = r1.isEnabled((com.alibaba.fastjson.parser.Feature) r9)     // Catch:{ all -> 0x00b8 }
            if (r1 == 0) goto L_0x014f
            com.alibaba.fastjson.parser.JSONLexer r1 = r10.lexer     // Catch:{ all -> 0x00b8 }
            com.alibaba.fastjson.parser.SymbolTable r7 = r10.symbolTable     // Catch:{ all -> 0x00b8 }
            java.lang.String r1 = r1.scanSymbol(r7, r8)     // Catch:{ all -> 0x00b8 }
            com.alibaba.fastjson.parser.JSONLexer r7 = r10.lexer     // Catch:{ all -> 0x00b8 }
            r7.skipWhitespace()     // Catch:{ all -> 0x00b8 }
            com.alibaba.fastjson.parser.JSONLexer r7 = r10.lexer     // Catch:{ all -> 0x00b8 }
            char r7 = r7.getCurrent()     // Catch:{ all -> 0x00b8 }
            if (r7 != r4) goto L_0x0134
            goto L_0x0174
        L_0x0134:
            com.alibaba.fastjson.JSONException r11 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x00b8 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b8 }
            r12.<init>()     // Catch:{ all -> 0x00b8 }
            r12.append(r3)     // Catch:{ all -> 0x00b8 }
            com.alibaba.fastjson.parser.JSONLexer r1 = r10.lexer     // Catch:{ all -> 0x00b8 }
            int r1 = r1.pos()     // Catch:{ all -> 0x00b8 }
            r12.append(r1)     // Catch:{ all -> 0x00b8 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x00b8 }
            r11.<init>(r12)     // Catch:{ all -> 0x00b8 }
            throw r11     // Catch:{ all -> 0x00b8 }
        L_0x014f:
            com.alibaba.fastjson.JSONException r11 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x00b8 }
            r11.<init>(r7)     // Catch:{ all -> 0x00b8 }
            throw r11     // Catch:{ all -> 0x00b8 }
        L_0x0155:
            com.alibaba.fastjson.parser.JSONLexer r1 = r10.lexer     // Catch:{ all -> 0x00b8 }
            com.alibaba.fastjson.parser.Feature r8 = com.alibaba.fastjson.parser.Feature.AllowUnQuotedFieldNames     // Catch:{ all -> 0x00b8 }
            boolean r1 = r1.isEnabled((com.alibaba.fastjson.parser.Feature) r8)     // Catch:{ all -> 0x00b8 }
            if (r1 == 0) goto L_0x025d
            com.alibaba.fastjson.parser.JSONLexer r1 = r10.lexer     // Catch:{ all -> 0x00b8 }
            com.alibaba.fastjson.parser.SymbolTable r7 = r10.symbolTable     // Catch:{ all -> 0x00b8 }
            java.lang.String r1 = r1.scanSymbolUnQuoted(r7)     // Catch:{ all -> 0x00b8 }
            com.alibaba.fastjson.parser.JSONLexer r7 = r10.lexer     // Catch:{ all -> 0x00b8 }
            r7.skipWhitespace()     // Catch:{ all -> 0x00b8 }
            com.alibaba.fastjson.parser.JSONLexer r7 = r10.lexer     // Catch:{ all -> 0x00b8 }
            char r7 = r7.getCurrent()     // Catch:{ all -> 0x00b8 }
            if (r7 != r4) goto L_0x023a
        L_0x0174:
            com.alibaba.fastjson.parser.JSONLexer r3 = r10.lexer     // Catch:{ all -> 0x00b8 }
            r3.next()     // Catch:{ all -> 0x00b8 }
            com.alibaba.fastjson.parser.JSONLexer r3 = r10.lexer     // Catch:{ all -> 0x00b8 }
            r3.skipWhitespace()     // Catch:{ all -> 0x00b8 }
            com.alibaba.fastjson.parser.JSONLexer r3 = r10.lexer     // Catch:{ all -> 0x00b8 }
            r3.getCurrent()     // Catch:{ all -> 0x00b8 }
            com.alibaba.fastjson.parser.JSONLexer r3 = r10.lexer     // Catch:{ all -> 0x00b8 }
            r3.resetStringPosition()     // Catch:{ all -> 0x00b8 }
            java.lang.String r3 = com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY     // Catch:{ all -> 0x00b8 }
            r4 = 13
            r7 = 0
            if (r1 != r3) goto L_0x01ed
            com.alibaba.fastjson.parser.JSONLexer r3 = r10.lexer     // Catch:{ all -> 0x00b8 }
            com.alibaba.fastjson.parser.Feature r8 = com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect     // Catch:{ all -> 0x00b8 }
            boolean r3 = r3.isEnabled((com.alibaba.fastjson.parser.Feature) r8)     // Catch:{ all -> 0x00b8 }
            if (r3 != 0) goto L_0x01ed
            com.alibaba.fastjson.parser.JSONLexer r1 = r10.lexer     // Catch:{ all -> 0x00b8 }
            com.alibaba.fastjson.parser.SymbolTable r3 = r10.symbolTable     // Catch:{ all -> 0x00b8 }
            java.lang.String r1 = r1.scanSymbol(r3, r5)     // Catch:{ all -> 0x00b8 }
            com.alibaba.fastjson.parser.ParserConfig r3 = r10.config     // Catch:{ all -> 0x00b8 }
            com.alibaba.fastjson.parser.JSONLexer r5 = r10.lexer     // Catch:{ all -> 0x00b8 }
            int r5 = r5.getFeatures()     // Catch:{ all -> 0x00b8 }
            java.lang.Class r1 = r3.checkAutoType(r1, r7, r5)     // Catch:{ all -> 0x00b8 }
            java.lang.Class<java.util.Map> r3 = java.util.Map.class
            boolean r3 = r3.isAssignableFrom(r1)     // Catch:{ all -> 0x00b8 }
            if (r3 == 0) goto L_0x01cb
            com.alibaba.fastjson.parser.JSONLexer r1 = r10.lexer     // Catch:{ all -> 0x00b8 }
            r1.nextToken(r6)     // Catch:{ all -> 0x00b8 }
            com.alibaba.fastjson.parser.JSONLexer r1 = r10.lexer     // Catch:{ all -> 0x00b8 }
            int r1 = r1.token()     // Catch:{ all -> 0x00b8 }
            if (r1 != r4) goto L_0x0232
            com.alibaba.fastjson.parser.JSONLexer r12 = r10.lexer     // Catch:{ all -> 0x00b8 }
            r12.nextToken(r6)     // Catch:{ all -> 0x00b8 }
            r10.setContext(r0)
            return r11
        L_0x01cb:
            com.alibaba.fastjson.parser.ParserConfig r11 = r10.config     // Catch:{ all -> 0x00b8 }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r11 = r11.getDeserializer((java.lang.reflect.Type) r1)     // Catch:{ all -> 0x00b8 }
            com.alibaba.fastjson.parser.JSONLexer r2 = r10.lexer     // Catch:{ all -> 0x00b8 }
            r2.nextToken(r6)     // Catch:{ all -> 0x00b8 }
            r2 = 2
            r10.setResolveStatus(r2)     // Catch:{ all -> 0x00b8 }
            if (r0 == 0) goto L_0x01e3
            boolean r2 = r12 instanceof java.lang.Integer     // Catch:{ all -> 0x00b8 }
            if (r2 != 0) goto L_0x01e3
            r10.popContext()     // Catch:{ all -> 0x00b8 }
        L_0x01e3:
            java.lang.Object r11 = r11.deserialze(r10, r1, r12)     // Catch:{ all -> 0x00b8 }
            java.util.Map r11 = (java.util.Map) r11     // Catch:{ all -> 0x00b8 }
            r10.setContext(r0)
            return r11
        L_0x01ed:
            com.alibaba.fastjson.parser.JSONLexer r3 = r10.lexer     // Catch:{ all -> 0x00b8 }
            r3.nextToken()     // Catch:{ all -> 0x00b8 }
            if (r2 == 0) goto L_0x01f7
            r10.setContext(r0)     // Catch:{ all -> 0x00b8 }
        L_0x01f7:
            java.lang.reflect.Type r3 = r11.getType(r1)     // Catch:{ all -> 0x00b8 }
            com.alibaba.fastjson.parser.JSONLexer r5 = r10.lexer     // Catch:{ all -> 0x00b8 }
            int r5 = r5.token()     // Catch:{ all -> 0x00b8 }
            r6 = 8
            if (r5 != r6) goto L_0x020b
            com.alibaba.fastjson.parser.JSONLexer r3 = r10.lexer     // Catch:{ all -> 0x00b8 }
            r3.nextToken()     // Catch:{ all -> 0x00b8 }
            goto L_0x020f
        L_0x020b:
            java.lang.Object r7 = r10.parseObject((java.lang.reflect.Type) r3, (java.lang.Object) r1)     // Catch:{ all -> 0x00b8 }
        L_0x020f:
            r11.apply(r1, r7)     // Catch:{ all -> 0x00b8 }
            r10.setContext(r0, r7, r1)     // Catch:{ all -> 0x00b8 }
            r10.setContext(r0)     // Catch:{ all -> 0x00b8 }
            com.alibaba.fastjson.parser.JSONLexer r1 = r10.lexer     // Catch:{ all -> 0x00b8 }
            int r1 = r1.token()     // Catch:{ all -> 0x00b8 }
            r3 = 20
            if (r1 == r3) goto L_0x0236
            r3 = 15
            if (r1 != r3) goto L_0x0227
            goto L_0x0236
        L_0x0227:
            if (r1 != r4) goto L_0x0232
            com.alibaba.fastjson.parser.JSONLexer r12 = r10.lexer     // Catch:{ all -> 0x00b8 }
            r12.nextToken()     // Catch:{ all -> 0x00b8 }
            r10.setContext(r0)
            return r11
        L_0x0232:
            int r2 = r2 + 1
            goto L_0x008e
        L_0x0236:
            r10.setContext(r0)
            return r11
        L_0x023a:
            com.alibaba.fastjson.JSONException r11 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x00b8 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b8 }
            r12.<init>()     // Catch:{ all -> 0x00b8 }
            r12.append(r3)     // Catch:{ all -> 0x00b8 }
            com.alibaba.fastjson.parser.JSONLexer r1 = r10.lexer     // Catch:{ all -> 0x00b8 }
            int r1 = r1.pos()     // Catch:{ all -> 0x00b8 }
            r12.append(r1)     // Catch:{ all -> 0x00b8 }
            java.lang.String r1 = ", actual "
            r12.append(r1)     // Catch:{ all -> 0x00b8 }
            r12.append(r7)     // Catch:{ all -> 0x00b8 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x00b8 }
            r11.<init>(r12)     // Catch:{ all -> 0x00b8 }
            throw r11     // Catch:{ all -> 0x00b8 }
        L_0x025d:
            com.alibaba.fastjson.JSONException r11 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x00b8 }
            r11.<init>(r7)     // Catch:{ all -> 0x00b8 }
            throw r11     // Catch:{ all -> 0x00b8 }
        L_0x0263:
            r10.setContext(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.DefaultJSONParser.parse(com.alibaba.fastjson.parser.deserializer.PropertyProcessable, java.lang.Object):java.lang.Object");
    }

    public final void parseArray(Collection collection) {
        parseArray(collection, (Object) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v18, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v20, resolved type: com.alibaba.fastjson.JSONArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v21, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void parseArray(java.util.Collection r10, java.lang.Object r11) {
        /*
            r9 = this;
            com.alibaba.fastjson.parser.JSONLexer r0 = r9.lexer
            int r1 = r0.token()
            r2 = 21
            if (r1 == r2) goto L_0x0012
            int r1 = r0.token()
            r2 = 22
            if (r1 != r2) goto L_0x0015
        L_0x0012:
            r0.nextToken()
        L_0x0015:
            int r1 = r0.token()
            r2 = 14
            if (r1 != r2) goto L_0x0139
            r1 = 4
            r0.nextToken(r1)
            com.alibaba.fastjson.parser.ParseContext r3 = r9.context
            if (r3 == 0) goto L_0x0034
            int r4 = r3.level
            r5 = 512(0x200, float:7.175E-43)
            if (r4 > r5) goto L_0x002c
            goto L_0x0034
        L_0x002c:
            com.alibaba.fastjson.JSONException r10 = new com.alibaba.fastjson.JSONException
            java.lang.String r11 = "array level > 512"
            r10.<init>(r11)
            throw r10
        L_0x0034:
            r9.setContext(r10, r11)
            r11 = 0
            r4 = 0
        L_0x0039:
            com.alibaba.fastjson.parser.Feature r5 = com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas     // Catch:{ ClassCastException -> 0x0050 }
            boolean r5 = r0.isEnabled((com.alibaba.fastjson.parser.Feature) r5)     // Catch:{ ClassCastException -> 0x0050 }
            r6 = 16
            if (r5 == 0) goto L_0x0053
        L_0x0043:
            int r5 = r0.token()     // Catch:{ ClassCastException -> 0x0050 }
            if (r5 != r6) goto L_0x0053
            r0.nextToken()     // Catch:{ ClassCastException -> 0x0050 }
            goto L_0x0043
        L_0x004d:
            r10 = move-exception
            goto L_0x0135
        L_0x0050:
            r10 = move-exception
            goto L_0x012d
        L_0x0053:
            int r5 = r0.token()     // Catch:{ ClassCastException -> 0x0050 }
            r7 = 2
            if (r5 == r7) goto L_0x0113
            r7 = 3
            if (r5 == r7) goto L_0x00fb
            if (r5 == r1) goto L_0x00d4
            r7 = 6
            if (r5 == r7) goto L_0x00ce
            r7 = 7
            if (r5 == r7) goto L_0x00c8
            r7 = 8
            r8 = 0
            if (r5 == r7) goto L_0x00c4
            r7 = 12
            if (r5 == r7) goto L_0x00b0
            r7 = 20
            if (r5 == r7) goto L_0x00a8
            r7 = 23
            if (r5 == r7) goto L_0x00a3
            if (r5 == r2) goto L_0x0089
            r7 = 15
            if (r5 == r7) goto L_0x0082
            java.lang.Object r8 = r9.parse()     // Catch:{ ClassCastException -> 0x0050 }
            goto L_0x011a
        L_0x0082:
            r0.nextToken(r6)     // Catch:{ ClassCastException -> 0x0050 }
            r9.setContext(r3)
            return
        L_0x0089:
            com.alibaba.fastjson.JSONArray r8 = new com.alibaba.fastjson.JSONArray     // Catch:{ ClassCastException -> 0x0050 }
            r8.<init>()     // Catch:{ ClassCastException -> 0x0050 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)     // Catch:{ ClassCastException -> 0x0050 }
            r9.parseArray((java.util.Collection) r8, (java.lang.Object) r5)     // Catch:{ ClassCastException -> 0x0050 }
            com.alibaba.fastjson.parser.Feature r5 = com.alibaba.fastjson.parser.Feature.UseObjectArray     // Catch:{ ClassCastException -> 0x0050 }
            boolean r5 = r0.isEnabled((com.alibaba.fastjson.parser.Feature) r5)     // Catch:{ ClassCastException -> 0x0050 }
            if (r5 == 0) goto L_0x011a
            java.lang.Object[] r8 = r8.toArray()     // Catch:{ ClassCastException -> 0x0050 }
            goto L_0x011a
        L_0x00a3:
            r0.nextToken(r1)     // Catch:{ ClassCastException -> 0x0050 }
            goto L_0x011a
        L_0x00a8:
            com.alibaba.fastjson.JSONException r10 = new com.alibaba.fastjson.JSONException     // Catch:{ ClassCastException -> 0x0050 }
            java.lang.String r11 = "unclosed jsonArray"
            r10.<init>(r11)     // Catch:{ ClassCastException -> 0x0050 }
            throw r10     // Catch:{ ClassCastException -> 0x0050 }
        L_0x00b0:
            com.alibaba.fastjson.JSONObject r5 = new com.alibaba.fastjson.JSONObject     // Catch:{ ClassCastException -> 0x0050 }
            com.alibaba.fastjson.parser.Feature r7 = com.alibaba.fastjson.parser.Feature.OrderedField     // Catch:{ ClassCastException -> 0x0050 }
            boolean r7 = r0.isEnabled((com.alibaba.fastjson.parser.Feature) r7)     // Catch:{ ClassCastException -> 0x0050 }
            r5.<init>((boolean) r7)     // Catch:{ ClassCastException -> 0x0050 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)     // Catch:{ ClassCastException -> 0x0050 }
            java.lang.Object r8 = r9.parseObject((java.util.Map) r5, (java.lang.Object) r7)     // Catch:{ ClassCastException -> 0x0050 }
            goto L_0x011a
        L_0x00c4:
            r0.nextToken(r1)     // Catch:{ ClassCastException -> 0x0050 }
            goto L_0x011a
        L_0x00c8:
            java.lang.Boolean r8 = java.lang.Boolean.FALSE     // Catch:{ ClassCastException -> 0x0050 }
            r0.nextToken(r6)     // Catch:{ ClassCastException -> 0x0050 }
            goto L_0x011a
        L_0x00ce:
            java.lang.Boolean r8 = java.lang.Boolean.TRUE     // Catch:{ ClassCastException -> 0x0050 }
            r0.nextToken(r6)     // Catch:{ ClassCastException -> 0x0050 }
            goto L_0x011a
        L_0x00d4:
            java.lang.String r8 = r0.stringVal()     // Catch:{ ClassCastException -> 0x0050 }
            r0.nextToken(r6)     // Catch:{ ClassCastException -> 0x0050 }
            com.alibaba.fastjson.parser.Feature r5 = com.alibaba.fastjson.parser.Feature.AllowISO8601DateFormat     // Catch:{ ClassCastException -> 0x0050 }
            boolean r5 = r0.isEnabled((com.alibaba.fastjson.parser.Feature) r5)     // Catch:{ ClassCastException -> 0x0050 }
            if (r5 == 0) goto L_0x011a
            com.alibaba.fastjson.parser.JSONScanner r5 = new com.alibaba.fastjson.parser.JSONScanner     // Catch:{ ClassCastException -> 0x0050 }
            r5.<init>(r8)     // Catch:{ ClassCastException -> 0x0050 }
            boolean r7 = r5.scanISO8601DateIfMatch()     // Catch:{ ClassCastException -> 0x0050 }
            if (r7 == 0) goto L_0x00f7
            java.util.Calendar r7 = r5.getCalendar()     // Catch:{ ClassCastException -> 0x0050 }
            java.util.Date r7 = r7.getTime()     // Catch:{ ClassCastException -> 0x0050 }
            r8 = r7
        L_0x00f7:
            r5.close()     // Catch:{ ClassCastException -> 0x0050 }
            goto L_0x011a
        L_0x00fb:
            com.alibaba.fastjson.parser.Feature r5 = com.alibaba.fastjson.parser.Feature.UseBigDecimal     // Catch:{ ClassCastException -> 0x0050 }
            boolean r5 = r0.isEnabled((com.alibaba.fastjson.parser.Feature) r5)     // Catch:{ ClassCastException -> 0x0050 }
            if (r5 == 0) goto L_0x010a
            r5 = 1
            java.lang.Number r5 = r0.decimalValue(r5)     // Catch:{ ClassCastException -> 0x0050 }
        L_0x0108:
            r8 = r5
            goto L_0x010f
        L_0x010a:
            java.lang.Number r5 = r0.decimalValue(r11)     // Catch:{ ClassCastException -> 0x0050 }
            goto L_0x0108
        L_0x010f:
            r0.nextToken(r6)     // Catch:{ ClassCastException -> 0x0050 }
            goto L_0x011a
        L_0x0113:
            java.lang.Number r8 = r0.integerValue()     // Catch:{ ClassCastException -> 0x0050 }
            r0.nextToken(r6)     // Catch:{ ClassCastException -> 0x0050 }
        L_0x011a:
            r10.add(r8)     // Catch:{ ClassCastException -> 0x0050 }
            r9.checkListResolve(r10)     // Catch:{ ClassCastException -> 0x0050 }
            int r5 = r0.token()     // Catch:{ ClassCastException -> 0x0050 }
            if (r5 != r6) goto L_0x0129
            r0.nextToken(r1)     // Catch:{ ClassCastException -> 0x0050 }
        L_0x0129:
            int r4 = r4 + 1
            goto L_0x0039
        L_0x012d:
            com.alibaba.fastjson.JSONException r11 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x004d }
            java.lang.String r0 = "unkown error"
            r11.<init>(r0, r10)     // Catch:{ all -> 0x004d }
            throw r11     // Catch:{ all -> 0x004d }
        L_0x0135:
            r9.setContext(r3)
            throw r10
        L_0x0139:
            com.alibaba.fastjson.JSONException r10 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "syntax error, expect [, actual "
            r1.append(r2)
            int r2 = r0.token()
            java.lang.String r2 = com.alibaba.fastjson.parser.JSONToken.name(r2)
            r1.append(r2)
            java.lang.String r2 = ", pos "
            r1.append(r2)
            int r0 = r0.pos()
            r1.append(r0)
            java.lang.String r0 = ", fieldName "
            r1.append(r0)
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.DefaultJSONParser.parseArray(java.util.Collection, java.lang.Object):void");
    }

    public <T> T parseObject(Class<T> cls) {
        return parseObject((Type) cls, (Object) null);
    }

    public <T> T parseObject(Type type) {
        return parseObject(type, (Object) null);
    }

    public <T> T parseObject(Type type, Object obj) {
        int i = this.lexer.token();
        if (i == 8) {
            this.lexer.nextToken();
            return TypeUtils.optionalEmpty(type);
        }
        if (i == 4) {
            if (type == byte[].class) {
                Object bytesValue = this.lexer.bytesValue();
                this.lexer.nextToken();
                return bytesValue;
            } else if (type == char[].class) {
                String stringVal = this.lexer.stringVal();
                this.lexer.nextToken();
                return stringVal.toCharArray();
            }
        }
        ObjectDeserializer deserializer = this.config.getDeserializer(type);
        try {
            if (deserializer.getClass() != JavaBeanDeserializer.class) {
                return deserializer.deserialze(this, type, obj);
            }
            if (this.lexer.token() != 12) {
                if (this.lexer.token() != 14) {
                    throw new JSONException("syntax error,expect start with { or [,but actually start with " + this.lexer.tokenName());
                }
            }
            return ((JavaBeanDeserializer) deserializer).deserialze(this, type, obj, 0);
        } catch (JSONException e) {
            throw e;
        } catch (Throwable th) {
            throw new JSONException(th.getMessage(), th);
        }
    }

    public void parseObject(Object obj) {
        Object obj2;
        Class<?> cls = obj.getClass();
        ObjectDeserializer deserializer = this.config.getDeserializer((Type) cls);
        JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
        if (this.lexer.token() == 12 || this.lexer.token() == 16) {
            while (true) {
                String scanSymbol = this.lexer.scanSymbol(this.symbolTable);
                if (scanSymbol == null) {
                    if (this.lexer.token() == 13) {
                        this.lexer.nextToken(16);
                        return;
                    } else if (this.lexer.token() == 16 && this.lexer.isEnabled(Feature.AllowArbitraryCommas)) {
                    }
                }
                FieldDeserializer fieldDeserializer = javaBeanDeserializer != null ? javaBeanDeserializer.getFieldDeserializer(scanSymbol) : null;
                if (fieldDeserializer != null) {
                    FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                    Class<?> cls2 = fieldInfo.fieldClass;
                    Type type = fieldInfo.fieldType;
                    if (cls2 == Integer.TYPE) {
                        this.lexer.nextTokenWithColon(2);
                        obj2 = IntegerCodec.instance.deserialze(this, type, (Object) null);
                    } else if (cls2 == String.class) {
                        this.lexer.nextTokenWithColon(4);
                        obj2 = StringCodec.deserialze(this);
                    } else if (cls2 == Long.TYPE) {
                        this.lexer.nextTokenWithColon(2);
                        obj2 = LongCodec.instance.deserialze(this, type, (Object) null);
                    } else {
                        ObjectDeserializer deserializer2 = this.config.getDeserializer(cls2, type);
                        this.lexer.nextTokenWithColon(deserializer2.getFastMatchToken());
                        obj2 = deserializer2.deserialze(this, type, (Object) null);
                    }
                    fieldDeserializer.setValue(obj, obj2);
                    if (this.lexer.token() != 16 && this.lexer.token() == 13) {
                        this.lexer.nextToken(16);
                        return;
                    }
                } else if (this.lexer.isEnabled(Feature.IgnoreNotMatch)) {
                    this.lexer.nextTokenWithColon();
                    parse();
                    if (this.lexer.token() == 13) {
                        this.lexer.nextToken();
                        return;
                    }
                } else {
                    throw new JSONException("setter not found, class " + cls.getName() + ", property " + scanSymbol);
                }
            }
        } else {
            throw new JSONException("syntax error, expect {, actual " + this.lexer.tokenName());
        }
    }

    public Object parseObject(Map map) {
        return parseObject(map, (Object) null);
    }

    public JSONObject parseObject() {
        Object parseObject = parseObject((Map) new JSONObject(this.lexer.isEnabled(Feature.OrderedField)));
        if (parseObject instanceof JSONObject) {
            return (JSONObject) parseObject;
        }
        if (parseObject == null) {
            return null;
        }
        return new JSONObject((Map<String, Object>) (Map) parseObject);
    }
}
