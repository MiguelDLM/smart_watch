package com.kwad.sdk.commercial.smallApp;

import com.ksad.json.annotation.KsJson;
import java.net.URL;

@KsJson
/* loaded from: classes11.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String apO;
    public String apP;
    public String apQ;
    public String apj;
    public String apq;
    public int status;
    public String url;

    private b(JumpFrom jumpFrom) {
        if (jumpFrom != null) {
            this.apQ = jumpFrom.getValue();
        }
    }

    public static b a(JumpFrom jumpFrom) {
        return new b(jumpFrom);
    }

    public final b cR(String str) {
        this.url = str;
        try {
            URL url = new URL(str);
            this.apj = url.getHost();
            this.apq = url.getPath();
        } catch (Throwable unused) {
        }
        return this;
    }

    public final b cS(String str) {
        this.apO = str;
        return this;
    }

    public final b cT(String str) {
        this.apP = str;
        return this;
    }

    public final b cm(int i) {
        this.status = i;
        return this;
    }
}
