package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.nio.charset.Charset;
import org.springframework.core.ResolvableType;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.GenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

/* loaded from: classes.dex */
public class FastJsonHttpMessageConverter extends AbstractHttpMessageConverter<Object> implements GenericHttpMessageConverter<Object> {
    public static final MediaType APPLICATION_JAVASCRIPT = new MediaType(MimeTypes.BASE_TYPE_APPLICATION, "javascript");

    @Deprecated
    protected String dateFormat;
    private FastJsonConfig fastJsonConfig;

    @Deprecated
    protected SerializerFeature[] features;

    @Deprecated
    protected SerializeFilter[] filters;
    private boolean setLengthError;

    /* loaded from: classes.dex */
    public static class Spring4TypeResolvableHelper {
        private static boolean hasClazzResolvableType;

        static {
            try {
                Class.forName("org.springframework.core.ResolvableType");
                hasClazzResolvableType = true;
            } catch (ClassNotFoundException unused) {
                hasClazzResolvableType = false;
            }
        }

        private Spring4TypeResolvableHelper() {
        }

        public static /* synthetic */ boolean access$000() {
            return isSupport();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Type getType(Type type, Class<?> cls) {
            if (cls != null) {
                ResolvableType forType = ResolvableType.forType(type);
                if (type instanceof TypeVariable) {
                    ResolvableType resolveVariable = resolveVariable((TypeVariable) type, ResolvableType.forClass(cls));
                    if (resolveVariable != ResolvableType.NONE) {
                        return resolveVariable.resolve();
                    }
                    return type;
                }
                if ((type instanceof ParameterizedType) && forType.hasUnresolvableGenerics()) {
                    ParameterizedType parameterizedType = (ParameterizedType) type;
                    Class[] clsArr = new Class[parameterizedType.getActualTypeArguments().length];
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    for (int i = 0; i < actualTypeArguments.length; i++) {
                        Type type2 = actualTypeArguments[i];
                        if (type2 instanceof TypeVariable) {
                            ResolvableType resolveVariable2 = resolveVariable((TypeVariable) type2, ResolvableType.forClass(cls));
                            if (resolveVariable2 != ResolvableType.NONE) {
                                clsArr[i] = resolveVariable2.resolve();
                            } else {
                                clsArr[i] = ResolvableType.forType(type2).resolve();
                            }
                        } else {
                            clsArr[i] = ResolvableType.forType(type2).resolve();
                        }
                    }
                    return ResolvableType.forClassWithGenerics(forType.getRawClass(), clsArr).getType();
                }
                return type;
            }
            return type;
        }

        private static boolean isSupport() {
            return hasClazzResolvableType;
        }

        private static ResolvableType resolveVariable(TypeVariable<?> typeVariable, ResolvableType resolvableType) {
            if (resolvableType.hasGenerics()) {
                ResolvableType forType = ResolvableType.forType(typeVariable, resolvableType);
                if (forType.resolve() != null) {
                    return forType;
                }
            }
            ResolvableType superType = resolvableType.getSuperType();
            if (superType != ResolvableType.NONE) {
                ResolvableType resolveVariable = resolveVariable(typeVariable, superType);
                if (resolveVariable.resolve() != null) {
                    return resolveVariable;
                }
            }
            for (ResolvableType resolvableType2 : resolvableType.getInterfaces()) {
                ResolvableType resolveVariable2 = resolveVariable(typeVariable, resolvableType2);
                if (resolveVariable2.resolve() != null) {
                    return resolveVariable2;
                }
            }
            return ResolvableType.NONE;
        }
    }

    public FastJsonHttpMessageConverter() {
        super(MediaType.ALL);
        this.features = new SerializerFeature[0];
        this.filters = new SerializeFilter[0];
        this.setLengthError = false;
        this.fastJsonConfig = new FastJsonConfig();
    }

