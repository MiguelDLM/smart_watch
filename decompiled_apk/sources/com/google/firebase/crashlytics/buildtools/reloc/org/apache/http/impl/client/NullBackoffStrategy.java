package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.client;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponse;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.ConnectionBackoffStrategy;

/* loaded from: classes10.dex */
public class NullBackoffStrategy implements ConnectionBackoffStrategy {
    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.ConnectionBackoffStrategy
    public boolean shouldBackoff(HttpResponse httpResponse) {
        return false;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.ConnectionBackoffStrategy
    public boolean shouldBackoff(Throwable th) {
        return false;
    }
}
