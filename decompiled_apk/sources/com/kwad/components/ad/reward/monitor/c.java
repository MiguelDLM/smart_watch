package com.kwad.components.ad.reward.monitor;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.proxy.PageCreateStage;
import com.kwad.components.core.s.f;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes11.dex */
public final class c {
    public static void K(AdTemplate adTemplate) {
        int i;
        AdInfo dS = e.dS(adTemplate);
        RewardMonitorInfo pageStatus = new RewardMonitorInfo().setPageStatus(7);
        if (adTemplate.isLoadFromCache()) {
            i = 2;
        } else {
            i = 1;
        }
        com.kwad.sdk.commercial.b.c(true, (com.kwad.sdk.commercial.c.a) pageStatus.setLoadType(i).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dS)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dS)).setAdTemplate(adTemplate));
    }

    public static void L(AdTemplate adTemplate) {
        int i;
        AdInfo dS = e.dS(adTemplate);
        RewardMonitorInfo pageStatus = new RewardMonitorInfo().setPageStatus(8);
        if (adTemplate.isLoadFromCache()) {
            i = 2;
        } else {
            i = 1;
        }
        com.kwad.sdk.commercial.b.c(true, (com.kwad.sdk.commercial.c.a) pageStatus.setLoadType(i).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dS)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dS)).setAdTemplate(adTemplate));
    }

    public static void a(boolean z, long j) {
        com.kwad.sdk.commercial.b.a(z, new RewardMonitorInfo().setLoadStatus(1).setPosId(j), com.kwai.adclient.kscommerciallogger.model.a.aUS);
    }

    public static void b(boolean z, long j) {
        com.kwad.sdk.commercial.b.a(z, new RewardMonitorInfo().setLoadStatus(5).setPosId(j), com.kwai.adclient.kscommerciallogger.model.a.aUS);
    }

    public static void c(boolean z, long j) {
        com.kwad.sdk.commercial.b.a(z, new RewardMonitorInfo().setLoadStatus(6).setPosId(j), com.kwai.adclient.kscommerciallogger.model.a.aUS);
    }

    public static void d(boolean z, @NonNull AdTemplate adTemplate) {
        int i;
        AdInfo dS = e.dS(adTemplate);
        RewardMonitorInfo loadStatus = new RewardMonitorInfo().setLoadStatus(7);
        if (adTemplate.isLoadFromCache()) {
            i = 2;
        } else {
            i = 1;
        }
        com.kwad.sdk.commercial.b.a(z, loadStatus.setLoadType(i).setCreativeId(com.kwad.sdk.core.response.b.a.J(dS)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dS)).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dS) * 1000).setAdTemplate(adTemplate), com.kwai.adclient.kscommerciallogger.model.a.aUS);
    }

    public static void e(boolean z, AdTemplate adTemplate) {
        int i;
        AdInfo dS = e.dS(adTemplate);
        RewardMonitorInfo pageStatus = new RewardMonitorInfo().setPageStatus(6);
        if (adTemplate.isLoadFromCache()) {
            i = 2;
        } else {
            i = 1;
        }
        com.kwad.sdk.commercial.b.c(z, pageStatus.setLoadType(i).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dS)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dS)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dS) * 1000).setAdTemplate(adTemplate));
    }

    public static void f(boolean z, AdTemplate adTemplate) {
        int i;
        if (adTemplate == null) {
            return;
        }
        AdInfo dS = e.dS(adTemplate);
        RewardMonitorInfo pageStatus = new RewardMonitorInfo().setPageStatus(5);
        if (adTemplate.isLoadFromCache()) {
            i = 2;
        } else {
            i = 1;
        }
        com.kwad.sdk.commercial.b.c(z, pageStatus.setLoadType(i).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dS)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dS)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dS) * 1000).setAdTemplate(adTemplate));
    }

    public static void g(boolean z, AdTemplate adTemplate) {
        String str;
        RewardWebViewInfo event = new RewardWebViewInfo().setEvent("ad_show");
        if (z) {
            str = "ad_reward";
        } else {
            str = "ad_fullscreen";
        }
        com.kwad.sdk.commercial.b.f(event.setSceneId(str).setAdTemplate(adTemplate));
    }

    public static void h(boolean z, AdTemplate adTemplate) {
        int i;
        AdInfo dS = e.dS(adTemplate);
        RewardMonitorInfo pageStatus = new RewardMonitorInfo().setPageStatus(3);
        if (adTemplate.isLoadFromCache()) {
            i = 2;
        } else {
            i = 1;
        }
        com.kwad.sdk.commercial.b.c(z, pageStatus.setLoadType(i).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dS)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dS)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dS) * 1000).setAdTemplate(adTemplate));
    }

    public static void i(boolean z, @Nullable AdTemplate adTemplate) {
        String str;
        if (adTemplate != null) {
            if (f.aB(adTemplate.mDataCacheTraceElement)) {
                str = "data_cache";
            } else if (f.aB(adTemplate.mDataLoadTraceElement)) {
                str = "data_load";
            }
            com.kwad.sdk.commercial.b.c(z, new RewardMonitorInfo().setPageStatus(101).setLaunchFrom(str).setSubStage(PageCreateStage.START_LAUNCH.getStage()).setAdTemplate(adTemplate));
        }
        str = "unknown";
        com.kwad.sdk.commercial.b.c(z, new RewardMonitorInfo().setPageStatus(101).setLaunchFrom(str).setSubStage(PageCreateStage.START_LAUNCH.getStage()).setAdTemplate(adTemplate));
    }

    private static boolean k(long j) {
        return j == -1;
    }

    public static void a(boolean z, @NonNull AdTemplate adTemplate, int i, long j) {
        long loadDataTime = (j <= 0 || adTemplate.getLoadDataTime() <= 0) ? -1L : adTemplate.getLoadDataTime() - j;
        long j2 = a(loadDataTime) ? -1L : loadDataTime;
        AdInfo dS = e.dS(adTemplate);
        com.kwad.sdk.commercial.b.a(z, new RewardMonitorInfo().setLoadStatus(2).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setAdCount(i).setLoadDataDuration(j2).setCreativeId(com.kwad.sdk.core.response.b.a.J(dS)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dS)).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dS) * 1000).setAdTemplate(adTemplate), com.kwai.adclient.kscommerciallogger.model.a.aUS);
    }

    public static void b(boolean z, AdTemplate adTemplate, int i, long j) {
        adTemplate.setDownloadFinishTime(SystemClock.elapsedRealtime());
        AdInfo dS = e.dS(adTemplate);
        long loadDataTime = adTemplate.getLoadDataTime() - j;
        long downloadFinishTime = adTemplate.getDownloadFinishTime() - adTemplate.getLoadDataTime();
        long downloadFinishTime2 = adTemplate.getDownloadFinishTime() - j;
        if (a(loadDataTime, downloadFinishTime, downloadFinishTime2)) {
            loadDataTime = -1;
            downloadFinishTime = -1;
            downloadFinishTime2 = -1;
        }
        com.kwad.sdk.commercial.b.a(z, new RewardMonitorInfo().setLoadStatus(3).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setAdCount(i).setLoadDataDuration(loadDataTime).setDownloadDuration(downloadFinishTime).setTotalDuration(downloadFinishTime2).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dS)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dS)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dS) * 1000).setAdTemplate(adTemplate), com.kwai.adclient.kscommerciallogger.model.a.aUS);
    }

    public static void c(AdTemplate adTemplate, int i, String str) {
        AdInfo dS = e.dS(adTemplate);
        com.kwad.sdk.commercial.b.c(true, (com.kwad.sdk.commercial.c.a) new RewardMonitorInfo().setPageStatus(9).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dS)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dS)).setErrorMsg(str).setErrorCode(i).setAdTemplate(adTemplate));
    }

    public static void c(boolean z, @Nullable AdTemplate adTemplate, String str) {
        com.kwad.sdk.commercial.b.c(z, new RewardMonitorInfo().setPageStatus(101).setSubStage(str).setAdTemplate(adTemplate));
    }

    public static void a(boolean z, int i, String str, long j) {
        com.kwad.sdk.commercial.b.a(z, new RewardMonitorInfo().setLoadStatus(4).setErrorCode(i).setErrorMsg(str).setPosId(j), com.kwai.adclient.kscommerciallogger.model.a.aUO);
    }

    public static void b(boolean z, AdTemplate adTemplate, long j) {
        long j2 = -1;
        if (!k(j)) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - j;
            if (!a(elapsedRealtime)) {
                j2 = elapsedRealtime;
            }
        }
        AdInfo dS = e.dS(adTemplate);
        com.kwad.sdk.commercial.b.c(z, new RewardMonitorInfo().setPageStatus(2).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setRenderDuration(j2).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dS)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dS)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dS) * 1000).setAdTemplate(adTemplate));
    }

    public static void a(boolean z, AdTemplate adTemplate, String str) {
        AdInfo dS = e.dS(adTemplate);
        com.kwad.sdk.commercial.b.b(z, new RewardMonitorInfo().setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dS)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dS)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dS) * 1000).setErrorMsg(str).setAdTemplate(adTemplate));
    }

    public static void a(boolean z, AdTemplate adTemplate, long j) {
        a(z, adTemplate, j, (AdGlobalConfigInfo) null);
    }

    public static void a(boolean z, AdTemplate adTemplate, long j, AdGlobalConfigInfo adGlobalConfigInfo) {
        long loadDataTime = adTemplate.getLoadDataTime();
        long downloadFinishTime = adTemplate.getDownloadFinishTime();
        long j2 = loadDataTime > 0 ? j - loadDataTime : 0L;
        long j3 = downloadFinishTime > 0 ? j - downloadFinishTime : 0L;
        int i = (adGlobalConfigInfo == null || adGlobalConfigInfo.neoPageType == 1) ? 3 : 0;
        AdInfo dS = e.dS(adTemplate);
        com.kwad.sdk.commercial.b.c(z, new RewardMonitorInfo().setPageStatus(1).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setAdSceneType(i).setDataLoadInterval(j2).setDataDownloadInterval(j3).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dS)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dS)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dS) * 1000).setAdTemplate(adTemplate));
    }

    public static void b(boolean z, AdTemplate adTemplate, String str) {
        AdInfo dS = e.dS(adTemplate);
        com.kwad.sdk.commercial.b.c(z, new RewardMonitorInfo().setPageStatus(4).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dS)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dS)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dS) * 1000).setInterceptReason(str).setAdTemplate(adTemplate));
    }

    public static void a(boolean z, String str) {
        com.kwad.sdk.commercial.b.f(new RewardWebViewInfo().setPageType(str).setEvent("webview_init").setSceneId(z ? "ad_reward" : "ad_fullscreen"));
    }

    public static void a(AdTemplate adTemplate, boolean z, String str, String str2) {
        com.kwad.sdk.commercial.b.f(new RewardWebViewInfo().setPageType(str).setEvent("webview_load_url").setSceneId(z ? "ad_reward" : "ad_fullscreen").setUrl(str2).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, boolean z, String str, String str2, long j, int i) {
        com.kwad.sdk.commercial.b.f(new RewardWebViewInfo().setPageType(str).setEvent("webview_timeout").setSceneId(z ? "ad_reward" : "ad_fullscreen").setDurationMs(j).setTimeType(i).setUrl(str2).setAdTemplate(adTemplate));
    }

    public static void a(boolean z, String str, String str2, long j) {
        com.kwad.sdk.commercial.b.f(new RewardWebViewInfo().setPageType(str).setEvent("webview_load_finish").setSceneId(z ? "ad_reward" : "ad_fullscreen").setDurationMs(j).setUrl(str2));
    }

    public static void a(boolean z, @Nullable AdTemplate adTemplate, a aVar, long j, @Nullable com.kwad.sdk.f.a<RewardMonitorInfo> aVar2) {
        com.kwad.sdk.commercial.b.e(z, new RewardMonitorInfo().setCallbackType(aVar.getTypeValue()).setAdTemplate(adTemplate).setPosId(j));
    }

    public static void a(boolean z, a aVar, AdTemplate adTemplate, @Nullable com.kwad.sdk.f.a<RewardMonitorInfo> aVar2) {
        if (adTemplate == null) {
            return;
        }
        RewardMonitorInfo adTemplate2 = new RewardMonitorInfo().setMaterialType(com.kwad.sdk.core.response.b.a.bd(e.dS(adTemplate))).setCallbackType(aVar.getTypeValue()).setAdTemplate(adTemplate);
        if (aVar2 != null) {
            aVar2.accept(adTemplate2);
        }
        com.kwad.sdk.commercial.b.d(z, adTemplate2);
    }

    public static void a(boolean z, AdTemplate adTemplate, long j, int i, long j2) {
        AdInfo dS = e.dS(adTemplate);
        com.kwad.sdk.commercial.b.f(z, new RewardMonitorInfo().setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setCurrentDuration(j).setErrorCode(i).setErrorMsg(String.valueOf(j2)).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dS)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dS)).setVideoDuration(com.kwad.sdk.core.response.b.a.M(dS)).setAdTemplate(adTemplate));
    }

    public static void a(boolean z, @Nullable AdTemplate adTemplate, String str, String str2) {
        com.kwad.sdk.commercial.b.c(z, new RewardMonitorInfo().setPageStatus(101).setSubStage(str).setErrorMsg(str2).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, int i, int i2, boolean z) {
        AdInfo dS = e.dS(adTemplate);
        com.kwad.sdk.commercial.b.g(new RewardMonitorInfo().setCreativeId(com.kwad.sdk.core.response.b.a.J(dS)).setRewardType(!z ? 1 : 0).setTaskType(i).setTaskStep(i2).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dS)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dS) * 1000).setAdTemplate(adTemplate));
    }

    private static boolean a(long... jArr) {
        for (long j : jArr) {
            if (j >= 60000) {
                return true;
            }
        }
        return false;
    }
}
