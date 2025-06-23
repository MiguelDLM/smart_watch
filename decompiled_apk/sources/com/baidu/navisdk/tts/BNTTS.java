package com.baidu.navisdk.tts;

import android.content.Context;

/* loaded from: classes7.dex */
public class BNTTS {
    public static int getCurrentVolume() {
        return BNTTSPlayer.getInstance().getCurrentVolume();
    }

    public static int getInitState() {
        return BNTTSPlayer.getInstance().getInitState();
    }

    public static int getTTSState() {
        return BNTTSPlayer.getInstance().getTTSState();
    }

    public static void init(Context context, String str, String str2, String str3, ITTSInitListener iTTSInitListener) {
        BNTTSPlayer.getInstance().initPlayer(context, str, str2, str3, iTTSInitListener);
    }

    public static int pauseTTS() {
        return BNTTSPlayer.getInstance().pauseTTS();
    }

    public static int resumeTTS() {
        return BNTTSPlayer.getInstance().resumeTTS();
    }

    public static void setCurrentVolume(int i) {
        BNTTSPlayer.getInstance().setCurrentVolume(i);
    }

    public static void setEnableTimeOut(boolean z) {
        BNTTSPlayer.getInstance().setEnableTimeOut(z);
    }

    public static void setOnTTSStateChangedListener(OnTTSStateChangedListener onTTSStateChangedListener) {
        BNTTSPlayer.getInstance().setOnTTSStateChangedListener(onTTSStateChangedListener);
    }

    public static void setTTSLogEnable(boolean z) {
        BNTTSPlayer.getInstance().setTTSLogEnable(z);
    }

    public static void stopTTS() {
        BNTTSPlayer.getInstance().stopTTS();
    }
}
