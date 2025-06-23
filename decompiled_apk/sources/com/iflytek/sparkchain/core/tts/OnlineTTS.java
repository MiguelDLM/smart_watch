package com.iflytek.sparkchain.core.tts;

/* loaded from: classes10.dex */
public class OnlineTTS extends TTS {
    public OnlineTTS(String str) {
        super(str);
    }

    private native int onlineTTSCreate(String str);

    private native int setAue(int i, String str);

    private native int setAuf(int i, String str);

    private native int setSfl(int i, int i2);

    private native int setTte(int i, String str);

    public void aue(String str) {
        setAue(this.sid, str);
    }

    public void auf(String str) {
        setAuf(this.sid, str);
    }

    @Override // com.iflytek.sparkchain.core.tts.TTS
    public int create(String str) {
        return onlineTTSCreate(str);
    }

    public void sfl(int i) {
        setSfl(this.sid, i);
    }

    public void tte(String str) {
        setTte(this.sid, str);
    }
}
