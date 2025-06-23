package androidx.lifecycle;

import XO0OX.x0XOIxOo;
import android.annotation.SuppressLint;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes.dex */
public class LifecycleRegistry extends Lifecycle {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);
    private int addingObserverCounter;
    private final boolean enforceMainThread;
    private boolean handlingEvent;

    @OXOo.OOXIXo
    private final WeakReference<LifecycleOwner> lifecycleOwner;
    private boolean newEventOccurred;

    @OXOo.OOXIXo
    private FastSafeIterableMap<LifecycleObserver, ObserverWithState> observerMap;

    @OXOo.OOXIXo
    private ArrayList<Lifecycle.State> parentStates;

    @OXOo.OOXIXo
    private Lifecycle.State state;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        @VisibleForTesting
        public final LifecycleRegistry createUnsafe(@OXOo.OOXIXo LifecycleOwner owner) {
            IIX0o.x0xO0oo(owner, "owner");
            return new LifecycleRegistry(owner, false, null);
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        public final Lifecycle.State min$lifecycle_runtime_release(@OXOo.OOXIXo Lifecycle.State state1, @OXOo.oOoXoXO Lifecycle.State state) {
            IIX0o.x0xO0oo(state1, "state1");
            if (state != null && state.compareTo(state1) < 0) {
                return state;
            }
            return state1;
        }

        private Companion() {
        }
    }

    /* loaded from: classes.dex */
    public static final class ObserverWithState {

        @OXOo.OOXIXo
        private LifecycleEventObserver lifecycleObserver;

        @OXOo.OOXIXo
        private Lifecycle.State state;

        public ObserverWithState(@OXOo.oOoXoXO LifecycleObserver lifecycleObserver, @OXOo.OOXIXo Lifecycle.State initialState) {
            IIX0o.x0xO0oo(initialState, "initialState");
            IIX0o.ooOOo0oXI(lifecycleObserver);
            this.lifecycleObserver = Lifecycling.lifecycleEventObserver(lifecycleObserver);
            this.state = initialState;
        }

        public final void dispatchEvent(@OXOo.oOoXoXO LifecycleOwner lifecycleOwner, @OXOo.OOXIXo Lifecycle.Event event) {
            IIX0o.x0xO0oo(event, "event");
            Lifecycle.State targetState = event.getTargetState();
            this.state = LifecycleRegistry.Companion.min$lifecycle_runtime_release(this.state, targetState);
            LifecycleEventObserver lifecycleEventObserver = this.lifecycleObserver;
            IIX0o.ooOOo0oXI(lifecycleOwner);
            lifecycleEventObserver.onStateChanged(lifecycleOwner, event);
            this.state = targetState;
        }

        @OXOo.OOXIXo
        public final LifecycleEventObserver getLifecycleObserver() {
            return this.lifecycleObserver;
        }

        @OXOo.OOXIXo
        public final Lifecycle.State getState() {
            return this.state;
        }

        public final void setLifecycleObserver(@OXOo.OOXIXo LifecycleEventObserver lifecycleEventObserver) {
            IIX0o.x0xO0oo(lifecycleEventObserver, "<set-?>");
            this.lifecycleObserver = lifecycleEventObserver;
        }

        public final void setState(@OXOo.OOXIXo Lifecycle.State state) {
            IIX0o.x0xO0oo(state, "<set-?>");
            this.state = state;
        }
    }

    public /* synthetic */ LifecycleRegistry(LifecycleOwner lifecycleOwner, boolean z, IIXOooo iIXOooo) {
        this(lifecycleOwner, z);
    }

    private final void backwardPass(LifecycleOwner lifecycleOwner) {
        Iterator<Map.Entry<LifecycleObserver, ObserverWithState>> descendingIterator = this.observerMap.descendingIterator();
        IIX0o.oO(descendingIterator, "observerMap.descendingIterator()");
        while (descendingIterator.hasNext() && !this.newEventOccurred) {
            Map.Entry<LifecycleObserver, ObserverWithState> next = descendingIterator.next();
            IIX0o.oO(next, "next()");
            LifecycleObserver key = next.getKey();
            ObserverWithState value = next.getValue();
            while (value.getState().compareTo(this.state) > 0 && !this.newEventOccurred && this.observerMap.contains(key)) {
                Lifecycle.Event downFrom = Lifecycle.Event.Companion.downFrom(value.getState());
                if (downFrom != null) {
                    pushParentState(downFrom.getTargetState());
                    value.dispatchEvent(lifecycleOwner, downFrom);
                    popParentState();
                } else {
                    throw new IllegalStateException("no event down from " + value.getState());
                }
            }
        }
    }

    private final Lifecycle.State calculateTargetState(LifecycleObserver lifecycleObserver) {
        Lifecycle.State state;
        ObserverWithState value;
        Map.Entry<LifecycleObserver, ObserverWithState> ceil = this.observerMap.ceil(lifecycleObserver);
        Lifecycle.State state2 = null;
        if (ceil != null && (value = ceil.getValue()) != null) {
            state = value.getState();
        } else {
            state = null;
        }
        if (!this.parentStates.isEmpty()) {
            state2 = this.parentStates.get(r0.size() - 1);
        }
        Companion companion = Companion;
        return companion.min$lifecycle_runtime_release(companion.min$lifecycle_runtime_release(this.state, state), state2);
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    @VisibleForTesting
    public static final LifecycleRegistry createUnsafe(@OXOo.OOXIXo LifecycleOwner lifecycleOwner) {
        return Companion.createUnsafe(lifecycleOwner);
    }

    @SuppressLint({"RestrictedApi"})
    private final void enforceMainThreadIfNeeded(String str) {
        if (this.enforceMainThread && !ArchTaskExecutor.getInstance().isMainThread()) {
            throw new IllegalStateException(("Method " + str + " must be called on the main thread").toString());
        }
    }

    private final void forwardPass(LifecycleOwner lifecycleOwner) {
        SafeIterableMap<LifecycleObserver, ObserverWithState>.IteratorWithAdditions iteratorWithAdditions = this.observerMap.iteratorWithAdditions();
        IIX0o.oO(iteratorWithAdditions, "observerMap.iteratorWithAdditions()");
        while (iteratorWithAdditions.hasNext() && !this.newEventOccurred) {
            Map.Entry next = iteratorWithAdditions.next();
            LifecycleObserver lifecycleObserver = (LifecycleObserver) next.getKey();
            ObserverWithState observerWithState = (ObserverWithState) next.getValue();
            while (observerWithState.getState().compareTo(this.state) < 0 && !this.newEventOccurred && this.observerMap.contains(lifecycleObserver)) {
                pushParentState(observerWithState.getState());
                Lifecycle.Event upFrom = Lifecycle.Event.Companion.upFrom(observerWithState.getState());
                if (upFrom != null) {
                    observerWithState.dispatchEvent(lifecycleOwner, upFrom);
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
        Lifecycle.State state = eldest.getValue().getState();
        Map.Entry<LifecycleObserver, ObserverWithState> newest = this.observerMap.newest();
        IIX0o.ooOOo0oXI(newest);
        Lifecycle.State state2 = newest.getValue().getState();
        if (state == state2 && this.state == state2) {
            return true;
        }
        return false;
    }

    private final void moveToState(Lifecycle.State state) {
        Lifecycle.State state2 = this.state;
        if (state2 == state) {
            return;
        }
        if (state2 == Lifecycle.State.INITIALIZED && state == Lifecycle.State.DESTROYED) {
            throw new IllegalStateException(("no event down from " + this.state + " in component " + this.lifecycleOwner.get()).toString());
        }
        this.state = state;
        if (!this.handlingEvent && this.addingObserverCounter == 0) {
            this.handlingEvent = true;
            sync();
            this.handlingEvent = false;
            if (this.state == Lifecycle.State.DESTROYED) {
                this.observerMap = new FastSafeIterableMap<>();
                return;
            }
            return;
        }
        this.newEventOccurred = true;
    }

    private final void popParentState() {
        this.parentStates.remove(r0.size() - 1);
    }

    private final void pushParentState(Lifecycle.State state) {
        this.parentStates.add(state);
    }

    private final void sync() {
        LifecycleOwner lifecycleOwner = this.lifecycleOwner.get();
        if (lifecycleOwner != null) {
            while (!isSynced()) {
                this.newEventOccurred = false;
                Lifecycle.State state = this.state;
                Map.Entry<LifecycleObserver, ObserverWithState> eldest = this.observerMap.eldest();
                IIX0o.ooOOo0oXI(eldest);
                if (state.compareTo(eldest.getValue().getState()) < 0) {
                    backwardPass(lifecycleOwner);
                }
                Map.Entry<LifecycleObserver, ObserverWithState> newest = this.observerMap.newest();
                if (!this.newEventOccurred && newest != null && this.state.compareTo(newest.getValue().getState()) > 0) {
                    forwardPass(lifecycleOwner);
                }
            }
            this.newEventOccurred = false;
            return;
        }
        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
    }

    @Override // androidx.lifecycle.Lifecycle
    public void addObserver(@OXOo.OOXIXo LifecycleObserver observer) {
        LifecycleOwner lifecycleOwner;
        boolean z;
        IIX0o.x0xO0oo(observer, "observer");
        enforceMainThreadIfNeeded("addObserver");
        Lifecycle.State state = this.state;
        Lifecycle.State state2 = Lifecycle.State.DESTROYED;
        if (state != state2) {
            state2 = Lifecycle.State.INITIALIZED;
        }
        ObserverWithState observerWithState = new ObserverWithState(observer, state2);
        if (this.observerMap.putIfAbsent(observer, observerWithState) != null || (lifecycleOwner = this.lifecycleOwner.get()) == null) {
            return;
        }
        if (this.addingObserverCounter == 0 && !this.handlingEvent) {
            z = false;
        } else {
            z = true;
        }
        Lifecycle.State calculateTargetState = calculateTargetState(observer);
        this.addingObserverCounter++;
        while (observerWithState.getState().compareTo(calculateTargetState) < 0 && this.observerMap.contains(observer)) {
            pushParentState(observerWithState.getState());
            Lifecycle.Event upFrom = Lifecycle.Event.Companion.upFrom(observerWithState.getState());
            if (upFrom != null) {
                observerWithState.dispatchEvent(lifecycleOwner, upFrom);
                popParentState();
                calculateTargetState = calculateTargetState(observer);
            } else {
                throw new IllegalStateException("no event up from " + observerWithState.getState());
            }
        }
        if (!z) {
            sync();
        }
        this.addingObserverCounter--;
    }

    @Override // androidx.lifecycle.Lifecycle
    @OXOo.OOXIXo
    public Lifecycle.State getCurrentState() {
        return this.state;
    }

    public int getObserverCount() {
        enforceMainThreadIfNeeded("getObserverCount");
        return this.observerMap.size();
    }

    public void handleLifecycleEvent(@OXOo.OOXIXo Lifecycle.Event event) {
        IIX0o.x0xO0oo(event, "event");
        enforceMainThreadIfNeeded("handleLifecycleEvent");
        moveToState(event.getTargetState());
    }

    @kotlin.OOXIXo(message = "Override [currentState].")
    @MainThread
    public void markState(@OXOo.OOXIXo Lifecycle.State state) {
        IIX0o.x0xO0oo(state, "state");
        enforceMainThreadIfNeeded("markState");
        setCurrentState(state);
    }

    @Override // androidx.lifecycle.Lifecycle
    public void removeObserver(@OXOo.OOXIXo LifecycleObserver observer) {
        IIX0o.x0xO0oo(observer, "observer");
        enforceMainThreadIfNeeded("removeObserver");
        this.observerMap.remove(observer);
    }

    public void setCurrentState(@OXOo.OOXIXo Lifecycle.State state) {
        IIX0o.x0xO0oo(state, "state");
        enforceMainThreadIfNeeded("setCurrentState");
        moveToState(state);
    }

    private LifecycleRegistry(LifecycleOwner lifecycleOwner, boolean z) {
        this.enforceMainThread = z;
        this.observerMap = new FastSafeIterableMap<>();
        this.state = Lifecycle.State.INITIALIZED;
        this.parentStates = new ArrayList<>();
        this.lifecycleOwner = new WeakReference<>(lifecycleOwner);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LifecycleRegistry(@OXOo.OOXIXo LifecycleOwner provider) {
        this(provider, true);
        IIX0o.x0xO0oo(provider, "provider");
    }
}
