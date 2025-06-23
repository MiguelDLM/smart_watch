package com.alibaba.fastjson.support.config;

import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ParseProcess;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.IOUtils;
import java.nio.charset.Charset;
import java.util.Map;

public class FastJsonConfig {
    private Charset charset = IOUtils.UTF8;
    private Map<Class<?>, SerializeFilter> classSerializeFilters;
    private String dateFormat;
    private Feature[] features = new Feature[0];
    private ParseProcess parseProcess;
    private ParserConfig parserConfig = ParserConfig.getGlobalInstance();
    private SerializeConfig serializeConfig = SerializeConfig.getGlobalInstance();
    private SerializeFilter[] serializeFilters = new SerializeFilter[0];
    private SerializerFeature[] serializerFeatures = {SerializerFeature.BrowserSecure};
    private boolean writeContentLength = true;

    public Charset getCharset() {
        return this.charset;
    }

    public Map<Class<?>, SerializeFilter> getClassSerializeFilters() {
        return this.classSerializeFilters;
    }

    public String getDateFormat() {
        return this.dateFormat;
    }

    public Feature[] getFeatures() {
        return this.features;
    }

    public ParseProcess getParseProcess() {
        return this.parseProcess;
    }

    public ParserConfig getParserConfig() {
        return this.parserConfig;
    }

    public SerializeConfig getSerializeConfig() {
        return this.serializeConfig;
    }

    public SerializeFilter[] getSerializeFilters() {
        return this.serializeFilters;
    }

    public SerializerFeature[] getSerializerFeatures() {
        return this.serializerFeatures;
    }

    public boolean isWriteContentLength() {
        return this.writeContentLength;
    }

    public void setCharset(Charset charset2) {
        this.charset = charset2;
    }

    public void setClassSerializeFilters(Map<Class<?>, SerializeFilter> map) {
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                this.serializeConfig.addFilter((Class) next.getKey(), (SerializeFilter) next.getValue());
            }
            this.classSerializeFilters = map;
        }
    }

    public void setDateFormat(String str) {
        this.dateFormat = str;
    }

    public void setFeatures(Feature... featureArr) {
        this.features = featureArr;
    }

    public void setParseProcess(ParseProcess parseProcess2) {
        this.parseProcess = parseProcess2;
    }

    public void setParserConfig(ParserConfig parserConfig2) {
        this.parserConfig = parserConfig2;
    }

    public void setSerializeConfig(SerializeConfig serializeConfig2) {
        this.serializeConfig = serializeConfig2;
    }

    public void setSerializeFilters(SerializeFilter... serializeFilterArr) {
        this.serializeFilters = serializeFilterArr;
    }

    public void setSerializerFeatures(SerializerFeature... serializerFeatureArr) {
        this.serializerFeatures = serializerFeatureArr;
    }

    public void setWriteContentLength(boolean z) {
        this.writeContentLength = z;
    }
}
