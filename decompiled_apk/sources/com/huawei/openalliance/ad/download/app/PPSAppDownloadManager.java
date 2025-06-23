package com.huawei.openalliance.ad.download.app;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.hms.ads.dl;
import com.huawei.hms.ads.dm;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.jb;
import com.huawei.hms.ads.jc;
import com.huawei.hms.ads.jn;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.constant.ai;
import com.huawei.openalliance.ad.constant.bb;
import com.huawei.openalliance.ad.constant.v;
import com.huawei.openalliance.ad.download.app.AppDownloadTask;
import com.huawei.openalliance.ad.download.app.g;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.inter.data.VideoInfo;
import com.huawei.openalliance.ad.inter.data.s;
import com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.w;
import com.huawei.openalliance.ad.views.PPSNativeView;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@AllApi
/* loaded from: classes10.dex */
public class PPSAppDownloadManager implements IAppDownloadManager {
    private String L;

    /* renamed from: a, reason: collision with root package name */
    private boolean f17386a;
    private final dm B = new dl();
    private Map<String, Pair<String, Long>> C = new HashMap();
    private int S = 2;
    private Integer F = 6;
    private com.huawei.openalliance.ad.download.g b = new com.huawei.openalliance.ad.download.g() { // from class: com.huawei.openalliance.ad.download.app.PPSAppDownloadManager.1
        @Override // com.huawei.openalliance.ad.download.g
        public void Code(AppDownloadTask appDownloadTask) {
        }

        @Override // com.huawei.openalliance.ad.download.g
        public void I(String str) {
        }

        @Override // com.huawei.openalliance.ad.download.g
        public void V(AppDownloadTask appDownloadTask) {
            if (appDownloadTask == null || appDownloadTask.o() != 7) {
                return;
            }
            appDownloadTask.B(0);
            PPSAppDownloadManager.this.Code.I(appDownloadTask);
            PPSAppDownloadManager.this.Code.V(appDownloadTask.L(), this);
        }

        @Override // com.huawei.openalliance.ad.download.g
        public void Code(String str) {
        }

        @Override // com.huawei.openalliance.ad.download.g
        public void V(String str) {
        }

        @Override // com.huawei.openalliance.ad.download.f
        public void Code(String str, int i) {
        }
    };
    g Code = g.I();

    @AllApi
    public PPSAppDownloadManager() {
    }

    private boolean D(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        AppInfo y;
        if (context == null || dVar == null || (y = dVar.y()) == null || !"21".equals(y.T())) {
            return false;
        }
        return new com.huawei.openalliance.ad.uriaction.j(context, dVar.n(), true, dVar instanceof com.huawei.openalliance.ad.inter.data.l ? ((com.huawei.openalliance.ad.inter.data.l) dVar).ar() : null).Code();
    }

    private int L(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        if (b(context, dVar)) {
            fb.V("PPSAppDownloadManager", "do app click action.");
            return 0;
        }
        AppInfo y = dVar.y();
        Code(y);
        AppDownloadTask Code = this.Code.Code(y);
        if (Code == null) {
            AppDownloadTask Code2 = Code(dVar);
            if (Code2 == null) {
                fb.V("PPSAppDownloadManager", "failed when create task");
                return -1;
            }
            if (y != null) {
                Code(y.Code(), y.e());
            }
            Code(dVar, Code2);
            if (!Code()) {
                V(context, null, dVar);
                Code(context, dVar, y, com.huawei.openalliance.ad.utils.b.Code(context));
            }
            this.Code.Code(Code2);
        } else {
            V(dVar, Code);
            Code(dVar, Code);
            this.Code.I(Code);
        }
        return 0;
    }

