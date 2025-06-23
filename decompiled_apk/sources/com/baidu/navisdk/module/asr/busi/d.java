package com.baidu.navisdk.module.asr.busi;

import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes7.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f7031a = false;

    public static boolean a() {
        return f7031a;
    }

    public static void b(boolean z) {
        f7031a = z;
    }

    public static void a(boolean z) {
        String string;
        if (z) {
            string = JarUtils.getResources().getString(R.string.nav_voice_delete_all_via_success, ((com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel")).g().mName);
        } else {
            string = JarUtils.getResources().getString(R.string.nav_voice_delete_all_via_fail);
        }
        TTSPlayerControl.playXDTTSText(string, 1);
    }
}
