package com.facebook.bolts;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes8.dex */
public final class BoltsExecutors {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    private static final BoltsExecutors INSTANCE = new BoltsExecutors();

    @OXOo.OOXIXo
    private final ExecutorService background;

    @OXOo.OOXIXo
    private final Executor immediate;

    @OXOo.OOXIXo
    private final ScheduledExecutorService scheduled;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isAndroidRuntime() {
            String property = System.getProperty("java.runtime.name");
            if (property == null) {
                return false;
            }
            Locale US = Locale.US;
            IIX0o.oO(US, "US");
            String lowerCase = property.toLowerCase(US);
            IIX0o.oO(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            return StringsKt__StringsKt.o00xOoIO(lowerCase, "android", false, 2, null);
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final ExecutorService background() {
            return BoltsExecutors.INSTANCE.background;
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final Executor immediate$facebook_bolts_release() {
            return BoltsExecutors.INSTANCE.immediate;
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final ScheduledExecutorService scheduled$facebook_bolts_release() {
            return BoltsExecutors.INSTANCE.scheduled;
        }

        private Companion() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class ImmediateExecutor implements Executor {

        @OXOo.OOXIXo
        public static final Companion Companion = new Companion(null);
        private static final int MAX_DEPTH = 15;

        @OXOo.OOXIXo
        private final ThreadLocal<Integer> executionDepth = new ThreadLocal<>();

        /* loaded from: classes8.dex */
        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            private Companion() {
            }
        }

        private final int decrementDepth() {
            Integer num = this.executionDepth.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.executionDepth.remove();
            } else {
                this.executionDepth.set(Integer.valueOf(intValue));
            }
            return intValue;
        }

        private final int incrementDepth() {
            Integer num = this.executionDepth.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() + 1;
            this.executionDepth.set(Integer.valueOf(intValue));
            return intValue;
        }

        @Override // java.util.concurrent.Executor
        public void execute(@OXOo.OOXIXo Runnable command) {
            IIX0o.x0xO0oo(command, "command");
            try {
                if (incrementDepth() <= 15) {
                    command.run();
                } else {
                    BoltsExecutors.Companion.background().execute(command);
                }
                decrementDepth();
            } catch (Throwable th) {
                decrementDepth();
                throw th;
            }
        }
    }

    private BoltsExecutors() {
        ExecutorService newCachedThreadPool;
        if (!Companion.isAndroidRuntime()) {
            newCachedThreadPool = Executors.newCachedThreadPool();
            IIX0o.oO(newCachedThreadPool, "newCachedThreadPool()");
        } else {
            newCachedThreadPool = AndroidExecutors.Companion.newCachedThreadPool();
        }
        this.background = newCachedThreadPool;
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        IIX0o.oO(newSingleThreadScheduledExecutor, "newSingleThreadScheduledExecutor()");
        this.scheduled = newSingleThreadScheduledExecutor;
        this.immediate = new ImmediateExecutor();
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final ExecutorService background() {
        return Companion.background();
    }
}
