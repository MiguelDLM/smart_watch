package com.kwad.components.ad.widget.tailframe.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.ad.widget.KsAppTagsView;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.R;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.l;
import java.util.List;

/* loaded from: classes11.dex */
public abstract class a extends LinearLayout {
    protected TextProgressBar BI;
    protected AppScoreView Bs;
    protected View HJ;
    protected TextView IT;
    protected TextView dH;
    protected ValueAnimator jo;
    protected ImageView kT;
    protected TextView kU;
    protected View yb;
    protected Button yc;
    protected Button yd;
    protected KsAppTagsView yj;
    protected com.kwad.components.ad.j.a ym;
    private Runnable yn;

    public a(Context context) {
        this(context, null);
    }

    private void initView() {
        this.HJ = l.inflate(getContext(), getLayoutId(), this);
        this.kT = (ImageView) findViewById(R.id.ksad_app_icon);
        this.kU = (TextView) findViewById(R.id.ksad_app_name);
        this.Bs = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.dH = (TextView) findViewById(R.id.ksad_app_download_count);
        this.IT = (TextView) findViewById(R.id.ksad_app_introduce);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_download_bar);
        this.BI = textProgressBar;
        textProgressBar.setTextDimen(com.kwad.sdk.c.a.a.a(getContext(), 16.0f));
        this.BI.setTextColor(-1);
        this.yj = (KsAppTagsView) findViewById(R.id.ksad_reward_apk_info_tags);
        this.yc = (Button) findViewById(R.id.ksad_reward_apk_info_install_action);
        this.yd = (Button) findViewById(R.id.ksad_reward_apk_info_install_start);
        this.yb = findViewById(R.id.ksad_reward_apk_info_install_container);
        this.ym = new com.kwad.components.ad.j.a(this.HJ);
    }

    private void mQ() {
        ValueAnimator valueAnimator = this.jo;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
        this.jo = ofFloat;
        ofFloat.setDuration(1200L);
        this.jo.setRepeatCount(-1);
        this.jo.setRepeatMode(1);
        this.jo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.widget.tailframe.appbar.a.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                a.this.BI.setScaleY(floatValue);
                a.this.BI.setScaleX(floatValue);
            }
        });
        this.jo.start();
    }

    public final void D(@NonNull AdInfo adInfo) {
        int i = adInfo.status;
        if (i != 1 && i != 2 && i != 3) {
            mQ();
        } else {
            kn();
        }
    }

    public void b(@NonNull AdTemplate adTemplate) {
        AdInfo dS = e.dS(adTemplate);
        if (e.F(adTemplate)) {
            KSImageLoader.loadAppIcon(this.kT, com.kwad.sdk.core.response.b.a.cJ(dS), adTemplate, 12);
        } else {
            KSImageLoader.loadAppIcon(this.kT, com.kwad.sdk.core.response.b.a.cg(dS), adTemplate, 12);
        }
        this.kU.setText(com.kwad.sdk.core.response.b.a.cd(dS));
        if (!e.F(adTemplate)) {
            float az = com.kwad.sdk.core.response.b.a.az(dS);
            if (az >= 3.0f) {
                this.Bs.setScore(az);
                this.Bs.setVisibility(0);
            } else {
                this.Bs.setVisibility(8);
            }
            String ay = com.kwad.sdk.core.response.b.a.ay(dS);
            if (!TextUtils.isEmpty(ay)) {
                this.dH.setText(ay);
                this.dH.setVisibility(0);
            } else {
                this.dH.setVisibility(8);
            }
        }
        this.IT.setText(com.kwad.sdk.core.response.b.a.at(dS));
        if (e.F(adTemplate)) {
            this.BI.setVisibility(8);
            this.yb.setVisibility(0);
            this.yd.setText("查看详情");
            Button button = this.yc;
            StringBuilder sb = new StringBuilder();
            sb.append(d.CQ());
            button.setText(String.format("浏览详情页%s秒，领取奖励", sb.toString()));
            if (!adTemplate.mRewardVerifyCalled) {
                if (this.yn == null) {
                    this.yn = new Runnable() { // from class: com.kwad.components.ad.widget.tailframe.appbar.a.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.ym.hU();
                        }
                    };
                }
                this.yb.postDelayed(this.yn, 1600L);
            }
        } else {
            this.BI.setVisibility(0);
            this.yb.setVisibility(8);
            Runnable runnable = this.yn;
            if (runnable != null) {
                this.yb.removeCallbacks(runnable);
                this.yn = null;
            }
            D(e.dS(adTemplate));
        }
        if (e.F(adTemplate)) {
            List<String> dJ = com.kwad.sdk.core.response.b.d.dJ(adTemplate);
            if (dJ.size() > 0) {
                this.yj.setVisibility(0);
            } else {
                this.yj.setVisibility(8);
            }
            this.yj.setAppTags(dJ);
        }
    }

    public View getBtnInstallContainer() {
        return this.yb;
    }

    @LayoutRes
    public abstract int getLayoutId();

    public TextProgressBar getTextProgressBar() {
        return this.BI;
    }

    public final void kn() {
        ValueAnimator valueAnimator = this.jo;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.jo.cancel();
            this.jo.end();
        }
        Runnable runnable = this.yn;
        if (runnable != null) {
            this.yb.removeCallbacks(runnable);
            this.yn = null;
        }
        this.ym.mB();
    }

    public a(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(l.wrapContextIfNeed(context), attributeSet, i);
        initView();
    }
}
