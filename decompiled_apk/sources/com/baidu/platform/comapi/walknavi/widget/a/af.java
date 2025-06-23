package com.baidu.platform.comapi.walknavi.widget.a;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.platform.comapi.walknavi.widget.a.z;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class af implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ z f9849a;

    public af(z zVar) {
        this.f9849a = zVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        View view;
        view = this.f9849a.h;
        view.setVisibility(8);
        z.a aVar = this.f9849a.b;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
