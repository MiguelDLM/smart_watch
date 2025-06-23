package com.baidu.tts;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes8.dex */
public enum y2 {
    TTS_SERVER("https://tts.baidu.com/text2audio"),
    MODEL_SERVER("https://tts.baidu.com/bos/story.php?"),
    STATISTICS_SERVER("http://upl.baidu.com/offline/confirm"),
    STATISTICS_MODELLOAD_SERVER("https://upl.baidu.com/ttsdlstats"),
    GETLICENSE_V1_SERVER("https://upl.baidu.com/offline/auth"),
    GETLICENSE_V2_SERVER("https://upl.baidu.com/auth");


    /* renamed from: a, reason: collision with root package name */
    public String f10202a;

    y2(String str) {
        this.f10202a = str;
    }

    public String a() {
        try {
            return new URL(this.f10202a).getHost();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String b() {
        String a2 = c4.a().a(this.f10202a, true);
        LoggerProxy.d(y2.class.getName(), "ipUrl: " + a2);
        if (!a2.isEmpty()) {
            return a2;
        }
        return this.f10202a;
    }
}
