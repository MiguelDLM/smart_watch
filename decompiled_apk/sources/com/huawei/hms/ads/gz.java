package com.huawei.hms.ads;

import android.media.AudioManager;

/* loaded from: classes10.dex */
public class gz {
    public static final float Code = 1.0E-8f;
    private static final String V = "VolumeStrategy";

    public static float Code(AudioManager audioManager, boolean z) {
        if (audioManager != null) {
            float streamMaxVolume = audioManager.getStreamMaxVolume(3);
            int streamVolume = audioManager.getStreamVolume(1);
            int streamVolume2 = audioManager.getStreamVolume(3);
            if (streamVolume != 0 && !z && streamMaxVolume > 1.0E-8f) {
                return streamVolume2 / streamMaxVolume;
            }
        }
        return 0.0f;
    }
}
