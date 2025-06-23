package com.huawei.hms.ads.reward;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.BiddingInfo;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.cd;
import com.huawei.hms.ads.k;
import com.huawei.hms.ads.utils.c;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.data.RewardItem;
import com.huawei.openalliance.ad.inter.data.i;
import com.huawei.openalliance.ad.inter.data.q;
import com.huawei.openalliance.ad.inter.listeners.g;
import com.huawei.openalliance.ad.inter.listeners.h;
import com.huawei.openalliance.ad.inter.p;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.n;
import java.util.List;
import java.util.Map;

@GlobalApi
/* loaded from: classes10.dex */
public class RewardAd {
    private Reward B;
    private RewardVerifyConfig C;
    private OnMetadataChangedListener Code;
    private p D;
    private q F;
    private VideoConfiguration S;
    private Context V;
    private String Z;

    /* renamed from: a, reason: collision with root package name */
    private RewardAdListener f17323a;
    private String b;
    private String c;
    private int e;
    private boolean I = false;
    private Bundle L = new Bundle();
    private boolean d = false;
    private boolean f = true;

    /* loaded from: classes10.dex */
    public class a implements com.huawei.openalliance.ad.inter.listeners.q {
        private RewardAdListener I;
        private RewardAdLoadListener V;

        public a(RewardAdLoadListener rewardAdLoadListener, RewardAdListener rewardAdListener) {
            this.V = rewardAdLoadListener;
            this.I = rewardAdListener;
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.q
        public void Code(int i) {
            RewardAd.this.I = false;
            RewardAdLoadListener rewardAdLoadListener = this.V;
            if (rewardAdLoadListener != null) {
                rewardAdLoadListener.onRewardAdFailedToLoad(com.huawei.hms.ads.utils.b.Code(i));
            }
            RewardAdListener rewardAdListener = this.I;
            if (rewardAdListener != null) {
                rewardAdListener.onRewardAdFailedToLoad(com.huawei.hms.ads.utils.b.Code(i));
            }
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.q
        public void Code(Map<String, List<i>> map) {
            RewardAdListener rewardAdListener;
            RewardAd.this.I = true;
            List<i> list = map.get(RewardAd.this.Z);
            if (ad.Code(list)) {
                RewardAdLoadListener rewardAdLoadListener = this.V;
                if (rewardAdLoadListener != null) {
                    rewardAdLoadListener.onRewardAdFailedToLoad(3);
                }
                rewardAdListener = this.I;
                if (rewardAdListener == null) {
                    return;
                }
            } else {
                i iVar = list.get(0);
                if (iVar instanceof q) {
                    RewardAd.this.F = (q) iVar;
                    RewardAd.this.F.a_(RewardAd.this.f);
                    RewardAd rewardAd = RewardAd.this;
                    rewardAd.B = new cd(rewardAd.F.C());
                    RewardAdLoadListener rewardAdLoadListener2 = this.V;
                    if (rewardAdLoadListener2 != null) {
                        rewardAdLoadListener2.onRewardedLoaded();
                    }
                    RewardAdListener rewardAdListener2 = this.I;
                    if (rewardAdListener2 != null) {
                        rewardAdListener2.onRewardAdLoaded();
                    }
                    if (RewardAd.this.Code != null) {
                        RewardAd.this.Code.onMetadataChanged();
                        return;
                    }
                    return;
                }
                RewardAdLoadListener rewardAdLoadListener3 = this.V;
                if (rewardAdLoadListener3 != null) {
                    rewardAdLoadListener3.onRewardAdFailedToLoad(3);
                }
                rewardAdListener = this.I;
                if (rewardAdListener == null) {
                    return;
                }
            }
            rewardAdListener.onRewardAdFailedToLoad(3);
        }
    }

    /* loaded from: classes10.dex */
    public class b implements g, h {
        private RewardAdListener I;
        private RewardAdStatusListener V;

        public b(RewardAdStatusListener rewardAdStatusListener, RewardAdListener rewardAdListener) {
            this.V = rewardAdStatusListener;
            this.I = rewardAdListener;
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.g
        public void B() {
            RewardItem C = RewardAd.this.F.C();
            RewardAdStatusListener rewardAdStatusListener = this.V;
            if (rewardAdStatusListener != null) {
                rewardAdStatusListener.onRewarded(C != null ? new cd(C) : Reward.DEFAULT);
            }
            RewardAdListener rewardAdListener = this.I;
            if (rewardAdListener != null) {
                rewardAdListener.onRewarded(new cd(C));
            }
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.h
        public void C() {
            RewardAdListener rewardAdListener = this.I;
            if (rewardAdListener != null) {
                rewardAdListener.onRewardAdStarted();
            }
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.g
        public void Code() {
            RewardAdStatusListener rewardAdStatusListener = this.V;
            if (rewardAdStatusListener != null) {
                rewardAdStatusListener.onRewardAdOpened();
            }
            RewardAdListener rewardAdListener = this.I;
            if (rewardAdListener != null) {
                rewardAdListener.onRewardAdOpened();
            }
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.g
        public void I() {
            RewardAdListener rewardAdListener = this.I;
            if (rewardAdListener != null) {
                rewardAdListener.onRewardAdCompleted();
            }
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.h
        public void S() {
            RewardAdListener rewardAdListener = this.I;
            if (rewardAdListener != null) {
                rewardAdListener.onRewardAdLeftApp();
            }
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.g
        public void V() {
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.g
        public void Z() {
            RewardAdStatusListener rewardAdStatusListener = this.V;
            if (rewardAdStatusListener != null) {
                rewardAdStatusListener.onRewardAdClosed();
            }
            RewardAdListener rewardAdListener = this.I;
            if (rewardAdListener != null) {
                rewardAdListener.onRewardAdClosed();
            }
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.g
        public void Code(int i, int i2) {
            RewardAdStatusListener rewardAdStatusListener = this.V;
            if (rewardAdStatusListener != null) {
                rewardAdStatusListener.onRewardAdFailedToShow(0);
            }
        }
    }

    private RewardAd(Context context) {
        if (context != null) {
            this.V = context.getApplicationContext();
        }
    }

    @GlobalApi
    public static RewardAd createRewardAdInstance(Context context) {
        return new RewardAd(context);
    }

    @GlobalApi
    public void destroy() {
    }

    @GlobalApi
    public BiddingInfo getBiddingInfo() {
        q qVar = this.F;
        if (qVar != null) {
            return qVar.ae();
        }
        return null;
    }

    @GlobalApi
    public String getData() {
        return this.b;
    }

    @GlobalApi
    public Bundle getMetadata() {
        return this.L;
    }

    @GlobalApi
    public Reward getReward() {
        return this.B;
    }

    @GlobalApi
    public RewardAdListener getRewardAdListener() {
        return this.f17323a;
    }

    @GlobalApi
    public String getUserId() {
        return this.c;
    }

    @GlobalApi
    public boolean isLoaded() {
        return this.I;
    }

    @GlobalApi
    public void loadAd(AdParam adParam, RewardAdLoadListener rewardAdLoadListener) {
        k.Code().Code(this.V);
        Code();
        Code(adParam);
        this.D.Code(new a(rewardAdLoadListener, null));
        this.D.Code(this.e, false);
    }

    @GlobalApi
    public void pause() {
    }

    @GlobalApi
    public void resume() {
    }

    @GlobalApi
    public void setData(String str) {
        this.b = str;
    }

    @GlobalApi
    public void setImmersive(boolean z) {
        this.d = z;
    }

    @GlobalApi
    public void setMobileDataAlertSwitch(boolean z) {
        this.f = z;
    }

    @GlobalApi
    public void setOnMetadataChangedListener(OnMetadataChangedListener onMetadataChangedListener) {
        this.Code = onMetadataChangedListener;
    }

    @GlobalApi
    public void setRewardAdListener(RewardAdListener rewardAdListener) {
        this.f17323a = rewardAdListener;
    }

    @GlobalApi
    public void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig) {
        this.C = rewardVerifyConfig;
    }

    @GlobalApi
    public void setUserId(String str) {
        this.c = str;
    }

    @GlobalApi
    public void setVideoConfiguration(VideoConfiguration videoConfiguration) {
        this.S = videoConfiguration;
    }

    @GlobalApi
    @Deprecated
    public void show() {
        Code(this.V);
    }

    @GlobalApi
    public RewardAd(Context context, String str) {
        this.Z = str;
        this.V = context.getApplicationContext();
        this.D = new p(context, TextUtils.isEmpty(str) ? null : new String[]{str});
        this.e = n.I(context);
    }

    @GlobalApi
    public void destroy(Context context) {
    }

    @GlobalApi
    public void loadAd(String str, AdParam adParam) {
        this.Z = str;
        k.Code().Code(this.V);
        Code();
        p pVar = new p(this.V, TextUtils.isEmpty(str) ? null : new String[]{str});
        this.D = pVar;
        pVar.Code(new a(null, this.f17323a));
        Code(adParam);
        this.D.Code(this.e, false);
    }

    @GlobalApi
    public void pause(Context context) {
    }

    @GlobalApi
    public void resume(Context context) {
    }

    @GlobalApi
    public void show(Activity activity) {
        Code(activity);
    }

    @GlobalApi
    public void show(Activity activity, RewardAdStatusListener rewardAdStatusListener) {
        show(activity, rewardAdStatusListener, true);
    }

    private void Code() {
        this.I = false;
        this.F = null;
    }

    @GlobalApi
    public void show(Activity activity, RewardAdStatusListener rewardAdStatusListener, boolean z) {
        int i;
        q qVar = this.F;
        if (qVar == null) {
            i = 2;
        } else {
            if (!qVar.B()) {
                RewardVerifyConfig rewardVerifyConfig = this.C;
                if (rewardVerifyConfig != null) {
                    this.F.Code(rewardVerifyConfig);
                    this.F.V(this.C.getUserId());
                    this.F.Code(this.C.getData());
                }
                b bVar = new b(rewardAdStatusListener, null);
                this.F.Code((h) bVar);
                this.F.Code(this.S);
                this.F.Code(activity, (g) bVar);
                return;
            }
            i = 1;
        }
        Code(rewardAdStatusListener, i);
    }

    private void Code(Context context) {
        q qVar;
        if (!this.I || (qVar = this.F) == null) {
            return;
        }
        qVar.V(this.c);
        this.F.Code(this.b);
        this.F.Code(this.S);
        b bVar = new b(null, this.f17323a);
        this.F.Code((h) bVar);
        this.F.Code(context, bVar);
    }

    private void Code(AdParam adParam) {
        if (adParam == null || this.D == null) {
            return;
        }
        this.D.Code(c.Code(adParam.V()));
        this.D.Code(adParam.getKeywords());
        this.D.Code(adParam.getGender());
        this.D.V(adParam.getTargetingContentUrl());
        this.D.I(adParam.I());
        this.D.Code(adParam.C());
        this.D.Code(adParam.Code());
        HiAd.getInstance(this.V).setCountryCode(adParam.Z());
    }

    private void Code(RewardAdStatusListener rewardAdStatusListener, int i) {
        if (rewardAdStatusListener != null) {
            rewardAdStatusListener.onRewardAdFailedToShow(i);
        }
    }
}
