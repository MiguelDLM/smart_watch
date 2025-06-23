package com.baidu.navisdk.module.asr.instructions;

import android.text.TextUtils;
import com.baidu.navisdk.asr.d;
import com.baidu.navisdk.asr.e;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.interfaces.asr.a;

/* loaded from: classes7.dex */
public class b {
    public static void a(String str) {
        a(str, (String) null);
    }

    public static com.baidu.navisdk.framework.interfaces.asr.a b(String str) {
        return a(str, false);
    }

    public static void a(String str, String str2) {
        a(str, str2, "0");
    }

    public static com.baidu.navisdk.framework.interfaces.asr.a b(String str, boolean z) {
        return new a.C0199a().c(true).e(true).a(str).a(z).d(z).b(com.baidu.navisdk.module.asr.c.b()).a();
    }

    public static void a(String str, String str2, String str3) {
        com.baidu.navisdk.util.statistic.userop.b.r().a(str, str2, str3, d.B().d() ? "1" : "0");
    }

    public static String a(boolean z, int i) {
        if (z) {
            return com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_avoid_traffic_no_route);
        }
        if (i == 2) {
            return com.baidu.navisdk.ui.util.b.h(R.string.asr_rg_route_refresh_more_fast_not_found);
        }
        if (i == 1) {
            return com.baidu.navisdk.ui.util.b.h(R.string.asr_rg_route_refresh_avoid_congestion_not_found);
        }
        if (i == 6) {
            return com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_avoid_traffic_no_route);
        }
        return null;
    }

    public static com.baidu.navisdk.framework.interfaces.asr.a a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            d.B().b();
            return null;
        }
        if (d.B().d() && !BNCommSettingManager.getInstance().isXDAwakened() && !BNCommSettingManager.getInstance().isVoiceBtnTipsPlayed()) {
            str = str + ",下次试试喊小度小度来跟我对话。";
            BNCommSettingManager.getInstance().setVoiceBtnTipsPlayed();
        }
        return e.a(str, z);
    }

    public static com.baidu.navisdk.framework.interfaces.asr.a a() {
        return e.a();
    }
}
