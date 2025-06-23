package com.kwad.sdk.core.download.a;

import com.kwad.sdk.api.KsAppDownloadListener;

/* loaded from: classes11.dex */
public abstract class a implements KsAppDownloadListener {
    public String downloadId;

    public a() {
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadStarted() {
    }

    public void onPaused(int i) {
    }

    public final String ow() {
        return this.downloadId;
    }

    public a(String str) {
        this.downloadId = str;
    }
}
