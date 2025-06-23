package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods;

import java.net.URI;

/* loaded from: classes10.dex */
public class HttpPost extends HttpEntityEnclosingRequestBase {
    public static final String METHOD_NAME = "POST";

    public HttpPost() {
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpRequestBase, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpUriRequest
    public String getMethod() {
        return "POST";
    }

    public HttpPost(URI uri) {
        setURI(uri);
    }

    public HttpPost(String str) {
        setURI(URI.create(str));
    }
}
