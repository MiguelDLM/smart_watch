package com.baidu.navisdk.adapter.sl;

import android.os.Bundle;

/* loaded from: classes7.dex */
public class BNCarPoolManager {
    private static BNCarPoolManager sInstance;

    private BNCarPoolManager() {
    }

    public static BNCarPoolManager getInstance() {
        if (sInstance == null) {
            synchronized (BNCarPoolManager.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new BNCarPoolManager();
                    }
                } finally {
                }
            }
        }
        return sInstance;
    }

    public void onCommonMessageCallback(Integer num, Integer num2, Integer num3, Bundle bundle) {
    }
}
