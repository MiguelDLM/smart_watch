package com.alimm.tanx.ui;

import android.app.Application;
import android.util.Log;
import com.alimm.tanx.core.SdkConstant;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.TanxInitListener;
import com.alimm.tanx.core.config.TanxConfig;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.ui.ad.ITanxSdkManager;
import java.util.concurrent.atomic.AtomicInteger;
import oOxxXI.oIX0oI;

public class TanxSdk implements NotConfused {
    private static final String TAG = "TanxSdk";
    public static final int TANX_SDK_INIT_ERROR = -1;
    public static final int TANX_SDK_INIT_ING = 1;
    public static final int TANX_SDK_INIT_SUCC = 2;
    public static final int TANX_SDK_INIT_WAIT = 0;
    private static Application application;
    /* access modifiers changed from: private */
    public static tanxu_if mInitializer;
    public static volatile AtomicInteger mIsInit = new AtomicInteger(0);

    public static Application getApplication() {
        return application;
    }

    public static TanxConfig getConfig() {
        if (TanxCoreSdk.checkSdkInit()) {
            return mInitializer.tanxu_do();
        }
        return null;
    }

    public static ITanxSdkManager getSDKManager() {
        if (TanxCoreSdk.checkSdkInit()) {
            return mInitializer.tanxu_if();
        }
        return null;
    }

