package com.alibaba.fastjson;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.parser.deserializer.ParseProcess;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;

public abstract class JSON implements JSONStreamAware, JSONAware {
    public static int DEFAULT_GENERATE_FEATURE = (((SerializerFeature.QuoteFieldNames.getMask() | SerializerFeature.SkipTransientField.getMask()) | SerializerFeature.WriteEnumUsingName.getMask()) | SerializerFeature.SortField.getMask());
    public static int DEFAULT_PARSER_FEATURE = (((((((Feature.AutoCloseSource.getMask() | Feature.InternFieldNames.getMask()) | Feature.UseBigDecimal.getMask()) | Feature.AllowUnQuotedFieldNames.getMask()) | Feature.AllowSingleQuotes.getMask()) | Feature.AllowArbitraryCommas.getMask()) | Feature.SortFeidFastMatch.getMask()) | Feature.IgnoreNotMatch.getMask());
    public static String DEFAULT_TYPE_KEY = "@type";
    public static String DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String VERSION = "1.2.83";
    private static final ThreadLocal<byte[]> bytesLocal = new ThreadLocal<>();
    private static final ThreadLocal<char[]> charsLocal = new ThreadLocal<>();
    public static Locale defaultLocale = Locale.getDefault();
    public static TimeZone defaultTimeZone = TimeZone.getDefault();
    static final SerializeFilter[] emptyFilters = new SerializeFilter[0];
    private static final ConcurrentHashMap<Type, Type> mixInsMapper = new ConcurrentHashMap<>(16);

    static {
        config(IOUtils.DEFAULT_PROPERTIES);
    }

    public static void addMixInAnnotations(Type type, Type type2) {
        if (type != null && type2 != null) {
            mixInsMapper.put(type, type2);
        }
    }

    private static byte[] allocateBytes(int i) {
        ThreadLocal<byte[]> threadLocal = bytesLocal;
        byte[] bArr = threadLocal.get();
        if (bArr == null) {
            if (i > 65536) {
                return new byte[i];
            }
            byte[] bArr2 = new byte[65536];
            threadLocal.set(bArr2);
            return bArr2;
        } else if (bArr.length < i) {
            return new byte[i];
        } else {
            return bArr;
        }
    }

    private static char[] allocateChars(int i) {
        ThreadLocal<char[]> threadLocal = charsLocal;
        char[] cArr = threadLocal.get();
        if (cArr == null) {
            if (i > 65536) {
                return new char[i];
            }
            char[] cArr2 = new char[65536];
            threadLocal.set(cArr2);
            return cArr2;
        } else if (cArr.length < i) {
            return new char[i];
        } else {
            return cArr;
        }
    }

    public static void clearMixInAnnotations() {
        mixInsMapper.clear();
    }

    private static void config(Properties properties) {
        String property = properties.getProperty("fastjson.serializerFeatures.MapSortField");
        int mask = SerializerFeature.MapSortField.getMask();
        if ("true".equals(property)) {
            DEFAULT_GENERATE_FEATURE |= mask;
        } else if ("false".equals(property)) {
            DEFAULT_GENERATE_FEATURE &= ~mask;
        }
        if ("true".equals(properties.getProperty("parser.features.NonStringKeyAsString"))) {
            DEFAULT_PARSER_FEATURE |= Feature.NonStringKeyAsString.getMask();
        }
        if ("true".equals(properties.getProperty("parser.features.ErrorOnEnumNotMatch")) || "true".equals(properties.getProperty("fastjson.parser.features.ErrorOnEnumNotMatch"))) {
            DEFAULT_PARSER_FEATURE |= Feature.ErrorOnEnumNotMatch.getMask();
        }
        if ("false".equals(properties.getProperty("fastjson.asmEnable"))) {
            ParserConfig.global.setAsmEnable(false);
            SerializeConfig.globalInstance.setAsmEnable(false);
        }
    }

    public static Type getMixInAnnotations(Type type) {
        if (type != null) {
            return mixInsMapper.get(type);
        }
        return null;
    }

    public static <T> void handleResovleTask(DefaultJSONParser defaultJSONParser, T t) {
        defaultJSONParser.handleResovleTask(t);
    }

    public static boolean isValid(String str) {
        boolean z = false;
        if (!(str == null || str.length() == 0)) {
            JSONScanner jSONScanner = new JSONScanner(str);
            try {
                jSONScanner.nextToken();
                int i = jSONScanner.token();
                if (i != 12) {
                    if (i != 14) {
                        switch (i) {
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                                jSONScanner.nextToken();
                                break;
                            default:
                                jSONScanner.close();
                                return false;
                        }
                    } else {
                        jSONScanner.skipArray(true);
                    }
                } else if (jSONScanner.getCurrent() == 26) {
                    jSONScanner.close();
                    return false;
                } else {
                    jSONScanner.skipObject(true);
                }
                if (jSONScanner.token() == 20) {
                    z = true;
                }
                jSONScanner.close();
                return z;
            } catch (Exception unused) {
                jSONScanner.close();
            } catch (Throwable th) {
                jSONScanner.close();
                throw th;
            }
        }
        return false;
    }

