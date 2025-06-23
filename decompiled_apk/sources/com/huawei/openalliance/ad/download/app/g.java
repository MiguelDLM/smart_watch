package com.huawei.openalliance.ad.download.app;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.dp;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.inter.listeners.AppDownloadListener;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.w;

/* loaded from: classes10.dex */
public class g extends com.huawei.openalliance.ad.download.b<AppDownloadTask> {
    private static final byte[] B = new byte[0];
    private static g C = null;
    private static final String Z = "ApDnMgr";
    private e F;
    private Context S;

    /* loaded from: classes10.dex */
    public interface a {
        void Code(boolean z);
    }

    private g(Context context) {
        super(context);
        super.Code();
        this.S = context.getApplicationContext();
        e eVar = new e(context);
        this.F = eVar;
        super.Code(eVar);
    }

    private boolean B(AppDownloadTask appDownloadTask) {
        return appDownloadTask.B() == 2 && appDownloadTask.S() == 50 && appDownloadTask.Z() == 0;
    }

    private boolean C(AppDownloadTask appDownloadTask) {
        if (appDownloadTask == null) {
            return false;
        }
        while (appDownloadTask.l()) {
            fb.V(Z, "switch next install way succ, curInstallWay:%s", appDownloadTask.j());
            if (!appDownloadTask.n() || w.S(this.Code)) {
                return true;
            }
        }
        fb.V(Z, "switch next install way fail, curInstallWay:%s", appDownloadTask.j());
        return false;
    }

