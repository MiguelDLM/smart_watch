package com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.alimm.tanx.core.R;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashInteractionListener;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.image.ImageManager;
import com.alimm.tanx.core.image.util.ImageConfig;
import com.alimm.tanx.core.image.util.ScaleMode;
import com.alimm.tanx.core.image.util.TanxDrawable;
import com.alimm.tanx.core.utils.LogUtils;

/* loaded from: classes.dex */
public class tanxc_if extends tanxc_do {
    protected ITanxSplashInteractionListener tanxc_long;

    public tanxc_if(@NonNull com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do tanxc_doVar, @NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull ITanxAd iTanxAd) {
        super(tanxc_doVar, context, viewGroup, iTanxAd);
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do
    public void tanxc_byte() {
        BidInfo bidInfo;
        String str;
        super.tanxc_byte();
        View findViewById = this.tanxc_if.findViewById(R.id.splash_ad_click_message_container_ex);
        this.tanxc_if.findViewById(R.id.splash_ad_count_and_skip_container_ex);
        if (this.tanxc_for != null && this.tanxc_case) {
            TextView textView = (TextView) this.tanxc_goto.findViewById(R.id.splash_ad_txt_title);
            if (this.tanxc_for.getTemplateConf() != null && !TextUtils.isEmpty(this.tanxc_for.getTemplateConf().getActionText())) {
                str = this.tanxc_for.getTemplateConf().getActionText();
            } else {
                str = "点击跳转详情页或第三方应用";
            }
            textView.setText(str);
            findViewById.setVisibility(0);
            this.tanxc_goto.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_if.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    tanxc_if.this.tanxc_goto.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            });
        }
        final ImageView imageView = (ImageView) tanxc_long();
        if (imageView != null && (bidInfo = this.tanxc_for) != null && !TextUtils.isEmpty(bidInfo.getAdvLogo()) && ImageManager.getLoader() != null) {
            final ImageConfig build = ImageManager.with(this.tanxc_do).url(this.tanxc_for.getAdvLogo()).scaleMode(ScaleMode.CENTER_CROP).build();
            ImageManager.getLoader().load(build, new ImageConfig.ImageBitmapCallback() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_if.2
                @Override // com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback
                public void onFailure(String str2) {
                    LogUtils.d("DefaultTemplate", "loadImg: onFailure");
                    imageView.setVisibility(8);
                }

                @Override // com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback
                public void onSuccess(Bitmap bitmap) {
                    LogUtils.d("DefaultTemplate", "loadImg: Success");
                    imageView.setImageBitmap(bitmap);
                    imageView.setImageDrawable(new TanxDrawable(bitmap, build.getImageConfig()));
                }
            });
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do
    public View tanxc_char() {
        return null;
    }

    public void tanxc_do(ITanxSplashInteractionListener iTanxSplashInteractionListener) {
        this.tanxc_long = iTanxSplashInteractionListener;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do
    public View tanxc_else() {
        View view = this.tanxc_goto;
        if (view != null) {
            return view;
        }
        ViewGroup viewGroup = this.tanxc_if;
        if (viewGroup != null) {
            return viewGroup.findViewById(R.id.splash_ad_click_message_container);
        }
        return null;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do
    public View tanxc_goto() {
        View view = this.tanxc_else;
        if (view != null) {
            return view;
        }
        ViewGroup viewGroup = this.tanxc_if;
        if (viewGroup != null) {
            return viewGroup.findViewById(R.id.splash_ad_count_and_skip_container);
        }
        return null;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do
    public View tanxc_long() {
        ViewGroup viewGroup = this.tanxc_if;
        if (viewGroup != null) {
            return viewGroup.findViewById(R.id.iv_ad_logo);
        }
        return null;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do
    public int tanxc_try() {
        return R.id.xadsdk_splash_ad_stub_default;
    }
}
