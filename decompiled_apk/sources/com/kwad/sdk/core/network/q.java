package com.kwad.sdk.core.network;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes11.dex */
public class q {
    private static volatile q axF;
    private final Map<String, String> awm = new ConcurrentHashMap();

    private q() {
    }

    public static q EA() {
        if (axF == null) {
            synchronized (q.class) {
                try {
                    if (axF == null) {
                        axF = new q();
                    }
                } finally {
                }
            }
        }
        return axF;
    }

    public final void U(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.awm.put(str, str2);
        }
    }

    public final String dZ(String str) {
        return this.awm.get(str);
    }
}
