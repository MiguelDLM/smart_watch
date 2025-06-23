package com.bytedance.android.dy.sdk.pangle;

import android.app.Application;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes8.dex */
public class ZeusPlatformUtils {
    public static final int EVENT_DOWNLOAD_FAILED = 4;
    public static final int EVENT_DOWNLOAD_PROGRESS = 2;
    public static final int EVENT_DOWNLOAD_START = 1;
    public static final int EVENT_DOWNLOAD_SUCCESS = 3;
    public static final int EVENT_INSTALL_FAILED = 7;
    public static final int EVENT_INSTALL_START = 5;
    public static final int EVENT_INSTALL_SUCCESS = 6;
    public static final int EVENT_LOAD_FAILED = 10;
    public static final int EVENT_LOAD_START = 8;
    public static final int EVENT_LOAD_SUCCESS = 9;
    public static final int EVENT_REQUEST_FINISH = 0;
    private static final HashMap<Integer, String> PLUGIN_LOAD_EVENT_DESC = new HashMap<Integer, String>() { // from class: com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.1
        {
            put(0, "REQUEST_FINISH");
            put(1, "DOWNLOAD_START");
            put(2, "DOWNLOAD_PROGRESS");
            put(3, "DOWNLOAD_SUCCESS");
            put(4, "DOWNLOAD_FAILED");
            put(5, "INSTALL_START");
            put(6, "INSTALL_SUCCESS");
            put(7, "INSTALL_FAILED");
            put(8, "LOAD_START");
            put(9, "LOAD_SUCCESS");
            put(10, "LOAD_FAILED");
        }
    };
    public static boolean hasInitZeus = false;
    public static final ScheduledExecutorService sExecutor = Executors.newSingleThreadScheduledExecutor();
    private static boolean apmEnable = true;
    private static HashMap<String, String> customTagMap = null;

    /* renamed from: com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils$2, reason: invalid class name */
    /* loaded from: classes8.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ String val$dependPkgName;
        final /* synthetic */ String val$pkgName;
        final /* synthetic */ PluginInitCallback val$pluginInitCallback;

