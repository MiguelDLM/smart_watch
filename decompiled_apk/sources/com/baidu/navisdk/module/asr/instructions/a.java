package com.baidu.navisdk.module.asr.instructions;

import android.text.TextUtils;
import com.baidu.navisdk.asr.d;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.util.common.x;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static a f7038a;

    private a() {
    }

    public static a a() {
        if (f7038a == null) {
            f7038a = new a();
        }
        return f7038a;
    }

    public void a(String str) {
        d.B().c(true);
        d.B().b(true);
        x.a(true);
        if (TextUtils.equals(str, "scene_xd_power_save_wakeup_guide_high")) {
            BNSettingManager.setCloseAsrWakeUpPowerSave(true);
        }
    }
}
