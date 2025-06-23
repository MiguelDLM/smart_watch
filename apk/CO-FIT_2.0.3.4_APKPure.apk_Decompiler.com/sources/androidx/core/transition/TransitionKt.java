package androidx.core.transition;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import android.transition.Transition;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nTransition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transition.kt\nandroidx/core/transition/TransitionKt\n*L\n1#1,76:1\n59#1,16:77\n59#1,16:93\n59#1,16:109\n59#1,16:125\n59#1,16:141\n*S KotlinDebug\n*F\n+ 1 Transition.kt\nandroidx/core/transition/TransitionKt\n*L\n26#1:77,16\n33#1:93,16\n40#1:109,16\n47#1:125,16\n54#1:141,16\n*E\n"})
public final class TransitionKt {
    @OOXIXo
    public static final Transition.TransitionListener addListener(@OOXIXo Transition transition, @OOXIXo oOoXoXO<? super Transition, oXIO0o0XI> oooxoxo, @OOXIXo oOoXoXO<? super Transition, oXIO0o0XI> oooxoxo2, @OOXIXo oOoXoXO<? super Transition, oXIO0o0XI> oooxoxo3, @OOXIXo oOoXoXO<? super Transition, oXIO0o0XI> oooxoxo4, @OOXIXo oOoXoXO<? super Transition, oXIO0o0XI> oooxoxo5) {
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(oooxoxo, oooxoxo4, oooxoxo5, oooxoxo3, oooxoxo2);
        transition.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    public static /* synthetic */ Transition.TransitionListener addListener$default(Transition transition, oOoXoXO oooxoxo, oOoXoXO oooxoxo2, oOoXoXO oooxoxo3, oOoXoXO oooxoxo4, oOoXoXO oooxoxo5, int i, Object obj) {
        if ((i & 1) != 0) {
            oooxoxo = TransitionKt$addListener$1.INSTANCE;
        }
        if ((i & 2) != 0) {
            oooxoxo2 = TransitionKt$addListener$2.INSTANCE;
        }
        oOoXoXO oooxoxo6 = oooxoxo2;
        if ((i & 4) != 0) {
            oooxoxo3 = TransitionKt$addListener$3.INSTANCE;
        }
        oOoXoXO oooxoxo7 = oooxoxo3;
        if ((i & 8) != 0) {
            oooxoxo4 = TransitionKt$addListener$4.INSTANCE;
        }
        if ((i & 16) != 0) {
            oooxoxo5 = TransitionKt$addListener$5.INSTANCE;
        }
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(oooxoxo, oooxoxo4, oooxoxo5, oooxoxo7, oooxoxo6);
        transition.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    @OOXIXo
    public static final Transition.TransitionListener doOnCancel(@OOXIXo Transition transition, @OOXIXo oOoXoXO<? super Transition, oXIO0o0XI> oooxoxo) {
        TransitionKt$doOnCancel$$inlined$addListener$default$1 transitionKt$doOnCancel$$inlined$addListener$default$1 = new TransitionKt$doOnCancel$$inlined$addListener$default$1(oooxoxo);
        transition.addListener(transitionKt$doOnCancel$$inlined$addListener$default$1);
        return transitionKt$doOnCancel$$inlined$addListener$default$1;
    }

    @OOXIXo
    public static final Transition.TransitionListener doOnEnd(@OOXIXo Transition transition, @OOXIXo oOoXoXO<? super Transition, oXIO0o0XI> oooxoxo) {
        TransitionKt$doOnEnd$$inlined$addListener$default$1 transitionKt$doOnEnd$$inlined$addListener$default$1 = new TransitionKt$doOnEnd$$inlined$addListener$default$1(oooxoxo);
        transition.addListener(transitionKt$doOnEnd$$inlined$addListener$default$1);
        return transitionKt$doOnEnd$$inlined$addListener$default$1;
    }

    @OOXIXo
    public static final Transition.TransitionListener doOnPause(@OOXIXo Transition transition, @OOXIXo oOoXoXO<? super Transition, oXIO0o0XI> oooxoxo) {
        TransitionKt$doOnPause$$inlined$addListener$default$1 transitionKt$doOnPause$$inlined$addListener$default$1 = new TransitionKt$doOnPause$$inlined$addListener$default$1(oooxoxo);
        transition.addListener(transitionKt$doOnPause$$inlined$addListener$default$1);
        return transitionKt$doOnPause$$inlined$addListener$default$1;
    }

    @OOXIXo
    public static final Transition.TransitionListener doOnResume(@OOXIXo Transition transition, @OOXIXo oOoXoXO<? super Transition, oXIO0o0XI> oooxoxo) {
        TransitionKt$doOnResume$$inlined$addListener$default$1 transitionKt$doOnResume$$inlined$addListener$default$1 = new TransitionKt$doOnResume$$inlined$addListener$default$1(oooxoxo);
        transition.addListener(transitionKt$doOnResume$$inlined$addListener$default$1);
        return transitionKt$doOnResume$$inlined$addListener$default$1;
    }

    @OOXIXo
    public static final Transition.TransitionListener doOnStart(@OOXIXo Transition transition, @OOXIXo oOoXoXO<? super Transition, oXIO0o0XI> oooxoxo) {
        TransitionKt$doOnStart$$inlined$addListener$default$1 transitionKt$doOnStart$$inlined$addListener$default$1 = new TransitionKt$doOnStart$$inlined$addListener$default$1(oooxoxo);
        transition.addListener(transitionKt$doOnStart$$inlined$addListener$default$1);
        return transitionKt$doOnStart$$inlined$addListener$default$1;
    }
}
