package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;

public class BigDecimalCodec implements ObjectSerializer, ObjectDeserializer {
    static final BigDecimal HIGH = BigDecimal.valueOf(9007199254740991L);
    static final BigDecimal LOW = BigDecimal.valueOf(-9007199254740991L);
    public static final BigDecimalCodec instance = new BigDecimalCodec();

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        try {
            return deserialze(defaultJSONParser);
        } catch (Exception e) {
            throw new JSONException("parseDecimal error, field : " + obj, e);
        }
    }

    public int getFastMatchToken() {
        return 2;
    }

    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        String str;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull(SerializerFeature.WriteNullNumberAsZero);
            return;
        }
        BigDecimal bigDecimal = (BigDecimal) obj;
        int scale = bigDecimal.scale();
        if (!SerializerFeature.isEnabled(i, serializeWriter.features, SerializerFeature.WriteBigDecimalAsPlain) || scale < -100 || scale >= 100) {
            str = bigDecimal.toString();
        } else {
            str = bigDecimal.toPlainString();
        }
        if (scale != 0 || str.length() < 16 || !SerializerFeature.isEnabled(i, serializeWriter.features, SerializerFeature.BrowserCompatible) || (bigDecimal.compareTo(LOW) >= 0 && bigDecimal.compareTo(HIGH) <= 0)) {
            serializeWriter.write(str);
            if (serializeWriter.isEnabled(SerializerFeature.WriteClassName) && type != BigDecimal.class && bigDecimal.scale() == 0) {
                serializeWriter.write(46);
                return;
            }
            return;
        }
        serializeWriter.writeString(str);
    }

    public static <T> T deserialze(DefaultJSONParser defaultJSONParser) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 2) {
            T decimalValue = jSONLexer.decimalValue();
            jSONLexer.nextToken(16);
            return decimalValue;
        } else if (jSONLexer.token() == 3) {
            T decimalValue2 = jSONLexer.decimalValue();
            jSONLexer.nextToken(16);
            return decimalValue2;
        } else {
            Object parse = defaultJSONParser.parse();
            if (parse == null) {
                return null;
            }
            return TypeUtils.castToBigDecimal(parse);
        }
    }
}