    private boolean a(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        String str;
        if (dVar == null || dVar.y() == null) {
            str = "param is empty";
        } else {
            AppInfo y = dVar.y();
            if (com.huawei.openalliance.ad.utils.g.Code(context, y.Code()) || !com.huawei.openalliance.ad.utils.g.Code()) {
                String Code = Code(y.Code());
                if (!TextUtils.isEmpty(Code)) {
                    y.V(Code);
                }
                jn.a aVar = new jn.a();
                aVar.Code(y).Code(dVar.n());
                if (com.huawei.openalliance.ad.utils.g.Code(context, y.Code(), y.D(), aVar.Code())) {
                    Code(context, y);
                    jc.Code(context, dVar.n(), "intentSuccess", (Integer) 1, (Integer) null);
                    if (!Code()) {
                        V(context, null, dVar);
                        Code(context, dVar, com.huawei.openalliance.ad.utils.b.Code(context));
                    }
                    return true;
                }
                fb.V("PPSAppDownloadManager", "handleClick, openAppIntent failed");
                jc.Code(context, dVar.n(), ai.D, (Integer) 1, (Integer) 2);
                if (com.huawei.openalliance.ad.utils.g.Code(context, y.Code(), aVar.Code())) {
                    Code(context, y);
                    jc.Code(context, dVar.n(), (Integer) 6);
                    if (!Code()) {
                        V(context, null, dVar);
                        Code(context, dVar, com.huawei.openalliance.ad.utils.b.Code(context));
                    }
                    return true;
                }
                str = "handleClick, openAppMainPage failed";
            } else {
                str = "app not installed, need download";
            }
        }
        fb.V("PPSAppDownloadManager", str);
        return false;
    }

