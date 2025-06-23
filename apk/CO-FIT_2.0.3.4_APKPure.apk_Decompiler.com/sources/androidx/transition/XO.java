package androidx.transition;

import androidx.transition.Transition;

public final /* synthetic */ class XO implements Transition.TransitionNotification {
    public final void notifyListener(Transition.TransitionListener transitionListener, Transition transition, boolean z) {
        transitionListener.onTransitionStart(transition, z);
    }
}
