package com.alimm.tanx.core.web.cache.utils;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;

/* loaded from: classes.dex */
public class MimeTypeMapUtils {
    public static String getFileExtensionFromUrl(String str) {
        int lastIndexOf;
        String lowerCase = str.toLowerCase();
        if (!TextUtils.isEmpty(lowerCase)) {
            int lastIndexOf2 = lowerCase.lastIndexOf(35);
            if (lastIndexOf2 > 0) {
                lowerCase = lowerCase.substring(0, lastIndexOf2);
            }
            int lastIndexOf3 = lowerCase.lastIndexOf(63);
            if (lastIndexOf3 > 0) {
                lowerCase = lowerCase.substring(0, lastIndexOf3);
            }
            int lastIndexOf4 = lowerCase.lastIndexOf(47);
            if (lastIndexOf4 >= 0) {
                lowerCase = lowerCase.substring(lastIndexOf4 + 1);
            }
            if (!lowerCase.isEmpty() && (lastIndexOf = lowerCase.lastIndexOf(46)) >= 0) {
                return lowerCase.substring(lastIndexOf + 1);
            }
            return "";
        }
        return "";
    }

    public static String getMimeTypeFromExtension(String str) {
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
    }

    public static String getMimeTypeFromUrl(String str) {
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(getFileExtensionFromUrl(str));
    }
}
