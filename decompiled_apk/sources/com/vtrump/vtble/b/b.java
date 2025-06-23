package com.vtrump.vtble.b;

import android.util.Log;

/* loaded from: classes13.dex */
public class b extends RuntimeException {
    public b(String str) {
        super(str);
        Log.e("NullScaleUserInfoExcept", "NullScaleDataException: " + str);
    }
}
