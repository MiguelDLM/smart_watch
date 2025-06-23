package androidx.core.transition;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import android.transition.Transition;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nTransition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$listener$1\n+ 2 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$1\n+ 3 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$4\n+ 4 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$5\n+ 5 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$2\n*L\n1#1,76:1\n60#2:77\n63#3:78\n64#4:79\n61#5:80\n*E\n"})
public final class TransitionKt$doOnCancel$$inlined$addListener$default$1 implements Transition.TransitionListener {
    final /* synthetic */ oOoXoXO $onCancel;

    public TransitionKt$doOnCancel$$inlined$addListener$default$1(oOoXoXO oooxoxo) {
        this.$onCancel = oooxoxo;
    }

    public void onTransitionCancel(@OOXIXo Transition transition) {
        this.$onCancel.invoke(transition);
    }

    public void onTransitionEnd(@OOXIXo Transition transition) {
    }

    public void onTransitionPause(@OOXIXo Transition transition) {
    }

    public void onTransitionResume(@OOXIXo Transition transition) {
    }

    public void onTransitionStart(@OOXIXo Transition transition) {
    }
}
