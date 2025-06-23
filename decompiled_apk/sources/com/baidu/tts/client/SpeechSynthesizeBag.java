package com.baidu.tts.client;

import com.baidu.tts.tools.ResourceTools;
import com.baidu.tts.x2;

/* loaded from: classes8.dex */
public class SpeechSynthesizeBag {

    /* renamed from: a, reason: collision with root package name */
    public String f10051a;
    public String b;

    public String getText() {
        return this.f10051a;
    }

    public String getUtteranceId() {
        return this.b;
    }

    public int setText(String str) {
        x2 isTextValid = ResourceTools.isTextValid(str);
        if (isTextValid == null) {
            this.f10051a = str;
            return 0;
        }
        return isTextValid.b;
    }

    public void setUtteranceId(String str) {
        this.b = str;
    }
}
