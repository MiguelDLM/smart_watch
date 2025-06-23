package com.alimm.tanx.core.ad.ad.template.rendering.reward;

import android.content.Context;
import com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd;
import com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do;
import com.alimm.tanx.core.ad.listener.model.IModel;

public class tanxc_int extends tanxc_do<IModel, ITanxRewardVideoAd, ITanxRewardExpressAd> {
    public tanxc_int(Context context, IModel iModel) {
        super(context, iModel);
    }

    public ITanxRewardExpressAd tanxc_do(ITanxRewardVideoAd iTanxRewardVideoAd) {
        return new tanxc_new(iTanxRewardVideoAd);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void tanxc_do(final java.util.List<com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd> r6, final com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnRewardAdLoadListener<com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd> r7) {
        /*
            r5 = this;
            if (r6 == 0) goto L_0x009a
            int r0 = r6.size()     // Catch:{ Exception -> 0x0055 }
            if (r0 != 0) goto L_0x000a
            goto L_0x009a
        L_0x000a:
            r0 = 0
            java.lang.Object r1 = r6.get(r0)     // Catch:{ Exception -> 0x0055 }
            com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd r1 = (com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd) r1     // Catch:{ Exception -> 0x0055 }
            if (r1 == 0) goto L_0x008f
            com.alimm.tanx.core.ad.bean.BidInfo r2 = r1.getBidInfo()     // Catch:{ Exception -> 0x0055 }
            if (r2 == 0) goto L_0x008f
            com.alimm.tanx.core.ad.bean.BidInfo r2 = r1.getBidInfo()     // Catch:{ Exception -> 0x0055 }
            com.alimm.tanx.core.ad.bean.TemplateConfig r2 = r2.getTemplateConf()     // Catch:{ Exception -> 0x0055 }
            if (r2 == 0) goto L_0x008f
            com.alimm.tanx.core.ad.bean.BidInfo r2 = r1.getBidInfo()     // Catch:{ Exception -> 0x0055 }
            com.alimm.tanx.core.ad.bean.TemplateConfig r2 = r2.getTemplateConf()     // Catch:{ Exception -> 0x0055 }
            java.lang.String r2 = r2.getPidStyleId()     // Catch:{ Exception -> 0x0055 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0055 }
            if (r2 == 0) goto L_0x0036
            goto L_0x008f
        L_0x0036:
            com.alimm.tanx.core.ad.bean.BidInfo r2 = r1.getBidInfo()     // Catch:{ Exception -> 0x0055 }
            com.alimm.tanx.core.ad.bean.TemplateConfig r2 = r2.getTemplateConf()     // Catch:{ Exception -> 0x0055 }
            java.lang.String r2 = r2.getPidStyleId()     // Catch:{ Exception -> 0x0055 }
            int r3 = r2.hashCode()     // Catch:{ Exception -> 0x0055 }
            r4 = 1
            switch(r3) {
                case 1448635041: goto L_0x0057;
                case 1448635042: goto L_0x004b;
                default: goto L_0x004a;
            }     // Catch:{ Exception -> 0x0055 }
        L_0x004a:
            goto L_0x0061
        L_0x004b:
            java.lang.String r3 = "100003"
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x0055 }
            if (r2 == 0) goto L_0x0061
            r2 = 1
            goto L_0x0062
        L_0x0055:
            r6 = move-exception
            goto L_0x00a5
        L_0x0057:
            java.lang.String r3 = "100002"
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x0055 }
            if (r2 == 0) goto L_0x0061
            r2 = 0
            goto L_0x0062
        L_0x0061:
            r2 = -1
        L_0x0062:
            if (r2 == 0) goto L_0x007c
            if (r2 == r4) goto L_0x0067
            goto L_0x00c5
        L_0x0067:
            java.lang.String r1 = "video_cache"
            java.lang.String r2 = "不是激励视频广告，不需要缓存，直接回调媒体"
            com.alimm.tanx.core.utils.LogUtils.d((java.lang.String) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x0055 }
            if (r7 == 0) goto L_0x00c5
            java.lang.Object r6 = r6.get(r0)     // Catch:{ Exception -> 0x0055 }
            com.alimm.tanx.core.ad.listener.INewTanxExpressAd r6 = (com.alimm.tanx.core.ad.listener.INewTanxExpressAd) r6     // Catch:{ Exception -> 0x0055 }
            r7.onRewardVideoCached(r6)     // Catch:{ Exception -> 0x0055 }
            goto L_0x00c5
        L_0x007c:
            com.alimm.tanx.core.utils.VideoCacheManager r2 = com.alimm.tanx.core.utils.VideoCacheManager.getInstance()     // Catch:{ Exception -> 0x0055 }
            java.lang.Object r3 = r6.get(r0)     // Catch:{ Exception -> 0x0055 }
            com.alimm.tanx.core.ad.ITanxAd r3 = (com.alimm.tanx.core.ad.ITanxAd) r3     // Catch:{ Exception -> 0x0055 }
            com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_int$1 r4 = new com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_int$1     // Catch:{ Exception -> 0x0055 }
            r4.<init>(r1, r7, r6)     // Catch:{ Exception -> 0x0055 }
            r2.preload((com.alimm.tanx.core.ad.ITanxAd) r3, (boolean) r0, (com.alimm.tanx.core.view.player.cache.videocache.PreloadListener) r4)     // Catch:{ Exception -> 0x0055 }
            goto L_0x00c5
        L_0x008f:
            com.alimm.tanx.core.request.TanxError r6 = new com.alimm.tanx.core.request.TanxError     // Catch:{ Exception -> 0x0055 }
            java.lang.String r0 = "RewardPresenter返回广告getBidInfo||getTemplateConf||getPidStyleId为空"
            r6.<init>(r0)     // Catch:{ Exception -> 0x0055 }
            r7.onError(r6)     // Catch:{ Exception -> 0x0055 }
            return
        L_0x009a:
            com.alimm.tanx.core.request.TanxError r6 = new com.alimm.tanx.core.request.TanxError     // Catch:{ Exception -> 0x0055 }
            java.lang.String r0 = "RewardPresenter返回广告list为空"
            r6.<init>(r0)     // Catch:{ Exception -> 0x0055 }
            r7.onError(r6)     // Catch:{ Exception -> 0x0055 }
            return
        L_0x00a5:
            if (r7 == 0) goto L_0x00c5
            com.alimm.tanx.core.request.TanxError r0 = new com.alimm.tanx.core.request.TanxError
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "缓存try - catch异常: "
            r1.append(r2)
            java.lang.String r6 = com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(r6)
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r0.<init>(r6)
            r7.onError(r0)
        L_0x00c5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_int.tanxc_do(java.util.List, com.alimm.tanx.core.ad.listener.ITanxAdLoader$OnRewardAdLoadListener):void");
    }
}
