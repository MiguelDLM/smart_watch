package androidx.work;

import OXOo.OOXIXo;
import XO0OX.II0xO0;
import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.work.WorkRequest;
import androidx.work.impl.utils.DurationApi26Impl;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.reflect.oxoX;

public final class PeriodicWorkRequest extends WorkRequest {
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);
    @SuppressLint({"MinMaxConstant"})
    public static final long MIN_PERIODIC_FLEX_MILLIS = 300000;
    @SuppressLint({"MinMaxConstant"})
    public static final long MIN_PERIODIC_INTERVAL_MILLIS = 900000;

    @XX({"SMAP\nPeriodicWorkRequest.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PeriodicWorkRequest.kt\nandroidx/work/PeriodicWorkRequest$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,420:1\n1#2:421\n*E\n"})
    public static final class Builder extends WorkRequest.Builder<Builder, PeriodicWorkRequest> {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Builder(@OOXIXo Class<? extends ListenableWorker> cls, long j, @OOXIXo TimeUnit timeUnit) {
            super(cls);
            IIX0o.x0xO0oo(cls, "workerClass");
            IIX0o.x0xO0oo(timeUnit, "repeatIntervalTimeUnit");
            getWorkSpec$work_runtime_release().setPeriodic(timeUnit.toMillis(j));
        }

        @OOXIXo
        public final Builder clearNextScheduleTimeOverride() {
            getWorkSpec$work_runtime_release().setNextScheduleTimeOverride(Long.MAX_VALUE);
            getWorkSpec$work_runtime_release().setNextScheduleTimeOverrideGeneration(1);
            return this;
        }

        @OOXIXo
        public Builder getThisObject$work_runtime_release() {
            return this;
        }

        @OOXIXo
        public final Builder setNextScheduleTimeOverride(long j) {
            if (j != Long.MAX_VALUE) {
                getWorkSpec$work_runtime_release().setNextScheduleTimeOverride(j);
                getWorkSpec$work_runtime_release().setNextScheduleTimeOverrideGeneration(1);
                return this;
            }
            throw new IllegalArgumentException("Cannot set Long.MAX_VALUE as the schedule override time");
        }

        @OOXIXo
        public PeriodicWorkRequest buildInternal$work_runtime_release() {
            if (getBackoffCriteriaSet$work_runtime_release() && Build.VERSION.SDK_INT >= 23 && getWorkSpec$work_runtime_release().constraints.requiresDeviceIdle()) {
                throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
            } else if (!getWorkSpec$work_runtime_release().expedited) {
                return new PeriodicWorkRequest(this);
            } else {
                throw new IllegalArgumentException("PeriodicWorkRequests cannot be expedited");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Builder(@OOXIXo oxoX<? extends ListenableWorker> oxox, long j, @OOXIXo TimeUnit timeUnit) {
            super(II0xO0.X0o0xo(oxox));
            IIX0o.x0xO0oo(oxox, "workerClass");
            IIX0o.x0xO0oo(timeUnit, "repeatIntervalTimeUnit");
            getWorkSpec$work_runtime_release().setPeriodic(timeUnit.toMillis(j));
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        @RequiresApi(26)
        public Builder(@OOXIXo Class<? extends ListenableWorker> cls, @OOXIXo Duration duration) {
            super(cls);
            IIX0o.x0xO0oo(cls, "workerClass");
            IIX0o.x0xO0oo(duration, "repeatInterval");
            getWorkSpec$work_runtime_release().setPeriodic(DurationApi26Impl.toMillisCompat(duration));
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        @RequiresApi(26)
        public Builder(@OOXIXo oxoX<? extends ListenableWorker> oxox, @OOXIXo Duration duration) {
            super(II0xO0.X0o0xo(oxox));
            IIX0o.x0xO0oo(oxox, "workerClass");
            IIX0o.x0xO0oo(duration, "repeatInterval");
            getWorkSpec$work_runtime_release().setPeriodic(DurationApi26Impl.toMillisCompat(duration));
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Builder(@OOXIXo Class<? extends ListenableWorker> cls, long j, @OOXIXo TimeUnit timeUnit, long j2, @OOXIXo TimeUnit timeUnit2) {
            super(cls);
            IIX0o.x0xO0oo(cls, "workerClass");
            IIX0o.x0xO0oo(timeUnit, "repeatIntervalTimeUnit");
            IIX0o.x0xO0oo(timeUnit2, "flexIntervalTimeUnit");
            getWorkSpec$work_runtime_release().setPeriodic(timeUnit.toMillis(j), timeUnit2.toMillis(j2));
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Builder(@OOXIXo oxoX<? extends ListenableWorker> oxox, long j, @OOXIXo TimeUnit timeUnit, long j2, @OOXIXo TimeUnit timeUnit2) {
            super(II0xO0.X0o0xo(oxox));
            IIX0o.x0xO0oo(oxox, "workerClass");
            IIX0o.x0xO0oo(timeUnit, "repeatIntervalTimeUnit");
            IIX0o.x0xO0oo(timeUnit2, "flexIntervalTimeUnit");
            getWorkSpec$work_runtime_release().setPeriodic(timeUnit.toMillis(j), timeUnit2.toMillis(j2));
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        @RequiresApi(26)
        public Builder(@OOXIXo Class<? extends ListenableWorker> cls, @OOXIXo Duration duration, @OOXIXo Duration duration2) {
            super(cls);
            IIX0o.x0xO0oo(cls, "workerClass");
            IIX0o.x0xO0oo(duration, "repeatInterval");
            IIX0o.x0xO0oo(duration2, "flexInterval");
            getWorkSpec$work_runtime_release().setPeriodic(DurationApi26Impl.toMillisCompat(duration), DurationApi26Impl.toMillisCompat(duration2));
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        @RequiresApi(26)
        public Builder(@OOXIXo oxoX<? extends ListenableWorker> oxox, @OOXIXo Duration duration, @OOXIXo Duration duration2) {
            super(II0xO0.X0o0xo(oxox));
            IIX0o.x0xO0oo(oxox, "workerClass");
            IIX0o.x0xO0oo(duration, "repeatInterval");
            IIX0o.x0xO0oo(duration2, "flexInterval");
            getWorkSpec$work_runtime_release().setPeriodic(DurationApi26Impl.toMillisCompat(duration), DurationApi26Impl.toMillisCompat(duration2));
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PeriodicWorkRequest(@OOXIXo Builder builder) {
        super(builder.getId$work_runtime_release(), builder.getWorkSpec$work_runtime_release(), builder.getTags$work_runtime_release());
        IIX0o.x0xO0oo(builder, "builder");
    }
}
