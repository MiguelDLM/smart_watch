package com.kwad.sdk.a.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.l;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bj;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class e implements View.OnClickListener {
    private final boolean amM;
    private final boolean amN;
    private View amO;
    private ImageView amP;
    private TextView amQ;
    private Button amR;
    private int amS;
    private int amT;
    private boolean amU;
    private final AdInfo mAdInfo;

    @NonNull
    private final AdTemplate mAdTemplate;

    @NonNull
    private final Context mContext;

    @NonNull
    private View mRootView = AC();

    public e(@NonNull Context context, @NonNull AdTemplate adTemplate, boolean z, boolean z2, boolean z3) {
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dS(adTemplate);
        this.amM = z;
        this.amN = z2;
        this.amU = z3;
        mr();
    }

    @SuppressLint({"InflateParams"})
    private View AC() {
        if (this.amM && this.amN) {
            this.mRootView = l.inflate(this.mContext, R.layout.ksad_install_tips_bottom, null);
        } else {
            this.mRootView = l.inflate(this.mContext, R.layout.ksad_install_tips, null);
        }
        ViewCompat.setElevation(this.mRootView, this.mContext.getResources().getDimension(R.dimen.ksad_install_tips_card_elevation));
        this.amO = this.mRootView.findViewById(R.id.ksad_install_tips_close);
        this.amP = (ImageView) this.mRootView.findViewById(R.id.ksad_install_tips_icon);
        this.amQ = (TextView) this.mRootView.findViewById(R.id.ksad_install_tips_content);
        this.amR = (Button) this.mRootView.findViewById(R.id.ksad_install_tips_install);
        return this.mRootView;
    }

    private Animator B(View view) {
        ObjectAnimator ofFloat;
        if (this.amM && this.amN) {
            ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_X, 0.0f, this.amT);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, 0.0f, -this.amS);
        }
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.42f, 0.85f, 0.64f));
        ofFloat.setDuration(260L);
        return ofFloat;
    }

    private void c(FrameLayout frameLayout) {
        FrameLayout.LayoutParams layoutParams;
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_card_height);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_card_margin);
        this.amS = dimensionPixelSize + dimensionPixelSize2;
        ViewGroup.LayoutParams layoutParams2 = this.mRootView.getLayoutParams();
        if (layoutParams2 instanceof FrameLayout.LayoutParams) {
            layoutParams = (FrameLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new FrameLayout.LayoutParams(-1, dimensionPixelSize);
        }
        layoutParams.gravity = 48;
        layoutParams.leftMargin = dimensionPixelSize2;
        layoutParams.rightMargin = dimensionPixelSize2;
        layoutParams.topMargin = dimensionPixelSize2;
        this.mRootView.setTranslationY(-this.amS);
        frameLayout.addView(this.mRootView, layoutParams);
        show();
    }

    private void d(FrameLayout frameLayout) {
        FrameLayout.LayoutParams layoutParams;
        int screenWidth = bj.getScreenWidth(this.mContext);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_bottom_margin_left);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_bottom_margin_bottom);
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.ksad_install_tips_bottom_height);
        this.amT = screenWidth - dimensionPixelSize;
        ViewGroup.LayoutParams layoutParams2 = this.mRootView.getLayoutParams();
        if (layoutParams2 instanceof FrameLayout.LayoutParams) {
            layoutParams = (FrameLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new FrameLayout.LayoutParams(-1, dimensionPixelOffset);
        }
        layoutParams.gravity = 80;
        layoutParams.leftMargin = dimensionPixelSize;
        layoutParams.rightMargin = 0;
        layoutParams.bottomMargin = dimensionPixelSize2;
        this.mRootView.setTranslationX(this.amT);
        frameLayout.addView(this.mRootView, layoutParams);
        show();
    }

    private void mr() {
        String str;
        int i;
        Button button = this.amR;
        if (this.amM) {
            str = "安装";
        } else {
            str = "打开";
        }
        button.setText(str);
        this.amO.setOnClickListener(this);
        this.amR.setOnClickListener(this);
        KSImageLoader.loadAppIcon(this.amP, com.kwad.sdk.core.response.b.a.cg(com.kwad.sdk.core.response.b.e.dS(this.mAdTemplate)), this.mAdTemplate, 8);
        String au = com.kwad.sdk.core.response.b.a.au(com.kwad.sdk.core.response.b.e.dS(this.mAdTemplate));
        if (au.length() >= 8) {
            au = au.substring(0, 7) + "...";
        }
        Context context = this.mContext;
        if (this.amM) {
            i = R.string.ksad_install_tips;
        } else {
            i = R.string.ksad_launch_tips;
        }
        this.amQ.setText(context.getString(i, au));
    }

    private void show() {
        ObjectAnimator ofFloat;
        if (this.amM && this.amN) {
            ofFloat = ObjectAnimator.ofFloat(this.mRootView, (Property<View, Float>) View.TRANSLATION_X, this.amT, 0.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(this.mRootView, (Property<View, Float>) View.TRANSLATION_Y, -this.amS, 0.0f);
        }
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.27f, 0.87f));
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    public final void dismiss() {
        if (this.mRootView.getParent() == null) {
            return;
        }
        final ViewGroup viewGroup = (ViewGroup) this.mRootView.getParent();
        Animator B = B(this.mRootView);
        B.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.a.a.e.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                viewGroup.removeView(e.this.mRootView);
            }
        });
        B.start();
        c.Au().Az();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        dismiss();
        if (view.getId() == R.id.ksad_install_tips_install) {
            if (this.amM) {
                if (this.amU) {
                    com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                    bVar.cM(29);
                    bVar.cT(23);
                    com.kwad.sdk.core.adlog.c.e(this.mAdTemplate, (JSONObject) null, bVar);
                } else {
                    com.kwad.sdk.core.adlog.c.o(this.mAdTemplate, 45);
                }
                al.a(com.kwad.sdk.core.response.b.a.H(this.mAdInfo), new al.a() { // from class: com.kwad.sdk.a.a.e.3
                    @Override // com.kwad.sdk.utils.al.a
                    public final void d(Throwable th) {
                        com.kwad.sdk.commercial.a.a.i(e.this.mAdTemplate, 100003, Log.getStackTraceString(th));
                    }

                    @Override // com.kwad.sdk.utils.al.a
                    public final void oK() {
                        com.kwad.sdk.core.adlog.c.h(e.this.mAdTemplate, 1);
                        com.kwad.sdk.commercial.a.a.aZ(e.this.mAdTemplate);
                    }
                });
                return;
            }
            if (al.ap(this.mContext, com.kwad.sdk.core.response.b.a.ax(this.mAdInfo))) {
                com.kwad.sdk.core.adlog.c.bJ(this.mAdTemplate);
            }
            com.kwad.sdk.core.adlog.c.n(this.mAdTemplate, 47);
            return;
        }
        if (view.getId() == R.id.ksad_install_tips_close) {
            if (this.amM) {
                if (this.amU) {
                    com.kwad.sdk.core.adlog.c.b bVar2 = new com.kwad.sdk.core.adlog.c.b();
                    bVar2.cM(69);
                    bVar2.cT(23);
                    bVar2.cX(1);
                    com.kwad.sdk.core.adlog.c.e(this.mAdTemplate, (JSONObject) null, bVar2);
                    return;
                }
                com.kwad.sdk.core.adlog.c.o(this.mAdTemplate, 46);
                return;
            }
            com.kwad.sdk.core.adlog.c.n(this.mAdTemplate, 48);
        }
    }

    public final void b(FrameLayout frameLayout) {
        if (this.mRootView.getParent() != null) {
            return;
        }
        if (this.amM && this.amN) {
            d(frameLayout);
        } else {
            c(frameLayout);
        }
        this.mRootView.postDelayed(new az() { // from class: com.kwad.sdk.a.a.e.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                e.this.dismiss();
            }
        }, 10000L);
    }
}
