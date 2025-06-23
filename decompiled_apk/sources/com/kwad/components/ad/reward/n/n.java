package com.kwad.components.ad.reward.n;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.ad.reward.widget.KSCouponLabelTextView;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bh;

/* loaded from: classes11.dex */
public final class n extends d implements View.OnClickListener {
    private ViewGroup gS;
    private TextView yB;
    private KSCornerImageView zA;
    private LinearLayout zB;
    private KsPriceView zC;
    private TextView zD;
    private View zE;
    private KSCornerImageView zF;
    private b zG;
    private a zH;
    private ViewGroup zu;

    /* loaded from: classes11.dex */
    public interface a {
        void hu();
    }

    public n(ViewGroup viewGroup, b bVar) {
        this.gS = viewGroup;
        this.zG = bVar;
        initView();
    }

    public static /* synthetic */ View a(n nVar, Context context, CouponInfo couponInfo, ViewGroup viewGroup) {
        return a(context, couponInfo, viewGroup);
    }

    private void initView() {
        this.zu = (ViewGroup) this.gS.findViewById(R.id.ksad_reward_order_root);
        this.zA = (KSCornerImageView) this.gS.findViewById(R.id.ksad_reward_order_icon);
        this.yB = (TextView) this.gS.findViewById(R.id.ksad_reward_order_title);
        this.zB = (LinearLayout) this.gS.findViewById(R.id.ksad_reward_order_coupon_list);
        this.zC = (KsPriceView) this.gS.findViewById(R.id.ksad_reward_order_price);
        this.zD = (TextView) this.gS.findViewById(R.id.ksad_reward_order_btn_buy);
        this.zE = this.gS.findViewById(R.id.ksad_reward_order_text_area);
        this.zF = (KSCornerImageView) this.gS.findViewById(R.id.ksad_reward_order_kwai_logo);
        this.zD.setText(com.kwad.components.ad.d.b.Y());
        this.zD.setOnClickListener(this);
        this.zA.setOnClickListener(this);
        this.zE.setOnClickListener(this);
        Context context = this.gS.getContext();
        if (!aj.ML()) {
            ViewGroup.LayoutParams layoutParams = this.gS.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_follow_card_width_horizontal);
                this.gS.setLayoutParams(layoutParams2);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup gG() {
        return this.zu;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.zG == null) {
            return;
        }
        if (view.equals(this.zD)) {
            this.zG.gK();
        } else if (view.equals(this.zA)) {
            this.zG.ii();
        } else if (view.equals(this.zE)) {
            this.zG.ij();
        }
    }

    public final void a(a aVar) {
        this.zH = aVar;
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        a(com.kwad.sdk.core.response.b.a.cQ(com.kwad.sdk.core.response.b.e.dS(rVar.getAdTemplate())), rVar.getAdTemplate());
    }

    private void a(final AdProductInfo adProductInfo, AdTemplate adTemplate) {
        KSImageLoader.loadImage(this.zA, adProductInfo.getIcon(), adTemplate);
        this.yB.setText(adProductInfo.getName());
        if (adProductInfo.isCouponListEmpty()) {
            this.zB.setVisibility(8);
            this.zH.hu();
        } else {
            this.zB.setVisibility(0);
            this.zB.post(new az() { // from class: com.kwad.components.ad.reward.n.n.1
                @Override // com.kwad.sdk.utils.az
                public final void doTask() {
                    for (CouponInfo couponInfo : adProductInfo.getCouponList()) {
                        n nVar = n.this;
                        View a2 = n.a(nVar, nVar.zB.getContext(), couponInfo, n.this.zB);
                        ViewGroup.LayoutParams layoutParams = a2.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new ViewGroup.LayoutParams(-2, -1);
                        } else {
                            layoutParams.width = -2;
                            layoutParams.height = -1;
                        }
                        n.this.zB.addView(a2, layoutParams);
                        com.kwad.components.core.s.i.a(new com.kwad.components.core.widget.e(), n.this.zB);
                    }
                    if (n.this.zH != null) {
                        if (n.this.zB.getChildCount() > 0) {
                            n.this.zB.getChildAt(0).post(new az() { // from class: com.kwad.components.ad.reward.n.n.1.1
                                @Override // com.kwad.sdk.utils.az
                                public final void doTask() {
                                    n.this.zH.hu();
                                }
                            });
                        } else {
                            n.this.zH.hu();
                        }
                    }
                }
            });
        }
        this.zC.h(adProductInfo.getPrice(), adProductInfo.getOriginPrice());
        String Z = com.kwad.components.ad.d.b.Z();
        if (bh.isNullString(Z)) {
            return;
        }
        KSImageLoader.loadImage(this.zF, Z, adTemplate);
    }

    private static View a(Context context, CouponInfo couponInfo, ViewGroup viewGroup) {
        KSCouponLabelTextView kSCouponLabelTextView = (KSCouponLabelTextView) com.kwad.sdk.n.l.a(context, R.layout.ksad_reward_order_card_coupon, viewGroup, false);
        kSCouponLabelTextView.setText(couponInfo.getDisplayName());
        return kSCouponLabelTextView;
    }
}
