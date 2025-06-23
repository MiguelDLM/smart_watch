package com.kwad.sdk.commercial.f;

import com.ksad.json.annotation.KsJson;
import java.net.URL;

@KsJson
/* loaded from: classes11.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String apj;
    public String apq;
    public int status;
    public String url;

    public static b Bx() {
        return new b();
    }

    public final b cK(String str) {
        this.url = str;
        try {
            URL url = new URL(str);
            this.apj = url.getHost();
            this.apq = url.getPath();
        } catch (Throwable unused) {
        }
        return this;
    }

    public final b cj(int i) {
        this.status = i;
        return this;
    }
}
