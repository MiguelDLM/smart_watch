package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.Type;

public class CharArrayCodec implements ObjectDeserializer {
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return deserialze(defaultJSONParser);
    }

    public int getFastMatchToken() {
        return 4;
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [T, char[]] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser r5) {
        /*
            com.alibaba.fastjson.parser.JSONLexer r0 = r5.lexer
            int r1 = r0.token()
            r2 = 4
            r3 = 16
            if (r1 != r2) goto L_0x0017
            java.lang.String r5 = r0.stringVal()
            r0.nextToken(r3)
            char[] r5 = r5.toCharArray()
            return r5
        L_0x0017:
            int r1 = r0.token()
            r2 = 2
            if (r1 != r2) goto L_0x002e
            java.lang.Number r5 = r0.integerValue()
            r0.nextToken(r3)
            java.lang.String r5 = r5.toString()
            char[] r5 = r5.toCharArray()
            return r5
        L_0x002e:
            java.lang.Object r5 = r5.parse()
            boolean r0 = r5 instanceof java.lang.String
            if (r0 == 0) goto L_0x003d
            java.lang.String r5 = (java.lang.String) r5
            char[] r5 = r5.toCharArray()
            return r5
        L_0x003d:
            boolean r0 = r5 instanceof java.util.Collection
            if (r0 == 0) goto L_0x008a
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r0 = r5.iterator()
        L_0x0047:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0067
            java.lang.Object r1 = r0.next()
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L_0x0047
            java.lang.String r1 = (java.lang.String) r1
            int r1 = r1.length()
            r2 = 1
            if (r1 != r2) goto L_0x005f
            goto L_0x0047
        L_0x005f:
            com.alibaba.fastjson.JSONException r5 = new com.alibaba.fastjson.JSONException
            java.lang.String r0 = "can not cast to char[]"
            r5.<init>(r0)
            throw r5
        L_0x0067:
            int r0 = r5.size()
            char[] r0 = new char[r0]
            java.util.Iterator r5 = r5.iterator()
            r1 = 0
            r2 = 0
        L_0x0073:
            boolean r3 = r5.hasNext()
            if (r3 == 0) goto L_0x0089
            java.lang.Object r3 = r5.next()
            int r4 = r2 + 1
            java.lang.String r3 = (java.lang.String) r3
            char r3 = r3.charAt(r1)
            r0[r2] = r3
            r2 = r4
            goto L_0x0073
        L_0x0089:
            return r0
        L_0x008a:
            if (r5 != 0) goto L_0x008e
            r5 = 0
            goto L_0x0096
        L_0x008e:
            java.lang.String r5 = com.alibaba.fastjson.JSON.toJSONString(r5)
            char[] r5 = r5.toCharArray()
        L_0x0096:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.CharArrayCodec.deserialze(com.alibaba.fastjson.parser.DefaultJSONParser):java.lang.Object");
    }
}
