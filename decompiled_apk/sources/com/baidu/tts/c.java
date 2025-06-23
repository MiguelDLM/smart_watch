package com.baidu.tts;

import com.baidu.tts.aop.ttslistener.TtsListener;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;

/* loaded from: classes8.dex */
public class c implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f10044a;

    public c(f fVar) {
        this.f10044a = fVar;
    }

    @Override // com.baidu.tts.p
    public void a(x4 x4Var) {
        LoggerProxy.d("TtsAdapter", "onSynthesizeStop");
    }

    @Override // com.baidu.tts.p
    public void onError(x4 x4Var) {
        TtsListener ttsListener = this.f10044a.c;
        if (ttsListener != null) {
            ttsListener.onError(x4Var);
        }
    }

    @Override // com.baidu.tts.p
    public void onSynthesizeDataArrived(x4 x4Var) {
        TtsListener ttsListener = this.f10044a.c;
        if (ttsListener != null) {
            ttsListener.onSynthesizeDataArrived(x4Var);
        }
    }

    @Override // com.baidu.tts.p
    public void onSynthesizeFinished(x4 x4Var) {
        TtsListener ttsListener = this.f10044a.c;
        if (ttsListener != null) {
            ttsListener.onSynthesizeFinished(x4Var);
        }
    }

    @Override // com.baidu.tts.p
    public void onSynthesizeStart(x4 x4Var) {
        TtsListener ttsListener = this.f10044a.c;
        if (ttsListener != null) {
            ttsListener.onSynthesizeStart(x4Var);
        }
    }
}
