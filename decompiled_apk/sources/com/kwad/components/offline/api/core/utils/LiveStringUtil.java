package com.kwad.components.offline.api.core.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;

/* loaded from: classes11.dex */
public class LiveStringUtil {
    @NonNull
    public static String emptyIfNull(String str) {
        if (str != null) {
            return str;
        }
        return "";
    }

    public static boolean isEquals(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str.equals(str2)) {
            return true;
        }
        return false;
    }

    public static boolean isNullString(String str) {
        if (!TextUtils.isEmpty(str) && !"null".equalsIgnoreCase(str)) {
            return false;
        }
        return true;
    }
}
