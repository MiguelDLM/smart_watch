package com.baidu.ar;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class nc {
    private static Map<String, String> He = new HashMap();
    private static long Hf;

    public static void iF() {
        Hf = System.currentTimeMillis();
        He.clear();
    }

    public static void iG() {
        He.put("time1", String.valueOf(Math.abs(System.currentTimeMillis() - Hf) / 1000.0d));
    }

    public static void iH() {
        He.put("time2", String.valueOf(Math.abs(System.currentTimeMillis() - Hf) / 1000.0d));
    }

    public static void iI() {
        He.put("time3", String.valueOf(Math.abs(System.currentTimeMillis() - Hf) / 1000.0d));
    }

    public static void iJ() {
        He.put("time4", String.valueOf(Math.abs(System.currentTimeMillis() - Hf) / 1000.0d));
    }

    public static void iK() {
        He.put("time5", String.valueOf(Math.abs(System.currentTimeMillis() - Hf) / 1000.0d));
    }

    public static Map<String, String> iL() {
        return He;
    }
}
