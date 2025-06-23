package com.baidu.navisdk.tts;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;

/* loaded from: classes7.dex */
public class BNTTSUtils {
    private static final String TAG = "BNTTSUtils";
    public static AudioManager.OnAudioFocusChangeListener sOnAudioFocusChange = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.navisdk.tts.BNTTSUtils.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            Log.i(BNTTSUtils.TAG, "onAudioFocusChange focusChange = " + i);
        }
    };

    public static AudioManager getAudioManager(Context context) {
        return (AudioManager) context.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
    }

    public static boolean isCalling(Context context) {
        AudioManager audioManager;
        int mode;
        if (context == null || (audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO)) == null || (mode = audioManager.getMode()) == -2 || mode == -1 || mode == 0) {
            return false;
        }
        return true;
    }

    public static void releaseAudioFocus(Context context) {
        if (context == null) {
            return;
        }
        getAudioManager(context).abandonAudioFocus(sOnAudioFocusChange);
    }

    public static void requestAudioFocus(Context context) {
        if (context == null) {
            return;
        }
        try {
            AudioManager audioManager = getAudioManager(context);
            if (audioManager != null) {
                audioManager.requestAudioFocus(sOnAudioFocusChange, 3, 3);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void requestAudioFocusToStopMusic(Context context) {
        if (context == null) {
            return;
        }
        try {
            AudioManager audioManager = getAudioManager(context);
            if (audioManager != null) {
                audioManager.requestAudioFocus(sOnAudioFocusChange, 3, 2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
