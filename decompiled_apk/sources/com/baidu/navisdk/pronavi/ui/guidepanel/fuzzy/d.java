package com.baidu.navisdk.pronavi.ui.guidepanel.fuzzy;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes7.dex */
public class d extends b {

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public a(d dVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public d(Context context, ViewGroup viewGroup) {
        this(context, viewGroup, null);
    }

    private void x0() {
        if (this.i != null) {
            com.baidu.navisdk.module.newguide.a.e().a(this.i);
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.guidepanel.fuzzy.b
    public void B(boolean z) {
        ViewGroup viewGroup = this.b;
        if (viewGroup == null) {
            return;
        }
        ViewStub viewStub = (ViewStub) viewGroup.findViewById(R.id.nsdk_layout_rg_mapmode_main_sub_fuzzy_guide_stub);
        if (viewStub != null) {
            viewStub.inflate();
        }
        ViewGroup viewGroup2 = (ViewGroup) this.b.findViewById(R.id.nsdk_layout_rg_mapmode_main_sub_fuzzy_guide_panel);
        this.i = viewGroup2;
        viewGroup2.setOnClickListener(new a(this));
        x0();
        this.k = (ImageView) this.i.findViewById(R.id.fuzzy_logo);
        this.j = (TextView) this.i.findViewById(R.id.fuzzy_tv);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
        x0();
    }

    @Override // com.baidu.navisdk.pronavi.ui.guidepanel.fuzzy.a
    public void n0() {
        ViewGroup viewGroup = this.i;
        if (viewGroup != null && viewGroup.isShown()) {
            AnimationSet animationSet = new AnimationSet(true);
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.4f, 1.0f, 0.4f, 1, 0.0f, 1, 0.0f);
            scaleAnimation.setDuration(550L);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.3f);
            alphaAnimation.setDuration(550L);
            animationSet.addAnimation(scaleAnimation);
            animationSet.addAnimation(alphaAnimation);
            ImageView imageView = this.k;
            if (imageView != null && this.j != null) {
                imageView.clearAnimation();
                this.j.clearAnimation();
                this.k.startAnimation(animationSet);
                this.j.startAnimation(animationSet);
            }
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.guidepanel.fuzzy.b
    public String u0() {
        return "RGMMFuzzyGuideViewNew";
    }

    @Override // com.baidu.navisdk.pronavi.ui.guidepanel.fuzzy.b, com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMFuzzyGuideViewNew", "RGMMFuzzyGuideView show()");
        }
        x.b().E4();
        return super.y();
    }

    public d(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
    }
}
