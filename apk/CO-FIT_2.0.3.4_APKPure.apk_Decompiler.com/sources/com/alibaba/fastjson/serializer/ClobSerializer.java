package com.alibaba.fastjson.serializer;

public class ClobSerializer implements ObjectSerializer {
    public static final ClobSerializer instance = new ClobSerializer();

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002d, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0035, code lost:
        throw new com.alibaba.fastjson.JSONException("read string from reader error", r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003e, code lost:
        throw new java.io.IOException("write clob error", r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0006, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:1:0x0002, B:8:0x0015] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void write(com.alibaba.fastjson.serializer.JSONSerializer r3, java.lang.Object r4, java.lang.Object r5, java.lang.reflect.Type r6, int r7) throws java.io.IOException {
        /*
            r2 = this;
            if (r4 != 0) goto L_0x0008
            r3.writeNull()     // Catch:{ SQLException -> 0x0006 }
            return
        L_0x0006:
            r3 = move-exception
            goto L_0x0036
        L_0x0008:
            java.sql.Clob r4 = (java.sql.Clob) r4     // Catch:{ SQLException -> 0x0006 }
            java.io.Reader r4 = r4.getCharacterStream()     // Catch:{ SQLException -> 0x0006 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ SQLException -> 0x0006 }
            r5.<init>()     // Catch:{ SQLException -> 0x0006 }
            r6 = 2048(0x800, float:2.87E-42)
            char[] r7 = new char[r6]     // Catch:{ Exception -> 0x002d }
        L_0x0017:
            r0 = 0
            int r1 = r4.read(r7, r0, r6)     // Catch:{ Exception -> 0x002d }
            if (r1 >= 0) goto L_0x0029
            java.lang.String r5 = r5.toString()     // Catch:{ SQLException -> 0x0006 }
            r4.close()     // Catch:{ SQLException -> 0x0006 }
            r3.write((java.lang.String) r5)     // Catch:{ SQLException -> 0x0006 }
            return
        L_0x0029:
            r5.append(r7, r0, r1)     // Catch:{ Exception -> 0x002d }
            goto L_0x0017
        L_0x002d:
            r3 = move-exception
            com.alibaba.fastjson.JSONException r4 = new com.alibaba.fastjson.JSONException     // Catch:{ SQLException -> 0x0006 }
            java.lang.String r5 = "read string from reader error"
            r4.<init>(r5, r3)     // Catch:{ SQLException -> 0x0006 }
            throw r4     // Catch:{ SQLException -> 0x0006 }
        L_0x0036:
            java.io.IOException r4 = new java.io.IOException
            java.lang.String r5 = "write clob error"
            r4.<init>(r5, r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.ClobSerializer.write(com.alibaba.fastjson.serializer.JSONSerializer, java.lang.Object, java.lang.Object, java.lang.reflect.Type, int):void");
    }
}
