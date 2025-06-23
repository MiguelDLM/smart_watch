package com.alimm.tanx.core.ad.ad.template.rendering.reward;

import android.content.Context;
import android.text.TextUtils;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd;
import com.alimm.tanx.core.ad.listener.INewTanxExpressAd;
import com.alimm.tanx.core.ad.listener.ITanxAdLoader;
import com.alimm.tanx.core.ad.listener.model.IModel;
import com.alimm.tanx.core.constant.AdConstants;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.ut.impl.TanxCommonUt;
import com.alimm.tanx.core.ut.impl.TanxInterfaceUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.VideoCacheManager;
import com.alimm.tanx.core.view.player.cache.videocache.PreloadListener;
import java.util.List;

/* loaded from: classes.dex */
public class tanxc_int extends com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do<IModel, ITanxRewardVideoAd, ITanxRewardExpressAd> {
    public tanxc_int(Context context, IModel iModel) {
        super(context, iModel);
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do
    public ITanxRewardExpressAd tanxc_do(ITanxRewardVideoAd iTanxRewardVideoAd) {
        return new tanxc_new(iTanxRewardVideoAd);
    }

    public void tanxc_do(final List<ITanxRewardExpressAd> list, final ITanxAdLoader.OnRewardAdLoadListener<ITanxRewardExpressAd> onRewardAdLoadListener) {
        char c;
        if (list != null) {
            try {
                if (list.size() != 0) {
                    final ITanxRewardExpressAd iTanxRewardExpressAd = list.get(0);
                    if (iTanxRewardExpressAd != null && iTanxRewardExpressAd.getBidInfo() != null && iTanxRewardExpressAd.getBidInfo().getTemplateConf() != null && !TextUtils.isEmpty(iTanxRewardExpressAd.getBidInfo().getTemplateConf().getPidStyleId())) {
                        String pidStyleId = iTanxRewardExpressAd.getBidInfo().getTemplateConf().getPidStyleId();
                        switch (pidStyleId.hashCode()) {
                            case 1448635041:
                                if (pidStyleId.equals(AdConstants.PID_STYLE_REWARD_VIDEO_ID)) {
                                    c = 0;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1448635042:
                                if (pidStyleId.equals(AdConstants.PID_STYLE_REWARD_ID)) {
                                    c = 1;
                                    break;
                                }
                                c = 65535;
                                break;
                            default:
                                c = 65535;
                                break;
                        }
                        if (c == 0) {
                            VideoCacheManager.getInstance().preload((ITanxAd) list.get(0), false, new PreloadListener() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_int.1
                                @Override // com.alimm.tanx.core.view.player.cache.videocache.PreloadListener
                                public void onCached(String str) {
                                    LogUtils.d("video_cache", "缓存完成");
                                    TanxCommonUt.cacheCheck(iTanxRewardExpressAd, str, 0, null);
                                    ITanxAdLoader.OnRewardAdLoadListener onRewardAdLoadListener2 = onRewardAdLoadListener;
                                    if (onRewardAdLoadListener2 != null) {
                                        onRewardAdLoadListener2.onRewardVideoCached((INewTanxExpressAd) list.get(0));
                                    }
                                }

                                @Override // com.alimm.tanx.core.view.player.cache.videocache.PreloadListener
                                public void onError(String str, Exception exc) {
                                    LogUtils.e("video_cache", "缓存异常");
                                    ITanxAdLoader.OnRewardAdLoadListener onRewardAdLoadListener2 = onRewardAdLoadListener;
                                    if (onRewardAdLoadListener2 != null) {
                                        onRewardAdLoadListener2.onError(new TanxError("缓存异常: " + LogUtils.getStackTraceMessage(exc)));
                                    }
                                    TanxCommonUt.cacheCheck(iTanxRewardExpressAd, str, 1, exc);
                                    TanxBaseUt.utErrorCode((ITanxAd) list.get(0), UtErrorCode.VIDEO_DOWNLOAD_ERROR);
                                }

                                @Override // com.alimm.tanx.core.view.player.cache.videocache.PreloadListener
                                public void onStartCached(ITanxAd iTanxAd) {
                                    if (iTanxAd != null && iTanxAd.getAdSlot() != null) {
                                        TanxInterfaceUt.sendMethodInvoke(iTanxAd.getAdSlot().getPid(), TanxInterfaceUt.REWARD_VIDEO_START_CACHE);
                                    }
                                }
                            });
                            return;
                        } else {
                            if (c != 1) {
                                return;
                            }
                            LogUtils.d("video_cache", "不是激励视频广告，不需要缓存，直接回调媒体");
                            if (onRewardAdLoadListener != null) {
                                onRewardAdLoadListener.onRewardVideoCached(list.get(0));
                                return;
                            }
                            return;
                        }
                    }
                    onRewardAdLoadListener.onError(new TanxError("RewardPresenter返回广告getBidInfo||getTemplateConf||getPidStyleId为空"));
                    return;
                }
            } catch (Exception e) {
                if (onRewardAdLoadListener != null) {
                    onRewardAdLoadListener.onError(new TanxError("缓存try - catch异常: " + LogUtils.getStackTraceMessage(e)));
                    return;
                }
                return;
            }
        }
        onRewardAdLoadListener.onError(new TanxError("RewardPresenter返回广告list为空"));
    }
}
