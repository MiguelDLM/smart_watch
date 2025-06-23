package com.bytedance.pangle;

import android.app.Application;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.bytedance.pangle.apm.ApmUtils;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import java.util.HashMap;
import java.util.List;

@Keep
/* loaded from: classes8.dex */
public class Zeus {
    private static Application sApplication;
    private static final HashMap<String, ProviderInfo> serverManagerHashMap = new HashMap<>();
    static final Object wait = new Object();
    private static volatile boolean onPrivacyAgreed = false;

    public static void addExternalAssetsForPlugin(String str, String str2) {
        Plugin plugin;
        Resources resources;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (plugin = getPlugin(str)) != null && (resources = plugin.mResources) != null) {
            new com.bytedance.pangle.res.a().a(resources.getAssets(), str2, false);
        }
    }

    public static void addPluginEventCallback(ZeusPluginEventCallback zeusPluginEventCallback) {
        i a2 = i.a();
        if (zeusPluginEventCallback != null) {
            synchronized (a2.c) {
                a2.c.add(zeusPluginEventCallback);
            }
        }
    }

    public static void fetchPlugin(final String str) {
        com.bytedance.pangle.download.a a2 = com.bytedance.pangle.download.a.a();
        if (com.bytedance.pangle.d.d.a(getAppApplication())) {
            if (GlobalParam.getInstance().autoFetch()) {
                final com.bytedance.pangle.download.b a3 = com.bytedance.pangle.download.b.a();
                Runnable runnable = a3.c.get(str);
                if (runnable != null) {
                    a3.b.removeCallbacks(runnable);
                }
                Runnable runnable2 = new Runnable() { // from class: com.bytedance.pangle.download.b.1
                    /* JADX WARN: Code restructure failed: missing block: B:7:0x0023, code lost:
                    
                        r0 = r0.get(0).topActivity;
                     */
                    @Override // java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final void run() {
                        /*
                            r3 = this;
                            android.app.Application r0 = com.bytedance.pangle.Zeus.getAppApplication()
                            java.lang.String r1 = r0.getPackageName()
                            boolean r2 = android.text.TextUtils.isEmpty(r1)
                            if (r2 != 0) goto L46
                            java.lang.String r2 = "activity"
                            java.lang.Object r0 = r0.getSystemService(r2)
                            android.app.ActivityManager r0 = (android.app.ActivityManager) r0
                            r2 = 1
                            java.util.List r0 = r0.getRunningTasks(r2)
                            if (r0 == 0) goto L46
                            boolean r2 = r0.isEmpty()
                            if (r2 != 0) goto L46
                            r2 = 0
                            java.lang.Object r0 = r0.get(r2)
                            android.app.ActivityManager$RunningTaskInfo r0 = (android.app.ActivityManager.RunningTaskInfo) r0
                            android.content.ComponentName r0 = com.baidu.sec.privacy.d.oIX0oI.oIX0oI(r0)
                            if (r0 == 0) goto L46
                            java.lang.String r0 = r0.getPackageName()
                            boolean r0 = r1.equals(r0)
                            if (r0 == 0) goto L46
                            com.bytedance.pangle.download.b r0 = com.bytedance.pangle.download.b.this
                            android.os.Handler r0 = com.bytedance.pangle.download.b.a(r0)
                            r1 = 1800000(0x1b7740, double:8.89318E-318)
                            r0.postDelayed(r3, r1)
                        L46:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.download.b.AnonymousClass1.run():void");
                    }
                };
                a3.c.put(str, runnable2);
                a3.b.postDelayed(runnable2, 1800000L);
                com.bytedance.pangle.download.b.a();
                if (!a2.f10532a.contains(str)) {
                    a2.f10532a.add(str);
                    return;
                }
                return;
            }
            com.bytedance.pangle.download.b.a();
        }
    }

    public static Application getAppApplication() {
        if (sApplication == null) {
            b.a();
            try {
                sApplication = (Application) MethodUtils.invokeMethod(com.bytedance.pangle.d.a.a(), "getApplication", new Object[0]);
            } catch (Throwable unused) {
            }
        }
        return sApplication;
    }

    public static String getHostAbi() {
        return com.bytedance.pangle.d.b.a();
    }

    public static int getHostAbiBit() {
        return com.bytedance.pangle.d.b.b();
    }

    public static int getInstalledPluginVersion(String str) {
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        if (plugin == null) {
            return -1;
        }
        int version = plugin.getVersion();
        ZeusLogger.d(ZeusLogger.TAG_DOWNLOAD, " getInstalledPluginVersion, " + str + " = " + version);
        return version;
    }

    public static int getMaxInstallVer(String str) {
        if (com.bytedance.pangle.d.d.a(getAppApplication())) {
            return getPlugin(str).getInstalledMaxVer();
        }
        return -1;
    }

    public static Plugin getPlugin(String str) {
        return getPlugin(str, true);
    }

    public static HashMap<String, ProviderInfo> getServerManagerHashMap() {
        return serverManagerHashMap;
    }

    public static String getZeusDid() {
        String did = GlobalParam.getInstance().getDid();
        if (!TextUtils.isEmpty(did)) {
            return did;
        }
        return ApmUtils.getApmInstance().getDid();
    }

    public static boolean hasInit() {
        return i.a().f10573a;
    }

    public static void hookHuaWeiVerifier(Application application) {
        com.bytedance.pangle.receiver.b.a(application);
    }

    public static void init(Application application, boolean z) {
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_COMMON, "start init");
        i.a().a(application, z);
        Object obj = wait;
        synchronized (obj) {
            obj.notifyAll();
        }
        com.bytedance.pangle.service.a.a b = com.bytedance.pangle.service.a.a.b();
        for (Runnable runnable : b.b) {
            if (runnable != null) {
                b.f10614a.post(runnable);
            }
        }
        b.b.clear();
    }

    public static void installFromDownloadDir() {
        if (com.bytedance.pangle.d.d.a(getAppApplication())) {
            PluginManager.getInstance().installFromDownloadDir();
        }
    }

    public static boolean isPluginInstalled(String str) {
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        if (plugin != null && plugin.isInstalled()) {
            return true;
        }
        return false;
    }

    public static boolean isPluginLoaded(String str) {
        return PluginManager.getInstance().isLoaded(str);
    }

    public static boolean loadPlugin(String str) {
        return PluginManager.getInstance().loadPlugin(str);
    }

    public static synchronized void onPrivacyAgreed() {
        synchronized (Zeus.class) {
            if (onPrivacyAgreed) {
                return;
            }
            ApmUtils.getApmInstance().init();
            onPrivacyAgreed = true;
        }
    }

    public static void registerPluginInstallListener(ZeusPluginInstallListener zeusPluginInstallListener) {
        try {
            c a2 = com.bytedance.pangle.servermanager.b.a();
            if (a2 != null) {
                a2.a(zeusPluginInstallListener.hashCode(), new com.bytedance.pangle.f.b(zeusPluginInstallListener));
            }
        } catch (RemoteException e) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "registerPluginInstallListener error.", e);
        }
    }

    public static void registerPluginStateListener(ZeusPluginStateListener zeusPluginStateListener) {
        i.a().b.add(zeusPluginStateListener);
    }

    public static void removePluginEventCallback(ZeusPluginEventCallback zeusPluginEventCallback) {
        i a2 = i.a();
        if (zeusPluginEventCallback != null) {
            synchronized (a2.c) {
                a2.c.remove(zeusPluginEventCallback);
            }
        }
    }

    public static void setAllowDownloadPlugin(String str, int i, boolean z) {
        PluginManager.getInstance().setAllowDownloadPlugin(str, i, z);
    }

    public static void setAppContext(Application application) {
        if (application != null && TextUtils.equals(application.getClass().getSimpleName(), "PluginApplicationWrapper")) {
            try {
                sApplication = (Application) FieldUtils.readField(application, "mOriginApplication");
                return;
            } catch (Throwable unused) {
            }
        }
        sApplication = application;
    }

    public static boolean syncInstallPlugin(String str, String str2) {
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_PLUGIN_INSTALL, "start");
        c a2 = com.bytedance.pangle.servermanager.b.a();
        if (a2 != null) {
            try {
                return a2.a(str, str2);
            } catch (RemoteException e) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "syncInstallPlugin error.", e);
                return false;
            }
        }
        return false;
    }

    public static void triggerBgDexOpt() {
        com.bytedance.pangle.e.f.a();
    }

    public static void unInstallPlugin(String str) {
        PluginManager.getInstance().unInstallPackage(str);
    }

    public static void unregisterPluginStateListener(ZeusPluginStateListener zeusPluginStateListener) {
        List<ZeusPluginStateListener> list = i.a().b;
        if (list != null) {
            list.remove(zeusPluginStateListener);
        }
    }

    public static boolean waitInit(int i) {
        if (i.a().f10573a) {
            return true;
        }
        Object obj = wait;
        synchronized (obj) {
            try {
                if (!i.a().f10573a) {
                    try {
                        if (i == -1) {
                            obj.wait();
                        } else {
                            obj.wait(i);
                        }
                    } catch (InterruptedException unused) {
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i.a().f10573a;
    }

    public void unregisterPluginInstallListener(ZeusPluginInstallListener zeusPluginInstallListener) {
        try {
            c a2 = com.bytedance.pangle.servermanager.b.a();
            if (a2 != null) {
                a2.a(zeusPluginInstallListener.hashCode());
            }
        } catch (RemoteException e) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "unregisterPluginInstallListener error.", e);
        }
    }

    public static Plugin getPlugin(String str, boolean z) {
        return PluginManager.getInstance().getPlugin(str, z);
    }
}
