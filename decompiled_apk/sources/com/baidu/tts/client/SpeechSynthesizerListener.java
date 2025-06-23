package com.baidu.tts.client;

/* loaded from: classes8.dex */
public interface SpeechSynthesizerListener {
    void onError(String str, SpeechError speechError);

    void onLipDataArrived(String str, byte[] bArr);

    void onSpeechFinish(String str);

    void onSpeechProgressChanged(String str, int i);

    void onSpeechStart(String str);

    void onSynthesizeDataArrived(String str, byte[] bArr, int i, int i2);

    void onSynthesizeFinish(String str);

    void onSynthesizeStart(String str);
}
