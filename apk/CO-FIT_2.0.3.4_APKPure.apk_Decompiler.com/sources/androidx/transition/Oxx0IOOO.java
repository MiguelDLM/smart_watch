package androidx.transition;

import androidx.transition.Transition;

public final /* synthetic */ class Oxx0IOOO implements Transition.TransitionNotification {
    public final void notifyListener(Transition.TransitionListener transitionListener, Transition transition, boolean z) {
        transitionListener.onTransitionEnd(transition, z);
    }
}
