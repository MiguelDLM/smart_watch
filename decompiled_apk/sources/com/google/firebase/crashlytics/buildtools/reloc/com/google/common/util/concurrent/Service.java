package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.Beta;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtIncompatible;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Beta
@GwtIncompatible
/* loaded from: classes10.dex */
public interface Service {

    @Beta
    /* loaded from: classes10.dex */
    public static abstract class Listener {
        public void failed(State state, Throwable th) {
        }

        public void running() {
        }

        public void starting() {
        }

        public void stopping(State state) {
        }

        public void terminated(State state) {
        }
    }

    @Beta
    /* loaded from: classes10.dex */
    public enum State {
        NEW { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.Service.State.1
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.Service.State
            public boolean isTerminal() {
                return false;
            }
        },
        STARTING { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.Service.State.2
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.Service.State
            public boolean isTerminal() {
                return false;
            }
        },
        RUNNING { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.Service.State.3
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.Service.State
            public boolean isTerminal() {
                return false;
            }
        },
        STOPPING { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.Service.State.4
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.Service.State
            public boolean isTerminal() {
                return false;
            }
        },
        TERMINATED { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.Service.State.5
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.Service.State
            public boolean isTerminal() {
                return true;
            }
        },
        FAILED { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.Service.State.6
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.Service.State
            public boolean isTerminal() {
                return true;
            }
        };

        public abstract boolean isTerminal();
    }

    void addListener(Listener listener, Executor executor);

    void awaitRunning();

    void awaitRunning(long j, TimeUnit timeUnit) throws TimeoutException;

    void awaitTerminated();

    void awaitTerminated(long j, TimeUnit timeUnit) throws TimeoutException;

    Throwable failureCause();

    boolean isRunning();

    @CanIgnoreReturnValue
    Service startAsync();

    State state();

    @CanIgnoreReturnValue
    Service stopAsync();
}
