package androidx.core.view;

import android.animation.ValueAnimator;
import android.view.View;

public final /* synthetic */ class X00IoxXI implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ View f374Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimatorUpdateListener f375XO;

    public /* synthetic */ X00IoxXI(ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener, View view) {
        this.f375XO = viewPropertyAnimatorUpdateListener;
        this.f374Oo = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f375XO.onAnimationUpdate(this.f374Oo);
    }
}
