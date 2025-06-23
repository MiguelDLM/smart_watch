package com.baidu.tts;

import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes8.dex */
public class l4 {

    /* renamed from: a, reason: collision with root package name */
    public String f10131a = null;
    public boolean b = false;
    public String c = null;
    public String d = null;

    public void a(String str, int i) {
    }

    public void a(String str, boolean z) {
        this.c = str;
        this.b = z;
    }

    public String a() {
        URL url;
        if (!this.b) {
            return this.f10131a;
        }
        try {
            if (this.f10131a == null) {
                url = new URL("wss://tts.baidu.com/ws/sdktts".replace("ws", "http"));
            } else {
                url = new URL(this.f10131a.replace("ws", "http"));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            url = null;
        }
        if (url != null) {
            this.d = url.getHost();
        }
        return this.f10131a;
    }
}
