package androidx.core.animation;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import android.animation.Animator;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nAnimator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$listener$1\n+ 2 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$1\n+ 3 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$3\n+ 4 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$2\n*L\n1#1,123:1\n92#2:124\n94#3:125\n93#4:126\n*E\n"})
public final class AnimatorKt$doOnRepeat$$inlined$addListener$default$1 implements Animator.AnimatorListener {
    final /* synthetic */ oOoXoXO $onRepeat;

    public AnimatorKt$doOnRepeat$$inlined$addListener$default$1(oOoXoXO oooxoxo) {
        this.$onRepeat = oooxoxo;
    }

    public void onAnimationCancel(@OOXIXo Animator animator) {
    }

    public void onAnimationEnd(@OOXIXo Animator animator) {
    }

    public void onAnimationRepeat(@OOXIXo Animator animator) {
        this.$onRepeat.invoke(animator);
    }

    public void onAnimationStart(@OOXIXo Animator animator) {
    }
}
