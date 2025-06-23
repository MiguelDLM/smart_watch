package com.kwad.components.ad.feed.monitor;

import com.kwad.components.ad.feed.monitor.FeedPageInfo;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.l;
import com.kwad.sdk.utils.t;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class b {
    public static void a(AdTemplate adTemplate, int i, int i2, String str, String str2, long j) {
        if (i2 == 1 && adTemplate.mHasReportVideoLoad) {
            return;
        }
        if (i2 == 1) {
            adTemplate.mHasReportVideoLoad = true;
        }
        a(new FeedPageInfo().setStatus(3).setType(adTemplate.type).setLoadStatus(i).setResourceLoadDuration(j).setMaterialType(i2).setMaterialUrl(str).setErrorMsg(str2).setAdTemplate(adTemplate), i == 2);
    }

    public static void aY() {
        a("ad_sdk_feed_adnum_monitor", new FeedErrorInfo(), 1.0E-4d);
    }

    public static void aZ() {
        com.kwad.sdk.commercial.b.f(new FeedWebViewInfo().setEvent("webview_init").setSceneId("ad_feed"));
    }

    private static void b(com.kwad.sdk.commercial.c.a aVar) {
        try {
            com.kwad.sdk.commercial.b.d(c.Br().cz(ILoggerReporter.Category.APM_LOG).i(0.01d).N("ad_sdk_feed_callback", "callback_type").a(BusinessType.AD_FEED).t(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aUS));
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.e("reportFeedCallback", e.toString());
        }
    }

    private static List<FeedPageInfo.a> c(List<KsFeedAd> list) {
        ArrayList arrayList = new ArrayList();
        for (KsFeedAd ksFeedAd : list) {
            if (ksFeedAd instanceof com.kwad.components.ad.feed.c) {
                AdInfo dS = e.dS(((com.kwad.components.ad.feed.c) ksFeedAd).getAdTemplate());
                arrayList.add(new FeedPageInfo.a().d(com.kwad.sdk.core.response.b.a.J(dS)).u(com.kwad.sdk.core.response.b.a.bd(dS)).o(com.kwad.sdk.core.response.b.a.ba(dS)));
            }
        }
        return arrayList;
    }

    public static void d(int i, String str) {
        a((com.kwad.sdk.commercial.c.a) new FeedPageInfo().setStatus(9).setErrorCode(i).setErrorMsg(str), true);
    }

    public static void e(int i, String str) {
        a(new FeedPageInfo().setStatus(10).setLoadStatus(i).setErrorMsg(str), i == 2);
    }

    public static void f(int i, String str) {
        a("ad_sdk_feed_request_monitor", (FeedErrorInfo) new FeedErrorInfo().setErrorCode(i).setErrorMsg(str), 1.0d);
    }

    public static void s(int i) {
        a(new FeedPageInfo().setStatus(1).setAdNum(i));
    }

    public static void t(int i) {
        a(new FeedPageInfo().setStatus(2).setAdNum(i));
    }

    public static void f(AdTemplate adTemplate) {
        com.kwad.sdk.commercial.b.f(new FeedWebViewInfo().setEvent("ad_show").setSceneId("ad_feed").setAdTemplate(adTemplate));
    }

    public static void e(AdTemplate adTemplate) {
        a(new FeedPageInfo().setStatus(11).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, int i, int i2, long j, String str) {
        a(new FeedPageInfo().setStatus(5).setType(adTemplate.type).setMaterialType(com.kwad.sdk.core.response.b.a.bd(e.dS(adTemplate))).setRenderType(i).setLoadType(adTemplate.loadType).setExpectedRenderType(i2).setErrorMsg(str).setRenderDuration(j).setAdTemplate(adTemplate), (i == 2 || i == 3) ? false : true);
    }

    public static void a(int i, long j) {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "feedLoadOptimizeType", d.Ce());
        t.putValue(jSONObject, "feedLoadOptimizeExternalEnable", d.Ch());
        t.putValue(jSONObject, "isExternal", l.zJ().yV());
        a(new FeedPageInfo().setStatus(6).setAdNum(i).setLoadDataDuration(j).setAbParams(jSONObject.toString()));
    }

    public static void a(AdTemplate adTemplate, int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "feedLoadOptimizeType", d.Ce());
        t.putValue(jSONObject, "feedLoadOptimizeExternalEnable", d.Ch());
        t.putValue(jSONObject, "isExternal", l.zJ().yV());
        a(new FeedPageInfo().setStatus(7).setType(adTemplate.type).setLoadType(adTemplate.loadType).setMaterialType(com.kwad.sdk.core.response.b.a.bd(e.dS(adTemplate))).setRenderType(i).setExpectedRenderType(i2).setAbParams(jSONObject.toString()).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, int i, long j) {
        a(new FeedPageInfo().setStatus(8).setType(adTemplate.type).setMaterialType(com.kwad.sdk.core.response.b.a.bd(e.dS(adTemplate))).setRenderType(i).setConvertDuration(j).setAdTemplate(adTemplate));
    }

    private static void a(com.kwad.sdk.commercial.c.a aVar) {
        a(aVar, false);
    }

    private static void a(com.kwad.sdk.commercial.c.a aVar, boolean z) {
        try {
            com.kwad.sdk.commercial.b.d(c.Br().cz(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).i(z ? 0.01d : 0.001d).N("ad_sdk_feed_load", "status").a(BusinessType.AD_FEED).t(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aUS));
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.e("reportFeedPageLineLog", e.toString());
        }
    }

    public static void a(int i, AdTemplate adTemplate, String str, int i2) {
        b(new FeedPageInfo().setCallbackType(i).setMaterialType(com.kwad.sdk.core.response.b.a.bd(e.dS(adTemplate))).setMaterialUrl(str).setRenderType(i2).setAdTemplate(adTemplate));
    }

    public static void a(long j, List<KsFeedAd> list) {
        if (list == null || list.size() == 0 || !(list.get(0) instanceof com.kwad.components.ad.feed.c)) {
            return;
        }
        b(new FeedPageInfo().setCallbackType(1).setPosId(j).setMaterialInfoList(c(list)).setAdTemplate(((com.kwad.components.ad.feed.c) list.get(0)).getAdTemplate()));
    }

    private static void a(String str, FeedErrorInfo feedErrorInfo, double d) {
        try {
            com.kwad.sdk.commercial.b.d(c.Br().cz(ILoggerReporter.Category.ERROR_LOG).a(BusinessType.AD_FEED).N(str, "default").cA(str).a(com.kwai.adclient.kscommerciallogger.model.a.aUS).t(feedErrorInfo).i(d));
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.d("reportFeedError", e.toString());
        }
    }

    public static void a(int i, int i2, AdTemplate adTemplate) {
        a("ad_sdk_feed_showType_monitor", (FeedErrorInfo) new FeedErrorInfo().setMaterialType(i).setFeedType(i2).setAdTemplate(adTemplate), 1.0d);
    }

    public static void a(long j, int i, int i2, AdTemplate adTemplate) {
        a("ad_sdk_feed_width_monitor", (FeedErrorInfo) new FeedErrorInfo().setWidth(j).setMaterialType(i).setFeedType(i2).setAdTemplate(adTemplate), 1.0d);
    }

    public static void a(int i, int i2, AdTemplate adTemplate, int i3) {
        a("ad_sdk_feed_h5_monitor", (FeedErrorInfo) new FeedErrorInfo().setMaterialType(i2).setErrorType(i3).setErrorCode(i).setAdTemplate(adTemplate), 1.0d);
    }

    public static void a(AdTemplate adTemplate, String str) {
        com.kwad.sdk.commercial.b.f(new FeedWebViewInfo().setEvent("webview_load_url").setSceneId("ad_feed").setUrl(str).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, String str, long j, int i) {
        com.kwad.sdk.commercial.b.f(new FeedWebViewInfo().setEvent("webview_timeout").setSceneId("ad_feed").setTimeType(i).setDurationMs(j).setUrl(str).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, String str, long j) {
        com.kwad.sdk.commercial.b.f(new FeedWebViewInfo().setEvent("webview_load_finish").setSceneId("ad_feed").setDurationMs(j).setUrl(str).setAdTemplate(adTemplate));
    }
}
