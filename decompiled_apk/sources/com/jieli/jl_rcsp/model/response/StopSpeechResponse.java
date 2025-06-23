package com.jieli.jl_rcsp.model.response;

import com.jieli.jl_rcsp.model.base.CommonResponse;

/* loaded from: classes10.dex */
public class StopSpeechResponse extends CommonResponse {
    private boolean isSyncIatText = false;
    private boolean isSyncNlpText = false;
    private boolean isPlayTTS = false;

    public boolean isPlayTTS() {
        return this.isPlayTTS;
    }

    public boolean isSyncIatText() {
        return this.isSyncIatText;
    }

    public boolean isSyncNlpText() {
        return this.isSyncNlpText;
    }

    public StopSpeechResponse setPlayTTS(boolean z) {
        this.isPlayTTS = z;
        return this;
    }

    public StopSpeechResponse setSyncIatText(boolean z) {
        this.isSyncIatText = z;
        return this;
    }

    public StopSpeechResponse setSyncNlpText(boolean z) {
        this.isSyncNlpText = z;
        return this;
    }
}
