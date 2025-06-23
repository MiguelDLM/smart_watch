package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class EnumCreatorDeserializer implements ObjectDeserializer {
    private final Method creator;
    private final Class paramType;

    public EnumCreatorDeserializer(Method method) {
        this.creator = method;
        this.paramType = method.getParameterTypes()[0];
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Object parseObject = defaultJSONParser.parseObject(this.paramType);
        try {
            return this.creator.invoke((Object) null, new Object[]{parseObject});
        } catch (IllegalAccessException e) {
            throw new JSONException("parse enum error", e);
        } catch (InvocationTargetException e2) {
            throw new JSONException("parse enum error", e2);
        }
    }

    public int getFastMatchToken() {
        return 0;
    }
}
