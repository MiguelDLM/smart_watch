package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.huawei.hms.ads.banner.BannerView;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.listeners.d;
import com.huawei.openalliance.ad.views.PPSBannerView;

/* loaded from: classes10.dex */
public class l implements r, d, com.huawei.openalliance.ad.inter.listeners.o {
    private static final String Code = "l";
    private Context B;
    private BannerAdSize I;
    private AdListener V;
    private PPSBannerView Z;

    public l(Context context, PPSBannerView pPSBannerView) {
        this.B = context;
        this.Z = pPSBannerView;
    }

    @Override // com.huawei.hms.ads.r
    public BannerAdSize B() {
        return this.I;
    }

    @Override // com.huawei.hms.ads.r
    public String C() {
        return this.Z.getAdId();
    }

    @Override // com.huawei.hms.ads.r
    public void Code() {
        this.Z.V();
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.d
    public void D() {
        AdListener adListener = this.V;
        if (adListener != null) {
            adListener.onAdLoaded();
        }
    }

    @Override // com.huawei.hms.ads.r
    public boolean F() {
        return this.Z.C();
    }

    @Override // com.huawei.hms.ads.r
    public void I() {
        this.Z.Z();
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.o
    public void L() {
        AdListener adListener = this.V;
        if (adListener != null) {
            adListener.onAdClicked();
        }
    }

    @Override // com.huawei.hms.ads.r
    public AdListener S() {
        return this.V;
    }

    @Override // com.huawei.hms.ads.r
    public void V() {
        this.Z.I();
    }

    @Override // com.huawei.hms.ads.r
    public BiddingInfo Z() {
        return this.Z.getBiddingInfo();
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.o
    public void a() {
        AdListener adListener = this.V;
        if (adListener != null) {
            adListener.onAdOpened();
        }
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.o
    public void b() {
        AdListener adListener = this.V;
        if (adListener != null) {
            adListener.onAdLeave();
        }
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.d, com.huawei.openalliance.ad.inter.listeners.o
    public void c() {
        AdListener adListener = this.V;
        if (adListener != null) {
            adListener.onAdClosed();
        }
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.o
    public void d() {
        AdListener adListener = this.V;
        if (adListener != null) {
            adListener.onAdImpression();
        }
    }

    private void I(BannerAdSize bannerAdSize) {
        int widthPx = bannerAdSize.getWidthPx(this.B);
        int heightPx = bannerAdSize.getHeightPx(this.B);
        int V = bannerAdSize.V(this.B);
        int Code2 = bannerAdSize.Code(this.B);
        fb.Code(Code, "set advanced size width: %s height: %s reqW %s reqH %s", Integer.valueOf(widthPx), Integer.valueOf(heightPx), Integer.valueOf(V), Integer.valueOf(Code2));
        if (widthPx <= 0 || heightPx <= 0 || V <= 0 || Code2 <= 0) {
            this.Z.setBannerSize(com.huawei.openalliance.ad.inter.data.b.B);
        } else {
            this.Z.setBannerSize(new com.huawei.openalliance.ad.inter.data.b(widthPx, heightPx, V, Code2));
        }
    }

    private void V(int i) {
        AdListener adListener = this.V;
        if (adListener != null) {
            adListener.onAdFailed(i);
        }
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.d
    public void Code(int i) {
        V(com.huawei.hms.ads.utils.b.Code(i));
    }

    private void V(AdParam adParam) {
        PPSBannerView pPSBannerView;
        if (adParam == null || (pPSBannerView = this.Z) == null) {
            return;
        }
        pPSBannerView.setRequestOptions(adParam.V());
        this.Z.setLocation(adParam.Code());
        this.Z.setContentBundle(adParam.C());
        HiAd.getInstance(this.B).setCountryCode(adParam.Z());
        this.Z.setTargetingInfo(new com.huawei.openalliance.ad.inter.data.r(adParam.getKeywords(), adParam.getGender(), adParam.getTargetingContentUrl(), adParam.I()));
    }

    @Override // com.huawei.hms.ads.r
    public void Code(long j) {
        this.Z.setBannerRefresh(j);
    }

    private void V(BannerAdSize bannerAdSize) {
        this.Z.setBannerSize(new com.huawei.openalliance.ad.inter.data.b(bannerAdSize.getWidthPx(this.B), bannerAdSize.getHeightPx(this.B)));
    }

    @Override // com.huawei.hms.ads.r
    public void Code(AdListener adListener) {
        this.V = adListener;
        this.Z.setAdListener(this);
        this.Z.setOnBannerAdStatusTrackingListener(this);
    }

    @Override // com.huawei.hms.ads.r
    public void Code(AdParam adParam) {
        String str = Code;
        fb.V(str, "load banner ");
        if (BannerAdSize.BANNER_SIZE_INVALID.equals(this.I)) {
            fb.Code(str, "invalid ad size");
            V(1);
        } else if (TextUtils.isEmpty(this.Z.getAdId())) {
            V(1);
            fb.V(str, " ad id is empty.");
        } else {
            k.Code().Code(this.B);
            V(adParam);
            this.Z.Code();
        }
    }

    @Override // com.huawei.hms.ads.r
    public void V(String str) {
        this.Z.setContentBundle(str);
    }

    @Override // com.huawei.hms.ads.r
    public void Code(BannerAdSize bannerAdSize) {
        PPSBannerView pPSBannerView;
        Integer num;
        if (bannerAdSize == null) {
            fb.I(Code, "invalid para.");
            return;
        }
        fb.V(Code, "setBannerAdSize width: %s  height: %s", Integer.valueOf(bannerAdSize.getWidth()), Integer.valueOf(bannerAdSize.getHeight()));
        this.I = bannerAdSize;
        if (BannerAdSize.BANNER_SIZE_DYNAMIC.equals(bannerAdSize) || BannerAdSize.BANNER_SIZE_SMART.equals(bannerAdSize)) {
            V(BannerAdSize.BANNER_SIZE_SMART);
            pPSBannerView = this.Z;
            num = com.huawei.openalliance.ad.constant.x.aP;
        } else {
            BannerAdSize bannerAdSize2 = BannerAdSize.BANNER_SIZE_INVALID;
            if (bannerAdSize2.equals(bannerAdSize)) {
                this.I = bannerAdSize2;
                return;
            } else {
                I(bannerAdSize);
                pPSBannerView = this.Z;
                num = com.huawei.openalliance.ad.constant.x.aQ;
            }
        }
        pPSBannerView.setIsSmart(num);
    }

    @Override // com.huawei.hms.ads.r
    public void Code(BannerView bannerView) {
        ViewGroup.LayoutParams layoutParams;
        if (bannerView == null || !AdSize.AD_SIZE_SMART.equals(this.I) || (layoutParams = bannerView.getLayoutParams()) == null) {
            return;
        }
        String str = Code;
        fb.Code(str, "layoutParams width: %s height: ", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
        if (layoutParams.width >= 0 || layoutParams.height >= 0) {
            fb.I(str, "Smart banner is not suitable for fixed AdView.");
            this.Z.setAdContainerSizeMatched(false);
        }
    }

    @Override // com.huawei.hms.ads.r
    public void Code(RewardVerifyConfig rewardVerifyConfig) {
        this.Z.setRewardVerifyConfig(rewardVerifyConfig);
    }

    @Override // com.huawei.hms.ads.r
    public void Code(String str) {
        this.Z.setAdId(str);
    }
}
