package androidx.core.animation;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import android.animation.Animator;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nAnimator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Animator.kt\nandroidx/core/animation/AnimatorKt\n*L\n1#1,123:1\n91#1,14:124\n91#1,14:138\n91#1,14:152\n91#1,14:166\n*S KotlinDebug\n*F\n+ 1 Animator.kt\nandroidx/core/animation/AnimatorKt\n*L\n30#1:124,14\n41#1:138,14\n52#1:152,14\n62#1:166,14\n*E\n"})
public final class AnimatorKt {
    @OOXIXo
    public static final Animator.AnimatorListener addListener(@OOXIXo Animator animator, @OOXIXo oOoXoXO<? super Animator, oXIO0o0XI> oooxoxo, @OOXIXo oOoXoXO<? super Animator, oXIO0o0XI> oooxoxo2, @OOXIXo oOoXoXO<? super Animator, oXIO0o0XI> oooxoxo3, @OOXIXo oOoXoXO<? super Animator, oXIO0o0XI> oooxoxo4) {
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(oooxoxo4, oooxoxo, oooxoxo3, oooxoxo2);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    public static /* synthetic */ Animator.AnimatorListener addListener$default(Animator animator, oOoXoXO oooxoxo, oOoXoXO oooxoxo2, oOoXoXO oooxoxo3, oOoXoXO oooxoxo4, int i, Object obj) {
        if ((i & 1) != 0) {
            oooxoxo = AnimatorKt$addListener$1.INSTANCE;
        }
        if ((i & 2) != 0) {
            oooxoxo2 = AnimatorKt$addListener$2.INSTANCE;
        }
        if ((i & 4) != 0) {
            oooxoxo3 = AnimatorKt$addListener$3.INSTANCE;
        }
        if ((i & 8) != 0) {
            oooxoxo4 = AnimatorKt$addListener$4.INSTANCE;
        }
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(oooxoxo4, oooxoxo, oooxoxo3, oooxoxo2);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    @OOXIXo
    public static final Animator.AnimatorPauseListener addPauseListener(@OOXIXo Animator animator, @OOXIXo oOoXoXO<? super Animator, oXIO0o0XI> oooxoxo, @OOXIXo oOoXoXO<? super Animator, oXIO0o0XI> oooxoxo2) {
        AnimatorKt$addPauseListener$listener$1 animatorKt$addPauseListener$listener$1 = new AnimatorKt$addPauseListener$listener$1(oooxoxo2, oooxoxo);
        animator.addPauseListener(animatorKt$addPauseListener$listener$1);
        return animatorKt$addPauseListener$listener$1;
    }

    public static /* synthetic */ Animator.AnimatorPauseListener addPauseListener$default(Animator animator, oOoXoXO oooxoxo, oOoXoXO oooxoxo2, int i, Object obj) {
        if ((i & 1) != 0) {
            oooxoxo = AnimatorKt$addPauseListener$1.INSTANCE;
        }
        if ((i & 2) != 0) {
            oooxoxo2 = AnimatorKt$addPauseListener$2.INSTANCE;
        }
        return addPauseListener(animator, oooxoxo, oooxoxo2);
    }

    @OOXIXo
    public static final Animator.AnimatorListener doOnCancel(@OOXIXo Animator animator, @OOXIXo oOoXoXO<? super Animator, oXIO0o0XI> oooxoxo) {
        AnimatorKt$doOnCancel$$inlined$addListener$default$1 animatorKt$doOnCancel$$inlined$addListener$default$1 = new AnimatorKt$doOnCancel$$inlined$addListener$default$1(oooxoxo);
        animator.addListener(animatorKt$doOnCancel$$inlined$addListener$default$1);
        return animatorKt$doOnCancel$$inlined$addListener$default$1;
    }

    @OOXIXo
    public static final Animator.AnimatorListener doOnEnd(@OOXIXo Animator animator, @OOXIXo oOoXoXO<? super Animator, oXIO0o0XI> oooxoxo) {
        AnimatorKt$doOnEnd$$inlined$addListener$default$1 animatorKt$doOnEnd$$inlined$addListener$default$1 = new AnimatorKt$doOnEnd$$inlined$addListener$default$1(oooxoxo);
        animator.addListener(animatorKt$doOnEnd$$inlined$addListener$default$1);
        return animatorKt$doOnEnd$$inlined$addListener$default$1;
    }

    @OOXIXo
    public static final Animator.AnimatorPauseListener doOnPause(@OOXIXo Animator animator, @OOXIXo oOoXoXO<? super Animator, oXIO0o0XI> oooxoxo) {
        return addPauseListener$default(animator, (oOoXoXO) null, oooxoxo, 1, (Object) null);
    }

    @OOXIXo
    public static final Animator.AnimatorListener doOnRepeat(@OOXIXo Animator animator, @OOXIXo oOoXoXO<? super Animator, oXIO0o0XI> oooxoxo) {
        AnimatorKt$doOnRepeat$$inlined$addListener$default$1 animatorKt$doOnRepeat$$inlined$addListener$default$1 = new AnimatorKt$doOnRepeat$$inlined$addListener$default$1(oooxoxo);
        animator.addListener(animatorKt$doOnRepeat$$inlined$addListener$default$1);
        return animatorKt$doOnRepeat$$inlined$addListener$default$1;
    }

    @OOXIXo
    public static final Animator.AnimatorPauseListener doOnResume(@OOXIXo Animator animator, @OOXIXo oOoXoXO<? super Animator, oXIO0o0XI> oooxoxo) {
        return addPauseListener$default(animator, oooxoxo, (oOoXoXO) null, 2, (Object) null);
    }

    @OOXIXo
    public static final Animator.AnimatorListener doOnStart(@OOXIXo Animator animator, @OOXIXo oOoXoXO<? super Animator, oXIO0o0XI> oooxoxo) {
        AnimatorKt$doOnStart$$inlined$addListener$default$1 animatorKt$doOnStart$$inlined$addListener$default$1 = new AnimatorKt$doOnStart$$inlined$addListener$default$1(oooxoxo);
        animator.addListener(animatorKt$doOnStart$$inlined$addListener$default$1);
        return animatorKt$doOnStart$$inlined$addListener$default$1;
    }
}
