package com.baidu.platform.comapi.walknavi.widget.a;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.RelativeLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class ac implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ z f9846a;

    public ac(z zVar) {
        this.f9846a = zVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        RelativeLayout relativeLayout;
        ViewGroup viewGroup;
        RelativeLayout relativeLayout2;
        relativeLayout = this.f9846a.v;
        relativeLayout.setVisibility(8);
        viewGroup = this.f9846a.e;
        relativeLayout2 = this.f9846a.v;
        viewGroup.removeView(relativeLayout2);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
