package com.baidu.navisdk.ugc.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.navisdk.util.common.ScreenUtil;

/* loaded from: classes8.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static ViewGroup f8337a;
    private static ImageView b;
    private static f c;
    private static View.OnClickListener d = new b();

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.c != null) {
                g.c.a(1);
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.u", "1", null, null);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f8338a;

        public c(View view) {
            this.f8338a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = Float.valueOf(valueAnimator.getAnimatedValue() + "").floatValue();
            ViewGroup.LayoutParams layoutParams = this.f8338a.getLayoutParams();
            layoutParams.height = (int) (((float) ScreenUtil.getInstance().dip2px(44)) * floatValue);
            this.f8338a.setLayoutParams(layoutParams);
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f8339a;

        public d(View view) {
            this.f8339a = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f8339a.setVisibility(0);
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f8340a;

        public e(View view) {
            this.f8340a = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f8340a.setVisibility(4);
        }
    }

    /* loaded from: classes8.dex */
    public interface f {
        void a(int i);
    }

    public static void c() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_OthersUgcMapsViewConstructor", "updateUgcReportBtn: ");
        }
        if (f8337a != null && b != null) {
            a(com.baidu.navisdk.framework.a.c().a(), f8337a, b);
        }
    }

    /* loaded from: classes8.dex */
    public class a implements com.baidu.navisdk.widget.naviimageloader.e {
        @Override // com.baidu.navisdk.widget.naviimageloader.e
        public void a(String str, View view) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_OthersUgcMapsViewConstructor", "onLoadingStarted: --> TYPE_UGC_ACT_ENTRY_ICON");
            }
        }

        @Override // com.baidu.navisdk.widget.naviimageloader.e
        public void a(String str, View view, Bitmap bitmap, int i) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_OthersUgcMapsViewConstructor", "onLoadingComplete: --> TYPE_UGC_ACT_ENTRY_ICON");
            }
            g.b(g.f8337a, 200L);
            if (g.c != null) {
                g.c.a(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(View view, long j) {
        if (view == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleY", 0.0f, 1.0f);
        ofFloat.addUpdateListener(new c(view));
        ofFloat.setDuration(j);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        ofFloat2.setDuration(j);
        ofFloat2.addListener(new d(view));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat, ofFloat2);
        animatorSet.addListener(new e(view));
        animatorSet.start();
    }

    private static void a(Context context, ViewGroup viewGroup, ImageView imageView) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d() && viewGroup != null) {
            gVar.e("UgcModule_OthersUgcMapsViewConstructor", "constructUgcReportBtn mContainer.getVisibility(): " + viewGroup.getVisibility() + ", false");
        }
        if (context == null || viewGroup == null || viewGroup.getVisibility() == 0) {
            return;
        }
        viewGroup.setOnClickListener(d);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        com.baidu.navisdk.ugc.utils.d.a(4096, imageView, new a());
    }
}
