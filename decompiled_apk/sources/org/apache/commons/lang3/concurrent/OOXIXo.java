package org.apache.commons.lang3.concurrent;

import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;

/* loaded from: classes6.dex */
public class OOXIXo extends AbstractCircuitBreaker<Integer> {

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final Map<AbstractCircuitBreaker.State, I0Io> f32685xxIXOIIO = II0XooXoX();

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public final long f32686II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public final int f32687Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final int f32688X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final long f32689XO;

    /* renamed from: oxoX, reason: collision with root package name */
    public final AtomicReference<II0xO0> f32690oxoX;

    /* loaded from: classes6.dex */
    public static abstract class I0Io {
        public I0Io() {
        }

        public abstract boolean I0Io(OOXIXo oOXIXo, II0xO0 iI0xO0, II0xO0 iI0xO02);

        public boolean II0xO0(OOXIXo oOXIXo, II0xO0 iI0xO0, long j) {
            if (j - iI0xO0.oIX0oI() > oIX0oI(oOXIXo)) {
                return true;
            }
            return false;
        }

        public abstract long oIX0oI(OOXIXo oOXIXo);
    }

    /* loaded from: classes6.dex */
    public static class II0xO0 {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final long f32691II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final int f32692oIX0oI;

        public II0xO0(int i, long j) {
            this.f32692oIX0oI = i;
            this.f32691II0xO0 = j;
        }

        public II0xO0 I0Io(int i) {
            if (i == 0) {
                return this;
            }
            return new II0xO0(II0xO0() + i, oIX0oI());
        }

        public int II0xO0() {
            return this.f32692oIX0oI;
        }

        public long oIX0oI() {
            return this.f32691II0xO0;
        }
    }

    /* loaded from: classes6.dex */
    public static class X0o0xo extends I0Io {
        public X0o0xo() {
            super();
        }

        @Override // org.apache.commons.lang3.concurrent.OOXIXo.I0Io
        public boolean I0Io(OOXIXo oOXIXo, II0xO0 iI0xO0, II0xO0 iI0xO02) {
            if (iI0xO02.oIX0oI() != iI0xO0.oIX0oI() && iI0xO0.II0xO0() < oOXIXo.xoIox()) {
                return true;
            }
            return false;
        }

        @Override // org.apache.commons.lang3.concurrent.OOXIXo.I0Io
        public long oIX0oI(OOXIXo oOXIXo) {
            return oOXIXo.xxIXOIIO();
        }
    }

    /* loaded from: classes6.dex */
    public static class oxoX extends I0Io {
        public oxoX() {
            super();
        }

        @Override // org.apache.commons.lang3.concurrent.OOXIXo.I0Io
        public boolean I0Io(OOXIXo oOXIXo, II0xO0 iI0xO0, II0xO0 iI0xO02) {
            if (iI0xO02.II0xO0() > oOXIXo.oOoXoXO()) {
                return true;
            }
            return false;
        }

        @Override // org.apache.commons.lang3.concurrent.OOXIXo.I0Io
        public long oIX0oI(OOXIXo oOXIXo) {
            return oOXIXo.OOXIXo();
        }
    }

    public OOXIXo(int i, long j, TimeUnit timeUnit, int i2, long j2, TimeUnit timeUnit2) {
        this.f32690oxoX = new AtomicReference<>(new II0xO0(0, 0L));
        this.f32688X0o0xo = i;
        this.f32689XO = timeUnit.toNanos(j);
        this.f32687Oxx0IOOO = i2;
        this.f32686II0XooXoX = timeUnit2.toNanos(j2);
    }

    public static Map<AbstractCircuitBreaker.State, I0Io> II0XooXoX() {
        EnumMap enumMap = new EnumMap(AbstractCircuitBreaker.State.class);
        enumMap.put((EnumMap) AbstractCircuitBreaker.State.CLOSED, (AbstractCircuitBreaker.State) new oxoX());
        enumMap.put((EnumMap) AbstractCircuitBreaker.State.OPEN, (AbstractCircuitBreaker.State) new X0o0xo());
        return enumMap;
    }

    public static I0Io IXxxXO(AbstractCircuitBreaker.State state) {
        return f32685xxIXOIIO.get(state);
    }

    public long OOXIXo() {
        return this.f32689XO;
    }

    public final boolean Oo(int i) {
        AbstractCircuitBreaker.State state;
        II0xO0 iI0xO0;
        II0xO0 oO2;
        do {
            long x0xO0oo2 = x0xO0oo();
            state = this.f32676oIX0oI.get();
            iI0xO0 = this.f32690oxoX.get();
            oO2 = oO(i, iI0xO0, state, x0xO0oo2);
        } while (!Oxx0xo(iI0xO0, oO2));
        if (IXxxXO(state).I0Io(this, iI0xO0, oO2)) {
            state = state.oppositeState();
            Oxx0IOOO(state);
        }
        return !AbstractCircuitBreaker.X0o0xo(state);
    }

    public final void Oxx0IOOO(AbstractCircuitBreaker.State state) {
        oxoX(state);
        this.f32690oxoX.set(new II0xO0(0, x0xO0oo()));
    }

    public final boolean Oxx0xo(II0xO0 iI0xO0, II0xO0 iI0xO02) {
        if (iI0xO0 != iI0xO02 && !androidx.lifecycle.Oxx0IOOO.oIX0oI(this.f32690oxoX, iI0xO0, iI0xO02)) {
            return false;
        }
        return true;
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker, org.apache.commons.lang3.concurrent.XO
    public void close() {
        super.close();
        this.f32690oxoX.set(new II0xO0(0, x0xO0oo()));
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker, org.apache.commons.lang3.concurrent.XO
    public boolean oIX0oI() {
        return Oo(0);
    }

    public final II0xO0 oO(int i, II0xO0 iI0xO0, AbstractCircuitBreaker.State state, long j) {
        if (IXxxXO(state).II0xO0(this, iI0xO0, j)) {
            return new II0xO0(i, j);
        }
        return iI0xO0.I0Io(i);
    }

    public int oOoXoXO() {
        return this.f32688X0o0xo;
    }

    public boolean ooOOo0oXI() {
        return II0xO0(1);
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker, org.apache.commons.lang3.concurrent.XO
    public void open() {
        super.open();
        this.f32690oxoX.set(new II0xO0(0, x0xO0oo()));
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker, org.apache.commons.lang3.concurrent.XO
    /* renamed from: x0XOIxOo, reason: merged with bridge method [inline-methods] */
    public boolean II0xO0(Integer num) {
        return Oo(num.intValue());
    }

    public long x0xO0oo() {
        return System.nanoTime();
    }

    public int xoIox() {
        return this.f32687Oxx0IOOO;
    }

    public long xxIXOIIO() {
        return this.f32686II0XooXoX;
    }

    public OOXIXo(int i, long j, TimeUnit timeUnit, int i2) {
        this(i, j, timeUnit, i2, j, timeUnit);
    }

    public OOXIXo(int i, long j, TimeUnit timeUnit) {
        this(i, j, timeUnit, i);
    }
}
