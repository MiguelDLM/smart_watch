package com.huawei.openalliance.ad.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;
import com.huawei.hms.ads.dj;
import com.huawei.hms.ads.dk;
import com.huawei.hms.ads.dn;
import com.huawei.hms.ads.ev;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.ja;
import com.huawei.hms.ads.jb;
import com.huawei.hms.ads.jc;
import com.huawei.hms.ads.jn;
import com.huawei.hms.ads.kc;
import com.huawei.hms.ads.ki;
import com.huawei.hms.ads.kx;
import com.huawei.hms.ads.nativead.R;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.beans.metadata.TextState;
import com.huawei.openalliance.ad.constant.ai;
import com.huawei.openalliance.ad.constant.v;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.download.app.AppDownloadTask;
import com.huawei.openalliance.ad.download.app.PPSAppDownloadManager;
import com.huawei.openalliance.ad.download.app.g;
import com.huawei.openalliance.ad.download.app.j;
import com.huawei.openalliance.ad.download.app.k;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.ad.inter.data.l;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.am;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.bf;
import com.huawei.openalliance.ad.utils.u;
import com.huawei.openalliance.ad.utils.w;
import com.huawei.openalliance.ad.views.a;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes10.dex */
public class AppDownloadButton extends AppDownBtnContainer implements kc, com.huawei.openalliance.ad.download.g {
    private l C;
    private e D;
    private boolean F;
    private f L;
    private AppInfo S;

    /* renamed from: a, reason: collision with root package name */
    private d f17414a;
    private k b;
    private k c;
    private int d;
    private AdContentData e;
    private boolean f;
    private int g;
    private final int h;
    private List<TextState> i;
    private ki j;
    private final boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private kx o;
    private boolean p;
    private int q;
    private MaterialClickInfo r;
    private boolean s;
    private boolean t;

    /* renamed from: com.huawei.openalliance.ad.views.AppDownloadButton$5, reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[k.values().length];
            Code = iArr;
            try {
                iArr[k.DOWNLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[k.PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Code[k.DOWNLOADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Code[k.INSTALLED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                Code[k.INSTALL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                Code[k.INSTALLING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface a {
    }

    /* loaded from: classes10.dex */
    public static class b implements View.OnClickListener {
        private WeakReference<AppDownloadButton> Code;

        public b(AppDownloadButton appDownloadButton) {
            this.Code = new WeakReference<>(appDownloadButton);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AppDownloadButton appDownloadButton = this.Code.get();
            if (appDownloadButton == null) {
                return;
            }
            fb.V(appDownloadButton.V, "on cancel btn click.");
            appDownloadButton.V();
        }
    }

    /* loaded from: classes10.dex */
    public static class c implements g.a {
        private WeakReference<AppDownloadButton> Code;

        public c(AppDownloadButton appDownloadButton) {
            this.Code = new WeakReference<>(appDownloadButton);
        }

