package androidx.transition;

import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.transition.Transition;

public final /* synthetic */ class oxoX implements DynamicAnimation.OnAnimationEndListener {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ Transition.SeekController f492oIX0oI;

    public /* synthetic */ oxoX(Transition.SeekController seekController) {
        this.f492oIX0oI = seekController;
    }

    public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f, float f2) {
        this.f492oIX0oI.lambda$ensureAnimation$0(dynamicAnimation, z, f, f2);
    }
}
