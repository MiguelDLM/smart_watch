package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigInteger;

public class BigIntegerCodec implements ObjectSerializer, ObjectDeserializer {
    private static final BigInteger HIGH = BigInteger.valueOf(9007199254740991L);
    private static final BigInteger LOW = BigInteger.valueOf(-9007199254740991L);
    public static final BigIntegerCodec instance = new BigIntegerCodec();

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return deserialze(defaultJSONParser);
    }

    public int getFastMatchToken() {
        return 2;
    }

    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull(SerializerFeature.WriteNullNumberAsZero);
            return;
        }
        BigInteger bigInteger = (BigInteger) obj;
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.length() < 16 || !SerializerFeature.isEnabled(i, serializeWriter.features, SerializerFeature.BrowserCompatible) || (bigInteger.compareTo(LOW) >= 0 && bigInteger.compareTo(HIGH) <= 0)) {
            serializeWriter.write(bigInteger2);
        } else {
            serializeWriter.writeString(bigInteger2);
        }
    }

    public static <T> T deserialze(DefaultJSONParser defaultJSONParser) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 2) {
            String numberString = jSONLexer.numberString();
            jSONLexer.nextToken(16);
            if (numberString.length() <= 65535) {
                return new BigInteger(numberString);
            }
            throw new JSONException("decimal overflow");
        }
        Object parse = defaultJSONParser.parse();
        if (parse == null) {
            return null;
        }
        return TypeUtils.castToBigInteger(parse);
    }
}
