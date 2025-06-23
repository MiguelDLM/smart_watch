package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import org.springframework.web.socket.sockjs.frame.AbstractSockJsMessageCodec;

public class FastjsonSockJsMessageCodec extends AbstractSockJsMessageCodec {
    public char[] applyJsonQuoting(String str) {
        SerializeWriter serializeWriter = new SerializeWriter();
        try {
            new JSONSerializer(serializeWriter).write(str);
            return serializeWriter.toCharArrayForSpringWebSocket();
        } finally {
            serializeWriter.close();
        }
    }

    public String[] decode(String str) throws IOException {
        return (String[]) JSON.parseObject(str, String[].class);
    }

    public String[] decodeInputStream(InputStream inputStream) throws IOException {
        return (String[]) JSON.parseObject(inputStream, (Type) String[].class, new Feature[0]);
    }
}
