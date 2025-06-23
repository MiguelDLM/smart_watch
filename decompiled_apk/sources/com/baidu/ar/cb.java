package com.baidu.ar;

import android.util.Log;

/* loaded from: classes7.dex */
public class cb {
    private static int lV;

    public static void clear() {
        Log.e("ResLoadMachine", "machine：reset");
        o(0);
    }

    public static boolean cp() {
        int i = lV;
        boolean z = i == 2 || i == 0;
        if (z) {
            Log.e("ResLoadMachine", "machine：!!!!!! can query.");
        }
        return z;
    }

    public static void o(int i) {
        String str;
        lV = i;
        if (i == 0) {
            str = "machine：init";
        } else if (i == 1) {
            str = "machine：query";
        } else if (i != 2) {
            return;
        } else {
            str = "machine：engine is load finish!";
        }
        Log.e("ResLoadMachine", str);
    }
}
