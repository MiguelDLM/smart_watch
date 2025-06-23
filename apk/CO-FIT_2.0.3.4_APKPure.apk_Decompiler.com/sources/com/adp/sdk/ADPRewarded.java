package com.adp.sdk;

import OoOoXO0.xoXoI;
import android.app.Activity;
import android.content.Context;
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
import com.kwad.sdk.api.KsInnerAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
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

public class ADPRewarded extends e {
    /* access modifiers changed from: private */
    public RewardVideoAD g;
    /* access modifiers changed from: private */
    public Activity h;
    /* access modifiers changed from: private */
    public String i;
    private String j;
    /* access modifiers changed from: private */
    public ADPRewardedListener k;
    /* access modifiers changed from: private */
    public AdItem l;
    /* access modifiers changed from: private */
    public boolean m = false;
    /* access modifiers changed from: private */
    public boolean n = false;
    private int o = 1;
    private TTAdNative p;
    /* access modifiers changed from: private */
    public TTRewardVideoAd q;
    /* access modifiers changed from: private */
    public ADPDownloadConfirmListener r;
    /* access modifiers changed from: private */
    public SourceVO s;
    /* access modifiers changed from: private */
    public ArrayList<SourceVO> t = new ArrayList<>();
    /* access modifiers changed from: private */
    public KsRewardVideoAd u;
    private boolean v = true;
    private boolean w = true;
    /* access modifiers changed from: private */
    public RewardAd x;

    public interface ADPRewardedListener {
        void onADClicked();

        void onADError(AdpError adpError);

        void onADPresent();

        void onADReceive();

        void onClose();

        void onReward(Map<String, Object> map);

        void onVideoComplete();
    }

    public class a implements KsLoadManager.RewardVideoAdListener {

        /* renamed from: com.adp.sdk.ADPRewarded$a$a  reason: collision with other inner class name */
        public class C0009a implements KsInnerAd.KsInnerAdInteractionListener {
            public C0009a(a aVar) {
            }

            public void onAdClicked(KsInnerAd ksInnerAd) {
            }

            public void onAdShow(KsInnerAd ksInnerAd) {
            }
        }

        public a() {
        }

        public void onError(int i, String str) {
            boolean unused = ADPRewarded.this.m = false;
            if (ADPRewarded.this.t.size() <= 0) {
                ADPRewarded.this.a("kuaishou", new AdpError(i + "", str + ""));
                return;
            }
            ADPRewarded.this.c();
        }

        public void onRewardVideoAdLoad(List<KsRewardVideoAd> list) {
            if (list != null && list.size() > 0) {
                boolean unused = ADPRewarded.this.n = true;
                ADPRewarded aDPRewarded = ADPRewarded.this;
                aDPRewarded.b(aDPRewarded.h, ADPRewarded.this.i, "kuaishou", "3", ADPRewarded.this.s);
                KsRewardVideoAd unused2 = ADPRewarded.this.u = list.get(0);
                ADPRewarded.this.u.setInnerAdInteractionListener(new C0009a(this));
                if (ADPRewarded.this.k != null) {
                    ADPRewarded.this.k.onADReceive();
                }
            }
        }

        public void onRewardVideoResult(List<KsRewardVideoAd> list) {
        }
    }

    public class b implements KsRewardVideoAd.RewardAdInteractionListener {
        public b() {
        }

        public void onAdClicked() {
            if (ADPRewarded.this.k != null) {
                ADPRewarded.this.k.onADClicked();
            }
            boolean unused = ADPRewarded.this.m = false;
            ADPRewarded aDPRewarded = ADPRewarded.this;
            aDPRewarded.a(aDPRewarded.h, ADPRewarded.this.i, "kuaishou", "3", ADPRewarded.this.s);
        }

        public void onExtraRewardVerify(int i) {
        }

        public void onPageDismiss() {
            if (ADPRewarded.this.k != null) {
                ADPRewarded.this.k.onClose();
            }
            boolean unused = ADPRewarded.this.m = false;
        }

        public void onRewardStepVerify(int i, int i2) {
        }

