package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public class MapSerializer extends SerializeFilterable implements ObjectSerializer {
    public static MapSerializer instance = new MapSerializer();
    private static final int NON_STRINGKEY_AS_STRING = SerializerFeature.of(new SerializerFeature[]{SerializerFeature.BrowserCompatible, SerializerFeature.WriteNonStringKeyAsString, SerializerFeature.BrowserSecure});

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0255 A[Catch: all -> 0x0059, TryCatch #1 {all -> 0x0059, blocks: (B:19:0x0055, B:24:0x005c, B:26:0x0068, B:32:0x0083, B:33:0x0094, B:34:0x00a4, B:36:0x00aa, B:38:0x00bc, B:41:0x00c4, B:44:0x00c9, B:46:0x00d3, B:48:0x00d7, B:55:0x00e6, B:59:0x00f0, B:61:0x00f4, B:64:0x00fc, B:67:0x0101, B:69:0x010b, B:71:0x010f, B:75:0x011a, B:79:0x0124, B:81:0x0128, B:84:0x0130, B:87:0x0135, B:89:0x013f, B:91:0x0143, B:95:0x014e, B:99:0x0158, B:101:0x015c, B:104:0x0164, B:107:0x0169, B:109:0x0173, B:111:0x0177, B:115:0x0183, B:119:0x018e, B:121:0x0192, B:124:0x019a, B:127:0x019f, B:129:0x01a9, B:131:0x01ad, B:132:0x01b6, B:133:0x01bc, B:135:0x01c0, B:138:0x01c8, B:141:0x01cd, B:143:0x01d7, B:145:0x01db, B:146:0x01e5, B:149:0x01ee, B:151:0x01f9, B:153:0x01fd, B:155:0x0208, B:158:0x023d, B:161:0x024f, B:163:0x0255, B:165:0x025a, B:166:0x025d, B:168:0x0265, B:169:0x0268, B:171:0x0297, B:174:0x02a4, B:176:0x02ac, B:177:0x02b6, B:179:0x02be, B:181:0x02c2, B:183:0x02c6, B:185:0x02d1, B:186:0x02d7, B:189:0x02e5, B:192:0x026e, B:193:0x0271, B:195:0x0279, B:197:0x028d, B:198:0x0290, B:199:0x0281, B:201:0x0285, B:207:0x0228, B:219:0x007c), top: B:18:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0297 A[Catch: all -> 0x0059, TryCatch #1 {all -> 0x0059, blocks: (B:19:0x0055, B:24:0x005c, B:26:0x0068, B:32:0x0083, B:33:0x0094, B:34:0x00a4, B:36:0x00aa, B:38:0x00bc, B:41:0x00c4, B:44:0x00c9, B:46:0x00d3, B:48:0x00d7, B:55:0x00e6, B:59:0x00f0, B:61:0x00f4, B:64:0x00fc, B:67:0x0101, B:69:0x010b, B:71:0x010f, B:75:0x011a, B:79:0x0124, B:81:0x0128, B:84:0x0130, B:87:0x0135, B:89:0x013f, B:91:0x0143, B:95:0x014e, B:99:0x0158, B:101:0x015c, B:104:0x0164, B:107:0x0169, B:109:0x0173, B:111:0x0177, B:115:0x0183, B:119:0x018e, B:121:0x0192, B:124:0x019a, B:127:0x019f, B:129:0x01a9, B:131:0x01ad, B:132:0x01b6, B:133:0x01bc, B:135:0x01c0, B:138:0x01c8, B:141:0x01cd, B:143:0x01d7, B:145:0x01db, B:146:0x01e5, B:149:0x01ee, B:151:0x01f9, B:153:0x01fd, B:155:0x0208, B:158:0x023d, B:161:0x024f, B:163:0x0255, B:165:0x025a, B:166:0x025d, B:168:0x0265, B:169:0x0268, B:171:0x0297, B:174:0x02a4, B:176:0x02ac, B:177:0x02b6, B:179:0x02be, B:181:0x02c2, B:183:0x02c6, B:185:0x02d1, B:186:0x02d7, B:189:0x02e5, B:192:0x026e, B:193:0x0271, B:195:0x0279, B:197:0x028d, B:198:0x0290, B:199:0x0281, B:201:0x0285, B:207:0x0228, B:219:0x007c), top: B:18:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02a4 A[Catch: all -> 0x0059, TryCatch #1 {all -> 0x0059, blocks: (B:19:0x0055, B:24:0x005c, B:26:0x0068, B:32:0x0083, B:33:0x0094, B:34:0x00a4, B:36:0x00aa, B:38:0x00bc, B:41:0x00c4, B:44:0x00c9, B:46:0x00d3, B:48:0x00d7, B:55:0x00e6, B:59:0x00f0, B:61:0x00f4, B:64:0x00fc, B:67:0x0101, B:69:0x010b, B:71:0x010f, B:75:0x011a, B:79:0x0124, B:81:0x0128, B:84:0x0130, B:87:0x0135, B:89:0x013f, B:91:0x0143, B:95:0x014e, B:99:0x0158, B:101:0x015c, B:104:0x0164, B:107:0x0169, B:109:0x0173, B:111:0x0177, B:115:0x0183, B:119:0x018e, B:121:0x0192, B:124:0x019a, B:127:0x019f, B:129:0x01a9, B:131:0x01ad, B:132:0x01b6, B:133:0x01bc, B:135:0x01c0, B:138:0x01c8, B:141:0x01cd, B:143:0x01d7, B:145:0x01db, B:146:0x01e5, B:149:0x01ee, B:151:0x01f9, B:153:0x01fd, B:155:0x0208, B:158:0x023d, B:161:0x024f, B:163:0x0255, B:165:0x025a, B:166:0x025d, B:168:0x0265, B:169:0x0268, B:171:0x0297, B:174:0x02a4, B:176:0x02ac, B:177:0x02b6, B:179:0x02be, B:181:0x02c2, B:183:0x02c6, B:185:0x02d1, B:186:0x02d7, B:189:0x02e5, B:192:0x026e, B:193:0x0271, B:195:0x0279, B:197:0x028d, B:198:0x0290, B:199:0x0281, B:201:0x0285, B:207:0x0228, B:219:0x007c), top: B:18:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:217:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00aa A[Catch: all -> 0x0059, TryCatch #1 {all -> 0x0059, blocks: (B:19:0x0055, B:24:0x005c, B:26:0x0068, B:32:0x0083, B:33:0x0094, B:34:0x00a4, B:36:0x00aa, B:38:0x00bc, B:41:0x00c4, B:44:0x00c9, B:46:0x00d3, B:48:0x00d7, B:55:0x00e6, B:59:0x00f0, B:61:0x00f4, B:64:0x00fc, B:67:0x0101, B:69:0x010b, B:71:0x010f, B:75:0x011a, B:79:0x0124, B:81:0x0128, B:84:0x0130, B:87:0x0135, B:89:0x013f, B:91:0x0143, B:95:0x014e, B:99:0x0158, B:101:0x015c, B:104:0x0164, B:107:0x0169, B:109:0x0173, B:111:0x0177, B:115:0x0183, B:119:0x018e, B:121:0x0192, B:124:0x019a, B:127:0x019f, B:129:0x01a9, B:131:0x01ad, B:132:0x01b6, B:133:0x01bc, B:135:0x01c0, B:138:0x01c8, B:141:0x01cd, B:143:0x01d7, B:145:0x01db, B:146:0x01e5, B:149:0x01ee, B:151:0x01f9, B:153:0x01fd, B:155:0x0208, B:158:0x023d, B:161:0x024f, B:163:0x0255, B:165:0x025a, B:166:0x025d, B:168:0x0265, B:169:0x0268, B:171:0x0297, B:174:0x02a4, B:176:0x02ac, B:177:0x02b6, B:179:0x02be, B:181:0x02c2, B:183:0x02c6, B:185:0x02d1, B:186:0x02d7, B:189:0x02e5, B:192:0x026e, B:193:0x0271, B:195:0x0279, B:197:0x028d, B:198:0x0290, B:199:0x0281, B:201:0x0285, B:207:0x0228, B:219:0x007c), top: B:18:0x0055 }] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v7, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void write(com.alibaba.fastjson.serializer.JSONSerializer r24, java.lang.Object r25, java.lang.Object r26, java.lang.reflect.Type r27, int r28, boolean r29) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 791
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.MapSerializer.write(com.alibaba.fastjson.serializer.JSONSerializer, java.lang.Object, java.lang.Object, java.lang.reflect.Type, int, boolean):void");
    }
}
