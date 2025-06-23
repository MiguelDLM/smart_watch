package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.inter.data.IInterstitialAd;
import com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener;
import com.huawei.hms.ads.reward.OnMetadataChangedListener;
import com.huawei.hms.ads.reward.RewardAdListener;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.openalliance.ad.beans.inner.BaseAdReqParam;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.constant.bn;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.listeners.INonwifiActionListener;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes10.dex */
public class aa {
    private String B;
    private OnMetadataChangedListener C;
    private Bundle D;
    private Context I;
    private String L;
    private RewardAdListener S;
    private AdListener Z;

    /* renamed from: a, reason: collision with root package name */
    private long f17251a;
    private long b;
    private long c;
    private App d;
    private RewardVerifyConfig g;
    private VideoConfiguration h;
    private com.huawei.openalliance.ad.inter.listeners.i i;
    private Integer j;
    private BiddingInfo k;
    private b V = b.IDLE;
    private List<IInterstitialAd> e = new ArrayList();
    private IInterstitialAd f = null;
    private IInterstitialAdStatusListener l = new c(this);
    private INonwifiActionListener m = new INonwifiActionListener() { // from class: com.huawei.hms.ads.aa.1
        @Override // com.huawei.openalliance.ad.inter.listeners.INonwifiActionListener
        public boolean Code(long j) {
            return false;
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.INonwifiActionListener
        public boolean Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo, long j) {
            return false;
        }
    };

    /* loaded from: classes10.dex */
    public static class a implements Comparator<IInterstitialAd> {
        @Override // java.util.Comparator
        /* renamed from: Code, reason: merged with bridge method [inline-methods] */
        public int compare(IInterstitialAd iInterstitialAd, IInterstitialAd iInterstitialAd2) {
            if (Code(iInterstitialAd.ae()) && !Code(iInterstitialAd2.ae())) {
                return -1;
            }
            if (Code(iInterstitialAd.ae()) && Code(iInterstitialAd2.ae())) {
                return (iInterstitialAd.ae().getPrice().floatValue() <= 0.0f || Float.compare(iInterstitialAd.ae().getPrice().floatValue(), iInterstitialAd2.ae().getPrice().floatValue()) >= 0) ? -1 : 1;
            }
            return 1;
        }

        private boolean Code(BiddingInfo biddingInfo) {
            return (biddingInfo == null || biddingInfo.getPrice() == null) ? false : true;
        }
    }

    /* loaded from: classes10.dex */
    public enum b {
        IDLE,
        LOADING
    }

    /* loaded from: classes10.dex */
    public static class c implements IInterstitialAdStatusListener {
        private WeakReference<aa> Code;

