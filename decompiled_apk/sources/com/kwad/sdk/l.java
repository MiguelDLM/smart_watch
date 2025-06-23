package com.kwad.sdk;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.kwad.components.core.request.g;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.library.solder.lib.i;
import com.kwad.sdk.api.KsInitCallback;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.loader.DynamicInstallReceiver;
import com.kwad.sdk.api.proxy.BaseProxyActivity;
import com.kwad.sdk.api.proxy.BaseProxyFragmentActivity;
import com.kwad.sdk.api.proxy.IComponentProxy;
import com.kwad.sdk.commercial.b;
import com.kwad.sdk.core.imageloader.ImageLoaderPerfUtil;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ar;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.ba;
import com.kwad.sdk.utils.bl;
import com.kwad.sdk.utils.bo;
import com.kwad.sdk.utils.u;
import com.kwad.sdk.utils.y;
import java.io.File;
import java.util.Map;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class l {
    private long ZL;
    private volatile boolean alN;
    private volatile boolean alO;
    private volatile boolean alP;
    private volatile Boolean alQ;
    private String alR;
    private int alS;
    private boolean alT;

    @Nullable
    private KsLoadManager alU;
    private long alV;
    private long alW;
    private f alX;
    private f alY;
    private f alZ;
    private f ama;
    private volatile boolean amb;
    private boolean amc;
    private boolean amd;
    private String ame;

    /* loaded from: classes11.dex */
    public static class a {
        private static final l amj = new l(0);
    }

    public /* synthetic */ l(byte b) {
        this();
    }

    private void Aa() {
        try {
            com.kwad.sdk.core.diskcache.a.bh(getContext());
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private static void Ab() {
        try {
            com.kwad.components.core.s.m.rI().init();
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private static void Ac() {
        com.kwad.components.core.p.b.rc();
        com.kwad.components.core.p.b.f(com.kwad.sdk.core.config.d.Cs(), com.kwad.sdk.core.config.d.Ct());
    }

    private void Ad() {
        try {
            aw.init(getContext());
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private static void Ae() {
        try {
            com.kwad.sdk.app.b.AW().checkInit();
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private void Af() {
        try {
            com.kwad.library.solder.lib.i.a(new i.a() { // from class: com.kwad.sdk.l.2
                @Override // com.kwad.library.solder.lib.i.a
                public final void b(String str, File file) {
                    com.kwad.sdk.core.download.a.a(str, file, true);
                }

                @Override // com.kwad.library.solder.lib.i.a
                public final void d(String str, Throwable th) {
                    if (th instanceof Exception) {
                        com.kwad.sdk.core.network.idc.a.EE().g(str, th);
                    }
                }

                @Override // com.kwad.library.solder.lib.i.a
                public final int getCorePoolSize() {
                    return com.kwad.sdk.core.config.d.Cv();
                }

                @Override // com.kwad.library.solder.lib.i.a
                public final int getMaxRetryCount() {
                    return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.ati);
                }

                @Override // com.kwad.library.solder.lib.i.a
                public final boolean xL() {
                    return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.ath);
                }
            });
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private static boolean aE(Context context) {
        String processName = ar.getProcessName(context);
        if (!TextUtils.isEmpty(processName) && processName.endsWith("kssdk_remote")) {
            return true;
        }
        return false;
    }

    public static Object c(String str, Object... objArr) {
        try {
            if ("autoRT".equals(str)) {
                return -1;
            }
            if ("getAutoRevertTime".equals(str)) {
                return 10000;
            }
            boolean z = false;
            if ("TRANSFORM_API_HOST".equals(str)) {
                return com.kwad.sdk.core.network.idc.a.EE().Y(objArr[0].toString(), "api");
            }
            if ("reportDynamicUpdate".equals(str)) {
                com.kwad.sdk.commercial.b.g((JSONObject) objArr[0]);
                return Boolean.TRUE;
            }
            if (!"enableDynamic".equals(str) || ServiceProvider.Lw() == null) {
                return null;
            }
            if (ar.isInMainProcess(ServiceProvider.Lw()) && com.kwad.framework.a.a.aev.booleanValue()) {
                z = true;
            }
            return Boolean.valueOf(z);
        } catch (Throwable th) {
            try {
                ServiceProvider.reportSdkCaughtException(th);
            } catch (Throwable unused) {
            }
            return null;
        }
    }

    public static String cd(String str) {
        return com.kwad.sdk.core.a.d.am(str);
    }

    public static String ce(String str) {
        return com.kwad.sdk.core.a.d.getResponseData(str);
    }

    public static void deleteCache() {
        com.kwad.sdk.core.diskcache.b.a.DM().delete();
    }

    private void e(final com.kwad.sdk.f.a aVar) {
        try {
            com.kwad.components.core.request.g.a(new g.b() { // from class: com.kwad.sdk.l.8
                @Override // com.kwad.components.core.request.g.a
                public final void d(@NonNull SdkConfigData sdkConfigData) {
                    com.kwad.sdk.core.e.c.i("KSAdSDK", "onConfigRefresh()");
                    try {
                        l.this.e(sdkConfigData);
                        com.kwad.sdk.f.a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.accept(null);
                        }
                    } catch (Throwable th) {
                        com.kwad.components.core.d.a.reportSdkCaughtException(th);
                    }
                }

                @Override // com.kwad.components.core.request.g.a
                public final void qW() {
                    com.kwad.sdk.core.e.c.i("KSAdSDK", "onCacheLoaded()");
                    l lVar = l.this;
                    l.zT();
                }

                @Override // com.kwad.components.core.request.g.b
                public final void qX() {
                    try {
                        com.kwad.sdk.f.a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.accept(null);
                        }
                    } catch (Throwable th) {
                        com.kwad.components.core.d.a.reportSdkCaughtException(th);
                    }
                }
            });
        } catch (Throwable th) {
            n.l(th);
        }
    }

    public static String getAppId() {
        return ServiceProvider.Lx().appId;
    }

    public static JSONObject getAppInfo() {
        return com.kwad.sdk.core.request.model.a.FI();
    }

    public static String getAppName() {
        return ServiceProvider.Lx().appName;
    }

    public static Context getContext() {
        return ServiceProvider.getContext();
    }

    public static JSONObject getDeviceInfo() {
        return com.kwad.sdk.core.request.model.b.FK().toJson();
    }

    public static String getDid() {
        return aw.getDeviceId();
    }

    public static JSONObject getNetworkInfo() {
        return com.kwad.sdk.core.request.model.d.FN().toJson();
    }

    public static String getSDKVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static SdkConfig getSdkConfig() {
        return ServiceProvider.Lx();
    }

    public static boolean isDebugLogEnable() {
        return ServiceProvider.Lx().enableDebug;
    }

    public static void k(Throwable th) {
        ServiceProvider.reportSdkCaughtException(th);
    }

    public static <T> T newInstance(Class<T> cls) {
        try {
            return (T) com.kwad.sdk.service.b.h(cls).newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void pauseCurrentPlayer() {
        com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
    }

    public static void resumeCurrentPlayer() {
        com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
    }

    public static void setLoadingLottieAnimation(boolean z, @RawRes int i) {
        com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
    }

    public static void setLoadingLottieAnimationColor(boolean z, @ColorInt int i) {
        com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
    }

    public static void setThemeMode(int i) {
        com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
    }

    public static l zJ() {
        return a.amj;
    }

    private synchronized boolean zL() {
        return n.aI(getContext());
    }

    private void zM() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.ZL = elapsedRealtime;
        com.kwad.sdk.service.b.init();
        j.yP();
        zU();
        zV();
        boolean zK = zK();
        Log.d("KSAdSDK", "initSDKModule enableInitStartMode: " + zK);
        if (this.alX == null) {
            this.alX = f.W(this.alV);
        }
        if (!zK) {
            this.alX.report();
        }
        zO();
        zY();
        zZ();
        Af();
        zS();
        if (!zK) {
            e((com.kwad.sdk.f.a) null);
        }
        zP();
        zQ();
        zR();
        zW();
        Ad();
        Ab();
        com.kwad.sdk.n.k.OL();
        if (!zK) {
            com.kwad.sdk.a.a.c.Au().Aw();
            com.kwad.components.core.o.a.qI().qJ();
        }
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        com.kwad.sdk.core.e.c.d("KSAdSDK", "KSAdSDK init time:" + elapsedRealtime2);
        com.kwad.sdk.core.e.c.i("KSAdSDK", "SDK_VERSION_NAME: 3.3.63 TK_VERSION_CODE: 6.0.7 BRIDGE_VERSION: 1.3");
        if (this.alY == null) {
            this.alY = f.X(elapsedRealtime2);
        }
        if (!zK) {
            this.alY.report();
        }
        a(ServiceProvider.Lx());
        this.alN = true;
    }

    private void zN() {
        try {
            com.kwad.sdk.commercial.b.a(new b.a() { // from class: com.kwad.sdk.l.3
                @Override // com.kwad.sdk.commercial.b.a
                public final boolean Ai() {
                    return com.kwad.sdk.core.config.d.b(com.kwad.sdk.core.config.c.asb);
                }

                @Override // com.kwad.sdk.commercial.b.a
                public final boolean Aj() {
                    return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.asa);
                }

                @Override // com.kwad.sdk.commercial.b.a
                public final JSONObject Ak() {
                    return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.asm);
                }

                @Override // com.kwad.sdk.commercial.b.a
                public final String Al() {
                    return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.auq);
                }

                @Override // com.kwad.sdk.commercial.b.a
                public final void j(String str, String str2, boolean z) {
                    com.kwad.components.core.o.a.qI().e(str, str2, false);
                }
            }, this.alT);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void zO() {
        try {
            com.kwad.sdk.components.b.init(ServiceProvider.getContext());
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private static void zP() {
        try {
            com.kwad.components.core.d.a.initAsync(ServiceProvider.getContext());
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private void zQ() {
        try {
            com.kwad.sdk.components.c.init(getContext());
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private void zR() {
        try {
            com.kwad.components.core.n.b.b.init(getContext());
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private void zS() {
        y.ah(ServiceProvider.getContext(), this.ame);
        this.ame = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zT() {
        try {
            Map<String, String> parseJSON2MapString = u.parseJSON2MapString(com.kwad.sdk.core.config.c.atU.getValue());
            for (String str : parseJSON2MapString.keySet()) {
                String str2 = parseJSON2MapString.get(str);
                Objects.requireNonNull(str2);
                GlobalThreadPools.q(str, Integer.parseInt(str2));
            }
            GlobalThreadPools.Gk();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void zU() {
        try {
            com.kwad.sdk.core.e.c.init(ServiceProvider.Lx().enableDebug);
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private static void zV() {
        try {
            com.kwad.sdk.n.e.OH().init();
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private static void zW() {
        try {
            com.kwad.sdk.core.c.b.En().init(ServiceProvider.getContext());
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private void zX() {
        try {
            com.kwad.sdk.core.webview.b.a.HG().init(getContext());
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void zY() {
        try {
            com.kwad.sdk.core.network.idc.a.EE().init(getContext());
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private static void zZ() {
        try {
            com.kwad.sdk.core.download.a.bi(ServiceProvider.getContext());
        } catch (Throwable th) {
            n.l(th);
        }
    }

    public final boolean Ag() {
        if (!zK()) {
            return this.alN;
        }
        if (this.alN && this.alO) {
            return true;
        }
        return false;
    }

    public final long Ah() {
        return this.ZL;
    }

    @NonNull
    public final KsLoadManager getAdManager() {
        if (this.alU == null) {
            this.alU = new com.kwad.components.core.b();
        }
        return this.alU;
    }

    public final String getApiVersion() {
        return this.alR;
    }

    public final int getApiVersionCode() {
        return this.alS;
    }

    public final synchronized void init(Context context, SdkConfig sdkConfig) {
        if (context != null && sdkConfig != null) {
            try {
            } catch (Throwable th) {
                Log.e("KSAdSDK", "init error", th);
                String stackTraceString = Log.getStackTraceString(th);
                n.a(th, stackTraceString);
                a(sdkConfig, new e(10002, stackTraceString));
            }
            if (!TextUtils.isEmpty(sdkConfig.appId)) {
                Log.d("KSAdSDK", "init appId:" + sdkConfig.appId + "--mIsSdkInit:" + this.alN);
                if (this.alN) {
                    ServiceProvider.c(sdkConfig);
                    return;
                }
                ServiceProvider.c(sdkConfig);
                ServiceProvider.bP(context);
                if (aE(context)) {
                    Log.d("KSAdSDK", "intKSRemoteProcess appId=" + sdkConfig.appId);
                    ServiceProvider.Lv();
                    j.yP();
                    zU();
                    this.alN = true;
                } else {
                    try {
                        n.Ao();
                        zM();
                        n.aH(context);
                    } catch (Throwable th2) {
                        Log.e("KSAdSDK", "initSDKModule error", th2);
                        String stackTraceString2 = Log.getStackTraceString(th2);
                        n.a(th2, stackTraceString2);
                        a(sdkConfig, new e(10002, stackTraceString2));
                        return;
                    }
                }
                return;
            }
        }
        Log.e("KSAdSDK", "KSAdSDK SDKInit:init error,please check appID and config item");
        a(sdkConfig, e.alt);
    }

    public final <T extends IComponentProxy> T newComponentProxy(Class<?> cls, Object obj) {
        try {
            Class g = com.kwad.sdk.service.b.g(cls);
            if (g == null) {
                if (obj instanceof BaseProxyActivity) {
                    g = com.kwad.components.core.proxy.a.class;
                } else if (obj instanceof BaseProxyFragmentActivity) {
                    g = com.kwad.components.core.proxy.b.class;
                }
                com.kwad.components.core.d.a.reportSdkCaughtException(new RuntimeException("--getIsExternal:" + yV() + "--mIsSdkInit:" + yY() + "--componentClass" + cls));
            }
            return (T) g.newInstance();
        } catch (Exception e) {
            com.kwad.components.core.d.a.reportSdkCaughtException(e);
            com.kwad.sdk.core.e.c.printStackTrace(e);
            return null;
        }
    }

    public final void setAdxEnable(boolean z) {
        this.amd = z;
    }

    public final void setApiVersion(String str) {
        this.alR = str;
    }

    public final void setApiVersionCode(int i) {
        this.alS = i;
    }

    public final void setAppTag(String str) {
        if (this.alN) {
            y.ah(ServiceProvider.getContext(), this.ame);
        } else {
            this.ame = str;
        }
    }

    public final void setInitStartTime(long j) {
        this.alW = j;
    }

    public final void setIsExternal(boolean z) {
        this.alT = z;
    }

    public final void setLaunchTime(long j) {
        this.alV = j;
    }

    public final void setPersonalRecommend(boolean z) {
        this.amb = z;
    }

    public final void setProgrammaticRecommend(boolean z) {
        this.amc = z;
    }

    public final synchronized void start() {
        boolean z;
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Log.d("KSAdSDK", "KSAdSDK start call");
            if (this.alZ == null) {
                this.alZ = f.Y(this.alV);
            }
            this.alZ.report();
            SdkConfig Lx = ServiceProvider.Lx();
            if (!zK()) {
                b(Lx);
                z = true;
            } else {
                z = false;
            }
            if (!this.alN) {
                b(Lx, e.alu);
                z = true;
            }
            if (this.alO) {
                b(Lx);
                z = true;
            }
            if (!z) {
                e(new com.kwad.sdk.f.a() { // from class: com.kwad.sdk.l.1
                    @Override // com.kwad.sdk.f.a
                    public final void accept(Object obj) {
                    }
                });
                com.kwad.sdk.a.a.c.Au().Aw();
                com.kwad.components.core.o.a.qI().qJ();
                f fVar = this.alX;
                if (fVar != null) {
                    fVar.report();
                }
                f fVar2 = this.alY;
                if (fVar2 != null) {
                    fVar2.report();
                }
                this.alO = true;
                b(Lx);
            }
            if (this.ama == null) {
                this.ama = f.Z(SystemClock.elapsedRealtime() - elapsedRealtime);
            }
            this.alZ.report();
        } catch (Throwable th) {
            n.l(th);
        }
    }

    public final void unInit() {
        com.kwad.sdk.core.download.b.DO().bk(getContext());
    }

    public final boolean yV() {
        return this.alT;
    }

    public final boolean yW() {
        return this.amb;
    }

    public final boolean yX() {
        return this.amc;
    }

    public final boolean yY() {
        return this.alN;
    }

    public final synchronized boolean zK() {
        boolean z;
        try {
            z = false;
        } catch (Throwable th) {
            Log.e("KSAdSDK", th.getMessage());
            th.printStackTrace();
        }
        if (zL()) {
            Log.d("KSAdSDK", "enableInitStartMode return false hadLastTimeInitError");
            return false;
        }
        if (this.alQ == null) {
            this.alQ = Boolean.valueOf(com.kwad.sdk.core.config.d.zK());
        }
        if (!this.alQ.booleanValue()) {
            Log.d("KSAdSDK", "enableInitStartMode return false mConfigEnableInitStart");
            return false;
        }
        if (this.alP) {
            Log.d("KSAdSDK", "enableInitStartMode return true mApiHadStartMethod");
            return true;
        }
        if (IKsAdSDK.class.getDeclaredMethod("start", null) != null) {
            z = true;
        }
        this.alP = z;
        Log.d("KSAdSDK", "enableInitStartMode return mApiHadStartMethod: " + this.alP);
        return this.alP;
    }

    private l() {
        this.alN = false;
        this.alO = false;
        this.alP = false;
        this.alQ = null;
        this.alR = "";
        this.amb = true;
        this.amc = true;
        this.amd = false;
    }

    private static void b(SdkConfig sdkConfig, final e eVar) {
        final KsInitCallback ksInitCallback;
        try {
            Log.d("KSAdSDK", "KSAdSDK notifyStartFail error: " + eVar.msg);
            if (sdkConfig == null || (ksInitCallback = sdkConfig.ksStartCallback) == null) {
                return;
            }
            bo.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.l.6
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        KsInitCallback ksInitCallback2 = KsInitCallback.this;
                        e eVar2 = eVar;
                        ksInitCallback2.onFail(eVar2.code, eVar2.msg);
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    private static void a(SdkConfig sdkConfig, final e eVar) {
        if (sdkConfig != null) {
            try {
                final KsInitCallback ksInitCallback = sdkConfig.ksInitCallback;
                if (ksInitCallback != null) {
                    bo.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.l.4
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                KsInitCallback ksInitCallback2 = KsInitCallback.this;
                                e eVar2 = eVar;
                                ksInitCallback2.onFail(eVar2.code, eVar2.msg);
                            } catch (Throwable unused) {
                            }
                        }
                    });
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(SdkConfigData sdkConfigData) {
        zN();
        zX();
        com.kwad.sdk.core.config.d.yT();
        if ((com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.arZ) && ar.isInMainProcess(ServiceProvider.Lw())) || com.kwad.framework.a.a.md.booleanValue()) {
            DynamicInstallReceiver.registerToApp(ServiceProvider.Lw());
        }
        if (com.kwad.sdk.core.config.d.Db()) {
            com.kwad.sdk.b.a.init(com.kwad.sdk.n.l.ON());
        }
        Ac();
        ba.init(getContext());
        com.kwad.components.core.a.a.mR().eG();
        com.kwad.sdk.utils.f.a(getContext(), 30000L, new com.kwad.sdk.collector.h() { // from class: com.kwad.sdk.l.9
            @Override // com.kwad.sdk.collector.h
            public final void c(@NonNull JSONArray jSONArray) {
                com.kwad.components.core.o.a.qI().c(jSONArray);
            }
        });
        com.kwad.sdk.core.network.idc.a.EE().a(com.kwad.sdk.core.config.d.Dc(), com.kwad.sdk.core.config.d.Dd());
        com.kwad.sdk.ip.direct.a.a(sdkConfigData.httpDnsInfo);
        bl.a(com.kwad.sdk.core.config.d.De(), com.kwad.sdk.core.config.d.Df(), ServiceProvider.getContext());
        Ae();
        Aa();
        com.kwad.components.core.h.a.pd().aj(getContext());
        com.kwad.sdk.crash.online.monitor.a.cM(com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.atK));
        ImageLoaderPerfUtil.report();
        com.kwad.sdk.m.e.cM(com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.atR));
        com.kwad.sdk.core.threads.c.cM(com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.atT));
        com.kwad.sdk.i.a.Kb();
        com.kwad.sdk.n.l.x(getContext(), ((Boolean) sdkConfigData.getAppConfigData(Boolean.FALSE, new com.kwad.sdk.f.b<JSONObject, Boolean>() { // from class: com.kwad.sdk.l.10
            private static Boolean f(JSONObject jSONObject) {
                return Boolean.valueOf(jSONObject.optBoolean("useContextClassLoader"));
            }

            @Override // com.kwad.sdk.f.b
            public final /* synthetic */ Boolean apply(JSONObject jSONObject) {
                return f(jSONObject);
            }
        })).booleanValue());
        com.kwad.sdk.kgeo.a.dC(com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.auk));
        try {
            com.kwad.components.core.webview.tachikoma.g.tc().init();
        } catch (Throwable th) {
            com.kwad.components.core.d.a.reportSdkCaughtException(th);
        }
    }

    private static void a(SdkConfig sdkConfig) {
        if (sdkConfig != null) {
            try {
                final KsInitCallback ksInitCallback = sdkConfig.ksInitCallback;
                if (ksInitCallback != null) {
                    bo.b(new Runnable() { // from class: com.kwad.sdk.l.5
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                m.ae(SystemClock.elapsedRealtime() - l.zJ().alW);
                                KsInitCallback.this.onSuccess();
                            } catch (Throwable unused) {
                            }
                        }
                    });
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static void b(SdkConfig sdkConfig) {
        final KsInitCallback ksInitCallback;
        try {
            Log.d("KSAdSDK", "KSAdSDK notifyStartSuccess");
            if (sdkConfig == null || (ksInitCallback = sdkConfig.ksStartCallback) == null) {
                return;
            }
            bo.b(new Runnable() { // from class: com.kwad.sdk.l.7
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        KsInitCallback.this.onSuccess();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static void b(String str, Map<String, String> map, String str2) {
        com.kwad.sdk.core.a.d.a(str, map, str2);
    }

    public static void e(@NonNull Map<String, String> map) {
        com.kwad.sdk.core.a.d.g(map);
    }
}
