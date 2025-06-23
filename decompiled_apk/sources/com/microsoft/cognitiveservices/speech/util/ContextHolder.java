package com.microsoft.cognitiveservices.speech.util;

import android.content.Context;

/* loaded from: classes11.dex */
public final class ContextHolder {
    private static volatile ContextHolder instance;
    private Context appContext;

    private ContextHolder() {
    }

    public static synchronized ContextHolder getInstance() {
        ContextHolder contextHolder;
        synchronized (ContextHolder.class) {
            try {
                if (instance == null) {
                    instance = new ContextHolder();
                }
                contextHolder = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return contextHolder;
    }

    public Context getContext() {
        return this.appContext;
    }

    public void setContext(Context context) {
        this.appContext = context != null ? context.getApplicationContext() : null;
    }
}
