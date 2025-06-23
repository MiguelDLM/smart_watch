package androidx.core.transition;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import android.transition.Transition;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nTransition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$listener$1\n+ 2 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$4\n+ 3 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$5\n+ 4 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$3\n+ 5 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$2\n*L\n1#1,76:1\n63#2:77\n64#3:78\n62#4:79\n61#5:80\n*E\n"})
public final class TransitionKt$doOnEnd$$inlined$addListener$default$1 implements Transition.TransitionListener {
    final /* synthetic */ oOoXoXO $onEnd;

    public TransitionKt$doOnEnd$$inlined$addListener$default$1(oOoXoXO oooxoxo) {
        this.$onEnd = oooxoxo;
    }

    public void onTransitionCancel(@OOXIXo Transition transition) {
    }

    public void onTransitionEnd(@OOXIXo Transition transition) {
        this.$onEnd.invoke(transition);
    }

    public void onTransitionPause(@OOXIXo Transition transition) {
    }

    public void onTransitionResume(@OOXIXo Transition transition) {
    }

    public void onTransitionStart(@OOXIXo Transition transition) {
    }
}
