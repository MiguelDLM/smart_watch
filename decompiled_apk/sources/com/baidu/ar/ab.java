package com.baidu.ar;

import android.content.SharedPreferences;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class ab {
    private static int fA = 3;
    private static int fy = 1;
    private static int fz = 2;
    private Map<String, String> fB = new HashMap();
    private Map<String, String> fC = new HashMap();
    private SharedPreferences fD;

    public void a(SharedPreferences sharedPreferences) {
        this.fD = sharedPreferences;
    }

    public void clearARMemory() {
        this.fB.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String getValue(int r3, java.lang.String r4) {
        /*
            r2 = this;
            int r0 = com.baidu.ar.ab.fy
            java.lang.String r1 = ""
            if (r3 != r0) goto Lf
            java.util.Map<java.lang.String, java.lang.String> r3 = r2.fB
        L8:
            java.lang.Object r3 = r3.get(r4)
            java.lang.String r3 = (java.lang.String) r3
            goto L2b
        Lf:
            int r0 = com.baidu.ar.ab.fz
            if (r3 != r0) goto L16
            java.util.Map<java.lang.String, java.lang.String> r3 = r2.fC
            goto L8
        L16:
            int r0 = com.baidu.ar.ab.fA
            if (r3 != r0) goto L2a
            android.content.SharedPreferences r3 = r2.fD
            if (r3 == 0) goto L23
            java.lang.String r3 = r3.getString(r4, r1)
            goto L2b
        L23:
            java.lang.String r3 = "TAG"
            java.lang.String r4 = "prefs data store is null"
            android.util.Log.e(r3, r4)
        L2a:
            r3 = 0
        L2b:
            if (r3 != 0) goto L2e
            goto L2f
        L2e:
            r1 = r3
        L2f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ar.ab.getValue(int, java.lang.String):java.lang.String");
    }

    public void setValue(int i, String str, String str2) {
        Map<String, String> map;
        if (i == fy) {
            map = this.fB;
        } else {
            if (i != fz) {
                if (i == fA) {
                    SharedPreferences sharedPreferences = this.fD;
                    if (sharedPreferences != null) {
                        sharedPreferences.edit().putString(str, str2).commit();
                        return;
                    } else {
                        Log.e("TAG", "prefs data store is null");
                        return;
                    }
                }
                return;
            }
            map = this.fC;
        }
        map.put(str, str2);
    }
}
