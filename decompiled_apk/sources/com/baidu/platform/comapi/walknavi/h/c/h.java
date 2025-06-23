package com.baidu.platform.comapi.walknavi.h.c;

import android.view.animation.Animation;
import android.widget.RelativeLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class h implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f9780a;

    public h(c cVar) {
        this.f9780a = cVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        RelativeLayout relativeLayout3;
        RelativeLayout relativeLayout4;
        RelativeLayout relativeLayout5;
        relativeLayout = this.f9780a.z;
        relativeLayout.clearAnimation();
        relativeLayout2 = this.f9780a.z;
        relativeLayout2.setVisibility(8);
        relativeLayout3 = this.f9780a.K;
        relativeLayout3.clearAnimation();
        relativeLayout4 = this.f9780a.K;
        relativeLayout4.setVisibility(8);
        relativeLayout5 = this.f9780a.A;
        relativeLayout5.setVisibility(8);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
