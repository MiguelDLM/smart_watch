package com.baidu.navisdk.util.statistic;

/* loaded from: classes8.dex */
public class q {
    public static void a(int i, String str, long j) {
        a(i, str, j, true);
    }

    public static void a(int i, String str, long j, boolean z) {
        if (str == null || str.length() == 0) {
            return;
        }
        if (z || !p.f9380a.containsKey(str)) {
            p.f9380a.put(str, Long.valueOf(j));
        }
    }

    public static long a(String str) {
        Long l;
        if (str == null || !p.f9380a.containsKey(str) || (l = p.f9380a.get(str)) == null) {
            return 0L;
        }
        return l.longValue();
    }
}
