package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.routing.HttpRoute;

/* loaded from: classes10.dex */
public interface BackoffManager {
    void backOff(HttpRoute httpRoute);

    void probe(HttpRoute httpRoute);
}
