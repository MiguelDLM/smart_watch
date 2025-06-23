package androidx.core.transition;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import android.transition.Transition;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nTransition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$listener$1\n*L\n1#1,76:1\n*E\n"})
public final class TransitionKt$addListener$listener$1 implements Transition.TransitionListener {
    final /* synthetic */ oOoXoXO<Transition, oXIO0o0XI> $onCancel;
    final /* synthetic */ oOoXoXO<Transition, oXIO0o0XI> $onEnd;
    final /* synthetic */ oOoXoXO<Transition, oXIO0o0XI> $onPause;
    final /* synthetic */ oOoXoXO<Transition, oXIO0o0XI> $onResume;
    final /* synthetic */ oOoXoXO<Transition, oXIO0o0XI> $onStart;

    public TransitionKt$addListener$listener$1(oOoXoXO<? super Transition, oXIO0o0XI> oooxoxo, oOoXoXO<? super Transition, oXIO0o0XI> oooxoxo2, oOoXoXO<? super Transition, oXIO0o0XI> oooxoxo3, oOoXoXO<? super Transition, oXIO0o0XI> oooxoxo4, oOoXoXO<? super Transition, oXIO0o0XI> oooxoxo5) {
        this.$onEnd = oooxoxo;
        this.$onResume = oooxoxo2;
        this.$onPause = oooxoxo3;
        this.$onCancel = oooxoxo4;
        this.$onStart = oooxoxo5;
    }

    public void onTransitionCancel(@OOXIXo Transition transition) {
        this.$onCancel.invoke(transition);
    }

    public void onTransitionEnd(@OOXIXo Transition transition) {
        this.$onEnd.invoke(transition);
    }

    public void onTransitionPause(@OOXIXo Transition transition) {
        this.$onPause.invoke(transition);
    }

    public void onTransitionResume(@OOXIXo Transition transition) {
        this.$onResume.invoke(transition);
    }

    public void onTransitionStart(@OOXIXo Transition transition) {
        this.$onStart.invoke(transition);
    }
}
