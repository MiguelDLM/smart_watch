package com.realsil.sdk.core.bluetooth;

import android.annotation.TargetApi;
import android.content.Context;
import com.realsil.sdk.core.c.a;

@TargetApi(18)
/* loaded from: classes11.dex */
public final class GlobalGatt extends a {
    public static GlobalGatt n;

    public GlobalGatt(Context context) {
        super(context);
    }

    public static GlobalGatt getInstance() {
        return n;
    }

    public static synchronized void initial(Context context) {
        synchronized (GlobalGatt.class) {
            if (n == null) {
                synchronized (GlobalGatt.class) {
                    try {
                        if (n == null) {
                            n = new GlobalGatt(context.getApplicationContext());
                        }
                    } finally {
                    }
                }
            }
        }
    }
}
