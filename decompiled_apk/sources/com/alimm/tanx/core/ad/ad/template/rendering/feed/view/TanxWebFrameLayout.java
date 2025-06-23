package com.alimm.tanx.core.ad.ad.template.rendering.feed.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.alimm.tanx.core.R;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.FeedWebViewUtil;
import com.alimm.tanx.core.ad.listener.ViewClickListener;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.image.util.GifConfig;
import com.alimm.tanx.core.image.util.ImageConfig;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.ut.impl.TanxCommonUt;
import com.alimm.tanx.core.ut.impl.TanxFeedUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;

/* loaded from: classes.dex */
public class TanxWebFrameLayout extends FrameLayout implements NotConfused {
    private final String TAG;
    protected WebView addView;
    protected Button btnReLoadH5;
    private boolean errorCreateViewUtUpload;
    protected ITanxAd iTanxFeedAd;
    private volatile boolean isH5Ut;
    private boolean isShowWebStatusUi;
    private boolean isTemplateRender;
    protected ImageView ivLoading;
    protected LinearLayout llWeb;
    protected LinearLayout llWebError;
    protected LinearLayout llWebLoading;
    protected TanxAdView parentTanxAdView;
    float radio;
    protected RelativeLayout rlRoot;
    protected View v;
    protected FeedWebViewUtil webViewUtil;

    public TanxWebFrameLayout(Context context) {
        this(context, null);
    }

    private void errorCreateViewUt() {
        if (!this.errorCreateViewUtUpload) {
            this.errorCreateViewUtUpload = true;
            TanxFeedUt.utViewDraw(this.iTanxFeedAd, 0);
        }
    }

    private void initClick(final boolean z) {
        this.btnReLoadH5.setOnClickListener(new ViewClickListener() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout.1
            @Override // com.alimm.tanx.core.ad.listener.ViewClickListener
            public void viewClick(View view) {
                TanxWebFrameLayout.this.showErrorUi(false);
                TanxWebFrameLayout.this.loadWeb(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loading$5(boolean z) {
        if (!this.isShowWebStatusUi) {
            return;
        }
        if (z) {
            TanxCoreSdk.getConfig().getImageLoader().loadGif(new GifConfig(this.ivLoading, R.drawable.tanx_loading), new ImageConfig.GifCallback() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout.3
                @Override // com.alimm.tanx.core.image.util.ImageConfig.GifCallback
                public void onFailure(String str) {
                }

                @Override // com.alimm.tanx.core.image.util.ImageConfig.GifCallback
                public void onSuccess() {
                }
            });
            this.llWebLoading.setVisibility(0);
            return;
        }
        this.llWebLoading.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showErrorUi$4(boolean z) {
        if (z) {
            if (this.isShowWebStatusUi) {
                this.llWebError.setVisibility(0);
            } else {
                setVisibility(8);
            }
            errorCreateViewUt();
            return;
        }
        this.llWebError.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadWeb(boolean z) {
        loading(true);
        TanxCommonUt.utWebStartLoad(this.iTanxFeedAd);
        FeedWebViewUtil feedWebViewUtil = new FeedWebViewUtil();
        this.webViewUtil = feedWebViewUtil;
        feedWebViewUtil.tanxc_do(this.llWeb, z, this.iTanxFeedAd, this.parentTanxAdView, new FeedWebViewUtil.FeedWebInterface() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout.2
            @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
            public void adClose() {
            }

            @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
            public void adSkip(boolean z2) {
            }

            @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
            public void h5NotifyDrawSuccess() {
                TanxWebFrameLayout.this.showErrorUi(false);
                TanxFeedUt.utViewDraw(TanxWebFrameLayout.this.iTanxFeedAd, 1);
                TanxWebFrameLayout.this.iTanxFeedAd.onResourceLoadSuccess();
            }

            @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
            public void webDrawStatus(boolean z2) {
                if (z2) {
                    LogUtils.d("utLog", "utViewDraw");
                } else {
                    if (!TanxWebFrameLayout.this.isH5Ut) {
                        TanxBaseUt.utErrorCode(TanxWebFrameLayout.this.iTanxFeedAd, UtErrorCode.CRASH_H5_ERROR);
                        TanxWebFrameLayout.this.isH5Ut = true;
                    }
                    TanxWebFrameLayout.this.showErrorUi(true);
                }
                TanxWebFrameLayout.this.loading(false);
            }

            @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
            public void webError(int i, String str) {
                LogUtils.e("TanxWebFrameLayout", "webError: cmd :" + i + " msg:" + str);
                TanxWebFrameLayout.this.showErrorUi(true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loading(final boolean z) {
        this.llWebLoading.post(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.feed.view.oIX0oI
            @Override // java.lang.Runnable
            public final void run() {
                TanxWebFrameLayout.this.lambda$loading$5(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showErrorUi(final boolean z) {
        this.llWebError.post(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.feed.view.II0xO0
            @Override // java.lang.Runnable
            public final void run() {
                TanxWebFrameLayout.this.lambda$showErrorUi$4(z);
            }
        });
    }

    public void loadAd(ITanxAd iTanxAd, boolean z, TanxAdView tanxAdView) {
        this.iTanxFeedAd = iTanxAd;
        this.parentTanxAdView = tanxAdView;
        this.errorCreateViewUtUpload = false;
        loadWeb(z);
        initClick(z);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.isTemplateRender) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i) * this.radio), 1073741824));
        } else {
            super.onMeasure(i, i2);
        }
    }

    public void setShowWebStatusUi(boolean z) {
        this.isShowWebStatusUi = z;
    }

    public void setTemplateRender(boolean z) {
        this.isTemplateRender = z;
    }

    public void setViewSize(float f) {
        this.radio = f;
    }

    public TanxWebFrameLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TanxWebFrameLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public TanxWebFrameLayout(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.TAG = "TanxWebFrameLayout";
        this.isH5Ut = false;
        this.errorCreateViewUtUpload = false;
        this.isShowWebStatusUi = true;
        this.isTemplateRender = true;
        this.radio = 0.56f;
        View inflate = LayoutInflater.from(context).inflate(R.layout.tanx_layout_ad_feed_item_web, (ViewGroup) this, true);
        this.v = inflate;
        this.rlRoot = (RelativeLayout) inflate.findViewById(R.id.rl_root);
        this.llWeb = (LinearLayout) this.v.findViewById(R.id.ll_web);
        this.llWebError = (LinearLayout) this.v.findViewById(R.id.ll_web_error);
        this.llWebLoading = (LinearLayout) this.v.findViewById(R.id.ll_web_loading);
        this.ivLoading = (ImageView) this.v.findViewById(R.id.iv_loading);
        this.btnReLoadH5 = (Button) this.v.findViewById(R.id.btn_re_load_h5);
    }
}
