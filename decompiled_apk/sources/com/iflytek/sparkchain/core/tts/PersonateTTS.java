package com.iflytek.sparkchain.core.tts;

import com.iflytek.sparkchain.core.tts.TTS;

/* loaded from: classes10.dex */
public class PersonateTTS extends TTS {
    public PersonateTTS(String str) {
        super(str);
    }

    private native int initEngine(int i);

    private native int personateTTSCreate(String str, int i);

    private native void setAbilityId(int i, String str);

    private native void setTTSMaxTokens(int i, int i2);

    private native void setTTSOralLevel(int i, String str);

    private native void setTTSSparkAssist(int i, boolean z);

    private native void setTTSTopK(int i, int i2);

    private native void setUrl(int i, String str);

    public void abilityId(String str) {
        setAbilityId(this.sid, str);
    }

    @Override // com.iflytek.sparkchain.core.tts.TTS
    public int create(String str) {
        return create(str, TTS.RequestType.Online.getValue());
    }

    public int init() {
        return initEngine(this.sid);
    }

    public void maxTokens(int i) {
        setTTSMaxTokens(this.sid, i);
    }

    public void oralLevel(String str) {
        setTTSOralLevel(this.sid, str);
    }

    public void sparkAssist(boolean z) {
        setTTSSparkAssist(this.sid, z);
    }

    public void topK(int i) {
        setTTSTopK(this.sid, i);
    }

    public void url(String str) {
        setUrl(this.sid, str);
    }

    public PersonateTTS(String str, TTS.RequestType requestType) {
        super(str, requestType.getValue());
    }

    @Override // com.iflytek.sparkchain.core.tts.TTS
    public int create(String str, int i) {
        return personateTTSCreate(str, i);
    }

    public PersonateTTS(String str, String str2, TTS.RequestType requestType) {
        super(str, str2, requestType.getValue());
    }
}
