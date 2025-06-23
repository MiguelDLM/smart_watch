package com.tenmeter.smlibrary.utils;

import android.content.Context;
import java.util.LinkedHashMap;

/* loaded from: classes13.dex */
public class SMPlayerManagerFactory {
    public static final String FROM_ACTIVITY_BANNER = "FROM_ACTIVITY_BANNER";
    public static final String FROM_FRAGMENT_BANNER = "FROM_FRAGMENT_BANNER";
    private static final LinkedHashMap<String, SMPlayerManager> mPlayerManagers = new LinkedHashMap<>();

    public static SMPlayerManager factory(Context context, String str) {
        LinkedHashMap<String, SMPlayerManager> linkedHashMap = mPlayerManagers;
        if (linkedHashMap.get(str) == null) {
            synchronized (SMPlayerManagerFactory.class) {
                linkedHashMap.put(str, SMPlayerManager.getInstance(context));
            }
        }
        return linkedHashMap.get(str);
    }

    public static synchronized void release(String str) {
        synchronized (SMPlayerManagerFactory.class) {
            LinkedHashMap<String, SMPlayerManager> linkedHashMap = mPlayerManagers;
            if (linkedHashMap.get(str) != null) {
                linkedHashMap.remove(str);
            }
        }
    }

    public synchronized void releaseAll() {
        LinkedHashMap<String, SMPlayerManager> linkedHashMap = mPlayerManagers;
        if (!linkedHashMap.isEmpty()) {
            linkedHashMap.clear();
        }
    }
}
