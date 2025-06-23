package com.google.maps.android.data.kml;

/* loaded from: classes10.dex */
public class KmlBoolean {
    public static boolean parseBoolean(String str) {
        if (!"1".equals(str) && !"true".equals(str)) {
            return false;
        }
        return true;
    }
}
