package com.baidu.ar.digital;

import java.util.HashMap;
import java.util.List;

/* loaded from: classes7.dex */
public interface IDigital {
    void initDigital(HashMap<String, Object> hashMap);

    void playAudio(byte[] bArr);

    void sendChatMessage(String str);

    void sendReadingMessage(String str);

    void setBlendShape(HashMap<String, Double> hashMap);

    void setDigitalListener(IDigitalListener iDigitalListener);

    void setSkeletonData(HashMap<String, List<Double>> hashMap);

    void startRecord();

    void stop();

    void stopRecord();
}
