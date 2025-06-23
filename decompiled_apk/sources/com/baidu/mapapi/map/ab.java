package com.baidu.mapapi.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* loaded from: classes7.dex */
class ab extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SwipeDismissTouchListener f5878a;

    public ab(SwipeDismissTouchListener swipeDismissTouchListener) {
        this.f5878a = swipeDismissTouchListener;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f5878a.a();
    }
}
