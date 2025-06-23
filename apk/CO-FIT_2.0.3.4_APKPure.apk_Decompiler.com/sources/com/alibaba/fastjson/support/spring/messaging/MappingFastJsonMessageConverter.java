package com.alibaba.fastjson.support.spring.messaging;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.google.android.exoplayer2.util.MimeTypes;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.converter.AbstractMessageConverter;
import org.springframework.util.MimeType;

public class MappingFastJsonMessageConverter extends AbstractMessageConverter {
    private FastJsonConfig fastJsonConfig = new FastJsonConfig();

    public MappingFastJsonMessageConverter() {
        super(new MimeType(MimeTypes.BASE_TYPE_APPLICATION, "json", Charset.forName("UTF-8")));
    }

    public boolean canConvertFrom(Message<?> message, Class<?> cls) {
        return supports(cls);
    }

    public boolean canConvertTo(Object obj, MessageHeaders messageHeaders) {
        return supports(obj.getClass());
    }

    public Object convertFromInternal(Message<?> message, Class<?> cls, Object obj) {
        Object payload = message.getPayload();
        if (payload instanceof byte[]) {
            return JSON.parseObject((byte[]) payload, this.fastJsonConfig.getCharset(), (Type) cls, this.fastJsonConfig.getParserConfig(), this.fastJsonConfig.getParseProcess(), JSON.DEFAULT_PARSER_FEATURE, this.fastJsonConfig.getFeatures());
        } else if (!(payload instanceof String)) {
            return null;
        } else {
            return JSON.parseObject((String) payload, (Type) cls, this.fastJsonConfig.getParserConfig(), this.fastJsonConfig.getParseProcess(), JSON.DEFAULT_PARSER_FEATURE, this.fastJsonConfig.getFeatures());
        }
    }

    public Object convertToInternal(Object obj, MessageHeaders messageHeaders, Object obj2) {
        if (byte[].class == getSerializedPayloadClass()) {
            if (obj instanceof String) {
                String str = (String) obj;
                if (JSON.isValid(str)) {
                    return str.getBytes(this.fastJsonConfig.getCharset());
                }
            }
            return JSON.toJSONBytesWithFastJsonConfig(this.fastJsonConfig.getCharset(), obj, this.fastJsonConfig.getSerializeConfig(), this.fastJsonConfig.getSerializeFilters(), this.fastJsonConfig.getDateFormat(), JSON.DEFAULT_GENERATE_FEATURE, this.fastJsonConfig.getSerializerFeatures());
        } else if ((obj instanceof String) && JSON.isValid((String) obj)) {
            return obj;
        } else {
            return JSON.toJSONString(obj, this.fastJsonConfig.getSerializeConfig(), this.fastJsonConfig.getSerializeFilters(), this.fastJsonConfig.getDateFormat(), JSON.DEFAULT_GENERATE_FEATURE, this.fastJsonConfig.getSerializerFeatures());
        }
    }

    public FastJsonConfig getFastJsonConfig() {
        return this.fastJsonConfig;
    }

    public void setFastJsonConfig(FastJsonConfig fastJsonConfig2) {
        this.fastJsonConfig = fastJsonConfig2;
    }

    public boolean supports(Class<?> cls) {
        return true;
    }
}
