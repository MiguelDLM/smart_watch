package org.apache.commons.lang3.concurrent;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public abstract class AbstractCircuitBreaker<T> implements XO<T> {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final String f32674I0Io = "open";

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final AtomicReference<State> f32676oIX0oI = new AtomicReference<>(State.CLOSED);

    /* renamed from: II0xO0, reason: collision with root package name */
    public final PropertyChangeSupport f32675II0xO0 = new PropertyChangeSupport(this);

    /* loaded from: classes6.dex */
    public enum State {
        CLOSED { // from class: org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.State.1
            @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.State
            public State oppositeState() {
                return State.OPEN;
            }
        },
        OPEN { // from class: org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.State.2
            @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.State
            public State oppositeState() {
                return State.CLOSED;
            }
        };

        public abstract State oppositeState();
    }

    public static boolean X0o0xo(State state) {
        if (state == State.OPEN) {
            return true;
        }
        return false;
    }

    public void I0Io(PropertyChangeListener propertyChangeListener) {
        this.f32675II0xO0.addPropertyChangeListener(propertyChangeListener);
    }

    @Override // org.apache.commons.lang3.concurrent.XO
    public abstract boolean II0xO0(T t);

    public void XO(PropertyChangeListener propertyChangeListener) {
        this.f32675II0xO0.removePropertyChangeListener(propertyChangeListener);
    }

    @Override // org.apache.commons.lang3.concurrent.XO
    public void close() {
        oxoX(State.CLOSED);
    }

    @Override // org.apache.commons.lang3.concurrent.XO
    public boolean isClosed() {
        return !isOpen();
    }

    @Override // org.apache.commons.lang3.concurrent.XO
    public boolean isOpen() {
        return X0o0xo(this.f32676oIX0oI.get());
    }

    @Override // org.apache.commons.lang3.concurrent.XO
    public abstract boolean oIX0oI();

    @Override // org.apache.commons.lang3.concurrent.XO
    public void open() {
        oxoX(State.OPEN);
    }

    public void oxoX(State state) {
        if (androidx.lifecycle.Oxx0IOOO.oIX0oI(this.f32676oIX0oI, state.oppositeState(), state)) {
            this.f32675II0xO0.firePropertyChange("open", !X0o0xo(state), X0o0xo(state));
        }
    }
}
