package com.alimm.tanx.core.ad.loader;

import android.content.Context;
import com.alimm.tanx.core.ad.ad.feed.FeedAdModel;
import com.alimm.tanx.core.ad.ad.reward.model.RewardVideoAdModel;
import com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel;
import com.alimm.tanx.core.ad.ad.table.screen.model.TableScreenAdModel;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.ITanxFeedExpressAd;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.tanxc_do;
import com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd;
import com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_int;
import com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd;
import com.alimm.tanx.core.ad.ad.template.rendering.table.screen.ITanxTableScreenExpressAd;
import com.alimm.tanx.core.ad.listener.ITanxAdLoader;
import com.alimm.tanx.core.orange.OrangeManager;
import com.alimm.tanx.core.orange.OrangeSwitchConstants;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.ut.impl.TanxInterfaceUt;
import com.alimm.tanx.core.utils.LogUtils;
import java.util.List;

/* loaded from: classes.dex */
public class NewTanxAdLoader extends TanxRequestLoader implements ITanxAdLoader {
    protected Context mContext;
    private tanxc_do mFeedPresenter;
    private tanxc_int mRewardVideoPresenter;
    private com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int mSplashAdPresenter;
    private com.alimm.tanx.core.ad.ad.template.rendering.table.screen.tanxc_do mTableScreenPresenter;
    long splashTimeConsuming = 0;

    public NewTanxAdLoader(Context context) {
        this.mContext = context;
    }

