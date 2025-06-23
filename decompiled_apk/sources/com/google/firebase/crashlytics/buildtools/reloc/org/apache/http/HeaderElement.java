package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http;

/* loaded from: classes10.dex */
public interface HeaderElement {
    String getName();

    NameValuePair getParameter(int i);

    NameValuePair getParameterByName(String str);

    int getParameterCount();

    NameValuePair[] getParameters();

    String getValue();
}
