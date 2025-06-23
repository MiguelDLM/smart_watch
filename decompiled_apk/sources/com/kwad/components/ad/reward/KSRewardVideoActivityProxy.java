package com.kwad.components.ad.reward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.m;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.proxy.PageCreateStage;
import com.kwad.components.core.s.c;
import com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.KSRewardLandScapeVideoActivity;
import com.kwad.sdk.api.proxy.app.KsRewardVideoActivity;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.utils.bo;

@KsAdSdkDynamicImpl(KsRewardVideoActivity.class)
@Keep
/* loaded from: classes11.dex */
public class KSRewardVideoActivityProxy extends com.kwad.components.core.l.b<g> implements g.b, m.a, c.b, OnAdLiveResumeInterceptor {
    public static final String KEY_AD_RESULT_CACHE_IDX = "key_ad_result_cache_idx";
    public static final String KEY_REWARD_TYPE = "key_template_reward_type";
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String KEY_VIDEO_PLAY_CONFIG = "key_video_play_config";
    public static final String KEY_VIDEO_PLAY_CONFIG_JSON = "key_video_play_config_json";
    private static final String TAG = "RewardVideo";
    private String listenerKey;
    private boolean mIsBackEnable;
    private com.kwad.components.ad.reward.model.c mModel;
    private boolean mPageDismissCalled;
    private long mPageEnterTime;
    private m mRewardPresenter;
    private AdBaseFrameLayout mRootContainer;
    private bn mTimerHelper;
    private boolean mReportedPageResume = false;
    private boolean mIsFinishVideoLookStep = false;
    private final com.kwad.components.ad.reward.e.l mRewardVerifyListener = new com.kwad.components.ad.reward.e.l() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.1
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (KSRewardVideoActivityProxy.this.mModel.hk() && ((g) KSRewardVideoActivityProxy.this.mCallerContext).mCheckExposureResult && ((g) KSRewardVideoActivityProxy.this.mCallerContext).ph != 2) {
                KSRewardVideoActivityProxy.this.markOpenNsCompleted();
                KSRewardVideoActivityProxy.this.notifyRewardVerify();
                KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
            }
        }
    };
    private com.kwad.components.ad.reward.e.i mAdOpenInteractionListener = new com.kwad.components.ad.reward.e.i() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.2
        @Override // com.kwad.components.ad.reward.e.i, com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
        public final void bJ() {
            super.bJ();
            ((g) KSRewardVideoActivityProxy.this.mCallerContext).fP = true;
            ((g) KSRewardVideoActivityProxy.this.mCallerContext).fF();
        }

        @Override // com.kwad.components.ad.reward.e.i, com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
        public final void h(boolean z) {
            if (KSRewardVideoActivityProxy.this.notifyPageDismiss(z)) {
                com.kwad.sdk.a.a.c.Au().Ax();
                super.h(z);
            }
        }

        @Override // com.kwad.components.ad.reward.e.i, com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
        public final void onRewardVerify() {
            if (((g) KSRewardVideoActivityProxy.this.mCallerContext).mCheckExposureResult && ((g) KSRewardVideoActivityProxy.this.mCallerContext).ph != 2) {
                KSRewardVideoActivityProxy.this.notifyRewardVerify();
                KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
            }
        }
    };
    private com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.3
        @Override // com.kwad.components.ad.reward.e.g
        public final void bL() {
            KSRewardVideoActivityProxy.this.mIsBackEnable = true;
        }
    };
    private com.kwad.components.ad.reward.e.d mAdRewardStepListener = new com.kwad.components.ad.reward.e.d() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.4
        @Override // com.kwad.components.ad.reward.e.d
        public final void fh() {
            KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
        }
    };

    private bn getTimerHelper() {
        if (this.mTimerHelper == null) {
            bn bnVar = new bn();
            this.mTimerHelper = bnVar;
            bnVar.startTiming();
        }
        return this.mTimerHelper;
    }

    private String getUniqueId() {
        return this.listenerKey;
    }

    private void handleNotifyVerify(boolean z) {
        ((g) this.mCallerContext).E(true);
        this.mModel.getAdTemplate().mRewardVerifyCalled = true;
        if (z || ((g) this.mCallerContext).ph == 0) {
            e.fq().C(this.mModel.getAdTemplate());
        }
        com.kwad.sdk.core.adlog.c.i(this.mModel.getAdTemplate(), isNeoScan());
        if (!((g) this.mCallerContext).mAdTemplate.converted) {
            com.kwad.components.ad.reward.c.a.gM().gN().M(com.kwad.components.ad.reward.c.b.ro);
        }
        bo.runOnUiThread(new az() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.7
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                if (KSRewardVideoActivityProxy.this.mAdOpenInteractionListener.gS()) {
                    com.kwad.components.ad.reward.monitor.c.a(KSRewardVideoActivityProxy.this.mModel.getAdTemplate(), 0, -1, true);
                }
            }
        });
        if (com.kwad.sdk.core.response.b.a.cT(this.mModel.bH())) {
            T t = this.mCallerContext;
            if (!((g) t).mAdTemplate.converted && !((g) t).pa && !((g) t).fM()) {
                g.a(getActivity(), (g) this.mCallerContext);
            }
        }
    }

    private boolean isLaunchTaskCompleted() {
        T t = this.mCallerContext;
        if (((g) t).pr != null && ((g) t).pr.isCompleted()) {
            return true;
        }
        return false;
    }

    private boolean isNeoScan() {
        if (this.mModel.hp() != null && this.mModel.hp().neoPageType == 1) {
            return true;
        }
        return false;
    }

    public static void launch(Activity activity, AdResultData adResultData, @NonNull KsVideoPlayConfig ksVideoPlayConfig, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener, com.kwad.components.core.i.d dVar, int i) {
        Intent intent;
        AdTemplate n = com.kwad.sdk.core.response.b.c.n(adResultData);
        com.kwad.components.ad.reward.monitor.c.i(true, n);
        AdGlobalConfigInfo adGlobalConfigInfo = adResultData.adGlobalConfigInfo;
        com.kwad.sdk.utils.l.em(n);
        if (adGlobalConfigInfo != null && adGlobalConfigInfo.neoPageType == 1) {
            ksVideoPlayConfig.setShowLandscape(false);
        }
        if (ksVideoPlayConfig.isShowLandscape()) {
            com.kwad.sdk.service.b.a(KSRewardLandScapeVideoActivity.class, KSRewardLandScapeVideoActivityProxy.class);
            intent = new Intent(activity, (Class<?>) KSRewardLandScapeVideoActivity.class);
        } else {
            com.kwad.sdk.service.b.a(KsRewardVideoActivity.class, KSRewardVideoActivityProxy.class);
            intent = new Intent(activity, (Class<?>) KsRewardVideoActivity.class);
        }
        intent.setFlags(268435456);
        intent.putExtra("key_template_json", n.toJson().toString());
        intent.putExtra("key_ad_result_cache_idx", com.kwad.components.core.c.f.ne().i(adResultData));
        intent.putExtra("key_video_play_config", ksVideoPlayConfig);
        intent.putExtra("key_video_play_config_json", com.kwad.components.core.internal.api.e.a(ksVideoPlayConfig));
        intent.putExtra(KEY_REWARD_TYPE, i);
        String uniqueId = n.getUniqueId();
        com.kwad.components.ad.reward.e.f.a(uniqueId, rewardAdInteractionListener, dVar);
        com.kwad.components.ad.reward.e.f.I(uniqueId);
        try {
            activity.startActivity(intent);
            com.kwad.sdk.a.a.c.Au().bj(true);
            com.kwad.components.ad.reward.monitor.c.c(true, n, PageCreateStage.END_LAUNCH.getStage());
        } catch (Throwable th) {
            com.kwad.components.ad.reward.monitor.c.a(true, n, PageCreateStage.ERROR_START_ACTIVITY.getStage(), th.getMessage());
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markOpenNsCompleted() {
        T t = this.mCallerContext;
        if (((g) t).ps != null) {
            ((g) t).ps.markOpenNsCompleted();
        }
    }

    private boolean needHandledOnResume() {
        if (((g) this.mCallerContext).fN()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean notifyPageDismiss(boolean z) {
        com.kwad.components.ad.reward.model.c cVar;
        if (this.mPageDismissCalled || this.mCallerContext == 0 || (cVar = this.mModel) == null) {
            return false;
        }
        this.mPageDismissCalled = true;
        if (!com.kwad.sdk.core.response.b.a.cN(cVar.bH()) || !((g) this.mCallerContext).fL()) {
            com.kwad.sdk.core.adlog.c.m(this.mModel.getAdTemplate(), (int) Math.ceil(((float) getTimerHelper().getTime()) / 1000.0f));
        }
        if (z) {
            if (this.mModel.hp() == null || this.mModel.hp().neoPageType != 1) {
                com.kwad.sdk.core.adlog.c.a(this.mModel.getAdTemplate(), 1, getTimerHelper().getTime(), ((g) this.mCallerContext).mReportExtData);
            }
        } else if (this.mModel.hp() == null || this.mModel.hp().neoPageType != 1) {
            com.kwad.sdk.core.adlog.c.a(this.mModel.getAdTemplate(), 6, getTimerHelper().getTime(), this.mModel.ho());
        }
        return true;
    }

    private void notifyRewardStep(final int i, final int i2) {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar == null || com.kwad.sdk.core.response.b.e.ed(cVar.getAdTemplate()) || ((g) this.mCallerContext).pg.contains(Integer.valueOf(i2))) {
            return;
        }
        ((g) this.mCallerContext).pg.add(Integer.valueOf(i2));
        n.a(i, i2, (g) this.mCallerContext, this.mModel);
        bo.runOnUiThread(new az() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.6
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                try {
                    if (KSRewardVideoActivityProxy.this.mAdOpenInteractionListener.h(i, i2)) {
                        com.kwad.components.ad.reward.monitor.c.a(KSRewardVideoActivityProxy.this.mModel.getAdTemplate(), i, i2, false);
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerify() {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar == null || !((g) this.mCallerContext).mCheckExposureResult || com.kwad.sdk.core.response.b.e.ed(cVar.getAdTemplate()) || ((g) this.mCallerContext).fO()) {
            return;
        }
        if (this.mModel.hj()) {
            T t = this.mCallerContext;
            if (((g) t).pr != null && ((g) t).pr.isCompleted()) {
                handleNotifyVerify(true);
                return;
            }
            return;
        }
        if (this.mModel.hk()) {
            T t2 = this.mCallerContext;
            if (((g) t2).ps != null && ((g) t2).ps.isCompleted()) {
                handleNotifyVerify(true);
                return;
            }
            return;
        }
        handleNotifyVerify(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerifyStepByStep() {
        boolean z;
        if (this.mModel.hj()) {
            notifyRewardStep(2, 0);
            if (isLaunchTaskCompleted()) {
                notifyRewardStep(2, 2);
                return;
            }
            return;
        }
        if (this.mModel.hk()) {
            T t = this.mCallerContext;
            if (((g) t).ps != null && ((g) t).ps.isCompleted()) {
                z = true;
            } else {
                z = false;
            }
            notifyRewardStep(1, 0);
            if (z) {
                notifyRewardStep(1, 1);
                return;
            }
            return;
        }
        if (!this.mIsFinishVideoLookStep) {
            this.mIsFinishVideoLookStep = true;
            notifyRewardStep(0, 0);
        }
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        com.kwad.sdk.service.b.a(KsRewardVideoActivity.class, KSRewardVideoActivityProxy.class);
    }

    private void reportSubPageCreate(String str) {
        AdTemplate adTemplate;
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar != null) {
            adTemplate = cVar.getAdTemplate();
        } else {
            adTemplate = null;
        }
        com.kwad.components.ad.reward.monitor.c.c(true, adTemplate, str);
    }

    @Override // com.kwad.components.core.proxy.c
    public boolean checkIntentData(@Nullable Intent intent) {
        com.kwad.components.ad.reward.model.c a2 = com.kwad.components.ad.reward.model.c.a(intent);
        this.mModel = a2;
        if (a2 == null) {
            return false;
        }
        return true;
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void finish() {
        super.finish();
        this.mAdOpenInteractionListener.h(false);
    }

    @Override // com.kwad.components.core.proxy.c
    public int getLayoutId() {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar != null && cVar.gt) {
            return R.layout.ksad_activity_reward_neo;
        }
        return R.layout.ksad_activity_reward_video_legacy;
    }

    @Override // com.kwad.components.core.proxy.c
    public String getPageName() {
        return "KSRewardLandScapeVideoActivityProxy";
    }

    @Override // com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor
    public boolean handledAdLiveOnResume() {
        return needHandledOnResume();
    }

    @Override // com.kwad.components.core.proxy.c
    public void initData() {
        this.listenerKey = this.mModel.getAdTemplate().getUniqueId();
        this.mAdOpenInteractionListener.setAdTemplate(this.mModel.getAdTemplate());
        this.mAdOpenInteractionListener.L(getUniqueId());
        this.mPageEnterTime = SystemClock.elapsedRealtime();
        com.kwad.components.ad.reward.monitor.c.a(true, this.mModel.getAdTemplate(), this.mPageEnterTime, this.mModel.hp());
        com.kwad.components.ad.reward.monitor.c.g(true, this.mModel.getAdTemplate());
        com.kwad.components.core.s.c.rD().a(this);
        b.fc().a(this.mRewardVerifyListener);
    }

    @Override // com.kwad.components.core.proxy.c
    public void initView() {
        this.mRootContainer = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
    }

    @Override // com.kwad.components.ad.reward.g.b
    public boolean interceptPlayCardResume() {
        return needHandledOnResume();
    }

    @Override // com.kwad.components.core.proxy.c
    public boolean needAdaptionScreen() {
        return true;
    }

    @Override // com.kwad.components.core.l.b, com.kwad.components.core.proxy.c
    public void onActivityCreate() {
        super.onActivityCreate();
        com.kwad.sdk.commercial.d.c.bA(this.mModel.getAdTemplate());
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        m mVar = this.mRewardPresenter;
        if (mVar == null) {
            super.onBackPressed();
            return;
        }
        BackPressHandleResult go = mVar.go();
        if (go.equals(BackPressHandleResult.HANDLED)) {
            return;
        }
        if (go.equals(BackPressHandleResult.HANDLED_CLOSE)) {
            super.onBackPressed();
            this.mAdOpenInteractionListener.h(false);
        } else if (this.mIsBackEnable) {
            this.mAdOpenInteractionListener.h(false);
            super.onBackPressed();
        }
    }

    @Override // com.kwad.components.core.proxy.c
    public void onCreateCaughtException(Throwable th) {
        AdTemplate adTemplate;
        super.onCreateCaughtException(th);
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar != null) {
            adTemplate = cVar.getAdTemplate();
        } else {
            adTemplate = null;
        }
        com.kwad.components.ad.reward.monitor.b.b(true, adTemplate);
    }

    @Override // com.kwad.components.core.l.b
    public Presenter onCreatePresenter() {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar == null) {
            return null;
        }
        m mVar = new m(this, this.mContext, this.mRootContainer, cVar, (g) this.mCallerContext);
        this.mRewardPresenter = mVar;
        mVar.a(this);
        return this.mRewardPresenter;
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.components.core.proxy.a.c
    public void onCreateStageChange(PageCreateStage pageCreateStage) {
        super.onCreateStageChange(pageCreateStage);
        com.kwad.sdk.core.e.c.d(TAG, "onCreateStageChange: " + pageCreateStage.getStage());
        reportSubPageCreate(pageCreateStage.getStage());
    }

    @Override // com.kwad.components.core.l.b, com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            b.fc().b(this.mRewardVerifyListener);
            super.onDestroy();
            this.mAdOpenInteractionListener.h(false);
            if (this.mCallerContext != 0) {
                i.gk().C(String.valueOf(((g) this.mCallerContext).mAdTemplate));
                com.kwad.components.ad.reward.e.f.K(getUniqueId());
            }
            com.kwad.components.ad.reward.model.c cVar = this.mModel;
            if (cVar != null) {
                String K = com.kwad.sdk.core.response.b.a.K(cVar.bH());
                if (!TextUtils.isEmpty(K)) {
                    com.kwad.sdk.core.videocache.c.a.by(this.mContext.getApplicationContext()).eN(K);
                }
            }
            com.kwad.components.core.s.c.rD().b(this);
            this.listenerKey = null;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.s.c.b
    public void onPageClose() {
        finish();
    }

    @Override // com.kwad.components.core.l.b, com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
        T t = this.mCallerContext;
        if (t != 0) {
            ((g) t).mPageEnterTime = -1L;
        }
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreCreate(@Nullable Bundle bundle) {
        super.onPreCreate(bundle);
        try {
            getIntent().removeExtra("key_template");
        } catch (Throwable unused) {
        }
        reportSubPageCreate(PageCreateStage.END_CHILD_ON_PRE_CREATE.getStage());
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreDestroy() {
        super.onPreDestroy();
        com.kwad.components.core.webview.tachikoma.d.b.tG().tH();
    }

    @Override // com.kwad.components.core.l.b, com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        try {
            super.onResume();
            com.kwad.components.ad.reward.model.c cVar = this.mModel;
            if (cVar != null) {
                AdTemplate adTemplate = cVar.getAdTemplate();
                com.kwad.sdk.core.d.a.Ep();
                com.kwad.sdk.core.d.a.bW(adTemplate);
            }
            if (!this.mReportedPageResume) {
                com.kwad.components.ad.reward.monitor.c.f(true, this.mModel.getAdTemplate());
                this.mReportedPageResume = true;
            }
            com.kwad.components.ad.reward.c.a.gM().M(this.mContext);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.ad.reward.m.a
    public void onUnbind() {
        this.mIsBackEnable = false;
        ((g) this.mCallerContext).E(false);
        ((g) this.mCallerContext).pe = false;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.kwad.components.core.l.b
    public g onCreateCallerContext() {
        long al;
        AdResultData hl = this.mModel.hl();
        AdTemplate adTemplate = this.mModel.getAdTemplate();
        AdInfo bH = this.mModel.bH();
        final g gVar = new g(this);
        gVar.mPageEnterTime = this.mPageEnterTime;
        gVar.f18441oI = this.mModel.hn() == 2;
        gVar.oJ = this.mAdOpenInteractionListener;
        gVar.mAdRewardStepListener = this.mAdRewardStepListener;
        gVar.mScreenOrientation = this.mModel.getScreenOrientation();
        gVar.mVideoPlayConfig = this.mModel.hm();
        gVar.mReportExtData = this.mModel.ho();
        gVar.mRootContainer = this.mRootContainer;
        gVar.d(hl);
        gVar.pC = com.kwad.sdk.core.response.b.b.dY(bH) ? LoadStrategy.FULL_TK : LoadStrategy.MULTI;
        gVar.a(this);
        if (com.kwad.sdk.core.response.b.a.aE(bH)) {
            gVar.mApkDownloadHelper = new com.kwad.components.core.e.d.c(adTemplate, this.mModel.ho());
        }
        gVar.oN = new RewardActionBarControl(gVar, this.mContext, adTemplate);
        gVar.b(this.mPlayEndPageListener);
        if (com.kwad.sdk.core.response.b.b.cB(adTemplate)) {
            j jVar = new j(gVar, this.mModel.ho(), null);
            gVar.f18442oO = jVar;
            jVar.a(new com.kwad.components.ad.reward.c.d() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.5
                @Override // com.kwad.components.ad.reward.c.d
                public final void a(com.kwad.components.ad.reward.c.b bVar) {
                    gVar.b(bVar);
                }
            });
        }
        if (com.kwad.sdk.core.response.b.a.ar(bH)) {
            gVar.oP = new com.kwad.components.ad.l.a().af(true);
        }
        gVar.oZ = true;
        if (com.kwad.sdk.core.response.b.a.bI(bH)) {
            gVar.oM = new com.kwad.components.core.playable.a((KsAdWebView) findViewById(R.id.ksad_playable_webview));
        }
        gVar.pv = 0L;
        if (this.mModel.bH() != null) {
            if (com.kwad.sdk.core.response.b.a.bI(this.mModel.bH())) {
                al = com.kwad.sdk.core.response.b.a.aq(this.mModel.bH());
            } else {
                al = com.kwad.sdk.core.response.b.a.al(this.mModel.bH());
            }
            gVar.pv = al;
        }
        gVar.mTimerHelper = getTimerHelper();
        gVar.oK = new com.kwad.components.ad.reward.m.e(gVar);
        gVar.gt = this.mModel.gt;
        return gVar;
    }
}