        public void onRewardVerify() {
            if (ADPRewarded.this.k != null) {
                ADPRewarded.this.k.onReward((Map<String, Object>) null);
            }
            boolean unused = ADPRewarded.this.m = false;
            ADPRewarded aDPRewarded = ADPRewarded.this;
            aDPRewarded.d(aDPRewarded.h, ADPRewarded.this.i, "kuaishou", "3", ADPRewarded.this.s);
            a.a(ADPRewarded.this.l, (Context) ADPRewarded.this.h);
        }

        public void onVideoPlayEnd() {
            if (ADPRewarded.this.k != null) {
                ADPRewarded.this.k.onVideoComplete();
            }
            boolean unused = ADPRewarded.this.m = false;
        }

        public void onVideoPlayError(int i, int i2) {
            boolean unused = ADPRewarded.this.m = false;
            ADPRewarded aDPRewarded = ADPRewarded.this;
            aDPRewarded.a("kuaishou", new AdpError(i + "", "kuaishow play error"));
        }

        public void onVideoPlayStart() {
            if (ADPRewarded.this.k != null) {
                ADPRewarded.this.k.onADPresent();
            }
            ADPRewarded aDPRewarded = ADPRewarded.this;
            aDPRewarded.e(aDPRewarded.h, ADPRewarded.this.i, "kuaishou", "3", ADPRewarded.this.s);
        }

        public void onVideoSkipToEnd(long j) {
        }
    }

    public class c implements TTAdNative.RewardVideoAdListener {

        public class a implements TTRewardVideoAd.RewardAdInteractionListener {
            public a() {
            }

            public void onAdClose() {
                if (ADPRewarded.this.k != null) {
                    ADPRewarded.this.k.onClose();
                }
            }

            public void onAdShow() {
                if (ADPRewarded.this.k != null) {
                    ADPRewarded.this.k.onADPresent();
                }
                ADPRewarded aDPRewarded = ADPRewarded.this;
                aDPRewarded.e(aDPRewarded.h, ADPRewarded.this.i, "gromore", "3", ADPRewarded.this.s);
                a.a(ADPRewarded.this.l, (Context) ADPRewarded.this.h);
            }

            public void onAdVideoBarClick() {
                if (ADPRewarded.this.k != null) {
                    ADPRewarded.this.k.onADClicked();
                }
                ADPRewarded aDPRewarded = ADPRewarded.this;
                aDPRewarded.a(aDPRewarded.h, ADPRewarded.this.i, "gromore", "3", ADPRewarded.this.s);
            }

            public void onRewardArrived(boolean z, int i, Bundle bundle) {
                if (z) {
                    if (ADPRewarded.this.k != null) {
                        ADPRewarded.this.k.onReward((Map<String, Object>) null);
                    }
                    ADPRewarded aDPRewarded = ADPRewarded.this;
                    aDPRewarded.d(aDPRewarded.h, ADPRewarded.this.i, "gromore", "3", ADPRewarded.this.s);
                }
            }

            public void onRewardVerify(boolean z, int i, String str, int i2, String str2) {
            }

            public void onSkippedVideo() {
            }

            public void onVideoComplete() {
                if (ADPRewarded.this.k != null) {
                    ADPRewarded.this.k.onVideoComplete();
                }
            }

            public void onVideoError() {
                ADPRewarded.this.a("bytedance", new AdpError(HelpFormatter.DEFAULT_OPT_PREFIX, "Video playback error csj"));
            }
        }

        public c() {
        }

        public void onError(int i, String str) {
            boolean unused = ADPRewarded.this.n = false;
            if (ADPRewarded.this.t.size() <= 0) {
                ADPRewarded aDPRewarded = ADPRewarded.this;
                aDPRewarded.a("bytedance", new AdpError(i + "", str));
                boolean unused2 = ADPRewarded.this.m = false;
                return;
            }
            ADPRewarded.this.c();
        }

        public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
            boolean unused = ADPRewarded.this.n = false;
            boolean unused2 = ADPRewarded.this.m = false;
            ADPRewarded aDPRewarded = ADPRewarded.this;
            aDPRewarded.b(aDPRewarded.h, ADPRewarded.this.i, "gromore", "3", ADPRewarded.this.s);
            TTRewardVideoAd unused3 = ADPRewarded.this.q = tTRewardVideoAd;
            ADPRewarded.this.q.setRewardAdInteractionListener(new a());
        }

