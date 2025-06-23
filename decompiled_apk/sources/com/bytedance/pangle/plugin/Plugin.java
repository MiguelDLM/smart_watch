package com.bytedance.pangle.plugin;

import O0OOX0IIx.oxoX;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusApplication;
import com.bytedance.pangle.d.e;
import com.bytedance.pangle.h;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.g;
import com.bytedance.pangle.util.k;
import com.bytedance.pangle.util.l;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

@Keep
/* loaded from: classes8.dex */
public class Plugin {
    public static final int LIFE_INSTALLED = 2;
    public static final int LIFE_LOADED = 3;
    public static final int LIFE_PENDING = 1;
    private static final String TAG = "Plugin";
    private int mApiVersionCode;
    public final String mAppKey;
    public final String mAppSecretKey;
    public ZeusApplication mApplication;
    public PluginClassLoader mClassLoader;
    public PluginApplicationWrapper mHostApplication;
    public ApplicationInfo mHostApplicationInfoHookSomeField;
    private volatile boolean mInitialized;
    private String mInternalPath;
    private int mInternalVersionCode;
    public boolean mIsSupportLibIso;
    public int mMaxVersionCode;
    public int mMinVersionCode;
    public final boolean mOpenLoadClassOpt;
    private String mPackageDir;
    public String mPkgName;
    public final boolean mReInstallInternalPluginByMd5;
    public Resources mResources;
    public String mSignature;
    public final boolean mUnInstallPluginWhenHostChange;
    public final boolean mUseMemoryForActivityIntent;
    private int mVersionCode;
    public String response;
    public HashMap<String, ActivityInfo> pluginActivities = new HashMap<>();
    public HashMap<String, ServiceInfo> pluginServices = new HashMap<>();
    public HashMap<String, ActivityInfo> pluginReceiver = new HashMap<>();
    public HashMap<String, ProviderInfo> pluginProvider = new HashMap<>();
    private volatile int mLifeCycle = 1;
    public final List<String> mSharedHostSos = new ArrayList();
    final Object installLock = new Object();
    final Object initializeLock = new Object();

