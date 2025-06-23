package com.huawei.openalliance.ad.inter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import android.util.Log;
import com.huawei.hms.ads.InformationController;
import com.huawei.hms.ads.RequestOptions;
import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.hms.ads.consent.inter.Consent;
import com.huawei.hms.ads.cz;
import com.huawei.hms.ads.ed;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.iy;
import com.huawei.openalliance.ad.constant.bb;
import com.huawei.openalliance.ad.constant.s;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.inter.listeners.AppDownloadListener;
import com.huawei.openalliance.ad.inter.listeners.ExtensionActionListener;
import com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.media.IMultiMediaPlayingManager;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.ag;
import com.huawei.openalliance.ad.utils.ar;
import com.huawei.openalliance.ad.utils.av;
import com.huawei.openalliance.ad.utils.aw;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.bf;
import com.huawei.openalliance.ad.utils.n;
import com.huawei.openalliance.ad.utils.r;
import com.huawei.openalliance.ad.utils.w;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@AllApi
/* loaded from: classes10.dex */
public final class HiAd implements IHiAd {
    private static final byte[] B = new byte[0];
    private static final String I = "hw_sc.build.os.enable";
    private static final String V = "HiAd";
    private static HiAd Z;
    private Context C;
    private IMultiMediaPlayingManager D;
    private AppDownloadListener L;
    private ed S;