        public c(aa aaVar) {
            this.Code = new WeakReference<>(aaVar);
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdClicked() {
            aa aaVar = this.Code.get();
            if (aaVar == null || aaVar.Z == null) {
                return;
            }
            aaVar.Z.onAdClicked();
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdClosed() {
            aa aaVar = this.Code.get();
            if (aaVar != null) {
                if (aaVar.Z != null) {
                    aaVar.Z.onAdClosed();
                }
                if (aaVar.S != null) {
                    aaVar.S.onRewardAdClosed();
                }
            }
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdCompleted() {
            aa aaVar = this.Code.get();
            if (aaVar == null || aaVar.S == null) {
                return;
            }
            aaVar.S.onRewardAdCompleted();
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdError(int i, int i2) {
            aa aaVar = this.Code.get();
            if (aaVar != null) {
                if (aaVar.Z != null) {
                    aaVar.Z.onAdFailed(com.huawei.hms.ads.utils.b.Code(i));
                }
                if (aaVar.S != null) {
                    aaVar.S.onRewardAdFailedToLoad(com.huawei.hms.ads.utils.b.Code(i));
                }
            }
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdShown() {
            aa aaVar = this.Code.get();
            if (aaVar != null) {
                if (aaVar.Z != null) {
                    aaVar.Z.onAdOpened();
                }
                if (aaVar.S != null) {
                    aaVar.S.onRewardAdOpened();
                }
            }
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onLeftApp() {
            aa aaVar = this.Code.get();
            if (aaVar != null) {
                if (aaVar.Z != null) {
                    aaVar.Z.onAdLeave();
                }
                if (aaVar.S != null) {
                    aaVar.S.onRewardAdLeftApp();
                }
            }
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onRewarded() {
            aa aaVar = this.Code.get();
            if (aaVar == null || aaVar.S == null) {
                return;
            }
            aaVar.S.onRewarded(new cd(aaVar.f.C()));
        }
    }

    public aa(Context context) {
        this.I = context;
    }

    private boolean L() {
        if (!com.huawei.openalliance.ad.utils.w.Code(this.I)) {
            AdListener adListener = this.Z;
            if (adListener != null) {
                adListener.onAdFailed(5);
            }
            RewardAdListener rewardAdListener = this.S;
            if (rewardAdListener != null) {
                rewardAdListener.onRewardAdFailedToLoad(5);
            }
            return false;
        }
        if (this.V == b.LOADING) {
            fb.V("InterstitialAdManager", "waiting for request finish");
            AdListener adListener2 = this.Z;
            if (adListener2 != null) {
                adListener2.onAdFailed(4);
            }
            RewardAdListener rewardAdListener2 = this.S;
            if (rewardAdListener2 != null) {
                rewardAdListener2.onRewardAdFailedToLoad(4);
            }
            return false;
        }
        if (!TextUtils.isEmpty(this.B)) {
            return true;
        }
        fb.I("InterstitialAdManager", "empty ad ids");
        AdListener adListener3 = this.Z;
        if (adListener3 != null) {
            adListener3.onAdFailed(1);
        }
        RewardAdListener rewardAdListener3 = this.S;
        if (rewardAdListener3 != null) {
            rewardAdListener3.onRewardAdFailedToLoad(1);
        }
        return false;
    }

    public final AdListener Code() {
        return this.Z;
    }

    public BiddingInfo D() {
        return this.k;
    }

    public final void F() {
        fb.V("InterstitialAdManager", bn.b.V);
        Code(this.I);
    }

    public final boolean I() {
        if (com.huawei.openalliance.ad.utils.ad.Code(this.e)) {
            return false;
        }
        for (IInterstitialAd iInterstitialAd : this.e) {
            if (iInterstitialAd != null && !iInterstitialAd.B()) {
                Code(iInterstitialAd.ae());
                return true;
            }
        }
        return false;
    }

    public final Bundle S() {
        Bundle bundle = this.D;
        return bundle == null ? new Bundle() : bundle;
    }

    public final boolean Z() {
        return this.V == b.LOADING;
    }

    public final String V() {
        return this.B;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(Map<String, List<IInterstitialAd>> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        for (List<IInterstitialAd> list : map.values()) {
            if (!com.huawei.openalliance.ad.utils.ad.Code(list)) {
                for (IInterstitialAd iInterstitialAd : list) {
                    if (iInterstitialAd.h() || !iInterstitialAd.V()) {
                        fb.V("InterstitialAdManager", "ad is invalid, content id:" + iInterstitialAd.a());
                    } else {
                        this.e.add(iInterstitialAd);
                    }
                }
            }
        }
        Collections.sort(this.e, new a());
        OnMetadataChangedListener onMetadataChangedListener = this.C;
        if (onMetadataChangedListener != null) {
            onMetadataChangedListener.onMetadataChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(final int i) {
        fb.V("InterstitialAdManager", "onAdFailed, errorCode:" + i);
        com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.aa.3
            @Override // java.lang.Runnable
            public void run() {
                aa.this.b = System.currentTimeMillis();
                if (aa.this.Z != null) {
                    aa.this.Z.onAdFailed(com.huawei.hms.ads.utils.b.Code(i));
                }
                if (aa.this.i != null) {
                    aa.this.i.Code(i);
                }
                if (aa.this.S != null) {
                    aa.this.S.onRewardAdFailedToLoad(com.huawei.hms.ads.utils.b.Code(i));
                }
                cy.Code(aa.this.I, i, aa.this.L, 12, null, aa.this.f17251a, aa.this.b, aa.this.c);
            }
        });
    }

    public final void Code(Activity activity) {
        fb.V("InterstitialAdManager", "show activity");
        Code((Context) activity);
    }

    private void Code(Context context) {
        for (IInterstitialAd iInterstitialAd : this.e) {
            if (iInterstitialAd != null && !iInterstitialAd.B()) {
                this.f = iInterstitialAd;
                VideoConfiguration videoConfiguration = this.h;
                if (videoConfiguration != null) {
                    iInterstitialAd.setVideoConfiguration(videoConfiguration);
                }
                iInterstitialAd.Code(this.g);
                iInterstitialAd.setRewardAdListener(this.S);
                iInterstitialAd.setNonwifiActionListener(this.m);
                iInterstitialAd.show(context, this.l);
                return;
            }
        }
    }

    public final void Code(AdListener adListener) {
        this.Z = adListener;
    }

    public final void Code(AdParam adParam) {
        this.f17251a = System.currentTimeMillis();
        fb.V("InterstitialAdManager", com.huawei.openalliance.ad.constant.h.Code);
        if (L()) {
            AdSlotParam.a aVar = new AdSlotParam.a();
            Code(adParam, aVar);
            if (this.d != null && !com.huawei.openalliance.ad.utils.w.I(this.I)) {
                fb.I("InterstitialAdManager", "hms ver not support set appInfo.");
                Code(706);
                return;
            }
            com.huawei.openalliance.ad.utils.af.Code(this.I.getApplicationContext(), aVar.V());
            this.V = b.LOADING;
            this.e.clear();
            BaseAdReqParam baseAdReqParam = new BaseAdReqParam();
            baseAdReqParam.Code(this.f17251a);
            iy.Code(this.I, "interstitial_ad_load", aVar.S(), com.huawei.openalliance.ad.utils.aa.V(baseAdReqParam), new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.aa.2
                @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                public void onRemoteCallResult(String str, CallResult<String> callResult) {
                    aa aaVar;
                    int code;
                    aa.this.c = System.currentTimeMillis();
                    if (callResult.getCode() == 200) {
                        Map<String, List<AdContentData>> map = (Map) com.huawei.openalliance.ad.utils.aa.V(callResult.getData(), Map.class, List.class, AdContentData.class);
                        if (aa.this.i != null) {
                            aa.this.i.Code(map);
                        }
                        code = 204;
                        if (map != null && map.size() > 0) {
                            HashMap hashMap = new HashMap(map.size());
                            for (Map.Entry<String, List<AdContentData>> entry : map.entrySet()) {
                                String key = entry.getKey();
                                List<AdContentData> value = entry.getValue();
                                if (value != null) {
                                    ArrayList arrayList = new ArrayList(value.size());
                                    for (AdContentData adContentData : value) {
                                        if (aa.this.L == null) {
                                            aa.this.L = adContentData.M();
                                        }
                                        arrayList.add(new com.huawei.hms.ads.inter.data.a(adContentData));
                                    }
                                    hashMap.put(key, arrayList);
                                }
                            }
                            if (!com.huawei.openalliance.ad.utils.ai.Code(hashMap)) {
                                aa.this.V(hashMap);
                                if (!com.huawei.openalliance.ad.utils.ad.Code(aa.this.e)) {
                                    aa.this.Code(hashMap);
                                    aa.this.V = b.IDLE;
                                }
                            }
                        }
                        aaVar = aa.this;
                    } else {
                        aaVar = aa.this;
                        code = callResult.getCode();
                    }
                    aaVar.Code(code);
                    aa.this.V = b.IDLE;
                }
            }, String.class);
        }
    }

    private void Code(AdParam adParam, AdSlotParam.a aVar) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(this.B);
        aVar.Code(arrayList).V(com.huawei.openalliance.ad.utils.n.I(this.I)).Code(this.I.getResources().getConfiguration().orientation != 1 ? 0 : 1).I(d.Z(this.I)).Z(d.B(this.I));
        Integer num = this.j;
        if (num != null) {
            aVar.S(num);
        }
        if (adParam != null) {
            RequestOptions Code = com.huawei.hms.ads.utils.c.Code(adParam.V());
            App app = Code.getApp();
            if (app != null) {
                this.d = app;
            }
            aVar.Code(Code).S(adParam.getGender()).V(adParam.getTargetingContentUrl()).Code(adParam.getKeywords()).Code(this.d).I(adParam.I()).C(adParam.C());
            if (adParam.Code() != null) {
                aVar.Code(adParam.Code());
            }
        }
    }

    public void Code(BiddingInfo biddingInfo) {
        this.k = biddingInfo;
    }

    public final void Code(VideoConfiguration videoConfiguration) {
        this.h = videoConfiguration;
    }

    public final void Code(OnMetadataChangedListener onMetadataChangedListener) {
        if (this.C != null) {
            fb.V("InterstitialAdManager", "Update ad metadata listener.");
        }
        this.C = onMetadataChangedListener;
    }

    public final void Code(RewardAdListener rewardAdListener) {
        if (this.S != null) {
            fb.V("InterstitialAdManager", "Update rewarded video listener.");
        }
        this.S = rewardAdListener;
    }

    public final void Code(RewardVerifyConfig rewardVerifyConfig) {
        this.g = rewardVerifyConfig;
    }

    public void Code(com.huawei.openalliance.ad.inter.listeners.i iVar) {
        this.i = iVar;
    }

    public void Code(Integer num) {
        this.j = num;
    }

    public final void Code(String str) {
        this.B = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(final Map<String, List<IInterstitialAd>> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("onAdsLoaded, size:");
        sb.append(map != null ? Integer.valueOf(map.size()) : null);
        fb.V("InterstitialAdManager", sb.toString());
        com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.aa.4
            @Override // java.lang.Runnable
            public void run() {
                aa.this.b = System.currentTimeMillis();
                if (aa.this.Z != null) {
                    aa.this.Z.onAdLoaded();
                }
                if (aa.this.S != null) {
                    aa.this.S.onRewardAdLoaded();
                }
                cy.Code(aa.this.I, 200, aa.this.L, 12, map, aa.this.f17251a, aa.this.b, aa.this.c);
            }
        });
    }
}
