package androidx.core.animation;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import android.animation.Animator;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nAnimator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$listener$1\n+ 2 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$4\n+ 3 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$1\n+ 4 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$3\n*L\n1#1,123:1\n95#2:124\n92#3:125\n94#4:126\n*E\n"})
public final class AnimatorKt$doOnStart$$inlined$addListener$default$1 implements Animator.AnimatorListener {
    final /* synthetic */ oOoXoXO $onStart;

    public AnimatorKt$doOnStart$$inlined$addListener$default$1(oOoXoXO oooxoxo) {
        this.$onStart = oooxoxo;
    }

    public void onAnimationCancel(@OOXIXo Animator animator) {
    }

    public void onAnimationEnd(@OOXIXo Animator animator) {
    }

    public void onAnimationRepeat(@OOXIXo Animator animator) {
    }

    public void onAnimationStart(@OOXIXo Animator animator) {
        this.$onStart.invoke(animator);
    }
}
