package com.kwad.components.core.page;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.c.f;
import com.kwad.components.core.page.widget.a;
import com.kwad.components.core.webview.tachikoma.c.e;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bo;
import org.json.JSONObject;

@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* loaded from: classes11.dex */
public class AdWebViewActivityProxy extends com.kwad.components.core.proxy.c {
    public static final String KEY_AD_RESULT_CACHE_IDX = "key_ad_result_cache_idx";
    private static final String KEY_IS_AUTO_SHOW = "key_is_auto_show";
    private static final String KEY_LANDING_PAGE_TYPE = "key_landing_page_type";
    private static final String KEY_PAGE_TITLE = "key_page_title";
    private static final String KEY_PAGE_URL = "key_page_url";
    private static final String KEY_SHOW_PERMISSION = "key_show_permission";
    private static final String KEY_SHOW_TK_CONFIRM_DIALOG = "key_show_tk_confirm_dialog";
    public static final String KEY_TEMPLATE = "key_template_json";
    private AdResultData mAdResultData;
    private AdTemplate mAdTemplate;
    private boolean mAutoShow;
    private com.kwad.components.core.q.b mDialogFragment;
    private boolean mDisableShowConfirmDialog;
    private boolean mHasShowShowConfirmDialog;
    private Dialog mKsExitInterceptDialog;
    private Dialog mKsExitInterceptDialogV2;
    private int mLandingPageType;
    private c mLandingPageView;
    private String mPageTitle;
    private String mPageUrl;
    private boolean mShowPermission;
    private volatile boolean destroyed = false;
    private com.kwad.sdk.core.webview.d.a.b mWebCardCloseListener = new com.kwad.sdk.core.webview.d.a.b() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.1
        @Override // com.kwad.sdk.core.webview.d.a.b
        public final void b(WebCloseStatus webCloseStatus) {
            AdWebViewActivityProxy.this.finish();
        }
    };
    private com.kwad.components.core.page.a.a mLandPageViewListener = new com.kwad.components.core.page.a.a() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.2
        @Override // com.kwad.components.core.page.a.a
        public final void pC() {
            AdWebViewActivityProxy.this.onBackPressed();
        }

        @Override // com.kwad.components.core.page.a.a
        public final void pD() {
            if (AdWebViewActivityProxy.this.mLandingPageView != null && AdWebViewActivityProxy.this.mLandingPageView.getCanInterceptBackClick()) {
                AdWebViewActivityProxy.this.mLandingPageView.pM();
                return;
            }
            if (AdWebViewActivityProxy.this.mDisableShowConfirmDialog) {
                AdWebViewActivityProxy.this.finish();
                return;
            }
            if (AdWebViewActivityProxy.this.handleMiddlePageDialog()) {
                return;
            }
            if (AdWebViewActivityProxy.this.mAdTemplate.mIsForceJumpLandingPage) {
                AdWebViewActivityProxy.this.finish();
                return;
            }
            if (com.kwad.sdk.core.response.b.a.aN(e.dS(AdWebViewActivityProxy.this.mAdTemplate)) && com.kwad.components.core.q.a.rj().rk() == 1 && com.kwad.components.core.q.a.rj().rp() && !com.kwad.components.core.q.a.rj().rm()) {
                if (!com.kwad.components.core.q.a.rj().rl() && com.kwad.sdk.core.config.d.CE()) {
                    AdWebViewActivityProxy adWebViewActivityProxy = AdWebViewActivityProxy.this;
                    adWebViewActivityProxy.mDialogFragment = adWebViewActivityProxy.getTkDialogFragment();
                    com.kwad.components.core.q.b.a(AdWebViewActivityProxy.this.mDialogFragment, AdWebViewActivityProxy.this.getActivity(), AdWebViewActivityProxy.this.mBaseDialogListener);
                    return;
                }
                AdWebViewActivityProxy.this.finish();
                return;
            }
            if (AdWebViewActivityProxy.this.isFormAdExitInterceptEnable()) {
                AdWebViewActivityProxy.this.showDialog();
            } else {
                AdWebViewActivityProxy.this.finish();
            }
        }
    };
    private com.kwad.components.core.webview.tachikoma.e.c mBaseDialogListener = new com.kwad.components.core.webview.tachikoma.e.c() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.3
        @Override // com.kwad.components.core.webview.tachikoma.e.c
        public final void F(boolean z) {
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.c
        public final void fS() {
            com.kwad.components.core.q.a.rj().aL(true);
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.c
        public final void ga() {
            com.kwad.components.core.q.a.rj().aL(false);
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.c
        public final void gb() {
        }
    };

    /* loaded from: classes11.dex */
    public static class a {
        private String OJ;
        private String OL;
        private AdResultData OM;
        private boolean ON;

        /* renamed from: OO, reason: collision with root package name */
        private boolean f18457OO;
        private int OP;
        private boolean OQ;
        private AdTemplate adTemplate;

        /* renamed from: com.kwad.components.core.page.AdWebViewActivityProxy$a$a, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public static class C0799a {
            private String OJ;
            private String OL;
            private AdResultData OM;

            /* renamed from: OO, reason: collision with root package name */
            private boolean f18458OO;
            private int OP = 0;
            private boolean OQ;
            private boolean OR;
            private AdTemplate adTemplate;

            public final C0799a aC(boolean z) {
                this.OR = z;
                return this;
            }

            public final C0799a aD(boolean z) {
                this.f18458OO = z;
                return this;
            }

            public final C0799a aE(boolean z) {
                this.OQ = z;
                return this;
            }

            public final C0799a at(String str) {
                this.OJ = str;
                return this;
            }

            public final C0799a au(String str) {
                this.OL = str;
                return this;
            }

            public final C0799a az(int i) {
                this.OP = i;
                return this;
            }

            public final C0799a m(AdResultData adResultData) {
                this.OM = adResultData;
                return this;
            }

            public final a pK() {
                AdResultData adResultData = this.OM;
                if (adResultData != null) {
                    return new a(this.OJ, this.OL, adResultData, this.OR, this.f18458OO, this.OQ, this.OP, (byte) 0);
                }
                return new a(this.OJ, this.OL, this.adTemplate, this.OR, this.f18458OO, this.OQ, this.OP, (byte) 0);
            }

            public final C0799a at(AdTemplate adTemplate) {
                this.adTemplate = adTemplate;
                return this;
            }
        }

        public /* synthetic */ a(String str, String str2, AdResultData adResultData, boolean z, boolean z2, boolean z3, int i, byte b) {
            this(str, str2, adResultData, z, z2, z3, i);
        }

        public final AdTemplate getAdTemplate() {
            return this.adTemplate;
        }

        public final String pE() {
            return this.OJ;
        }

        public final String pF() {
            return this.OL;
        }

        public final int pG() {
            return this.OP;
        }

        public final boolean pH() {
            return this.ON;
        }

        public final boolean pI() {
            return this.OQ;
        }

        public final boolean pJ() {
            return this.f18457OO;
        }

        public /* synthetic */ a(String str, String str2, AdTemplate adTemplate, boolean z, boolean z2, boolean z3, int i, byte b) {
            this(str, str2, adTemplate, z, z2, z3, i);
        }

        private a(String str, String str2, AdTemplate adTemplate, boolean z, boolean z2, boolean z3, int i) {
            this(str, str2, z, z2, z3, i);
            this.adTemplate = adTemplate;
        }

        private a(String str, String str2, AdResultData adResultData, boolean z, boolean z2, boolean z3, int i) {
            this(str, str2, z, z2, z3, i);
            this.OM = adResultData;
            this.adTemplate = com.kwad.sdk.core.response.b.c.n(adResultData);
        }

        private a(String str, String str2, boolean z, boolean z2, boolean z3, int i) {
            this.OJ = str;
            this.OL = str2;
            this.ON = z;
            this.f18457OO = z2;
            this.OQ = z3;
            this.OP = i;
        }
    }

    private com.kwad.components.core.page.widget.a buildDialog() {
        return new com.kwad.components.core.page.widget.a(getActivity(), new a.InterfaceC0803a() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.5
            @Override // com.kwad.components.core.page.widget.a.InterfaceC0803a
            public final void a(DialogInterface dialogInterface) {
                com.kwad.sdk.core.adlog.c.p(AdWebViewActivityProxy.this.mAdTemplate, 104);
                dialogInterface.dismiss();
            }

            @Override // com.kwad.components.core.page.widget.a.InterfaceC0803a
            public final void b(DialogInterface dialogInterface) {
                try {
                    AdWebViewActivityProxy.super.onBackPressed();
                } catch (Throwable unused) {
                }
                com.kwad.sdk.core.adlog.c.p(AdWebViewActivityProxy.this.mAdTemplate, 105);
            }

            @Override // com.kwad.components.core.page.widget.a.InterfaceC0803a
            public final void c(DialogInterface dialogInterface) {
                com.kwad.sdk.core.adlog.c.p(AdWebViewActivityProxy.this.mAdTemplate, 106);
                dialogInterface.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.kwad.components.core.q.b getTkDialogFragment() {
        e.b bVar = new e.b();
        bVar.d(this.mAdResultData);
        bVar.aX(com.kwad.sdk.core.response.b.b.dy(this.mAdTemplate));
        bVar.aW(false);
        bVar.aX(true);
        return com.kwad.components.core.q.b.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleMiddlePageDialog() {
        boolean z = false;
        if (this.mAdTemplate == null || !com.kwad.sdk.core.config.d.CE()) {
            return false;
        }
        if (!bh.isNullString(com.kwad.sdk.core.response.b.a.cc(this.mAdTemplate)) && com.kwad.sdk.core.response.b.a.cb(this.mAdTemplate)) {
            z = true;
            if (this.mHasShowShowConfirmDialog) {
                try {
                    super.onBackPressed();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTrace(th);
                }
            } else {
                com.kwad.components.core.q.b tkDialogFragment = getTkDialogFragment();
                this.mDialogFragment = tkDialogFragment;
                com.kwad.components.core.q.b.a(tkDialogFragment, getActivity(), this.mBaseDialogListener);
                this.mHasShowShowConfirmDialog = true;
            }
        }
        return z;
    }

    private void initContentView() {
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_land_page_root);
        c a2 = c.a(this.mContext, new a.C0799a().at(this.mPageTitle).au(this.mPageUrl).at(this.mAdTemplate).aC(this.mShowPermission).aD(this.mAutoShow).az(this.mLandingPageType).aE(this.mDisableShowConfirmDialog).pK());
        this.mLandingPageView = a2;
        a2.setLandPageViewListener(this.mLandPageViewListener);
        this.mLandingPageView.setWebCardCloseListener(this.mWebCardCloseListener);
        viewGroup.addView(this.mLandingPageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFormAdExitInterceptEnable() {
        AdTemplate adTemplate;
        if (this.mShowPermission || (adTemplate = this.mAdTemplate) == null || com.kwad.sdk.core.response.b.e.F(adTemplate)) {
            return false;
        }
        if (com.kwad.sdk.core.config.d.CM() && this.mAdTemplate.mIsFromContent) {
            return true;
        }
        if (!com.kwad.sdk.core.config.d.CN() || this.mAdTemplate.mIsFromContent) {
            return false;
        }
        return true;
    }

    public static void launch(Context context, a aVar) {
        if (context == null || TextUtils.isEmpty(aVar.OL)) {
            return;
        }
        try {
            com.kwad.sdk.commercial.g.a.j(aVar.getAdTemplate(), aVar.pG(), aVar.pF());
            com.kwad.sdk.service.b.a(AdWebViewActivity.class, AdWebViewActivityProxy.class);
            Intent intent = new Intent(context, (Class<?>) AdWebViewActivity.class);
            intent.addFlags(268435456);
            intent.putExtra(KEY_PAGE_TITLE, aVar.OJ);
            intent.putExtra(KEY_LANDING_PAGE_TYPE, aVar.OP);
            intent.putExtra(KEY_PAGE_URL, aVar.OL);
            intent.putExtra(KEY_IS_AUTO_SHOW, aVar.f18457OO);
            intent.putExtra(KEY_SHOW_PERMISSION, aVar.ON);
            intent.putExtra(KEY_SHOW_TK_CONFIRM_DIALOG, aVar.pI());
            AdResultData adResultData = aVar.OM;
            if (adResultData == null) {
                adResultData = com.kwad.sdk.core.response.b.c.dD(aVar.adTemplate);
            }
            intent.putExtra("key_ad_result_cache_idx", f.ne().i(adResultData));
            context.startActivity(intent);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            com.kwad.sdk.commercial.g.a.a(aVar.getAdTemplate(), aVar.pG(), aVar.pF(), bo.t(th));
            if (l.zJ().yV()) {
                ServiceProvider.reportSdkCaughtException(th);
                return;
            }
            throw th;
        }
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        com.kwad.sdk.service.b.a(AdWebViewActivity.class, AdWebViewActivityProxy.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        if (this.mKsExitInterceptDialog == null) {
            this.mKsExitInterceptDialog = buildDialog();
        }
        com.kwad.sdk.core.adlog.c.b(this.mAdTemplate, 103, (JSONObject) null);
        this.mKsExitInterceptDialog.show();
    }

    @Override // com.kwad.components.core.proxy.c
    public boolean checkIntentData(@Nullable Intent intent) {
        AdResultData d = f.ne().d(getIntent().getIntExtra("key_ad_result_cache_idx", 0), true);
        this.mAdResultData = d;
        if (d == null) {
            return false;
        }
        AdTemplate n = com.kwad.sdk.core.response.b.c.n(d);
        this.mAdTemplate = n;
        if (n == null) {
            return false;
        }
        return true;
    }

    @Override // com.kwad.components.core.proxy.c
    public int getLayoutId() {
        return 0;
    }

    @Override // com.kwad.components.core.proxy.c
    public String getPageName() {
        return "AdWebViewActivityProxy";
    }

    @Override // com.kwad.components.core.proxy.c
    public void initData() {
        this.destroyed = false;
        this.mPageTitle = getIntent().getStringExtra(KEY_PAGE_TITLE);
        this.mLandingPageType = getIntent().getIntExtra(KEY_LANDING_PAGE_TYPE, 0);
        this.mPageUrl = getIntent().getStringExtra(KEY_PAGE_URL);
        this.mAutoShow = getIntent().getBooleanExtra(KEY_IS_AUTO_SHOW, false);
        this.mShowPermission = getIntent().getBooleanExtra(KEY_SHOW_PERMISSION, false);
        this.mDisableShowConfirmDialog = getIntent().getBooleanExtra(KEY_SHOW_TK_CONFIRM_DIALOG, false);
    }

    @Override // com.kwad.components.core.proxy.c
    public void initView() {
        setContentView(R.layout.ksad_activity_landpage);
        initContentView();
    }

    @Override // com.kwad.components.core.proxy.c
    public void onActivityCreate() {
        super.onActivityCreate();
        com.kwad.sdk.commercial.g.a.k(this.mAdTemplate, this.mLandingPageType, this.mPageUrl);
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        c cVar = this.mLandingPageView;
        if (cVar != null && cVar.getCanInterceptBackClick()) {
            this.mLandingPageView.pM();
            return;
        }
        if (this.mDisableShowConfirmDialog) {
            finish();
            return;
        }
        if (handleMiddlePageDialog()) {
            return;
        }
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null && !adTemplate.mIsForceJumpLandingPage) {
            if (com.kwad.sdk.core.response.b.a.aN(com.kwad.sdk.core.response.b.e.dS(adTemplate)) && com.kwad.components.core.q.a.rj().rk() == 1 && com.kwad.components.core.q.a.rj().rp() && !com.kwad.components.core.q.a.rj().rm()) {
                if (!com.kwad.components.core.q.a.rj().rl() && com.kwad.sdk.core.config.d.CE()) {
                    com.kwad.components.core.q.b tkDialogFragment = getTkDialogFragment();
                    this.mDialogFragment = tkDialogFragment;
                    com.kwad.components.core.q.b.a(tkDialogFragment, getActivity(), this.mBaseDialogListener);
                    return;
                }
                super.onBackPressed();
                return;
            }
            if (isFormAdExitInterceptEnable()) {
                try {
                    if (this.mKsExitInterceptDialogV2 == null) {
                        this.mKsExitInterceptDialogV2 = new com.kwad.components.core.page.widget.a(getActivity(), new a.InterfaceC0803a() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.4
                            @Override // com.kwad.components.core.page.widget.a.InterfaceC0803a
                            public final void a(DialogInterface dialogInterface) {
                                com.kwad.sdk.core.adlog.c.p(AdWebViewActivityProxy.this.mAdTemplate, 104);
                                dialogInterface.dismiss();
                            }

                            @Override // com.kwad.components.core.page.widget.a.InterfaceC0803a
                            public final void b(DialogInterface dialogInterface) {
                                if (!AdWebViewActivityProxy.this.destroyed) {
                                    try {
                                        AdWebViewActivityProxy.super.onBackPressed();
                                    } catch (Throwable th) {
                                        com.kwad.sdk.core.e.c.printStackTrace(th);
                                    }
                                }
                                com.kwad.sdk.core.adlog.c.p(AdWebViewActivityProxy.this.mAdTemplate, 105);
                            }

                            @Override // com.kwad.components.core.page.widget.a.InterfaceC0803a
                            public final void c(DialogInterface dialogInterface) {
                                com.kwad.sdk.core.adlog.c.p(AdWebViewActivityProxy.this.mAdTemplate, 106);
                                dialogInterface.dismiss();
                            }
                        });
                    }
                    com.kwad.sdk.core.adlog.c.b(this.mAdTemplate, 103, (JSONObject) null);
                    this.mKsExitInterceptDialogV2.show();
                    return;
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }
            super.onBackPressed();
            return;
        }
        super.onBackPressed();
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            this.destroyed = true;
            com.kwad.components.core.q.b bVar = this.mDialogFragment;
            if (bVar != null) {
                bVar.dismiss();
                this.mDialogFragment = null;
            }
            Dialog dialog = this.mKsExitInterceptDialog;
            if (dialog != null && dialog.isShowing()) {
                this.mKsExitInterceptDialog.dismiss();
            }
            Dialog dialog2 = this.mKsExitInterceptDialogV2;
            if (dialog2 != null && dialog2.isShowing()) {
                this.mKsExitInterceptDialogV2.dismiss();
            }
            super.onDestroy();
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate != null) {
                adTemplate.interactLandingPageShowing = false;
                adTemplate.mIsForceJumpLandingPage = false;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreCreate(@Nullable Bundle bundle) {
        super.onPreCreate(bundle);
        try {
            getIntent().removeExtra("key_template");
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
    }

    public static void launch(Context context, AdTemplate adTemplate) {
        launch(context, new a.C0799a().au(com.kwad.sdk.core.response.b.b.cD(adTemplate)).at(adTemplate).pK());
    }
}
