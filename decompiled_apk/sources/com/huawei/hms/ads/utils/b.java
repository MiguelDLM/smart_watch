package com.huawei.hms.ads.utils;

/* loaded from: classes10.dex */
public class b {
    public static int Code(int i) {
        if (i == -4 || i == 804) {
            return 1;
        }
        if (i == -1 || i == -2) {
            return 2;
        }
        if (i == 204 || i == 700 || i == 800 || i == 900 || i == -3 || i == 498 || i == 494) {
            return 3;
        }
        if (i == 1001) {
            return 5;
        }
        if (i == 701 || i == 801 || i == 901) {
            return 4;
        }
        if (i == 704) {
            return 6;
        }
        if (i == 705) {
            return 7;
        }
        return i == 706 ? 8 : 0;
    }
}
