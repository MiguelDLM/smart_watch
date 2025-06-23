package com.alimm.tanx.core.ad.ad.template.rendering.splash;

import android.app.Activity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.alimm.tanx.core.R;
import com.alimm.tanx.core.ad.bean.AdInfo;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.utils.LogUtils;

public class TanxSplashAdView extends TanxAdView {
    private static final String TAG = "TanxSplashAdView";
    private ITanxSplashExpressAd iTanxSplashExpressAd;
    private ImageView ivAd;
    private Activity mActivity;
    private AdInfo mAdInfo;
    private tanxc_do mAdRenderer;
    private boolean mIsColdStart;
    private IRenderCallback mRenderCallback;

    public TanxSplashAdView(Activity activity) {
        this(activity, (AttributeSet) null);
    }

    private void createAndStartRender(@NonNull BidInfo bidInfo) {
        if (this.mAdRenderer != null) {
            LogUtils.d(TAG, "createAndStartRender: has created render = " + this.mAdRenderer);
            return;
        }
        tanxc_for tanxc_for = new tanxc_for(this.mRenderCallback, this.mActivity, this, this.iTanxSplashExpressAd, this.mIsColdStart);
        this.mAdRenderer = tanxc_for;
        tanxc_for.tanxc_do(this.iTanxSplashExpressAd);
        if (this.mAdRenderer != null) {
            LogUtils.d(TAG, "0830_splash: ======= createAndStartRender ======" + System.currentTimeMillis());
            this.mAdRenderer.tanxc_do();
        }
    }

    public View getClickView() {
        tanxc_do tanxc_do = this.mAdRenderer;
        if (tanxc_do != null) {
            return tanxc_do.tanxc_goto();
        }
        return null;
    }

    public View getCloseView() {
        tanxc_do tanxc_do = this.mAdRenderer;
        if (tanxc_do != null) {
            return tanxc_do.tanxc_this();
        }
        return null;
    }

    public IRenderCallback getRenderCallback() {
        return this.mRenderCallback;
    }

    public ITanxSplashExpressAd getTanxSplashExpressAd() {
        return this.iTanxSplashExpressAd;
    }

    public void notifyViewClick() {
        tanxc_do tanxc_do = this.mAdRenderer;
        if (tanxc_do != null) {
            tanxc_do.tanxc_break();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void pauseTimer() {
        tanxc_do tanxc_do = this.mAdRenderer;
        if (tanxc_do != null) {
            tanxc_do.tanxc_try();
        }
    }

    public void removeAdView() {
        tanxc_do tanxc_do = this.mAdRenderer;
        if (tanxc_do != null) {
            tanxc_do.tanxc_case();
            this.mAdRenderer = null;
        }
    }

    public void resumeTimer() {
        tanxc_do tanxc_do = this.mAdRenderer;
        if (tanxc_do != null) {
            tanxc_do.tanxc_byte();
        }
    }

    public void setITanxSplashInteractionListener(ITanxSplashInteractionListener iTanxSplashInteractionListener) {
        tanxc_do tanxc_do = this.mAdRenderer;
        if (tanxc_do != null) {
            tanxc_do.tanxc_do(iTanxSplashInteractionListener);
        } else {
            LogUtils.e(TAG, "mAdRenderer为空，设置监听失败setiTanxSplashInteractionListener失败");
        }
    }

    public void setRenderCallback(IRenderCallback iRenderCallback) {
        this.mRenderCallback = iRenderCallback;
    }

    public void setTanxSplashExpressAd(ITanxSplashExpressAd iTanxSplashExpressAd2) {
        this.iTanxSplashExpressAd = iTanxSplashExpressAd2;
    }

    public void startShow(BidInfo bidInfo) {
        Activity activity;
        try {
            LogUtils.d(TAG, "startShow" + bidInfo);
            if (bidInfo != null) {
                LogUtils.d(TAG, "startShow" + bidInfo.getCreativePath());
                createAndStartRender(bidInfo);
            } else {
                LogUtils.e(TAG, "startShow bidInfo为空");
            }
            if (!this.mIsColdStart && (activity = this.mActivity) != null && (activity instanceof Activity) && activity.getResources().getConfiguration().orientation == 2) {
                LogUtils.d(TAG, "change screen orientation to portrait");
                this.mActivity.setRequestedOrientation(1);
            }
        } catch (Exception e) {
            LogUtils.e(TAG, e);
            e.printStackTrace();
        }
    }

    public TanxSplashAdView(Activity activity, AttributeSet attributeSet) {
        super(activity, attributeSet);
        this.mIsColdStart = true;
        try {
            this.mActivity = activity;
            final View inflate = LayoutInflater.from(activity).inflate(R.layout.xadsdk_new_layout_dialog_splash_ad, this, true);
            inflate.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    inflate.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            });
            ImageView imageView = (ImageView) findViewById(R.id.xadsdk_splash_ad_image_view);
            this.ivAd = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } catch (Exception e) {
            LogUtils.e(e);
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), e);
        }
    }
}
