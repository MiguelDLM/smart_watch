package com.google.firebase.crashlytics.buildtools.api.net.proxy;

import com.google.firebase.crashlytics.buildtools.api.net.Constants;
import java.net.URI;
import java.net.URL;

/* loaded from: classes10.dex */
public enum ProtocolScheme {
    HTTP,
    HTTPS,
    Other;

    public static ProtocolScheme getType(URL url) {
        return getType(url.getProtocol());
    }

    public static ProtocolScheme getType(URI uri) {
        return getType(uri.getScheme());
    }

    private static ProtocolScheme getType(String str) {
        if (str.equalsIgnoreCase("HTTP")) {
            return HTTP;
        }
        if (str.equalsIgnoreCase(Constants.Http.HTTPS)) {
            return HTTPS;
        }
        return Other;
    }
}
