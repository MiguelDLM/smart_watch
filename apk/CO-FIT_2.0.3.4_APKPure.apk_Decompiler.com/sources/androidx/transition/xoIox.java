package androidx.transition;

import androidx.transition.Transition;

public final /* synthetic */ class xoIox implements Transition.TransitionNotification {
    public final void notifyListener(Transition.TransitionListener transitionListener, Transition transition, boolean z) {
        transitionListener.onTransitionResume(transition);
    }
}
