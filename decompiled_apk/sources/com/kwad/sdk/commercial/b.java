package com.kwad.sdk.commercial;

import XIXIX.OOXIXo;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.model.HybridLoadMsg;
import com.kwad.sdk.commercial.model.WebViewCommercialMsg;
import com.kwad.sdk.commercial.model.WebViewLoadMsg;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bp;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.t;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.c;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class b {
    private static float aoT = -1.0f;
    private static double aoU = -1.0d;
    private static final AtomicBoolean aoV = new AtomicBoolean();
    private static boolean aoW;
    private static volatile boolean aoX;
    private static List<c> aoY;
    private static a aoZ;
    private static Map<String, com.kwad.sdk.commercial.c.c> apa;

    /* loaded from: classes11.dex */
    public interface a {
        @WorkerThread
        boolean Ai();

        @WorkerThread
        boolean Aj();

        @WorkerThread
        JSONObject Ak();

        String Al();

        @WorkerThread
        void j(String str, String str2, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Bo() {
        try {
            apa = new HashMap();
            JSONObject Ak = aoZ.Ak();
            if (Ak == null) {
                return;
            }
            Iterator<String> keys = Ak.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject = Ak.optJSONObject(next);
                if (optJSONObject != null) {
                    a(next, optJSONObject.optJSONArray(MapBundleKey.OfflineMapKey.OFFLINE_RATION));
                    b(next, optJSONObject.optJSONArray("ratioApmRL"));
                }
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static synchronized void a(final a aVar, final boolean z) {
        synchronized (b.class) {
            if (aoW) {
                return;
            }
            aoW = true;
            aoZ = aVar;
            g.execute(new az() { // from class: com.kwad.sdk.commercial.b.1
                @Override // com.kwad.sdk.utils.az
                public final void doTask() {
                    b.b(a.this, z);
                    b.Bo();
                    b.aoV.set(true);
                    b.nq();
                }
            });
        }
    }

    private static void b(String str, JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    Object obj = jSONArray.get(i);
                    if (obj instanceof String) {
                        com.kwad.sdk.commercial.c.c cVar = new com.kwad.sdk.commercial.c.c();
                        String a2 = a(cVar, (String) obj);
                        com.kwad.sdk.commercial.c.c cVar2 = apa.get(a2);
                        if (cVar2 != null) {
                            cVar2.apy = true;
                            cVar2.apv = Double.parseDouble(str);
                        } else {
                            cVar.apy = true;
                            cVar.apv = Double.parseDouble(str);
                            apa.put(a2, cVar);
                        }
                    }
                }
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    public static synchronized void d(c cVar) {
        synchronized (b.class) {
            try {
                if (com.kwad.framework.a.a.md.booleanValue()) {
                    if (cVar.category.equals(ILoggerReporter.Category.ERROR_LOG)) {
                        com.kwad.sdk.core.e.c.e("KCLogReporter", "reportItem: " + cVar);
                    } else {
                        com.kwad.sdk.core.e.c.d("KCLogReporter", "reportItem: " + cVar);
                    }
                }
                if (!aoV.get()) {
                    c(cVar);
                } else {
                    b(cVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void e(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Br().cz(ILoggerReporter.Category.APM_LOG).i(0.01d).N("ad_sdk_reward_check_result", "check_type").a(BusinessType.AD_REWARD).t(aVar).a(new com.kwai.adclient.kscommerciallogger.model.b("RESULT_CHECK_REWARD")));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void f(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Br().cz(ILoggerReporter.Category.APM_LOG).i(0.5d).N("ad_sdk_webview_track", "scene_id").a(BusinessType.AD_WEBVIEW).t(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aUS));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void g(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Br().cz(ILoggerReporter.Category.ERROR_LOG).i(0.01d).N("ad_sdk_reward_performance", "reward_type").a(BusinessType.AD_REWARD).t(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.aVu));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void h(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Br().cz(ILoggerReporter.Category.APM_LOG).i(0.1d).N("ad_sdk_splash_load", "status").a(BusinessType.AD_SPLASH).t(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aUS));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void i(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Br().cz(ILoggerReporter.Category.APM_LOG).i(0.1d).N("ad_sdk_splash_preload", "status").a(BusinessType.AD_SPLASH).t(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aUS));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void j(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Br().cz(ILoggerReporter.Category.APM_LOG).i(0.01d).N("ad_sdk_splash_cache", "cache").a(BusinessType.AD_SPLASH).t(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aUR));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void k(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Br().cz(ILoggerReporter.Category.APM_LOG).i(0.01d).N("ad_sdk_splash_show", "status").a(BusinessType.AD_SPLASH).t(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aUS));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void l(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Br().cz(ILoggerReporter.Category.ERROR_LOG).i(1.0d).N("ad_sdk_splash_monitor_view_error", "status").a(BusinessType.AD_SPLASH).t(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aUS));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void m(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Br().cz(ILoggerReporter.Category.ERROR_LOG).i(1.0d).N("ad_sdk_splash_monitor_template_data_error", "status").a(BusinessType.AD_SPLASH).t(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aUS));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void n(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Br().cz(ILoggerReporter.Category.ERROR_LOG).i(1.0d).N("ad_sdk_splash_monitor_errorcode_error", "status").a(BusinessType.AD_SPLASH).t(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aUS));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void nq() {
        synchronized (b.class) {
            try {
                List<c> list = aoY;
                if (list == null) {
                    return;
                }
                Iterator<c> it = list.iterator();
                while (it.hasNext()) {
                    b(it.next());
                }
                aoY.clear();
                aoY = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void o(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Br().cz(ILoggerReporter.Category.APM_LOG).i(0.01d).N("ad_sdk_block_info", "block").a(com.kwai.adclient.kscommerciallogger.model.b.aVl).t(aVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void p(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Br().cz(ILoggerReporter.Category.APM_LOG).i(0.01d).N("ad_image_load_perf", "image_perf").t(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.aVu));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void q(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Br().cz(ILoggerReporter.Category.APM_LOG).i(1.0d).N("ad_thread_monitor", "thread_perf").t(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.aVu));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void r(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Br().cz(ILoggerReporter.Category.APM_LOG).i(0.001d).N("ad_video_load_perf", "video_load_perf").cA("ad_video_load_perf").t(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.aVu));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void s(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Br().cz(ILoggerReporter.Category.APM_LOG).i(0.001d).N("ad_video_load_failed", "video_load_failed").cA("ad_video_load_failed").t(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.aVu));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void c(c cVar) {
        if (aoY == null) {
            aoY = new CopyOnWriteArrayList();
        }
        aoY.add(cVar);
    }

    public static void c(boolean z, com.kwad.sdk.commercial.c.a aVar) {
        String str;
        if (z) {
            str = "ad_sdk_reward_page_show";
        } else {
            str = "ad_sdk_fullscreen_page_show";
        }
        try {
            d(c.Br().cz(ILoggerReporter.Category.APM_LOG).i(0.01d).N(str, "page_status").a(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).t(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aUI));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void a(String str, JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    Object obj = jSONArray.get(i);
                    if (obj instanceof String) {
                        com.kwad.sdk.commercial.c.c cVar = new com.kwad.sdk.commercial.c.c();
                        String a2 = a(cVar, (String) obj);
                        com.kwad.sdk.commercial.c.c cVar2 = apa.get(a2);
                        if (cVar2 != null) {
                            cVar2.apx = true;
                            cVar2.apu = Double.parseDouble(str);
                        } else {
                            cVar.apx = true;
                            cVar.apu = Double.parseDouble(str);
                            apa.put(a2, cVar);
                        }
                    }
                }
            } catch (JSONException e) {
                ServiceProvider.reportSdkCaughtException(e);
            }
        }
    }

    public static void d(boolean z, com.kwad.sdk.commercial.c.a aVar) {
        String str;
        if (z) {
            str = "ad_sdk_reward_callback_interaction";
        } else {
            str = "ad_sdk_fullscreen_callback_interaction";
        }
        try {
            d(c.Br().cz(ILoggerReporter.Category.APM_LOG).i(0.01d).N(str, "callback_type").a(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).t(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aUS));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void e(boolean z, com.kwad.sdk.commercial.c.a aVar) {
        String str;
        if (z) {
            str = "ad_sdk_reward_callback_load";
        } else {
            str = "ad_sdk_fullscreen_callback_load";
        }
        try {
            d(c.Br().cz(ILoggerReporter.Category.APM_LOG).i(0.01d).N(str, "callback_type").a(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).t(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aUS));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void f(boolean z, com.kwad.sdk.commercial.c.a aVar) {
        String str;
        if (z) {
            str = "ad_sdk_reward_play_error";
        } else {
            str = "ad_sdk_fullscreen_play_error";
        }
        try {
            d(c.Br().cz(ILoggerReporter.Category.ERROR_LOG).i(1.0d).N(str, "reward_type").a(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).t(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.aVl));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void g(boolean z, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Br().cz(ILoggerReporter.Category.APM_LOG).i(z ? 1.0d : 0.01d).N("ad_sdk_splash_single_cache", "status").a(BusinessType.AD_SPLASH).t(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aUR));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void b(c cVar) {
        c.a Pa;
        if (aoX) {
            com.kwad.sdk.commercial.c.b a2 = a(cVar);
            if (aoT == -1.0f) {
                aoT = new Random().nextFloat();
            }
            if (aoU == -1.0d) {
                aoU = new Random().nextFloat();
            }
            if ((aoZ.Aj() || aoT <= a2.apu) && bp.ay(BuildConfig.VERSION_NAME, a2.apw)) {
                try {
                    if (ILoggerReporter.Category.ERROR_LOG.equals(a(cVar.category, cVar))) {
                        Pa = c.a.OZ();
                    } else {
                        Pa = c.a.Pa();
                    }
                    com.kwai.adclient.kscommerciallogger.a.OQ().a(Pa.b(cVar.apg).b(cVar.aph).hu(TextUtils.isEmpty(cVar.tag) ? cVar.eventId : cVar.tag).b(cVar.api).hv(cVar.eventId).A(a(cVar.msg, a2)).Pb());
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        }
    }

    public static void g(JSONObject jSONObject) {
        String str;
        try {
            int optInt = jSONObject.optInt("load_status");
            if (optInt != 3 && optInt != 4 && optInt != 7) {
                str = ILoggerReporter.Category.APM_LOG;
                d(c.Br().cz(str).i(1.0d).j(0.1d).k(0.001d).N("ad_sdk_dynamic_update", "load_status").a(com.kwai.adclient.kscommerciallogger.model.a.aUS).h(jSONObject));
            }
            str = ILoggerReporter.Category.ERROR_LOG;
            d(c.Br().cz(str).i(1.0d).j(0.1d).k(0.001d).N("ad_sdk_dynamic_update", "load_status").a(com.kwai.adclient.kscommerciallogger.model.a.aUS).h(jSONObject));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static String a(com.kwad.sdk.commercial.c.b bVar, String str) {
        try {
            int lastIndexOf = str.lastIndexOf(95);
            int length = str.length() - 1;
            if (str.charAt(length) >= '0' && str.charAt(length) <= '9' && lastIndexOf != -1) {
                bVar.apw = str.substring(lastIndexOf + 1);
                return str.substring(0, lastIndexOf);
            }
        } catch (Throwable unused) {
        }
        return str;
    }

    @NonNull
    private static com.kwad.sdk.commercial.c.b a(c cVar) {
        double d;
        double d2;
        String str;
        com.kwad.sdk.commercial.c.c cVar2;
        com.kwad.sdk.commercial.c.c cVar3;
        com.kwad.sdk.commercial.c.b bVar = new com.kwad.sdk.commercial.c.b();
        try {
            Boolean bool = com.kwad.framework.a.a.md;
            if (bool.booleanValue()) {
                bVar.apu = cVar.ape;
            } else {
                bVar.apu = cVar.apd;
            }
            bVar.apv = cVar.apf;
            if (!apa.containsKey(cVar.eventId) || (cVar3 = apa.get(cVar.eventId)) == null) {
                d = -1.0d;
                d2 = -1.0d;
            } else {
                d = cVar3.apx ? cVar3.apu : -1.0d;
                d2 = cVar3.apy ? cVar3.apv : -1.0d;
                if (!TextUtils.isEmpty(cVar3.apw)) {
                    bVar.apw = cVar3.apw;
                }
            }
            if (TextUtils.isEmpty(cVar.primaryKey) && bool.booleanValue()) {
                throw new Exception("primaryKey为空");
            }
            String str2 = cVar.eventId;
            if (!TextUtils.isEmpty(cVar.primaryKey)) {
                if (cVar.msg.has(cVar.primaryKey)) {
                    str = str2 + "_" + cVar.msg.opt(cVar.primaryKey);
                } else {
                    str = str2 + "_" + cVar.primaryKey;
                }
                if (apa.containsKey(str) && (cVar2 = apa.get(str)) != null) {
                    if (cVar2.apx) {
                        d = cVar2.apu;
                    }
                    if (cVar2.apy) {
                        d2 = cVar2.apv;
                    }
                    if (!TextUtils.isEmpty(cVar2.apw)) {
                        bVar.apw = cVar2.apw;
                    }
                }
            }
            if (d != -1.0d) {
                bVar.apu = d;
            }
            if (d2 != -1.0d) {
                bVar.apv = d2;
            } else {
                bVar.apv = ((h) ServiceProvider.get(h.class)).zu();
            }
            cVar.apd = bVar.apu;
            cVar.apf = bVar.apv;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final a aVar, boolean z) {
        boolean Ai = aVar.Ai();
        aoX = Ai;
        if (Ai) {
            JSONObject jSONObject = new JSONObject();
            t.putValue(jSONObject, "publish_type", 0);
            t.putValue(jSONObject, "plug_sdk", z ? 1 : 0);
            com.kwai.adclient.kscommerciallogger.a OQ = com.kwai.adclient.kscommerciallogger.a.OQ();
            com.kwad.sdk.commercial.a aVar2 = new com.kwad.sdk.commercial.a();
            com.kwai.adclient.kscommerciallogger.a.b bVar = new com.kwai.adclient.kscommerciallogger.a.b() { // from class: com.kwad.sdk.commercial.b.2
                private void M(String str, String str2) {
                    a.this.j(str, str2, false);
                }

                @Override // com.kwai.adclient.kscommerciallogger.a.b
                public final void L(@NonNull String str, @NonNull String str2) {
                    M(str, str2);
                }
            };
            Boolean bool = com.kwad.framework.a.a.md;
            OQ.a(aVar2, bVar, jSONObject, bool.booleanValue(), bool.booleanValue());
            com.kwad.sdk.commercial.h.a.Bz().cM(aVar.Al());
        }
    }

    public static void b(boolean z, com.kwad.sdk.commercial.c.a aVar) {
        String str;
        if (z) {
            str = "ad_sdk_reward_download_error";
        } else {
            str = "ad_sdk_fullscreen_download_error";
        }
        try {
            d(c.Br().cz(ILoggerReporter.Category.ERROR_LOG).i(1.0d).N(str, "download_type").a(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).t(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.aVf));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(String str, HybridLoadMsg hybridLoadMsg) {
        try {
            d(c.Br().cz(str).i(ILoggerReporter.Category.ERROR_LOG.equals(str) ? 1.0d : 0.001d).N("union_web_cache_load_event", "state").a(BusinessType.WEB_CACHE).t(hybridLoadMsg).a(com.kwai.adclient.kscommerciallogger.model.d.aVu));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static String a(String str, c cVar) {
        return (!str.equals(ILoggerReporter.Category.APM_LOG) || aoU >= cVar.apf) ? str : ILoggerReporter.Category.ERROR_LOG;
    }

    public static void a(String str, com.kwai.adclient.kscommerciallogger.model.d dVar, com.kwad.sdk.commercial.c.a aVar) {
        String str2;
        try {
            if (ILoggerReporter.Category.ERROR_LOG.equals(str)) {
                str2 = "ad_sdk_init_error_performance";
            } else {
                str2 = "ad_sdk_init_performance";
            }
            d(c.Br().cz(str).i(0.001d).N(str2, "init_status").a(BusinessType.AD_SDK_INIT).t(aVar).a(dVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(j jVar) {
        try {
            d(c.Br().cz(ILoggerReporter.Category.APM_LOG).i(1.0E-5d).N("ad_perf_monitor_net_success", "network_monitor").t(jVar).a(com.kwai.adclient.kscommerciallogger.model.d.aVu));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(boolean z, com.kwad.sdk.commercial.c.a aVar, com.kwai.adclient.kscommerciallogger.model.d dVar) {
        String str;
        if (z) {
            str = "ad_sdk_reward_load";
        } else {
            str = "ad_sdk_fullscreen_load";
        }
        try {
            d(c.Br().cz(ILoggerReporter.Category.APM_LOG).i(0.01d).N(str, "load_status").a(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).t(aVar).a(dVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(i iVar) {
        try {
            d(c.Br().cz(ILoggerReporter.Category.APM_LOG).i(0.1d).N("ad_perf_monitor_net_error", "network_monitor").t(iVar).a(com.kwai.adclient.kscommerciallogger.model.d.aVu));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(@NonNull com.kwad.sdk.utils.b.a aVar) {
        try {
            d(c.Br().cz(ILoggerReporter.Category.APM_LOG).i(0.01d).N("ad_union_kv_fail_rate", "kv").t(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.aVu));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(boolean z, String str, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Br().cz(ILoggerReporter.Category.ERROR_LOG).i(1.0d).N(str, "reward_type").a(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).t(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.aVl));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, HybridLoadMsg hybridLoadMsg) {
        try {
            d(c.Br().cz(str).i(1.0E-4d).N("union_web_cache_download_event", "state").a(BusinessType.WEB_CACHE).t(hybridLoadMsg).a(com.kwai.adclient.kscommerciallogger.model.d.aVu));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, WebViewLoadMsg webViewLoadMsg) {
        try {
            d(c.Br().cz(str).i(1.0d).N("union_webview_load_event", "state").t(webViewLoadMsg).a(com.kwai.adclient.kscommerciallogger.model.d.aVu));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, WebViewCommercialMsg webViewCommercialMsg) {
        try {
            double d = webViewCommercialMsg.rate;
            if (d >= OOXIXo.f3760XO) {
                t.putValue(webViewCommercialMsg.msg, MapBundleKey.OfflineMapKey.OFFLINE_RATION, d);
            }
            if (TextUtils.isEmpty(webViewCommercialMsg.primaryKey)) {
                webViewCommercialMsg.primaryKey = "web_log";
            }
            d(c.Br().cz(str).i(webViewCommercialMsg.rate).N(webViewCommercialMsg.eventId, webViewCommercialMsg.primaryKey).a(webViewCommercialMsg.biz).a(webViewCommercialMsg.subBiz).h(webViewCommercialMsg.msg).a(com.kwai.adclient.kscommerciallogger.model.d.aVu));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static JSONObject a(JSONObject jSONObject, com.kwad.sdk.commercial.c.b bVar) {
        try {
            t.putValue(jSONObject, MapBundleKey.OfflineMapKey.OFFLINE_RATION, bVar.apu);
            double d = bVar.apu;
            if (d > OOXIXo.f3760XO) {
                t.putValue(jSONObject, "ratio_count", a(1.0d, d, 0));
            }
            t.putValue(jSONObject, "debug_mode", com.kwad.framework.a.a.md.booleanValue() ? 1 : 0);
            t.putValue(jSONObject, "convert_ratio", bVar.apv);
            double d2 = bVar.apv;
            if (d2 > OOXIXo.f3760XO) {
                t.putValue(jSONObject, "convert_ratio_count", a(1.0d, d2, 0));
            }
            return jSONObject;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
            return jSONObject;
        }
    }

    private static double a(double d, double d2, int i) {
        return new BigDecimal(Double.toString(1.0d)).divide(new BigDecimal(Double.toString(d2)), 0, RoundingMode.HALF_UP).doubleValue();
    }
}
