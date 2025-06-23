package androidx.transition;

import androidx.transition.Transition;

/* loaded from: classes.dex */
public final /* synthetic */ class OOXIXo {
    static {
        Transition.TransitionNotification transitionNotification = Transition.TransitionNotification.ON_START;
    }

    public static /* synthetic */ void I0Io(Transition.TransitionListener transitionListener, Transition transition, boolean z) {
        transitionListener.onTransitionResume(transition);
    }

    public static /* synthetic */ void II0xO0(Transition.TransitionListener transitionListener, Transition transition, boolean z) {
        transitionListener.onTransitionPause(transition);
    }

    public static /* synthetic */ void oIX0oI(Transition.TransitionListener transitionListener, Transition transition, boolean z) {
        transitionListener.onTransitionCancel(transition);
    }
}
