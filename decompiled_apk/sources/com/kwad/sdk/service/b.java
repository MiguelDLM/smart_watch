package com.kwad.sdk.service;

import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.components.ad.feed.FeedDownloadActivityProxy;
import com.kwad.components.ad.fullscreen.KsFullScreenLandScapeVideoActivityProxy;
import com.kwad.components.ad.fullscreen.KsFullScreenVideoActivityProxy;
import com.kwad.components.ad.reward.KSRewardLandScapeVideoActivityProxy;
import com.kwad.components.ad.reward.KSRewardVideoActivityProxy;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.internal.api.VideoPlayConfigImpl;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.page.d;
import com.kwad.framework.filedownloader.services.FileDownloadServiceProxy;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes11.dex */
public final class b {
    private static final Map<Class<?>, Class<?>> aOY = new HashMap();
    private static final Map<Class<?>, Class<?>> aOZ = new HashMap();
    private static boolean aPa = false;
    private static boolean aPb = false;

    private static synchronized void Lr() {
        synchronized (b.class) {
            if (aPa) {
                return;
            }
            Ls();
            aPa = true;
        }
    }

    @ForInvoker(methodId = "initComponentProxyForInvoker")
    private static void Ls() {
        FeedDownloadActivityProxy.register();
        KsFullScreenLandScapeVideoActivityProxy.register();
        KsFullScreenVideoActivityProxy.register();
        KSRewardLandScapeVideoActivityProxy.register();
        KSRewardVideoActivityProxy.register();
        com.kwad.components.core.page.a.register();
        AdWebViewActivityProxy.register();
        AdWebViewVideoActivityProxy.register();
        d.register();
        com.kwad.components.core.r.a.a.register();
        FileDownloadServiceProxy.register();
        com.kwad.sdk.collector.b.a.register();
        a.register();
    }

    private static synchronized void Lt() {
        synchronized (b.class) {
            if (aPb) {
                return;
            }
            Lu();
            aPb = true;
        }
    }

    @ForInvoker(methodId = "initModeImplForInvoker")
    private static void Lu() {
        KSAdVideoPlayConfigImpl.register();
        com.kwad.components.core.internal.api.d.register();
        VideoPlayConfigImpl.register();
        com.kwad.components.core.p.b.register();
        SceneImpl.register();
    }

    public static void a(Class<?> cls, Class<?> cls2) {
        aOY.put(cls, cls2);
    }

    public static void b(Class cls, Class cls2) {
        aOZ.put(cls, cls2);
    }

    public static Class<?> g(Class<?> cls) {
        Lr();
        return aOY.get(cls);
    }

    public static Class<?> h(Class<?> cls) {
        Lt();
        return aOZ.get(cls);
    }

    public static void init() {
        Lr();
        Lt();
    }
}