    private Object readType(Type type, HttpInputMessage httpInputMessage) {
        try {
            return JSON.parseObject(httpInputMessage.getBody(), this.fastJsonConfig.getCharset(), type, this.fastJsonConfig.getParserConfig(), this.fastJsonConfig.getParseProcess(), JSON.DEFAULT_PARSER_FEATURE, this.fastJsonConfig.getFeatures());
        } catch (JSONException e) {
            throw new HttpMessageNotReadableException("JSON parse error: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new HttpMessageNotReadableException("I/O error while reading input message", e2);
        }
    }

    private Object strangeCodeForJackson(Object obj) {
        if (obj != null && "com.fasterxml.jackson.databind.node.ObjectNode".equals(obj.getClass().getName())) {
            return obj.toString();
        }
        return obj;
    }

    @Deprecated
    public void addSerializeFilter(SerializeFilter serializeFilter) {
        if (serializeFilter == null) {
            return;
        }
        int length = this.fastJsonConfig.getSerializeFilters().length;
        SerializeFilter[] serializeFilterArr = new SerializeFilter[length + 1];
        System.arraycopy(this.fastJsonConfig.getSerializeFilters(), 0, serializeFilterArr, 0, length);
        serializeFilterArr[length] = serializeFilter;
        this.fastJsonConfig.setSerializeFilters(serializeFilterArr);
    }

    public boolean canRead(Type type, Class<?> cls, MediaType mediaType) {
        return super.canRead(cls, mediaType);
    }

    public boolean canWrite(Type type, Class<?> cls, MediaType mediaType) {
        return super.canWrite(cls, mediaType);
    }

    @Deprecated
    public Charset getCharset() {
        return this.fastJsonConfig.getCharset();
    }

    @Deprecated
    public String getDateFormat() {
        return this.fastJsonConfig.getDateFormat();
    }

    public FastJsonConfig getFastJsonConfig() {
        return this.fastJsonConfig;
    }

    @Deprecated
    public SerializerFeature[] getFeatures() {
        return this.fastJsonConfig.getSerializerFeatures();
    }

    @Deprecated
    public SerializeFilter[] getFilters() {
        return this.fastJsonConfig.getSerializeFilters();
    }

    public Type getType(Type type, Class<?> cls) {
        if (Spring4TypeResolvableHelper.access$000()) {
            return Spring4TypeResolvableHelper.getType(type, cls);
        }
        return type;
    }

    public Object read(Type type, Class<?> cls, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return readType(getType(type, cls), httpInputMessage);
    }

    public Object readInternal(Class<?> cls, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return readType(getType(cls, null), httpInputMessage);
    }

    @Deprecated
    public void setCharset(Charset charset) {
        this.fastJsonConfig.setCharset(charset);
    }

    @Deprecated
    public void setDateFormat(String str) {
        this.fastJsonConfig.setDateFormat(str);
    }

    public void setFastJsonConfig(FastJsonConfig fastJsonConfig) {
        this.fastJsonConfig = fastJsonConfig;
    }

    @Deprecated
    public void setFeatures(SerializerFeature... serializerFeatureArr) {
        this.fastJsonConfig.setSerializerFeatures(serializerFeatureArr);
    }

    @Deprecated
    public void setFilters(SerializeFilter... serializeFilterArr) {
        this.fastJsonConfig.setSerializeFilters(serializeFilterArr);
    }

    public boolean supports(Class<?> cls) {
        return true;
    }

    public void write(Object obj, Type type, MediaType mediaType, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        super.write(obj, mediaType, httpOutputMessage);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0049, code lost:
    
        if (org.springframework.util.StringUtils.isEmpty(((com.alibaba.fastjson.support.spring.MappingFastJsonValue) r2).getJsonpFunction()) == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void writeInternal(java.lang.Object r13, org.springframework.http.HttpOutputMessage r14) throws java.io.IOException, org.springframework.http.converter.HttpMessageNotWritableException {
        /*
            r12 = this;
            java.io.ByteArrayOutputStream r8 = new java.io.ByteArrayOutputStream
            r8.<init>()
            org.springframework.http.HttpHeaders r9 = r14.getHeaders()     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
            com.alibaba.fastjson.support.config.FastJsonConfig r0 = r12.fastJsonConfig     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
            com.alibaba.fastjson.serializer.SerializeFilter[] r0 = r0.getSerializeFilters()     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
            java.util.List r0 = java.util.Arrays.asList(r0)     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
            java.lang.Object r13 = r12.strangeCodeForJackson(r13)     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
            boolean r0 = r13 instanceof com.alibaba.fastjson.support.spring.FastJsonContainer     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
            if (r0 == 0) goto L31
            com.alibaba.fastjson.support.spring.FastJsonContainer r13 = (com.alibaba.fastjson.support.spring.FastJsonContainer) r13     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
            com.alibaba.fastjson.support.spring.PropertyPreFilters r0 = r13.getFilters()     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
            java.util.List r0 = r0.getFilters()     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
            r1.addAll(r0)     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
            java.lang.Object r13 = r13.getValue()     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
        L31:
            r2 = r13
            goto L39
        L33:
            r13 = move-exception
            goto Lc5
        L36:
            r13 = move-exception
            goto Laa
        L39:
            boolean r13 = r2 instanceof com.alibaba.fastjson.support.spring.MappingFastJsonValue     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
            r10 = 1
            if (r13 == 0) goto L4d
            r13 = r2
            com.alibaba.fastjson.support.spring.MappingFastJsonValue r13 = (com.alibaba.fastjson.support.spring.MappingFastJsonValue) r13     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
            java.lang.String r13 = r13.getJsonpFunction()     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
            boolean r13 = org.springframework.util.StringUtils.isEmpty(r13)     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
            if (r13 != 0) goto L52
        L4b:
            r13 = 1
            goto L53
        L4d:
            boolean r13 = r2 instanceof com.alibaba.fastjson.JSONPObject     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
            if (r13 == 0) goto L52
            goto L4b
        L52:
            r13 = 0
        L53:
            com.alibaba.fastjson.support.config.FastJsonConfig r0 = r12.fastJsonConfig     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
            java.nio.charset.Charset r3 = r0.getCharset()     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
            com.alibaba.fastjson.support.config.FastJsonConfig r0 = r12.fastJsonConfig     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
            com.alibaba.fastjson.serializer.SerializeConfig r4 = r0.getSerializeConfig()     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
            int r0 = r1.size()     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
            com.alibaba.fastjson.serializer.SerializeFilter[] r0 = new com.alibaba.fastjson.serializer.SerializeFilter[r0]     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
            java.lang.Object[] r0 = r1.toArray(r0)     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
            r5 = r0
            com.alibaba.fastjson.serializer.SerializeFilter[] r5 = (com.alibaba.fastjson.serializer.SerializeFilter[]) r5     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
            com.alibaba.fastjson.support.config.FastJsonConfig r0 = r12.fastJsonConfig     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
            java.lang.String r6 = r0.getDateFormat()     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
            int r7 = com.alibaba.fastjson.JSON.DEFAULT_GENERATE_FEATURE     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
            com.alibaba.fastjson.support.config.FastJsonConfig r0 = r12.fastJsonConfig     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
            com.alibaba.fastjson.serializer.SerializerFeature[] r11 = r0.getSerializerFeatures()     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
            r0 = r8
            r1 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r11
            int r0 = com.alibaba.fastjson.JSON.writeJSONStringWithFastJsonConfig(r0, r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
            if (r13 == 0) goto L8c
            org.springframework.http.MediaType r13 = com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter.APPLICATION_JAVASCRIPT     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
            r9.setContentType(r13)     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
        L8c:
            com.alibaba.fastjson.support.config.FastJsonConfig r13 = r12.fastJsonConfig     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
            boolean r13 = r13.isWriteContentLength()     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
            if (r13 == 0) goto L9f
            boolean r13 = r12.setLengthError     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
            if (r13 != 0) goto L9f
            long r0 = (long) r0
            r9.setContentLength(r0)     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36 java.lang.UnsupportedOperationException -> L9d
            goto L9f
        L9d:
            r12.setLengthError = r10     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
        L9f:
            java.io.OutputStream r13 = r14.getBody()     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
            r8.writeTo(r13)     // Catch: java.lang.Throwable -> L33 com.alibaba.fastjson.JSONException -> L36
            r8.close()
            return
        Laa:
            org.springframework.http.converter.HttpMessageNotWritableException r14 = new org.springframework.http.converter.HttpMessageNotWritableException     // Catch: java.lang.Throwable -> L33
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L33
            r0.<init>()     // Catch: java.lang.Throwable -> L33
            java.lang.String r1 = "Could not write JSON: "
            r0.append(r1)     // Catch: java.lang.Throwable -> L33
            java.lang.String r1 = r13.getMessage()     // Catch: java.lang.Throwable -> L33
            r0.append(r1)     // Catch: java.lang.Throwable -> L33
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L33
            r14.<init>(r0, r13)     // Catch: java.lang.Throwable -> L33
            throw r14     // Catch: java.lang.Throwable -> L33
        Lc5:
            r8.close()
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter.writeInternal(java.lang.Object, org.springframework.http.HttpOutputMessage):void");
    }
}
