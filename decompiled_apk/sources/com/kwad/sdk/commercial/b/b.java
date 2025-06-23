package com.kwad.sdk.commercial.b;

import com.ksad.json.annotation.KsJson;
import java.net.URL;

@KsJson
/* loaded from: classes11.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String apj;
    public String apq;
    public String apr;
    public int aps;
    public int apt;
    public int status;
    public String url;

    public static b Bt() {
        return new b();
    }

    public final b cB(String str) {
        this.url = str;
        try {
            URL url = new URL(str);
            this.apj = url.getHost();
            this.apq = url.getPath();
        } catch (Throwable unused) {
        }
        return this;
    }

    public final b cC(String str) {
        this.apr = str;
        return this;
    }

    public final b cf(int i) {
        this.status = i;
        return this;
    }

    public final b cg(int i) {
        this.aps = i;
        return this;
    }

    public final b ch(int i) {
        this.apt = i;
        return this;
    }
}
