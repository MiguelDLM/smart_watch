package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http;

/* loaded from: classes10.dex */
public interface HttpRequestFactory {
    HttpRequest newHttpRequest(RequestLine requestLine) throws MethodNotSupportedException;

    HttpRequest newHttpRequest(String str, String str2) throws MethodNotSupportedException;
}
