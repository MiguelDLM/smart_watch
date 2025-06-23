package com.baidu.mapapi.tts;

import com.baidu.platform.comapi.wnplatform.tts.b;

/* loaded from: classes7.dex */
public class WNTTSManager {

    /* renamed from: a, reason: collision with root package name */
    private static WNTTSManager f6011a;

    /* loaded from: classes7.dex */
    public interface IOnTTSPlayStateChangedListener {
        void onPlayEnd(String str);

        void onPlayError(int i, String str);

        void onPlayStart();
    }

    /* loaded from: classes7.dex */
    public interface IWNOuterTTSPlayerCallback extends b {
        @Override // com.baidu.platform.comapi.wnplatform.tts.b
        int getTTSState();

        @Override // com.baidu.platform.comapi.wnplatform.tts.b
        int playTTSText(String str, int i, int i2);
    }

    public static WNTTSManager getInstance() {
        if (f6011a == null) {
            f6011a = new WNTTSManager();
        }
        return f6011a;
    }

    public void initTTS(WNTTsInitConfig wNTTsInitConfig) {
        if (wNTTsInitConfig == null) {
            return;
        }
        com.baidu.platform.comapi.wnplatform.tts.a.a(wNTTsInitConfig, null);
    }

    public void removeOutTTSPlayerListener(IWNOuterTTSPlayerCallback iWNOuterTTSPlayerCallback) {
        com.baidu.platform.comapi.wnplatform.tts.a.a(iWNOuterTTSPlayerCallback);
    }

    public void setOnTTSStateChangedListener(IOnTTSPlayStateChangedListener iOnTTSPlayStateChangedListener) {
        if (iOnTTSPlayStateChangedListener == null) {
            return;
        }
        com.baidu.platform.comapi.wnplatform.tts.a.a(iOnTTSPlayStateChangedListener);
    }

    public void initTTS(IWNOuterTTSPlayerCallback iWNOuterTTSPlayerCallback) {
        com.baidu.platform.comapi.wnplatform.tts.a.a(null, iWNOuterTTSPlayerCallback);
    }
}
