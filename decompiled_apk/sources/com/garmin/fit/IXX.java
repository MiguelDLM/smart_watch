package com.garmin.fit;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class IXX {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final long f11664I0Io = Fit.f11230x0xO.longValue();

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final long f11665II0xO0 = 268435456;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final long f11666X0o0xo = 631065600000L;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final Map<Long, String> f11667oxoX;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public long f11668oIX0oI;

    static {
        HashMap hashMap = new HashMap();
        f11667oxoX = hashMap;
        hashMap.put(268435456L, "MIN");
    }

    public IXX(long j) {
        this.f11668oIX0oI = j;
    }

    public static Long XO(String str) {
        for (Map.Entry<Long, String> entry : f11667oxoX.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Long.valueOf(f11664I0Io);
    }

    public static String oxoX(Long l) {
        Map<Long, String> map = f11667oxoX;
        if (map.containsKey(l)) {
            return map.get(l);
        }
        return "";
    }

    public Date I0Io() {
        return new Date((this.f11668oIX0oI * 1000) + 631065600000L);
    }

    public boolean II0xO0(o0xxxXXxX o0xxxxxxx) {
        return X0o0xo().equals(o0xxxxxxx.x0xO0oo());
    }

    public Long X0o0xo() {
        return new Long(this.f11668oIX0oI);
    }

    public void oIX0oI(long j) {
        long j2 = this.f11668oIX0oI;
        if (j2 < 268435456) {
            this.f11668oIX0oI = j2 + j;
        }
    }

    public String toString() {
        return I0Io().toString();
    }

    public IXX(Date date) {
        this.f11668oIX0oI = (date.getTime() - 631065600000L) / 1000;
    }
}
