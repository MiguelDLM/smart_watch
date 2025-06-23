package com.alimm.tanx.core;

import android.app.Application;
import android.content.Context;
import com.alimm.tanx.core.ad.ITanxCoreManager;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.alimm.tanx.core.ad.listener.ut.ITanxUserTracker;
import com.alimm.tanx.core.ad.loader.ITanxRequestLoader;
import com.alimm.tanx.core.ad.loader.TanxRequestLoader;
import com.alimm.tanx.core.config.TanxCoreConfig;
import com.alimm.tanx.core.orange.OrangeInitListener;
import com.alimm.tanx.core.orange.OrangeManager;
import com.alimm.tanx.core.orange.bean.OrangeBean;
import com.alimm.tanx.core.request.C;
import com.alimm.tanx.core.ut.core.LifeCycleManager;
import com.alimm.tanx.core.ut.core.UserReportManager;
import com.alimm.tanx.core.utils.DeviceIdGetUtil;
import com.alimm.tanx.core.utils.LogStatus;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.web.WebCacheManager;
import x0oxIIIX.oIX0oI;

/* loaded from: classes.dex */
public class TanxCoreManager implements ITanxCoreManager, NotConfused {
    private static final String TAG = "AdSdkManager";
    private Application mAppContext;
    private boolean mHasInit = false;
    private TanxCoreInstanceConfig tanxCoreInstanceConfig;

    /* loaded from: classes.dex */
    public static class tanxc_do {
        static final TanxCoreManager tanxc_do = new TanxCoreManager();
    }

    public static TanxCoreManager getInstance() {
        return tanxc_do.tanxc_do;
    }

    private void initAllId() {
        DeviceIdGetUtil.getInstance().init(this.mAppContext);
        DeviceIdGetUtil.getInstance().getAllIdOnlyCache();
    }

    private void initExpose() {
        ExposeManager.tanxc_do().tanxc_do(this.mAppContext);
    }

    private void initLogSwitch(TanxCoreConfig tanxCoreConfig) {
        if (tanxCoreConfig == null) {
            LogUtils.setLogStatus(LogStatus.LOG_DEFAULT);
        } else {
            if (tanxCoreConfig.getLogStatus() == null) {
                if (tanxCoreConfig.isDebugMode()) {
                    LogUtils.setLogStatus(LogStatus.LOG_DEBUG);
                    return;
                }
                return;
            }
            LogUtils.setLogStatus(tanxCoreConfig.getLogStatus());
        }
    }

    private void initNet() {
        if (TanxCoreSdk.getConfig().isNetDebug()) {
            C.setDebug();
        }
    }

    private void initOrange() {
        LogUtils.d(TAG, "initOrange()");
        OrangeManager.getInstance().init(new OrangeInitListener<OrangeBean>() { // from class: com.alimm.tanx.core.TanxCoreManager.1
            @Override // com.alimm.tanx.core.orange.OrangeInitListener
            public /* bridge */ /* synthetic */ void initFinish(OrangeBean orangeBean) {
            }
        });
    }

    private void initUT() {
        LogUtils.d(TAG, "initUTSDK()");
        TanxCoreSdk.getConfig();
        UserReportManager.getInstance().init();
        LifeCycleManager.getInstance().init();
    }

    private void initWebCache() {
        WebCacheManager.getInstance().init(this.mAppContext);
    }

    @Override // com.alimm.tanx.core.ad.ITanxCoreManager
    public ITanxRequestLoader createRequestLoader(Context context) {
        return new TanxRequestLoader();
    }

    public Application getAppContext() {
        Application application = this.mAppContext;
        if (application != null) {
            return application;
        }
        throw new RuntimeException("App should call init() to initialize first. you AppContext == null");
    }

    @Override // com.alimm.tanx.core.ad.ITanxCoreManager
    public String getSDKVersion() {
        return SdkConstant.getSdkVersion();
    }

    public TanxCoreInstanceConfig getTanxCoreInstanceConfig() {
        return this.tanxCoreInstanceConfig;
    }

    public ITanxUserTracker getTanxUserTracker() {
        TanxCoreInstanceConfig tanxCoreInstanceConfig = this.tanxCoreInstanceConfig;
        if (tanxCoreInstanceConfig != null) {
            return tanxCoreInstanceConfig.getTanxUserTracker();
        }
        return null;
    }

    public oIX0oI getUserTracker() {
        TanxCoreInstanceConfig tanxCoreInstanceConfig = this.tanxCoreInstanceConfig;
        if (tanxCoreInstanceConfig != null) {
            return tanxCoreInstanceConfig.getUserTracker();
        }
        return null;
    }

    public void init(Application application, TanxCoreConfig tanxCoreConfig, TanxCoreInstanceConfig tanxCoreInstanceConfig, TanxInitListener tanxInitListener) {
        this.tanxCoreInstanceConfig = tanxCoreInstanceConfig;
        init(application, tanxCoreConfig, tanxInitListener);
    }

    public void setTanxCoreInstanceConfig(TanxCoreInstanceConfig tanxCoreInstanceConfig) {
        this.tanxCoreInstanceConfig = tanxCoreInstanceConfig;
    }

    public void init(Application application, TanxCoreConfig tanxCoreConfig, TanxInitListener tanxInitListener) {
        if (this.mHasInit) {
            if (tanxInitListener != null) {
                tanxInitListener.succ();
                return;
            }
            return;
        }
        initLogSwitch(tanxCoreConfig);
        LogUtils.i(TAG, "init: appContext = " + application + ", mHasInit = " + this.mHasInit + ", config = " + tanxCoreConfig);
        if (application == null) {
            throw new RuntimeException("App should set a NonNull context when init().");
        }
        if (tanxCoreConfig != null) {
            this.mAppContext = application;
            initAllId();
            initExpose();
            initNet();
            initOrange();
            initUT();
            initWebCache();
            this.mHasInit = true;
            if (tanxInitListener != null) {
                tanxInitListener.succ();
                return;
            }
            return;
        }
        throw new RuntimeException("App should set a NonNull config when init().");
    }
}
