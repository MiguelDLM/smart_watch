package com.baidu.tts.aop.tts;

import android.content.Context;
import com.baidu.tts.aop.ttslistener.TtsListener;
import com.baidu.tts.auth.AuthInfo;
import com.baidu.tts.i3;
import com.baidu.tts.q2;
import com.baidu.tts.u4;
import com.baidu.tts.v4;
import com.baidu.tts.w2;
import com.baidu.tts.w4;
import com.baidu.tts.y4;
import com.baidu.tts.z4;
import java.util.HashMap;

/* loaded from: classes8.dex */
public interface ITts extends i3 {
    AuthInfo auth(w2 w2Var);

    @Override // com.baidu.tts.i3
    /* synthetic */ TtsError create();

    @Override // com.baidu.tts.i3
    /* synthetic */ void destroy();

    int freeCustomResource(u4 u4Var);

    w2 getMode();

    TtsListener getTtsListener();

    z4 getTtsParams();

    int loadCustomResource(u4 u4Var);

    int loadEnglishModel(v4 v4Var);

    int loadModel(w4 w4Var);

    int loadSuitedModel(HashMap<String, String> hashMap);

    @Override // com.baidu.tts.i3
    /* synthetic */ void pause();

    @Override // com.baidu.tts.i3
    /* synthetic */ void resume();

    int setAudioAttributes(int i, int i2);

    int setAudioSampleRate(int i);

    int setAudioStreamType(int i);

    void setContext(Context context);

    void setMode(w2 w2Var);

    int setParam(q2 q2Var, String str);

    int setStereoVolume(float f, float f2);

    void setTtsListener(TtsListener ttsListener);

    void speak(y4 y4Var);

    @Override // com.baidu.tts.i3
    /* synthetic */ void start();

    @Override // com.baidu.tts.i3
    /* synthetic */ void stop();

    void synthesize(y4 y4Var);
}
