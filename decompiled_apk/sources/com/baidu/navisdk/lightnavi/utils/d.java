package com.baidu.navisdk.lightnavi.utils;

import android.content.Context;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.lightnavi.controller.f;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes7.dex */
public class d {
    @Deprecated
    public static int a() {
        return c() + b();
    }

    public static final int b() {
        return ScreenUtil.getInstance().getStatusBarHeight(f.n().b());
    }

    public static int c() {
        return JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_54dp);
    }

    public static int a(Context context) {
        if (com.baidu.navisdk.util.common.c.c()) {
            return a();
        }
        return c();
    }

    public static int a(boolean z) {
        return JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_light_navi_map_bottom_margin);
    }
}
