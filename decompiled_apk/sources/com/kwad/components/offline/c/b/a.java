package com.kwad.components.offline.c.b;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.core.soloader.SoLoadListener;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TkLoggerReporter;
import com.kwad.components.offline.api.tk.model.report.TKDownloadMsg;
import com.kwad.library.solder.lib.a.e;
import com.kwad.library.solder.lib.c.b;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.aa;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes11.dex */
public final class a {
    private static long aer;
    private static final AtomicBoolean adq = new AtomicBoolean(false);
    private static final String ael = aa.format("lib%s.so", "tk_runtime_v0_0_161");
    private static final String aem = aa.format("lib%s.so", "tk_runtime_lite_v0_0_161");
    private static final String aen = aa.format("lib%s.so", "kwai-v8");
    private static final String aeo = aa.format("lib%s.so", "kwai-v8-lite");
    private static final String aep = aa.format("lib%s.so", "kwad-fb");
    private static final String aeq = aa.format("lib%s.so", "kwad-yoga");
    private static final String adr = aa.format("lib%s.so", "c++_shared");
    private static Boolean aes = null;

    public static void a(Context context, @NonNull final SoLoadListener soLoadListener) {
        String Cq;
        String str;
        String str2;
        String str3;
        AtomicBoolean atomicBoolean = adq;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        HashMap<String, String> hashMap = new HashMap<>();
        boolean useTkLite = useTkLite();
        if (AbiUtil.isArm64(context)) {
            Cq = d.Cr();
            if (TextUtils.isEmpty(Cq)) {
                if (useTkLite) {
                    Cq = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/3.3.58/ks_tk_so_v8_lite_3358";
                } else {
                    Cq = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/3.3.58/ks_tk_so_v8_3358";
                }
            }
            if (useTkLite) {
                str = "sotk-v8a-lite";
            } else {
                str = "sotk-v8a";
            }
            if (useTkLite) {
                str2 = "0e2d6748c990aa021d01521b6926a5d1";
            } else {
                str2 = "581986671ff8549adfa5bcc94410a6d5";
            }
            if (useTkLite) {
                hashMap.put(aem, "0666493e16b18f08ec178a949c41ce30");
                hashMap.put(aeo, "77545ba1892c1a1d4a039db37b3249eb");
            } else {
                hashMap.put(ael, "a72b02a82df72cd82a3acace986099ad");
                hashMap.put(aen, "7316cd8d074b04e6cb21486288d314ce");
            }
            hashMap.put(aep, "31f065607e6da6b741330d1df0b35460");
            hashMap.put(aeq, "76308532f64b68fd5a930c42cceec22b");
            hashMap.put(adr, "2e989e1c8d777ce169376feb637530e9");
        } else {
            Cq = d.Cq();
            if (TextUtils.isEmpty(Cq)) {
                if (useTkLite) {
                    Cq = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/3.3.58/ks_tk_so_v7_lite_3358";
                } else {
                    Cq = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/3.3.58/ks_tk_so_v7_3358";
                }
            }
            if (useTkLite) {
                str = "sotk-v7a-lite";
            } else {
                str = "sotk-v7a";
            }
            if (useTkLite) {
                str2 = "e9821df3990aca6fc2cd6b5b71c5a1df";
            } else {
                str2 = "16335fa1eb7d19586a6be6aa74778b5b";
            }
            if (useTkLite) {
                hashMap.put(aem, "cb8a97957aa4cb944a27f4353be3384c");
                hashMap.put(aeo, "2dbd72527a0739740746adaae48ed2e0");
            } else {
                hashMap.put(ael, "75ae8eff358638dcddad68117cbbc494");
                hashMap.put(aen, "519ba633e88efafb8fbd536d800da734");
            }
            hashMap.put(aep, "eff11bebb8a3c872fa30b0484b460d12");
            hashMap.put(aeq, "2c6f402c6a565d2e6912b0013fa59380");
            hashMap.put(adr, "2ce4deb75b884953f20ab2e6e149be98");
        }
        b bVar = new b();
        bVar.akW = com.kwad.sdk.core.network.idc.a.EE().ee(Cq);
        bVar.JE = true;
        bVar.akV = str;
        if (useTkLite) {
            str3 = "3.3.60-lite";
        } else {
            str3 = "3.3.60";
        }
        bVar.version = str3;
        bVar.akZ = false;
        bVar.akY = str2;
        bVar.alb = hashMap;
        com.kwad.library.b.a j = com.kwad.library.solder.a.a.j(context, ITkOfflineCompo.PACKAGE_NAME);
        c.d("TkSoLoadHelper", "tkOfflineCompoPlugin: " + j);
        if (j instanceof com.kwad.library.b.a) {
            bVar.ale = j.xy();
        }
        com.kwad.library.solder.a.a.a(context, bVar, new b.c() { // from class: com.kwad.components.offline.c.b.a.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0836b, com.kwad.library.solder.lib.ext.b
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void e(com.kwad.library.solder.lib.b.c cVar) {
                super.e(cVar);
                SoLoadListener.this.onPreUpdate();
                long unused = a.aer = SystemClock.elapsedRealtime();
                TkLoggerReporter.get().reportTKSODownload(ILoggerReporter.Category.APM_LOG, new TKDownloadMsg().setDownloadState(0).setRetryCount(cVar.xV()).setThreadPoolCoreSize(cVar.xP().xC().yd()).toJson());
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0836b, com.kwad.library.solder.lib.ext.b
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void d(com.kwad.library.solder.lib.b.c cVar) {
                super.d(cVar);
                if (cVar.getState() == 4) {
                    TkLoggerReporter.get().reportTKSODownload(ILoggerReporter.Category.APM_LOG, new TKDownloadMsg().setRetryCount(cVar.xV()).setDownloadTime(SystemClock.elapsedRealtime() - a.aer).setDownloadState(1).setThreadPoolCoreSize(cVar.xP().xC().yd()).toJson());
                }
            }

            private void uk() {
                SoLoadListener.this.onLoaded();
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0836b, com.kwad.library.solder.lib.ext.b
            public final /* synthetic */ void a(e eVar, com.kwad.library.solder.lib.a.a aVar) {
                uk();
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0836b, com.kwad.library.solder.lib.ext.b
            public void a(com.kwad.library.solder.lib.b.c cVar, PluginError pluginError) {
                SoLoadListener.this.onFailed(pluginError.getCode(), pluginError);
                if (cVar.getState() == 1) {
                    TkLoggerReporter.get().reportTKSODownload(ILoggerReporter.Category.ERROR_LOG, new TKDownloadMsg().setRetryCount(cVar.xV()).setErrorReason(String.valueOf(pluginError.getCode())).setDownloadState(2).toJson());
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0836b, com.kwad.library.solder.lib.ext.b
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void f(com.kwad.library.solder.lib.b.c cVar) {
                super.f(cVar);
            }
        });
    }

    public static boolean useTkLite() {
        if (aes == null) {
            aes = Boolean.valueOf(!d.a(com.kwad.sdk.core.config.c.ase));
        }
        return aes.booleanValue();
    }
}
