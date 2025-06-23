package com.kwad.sdk.api.core.lifecycle;

import androidx.annotation.Keep;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlinx.coroutines.debug.internal.oxoX;

/* loaded from: classes11.dex */
public class KsLifecycle {
    private Lifecycle mBase;

    @Keep
    /* loaded from: classes11.dex */
    public enum KsLifeEvent {
        ON_CREATE(Lifecycle.Event.ON_CREATE),
        ON_START(Lifecycle.Event.ON_START),
        ON_RESUME(Lifecycle.Event.ON_RESUME),
        ON_PAUSE(Lifecycle.Event.ON_PAUSE),
        ON_STOP(Lifecycle.Event.ON_STOP),
        ON_DESTROY(Lifecycle.Event.ON_DESTROY),
        ON_ANY(Lifecycle.Event.ON_ANY);

        Lifecycle.Event mRealValue;

        KsLifeEvent(Lifecycle.Event event) {
            this.mRealValue = event;
        }

        public static KsLifeEvent createfrom(Lifecycle.Event event) {
            for (KsLifeEvent ksLifeEvent : values()) {
                if (ksLifeEvent.getReal() == event) {
                    return ksLifeEvent;
                }
            }
            return null;
        }

        @Keep
        public final Lifecycle.Event getReal() {
            return this.mRealValue;
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'DESTROYED' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes11.dex */
    public static final class KsLifeState {
        private static final /* synthetic */ KsLifeState[] $VALUES;
        public static final KsLifeState CREATED;
        public static final KsLifeState DESTROYED;
        public static final KsLifeState INITIALIZED;
        public static final KsLifeState RESUMED;
        public static final KsLifeState STARTED;
        Lifecycle.State mReal;

        static {
            Lifecycle.State state = Lifecycle.State.DESTROYED;
            KsLifeState ksLifeState = new KsLifeState("DESTROYED", 0, state);
            DESTROYED = ksLifeState;
            KsLifeState ksLifeState2 = new KsLifeState("INITIALIZED", 1, state);
            INITIALIZED = ksLifeState2;
            KsLifeState ksLifeState3 = new KsLifeState(oxoX.f29952oIX0oI, 2, state);
            CREATED = ksLifeState3;
            KsLifeState ksLifeState4 = new KsLifeState("STARTED", 3, state);
            STARTED = ksLifeState4;
            KsLifeState ksLifeState5 = new KsLifeState("RESUMED", 4, state);
            RESUMED = ksLifeState5;
            $VALUES = new KsLifeState[]{ksLifeState, ksLifeState2, ksLifeState3, ksLifeState4, ksLifeState5};
        }

        private KsLifeState(String str, int i, Lifecycle.State state) {
            this.mReal = state;
        }

        public static KsLifeState createFrom(Lifecycle.State state) {
            for (KsLifeState ksLifeState : values()) {
                if (ksLifeState.mReal == state) {
                    return ksLifeState;
                }
            }
            return null;
        }

        public static KsLifeState valueOf(String str) {
            return (KsLifeState) Enum.valueOf(KsLifeState.class, str);
        }

        public static KsLifeState[] values() {
            return (KsLifeState[]) $VALUES.clone();
        }

        public final boolean isAtLeast(@NonNull KsLifeState ksLifeState) {
            if (compareTo(ksLifeState) >= 0) {
                return true;
            }
            return false;
        }
    }

    public KsLifecycle(Lifecycle lifecycle) {
        this.mBase = lifecycle;
    }

    @MainThread
    public void addObserver(@NonNull final KsLifecycleObserver ksLifecycleObserver) {
        if (ksLifecycleObserver instanceof KsGenericLifecycleObserver) {
            GenericLifecycleObserver genericLifecycleObserver = new GenericLifecycleObserver() { // from class: com.kwad.sdk.api.core.lifecycle.KsLifecycle.1
                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    ((KsGenericLifecycleObserver) ksLifecycleObserver).onStateChanged(KsLifeEvent.createfrom(event));
                }
            };
            ksLifecycleObserver.setBase(genericLifecycleObserver);
            this.mBase.addObserver(genericLifecycleObserver);
        }
    }

    @MainThread
    public KsLifeState getCurrentState() {
        return KsLifeState.createFrom(this.mBase.getCurrentState());
    }

    @MainThread
    public void removeObserver(@NonNull KsLifecycleObserver ksLifecycleObserver) {
        this.mBase.removeObserver(ksLifecycleObserver.getBase());
    }
}