    /* renamed from: a, reason: collision with root package name */
    private IAppDownloadManager f17393a;
    private ExtensionActionListener b;
    private Integer d;
    private boolean e;
    private Boolean f;
    private Map<BroadcastReceiver, IntentFilter> F = new HashMap();
    private int c = -1;
    private BroadcastReceiver g = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.inter.HiAd.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                try {
                    if (intent.getExtras() != null) {
                        if (intent.getExtras().getBoolean(x.bl)) {
                            HiAd.this.e = true;
                            iy.Code();
                        } else {
                            HiAd.this.e = false;
                        }
                    }
                } catch (Throwable th) {
                    fb.I(HiAd.V, "onReceive error:" + th.getClass().getSimpleName());
                }
            }
        }
    };
    private BroadcastReceiver h = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.inter.HiAd.8
        @Override // android.content.BroadcastReceiver
        public void onReceive(final Context context, final Intent intent) {
            if (intent == null) {
                return;
            }
            bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.8.1
                @Override // java.lang.Runnable
                public void run() {
                    String action = intent.getAction();
                    for (Map.Entry entry : HiAd.this.F.entrySet()) {
                        BroadcastReceiver broadcastReceiver = (BroadcastReceiver) entry.getKey();
                        IntentFilter intentFilter = (IntentFilter) entry.getValue();
                        if (intentFilter != null && intentFilter.matchAction(action)) {
                            broadcastReceiver.onReceive(context, intent);
                        }
                    }
                }
            });
        }
    };
    RequestOptions Code = new RequestOptions.Builder().build();

    /* loaded from: classes10.dex */
    public static class a implements RemoteCallResultCallback<String> {
        private a() {
        }

        @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
        public void onRemoteCallResult(String str, CallResult<String> callResult) {
            if (callResult.getCode() == 200) {
                fb.Code(HiAd.V, "success: set install permission in hms, %s", str);
            } else {
                fb.I(HiAd.V, "error: set install permission in hms, %s", str);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class b implements Runnable {
        private final AppDownloadListener Code;

        public b(AppDownloadListener appDownloadListener) {
            this.Code = appDownloadListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.huawei.openalliance.ad.download.a.Code().Code(this.Code);
        }
    }

    private HiAd(Context context) {
        this.C = context.getApplicationContext();
        D();
        L();
        this.S = ed.Code(this.C);
        a();
        aw.Code(this.C);
        C();
        if (isEnableUserInfo()) {
            F();
        }
        S();
    }

    public static boolean B() {
        String Code = bc.Code(I);
        if (fb.Code()) {
            fb.Code(V, "hmftype: %s", Code);
        }
        return Boolean.parseBoolean(Code);
    }

    private void C() {
        if (w.C()) {
            com.huawei.openalliance.ad.utils.h.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.4
                @Override // java.lang.Runnable
                public void run() {
                    Consent.getInstance(HiAd.this.C).getNpaAccordingToServerConsent();
                }
            });
        }
    }

    private void D() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.C.registerReceiver(this.h, intentFilter);
    }

    private void F() {
        com.huawei.openalliance.ad.utils.h.V(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.6
            @Override // java.lang.Runnable
            public void run() {
                int ad = HiAd.this.S.ad();
                boolean V2 = n.V(HiAd.this.C);
                fb.V(HiAd.V, "preRequest, type: %s, isTv: %s", Integer.valueOf(ad), Boolean.valueOf(V2));
                if (ad != 0 || V2) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(bb.ag, ad);
                        jSONObject.put(bb.ah, V2);
                        com.huawei.openalliance.ad.ipc.g.V(HiAd.this.C.getApplicationContext()).Code("preRequest", jSONObject.toString(), null, null);
                    } catch (JSONException unused) {
                        fb.I(HiAd.V, "preRequest error.");
                    }
                }
            }
        });
    }

    private void L() {
        fb.Code(V, "registerUSBObserver");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(x.bk);
        this.C.registerReceiver(this.g, intentFilter);
    }

    private void S() {
        com.huawei.openalliance.ad.utils.h.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.5
            @Override // java.lang.Runnable
            public void run() {
                cz.Code(HiAd.this.C);
                com.huawei.hms.ads.g.Code(HiAd.this.C);
                com.huawei.openalliance.ad.utils.d.e(HiAd.this.C);
            }
        });
    }

    private void a() {
        com.huawei.openalliance.ad.download.app.g.Code(this.C);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        c();
        d();
    }

    private void c() {
        StringBuilder sb = new StringBuilder();
        sb.append(av.Z(this.C));
        String str = File.separator;
        sb.append(str);
        sb.append(x.i);
        sb.append(str);
        String sb2 = sb.toString();
        if (ay.Code(sb2)) {
            return;
        }
        r.Code(sb2);
    }

    private void d() {
        StringBuilder sb = new StringBuilder();
        sb.append(av.B(this.C));
        String str = File.separator;
        sb.append(str);
        sb.append(x.i);
        sb.append(str);
        String sb2 = sb.toString();
        if (ay.Code(sb2)) {
            return;
        }
        r.Code(sb2);
    }

    @AllApi
    public static void disableUserInfo(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append("disableUserInfo, context ");
        sb.append(context == null ? "is null" : "not null");
        Log.i(V, sb.toString());
        if (context == null) {
            return;
        }
        ed.Code(context).Code(false);
        getInstance(context).enableUserInfo(false);
    }

    @AllApi
    public static IHiAd getInstance(Context context) {
        return V(context);
    }

    @com.huawei.openalliance.ad.annotations.b
    public Integer I() {
        return this.d;
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void enableSharePd(boolean z) {
        if (w.Code(this.C)) {
            this.S.V(z);
        }
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void enableUserInfo(boolean z) {
        if (w.Code(this.C)) {
            this.S.Code(z);
            if (z) {
                return;
            }
            com.huawei.openalliance.ad.utils.h.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.7
                @Override // java.lang.Runnable
                public void run() {
                    HiAd.this.b();
                }
            });
        }
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public int getAppActivateStyle() {
        return ed.Code(this.C).Y();
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public IAppDownloadManager getAppDownloadManager() {
        if (this.f17393a == null) {
            this.f17393a = (IAppDownloadManager) ar.V(x.ag);
        }
        return this.f17393a;
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public ExtensionActionListener getExtensionActionListener() {
        return this.b;
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public RequestOptions getRequestConfiguration() {
        return this.Code;
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void informReady() {
        e.Code(this.C).V();
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void initGrs(String str) {
        try {
            fb.V(V, "initGrs, appName: %s", str);
            Class<?> cls = Class.forName("com.huawei.openalliance.ad.ppskit.utils.ServerConfig");
            ar.Code(null, cls, "setGrsAppName", new Class[]{String.class}, new Object[]{str});
            ar.Code(null, cls, "init", new Class[]{Context.class}, new Object[]{this.C});
        } catch (Throwable unused) {
            fb.I(V, "fail to find ServerConfig in adscore");
        }
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void initLog(boolean z, int i) {
        initLog(z, i, null);
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public boolean isAppAutoOpenForbidden() {
        return ed.Code(this.C).ac();
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public boolean isAppInstalledNotify() {
        return ed.Code(this.C).X();
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public boolean isEnableUserInfo() {
        if (w.Code(this.C)) {
            return this.S.f();
        }
        return false;
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public boolean isNewProcess() {
        boolean z = this.c != Process.myPid();
        if (z) {
            this.c = Process.myPid();
        }
        fb.V(V, "isNewProcess:" + z);
        return z;
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public Boolean isOpenWebPageByBrowser() {
        return this.f;
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void onBackground() {
        Code("stopTimer");
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void onForeground() {
        Code("startTimer");
        Context context = this.C;
        if (context != null) {
            I(context);
        }
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setAppActivateStyle(final int i) {
        com.huawei.openalliance.ad.download.app.c.Code(this.C, isAppInstalledNotify(), i, bb.X, new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.inter.HiAd.2
            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                if (callResult.getCode() == 200) {
                    ed.Code(HiAd.this.C).F(i);
                }
            }
        }, String.class);
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setAppAutoOpenForbidden(final boolean z) {
        fb.V(V, "set app AutoOpenForbidden: " + z);
        com.huawei.openalliance.ad.download.app.c.Code(this.C, z, new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.inter.HiAd.3
            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                if (callResult.getCode() == 200) {
                    fb.V(HiAd.V, "set app AutoOpenForbidden: " + z);
                    ed.Code(HiAd.this.C).Z(z);
                }
            }
        }, String.class);
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setAppDownloadListener(AppDownloadListener appDownloadListener) {
        this.L = appDownloadListener;
        bf.Code(new b(appDownloadListener));
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setAppInstalledNotify(final boolean z) {
        fb.Code(V, "set app installed notify: " + z);
        com.huawei.openalliance.ad.download.app.c.Code(this.C, z, getAppActivateStyle(), "full_screen_notify", new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.inter.HiAd.11
            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                if (callResult.getCode() == 200) {
                    ed.Code(HiAd.this.C).I(z);
                }
            }
        }, String.class);
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setAppMuted(boolean z) {
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setAppVolume(float f) {
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setApplicationCode(String str) {
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setBrand(int i) {
        this.d = Integer.valueOf(i);
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setConsent(final String str) {
        fb.V(V, "set TCF consent string");
        com.huawei.openalliance.ad.utils.h.I(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.10
            @Override // java.lang.Runnable
            public void run() {
                com.huawei.openalliance.ad.ipc.d.Code(HiAd.this.C).Code(s.o, str, null, null);
            }
        });
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setCountryCode(String str) {
        this.S.Code(str);
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setExtensionActionListener(ExtensionActionListener extensionActionListener) {
        this.b = extensionActionListener;
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setInfoController(InformationController informationController) {
        if (informationController == null) {
            fb.V(V, "param err");
        } else if (informationController.I() == null && informationController.V() == null && informationController.Code() == null) {
            fb.V(V, "no valid value");
        } else {
            com.huawei.openalliance.ad.ipc.b.Code(this.C).Code(s.H, aa.V(informationController), null);
        }
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setMultiMediaPlayingManager(IMultiMediaPlayingManager iMultiMediaPlayingManager) {
        this.D = iMultiMediaPlayingManager;
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setOpenWebPageByBrowser(boolean z) {
        this.f = Boolean.valueOf(z);
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setRequestConfiguration(RequestOptions requestOptions) {
        this.Code = requestOptions;
    }

    @com.huawei.openalliance.ad.annotations.b
    public static HiAd Code(Context context) {
        return V(context);
    }

    private void I(Context context) {
        boolean a2 = bc.a(context);
        fb.Code(V, "has install permission is: %s", Boolean.valueOf(a2));
        com.huawei.openalliance.ad.download.app.c.V(context.getApplicationContext(), a2, new a(), String.class);
    }

    private static HiAd V(Context context) {
        HiAd hiAd;
        synchronized (B) {
            try {
                if (Z == null) {
                    Z = new HiAd(context);
                }
                hiAd = Z;
            } catch (Throwable th) {
                throw th;
            }
        }
        return hiAd;
    }

    public boolean Z() {
        return this.e;
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void initGrs(String str, String str2) {
        initGrs(str);
        try {
            fb.V(V, "initGrs, appName: %s, countryCode: %s", str, str2);
            ar.Code(null, Class.forName("com.huawei.openalliance.ad.ppskit.utils.ServerConfig"), "setRouterCountryCode", new Class[]{String.class}, new Object[]{str2});
            this.S.Z(str2);
        } catch (Throwable unused) {
            fb.I(V, "fail to find ServerConfig in adscore");
        }
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void initLog(boolean z, int i, String str) {
        if (w.Code(this.C) && z) {
            ag.Code(this.C, i, str);
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public AppDownloadListener Code() {
        return this.L;
    }

    public IMultiMediaPlayingManager V() {
        IMultiMediaPlayingManager iMultiMediaPlayingManager = this.D;
        return iMultiMediaPlayingManager != null ? iMultiMediaPlayingManager : com.huawei.openalliance.ad.media.c.Code(this.C);
    }

    public void Code(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver == null) {
            return;
        }
        this.F.remove(broadcastReceiver);
    }

    public void Code(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (broadcastReceiver == null) {
            return;
        }
        this.F.put(broadcastReceiver, intentFilter);
    }

    private void Code(final String str) {
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.9
            @Override // java.lang.Runnable
            public void run() {
                Object Code;
                Class Code2 = ar.Code("com.huawei.openalliance.ad.inter.n");
                if (Code2 == null || (Code = ar.Code(null, Code2, "getInstance", new Class[]{Context.class}, new Object[]{HiAd.this.C})) == null) {
                    return;
                }
                ar.Code(Code, Code2, str, null, null);
            }
        });
    }
}