    public static void init(Application application2, TanxConfig tanxConfig, TanxInitListener tanxInitListener) {
        StringBuilder oIX0oI2 = oIX0oI.oIX0oI("--->init()-->mIsInit->");
        oIX0oI2.append(mIsInit);
        oIX0oI2.append(" version:");
        oIX0oI2.append(SdkConstant.getSdkVersion());
        Log.d(TAG, oIX0oI2.toString());
        init(application2, tanxConfig, new TanxThirdInstanceDefault().build(), tanxInitListener);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b7, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void init(android.app.Application r3, com.alimm.tanx.core.config.TanxConfig r4, com.alimm.tanx.core.TanxCoreInstanceConfig r5, com.alimm.tanx.core.TanxInitListener r6) {
        /*
            java.lang.String r0 = "--->init()-->mIsInit->"
            java.lang.StringBuilder r0 = oOxxXI.oIX0oI.oIX0oI(r0)
            java.util.concurrent.atomic.AtomicInteger r1 = mIsInit
            r0.append(r1)
            java.lang.String r1 = " version:"
            r0.append(r1)
            java.lang.String r1 = com.alimm.tanx.core.SdkConstant.getSdkVersion()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "TanxSdk"
            android.util.Log.d(r1, r0)
            java.lang.Class<com.alimm.tanx.ui.TanxSdk> r0 = com.alimm.tanx.ui.TanxSdk.class
            monitor-enter(r0)
            java.util.concurrent.atomic.AtomicInteger r1 = mIsInit     // Catch:{ all -> 0x005a }
            int r1 = r1.get()     // Catch:{ all -> 0x005a }
            if (r1 == 0) goto L_0x005c
            java.util.concurrent.atomic.AtomicInteger r1 = mIsInit     // Catch:{ all -> 0x005a }
            int r1 = r1.get()     // Catch:{ all -> 0x005a }
            r2 = -1
            if (r1 != r2) goto L_0x0035
            goto L_0x005c
        L_0x0035:
            java.lang.String r3 = "TanxSdk"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x005a }
            r4.<init>()     // Catch:{ all -> 0x005a }
            java.lang.String r5 = "--->init()终止，已经在初始化，或者已经初始化完成。-->mIsInit->"
            r4.append(r5)     // Catch:{ all -> 0x005a }
            java.util.concurrent.atomic.AtomicInteger r5 = mIsInit     // Catch:{ all -> 0x005a }
            r4.append(r5)     // Catch:{ all -> 0x005a }
            java.lang.String r5 = " version:"
            r4.append(r5)     // Catch:{ all -> 0x005a }
            java.lang.String r5 = com.alimm.tanx.core.SdkConstant.getSdkVersion()     // Catch:{ all -> 0x005a }
            r4.append(r5)     // Catch:{ all -> 0x005a }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x005a }
            android.util.Log.d(r3, r4)     // Catch:{ all -> 0x005a }
            goto L_0x00b6
        L_0x005a:
            r3 = move-exception
            goto L_0x00c0
        L_0x005c:
            java.util.concurrent.atomic.AtomicInteger r1 = mIsInit     // Catch:{ all -> 0x005a }
            r2 = 1
            r1.set(r2)     // Catch:{ all -> 0x005a }
            application = r3     // Catch:{ all -> 0x005a }
            if (r4 == 0) goto L_0x00b8
            java.lang.String r1 = r4.getAppKey()     // Catch:{ all -> 0x005a }
            boolean r1 = com.alimm.tanx.core.utils.StringUtil.isNull(r1)     // Catch:{ all -> 0x005a }
            if (r1 == 0) goto L_0x00a3
            java.lang.String r3 = "TanxSdk"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x005a }
            r4.<init>()     // Catch:{ all -> 0x005a }
            java.lang.String r5 = "AppKey Is Null :"
            r4.append(r5)     // Catch:{ all -> 0x005a }
            java.util.concurrent.atomic.AtomicInteger r5 = mIsInit     // Catch:{ all -> 0x005a }
            r4.append(r5)     // Catch:{ all -> 0x005a }
            java.lang.String r5 = " version:"
            r4.append(r5)     // Catch:{ all -> 0x005a }
            java.lang.String r5 = com.alimm.tanx.core.SdkConstant.getSdkVersion()     // Catch:{ all -> 0x005a }
            r4.append(r5)     // Catch:{ all -> 0x005a }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x005a }
            android.util.Log.d(r3, r4)     // Catch:{ all -> 0x005a }
            com.alimm.tanx.core.ut.UtErrorCode r3 = com.alimm.tanx.core.ut.UtErrorCode.APP_KEY_NULL     // Catch:{ all -> 0x005a }
            int r4 = r3.getIntCode()     // Catch:{ all -> 0x005a }
            java.lang.String r3 = r3.getMsg()     // Catch:{ all -> 0x005a }
            r6.error(r4, r3)     // Catch:{ all -> 0x005a }
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            return
        L_0x00a3:
            com.alimm.tanx.ui.tanxu_if r1 = mInitializer     // Catch:{ all -> 0x005a }
            if (r1 != 0) goto L_0x00ae
            com.alimm.tanx.ui.tanxu_if r1 = new com.alimm.tanx.ui.tanxu_if     // Catch:{ all -> 0x005a }
            r1.<init>()     // Catch:{ all -> 0x005a }
            mInitializer = r1     // Catch:{ all -> 0x005a }
        L_0x00ae:
            com.alimm.tanx.ui.tanxu_do r1 = new com.alimm.tanx.ui.tanxu_do     // Catch:{ all -> 0x005a }
            r1.<init>(r3, r4, r6)     // Catch:{ all -> 0x005a }
            com.alimm.tanx.core.TanxCoreSdk.init(r3, r4, r5, r1)     // Catch:{ all -> 0x005a }
        L_0x00b6:
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            return
        L_0x00b8:
            java.lang.RuntimeException r3 = new java.lang.RuntimeException     // Catch:{ all -> 0x005a }
            java.lang.String r4 = "TanxConfig Not Null"
            r3.<init>(r4)     // Catch:{ all -> 0x005a }
            throw r3     // Catch:{ all -> 0x005a }
        L_0x00c0:
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.ui.TanxSdk.init(android.app.Application, com.alimm.tanx.core.config.TanxConfig, com.alimm.tanx.core.TanxCoreInstanceConfig, com.alimm.tanx.core.TanxInitListener):void");
    }
}
