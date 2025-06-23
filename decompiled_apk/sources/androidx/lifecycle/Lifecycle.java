package androidx.lifecycle;

import XO0OX.x0XOIxOo;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes.dex */
public abstract class Lifecycle {

    @OXOo.OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    private AtomicReference<Object> internalScopeRef = new AtomicReference<>();

    /* loaded from: classes.dex */
    public enum Event {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;


        @OXOo.OOXIXo
        public static final Companion Companion = new Companion(null);

        /* loaded from: classes.dex */
        public static final class Companion {

            /* loaded from: classes.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[State.values().length];
                    try {
                        iArr[State.CREATED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[State.STARTED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[State.RESUMED.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[State.DESTROYED.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[State.INITIALIZED.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            @x0XOIxOo
            @OXOo.oOoXoXO
            public final Event downFrom(@OXOo.OOXIXo State state) {
                IIX0o.x0xO0oo(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return null;
                        }
                        return Event.ON_PAUSE;
                    }
                    return Event.ON_STOP;
                }
                return Event.ON_DESTROY;
            }

            @x0XOIxOo
            @OXOo.oOoXoXO
            public final Event downTo(@OXOo.OOXIXo State state) {
                IIX0o.x0xO0oo(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (i != 4) {
                            return null;
                        }
                        return Event.ON_DESTROY;
                    }
                    return Event.ON_PAUSE;
                }
                return Event.ON_STOP;
            }

            @x0XOIxOo
            @OXOo.oOoXoXO
            public final Event upFrom(@OXOo.OOXIXo State state) {
                IIX0o.x0xO0oo(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (i != 5) {
                            return null;
                        }
                        return Event.ON_CREATE;
                    }
                    return Event.ON_RESUME;
                }
                return Event.ON_START;
            }

            @x0XOIxOo
            @OXOo.oOoXoXO
            public final Event upTo(@OXOo.OOXIXo State state) {
                IIX0o.x0xO0oo(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return null;
                        }
                        return Event.ON_RESUME;
                    }
                    return Event.ON_START;
                }
                return Event.ON_CREATE;
            }

            private Companion() {
            }
        }

        /* loaded from: classes.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Event.values().length];
                try {
                    iArr[Event.ON_CREATE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Event.ON_STOP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Event.ON_START.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Event.ON_PAUSE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[Event.ON_RESUME.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[Event.ON_DESTROY.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[Event.ON_ANY.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        @x0XOIxOo
        @OXOo.oOoXoXO
        public static final Event downFrom(@OXOo.OOXIXo State state) {
            return Companion.downFrom(state);
        }

        @x0XOIxOo
        @OXOo.oOoXoXO
        public static final Event downTo(@OXOo.OOXIXo State state) {
            return Companion.downTo(state);
        }

        @x0XOIxOo
        @OXOo.oOoXoXO
        public static final Event upFrom(@OXOo.OOXIXo State state) {
            return Companion.upFrom(state);
        }

        @x0XOIxOo
        @OXOo.oOoXoXO
        public static final Event upTo(@OXOo.OOXIXo State state) {
            return Companion.upTo(state);
        }

        @OXOo.OOXIXo
        public final State getTargetState() {
            switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                case 1:
                case 2:
                    return State.CREATED;
                case 3:
                case 4:
                    return State.STARTED;
                case 5:
                    return State.RESUMED;
                case 6:
                    return State.DESTROYED;
                default:
                    throw new IllegalArgumentException(this + " has no target state");
            }
        }
    }

    /* loaded from: classes.dex */
    public enum State {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public final boolean isAtLeast(@OXOo.OOXIXo State state) {
            IIX0o.x0xO0oo(state, "state");
            if (compareTo(state) >= 0) {
                return true;
            }
            return false;
        }
    }

    @MainThread
    public abstract void addObserver(@OXOo.OOXIXo LifecycleObserver lifecycleObserver);

    @OXOo.OOXIXo
    @MainThread
    public abstract State getCurrentState();

    @OXOo.OOXIXo
    public final AtomicReference<Object> getInternalScopeRef() {
        return this.internalScopeRef;
    }

    @MainThread
    public abstract void removeObserver(@OXOo.OOXIXo LifecycleObserver lifecycleObserver);

    public final void setInternalScopeRef(@OXOo.OOXIXo AtomicReference<Object> atomicReference) {
        IIX0o.x0xO0oo(atomicReference, "<set-?>");
        this.internalScopeRef = atomicReference;
    }
}