        public void onRewardVideoCached(TTRewardVideoAd tTRewardVideoAd) {
        }

        public void onRewardVideoCached() {
            boolean unused = ADPRewarded.this.n = true;
            if (ADPRewarded.this.k != null) {
                ADPRewarded.this.k.onADReceive();
            }
        }
    }

    public class d extends RewardAdLoadListener {
        public d() {
        }

        public void onRewardAdFailedToLoad(int i) {
            boolean unused = ADPRewarded.this.m = false;
            if (ADPRewarded.this.t.size() <= 0) {
                ADPRewarded.this.a("huawei", new AdpError(i + "", i + ">HUAWEI"));
                return;
            }
            ADPRewarded.this.c();
        }

        public void onRewardedLoaded() {
            boolean unused = ADPRewarded.this.n = true;
            ADPRewarded aDPRewarded = ADPRewarded.this;
            aDPRewarded.b(aDPRewarded.h, ADPRewarded.this.i, "huawei", "3", ADPRewarded.this.s);
            if (ADPRewarded.this.k != null) {
                ADPRewarded.this.k.onADReceive();
            }
        }
    }

    public class e extends RewardAdStatusListener {
        public e() {
        }

        public void onRewardAdClosed() {
            if (ADPRewarded.this.k != null) {
                ADPRewarded.this.k.onClose();
            }
            boolean unused = ADPRewarded.this.m = false;
            RewardAd unused2 = ADPRewarded.this.x = null;
        }

        public void onRewardAdFailedToShow(int i) {
            ADPRewarded.this.a("adsplus", new AdpError(i + "", i + ">Huawei onRewardAdFailedToShow"));
            if (ADPRewarded.this.k != null) {
                ADPRewarded.this.k.onClose();
            }
            boolean unused = ADPRewarded.this.m = false;
        }

        public void onRewardAdOpened() {
            if (ADPRewarded.this.k != null) {
                ADPRewarded.this.k.onADPresent();
            }
            ADPRewarded aDPRewarded = ADPRewarded.this;
            aDPRewarded.e(aDPRewarded.h, ADPRewarded.this.i, "huawei", "3", ADPRewarded.this.s);
            a.a(ADPRewarded.this.l, (Context) ADPRewarded.this.h);
        }

        public void onRewarded(Reward reward) {
            if (ADPRewarded.this.k != null) {
                ADPRewarded.this.k.onReward(new HashMap());
            }
            boolean unused = ADPRewarded.this.m = false;
            ADPRewarded aDPRewarded = ADPRewarded.this;
            aDPRewarded.d(aDPRewarded.h, ADPRewarded.this.i, "huawei", "3", ADPRewarded.this.s);
        }
    }

    public class f implements f.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f678a;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                f fVar = f.this;
                ADPRewarded.this.b(fVar.f678a);
            }
        }

        public f(String str) {
            this.f678a = str;
        }

        public void a(int i, String str) {
            boolean unused = ADPRewarded.this.m = false;
            if (ADPRewarded.this.t.size() <= 0) {
                ADPRewarded aDPRewarded = ADPRewarded.this;
                aDPRewarded.a("gromore", new AdpError(i + "", str));
                return;
            }
            ADPRewarded.this.c();
        }

        public void success() {
            ADPRewarded.this.h.runOnUiThread(new a());
        }
    }

    public class g implements RewardVideoADListener {

        public class a implements DownloadConfirmListener {

            /* renamed from: com.adp.sdk.ADPRewarded$g$a$a  reason: collision with other inner class name */
            public class C0010a implements ADPDownloadConfirmCallBack {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ DownloadConfirmCallBack f682a;

                public C0010a(a aVar, DownloadConfirmCallBack downloadConfirmCallBack) {
                    this.f682a = downloadConfirmCallBack;
                }

                public void onCancel() {
                    DownloadConfirmCallBack downloadConfirmCallBack = this.f682a;
                    if (downloadConfirmCallBack != null) {
                        downloadConfirmCallBack.onCancel();
                    }
                }

                public void onConfirm() {
                    DownloadConfirmCallBack downloadConfirmCallBack = this.f682a;
                    if (downloadConfirmCallBack != null) {
                        downloadConfirmCallBack.onConfirm();
                    }
                }
            }

            public a() {
            }

            public void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
                ADPRewarded.this.r.onDownloadConfirm(activity, i, str, new C0010a(this, downloadConfirmCallBack));
            }
        }

        public g() {
        }

        public void onADClick() {
            if (ADPRewarded.this.k != null) {
                ADPRewarded.this.k.onADClicked();
            }
            boolean unused = ADPRewarded.this.m = false;
            ADPRewarded aDPRewarded = ADPRewarded.this;
            aDPRewarded.a(aDPRewarded.h, ADPRewarded.this.i, "tencent", "3", ADPRewarded.this.s);
        }

        public void onADClose() {
            if (ADPRewarded.this.k != null) {
                ADPRewarded.this.k.onClose();
            }
            boolean unused = ADPRewarded.this.m = false;
        }

        public void onADExpose() {
            if (ADPRewarded.this.k != null) {
                ADPRewarded.this.k.onADPresent();
            }
            ADPRewarded aDPRewarded = ADPRewarded.this;
            aDPRewarded.e(aDPRewarded.h, ADPRewarded.this.i, "tencent", "3", ADPRewarded.this.s);
            a.a(ADPRewarded.this.l, (Context) ADPRewarded.this.h);
        }

        public void onADLoad() {
        }

        public void onADShow() {
        }

        public void onError(AdError adError) {
            boolean unused = ADPRewarded.this.m = false;
            if (ADPRewarded.this.t.size() <= 0) {
                ADPRewarded aDPRewarded = ADPRewarded.this;
                aDPRewarded.a("tencent", new AdpError(adError.getErrorCode() + "", adError.getErrorMsg()));
                return;
            }
            ADPRewarded.this.c();
        }

        public void onReward(Map<String, Object> map) {
            if (ADPRewarded.this.k != null) {
                ADPRewarded.this.k.onReward(map);
            }
            boolean unused = ADPRewarded.this.m = false;
            ADPRewarded aDPRewarded = ADPRewarded.this;
            aDPRewarded.d(aDPRewarded.h, ADPRewarded.this.i, "tencent", "3", ADPRewarded.this.s);
        }

        public void onVideoCached() {
            boolean unused = ADPRewarded.this.n = true;
            ADPRewarded aDPRewarded = ADPRewarded.this;
            aDPRewarded.b(aDPRewarded.h, ADPRewarded.this.i, "tencent", "3", ADPRewarded.this.s);
            if (!(ADPRewarded.this.r == null || ADPRewarded.this.g == null)) {
                try {
                    ADPRewarded.this.g.setDownloadConfirmListener(new a());
                } catch (Exception unused2) {
                }
            }
            if (ADPRewarded.this.k != null) {
                ADPRewarded.this.k.onADReceive();
            }
        }

        public void onVideoComplete() {
            if (ADPRewarded.this.k != null) {
                ADPRewarded.this.k.onVideoComplete();
            }
            boolean unused = ADPRewarded.this.m = false;
        }
    }

    private ADPRewarded() {
    }

    private void load() {
        if (ADP.isInitSuccess()) {
            a();
            b();
            return;
        }
        this.m = false;
        a("adsplus", new AdpError("-1", "adp sdk is not initialized"));
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
        int i2 = this.o;
        if (i2 == 1) {
            RewardVideoAD rewardVideoAD = this.g;
            if (rewardVideoAD == null || !this.n) {
                return false;
            }
            return rewardVideoAD.isValid();
        } else if (i2 == 2) {
            TTRewardVideoAd tTRewardVideoAd = this.q;
            if (tTRewardVideoAd == null || tTRewardVideoAd.getMediationManager() == null) {
                z = false;
            } else {
                z = this.q.getMediationManager().isReady();
            }
            if (this.q == null || !this.n || !z) {
                return false;
            }
            return true;
        } else if (i2 == 3) {
            if (this.u == null || !this.n) {
                return false;
            }
            return true;
        } else if (i2 != 5 || (rewardAd = this.x) == null || !rewardAd.isLoaded()) {
            return false;
        } else {
            return true;
        }
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
        int i2 = this.o;
        if (i2 == 1) {
            if (isAdValid()) {
                this.g.showAD(activity);
            }
        } else if (i2 == 2) {
            if (isAdValid()) {
                this.q.showRewardVideoAd(activity);
            }
        } else if (i2 == 3) {
            f();
        } else if (i2 != 4 && i2 == 5) {
            e();
        }
    }

    /* access modifiers changed from: private */
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
        } else if ("kuaishou".equals(this.s.getSource())) {
            d(this.s.getId());
        } else if ("gromore".equals(this.s.getSource())) {
            a(this.s.getId());
        } else if ("bytedance".equals(this.s.getSource())) {
            a(this.s.getId());
        } else if ("huawei".equals(this.s.getSource())) {
            c(this.s.getId());
        } else {
            this.m = false;
            if (this.t.size() <= 0) {
                a("kuaishou", new AdpError("-1", "no ad ads"));
            } else {
                c();
            }
        }
    }

    private void e() {
        RewardAd rewardAd = this.x;
        if (rewardAd != null && rewardAd.isLoaded()) {
            this.x.show(this.h, new e());
        }
    }

    private void f() {
        KsRewardVideoAd ksRewardVideoAd = this.u;
        if (ksRewardVideoAd != null && ksRewardVideoAd.isAdEnable()) {
            KsVideoPlayConfig build = new KsVideoPlayConfig.Builder().videoSoundEnable(this.w).showLandscape(this.h.getRequestedOrientation() == 0).build();
            this.u.setRewardAdInteractionListener(new b());
            this.u.showRewardVideoAd(this.h, build);
        }
    }

    private void b() {
        int i2 = 0;
        if (this.l == null) {
            AdInfo adInfo = a.b;
            if (adInfo == null || adInfo.getAdUnits() == null || adInfo.getAdUnits().size() <= 0 || !"0".equals(adInfo.getStatus())) {
                a("adsplus", new AdpError("B002", this.h.getString(R.string.B002)));
                this.m = false;
                return;
            }
            for (AdItem next : adInfo.getAdUnits()) {
                if (ExploreConstants.SCENE_REWARD.equals(next.getType()) && this.i.equals(next.getAdUnitId())) {
                    this.l = next;
                }
            }
        }
        AdItem adItem = this.l;
        if (adItem == null) {
            a("adsplus", new AdpError("B003", this.h.getString(R.string.B003)));
            this.m = false;
        } else if (!adItem.isEnable()) {
            a("adsplus", new AdpError("B004", this.h.getString(R.string.B004)));
            this.m = false;
        } else {
            String b2 = a.b(this.l, (Context) this.h);
            if (b2 != null) {
                a("adsplus", new AdpError("C001", b2));
            } else if (this.l.getAdSource() == null || this.l.getAdSource().isEmpty()) {
                a("adsplus", new AdpError("B003", this.h.getString(R.string.B003)));
            } else {
                try {
                    this.v = this.l.isOpenLogs();
                } catch (Exception unused) {
                }
                int parseInt = Integer.parseInt(new com.adp.sdk.utils.d(this.h).b("rewarded_index", "0"));
                if (!b.a(this.l, parseInt)) {
                    i2 = parseInt;
                }
                SourceVO a2 = b.a(this.l, i2, this.h);
                this.s = a2;
                if (a2 == null) {
                    a("adsplus", new AdpError("B003", this.h.getString(R.string.B003)));
                    return;
                }
                this.t = b.a(this.l, a2);
                d();
                f((i2 + 1) + "");
            }
        }
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

    /* access modifiers changed from: private */
    public void a(String str, AdpError adpError) {
        ADPRewardedListener aDPRewardedListener = this.k;
        if (aDPRewardedListener != null) {
            aDPRewardedListener.onADError(adpError);
        }
        String str2 = str + xoXoI.f16453oxoX + adpError.getCode() + xoXoI.f16453oxoX + adpError.getMessage();
        if (this.v) {
            c.a().a((Context) this.h, this.i, str2, "3", this.s);
        }
        this.m = false;
    }

    private void c(String str) {
        try {
            this.o = 5;
            this.n = false;
            this.j = str;
            if (!h.a()) {
                h.a((Context) this.h);
            }
            c(this.h, this.i, "huawei", "3", this.s);
            this.x = new RewardAd(this.h, str);
            d dVar = new d();
            AdParam a2 = h.a(5000);
            VideoConfiguration.Builder builder = new VideoConfiguration.Builder();
            builder.setStartMuted(!this.w);
            this.x.setVideoConfiguration(builder.build());
            this.x.loadAd(a2, (RewardAdLoadListener) dVar);
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
        if (activity == null || activity.isFinishing() || !ADP.isInitSuccess()) {
            a("adsplus", new AdpError("-1", "ad is not init"));
        } else if (!f.a()) {
            f.a(this.h, new f(str));
        } else {
            b(str);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:6|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        a("adsplus", new com.adp.sdk.dto.AdpError("-1", "adid NumberFormatException"));
        r4 = 0;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x000f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d(java.lang.String r13) {
        /*
            r12 = this;
            java.lang.String r0 = "-1"
            java.lang.String r1 = "adsplus"
            r2 = 3
            r3 = 0
            r12.o = r2     // Catch:{ Exception -> 0x000d }
            long r4 = java.lang.Long.parseLong(r13)     // Catch:{ NumberFormatException -> 0x000f }
            goto L_0x001b
        L_0x000d:
            r13 = move-exception
            goto L_0x0050
        L_0x000f:
            com.adp.sdk.dto.AdpError r13 = new com.adp.sdk.dto.AdpError     // Catch:{ Exception -> 0x000d }
            java.lang.String r2 = "adid NumberFormatException"
            r13.<init>(r0, r2)     // Catch:{ Exception -> 0x000d }
            r12.a((java.lang.String) r1, (com.adp.sdk.dto.AdpError) r13)     // Catch:{ Exception -> 0x000d }
            r4 = 0
        L_0x001b:
            r12.m = r3     // Catch:{ Exception -> 0x000d }
            r12.n = r3     // Catch:{ Exception -> 0x000d }
            android.app.Activity r7 = r12.h     // Catch:{ Exception -> 0x000d }
            java.lang.String r8 = r12.i     // Catch:{ Exception -> 0x000d }
            java.lang.String r9 = "kuaishou"
            java.lang.String r10 = "3"
            com.adp.sdk.dto.SourceVO r11 = r12.s     // Catch:{ Exception -> 0x000d }
            r6 = r12
            r6.c(r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x000d }
            r13 = 0
            r12.u = r13     // Catch:{ Exception -> 0x000d }
            com.kwad.sdk.api.KsScene$Builder r13 = new com.kwad.sdk.api.KsScene$Builder     // Catch:{ Exception -> 0x000d }
            r13.<init>(r4)     // Catch:{ Exception -> 0x000d }
            java.lang.String r2 = "ksad://returnback"
            com.kwad.sdk.api.KsScene$Builder r13 = r13.setBackUrl(r2)     // Catch:{ Exception -> 0x000d }
            com.kwad.sdk.api.KsScene$Builder r13 = r13.screenOrientation(r3)     // Catch:{ Exception -> 0x000d }
            com.kwad.sdk.api.KsScene r13 = r13.build()     // Catch:{ Exception -> 0x000d }
            com.kwad.sdk.api.KsLoadManager r2 = com.kwad.sdk.api.KsAdSDK.getLoadManager()     // Catch:{ Exception -> 0x000d }
            com.adp.sdk.ADPRewarded$a r4 = new com.adp.sdk.ADPRewarded$a     // Catch:{ Exception -> 0x000d }
            r4.<init>()     // Catch:{ Exception -> 0x000d }
            r2.loadRewardVideoAd(r13, r4)     // Catch:{ Exception -> 0x000d }
            goto L_0x007b
        L_0x0050:
            r12.m = r3
            java.util.ArrayList<com.adp.sdk.dto.SourceVO> r2 = r12.t
            int r2 = r2.size()
            if (r2 > 0) goto L_0x0078
            com.adp.sdk.dto.AdpError r2 = new com.adp.sdk.dto.AdpError
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = ""
            r3.append(r4)
            java.lang.String r13 = r13.getMessage()
            r3.append(r13)
            java.lang.String r13 = r3.toString()
            r2.<init>(r0, r13)
            r12.a((java.lang.String) r1, (com.adp.sdk.dto.AdpError) r2)
            return
        L_0x0078:
            r12.c()
        L_0x007b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adp.sdk.ADPRewarded.d(java.lang.String):void");
    }

    /* access modifiers changed from: private */
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
