package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.entity;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpEntity;

/* loaded from: classes10.dex */
public class GzipDecompressingEntity extends DecompressingEntity {
    public GzipDecompressingEntity(HttpEntity httpEntity) {
        super(httpEntity, GZIPInputStreamFactory.getInstance());
    }
}
