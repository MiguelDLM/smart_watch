package com.kwad.components.core.e.d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.kwad.components.core.e.c.b;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.sdk.api.KsApkDownloadListener;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.adlog.c;
import com.kwad.sdk.core.diskcache.ApkCacheManager;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.v;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class c implements NetworkMonitor.a, com.kwad.sdk.core.download.c, com.kwad.sdk.core.webview.a {

    @NonNull
    private AdTemplate Lu;
    private boolean Lv;
    private a Lw;
    private DialogInterface.OnShowListener Lx;
    private List<KsAppDownloadListener> Ly;
    private boolean downloadPauseEnable;
    private Handler fS;

    @NonNull
    private AdInfo mAdInfo;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private JSONObject mReportExtData;

    /* loaded from: classes11.dex */
    public interface a {
        boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener);
    }

    public c(@NonNull AdTemplate adTemplate, JSONObject jSONObject, KsAppDownloadListener ksAppDownloadListener) {
        this.fS = new Handler(Looper.getMainLooper());
        this.Ly = new ArrayList();
        this.Lu = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dS(adTemplate);
        this.mReportExtData = jSONObject;
        if (ksAppDownloadListener != null) {
            b(ksAppDownloadListener);
        }
        ou();
        this.downloadPauseEnable = com.kwad.sdk.core.response.b.a.cC(com.kwad.sdk.core.response.b.e.dS(this.Lu));
        ot();
        com.kwad.sdk.a.a.c.Au().aO(this.Lu);
    }

    public static int A(a.C0788a c0788a) {
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(c0788a.getAdTemplate());
        if (dS.downloadSafeInfo.complianceInfo != null) {
            int cV = c0788a.cV();
            if (cV != 2) {
                if (cV != 3) {
                    return dS.downloadSafeInfo.complianceInfo.actionBarType;
                }
                return dS.downloadSafeInfo.complianceInfo.materialJumpType;
            }
            return dS.downloadSafeInfo.complianceInfo.describeBarType;
        }
        return 0;
    }

    private boolean oC() {
        a aVar = this.Lw;
        if (aVar != null) {
            return aVar.handleDownloadDialog(new DialogInterface.OnClickListener() { // from class: com.kwad.components.core.e.d.c.4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (i == -1) {
                        switch (c.this.mAdInfo.status) {
                            case 0:
                            case 1:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                                c.this.oG();
                                return;
                            case 2:
                            case 3:
                            case 10:
                            default:
                                return;
                            case 8:
                            case 9:
                            case 11:
                                c.this.oF();
                                return;
                            case 12:
                                c.this.oD();
                                return;
                        }
                    }
                }
            });
        }
        return false;
    }

    private boolean oE() {
        Context context = ServiceProvider.getContext();
        if (d.a(new a.C0788a(context).ar(this.Lu), 1) == 1) {
            return true;
        }
        boolean ap = al.ap(context, com.kwad.sdk.core.response.b.a.ax(this.mAdInfo));
        if (ap) {
            com.kwad.sdk.core.adlog.c.bJ(this.Lu);
        }
        return ap;
    }

    private void ou() {
        com.kwad.sdk.core.download.b.DO();
        int dJ = com.kwad.sdk.core.download.b.dJ(ow());
        if (dJ != 0) {
            this.mAdInfo.status = dJ;
        }
        oA();
        oz();
    }

    private boolean oy() {
        boolean z = false;
        if (Build.VERSION.SDK_INT < 29) {
            if (this.Lu.mIsFromContent && com.kwad.sdk.core.config.d.Cc()) {
                z = oE();
                if (z) {
                    com.kwad.sdk.core.adlog.c.bK(this.Lu);
                }
            } else if (!this.Lu.mIsFromContent && com.kwad.sdk.core.config.d.CI()) {
                boolean al = com.kwad.components.core.k.b.al(ServiceProvider.getContext());
                com.kwad.sdk.core.e.c.d("ApkDownloadHelper", "handleForceOpenApp enableForceOpen: " + al);
                if (al) {
                    z = oE();
                }
                if (z) {
                    com.kwad.sdk.core.adlog.c.bL(this.Lu);
                }
            }
        }
        return z;
    }

    private void oz() {
        this.fS.post(new az() { // from class: com.kwad.components.core.e.d.c.3
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                ArrayList<KsAppDownloadListener> arrayList = new ArrayList(c.this.Ly.size());
                arrayList.addAll(c.this.Ly);
                for (KsAppDownloadListener ksAppDownloadListener : arrayList) {
                    if (ksAppDownloadListener != null) {
                        c.this.a(ksAppDownloadListener);
                    }
                }
            }
        });
    }

    private boolean t(a.C0788a c0788a) {
        boolean h = com.kwad.sdk.utils.d.h(c0788a.getContext(), this.Lu);
        if (h) {
            com.kwad.sdk.core.adlog.c.k(this.Lu, 0);
        }
        return h;
    }

    private int u(a.C0788a c0788a) {
        Context context = c0788a.getContext();
        if (com.kwad.sdk.utils.d.a(context, com.kwad.sdk.core.response.b.a.cR(this.mAdInfo), this.Lu)) {
            com.kwad.sdk.core.adlog.c.k(this.Lu, 1);
            return 11;
        }
        if (t(c0788a)) {
            return 11;
        }
        if (oC()) {
            return 10;
        }
        if (!ah.isNetworkConnected(context)) {
            v.P(context, w.ck(context));
            return 2;
        }
        if (c0788a.op() && com.kwad.sdk.core.config.d.Cu()) {
            return v(c0788a);
        }
        if (com.kwad.sdk.core.response.b.e.eh(this.Lu) && c0788a.or() != 2) {
            return c(c0788a.getContext(), c0788a.getAdTemplate());
        }
        if (c0788a.ol()) {
            return w(c0788a);
        }
        if (x(c0788a)) {
            return 8;
        }
        return oG();
    }

    private int v(a.C0788a c0788a) {
        Context context = c0788a.getContext();
        AdTemplate adTemplate = c0788a.getAdTemplate();
        int oq = c0788a.oq();
        if (oq != 1) {
            if (oq != 2) {
                return 1;
            }
            if (com.kwad.sdk.core.response.b.b.cZ(adTemplate)) {
                com.kwad.components.core.e.c.b.a(context, new b.a().aq(adTemplate).af(com.kwad.sdk.core.response.b.b.cY(adTemplate)).a(this.Lx).c(this.mOnDismissListener).nT());
                return 8;
            }
            return 8;
        }
        return oG();
    }

    private int w(a.C0788a c0788a) {
        Context context = c0788a.getContext();
        AdTemplate adTemplate = c0788a.getAdTemplate();
        int A = A(c0788a);
        if (A != 1) {
            if (A != 2) {
                if (A == 3) {
                    return 1;
                }
                if (x(c0788a)) {
                    return 8;
                }
                return oG();
            }
            return c(c0788a.getContext(), c0788a.getAdTemplate());
        }
        if (com.kwad.sdk.core.response.b.b.cZ(adTemplate)) {
            com.kwad.components.core.e.c.b.a(context, new b.a().aq(adTemplate).af(com.kwad.sdk.core.response.b.b.cY(adTemplate)).a(this.Lx).c(this.mOnDismissListener).nT());
        }
        return 8;
    }

    private boolean x(a.C0788a c0788a) {
        if (!c0788a.oi() && this.mAdInfo.status != 4 && com.kwad.sdk.core.response.b.b.dc(this.Lu) && y(c0788a)) {
            return com.kwad.components.core.e.c.b.a(c0788a.getContext(), new b.a().aq(this.Lu).af(com.kwad.sdk.core.response.b.b.db(this.Lu)).a(this.Lx).c(this.mOnDismissListener).nT());
        }
        return false;
    }

    private static boolean y(a.C0788a c0788a) {
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(c0788a.getAdTemplate());
        if (com.kwad.sdk.core.response.b.a.bu(dS) && (DownloadLandPageActivity.showingAdWebViewLandPage || AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity || c0788a.getAdTemplate().isWebViewDownload)) {
            return true;
        }
        if (com.kwad.sdk.core.response.b.a.bv(dS) && !ah.isWifiConnected(c0788a.getContext())) {
            return true;
        }
        return false;
    }

    private int z(a.C0788a c0788a) {
        Activity dB = l.dB(c0788a.getContext());
        if (dB != null && com.kwad.sdk.core.response.b.a.T(this.mAdInfo) && !c0788a.nZ() && !c0788a.oe()) {
            c0788a.ak(1);
            com.kwad.components.core.e.e.e.a(dB, c0788a);
            return 18;
        }
        return oD();
    }

    public final void as(int i) {
        this.Lu.downloadSource = i;
    }

    @Override // com.kwad.sdk.core.download.c
    public final void b(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            if (this.mAdInfo.status != 4 && eVar.DS()) {
                com.kwad.sdk.core.adlog.c.a(this.Lu, this.mReportExtData);
                eVar.DR();
                com.kwad.sdk.commercial.a.a.aV(this.Lu);
            }
            this.mAdInfo.status = 4;
            oz();
        }
    }

    public final void clear() {
        oJ();
        com.kwad.sdk.core.download.b.DO().a(this);
        if (com.kwad.sdk.core.config.d.CU()) {
            NetworkMonitor.getInstance().a(this);
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void f(String str, com.kwad.sdk.core.download.e eVar) {
        if (!this.mAdInfo.downloadId.equals(str)) {
            return;
        }
        oA();
        if (eVar.DS()) {
            eVar.DR();
            com.kwad.sdk.commercial.a.a.bb(this.Lu);
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void g(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str) && eVar.DS()) {
            eVar.DR();
            com.kwad.sdk.core.adlog.c.bI(this.Lu);
            com.kwad.sdk.commercial.a.a.aY(this.Lu);
        }
    }

    public final void oA() {
        if (al.an(ServiceProvider.getContext(), this.mAdInfo.adBaseInfo.appPackageName)) {
            this.mAdInfo.status = 12;
            return;
        }
        AdInfo adInfo = this.mAdInfo;
        if (adInfo.status == 12) {
            adInfo.status = 0;
            adInfo.progress = 0;
        }
        int i = adInfo.status;
        if (i == 8 || i == 9) {
            String str = adInfo.downloadFilePath;
            if (TextUtils.isEmpty(str) || !new File(str).exists()) {
                AdInfo adInfo2 = this.mAdInfo;
                adInfo2.status = 0;
                adInfo2.progress = 0;
            }
        }
        AdInfo adInfo3 = this.mAdInfo;
        if (adInfo3.status == 0) {
            String H = com.kwad.sdk.core.download.a.H(adInfo3);
            if (!TextUtils.isEmpty(H) && new File(H).exists()) {
                AdInfo adInfo4 = this.mAdInfo;
                adInfo4.downloadFilePath = H;
                adInfo4.status = 8;
            }
        }
    }

    @NonNull
    public final AdTemplate oB() {
        return this.Lu;
    }

    public final int oD() {
        g.execute(new az() { // from class: com.kwad.components.core.e.d.c.5
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
            }
        });
        if (al.ap(ServiceProvider.getContext(), com.kwad.sdk.core.response.b.a.ax(this.mAdInfo))) {
            com.kwad.sdk.core.adlog.c.bJ(this.Lu);
            return 6;
        }
        return 6;
    }

    public final int oF() {
        al.a(this.mAdInfo.downloadFilePath, new al.a() { // from class: com.kwad.components.core.e.d.c.6
            @Override // com.kwad.sdk.utils.al.a
            public final void d(Throwable th) {
                com.kwad.sdk.commercial.a.a.i(c.this.Lu, 100003, Log.getStackTraceString(th));
            }

            @Override // com.kwad.sdk.utils.al.a
            public final void oK() {
                com.kwad.sdk.core.adlog.c.h(c.this.Lu, 1);
                com.kwad.sdk.commercial.a.a.aZ(c.this.Lu);
            }
        });
        return 7;
    }

    public final int oG() {
        com.kwad.sdk.core.download.a.I(this.mAdInfo);
        return 3;
    }

    public final int oH() {
        com.kwad.sdk.core.download.a.dG(this.mAdInfo.downloadId);
        return 4;
    }

    public final int oI() {
        oG();
        return 5;
    }

    @Override // com.kwad.sdk.core.webview.a
    public final void oJ() {
        List<KsAppDownloadListener> list = this.Ly;
        if (list != null) {
            list.clear();
        }
    }

    public final void ot() {
        com.kwad.sdk.core.download.b.DO().a(this, this.Lu);
        if (com.kwad.sdk.core.config.d.CU()) {
            NetworkMonitor.getInstance().a(ServiceProvider.getContext(), this);
        }
    }

    public final int ov() {
        oA();
        int i = this.mAdInfo.status;
        if (i == 3) {
            return 2;
        }
        return i;
    }

    @Override // com.kwad.sdk.core.download.c
    public final String ow() {
        return this.mAdInfo.downloadId;
    }

    @Override // com.kwad.sdk.core.download.c
    public final String ox() {
        return this.mAdInfo.adBaseInfo.appPackageName;
    }

    public final int q(a.C0788a c0788a) {
        int i = this.mAdInfo.status;
        if (i != 0 && i != 1) {
            switch (i) {
                case 4:
                case 5:
                case 6:
                case 7:
                    break;
                case 8:
                case 9:
                case 10:
                case 11:
                    return oF();
                case 12:
                    return z(c0788a);
                default:
                    return 0;
            }
        }
        if (!t(c0788a)) {
            return 0;
        }
        return 11;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final int r(a.C0788a c0788a) {
        this.Lv = false;
        oA();
        switch (this.mAdInfo.status) {
            case 0:
            case 1:
            case 5:
            case 6:
            case 7:
                return u(c0788a);
            case 2:
            case 3:
                if (c0788a.og() && this.downloadPauseEnable) {
                    return oH();
                }
                return 0;
            case 4:
                return oI();
            case 8:
            case 9:
            case 11:
                return oF();
            case 10:
            default:
                return 0;
            case 12:
                return z(c0788a);
        }
    }

    public final boolean s(a.C0788a c0788a) {
        if (this.mAdInfo.status == 0 && t(c0788a)) {
            return true;
        }
        return false;
    }

    public final void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public final void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        this.Lx = onShowListener;
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 1;
            oz();
            if (eVar.DS()) {
                this.mAdInfo.mStartDownloadTime = SystemClock.elapsedRealtime();
                com.kwad.sdk.core.adlog.c.bH(this.Lu);
                eVar.DR();
                com.kwad.sdk.commercial.a.a.o(this.Lu);
            }
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void c(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            if (this.mAdInfo.status != 2 && eVar.DS()) {
                com.kwad.sdk.core.adlog.c.b(this.Lu, this.mReportExtData);
                eVar.DR();
                com.kwad.sdk.commercial.a.a.aW(this.Lu);
            }
            this.mAdInfo.status = 2;
            oz();
        }
    }

    public final void d(JSONObject jSONObject) {
        this.mReportExtData = jSONObject;
    }

    @Override // com.kwad.sdk.core.download.c
    public final void e(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 9;
            oz();
            if (eVar.DS()) {
                com.kwad.sdk.core.adlog.c.h(this.Lu, 2);
                eVar.DR();
                com.kwad.sdk.commercial.a.a.aZ(this.Lu);
            }
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void d(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            if (this.mAdInfo.status != 5 && eVar.DS()) {
                com.kwad.sdk.core.adlog.c.d(this.Lu, this.mReportExtData);
                eVar.DR();
                com.kwad.sdk.commercial.a.a.aX(this.Lu);
            }
            com.kwad.sdk.a.a.c.Au().aP(this.Lu);
            com.kwad.sdk.a.a.b.Ar().aK(this.Lu);
            this.mAdInfo.status = 5;
            oz();
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void b(String str, String str2, com.kwad.sdk.core.download.e eVar) {
        final boolean z;
        this.mAdInfo.status = 12;
        oz();
        if (eVar.DS()) {
            com.kwad.sdk.core.adlog.c.e(this.Lu, this.mReportExtData);
            eVar.DR();
            com.kwad.sdk.commercial.a.a.ba(this.Lu);
            z = oy();
            com.kwad.sdk.a.a.c.Au().aR(this.Lu);
            com.kwad.sdk.a.a.c.Au().aP(this.Lu);
            com.kwad.sdk.a.a.b.Ar().aK(this.Lu);
            com.kwad.components.core.e.a.e.nE().an(this.Lu);
            com.kwad.sdk.core.a.BK().df(ow());
        } else {
            z = false;
        }
        g.execute(new az() { // from class: com.kwad.components.core.e.d.c.2
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
            }
        });
    }

    public final void c(final KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.Ly.remove(ksAppDownloadListener);
        } else {
            this.fS.post(new az() { // from class: com.kwad.components.core.e.d.c.8
                @Override // com.kwad.sdk.utils.az
                public final void doTask() {
                    c.this.Ly.remove(ksAppDownloadListener);
                }
            });
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, int i, int i2, int i3) {
        if (this.mAdInfo.downloadId.equals(str)) {
            AdInfo adInfo = this.mAdInfo;
            adInfo.status = 3;
            adInfo.progress = i;
            adInfo.soFarBytes = i2;
            adInfo.totalBytes = i3;
            oz();
        }
    }

    private static int c(Context context, AdTemplate adTemplate) {
        if (context == null || adTemplate == null) {
            return 9;
        }
        DownloadLandPageActivity.launch(context, adTemplate, false);
        return 9;
    }

    public final void d(KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        oA();
        a(ksAppDownloadListener);
    }

    public c(@NonNull AdTemplate adTemplate, @NonNull KsAppDownloadListener ksAppDownloadListener) {
        this(adTemplate, null, ksAppDownloadListener);
    }

    public c(@NonNull AdTemplate adTemplate, JSONObject jSONObject) {
        this(adTemplate, jSONObject, null);
    }

    public c(@NonNull AdTemplate adTemplate) {
        this(adTemplate, null, null);
    }

    public c(@NonNull AdTemplate adTemplate, KsAppDownloadListener ksAppDownloadListener, String str, String str2) {
        this(adTemplate, null, null);
        AdInfo adInfo = this.mAdInfo;
        adInfo.adConversionInfo.appDownloadUrl = str;
        adInfo.adBaseInfo.appPackageName = str2;
        adInfo.downloadId = ae.bx(str);
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, String str2, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            AdInfo adInfo = this.mAdInfo;
            adInfo.downloadFilePath = str2;
            adInfo.progress = 100;
            adInfo.status = 8;
            oz();
            if (eVar.DS()) {
                eVar.DR();
                com.kwad.sdk.core.adlog.c.c(this.Lu, this.mReportExtData);
                com.kwad.sdk.commercial.a.a.j(this.Lu, SystemClock.elapsedRealtime() - this.mAdInfo.mStartDownloadTime);
                com.kwad.sdk.core.a.BK().e(str, this.Lu);
                g.execute(new Runnable() { // from class: com.kwad.components.core.e.d.c.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
                    }
                });
                com.kwad.sdk.a.a.c.Au().aQ(this.Lu);
                com.kwad.sdk.a.a.c.Au().aO(this.Lu);
                com.kwad.sdk.a.a.b.Ar().aJ(this.Lu);
                ApkCacheManager.getInstance().DB();
            }
        }
    }

    @UiThread
    public final void b(final KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (!this.Ly.contains(ksAppDownloadListener)) {
                this.Ly.add(0, ksAppDownloadListener);
            }
        } else {
            this.fS.post(new az() { // from class: com.kwad.components.core.e.d.c.7
                @Override // com.kwad.sdk.utils.az
                public final void doTask() {
                    if (!c.this.Ly.contains(ksAppDownloadListener)) {
                        c.this.Ly.add(0, ksAppDownloadListener);
                    }
                }
            });
        }
        oA();
        a(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, int i, String str2, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 7;
            oz();
            if (eVar.DS()) {
                c.a aVar = new c.a(i, str2);
                com.kwad.sdk.core.adlog.c.a(this.Lu, aVar);
                com.kwad.components.core.o.a.qI().a(this.Lu, this.mAdInfo.adConversionInfo.appDownloadUrl, aVar.toJson().toString());
                eVar.DR();
                com.kwad.sdk.commercial.a.a.h(this.Lu, i, str2);
            }
            if (this.mAdInfo.adConversionInfo.retryH5TimeStep <= 0 || this.Lv) {
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            AdInfo adInfo = this.mAdInfo;
            if (elapsedRealtime - adInfo.mStartDownloadTime >= adInfo.adConversionInfo.retryH5TimeStep || TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aR(adInfo))) {
                return;
            }
            AdWebViewActivityProxy.launch(ServiceProvider.getContext(), this.Lu);
            this.Lv = true;
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, Throwable th, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 11;
            oz();
            if (eVar.DS()) {
                eVar.DR();
                com.kwad.sdk.commercial.a.a.i(this.Lu, 100003, Log.getStackTraceString(th));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull KsAppDownloadListener ksAppDownloadListener) {
        AdInfo adInfo = this.mAdInfo;
        int i = adInfo.progress;
        switch (adInfo.status) {
            case 0:
            case 5:
                ksAppDownloadListener.onIdle();
                return;
            case 1:
                ksAppDownloadListener.onProgressUpdate(0);
                if (ksAppDownloadListener instanceof com.kwad.sdk.core.download.a.a) {
                    ((com.kwad.sdk.core.download.a.a) ksAppDownloadListener).onDownloadStarted();
                    return;
                }
                try {
                    ksAppDownloadListener.onDownloadStarted();
                    return;
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                    return;
                }
            case 2:
            case 3:
                ksAppDownloadListener.onProgressUpdate(i);
                return;
            case 4:
                if (ksAppDownloadListener instanceof com.kwad.sdk.core.download.a.a) {
                    ((com.kwad.sdk.core.download.a.a) ksAppDownloadListener).onPaused(i);
                }
                try {
                    if (ksAppDownloadListener instanceof KsApkDownloadListener) {
                        ((KsApkDownloadListener) ksAppDownloadListener).onPaused(i);
                        return;
                    }
                    return;
                } catch (Throwable unused) {
                    return;
                }
            case 6:
            case 10:
            case 11:
            default:
                return;
            case 7:
                ksAppDownloadListener.onDownloadFailed();
                return;
            case 8:
            case 9:
                ksAppDownloadListener.onDownloadFinished();
                return;
            case 12:
                ksAppDownloadListener.onInstalled();
                return;
        }
    }

    public final void a(a aVar) {
        this.Lw = aVar;
    }

    @Override // com.kwad.sdk.core.NetworkMonitor.a
    public final void a(NetworkMonitor.NetworkState networkState) {
        if (this.mAdInfo.status == 7 && networkState == NetworkMonitor.NetworkState.NETWORK_WIFI) {
            oG();
        }
    }
}
