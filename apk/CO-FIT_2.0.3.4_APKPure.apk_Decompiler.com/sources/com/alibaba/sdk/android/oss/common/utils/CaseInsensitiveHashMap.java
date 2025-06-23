package com.alibaba.sdk.android.oss.common.utils;

import java.util.HashMap;

public class CaseInsensitiveHashMap<k, v> extends HashMap<k, v> {
    public v get(Object obj) {
        if (obj == null || containsKey(obj) || !(obj instanceof String)) {
            return super.get(obj);
        }
        String lowerCase = ((String) obj).toLowerCase();
        if (containsKey(lowerCase)) {
            return get(lowerCase);
        }
        return null;
    }
}
