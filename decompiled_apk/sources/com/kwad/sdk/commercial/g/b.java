package com.kwad.sdk.commercial.g;

import com.ksad.json.annotation.KsJson;
import java.net.URL;

@KsJson
/* loaded from: classes11.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public int OP;
    public String apj;
    public String apq;
    public int status;
    public String url;

    public static b By() {
        return new b();
    }

    public final b cL(String str) {
        this.url = str;
        try {
            URL url = new URL(str);
            this.apj = url.getHost();
            this.apq = url.getPath();
        } catch (Throwable unused) {
        }
        return this;
    }

    public final b ck(int i) {
        this.status = i;
        return this;
    }

    public final b cl(int i) {
        this.OP = i;
        return this;
    }
}
