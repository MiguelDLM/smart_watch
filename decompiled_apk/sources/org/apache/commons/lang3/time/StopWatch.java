package org.apache.commons.lang3.time;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
public class StopWatch {

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final long f32898Oxx0IOOO = 1000000;

    /* renamed from: I0Io, reason: collision with root package name */
    public SplitState f32899I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public State f32900II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public long f32901X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public long f32902XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final String f32903oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public long f32904oxoX;

    /* loaded from: classes6.dex */
    public enum SplitState {
        SPLIT,
        UNSPLIT
    }

    /* loaded from: classes6.dex */
    public enum State {
        RUNNING { // from class: org.apache.commons.lang3.time.StopWatch.State.1
            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isStarted() {
                return true;
            }

            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isStopped() {
                return false;
            }

            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isSuspended() {
                return false;
            }
        },
        STOPPED { // from class: org.apache.commons.lang3.time.StopWatch.State.2
            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isStarted() {
                return false;
            }

            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isStopped() {
                return true;
            }

            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isSuspended() {
                return false;
            }
        },
        SUSPENDED { // from class: org.apache.commons.lang3.time.StopWatch.State.3
            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isStarted() {
                return true;
            }

            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isStopped() {
                return false;
            }

            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isSuspended() {
                return true;
            }
        },
        UNSTARTED { // from class: org.apache.commons.lang3.time.StopWatch.State.4
            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isStarted() {
                return false;
            }

            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isStopped() {
                return true;
            }

            @Override // org.apache.commons.lang3.time.StopWatch.State
            public boolean isSuspended() {
                return false;
            }
        };

        public abstract boolean isStarted();

        public abstract boolean isStopped();

        public abstract boolean isSuspended();
    }

    public StopWatch() {
        this(null);
    }

    public static StopWatch II0xO0() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.IXxxXO();
        return stopWatch;
    }

    public static StopWatch oIX0oI() {
        return new StopWatch();
    }

    public String I0Io() {
        return X0o0xo.oxoX(II0XooXoX());
    }

    public long II0XooXoX() {
        return Oxx0IOOO() / 1000000;
    }

    public void IIXOooo() {
        if (this.f32899I0Io == SplitState.SPLIT) {
            this.f32899I0Io = SplitState.UNSPLIT;
            return;
        }
        throw new IllegalStateException("Stopwatch has not been split. ");
    }

    public void IXxxXO() {
        State state = this.f32900II0xO0;
        if (state != State.STOPPED) {
            if (state == State.UNSTARTED) {
                this.f32904oxoX = System.nanoTime();
                this.f32901X0o0xo = System.currentTimeMillis();
                this.f32900II0xO0 = State.RUNNING;
                return;
            }
            throw new IllegalStateException("Stopwatch already started. ");
        }
        throw new IllegalStateException("Stopwatch must be reset before being restarted. ");
    }

    public long OOXIXo(TimeUnit timeUnit) {
        return timeUnit.convert(XO(), TimeUnit.NANOSECONDS);
    }

    public void Oo() {
        if (this.f32900II0xO0 == State.RUNNING) {
            this.f32902XO = System.nanoTime();
            this.f32899I0Io = SplitState.SPLIT;
            return;
        }
        throw new IllegalStateException("Stopwatch is not running. ");
    }

    public long Oxx0IOOO() {
        if (this.f32899I0Io == SplitState.SPLIT) {
            return this.f32902XO - this.f32904oxoX;
        }
        throw new IllegalStateException("Stopwatch must be split to get the split time. ");
    }

    public void Oxx0xo() {
        State state = this.f32900II0xO0;
        State state2 = State.RUNNING;
        if (state != state2 && state != State.SUSPENDED) {
            throw new IllegalStateException("Stopwatch is not running. ");
        }
        if (state == state2) {
            this.f32902XO = System.nanoTime();
        }
        this.f32900II0xO0 = State.STOPPED;
    }

    public String OxxIIOOXO() {
        String objects = Objects.toString(this.f32903oIX0oI, "");
        String I0Io2 = I0Io();
        if (!objects.isEmpty()) {
            return objects + " " + I0Io2;
        }
        return I0Io2;
    }

    public String X0o0xo() {
        return this.f32903oIX0oI;
    }

    public long XO() {
        long j;
        long j2;
        State state = this.f32900II0xO0;
        if (state != State.STOPPED && state != State.SUSPENDED) {
            if (state == State.UNSTARTED) {
                return 0L;
            }
            if (state == State.RUNNING) {
                j = System.nanoTime();
                j2 = this.f32904oxoX;
            } else {
                throw new RuntimeException("Illegal running state has occurred.");
            }
        } else {
            j = this.f32902XO;
            j2 = this.f32904oxoX;
        }
        return j - j2;
    }

    public void oI0IIXIo() {
        if (this.f32900II0xO0 == State.RUNNING) {
            this.f32902XO = System.nanoTime();
            this.f32900II0xO0 = State.SUSPENDED;
            return;
        }
        throw new IllegalStateException("Stopwatch must be running to suspend. ");
    }

    public void oO() {
        this.f32900II0xO0 = State.UNSTARTED;
        this.f32899I0Io = SplitState.UNSPLIT;
    }

    public boolean oOoXoXO() {
        return this.f32900II0xO0.isStarted();
    }

    public boolean ooOOo0oXI() {
        return this.f32900II0xO0.isStopped();
    }

    public String oxoX() {
        return X0o0xo.oxoX(xoIox());
    }

    public String toString() {
        String objects = Objects.toString(this.f32903oIX0oI, "");
        String oxoX2 = oxoX();
        if (!objects.isEmpty()) {
            return objects + " " + oxoX2;
        }
        return oxoX2;
    }

    public boolean x0XOIxOo() {
        return this.f32900II0xO0.isSuspended();
    }

    public void x0xO0oo() {
        if (this.f32900II0xO0 == State.SUSPENDED) {
            this.f32904oxoX += System.nanoTime() - this.f32902XO;
            this.f32900II0xO0 = State.RUNNING;
            return;
        }
        throw new IllegalStateException("Stopwatch must be suspended to resume. ");
    }

    public long xoIox() {
        return XO() / 1000000;
    }

    public long xxIXOIIO() {
        if (this.f32900II0xO0 != State.UNSTARTED) {
            return this.f32901X0o0xo;
        }
        throw new IllegalStateException("Stopwatch has not been started");
    }

    public StopWatch(String str) {
        this.f32900II0xO0 = State.UNSTARTED;
        this.f32899I0Io = SplitState.UNSPLIT;
        this.f32903oIX0oI = str;
    }
}
