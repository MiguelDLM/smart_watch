package com.kwad.components.ad.splashscreen;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.ad.splashscreen.monitor.SplashMonitorInfo;
import com.kwad.components.core.video.j;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.i;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class SplashPreloadManager {
    private HashMap<String, PreLoadItem> Cn;
    private List<String> Co;
    private volatile SharedPreferences Cp;
    private final Object mLock;

    @KsJson
    /* loaded from: classes11.dex */
    public static class PreLoadItem extends com.kwad.sdk.core.response.a.a implements Serializable {
        public long cacheTime;
        public long expiredTime;
        public String preloadId;
    }

    /* loaded from: classes11.dex */
    public static class a {
        private static final SplashPreloadManager Cq = new SplashPreloadManager(0);
    }

    public /* synthetic */ SplashPreloadManager(byte b) {
        this();
    }

    public static File U(String str) {
        if (str != null) {
            com.kwad.sdk.core.e.c.d("PreloadManager", "getVideoFile preloadId " + str + "  url " + str);
            File bZ = com.kwad.sdk.core.diskcache.b.a.DM().bZ(str);
            if (bZ != null && bZ.exists()) {
                return bZ;
            }
            return null;
        }
        return null;
    }

    @AnyThread
    public static boolean f(AdResultData adResultData) {
        if (!adResultData.getAdTemplateList().isEmpty()) {
            AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                return com.kwad.sdk.core.response.b.a.bc(adTemplate.adInfoList.get(0));
            }
        }
        return false;
    }

    @AnyThread
    public static boolean g(AdResultData adResultData) {
        if (!adResultData.getAdTemplateList().isEmpty()) {
            AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                return com.kwad.sdk.core.response.b.a.bb(adTemplate.adInfoList.get(0));
            }
        }
        return false;
    }

    private void init() {
        Context context = ServiceProvider.getContext();
        if (context != null) {
            this.Cp = context.getSharedPreferences("ksadsdk_splash_preload_id_list", 0);
            initData();
        }
    }

    private void initData() {
        Map<String, ?> all = this.Cp.getAll();
        ArrayList arrayList = new ArrayList();
        for (String str : all.keySet()) {
            PreLoadItem preLoadItem = new PreLoadItem();
            try {
                Object obj = all.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!TextUtils.isEmpty(str2)) {
                        preLoadItem.parseJson(new JSONObject(str2));
                        if (!TextUtils.isEmpty(preLoadItem.preloadId)) {
                            File bZ = com.kwad.sdk.core.diskcache.b.a.DM().bZ(preLoadItem.preloadId);
                            if (bZ != null && bZ.exists()) {
                                synchronized (this.mLock) {
                                    try {
                                        this.Cn.put(str, preLoadItem);
                                        if (!this.Co.contains(str)) {
                                            this.Co.add(str);
                                        }
                                    } catch (Throwable th) {
                                        throw th;
                                        break;
                                    }
                                }
                            } else {
                                arrayList.add(preLoadItem.preloadId);
                                com.kwad.sdk.core.e.c.d("PreloadManager", "Remove null file list " + preLoadItem.preloadId);
                            }
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            } catch (Exception e) {
                com.kwad.sdk.core.e.c.printStackTrace(e);
            }
        }
        SharedPreferences.Editor edit = this.Cp.edit();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            edit.remove((String) it.next());
        }
        edit.apply();
    }

    private void ky() {
        int size;
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.mLock) {
            try {
                ArrayList<String> arrayList = new ArrayList();
                for (String str : this.Cn.keySet()) {
                    PreLoadItem preLoadItem = this.Cn.get(str);
                    if (preLoadItem != null && preLoadItem.expiredTime < currentTimeMillis) {
                        arrayList.add(str);
                    }
                }
                SharedPreferences.Editor edit = this.Cp.edit();
                for (String str2 : arrayList) {
                    this.Co.remove(str2);
                    this.Cn.remove(str2);
                    edit.remove(str2);
                    com.kwad.sdk.core.diskcache.b.a.DM().remove(str2);
                }
                edit.apply();
                size = this.Co.size();
            } finally {
            }
        }
        if (size > 30) {
            com.kwad.sdk.core.e.c.d("PreloadManager", "大于 30 按失效日期远近顺序移除");
            int i = size - 15;
            for (int i2 = 0; i2 < i; i2++) {
                String str3 = "";
                synchronized (this.mLock) {
                    try {
                        long j = Long.MAX_VALUE;
                        for (PreLoadItem preLoadItem2 : this.Cn.values()) {
                            long j2 = preLoadItem2.expiredTime;
                            if (j2 < j) {
                                str3 = preLoadItem2.preloadId;
                                j = j2;
                            }
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            this.Co.remove(str3);
                            this.Cn.remove(str3);
                            this.Cp.edit().remove(str3).apply();
                            com.kwad.sdk.core.e.c.d("PreloadManager", "移除 preloadId = " + str3 + " expiredTime =  " + j);
                        }
                    } finally {
                    }
                }
                if (!TextUtils.isEmpty(str3)) {
                    com.kwad.sdk.core.diskcache.b.a.DM().remove(str3);
                }
            }
        }
    }

    @AnyThread
    public static SplashPreloadManager kz() {
        SplashPreloadManager splashPreloadManager = a.Cq;
        if (splashPreloadManager.Cp == null) {
            splashPreloadManager.init();
        }
        return splashPreloadManager;
    }

    @AnyThread
    private void o(AdInfo adInfo) {
        PreLoadItem preLoadItem = new PreLoadItem();
        preLoadItem.cacheTime = System.currentTimeMillis();
        preLoadItem.expiredTime = System.currentTimeMillis() + (adInfo.adPreloadInfo.validityPeriod * 1000);
        preLoadItem.preloadId = com.kwad.sdk.core.response.b.a.aY(adInfo);
        synchronized (this.mLock) {
            try {
                this.Cn.put(adInfo.adPreloadInfo.preloadId, preLoadItem);
                if (!this.Co.contains(adInfo.adPreloadInfo.preloadId)) {
                    this.Co.add(adInfo.adPreloadInfo.preloadId);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.Cp != null) {
            SharedPreferences.Editor edit = this.Cp.edit();
            edit.putString(adInfo.adPreloadInfo.preloadId, preLoadItem.toJson().toString());
            edit.apply();
        }
    }

    private static boolean p(AdInfo adInfo) {
        if (com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.CS) && com.kwad.sdk.core.response.b.a.bc(adInfo)) {
            return true;
        }
        return false;
    }

    @AnyThread
    private boolean q(AdInfo adInfo) {
        Object valueOf;
        if (p(adInfo)) {
            return KSImageLoader.isImageExist(com.kwad.sdk.core.response.b.a.aT(adInfo).materialUrl);
        }
        String str = adInfo.adPreloadInfo.preloadId;
        if (str != null) {
            File bZ = com.kwad.sdk.core.diskcache.b.a.DM().bZ(str);
            StringBuilder sb = new StringBuilder("check preloadId ");
            sb.append(str);
            sb.append(" file exists ");
            if (bZ == null) {
                valueOf = "null";
            } else {
                valueOf = Boolean.valueOf(bZ.exists());
            }
            sb.append(valueOf);
            com.kwad.sdk.core.e.c.d("PreloadManager", sb.toString());
            if (bZ != null && bZ.exists()) {
                return true;
            }
        }
        return false;
    }

    public final List<String> R() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.mLock) {
            try {
                com.kwad.sdk.core.e.c.d("PreloadManager", "getPreloadIdList start ");
                for (int i = 0; i < this.Co.size(); i++) {
                    String str = this.Co.get(i);
                    File bZ = com.kwad.sdk.core.diskcache.b.a.DM().bZ(str);
                    if (bZ != null && bZ.exists()) {
                        arrayList.add(str);
                    }
                }
                com.kwad.sdk.core.e.c.d("PreloadManager", "getPreloadIdList end ");
            } catch (Throwable th) {
                throw th;
            }
        }
        com.kwad.sdk.core.e.c.d("PreloadManager", "getPreloadIdList " + this.Co.size());
        return arrayList;
    }

    @AnyThread
    public final int b(AdResultData adResultData, boolean z) {
        AdTemplate adTemplate;
        String str;
        boolean a2;
        Iterator<AdTemplate> it = adResultData.getAdTemplateList().iterator();
        com.kwad.components.ad.splashscreen.monitor.b.kW();
        com.kwad.components.ad.splashscreen.monitor.b.h(adResultData);
        int i = 0;
        while (true) {
            adTemplate = null;
            if (!it.hasNext()) {
                break;
            }
            AdTemplate next = it.next();
            if (next != null) {
                for (AdInfo adInfo : next.adInfoList) {
                    if (adInfo.adPreloadInfo != null && this.Cp != null) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (!q(adInfo)) {
                            if (com.kwad.sdk.core.response.b.a.bb(adInfo)) {
                                str = com.kwad.sdk.core.response.b.a.K(adInfo);
                            } else if (com.kwad.sdk.core.response.b.a.bc(adInfo)) {
                                str = com.kwad.sdk.core.response.b.a.aT(adInfo).materialUrl;
                            } else {
                                str = null;
                            }
                            if (!TextUtils.isEmpty(str)) {
                                String aY = com.kwad.sdk.core.response.b.a.aY(adInfo);
                                if (adInfo.adPreloadInfo.preloadType == 1 && !ah.isWifiConnected(ServiceProvider.getContext()) && !z) {
                                    com.kwad.components.ad.splashscreen.monitor.b.kW();
                                    com.kwad.components.ad.splashscreen.monitor.b.d(next, 1, SplashMonitorInfo.ERROR_NET_MSG);
                                } else {
                                    com.kwad.sdk.core.e.c.d("PreloadManager", "start Download preloadId " + aY + " true url " + str);
                                    ky();
                                    a.C0856a c0856a = new a.C0856a();
                                    if (p(adInfo)) {
                                        if (KSImageLoader.loadImageSync(str) != null) {
                                            a2 = true;
                                        } else {
                                            a2 = false;
                                        }
                                    } else {
                                        a2 = j.a(str, aY, c0856a);
                                    }
                                    if (a2) {
                                        o(adInfo);
                                        i++;
                                        com.kwad.components.ad.splashscreen.monitor.b.kW();
                                        com.kwad.components.ad.splashscreen.monitor.b.a(next, SystemClock.elapsedRealtime() - elapsedRealtime, 1);
                                    } else {
                                        com.kwad.components.ad.splashscreen.monitor.b.kW();
                                        com.kwad.components.ad.splashscreen.monitor.b.d(next, 4, c0856a.msg);
                                        com.kwad.components.core.o.a.qI().f(next, 1, c0856a.msg);
                                    }
                                }
                            } else {
                                com.kwad.components.ad.splashscreen.monitor.b.kW();
                                com.kwad.components.ad.splashscreen.monitor.b.d(next, 2, SplashMonitorInfo.ERROR_URL_INVALID_MSG);
                            }
                        } else {
                            com.kwad.components.ad.splashscreen.monitor.b.kW();
                            com.kwad.components.ad.splashscreen.monitor.b.a(next, SystemClock.elapsedRealtime() - elapsedRealtime, 2);
                            o(adInfo);
                            i++;
                        }
                    } else {
                        com.kwad.components.ad.splashscreen.monitor.b.kW();
                        com.kwad.components.ad.splashscreen.monitor.b.d(next, 3, SplashMonitorInfo.ERROR_PRELOAD_ID_INVALID_MSG);
                    }
                }
            }
        }
        if (adResultData.getAdTemplateList().size() > 0) {
            adTemplate = adResultData.getAdTemplateList().get(0);
        }
        if (i > 0) {
            i.ao("splashAd_", "onSplashVideoAdCacheSuccess");
            com.kwad.components.core.o.a.qI().e(adTemplate, i);
        } else {
            i.ao("splashAd_", "onSplashVideoAdCacheFailed");
        }
        return i;
    }

    @AnyThread
    public final boolean e(AdResultData adResultData) {
        if (!adResultData.getAdTemplateList().isEmpty()) {
            AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                AdInfo adInfo = adTemplate.adInfoList.get(0);
                if (adInfo.adPreloadInfo != null) {
                    if (p(adInfo)) {
                        return KSImageLoader.isImageExist(com.kwad.sdk.core.response.b.a.aT(adInfo).materialUrl);
                    }
                    return q(adInfo);
                }
            }
        }
        return false;
    }

    private SplashPreloadManager() {
        this.mLock = new Object();
        this.Cn = new HashMap<>();
        this.Co = new ArrayList();
        init();
    }
}
