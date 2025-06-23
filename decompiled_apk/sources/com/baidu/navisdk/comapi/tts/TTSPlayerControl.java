package com.baidu.navisdk.comapi.tts;

import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener;
import com.baidu.navisdk.comapi.tts.a;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.interfaces.k;
import com.baidu.navisdk.framework.interfaces.o;
import com.baidu.navisdk.jni.nativeif.JNIStatisticsControl;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.j0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes7.dex */
public class TTSPlayerControl {
    public static final String CAR_LIMIT_VOICE_TAG = "CarLimitVoice-";
    private static final String CRUISERVOICEPREFIX = "嗒嗒嗒";
    private static final String DINGVOICEBUFFER = "叮";
    private static final String HIGHTWAYVOICEPREFIX = "嘀嘀嘀";
    private static final String MULTI_ROUTE_VOICE = "嘀咕";
    private static final String OVER_SPEED_VOICE = "当当";
    public static final int PER_TTS_DEFAULT_SPEED = 5;
    public static final int PER_TTS_DEFAULT_VOL = 9;
    private static final String TTS_RES_FAIL = "Fail";
    private static final String TTS_RES_SUCCESS = "Success";
    private static IBNTTSPlayerListener mTtsPlayerListener;
    private static final com.baidu.navisdk.comapi.tts.a mJNIStat = new com.baidu.navisdk.comapi.tts.a();
    private static boolean mIsFellowSpeaking = false;
    private static boolean mIsTTSPlaying = false;
    private static boolean bStopVoiceOutput = false;
    private static boolean mPlayYawSound = true;
    private static j0 mDingSound = null;
    private static j0 mFastRouteSound = null;
    private static final j0 mBlankSound = null;
    private static final HashMap<String, String> stasStrTagMap = null;
    private static final ArrayList<e> mOnTTSStateListenerList = new ArrayList<>();
    private static final ArrayList<c> sTTSBreakListenerList = new ArrayList<>();
    private static final List<d> sTTSInitList = new ArrayList();
    private static final String TAG = "TTSTTSPlayerControl";
    private static final com.baidu.navisdk.util.worker.loop.a mHandler = new a(TAG);

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.util.worker.loop.a {
        public a(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            int i = message.arg1;
            if (message.what == 5556) {
                if (i != 1 && i != 3) {
                    if (i == 4) {
                        TTSPlayerControl.setPhoneIn(false);
                    }
                } else {
                    TTSPlayerControl.setPhoneIn(true);
                    TTSPlayerControl.stopSound();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends com.baidu.navisdk.util.worker.f<String, String> {
        public b(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            TTSPlayerControl.initDingVoice();
            TTSPlayerControl.initFastRouteVoice();
            TTSPlayerControl.initBluetoothBlankVoice();
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        boolean a(String str, String str2);
    }

    /* loaded from: classes7.dex */
    public interface d {
    }

    /* loaded from: classes7.dex */
    public interface e {
        void a(String str);

        void onPlayEnd(String str);
    }

    /* loaded from: classes7.dex */
    public static class f implements e {
    }

    public static void addTTSBreakListener(c cVar) {
        ArrayList<c> arrayList = sTTSBreakListenerList;
        if (arrayList != null && cVar != null) {
            if (arrayList.contains(cVar)) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e(TAG, "addTTSBreakListener,already added!!!," + cVar);
                    return;
                }
                return;
            }
            arrayList.add(cVar);
        }
    }

    public static void addTTSInitCallback(d dVar) {
        List<d> list = sTTSInitList;
        if (list != null && dVar != null) {
            if (list.contains(dVar)) {
                g gVar = g.TTS;
                if (gVar.c()) {
                    gVar.c(TAG, "addTTSInitCallback,already added!!!," + dVar);
                    return;
                }
                return;
            }
            list.add(dVar);
        }
    }

    public static void addTTSPlayStateListener(e eVar) {
        ArrayList<e> arrayList = mOnTTSStateListenerList;
        if (arrayList != null && eVar != null) {
            if (arrayList.contains(eVar)) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e(TAG, "addTTSPlayStateListener,already added!!!," + eVar);
                    return;
                }
                return;
            }
            arrayList.add(eVar);
        }
    }

    public static int cancelAudio() {
        IBNTTSPlayerListener iBNTTSPlayerListener;
        if (getTTSState() == 2 && (iBNTTSPlayerListener = mTtsPlayerListener) != null) {
            return iBNTTSPlayerListener.cancelAudio();
        }
        return -1;
    }

    public static void clearTagMap() {
        HashMap<String, String> hashMap = stasStrTagMap;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    private static int commonPlayTTS(String str, String str2, int i, String str3, String str4, boolean z) {
        String str5;
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "TTSPlayerControl.playTTSText(). speech=" + str + ", bPreempt=" + i + ", bStopVoiceOutput=" + bStopVoiceOutput + ", mTtsPlayerListener=" + mTtsPlayerListener + ",pStrTag=" + str2 + ", speechId=" + str3 + ", scene =" + str4 + ", needSpec = " + z);
        }
        Iterator<c> it = sTTSBreakListenerList.iterator();
        while (it.hasNext()) {
            if (it.next().a(str, str3)) {
                return -2;
            }
        }
        o m = com.baidu.navisdk.framework.interfaces.c.p().m();
        if (m != null && m.c() == 3 && !isContainWarningVoice(str)) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(TAG, "just play warn, return");
                return -3;
            }
            return -3;
        }
        boolean z2 = false;
        if (!bStopVoiceOutput && mTtsPlayerListener != null) {
            boolean K = com.baidu.navisdk.framework.b.K();
            String[] trimBlankVoiceStr = trimBlankVoiceStr(str, K);
            String str6 = trimBlankVoiceStr[0];
            String str7 = trimBlankVoiceStr[1];
            k k = com.baidu.navisdk.framework.interfaces.c.p().k();
            if (k != null && k.k()) {
                if (!TextUtils.isEmpty(str6)) {
                    if (str6.startsWith(DINGVOICEBUFFER)) {
                        if (mPlayYawSound && mDingSound != null && m != null && m.c() != 2) {
                            mDingSound.a();
                        }
                        str6 = str6.substring(1);
                    } else {
                        if (str6.startsWith(CRUISERVOICEPREFIX)) {
                            return -4;
                        }
                        if (str6.startsWith(HIGHTWAYVOICEPREFIX)) {
                            str6 = str6.substring(3);
                        }
                    }
                }
                if (str6.startsWith("。")) {
                    str6 = str6.substring(1);
                }
                if (TextUtils.isEmpty(str6)) {
                    return -4;
                }
            } else {
                com.baidu.navisdk.framework.interfaces.pronavi.b h = com.baidu.navisdk.framework.interfaces.c.p().h();
                if (h != null) {
                    z2 = h.x0();
                }
                if (m != null && m.c() == 2 && z2) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e(TAG, "Quiet, return");
                        return -5;
                    }
                    return -5;
                }
                if (str6.startsWith(DINGVOICEBUFFER) && !TextUtils.isEmpty(str6) && !mPlayYawSound) {
                    str6 = str6.substring(1);
                }
            }
            if (!TextUtils.isEmpty(str7) && K) {
                str5 = str7 + str6;
            } else {
                str5 = str6;
            }
            int playTTSText = mTtsPlayerListener.playTTSText(getSource(str3), str5, str2, i, str3, str4, z);
            g gVar = g.TTS;
            if (gVar.d()) {
                gVar.e(TAG, "commonPlayTTS(), result = " + playTTSText);
            }
            return playTTSText;
        }
        g gVar2 = g.TTS;
        if (gVar2.a()) {
            gVar2.a("TTSPlayerControl end. speech=" + str + ", bPreempt=" + i + ", bStopVoiceOutput=" + bStopVoiceOutput + ", mTtsPlayerListener=" + mTtsPlayerListener + ",pStrTag" + str2);
        }
        return 0;
    }

    public static int getCurrentVolume() {
        IBNTTSPlayerListener iBNTTSPlayerListener = mTtsPlayerListener;
        if (iBNTTSPlayerListener != null) {
            return iBNTTSPlayerListener.getCurrentVolume();
        }
        return -1;
    }

    public static boolean getFellowSpeakStatus() {
        return mIsFellowSpeaking;
    }

    public static boolean getMapTTSPlayStatus() {
        if (getTTSState() == 2) {
            return true;
        }
        return false;
    }

    private static int getSource(String str) {
        com.baidu.navisdk.framework.interfaces.g d2;
        if (!TextUtils.isEmpty(str) && str.startsWith("scenic_broadcast")) {
            return 4;
        }
        if (com.baidu.navisdk.asr.d.B().r()) {
            return 1;
        }
        com.baidu.navisdk.framework.interfaces.pronavi.b h = com.baidu.navisdk.framework.interfaces.c.p().h();
        if (h != null && h.x0() && (d2 = com.baidu.navisdk.framework.interfaces.c.p().d()) != null) {
            if (d2.b() == 2) {
                return 6;
            }
            if (d2.b() == 3) {
                return 7;
            }
            return 0;
        }
        com.baidu.navisdk.framework.interfaces.commute.b e2 = com.baidu.navisdk.framework.interfaces.c.p().e();
        if (e2 != null && e2.b()) {
            return 8;
        }
        return -1;
    }

    public static List<d> getTTSInitCallbackLIst() {
        return sTTSInitList;
    }

    public static ArrayList<e> getTTSPlayStateListener() {
        return mOnTTSStateListenerList;
    }

    public static boolean getTTSPlayStatus() {
        return mIsTTSPlaying;
    }

    public static IBNTTSPlayerListener getTTSPlayerListener() {
        return mTtsPlayerListener;
    }

    public static int getTTSState() {
        IBNTTSPlayerListener iBNTTSPlayerListener = mTtsPlayerListener;
        if (iBNTTSPlayerListener != null) {
            int tTSState = iBNTTSPlayerListener.getTTSState();
            LogUtil.e(TAG, "getTTSState =  " + tTSState);
            com.baidu.navisdk.util.statistic.userop.b.r().d("d.1.4", "" + tTSState);
            return tTSState;
        }
        return 1;
    }

    public static boolean hasInitialized() {
        IBNTTSPlayerListener iBNTTSPlayerListener = mTtsPlayerListener;
        if (iBNTTSPlayerListener != null) {
            boolean hasInitialized = iBNTTSPlayerListener.hasInitialized();
            LogUtil.e(TAG, "hasInitialized =  " + hasInitialized);
            return hasInitialized;
        }
        return false;
    }

    public static void init() {
        IBNTTSPlayerListener iBNTTSPlayerListener = mTtsPlayerListener;
        if (iBNTTSPlayerListener != null) {
            iBNTTSPlayerListener.initTTSPlayer();
        }
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.f) new b("InitFastRouteVoice", null), new com.baidu.navisdk.util.worker.e(2, 0));
        mJNIStat.a();
        com.baidu.navisdk.util.listener.a.a(mHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initBluetoothBlankVoice() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initDingVoice() {
        mDingSound = new j0(com.baidu.navisdk.framework.a.c().a(), R.raw.ding);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initFastRouteVoice() {
        mFastRouteSound = new j0(com.baidu.navisdk.framework.a.c().a(), R.raw.fast_route_ding);
    }

    public static boolean isContainWarningVoice(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.startsWith(DINGVOICEBUFFER) && !str.startsWith(HIGHTWAYVOICEPREFIX) && !str.startsWith(CRUISERVOICEPREFIX) && !str.startsWith(OVER_SPEED_VOICE) && !str.startsWith(MULTI_ROUTE_VOICE)) {
            return false;
        }
        return true;
    }

    public static void pauseVoiceTTSOutput() {
        LogUtil.e(TAG, "pauseVoiceTTSOutput! mTtsPlayerListener = " + mTtsPlayerListener);
        setStopVoiceOutput(true);
        IBNTTSPlayerListener iBNTTSPlayerListener = mTtsPlayerListener;
        if (iBNTTSPlayerListener != null) {
            iBNTTSPlayerListener.pauseTTS();
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("d.1.1", "1", null, null);
    }

    public static int playAudio(String str, IBNTTSPlayerListener.a aVar) {
        IBNTTSPlayerListener iBNTTSPlayerListener = mTtsPlayerListener;
        if (iBNTTSPlayerListener != null) {
            return iBNTTSPlayerListener.playAudio(str, aVar);
        }
        return -1;
    }

    public static void playBluetoothBlankVoice() {
        boolean z;
        StringBuilder sb = new StringBuilder();
        sb.append("playBluetoothBlankVoice,mBlankSound is null:");
        j0 j0Var = mBlankSound;
        if (j0Var == null) {
            z = true;
        } else {
            z = false;
        }
        sb.append(z);
        LogUtil.e(TAG, sb.toString());
        o m = com.baidu.navisdk.framework.interfaces.c.p().m();
        if (j0Var != null && m != null && m.c() != 2) {
            j0Var.a();
        }
    }

    public static void playFastRouteVoice() {
        LogUtil.e(TAG, "playFastRouteVoice");
        o m = com.baidu.navisdk.framework.interfaces.c.p().m();
        if (mFastRouteSound != null && m != null && m.c() != 2) {
            mFastRouteSound.a();
        }
    }

    public static int playTTS(String str, int i) {
        return playTTS(str, i, null);
    }

    @Deprecated
    public static int playTTSText(String str, int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "playTTSText from JNI. with 2 params");
        }
        return playTTSText(str, null, i);
    }

    public static int playXDTTSText(String str, int i) {
        return playXDTTSText(str, i, null);
    }

    public static int playXDTTSTextForResult(String str, int i, String str2) {
        return playXDTTSTextForResult(str, i, str2, null);
    }

    public static void removeTTSBreakListener(c cVar) {
        ArrayList<c> arrayList = sTTSBreakListenerList;
        if (arrayList != null && cVar != null) {
            arrayList.remove(cVar);
        }
    }

    public static void removeTTSInitCallback(d dVar) {
        List<d> list = sTTSInitList;
        if (list != null && dVar != null) {
            list.remove(dVar);
        }
    }

    public static void removeTTSPlayStateListener(e eVar) {
        ArrayList<e> arrayList = mOnTTSStateListenerList;
        if (arrayList != null && eVar != null) {
            arrayList.remove(eVar);
        }
    }

    public static void resumeVoiceTTSOutput() {
        LogUtil.e(TAG, "resumeVoiceTTSOutput! mTtsPlayerListener = " + mTtsPlayerListener);
        setStopVoiceOutput(false);
        IBNTTSPlayerListener iBNTTSPlayerListener = mTtsPlayerListener;
        if (iBNTTSPlayerListener != null) {
            iBNTTSPlayerListener.resumeTTS();
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("d.1.1", "2", null, null);
    }

    public static void setEnableTimeOut(boolean z) {
        IBNTTSPlayerListener iBNTTSPlayerListener = mTtsPlayerListener;
        if (iBNTTSPlayerListener != null) {
            iBNTTSPlayerListener.setEnableTimeOut(z);
        }
    }

    public static void setFellowSpeakStatus(boolean z) {
        mIsFellowSpeaking = z;
    }

    public static void setPhoneIn(boolean z) {
        IBNTTSPlayerListener iBNTTSPlayerListener = mTtsPlayerListener;
        if (iBNTTSPlayerListener != null) {
            if (z) {
                iBNTTSPlayerListener.phoneCalling();
            } else {
                iBNTTSPlayerListener.phoneHangUp();
            }
        }
    }

    public static void setStopVoiceOutput(boolean z) {
        LogUtil.e(TAG, "setStopVoiceOutput " + z);
        bStopVoiceOutput = z;
    }

    public static void setTTSPlayStatus(boolean z) {
        mIsTTSPlaying = z;
    }

    public static void setTTSPlayerListener(IBNTTSPlayerListener iBNTTSPlayerListener) {
        mTtsPlayerListener = iBNTTSPlayerListener;
    }

    public static void setTTSTextPlayResult(String str) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("setTTSTextPlayResult:", "speechId" + str);
            HashMap<String, String> hashMap = stasStrTagMap;
            if (hashMap != null) {
                LogUtil.e("stasStrTagMap:", hashMap.toString());
            }
        }
        HashMap<String, String> hashMap2 = stasStrTagMap;
        if (hashMap2 == null || TextUtils.isEmpty(str) || !hashMap2.containsKey(str)) {
            return;
        }
        Iterator<Map.Entry<String, String>> it = hashMap2.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            it.remove();
            String key = next.getKey();
            String value = next.getValue();
            if (!str.equals(key)) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("setTTSTextPlayResult result:", key + ", " + value + ":" + TTS_RES_FAIL);
                }
                JNIStatisticsControl.sInstance.setTTSTextPlayResult(value, TTS_RES_FAIL);
            } else {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("setTTSTextPlayResult result:", key + ", " + value + ":" + TTS_RES_SUCCESS);
                }
                JNIStatisticsControl.sInstance.setTTSTextPlayResult(value, TTS_RES_SUCCESS);
                return;
            }
        }
    }

    public static void setTTSVolume(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "setTTSVolume: " + i);
        }
        IBNTTSPlayerListener iBNTTSPlayerListener = mTtsPlayerListener;
        if (iBNTTSPlayerListener != null) {
            iBNTTSPlayerListener.setTTSVolume(i);
        }
    }

    public static void setYawSoundEnable(boolean z) {
        mPlayYawSound = z;
    }

    public static void stopSound() {
        j0 j0Var = mFastRouteSound;
        if (j0Var != null) {
            j0Var.c();
        }
    }

    public static void stopVoiceTTSOutput() {
        IBNTTSPlayerListener iBNTTSPlayerListener;
        LogUtil.e("TTSPlayerControl", "stopVoiceTTSOutput()");
        if (getTTSState() == 2 && (iBNTTSPlayerListener = mTtsPlayerListener) != null) {
            iBNTTSPlayerListener.stopTTS();
        }
    }

    public static String[] trimBlankVoiceStr(String str, boolean z) {
        String str2 = "";
        if (!TextUtils.isEmpty(str) && z) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(TAG, "before_filter_blankStr:" + str);
            }
            Matcher matcher = Pattern.compile("<usraud>.*</usraud>").matcher(str);
            if (matcher.lookingAt()) {
                String group = matcher.group();
                if (LogUtil.LOGGABLE) {
                    LogUtil.e(TAG, "blankStr:" + group);
                }
                if (!TextUtils.isEmpty(group)) {
                    str = str.replace(group, "");
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e(TAG, "after_filter_blankStr:" + str);
                    }
                }
                str2 = group;
            }
        }
        return new String[]{str, str2};
    }

    public static void unInit() {
        j0 j0Var = mDingSound;
        if (j0Var != null) {
            j0Var.b();
        }
        j0 j0Var2 = mFastRouteSound;
        if (j0Var2 != null) {
            j0Var2.b();
        }
        IBNTTSPlayerListener iBNTTSPlayerListener = mTtsPlayerListener;
        if (iBNTTSPlayerListener != null) {
            iBNTTSPlayerListener.releaseTTSPlayer();
        }
        com.baidu.navisdk.util.listener.a.b(mHandler);
    }

    public static int playTTS(String str, int i, String str2) {
        return playTTS(str, i, str2, null);
    }

    public static int playXDTTSText(String str, int i, String str2) {
        return playXDTTSTextForResult(str, i, null, str2);
    }

    public static int playXDTTSTextForResult(String str, int i, String str2, String str3) {
        IBNTTSPlayerListener iBNTTSPlayerListener;
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "TTSPlayerControl.playXDTTSText(). speech=" + str + ", bPreempt=" + i + ", bStopVoiceOutput=" + bStopVoiceOutput + " , speechId = " + str2 + ", mTtsPlayerListener=" + mTtsPlayerListener + ",pStrTagnull");
        }
        int source = getSource(str2);
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "playXDTTSTextForResult(),getSpecTagInText newSpeech = " + str);
        }
        Iterator<c> it = sTTSBreakListenerList.iterator();
        while (it.hasNext()) {
            if (it.next().a(str, str2)) {
                return 0;
            }
        }
        com.baidu.navisdk.asr.d.B().b(str);
        if (!bStopVoiceOutput && (iBNTTSPlayerListener = mTtsPlayerListener) != null) {
            return iBNTTSPlayerListener.playXDTTSText(source, str, null, i, str2, str3);
        }
        g gVar = g.TTS;
        if (gVar.a()) {
            gVar.a("TTSPlayerControl end. speech=" + str + ", bPreempt=" + i + ", bStopVoiceOutput=" + bStopVoiceOutput + ", mTtsPlayerListener=" + mTtsPlayerListener + ",pStrTagnull");
        }
        return 0;
    }

    public static int playTTS(String str, int i, String str2, String str3) {
        LogUtil.e(TAG, "playTTSText from SDK. speech=" + str + ", bPreempt=" + i + ", speechid = " + str2 + ", scene = " + str3 + ", bStopVoiceOutput=" + bStopVoiceOutput + ", mTtsPlayerListener=" + mTtsPlayerListener);
        return commonPlayTTS(str, null, i, str2, str3, true);
    }

    @Deprecated
    public static int playTTSText(String str, String str2, int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "playTTSText from JNI. with 3 params");
        }
        return playTTSText(str, str2, i, null, true);
    }

    public static int playTTSText(String str, String str2, int i, String str3, boolean z) {
        int i2;
        String str4 = "NaviEngine-";
        if (!TextUtils.isEmpty(str2)) {
            str4 = "NaviEngine-" + SystemClock.elapsedRealtime();
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "playTTSText from JNI. speech=" + str + "pStrTag=" + str2 + ", speechId=" + str4 + ", bPreempt=" + i + ", scene =" + str3 + ", needSpec = " + z + ", bStopVoiceOutput=" + bStopVoiceOutput + ", mTtsPlayerListener=" + mTtsPlayerListener);
        }
        mJNIStat.a(new a.d(str, str4, str2, Integer.MIN_VALUE, i));
        try {
            i2 = commonPlayTTS(str, str2, i, str4, str3, z);
        } catch (Exception e2) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("playTTSText", e2);
            }
            i2 = -1;
        }
        mJNIStat.b(new a.d(str, str4, str2, i2, i));
        return i2;
    }
}
