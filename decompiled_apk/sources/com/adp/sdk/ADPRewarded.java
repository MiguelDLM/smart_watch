package com.adp.sdk;

import OoOoXO0.xoXoI;
import android.app.Activity;
import android.os.Bundle;
import com.adp.sdk.dto.AdInfo;
import com.adp.sdk.dto.AdItem;
import com.adp.sdk.dto.AdpError;
import com.adp.sdk.dto.SourceVO;
import com.adp.sdk.f;
import com.adp.sdk.listener.ADPDownloadConfirmCallBack;
import com.adp.sdk.listener.ADPDownloadConfirmListener;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdSlot;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.hms.ads.reward.Reward;
import com.huawei.hms.ads.reward.RewardAd;
import com.huawei.hms.ads.reward.RewardAdLoadListener;
import com.huawei.hms.ads.reward.RewardAdStatusListener;
import com.kwad.components.offline.api.explore.model.ExploreConstants;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsInnerAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.RewardVideoADListener;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class ADPRewarded extends com.adp.sdk.e {
    private RewardVideoAD g;
    private Activity h;
    private String i;
    private String j;
    private ADPRewardedListener k;
    private AdItem l;
    private TTAdNative p;
    private TTRewardVideoAd q;
    private ADPDownloadConfirmListener r;
    private SourceVO s;
    private KsRewardVideoAd u;
    private RewardAd x;
    private boolean m = false;
    private boolean n = false;
    private int o = 1;
    private ArrayList<SourceVO> t = new ArrayList<>();
    private boolean v = true;
    private boolean w = true;

    /* loaded from: classes.dex */
    public interface ADPRewardedListener {
        void onADClicked();

        void onADError(AdpError adpError);

        void onADPresent();

        void onADReceive();

        void onClose();

        void onReward(Map<String, Object> map);

        void onVideoComplete();
    }

    /* loaded from: classes.dex */
    public class a implements KsLoadManager.RewardVideoAdListener {

        /* renamed from: com.adp.sdk.ADPRewarded$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0089a implements KsInnerAd.KsInnerAdInteractionListener {
            public C0089a(a aVar) {
            }

            @Override // com.kwad.sdk.api.KsInnerAd.KsInnerAdInteractionListener
            public void onAdClicked(KsInnerAd ksInnerAd) {
            }

            @Override // com.kwad.sdk.api.KsInnerAd.KsInnerAdInteractionListener
            public void onAdShow(KsInnerAd ksInnerAd) {
            }
        }

        public a() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public void onError(int i, String str) {
            ADPRewarded.this.m = false;
            if (ADPRewarded.this.t.size() > 0) {
                ADPRewarded.this.c();
                return;
            }
            ADPRewarded.this.a("kuaishou", new AdpError(i + "", str + ""));
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public void onRewardVideoAdLoad(List<KsRewardVideoAd> list) {
            if (list != null && list.size() > 0) {
                ADPRewarded.this.n = true;
                ADPRewarded aDPRewarded = ADPRewarded.this;
                aDPRewarded.b(aDPRewarded.h, ADPRewarded.this.i, "kuaishou", "3", ADPRewarded.this.s);
                ADPRewarded.this.u = list.get(0);
                ADPRewarded.this.u.setInnerAdInteractionListener(new C0089a(this));
                if (ADPRewarded.this.k != null) {
                    ADPRewarded.this.k.onADReceive();
                }
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public void onRewardVideoResult(List<KsRewardVideoAd> list) {
        }
    }

    /* loaded from: classes.dex */
    public class b implements KsRewardVideoAd.RewardAdInteractionListener {
        public b() {
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public void onAdClicked() {
            if (ADPRewarded.this.k != null) {
                ADPRewarded.this.k.onADClicked();
            }
            ADPRewarded.this.m = false;
            ADPRewarded aDPRewarded = ADPRewarded.this;
            aDPRewarded.a(aDPRewarded.h, ADPRewarded.this.i, "kuaishou", "3", ADPRewarded.this.s);
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public void onExtraRewardVerify(int i) {
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public void onPageDismiss() {
            if (ADPRewarded.this.k != null) {
                ADPRewarded.this.k.onClose();
            }
            ADPRewarded.this.m = false;
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public void onRewardStepVerify(int i, int i2) {
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public void onRewardVerify() {
            if (ADPRewarded.this.k != null) {
                ADPRewarded.this.k.onReward(null);
            }
            ADPRewarded.this.m = false;
            ADPRewarded aDPRewarded = ADPRewarded.this;
            aDPRewarded.d(aDPRewarded.h, ADPRewarded.this.i, "kuaishou", "3", ADPRewarded.this.s);
            com.adp.sdk.a.a(ADPRewarded.this.l, ADPRewarded.this.h);
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public void onVideoPlayEnd() {
            if (ADPRewarded.this.k != null) {
                ADPRewarded.this.k.onVideoComplete();
            }
            ADPRewarded.this.m = false;
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public void onVideoPlayError(int i, int i2) {
            ADPRewarded.this.m = false;
            ADPRewarded.this.a("kuaishou", new AdpError(i + "", "kuaishow play error"));
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public void onVideoPlayStart() {
            if (ADPRewarded.this.k != null) {
                ADPRewarded.this.k.onADPresent();
            }
            ADPRewarded aDPRewarded = ADPRewarded.this;
            aDPRewarded.e(aDPRewarded.h, ADPRewarded.this.i, "kuaishou", "3", ADPRewarded.this.s);
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public void onVideoSkipToEnd(long j) {
        }
    }

    /* loaded from: classes.dex */
    public class c implements TTAdNative.RewardVideoAdListener {

        /* loaded from: classes.dex */
        public class a implements TTRewardVideoAd.RewardAdInteractionListener {
            public a() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onAdClose() {
                if (ADPRewarded.this.k != null) {
                    ADPRewarded.this.k.onClose();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onAdShow() {
                if (ADPRewarded.this.k != null) {
                    ADPRewarded.this.k.onADPresent();
                }
                ADPRewarded aDPRewarded = ADPRewarded.this;
                aDPRewarded.e(aDPRewarded.h, ADPRewarded.this.i, "gromore", "3", ADPRewarded.this.s);
                com.adp.sdk.a.a(ADPRewarded.this.l, ADPRewarded.this.h);
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onAdVideoBarClick() {
                if (ADPRewarded.this.k != null) {
                    ADPRewarded.this.k.onADClicked();
                }
                ADPRewarded aDPRewarded = ADPRewarded.this;
                aDPRewarded.a(aDPRewarded.h, ADPRewarded.this.i, "gromore", "3", ADPRewarded.this.s);
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onRewardArrived(boolean z, int i, Bundle bundle) {
                if (!z) {
                    return;
                }
                if (ADPRewarded.this.k != null) {
                    ADPRewarded.this.k.onReward(null);
                }
                ADPRewarded aDPRewarded = ADPRewarded.this;
                aDPRewarded.d(aDPRewarded.h, ADPRewarded.this.i, "gromore", "3", ADPRewarded.this.s);
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onRewardVerify(boolean z, int i, String str, int i2, String str2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onSkippedVideo() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onVideoComplete() {
                if (ADPRewarded.this.k != null) {
                    ADPRewarded.this.k.onVideoComplete();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public void onVideoError() {
                ADPRewarded.this.a("bytedance", new AdpError(HelpFormatter.DEFAULT_OPT_PREFIX, "Video playback error csj"));
            }
        }

        public c() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onError(int i, String str) {
            ADPRewarded.this.n = false;
            if (ADPRewarded.this.t.size() > 0) {
                ADPRewarded.this.c();
                return;
            }
            ADPRewarded.this.a("bytedance", new AdpError(i + "", str));
            ADPRewarded.this.m = false;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
            ADPRewarded.this.n = false;
            ADPRewarded.this.m = false;
            ADPRewarded aDPRewarded = ADPRewarded.this;
            aDPRewarded.b(aDPRewarded.h, ADPRewarded.this.i, "gromore", "3", ADPRewarded.this.s);
            ADPRewarded.this.q = tTRewardVideoAd;
            ADPRewarded.this.q.setRewardAdInteractionListener(new a());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoCached(TTRewardVideoAd tTRewardVideoAd) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoCached() {
            ADPRewarded.this.n = true;
            if (ADPRewarded.this.k != null) {
                ADPRewarded.this.k.onADReceive();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends RewardAdLoadListener {
        public d() {
        }

        @Override // com.huawei.hms.ads.reward.RewardAdLoadListener
        public void onRewardAdFailedToLoad(int i) {
            ADPRewarded.this.m = false;
            if (ADPRewarded.this.t.size() > 0) {
                ADPRewarded.this.c();
                return;
            }
            ADPRewarded.this.a("huawei", new AdpError(i + "", i + ">HUAWEI"));
        }

        @Override // com.huawei.hms.ads.reward.RewardAdLoadListener
        public void onRewardedLoaded() {
            ADPRewarded.this.n = true;
            ADPRewarded aDPRewarded = ADPRewarded.this;
            aDPRewarded.b(aDPRewarded.h, ADPRewarded.this.i, "huawei", "3", ADPRewarded.this.s);
            if (ADPRewarded.this.k != null) {
                ADPRewarded.this.k.onADReceive();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends RewardAdStatusListener {
        public e() {
        }

        @Override // com.huawei.hms.ads.reward.RewardAdStatusListener
        public void onRewardAdClosed() {
            if (ADPRewarded.this.k != null) {
                ADPRewarded.this.k.onClose();
            }
            ADPRewarded.this.m = false;
            ADPRewarded.this.x = null;
        }

        @Override // com.huawei.hms.ads.reward.RewardAdStatusListener
        public void onRewardAdFailedToShow(int i) {
            ADPRewarded.this.a("adsplus", new AdpError(i + "", i + ">Huawei onRewardAdFailedToShow"));
            if (ADPRewarded.this.k != null) {
                ADPRewarded.this.k.onClose();
            }
            ADPRewarded.this.m = false;
        }

        @Override // com.huawei.hms.ads.reward.RewardAdStatusListener
        public void onRewardAdOpened() {
            if (ADPRewarded.this.k != null) {
                ADPRewarded.this.k.onADPresent();
            }
            ADPRewarded aDPRewarded = ADPRewarded.this;
            aDPRewarded.e(aDPRewarded.h, ADPRewarded.this.i, "huawei", "3", ADPRewarded.this.s);
            com.adp.sdk.a.a(ADPRewarded.this.l, ADPRewarded.this.h);
        }

        @Override // com.huawei.hms.ads.reward.RewardAdStatusListener
        public void onRewarded(Reward reward) {
            if (ADPRewarded.this.k != null) {
                ADPRewarded.this.k.onReward(new HashMap());
            }
            ADPRewarded.this.m = false;
            ADPRewarded aDPRewarded = ADPRewarded.this;
            aDPRewarded.d(aDPRewarded.h, ADPRewarded.this.i, "huawei", "3", ADPRewarded.this.s);
        }
    }

    /* loaded from: classes.dex */
    public class f implements f.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4672a;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = f.this;
                ADPRewarded.this.b(fVar.f4672a);
            }
        }

        public f(String str) {
            this.f4672a = str;
        }

        @Override // com.adp.sdk.f.c
        public void a(int i, String str) {
            ADPRewarded.this.m = false;
            if (ADPRewarded.this.t.size() > 0) {
                ADPRewarded.this.c();
                return;
            }
            ADPRewarded.this.a("gromore", new AdpError(i + "", str));
        }

        @Override // com.adp.sdk.f.c
        public void success() {
            ADPRewarded.this.h.runOnUiThread(new a());
        }
    }

    /* loaded from: classes.dex */
    public class g implements RewardVideoADListener {

        /* loaded from: classes.dex */
        public class a implements DownloadConfirmListener {

            /* renamed from: com.adp.sdk.ADPRewarded$g$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class C0090a implements ADPDownloadConfirmCallBack {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ DownloadConfirmCallBack f4676a;

                public C0090a(a aVar, DownloadConfirmCallBack downloadConfirmCallBack) {
                    this.f4676a = downloadConfirmCallBack;
                }

                @Override // com.adp.sdk.listener.ADPDownloadConfirmCallBack
                public void onCancel() {
                    DownloadConfirmCallBack downloadConfirmCallBack = this.f4676a;
                    if (downloadConfirmCallBack != null) {
                        downloadConfirmCallBack.onCancel();
                    }
                }

                @Override // com.adp.sdk.listener.ADPDownloadConfirmCallBack
                public void onConfirm() {
                    DownloadConfirmCallBack downloadConfirmCallBack = this.f4676a;
                    if (downloadConfirmCallBack != null) {
                        downloadConfirmCallBack.onConfirm();
                    }
                }
            }

            public a() {
            }

            @Override // com.qq.e.comm.compliance.DownloadConfirmListener
            public void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
                ADPRewarded.this.r.onDownloadConfirm(activity, i, str, new C0090a(this, downloadConfirmCallBack));
            }
        }

        public g() {
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADClick() {
            if (ADPRewarded.this.k != null) {
                ADPRewarded.this.k.onADClicked();
            }
            ADPRewarded.this.m = false;
            ADPRewarded aDPRewarded = ADPRewarded.this;
            aDPRewarded.a(aDPRewarded.h, ADPRewarded.this.i, "tencent", "3", ADPRewarded.this.s);
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADClose() {
            if (ADPRewarded.this.k != null) {
                ADPRewarded.this.k.onClose();
            }
            ADPRewarded.this.m = false;
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADExpose() {
            if (ADPRewarded.this.k != null) {
                ADPRewarded.this.k.onADPresent();
            }
            ADPRewarded aDPRewarded = ADPRewarded.this;
            aDPRewarded.e(aDPRewarded.h, ADPRewarded.this.i, "tencent", "3", ADPRewarded.this.s);
            com.adp.sdk.a.a(ADPRewarded.this.l, ADPRewarded.this.h);
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADLoad() {
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADShow() {
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onError(AdError adError) {
            ADPRewarded.this.m = false;
            if (ADPRewarded.this.t.size() > 0) {
                ADPRewarded.this.c();
                return;
            }
            ADPRewarded.this.a("tencent", new AdpError(adError.getErrorCode() + "", adError.getErrorMsg()));
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onReward(Map<String, Object> map) {
            if (ADPRewarded.this.k != null) {
                ADPRewarded.this.k.onReward(map);
            }
            ADPRewarded.this.m = false;
            ADPRewarded aDPRewarded = ADPRewarded.this;
            aDPRewarded.d(aDPRewarded.h, ADPRewarded.this.i, "tencent", "3", ADPRewarded.this.s);
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onVideoCached() {
            ADPRewarded.this.n = true;
            ADPRewarded aDPRewarded = ADPRewarded.this;
            aDPRewarded.b(aDPRewarded.h, ADPRewarded.this.i, "tencent", "3", ADPRewarded.this.s);
            if (ADPRewarded.this.r != null && ADPRewarded.this.g != null) {
                try {
                    ADPRewarded.this.g.setDownloadConfirmListener(new a());
                } catch (Exception unused) {
                }
            }
            if (ADPRewarded.this.k != null) {
                ADPRewarded.this.k.onADReceive();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onVideoComplete() {
            if (ADPRewarded.this.k != null) {
                ADPRewarded.this.k.onVideoComplete();
            }
            ADPRewarded.this.m = false;
        }
    }

    private ADPRewarded() {
    }

    private void load() {
        if (ADP.isInitSuccess()) {
            a();
            b();
        } else {
            this.m = false;
            a("adsplus", new AdpError("-1", "adp sdk is not initialized"));
        }
    }

    public void close() {
        this.m = false;
    }

    public void destroy() {
        this.m = false;
        if (this.g != null) {
            this.g = null;
        }
        if (this.u != null) {
            this.u = null;
        }
        TTRewardVideoAd tTRewardVideoAd = this.q;
        if (tTRewardVideoAd != null && tTRewardVideoAd.getMediationManager() != null) {
            this.q.getMediationManager().destroy();
        }
    }

    public void enableAudio(boolean z) {
        this.w = z;
    }

    public boolean isAdValid() {
        RewardAd rewardAd;
        boolean z;
        int i = this.o;
        if (i == 1) {
            RewardVideoAD rewardVideoAD = this.g;
            if (rewardVideoAD == null || !this.n) {
                return false;
            }
            return rewardVideoAD.isValid();
        }
        if (i == 2) {
            TTRewardVideoAd tTRewardVideoAd = this.q;
            if (tTRewardVideoAd != null && tTRewardVideoAd.getMediationManager() != null) {
                z = this.q.getMediationManager().isReady();
            } else {
                z = false;
            }
            if (this.q == null || !this.n || !z) {
                return false;
            }
            return true;
        }
        if (i == 3) {
            if (this.u == null || !this.n) {
                return false;
            }
            return true;
        }
        if (i != 5 || (rewardAd = this.x) == null || !rewardAd.isLoaded()) {
            return false;
        }
        return true;
    }

    public void loadAD() {
        if (!this.m) {
            a();
            this.m = true;
            load();
        }
    }

    public void setADDate(AdItem adItem) {
        this.l = adItem;
    }

    public void setDownloadConfirmListener(ADPDownloadConfirmListener aDPDownloadConfirmListener) {
        this.r = aDPDownloadConfirmListener;
    }

    public void show(Activity activity) {
        this.m = false;
        int i = this.o;
        if (i == 1) {
            if (isAdValid()) {
                this.g.showAD(activity);
            }
        } else if (i == 2) {
            if (isAdValid()) {
                this.q.showRewardVideoAd(activity);
            }
        } else if (i == 3) {
            f();
        } else if (i != 4 && i == 5) {
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        int size = this.t.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            if ((this.s.getId() + "").equals(this.t.get(size).getId() + "")) {
                this.t.remove(size);
                break;
            }
            size--;
        }
        if (this.t.size() > 0) {
            this.s = this.t.get(0);
            this.t.remove(0);
            d();
        }
    }

    private void d() {
        if ("tencent".equals(this.s.getSource())) {
            e(this.s.getId());
            return;
        }
        if ("kuaishou".equals(this.s.getSource())) {
            d(this.s.getId());
            return;
        }
        if ("gromore".equals(this.s.getSource())) {
            a(this.s.getId());
            return;
        }
        if ("bytedance".equals(this.s.getSource())) {
            a(this.s.getId());
            return;
        }
        if ("huawei".equals(this.s.getSource())) {
            c(this.s.getId());
            return;
        }
        this.m = false;
        if (this.t.size() <= 0) {
            a("kuaishou", new AdpError("-1", "no ad ads"));
        } else {
            c();
        }
    }

    private void e() {
        RewardAd rewardAd = this.x;
        if (rewardAd == null || !rewardAd.isLoaded()) {
            return;
        }
        this.x.show(this.h, new e());
    }

    private void f() {
        KsRewardVideoAd ksRewardVideoAd = this.u;
        if (ksRewardVideoAd == null || !ksRewardVideoAd.isAdEnable()) {
            return;
        }
        KsVideoPlayConfig build = new KsVideoPlayConfig.Builder().videoSoundEnable(this.w).showLandscape(this.h.getRequestedOrientation() == 0).build();
        this.u.setRewardAdInteractionListener(new b());
        this.u.showRewardVideoAd(this.h, build);
    }

    private void b() {
        if (this.l == null) {
            AdInfo adInfo = com.adp.sdk.a.b;
            if (adInfo != null && adInfo.getAdUnits() != null && adInfo.getAdUnits().size() > 0 && "0".equals(adInfo.getStatus())) {
                for (AdItem adItem : adInfo.getAdUnits()) {
                    if (ExploreConstants.SCENE_REWARD.equals(adItem.getType()) && this.i.equals(adItem.getAdUnitId())) {
                        this.l = adItem;
                    }
                }
            } else {
                a("adsplus", new AdpError("B002", this.h.getString(R.string.B002)));
                this.m = false;
                return;
            }
        }
        AdItem adItem2 = this.l;
        if (adItem2 == null) {
            a("adsplus", new AdpError("B003", this.h.getString(R.string.B003)));
            this.m = false;
            return;
        }
        if (!adItem2.isEnable()) {
            a("adsplus", new AdpError("B004", this.h.getString(R.string.B004)));
            this.m = false;
            return;
        }
        String b2 = com.adp.sdk.a.b(this.l, this.h);
        if (b2 != null) {
            a("adsplus", new AdpError("C001", b2));
            return;
        }
        if (this.l.getAdSource() != null && !this.l.getAdSource().isEmpty()) {
            try {
                this.v = this.l.isOpenLogs();
            } catch (Exception unused) {
            }
            int parseInt = Integer.parseInt(new com.adp.sdk.utils.d(this.h).b("rewarded_index", "0"));
            int i = com.adp.sdk.b.a(this.l, parseInt) ? 0 : parseInt;
            SourceVO a2 = com.adp.sdk.b.a(this.l, i, this.h);
            this.s = a2;
            if (a2 == null) {
                a("adsplus", new AdpError("B003", this.h.getString(R.string.B003)));
                return;
            }
            this.t = com.adp.sdk.b.a(this.l, a2);
            d();
            f((i + 1) + "");
            return;
        }
        a("adsplus", new AdpError("B003", this.h.getString(R.string.B003)));
    }

    private void e(String str) {
        try {
            this.o = 1;
            this.n = false;
            this.j = str;
            c(this.h, this.i, "tencent", "3", this.s);
            this.g = new RewardVideoAD(this.h, this.j, new g(), this.w);
            this.g.setServerSideVerificationOptions(new ServerSideVerificationOptions.Builder().build());
            this.g.loadAD();
        } catch (Exception e2) {
            this.m = false;
            if (this.t.size() <= 0) {
                a("adsplus", new AdpError("-1", "" + e2.getMessage()));
                return;
            }
            c();
        }
    }

    public ADPRewarded(Activity activity, String str, ADPRewardedListener aDPRewardedListener) {
        this.h = activity;
        this.i = str;
        this.k = aDPRewardedListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, AdpError adpError) {
        ADPRewardedListener aDPRewardedListener = this.k;
        if (aDPRewardedListener != null) {
            aDPRewardedListener.onADError(adpError);
        }
        String str2 = str + xoXoI.f2670oxoX + adpError.getCode() + xoXoI.f2670oxoX + adpError.getMessage();
        if (this.v) {
            com.adp.sdk.c.a().a(this.h, this.i, str2, "3", this.s);
        }
        this.m = false;
    }

    private void c(String str) {
        try {
            this.o = 5;
            this.n = false;
            this.j = str;
            if (!h.a()) {
                h.a(this.h);
            }
            c(this.h, this.i, "huawei", "3", this.s);
            this.x = new RewardAd(this.h, str);
            d dVar = new d();
            AdParam a2 = h.a(5000);
            VideoConfiguration.Builder builder = new VideoConfiguration.Builder();
            builder.setStartMuted(!this.w);
            this.x.setVideoConfiguration(builder.build());
            this.x.loadAd(a2, dVar);
        } catch (Exception e2) {
            this.m = false;
            if (this.t.size() <= 0) {
                a("adsplus", new AdpError("-1", "" + e2.getMessage()));
                return;
            }
            c();
        }
    }

    private void f(String str) {
        Activity activity = this.h;
        if (activity != null) {
            new com.adp.sdk.utils.d(activity).a("rewarded_index", str);
        }
    }

    private void a(String str) {
        Activity activity = this.h;
        if (activity != null && !activity.isFinishing() && ADP.isInitSuccess()) {
            if (!com.adp.sdk.f.a()) {
                com.adp.sdk.f.a(this.h, new f(str));
                return;
            } else {
                b(str);
                return;
            }
        }
        a("adsplus", new AdpError("-1", "ad is not init"));
    }

    private void d(String str) {
        long j;
        try {
            this.o = 3;
            try {
                j = Long.parseLong(str);
            } catch (NumberFormatException unused) {
                a("adsplus", new AdpError("-1", "adid NumberFormatException"));
                j = 0;
            }
            this.m = false;
            this.n = false;
            c(this.h, this.i, "kuaishou", "3", this.s);
            this.u = null;
            KsAdSDK.getLoadManager().loadRewardVideoAd(new KsScene.Builder(j).setBackUrl("ksad://returnback").screenOrientation(0).build(), new a());
        } catch (Exception e2) {
            this.m = false;
            if (this.t.size() <= 0) {
                a("adsplus", new AdpError("-1", "" + e2.getMessage()));
                return;
            }
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        try {
            this.j = str;
            this.o = 2;
            this.n = false;
            if (this.p == null) {
                this.p = ADP.getTTAdManager().createAdNative(this.h);
            }
            AdSlot build = new AdSlot.Builder().setOrientation(1).setCodeId(this.j).setMediationAdSlot(new MediationAdSlot.Builder().setMuted(!this.w).setVolume(0.1f).setBidNotify(true).setExtraObject(MediationConstant.ADN_PANGLE, "pangleRewardCustomData").setExtraObject(MediationConstant.ADN_GDT, "gdtRewardCustomData").setExtraObject("baidu", "baiduRewardCustomData").build()).build();
            c(this.h, this.i, "gromore", "3", this.s);
            this.p.loadRewardVideoAd(build, new c());
        } catch (Exception e2) {
            this.m = false;
            if (this.t.size() <= 0) {
                a("adsplus", new AdpError("-1", "" + e2.getMessage()));
                return;
            }
            c();
        }
    }
}
