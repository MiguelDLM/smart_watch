package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol;

/* loaded from: classes10.dex */
public interface HttpContext {
    public static final String RESERVED_PREFIX = "http.";

    Object getAttribute(String str);

    Object removeAttribute(String str);

    void setAttribute(String str, Object obj);
}
