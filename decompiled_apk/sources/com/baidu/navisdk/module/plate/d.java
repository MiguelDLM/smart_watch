package com.baidu.navisdk.module.plate;

import android.text.TextUtils;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes7.dex */
public class d {
    public static String a(int i, String str) {
        int length;
        g gVar = g.CAR_PLATE;
        if (gVar.d()) {
            gVar.e("BNServiceMultiFlagUtil", "getMultiFlagByIndex: " + i + ", " + str);
        }
        if (i >= 0) {
            return (!TextUtils.isEmpty(str) && (length = (str.length() - i) + (-1)) >= 0) ? String.valueOf(str.charAt(length)) : "0";
        }
        throw new IllegalArgumentException("getMultiFlagByIndex bitIndex can not < 0");
    }

    public static String a(String str, int i, char c) {
        StringBuilder sb;
        g gVar = g.CAR_PLATE;
        if (gVar.d()) {
            gVar.e("BNServiceMultiFlagUtil", "addMultiFlag: " + str + ", " + i + ", " + c);
        }
        if (i >= 0) {
            int i2 = i + 1;
            if (TextUtils.isEmpty(str)) {
                sb = new StringBuilder(i2);
            } else {
                sb = new StringBuilder(str);
            }
            int length = sb.length();
            if (length < i2) {
                while (length < i2) {
                    sb.insert(0, '0');
                    length++;
                }
            }
            sb.setCharAt((sb.length() - i) - 1, c);
            return sb.toString();
        }
        throw new IllegalArgumentException("addMultiFlag bitIndex can not < 0 && addValue not null");
    }
}