    public Plugin(JSONObject jSONObject) {
        this.mInternalVersionCode = -1;
        this.mMaxVersionCode = Integer.MAX_VALUE;
        this.mPkgName = jSONObject.getString("packageName");
        this.mMinVersionCode = jSONObject.optInt("minPluginVersion", 0);
        this.mMaxVersionCode = jSONObject.optInt("maxPluginVersion", Integer.MAX_VALUE);
        this.mApiVersionCode = jSONObject.getInt("apiVersionCode");
        String signature = GlobalParam.getInstance().getSignature(this.mPkgName);
        this.mSignature = signature;
        if (TextUtils.isEmpty(signature)) {
            this.mSignature = jSONObject.optString(oxoX.f1377Oxx0IOOO, "");
        }
        this.mIsSupportLibIso = jSONObject.optBoolean("isSupportLibIsolate", false);
        this.mInternalPath = jSONObject.optString("internalPath", "");
        this.mInternalVersionCode = jSONObject.optInt("internalVersionCode", -1);
        this.mAppKey = jSONObject.optString("appKey", "");
        this.mAppSecretKey = jSONObject.optString("appSecretKey", "");
        this.mOpenLoadClassOpt = jSONObject.optBoolean("loadClassOpt", false);
        this.mUnInstallPluginWhenHostChange = jSONObject.optBoolean("unInstallPluginWhenHostChange", false);
        this.mUseMemoryForActivityIntent = jSONObject.optBoolean("useMemoryForActivityIntent", false);
        this.mReInstallInternalPluginByMd5 = jSONObject.optBoolean("reInstallInternalPluginByMd5", false);
        JSONArray optJSONArray = jSONObject.optJSONArray("sharedHostSo");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.mSharedHostSos.add((String) optJSONArray.get(i));
            }
        }
        setupInternalPlugin();
    }

    private boolean checkValid(File file, String str, int i) {
        if (!TextUtils.equals(this.mPkgName, str)) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " package name not match !!!");
            return false;
        }
        if (i >= this.mMinVersionCode && i <= this.mMaxVersionCode) {
            if (i < this.mVersionCode && isInstalled()) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + String.format(" pluginApk ver[%s] lower than installed plugin[%s].", Integer.valueOf(i), Integer.valueOf(this.mVersionCode)));
                return false;
            }
            if (file != null && file.exists()) {
                if (i == this.mVersionCode && l.a().f10637a.getString("IDENTITY_".concat(String.valueOf(str)), "").equals(com.bytedance.pangle.util.c.a(file)[0])) {
                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " pluginApk with the same identity has already installed.");
                    return false;
                }
                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + ":" + i + " true");
                return true;
            }
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " pluginApk not exist.");
            return false;
        }
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " " + String.format(" pluginApk ver[%s] not match plugin VerRange[%s, %s].", Integer.valueOf(i), Integer.valueOf(this.mMinVersionCode), Integer.valueOf(this.mMaxVersionCode)));
        return false;
    }

    private boolean checkVersionValid(int i, int i2, boolean z) {
        boolean z2;
        int a2 = l.a().a(this.mPkgName);
        boolean z3 = false;
        if (a2 > i2) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(String.format(" checkVersionValid %s apiVersion downgrade , lastApiVersion=%s , currentApiVersion=%s", this.mPkgName, Integer.valueOf(a2), Integer.valueOf(i2))));
            return false;
        }
        if (i >= 0 && i >= this.mMinVersionCode && i <= this.mMaxVersionCode) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 && i2 != -1) {
            l a3 = l.a();
            String str = this.mPkgName;
            int i3 = a3.f10637a.getInt("API_MIN_" + str + "_" + i, 0);
            l a4 = l.a();
            String str2 = this.mPkgName;
            int i4 = Integer.MAX_VALUE;
            int i5 = a4.f10637a.getInt("API_MAX_" + str2 + "_" + i, Integer.MAX_VALUE);
            if (i5 != 0) {
                i4 = i5;
            }
            if (i2 < i3 || i2 > i4) {
                ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(String.format(" checkVersionValid plugin[%s, ver=%s] is not compatible with api[ver_code=%s], apiCompatibleVer=[%s,%s]", this.mPkgName, Integer.valueOf(this.mVersionCode), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4))));
                z2 = false;
            }
        }
        if (z2 && z && com.bytedance.pangle.d.b.b(new File(com.bytedance.pangle.d.c.b(this.mPkgName, i)))) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(String.format(" checkVersionValid plugin[%s, ver=%s] not match hostAbi", this.mPkgName, Integer.valueOf(i))));
        } else {
            z3 = z2;
        }
        ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin checkVersionValid, pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", valid=" + z3);
        return z3;
    }

    private void deleteIfNeeded() {
        if (com.bytedance.pangle.d.d.a(Zeus.getAppApplication())) {
            if (l.a().f10637a.getBoolean("UNINSTALL__".concat(String.valueOf(this.mPkgName)), false)) {
                l a2 = l.a();
                String str = this.mPkgName;
                SharedPreferences.Editor edit = a2.f10637a.edit();
                edit.remove("UNINSTALL__".concat(String.valueOf(str)));
                edit.apply();
                deleteInstalledPlugin();
                ZeusLogger.w(ZeusLogger.TAG_INIT, "Plugin deleteIfNeeded " + this.mPkgName);
            }
        }
    }

    private void deleteInstalledPlugin() {
        if (TextUtils.isEmpty(this.mPackageDir)) {
            this.mPackageDir = com.bytedance.pangle.d.c.a(this.mPkgName);
        }
        new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.3
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                if (file.getName().matches("^version-(\\d+)$")) {
                    l.a().a(Plugin.this.mPkgName, Integer.parseInt(file.getName().split(HelpFormatter.DEFAULT_OPT_PREFIX)[1]), false);
                }
                return false;
            }
        });
        g.a(this.mPackageDir);
    }

    private void deleteOtherExpiredVer(int i) {
        if (com.bytedance.pangle.d.d.a(Zeus.getAppApplication())) {
            if (TextUtils.isEmpty(this.mPackageDir)) {
                this.mPackageDir = com.bytedance.pangle.d.c.a(this.mPkgName);
            }
            final String concat = "version-".concat(String.valueOf(i));
            new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.4
                @Override // java.io.FileFilter
                public final boolean accept(File file) {
                    if (file != null && !concat.equals(file.getName()) && !"data".equals(file.getName())) {
                        g.a(file.getAbsolutePath());
                        ZeusLogger.w(ZeusLogger.TAG_INIT, "Plugin deleteOtherExpired " + file.getAbsolutePath());
                        if (file.getName().matches("^version-(\\d+)$")) {
                            l.a().a(Plugin.this.mPkgName, Integer.parseInt(file.getName().split(HelpFormatter.DEFAULT_OPT_PREFIX)[1]), false);
                        }
                    }
                    return false;
                }
            });
        }
    }

    private void installInternalPlugin() {
        if (com.bytedance.pangle.d.d.a(Zeus.getAppApplication())) {
            if (this.mReInstallInternalPluginByMd5) {
                if (getVersion() > this.mInternalVersionCode) {
                    return;
                }
            } else if (getVersion() >= this.mInternalVersionCode) {
                return;
            }
            if (!TextUtils.isEmpty(this.mInternalPath)) {
                e.a(new Runnable() { // from class: com.bytedance.pangle.plugin.Plugin.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        File file;
                        try {
                            if (Plugin.this.mInternalPath.endsWith(".7z.zip")) {
                                file = new File(com.bytedance.pangle.d.c.b(), Plugin.this.mPkgName + ".7z.zip");
                            } else {
                                file = new File(com.bytedance.pangle.d.c.b(), Plugin.this.mPkgName + com.huawei.hms.ads.dynamicloader.b.b);
                            }
                            ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin copyInternalPlugin " + Plugin.this.mInternalPath + " --> " + file.getAbsolutePath());
                            g.a(Zeus.getAppApplication().getAssets().open(Plugin.this.mInternalPath), new FileOutputStream(file));
                            if (file.exists()) {
                                PluginManager.getInstance().asyncInstall(Plugin.this.mPkgName, file);
                                return;
                            }
                            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "installInternalPlugin failed. " + file.getAbsolutePath() + " is not exists.");
                        } catch (Throwable th) {
                            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "installInternalPlugin failed. " + th.getMessage());
                        }
                    }
                });
            }
        }
    }

    private int modifyResIfNeed(int i) {
        String a2 = com.bytedance.pangle.util.b.a(Zeus.getAppApplication());
        if (!TextUtils.isEmpty(a2) && TextUtils.equals(l.a().b(this.mPkgName), a2)) {
            return i;
        }
        if (!this.mUnInstallPluginWhenHostChange && !GlobalParam.getInstance().unInstallPluginWhenHostChange(this.mPkgName)) {
            ZeusLogger.d(ZeusLogger.TAG_INIT, "modifyRes by init. " + this.mPkgName + " " + i);
            int a3 = new com.bytedance.pangle.res.a.c().a(new File(com.bytedance.pangle.d.c.b(this.mPkgName, i)), true, new StringBuilder());
            if (a3 != 100 && a3 != 200) {
                return 0;
            }
            return i;
        }
        ZeusLogger.d(ZeusLogger.TAG_INIT, "uninstall plugin by host update. " + this.mPkgName + " " + i);
        return 0;
    }

    private void setupInternalPlugin() {
        int a2;
        if (l.a().f10637a.getInt(String.format(Locale.getDefault(), "OFFLINE_INTERNAL_%s", this.mPkgName), -1) == this.mApiVersionCode) {
            return;
        }
        if (!TextUtils.isEmpty(this.mInternalPath) && this.mInternalVersionCode != -1) {
            return;
        }
        try {
            for (String str : Zeus.getAppApplication().getAssets().list(h.d)) {
                if (str.startsWith(this.mPkgName + "_") && (a2 = k.a(str.split("_")[1])) != -1) {
                    this.mInternalPath = h.d + "/" + str;
                    this.mInternalVersionCode = a2;
                    return;
                }
            }
        } catch (IOException e) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "setupInternalPlugin failed.", e);
        }
    }

    private void updateInstallStateFromMainProcess() {
        com.bytedance.pangle.c a2;
        try {
            if (!com.bytedance.pangle.d.d.a(Zeus.getAppApplication()) && this.mLifeCycle < 2 && (a2 = com.bytedance.pangle.servermanager.b.a()) != null && a2.a(this.mPkgName)) {
                updateToInstalled(a2.b(this.mPkgName));
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("updateInstallStateFromMainProcess error. process = ");
            Zeus.getAppApplication();
            sb.append(com.bytedance.pangle.d.d.a());
            ZeusLogger.w(ZeusLogger.TAG_PPM, sb.toString(), th);
        }
    }

    private void updateToInstalled(int i) {
        this.mVersionCode = i;
        this.mLifeCycle = 2;
    }

    public int getApiVersionCode() {
        return this.mApiVersionCode;
    }

    public int getInstalledMaxVer() {
        if (TextUtils.isEmpty(this.mPackageDir)) {
            this.mPackageDir = com.bytedance.pangle.d.c.a(this.mPkgName);
        }
        File[] listFiles = new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.2
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                if (file != null && file.getName().matches("^version-(\\d+)$")) {
                    return true;
                }
                return false;
            }
        });
        int i = -1;
        if (listFiles != null && listFiles.length > 0) {
            for (File file : listFiles) {
                int parseInt = Integer.parseInt(file.getName().split(HelpFormatter.DEFAULT_OPT_PREFIX)[1]);
                if (parseInt > i && l.a().a(this.mPkgName, parseInt) && new File(com.bytedance.pangle.d.c.b(this.mPkgName, parseInt)).exists()) {
                    i = parseInt;
                }
            }
        }
        ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin getInstalledMaxVersion, pkg=" + this.mPkgName + ", maxVer=" + i);
        return i;
    }

    public String getInternalPath() {
        return this.mInternalPath;
    }

    public int getInternalVersionCode() {
        return this.mInternalVersionCode;
    }

    public int getLifeCycle() {
        updateInstallStateFromMainProcess();
        return this.mLifeCycle;
    }

    public String getNativeLibraryDir() {
        int i = this.mVersionCode;
        if (i > 0) {
            return com.bytedance.pangle.d.c.d(this.mPkgName, i);
        }
        return com.bytedance.pangle.d.c.a(this.mPkgName);
    }

    public int getVersion() {
        updateInstallStateFromMainProcess();
        return this.mVersionCode;
    }

    public void init() {
        boolean z;
        if (this.mInitialized) {
            return;
        }
        synchronized (this.initializeLock) {
            try {
                if (this.mInitialized) {
                    return;
                }
                if (com.bytedance.pangle.d.d.a(Zeus.getAppApplication())) {
                    int i = 0;
                    if (!TextUtils.isEmpty(l.a().f10637a.getString("HOST_ABI_".concat(String.valueOf(this.mPkgName)), ""))) {
                        l a2 = l.a();
                        String str = this.mPkgName;
                        z = !TextUtils.equals(a2.f10637a.getString("HOST_ABI_".concat(String.valueOf(str)), ""), Zeus.getHostAbi());
                        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils isHostAbiUpdate HOST_ABI=" + a2.f10637a.getString("HOST_ABI_".concat(String.valueOf(str)), "") + ", " + Zeus.getHostAbi() + ", result=" + z);
                    } else {
                        z = false;
                    }
                    deleteIfNeeded();
                    int installedMaxVer = getInstalledMaxVer();
                    if (checkVersionValid(installedMaxVer, this.mApiVersionCode, z)) {
                        i = modifyResIfNeed(installedMaxVer);
                        updateToInstalled(i);
                    }
                    deleteOtherExpiredVer(i);
                    ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin initPlugins result=".concat(String.valueOf(this)));
                    l a3 = l.a();
                    String str2 = this.mPkgName;
                    SharedPreferences.Editor edit = a3.f10637a.edit();
                    edit.putString("ROM_LAST_".concat(String.valueOf(str2)), Build.VERSION.INCREMENTAL);
                    edit.apply();
                    l a4 = l.a();
                    String str3 = this.mPkgName;
                    String string = a4.f10637a.getString("HOST_ABI_".concat(String.valueOf(str3)), "");
                    SharedPreferences.Editor edit2 = a4.f10637a.edit();
                    edit2.putString("HOST_ABI_".concat(String.valueOf(str3)), Zeus.getHostAbi());
                    edit2.apply();
                    ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setHostAbiUpdated HOST_ABI=" + string + " --> " + Zeus.getHostAbi());
                    l a5 = l.a();
                    String str4 = this.mPkgName;
                    String a6 = com.bytedance.pangle.util.b.a(Zeus.getAppApplication());
                    String b = a5.b(str4);
                    if (!TextUtils.equals(b, a6)) {
                        SharedPreferences.Editor edit3 = a5.f10637a.edit();
                        edit3.putString("HOST_IDENTITY_".concat(String.valueOf(str4)), a6);
                        edit3.apply();
                    }
                    ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setHostIdentity(" + str4 + ") " + b + " --> " + a6);
                    l a7 = l.a();
                    String str5 = this.mPkgName;
                    int i2 = this.mApiVersionCode;
                    int a8 = a7.a(str5);
                    if (a8 != i2) {
                        SharedPreferences.Editor edit4 = a7.f10637a.edit();
                        edit4.putInt("PLUGIN_API_VERSION_".concat(String.valueOf(str5)), i2);
                        edit4.apply();
                    }
                    ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setPluginApiVersion " + a8 + " --> " + i2);
                } else {
                    updateInstallStateFromMainProcess();
                }
                this.mInitialized = true;
                installInternalPlugin();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void injectResponse(String str) {
        this.response = str;
    }

    public boolean install(File file, com.bytedance.pangle.f.a.e eVar) {
        boolean z = false;
        try {
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin install from local file " + file + ", " + Thread.currentThread().getName());
            String str = eVar.f10549a;
            int i = eVar.b;
            synchronized (this.installLock) {
                try {
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin synchronized begin, plugin=".concat(String.valueOf(this)));
                    boolean checkValid = checkValid(file, str, i);
                    if (checkValid) {
                        String str2 = com.bytedance.pangle.util.c.a(file)[0];
                        z = b.a(file, str, i);
                        if (z) {
                            l a2 = l.a();
                            String str3 = this.mPkgName;
                            SharedPreferences.Editor edit = a2.f10637a.edit();
                            edit.putString("IDENTITY_".concat(String.valueOf(str3)), str2);
                            edit.apply();
                            l.a().a(this.mPkgName, i, true);
                            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin markPluginInstalled, " + this.mPkgName + ":" + i + " identity=" + str2);
                            g.a(file);
                        }
                    }
                    synchronized (this) {
                        try {
                            if (checkValid) {
                                if (this.mLifeCycle != 3) {
                                    if (z) {
                                        updateToInstalled(i);
                                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin INSTALLED " + str + ":" + i);
                                    } else {
                                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin INSTALL_FAILED" + str + ":" + i);
                                        g.a(file);
                                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin delete file by failedCount > 0 " + str + ":" + i);
                                    }
                                } else {
                                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin LIFE_LOADED, valid next restart " + str + ":" + i);
                                }
                            } else {
                                g.a(file);
                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin deleting invalid " + str + ":" + i);
                            }
                        } finally {
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "Plugin IMPOSSIBLE!!!", th2);
        }
        return z;
    }

    public boolean isInstalled() {
        updateInstallStateFromMainProcess();
        if (this.mLifeCycle >= 2) {
            return true;
        }
        return false;
    }

    public boolean isLoaded() {
        if (this.mLifeCycle == 3) {
            return true;
        }
        return false;
    }

    public boolean isVersionInstalled(int i) {
        return l.a().a(this.mPkgName, i);
    }

    public void setApiCompatVersion(int i, int i2, int i3) {
        l a2 = l.a();
        String str = this.mPkgName;
        SharedPreferences.Editor edit = a2.f10637a.edit();
        edit.putInt("API_MIN_" + str + "_" + i, i2);
        edit.putInt("API_MAX_" + str + "_" + i, i3);
        edit.apply();
    }

    public void setLifeCycle(int i) {
        this.mLifeCycle = i;
    }

    public String toString() {
        return "Plugin{pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", life=" + this.mLifeCycle + '}';
    }
}