    private boolean b(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        AppInfo y;
        boolean z = dVar instanceof s;
        if (!this.f17386a || !z || (y = dVar.y()) == null || ad.Code(y.E()) || !com.huawei.openalliance.ad.uriaction.d.Code(context, dVar.n(), Code(dVar.n()), y.E()).Code()) {
            return false;
        }
        V(context, null, dVar);
        Code(context, dVar.n(), com.huawei.openalliance.ad.utils.b.Code(context));
        return true;
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager
    public int B(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        if (D(context, dVar)) {
            fb.V("PPSAppDownloadManager", "open landing page action");
            return -4;
        }
        if (V(context, dVar) != null) {
            fb.V("PPSAppDownloadManager", "ad is invalid ad when pause");
            return -1;
        }
        if (!this.B.Code(context, dVar, false)) {
            fb.V("PPSAppDownloadManager", "pauseDownload has not permission, please add white list");
            return -2;
        }
        AppDownloadTask Code = this.Code.Code(dVar.y());
        if (Code == null) {
            return 1;
        }
        V(dVar, Code);
        Code(dVar, Code);
        this.Code.V(Code);
        return 1;
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager
    public void C(final Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        String str;
        if (V(context, dVar) != null) {
            str = "ad is invalid ad when cancel";
        } else {
            if (this.B.Code(context, dVar, false)) {
                final AppInfo y = dVar.y();
                AppDownloadTask Code = this.Code.Code(y);
                if (Code != null) {
                    V(dVar, Code);
                    Code(dVar, Code);
                    this.Code.Code(y, new g.a() { // from class: com.huawei.openalliance.ad.download.app.PPSAppDownloadManager.2
                        @Override // com.huawei.openalliance.ad.download.app.g.a
                        public void Code(boolean z) {
                            if (z && PPSAppDownloadManager.this.F != null) {
                                if (PPSAppDownloadManager.this.F.intValue() == 14 || PPSAppDownloadManager.this.F.intValue() == 10005) {
                                    PPSAppDownloadManager.V(context, y);
                                }
                            }
                        }
                    });
                    return;
                }
                return;
            }
            str = "cancelDownload has not permission, please add white list";
        }
        fb.V("PPSAppDownloadManager", str);
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager
    public int Code(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        if (dVar == null) {
            fb.V("PPSAppDownloadManager", "ad is empty");
            return -1;
        }
        if (!Z(dVar.y())) {
            return -1;
        }
        if (a(context, dVar)) {
            fb.V("PPSAppDownloadManager", "app is installed, open it.");
            return 0;
        }
        if (D(context, dVar)) {
            fb.V("PPSAppDownloadManager", "open landing page action");
            return -4;
        }
        Integer V = V(context, dVar);
        if (V != null) {
            return V.intValue();
        }
        if (this.B.Code(context, dVar, true)) {
            return L(context, dVar);
        }
        fb.V("PPSAppDownloadManager", "download has not permission, please add white list");
        return -2;
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager
    public int F(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        String str;
        if (dVar == null) {
            str = "ad is empty";
        } else if (V(dVar)) {
            AppDownloadTask Code = this.Code.Code(dVar.y());
            if (Code != null) {
                return Code.S();
            }
            str = "task is not exist.";
        } else {
            str = "ad is not native ad";
        }
        fb.V("PPSAppDownloadManager", str);
        return 0;
    }

    public Integer I(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        return (context == null || dVar == null) ? -1 : null;
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager
    public k S(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        AppDownloadTask Code;
        if (dVar == null) {
            return k.DOWNLOAD;
        }
        if (!I(dVar)) {
            fb.V("PPSAppDownloadManager", "this ad is not a native ad");
            return k.DOWNLOAD;
        }
        AppInfo y = dVar.y();
        if (y != null && com.huawei.openalliance.ad.utils.g.Code(context, y.Code())) {
            fb.V("PPSAppDownloadManager", "app installed");
            return k.INSTALLED;
        }
        if (Z(dVar.y()) && (Code = this.Code.Code(y)) != null) {
            Code.C(dVar.a());
            return com.huawei.hms.ads.utils.a.Code(Code);
        }
        return k.DOWNLOAD;
    }

    public Integer V(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        Integer I = I(context, dVar);
        return I != null ? I : !V(dVar) ? -1 : null;
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager
    public int Z(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        if (D(context, dVar)) {
            fb.V("PPSAppDownloadManager", "open landing page action");
            return -4;
        }
        Integer V = V(context, dVar);
        if (V != null) {
            return V.intValue();
        }
        if (!this.B.Code(context, dVar, true)) {
            fb.V("PPSAppDownloadManager", "resumeDownload has not permission, please add white list");
            return -2;
        }
        if (a(context, dVar)) {
            fb.V("PPSAppDownloadManager", "app is installed, open it.");
            return 0;
        }
        if (b(context, dVar)) {
            fb.V("PPSAppDownloadManager", "do app click action.");
            return 0;
        }
        AppDownloadTask Code = this.Code.Code(dVar.y());
        if (Code == null) {
            fb.V("PPSAppDownloadManager", "app download info is empty, must first invoke startDownload method");
            return -1;
        }
        V(dVar, Code);
        Code(dVar, Code);
        this.Code.I(Code);
        return 0;
    }

    private boolean B(AppInfo appInfo) {
        if (appInfo == null) {
            return true;
        }
        return appInfo.S() && TextUtils.isEmpty(appInfo.C());
    }

    private AppDownloadTask Code(com.huawei.openalliance.ad.inter.data.d dVar) {
        AppDownloadTask Code = new AppDownloadTask.a().Code(true).Code(dVar.y()).Code();
        if (Code != null) {
            Code.C(dVar.a());
            Code.Z(dVar.o());
            AdContentData n = dVar.n();
            Code.Code(n);
            if (n != null) {
                Code.B(n.w());
                Code.I(n.D());
                Code.D(n.M());
                Code.b(n.aE());
                Code.C(n.aF());
            }
        }
        return Code;
    }

    private boolean I(AppInfo appInfo) {
        if (appInfo == null) {
            return false;
        }
        String z = appInfo.z();
        return (TextUtils.isEmpty(z) || TextUtils.isEmpty(appInfo.Code()) || !z.equals("6")) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        if (com.huawei.openalliance.ad.utils.ai.Code(this.C)) {
            return;
        }
        fb.Code("PPSAppDownloadManager", "clean invalid uniqueId");
        try {
            Set<Map.Entry<String, Pair<String, Long>>> entrySet = this.C.entrySet();
            if (entrySet == null) {
                return;
            }
            for (Map.Entry<String, Pair<String, Long>> entry : entrySet) {
                if (entry != null && entry.getValue() != null && entry.getValue().second != null && w.Code() - ((Long) entry.getValue().second).longValue() > 86400000) {
                    this.C.remove(entry.getKey());
                }
            }
        } catch (Throwable th) {
            fb.I("PPSAppDownloadManager", "clear uniqueIdMap ex: %s", th.getClass().getSimpleName());
        }
    }

    private boolean Z(AppInfo appInfo) {
        String str;
        if (appInfo == null) {
            str = " download app info is empty";
        } else if (TextUtils.isEmpty(appInfo.Code())) {
            str = "app packageName is empty";
        } else {
            if ("11".equals(appInfo.i())) {
                return true;
            }
            if (!V(appInfo) && !com.huawei.hms.ads.utils.a.Code(appInfo) && (TextUtils.isEmpty(appInfo.Z()) || B(appInfo) || appInfo.B() <= 0)) {
                str = " download app info is invalid";
            } else {
                if (this.Code != null) {
                    return true;
                }
                str = " download manager is not init";
            }
        }
        fb.V("PPSAppDownloadManager", str);
        return false;
    }

    private boolean I(com.huawei.openalliance.ad.inter.data.d dVar) {
        return (dVar instanceof com.huawei.openalliance.ad.inter.data.l) || (dVar instanceof s);
    }

    private void V(Context context, View view, com.huawei.openalliance.ad.inter.data.d dVar) {
        if (view != null && (view instanceof PPSNativeView)) {
            ((PPSNativeView) view).Code((Integer) 6, true);
            return;
        }
        if (dVar != null) {
            String D = dVar instanceof s ? ((s) dVar).n().D() : null;
            if (D == null || !D.equals(this.L)) {
                this.L = D;
                jb.a aVar = new jb.a();
                aVar.V(Long.valueOf(w.Code())).Code(Long.valueOf(dVar.u())).Code(Integer.valueOf(dVar.v())).V((Integer) 6).I(com.huawei.openalliance.ad.utils.b.Code(context));
                jc.Code(context, dVar.n(), aVar.Code());
            }
        }
    }

    private String Code(String str) {
        if (TextUtils.isEmpty(str) || !this.C.containsKey(str) || this.C.get(str) == null) {
            return null;
        }
        return (String) this.C.get(str).first;
    }

    public static void V(Context context, final AppInfo appInfo) {
        if (appInfo == null) {
            fb.V("PPSAppDownloadManager", "appInfo is empty.");
        } else {
            com.huawei.openalliance.ad.utils.h.I(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.PPSAppDownloadManager.5
                @Override // java.lang.Runnable
                public void run() {
                    com.huawei.openalliance.ad.download.a Code = com.huawei.openalliance.ad.download.a.Code();
                    if (Code != null) {
                        Code.V(AppInfo.this);
                    }
                }
            });
        }
    }

    public Map<String, String> Code(AdContentData adContentData) {
        HashMap hashMap = new HashMap();
        if (adContentData != null) {
            MetaData S = adContentData.S();
            hashMap.put(com.huawei.openalliance.ad.uriaction.i.Code, S == null ? "" : S.b());
            hashMap.put(com.huawei.openalliance.ad.uriaction.i.V, S != null ? S.a() : "");
            if (adContentData.t() == null) {
                return hashMap;
            }
            VideoInfo videoInfo = new VideoInfo(adContentData.t());
            hashMap.put(bb.m, adContentData.D());
            int L = videoInfo.L();
            fb.V("PPSAppDownloadManager", "buildLinkedAdConfig, set progress from native view " + L);
            hashMap.put(bb.p, String.valueOf(adContentData.J()));
            hashMap.put(bb.s, adContentData.H() ? "true" : "false");
            hashMap.put(bb.r, videoInfo.a());
            hashMap.put(bb.q, String.valueOf(L));
        }
        return hashMap;
    }

    private void Code(Context context, AdContentData adContentData, String str) {
        if (adContentData != null) {
            jc.Code(context, adContentData, 0, 0, "app", 6, str);
        }
    }

    private void V(com.huawei.openalliance.ad.inter.data.d dVar, AppDownloadTask appDownloadTask) {
        AdContentData n = dVar.n();
        if (n != null) {
            appDownloadTask.I(n.D());
        }
    }

    public static void Code(Context context, final AppInfo appInfo) {
        if (appInfo == null) {
            fb.V("PPSAppDownloadManager", "appInfo is empty.");
        } else {
            com.huawei.openalliance.ad.utils.h.I(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.PPSAppDownloadManager.3
                @Override // java.lang.Runnable
                public void run() {
                    com.huawei.openalliance.ad.download.a Code = com.huawei.openalliance.ad.download.a.Code();
                    if (Code != null) {
                        Code.Code(AppInfo.this.Code());
                    }
                }
            });
            com.huawei.openalliance.ad.utils.h.I(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.PPSAppDownloadManager.4
                @Override // java.lang.Runnable
                public void run() {
                    com.huawei.openalliance.ad.download.a Code = com.huawei.openalliance.ad.download.a.Code();
                    if (Code != null) {
                        Code.Code(AppInfo.this);
                    }
                }
            });
        }
    }

    private boolean V(AppInfo appInfo) {
        if (appInfo == null) {
            return false;
        }
        return appInfo.w();
    }

    private void Code(Context context, com.huawei.openalliance.ad.inter.data.d dVar, AppInfo appInfo, String str) {
        if (dVar == null || dVar.n() == null) {
            return;
        }
        String str2 = I(appInfo) ? v.F : "download";
        if (appInfo != null && "11".equals(appInfo.y())) {
            str2 = "restore";
        }
        com.huawei.openalliance.ad.inter.data.l lVar = (com.huawei.openalliance.ad.inter.data.l) dVar;
        if (lVar.K() == null) {
            jc.Code(context, dVar.n(), 0, 0, str2, 6, str);
        } else {
            fb.V("PPSAppDownloadManager", "fastAppClickInfo is %s ", lVar.K());
            jc.Code(context, dVar.n(), lVar.K(), 0, 0, str2, 6, str);
        }
    }

    private boolean V(com.huawei.openalliance.ad.inter.data.d dVar) {
        return I(dVar) && Z(dVar.y());
    }

    private void Code(Context context, com.huawei.openalliance.ad.inter.data.d dVar, String str) {
        if (dVar == null || dVar.n() == null) {
            return;
        }
        com.huawei.openalliance.ad.inter.data.l lVar = (com.huawei.openalliance.ad.inter.data.l) dVar;
        fb.V("PPSAppDownloadManager", "fastAppClickInfo is %s ", lVar.K());
        jc.Code(context, dVar.n(), lVar.K(), 0, 0, "app", 6, str);
    }

    private void Code(AppInfo appInfo) {
        if (appInfo == null || !"11".equals(appInfo.y())) {
            return;
        }
        this.Code.Code(appInfo, this.b);
    }

    private void Code(com.huawei.openalliance.ad.inter.data.d dVar, AppDownloadTask appDownloadTask) {
        RewardVerifyConfig M = dVar.M();
        if (M != null) {
            appDownloadTask.S(M.getData());
            appDownloadTask.F(M.getUserId());
            AdContentData f = appDownloadTask.f();
            if (f != null) {
                f.q(M.getData());
                f.r(M.getUserId());
            }
        }
        if (dVar.n() != null) {
            AdContentData n = dVar.n();
            if (!TextUtils.isEmpty(n.L())) {
                appDownloadTask.Z(n.L());
            }
            if (!TextUtils.isEmpty(n.aE())) {
                appDownloadTask.b(n.aE());
            }
            if (n.aF() >= 0) {
                appDownloadTask.C(n.aF());
            }
        }
        appDownloadTask.C(dVar.a());
        appDownloadTask.Code(this.F);
        appDownloadTask.V(this.F);
        appDownloadTask.I(Integer.valueOf(this.S));
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager
    public void Code(Integer num) {
        this.F = num;
    }

    private void Code(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        fb.Code("PPSAppDownloadManager", "update uniqueIdMap, pkg: %s, uniqueId: %s", str, str2);
        this.C.put(str, new Pair<>(str2, Long.valueOf(w.Code())));
        com.huawei.openalliance.ad.utils.h.I(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.PPSAppDownloadManager.6
            @Override // java.lang.Runnable
            public void run() {
                PPSAppDownloadManager.this.V();
            }
        });
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager
    public void Code(boolean z) {
        this.f17386a = z;
    }

    private boolean Code() {
        return this.F.intValue() == 14 || this.F.intValue() == 10005;
    }
}
