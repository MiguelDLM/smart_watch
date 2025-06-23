package com.jd.ad.sdk.bl.initsdk;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.dl.baseinfo.JADLocation;
import com.jd.ad.sdk.fdt.logger.JADLogAdapter;
import com.jd.ad.sdk.fdt.thread.WorkExecutor;
import com.jd.ad.sdk.fdt.utils.ActLifecycle;
import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.fdt.utils.UUIDUtils;
import com.jd.ad.sdk.jad_kx.jad_er;
import com.jd.ad.sdk.jad_mz.jad_dq;
import com.jd.ad.sdk.jad_mz.jad_er;
import com.jd.ad.sdk.jad_ob.jad_dq;
import com.jd.ad.sdk.jad_ob.jad_hu;
import com.jd.ad.sdk.jad_sf.jad_an;
import com.jd.ad.sdk.jad_vi.jad_bo;
import com.jd.ad.sdk.jad_vi.jad_fs;
import com.jd.ad.sdk.jad_vi.jad_iv;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.multi.BuildConfig;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class JADYunSdk {
    private static boolean isEnableLog = false;
    private static boolean isInitSuccess = false;
    private static JADInitCallback mInitCallback = null;
    public static jad_er mInnerInitCallBack = null;
    private static boolean mSupportMultiProcess = false;
    private static String sAppId = "";
    public static volatile JADLogAdapter sLogAdapter;
    public static volatile JADPrivateController sPrivateController;

    /* loaded from: classes10.dex */
    public class jad_an implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            long j;
            try {
                if (TextUtils.isEmpty(com.jd.ad.sdk.jad_jw.jad_an.jad_an)) {
                    com.jd.ad.sdk.jad_sf.jad_an jad_anVar = jad_an.jad_bo.jad_an;
                    com.jd.ad.sdk.jad_jw.jad_an.jad_an = jad_anVar.jad_an("refo");
                    Object jad_an = jad_anVar.jad_an("refot", (Class<Object>) Long.TYPE);
                    if (jad_an != null && (jad_an instanceof Long)) {
                        j = ((Long) jad_an).longValue();
                    } else {
                        j = 0;
                    }
                    if (System.currentTimeMillis() - j > 86400000) {
                        com.jd.ad.sdk.jad_jw.jad_an.jad_an(com.jd.ad.sdk.jad_do.jad_bo.jad_an());
                    }
                }
            } catch (Exception e) {
                StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("init oaid error: ");
                jad_an2.append(Log.getStackTraceString(e));
                Logger.d(jad_an2.toString());
                com.jd.ad.sdk.jad_uh.jad_an jad_anVar2 = com.jd.ad.sdk.jad_uh.jad_an.UTILS_OADI_REFLECT_ERROR;
                jad_fs.jad_an("", jad_anVar2.jad_an, jad_anVar2.jad_an(e.getMessage()));
            }
        }
    }

    /* loaded from: classes10.dex */
    public class jad_bo extends JADLogAdapter {
        @Override // com.jd.ad.sdk.fdt.logger.JADLogAdapter, com.jd.ad.sdk.jad_ir.jad_bo
        public boolean isLoggable(int i, @Nullable String str) {
            if (JADYunSdk.isEnableLog) {
                return super.isLoggable(i, str);
            }
            return false;
        }
    }

    /* loaded from: classes10.dex */
    public class jad_cp implements jad_er {
    }

    /* loaded from: classes10.dex */
    public class jad_dq implements Runnable {
        public final /* synthetic */ Context jad_an;
        public final /* synthetic */ JADYunSdkConfig jad_bo;

        public jad_dq(Context context, JADYunSdkConfig jADYunSdkConfig) {
            this.jad_an = context;
            this.jad_bo = jADYunSdkConfig;
        }

        @Override // java.lang.Runnable
        public void run() {
            JADYunSdk.init(this.jad_an, this.jad_bo);
        }
    }

    /* loaded from: classes10.dex */
    public interface jad_er {
    }

    public static void asyncInit(@NonNull Context context, @NonNull JADYunSdkConfig jADYunSdkConfig, JADInitCallback jADInitCallback) {
        mInitCallback = jADInitCallback;
        WorkExecutor.execute(new jad_dq(context, jADYunSdkConfig));
    }

    private static void crashInit() {
        if (jad_dq.jad_an.jad_an.jad_an(10, (String) null)) {
            return;
        }
        com.jd.ad.sdk.jad_vi.jad_bo jad_boVar = jad_bo.C0719jad_bo.jad_an;
        try {
            String str = "jadcrash";
            if (!jad_hu.jad_dq(com.jd.ad.sdk.jad_do.jad_bo.jad_an())) {
                str = "jadcrash_" + jad_hu.jad_cp(com.jd.ad.sdk.jad_do.jad_bo.jad_an());
            }
            jad_boVar.jad_an = com.jd.ad.sdk.jad_do.jad_bo.jad_an().getSharedPreferences(str, 0);
            if (!(Thread.getDefaultUncaughtExceptionHandler() instanceof com.jd.ad.sdk.jad_vi.jad_bo) && jad_boVar.jad_bo == null) {
                jad_boVar.jad_bo = Thread.getDefaultUncaughtExceptionHandler();
            }
            Thread.setDefaultUncaughtExceptionHandler(jad_boVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WorkExecutor.execute(new com.jd.ad.sdk.jad_vi.jad_an(jad_bo.C0719jad_bo.jad_an));
    }

    public static String getAppId() {
        if (!TextUtils.isEmpty(sAppId)) {
            return sAppId;
        }
        return jad_an.jad_bo.jad_an.jad_an("AppId");
    }

    public static JADPrivateController getPrivateController() {
        return sPrivateController;
    }

    public static String getSDKVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static void init(@NonNull Context context, @NonNull JADYunSdkConfig jADYunSdkConfig) {
        long currentTimeMillis = System.currentTimeMillis();
        initJADLog(jADYunSdkConfig);
        Application application = (Application) context.getApplicationContext();
        com.jd.ad.sdk.jad_do.jad_bo.jad_an = application;
        if (application != null) {
            application.registerActivityLifecycleCallbacks(new ActLifecycle());
        }
        sAppId = jADYunSdkConfig.getAppId();
        WorkExecutor.execute(new com.jd.ad.sdk.jad_pc.jad_bo(jADYunSdkConfig));
        mSupportMultiProcess = jADYunSdkConfig.isSupportMultiProcess();
        initAntiSDK(context);
        if (jADYunSdkConfig.getPrivateController() != null) {
            sPrivateController = jADYunSdkConfig.getPrivateController();
            com.jd.ad.sdk.jad_ob.jad_dq jad_dqVar = jad_dq.jad_an.jad_an;
            JADPrivateController jADPrivateController = sPrivateController;
            jad_dqVar.jad_jw = jADPrivateController;
            String oaid = jADPrivateController.getOaid();
            if (!TextUtils.isEmpty(oaid)) {
                jad_dqVar.jad_an = oaid;
                jad_an.jad_bo.jad_an.jad_an("oidCustom", oaid);
            }
            jADPrivateController.isCanUsePhoneState();
            jad_dqVar.jad_er = false;
            String imei = jADPrivateController.getImei();
            if (!TextUtils.isEmpty(imei)) {
                String jad_bo2 = com.jd.ad.sdk.jad_do.jad_er.jad_bo(imei.toUpperCase());
                jad_an.jad_bo.jad_an.jad_an("didCustom", (Object) jad_bo2);
                jad_dqVar.jad_bo = jad_bo2;
            }
            jad_dqVar.jad_fs = jADPrivateController.isCanUseLocation();
            JADLocation location = jADPrivateController.getLocation();
            if (location != null && location.isValid()) {
                jad_dqVar.jad_dq = location;
            }
            jad_dqVar.jad_jt = jADPrivateController.isCanUseIP();
            String ip = jADPrivateController.getIP();
            if (!TextUtils.isEmpty(ip) && !"0.0.0.0".equals(ip)) {
                jad_dqVar.jad_cp = ip;
            }
            jad_dqVar.jad_hu.clear();
            Iterator<String> it = com.jd.ad.sdk.jad_ob.jad_bo.jad_cp.iterator();
            while (it.hasNext()) {
                jad_dqVar.jad_hu.add(com.jd.ad.sdk.jad_do.jad_er.jad_an(it.next()));
            }
            try {
                jad_dqVar.jad_iv.clear();
                com.jd.ad.sdk.jad_na.jad_an jad_an2 = com.jd.ad.sdk.jad_pc.jad_an.jad_an();
                if (jad_an2 != null) {
                    String str = jad_an2.jad_ob;
                    if (!TextUtils.isEmpty(str)) {
                        jad_dqVar.jad_iv.addAll(Arrays.asList(str.split(",")));
                    }
                }
            } catch (Exception unused) {
            }
        }
        crashInit();
        jad_iv jad_ivVar = jad_iv.jad_cp.jad_an;
        jad_ivVar.getClass();
        WorkExecutor.execute(new com.jd.ad.sdk.jad_vi.jad_hu(jad_ivVar, context));
        initInternalInitCallBack();
        String appId = jADYunSdkConfig.getAppId();
        Handler handler = com.jd.ad.sdk.jad_mz.jad_er.jad_an;
        com.jd.ad.sdk.jad_mz.jad_bo.jad_bo = true;
        com.jd.ad.sdk.jad_mz.jad_er.jad_an(appId);
        ActLifecycle.jad_bo.add(new jad_er.jad_bo());
        com.jd.ad.sdk.jad_sf.jad_an jad_anVar = jad_an.jad_bo.jad_an;
        String jad_dq2 = jad_anVar.jad_dq("isRegisterNetworkReceiver");
        if (TextUtils.isEmpty(jad_dq2) || !jad_dq2.equals("1")) {
            if (com.jd.ad.sdk.jad_mz.jad_er.jad_bo == null) {
                com.jd.ad.sdk.jad_mz.jad_er.jad_bo = new com.jd.ad.sdk.jad_mz.jad_hu();
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            context.registerReceiver(com.jd.ad.sdk.jad_mz.jad_er.jad_bo, intentFilter, null, null);
            jad_anVar.jad_bo("isRegisterNetworkReceiver", "1");
        }
        initSOaid();
        WorkExecutor.execute(new com.jd.ad.sdk.jad_hu.jad_dq(context));
        WorkExecutor.execute(new com.jd.ad.sdk.jad_kx.jad_dq(jad_er.jad_an.jad_an, context));
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        int i = com.jd.ad.sdk.jad_tg.jad_an.jad_an;
        if (i < 1) {
            com.jd.ad.sdk.jad_tg.jad_an.jad_an = i + 1;
            JSONObject jSONObject = new JSONObject();
            JsonUtils.put(jSONObject, "tp", 6);
            JsonUtils.put(jSONObject, "iid", UUIDUtils.uuid());
            JsonUtils.put(jSONObject, "init", 1);
            JsonUtils.put(jSONObject, "idu", Long.valueOf(currentTimeMillis2));
            jad_ivVar.jad_bo(jSONObject);
        }
    }

    private static void initAntiSDK(Context context) {
        if (jad_dq.jad_an.jad_an.jad_an(11, (String) null)) {
            return;
        }
        com.jd.ad.sdk.jad_gj.jad_bo jad_boVar = new com.jd.ad.sdk.jad_gj.jad_bo();
        jad_boVar.jad_an = context;
        jad_boVar.jad_bo = false;
        synchronized (com.jd.ad.sdk.jad_gj.jad_an.class) {
            try {
                if (com.jd.ad.sdk.jad_gj.jad_an.jad_bo) {
                    Log.i("AntiSDK", "AntiSDK has initialized.");
                } else {
                    Context context2 = jad_boVar.jad_an;
                    if (context2 == null) {
                        Log.w("AntiSDK", "context is null");
                    } else {
                        boolean z = jad_boVar.jad_bo;
                        com.jd.ad.sdk.jad_dq.jad_an.jad_cp = z;
                        com.jd.ad.sdk.jad_dq.jad_an.jad_bo = z;
                        com.jd.ad.sdk.jad_dq.jad_an.jad_an = z;
                        Log.i("AntiSDK", "init AntiSDK :context=" + jad_boVar.jad_an + ", debugFlag=" + z);
                        com.jd.ad.sdk.jad_gj.jad_an.jad_an = context2;
                        com.jd.ad.sdk.jad_gj.jad_an.jad_bo = true;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void initInternalInitCallBack() {
        mInnerInitCallBack = new jad_cp();
    }

    private static void initJADLog(JADYunSdkConfig jADYunSdkConfig) {
        isEnableLog = jADYunSdkConfig.isEnableLog();
        if (sLogAdapter == null) {
            sLogAdapter = new jad_bo();
            Logger.addLogAdapter(sLogAdapter);
        }
    }

    private static void initSOaid() {
        if (jad_dq.jad_an.jad_an.jad_an(12, (String) null)) {
            return;
        }
        WorkExecutor.execute(new jad_an());
    }

    public static boolean isEnableLog() {
        return isEnableLog;
    }

    public static boolean isInitSuccess() {
        return isInitSuccess;
    }

    public static boolean isSupportMultiProcess() {
        return mSupportMultiProcess;
    }

    public static void syncInit(@NonNull Context context, @NonNull JADYunSdkConfig jADYunSdkConfig, JADInitCallback jADInitCallback) {
        mInitCallback = jADInitCallback;
        init(context, jADYunSdkConfig);
    }
}
