package com.baidu.navcore.tts;

import android.content.Context;
import com.baidu.navisdk.comapi.setting.SettingParams;
import com.baidu.navisdk.j;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.e0;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes7.dex */
public class BNVoiceDelegate$SP {
    public static final String TAG = "BNVoiceDelegate-SP";
    private static BNVoiceDelegate$SP mInstance;
    private static e0 mPreferenceHelper;

    private BNVoiceDelegate$SP() {
    }

    public static BNVoiceDelegate$SP getInstance() {
        if (mInstance == null) {
            synchronized (BNVoiceDelegate$SP.class) {
                try {
                    if (mInstance == null) {
                        mInstance = new BNVoiceDelegate$SP();
                        if (mPreferenceHelper == null) {
                            init(com.baidu.navisdk.framework.a.c().a());
                        }
                    }
                } finally {
                }
            }
        }
        if (mPreferenceHelper == null && LogUtil.LOGGABLE) {
            g.VOICE_PAGE.a("BNVoiceSettngManager，PrefreHelper还没初始化就调用了", new Throwable());
        }
        return mInstance;
    }

    public static String getTTSVocoderParam() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return "0";
        }
        return e0Var.a(SettingParams.Key.NAVI_TTS_VOCODER, "0");
    }

    public static void init(Context context) {
        if (context == null) {
            g gVar = g.VOICE_PAGE;
            if (gVar.c()) {
                gVar.c(TAG, "init context = null");
                return;
            }
            return;
        }
        if (mPreferenceHelper == null) {
            synchronized (BNVoiceDelegate$SP.class) {
                try {
                    if (mPreferenceHelper == null) {
                        mPreferenceHelper = e0.a(context);
                    }
                } finally {
                }
            }
        }
    }

    public boolean getAutoSwitchJinShaTTS() {
        e0 e0Var;
        if (!j.d() || (e0Var = mPreferenceHelper) == null) {
            return true;
        }
        return e0Var.a("NAVI_VOICE_JINSHA_AUTO_SWITCH", true);
    }

    public boolean getHasDownloadJinShaTTS() {
        e0 e0Var;
        if (!j.d() || (e0Var = mPreferenceHelper) == null) {
            return false;
        }
        return e0Var.a("NAVI_VOICE_JINSHA_HAS_DOWNLOAD", false);
    }

    public int getTTSSpeedParam() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 5;
        }
        return e0Var.a(SettingParams.Key.NAVI_TTS_SPEED, 5);
    }

    public int getVoicePersonality() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a("NAVI_VOICE_PERSONNALITY", 0);
    }

    public void setAutoSwitchJinShaTTS(boolean z) {
        e0 e0Var;
        if (!j.d() || (e0Var = mPreferenceHelper) == null) {
            return;
        }
        e0Var.b("NAVI_VOICE_JINSHA_AUTO_SWITCH", z);
    }

    public void setVoicePersonality(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b("NAVI_VOICE_PERSONNALITY", i);
    }

    public void setVoiceTaskId(String str) {
        if (mPreferenceHelper == null) {
            return;
        }
        int voicePersonality = getVoicePersonality();
        if (str != null && voicePersonality != 0) {
            mPreferenceHelper.b("NAVI_VOICE_TASK_ID", str);
        }
    }
}
