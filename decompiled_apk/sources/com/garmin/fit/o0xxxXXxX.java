package com.garmin.fit;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class o0xxxXXxX implements Comparable<o0xxxXXxX> {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final long f14304IXxxXO = 268435456;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final long f14305Oxx0xo = Fit.f11230x0xO.longValue();

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final long f14306OxxIIOOXO = 631065600000L;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final Map<Long, String> f14307oI0IIXIo;

    /* renamed from: Oo, reason: collision with root package name */
    public double f14308Oo;

    /* renamed from: XO, reason: collision with root package name */
    public long f14309XO;

    static {
        HashMap hashMap = new HashMap();
        f14307oI0IIXIo = hashMap;
        hashMap.put(268435456L, "MIN");
    }

    public o0xxxXXxX(long j) {
        this.f14309XO = j;
        this.f14308Oo = XIXIX.OOXIXo.f3760XO;
    }

    public static Long Oo(String str) {
        for (Map.Entry<Long, String> entry : f14307oI0IIXIo.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Long.valueOf(f14305Oxx0xo);
    }

    public static String oO(Long l) {
        Map<Long, String> map = f14307oI0IIXIo;
        if (map.containsKey(l)) {
            return map.get(l);
        }
        return "";
    }

    public void I0Io(double d) {
        XO(new o0xxxXXxX(0L, d));
    }

    public boolean II0XooXoX(o0xxxXXxX o0xxxxxxx) {
        if (compareTo(o0xxxxxxx) < 0) {
            return true;
        }
        return false;
    }

    public void OOXIXo(long j) {
        long j2 = this.f14309XO;
        if (j2 < 268435456) {
            this.f14309XO = j2 + j;
        }
    }

    public boolean Oxx0IOOO(o0xxxXXxX o0xxxxxxx) {
        if (compareTo(o0xxxxxxx) > 0) {
            return true;
        }
        return false;
    }

    public void XO(o0xxxXXxX o0xxxxxxx) {
        this.f14309XO += o0xxxxxxx.x0xO0oo().longValue();
        double doubleValue = this.f14308Oo + o0xxxxxxx.x0XOIxOo().doubleValue();
        this.f14308Oo = doubleValue;
        this.f14309XO += (long) Math.floor(doubleValue);
        this.f14308Oo = this.f14308Oo - ((float) Math.floor(r0));
    }

    public boolean oOoXoXO(o0xxxXXxX o0xxxxxxx) {
        if (x0xO0oo().equals(o0xxxxxxx.x0xO0oo()) && x0XOIxOo().equals(o0xxxxxxx.x0XOIxOo())) {
            return true;
        }
        return false;
    }

    public Date ooOOo0oXI() {
        return new Date((this.f14309XO * 1000) + Math.round(this.f14308Oo * 1000.0d) + 631065600000L);
    }

    public void oxoX(long j) {
        XO(new o0xxxXXxX(j));
    }

    public String toString() {
        return ooOOo0oXI().toString();
    }

    public Double x0XOIxOo() {
        return new Double(this.f14308Oo);
    }

    public Long x0xO0oo() {
        return new Long(this.f14309XO);
    }

    @Override // java.lang.Comparable
    /* renamed from: xoIox, reason: merged with bridge method [inline-methods] */
    public int compareTo(o0xxxXXxX o0xxxxxxx) {
        if (this.f14309XO == o0xxxxxxx.x0xO0oo().longValue()) {
            return Double.compare(this.f14308Oo, o0xxxxxxx.x0XOIxOo().doubleValue());
        }
        if (this.f14309XO > o0xxxxxxx.x0xO0oo().longValue()) {
            return 1;
        }
        return -1;
    }

    public o0xxxXXxX(Date date) {
        this.f14309XO = (date.getTime() - 631065600000L) / 1000;
        this.f14308Oo = ((date.getTime() - 631065600000L) % 1000) / 1000.0d;
    }

    public o0xxxXXxX(o0xxxXXxX o0xxxxxxx) {
        this(o0xxxxxxx.x0xO0oo().longValue(), o0xxxxxxx.x0XOIxOo().doubleValue());
    }

    public o0xxxXXxX(long j, double d) {
        this.f14309XO = j + ((long) Math.floor(d));
        this.f14308Oo = d - Math.floor(d);
    }
}
