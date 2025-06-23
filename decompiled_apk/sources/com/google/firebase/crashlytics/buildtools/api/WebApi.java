package com.google.firebase.crashlytics.buildtools.api;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpRequestBase;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/* loaded from: classes10.dex */
public interface WebApi {
    public static final String DEFAULT_CODEMAPPING_API_URL = "https://firebasecrashlyticssymbols.googleapis.com";

    void applyCommonHeadersTo(HttpRequestBase httpRequestBase);

    String getCodeMappingApiUrl();

    void setClientType(String str);

    void setClientVersion(String str);

    void setUserAgent(String str);

    void uploadFile(URL url, File file) throws IOException;
}
