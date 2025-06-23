package com.vtrump.vtble;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes13.dex */
public class xXxxox0I {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static xXxxox0I f27551II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Map<String, Double> f27552oIX0oI = new HashMap();

    public static xXxxox0I oIX0oI() {
        if (f27551II0xO0 == null) {
            f27551II0xO0 = new xXxxox0I();
        }
        return f27551II0xO0;
    }

    public boolean I0Io(String str, double d) {
        if (this.f27552oIX0oI == null) {
            this.f27552oIX0oI = new HashMap();
        }
        double doubleValue = this.f27552oIX0oI.containsKey(str) ? this.f27552oIX0oI.get(str).doubleValue() : -1.0d;
        Oxx0xo.I0Io("TAG", "lockAdvScale:cashWeight " + doubleValue + ",weight " + d);
        if (d == doubleValue) {
            return true;
        }
        this.f27552oIX0oI.put(str, Double.valueOf(d));
        return false;
    }

    public void II0xO0(String str) {
        Map<String, Double> map = this.f27552oIX0oI;
        if (map != null) {
            map.put(str, Double.valueOf(-10.0d));
        }
    }

    public void oxoX() {
        this.f27552oIX0oI.clear();
        Oxx0xo.I0Io("", "lock clear");
    }
}
