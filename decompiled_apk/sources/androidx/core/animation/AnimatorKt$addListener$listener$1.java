package androidx.core.animation;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import android.animation.Animator;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nAnimator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$listener$1\n*L\n1#1,123:1\n*E\n"})
/* loaded from: classes.dex */
public final class AnimatorKt$addListener$listener$1 implements Animator.AnimatorListener {
    final /* synthetic */ oOoXoXO<Animator, oXIO0o0XI> $onCancel;
    final /* synthetic */ oOoXoXO<Animator, oXIO0o0XI> $onEnd;
    final /* synthetic */ oOoXoXO<Animator, oXIO0o0XI> $onRepeat;
    final /* synthetic */ oOoXoXO<Animator, oXIO0o0XI> $onStart;

    /* JADX WARN: Multi-variable type inference failed */
    public AnimatorKt$addListener$listener$1(oOoXoXO<? super Animator, oXIO0o0XI> oooxoxo, oOoXoXO<? super Animator, oXIO0o0XI> oooxoxo2, oOoXoXO<? super Animator, oXIO0o0XI> oooxoxo3, oOoXoXO<? super Animator, oXIO0o0XI> oooxoxo4) {
        this.$onRepeat = oooxoxo;
        this.$onEnd = oooxoxo2;
        this.$onCancel = oooxoxo3;
        this.$onStart = oooxoxo4;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(@OOXIXo Animator animator) {
        this.$onCancel.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(@OOXIXo Animator animator) {
        this.$onEnd.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(@OOXIXo Animator animator) {
        this.$onRepeat.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(@OOXIXo Animator animator) {
        this.$onStart.invoke(animator);
    }
}
