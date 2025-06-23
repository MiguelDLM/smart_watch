package com.baidu.tts.aop.tts;

import com.baidu.tts.aop.AInterceptorHandler;

/* loaded from: classes8.dex */
public class TtsInterceptorHandler extends AInterceptorHandler {
    @Override // com.baidu.tts.aop.IInterceptorHandler
    public void registerMethods() {
        registerMethod("speak");
        registerMethod("synthesize");
        registerMethod("setTtsListener");
        registerMethod("setMode");
        registerMethod("setParam");
    }
}
