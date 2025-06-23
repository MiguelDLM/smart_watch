package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http;

import java.io.IOException;

/* loaded from: classes10.dex */
public class NoHttpResponseException extends IOException {
    private static final long serialVersionUID = -7658940387386078766L;

    public NoHttpResponseException(String str) {
        super(HttpException.clean(str));
    }
}
