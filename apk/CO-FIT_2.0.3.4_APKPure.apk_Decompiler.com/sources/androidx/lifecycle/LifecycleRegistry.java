package androidx.lifecycle;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.annotation.SuppressLint;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

public class LifecycleRegistry extends Lifecycle {
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);
    private int addingObserverCounter;
    private final boolean enforceMainThread;
    private boolean handlingEvent;
    @OOXIXo
    private final WeakReference<LifecycleOwner> lifecycleOwner;
    private boolean newEventOccurred;
    @OOXIXo
    private FastSafeIterableMap<LifecycleObserver, ObserverWithState> observerMap;
    @OOXIXo
    private ArrayList<Lifecycle.State> parentStates;
    @OOXIXo
    private Lifecycle.State state;

    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @VisibleForTesting
        @x0XOIxOo
        @OOXIXo
        public final LifecycleRegistry createUnsafe(@OOXIXo LifecycleOwner lifecycleOwner) {
            IIX0o.x0xO0oo(lifecycleOwner, "owner");
            return new LifecycleRegistry(lifecycleOwner, false, (IIXOooo) null);
        }

        @x0XOIxOo
        @OOXIXo
        public final Lifecycle.State min$lifecycle_runtime_release(@OOXIXo Lifecycle.State state, @oOoXoXO Lifecycle.State state2) {
            IIX0o.x0xO0oo(state, "state1");
            if (state2 == null || state2.compareTo(state) >= 0) {
                return state;
            }
            return state2;
        }

        private Companion() {
        }
    }

    public static final class ObserverWithState {
        @OOXIXo
        private LifecycleEventObserver lifecycleObserver;
        @OOXIXo
        private Lifecycle.State state;

        public ObserverWithState(@oOoXoXO LifecycleObserver lifecycleObserver2, @OOXIXo Lifecycle.State state2) {
            IIX0o.x0xO0oo(state2, "initialState");
            IIX0o.ooOOo0oXI(lifecycleObserver2);
            this.lifecycleObserver = Lifecycling.lifecycleEventObserver(lifecycleObserver2);
            this.state = state2;
        }

        public final void dispatchEvent(@oOoXoXO LifecycleOwner lifecycleOwner, @OOXIXo Lifecycle.Event event) {
            IIX0o.x0xO0oo(event, NotificationCompat.CATEGORY_EVENT);
            Lifecycle.State targetState = event.getTargetState();
            this.state = LifecycleRegistry.Companion.min$lifecycle_runtime_release(this.state, targetState);
            LifecycleEventObserver lifecycleEventObserver = this.lifecycleObserver;
            IIX0o.ooOOo0oXI(lifecycleOwner);
            lifecycleEventObserver.onStateChanged(lifecycleOwner, event);
            this.state = targetState;
        }

        @OOXIXo
        public final LifecycleEventObserver getLifecycleObserver() {
            return this.lifecycleObserver;
        }

        @OOXIXo
        public final Lifecycle.State getState() {
            return this.state;
        }

        public final void setLifecycleObserver(@OOXIXo LifecycleEventObserver lifecycleEventObserver) {
            IIX0o.x0xO0oo(lifecycleEventObserver, "<set-?>");
            this.lifecycleObserver = lifecycleEventObserver;
        }

        public final void setState(@OOXIXo Lifecycle.State state2) {
            IIX0o.x0xO0oo(state2, "<set-?>");
            this.state = state2;
        }
    }

    public /* synthetic */ LifecycleRegistry(LifecycleOwner lifecycleOwner2, boolean z, IIXOooo iIXOooo) {
        this(lifecycleOwner2, z);
    }

    private final void backwardPass(LifecycleOwner lifecycleOwner2) {
        Iterator<Map.Entry<LifecycleObserver, ObserverWithState>> descendingIterator = this.observerMap.descendingIterator();
        IIX0o.oO(descendingIterator, "observerMap.descendingIterator()");
        while (descendingIterator.hasNext() && !this.newEventOccurred) {
            Map.Entry next = descendingIterator.next();
            IIX0o.oO(next, "next()");
            LifecycleObserver lifecycleObserver = (LifecycleObserver) next.getKey();
            ObserverWithState observerWithState = (ObserverWithState) next.getValue();
            while (observerWithState.getState().compareTo(this.state) > 0 && !this.newEventOccurred && this.observerMap.contains(lifecycleObserver)) {
                Lifecycle.Event downFrom = Lifecycle.Event.Companion.downFrom(observerWithState.getState());
                if (downFrom != null) {
                    pushParentState(downFrom.getTargetState());
                    observerWithState.dispatchEvent(lifecycleOwner2, downFrom);
                    popParentState();
                } else {
                    throw new IllegalStateException("no event down from " + observerWithState.getState());
                }
            }
        }
    }

    private final Lifecycle.State calculateTargetState(LifecycleObserver lifecycleObserver) {
        Lifecycle.State state2;
        ObserverWithState value;
        Map.Entry<LifecycleObserver, ObserverWithState> ceil = this.observerMap.ceil(lifecycleObserver);
        Lifecycle.State state3 = null;
        if (ceil == null || (value = ceil.getValue()) == null) {
            state2 = null;
        } else {
            state2 = value.getState();
        }
        if (!this.parentStates.isEmpty()) {
            ArrayList<Lifecycle.State> arrayList = this.parentStates;
            state3 = arrayList.get(arrayList.size() - 1);
        }
        Companion companion = Companion;
        return companion.min$lifecycle_runtime_release(companion.min$lifecycle_runtime_release(this.state, state2), state3);
    }

    @VisibleForTesting
    @x0XOIxOo
    @OOXIXo
    public static final LifecycleRegistry createUnsafe(@OOXIXo LifecycleOwner lifecycleOwner2) {
        return Companion.createUnsafe(lifecycleOwner2);
    }

    @SuppressLint({"RestrictedApi"})
    private final void enforceMainThreadIfNeeded(String str) {
        if (this.enforceMainThread && !ArchTaskExecutor.getInstance().isMainThread()) {
            throw new IllegalStateException(("Method " + str + " must be called on the main thread").toString());
        }
    }

    private final void forwardPass(LifecycleOwner lifecycleOwner2) {
        SafeIterableMap<K, V>.IteratorWithAdditions iteratorWithAdditions = this.observerMap.iteratorWithAdditions();
        IIX0o.oO(iteratorWithAdditions, "observerMap.iteratorWithAdditions()");
        while (iteratorWithAdditions.hasNext() && !this.newEventOccurred) {
            Map.Entry entry = (Map.Entry) iteratorWithAdditions.next();
            LifecycleObserver lifecycleObserver = (LifecycleObserver) entry.getKey();
            ObserverWithState observerWithState = (ObserverWithState) entry.getValue();
            while (observerWithState.getState().compareTo(this.state) < 0 && !this.newEventOccurred && this.observerMap.contains(lifecycleObserver)) {
                pushParentState(observerWithState.getState());
                Lifecycle.Event upFrom = Lifecycle.Event.Companion.upFrom(observerWithState.getState());
                if (upFrom != null) {
                    observerWithState.dispatchEvent(lifecycleOwner2, upFrom);
                    popParentState();
                } else {
                    throw new IllegalStateException("no event up from " + observerWithState.getState());
                }
            }
        }
    }

    private final boolean isSynced() {
        if (this.observerMap.size() == 0) {
            return true;
        }
        Map.Entry<LifecycleObserver, ObserverWithState> eldest = this.observerMap.eldest();
        IIX0o.ooOOo0oXI(eldest);
        Lifecycle.State state2 = eldest.getValue().getState();
        Map.Entry<LifecycleObserver, ObserverWithState> newest = this.observerMap.newest();
        IIX0o.ooOOo0oXI(newest);
        Lifecycle.State state3 = newest.getValue().getState();
        if (state2 == state3 && this.state == state3) {
            return true;
        }
        return false;
    }

    @x0XOIxOo
    @OOXIXo
    public static final Lifecycle.State min$lifecycle_runtime_release(@OOXIXo Lifecycle.State state2, @oOoXoXO Lifecycle.State state3) {
        return Companion.min$lifecycle_runtime_release(state2, state3);
    }

    private final void moveToState(Lifecycle.State state2) {
        Lifecycle.State state3 = this.state;
        if (state3 != state2) {
            if (state3 == Lifecycle.State.INITIALIZED && state2 == Lifecycle.State.DESTROYED) {
                throw new IllegalStateException(("no event down from " + this.state + " in component " + this.lifecycleOwner.get()).toString());
            }
            this.state = state2;
            if (this.handlingEvent || this.addingObserverCounter != 0) {
                this.newEventOccurred = true;
                return;
            }
            this.handlingEvent = true;
            sync();
            this.handlingEvent = false;
            if (this.state == Lifecycle.State.DESTROYED) {
                this.observerMap = new FastSafeIterableMap<>();
            }
        }
    }

    private final void popParentState() {
        ArrayList<Lifecycle.State> arrayList = this.parentStates;
        arrayList.remove(arrayList.size() - 1);
    }

    private final void pushParentState(Lifecycle.State state2) {
        this.parentStates.add(state2);
    }

    private final void sync() {
        LifecycleOwner lifecycleOwner2 = this.lifecycleOwner.get();
        if (lifecycleOwner2 != null) {
            while (!isSynced()) {
                this.newEventOccurred = false;
                Lifecycle.State state2 = this.state;
                Map.Entry<LifecycleObserver, ObserverWithState> eldest = this.observerMap.eldest();
                IIX0o.ooOOo0oXI(eldest);
                if (state2.compareTo(eldest.getValue().getState()) < 0) {
                    backwardPass(lifecycleOwner2);
                }
                Map.Entry<LifecycleObserver, ObserverWithState> newest = this.observerMap.newest();
                if (!this.newEventOccurred && newest != null && this.state.compareTo(newest.getValue().getState()) > 0) {
                    forwardPass(lifecycleOwner2);
                }
            }
            this.newEventOccurred = false;
            return;
        }
        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
    }

    public void addObserver(@OOXIXo LifecycleObserver lifecycleObserver) {
        LifecycleOwner lifecycleOwner2;
        boolean z;
        IIX0o.x0xO0oo(lifecycleObserver, "observer");
        enforceMainThreadIfNeeded("addObserver");
        Lifecycle.State state2 = this.state;
        Lifecycle.State state3 = Lifecycle.State.DESTROYED;
        if (state2 != state3) {
            state3 = Lifecycle.State.INITIALIZED;
        }
        ObserverWithState observerWithState = new ObserverWithState(lifecycleObserver, state3);
        if (this.observerMap.putIfAbsent(lifecycleObserver, observerWithState) == null && (lifecycleOwner2 = this.lifecycleOwner.get()) != null) {
            if (this.addingObserverCounter != 0 || this.handlingEvent) {
                z = true;
            } else {
                z = false;
            }
            Lifecycle.State calculateTargetState = calculateTargetState(lifecycleObserver);
            this.addingObserverCounter++;
            while (observerWithState.getState().compareTo(calculateTargetState) < 0 && this.observerMap.contains(lifecycleObserver)) {
                pushParentState(observerWithState.getState());
                Lifecycle.Event upFrom = Lifecycle.Event.Companion.upFrom(observerWithState.getState());
                if (upFrom != null) {
                    observerWithState.dispatchEvent(lifecycleOwner2, upFrom);
                    popParentState();
                    calculateTargetState = calculateTargetState(lifecycleObserver);
                } else {
                    throw new IllegalStateException("no event up from " + observerWithState.getState());
                }
            }
            if (!z) {
                sync();
            }
            this.addingObserverCounter--;
        }
    }

    @OOXIXo
    public Lifecycle.State getCurrentState() {
        return this.state;
    }

    public int getObserverCount() {
        enforceMainThreadIfNeeded("getObserverCount");
        return this.observerMap.size();
    }

    public void handleLifecycleEvent(@OOXIXo Lifecycle.Event event) {
        IIX0o.x0xO0oo(event, NotificationCompat.CATEGORY_EVENT);
        enforceMainThreadIfNeeded("handleLifecycleEvent");
        moveToState(event.getTargetState());
    }

    @kotlin.OOXIXo(message = "Override [currentState].")
    @MainThread
    public void markState(@OOXIXo Lifecycle.State state2) {
        IIX0o.x0xO0oo(state2, "state");
        enforceMainThreadIfNeeded("markState");
        setCurrentState(state2);
    }

    public void removeObserver(@OOXIXo LifecycleObserver lifecycleObserver) {
        IIX0o.x0xO0oo(lifecycleObserver, "observer");
        enforceMainThreadIfNeeded("removeObserver");
        this.observerMap.remove(lifecycleObserver);
    }

    public void setCurrentState(@OOXIXo Lifecycle.State state2) {
        IIX0o.x0xO0oo(state2, "state");
        enforceMainThreadIfNeeded("setCurrentState");
        moveToState(state2);
    }

    private LifecycleRegistry(LifecycleOwner lifecycleOwner2, boolean z) {
        this.enforceMainThread = z;
        this.observerMap = new FastSafeIterableMap<>();
        this.state = Lifecycle.State.INITIALIZED;
        this.parentStates = new ArrayList<>();
        this.lifecycleOwner = new WeakReference<>(lifecycleOwner2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LifecycleRegistry(@OOXIXo LifecycleOwner lifecycleOwner2) {
        this(lifecycleOwner2, true);
        IIX0o.x0xO0oo(lifecycleOwner2, "provider");
    }
}
