package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.client;

/* loaded from: classes10.dex */
class SystemClock implements Clock {
    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.client.Clock
    public long getCurrentTime() {
        return System.currentTimeMillis();
    }
}
