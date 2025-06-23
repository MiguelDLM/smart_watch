package com.realsil.sdk.dfu.b;

/* loaded from: classes11.dex */
public class h {
    public static int a(int i, int i2, int i3) {
        if (i2 <= 0) {
            return i;
        }
        if (i3 == 1) {
            return (i >> 24) & 255;
        }
        if (i3 == 515) {
            return (i & 255) | ((i >> 8) & 255);
        }
        if (i3 == 2) {
            return i & 255;
        }
        if (i3 == 3) {
            return (i >> 27) & 31;
        }
        if (i3 == 5) {
            return (i >> 21) & 2047;
        }
        if (i3 == 4 || i3 == 7 || i3 != 514) {
            return i;
        }
        return (i & 255) | ((i >> 8) & 255);
    }
}
