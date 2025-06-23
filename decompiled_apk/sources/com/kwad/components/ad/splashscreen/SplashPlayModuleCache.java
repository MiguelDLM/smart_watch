package com.kwad.components.ad.splashscreen;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: classes11.dex */
public final class SplashPlayModuleCache {
    private HashMap<String, WeakReference<com.kwad.components.ad.splashscreen.d.a>> Cm;

    /* loaded from: classes11.dex */
    public enum Holder {
        INSTANCE;

        private SplashPlayModuleCache mInstance = new SplashPlayModuleCache(0);

        Holder() {
        }

        public final SplashPlayModuleCache getInstance() {
            return this.mInstance;
        }
    }

    public /* synthetic */ SplashPlayModuleCache(byte b) {
        this();
    }

    private SplashPlayModuleCache() {
        this.Cm = new HashMap<>(1);
    }
}
