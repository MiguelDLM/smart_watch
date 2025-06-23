package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.util.Arrays;

public class EnumDeserializer implements ObjectDeserializer {
    protected final Class<?> enumClass;
    protected long[] enumNameHashCodes;
    protected final Enum[] enums;
    protected final Enum[] ordinalEnums;

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00c1 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public EnumDeserializer(java.lang.Class<?> r22) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r21.<init>()
            r0.enumClass = r1
            java.lang.Object[] r2 = r22.getEnumConstants()
            java.lang.Enum[] r2 = (java.lang.Enum[]) r2
            r0.ordinalEnums = r2
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r4 = 0
        L_0x0017:
            java.lang.Enum[] r5 = r0.ordinalEnums
            int r6 = r5.length
            if (r4 >= r6) goto L_0x00c7
            r5 = r5[r4]
            java.lang.String r6 = r5.name()
            r7 = 0
            java.lang.reflect.Field r8 = r1.getField(r6)     // Catch:{ Exception -> 0x0040 }
            java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r9 = com.alibaba.fastjson.annotation.JSONField.class
            java.lang.annotation.Annotation r8 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.reflect.Field) r8, r9)     // Catch:{ Exception -> 0x0040 }
            com.alibaba.fastjson.annotation.JSONField r8 = (com.alibaba.fastjson.annotation.JSONField) r8     // Catch:{ Exception -> 0x0040 }
            if (r8 == 0) goto L_0x0041
            java.lang.String r7 = r8.name()     // Catch:{ Exception -> 0x003f }
            if (r7 == 0) goto L_0x0041
            int r9 = r7.length()     // Catch:{ Exception -> 0x003f }
            if (r9 <= 0) goto L_0x0041
            r6 = r7
            goto L_0x0041
        L_0x003f:
            r7 = r8
        L_0x0040:
            r8 = r7
        L_0x0041:
            r7 = 0
            r11 = -3750763034362895579(0xcbf29ce484222325, double:-7.302176725335867E57)
            r13 = -3750763034362895579(0xcbf29ce484222325, double:-7.302176725335867E57)
        L_0x004c:
            int r15 = r6.length()
            r16 = 1099511628211(0x100000001b3, double:5.43230922702E-312)
            if (r7 >= r15) goto L_0x0071
            char r15 = r6.charAt(r7)
            long r9 = (long) r15
            long r9 = r9 ^ r11
            r11 = 65
            if (r15 < r11) goto L_0x0067
            r11 = 90
            if (r15 > r11) goto L_0x0067
            int r15 = r15 + 32
        L_0x0067:
            long r11 = (long) r15
            long r11 = r11 ^ r13
            long r9 = r9 * r16
            long r13 = r11 * r16
            int r7 = r7 + 1
            r11 = r9
            goto L_0x004c
        L_0x0071:
            java.lang.Long r6 = java.lang.Long.valueOf(r11)
            r2.put(r6, r5)
            int r6 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r6 == 0) goto L_0x0083
            java.lang.Long r6 = java.lang.Long.valueOf(r13)
            r2.put(r6, r5)
        L_0x0083:
            if (r8 == 0) goto L_0x00c1
            java.lang.String[] r6 = r8.alternateNames()
            int r7 = r6.length
            r8 = 0
        L_0x008b:
            if (r8 >= r7) goto L_0x00c1
            r9 = r6[r8]
            r10 = 0
            r18 = -3750763034362895579(0xcbf29ce484222325, double:-7.302176725335867E57)
        L_0x0095:
            int r15 = r9.length()
            if (r10 >= r15) goto L_0x00ab
            char r15 = r9.charAt(r10)
            r20 = r4
            long r3 = (long) r15
            long r3 = r18 ^ r3
            long r18 = r3 * r16
            int r10 = r10 + 1
            r4 = r20
            goto L_0x0095
        L_0x00ab:
            r20 = r4
            int r3 = (r18 > r11 ? 1 : (r18 == r11 ? 0 : -1))
            if (r3 == 0) goto L_0x00bc
            int r3 = (r18 > r13 ? 1 : (r18 == r13 ? 0 : -1))
            if (r3 == 0) goto L_0x00bc
            java.lang.Long r3 = java.lang.Long.valueOf(r18)
            r2.put(r3, r5)
        L_0x00bc:
            int r8 = r8 + 1
            r4 = r20
            goto L_0x008b
        L_0x00c1:
            r20 = r4
            int r4 = r20 + 1
            goto L_0x0017
        L_0x00c7:
            int r1 = r2.size()
            long[] r1 = new long[r1]
            r0.enumNameHashCodes = r1
            java.util.Set r1 = r2.keySet()
            java.util.Iterator r1 = r1.iterator()
            r3 = 0
        L_0x00d8:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x00f0
            java.lang.Object r4 = r1.next()
            java.lang.Long r4 = (java.lang.Long) r4
            long[] r5 = r0.enumNameHashCodes
            int r6 = r3 + 1
            long r7 = r4.longValue()
            r5[r3] = r7
            r3 = r6
            goto L_0x00d8
        L_0x00f0:
            long[] r1 = r0.enumNameHashCodes
            java.util.Arrays.sort(r1)
            long[] r1 = r0.enumNameHashCodes
            int r1 = r1.length
            java.lang.Enum[] r1 = new java.lang.Enum[r1]
            r0.enums = r1
            r3 = 0
        L_0x00fd:
            long[] r1 = r0.enumNameHashCodes
            int r4 = r1.length
            if (r3 >= r4) goto L_0x0115
            r4 = r1[r3]
            java.lang.Long r1 = java.lang.Long.valueOf(r4)
            java.lang.Object r1 = r2.get(r1)
            java.lang.Enum r1 = (java.lang.Enum) r1
            java.lang.Enum[] r4 = r0.enums
            r4[r3] = r1
            int r3 = r3 + 1
            goto L_0x00fd
        L_0x0115:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.EnumDeserializer.<init>(java.lang.Class):void");
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        try {
            JSONLexer jSONLexer = defaultJSONParser.lexer;
            int i = jSONLexer.token();
            if (i == 2) {
                int intValue = jSONLexer.intValue();
                jSONLexer.nextToken(16);
                if (intValue >= 0) {
                    T[] tArr = this.ordinalEnums;
                    if (intValue < tArr.length) {
                        return tArr[intValue];
                    }
                }
                throw new JSONException("parse enum " + this.enumClass.getName() + " error, value : " + intValue);
            } else if (i == 4) {
                String stringVal = jSONLexer.stringVal();
                jSONLexer.nextToken(16);
                if (stringVal.length() == 0) {
                    return null;
                }
                long j = TypeUtils.fnv1a_64_magic_hashcode;
                long j2 = -3750763034362895579L;
                for (int i2 = 0; i2 < stringVal.length(); i2++) {
                    int charAt = stringVal.charAt(i2);
                    long j3 = j ^ ((long) charAt);
                    if (charAt >= 65 && charAt <= 90) {
                        charAt += 32;
                    }
                    j = j3 * TypeUtils.fnv1a_64_magic_prime;
                    j2 = (j2 ^ ((long) charAt)) * TypeUtils.fnv1a_64_magic_prime;
                }
                T enumByHashCode = getEnumByHashCode(j);
                if (enumByHashCode == null && j2 != j) {
                    enumByHashCode = getEnumByHashCode(j2);
                }
                if (enumByHashCode == null) {
                    if (jSONLexer.isEnabled(Feature.ErrorOnEnumNotMatch)) {
                        throw new JSONException("not match enum value, " + this.enumClass.getName() + " : " + stringVal);
                    }
                }
                return enumByHashCode;
            } else if (i == 8) {
                jSONLexer.nextToken(16);
                return null;
            } else {
                throw new JSONException("parse enum " + this.enumClass.getName() + " error, value : " + defaultJSONParser.parse());
            }
        } catch (JSONException e) {
            throw e;
        } catch (Exception e2) {
            throw new JSONException(e2.getMessage(), e2);
        }
    }

    public Enum getEnumByHashCode(long j) {
        int binarySearch;
        if (this.enums != null && (binarySearch = Arrays.binarySearch(this.enumNameHashCodes, j)) >= 0) {
            return this.enums[binarySearch];
        }
        return null;
    }

    public int getFastMatchToken() {
        return 2;
    }

    public Enum<?> valueOf(int i) {
        return this.ordinalEnums[i];
    }
}