    public static g I() {
        g gVar;
        synchronized (B) {
            try {
                gVar = C;
                if (gVar == null) {
                    throw new dp("AppDownloadManager instance is not init!");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return gVar;
    }

    private boolean S(AppDownloadTask appDownloadTask) {
        AdContentData f = appDownloadTask.f();
        if (f != null) {
            return new com.huawei.openalliance.ad.uriaction.b(this.Code, f).Code();
        }
        return false;
    }

    @Override // com.huawei.openalliance.ad.download.b
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public AppDownloadTask Code(String str) {
        fb.V(Z, "getTask by pkg");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        AppDownloadTask appDownloadTask = (AppDownloadTask) super.Code(str);
        if (appDownloadTask != null) {
            return appDownloadTask;
        }
        fb.Code(Z, " local task is null,try get remote");
        AppInfo appInfo = new AppInfo();
        appInfo.b(str);
        appInfo.I("5");
        RemoteAppDownloadTask remoteAppDownloadTask = (RemoteAppDownloadTask) c.Code(this.S, appInfo, true, RemoteAppDownloadTask.class);
        if (remoteAppDownloadTask == null) {
            fb.V(Z, "remote agd task is null, get restore task");
            appInfo.I("11");
            remoteAppDownloadTask = (RemoteAppDownloadTask) c.Code(this.S, appInfo, false, RemoteAppDownloadTask.class);
        }
        return Code(appInfo, remoteAppDownloadTask);
    }

    public boolean Z(AppDownloadTask appDownloadTask) {
        if (!C(appDownloadTask)) {
            return false;
        }
        V((g) appDownloadTask);
        Code(appDownloadTask);
        return true;
    }

    public AppDownloadTask Code(AppInfo appInfo) {
        fb.V(Z, "getTask by appInfo");
        if (V(appInfo)) {
            return null;
        }
        AppDownloadTask appDownloadTask = (AppDownloadTask) super.Code(appInfo.Code());
        if (appDownloadTask == null) {
            fb.Code(Z, " local task is null,try get remote");
            RemoteAppDownloadTask remoteAppDownloadTask = (RemoteAppDownloadTask) c.Code(this.S, appInfo, false, RemoteAppDownloadTask.class);
            if (remoteAppDownloadTask == null && "11".equals(appInfo.i())) {
                fb.Code(Z, "restore scenario, but may has agd task, query again");
                remoteAppDownloadTask = (RemoteAppDownloadTask) c.Code(this.S, appInfo, true, RemoteAppDownloadTask.class);
            }
            appDownloadTask = Code(appInfo, remoteAppDownloadTask);
        }
        if (appDownloadTask != null && !appDownloadTask.m()) {
            appDownloadTask.a(appInfo.x());
        }
        return appDownloadTask;
    }

    public void I(final AppDownloadTask appDownloadTask) {
        if (appDownloadTask == null) {
            return;
        }
        c.Code(this.S, appDownloadTask, new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.download.app.g.3
            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                if (callResult.getCode() != -1) {
                    fb.V(g.Z, " resume task is success:" + appDownloadTask.F());
                }
            }
        }, String.class);
    }

    public void V(final AppDownloadTask appDownloadTask) {
        if (appDownloadTask == null) {
            return;
        }
        c.V(this.S, appDownloadTask, new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.download.app.g.2
            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                if (callResult.getCode() != -1) {
                    fb.V(g.Z, " pause task is success:" + appDownloadTask.F());
                }
            }
        }, String.class);
    }

    private AppDownloadTask Code(AppInfo appInfo, RemoteAppDownloadTask remoteAppDownloadTask) {
        if (remoteAppDownloadTask == null) {
            return null;
        }
        fb.V(Z, "remote task is exist, create local by remote");
        AppDownloadTask Code = remoteAppDownloadTask.Code(appInfo);
        if (TextUtils.isEmpty(remoteAppDownloadTask.L())) {
            Code.L(B(Code) ? "11" : "5");
        }
        super.Code((g) Code);
        return Code;
    }

    public void V(AppInfo appInfo, com.huawei.openalliance.ad.download.g gVar) {
        if (!V(appInfo)) {
            this.F.V(appInfo.Code(), gVar);
        }
        if (com.huawei.hms.ads.utils.a.Code(appInfo)) {
            b.Code(this.Code).V(appInfo.Q(), gVar);
        }
    }

    public static void Code(Context context) {
        synchronized (B) {
            try {
                if (C == null) {
                    C = new g(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static boolean V(AppInfo appInfo) {
        return appInfo == null || TextUtils.isEmpty(appInfo.Code());
    }

    @Override // com.huawei.openalliance.ad.download.b
    public void Code(final AppDownloadTask appDownloadTask) {
        if (!appDownloadTask.k()) {
            super.Code((g) appDownloadTask);
            c.Code(this.S, appDownloadTask, new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.download.app.g.1
                @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                public void onRemoteCallResult(String str, CallResult<String> callResult) {
                    if (callResult.getCode() == -1) {
                        g.this.V((g) appDownloadTask);
                    }
                }
            }, String.class);
            return;
        }
        AppInfo L = appDownloadTask.L();
        if (L == null || TextUtils.isEmpty(L.j()) || !S(appDownloadTask)) {
            fb.V(Z, "can not open Ag detail");
            Z(appDownloadTask);
        }
    }

    public void Code(AppInfo appInfo, final a aVar) {
        if (V(appInfo)) {
            return;
        }
        final AppDownloadTask Code = Code(appInfo);
        if (Code != null) {
            c.I(this.S, Code, new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.download.app.g.4
                @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                public void onRemoteCallResult(String str, CallResult<String> callResult) {
                    if (callResult.getCode() == 200 && String.valueOf(Boolean.TRUE).equals(callResult.getData())) {
                        g.super.I((g) Code);
                        a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.Code(true);
                        }
                        fb.V(g.Z, " removeTask task is success:" + Code.F());
                    }
                }
            }, String.class);
            return;
        }
        fb.V(Z, " removeTask failed:" + appInfo.Code());
    }

    public void Code(AppInfo appInfo, com.huawei.openalliance.ad.download.g gVar) {
        if (!V(appInfo)) {
            this.F.Code(appInfo.Code(), gVar);
        }
        if (com.huawei.hms.ads.utils.a.Code(appInfo)) {
            b.Code(this.Code).Code(appInfo.Q(), gVar);
        }
    }

    public void Code(AppDownloadListener appDownloadListener) {
        this.F.Code(appDownloadListener);
    }
}
