package com.alimm.tanx.core.ad.ad.template.rendering.reward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.alimm.tanx.core.ad.ad.reward.IRewardRequestListener;
import com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd;
import com.alimm.tanx.core.ad.ad.reward.model.VideoParam;
import com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd;
import com.alimm.tanx.core.ad.bean.RewardParam;
import com.alimm.tanx.core.ad.bean.RewardRequestBean;
import com.alimm.tanx.core.ad.listener.reward.TanxRewardRequest;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.core.ut.core.LifeCycleManager;
import com.alimm.tanx.core.utils.LogUtils;
import java.util.Map;

/* loaded from: classes.dex */
public class tanxc_new extends com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if<ITanxRewardVideoAd> implements ITanxRewardExpressAd {
    public VideoParam tanxc_do;
    public ITanxRewardVideoAd tanxc_if;
    private String tanxc_int;
    private ITanxRewardExpressAd.OnRewardAdListener tanxc_new;

    public tanxc_new(ITanxRewardVideoAd iTanxRewardVideoAd) {
        super(iTanxRewardVideoAd);
        this.tanxc_int = "TanxRewardExpressAd";
        this.tanxc_if = iTanxRewardVideoAd;
    }

    private void tanxc_int() {
        LifeCycleManager.getInstance().register(this.tanxc_int, new LifeCycleManager.AppVisibleCallBack() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_new.1
            @Override // com.alimm.tanx.core.ut.core.LifeCycleManager.AppVisibleCallBack
            public void appVisibleCallBack(boolean z, boolean z2) {
                int i;
                LogUtils.d(tanxc_new.this.tanxc_int, "触发前后台切换的查奖链路，nowBackground/secondUp：" + z + "/" + z2);
                if (z2) {
                    if (tanxc_new.this.getBidInfo() != null && tanxc_new.this.getBidInfo().getTemplateConf() != null && tanxc_new.this.getBidInfo().getTemplateConf().getRewardMode() == 1) {
                        if (tanxc_new.this.tanxc_new() && tanxc_if.tanxc_if != null && !TextUtils.isEmpty(tanxc_if.tanxc_if.tanxc_if)) {
                            LogUtils.d(tanxc_new.this.tanxc_int, "自动查询奖励开始：" + tanxc_if.tanxc_if.toString());
                            tanxc_new.this.tanxc_do(tanxc_if.tanxc_if.tanxc_if, tanxc_if.tanxc_if.tanxc_do, tanxc_if.tanxc_if.tanxc_int, 1, null);
                            tanxc_if.tanxc_do();
                            return;
                        }
                        return;
                    }
                    try {
                        i = tanxc_new.this.getBidInfo().getTemplateConf().getRewardMode();
                    } catch (Exception e) {
                        LogUtils.e(e);
                        i = -1;
                    }
                    LogUtils.d(tanxc_new.this.tanxc_int, "appVisibleCallBack:当前不是客户端发奖，rewardMode:" + i);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tanxc_new() {
        if (getAdSlot() != null && getAdSlot().getRewardParam() != null && getAdSlot().getRewardParam().isAutoQuerySwitch()) {
            return true;
        }
        LogUtils.d(this.tanxc_int, "自动查询奖励关闭");
        return false;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if, com.alimm.tanx.core.ad.ITanxAd
    public void destroy() {
        LifeCycleManager.getInstance().unRegister(this.tanxc_int);
        LogUtils.d("TanxRewardExpressAd", "媒体调用destroy（）");
        this.tanxc_new = null;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if, com.alimm.tanx.core.ad.ITanxAd
    public String getScene() {
        return "rewardVideo";
    }

    @Override // com.alimm.tanx.core.ad.listener.INewTanxExpressAd
    public void refresh() {
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd
    public void setOnRewardAdListener(ITanxRewardExpressAd.OnRewardAdListener onRewardAdListener) {
        this.tanxc_new = onRewardAdListener;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd
    public void showAd(Activity activity) {
        showAd(activity, new VideoParam());
    }

    public TanxAdView tanxc_do() {
        return null;
    }

    @Override // com.alimm.tanx.core.ad.listener.INewTanxExpressAd
    /* renamed from: tanxc_if, reason: merged with bridge method [inline-methods] */
    public TanxAdView getAdView() {
        return null;
    }

    @Override // com.alimm.tanx.core.ad.listener.INewTanxExpressAd
    public /* synthetic */ View getAdView(Activity activity) {
        return tanxc_do();
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd
    public void showAd(Activity activity, VideoParam videoParam) {
        showAd(activity, videoParam, true);
    }

    public ITanxRewardExpressAd.OnRewardAdListener tanxc_for() {
        return this.tanxc_new;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b7, code lost:
    
        if (r1.equals(com.alimm.tanx.core.constant.AdConstants.PID_STYLE_ORDER_REWARD_ID) == false) goto L18;
     */
    @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void showAd(android.app.Activity r9, com.alimm.tanx.core.ad.ad.reward.model.VideoParam r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_new.showAd(android.app.Activity, com.alimm.tanx.core.ad.ad.reward.model.VideoParam, boolean):void");
    }

    private void tanxc_do(Context context, Class<?> cls, boolean z) {
        tanxc_if.tanxc_do.put(getRequestId(), this);
        Intent intent = new Intent(context, cls);
        if (z) {
            intent.addFlags(268435456);
        }
        intent.putExtra("REQ_ID", getRequestId());
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tanxc_do(String str, String str2, RewardParam rewardParam, Integer num, String str3) {
        new TanxRewardRequest().queryRewards(new RewardRequestBean().build(str, str2, rewardParam), num, str3, new IRewardRequestListener() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_new.2
            @Override // com.alimm.tanx.core.ad.ad.reward.IRewardRequestListener
            public void onError(TanxError tanxError) {
                if (tanxc_new.this.tanxc_new != null) {
                    tanxc_new.this.tanxc_new.onError(tanxError);
                }
            }

            @Override // com.alimm.tanx.core.ad.ad.reward.IRewardRequestListener
            public void onRewardArrived(boolean z, int i, Map<String, Object> map) {
                String str4 = "";
                if (map != null) {
                    try {
                        str4 = ((((("\n pid:") + map.get("pid")) + "\n sessionId:") + map.get("sessionId")) + "\n completeTime:") + map.get("completeTime");
                    } catch (Exception e) {
                        LogUtils.e(e);
                    }
                }
                LogUtils.d(tanxc_new.this.tanxc_int, "查询奖励成功，本次奖励信息为：" + str4);
                if (tanxc_new.this.tanxc_new != null) {
                    tanxc_new.this.tanxc_new.onRewardArrived(z, i, map);
                }
            }
        });
    }
}
