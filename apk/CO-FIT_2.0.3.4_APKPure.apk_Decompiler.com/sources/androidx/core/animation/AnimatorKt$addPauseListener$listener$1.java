package androidx.core.animation;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import android.animation.Animator;
import kotlin.oXIO0o0XI;

public final class AnimatorKt$addPauseListener$listener$1 implements Animator.AnimatorPauseListener {
    final /* synthetic */ oOoXoXO<Animator, oXIO0o0XI> $onPause;
    final /* synthetic */ oOoXoXO<Animator, oXIO0o0XI> $onResume;

    public AnimatorKt$addPauseListener$listener$1(oOoXoXO<? super Animator, oXIO0o0XI> oooxoxo, oOoXoXO<? super Animator, oXIO0o0XI> oooxoxo2) {
        this.$onPause = oooxoxo;
        this.$onResume = oooxoxo2;
    }

    public void onAnimationPause(@OOXIXo Animator animator) {
        this.$onPause.invoke(animator);
    }

    public void onAnimationResume(@OOXIXo Animator animator) {
        this.$onResume.invoke(animator);
    }
}
