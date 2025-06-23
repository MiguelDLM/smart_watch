package com.baidu.navisdk.adapter;

import com.baidu.navcore.tts.BaseTTSPlayer;
import com.baidu.navisdk.adapter.struct.BNTTsInitConfig;
import com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener;

/* loaded from: classes7.dex */
public interface IBNTTSManager {

    /* loaded from: classes7.dex */
    public static abstract class IBNOuterTTSPlayerCallback implements IBNTTSPlayerListener {
        @Override // com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener
        public int cancelAudio() {
            return 0;
        }

        @Override // com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener
        public int getCurrentVolume() {
            return 0;
        }

        @Override // com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener
        public boolean hasInitialized() {
            if (BaseTTSPlayer.j().b() == 2) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener
        public void initTTSPlayer() {
        }

        @Override // com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener
        public void pauseTTS() {
        }

        @Override // com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener
        public void phoneCalling() {
        }

        @Override // com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener
        public void phoneHangUp() {
        }

        @Override // com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener
        public int playAudio(String str, IBNTTSPlayerListener.a aVar) {
            return 0;
        }

        @Override // com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener
        public int playTTSText(int i, String str, String str2, int i2, String str3, String str4, boolean z) {
            if (BaseTTSPlayer.j().e()) {
                str = str.replaceAll("[(（]\\w+[））]", "");
            }
            return playTTSText(str, i2, str3);
        }

        public abstract int playTTSText(String str, int i, String str2);

        @Override // com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener
        public int playXDTTSText(int i, String str, String str2, int i2, String str3, String str4) {
            return 0;
        }

        @Override // com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener
        public void releaseTTSPlayer() {
        }

        @Override // com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener
        public void resumeTTS() {
        }

        @Override // com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener
        public void setEnableTimeOut(boolean z) {
        }

        @Override // com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener
        public void setTTSVolume(int i) {
        }

        @Override // com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener
        public void stopTTS() {
        }
    }

    /* loaded from: classes7.dex */
    public interface IOnTTSPlayStateChangedListener {
        void onPlayEnd(String str);

        void onPlayError(int i, String str);

        void onPlayStart();
    }

    void initTTS(IBNOuterTTSPlayerCallback iBNOuterTTSPlayerCallback);

    void initTTS(BNTTsInitConfig bNTTsInitConfig);

    void setOnTTSStateChangedListener(IOnTTSPlayStateChangedListener iOnTTSPlayStateChangedListener);

    void setRemovePolyphonicPinyin(boolean z);
}