    private void rewardAdExecute(final TanxAdSlot tanxAdSlot, final ITanxAdLoader.OnRewardAdLoadListener<ITanxRewardExpressAd> onRewardAdLoadListener, long j) {
        try {
            final long currentTimeMillis = System.currentTimeMillis();
            if (!OrangeManager.getInstance().getAdSwitch(OrangeSwitchConstants.AD_TEMPLATE_REWARD)) {
                onRewardAdLoadListener.onError(new TanxError("", TanxError.ERROR_AD_SWITCH_CLOSE));
                return;
            }
            tanxAdSlot.setAdCount(1);
            if (this.mRewardVideoPresenter == null) {
                this.mRewardVideoPresenter = new tanxc_int(this.mContext, new RewardVideoAdModel());
            }
            TanxInterfaceUt.sendMethodInvoke(tanxAdSlot.getPid(), TanxInterfaceUt.TEMPLATE_REWARD);
            this.mRewardVideoPresenter.request(tanxAdSlot, new ITanxAdLoader.OnAdLoadListener<ITanxRewardExpressAd>() { // from class: com.alimm.tanx.core.ad.loader.NewTanxAdLoader.4
                @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.BaseAdLoadListener
                public void onError(TanxError tanxError) {
                    TanxInterfaceUt.sendMethodCallback(tanxAdSlot, TanxInterfaceUt.TEMPLATE_REWARD, "error", System.currentTimeMillis() - currentTimeMillis);
                    ITanxAdLoader.OnRewardAdLoadListener onRewardAdLoadListener2 = onRewardAdLoadListener;
                    if (onRewardAdLoadListener2 != null) {
                        onRewardAdLoadListener2.onError(tanxError);
                    }
                }

                @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener
                public void onLoaded(List<ITanxRewardExpressAd> list) {
                    ITanxAdLoader.OnRewardAdLoadListener onRewardAdLoadListener2 = onRewardAdLoadListener;
                    if (onRewardAdLoadListener2 != null) {
                        onRewardAdLoadListener2.onLoaded(list);
                    }
                    NewTanxAdLoader.this.mRewardVideoPresenter.tanxc_do(list, onRewardAdLoadListener);
                    TanxInterfaceUt.sendMethodCallback(tanxAdSlot, TanxInterfaceUt.TEMPLATE_REWARD, "success", System.currentTimeMillis() - currentTimeMillis);
                }

                @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.BaseAdLoadListener
                public void onTimeOut() {
                    TanxInterfaceUt.sendMethodCallback(tanxAdSlot, TanxInterfaceUt.TEMPLATE_REWARD, TanxInterfaceUt.CALLBACK_TIMEOUT, System.currentTimeMillis() - currentTimeMillis);
                    ITanxAdLoader.OnRewardAdLoadListener onRewardAdLoadListener2 = onRewardAdLoadListener;
                    if (onRewardAdLoadListener2 != null) {
                        onRewardAdLoadListener2.onTimeOut();
                    }
                }
            }, j);
        } catch (Exception e) {
            if (onRewardAdLoadListener != null) {
                onRewardAdLoadListener.onError(new TanxError("loadRewardAd异常:" + LogUtils.getStackTraceMessage(e)));
            }
            LogUtils.e("loadRewardVideoAd", e);
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "loadRewardAd", LogUtils.getStackTraceMessage(e), "");
        }
    }

    private void tableScreenAdAdExecute(final TanxAdSlot tanxAdSlot, final ITanxAdLoader.OnAdLoadListener<ITanxTableScreenExpressAd> onAdLoadListener, long j) {
        try {
            final long currentTimeMillis = System.currentTimeMillis();
            if (!OrangeManager.getInstance().getAdSwitch(OrangeSwitchConstants.AD_TEMPLATE_TABLE_SCREEN)) {
                onAdLoadListener.onError(new TanxError("", TanxError.ERROR_AD_SWITCH_CLOSE));
                return;
            }
            tanxAdSlot.setAdCount(1);
            if (this.mTableScreenPresenter == null) {
                this.mTableScreenPresenter = new com.alimm.tanx.core.ad.ad.template.rendering.table.screen.tanxc_do(this.mContext, new TableScreenAdModel());
            }
            TanxInterfaceUt.sendMethodInvoke(tanxAdSlot.getPid(), TanxInterfaceUt.TEMPLATE_TABLE_SCREEN);
            this.mTableScreenPresenter.request(tanxAdSlot, new ITanxAdLoader.OnAdLoadListener<ITanxTableScreenExpressAd>() { // from class: com.alimm.tanx.core.ad.loader.NewTanxAdLoader.3
                @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.BaseAdLoadListener
                public void onError(TanxError tanxError) {
                    TanxInterfaceUt.sendMethodCallback(tanxAdSlot, TanxInterfaceUt.TEMPLATE_TABLE_SCREEN, "error", System.currentTimeMillis() - currentTimeMillis);
                    ITanxAdLoader.OnAdLoadListener onAdLoadListener2 = onAdLoadListener;
                    if (onAdLoadListener2 != null) {
                        onAdLoadListener2.onError(tanxError);
                    }
                }

                @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener
                public void onLoaded(List<ITanxTableScreenExpressAd> list) {
                    ITanxAdLoader.OnAdLoadListener onAdLoadListener2 = onAdLoadListener;
                    if (onAdLoadListener2 != null) {
                        onAdLoadListener2.onLoaded(list);
                    }
                    NewTanxAdLoader.this.mTableScreenPresenter.tanxc_do(list, onAdLoadListener);
                    TanxInterfaceUt.sendMethodCallback(tanxAdSlot, TanxInterfaceUt.TEMPLATE_TABLE_SCREEN, "success", System.currentTimeMillis() - currentTimeMillis);
                }

                @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.BaseAdLoadListener
                public void onTimeOut() {
                    TanxInterfaceUt.sendMethodCallback(tanxAdSlot, TanxInterfaceUt.TEMPLATE_TABLE_SCREEN, TanxInterfaceUt.CALLBACK_TIMEOUT, System.currentTimeMillis() - currentTimeMillis);
                    ITanxAdLoader.OnAdLoadListener onAdLoadListener2 = onAdLoadListener;
                    if (onAdLoadListener2 != null) {
                        onAdLoadListener2.onTimeOut();
                    }
                }
            }, j);
        } catch (Exception e) {
            if (onAdLoadListener != null) {
                onAdLoadListener.onError(new TanxError("tableScreenAdAdExecute异常:" + LogUtils.getStackTraceMessage(e)));
            }
            LogUtils.e("tableScreenAdAdExecute", e);
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "tableScreenAdAdExecute", LogUtils.getStackTraceMessage(e), "");
        }
    }

    @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader
    public void destroy() {
    }

    @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader
    public void loadFeedAd(final TanxAdSlot tanxAdSlot, final ITanxAdLoader.OnAdLoadListener<ITanxFeedExpressAd> onAdLoadListener) {
        try {
            final long currentTimeMillis = System.currentTimeMillis();
            if (!OrangeManager.getInstance().getAdSwitch(OrangeSwitchConstants.AD_TEMPLATE_FEED)) {
                onAdLoadListener.onError(new TanxError("", TanxError.ERROR_AD_SWITCH_CLOSE));
                return;
            }
            tanxAdSlot.addTemplateAdSlot(2);
            if (this.mFeedPresenter == null) {
                this.mFeedPresenter = new tanxc_do(this.mContext, new FeedAdModel());
            }
            TanxInterfaceUt.sendMethodInvoke(tanxAdSlot.getPid(), TanxInterfaceUt.TEMPLATE_FEED);
            this.mFeedPresenter.request(tanxAdSlot, new ITanxAdLoader.OnAdLoadListener() { // from class: com.alimm.tanx.core.ad.loader.NewTanxAdLoader.1
                @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.BaseAdLoadListener
                public void onError(TanxError tanxError) {
                    TanxInterfaceUt.sendMethodCallback(tanxAdSlot, TanxInterfaceUt.TEMPLATE_FEED, "error", System.currentTimeMillis() - currentTimeMillis);
                    ITanxAdLoader.OnAdLoadListener onAdLoadListener2 = onAdLoadListener;
                    if (onAdLoadListener2 != null) {
                        onAdLoadListener2.onError(tanxError);
                    }
                }

                @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener
                public void onLoaded(List list) {
                    TanxInterfaceUt.sendMethodCallback(tanxAdSlot, TanxInterfaceUt.TEMPLATE_FEED, "success", System.currentTimeMillis() - currentTimeMillis);
                    ITanxAdLoader.OnAdLoadListener onAdLoadListener2 = onAdLoadListener;
                    if (onAdLoadListener2 != null) {
                        onAdLoadListener2.onLoaded(list);
                    }
                }

                @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.BaseAdLoadListener
                public void onTimeOut() {
                    TanxInterfaceUt.sendMethodCallback(tanxAdSlot, TanxInterfaceUt.TEMPLATE_FEED, TanxInterfaceUt.CALLBACK_TIMEOUT, System.currentTimeMillis() - currentTimeMillis);
                    ITanxAdLoader.OnAdLoadListener onAdLoadListener2 = onAdLoadListener;
                    if (onAdLoadListener2 != null) {
                        onAdLoadListener2.onTimeOut();
                    }
                }
            });
        } catch (Exception e) {
            LogUtils.e("loadFeedAd", e);
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "loadFeedAd", LogUtils.getStackTraceMessage(e), "");
            if (onAdLoadListener != null) {
                onAdLoadListener.onError(new TanxError("feedAdListener异常:" + LogUtils.getStackTraceMessage(e)));
            }
        }
    }

    @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader
    public void loadRewardAd(TanxAdSlot tanxAdSlot, ITanxAdLoader.OnRewardAdLoadListener<ITanxRewardExpressAd> onRewardAdLoadListener) {
        loadRewardAd(tanxAdSlot, onRewardAdLoadListener, 0L);
    }

    @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader
    public void loadRewardVideoAd(TanxAdSlot tanxAdSlot, ITanxAdLoader.OnRewardAdLoadListener<ITanxRewardExpressAd> onRewardAdLoadListener) {
        loadRewardVideoAd(tanxAdSlot, onRewardAdLoadListener, 0L);
    }

    @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader
    public void loadSplashAd(final TanxAdSlot tanxAdSlot, final ITanxAdLoader.OnAdLoadListener<ITanxSplashExpressAd> onAdLoadListener, long j) {
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            this.splashTimeConsuming = 0L;
            if (!OrangeManager.getInstance().getAdSwitch(OrangeSwitchConstants.AD_TEMPLATE_SPLASH)) {
                onAdLoadListener.onError(new TanxError("", TanxError.ERROR_AD_SWITCH_CLOSE));
                return;
            }
            tanxAdSlot.addTemplateAdSlot(1);
            if (this.mSplashAdPresenter == null) {
                this.mSplashAdPresenter = new com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int(this.mContext, new SplashAdModel());
            }
            TanxInterfaceUt.sendMethodInvoke(tanxAdSlot.getPid(), TanxInterfaceUt.TEMPLATE_SPLASH);
            this.mSplashAdPresenter.tanxc_do(tanxAdSlot, new ITanxAdLoader.OnAdLoadListener<ITanxSplashExpressAd>() { // from class: com.alimm.tanx.core.ad.loader.NewTanxAdLoader.2
                @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.BaseAdLoadListener
                public void onError(TanxError tanxError) {
                    NewTanxAdLoader.this.splashTimeConsuming = System.currentTimeMillis() - currentTimeMillis;
                    LogUtils.d("splashTimeConsuming", NewTanxAdLoader.this.splashTimeConsuming + "");
                    TanxInterfaceUt.sendMethodCallback(tanxAdSlot, TanxInterfaceUt.TEMPLATE_SPLASH, "error", System.currentTimeMillis() - currentTimeMillis);
                    ITanxAdLoader.OnAdLoadListener onAdLoadListener2 = onAdLoadListener;
                    if (onAdLoadListener2 != null) {
                        onAdLoadListener2.onError(tanxError);
                    }
                }

                @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener
                public void onLoaded(List<ITanxSplashExpressAd> list) {
                    NewTanxAdLoader.this.splashTimeConsuming = System.currentTimeMillis() - currentTimeMillis;
                    LogUtils.d("splashTimeConsuming", NewTanxAdLoader.this.splashTimeConsuming + "");
                    TanxInterfaceUt.sendMethodCallback(tanxAdSlot, TanxInterfaceUt.TEMPLATE_SPLASH, "success", System.currentTimeMillis() - currentTimeMillis);
                    ITanxAdLoader.OnAdLoadListener onAdLoadListener2 = onAdLoadListener;
                    if (onAdLoadListener2 != null) {
                        onAdLoadListener2.onLoaded(list);
                    }
                }

                @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.BaseAdLoadListener
                public void onTimeOut() {
                    NewTanxAdLoader.this.splashTimeConsuming = System.currentTimeMillis() - currentTimeMillis;
                    LogUtils.d("splashTimeConsuming", NewTanxAdLoader.this.splashTimeConsuming + "");
                    TanxInterfaceUt.sendMethodCallback(tanxAdSlot, TanxInterfaceUt.TEMPLATE_SPLASH, TanxInterfaceUt.CALLBACK_TIMEOUT, System.currentTimeMillis() - currentTimeMillis);
                    ITanxAdLoader.OnAdLoadListener onAdLoadListener2 = onAdLoadListener;
                    if (onAdLoadListener2 != null) {
                        onAdLoadListener2.onTimeOut();
                    }
                }
            }, j);
        } catch (Exception e) {
            LogUtils.e("loadSplashAd", e);
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "loadSplashAd", LogUtils.getStackTraceMessage(e), "");
            if (onAdLoadListener != null) {
                onAdLoadListener.onError(new TanxError("loadSplashAd异常:" + LogUtils.getStackTraceMessage(e)));
                this.splashTimeConsuming = System.currentTimeMillis() - currentTimeMillis;
                LogUtils.d("splashTimeConsuming", this.splashTimeConsuming + "");
            }
        }
    }

    @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader
    public void loadTableScreenAd(TanxAdSlot tanxAdSlot, ITanxAdLoader.OnAdLoadListener<ITanxTableScreenExpressAd> onAdLoadListener) {
        loadTableScreenAd(tanxAdSlot, onAdLoadListener, 0L);
    }

    @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader
    public void preloadSplashAd(TanxAdSlot tanxAdSlot) {
        try {
            if (!OrangeManager.getInstance().getAdSwitch(OrangeSwitchConstants.AD_TEMPLATE_SPLASH)) {
                LogUtils.e("preloadSplashAd", TanxError.ERROR_AD_SWITCH_CLOSE);
                return;
            }
            tanxAdSlot.addTemplateAdSlot(1);
            if (this.mSplashAdPresenter == null) {
                this.mSplashAdPresenter = new com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_int(this.mContext, new SplashAdModel());
            }
            TanxInterfaceUt.sendMethodInvoke(tanxAdSlot.getPid(), TanxInterfaceUt.SPLASH_PRELOAD);
            this.mSplashAdPresenter.tanxc_do(tanxAdSlot);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e("preloadSplashAd", e);
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "preloadSplashAd", LogUtils.getStackTraceMessage(e), "");
        }
    }

    @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader
    public void loadRewardAd(TanxAdSlot tanxAdSlot, ITanxAdLoader.OnRewardAdLoadListener<ITanxRewardExpressAd> onRewardAdLoadListener, long j) {
        tanxAdSlot.addTemplateAdSlot(4);
        rewardAdExecute(tanxAdSlot, onRewardAdLoadListener, j);
    }

    @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader
    public void loadRewardVideoAd(TanxAdSlot tanxAdSlot, ITanxAdLoader.OnRewardAdLoadListener<ITanxRewardExpressAd> onRewardAdLoadListener, long j) {
        tanxAdSlot.addTemplateAdSlot(3);
        rewardAdExecute(tanxAdSlot, onRewardAdLoadListener, j);
    }

    @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader
    public void loadTableScreenAd(TanxAdSlot tanxAdSlot, ITanxAdLoader.OnAdLoadListener<ITanxTableScreenExpressAd> onAdLoadListener, long j) {
        tanxAdSlot.addTemplateAdSlot(5);
        tableScreenAdAdExecute(tanxAdSlot, onAdLoadListener, j);
    }

    @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader
    public void loadSplashAd(TanxAdSlot tanxAdSlot, ITanxAdLoader.OnAdLoadListener<ITanxSplashExpressAd> onAdLoadListener) {
        loadSplashAd(tanxAdSlot, onAdLoadListener, 0L);
    }
}
