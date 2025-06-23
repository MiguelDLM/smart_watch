package com.baidu.navisdk.module.asr;

import android.text.TextUtils;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.framework.interfaces.asr.a;

/* loaded from: classes7.dex */
public class f {
    public static com.baidu.navisdk.framework.interfaces.asr.a a(String str) {
        if (TextUtils.isEmpty(str)) {
            a.b().a();
            return null;
        }
        if (com.baidu.navisdk.asr.d.B().d() && !BNCommSettingManager.getInstance().isXDAwakened() && !BNCommSettingManager.getInstance().isVoiceBtnTipsPlayed()) {
            str = str + ",下次试试喊小度小度来跟我对话。";
            BNCommSettingManager.getInstance().setVoiceBtnTipsPlayed();
        }
        return new a.C0199a().c(false).e(true).a(str).a();
    }
}
