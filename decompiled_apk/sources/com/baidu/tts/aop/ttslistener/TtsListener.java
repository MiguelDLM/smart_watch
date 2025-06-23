package com.baidu.tts.aop.ttslistener;

import com.baidu.tts.x4;

/* loaded from: classes8.dex */
public interface TtsListener {
    void onError(x4 x4Var);

    void onPlayFinished(x4 x4Var);

    void onPlayLipData(x4 x4Var);

    void onPlayProgressUpdate(x4 x4Var);

    void onPlayStart(x4 x4Var);

    void onSynthesizeDataArrived(x4 x4Var);

    void onSynthesizeFinished(x4 x4Var);

    void onSynthesizeStart(x4 x4Var);
}
