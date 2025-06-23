package com.alimm.tanx.core.utils;

import android.text.TextUtils;

public class StringUtil implements NotConfused {
    public static String filterNonPrintableCharacters(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (isPrintable(c)) {
                sb.append(c);
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        LogUtils.d("StringUtil耗时" + (currentTimeMillis2 - currentTimeMillis), new String[0]);
        return sb.toString();
    }

    public static boolean isNull(String str) {
        return TextUtils.isEmpty(str);
    }

    public static boolean isPrintable(char c) {
        if (Character.isISOControl(c) || Character.getType(c) == 0) {
            return false;
        }
        return true;
    }
}
