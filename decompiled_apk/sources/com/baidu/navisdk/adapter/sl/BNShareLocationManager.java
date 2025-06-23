package com.baidu.navisdk.adapter.sl;

import android.os.Bundle;

/* loaded from: classes7.dex */
public class BNShareLocationManager {
    private static BNShareLocationManager sInstance;

    private BNShareLocationManager() {
    }

    public static BNShareLocationManager getInstance() {
        if (sInstance == null) {
            synchronized (BNShareLocationManager.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new BNShareLocationManager();
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
