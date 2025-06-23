package androidx.work;

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

/* loaded from: classes.dex */
public final class PeriodicWorkRequest extends WorkRequest {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @SuppressLint({"MinMaxConstant"})
    public static final long MIN_PERIODIC_FLEX_MILLIS = 300000;

    @SuppressLint({"MinMaxConstant"})
    public static final long MIN_PERIODIC_INTERVAL_MILLIS = 900000;

    @XX({"SMAP\nPeriodicWorkRequest.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PeriodicWorkRequest.kt\nandroidx/work/PeriodicWorkRequest$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,420:1\n1#2:421\n*E\n"})
    /* loaded from: classes.dex */
    public static final class Builder extends WorkRequest.Builder<Builder, PeriodicWorkRequest> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(@OXOo.OOXIXo Class<? extends ListenableWorker> workerClass, long j, @OXOo.OOXIXo TimeUnit repeatIntervalTimeUnit) {
            super(workerClass);
            IIX0o.x0xO0oo(workerClass, "workerClass");
            IIX0o.x0xO0oo(repeatIntervalTimeUnit, "repeatIntervalTimeUnit");
            getWorkSpec$work_runtime_release().setPeriodic(repeatIntervalTimeUnit.toMillis(j));
        }

        @OXOo.OOXIXo
        public final Builder clearNextScheduleTimeOverride() {
            getWorkSpec$work_runtime_release().setNextScheduleTimeOverride(Long.MAX_VALUE);
            getWorkSpec$work_runtime_release().setNextScheduleTimeOverrideGeneration(1);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.work.WorkRequest.Builder
        @OXOo.OOXIXo
        public Builder getThisObject$work_runtime_release() {
            return this;
        }

        @OXOo.OOXIXo
        public final Builder setNextScheduleTimeOverride(long j) {
            if (j != Long.MAX_VALUE) {
                getWorkSpec$work_runtime_release().setNextScheduleTimeOverride(j);
                getWorkSpec$work_runtime_release().setNextScheduleTimeOverrideGeneration(1);
                return this;
            }
            throw new IllegalArgumentException("Cannot set Long.MAX_VALUE as the schedule override time");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.work.WorkRequest.Builder
        @OXOo.OOXIXo
        public PeriodicWorkRequest buildInternal$work_runtime_release() {
            if (getBackoffCriteriaSet$work_runtime_release() && Build.VERSION.SDK_INT >= 23 && getWorkSpec$work_runtime_release().constraints.requiresDeviceIdle()) {
                throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
            }
            if (!getWorkSpec$work_runtime_release().expedited) {
                return new PeriodicWorkRequest(this);
            }
            throw new IllegalArgumentException("PeriodicWorkRequests cannot be expedited");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(@OXOo.OOXIXo kotlin.reflect.oxoX<? extends ListenableWorker> workerClass, long j, @OXOo.OOXIXo TimeUnit repeatIntervalTimeUnit) {
            super(XO0OX.II0xO0.X0o0xo(workerClass));
            IIX0o.x0xO0oo(workerClass, "workerClass");
            IIX0o.x0xO0oo(repeatIntervalTimeUnit, "repeatIntervalTimeUnit");
            getWorkSpec$work_runtime_release().setPeriodic(repeatIntervalTimeUnit.toMillis(j));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @RequiresApi(26)
        public Builder(@OXOo.OOXIXo Class<? extends ListenableWorker> workerClass, @OXOo.OOXIXo Duration repeatInterval) {
            super(workerClass);
            IIX0o.x0xO0oo(workerClass, "workerClass");
            IIX0o.x0xO0oo(repeatInterval, "repeatInterval");
            getWorkSpec$work_runtime_release().setPeriodic(DurationApi26Impl.toMillisCompat(repeatInterval));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @RequiresApi(26)
        public Builder(@OXOo.OOXIXo kotlin.reflect.oxoX<? extends ListenableWorker> workerClass, @OXOo.OOXIXo Duration repeatInterval) {
            super(XO0OX.II0xO0.X0o0xo(workerClass));
            IIX0o.x0xO0oo(workerClass, "workerClass");
            IIX0o.x0xO0oo(repeatInterval, "repeatInterval");
            getWorkSpec$work_runtime_release().setPeriodic(DurationApi26Impl.toMillisCompat(repeatInterval));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(@OXOo.OOXIXo Class<? extends ListenableWorker> workerClass, long j, @OXOo.OOXIXo TimeUnit repeatIntervalTimeUnit, long j2, @OXOo.OOXIXo TimeUnit flexIntervalTimeUnit) {
            super(workerClass);
            IIX0o.x0xO0oo(workerClass, "workerClass");
            IIX0o.x0xO0oo(repeatIntervalTimeUnit, "repeatIntervalTimeUnit");
            IIX0o.x0xO0oo(flexIntervalTimeUnit, "flexIntervalTimeUnit");
            getWorkSpec$work_runtime_release().setPeriodic(repeatIntervalTimeUnit.toMillis(j), flexIntervalTimeUnit.toMillis(j2));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(@OXOo.OOXIXo kotlin.reflect.oxoX<? extends ListenableWorker> workerClass, long j, @OXOo.OOXIXo TimeUnit repeatIntervalTimeUnit, long j2, @OXOo.OOXIXo TimeUnit flexIntervalTimeUnit) {
            super(XO0OX.II0xO0.X0o0xo(workerClass));
            IIX0o.x0xO0oo(workerClass, "workerClass");
            IIX0o.x0xO0oo(repeatIntervalTimeUnit, "repeatIntervalTimeUnit");
            IIX0o.x0xO0oo(flexIntervalTimeUnit, "flexIntervalTimeUnit");
            getWorkSpec$work_runtime_release().setPeriodic(repeatIntervalTimeUnit.toMillis(j), flexIntervalTimeUnit.toMillis(j2));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @RequiresApi(26)
        public Builder(@OXOo.OOXIXo Class<? extends ListenableWorker> workerClass, @OXOo.OOXIXo Duration repeatInterval, @OXOo.OOXIXo Duration flexInterval) {
            super(workerClass);
            IIX0o.x0xO0oo(workerClass, "workerClass");
            IIX0o.x0xO0oo(repeatInterval, "repeatInterval");
            IIX0o.x0xO0oo(flexInterval, "flexInterval");
            getWorkSpec$work_runtime_release().setPeriodic(DurationApi26Impl.toMillisCompat(repeatInterval), DurationApi26Impl.toMillisCompat(flexInterval));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @RequiresApi(26)
        public Builder(@OXOo.OOXIXo kotlin.reflect.oxoX<? extends ListenableWorker> workerClass, @OXOo.OOXIXo Duration repeatInterval, @OXOo.OOXIXo Duration flexInterval) {
            super(XO0OX.II0xO0.X0o0xo(workerClass));
            IIX0o.x0xO0oo(workerClass, "workerClass");
            IIX0o.x0xO0oo(repeatInterval, "repeatInterval");
            IIX0o.x0xO0oo(flexInterval, "flexInterval");
            getWorkSpec$work_runtime_release().setPeriodic(DurationApi26Impl.toMillisCompat(repeatInterval), DurationApi26Impl.toMillisCompat(flexInterval));
        }
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PeriodicWorkRequest(@OXOo.OOXIXo Builder builder) {
        super(builder.getId$work_runtime_release(), builder.getWorkSpec$work_runtime_release(), builder.getTags$work_runtime_release());
        IIX0o.x0xO0oo(builder, "builder");
    }
}
