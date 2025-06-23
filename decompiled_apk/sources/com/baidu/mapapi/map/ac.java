package com.baidu.mapapi.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mapapi.map.SwipeDismissTouchListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class ac extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewGroup.LayoutParams f5879a;
    final /* synthetic */ int b;
    final /* synthetic */ SwipeDismissTouchListener c;

    public ac(SwipeDismissTouchListener swipeDismissTouchListener, ViewGroup.LayoutParams layoutParams, int i) {
        this.c = swipeDismissTouchListener;
        this.f5879a = layoutParams;
        this.b = i;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        SwipeDismissTouchListener.DismissCallbacks dismissCallbacks;
        View view;
        Object obj;
        View view2;
        View view3;
        dismissCallbacks = this.c.f;
        view = this.c.e;
        obj = this.c.l;
        dismissCallbacks.onDismiss(view, obj);
        view2 = this.c.e;
        view2.setTranslationX(0.0f);
        this.f5879a.height = this.b;
        view3 = this.c.e;
        view3.setLayoutParams(this.f5879a);
    }
}
