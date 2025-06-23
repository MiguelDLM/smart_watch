package com.baidu.navisdk.preset.viaduct;

import com.baidu.navisdk.framework.b;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.Arrays;

/* loaded from: classes7.dex */
public final class a {
    public static int[] a() {
        int[] p = b.p();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("HwViaductManager", "getNavigationContextState state:" + Arrays.toString(p));
        }
        return p;
    }
}
