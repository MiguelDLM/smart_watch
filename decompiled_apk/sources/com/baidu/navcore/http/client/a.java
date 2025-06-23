package com.baidu.navcore.http.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/* loaded from: classes7.dex */
public class a {
    public static String a(String str, Map<String, String> map, Map<String, String> map2) throws IOException {
        HashMap hashMap = new HashMap();
        if (!map2.isEmpty()) {
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                linkedHashSet.add(value);
                hashMap.put(key, linkedHashSet);
            }
        }
        return b(str, map, hashMap);
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x020b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String b(java.lang.String r17, java.util.Map<java.lang.String, java.lang.String> r18, java.util.Map<java.lang.String, java.util.LinkedHashSet<java.lang.String>> r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 527
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navcore.http.client.a.b(java.lang.String, java.util.Map, java.util.Map):java.lang.String");
    }
}
