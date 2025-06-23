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
import com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if;
import com.alimm.tanx.core.ad.bean.RewardParam;
import com.alimm.tanx.core.ad.bean.RewardRequestBean;
import com.alimm.tanx.core.ad.listener.reward.TanxRewardRequest;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.core.ut.core.LifeCycleManager;
import com.alimm.tanx.core.utils.LogUtils;
import java.util.Map;

public class tanxc_new extends tanxc_if<ITanxRewardVideoAd> implements ITanxRewardExpressAd {
    public VideoParam tanxc_do;
    public ITanxRewardVideoAd tanxc_if;
    /* access modifiers changed from: private */
    public String tanxc_int = "TanxRewardExpressAd";
    /* access modifiers changed from: private */
    public ITanxRewardExpressAd.OnRewardAdListener tanxc_new;

    public tanxc_new(ITanxRewardVideoAd iTanxRewardVideoAd) {
        super(iTanxRewardVideoAd);
        this.tanxc_if = iTanxRewardVideoAd;
    }

    private void tanxc_int() {
        LifeCycleManager.getInstance().register(this.tanxc_int, new LifeCycleManager.AppVisibleCallBack() {
            public void appVisibleCallBack(boolean z, boolean z2) {
                int i;
                String tanxc_do2 = tanxc_new.this.tanxc_int;
                LogUtils.d(tanxc_do2, "触发前后台切换的查奖链路，nowBackground/secondUp：" + z + "/" + z2);
                if (!z2) {
                    return;
                }
                if (tanxc_new.this.getBidInfo() == null || tanxc_new.this.getBidInfo().getTemplateConf() == null || tanxc_new.this.getBidInfo().getTemplateConf().getRewardMode() != 1) {
                    try {
                        i = tanxc_new.this.getBidInfo().getTemplateConf().getRewardMode();
                    } catch (Exception e) {
                        LogUtils.e(e);
                        i = -1;
                    }
                    String tanxc_do3 = tanxc_new.this.tanxc_int;
                    LogUtils.d(tanxc_do3, "appVisibleCallBack:当前不是客户端发奖，rewardMode:" + i);
                } else if (tanxc_new.this.tanxc_new() && tanxc_if.tanxc_if != null && !TextUtils.isEmpty(tanxc_if.tanxc_if.tanxc_if)) {
                    String tanxc_do4 = tanxc_new.this.tanxc_int;
                    LogUtils.d(tanxc_do4, "自动查询奖励开始：" + tanxc_if.tanxc_if.toString());
                    tanxc_new.this.tanxc_do(tanxc_if.tanxc_if.tanxc_if, tanxc_if.tanxc_if.tanxc_do, tanxc_if.tanxc_if.tanxc_int, 1, (String) null);
                    tanxc_if.tanxc_do();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean tanxc_new() {
        if (getAdSlot() != null && getAdSlot().getRewardParam() != null && getAdSlot().getRewardParam().isAutoQuerySwitch()) {
            return true;
        }
        LogUtils.d(this.tanxc_int, "自动查询奖励关闭");
        return false;
    }

    public void destroy() {
        LifeCycleManager.getInstance().unRegister(this.tanxc_int);
        LogUtils.d("TanxRewardExpressAd", "媒体调用destroy（）");
        this.tanxc_new = null;
    }

    public String getScene() {
        return "rewardVideo";
    }

    public void refresh() {
    }

    public void setOnRewardAdListener(ITanxRewardExpressAd.OnRewardAdListener onRewardAdListener) {
        this.tanxc_new = onRewardAdListener;
    }

    public void showAd(Activity activity) {
        showAd(activity, new VideoParam());
    }

    public TanxAdView tanxc_do() {
        return null;
    }

    /* renamed from: tanxc_if */
    public TanxAdView getAdView() {
        return null;
    }

    public /* synthetic */ View getAdView(Activity activity) {
        return tanxc_do();
    }

    public void showAd(Activity activity, VideoParam videoParam) {
        showAd(activity, videoParam, true);
    }

    public ITanxRewardExpressAd.OnRewardAdListener tanxc_for() {
        return this.tanxc_new;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00b7, code lost:
        if (r1.equals(com.alimm.tanx.core.constant.AdConstants.PID_STYLE_ORDER_REWARD_ID) == false) goto L_0x0099;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void showAd(android.app.Activity r9, com.alimm.tanx.core.ad.ad.reward.model.VideoParam r10, boolean r11) {
        /*
            r8 = this;
            r0 = 2
            com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd r1 = r8.tanxc_if
            if (r1 == 0) goto L_0x0104
            com.alimm.tanx.core.ad.bean.BidInfo r1 = r1.getBidInfo()
            if (r1 == 0) goto L_0x0104
            com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd r1 = r8.tanxc_if
            com.alimm.tanx.core.ad.bean.BidInfo r1 = r1.getBidInfo()
            com.alimm.tanx.core.ad.bean.TemplateConfig r1 = r1.getTemplateConf()
            if (r1 == 0) goto L_0x0104
            com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd r1 = r8.tanxc_if
            com.alimm.tanx.core.ad.bean.BidInfo r1 = r1.getBidInfo()
            com.alimm.tanx.core.ad.bean.TemplateConfig r1 = r1.getTemplateConf()
            java.lang.String r1 = r1.getPidStyleId()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x002d
            goto L_0x0104
        L_0x002d:
            boolean r1 = r8.tanxc_new()
            if (r1 == 0) goto L_0x0069
            com.alimm.tanx.core.request.TanxAdSlot r1 = r8.getAdSlot()
            com.alimm.tanx.core.ad.bean.RewardParam r1 = r1.getRewardParam()
            boolean r1 = r1.isQueryHistoryRewards()
            if (r1 == 0) goto L_0x0069
            com.alimm.tanx.core.request.TanxAdSlot r1 = r8.getAdSlot()
            java.lang.String r3 = r1.getMediaUid()
            com.alimm.tanx.core.request.TanxAdSlot r1 = r8.getAdSlot()
            java.lang.String r4 = r1.getPid()
            com.alimm.tanx.core.request.TanxAdSlot r1 = r8.getAdSlot()
            com.alimm.tanx.core.ad.bean.RewardParam r5 = r1.getRewardParam()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)
            com.alimm.tanx.core.ad.bean.BidInfo r1 = r8.getBidInfo()
            java.lang.String r7 = r1.getSessionId()
            r2 = r8
            r2.tanxc_do(r3, r4, r5, r6, r7)
        L_0x0069:
            com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd r1 = r8.tanxc_if
            com.alimm.tanx.core.ad.bean.BidInfo r1 = r1.getBidInfo()
            com.alimm.tanx.core.ad.bean.TemplateConfig r1 = r1.getTemplateConf()
            java.lang.String r1 = r1.getPidStyleId()
            java.lang.String r2 = "TanxRewardExpressAd PidStyleId:"
            com.alimm.tanx.core.utils.LogUtils.d((java.lang.String) r2, (java.lang.String) r1)
            com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd r1 = r8.tanxc_if
            com.alimm.tanx.core.ad.bean.BidInfo r1 = r1.getBidInfo()
            com.alimm.tanx.core.ad.bean.TemplateConfig r1 = r1.getTemplateConf()
            java.lang.String r1 = r1.getPidStyleId()
            r1.hashCode()
            java.lang.Class<com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity> r2 = com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.class
            java.lang.String r3 = "TanxRewardExpressAd"
            r4 = -1
            int r5 = r1.hashCode()
            switch(r5) {
                case 1448635041: goto L_0x00c5;
                case 1448635042: goto L_0x00ba;
                case 1448635076: goto L_0x00b1;
                case 1448635077: goto L_0x00a6;
                case 1448635103: goto L_0x009b;
                default: goto L_0x0099;
            }
        L_0x0099:
            r0 = -1
            goto L_0x00cf
        L_0x009b:
            java.lang.String r0 = "100022"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x00a4
            goto L_0x0099
        L_0x00a4:
            r0 = 4
            goto L_0x00cf
        L_0x00a6:
            java.lang.String r0 = "100017"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x00af
            goto L_0x0099
        L_0x00af:
            r0 = 3
            goto L_0x00cf
        L_0x00b1:
            java.lang.String r5 = "100016"
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x00cf
            goto L_0x0099
        L_0x00ba:
            java.lang.String r0 = "100003"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x00c3
            goto L_0x0099
        L_0x00c3:
            r0 = 1
            goto L_0x00cf
        L_0x00c5:
            java.lang.String r0 = "100002"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x00ce
            goto L_0x0099
        L_0x00ce:
            r0 = 0
        L_0x00cf:
            switch(r0) {
                case 0: goto L_0x00f6;
                case 1: goto L_0x00ec;
                case 2: goto L_0x00d3;
                case 3: goto L_0x00d3;
                case 4: goto L_0x00d3;
                default: goto L_0x00d2;
            }
        L_0x00d2:
            goto L_0x0103
        L_0x00d3:
            java.lang.String r10 = "启动淘宝浏览"
            com.alimm.tanx.core.utils.LogUtils.d((java.lang.String) r3, (java.lang.String) r10)
            com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_for r10 = new com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_for
            r10.<init>(r8)
            boolean r10 = r10.tanxc_do((android.content.Context) r9)
            if (r10 != 0) goto L_0x00e8
            r8.tanxc_do(r9, r2, r11)
            goto L_0x0103
        L_0x00e8:
            r8.tanxc_int()
            goto L_0x0103
        L_0x00ec:
            java.lang.String r10 = "启动激励浏览"
            com.alimm.tanx.core.utils.LogUtils.d((java.lang.String) r3, (java.lang.String) r10)
            r8.tanxc_do(r9, r2, r11)
            goto L_0x0103
        L_0x00f6:
            java.lang.String r0 = "启动激励视频"
            com.alimm.tanx.core.utils.LogUtils.d((java.lang.String) r3, (java.lang.String) r0)
            r8.tanxc_do = r10
            java.lang.Class<com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity> r10 = com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.class
            r8.tanxc_do(r9, r10, r11)
        L_0x0103:
            return
        L_0x0104:
            com.alimm.tanx.core.request.TanxError r9 = new com.alimm.tanx.core.request.TanxError
            java.lang.String r10 = "TanxRewardExpressAd showAd() iTanxRewardVideoAd为空|| getBidInfo||getTemplateConf||getPidStyleId为空"
            r9.<init>(r10)
            com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd$OnRewardAdListener r10 = r8.tanxc_new
            if (r10 == 0) goto L_0x0112
            r10.onError(r9)
        L_0x0112:
            com.alimm.tanx.core.utils.LogUtils.e(r9)
            return
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

    /* access modifiers changed from: private */
    public void tanxc_do(String str, String str2, RewardParam rewardParam, Integer num, String str3) {
        new TanxRewardRequest().queryRewards(new RewardRequestBean().build(str, str2, rewardParam), num, str3, new IRewardRequestListener() {
            public void onError(TanxError tanxError) {
                if (tanxc_new.this.tanxc_new != null) {
                    tanxc_new.this.tanxc_new.onError(tanxError);
                }
            }

            public void onRewardArrived(boolean z, int i, Map<String, Object> map) {
                String str = "";
                if (map != null) {
                    try {
                        str = (((((str + "\n pid:") + map.get("pid")) + "\n sessionId:") + map.get("sessionId")) + "\n completeTime:") + map.get("completeTime");
                    } catch (Exception e) {
                        LogUtils.e(e);
                    }
                }
                LogUtils.d(tanxc_new.this.tanxc_int, "查询奖励成功，本次奖励信息为：" + str);
                if (tanxc_new.this.tanxc_new != null) {
                    tanxc_new.this.tanxc_new.onRewardArrived(z, i, map);
                }
            }
        });
    }
}