        public AnonymousClass2(PluginInitCallback pluginInitCallback, String str, String str2) {
            this.val$pluginInitCallback = pluginInitCallback;
            this.val$pkgName = str;
            this.val$dependPkgName = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = new Runnable() { // from class: com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (ZeusPlatformUtils.checkPluginState(new Runnable() { // from class: com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.2.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass2.this.val$pluginInitCallback.onPluginInitSuccess();
                        }
                    }, AnonymousClass2.this.val$pkgName)) {
                        AnonymousClass2.this.val$pluginInitCallback.onPluginInitSuccess();
                    }
                }
            };
            if (ZeusPlatformUtils.checkPluginState(runnable, this.val$dependPkgName)) {
                runnable.run();
            }
        }
    }

    public static void addCustomTag(String str, String str2) {
        if (customTagMap == null) {
            customTagMap = new HashMap<>();
        }
        customTagMap.put(str, str2);
    }

    public static void checkPluginInit(final String str, final PluginInitCallback pluginInitCallback) {
        sExecutor.execute(new Runnable() { // from class: com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.3
            @Override // java.lang.Runnable
            public void run() {
                if (ZeusPlatformUtils.checkPluginState(new Runnable() { // from class: com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PluginInitCallback.this.onPluginInitSuccess();
                    }
                }, str)) {
                    PluginInitCallback.this.onPluginInitSuccess();
                }
            }
        });
    }

    public static boolean checkPluginState(final Runnable runnable, final String str) {
        if (Zeus.isPluginInstalled(str)) {
            return !Zeus.isPluginLoaded(str) ? Zeus.loadPlugin(str) : Zeus.isPluginLoaded(str);
        }
        Zeus.registerPluginStateListener(new ZeusPluginStateListener() { // from class: com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.4
            @Override // com.bytedance.pangle.ZeusPluginStateListener
            public void onPluginStateChange(String str2, int i, Object... objArr) {
                if (runnable != null && str.equals(str2) && i == 6) {
                    ZeusPlatformUtils.sExecutor.execute(new Runnable() { // from class: com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (Zeus.isPluginLoaded(str) || Zeus.loadPlugin(str)) {
                                runnable.run();
                            }
                        }
                    });
                }
            }
        });
        return false;
    }

    public static void fetchPlugin(String str) {
        Zeus.onPrivacyAgreed();
        Zeus.fetchPlugin(str);
    }

    public static boolean getApmEnable() {
        return apmEnable;
    }

    public static Plugin getPlugin(String str, boolean z) {
        return Zeus.getPlugin(str, z);
    }

    public static ClassLoader getPluginClassloader(String str) {
        return PluginManager.getInstance().getPlugin(str).mClassLoader;
    }

    public static String getZeusActivityString() {
        return "com.bytedance.pangle.activity";
    }

    public static String getZeusWrapperString() {
        return "com.bytedance.pangle.wrapper";
    }

    public static void initZeus(Application application) {
        if (application == null || hasInitZeus) {
            return;
        }
        GlobalParam.getInstance().init();
        Zeus.init(application, false);
        Zeus.installFromDownloadDir();
        hasInitZeus = true;
    }

    public static boolean isPluginInstalled(String str) {
        return Zeus.isPluginInstalled(str);
    }

    public static boolean isPluginLoaded(String str) {
        return Zeus.isPluginLoaded(str);
    }

    public static void registerZeusPluginLoadStateListener(final String str, final PluginStateListener pluginStateListener) {
        Zeus.registerPluginStateListener(new ZeusPluginStateListener() { // from class: com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.6
            @Override // com.bytedance.pangle.ZeusPluginStateListener
            public void onPluginStateChange(String str2, int i, Object... objArr) {
                if (str.equals(str2)) {
                    pluginStateListener.onPluginStateChanged(i, (String) ZeusPlatformUtils.PLUGIN_LOAD_EVENT_DESC.get(Integer.valueOf(i)));
                }
            }
        });
    }

    public static void setApmEnable(boolean z) {
        apmEnable = z;
    }

    public static void setGlobalParams() {
        GlobalParam.getInstance().setApmFlag(false, false, false, false);
        GlobalParam.getInstance().closeCrashMonitor(true);
    }

    public static void setHostVersionCodeTag(long j) {
        addCustomTag("internal_host_version_code", j + "");
    }

    public static void checkPluginInit(String str, String str2, PluginInitCallback pluginInitCallback) {
        sExecutor.execute(new AnonymousClass2(pluginInitCallback, str2, str));
    }

    public static boolean checkPluginState(final String str) {
        if (Zeus.isPluginInstalled(str)) {
            return !Zeus.isPluginLoaded(str) ? Zeus.loadPlugin(str) : Zeus.isPluginLoaded(str);
        }
        Zeus.registerPluginStateListener(new ZeusPluginStateListener() { // from class: com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.5
            @Override // com.bytedance.pangle.ZeusPluginStateListener
            public void onPluginStateChange(String str2, int i, Object... objArr) {
                if (str.equals(str2) && i == 6 && !Zeus.isPluginLoaded(str)) {
                    Zeus.loadPlugin(str);
                }
            }
        });
        return false;
    }

    public static void initZeus(Application application, boolean z, String str) {
        if (application == null || hasInitZeus) {
            return;
        }
        hasInitZeus = true;
        if (customTagMap != null) {
            GlobalParam.getInstance().setCustomTag(str, customTagMap);
            customTagMap = null;
        }
        if (!apmEnable) {
            GlobalParam.getInstance().setApmFlag(false, false, false, false);
            GlobalParam.getInstance().closeCrashMonitor(true);
        }
        GlobalParam.getInstance().init();
        Zeus.init(application, true);
        Zeus.installFromDownloadDir();
        if (z) {
            Zeus.fetchPlugin(str);
        }
    }
}
