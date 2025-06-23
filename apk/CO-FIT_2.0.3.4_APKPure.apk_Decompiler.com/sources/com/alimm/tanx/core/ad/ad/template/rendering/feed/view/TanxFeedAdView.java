package com.alimm.tanx.core.ad.ad.template.rendering.feed.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.alimm.tanx.core.R;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.ITanxFeedExpressAd;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.ErrorInterface;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.tanxc_for;
import com.alimm.tanx.core.ad.bean.CreativeItem;
import com.alimm.tanx.core.ad.bean.MediaRenderingMode;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.image.ImageManager;
import com.alimm.tanx.core.image.util.ImageConfig;
import com.alimm.tanx.core.image.util.ScaleMode;
import com.alimm.tanx.core.image.util.ShapeMode;
import com.alimm.tanx.core.image.util.TanxDrawable;
import com.alimm.tanx.core.ut.impl.TanxFeedUt;
import com.alimm.tanx.core.utils.DimenUtil;
import com.alimm.tanx.core.utils.LogUtils;

public class TanxFeedAdView extends TanxAdView {
    private static final String TAG = "TanxFeedAdView";
    private final BottomView bottomView;
    protected FrameLayout flAdContentRoot;
    protected ITanxFeedAd iTanxFeedAd;
    TanxImageView ivAd;
    protected ImageView ivAdLogo;
    private final LinearLayout llRoot;
    protected MediaRenderingMode nowMediaRenderingMode;
    private final TitleTextView tvTitle;
    protected View v;

    public TanxFeedAdView(Context context) {
        this(context, (AttributeSet) null);
    }

    public boolean allowSettingViewSize() {
        return true;
    }

    public View getCloseView() {
        return this.bottomView.getCloseView();
    }

    public void loadAdContent(String str) {
        LogUtils.d(TAG, str + "\n");
        if (ImageManager.getLoader() != null) {
            final ImageConfig build = ImageManager.with(this.ivAd.getContext()).url(str).radius(this.nowMediaRenderingMode.getPicRadius2Int(this.ivAd.getContext())).shapeMode(ShapeMode.RECT_ROUND).scaleMode(ScaleMode.FIT_CENTER).build();
            ImageManager.getLoader().load(build, new ImageConfig.ImageBitmapCallback() {
                public void onFailure(String str) {
                    TanxFeedUt.utViewDraw(TanxFeedAdView.this.iTanxFeedAd, 0);
                }

                public void onSuccess(Bitmap bitmap) {
                    LogUtils.d(TanxFeedAdView.TAG, "loadImg:" + TanxFeedAdView.this.ivAd.getMeasuredWidth() + ":bm:" + bitmap.getWidth());
                    TanxFeedAdView.this.ivAd.setImageBitmap(bitmap);
                    TanxFeedAdView.this.ivAd.setImageDrawable(new TanxDrawable(bitmap, build.getImageConfig()));
                    TanxFeedUt.utViewDraw(TanxFeedAdView.this.iTanxFeedAd, 1);
                    TanxFeedAdView.this.iTanxFeedAd.onResourceLoadSuccess();
                }
            });
        }
    }

    public void loadAdLogo(String str) {
        LogUtils.d(TAG, "loadAdLogo:" + str);
        if (ImageManager.getLoader() != null) {
            final ImageConfig build = ImageManager.with(this.ivAdLogo.getContext()).url(str).scaleMode(ScaleMode.FIT_CENTER).build();
            ImageManager.getLoader().load(build, new ImageConfig.ImageBitmapCallback() {
                public void onFailure(String str) {
                    TanxFeedAdView.this.ivAdLogo.setVisibility(8);
                }

                public void onSuccess(Bitmap bitmap) {
                    TanxFeedAdView.this.ivAdLogo.setImageBitmap(bitmap);
                    TanxFeedAdView.this.ivAdLogo.setVisibility(0);
                    TanxFeedAdView.this.ivAdLogo.setImageDrawable(new TanxDrawable(bitmap, build.getImageConfig()));
                }
            });
        }
    }

    public void loadAdStyle() {
        LogUtils.d(TAG, this.nowMediaRenderingMode.toString());
        if (TanxCoreSdk.getConfig().getSettingConfig().isCustomTextSizeDpSwitch()) {
            this.tvTitle.setTextSize(1, (float) this.nowMediaRenderingMode.getTitleSize2Int());
        } else {
            TitleTextView titleTextView = this.tvTitle;
            titleTextView.setTextSize(0, (float) DimenUtil.dp2px(titleTextView.getContext(), (float) this.nowMediaRenderingMode.getTitleSize2Int()));
        }
        this.tvTitle.setBackgroundColor(Color.parseColor(this.nowMediaRenderingMode.getBgColor()));
        this.tvTitle.setTextColor(Color.parseColor(this.nowMediaRenderingMode.getTitleColor()));
        this.llRoot.setBackgroundColor(Color.parseColor(this.nowMediaRenderingMode.getBgColor()));
        this.bottomView.setViewStyle(this.nowMediaRenderingMode);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        LogUtils.d(TAG, "onAttachedToWindow");
    }