    public static boolean isValidArray(String str) {
        boolean z = false;
        if (!(str == null || str.length() == 0)) {
            JSONScanner jSONScanner = new JSONScanner(str);
            try {
                jSONScanner.nextToken();
                if (jSONScanner.token() == 14) {
                    jSONScanner.skipArray(true);
                    if (jSONScanner.token() == 20) {
                        z = true;
                    }
                    return z;
                }
                jSONScanner.close();
                return false;
            } catch (Exception unused) {
            } finally {
                jSONScanner.close();
            }
        }
        return false;
    }

    public static boolean isValidObject(String str) {
        boolean z = false;
        if (!(str == null || str.length() == 0)) {
            JSONScanner jSONScanner = new JSONScanner(str);
            try {
                jSONScanner.nextToken();
                if (jSONScanner.token() != 12) {
                    jSONScanner.close();
                    return false;
                } else if (jSONScanner.getCurrent() == 26) {
                    return false;
                } else {
                    jSONScanner.skipObject(true);
                    if (jSONScanner.token() == 20) {
                        z = true;
                    }
                    jSONScanner.close();
                    return z;
                }
            } catch (Exception unused) {
            } finally {
                jSONScanner.close();
            }
        }
        return false;
    }

    public static Object parse(String str) {
        return parse(str, DEFAULT_PARSER_FEATURE);
    }

    public static JSONArray parseArray(String str) {
        return parseArray(str, ParserConfig.global);
    }

    public static JSONObject parseObject(String str, Feature... featureArr) {
        return (JSONObject) parse(str, featureArr);
    }

    public static void removeMixInAnnotations(Type type) {
        if (type != null) {
            mixInsMapper.remove(type);
        }
    }

    public static void setDefaultTypeKey(String str) {
        DEFAULT_TYPE_KEY = str;
        ParserConfig.global.symbolTable.addSymbol(str, 0, str.length(), str.hashCode(), true);
    }

    public static Object toJSON(Object obj) {
        return toJSON(obj, SerializeConfig.globalInstance);
    }

