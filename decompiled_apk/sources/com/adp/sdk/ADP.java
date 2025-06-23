package com.adp.sdk;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.annotation.Keep;
import com.adp.sdk.dto.ADPConfig;
import com.adp.sdk.dto.AdInfo;
import com.adp.sdk.dto.AdpError;
import com.adp.sdk.listener.AdInfoListener;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.huawei.hms.ads.identifier.AdvertisingIdClient;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.SdkConfig;
import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class ADP {
    protected static String ADP_APPID = "";
    protected static final String ALIYUN = "aliyun";
    protected static final String BAIDU = "baidu";
    protected static final String BYTEDANCE = "bytedance";
    public static boolean DEBUGLOG = true;
    protected static final String GROMORE = "gromore";
    protected static final String HUAWEI = "huawei";
    private static boolean ISINITSUCCESS = false;
    protected static final String JINGDONG = "jingdong";
    protected static final String KLEVIN = "klevin";
    protected static final String KUAISHOU = "kuaishou";
    protected static final String OCTOPUS = "octopus";
    protected static final String TANX = "tanx";
    protected static final String TENCENT = "tencent";
    public static final String VERSION = "4.2.6.3";
    protected static ADPConfig adpConfig = null;
    private static InitCallback adpinitCallback = null;
    private static String appname = "adp";
    private static Builder builder = null;
    private static String csjAppid = "";
    protected static boolean initksBoolean = false;
    protected static boolean isErrorLogs = true;
    protected static boolean isOpenLogsBoolean = true;
    private static boolean isRun = false;
    private static String jingdong = "";
    private static String klevinid = "";
    private static String ksid = "";
    protected static String oaid = "";
    protected static String serviceId = null;
    private static String txAppid = "";
    private static final Handler uiHandler = new Handler(new b());

    /* loaded from: classes.dex */
    public static class Builder {
        private boolean debug;
        private boolean supportMultiProcess = true;

        public boolean getDebug() {
            return this.debug;
        }

        public boolean getSupportMultiProcess() {
            return this.supportMultiProcess;
        }

        public Builder setDebug(boolean z) {
            this.debug = z;
            return this;
        }

        public Builder setSupportMultiProcess(boolean z) {
            this.supportMultiProcess = z;
            return this;
        }
    }

    @Keep
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface HorizontalPlayStyle {
        public static final int CURRENT = 0;
        public static final int OUTDOORS = 1;
    }

    /* loaded from: classes.dex */
    public interface InitCallback {
        void onError(AdpError adpError);

        void onSuccess();
    }

    @Keep
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ThemeModeType {
        public static final int NIGHT = 1;
        public static final int NORMAL = 0;
    }

    /* loaded from: classes.dex */
    public static class a extends Thread {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Application f4619a;

        public a(Application application) {
            this.f4619a = application;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            AdvertisingIdClient.Info advertisingIdInfo;
            try {
                if (com.adp.sdk.utils.b.a("com.huawei.hms.ads.identifier.AdvertisingIdClient") && com.adp.sdk.utils.b.a("com.huawei.hms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo") && (advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.f4619a)) != null) {
                    ADP.oaid = advertisingIdInfo.getId();
                }
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            String str;
            boolean z;
            if (ADP.DEBUGLOG) {
                Log.i("adsplus", "SDK版本:4.2.6.3时间:20241008");
            }
            Context context = (Context) message.obj;
            try {
                ADPConfig aDPConfig = ADP.adpConfig;
                if (aDPConfig != null && !ADP.isEmpty(aDPConfig.getOaid())) {
                    ADP.oaid = ADP.adpConfig.getOaid();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (!ADP.isEmpty(ADP.txAppid)) {
                    ADPConfig aDPConfig2 = ADP.adpConfig;
                    if (aDPConfig2 != null) {
                        if (aDPConfig2.isEnablePersonalRecommend()) {
                            GlobalSetting.setPersonalizedState(1);
                            if (ADP.DEBUGLOG) {
                                Log.i("adsplus", "1不允许个性化");
                            }
                            GlobalSetting.setEnableCollectAppInstallStatus(false);
                        } else {
                            if (ADP.DEBUGLOG) {
                                Log.i("adsplus", "1允许个性化");
                            }
                            GlobalSetting.setPersonalizedState(0);
                            if (ADP.adpConfig.getPermissionAppListBoolean()) {
                                GlobalSetting.setEnableCollectAppInstallStatus(true);
                            }
                        }
                    }
                    GDTAdSdk.initWithoutStart(context, ADP.txAppid);
                    g.a(context, null);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (ADP.DEBUGLOG) {
                    Log.i("adsplus", "gdt error:" + e2.toString());
                }
            }
            try {
                if (!ADP.isEmpty(ADP.ksid)) {
                    ADPConfig aDPConfig3 = ADP.adpConfig;
                    if (aDPConfig3 != null) {
                        if (aDPConfig3.isEnablePersonalRecommend()) {
                            KsAdSDK.setPersonalRecommend(false);
                            KsAdSDK.setProgrammaticRecommend(false);
                            if (ADP.DEBUGLOG) {
                                Log.i("adsplus", "2不允许个性化");
                            }
                            z = false;
                            ADP.initksBoolean = KsAdSDK.init(context, new SdkConfig.Builder().appId(ADP.ksid).nightThemeStyleAssetsFileName(SdkConfig.DEF_NIGHT_THEME_STYLE_FILE_NAME).showNotification(true).debug(false).customController(com.adp.sdk.utils.e.a().a(z, ADP.adpConfig)).build());
                            KsAdSDK.start();
                        } else {
                            if (ADP.DEBUGLOG) {
                                Log.i("adsplus", "2允许个性化");
                            }
                            KsAdSDK.setPersonalRecommend(true);
                            KsAdSDK.setProgrammaticRecommend(true);
                        }
                    }
                    z = true;
                    ADP.initksBoolean = KsAdSDK.init(context, new SdkConfig.Builder().appId(ADP.ksid).nightThemeStyleAssetsFileName(SdkConfig.DEF_NIGHT_THEME_STYLE_FILE_NAME).showNotification(true).debug(false).customController(com.adp.sdk.utils.e.a().a(z, ADP.adpConfig)).build());
                    KsAdSDK.start();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            try {
                if (!j.a()) {
                    j.a(context);
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            if (ADP.adpinitCallback != null) {
                ADP.adpinitCallback.onSuccess();
            }
            boolean unused = ADP.ISINITSUCCESS = true;
            if (ADP.adpConfig != null) {
                str = "applist:" + ADP.adpConfig.getPermissionAppListBoolean() + " PersonalRecommend:" + ADP.adpConfig.isEnablePersonalRecommend();
            } else {
                str = "";
            }
            com.adp.sdk.c.a().c(context, str);
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class c implements AdInfoListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InitCallback f4620a;
        final /* synthetic */ Application b;

        public c(InitCallback initCallback, Application application) {
            this.f4620a = initCallback;
            this.b = application;
        }

        @Override // com.adp.sdk.listener.AdInfoListener
        public void error(String str, String str2) {
            com.adp.sdk.c.a().b(this.b, str2 + "");
            boolean unused = ADP.isRun = false;
            InitCallback initCallback = this.f4620a;
            if (initCallback != null) {
                initCallback.onError(new AdpError(str, str2));
            }
            boolean unused2 = ADP.ISINITSUCCESS = false;
            com.adp.sdk.c.a().b(this.b, "sdk init error init ad error:" + str2);
        }

        @Override // com.adp.sdk.listener.AdInfoListener
        public void onAdLoadOk(String str, String str2, String str3, String str4) {
            boolean unused = ADP.isRun = false;
            String unused2 = ADP.txAppid = str;
            String unused3 = ADP.csjAppid = str2;
            String unused4 = ADP.ksid = str4;
            String unused5 = ADP.jingdong = com.adp.sdk.a.b.getJingdong();
            String unused6 = ADP.klevinid = com.adp.sdk.a.b.getKlevin();
            InitCallback unused7 = ADP.adpinitCallback = this.f4620a;
            Message message = new Message();
            message.obj = this.b;
            message.what = 1;
            ADP.uiHandler.sendMessage(message);
            String unused8 = ADP.appname = str3;
            AdInfo adInfo = com.adp.sdk.a.b;
            if (adInfo != null) {
                ADP.isOpenLogsBoolean = adInfo.isOpenLogs();
                ADP.isErrorLogs = com.adp.sdk.a.b.isOpenLogs();
            }
        }
    }

    private static void fetchAdvertisingInfo(Application application) {
        new a(application).start();
    }

    public static TTAdManager getTTAdManager() {
        if (ISINITSUCCESS) {
            return TTAdSdk.getAdManager();
        }
        throw new RuntimeException("TTAdSdk is not init, please check.");
    }

    public static void initialize(ADPConfig aDPConfig, String str, Application application, InitCallback initCallback, Builder builder2) {
        builder = builder2;
        initialize(aDPConfig, str, application, initCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isEmpty(String str) {
        if (str != null && str.trim().length() != 0) {
            return false;
        }
        return true;
    }

    public static boolean isInitSuccess() {
        return ISINITSUCCESS;
    }

    public static void setThemeMode(int i) {
        if (i == 1) {
            KsAdSDK.setThemeMode(1);
        } else {
            KsAdSDK.setThemeMode(1);
        }
    }

    public static void initialize(ADPConfig aDPConfig, String str, Application application, InitCallback initCallback) {
        ADP_APPID = str;
        com.adp.sdk.c.a().a(application, str);
        adpConfig = aDPConfig;
        com.adp.sdk.utils.k.a.b().a(application);
        ADPConfig aDPConfig2 = adpConfig;
        if (aDPConfig2 != null) {
            DEBUGLOG = aDPConfig2.getDebug();
        }
        ADPConfig aDPConfig3 = adpConfig;
        if (aDPConfig3 != null && !aDPConfig3.isEnablePersonalRecommend()) {
            if (adpConfig.getOaid() != null && adpConfig.getOaid().length() != 0) {
                oaid = adpConfig.getOaid();
            } else {
                fetchAdvertisingInfo(application);
            }
        }
        if (isInitSuccess() || isRun) {
            return;
        }
        isRun = true;
        com.adp.sdk.a.a().a(str, application, new c(initCallback, application));
    }
}
