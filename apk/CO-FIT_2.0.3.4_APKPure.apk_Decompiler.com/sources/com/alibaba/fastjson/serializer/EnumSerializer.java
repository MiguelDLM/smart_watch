package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class EnumSerializer implements ObjectSerializer {
    public static final EnumSerializer instance = new EnumSerializer();
    private final Member member;

    public EnumSerializer() {
        this.member = null;
    }

    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        Object obj3;
        Member member2 = this.member;
        if (member2 == null) {
            jSONSerializer.out.writeEnum((Enum) obj);
            return;
        }
        try {
            if (member2 instanceof Field) {
                obj3 = ((Field) member2).get(obj);
            } else {
                obj3 = ((Method) member2).invoke(obj, (Object[]) null);
            }
            jSONSerializer.write(obj3);
        } catch (Exception e) {
            throw new JSONException("getEnumValue error", e);
        }
    }

    public EnumSerializer(Member member2) {
        this.member = member2;
    }
}
