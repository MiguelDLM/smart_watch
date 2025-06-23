package com.alimm.tanx.core.ad.ad.template.rendering.feed.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.alimm.tanx.core.R;
import com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TouchTraceView;
import com.alimm.tanx.core.image.ImageManager;
import com.alimm.tanx.core.image.util.GifConfig;
import com.alimm.tanx.core.image.util.ImageConfig;
import com.alimm.tanx.core.orange.OrangeManager;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.utils.DimenUtil;
import com.alimm.tanx.core.utils.LogUtils;

public class TanxFeedAdInteractionView extends TanxFeedAdNativeView {
    private static final String TAG = "TanxFeedAdInteractionView";
    private final String ALL_SLIDE_DISTANCE_KEY;
    private final String DIRECTION_SLIDE_DISTANCE_KEY;
    private final String FEED_INTERACTION_GIF_URL;
    private final String SLIDE_DIRECTION_KEY;
    private final int defaultAllSlideDistance;
    private final int defaultDirectionSlideDistance;
    private final int defaultSlideDirection;
    private final TanxFrameLayout flGif;
    private final ImageView ivGif;
    private float radio;

    public TanxFeedAdInteractionView(Context context) {
        this(context, (AttributeSet) null);
    }

    private boolean isInterAction() {
        ITanxFeedAd iTanxFeedAd = this.iTanxFeedAd;
        if (iTanxFeedAd == null || iTanxFeedAd.getBidInfo() == null) {
            LogUtils.d(TAG, "交互type不为3");
            return false;
        }
        LogUtils.d(TAG, "交互type为3,为信息流滑动");
        return this.iTanxFeedAd.getBidInfo().getInteractType2FeedSlide();
    }

    public boolean allowSettingViewSize() {
        return true;
    }

    public void loadAdContent(String str) {
        LogUtils.d(TAG, str);
        super.loadAdContent(str);
        if (isInterAction() && ImageManager.getLoader() != null) {
            ImageManager.getLoader().loadGif(new GifConfig(this.ivGif, OrangeManager.getInstance().getFeedInteractionGifUrlParam("feedInteractionGifUrl")), new ImageConfig.GifCallback() {
                public void onFailure(String str) {
                    TanxBaseUt.utError(UtErrorCode.ERROR_LOGIC.getIntCode(), TanxFeedAdInteractionView.TAG, str, "main");
                    LogUtils.e(TanxFeedAdInteractionView.TAG, str);
                }

                public void onSuccess() {
                    LogUtils.d(TanxFeedAdInteractionView.TAG, "加载gif成功");
                }
            });
        }
    }

    public void onMeasure(int i, int i2) {
        ITanxFeedAd iTanxFeedAd = this.iTanxFeedAd;
        if (!(iTanxFeedAd == null || iTanxFeedAd.getBidInfo() == null)) {
            float templateHeight2Int = ((float) this.iTanxFeedAd.getBidInfo().getTemplateHeight2Int()) / ((float) this.iTanxFeedAd.getBidInfo().getTemplateWidth2Int());
            this.radio = templateHeight2Int;
            this.flGif.setViewSize(templateHeight2Int);
        }
        super.onMeasure(i, i2);
    }

    public void renderAd() {
        super.renderAd();
        if (isInterAction()) {
            this.ivGif.setVisibility(0);
            TouchTraceView touchTraceView = new TouchTraceView(getContext(), (AttributeSet) null, new TouchTraceView.InteractionCallBack() {
                public void onInteractionEnd(int i, int i2, int i3) {
                    int i4;
                    int i5;
                    int i6;
                    ITanxFeedAd iTanxFeedAd = TanxFeedAdInteractionView.this.iTanxFeedAd;
                    if (iTanxFeedAd == null || iTanxFeedAd.getBidInfo() == null || TanxFeedAdInteractionView.this.iTanxFeedAd.getBidInfo().getTemplateConf() == null) {
                        i6 = 1;
                        i5 = 55;
                        i4 = 120;
                    } else {
                        i6 = TanxFeedAdInteractionView.this.iTanxFeedAd.getBidInfo().getTemplateConf().getSlideType2Int();
                        i5 = TanxFeedAdInteractionView.this.iTanxFeedAd.getBidInfo().getTemplateConf().getSlideDistance2Int();
                        i4 = TanxFeedAdInteractionView.this.iTanxFeedAd.getBidInfo().getTemplateConf().getAllSlideDistance2Int();
                    }
                    if (i6 == 2) {
                        if (Math.abs(i2) >= DimenUtil.dp2px(TanxFeedAdInteractionView.this.getContext(), (float) i5) || i3 >= DimenUtil.dp2px(TanxFeedAdInteractionView.this.getContext(), (float) i4)) {
                            TanxFeedAdInteractionView tanxFeedAdInteractionView = TanxFeedAdInteractionView.this;
                            tanxFeedAdInteractionView.iTanxFeedAd.click(tanxFeedAdInteractionView);
                        }
                    } else if (Math.abs(i) >= DimenUtil.dp2px(TanxFeedAdInteractionView.this.getContext(), (float) i5) || i3 >= DimenUtil.dp2px(TanxFeedAdInteractionView.this.getContext(), (float) i4)) {
                        TanxFeedAdInteractionView tanxFeedAdInteractionView2 = TanxFeedAdInteractionView.this;
                        tanxFeedAdInteractionView2.iTanxFeedAd.click(tanxFeedAdInteractionView2);
                    }
                }

                public void onInteractionStart() {
                    LogUtils.d("", "");
                }
            });
            touchTraceView.tanxc_do(this.radio);
            this.flAdContentRoot.addView(touchTraceView);
            return;
        }
        this.flGif.setVisibility(8);
    }

    public TanxFeedAdInteractionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.DIRECTION_SLIDE_DISTANCE_KEY = "directionSlideDistance";
        this.ALL_SLIDE_DISTANCE_KEY = "allSlideDistance";
        this.SLIDE_DIRECTION_KEY = "slideDirection";
        this.FEED_INTERACTION_GIF_URL = "feedInteractionGifUrl";
        this.defaultDirectionSlideDistance = 55;
        this.defaultAllSlideDistance = 120;
        this.defaultSlideDirection = 1;
        this.radio = 0.56f;
        this.ivGif = (ImageView) this.v.findViewById(R.id.iv_gif);
        TanxFrameLayout tanxFrameLayout = (TanxFrameLayout) this.v.findViewById(R.id.fl_gif);
        this.flGif = tanxFrameLayout;
        tanxFrameLayout.setVisibility(0);
    }
}
