package com.baidu.platform.comapi.bmsdk.style;

/* loaded from: classes8.dex */
public class a {
    public static int a(int i) {
        int i2 = ((-16777216) & i) >> 24;
        int i3 = (65280 & i) >> 8;
        return ((i & 255) << 16) | (i2 << 24) | (i3 << 8) | ((16711680 & i) >> 16);
    }
}
