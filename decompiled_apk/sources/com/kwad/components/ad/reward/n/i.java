package com.kwad.components.ad.reward.n;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.core.widget.KsStyledTextButton;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.utils.aj;

/* loaded from: classes11.dex */
public final class i extends d implements View.OnClickListener {

    @Nullable
    private TextView hz;

    @Nullable
    private KSCornerImageView lv;

    @Nullable
    private TextView lw;

    @Nullable
    private KsLogoView mLogoView;
    private com.kwad.components.ad.reward.g qp;
    private ViewGroup sA;
    private ViewGroup yH;

    @Nullable
    private KsPriceView yI;

    @Nullable
    private TextView yJ;

    @Nullable
    private KsStyledTextButton yK;

    @Nullable
    private TextView yL;

    @Nullable
    private TextView yM;

    @Nullable
    private View yN;

    @Nullable
    private ImageView yO;

    /* loaded from: classes11.dex */
    public static class a {
        private String kZ;
        private String qb;
        private String qc;
        private String rS;
        private String rating;
        private String title;
        private String yY;

        @Nullable
        private String yZ;
        private String za;
        private String zb;

        private a() {
        }

        private void M(String str) {
            this.rS = str;
        }

        public static a Q(AdTemplate adTemplate) {
            CouponInfo firstCouponList;
            AdInfo dS = com.kwad.sdk.core.response.b.e.dS(adTemplate);
            AdProductInfo cQ = com.kwad.sdk.core.response.b.a.cQ(dS);
            a aVar = new a();
            String name = cQ.getName();
            aVar.title = name;
            if (TextUtils.isEmpty(name)) {
                aVar.title = com.kwad.sdk.core.response.b.a.aw(dS);
            }
            aVar.za = com.kwad.sdk.core.response.b.a.aD(dS);
            aVar.qb = cQ.getIcon();
            aVar.qc = com.kwad.sdk.core.response.b.a.at(dS);
            aVar.yY = cQ.getPrice();
            aVar.kZ = cQ.getOriginPrice();
            aVar.zb = cQ.getVolume();
            aVar.rating = cQ.getRating();
            if (!cQ.isCouponListEmpty() && (firstCouponList = cQ.getFirstCouponList()) != null) {
                aVar.yZ = CouponInfo.jinniuFormatCoupon(firstCouponList);
                aVar.M(firstCouponList.getFormattedJinniuPrefix());
            }
            return aVar;
        }

        public final String dA() {
            return this.kZ;
        }

        public final String gY() {
            return this.rS;
        }

        public final String getRating() {
            return this.rating;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String gg() {
            return this.qb;
        }

        public final String gh() {
            return this.qc;
        }

        public final String jW() {
            return this.yY;
        }

        public final String jX() {
            return this.yZ;
        }

        public final String jY() {
            return this.za;
        }

        public final String jZ() {
            return this.zb;
        }
    }

    public i(com.kwad.components.ad.reward.g gVar, ViewGroup viewGroup, KsLogoView ksLogoView) {
        this.qp = gVar;
        this.mLogoView = ksLogoView;
        this.yH = viewGroup;
        initView();
    }

    public static /* synthetic */ Animator a(i iVar, View view, float f) {
        return a(view, f);
    }

