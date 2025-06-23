package com.baidu.tts.aop.ttslistener;

import com.baidu.tts.aop.AInterceptorHandler;

/* loaded from: classes8.dex */
public class TtsListenerInterceptorHandler extends AInterceptorHandler {
    @Override // com.baidu.tts.aop.IInterceptorHandler
    public void registerMethods() {
        registerMethod("onSynthesizeDataArrived");
        registerMethod("onPlayProgressUpdate");
    }
}
