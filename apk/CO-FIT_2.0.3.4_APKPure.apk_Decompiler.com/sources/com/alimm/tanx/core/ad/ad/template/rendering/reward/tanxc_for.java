package com.alimm.tanx.core.ad.ad.template.rendering.reward;

import android.content.Context;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd;
import com.alimm.tanx.core.ad.interaction.AdClickHandler;
import com.alimm.tanx.core.ad.interaction.AdClickInfo;
import com.alimm.tanx.core.ad.listener.ITanxInteractionListener;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.ut.AdUtConstants;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.tanxc_do;

public class tanxc_for {
    /* access modifiers changed from: private */
    public final tanxc_new tanxc_do;
    private AdClickInfo tanxc_for;
    /* access modifiers changed from: private */
    public ITanxRewardVideoAd tanxc_if;

    public tanxc_for(tanxc_new tanxc_new) {
        this.tanxc_do = tanxc_new;
        if (tanxc_new != null) {
            this.tanxc_if = tanxc_new.tanxc_if;
        }
    }

    private boolean tanxc_if(Context context) {
        ITanxRewardVideoAd iTanxRewardVideoAd;
        if (this.tanxc_do == null || (iTanxRewardVideoAd = this.tanxc_if) == null) {
            return false;
        }
        iTanxRewardVideoAd.bindRewardVideoAdView(new TanxAdView(context), new ITanxInteractionListener<ITanxRewardVideoAd>() {
            public /* synthetic */ void onAdClicked(TanxAdView tanxAdView, ITanxAd iTanxAd) {
                tanxc_do();
            }

            public void tanxc_do() {
                LogUtils.d("RewardNewBrowseManager", "onAdClicked");
            }

            /* renamed from: tanxc_do */
            public void onAdShow(ITanxRewardVideoAd iTanxRewardVideoAd) {
                LogUtils.d("RewardNewBrowseManager", "onAdShow");
                if (!(tanxc_for.this.tanxc_do == null || tanxc_for.this.tanxc_do.tanxc_for() == null)) {
                    tanxc_for.this.tanxc_do.tanxc_for().onAdShow(iTanxRewardVideoAd);
                }
                tanxc_for.this.tanxc_if.clickUpload();
            }
        });
        return true;
    }

    public boolean tanxc_do(Context context) {
        if (!(this.tanxc_do == null || this.tanxc_if == null)) {
            AdClickHandler adClickHandler = new AdClickHandler();
            AdClickInfo tanxc_do2 = new tanxc_do().tanxc_do(this.tanxc_if.getAdSlot(), this.tanxc_if.getBidInfo(), AdUtConstants.REWARD_NEW_BROWSE_NAVIGATE);
            this.tanxc_for = tanxc_do2;
            if (adClickHandler.handleClickAndUt(context, tanxc_do2, true, true)) {
                tanxc_if(context);
                this.tanxc_if.onResourceLoadSuccess();
                try {
                    tanxc_if.tanxc_if = new tanxc_try(this.tanxc_if.getAdSlot().getPid(), this.tanxc_if.getAdSlot().getMediaUid(), this.tanxc_if.getBidInfo().getSessionId(), this.tanxc_if.getAdSlot().getRewardParam());
                } catch (Exception e) {
                    LogUtils.e("RewardNewBrowseManager", e);
                }
                return true;
            }
        }
        return false;
    }
}
