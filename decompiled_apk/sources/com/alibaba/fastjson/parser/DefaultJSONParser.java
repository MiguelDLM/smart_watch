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
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
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
        hashSet.addAll(Arrays.asList(Boolean.TYPE, Byte.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Boolean.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, BigInteger.class, BigDecimal.class, String.class));
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
            ParseContext[] parseContextArr2 = new ParseContext[(parseContextArr.length * 3) / 2];
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
        if (jSONLexer.token() == 4) {
            if (str.equals(jSONLexer.stringVal())) {
                jSONLexer.nextToken();
                if (jSONLexer.token() == 16) {
                    jSONLexer.nextToken();
                    return;
                }
                return;
            }
            throw new JSONException("type not match error");
        }
        throw new JSONException("type not match error");
    }

    public void addResolveTask(ResolveTask resolveTask) {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        this.resolveTaskList.add(resolveTask);
    }

    public void checkListResolve(Collection collection) {
        if (this.resolveStatus == 1) {
            if (collection instanceof List) {
                int size = collection.size() - 1;
                ResolveTask lastResolveTask = getLastResolveTask();
                lastResolveTask.fieldDeserializer = new ResolveFieldDeserializer(this, (List) collection, size);
                lastResolveTask.ownerContext = this.context;
                setResolveStatus(0);
                return;
            }
            ResolveTask lastResolveTask2 = getLastResolveTask();
            lastResolveTask2.fieldDeserializer = new ResolveFieldDeserializer(collection);
            lastResolveTask2.ownerContext = this.context;
            setResolveStatus(0);
        }
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

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        JSONLexer jSONLexer = this.lexer;
        try {
            if (jSONLexer.isEnabled(Feature.AutoCloseSource) && jSONLexer.token() != 20) {
                throw new JSONException("not close json text, token : " + JSONToken.name(jSONLexer.token()));
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
        return this.resolveTaskList.get(r0.size() - 1);
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
        if (list == null) {
            return;
        }
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
                        }
                        if (fieldDeserializer.getOwnerClass().isInstance(parseContext.object)) {
                            obj2 = parseContext.object;
                            break;
                        }
                        parseContext = parseContext.parent;
                    }
                }
                fieldDeserializer.setValue(obj2, obj3);
            }
        }
    }

    public boolean isEnabled(Feature feature) {
        return this.lexer.isEnabled(feature);
    }

    public Object parse() {
        return parse(null);
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
                parseArray((Class<?>) type2, (Collection) arrayList);
                return arrayList;
            }
            if (type2 instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type2;
                Type type3 = wildcardType.getUpperBounds()[0];
                if (Object.class.equals(type3)) {
                    if (wildcardType.getLowerBounds().length == 0) {
                        return parse();
                    }
                    throw new JSONException("not support type : " + type);
                }
                ArrayList arrayList2 = new ArrayList();
                parseArray((Class<?>) type3, (Collection) arrayList2);
                return arrayList2;
            }
            if (type2 instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) type2;
                Type[] bounds = typeVariable.getBounds();
                if (bounds.length == 1) {
                    Type type4 = bounds[0];
                    if (type4 instanceof Class) {
                        ArrayList arrayList3 = new ArrayList();
                        parseArray((Class<?>) type4, (Collection) arrayList3);
                        return arrayList3;
                    }
                } else {
                    throw new JSONException("not support : " + typeVariable);
                }
            }
            if (type2 instanceof ParameterizedType) {
                ArrayList arrayList4 = new ArrayList();
                parseArray((ParameterizedType) type2, arrayList4);
                return arrayList4;
            }
            throw new JSONException("TODO : " + type);
        }
        throw new JSONException("not support type " + type);
    }

    public void parseExtra(Object obj, String str) {
        Object parseObject;
        this.lexer.nextTokenWithColon();
        List<ExtraTypeProvider> list = this.extraTypeProviders;
        Type type = null;
        if (list != null) {
            Iterator<ExtraTypeProvider> it = list.iterator();
            while (it.hasNext()) {
                type = it.next().getExtraType(obj, str);
            }
        }
        if (type == null) {
            parseObject = parse();
        } else {
            parseObject = parseObject(type);
        }
        if (obj instanceof ExtraProcessable) {
            ((ExtraProcessable) obj).processExtra(str, parseObject);
            return;
        }
        List<ExtraProcessor> list2 = this.extraProcessors;
        if (list2 != null) {
            Iterator<ExtraProcessor> it2 = list2.iterator();
            while (it2.hasNext()) {
                it2.next().processExtra(obj, str, parseObject);
            }
        }
        if (this.resolveStatus == 1) {
            this.resolveStatus = 0;
        }
    }

    public Object parseKey() {
        if (this.lexer.token() == 18) {
            String stringVal = this.lexer.stringVal();
            this.lexer.nextToken(16);
            return stringVal;
        }
        return parse(null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x034b, code lost:
    
        if (r3 == com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer.class) goto L192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x034d, code lost:
    
        setResolveStatus(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x035a, code lost:
    
        r0 = r0.deserialze(r17, r8, r19);
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x035e, code lost:
    
        setContext(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0361, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0354, code lost:
    
        if ((r0 instanceof com.alibaba.fastjson.parser.deserializer.MapDeserializer) == false) goto L195;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0356, code lost:
    
        setResolveStatus(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x02a6, code lost:
    
        r5.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x02b1, code lost:
    
        if (r5.token() != 13) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x02b3, code lost:
    
        r5.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x02be, code lost:
    
        if ((r17.config.getDeserializer(r8) instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) == false) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x02c0, code lost:
    
        r13 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r18, (java.lang.Class<java.lang.Object>) r8, r17.config);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x02ca, code lost:
    
        if (r13 != null) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x02ce, code lost:
    
        if (r8 != java.lang.Cloneable.class) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x02d0, code lost:
    
        r13 = new java.util.HashMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x02dc, code lost:
    
        if ("java.util.Collections$EmptyMap".equals(r7) == false) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x02de, code lost:
    
        r13 = java.util.Collections.emptyMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x02e9, code lost:
    
        if ("java.util.Collections$UnmodifiableMap".equals(r7) == false) goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x02eb, code lost:
    
        r13 = java.util.Collections.unmodifiableMap(new java.util.HashMap());
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x02f5, code lost:
    
        r13 = r8.newInstance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x02f9, code lost:
    
        setContext(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x02fc, code lost:
    
        return r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x02c8, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0304, code lost:
    
        throw new com.alibaba.fastjson.JSONException("create instance error", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0305, code lost:
    
        setResolveStatus(2);
        r3 = r17.context;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x030b, code lost:
    
        if (r3 == null) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x030d, code lost:
    
        if (r19 == null) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0311, code lost:
    
        if ((r19 instanceof java.lang.Integer) != false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0317, code lost:
    
        if ((r3.fieldName instanceof java.lang.Integer) != false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0319, code lost:
    
        popContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0320, code lost:
    
        if (r18.size() <= 0) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0322, code lost:
    
        r0 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r18, (java.lang.Class<java.lang.Object>) r8, r17.config);
        setResolveStatus(0);
        parseObject(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x032f, code lost:
    
        setContext(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0332, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0333, code lost:
    
        r0 = r17.config.getDeserializer(r8);
        r3 = r0.getClass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0343, code lost:
    
        if (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.class.isAssignableFrom(r3) == false) goto L192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0347, code lost:
    
        if (r3 == com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.class) goto L192;
     */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0367  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0471 A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:24:0x0074, B:26:0x0078, B:28:0x0085, B:31:0x0098, B:35:0x00ad, B:39:0x021e, B:40:0x0224, B:42:0x022f, B:44:0x0237, B:51:0x024d, B:53:0x025b, B:56:0x029e, B:58:0x02a6, B:60:0x02b3, B:62:0x02b6, B:64:0x02c0, B:68:0x02d0, B:69:0x02d6, B:71:0x02de, B:72:0x02e3, B:74:0x02eb, B:75:0x02f5, B:80:0x02fd, B:81:0x0304, B:82:0x0305, B:85:0x030f, B:87:0x0313, B:89:0x0319, B:90:0x031c, B:92:0x0322, B:95:0x0333, B:101:0x034d, B:102:0x035a, B:105:0x0352, B:107:0x0356, B:108:0x0261, B:111:0x026c, B:115:0x0278, B:117:0x027e, B:121:0x028b, B:124:0x028e, B:133:0x036b, B:136:0x0377, B:138:0x037f, B:140:0x0389, B:142:0x039a, B:144:0x03a4, B:146:0x03ac, B:148:0x03b0, B:150:0x03b6, B:153:0x03bb, B:155:0x03bf, B:156:0x0424, B:158:0x042c, B:161:0x0435, B:162:0x044f, B:165:0x03c5, B:167:0x03cd, B:170:0x03d3, B:171:0x03e0, B:174:0x03e9, B:178:0x03ef, B:181:0x03f4, B:182:0x0401, B:184:0x040b, B:185:0x0419, B:187:0x0450, B:188:0x046e, B:191:0x0471, B:193:0x0475, B:195:0x0479, B:198:0x047f, B:202:0x0487, B:208:0x0497, B:210:0x04a6, B:212:0x04b1, B:213:0x04b9, B:214:0x04bc, B:215:0x04e8, B:217:0x04f3, B:224:0x0500, B:227:0x0510, B:228:0x0530, B:233:0x04cc, B:235:0x04d6, B:236:0x04e5, B:237:0x04db, B:242:0x0535, B:244:0x053f, B:246:0x0547, B:247:0x054a, B:249:0x0555, B:250:0x0559, B:259:0x0564, B:252:0x056b, B:256:0x0577, B:257:0x057c, B:264:0x0581, B:266:0x0586, B:269:0x0591, B:271:0x0599, B:273:0x05ac, B:275:0x05c7, B:276:0x05cf, B:279:0x05d5, B:280:0x05db, B:282:0x05e3, B:284:0x05f3, B:287:0x05fb, B:289:0x05ff, B:290:0x0606, B:292:0x060b, B:293:0x060e, B:304:0x0616, B:295:0x0620, B:298:0x062a, B:299:0x062f, B:301:0x0634, B:302:0x064e, B:310:0x05b5, B:311:0x05ba, B:313:0x064f, B:321:0x0661, B:315:0x0668, B:318:0x0676, B:319:0x0696, B:325:0x00c1, B:326:0x00df, B:402:0x00e4, B:404:0x00ef, B:406:0x00f3, B:408:0x00f7, B:411:0x00fd, B:331:0x010c, B:333:0x0114, B:337:0x0126, B:338:0x013e, B:340:0x013f, B:341:0x0144, B:350:0x0159, B:352:0x015f, B:354:0x0166, B:355:0x0171, B:360:0x0183, B:364:0x018d, B:365:0x01a5, B:366:0x017e, B:367:0x016b, B:369:0x01a6, B:370:0x01be, B:378:0x01c8, B:380:0x01d0, B:384:0x01e3, B:385:0x0203, B:387:0x0204, B:388:0x0209, B:389:0x020a, B:391:0x0214, B:393:0x0697, B:394:0x069e, B:396:0x069f, B:397:0x06a4, B:399:0x06a5, B:400:0x06aa), top: B:23:0x0074, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0497 A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:24:0x0074, B:26:0x0078, B:28:0x0085, B:31:0x0098, B:35:0x00ad, B:39:0x021e, B:40:0x0224, B:42:0x022f, B:44:0x0237, B:51:0x024d, B:53:0x025b, B:56:0x029e, B:58:0x02a6, B:60:0x02b3, B:62:0x02b6, B:64:0x02c0, B:68:0x02d0, B:69:0x02d6, B:71:0x02de, B:72:0x02e3, B:74:0x02eb, B:75:0x02f5, B:80:0x02fd, B:81:0x0304, B:82:0x0305, B:85:0x030f, B:87:0x0313, B:89:0x0319, B:90:0x031c, B:92:0x0322, B:95:0x0333, B:101:0x034d, B:102:0x035a, B:105:0x0352, B:107:0x0356, B:108:0x0261, B:111:0x026c, B:115:0x0278, B:117:0x027e, B:121:0x028b, B:124:0x028e, B:133:0x036b, B:136:0x0377, B:138:0x037f, B:140:0x0389, B:142:0x039a, B:144:0x03a4, B:146:0x03ac, B:148:0x03b0, B:150:0x03b6, B:153:0x03bb, B:155:0x03bf, B:156:0x0424, B:158:0x042c, B:161:0x0435, B:162:0x044f, B:165:0x03c5, B:167:0x03cd, B:170:0x03d3, B:171:0x03e0, B:174:0x03e9, B:178:0x03ef, B:181:0x03f4, B:182:0x0401, B:184:0x040b, B:185:0x0419, B:187:0x0450, B:188:0x046e, B:191:0x0471, B:193:0x0475, B:195:0x0479, B:198:0x047f, B:202:0x0487, B:208:0x0497, B:210:0x04a6, B:212:0x04b1, B:213:0x04b9, B:214:0x04bc, B:215:0x04e8, B:217:0x04f3, B:224:0x0500, B:227:0x0510, B:228:0x0530, B:233:0x04cc, B:235:0x04d6, B:236:0x04e5, B:237:0x04db, B:242:0x0535, B:244:0x053f, B:246:0x0547, B:247:0x054a, B:249:0x0555, B:250:0x0559, B:259:0x0564, B:252:0x056b, B:256:0x0577, B:257:0x057c, B:264:0x0581, B:266:0x0586, B:269:0x0591, B:271:0x0599, B:273:0x05ac, B:275:0x05c7, B:276:0x05cf, B:279:0x05d5, B:280:0x05db, B:282:0x05e3, B:284:0x05f3, B:287:0x05fb, B:289:0x05ff, B:290:0x0606, B:292:0x060b, B:293:0x060e, B:304:0x0616, B:295:0x0620, B:298:0x062a, B:299:0x062f, B:301:0x0634, B:302:0x064e, B:310:0x05b5, B:311:0x05ba, B:313:0x064f, B:321:0x0661, B:315:0x0668, B:318:0x0676, B:319:0x0696, B:325:0x00c1, B:326:0x00df, B:402:0x00e4, B:404:0x00ef, B:406:0x00f3, B:408:0x00f7, B:411:0x00fd, B:331:0x010c, B:333:0x0114, B:337:0x0126, B:338:0x013e, B:340:0x013f, B:341:0x0144, B:350:0x0159, B:352:0x015f, B:354:0x0166, B:355:0x0171, B:360:0x0183, B:364:0x018d, B:365:0x01a5, B:366:0x017e, B:367:0x016b, B:369:0x01a6, B:370:0x01be, B:378:0x01c8, B:380:0x01d0, B:384:0x01e3, B:385:0x0203, B:387:0x0204, B:388:0x0209, B:389:0x020a, B:391:0x0214, B:393:0x0697, B:394:0x069e, B:396:0x069f, B:397:0x06a4, B:399:0x06a5, B:400:0x06aa), top: B:23:0x0074, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:217:0x04f3 A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:24:0x0074, B:26:0x0078, B:28:0x0085, B:31:0x0098, B:35:0x00ad, B:39:0x021e, B:40:0x0224, B:42:0x022f, B:44:0x0237, B:51:0x024d, B:53:0x025b, B:56:0x029e, B:58:0x02a6, B:60:0x02b3, B:62:0x02b6, B:64:0x02c0, B:68:0x02d0, B:69:0x02d6, B:71:0x02de, B:72:0x02e3, B:74:0x02eb, B:75:0x02f5, B:80:0x02fd, B:81:0x0304, B:82:0x0305, B:85:0x030f, B:87:0x0313, B:89:0x0319, B:90:0x031c, B:92:0x0322, B:95:0x0333, B:101:0x034d, B:102:0x035a, B:105:0x0352, B:107:0x0356, B:108:0x0261, B:111:0x026c, B:115:0x0278, B:117:0x027e, B:121:0x028b, B:124:0x028e, B:133:0x036b, B:136:0x0377, B:138:0x037f, B:140:0x0389, B:142:0x039a, B:144:0x03a4, B:146:0x03ac, B:148:0x03b0, B:150:0x03b6, B:153:0x03bb, B:155:0x03bf, B:156:0x0424, B:158:0x042c, B:161:0x0435, B:162:0x044f, B:165:0x03c5, B:167:0x03cd, B:170:0x03d3, B:171:0x03e0, B:174:0x03e9, B:178:0x03ef, B:181:0x03f4, B:182:0x0401, B:184:0x040b, B:185:0x0419, B:187:0x0450, B:188:0x046e, B:191:0x0471, B:193:0x0475, B:195:0x0479, B:198:0x047f, B:202:0x0487, B:208:0x0497, B:210:0x04a6, B:212:0x04b1, B:213:0x04b9, B:214:0x04bc, B:215:0x04e8, B:217:0x04f3, B:224:0x0500, B:227:0x0510, B:228:0x0530, B:233:0x04cc, B:235:0x04d6, B:236:0x04e5, B:237:0x04db, B:242:0x0535, B:244:0x053f, B:246:0x0547, B:247:0x054a, B:249:0x0555, B:250:0x0559, B:259:0x0564, B:252:0x056b, B:256:0x0577, B:257:0x057c, B:264:0x0581, B:266:0x0586, B:269:0x0591, B:271:0x0599, B:273:0x05ac, B:275:0x05c7, B:276:0x05cf, B:279:0x05d5, B:280:0x05db, B:282:0x05e3, B:284:0x05f3, B:287:0x05fb, B:289:0x05ff, B:290:0x0606, B:292:0x060b, B:293:0x060e, B:304:0x0616, B:295:0x0620, B:298:0x062a, B:299:0x062f, B:301:0x0634, B:302:0x064e, B:310:0x05b5, B:311:0x05ba, B:313:0x064f, B:321:0x0661, B:315:0x0668, B:318:0x0676, B:319:0x0696, B:325:0x00c1, B:326:0x00df, B:402:0x00e4, B:404:0x00ef, B:406:0x00f3, B:408:0x00f7, B:411:0x00fd, B:331:0x010c, B:333:0x0114, B:337:0x0126, B:338:0x013e, B:340:0x013f, B:341:0x0144, B:350:0x0159, B:352:0x015f, B:354:0x0166, B:355:0x0171, B:360:0x0183, B:364:0x018d, B:365:0x01a5, B:366:0x017e, B:367:0x016b, B:369:0x01a6, B:370:0x01be, B:378:0x01c8, B:380:0x01d0, B:384:0x01e3, B:385:0x0203, B:387:0x0204, B:388:0x0209, B:389:0x020a, B:391:0x0214, B:393:0x0697, B:394:0x069e, B:396:0x069f, B:397:0x06a4, B:399:0x06a5, B:400:0x06aa), top: B:23:0x0074, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:221:0x04fc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x04c0  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x05f3 A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:24:0x0074, B:26:0x0078, B:28:0x0085, B:31:0x0098, B:35:0x00ad, B:39:0x021e, B:40:0x0224, B:42:0x022f, B:44:0x0237, B:51:0x024d, B:53:0x025b, B:56:0x029e, B:58:0x02a6, B:60:0x02b3, B:62:0x02b6, B:64:0x02c0, B:68:0x02d0, B:69:0x02d6, B:71:0x02de, B:72:0x02e3, B:74:0x02eb, B:75:0x02f5, B:80:0x02fd, B:81:0x0304, B:82:0x0305, B:85:0x030f, B:87:0x0313, B:89:0x0319, B:90:0x031c, B:92:0x0322, B:95:0x0333, B:101:0x034d, B:102:0x035a, B:105:0x0352, B:107:0x0356, B:108:0x0261, B:111:0x026c, B:115:0x0278, B:117:0x027e, B:121:0x028b, B:124:0x028e, B:133:0x036b, B:136:0x0377, B:138:0x037f, B:140:0x0389, B:142:0x039a, B:144:0x03a4, B:146:0x03ac, B:148:0x03b0, B:150:0x03b6, B:153:0x03bb, B:155:0x03bf, B:156:0x0424, B:158:0x042c, B:161:0x0435, B:162:0x044f, B:165:0x03c5, B:167:0x03cd, B:170:0x03d3, B:171:0x03e0, B:174:0x03e9, B:178:0x03ef, B:181:0x03f4, B:182:0x0401, B:184:0x040b, B:185:0x0419, B:187:0x0450, B:188:0x046e, B:191:0x0471, B:193:0x0475, B:195:0x0479, B:198:0x047f, B:202:0x0487, B:208:0x0497, B:210:0x04a6, B:212:0x04b1, B:213:0x04b9, B:214:0x04bc, B:215:0x04e8, B:217:0x04f3, B:224:0x0500, B:227:0x0510, B:228:0x0530, B:233:0x04cc, B:235:0x04d6, B:236:0x04e5, B:237:0x04db, B:242:0x0535, B:244:0x053f, B:246:0x0547, B:247:0x054a, B:249:0x0555, B:250:0x0559, B:259:0x0564, B:252:0x056b, B:256:0x0577, B:257:0x057c, B:264:0x0581, B:266:0x0586, B:269:0x0591, B:271:0x0599, B:273:0x05ac, B:275:0x05c7, B:276:0x05cf, B:279:0x05d5, B:280:0x05db, B:282:0x05e3, B:284:0x05f3, B:287:0x05fb, B:289:0x05ff, B:290:0x0606, B:292:0x060b, B:293:0x060e, B:304:0x0616, B:295:0x0620, B:298:0x062a, B:299:0x062f, B:301:0x0634, B:302:0x064e, B:310:0x05b5, B:311:0x05ba, B:313:0x064f, B:321:0x0661, B:315:0x0668, B:318:0x0676, B:319:0x0696, B:325:0x00c1, B:326:0x00df, B:402:0x00e4, B:404:0x00ef, B:406:0x00f3, B:408:0x00f7, B:411:0x00fd, B:331:0x010c, B:333:0x0114, B:337:0x0126, B:338:0x013e, B:340:0x013f, B:341:0x0144, B:350:0x0159, B:352:0x015f, B:354:0x0166, B:355:0x0171, B:360:0x0183, B:364:0x018d, B:365:0x01a5, B:366:0x017e, B:367:0x016b, B:369:0x01a6, B:370:0x01be, B:378:0x01c8, B:380:0x01d0, B:384:0x01e3, B:385:0x0203, B:387:0x0204, B:388:0x0209, B:389:0x020a, B:391:0x0214, B:393:0x0697, B:394:0x069e, B:396:0x069f, B:397:0x06a4, B:399:0x06a5, B:400:0x06aa), top: B:23:0x0074, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:289:0x05ff A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:24:0x0074, B:26:0x0078, B:28:0x0085, B:31:0x0098, B:35:0x00ad, B:39:0x021e, B:40:0x0224, B:42:0x022f, B:44:0x0237, B:51:0x024d, B:53:0x025b, B:56:0x029e, B:58:0x02a6, B:60:0x02b3, B:62:0x02b6, B:64:0x02c0, B:68:0x02d0, B:69:0x02d6, B:71:0x02de, B:72:0x02e3, B:74:0x02eb, B:75:0x02f5, B:80:0x02fd, B:81:0x0304, B:82:0x0305, B:85:0x030f, B:87:0x0313, B:89:0x0319, B:90:0x031c, B:92:0x0322, B:95:0x0333, B:101:0x034d, B:102:0x035a, B:105:0x0352, B:107:0x0356, B:108:0x0261, B:111:0x026c, B:115:0x0278, B:117:0x027e, B:121:0x028b, B:124:0x028e, B:133:0x036b, B:136:0x0377, B:138:0x037f, B:140:0x0389, B:142:0x039a, B:144:0x03a4, B:146:0x03ac, B:148:0x03b0, B:150:0x03b6, B:153:0x03bb, B:155:0x03bf, B:156:0x0424, B:158:0x042c, B:161:0x0435, B:162:0x044f, B:165:0x03c5, B:167:0x03cd, B:170:0x03d3, B:171:0x03e0, B:174:0x03e9, B:178:0x03ef, B:181:0x03f4, B:182:0x0401, B:184:0x040b, B:185:0x0419, B:187:0x0450, B:188:0x046e, B:191:0x0471, B:193:0x0475, B:195:0x0479, B:198:0x047f, B:202:0x0487, B:208:0x0497, B:210:0x04a6, B:212:0x04b1, B:213:0x04b9, B:214:0x04bc, B:215:0x04e8, B:217:0x04f3, B:224:0x0500, B:227:0x0510, B:228:0x0530, B:233:0x04cc, B:235:0x04d6, B:236:0x04e5, B:237:0x04db, B:242:0x0535, B:244:0x053f, B:246:0x0547, B:247:0x054a, B:249:0x0555, B:250:0x0559, B:259:0x0564, B:252:0x056b, B:256:0x0577, B:257:0x057c, B:264:0x0581, B:266:0x0586, B:269:0x0591, B:271:0x0599, B:273:0x05ac, B:275:0x05c7, B:276:0x05cf, B:279:0x05d5, B:280:0x05db, B:282:0x05e3, B:284:0x05f3, B:287:0x05fb, B:289:0x05ff, B:290:0x0606, B:292:0x060b, B:293:0x060e, B:304:0x0616, B:295:0x0620, B:298:0x062a, B:299:0x062f, B:301:0x0634, B:302:0x064e, B:310:0x05b5, B:311:0x05ba, B:313:0x064f, B:321:0x0661, B:315:0x0668, B:318:0x0676, B:319:0x0696, B:325:0x00c1, B:326:0x00df, B:402:0x00e4, B:404:0x00ef, B:406:0x00f3, B:408:0x00f7, B:411:0x00fd, B:331:0x010c, B:333:0x0114, B:337:0x0126, B:338:0x013e, B:340:0x013f, B:341:0x0144, B:350:0x0159, B:352:0x015f, B:354:0x0166, B:355:0x0171, B:360:0x0183, B:364:0x018d, B:365:0x01a5, B:366:0x017e, B:367:0x016b, B:369:0x01a6, B:370:0x01be, B:378:0x01c8, B:380:0x01d0, B:384:0x01e3, B:385:0x0203, B:387:0x0204, B:388:0x0209, B:389:0x020a, B:391:0x0214, B:393:0x0697, B:394:0x069e, B:396:0x069f, B:397:0x06a4, B:399:0x06a5, B:400:0x06aa), top: B:23:0x0074, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:292:0x060b A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:24:0x0074, B:26:0x0078, B:28:0x0085, B:31:0x0098, B:35:0x00ad, B:39:0x021e, B:40:0x0224, B:42:0x022f, B:44:0x0237, B:51:0x024d, B:53:0x025b, B:56:0x029e, B:58:0x02a6, B:60:0x02b3, B:62:0x02b6, B:64:0x02c0, B:68:0x02d0, B:69:0x02d6, B:71:0x02de, B:72:0x02e3, B:74:0x02eb, B:75:0x02f5, B:80:0x02fd, B:81:0x0304, B:82:0x0305, B:85:0x030f, B:87:0x0313, B:89:0x0319, B:90:0x031c, B:92:0x0322, B:95:0x0333, B:101:0x034d, B:102:0x035a, B:105:0x0352, B:107:0x0356, B:108:0x0261, B:111:0x026c, B:115:0x0278, B:117:0x027e, B:121:0x028b, B:124:0x028e, B:133:0x036b, B:136:0x0377, B:138:0x037f, B:140:0x0389, B:142:0x039a, B:144:0x03a4, B:146:0x03ac, B:148:0x03b0, B:150:0x03b6, B:153:0x03bb, B:155:0x03bf, B:156:0x0424, B:158:0x042c, B:161:0x0435, B:162:0x044f, B:165:0x03c5, B:167:0x03cd, B:170:0x03d3, B:171:0x03e0, B:174:0x03e9, B:178:0x03ef, B:181:0x03f4, B:182:0x0401, B:184:0x040b, B:185:0x0419, B:187:0x0450, B:188:0x046e, B:191:0x0471, B:193:0x0475, B:195:0x0479, B:198:0x047f, B:202:0x0487, B:208:0x0497, B:210:0x04a6, B:212:0x04b1, B:213:0x04b9, B:214:0x04bc, B:215:0x04e8, B:217:0x04f3, B:224:0x0500, B:227:0x0510, B:228:0x0530, B:233:0x04cc, B:235:0x04d6, B:236:0x04e5, B:237:0x04db, B:242:0x0535, B:244:0x053f, B:246:0x0547, B:247:0x054a, B:249:0x0555, B:250:0x0559, B:259:0x0564, B:252:0x056b, B:256:0x0577, B:257:0x057c, B:264:0x0581, B:266:0x0586, B:269:0x0591, B:271:0x0599, B:273:0x05ac, B:275:0x05c7, B:276:0x05cf, B:279:0x05d5, B:280:0x05db, B:282:0x05e3, B:284:0x05f3, B:287:0x05fb, B:289:0x05ff, B:290:0x0606, B:292:0x060b, B:293:0x060e, B:304:0x0616, B:295:0x0620, B:298:0x062a, B:299:0x062f, B:301:0x0634, B:302:0x064e, B:310:0x05b5, B:311:0x05ba, B:313:0x064f, B:321:0x0661, B:315:0x0668, B:318:0x0676, B:319:0x0696, B:325:0x00c1, B:326:0x00df, B:402:0x00e4, B:404:0x00ef, B:406:0x00f3, B:408:0x00f7, B:411:0x00fd, B:331:0x010c, B:333:0x0114, B:337:0x0126, B:338:0x013e, B:340:0x013f, B:341:0x0144, B:350:0x0159, B:352:0x015f, B:354:0x0166, B:355:0x0171, B:360:0x0183, B:364:0x018d, B:365:0x01a5, B:366:0x017e, B:367:0x016b, B:369:0x01a6, B:370:0x01be, B:378:0x01c8, B:380:0x01d0, B:384:0x01e3, B:385:0x0203, B:387:0x0204, B:388:0x0209, B:389:0x020a, B:391:0x0214, B:393:0x0697, B:394:0x069e, B:396:0x069f, B:397:0x06a4, B:399:0x06a5, B:400:0x06aa), top: B:23:0x0074, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0620 A[Catch: all -> 0x0080, TRY_ENTER, TryCatch #0 {all -> 0x0080, blocks: (B:24:0x0074, B:26:0x0078, B:28:0x0085, B:31:0x0098, B:35:0x00ad, B:39:0x021e, B:40:0x0224, B:42:0x022f, B:44:0x0237, B:51:0x024d, B:53:0x025b, B:56:0x029e, B:58:0x02a6, B:60:0x02b3, B:62:0x02b6, B:64:0x02c0, B:68:0x02d0, B:69:0x02d6, B:71:0x02de, B:72:0x02e3, B:74:0x02eb, B:75:0x02f5, B:80:0x02fd, B:81:0x0304, B:82:0x0305, B:85:0x030f, B:87:0x0313, B:89:0x0319, B:90:0x031c, B:92:0x0322, B:95:0x0333, B:101:0x034d, B:102:0x035a, B:105:0x0352, B:107:0x0356, B:108:0x0261, B:111:0x026c, B:115:0x0278, B:117:0x027e, B:121:0x028b, B:124:0x028e, B:133:0x036b, B:136:0x0377, B:138:0x037f, B:140:0x0389, B:142:0x039a, B:144:0x03a4, B:146:0x03ac, B:148:0x03b0, B:150:0x03b6, B:153:0x03bb, B:155:0x03bf, B:156:0x0424, B:158:0x042c, B:161:0x0435, B:162:0x044f, B:165:0x03c5, B:167:0x03cd, B:170:0x03d3, B:171:0x03e0, B:174:0x03e9, B:178:0x03ef, B:181:0x03f4, B:182:0x0401, B:184:0x040b, B:185:0x0419, B:187:0x0450, B:188:0x046e, B:191:0x0471, B:193:0x0475, B:195:0x0479, B:198:0x047f, B:202:0x0487, B:208:0x0497, B:210:0x04a6, B:212:0x04b1, B:213:0x04b9, B:214:0x04bc, B:215:0x04e8, B:217:0x04f3, B:224:0x0500, B:227:0x0510, B:228:0x0530, B:233:0x04cc, B:235:0x04d6, B:236:0x04e5, B:237:0x04db, B:242:0x0535, B:244:0x053f, B:246:0x0547, B:247:0x054a, B:249:0x0555, B:250:0x0559, B:259:0x0564, B:252:0x056b, B:256:0x0577, B:257:0x057c, B:264:0x0581, B:266:0x0586, B:269:0x0591, B:271:0x0599, B:273:0x05ac, B:275:0x05c7, B:276:0x05cf, B:279:0x05d5, B:280:0x05db, B:282:0x05e3, B:284:0x05f3, B:287:0x05fb, B:289:0x05ff, B:290:0x0606, B:292:0x060b, B:293:0x060e, B:304:0x0616, B:295:0x0620, B:298:0x062a, B:299:0x062f, B:301:0x0634, B:302:0x064e, B:310:0x05b5, B:311:0x05ba, B:313:0x064f, B:321:0x0661, B:315:0x0668, B:318:0x0676, B:319:0x0696, B:325:0x00c1, B:326:0x00df, B:402:0x00e4, B:404:0x00ef, B:406:0x00f3, B:408:0x00f7, B:411:0x00fd, B:331:0x010c, B:333:0x0114, B:337:0x0126, B:338:0x013e, B:340:0x013f, B:341:0x0144, B:350:0x0159, B:352:0x015f, B:354:0x0166, B:355:0x0171, B:360:0x0183, B:364:0x018d, B:365:0x01a5, B:366:0x017e, B:367:0x016b, B:369:0x01a6, B:370:0x01be, B:378:0x01c8, B:380:0x01d0, B:384:0x01e3, B:385:0x0203, B:387:0x0204, B:388:0x0209, B:389:0x020a, B:391:0x0214, B:393:0x0697, B:394:0x069e, B:396:0x069f, B:397:0x06a4, B:399:0x06a5, B:400:0x06aa), top: B:23:0x0074, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0616 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:362:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x018d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x021e A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:24:0x0074, B:26:0x0078, B:28:0x0085, B:31:0x0098, B:35:0x00ad, B:39:0x021e, B:40:0x0224, B:42:0x022f, B:44:0x0237, B:51:0x024d, B:53:0x025b, B:56:0x029e, B:58:0x02a6, B:60:0x02b3, B:62:0x02b6, B:64:0x02c0, B:68:0x02d0, B:69:0x02d6, B:71:0x02de, B:72:0x02e3, B:74:0x02eb, B:75:0x02f5, B:80:0x02fd, B:81:0x0304, B:82:0x0305, B:85:0x030f, B:87:0x0313, B:89:0x0319, B:90:0x031c, B:92:0x0322, B:95:0x0333, B:101:0x034d, B:102:0x035a, B:105:0x0352, B:107:0x0356, B:108:0x0261, B:111:0x026c, B:115:0x0278, B:117:0x027e, B:121:0x028b, B:124:0x028e, B:133:0x036b, B:136:0x0377, B:138:0x037f, B:140:0x0389, B:142:0x039a, B:144:0x03a4, B:146:0x03ac, B:148:0x03b0, B:150:0x03b6, B:153:0x03bb, B:155:0x03bf, B:156:0x0424, B:158:0x042c, B:161:0x0435, B:162:0x044f, B:165:0x03c5, B:167:0x03cd, B:170:0x03d3, B:171:0x03e0, B:174:0x03e9, B:178:0x03ef, B:181:0x03f4, B:182:0x0401, B:184:0x040b, B:185:0x0419, B:187:0x0450, B:188:0x046e, B:191:0x0471, B:193:0x0475, B:195:0x0479, B:198:0x047f, B:202:0x0487, B:208:0x0497, B:210:0x04a6, B:212:0x04b1, B:213:0x04b9, B:214:0x04bc, B:215:0x04e8, B:217:0x04f3, B:224:0x0500, B:227:0x0510, B:228:0x0530, B:233:0x04cc, B:235:0x04d6, B:236:0x04e5, B:237:0x04db, B:242:0x0535, B:244:0x053f, B:246:0x0547, B:247:0x054a, B:249:0x0555, B:250:0x0559, B:259:0x0564, B:252:0x056b, B:256:0x0577, B:257:0x057c, B:264:0x0581, B:266:0x0586, B:269:0x0591, B:271:0x0599, B:273:0x05ac, B:275:0x05c7, B:276:0x05cf, B:279:0x05d5, B:280:0x05db, B:282:0x05e3, B:284:0x05f3, B:287:0x05fb, B:289:0x05ff, B:290:0x0606, B:292:0x060b, B:293:0x060e, B:304:0x0616, B:295:0x0620, B:298:0x062a, B:299:0x062f, B:301:0x0634, B:302:0x064e, B:310:0x05b5, B:311:0x05ba, B:313:0x064f, B:321:0x0661, B:315:0x0668, B:318:0x0676, B:319:0x0696, B:325:0x00c1, B:326:0x00df, B:402:0x00e4, B:404:0x00ef, B:406:0x00f3, B:408:0x00f7, B:411:0x00fd, B:331:0x010c, B:333:0x0114, B:337:0x0126, B:338:0x013e, B:340:0x013f, B:341:0x0144, B:350:0x0159, B:352:0x015f, B:354:0x0166, B:355:0x0171, B:360:0x0183, B:364:0x018d, B:365:0x01a5, B:366:0x017e, B:367:0x016b, B:369:0x01a6, B:370:0x01be, B:378:0x01c8, B:380:0x01d0, B:384:0x01e3, B:385:0x0203, B:387:0x0204, B:388:0x0209, B:389:0x020a, B:391:0x0214, B:393:0x0697, B:394:0x069e, B:396:0x069f, B:397:0x06a4, B:399:0x06a5, B:400:0x06aa), top: B:23:0x0074, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x029e A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:24:0x0074, B:26:0x0078, B:28:0x0085, B:31:0x0098, B:35:0x00ad, B:39:0x021e, B:40:0x0224, B:42:0x022f, B:44:0x0237, B:51:0x024d, B:53:0x025b, B:56:0x029e, B:58:0x02a6, B:60:0x02b3, B:62:0x02b6, B:64:0x02c0, B:68:0x02d0, B:69:0x02d6, B:71:0x02de, B:72:0x02e3, B:74:0x02eb, B:75:0x02f5, B:80:0x02fd, B:81:0x0304, B:82:0x0305, B:85:0x030f, B:87:0x0313, B:89:0x0319, B:90:0x031c, B:92:0x0322, B:95:0x0333, B:101:0x034d, B:102:0x035a, B:105:0x0352, B:107:0x0356, B:108:0x0261, B:111:0x026c, B:115:0x0278, B:117:0x027e, B:121:0x028b, B:124:0x028e, B:133:0x036b, B:136:0x0377, B:138:0x037f, B:140:0x0389, B:142:0x039a, B:144:0x03a4, B:146:0x03ac, B:148:0x03b0, B:150:0x03b6, B:153:0x03bb, B:155:0x03bf, B:156:0x0424, B:158:0x042c, B:161:0x0435, B:162:0x044f, B:165:0x03c5, B:167:0x03cd, B:170:0x03d3, B:171:0x03e0, B:174:0x03e9, B:178:0x03ef, B:181:0x03f4, B:182:0x0401, B:184:0x040b, B:185:0x0419, B:187:0x0450, B:188:0x046e, B:191:0x0471, B:193:0x0475, B:195:0x0479, B:198:0x047f, B:202:0x0487, B:208:0x0497, B:210:0x04a6, B:212:0x04b1, B:213:0x04b9, B:214:0x04bc, B:215:0x04e8, B:217:0x04f3, B:224:0x0500, B:227:0x0510, B:228:0x0530, B:233:0x04cc, B:235:0x04d6, B:236:0x04e5, B:237:0x04db, B:242:0x0535, B:244:0x053f, B:246:0x0547, B:247:0x054a, B:249:0x0555, B:250:0x0559, B:259:0x0564, B:252:0x056b, B:256:0x0577, B:257:0x057c, B:264:0x0581, B:266:0x0586, B:269:0x0591, B:271:0x0599, B:273:0x05ac, B:275:0x05c7, B:276:0x05cf, B:279:0x05d5, B:280:0x05db, B:282:0x05e3, B:284:0x05f3, B:287:0x05fb, B:289:0x05ff, B:290:0x0606, B:292:0x060b, B:293:0x060e, B:304:0x0616, B:295:0x0620, B:298:0x062a, B:299:0x062f, B:301:0x0634, B:302:0x064e, B:310:0x05b5, B:311:0x05ba, B:313:0x064f, B:321:0x0661, B:315:0x0668, B:318:0x0676, B:319:0x0696, B:325:0x00c1, B:326:0x00df, B:402:0x00e4, B:404:0x00ef, B:406:0x00f3, B:408:0x00f7, B:411:0x00fd, B:331:0x010c, B:333:0x0114, B:337:0x0126, B:338:0x013e, B:340:0x013f, B:341:0x0144, B:350:0x0159, B:352:0x015f, B:354:0x0166, B:355:0x0171, B:360:0x0183, B:364:0x018d, B:365:0x01a5, B:366:0x017e, B:367:0x016b, B:369:0x01a6, B:370:0x01be, B:378:0x01c8, B:380:0x01d0, B:384:0x01e3, B:385:0x0203, B:387:0x0204, B:388:0x0209, B:389:0x020a, B:391:0x0214, B:393:0x0697, B:394:0x069e, B:396:0x069f, B:397:0x06a4, B:399:0x06a5, B:400:0x06aa), top: B:23:0x0074, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02a6 A[EDGE_INSN: B:57:0x02a6->B:58:0x02a6 BREAK  A[LOOP:0: B:28:0x0085->B:49:0x03a0], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object parseObject(java.util.Map r18, java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 1711
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.DefaultJSONParser.parseObject(java.util.Map, java.lang.Object):java.lang.Object");
    }

    public void popContext() {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return;
        }
        this.context = this.context.parent;
        int i = this.contextArrayIndex;
        if (i <= 0) {
            return;
        }
        int i2 = i - 1;
        this.contextArrayIndex = i2;
        this.contextArray[i2] = null;
    }

    public Object resolveReference(String str) {
        if (this.contextArray == null) {
            return null;
        }
        int i = 0;
        while (true) {
            ParseContext[] parseContextArr = this.contextArray;
            if (i >= parseContextArr.length || i >= this.contextArrayIndex) {
                break;
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
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return;
        }
        this.context = parseContext;
    }

    public void setDateFomrat(DateFormat dateFormat) {
        setDateFormat(dateFormat);
    }

    public void setDateFormat(String str) {
        this.dateFormatPattern = str;
        this.dateFormat = null;
    }

    public void setFieldTypeResolver(FieldTypeResolver fieldTypeResolver) {
        this.fieldTypeResolver = fieldTypeResolver;
    }

    public void setResolveStatus(int i) {
        this.resolveStatus = i;
    }

    public void throwException(int i) {
        throw new JSONException("syntax error, expect " + JSONToken.name(i) + ", actual " + JSONToken.name(this.lexer.token()));
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig) {
        this(str, new JSONScanner(str, JSON.DEFAULT_PARSER_FEATURE), parserConfig);
    }

    public Object parse(Object obj) {
        Map jSONObject;
        JSONLexer jSONLexer = this.lexer;
        int i = jSONLexer.token();
        if (i == 2) {
            Number integerValue = jSONLexer.integerValue();
            jSONLexer.nextToken();
            return integerValue;
        }
        if (i == 3) {
            Number decimalValue = jSONLexer.decimalValue(jSONLexer.isEnabled(Feature.UseBigDecimal));
            jSONLexer.nextToken();
            return decimalValue;
        }
        if (i == 4) {
            String stringVal = jSONLexer.stringVal();
            jSONLexer.nextToken(16);
            if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                JSONScanner jSONScanner = new JSONScanner(stringVal);
                try {
                    if (jSONScanner.scanISO8601DateIfMatch()) {
                        return jSONScanner.getCalendar().getTime();
                    }
                } finally {
                    jSONScanner.close();
                }
            }
            return stringVal;
        }
        if (i == 12) {
            if (isEnabled(Feature.UseNativeJavaObject)) {
                jSONObject = jSONLexer.isEnabled(Feature.OrderedField) ? new HashMap() : new LinkedHashMap();
            } else {
                jSONObject = new JSONObject(jSONLexer.isEnabled(Feature.OrderedField));
            }
            return parseObject(jSONObject, obj);
        }
        if (i == 14) {
            Collection arrayList = isEnabled(Feature.UseNativeJavaObject) ? new ArrayList() : new JSONArray();
            parseArray(arrayList, obj);
            return jSONLexer.isEnabled(Feature.UseObjectArray) ? arrayList.toArray() : arrayList;
        }
        if (i == 18) {
            if ("NaN".equals(jSONLexer.stringVal())) {
                jSONLexer.nextToken();
                return null;
            }
            throw new JSONException("syntax error, " + jSONLexer.info());
        }
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
                            parseArray(hashSet, obj);
                            return hashSet;
                        case 22:
                            jSONLexer.nextToken();
                            TreeSet treeSet = new TreeSet();
                            parseArray(treeSet, obj);
                            return treeSet;
                        case 23:
                            jSONLexer.nextToken();
                            return null;
                        default:
                            throw new JSONException("syntax error, " + jSONLexer.info());
                    }
            }
        }
        byte[] bytesValue = jSONLexer.bytesValue();
        jSONLexer.nextToken();
        return bytesValue;
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig, int i) {
        this(str, new JSONScanner(str, i), parserConfig);
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

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public DefaultJSONParser(char[] cArr, int i, ParserConfig parserConfig, int i2) {
        this(cArr, new JSONScanner(cArr, i, i2), parserConfig);
    }

    public void parseArray(Type type, Collection collection) {
        parseArray(type, collection, null);
    }

    public DefaultJSONParser(JSONLexer jSONLexer) {
        this(jSONLexer, ParserConfig.getGlobalInstance());
    }

    public void parseArray(Type type, Collection collection, Object obj) {
        ObjectDeserializer deserializer;
        int i = this.lexer.token();
        if (i == 21 || i == 22) {
            this.lexer.nextToken();
            i = this.lexer.token();
        }
        if (i == 14) {
            if (Integer.TYPE == type) {
                deserializer = IntegerCodec.instance;
                this.lexer.nextToken(2);
            } else if (String.class == type) {
                deserializer = StringCodec.instance;
                this.lexer.nextToken(4);
            } else {
                deserializer = this.config.getDeserializer(type);
                this.lexer.nextToken(deserializer.getFastMatchToken());
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
                        collection.add(IntegerCodec.instance.deserialze(this, null, null));
                    } else if (String.class == type) {
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
                            obj2 = deserializer.deserialze(this, type, Integer.valueOf(i2));
                        }
                        collection.add(obj2);
                        checkListResolve(collection);
                    }
                    if (this.lexer.token() == 16) {
                        this.lexer.nextToken(deserializer.getFastMatchToken());
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
        Object cast;
        Class<?> cls;
        boolean z;
        Class cls2;
        int i = 8;
        if (this.lexer.token() == 8) {
            this.lexer.nextToken(16);
            return null;
        }
        int i2 = 14;
        if (this.lexer.token() == 14) {
            Object[] objArr = new Object[typeArr.length];
            if (typeArr.length == 0) {
                this.lexer.nextToken(15);
                if (this.lexer.token() == 15) {
                    this.lexer.nextToken(16);
                    return new Object[0];
                }
                throw new JSONException("syntax error");
            }
            this.lexer.nextToken(2);
            int i3 = 0;
            while (i3 < typeArr.length) {
                if (this.lexer.token() == i) {
                    this.lexer.nextToken(16);
                    cast = null;
                } else {
                    Type type = typeArr[i3];
                    if (type != Integer.TYPE && type != Integer.class) {
                        if (type == String.class) {
                            if (this.lexer.token() == 4) {
                                cast = this.lexer.stringVal();
                                this.lexer.nextToken(16);
                            } else {
                                cast = TypeUtils.cast(parse(), type, this.config);
                            }
                        } else {
                            if (i3 == typeArr.length - 1 && (type instanceof Class) && (((cls2 = (Class) type) != byte[].class && cls2 != char[].class) || this.lexer.token() != 4)) {
                                z = cls2.isArray();
                                cls = cls2.getComponentType();
                            } else {
                                cls = null;
                                z = false;
                            }
                            if (z && this.lexer.token() != i2) {
                                ArrayList arrayList = new ArrayList();
                                ObjectDeserializer deserializer = this.config.getDeserializer(cls);
                                int fastMatchToken = deserializer.getFastMatchToken();
                                if (this.lexer.token() != 15) {
                                    while (true) {
                                        arrayList.add(deserializer.deserialze(this, type, null));
                                        if (this.lexer.token() != 16) {
                                            break;
                                        }
                                        this.lexer.nextToken(fastMatchToken);
                                    }
                                    if (this.lexer.token() != 15) {
                                        throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
                                    }
                                }
                                cast = TypeUtils.cast(arrayList, type, this.config);
                            } else {
                                cast = this.config.getDeserializer(type).deserialze(this, type, Integer.valueOf(i3));
                            }
                        }
                    } else if (this.lexer.token() == 2) {
                        cast = Integer.valueOf(this.lexer.intValue());
                        this.lexer.nextToken(16);
                    } else {
                        cast = TypeUtils.cast(parse(), type, this.config);
                    }
                }
                objArr[i3] = cast;
                if (this.lexer.token() == 15) {
                    break;
                }
                if (this.lexer.token() == 16) {
                    if (i3 == typeArr.length - 1) {
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

    /* JADX WARN: Code restructure failed: missing block: B:70:0x0239, code lost:
    
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object parse(com.alibaba.fastjson.parser.deserializer.PropertyProcessable r11, java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 615
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.DefaultJSONParser.parse(com.alibaba.fastjson.parser.deserializer.PropertyProcessable, java.lang.Object):java.lang.Object");
    }

    public final void parseArray(Collection collection) {
        parseArray(collection, (Object) null);
    }

    public final void parseArray(Collection collection, Object obj) {
        Object obj2;
        Number decimalValue;
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == 21 || jSONLexer.token() == 22) {
            jSONLexer.nextToken();
        }
        if (jSONLexer.token() == 14) {
            jSONLexer.nextToken(4);
            ParseContext parseContext = this.context;
            if (parseContext != null && parseContext.level > 512) {
                throw new JSONException("array level > 512");
            }
            setContext(collection, obj);
            int i = 0;
            while (true) {
                try {
                    try {
                        if (jSONLexer.isEnabled(Feature.AllowArbitraryCommas)) {
                            while (jSONLexer.token() == 16) {
                                jSONLexer.nextToken();
                            }
                        }
                        int i2 = jSONLexer.token();
                        if (i2 == 2) {
                            Number integerValue = jSONLexer.integerValue();
                            jSONLexer.nextToken(16);
                            obj2 = integerValue;
                        } else if (i2 == 3) {
                            if (jSONLexer.isEnabled(Feature.UseBigDecimal)) {
                                decimalValue = jSONLexer.decimalValue(true);
                            } else {
                                decimalValue = jSONLexer.decimalValue(false);
                            }
                            obj2 = decimalValue;
                            jSONLexer.nextToken(16);
                        } else if (i2 == 4) {
                            String stringVal = jSONLexer.stringVal();
                            jSONLexer.nextToken(16);
                            obj2 = stringVal;
                            if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                                JSONScanner jSONScanner = new JSONScanner(stringVal);
                                Object obj3 = stringVal;
                                if (jSONScanner.scanISO8601DateIfMatch()) {
                                    obj3 = jSONScanner.getCalendar().getTime();
                                }
                                jSONScanner.close();
                                obj2 = obj3;
                            }
                        } else if (i2 == 6) {
                            Boolean bool = Boolean.TRUE;
                            jSONLexer.nextToken(16);
                            obj2 = bool;
                        } else if (i2 != 7) {
                            obj2 = null;
                            obj2 = null;
                            if (i2 == 8) {
                                jSONLexer.nextToken(4);
                            } else if (i2 == 12) {
                                obj2 = parseObject(new JSONObject(jSONLexer.isEnabled(Feature.OrderedField)), Integer.valueOf(i));
                            } else {
                                if (i2 == 20) {
                                    throw new JSONException("unclosed jsonArray");
                                }
                                if (i2 == 23) {
                                    jSONLexer.nextToken(4);
                                } else if (i2 == 14) {
                                    JSONArray jSONArray = new JSONArray();
                                    parseArray(jSONArray, Integer.valueOf(i));
                                    obj2 = jSONArray;
                                    if (jSONLexer.isEnabled(Feature.UseObjectArray)) {
                                        obj2 = jSONArray.toArray();
                                    }
                                } else if (i2 != 15) {
                                    obj2 = parse();
                                } else {
                                    jSONLexer.nextToken(16);
                                    setContext(parseContext);
                                    return;
                                }
                            }
                        } else {
                            Boolean bool2 = Boolean.FALSE;
                            jSONLexer.nextToken(16);
                            obj2 = bool2;
                        }
                        collection.add(obj2);
                        checkListResolve(collection);
                        if (jSONLexer.token() == 16) {
                            jSONLexer.nextToken(4);
                        }
                        i++;
                    } catch (ClassCastException e) {
                        throw new JSONException("unkown error", e);
                    }
                } catch (Throwable th) {
                    setContext(parseContext);
                    throw th;
                }
            }
        } else {
            throw new JSONException("syntax error, expect [, actual " + JSONToken.name(jSONLexer.token()) + ", pos " + jSONLexer.pos() + ", fieldName " + obj);
        }
    }

    public <T> T parseObject(Class<T> cls) {
        return (T) parseObject(cls, (Object) null);
    }

    public <T> T parseObject(Type type) {
        return (T) parseObject(type, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T parseObject(Type type, Object obj) {
        int i = this.lexer.token();
        if (i == 8) {
            this.lexer.nextToken();
            return (T) TypeUtils.optionalEmpty(type);
        }
        if (i == 4) {
            if (type == byte[].class) {
                T t = (T) this.lexer.bytesValue();
                this.lexer.nextToken();
                return t;
            }
            if (type == char[].class) {
                String stringVal = this.lexer.stringVal();
                this.lexer.nextToken();
                return (T) stringVal.toCharArray();
            }
        }
        ObjectDeserializer deserializer = this.config.getDeserializer(type);
        try {
            if (deserializer.getClass() == JavaBeanDeserializer.class) {
                if (this.lexer.token() != 12 && this.lexer.token() != 14) {
                    throw new JSONException("syntax error,expect start with { or [,but actually start with " + this.lexer.tokenName());
                }
                return (T) ((JavaBeanDeserializer) deserializer).deserialze(this, type, obj, 0);
            }
            return (T) deserializer.deserialze(this, type, obj);
        } catch (JSONException e) {
            throw e;
        } catch (Throwable th) {
            throw new JSONException(th.getMessage(), th);
        }
    }

    public void parseObject(Object obj) {
        Object deserialze;
        Class<?> cls = obj.getClass();
        ObjectDeserializer deserializer = this.config.getDeserializer(cls);
        JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
        if (this.lexer.token() != 12 && this.lexer.token() != 16) {
            throw new JSONException("syntax error, expect {, actual " + this.lexer.tokenName());
        }
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
            if (fieldDeserializer == null) {
                if (this.lexer.isEnabled(Feature.IgnoreNotMatch)) {
                    this.lexer.nextTokenWithColon();
                    parse();
                    if (this.lexer.token() == 13) {
                        this.lexer.nextToken();
                        return;
                    }
                } else {
                    throw new JSONException("setter not found, class " + cls.getName() + ", property " + scanSymbol);
                }
            } else {
                FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                Class<?> cls2 = fieldInfo.fieldClass;
                Type type = fieldInfo.fieldType;
                if (cls2 == Integer.TYPE) {
                    this.lexer.nextTokenWithColon(2);
                    deserialze = IntegerCodec.instance.deserialze(this, type, null);
                } else if (cls2 == String.class) {
                    this.lexer.nextTokenWithColon(4);
                    deserialze = StringCodec.deserialze(this);
                } else if (cls2 == Long.TYPE) {
                    this.lexer.nextTokenWithColon(2);
                    deserialze = LongCodec.instance.deserialze(this, type, null);
                } else {
                    ObjectDeserializer deserializer2 = this.config.getDeserializer(cls2, type);
                    this.lexer.nextTokenWithColon(deserializer2.getFastMatchToken());
                    deserialze = deserializer2.deserialze(this, type, null);
                }
                fieldDeserializer.setValue(obj, deserialze);
                if (this.lexer.token() != 16 && this.lexer.token() == 13) {
                    this.lexer.nextToken(16);
                    return;
                }
            }
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
        return new JSONObject((Map<String, Object>) parseObject);
    }
}
