package com.kwad.sdk.api.a;

import com.kwad.sdk.api.c;

/* loaded from: classes11.dex */
public abstract class b implements Runnable {
    public abstract void doTask();

    @Override // java.lang.Runnable
    public void run() {
        try {
            doTask();
        } catch (Throwable th) {
            c.m(th);
        }
    }
}
