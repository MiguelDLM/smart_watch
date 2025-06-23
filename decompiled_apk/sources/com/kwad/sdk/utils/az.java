package com.kwad.sdk.utils;

import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes11.dex */
public abstract class az implements Runnable {
    public abstract void doTask();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            doTask();
        } catch (Throwable th) {
            com.kwad.sdk.service.a.e eVar = (com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class);
            if (eVar != null) {
                eVar.gatherException(th);
            }
        }
    }
}
