package com.baidu.navisdk.lightnavi.asr.busi;

import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.util.b;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f6871a = false;

    public static void a() {
        TTSPlayerControl.playXDTTSText(b.h(R.string.asr_rg_switch_route_success), 1);
    }

    public static boolean b() {
        return f6871a;
    }

    public static void a(boolean z) {
        f6871a = z;
    }
}
