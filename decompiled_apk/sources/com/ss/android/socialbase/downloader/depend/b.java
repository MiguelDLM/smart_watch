package com.ss.android.socialbase.downloader.depend;

import java.util.List;

/* loaded from: classes13.dex */
public abstract class b implements v {

    /* renamed from: a, reason: collision with root package name */
    private boolean f26249a = false;

    @Override // com.ss.android.socialbase.downloader.depend.v
    public void a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f26249a = true;
    }

    @Override // com.ss.android.socialbase.downloader.depend.v
    public boolean a() {
        return this.f26249a;
    }
}
