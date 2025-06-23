package com.kwad.sdk.core.videocache;

/* loaded from: classes11.dex */
public abstract class p implements m {
    protected volatile String aDL;
    protected volatile int length = Integer.MIN_VALUE;
    protected String url;

    public abstract String Hi();

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "UrlSource{url='" + this.url + "', length=" + this.length + ", mime='" + this.aDL + "'}";
    }
}
