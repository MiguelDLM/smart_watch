package com.huawei.hms.ads.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.iw;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.constant.h;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.af;
import com.huawei.openalliance.ad.views.PPSSplashView;
import java.util.List;

@GlobalApi
/* loaded from: classes10.dex */
public class SplashView extends PPSSplashView {
    private SplashAdDisplayListener D;
    private SplashAdLoadListener F;

    @GlobalApi
    /* loaded from: classes10.dex */
    public static abstract class SplashAdLoadListener {
        @GlobalApi
        public void onAdDismissed() {
        }

        @GlobalApi
        public void onAdFailedToLoad(int i) {
        }

        @GlobalApi
        public void onAdLoaded() {
        }
    }

    @GlobalApi
    public SplashView(Context context) {
        super(context);
    }

    private void Z() {
        Integer F;
        if (isLoading()) {
            SplashAdLoadListener splashAdLoadListener = this.F;
            if (splashAdLoadListener != null) {
                splashAdLoadListener.onAdFailedToLoad(4);
                return;
            }
            return;
        }
        iw splashPresenter = getSplashPresenter();
        if (splashPresenter.V()) {
            AdSlotParam adSlotParam = getAdSlotParam();
            if (!splashPresenter.S() || adSlotParam == null || (F = adSlotParam.F()) == null || F.intValue() != 0) {
                if (adSlotParam != null) {
                    af.Code(getContext().getApplicationContext(), adSlotParam.B());
                }
                getSplashPresenter().Code();
            } else {
                List<String> Code = adSlotParam.Code();
                splashPresenter.Code(!ad.Code(Code) ? Code.get(0) : null, 1);
                splashPresenter.F();
            }
        }
    }

    private void setAdLoadListener(SplashAdLoadListener splashAdLoadListener) {
        this.F = splashAdLoadListener;
        getSplashPresenter().Code(splashAdLoadListener);
        if (getAdMediator() != null) {
            getAdMediator().Code(splashAdLoadListener);
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView, com.huawei.hms.ads.kk
    public void Code(int i) {
        super.Code(i);
        getAdMediator().Code(this.F);
        getAdMediator().Code(this.D);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView, com.huawei.hms.ads.kw
    @GlobalApi
    public void destroyView() {
        super.destroyView();
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    @GlobalApi
    public boolean isLoaded() {
        return super.isLoaded();
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    @GlobalApi
    public boolean isLoading() {
        return super.isLoading();
    }

    @GlobalApi
    public void load(String str, int i, AdParam adParam, SplashAdLoadListener splashAdLoadListener) {
        this.C = System.currentTimeMillis();
        fb.V("SplashView", h.Code);
        setAdLoadListener(splashAdLoadListener);
        AdSlotParam.a aVar = new AdSlotParam.a();
        SplashAd.Code(getContext(), str, i, adParam, aVar);
        super.setAdSlotParam(aVar.S());
        Z();
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView, com.huawei.hms.ads.kw
    @GlobalApi
    public void pauseView() {
        super.pauseView();
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView, com.huawei.hms.ads.kw
    @GlobalApi
    public void resumeView() {
        super.resumeView();
    }

    @GlobalApi
    public void setAdDisplayListener(SplashAdDisplayListener splashAdDisplayListener) {
        this.D = splashAdDisplayListener;
        if (getAdMediator() != null) {
            getAdMediator().Code(this.D);
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    @GlobalApi
    public void setAudioFocusType(int i) {
        super.setAudioFocusType(i);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    @GlobalApi
    public void setLogo(View view) {
        super.setLogo(view);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    @GlobalApi
    public void setLogoBitmap(Bitmap bitmap) {
        super.setLogoBitmap(bitmap);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    @GlobalApi
    public void setLogoResId(int i) {
        super.setLogoResId(i);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    @GlobalApi
    public void setMediaNameResId(int i) {
        super.setMediaNameResId(i);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    @GlobalApi
    public void setMediaNameString(String str) {
        super.setMediaNameString(str);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    @GlobalApi
    public void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig) {
        super.setRewardVerifyConfig(rewardVerifyConfig);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    @GlobalApi
    public void setSloganResId(int i) {
        super.setSloganResId(i);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    @GlobalApi
    public void setSloganView(View view) {
        super.setSloganView(view);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    @GlobalApi
    public void setWideSloganResId(int i) {
        super.setWideSloganResId(i);
    }

    @GlobalApi
    public SplashView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    @GlobalApi
    public void setLogo(View view, int i) {
        super.setLogo(view, i);
    }

    @GlobalApi
    public SplashView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
