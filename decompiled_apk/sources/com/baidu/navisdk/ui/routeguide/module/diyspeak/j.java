package com.baidu.navisdk.ui.routeguide.module.diyspeak;

import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class j {
    public static String a() {
        e eVar = e.f;
        if (eVar != null && eVar.e()) {
            return JarUtils.getResources().getString(R.string.nsdk_string_diy_speak_subtitle_enabled);
        }
        return JarUtils.getResources().getString(R.string.nsdk_string_diy_speak_subtitle_disabled);
    }

    public static String b() {
        e eVar = e.f;
        int a2 = eVar.a(true);
        if (a2 != 0) {
            if (a2 != 1) {
                if (a2 != 6) {
                    if (a2 != 7) {
                        return "";
                    }
                    return JarUtils.getResources().getString(R.string.nsdk_diy_speak_items_detail);
                }
                return JarUtils.getResources().getString(R.string.nsdk_diy_speak_items_user_define);
            }
            return JarUtils.getResources().getString(R.string.nsdk_diy_speak_items_simple);
        }
        if (eVar.e()) {
            return JarUtils.getResources().getString(R.string.nsdk_diy_speak_items_standard);
        }
        return JarUtils.getResources().getString(R.string.nsdk_diy_speak_items_detail);
    }
}
