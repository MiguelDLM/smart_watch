package com.baidu.navisdk.ui.routeguide.module.diyspeak;

import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes8.dex */
public class k {
    public static boolean a(long j, int i) {
        return ((j >> i) & 1) == 0;
    }

    public static long b(long j, int i) {
        return j & (~(1 << i));
    }

    public static long c(long j, int i) {
        return j | (1 << i);
    }

    public static long a(long j, int i, String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            j = a(j, i + i2, str.charAt((length + (-1)) - i2) == '0' ? 0 : 1);
        }
        return j;
    }

    public static boolean b(long j, int i, String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        for (int i2 = length - 1; i2 >= 0; i2--) {
            sb.append((((int) j) >> (i + i2)) & 1);
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("DiySpeak", "isCmdSelected cmdStartPos = " + i + ", cmdValue = " + str + ", uiModeValue = " + j);
        }
        return sb.toString().equals(str);
    }

    public static long a(long j, int i, int i2) {
        if (i2 == 0) {
            return b(j, i);
        }
        return c(j, i);
    }
}
