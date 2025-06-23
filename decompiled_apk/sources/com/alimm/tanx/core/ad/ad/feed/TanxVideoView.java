package com.alimm.tanx.core.ad.ad.feed;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alimm.tanx.core.R;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout;
import com.alimm.tanx.core.utils.DimenUtil;
import com.alimm.tanx.core.view.player.ui.TanxPlayerView;

/* loaded from: classes.dex */
public class TanxVideoView extends TanxPlayerView {
    private static final String TAG = "TanxVideoView";
    private ITanxAd iTanxAd;
    private ITanxFeedVideoAdListener iTanxFeedVideoAdListener;
    private volatile boolean isLoadWeb;
    private ImageView ivDefaultPlayer;
    private View ivPlayer;
    private View.OnClickListener onClickListener;
    private TanxWebFrameLayout tanxWebFrameLayout;

    public TanxVideoView(@NonNull Context context) {
        super(context);
        this.isLoadWeb = false;
        initView();
    }

    private void initView() {
        TanxWebFrameLayout tanxWebFrameLayout = new TanxWebFrameLayout(getContext());
        this.tanxWebFrameLayout = tanxWebFrameLayout;
        tanxWebFrameLayout.setShowWebStatusUi(false);
        this.tanxWebFrameLayout.setTemplateRender(false);
        addView(this.tanxWebFrameLayout, new ViewGroup.LayoutParams(-1, -1));
        this.ivDefaultPlayer = new ImageView(getContext());
        int dp2px = DimenUtil.dp2px(getContext(), 30.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dp2px, dp2px);
        layoutParams.gravity = 17;
        this.ivDefaultPlayer.setLayoutParams(layoutParams);
        ImageView imageView = this.ivDefaultPlayer;
        this.ivPlayer = imageView;
        View.OnClickListener onClickListener = this.onClickListener;
        if (onClickListener != null) {
            imageView.setOnClickListener(onClickListener);
        }
        addView(this.ivPlayer, layoutParams);
    }

    @Override // com.alimm.tanx.core.ad.view.TanxAdView
    public boolean allowSettingViewSize() {
        return true;
    }

    @Override // com.alimm.tanx.core.view.player.ui.TanxPlayerView
    public void loadWeb() {
        if (!this.isLoadWeb) {
            super.loadWeb();
            this.tanxWebFrameLayout.loadAd(this.iTanxAd, false, this);
            this.isLoadWeb = true;
        }
    }

    @Override // com.alimm.tanx.core.ad.view.TanxAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void setLoadingType() {
        post(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.feed.TanxVideoView.2
            @Override // java.lang.Runnable
            public void run() {
                TanxVideoView.this.ivDefaultPlayer.setImageResource(R.mipmap.londing);
                TanxVideoView tanxVideoView = TanxVideoView.this;
                tanxVideoView.removeView(tanxVideoView.ivPlayer);
                if (TanxVideoView.this.iTanxFeedVideoAdListener != null) {
                    View onCustomLoadingIcon = TanxVideoView.this.iTanxFeedVideoAdListener.onCustomLoadingIcon();
                    if (onCustomLoadingIcon != null) {
                        TanxVideoView.this.ivPlayer = onCustomLoadingIcon;
                    } else {
                        TanxVideoView tanxVideoView2 = TanxVideoView.this;
                        tanxVideoView2.ivPlayer = tanxVideoView2.ivDefaultPlayer;
                    }
                }
                if (TanxVideoView.this.onClickListener != null) {
                    TanxVideoView.this.ivPlayer.setOnClickListener(TanxVideoView.this.onClickListener);
                }
                TanxVideoView tanxVideoView3 = TanxVideoView.this;
                tanxVideoView3.addView(tanxVideoView3.ivPlayer);
                TanxVideoView.this.ivPlayer.setVisibility(0);
            }
        });
    }

    public void setPauseType() {
        post(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.feed.TanxVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                TanxVideoView.this.ivDefaultPlayer.setImageResource(R.mipmap.pause);
                TanxVideoView tanxVideoView = TanxVideoView.this;
                tanxVideoView.removeView(tanxVideoView.ivPlayer);
                if (TanxVideoView.this.iTanxFeedVideoAdListener != null) {
                    View onCustomPlayIcon = TanxVideoView.this.iTanxFeedVideoAdListener.onCustomPlayIcon();
                    if (onCustomPlayIcon != null) {
                        TanxVideoView.this.ivPlayer = onCustomPlayIcon;
                    } else {
                        TanxVideoView tanxVideoView2 = TanxVideoView.this;
                        tanxVideoView2.ivPlayer = tanxVideoView2.ivDefaultPlayer;
                    }
                }
                if (TanxVideoView.this.onClickListener != null) {
                    TanxVideoView.this.ivPlayer.setOnClickListener(TanxVideoView.this.onClickListener);
                }
                TanxVideoView tanxVideoView3 = TanxVideoView.this;
                tanxVideoView3.addView(tanxVideoView3.ivPlayer);
                TanxVideoView.this.ivPlayer.setVisibility(0);
            }
        });
    }

    public void setPlayClickListener(View.OnClickListener onClickListener) {
        View view = this.ivPlayer;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
        this.onClickListener = onClickListener;
    }

    public void setPlayType() {
        post(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.feed.TanxVideoView.3
            @Override // java.lang.Runnable
            public void run() {
                TanxVideoView.this.ivPlayer.setVisibility(8);
            }
        });
    }

    public void setTanxAd(ITanxAd iTanxAd) {
        this.iTanxAd = iTanxAd;
    }

    public void setiTanxFeedVideoAdListener(ITanxFeedVideoAdListener iTanxFeedVideoAdListener) {
        this.iTanxFeedVideoAdListener = iTanxFeedVideoAdListener;
    }

    public TanxVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isLoadWeb = false;
    }

    public TanxVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isLoadWeb = false;
    }
}
