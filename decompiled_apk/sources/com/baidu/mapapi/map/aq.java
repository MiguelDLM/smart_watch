package com.baidu.mapapi.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* loaded from: classes7.dex */
class aq extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f5893a;
    final /* synthetic */ WearMapView b;

    public aq(WearMapView wearMapView, View view) {
        this.b = wearMapView;
        this.f5893a = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f5893a.setVisibility(4);
        super.onAnimationEnd(animator);
    }
}
