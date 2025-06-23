package com.baidu.platform.comjni.jninative.vibrate;

import android.annotation.SuppressLint;
import android.os.Vibrator;
import com.baidu.platform.comapi.wnplatform.p.b.a;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes8.dex */
public class VibrateHelper {
    public static final int VIBRATE_DURATION_TIME = 500;
    private static boolean bStopVibration = false;
    private static List<IVibrateListener> mVibrateListeners;
    private static Vibrator vibrator;

    public static void MobileVibration() {
        if (vibrator == null) {
            vibrator = (Vibrator) a.a().getSystemService("vibrator");
        }
        if (checkVibrate() && !bStopVibration) {
            vibrator.vibrate(500L);
            List<IVibrateListener> list = mVibrateListeners;
            if (list != null) {
                for (IVibrateListener iVibrateListener : list) {
                    if (iVibrateListener != null) {
                        iVibrateListener.onVibrate();
                    }
                }
            }
        }
    }

    public static void addVibrateListener(IVibrateListener iVibrateListener) {
        if (mVibrateListeners == null) {
            mVibrateListeners = new LinkedList();
        }
        mVibrateListeners.add(iVibrateListener);
    }

    @SuppressLint({"NewApi"})
    private static boolean checkVibrate() {
        if (!vibrator.hasVibrator()) {
            return false;
        }
        return true;
    }

    public static void pauseVibration() {
        bStopVibration = true;
    }

    public static void removeVibrateListener(IVibrateListener iVibrateListener) {
        List<IVibrateListener> list = mVibrateListeners;
        if (list != null && iVibrateListener != null) {
            list.remove(iVibrateListener);
        }
    }

    public static void resumeVibration() {
        bStopVibration = false;
    }
}
