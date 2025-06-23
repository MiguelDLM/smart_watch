package com.tenmeter.smlibrary.utils.videocache;

/* loaded from: classes13.dex */
public class SourceInfo {
    public final long length;
    public final String mime;
    public final String url;

    public SourceInfo(String str, long j, String str2) {
        this.url = str;
        this.length = j;
        this.mime = str2;
    }

    public String toString() {
        return "SourceInfo{url='" + this.url + "', length=" + this.length + ", mime='" + this.mime + "'}";
    }
}
