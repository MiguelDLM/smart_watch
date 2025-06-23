package com.baidu.navisdk.comapi.tts;

/* loaded from: classes7.dex */
public interface IBNTTSPlayerListener {
    public static final int PLAYER_STATE_ERROR = 4;
    public static final int PLAYER_STATE_IDLE = 1;
    public static final int PLAYER_STATE_NOT_INIT = 0;
    public static final int PLAYER_STATE_PAUSE = 3;
    public static final int PLAYER_STATE_PLAYING = 2;

    /* loaded from: classes7.dex */
    public interface a {
    }

    int cancelAudio();

    int getCurrentVolume();

    int getTTSState();

    boolean hasInitialized();

    void initTTSPlayer();

    void pauseTTS();

    void phoneCalling();

    void phoneHangUp();

    int playAudio(String str, a aVar);

    int playTTSText(int i, String str, String str2, int i2, String str3, String str4, boolean z);

    int playXDTTSText(int i, String str, String str2, int i2, String str3, String str4);

    void releaseTTSPlayer();

    void resumeTTS();

    void setEnableTimeOut(boolean z);

    void setTTSVolume(int i);

    void stopTTS();
}