        @Override // com.huawei.openalliance.ad.download.app.g.a
        public void Code(boolean z) {
            final AppDownloadButton appDownloadButton = this.Code.get();
            if (!z || appDownloadButton == null) {
                return;
            }
            fb.V(appDownloadButton.V, "cancelTask success");
            bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.c.1
                @Override // java.lang.Runnable
                public void run() {
                    PPSAppDownloadManager.V(appDownloadButton.getContext(), appDownloadButton.S);
                    if (appDownloadButton.D != null) {
                        appDownloadButton.D.Code(appDownloadButton.S);
                    }
                }
            });
        }
    }

    /* loaded from: classes10.dex */
    public interface d {
        CharSequence Code(CharSequence charSequence, k kVar);
    }

    /* loaded from: classes10.dex */
    public interface e {
        void Code(k kVar);

        void Code(AppInfo appInfo);
    }

    /* loaded from: classes10.dex */
    public interface f {
        boolean Code(AppInfo appInfo, long j);
    }

    public AppDownloadButton(Context context) {
        super(context);
        this.d = -1;
        this.f = true;
        this.g = 1;
        this.h = 2;
        this.k = true;
        this.m = true;
        this.n = false;
        this.p = true;
        this.q = -1;
        this.s = false;
        Code(context, (AttributeSet) null, -1, -1);
    }

    private boolean D() {
        AppInfo appInfo = this.S;
        if (appInfo == null) {
            return false;
        }
        String z = appInfo.z();
        return (TextUtils.isEmpty(z) || TextUtils.isEmpty(this.S.Code()) || !z.equals("6")) ? false : true;
    }

    private boolean F() {
        AppInfo appInfo = this.S;
        return appInfo != null && "11".equals(appInfo.i());
    }

    private boolean L() {
        String str;
        String str2;
        if (e()) {
            str = this.V;
            str2 = "open harmony service";
        } else {
            if (this.b == k.INSTALLED) {
                h();
                return true;
            }
            if (a()) {
                return b();
            }
            if (d()) {
                str = this.V;
                str2 = "open Ag detail";
            } else if (f()) {
                str = this.V;
                str2 = "open Ag mini detail";
            } else {
                if (!g()) {
                    return false;
                }
                str = this.V;
                str2 = "open Gp detail";
            }
        }
        fb.V(str, str2);
        return true;
    }

    private boolean a() {
        AppInfo appInfo;
        if (this.g != 1 || (appInfo = this.S) == null) {
            return false;
        }
        return "21".equalsIgnoreCase(appInfo.T());
    }

    private boolean b() {
        if (this.e == null) {
            return false;
        }
        l lVar = this.C;
        boolean Code = new com.huawei.openalliance.ad.uriaction.j(getContext(), this.e, true, lVar != null ? lVar.ar() : null).Code();
        if (Code) {
            fb.V(this.V, "list page btn openLandingPage");
            V("web", this.g);
        }
        return Code;
    }

    private boolean c() {
        if (this.S == null) {
            l();
            fb.V(this.V, "appInfo is empty");
            return false;
        }
        if (this.b == k.INSTALLED || F() || this.S.w()) {
            return true;
        }
        String z = this.S.z();
        if (!TextUtils.isEmpty(z)) {
            if (z.equals("7") && !TextUtils.isEmpty(this.S.j())) {
                return true;
            }
            if (z.equals("9") && !TextUtils.isEmpty(this.S.Code()) && !TextUtils.isEmpty(this.S.A())) {
                return true;
            }
        }
        if (!TextUtils.isEmpty(this.S.Z())) {
            return true;
        }
        l();
        return false;
    }

    private boolean d() {
        String z = this.S.z();
        if (TextUtils.isEmpty(z) || TextUtils.isEmpty(this.S.j()) || !z.equals("7")) {
            return false;
        }
        if (!new com.huawei.openalliance.ad.uriaction.b(getContext(), this.e).Code()) {
            l();
            return false;
        }
        V(v.Code, this.g);
        n();
        return true;
    }

    private boolean e() {
        if (!"9".equals(this.S.z()) || TextUtils.isEmpty(this.S.Code()) || TextUtils.isEmpty(this.S.A())) {
            return false;
        }
        com.huawei.openalliance.ad.uriaction.h hVar = new com.huawei.openalliance.ad.uriaction.h(getContext(), this.e);
        if (!hVar.Code()) {
            l();
            return false;
        }
        V(hVar.I(), this.g);
        n();
        return true;
    }

    private boolean f() {
        String z = this.S.z();
        if (TextUtils.isEmpty(z) || TextUtils.isEmpty(this.S.Code()) || !z.equals("6")) {
            return false;
        }
        com.huawei.openalliance.ad.uriaction.l lVar = new com.huawei.openalliance.ad.uriaction.l(getContext(), this.e);
        lVar.Code(this.g);
        lVar.Code();
        V(v.F, this.g);
        n();
        return true;
    }

    private boolean g() {
        List<Integer> E;
        if (this.S != null && w.B(getContext()) && (E = this.S.E()) != null && E.contains(14)) {
            ev.Code(getContext()).Code();
            if (com.huawei.openalliance.ad.uriaction.d.Code(getContext(), this.e, this.C.ar(), E).Code()) {
                V("web", this.g);
                n();
                return true;
            }
            l();
        }
        return false;
    }

    private String getAdTag() {
        ki kiVar = this.j;
        if (kiVar != null) {
            return kiVar.getAdTag();
        }
        return null;
    }

    private long getLeftSize() {
        if (this.S == null) {
            return 0L;
        }
        AppDownloadTask task = getTask();
        long B = this.S.B();
        if (task == null) {
            return B;
        }
        long B2 = this.S.B() - task.Z();
        return B2 <= 0 ? B : B2;
    }

    private AppDownloadTask getTask() {
        AdContentData adContentData;
        AppDownloadTask Code = com.huawei.openalliance.ad.download.app.g.I().Code(this.S);
        if (Code != null && (adContentData = this.e) != null) {
            Code.Z(adContentData.L());
            Code.B(this.e.w());
            Code.C(this.e.a());
            Code.I(this.e.D());
            Code.S(this.e.at());
            Code.F(this.e.au());
            Code.D(this.e.M());
            Code.C(this.e.aF());
            Code.b(this.e.aE());
        }
        return Code;
    }

    private void h() {
        AppDownloadTask task;
        fb.Code(this.V, "doClickAction, status:" + this.b);
        int i = AnonymousClass5.Code[this.b.ordinal()];
        if (i == 1) {
            if (!com.huawei.openalliance.ad.utils.g.Code() && o()) {
                fb.V(this.V, "not allowed");
                return;
            } else {
                Code(true);
                V(F() ? "restore" : "download", this.g);
                return;
            }
        }
        if (i == 2) {
            Code(false);
            return;
        }
        if (i == 3) {
            com.huawei.openalliance.ad.download.app.g.I().V(getTask());
            return;
        }
        if (i == 4) {
            i();
        } else if (i == 5 && (task = getTask()) != null) {
            Z(task);
        }
    }

    private void i() {
        if (!k() || this.q == 1) {
            o();
        } else {
            j();
            bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.7
                @Override // java.lang.Runnable
                public void run() {
                    AppDownloadButton.this.o();
                }
            }, 600L);
        }
    }

    private void j() {
        Context context = getContext();
        AppDownloadTask s = s();
        if (context == null || s == null) {
            return;
        }
        com.huawei.openalliance.ad.download.app.b.Code(context).Code(s);
    }

    private boolean k() {
        return ja.b(this.e.v()) && com.huawei.hms.ads.utils.a.Code(this.S);
    }

    private void l() {
        kx kxVar = this.o;
        if (kxVar != null) {
            kxVar.Code(this);
        }
    }

    private void m() {
        kx kxVar = this.o;
        if (kxVar != null) {
            kxVar.V(this);
        }
    }

    private void n() {
        kx kxVar = this.o;
        if (kxVar != null) {
            kxVar.I(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o() {
        if (this.e == null) {
            return false;
        }
        Context context = getContext();
        String Code = this.S.Code();
        boolean V = u.Code(context, Code) ? V(context) : false;
        return !V ? Code(context, Code) : V;
    }

    private void p() {
        ki kiVar = this.j;
        if (kiVar != null) {
            kiVar.Code(2, true);
        }
    }

    private void q() {
        ki kiVar = this.j;
        if (kiVar != null) {
            kiVar.D();
        }
    }

    private boolean r() {
        AppInfo appInfo = this.S;
        return appInfo != null && appInfo.w() && com.huawei.openalliance.ad.utils.g.I(getContext(), x.Y) >= 100300300;
    }

    private AppDownloadTask s() {
        AppDownloadTask Code = new AppDownloadTask.a().Code(this.F).Code(this.S).Code();
        if (Code == null) {
            return null;
        }
        Code.Code(Integer.valueOf(this.g));
        Code.I((Integer) 2);
        Code.Code(this.e);
        AdContentData adContentData = this.e;
        if (adContentData != null) {
            Code.B(adContentData.w());
            Code.Z(this.e.L());
            Code.C(this.e.a());
            Code.I(this.e.D());
            Code.S(this.e.at());
            Code.F(this.e.au());
            Code.D(this.e.M());
            Code.b(this.e.aE());
            Code.C(this.e.aF());
        }
        return Code;
    }

    public k I() {
        k kVar = k.DOWNLOAD;
        AppInfo appInfo = this.S;
        AppDownloadTask appDownloadTask = null;
        if (appInfo == null) {
            this.c = this.b;
            this.b = kVar;
        } else {
            String Code = appInfo.Code();
            if (com.huawei.openalliance.ad.utils.g.V(getContext(), this.S.Code()) != null) {
                kVar = k.INSTALLED;
            } else {
                appDownloadTask = getTask();
                if (appDownloadTask != null) {
                    kVar = Code(appDownloadTask, Code, false);
                }
            }
            this.c = this.b;
            this.b = kVar;
            I(appDownloadTask);
            appDownloadTask = Code;
        }
        fb.Code(this.V, "refreshStatus, status:%s, pkg:%s", this.b, appDownloadTask);
        return this.b;
    }

    public void S() {
        if (fb.Code()) {
            fb.Code(this.V, "downloadApp, status:%s", this.b);
        }
        k kVar = this.b;
        if ((kVar == k.DOWNLOAD || kVar == k.PAUSE) && this.S != null) {
            AppDownloadTask task = getTask();
            if (task == null) {
                com.huawei.openalliance.ad.download.app.g.I().Code(s());
                return;
            }
            task.Code(Integer.valueOf(this.g));
            task.I((Integer) 2);
            task.Code(this.F);
            com.huawei.openalliance.ad.download.app.g.I().I(task);
        }
    }

    public void cancel() {
        Code((g.a) null);
    }

    public void continueDownload() {
        if (!c()) {
            fb.V(this.V, "click action invalid.");
            return;
        }
        m();
        if (L()) {
            return;
        }
        S();
    }

    public AppInfo getAppInfo() {
        return this.S;
    }

    public kx getClickActionListener() {
        return this.o;
    }

    @Override // com.huawei.openalliance.ad.views.AppDownBtnContainer
    public k getStatus() {
        return this.b;
    }

    public com.huawei.openalliance.ad.views.a getStyle() {
        return this.I;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            if (fb.Code()) {
                String str = this.V;
                AppInfo appInfo = this.S;
                fb.Code(str, "attach, pkg:%s", appInfo == null ? null : appInfo.Code());
            } else {
                fb.V(this.V, "attach appinfo is " + ay.V(this.S));
            }
            com.huawei.openalliance.ad.download.app.g.I().Code(this.S, this);
            bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.1
                @Override // java.lang.Runnable
                public void run() {
                    AppDownloadButton.this.I();
                }
            });
        } catch (RuntimeException | Exception unused) {
            fb.I(this.V, "attach ex");
        }
    }

    @Override // com.huawei.openalliance.ad.views.AppDownBtnContainer, android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        fb.V(this.V, "onClick");
        if (Code()) {
            str = this.V;
            str2 = "fast click";
        } else {
            if (c()) {
                m();
                if (L()) {
                    return;
                }
                h();
                return;
            }
            str = this.V;
            str2 = "click action invalid.";
        }
        fb.V(str, str2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            if (fb.Code()) {
                String str = this.V;
                AppInfo appInfo = this.S;
                fb.Code(str, "detach, pkg:%s", appInfo == null ? null : appInfo.Code());
            } else {
                fb.V(this.V, "detach appinfo is " + ay.V(this.S));
            }
            com.huawei.openalliance.ad.download.app.g.I().V(this.S, this);
            ev.Code(getContext()).V();
        } catch (RuntimeException | Exception unused) {
            fb.I(this.V, "detach ex");
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        fb.V(this.V, "onVisibilityChanged, status:" + this.b);
        super.onVisibilityChanged(view, i);
        this.t = i == 0;
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.6
            @Override // java.lang.Runnable
            public void run() {
                AppDownloadButton.this.I();
            }
        });
    }

    public void setAfDlBtnText(String str) {
        if (this.S == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.S.S(str);
    }

    public void setAllowedNonWifiNetwork(boolean z) {
        this.F = z;
    }

    public void setAppDownloadButtonStyle(com.huawei.openalliance.ad.views.a aVar) {
        this.I = aVar;
    }

    public void setAppInfo(AppInfo appInfo) {
        fb.V(this.V, "setAppInfo appInfo is " + ay.V(appInfo));
        this.S = appInfo;
        if (appInfo != null) {
            com.huawei.openalliance.ad.download.app.g.I().Code(appInfo, this);
        }
    }

    public void setBfDlBtnTxt(String str) {
        AppInfo appInfo = this.S;
        if (appInfo != null) {
            appInfo.C(str);
        }
    }

    @Deprecated
    public void setButtonTextWatcher(a aVar) {
    }

    public void setButtonTextWatcherInner(d dVar) {
        this.f17414a = dVar;
    }

    @Override // com.huawei.hms.ads.kc
    public void setClickActionListener(kx kxVar) {
        this.o = kxVar;
    }

    public void setIsSetProgressDrawable(boolean z) {
        this.p = z;
    }

    public void setNeedAppendProgress(boolean z) {
        this.s = z;
    }

    public void setNeedShowConfirmDialog(boolean z) {
        this.m = z;
    }

    public void setOnDownloadStatusChangedListener(e eVar) {
        this.D = eVar;
    }

    public void setOnNonWifiDownloadListener(f fVar) {
        this.L = fVar;
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        super.Code(i, i2, i3, i4);
    }

    @Override // android.view.View
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
        super.V(i, i2, i3, i4);
    }

    @Override // com.huawei.hms.ads.kc
    public void setPpsNativeView(ki kiVar) {
        this.j = kiVar;
    }

    public void setRemoteAfDlBtnText(String str) {
        AppInfo appInfo = this.S;
        if (appInfo != null) {
            appInfo.D(str);
        }
    }

    public void setRemoteBfDlBtnTxt(String str) {
        AppInfo appInfo = this.S;
        if (appInfo != null) {
            appInfo.F(str);
        }
    }

    public void setShowPermissionDialog(boolean z) {
        this.f = z;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        super.setVisibilityInner(i);
    }

    public AppDownloadButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = -1;
        this.f = true;
        this.g = 1;
        this.h = 2;
        this.k = true;
        this.m = true;
        this.n = false;
        this.p = true;
        this.q = -1;
        this.s = false;
        Code(context, attributeSet, -1, -1);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004c, code lost:
    
        if (r6 > 0) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0063, code lost:
    
        if (r6 <= 0) goto L4;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0018. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.huawei.openalliance.ad.download.app.k Code(com.huawei.openalliance.ad.download.app.AppDownloadTask r6, java.lang.String r7, boolean r8) {
        /*
            r5 = this;
            int r0 = r6.B()
            java.lang.String r1 = r5.V
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = 0
            r3[r4] = r2
            r2 = 1
            r3[r2] = r7
            java.lang.String r7 = "refreshStatus, dwnStatus:%s, pkg:%s"
            com.huawei.hms.ads.fb.Code(r1, r7, r3)
            switch(r0) {
                case 0: goto L57;
                case 1: goto L54;
                case 2: goto L54;
                case 3: goto L51;
                case 4: goto L46;
                case 5: goto L3d;
                case 6: goto L1e;
                default: goto L1b;
            }
        L1b:
            com.huawei.openalliance.ad.download.app.k r6 = com.huawei.openalliance.ad.download.app.k.DOWNLOAD
            goto L66
        L1e:
            if (r8 != 0) goto L3a
            com.huawei.openalliance.ad.download.app.k r7 = com.huawei.openalliance.ad.download.app.k.DOWNLOAD
            java.lang.String r0 = r5.V
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            java.lang.Object[] r1 = new java.lang.Object[r2]
            r1[r4] = r8
            java.lang.String r8 = " hasInstalled=%s"
            com.huawei.hms.ads.fb.Code(r0, r8, r1)
            com.huawei.openalliance.ad.download.app.g r8 = com.huawei.openalliance.ad.download.app.g.I()
            r8.I(r6)
        L38:
            r6 = r7
            goto L66
        L3a:
            com.huawei.openalliance.ad.download.app.k r6 = com.huawei.openalliance.ad.download.app.k.INSTALLED
            goto L66
        L3d:
            com.huawei.openalliance.ad.download.app.k r7 = com.huawei.openalliance.ad.download.app.k.INSTALLING
        L3f:
            int r6 = r6.S()
            r5.d = r6
            goto L38
        L46:
            int r6 = r6.S()
            r5.d = r6
            if (r6 <= 0) goto L1b
        L4e:
            com.huawei.openalliance.ad.download.app.k r6 = com.huawei.openalliance.ad.download.app.k.PAUSE
            goto L66
        L51:
            com.huawei.openalliance.ad.download.app.k r6 = com.huawei.openalliance.ad.download.app.k.INSTALL
            goto L66
        L54:
            com.huawei.openalliance.ad.download.app.k r7 = com.huawei.openalliance.ad.download.app.k.DOWNLOADING
            goto L3f
        L57:
            int r7 = r6.D()
            int r6 = r6.S()
            r5.d = r6
            if (r7 != 0) goto L4e
            if (r6 <= 0) goto L1b
            goto L4e
        L66:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.views.AppDownloadButton.Code(com.huawei.openalliance.ad.download.app.AppDownloadTask, java.lang.String, boolean):com.huawei.openalliance.ad.download.app.k");
    }

    public void B() {
        Context context = getContext();
        boolean z = this.l && this.m;
        if (!(context instanceof Activity) || getStatus() != k.DOWNLOAD || !z) {
            S();
            return;
        }
        dk dkVar = new dk(context);
        dkVar.Code(new dj.a() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.10
            @Override // com.huawei.hms.ads.dj.a
            public void Code(AppInfo appInfo) {
                AppDownloadButton.this.setNeedShowConfirmDialog(false);
                AppDownloadButton.this.S();
            }

            @Override // com.huawei.hms.ads.dj.a
            public void V(AppInfo appInfo) {
            }
        });
        this.n = true;
        dkVar.Code(this.S, this.e, getLeftSize());
    }

    public void V() {
        Code(new c(this));
    }

    public void Z() {
        fb.Code(this.V, "downloadInMobileData");
        if (r()) {
            B();
            return;
        }
        fb.Code(this.V, "not useAgMobileDataTipsDialog");
        dn dnVar = new dn(getContext());
        dnVar.Code(new dj.a() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.9
            @Override // com.huawei.hms.ads.dj.a
            public void Code(AppInfo appInfo) {
                AppDownloadButton.this.setAllowedNonWifiNetwork(true);
                AppDownloadButton.this.setNeedShowConfirmDialog(false);
                AppDownloadButton.this.B();
            }

            @Override // com.huawei.hms.ads.dj.a
            public void V(AppInfo appInfo) {
            }
        });
        dnVar.Code(this.S, this.e, getLeftSize());
    }

    public AppDownloadButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = -1;
        this.f = true;
        this.g = 1;
        this.h = 2;
        this.k = true;
        this.m = true;
        this.n = false;
        this.p = true;
        this.q = -1;
        this.s = false;
        Code(context, attributeSet, i, -1);
    }

    private void I(AppDownloadTask appDownloadTask) {
        int i;
        k kVar;
        if (fb.Code()) {
            String str = this.V;
            k kVar2 = this.b;
            k kVar3 = this.c;
            AppInfo appInfo = this.S;
            fb.Code(str, "processStatus, status:%s, preStatus:%s, packageName:%s", kVar2, kVar3, appInfo == null ? null : appInfo.Code());
        }
        if (D() && this.b != k.INSTALLED) {
            Code(k.DOWNLOAD);
            return;
        }
        Context context = getContext();
        a.C0672a Code = this.I.Code(getContext(), this.b);
        setTextColor(Code.V);
        if (this.p) {
            int i2 = this.d;
            Drawable drawable = Code.Code;
            if (i2 != -1) {
                Code(drawable, i2);
            } else {
                setProgressDrawable(drawable);
            }
        }
        V(this.b);
        switch (AnonymousClass5.Code[this.b.ordinal()]) {
            case 1:
                Code(context, this.g, k.DOWNLOAD);
                return;
            case 2:
                i = this.g;
                kVar = k.PAUSE;
                break;
            case 3:
                i = this.g;
                kVar = k.DOWNLOADING;
                break;
            case 4:
                Code(context);
                return;
            case 5:
                Code(appDownloadTask, context);
                return;
            case 6:
                V(appDownloadTask, context);
                return;
            default:
                return;
        }
        Code(context, i, kVar);
        setProgress(this.d);
    }

    private void Z(AppDownloadTask appDownloadTask) {
        if (this.S == null || this.e == null) {
            fb.I(this.V, "installApk, appinfo or content record is null");
        } else {
            com.huawei.openalliance.ad.download.app.g.I().Code(appDownloadTask);
        }
    }

    @Override // com.huawei.openalliance.ad.download.g
    public void V(AppDownloadTask appDownloadTask) {
        String str = this.V;
        StringBuilder sb = new StringBuilder();
        sb.append("onStatusChanged, taskId:");
        sb.append(appDownloadTask.F());
        sb.append(", packageName");
        AppInfo appInfo = this.S;
        sb.append(appInfo == null ? null : appInfo.Code());
        sb.append(", status:");
        sb.append(appDownloadTask.B());
        fb.V(str, sb.toString());
        AppInfo appInfo2 = this.S;
        if (appInfo2 == null || !appInfo2.Code().equals(appDownloadTask.F())) {
            return;
        }
        if (appDownloadTask.o() != 7) {
            bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.12
                @Override // java.lang.Runnable
                public void run() {
                    AppDownloadButton.this.I();
                    if (AppDownloadButton.this.D != null) {
                        AppDownloadButton.this.D.Code(AppDownloadButton.this.b);
                    }
                }
            });
            return;
        }
        if (!this.t) {
            fb.Code(this.V, "not visible");
        } else {
            if (appDownloadTask.B() != 4) {
                return;
            }
            appDownloadTask.Code(1);
            bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.11
                @Override // java.lang.Runnable
                public void run() {
                    fb.Code(AppDownloadButton.this.V, "start next install way");
                    AppDownloadButton.this.b = k.DOWNLOAD;
                    AppDownloadButton.this.setNeedShowConfirmDialog(false);
                    AppDownloadButton.this.Code(false);
                }
            });
        }
    }

    public AppDownloadButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.d = -1;
        this.f = true;
        this.g = 1;
        this.h = 2;
        this.k = true;
        this.m = true;
        this.n = false;
        this.p = true;
        this.q = -1;
        this.s = false;
        Code(context, attributeSet, i, i2);
    }

    private String Code(int i, k kVar) {
        String str = null;
        if (F() || ad.Code(this.i)) {
            return null;
        }
        int i2 = 1 == i ? 2 : 1;
        int Code = TextState.Code(kVar);
        String V = com.huawei.openalliance.ad.utils.d.V();
        Iterator<TextState> it = this.i.iterator();
        String str2 = null;
        String str3 = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TextState next = it.next();
            if (next != null && i2 == next.Code()) {
                if (Code == next.V()) {
                    if (V.equalsIgnoreCase(new Locale(next.I()).getLanguage())) {
                        str = next.Z();
                        break;
                    }
                    if (1 == next.B()) {
                        str2 = next.Z();
                    }
                }
                if (next.V() == 0) {
                    str3 = next.Z();
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            str2 = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            str3 = str2;
        }
        return ay.V(str3);
    }

    private void V(AppDownloadTask appDownloadTask, Context context) {
        if (appDownloadTask != null) {
            Code(context, this.g, k.INSTALLING);
        }
    }

    @Override // com.huawei.openalliance.ad.download.g
    public void I(String str) {
        V(str);
    }

    @Override // com.huawei.hms.ads.kc
    public void Z(String str) {
        AdContentData adContentData = this.e;
        if (adContentData != null) {
            adContentData.I(str);
        }
    }

    public AppDownloadButton(Context context, Boolean bool) {
        super(context, bool);
        this.d = -1;
        this.f = true;
        this.g = 1;
        this.h = 2;
        this.k = true;
        this.m = true;
        this.n = false;
        this.p = true;
        this.q = -1;
        this.s = false;
        Code(context, (AttributeSet) null, -1, -1);
    }

    private String Code(Context context, k kVar) {
        int i;
        if (context == null || kVar == null) {
            return "";
        }
        switch (AnonymousClass5.Code[kVar.ordinal()]) {
            case 1:
                return com.huawei.hms.ads.utils.a.Code(context, this.S);
            case 2:
                i = R.string.hiad_download_resume;
                break;
            case 3:
                return NumberFormat.getPercentInstance().format((this.d * 1.0f) / 100.0f);
            case 4:
                return com.huawei.hms.ads.utils.a.Code(context, this.S, this.q);
            case 5:
                i = R.string.hiad_download_install;
                break;
            case 6:
                i = R.string.hiad_download_installing;
                break;
            default:
                return null;
        }
        return context.getString(i);
    }

    @Override // com.huawei.openalliance.ad.download.g
    public void V(String str) {
        AppInfo appInfo = this.S;
        if (appInfo == null || str == null || !str.equals(appInfo.Code())) {
            return;
        }
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.3
            @Override // java.lang.Runnable
            public void run() {
                AppDownloadButton.this.I();
                if (AppDownloadButton.this.D != null) {
                    AppDownloadButton.this.D.Code(AppDownloadButton.this.b);
                }
            }
        });
    }

    @Override // com.huawei.hms.ads.kc
    public void Code(long j) {
        AdContentData adContentData = this.e;
        if (adContentData != null) {
            adContentData.Z(j);
        }
    }

    public void V(String str, int i) {
        if (this.e != null) {
            p();
            if (i == 1 || this.e.Z() == 7 || this.e.Z() == 12) {
                jb jbVar = new jb();
                jbVar.B(getAdTag());
                jc.Code(getContext(), this.e, 0, 0, str, i, this.r, com.huawei.openalliance.ad.utils.b.Code(getContext()), bc.V((View) this), jbVar);
                this.r = null;
                q();
            }
        }
    }

    private void Code(Context context) {
        Code(context, this.g, k.INSTALLED);
    }

    private boolean V(Context context) {
        boolean Code = new com.huawei.openalliance.ad.uriaction.g(context, this.e).Code();
        if (Code) {
            PPSAppDownloadManager.Code(context, this.S);
            p();
            jb jbVar = new jb();
            jbVar.B(getAdTag());
            jc.Code(context, this.e, 0, 0, v.Z, this.g, this.r, com.huawei.openalliance.ad.utils.b.Code(getContext()), bc.V((View) this), jbVar);
            this.r = null;
            q();
        }
        return Code;
    }

    private void Code(Context context, int i, k kVar) {
        String Code = Code(i, kVar);
        if (TextUtils.isEmpty(Code)) {
            Code((CharSequence) Code(context, kVar), true, kVar);
            return;
        }
        if (this.s && i == 1 && kVar == k.DOWNLOADING) {
            Code = Code + NumberFormat.getPercentInstance().format((this.d * 1.0f) / 100.0f);
        }
        Code((CharSequence) Code, false, kVar);
    }

    public void Code(Context context, AttributeSet attributeSet, int i, int i2) {
        this.I = new com.huawei.openalliance.ad.views.a(context);
        super.setPadding(0, 0, 0, 0);
        setOnClickListener(this);
        setCancelBtnClickListener(new b(this));
    }

    @Override // com.huawei.openalliance.ad.download.g
    public void Code(AppDownloadTask appDownloadTask) {
        AppInfo appInfo = this.S;
        if (appInfo == null || !appInfo.Code().equals(appDownloadTask.F())) {
            return;
        }
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.2
            @Override // java.lang.Runnable
            public void run() {
                AppDownloadButton.this.I();
                if (AppDownloadButton.this.D == null || AppDownloadButton.this.c == AppDownloadButton.this.b) {
                    return;
                }
                AppDownloadButton.this.D.Code(AppDownloadButton.this.b);
            }
        });
    }

    private void Code(AppDownloadTask appDownloadTask, Context context) {
        if (appDownloadTask != null) {
            Code(context, this.g, k.INSTALL);
        }
    }

    private void Code(g.a aVar) {
        com.huawei.openalliance.ad.download.app.g.I().Code(this.S, aVar);
        I();
        setOnNonWifiDownloadListener(null);
        setNeedShowConfirmDialog(true);
    }

    private void Code(k kVar) {
        a.C0672a Code = this.I.Code(getContext(), kVar);
        setTextColor(Code.V);
        setProgressDrawable(Code.Code);
        Code(getContext(), this.g, kVar);
    }

    public void Code(MaterialClickInfo materialClickInfo) {
        this.r = materialClickInfo;
    }

    public void Code(CharSequence charSequence, boolean z, k kVar) {
        d dVar = this.f17414a;
        if (dVar != null && z) {
            charSequence = dVar.Code(charSequence, kVar);
        }
        super.setText(charSequence);
    }

    @Override // com.huawei.openalliance.ad.download.g
    public void Code(String str) {
        if (fb.Code()) {
            String str2 = this.V;
            AppInfo appInfo = this.S;
            fb.Code(str2, "onStatusChanged, packageName:%s, packageName %s", str, appInfo == null ? null : appInfo.Code());
        }
        AppInfo appInfo2 = this.S;
        if (appInfo2 == null || !appInfo2.Code().equals(str)) {
            return;
        }
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.13
            @Override // java.lang.Runnable
            public void run() {
                AppDownloadButton.this.I();
                if (AppDownloadButton.this.D == null || AppDownloadButton.this.c == AppDownloadButton.this.b) {
                    return;
                }
                AppDownloadButton.this.D.Code(AppDownloadButton.this.b);
            }
        });
    }

    @Override // com.huawei.openalliance.ad.download.f
    public void Code(String str, final int i) {
        if (fb.Code()) {
            fb.Code(this.V, "status %s, packageName:%s", Integer.valueOf(i), str);
        }
        if (com.huawei.hms.ads.utils.a.Code(this.S)) {
            bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.4
                @Override // java.lang.Runnable
                public void run() {
                    AppDownloadButton.this.q = i;
                    AppDownloadButton.this.I();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(boolean z) {
        fb.V(this.V, "processDownload, needShowPermissionDialog = %s", Boolean.valueOf(z));
        if (!am.Z(getContext())) {
            Toast.makeText(getContext(), R.string.hiad_network_no_available, 0).show();
            return;
        }
        if (this.S.v() && this.f && z) {
            com.huawei.openalliance.ad.download.app.j.Code(getContext(), this.S, new j.a() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.8
                @Override // com.huawei.openalliance.ad.download.app.j.a
                public void Code() {
                    AppDownloadButton.this.setNeedShowConfirmDialog(false);
                    AppDownloadButton.this.Code(false);
                }
            });
            return;
        }
        if (!F() && !am.I(getContext())) {
            long leftSize = getLeftSize();
            f fVar = this.L;
            if (fVar == null) {
                Z();
                return;
            } else if (!fVar.Code(this.S, leftSize)) {
                return;
            }
        }
        B();
    }

    private boolean Code(Context context, String str) {
        jn.a aVar = new jn.a();
        aVar.Code(this.S).Code(this.e).I(str);
        boolean Code = com.huawei.openalliance.ad.utils.g.Code(context, str, this.S.D(), aVar.Code());
        jb jbVar = new jb();
        jbVar.B(getAdTag());
        if (Code) {
            PPSAppDownloadManager.Code(context, this.S);
            p();
            jc.Code(context, this.e, "intentSuccess", (Integer) 1, (Integer) null);
            jc.Code(context, this.e, 0, 0, "app", this.g, this.r, com.huawei.openalliance.ad.utils.b.Code(getContext()), bc.V((View) this), jbVar);
        } else {
            fb.V(this.V, "handClick, openAppIntent fail");
            jc.Code(getContext(), this.e, ai.D, (Integer) 1, Integer.valueOf(com.huawei.openalliance.ad.utils.g.Code(context, str) ? 2 : 1));
            Code = com.huawei.openalliance.ad.utils.g.Code(context, str, aVar.Code());
            if (!Code) {
                fb.V(this.V, "handClick, openAppMainPage fail");
                return Code;
            }
            p();
            jc.Code(context, this.C.n(), (Integer) 1);
            PPSAppDownloadManager.Code(context, this.S);
            jc.Code(context, this.e, 0, 0, "app", this.g, this.r, com.huawei.openalliance.ad.utils.b.Code(getContext()), bc.V((View) this), jbVar);
        }
        this.r = null;
        q();
        return Code;
    }

    @Override // com.huawei.hms.ads.kc
    public boolean Code(com.huawei.openalliance.ad.inter.data.g gVar) {
        if (gVar == null) {
            setAppInfo(null);
            this.e = null;
            this.C = null;
            return false;
        }
        if (gVar instanceof l) {
            this.C = (l) gVar;
        }
        try {
            this.g = 1;
            this.e = this.C.n();
            AppInfo y = gVar.y();
            setAppInfo(y);
            l lVar = this.C;
            if (lVar != null) {
                MetaData i_ = lVar.i_();
                if (i_ != null) {
                    this.i = i_.i();
                }
                this.l = ja.B(this.C.m_());
            }
            if (y != null) {
                setShowPermissionDialog(y.c());
                return true;
            }
        } catch (RuntimeException | Exception unused) {
            fb.Z(this.V, "setNativeAd ex");
        }
        return false;
    }
}
