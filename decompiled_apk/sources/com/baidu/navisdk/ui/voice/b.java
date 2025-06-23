package com.baidu.navisdk.ui.voice;

import android.text.TextUtils;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.framework.interfaces.c;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.voicesquare.interfaces.VoiceInterfaceImplProxy;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class b {
    public static List<String> a() {
        VoiceInterfaceImplProxy o = c.p().o();
        if (o == null) {
            return null;
        }
        o.getNewVoiceInfoIdsFromEng();
        return null;
    }

    public static boolean a(List<String> list) {
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
            }
        }
        boolean z = !TextUtils.equals(sb.toString(), BNSettingManager.getNewVoiceTaskIds());
        LogUtil.e("VoiceNewVoiceManager", "checkHasNewVoice() : engineTaskIds = " + ((Object) sb) + " savedIds =" + BNSettingManager.getNewVoiceTaskIds() + " hasNewVoice = " + z);
        BNSettingManager.setNewVoiceTaskIds(sb.toString());
        return z;
    }
}
