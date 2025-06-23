package com.huawei.hms.ads.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.BannerAdSize;
import com.huawei.hms.ads.BiddingInfo;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.l;
import com.huawei.hms.ads.r;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.openalliance.ad.views.PPSBannerView;

@GlobalApi
/* loaded from: classes10.dex */
public class BannerView extends FrameLayout implements IBannerView {
    private static final String Code = "BannerView";
    private r I;
    private PPSBannerView V;

    @GlobalApi
    public BannerView(Context context) {
        super(context);
        Code(context);
    }

    private void Code(Context context) {
        this.V = new PPSBannerView(context);
        addView(this.V, new FrameLayout.LayoutParams(-2, -2));
        this.I = new l(context, this.V);
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void destroy() {
        this.V.S();
        this.I.Code();
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public String getAdId() {
        return this.I.C();
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public AdListener getAdListener() {
        return this.I.S();
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public BannerAdSize getBannerAdSize() {
        return this.I.B();
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public BiddingInfo getBiddingInfo() {
        return this.I.Z();
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public boolean isLoading() {
        return this.I.F();
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void loadAd(AdParam adParam) {
        this.I.Code(adParam);
        this.I.Code(this);
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void pause() {
        this.I.V();
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void resume() {
        this.I.I();
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void setAdId(String str) {
        this.I.Code(str);
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void setAdListener(AdListener adListener) {
        this.I.Code(adListener);
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void setBannerAdSize(BannerAdSize bannerAdSize) {
        this.I.Code(bannerAdSize);
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void setBannerRefresh(long j) {
        this.I.Code(j);
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void setContentBundle(String str) {
        this.I.V(str);
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig) {
        this.I.Code(rewardVerifyConfig);
    }

    @GlobalApi
    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code(context);
        Code(attributeSet);
    }

    private void Code(AttributeSet attributeSet) {
        String str;
        String str2;
        String str3 = Code;
        fb.Code(str3, "initDefAttr");
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BannerView);
        try {
            if (obtainStyledAttributes != null) {
                try {
                    String string = obtainStyledAttributes.getString(R.styleable.BannerView_adId);
                    if (string != null && !string.isEmpty()) {
                        this.I.Code(string);
                    }
                    String string2 = obtainStyledAttributes.getString(R.styleable.BannerView_bannerSize);
                    if (string2 != null && !string2.isEmpty()) {
                        fb.Code(str3, "AdSize:%s", string2);
                        Code(string2);
                    }
                } catch (RuntimeException e) {
                    str = Code;
                    str2 = "initDefAttr " + e.getClass().getSimpleName();
                    fb.I(str, str2);
                    obtainStyledAttributes.recycle();
                } catch (Throwable th) {
                    str = Code;
                    str2 = "initDefAttr " + th.getClass().getSimpleName();
                    fb.I(str, str2);
                    obtainStyledAttributes.recycle();
                }
                obtainStyledAttributes.recycle();
            }
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    @GlobalApi
    public BannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Code(context);
        Code(attributeSet);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:36:0x008e. Please report as an issue. */
    private void Code(String str) {
        r rVar;
        BannerAdSize bannerAdSize;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2009976458:
                if (str.equals("BANNER_SIZE_300_250")) {
                    c = 0;
                    break;
                }
                break;
            case -1952719272:
                if (str.equals("BANNER_SIZE_320_100")) {
                    c = 1;
                    break;
                }
                break;
            case -1918932275:
                if (str.equals("BANNER_SIZE_ADVANCED")) {
                    c = 2;
                    break;
                }
                break;
            case -1838202540:
                if (str.equals("BANNER_SIZE_360_144")) {
                    c = 3;
                    break;
                }
                break;
            case 681762071:
                if (str.equals("BANNER_SIZE_160_600")) {
                    c = 4;
                    break;
                }
                break;
            case 783647454:
                if (str.equals("BANNER_SIZE_SMART")) {
                    c = 5;
                    break;
                }
                break;
            case 1393317908:
                if (str.equals("BANNER_SIZE_DYNAMIC")) {
                    c = 6;
                    break;
                }
                break;
            case 1876671828:
                if (str.equals("BANNER_SIZE_320_50")) {
                    c = 7;
                    break;
                }
                break;
            case 1880365919:
                if (str.equals("BANNER_SIZE_360_57")) {
                    c = '\b';
                    break;
                }
                break;
            case 1909233422:
                if (str.equals("BANNER_SIZE_468_60")) {
                    c = '\t';
                    break;
                }
                break;
            case 1991426884:
                if (str.equals("BANNER_SIZE_728_90")) {
                    c = '\n';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                rVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_300_250;
                rVar.Code(bannerAdSize);
                return;
            case 1:
                rVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_320_100;
                rVar.Code(bannerAdSize);
                return;
            case 2:
                rVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_ADVANCED;
                rVar.Code(bannerAdSize);
                return;
            case 3:
                rVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_360_144;
                rVar.Code(bannerAdSize);
                return;
            case 4:
                rVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_160_600;
                rVar.Code(bannerAdSize);
                return;
            case 5:
                rVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_SMART;
                rVar.Code(bannerAdSize);
                return;
            case 6:
                rVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_DYNAMIC;
                rVar.Code(bannerAdSize);
                return;
            case 7:
                rVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_320_50;
                rVar.Code(bannerAdSize);
                return;
            case '\b':
                rVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_360_57;
                rVar.Code(bannerAdSize);
                return;
            case '\t':
                rVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_468_60;
                rVar.Code(bannerAdSize);
                return;
            case '\n':
                rVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_728_90;
                rVar.Code(bannerAdSize);
                return;
            default:
                return;
        }
    }
}
