package com.iflytek.sparkchain.utils;

import android.content.Context;
import android.media.AudioManager;
import android.view.View;
import com.google.android.exoplayer2.util.MimeTypes;
import com.iflytek.sparkchain.utils.log.LogUtil;

/* loaded from: classes10.dex */
public class FuncAdapterSdk10 {
    private static int avoidValue;

    public static void CloseHardWareAccelerate(View view) {
        view.setLayerType(1, null);
    }

    public static boolean Lock(Context context, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener) {
        try {
            LogUtil.d("start request music_stream focus");
            ((AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO)).requestAudioFocus(onAudioFocusChangeListener, 3, 2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean UnLock(Context context, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener) {
        try {
            LogUtil.d("start abandon audio focus");
            ((AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO)).abandonAudioFocus(onAudioFocusChangeListener);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void avoidSystemError(int i) {
        LogUtil.d("avoidSystemError");
        avoidValue = i;
    }
}