    private void initView() {
        this.sA = (ViewGroup) this.yH.findViewById(R.id.ksad_reward_jinniu_root);
        this.lv = (KSCornerImageView) this.yH.findViewById(R.id.ksad_reward_jinniu_icon);
        this.hz = (TextView) this.yH.findViewById(R.id.ksad_reward_jinniu_title);
        this.lw = (TextView) this.yH.findViewById(R.id.ksad_reward_jinniu_desc);
        this.yI = (KsPriceView) this.yH.findViewById(R.id.ksad_reward_jinniu_price);
        this.yJ = (TextView) this.yH.findViewById(R.id.ksad_reward_jinniu_right_label);
        this.yK = (KsStyledTextButton) this.yH.findViewById(R.id.ksad_reward_jinniu_btn_buy);
        this.yO = (ImageView) this.yH.findViewById(R.id.ksad_reward_jinniu_light_sweep);
        this.yN = this.yH.findViewById(R.id.ksad_reward_jinniu_coupon_layout);
        this.yL = (TextView) this.yH.findViewById(R.id.ksad_reward_jinniu_coupon);
        this.yM = (TextView) this.yH.findViewById(R.id.ksad_reward_jinniu_coupon_prefix);
        this.sA.setOnClickListener(this);
        KsStyledTextButton ksStyledTextButton = this.yK;
        if (ksStyledTextButton != null) {
            ksStyledTextButton.setOnClickListener(this);
        }
        Context context = this.sA.getContext();
        if (!aj.ML()) {
            ViewGroup.LayoutParams layoutParams = this.sA.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_follow_card_width_horizontal);
                this.sA.setLayoutParams(layoutParams2);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup gG() {
        return this.sA;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.equals(this.sA)) {
            this.qp.a(1, view.getContext(), 118, 2);
        } else if (view.equals(this.yK)) {
            this.qp.a(1, view.getContext(), 1, 1);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        if (rVar == null) {
            return;
        }
        a(rVar.getAdTemplate(), a.Q(rVar.getAdTemplate()));
        ViewGroup viewGroup = this.sA;
        if (viewGroup != null) {
            viewGroup.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.n.i.1
                @Override // java.lang.Runnable
                public final void run() {
                    i iVar = i.this;
                    Animator a2 = iVar.a(iVar.sA, i.this.yK, i.this.mLogoView);
                    if (a2 != null) {
                        a2.start();
                    }
                }
            }, 3000L);
            this.sA.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.n.i.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (i.this.yK != null && i.this.yK.getWidth() != 0) {
                        float width = i.this.yK.getWidth();
                        i iVar = i.this;
                        final Animator a2 = i.a(iVar, iVar.yO, width);
                        if (a2 != null) {
                            a2.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.n.i.2.1
                                private int yQ = 1;

                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public final void onAnimationEnd(Animator animator) {
                                    super.onAnimationEnd(animator);
                                    if (this.yQ >= 3) {
                                        return;
                                    }
                                    a2.start();
                                    this.yQ++;
                                }
                            });
                            a2.start();
                        }
                    }
                }
            }, 5000L);
        }
    }

    private void a(AdTemplate adTemplate, a aVar) {
        if (aVar == null) {
            return;
        }
        KSImageLoader.loadAppIcon(this.lv, aVar.gg(), adTemplate, 4);
        TextView textView = this.hz;
        if (textView != null) {
            textView.setText(aVar.getTitle());
        }
        TextView textView2 = this.lw;
        if (textView2 != null) {
            textView2.setText(aVar.gh());
        }
        KsPriceView ksPriceView = this.yI;
        if (ksPriceView != null) {
            int dimensionPixelSize = ksPriceView.getResources().getDimensionPixelSize(R.dimen.ksad_reward_jinniu_end_origin_text_size);
            this.yI.getConfig().ae(dimensionPixelSize).ag(dimensionPixelSize).af(this.yI.getResources().getColor(R.color.ksad_jinniu_end_origin_color));
            this.yI.d(aVar.jW(), aVar.dA(), true);
        }
        if (this.yJ != null) {
            if (!TextUtils.isEmpty(aVar.jZ())) {
                this.yJ.setText(aVar.jZ());
            } else if (!TextUtils.isEmpty(aVar.getRating())) {
                this.yJ.setText(aVar.getRating());
            } else {
                this.yJ.setVisibility(8);
            }
        }
        if (this.yL != null && !TextUtils.isEmpty(aVar.jX())) {
            this.yL.setText(aVar.jX());
        }
        if (this.yK != null && !TextUtils.isEmpty(aVar.jY())) {
            this.yK.setText(aVar.jY());
        }
        int i = TextUtils.isEmpty(aVar.jX()) ? 8 : 0;
        View view = this.yN;
        if (view != null) {
            view.setVisibility(i);
        }
        if (this.yM == null || TextUtils.isEmpty(aVar.gY())) {
            return;
        }
        this.yM.setText(aVar.gY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public Animator a(final View view, View view2, final View view3) {
        final int height = view.getHeight();
        if (height <= 0 || view.getLayoutParams() == null) {
            return null;
        }
        Interpolator create = PathInterpolatorCompat.create(0.51f, 0.0f, 0.67f, 1.0f);
        ValueAnimator duration = ValueAnimator.ofInt(height, view.getResources().getDimensionPixelSize(R.dimen.ksad_reward_jinniu_card_height_full)).setDuration(500L);
        duration.setInterpolator(create);
        view.getContext();
        if (aj.ML() && view3 != null && (view3.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view3.getLayoutParams();
            final int i = marginLayoutParams.bottomMargin;
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.n.i.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    int i2 = intValue - height;
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
                    marginLayoutParams2.bottomMargin = i + i2;
                    view3.setLayoutParams(marginLayoutParams2);
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = intValue;
                        view.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view2, "alpha", 0.0f, 0.0f).setDuration(200L);
        Interpolator create2 = PathInterpolatorCompat.create(0.86f, 0.0f, 0.83f, 1.0f);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view2, "alpha", 0.0f, 1.0f).setDuration(300L);
        duration3.setInterpolator(create2);
        animatorSet.playSequentially(duration2, duration3);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(duration, animatorSet);
        return animatorSet2;
    }

    @Nullable
    private static Animator a(View view, float f) {
        if (view == null || view.getWidth() <= 0) {
            return null;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationX", view.getResources().getDimension(R.dimen.ksad_jinniu_light_sweep_width) + f).setDuration(1000L);
        duration.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f).setDuration(1000L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(duration, duration2);
        return animatorSet;
    }
}
