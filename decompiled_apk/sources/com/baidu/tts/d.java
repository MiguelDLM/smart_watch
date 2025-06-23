package com.baidu.tts;

import android.util.Log;
import com.baidu.tts.aop.ttslistener.TtsListener;

/* loaded from: classes8.dex */
public class d implements h0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f10067a;

    public d(f fVar) {
        this.f10067a = fVar;
    }

    @Override // com.baidu.tts.h0
    public void onPlayFinished(x4 x4Var) {
        TtsListener ttsListener = this.f10067a.c;
        if (ttsListener != null) {
            try {
                ttsListener.onPlayFinished(x4Var);
            } catch (Exception e) {
                Log.e("TtsAdapter", "onPlayFinished exception e=" + e.toString());
            }
        }
    }

    @Override // com.baidu.tts.h0
    public void onPlayLipData(x4 x4Var) {
        TtsListener ttsListener = this.f10067a.c;
        if (ttsListener != null) {
            ttsListener.onPlayLipData(x4Var);
        }
    }

    @Override // com.baidu.tts.h0
    public void onPlayProgressUpdate(x4 x4Var) {
        TtsListener ttsListener = this.f10067a.c;
        if (ttsListener != null) {
            ttsListener.onPlayProgressUpdate(x4Var);
        }
    }

    @Override // com.baidu.tts.h0
    public void onPlayStart(x4 x4Var) {
        TtsListener ttsListener = this.f10067a.c;
        if (ttsListener != null) {
            ttsListener.onPlayStart(x4Var);
        }
    }
}