    public void onMeasure(int i, int i2) {
        ITanxFeedAd iTanxFeedAd2 = this.iTanxFeedAd;
        if (!(iTanxFeedAd2 == null || iTanxFeedAd2.getBidInfo() == null)) {
            this.ivAd.setViewSize(((float) this.iTanxFeedAd.getBidInfo().getTemplateHeight2Int()) / ((float) this.iTanxFeedAd.getBidInfo().getTemplateWidth2Int()));
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(setViewSize(this.iTanxFeedAd, i), 1073741824), i2);
        LogUtils.d(TAG, "onMeasure-> w:" + View.MeasureSpec.getSize(i) + " h:" + View.MeasureSpec.getSize(i2));
    }

    public void renderAd() {
        CreativeItem creativeItem;
        ITanxFeedAd iTanxFeedAd2 = this.iTanxFeedAd;
        if (iTanxFeedAd2 != null && iTanxFeedAd2.getBidInfo() != null && (creativeItem = this.iTanxFeedAd.getBidInfo().getCreativeItem()) != null) {
            loadAdContent(creativeItem.getImageUrl());
            loadAdLogo(creativeItem.getAdvLogo());
            this.tvTitle.setText(creativeItem.getTitle());
            loadAdStyle();
        }
    }

    public void setTanxFeedAd(ITanxFeedAd iTanxFeedAd2, ITanxFeedExpressAd.OnFeedAdListener onFeedAdListener) {
        this.iTanxFeedAd = iTanxFeedAd2;
        this.bottomView.setTanxFeedAd(iTanxFeedAd2);
        LogUtils.d(TAG, "setTanxFeedAd()");
        if (iTanxFeedAd2.getBidInfo().getTemplateConf() != null) {
            LogUtils.d(TAG, "setTanxFeedAd()iTanxFeedAd.getBidInfo().getTemplateConf() != null");
            this.nowMediaRenderingMode = iTanxFeedAd2.getBidInfo().getTemplateConf().getNowConfig(TanxCoreSdk.getConfig().getSettingConfig().isNightSwitch(), TanxCoreSdk.getConfig().getSettingConfig().isCustomTitleSizeSwitch(), TanxCoreSdk.getConfig().getSettingConfig().getCustomTitleSize());
        }
        if (this.nowMediaRenderingMode != null || onFeedAdListener == null) {
            renderAd();
            return;
        }
        LogUtils.d(TAG, "日夜间模式对象nowConfig为空");
        onFeedAdListener.onError("日夜间模式对象nowConfig为空");
    }

    public void showDislikeView(Context context, final ITanxFeedExpressAd.OnFeedAdListener onFeedAdListener) {
        final tanxc_for tanxc_for = new tanxc_for(context, this.nowMediaRenderingMode);
        tanxc_for.tanxc_do(getCloseView(), (ErrorInterface) new ErrorInterface() {
            public void error(String str) {
                ITanxFeedExpressAd.OnFeedAdListener onFeedAdListener = onFeedAdListener;
                if (onFeedAdListener != null) {
                    onFeedAdListener.onAdClose(TanxFeedAdView.this.iTanxFeedAd);
                }
            }
        });
        this.iTanxFeedAd.bindDislikeView(tanxc_for.tanxc_do(), new ITanxFeedAd.DislikeOnClickListener() {
            public void onClick(View view) {
                tanxc_for.tanxc_for();
            }
        });
    }

    public TanxFeedAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nowMediaRenderingMode = null;
        View inflate = LayoutInflater.from(context).inflate(R.layout.tanx_layout_ad_feed, this, true);
        this.v = inflate;
        this.tvTitle = (TitleTextView) inflate.findViewById(R.id.tv_title);
        this.llRoot = (LinearLayout) this.v.findViewById(R.id.ll_root);
        this.bottomView = (BottomView) this.v.findViewById(R.id.bottomView);
        this.ivAd = (TanxImageView) this.v.findViewById(R.id.iv_ad);
        this.ivAdLogo = (ImageView) this.v.findViewById(R.id.iv_ad_logo);
        this.flAdContentRoot = (FrameLayout) this.v.findViewById(R.id.fl_ad_content_root);
    }
}