    public static byte[] toJSONBytes(Object obj, SerializerFeature... serializerFeatureArr) {
        return toJSONBytes(obj, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static byte[] toJSONBytesWithFastJsonConfig(Charset charset, Object obj, SerializeConfig serializeConfig, SerializeFilter[] serializeFilterArr, String str, int i, SerializerFeature... serializerFeatureArr) {
        SerializeWriter serializeWriter = new SerializeWriter((Writer) null, i, serializerFeatureArr);
        try {
            JSONSerializer jSONSerializer = new JSONSerializer(serializeWriter, serializeConfig);
            if (!(str == null || str.length() == 0)) {
                jSONSerializer.setFastJsonConfigDateFormatPattern(str);
                jSONSerializer.config(SerializerFeature.WriteDateUseDateFormat, true);
            }
            if (serializeFilterArr != null) {
                for (SerializeFilter addFilter : serializeFilterArr) {
                    jSONSerializer.addFilter(addFilter);
                }
            }
            jSONSerializer.write(obj);
            byte[] bytes = serializeWriter.toBytes(charset);
            serializeWriter.close();
            return bytes;
        } catch (Throwable th) {
            serializeWriter.close();
            throw th;
        }
    }

    public static String toJSONString(Object obj) {
        return toJSONString(obj, emptyFilters, new SerializerFeature[0]);
    }

    public static String toJSONStringWithDateFormat(Object obj, String str, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, SerializeConfig.globalInstance, (SerializeFilter[]) null, str, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static String toJSONStringZ(Object obj, SerializeConfig serializeConfig, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, serializeConfig, emptyFilters, (String) null, 0, serializerFeatureArr);
    }

    public static <T> T toJavaObject(JSON json, Class<T> cls) {
        return TypeUtils.cast((Object) json, cls, ParserConfig.getGlobalInstance());
    }

    public static void writeJSONString(Writer writer, Object obj, SerializerFeature... serializerFeatureArr) {
        writeJSONString(writer, obj, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static void writeJSONStringTo(Object obj, Writer writer, SerializerFeature... serializerFeatureArr) {
        writeJSONString(writer, obj, serializerFeatureArr);
    }

    public static final int writeJSONStringWithFastJsonConfig(OutputStream outputStream, Charset charset, Object obj, SerializeConfig serializeConfig, SerializeFilter[] serializeFilterArr, String str, int i, SerializerFeature... serializerFeatureArr) throws IOException {
        SerializeWriter serializeWriter = new SerializeWriter((Writer) null, i, serializerFeatureArr);
        try {
            JSONSerializer jSONSerializer = new JSONSerializer(serializeWriter, serializeConfig);
            if (!(str == null || str.length() == 0)) {
                jSONSerializer.setFastJsonConfigDateFormatPattern(str);
                jSONSerializer.config(SerializerFeature.WriteDateUseDateFormat, true);
            }
            if (serializeFilterArr != null) {
                for (SerializeFilter addFilter : serializeFilterArr) {
                    jSONSerializer.addFilter(addFilter);
                }
            }
            jSONSerializer.write(obj);
            int writeToEx = serializeWriter.writeToEx(outputStream, charset);
            serializeWriter.close();
            return writeToEx;
        } catch (Throwable th) {
            serializeWriter.close();
            throw th;
        }
    }

    public String toString() {
        return toJSONString();
    }

    public static Object parse(String str, ParserConfig parserConfig) {
        return parse(str, parserConfig, DEFAULT_PARSER_FEATURE);
    }

    public static JSONArray parseArray(String str, ParserConfig parserConfig) {
        JSONArray jSONArray = null;
        if (str == null) {
            return null;
        }
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str, parserConfig);
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 8) {
            jSONLexer.nextToken();
        } else if (jSONLexer.token() != 20 || !jSONLexer.isBlankInput()) {
            jSONArray = new JSONArray();
            defaultJSONParser.parseArray((Collection) jSONArray);
            defaultJSONParser.handleResovleTask(jSONArray);
        }
        defaultJSONParser.close();
        return jSONArray;
    }

    public static JSONObject parseObject(String str) {
        Object parse = parse(str);
        if (parse instanceof JSONObject) {
            return (JSONObject) parse;
        }
        try {
            return (JSONObject) toJSON(parse);
        } catch (RuntimeException e) {
            throw new JSONException("can not cast to JSONObject.", e);
        }
    }

    public static Object toJSON(Object obj, ParserConfig parserConfig) {
        return toJSON(obj, SerializeConfig.globalInstance);
    }

    public static byte[] toJSONBytes(Object obj, SerializeFilter serializeFilter, SerializerFeature... serializerFeatureArr) {
        return toJSONBytes(obj, SerializeConfig.globalInstance, new SerializeFilter[]{serializeFilter}, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static String toJSONString(Object obj, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static void writeJSONString(Writer writer, Object obj, int i, SerializerFeature... serializerFeatureArr) {
        SerializeWriter serializeWriter = new SerializeWriter(writer, i, serializerFeatureArr);
        try {
            new JSONSerializer(serializeWriter).write(obj);
        } finally {
            serializeWriter.close();
        }
    }

    public <T> T toJavaObject(Class<T> cls) {
        return (cls == JSONArray.class || cls == JSON.class || cls == Collection.class || cls == List.class) ? this : TypeUtils.cast((Object) this, cls, ParserConfig.getGlobalInstance());
    }

    public String toString(SerializerFeature... serializerFeatureArr) {
        SerializeWriter serializeWriter = new SerializeWriter((Writer) null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
        try {
            new JSONSerializer(serializeWriter).write((Object) this);
            return serializeWriter.toString();
        } finally {
            serializeWriter.close();
        }
    }

    public static Object parse(String str, ParserConfig parserConfig, Feature... featureArr) {
        int i = DEFAULT_PARSER_FEATURE;
        for (Feature config : featureArr) {
            i = Feature.config(i, config, true);
        }
        return parse(str, parserConfig, i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v4, types: [int] */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r2v7, types: [int] */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: type inference failed for: r2v12 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object toJSON(java.lang.Object r7, com.alibaba.fastjson.serializer.SerializeConfig r8) {
        /*
            if (r7 != 0) goto L_0x0004
            r7 = 0
            return r7
        L_0x0004:
            boolean r0 = r7 instanceof com.alibaba.fastjson.JSON
            if (r0 == 0) goto L_0x0009
            return r7
        L_0x0009:
            boolean r0 = r7 instanceof java.util.Map
            if (r0 == 0) goto L_0x005a
            java.util.Map r7 = (java.util.Map) r7
            int r0 = r7.size()
            boolean r1 = r7 instanceof java.util.LinkedHashMap
            if (r1 == 0) goto L_0x001d
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r1.<init>(r0)
            goto L_0x002c
        L_0x001d:
            boolean r1 = r7 instanceof java.util.TreeMap
            if (r1 == 0) goto L_0x0027
            java.util.TreeMap r1 = new java.util.TreeMap
            r1.<init>()
            goto L_0x002c
        L_0x0027:
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>(r0)
        L_0x002c:
            com.alibaba.fastjson.JSONObject r0 = new com.alibaba.fastjson.JSONObject
            r0.<init>((java.util.Map<java.lang.String, java.lang.Object>) r1)
            java.util.Set r7 = r7.entrySet()
            java.util.Iterator r7 = r7.iterator()
        L_0x0039:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x0059
            java.lang.Object r1 = r7.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            java.lang.String r2 = com.alibaba.fastjson.util.TypeUtils.castToString(r2)
            java.lang.Object r1 = r1.getValue()
            java.lang.Object r1 = toJSON((java.lang.Object) r1, (com.alibaba.fastjson.serializer.SerializeConfig) r8)
            r0.put((java.lang.String) r2, (java.lang.Object) r1)
            goto L_0x0039
        L_0x0059:
            return r0
        L_0x005a:
            boolean r0 = r7 instanceof java.util.Collection
            if (r0 == 0) goto L_0x0080
            java.util.Collection r7 = (java.util.Collection) r7
            com.alibaba.fastjson.JSONArray r0 = new com.alibaba.fastjson.JSONArray
            int r1 = r7.size()
            r0.<init>((int) r1)
            java.util.Iterator r7 = r7.iterator()
        L_0x006d:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x007f
            java.lang.Object r1 = r7.next()
            java.lang.Object r1 = toJSON((java.lang.Object) r1, (com.alibaba.fastjson.serializer.SerializeConfig) r8)
            r0.add(r1)
            goto L_0x006d
        L_0x007f:
            return r0
        L_0x0080:
            boolean r0 = r7 instanceof com.alibaba.fastjson.serializer.JSONSerializable
            if (r0 == 0) goto L_0x008d
            java.lang.String r7 = toJSONString(r7)
            java.lang.Object r7 = parse(r7)
            return r7
        L_0x008d:
            java.lang.Class r0 = r7.getClass()
            boolean r1 = r0.isEnum()
            if (r1 == 0) goto L_0x009e
            java.lang.Enum r7 = (java.lang.Enum) r7
            java.lang.String r7 = r7.name()
            return r7
        L_0x009e:
            boolean r1 = r0.isArray()
            r2 = 0
            if (r1 == 0) goto L_0x00bf
            int r8 = java.lang.reflect.Array.getLength(r7)
            com.alibaba.fastjson.JSONArray r0 = new com.alibaba.fastjson.JSONArray
            r0.<init>((int) r8)
        L_0x00ae:
            if (r2 >= r8) goto L_0x00be
            java.lang.Object r1 = java.lang.reflect.Array.get(r7, r2)
            java.lang.Object r1 = toJSON(r1)
            r0.add(r1)
            int r2 = r2 + 1
            goto L_0x00ae
        L_0x00be:
            return r0
        L_0x00bf:
            boolean r1 = com.alibaba.fastjson.parser.ParserConfig.isPrimitive2(r0)
            if (r1 == 0) goto L_0x00c6
            return r7
        L_0x00c6:
            com.alibaba.fastjson.serializer.ObjectSerializer r0 = r8.getObjectWriter(r0)
            boolean r1 = r0 instanceof com.alibaba.fastjson.serializer.JavaBeanSerializer
            if (r1 == 0) goto L_0x0127
            com.alibaba.fastjson.serializer.JavaBeanSerializer r0 = (com.alibaba.fastjson.serializer.JavaBeanSerializer) r0
            com.alibaba.fastjson.annotation.JSONType r1 = r0.getJSONType()
            if (r1 == 0) goto L_0x00ed
            com.alibaba.fastjson.serializer.SerializerFeature[] r1 = r1.serialzeFeatures()
            int r3 = r1.length
            r4 = 0
        L_0x00dc:
            if (r2 >= r3) goto L_0x00ec
            r5 = r1[r2]
            com.alibaba.fastjson.serializer.SerializerFeature r6 = com.alibaba.fastjson.serializer.SerializerFeature.SortField
            if (r5 == r6) goto L_0x00e8
            com.alibaba.fastjson.serializer.SerializerFeature r6 = com.alibaba.fastjson.serializer.SerializerFeature.MapSortField
            if (r5 != r6) goto L_0x00e9
        L_0x00e8:
            r4 = 1
        L_0x00e9:
            int r2 = r2 + 1
            goto L_0x00dc
        L_0x00ec:
            r2 = r4
        L_0x00ed:
            com.alibaba.fastjson.JSONObject r1 = new com.alibaba.fastjson.JSONObject
            r1.<init>((boolean) r2)
            java.util.Map r7 = r0.getFieldValuesMap(r7)     // Catch:{ Exception -> 0x011c }
            java.util.Set r7 = r7.entrySet()     // Catch:{ Exception -> 0x011c }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ Exception -> 0x011c }
        L_0x00fe:
            boolean r0 = r7.hasNext()     // Catch:{ Exception -> 0x011c }
            if (r0 == 0) goto L_0x011e
            java.lang.Object r0 = r7.next()     // Catch:{ Exception -> 0x011c }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ Exception -> 0x011c }
            java.lang.Object r2 = r0.getKey()     // Catch:{ Exception -> 0x011c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x011c }
            java.lang.Object r0 = r0.getValue()     // Catch:{ Exception -> 0x011c }
            java.lang.Object r0 = toJSON((java.lang.Object) r0, (com.alibaba.fastjson.serializer.SerializeConfig) r8)     // Catch:{ Exception -> 0x011c }
            r1.put((java.lang.String) r2, (java.lang.Object) r0)     // Catch:{ Exception -> 0x011c }
            goto L_0x00fe
        L_0x011c:
            r7 = move-exception
            goto L_0x011f
        L_0x011e:
            return r1
        L_0x011f:
            com.alibaba.fastjson.JSONException r8 = new com.alibaba.fastjson.JSONException
            java.lang.String r0 = "toJSON error"
            r8.<init>(r0, r7)
            throw r8
        L_0x0127:
            com.alibaba.fastjson.serializer.SerializerFeature[] r0 = new com.alibaba.fastjson.serializer.SerializerFeature[r2]
            java.lang.String r7 = toJSONString((java.lang.Object) r7, (com.alibaba.fastjson.serializer.SerializeConfig) r8, (com.alibaba.fastjson.serializer.SerializerFeature[]) r0)
            java.lang.Object r7 = parse(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.JSON.toJSON(java.lang.Object, com.alibaba.fastjson.serializer.SerializeConfig):java.lang.Object");
    }

    public static byte[] toJSONBytes(Object obj, int i, SerializerFeature... serializerFeatureArr) {
        return toJSONBytes(obj, SerializeConfig.globalInstance, i, serializerFeatureArr);
    }

    public static String toJSONString(Object obj, int i, SerializerFeature... serializerFeatureArr) {
        SerializeWriter serializeWriter = new SerializeWriter((Writer) null, i, serializerFeatureArr);
        try {
            new JSONSerializer(serializeWriter).write(obj);
            String serializeWriter2 = serializeWriter.toString();
            int length = serializeWriter2.length();
            if (length > 0) {
                int i2 = length - 1;
                if (serializeWriter2.charAt(i2) == '.' && (obj instanceof Number) && !serializeWriter.isEnabled(SerializerFeature.WriteClassName)) {
                    return serializeWriter2.substring(0, i2);
                }
            }
            serializeWriter.close();
            return serializeWriter2;
        } finally {
            serializeWriter.close();
        }
    }

    public static byte[] toJSONBytes(Object obj, SerializeConfig serializeConfig, SerializerFeature... serializerFeatureArr) {
        return toJSONBytes(obj, serializeConfig, emptyFilters, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public <T> T toJavaObject(Type type) {
        return TypeUtils.cast((Object) this, type, ParserConfig.getGlobalInstance());
    }

    public static byte[] toJSONBytes(Object obj, SerializeConfig serializeConfig, int i, SerializerFeature... serializerFeatureArr) {
        return toJSONBytes(obj, serializeConfig, emptyFilters, i, serializerFeatureArr);
    }

    public <T> T toJavaObject(TypeReference typeReference) {
        return TypeUtils.cast((Object) this, typeReference != null ? typeReference.getType() : null, ParserConfig.getGlobalInstance());
    }

    public static byte[] toJSONBytes(Object obj, SerializeFilter[] serializeFilterArr, SerializerFeature... serializerFeatureArr) {
        return toJSONBytes(obj, SerializeConfig.globalInstance, serializeFilterArr, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static Object parse(String str, ParserConfig parserConfig, int i) {
        if (str == null) {
            return null;
        }
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str, parserConfig, i);
        Object parse = defaultJSONParser.parse();
        defaultJSONParser.handleResovleTask(parse);
        defaultJSONParser.close();
        return parse;
    }

    public static <T> T parseObject(String str, TypeReference<T> typeReference, Feature... featureArr) {
        return parseObject(str, typeReference.type, ParserConfig.global, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static byte[] toJSONBytes(Object obj, SerializeConfig serializeConfig, SerializeFilter serializeFilter, SerializerFeature... serializerFeatureArr) {
        return toJSONBytes(obj, serializeConfig, new SerializeFilter[]{serializeFilter}, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static final int writeJSONString(OutputStream outputStream, Object obj, SerializerFeature... serializerFeatureArr) throws IOException {
        return writeJSONString(outputStream, obj, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static <T> T parseObject(String str, Class<T> cls, Feature... featureArr) {
        return parseObject(str, (Type) cls, ParserConfig.global, (ParseProcess) null, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static byte[] toJSONBytes(Object obj, SerializeConfig serializeConfig, SerializeFilter[] serializeFilterArr, int i, SerializerFeature... serializerFeatureArr) {
        return toJSONBytes(obj, serializeConfig, serializeFilterArr, (String) null, i, serializerFeatureArr);
    }

    public static final int writeJSONString(OutputStream outputStream, Object obj, int i, SerializerFeature... serializerFeatureArr) throws IOException {
        return writeJSONString(outputStream, IOUtils.UTF8, obj, SerializeConfig.globalInstance, (SerializeFilter[]) null, (String) null, i, serializerFeatureArr);
    }

    public static <T> T parseObject(String str, Class<T> cls, ParseProcess parseProcess, Feature... featureArr) {
        return parseObject(str, (Type) cls, ParserConfig.global, parseProcess, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static byte[] toJSONBytes(Object obj, SerializeConfig serializeConfig, SerializeFilter[] serializeFilterArr, String str, int i, SerializerFeature... serializerFeatureArr) {
        return toJSONBytes(IOUtils.UTF8, obj, serializeConfig, serializeFilterArr, str, i, serializerFeatureArr);
    }

    public static final int writeJSONString(OutputStream outputStream, Charset charset, Object obj, SerializerFeature... serializerFeatureArr) throws IOException {
        return writeJSONString(outputStream, charset, obj, SerializeConfig.globalInstance, (SerializeFilter[]) null, (String) null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static <T> T parseObject(String str, Type type, Feature... featureArr) {
        return parseObject(str, type, ParserConfig.global, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static byte[] toJSONBytes(Charset charset, Object obj, SerializeConfig serializeConfig, SerializeFilter[] serializeFilterArr, String str, int i, SerializerFeature... serializerFeatureArr) {
        SerializeWriter serializeWriter = new SerializeWriter((Writer) null, i, serializerFeatureArr);
        try {
            JSONSerializer jSONSerializer = new JSONSerializer(serializeWriter, serializeConfig);
            if (!(str == null || str.length() == 0)) {
                jSONSerializer.setDateFormat(str);
                jSONSerializer.config(SerializerFeature.WriteDateUseDateFormat, true);
            }
            if (serializeFilterArr != null) {
                for (SerializeFilter addFilter : serializeFilterArr) {
                    jSONSerializer.addFilter(addFilter);
                }
            }
            jSONSerializer.write(obj);
            byte[] bytes = serializeWriter.toBytes(charset);
            serializeWriter.close();
            return bytes;
        } catch (Throwable th) {
            serializeWriter.close();
            throw th;
        }
    }

    public static final int writeJSONString(OutputStream outputStream, Charset charset, Object obj, SerializeConfig serializeConfig, SerializeFilter[] serializeFilterArr, String str, int i, SerializerFeature... serializerFeatureArr) throws IOException {
        SerializeWriter serializeWriter = new SerializeWriter((Writer) null, i, serializerFeatureArr);
        try {
            JSONSerializer jSONSerializer = new JSONSerializer(serializeWriter, serializeConfig);
            if (!(str == null || str.length() == 0)) {
                jSONSerializer.setDateFormat(str);
                jSONSerializer.config(SerializerFeature.WriteDateUseDateFormat, true);
            }
            if (serializeFilterArr != null) {
                for (SerializeFilter addFilter : serializeFilterArr) {
                    jSONSerializer.addFilter(addFilter);
                }
            }
            jSONSerializer.write(obj);
            int writeToEx = serializeWriter.writeToEx(outputStream, charset);
            serializeWriter.close();
            return writeToEx;
        } catch (Throwable th) {
            serializeWriter.close();
            throw th;
        }
    }

    public static Object parse(String str, int i) {
        return parse(str, ParserConfig.getGlobalInstance(), i);
    }

    public static <T> List<T> parseArray(String str, Class<T> cls) {
        return parseArray(str, cls, ParserConfig.global);
    }

    public static <T> T parseObject(String str, Type type, ParseProcess parseProcess, Feature... featureArr) {
        return parseObject(str, type, ParserConfig.global, parseProcess, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static Object parse(byte[] bArr, Feature... featureArr) {
        char[] allocateChars = allocateChars(bArr.length);
        int decodeUTF8 = IOUtils.decodeUTF8(bArr, 0, bArr.length, allocateChars);
        if (decodeUTF8 < 0) {
            return null;
        }
        return parse(new String(allocateChars, 0, decodeUTF8), featureArr);
    }

    public static <T> List<T> parseArray(String str, Class<T> cls, ParserConfig parserConfig) {
        ArrayList arrayList = null;
        if (str == null) {
            return null;
        }
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str, parserConfig);
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = jSONLexer.token();
        if (i == 8) {
            jSONLexer.nextToken();
        } else if (i != 20 || !jSONLexer.isBlankInput()) {
            arrayList = new ArrayList();
            defaultJSONParser.parseArray((Class<?>) cls, (Collection) arrayList);
            defaultJSONParser.handleResovleTask(arrayList);
        }
        defaultJSONParser.close();
        return arrayList;
    }

    public static <T> T parseObject(String str, Type type, int i, Feature... featureArr) {
        if (str == null) {
            return null;
        }
        for (Feature config : featureArr) {
            i = Feature.config(i, config, true);
        }
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str, ParserConfig.getGlobalInstance(), i);
        T parseObject = defaultJSONParser.parseObject(type);
        defaultJSONParser.handleResovleTask(parseObject);
        defaultJSONParser.close();
        return parseObject;
    }

    public static String toJSONString(Object obj, SerializeFilter serializeFilter, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, SerializeConfig.globalInstance, new SerializeFilter[]{serializeFilter}, (String) null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static String toJSONString(Object obj, SerializeFilter[] serializeFilterArr, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, SerializeConfig.globalInstance, serializeFilterArr, (String) null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static Object parse(byte[] bArr, int i, int i2, CharsetDecoder charsetDecoder, Feature... featureArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        int i3 = DEFAULT_PARSER_FEATURE;
        for (Feature config : featureArr) {
            i3 = Feature.config(i3, config, true);
        }
        return parse(bArr, i, i2, charsetDecoder, i3);
    }

    public static String toJSONString(Object obj, SerializeConfig serializeConfig, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, serializeConfig, (SerializeFilter) null, serializerFeatureArr);
    }

    public static String toJSONString(Object obj, SerializeConfig serializeConfig, SerializeFilter serializeFilter, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, serializeConfig, new SerializeFilter[]{serializeFilter}, (String) null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static String toJSONString(Object obj, SerializeConfig serializeConfig, SerializeFilter[] serializeFilterArr, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, serializeConfig, serializeFilterArr, (String) null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static <T> T parseObject(String str, Type type, ParserConfig parserConfig, Feature... featureArr) {
        return parseObject(str, type, parserConfig, (ParseProcess) null, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static String toJSONString(Object obj, SerializeConfig serializeConfig, SerializeFilter[] serializeFilterArr, String str, int i, SerializerFeature... serializerFeatureArr) {
        SerializeWriter serializeWriter = new SerializeWriter((Writer) null, i, serializerFeatureArr);
        try {
            JSONSerializer jSONSerializer = new JSONSerializer(serializeWriter, serializeConfig);
            if (!(str == null || str.length() == 0)) {
                jSONSerializer.setDateFormat(str);
                jSONSerializer.config(SerializerFeature.WriteDateUseDateFormat, true);
            }
            if (serializeFilterArr != null) {
                for (SerializeFilter addFilter : serializeFilterArr) {
                    jSONSerializer.addFilter(addFilter);
                }
            }
            jSONSerializer.write(obj);
            String serializeWriter2 = serializeWriter.toString();
            serializeWriter.close();
            return serializeWriter2;
        } catch (Throwable th) {
            serializeWriter.close();
            throw th;
        }
    }

    public static <T> T parseObject(String str, Type type, ParserConfig parserConfig, int i, Feature... featureArr) {
        return parseObject(str, type, parserConfig, (ParseProcess) null, i, featureArr);
    }

    public static Object parse(byte[] bArr, int i, int i2, CharsetDecoder charsetDecoder, int i3) {
        charsetDecoder.reset();
        char[] allocateChars = allocateChars((int) (((double) i2) * ((double) charsetDecoder.maxCharsPerByte())));
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i, i2);
        CharBuffer wrap2 = CharBuffer.wrap(allocateChars);
        IOUtils.decode(charsetDecoder, wrap, wrap2);
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(allocateChars, wrap2.position(), ParserConfig.getGlobalInstance(), i3);
        Object parse = defaultJSONParser.parse();
        defaultJSONParser.handleResovleTask(parse);
        defaultJSONParser.close();
        return parse;
    }

    public static <T> T parseObject(String str, Type type, ParserConfig parserConfig, ParseProcess parseProcess, int i, Feature... featureArr) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (featureArr != null) {
            for (Feature feature : featureArr) {
                i |= feature.mask;
            }
        }
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str, parserConfig, i);
        if (parseProcess != null) {
            if (parseProcess instanceof ExtraTypeProvider) {
                defaultJSONParser.getExtraTypeProviders().add((ExtraTypeProvider) parseProcess);
            }
            if (parseProcess instanceof ExtraProcessor) {
                defaultJSONParser.getExtraProcessors().add((ExtraProcessor) parseProcess);
            }
            if (parseProcess instanceof FieldTypeResolver) {
                defaultJSONParser.setFieldTypeResolver((FieldTypeResolver) parseProcess);
            }
        }
        T parseObject = defaultJSONParser.parseObject(type, (Object) null);
        defaultJSONParser.handleResovleTask(parseObject);
        defaultJSONParser.close();
        return parseObject;
    }

    public static List<Object> parseArray(String str, Type[] typeArr) {
        return parseArray(str, typeArr, ParserConfig.global);
    }

    public void writeJSONString(Appendable appendable) {
        SerializeWriter serializeWriter = new SerializeWriter();
        try {
            new JSONSerializer(serializeWriter).write((Object) this);
            appendable.append(serializeWriter.toString());
            serializeWriter.close();
        } catch (IOException e) {
            throw new JSONException(e.getMessage(), e);
        } catch (Throwable th) {
            serializeWriter.close();
            throw th;
        }
    }

    public static List<Object> parseArray(String str, Type[] typeArr, ParserConfig parserConfig) {
        List<Object> list = null;
        if (str == null) {
            return null;
        }
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str, parserConfig);
        Object[] parseArray = defaultJSONParser.parseArray(typeArr);
        if (parseArray != null) {
            list = Arrays.asList(parseArray);
        }
        defaultJSONParser.handleResovleTask(list);
        defaultJSONParser.close();
        return list;
    }

    public static String toJSONString(Object obj, boolean z) {
        if (!z) {
            return toJSONString(obj);
        }
        return toJSONString(obj, SerializerFeature.PrettyFormat);
    }

    public static Object parse(String str, Feature... featureArr) {
        int i = DEFAULT_PARSER_FEATURE;
        for (Feature config : featureArr) {
            i = Feature.config(i, config, true);
        }
        return parse(str, i);
    }

    public String toJSONString() {
        SerializeWriter serializeWriter = new SerializeWriter();
        try {
            new JSONSerializer(serializeWriter).write((Object) this);
            return serializeWriter.toString();
        } finally {
            serializeWriter.close();
        }
    }

    public static <T> T parseObject(byte[] bArr, Type type, Feature... featureArr) {
        return parseObject(bArr, 0, bArr.length, IOUtils.UTF8, type, featureArr);
    }

    public static <T> T parseObject(byte[] bArr, int i, int i2, Charset charset, Type type, Feature... featureArr) {
        return parseObject(bArr, i, i2, charset, type, ParserConfig.global, (ParseProcess) null, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static <T> T parseObject(byte[] bArr, Charset charset, Type type, ParserConfig parserConfig, ParseProcess parseProcess, int i, Feature... featureArr) {
        return parseObject(bArr, 0, bArr.length, charset, type, parserConfig, parseProcess, i, featureArr);
    }

    public static <T> T parseObject(byte[] bArr, int i, int i2, Charset charset, Type type, ParserConfig parserConfig, ParseProcess parseProcess, int i3, Feature... featureArr) {
        String str;
        String str2;
        InputStreamReader inputStreamReader;
        if (charset == null) {
            charset = IOUtils.UTF8;
        }
        InputStreamReader inputStreamReader2 = null;
        if (charset == IOUtils.UTF8) {
            char[] allocateChars = allocateChars(bArr.length);
            int decodeUTF8 = IOUtils.decodeUTF8(bArr, i, i2, allocateChars);
            if (decodeUTF8 < 0) {
                try {
                    inputStreamReader = new InputStreamReader(new GZIPInputStream(new ByteArrayInputStream(bArr, i, i2)), "UTF-8");
                    try {
                        str2 = IOUtils.readAll(inputStreamReader);
                        IOUtils.close(inputStreamReader);
                    } catch (Exception unused) {
                        IOUtils.close(inputStreamReader);
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        inputStreamReader2 = inputStreamReader;
                        IOUtils.close(inputStreamReader2);
                        throw th;
                    }
                } catch (Exception unused2) {
                    inputStreamReader = null;
                    IOUtils.close(inputStreamReader);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    IOUtils.close(inputStreamReader2);
                    throw th;
                }
            } else {
                str2 = null;
            }
            if (str2 == null && decodeUTF8 < 0) {
                return null;
            }
            if (str2 == null) {
                str2 = new String(allocateChars, 0, decodeUTF8);
            }
            str = str2;
        } else if (i2 < 0) {
            return null;
        } else {
            str = new String(bArr, i, i2, charset);
        }
        return parseObject(str, type, parserConfig, parseProcess, i3, featureArr);
    }

    public static <T> T parseObject(byte[] bArr, int i, int i2, CharsetDecoder charsetDecoder, Type type, Feature... featureArr) {
        charsetDecoder.reset();
        char[] allocateChars = allocateChars((int) (((double) i2) * ((double) charsetDecoder.maxCharsPerByte())));
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i, i2);
        CharBuffer wrap2 = CharBuffer.wrap(allocateChars);
        IOUtils.decode(charsetDecoder, wrap, wrap2);
        return parseObject(allocateChars, wrap2.position(), type, featureArr);
    }

    public static <T> T parseObject(char[] cArr, int i, Type type, Feature... featureArr) {
        if (cArr == null || cArr.length == 0) {
            return null;
        }
        int i2 = DEFAULT_PARSER_FEATURE;
        for (Feature config : featureArr) {
            i2 = Feature.config(i2, config, true);
        }
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(cArr, i, ParserConfig.getGlobalInstance(), i2);
        T parseObject = defaultJSONParser.parseObject(type);
        defaultJSONParser.handleResovleTask(parseObject);
        defaultJSONParser.close();
        return parseObject;
    }

    public static <T> T parseObject(InputStream inputStream, Type type, Feature... featureArr) throws IOException {
        return parseObject(inputStream, IOUtils.UTF8, type, featureArr);
    }

    public static <T> T parseObject(InputStream inputStream, Charset charset, Type type, Feature... featureArr) throws IOException {
        return parseObject(inputStream, charset, type, ParserConfig.global, featureArr);
    }

    public static <T> T parseObject(InputStream inputStream, Charset charset, Type type, ParserConfig parserConfig, Feature... featureArr) throws IOException {
        return parseObject(inputStream, charset, type, parserConfig, (ParseProcess) null, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static <T> T parseObject(InputStream inputStream, Charset charset, Type type, ParserConfig parserConfig, ParseProcess parseProcess, int i, Feature... featureArr) throws IOException {
        if (charset == null) {
            charset = IOUtils.UTF8;
        }
        Charset charset2 = charset;
        byte[] allocateBytes = allocateBytes(65536);
        int i2 = 0;
        while (true) {
            int read = inputStream.read(allocateBytes, i2, allocateBytes.length - i2);
            if (read == -1) {
                return parseObject(allocateBytes, 0, i2, charset2, type, parserConfig, parseProcess, i, featureArr);
            }
            i2 += read;
            if (i2 == allocateBytes.length) {
                byte[] bArr = new byte[((allocateBytes.length * 3) / 2)];
                System.arraycopy(allocateBytes, 0, bArr, 0, allocateBytes.length);
                allocateBytes = bArr;
            }
        }
    }

    public static <T> T parseObject(String str, Class<T> cls) {
        return parseObject(str, cls, new Feature[0]);
    }
}
