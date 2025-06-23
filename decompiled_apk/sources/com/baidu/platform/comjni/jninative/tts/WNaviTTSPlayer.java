package com.baidu.platform.comjni.jninative.tts;

import com.baidu.platform.comapi.wnplatform.tts.b;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class WNaviTTSPlayer {
    private static boolean bStopVoiceOutput = false;
    private static List<b> mTtsPlayerListListener;
    private static b mTtsPlayerListener;

    public static void addOutTTSPlayerListener(b bVar) {
        if (bVar != null) {
            if (mTtsPlayerListListener == null) {
                mTtsPlayerListListener = new ArrayList();
            }
            if (!mTtsPlayerListListener.contains(bVar)) {
                mTtsPlayerListListener.add(bVar);
            }
        }
    }

    public static int getTTSState() {
        List<b> list;
        List<b> list2 = mTtsPlayerListListener;
        if (list2 != null && list2.size() > 0 && (list = mTtsPlayerListListener) != null && list.size() > 0) {
            for (int i = 0; i < mTtsPlayerListListener.size(); i++) {
                if (mTtsPlayerListListener.get(i) != null) {
                    mTtsPlayerListListener.get(i).getTTSState();
                }
            }
        }
        b bVar = mTtsPlayerListener;
        if (bVar == null) {
            return 0;
        }
        return bVar.getTTSState();
    }

    public static void pauseVoiceTTSOutput() {
        bStopVoiceOutput = true;
    }

    public static int playTTSText(String str, int i, int i2, int i3) {
        List<b> list;
        List<b> list2 = mTtsPlayerListListener;
        if (list2 != null && list2.size() > 0 && !bStopVoiceOutput && (list = mTtsPlayerListListener) != null && list.size() > 0) {
            for (int i4 = 0; i4 < mTtsPlayerListListener.size(); i4++) {
                if (mTtsPlayerListListener.get(i4) != null) {
                    mTtsPlayerListListener.get(i4).playTTSText(str, i, i2);
                }
            }
        }
        b bVar = mTtsPlayerListener;
        if (bVar == null || bStopVoiceOutput) {
            return 0;
        }
        return bVar.playTTSText(str, i, i2);
    }

    public static void removeOutTTSPlayerListener(b bVar) {
        List<b> list = mTtsPlayerListListener;
        if (list != null && list.size() > 0) {
            mTtsPlayerListListener.remove(bVar);
        }
    }

    public static void resumeVoiceTTSOutput() {
        bStopVoiceOutput = false;
    }

    public static void setTTSPlayerListener(b bVar) {
        mTtsPlayerListener = bVar;
    }
}
