package com.bytedance.pangle.plugin;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.baidu.tts.emstatistics.TtsStatsUploadBag;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.c.b;
import com.bytedance.pangle.f.a.e;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.g;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private File f10583a;
    private final String b;

    public a(String str, File file) {
        this.f10583a = file;
        this.b = str;
    }

    private static File a(File file) {
        if (file.exists() || file.getParent() == null) {
            return file;
        }
        File[] listFiles = new File(file.getParent()).listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return null;
        }
        for (File file2 : listFiles) {
            if (file2.exists() && file2.getName().endsWith(com.huawei.hms.ads.dynamicloader.b.b)) {
                return file2;
            }
        }
        return file;
    }

    private void b() {
        int i = 3;
        while (i > 0) {
            i--;
            try {
                File file = new File(this.f10583a.getAbsolutePath() + "_unzip");
                if (file.exists()) {
                    file.delete();
                    file.mkdirs();
                }
                g.b(this.f10583a.getAbsolutePath(), file.getAbsolutePath());
                File[] listFiles = file.listFiles();
                File file2 = this.f10583a;
                if (listFiles != null && listFiles.length > 0) {
                    file2 = listFiles[0];
                }
                File a2 = a(file2);
                if (a2 != null && a2.exists() && a2.isFile()) {
                    this.f10583a = a2;
                    ZeusLogger.d("Plugin install : unZip count : " + (3 - i));
                    return;
                }
            } catch (Exception e) {
                ZeusLogger.errReport(ZeusLogger.TAG_INIT, "Plugin install : unZip file failed !!!", e);
                e.printStackTrace();
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();
    }

    private static void a(String str, int i, @NonNull String str2, long j, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt(TtsStatsUploadBag.KEY_HTTP_STATUS_CODE, com.bytedance.pangle.log.b.a(Integer.valueOf(i)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.b.a(str2));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.b.a((Object) 0));
            jSONObject3.putOpt("duration", Integer.valueOf(com.bytedance.pangle.log.b.b(Long.valueOf(j))));
            jSONObject2.putOpt("message", com.bytedance.pangle.log.b.a(str3));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.bytedance.pangle.c.b.a().a(str, jSONObject, jSONObject3, jSONObject2);
    }

    public final boolean a() {
        if (g.b(this.f10583a)) {
            ZeusLogger.d("Plugin install : start unZip file ~~~~");
            long elapsedRealtime = SystemClock.elapsedRealtime();
            b();
            a(com.bytedance.pangle.c.b.h, b.a.G, this.b, SystemClock.elapsedRealtime() - elapsedRealtime, "");
            ZeusLogger.d("Plugin install : start install from unZip ~~~~");
        } else {
            ZeusLogger.d("Plugin install : start install without unZip ~~~~");
        }
        e a2 = com.bytedance.pangle.f.a.d.a(this.f10583a);
        if (a2 == null) {
            ZeusPluginStateListener.postStateChange(this.b, 7, " read local file package info failed !!! pluginPkg = " + this.b + " mApkFile.exists = " + this.f10583a.exists());
            StringBuilder sb = new StringBuilder("PluginInstallRunnable read local file package info failed !!! pluginPkg = ");
            sb.append(this.b);
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, sb.toString());
            return false;
        }
        Plugin plugin = PluginManager.getInstance().getPlugin(a2.f10549a);
        if (plugin == null) {
            ZeusPluginStateListener.postStateChange(this.b, 7, " plugin == null !!! pluginPkg = " + this.b);
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstallRunnable cannot query valid plugin !!! packageName = " + a2.f10549a);
            return false;
        }
        boolean install = plugin.install(this.f10583a, a2);
        if (install) {
            ZeusPluginStateListener.postStateChange(a2.f10549a, 6, new Object[0]);
        } else {
            ZeusPluginStateListener.postStateChange(a2.f10549a, 7, "Internal error.");
        }
        return install;
    }
}
