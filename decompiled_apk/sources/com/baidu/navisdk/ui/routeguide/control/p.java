package com.baidu.navisdk.ui.routeguide.control;

import android.app.Activity;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;

/* loaded from: classes8.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private static p f8577a;
    private static Object b = new Object();

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a(p pVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            s.T().a(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_rp_build_fail), false);
        }
    }

    public static p b() {
        if (f8577a == null) {
            synchronized (b) {
                try {
                    if (f8577a == null) {
                        f8577a = new p();
                    }
                } finally {
                }
            }
        }
        return f8577a;
    }

    public void a(int i) {
        com.baidu.navisdk.framework.interfaces.k k = com.baidu.navisdk.framework.interfaces.c.p().k();
        if (k != null) {
            k.k0();
        }
        int voiceMode = BNCommSettingManager.getInstance().getVoiceMode();
        if (2 == voiceMode || 3 == voiceMode) {
            return;
        }
        if (i == 1) {
            TTSPlayerControl.playTTS("已为您切换至主路", 1);
            return;
        }
        if (i == 2) {
            TTSPlayerControl.playTTS("已为您切换至辅路", 1);
        } else if (i == 3) {
            TTSPlayerControl.playTTS("已为您切换至桥上", 1);
        } else if (i == 4) {
            TTSPlayerControl.playTTS("已为您切换至桥下", 1);
        }
    }

    public void a() {
        com.baidu.navisdk.framework.interfaces.k k = com.baidu.navisdk.framework.interfaces.c.p().k();
        if (k != null) {
            k.g();
        }
        Activity b2 = com.baidu.navisdk.ui.routeguide.b.V().b();
        if (b2 != null) {
            b2.runOnUiThread(new a(this));
        }
    }
}
