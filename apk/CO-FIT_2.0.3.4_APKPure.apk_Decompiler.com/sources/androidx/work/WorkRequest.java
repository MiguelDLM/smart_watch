package androidx.work;

import OXOo.OOXIXo;
import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.DurationApi26Impl;
import com.baidu.mobads.sdk.internal.bn;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.Xo0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;

public abstract class WorkRequest {
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);
    public static final long DEFAULT_BACKOFF_DELAY_MILLIS = 30000;
    @SuppressLint({"MinMaxConstant"})
    public static final long MAX_BACKOFF_MILLIS = 18000000;
    private static final int MAX_TRACE_SPAN_LENGTH = 127;
    @SuppressLint({"MinMaxConstant"})
    public static final long MIN_BACKOFF_MILLIS = 10000;
    @OOXIXo
    private final UUID id;
    @OOXIXo
    private final Set<String> tags;
    @OOXIXo
    private final WorkSpec workSpec;

    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        /* access modifiers changed from: private */
        public final String deriveTraceTagFromClassName(String str) {
            String str2;
            List XXoO0oX2 = StringsKt__StringsKt.XXoO0oX(str, new String[]{FileUtils.FILE_EXTENSION_SEPARATOR}, false, 0, 6, (Object) null);
            if (XXoO0oX2.size() == 1) {
                str2 = (String) XXoO0oX2.get(0);
            } else {
                str2 = (String) CollectionsKt___CollectionsKt.O0O0Io00X(XXoO0oX2);
            }
            if (str2.length() <= 127) {
                return str2;
            }
            return StringsKt___StringsKt.oOI0IXOO(str2, 127);
        }

        private Companion() {
        }
    }

    public WorkRequest(@OOXIXo UUID uuid, @OOXIXo WorkSpec workSpec2, @OOXIXo Set<String> set) {
        IIX0o.x0xO0oo(uuid, "id");
        IIX0o.x0xO0oo(workSpec2, "workSpec");
        IIX0o.x0xO0oo(set, bn.l);
        this.id = uuid;
        this.workSpec = workSpec2;
        this.tags = set;
    }

    @OOXIXo
    public UUID getId() {
        return this.id;
    }

    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final String getStringId() {
        String uuid = getId().toString();
        IIX0o.oO(uuid, "id.toString()");
        return uuid;
    }

    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Set<String> getTags() {
        return this.tags;
    }

    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final WorkSpec getWorkSpec() {
        return this.workSpec;
    }

    @XX({"SMAP\nWorkRequest.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkRequest.kt\nandroidx/work/WorkRequest$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,387:1\n1#2:388\n*E\n"})
    public static abstract class Builder<B extends Builder<B, ?>, W extends WorkRequest> {
        private boolean backoffCriteriaSet;
        @OOXIXo
        private UUID id;
        @OOXIXo
        private final Set<String> tags;
        @OOXIXo
        private WorkSpec workSpec;
        @OOXIXo
        private final Class<? extends ListenableWorker> workerClass;

        public Builder(@OOXIXo Class<? extends ListenableWorker> cls) {
            IIX0o.x0xO0oo(cls, "workerClass");
            this.workerClass = cls;
            UUID randomUUID = UUID.randomUUID();
            IIX0o.oO(randomUUID, "randomUUID()");
            this.id = randomUUID;
            String uuid = this.id.toString();
            IIX0o.oO(uuid, "id.toString()");
            String name = cls.getName();
            IIX0o.oO(name, "workerClass.name");
            this.workSpec = new WorkSpec(uuid, name);
            String name2 = cls.getName();
            IIX0o.oO(name2, "workerClass.name");
            this.tags = Xo0.Oo(name2);
        }

        @OOXIXo
        public final B addTag(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "tag");
            this.tags.add(str);
            return getThisObject$work_runtime_release();
        }

        @OOXIXo
        public final W build() {
            boolean z;
            W buildInternal$work_runtime_release = buildInternal$work_runtime_release();
            Constraints constraints = this.workSpec.constraints;
            int i = Build.VERSION.SDK_INT;
            if ((i < 24 || !constraints.hasContentUriTriggers()) && !constraints.requiresBatteryNotLow() && !constraints.requiresCharging() && (i < 23 || !constraints.requiresDeviceIdle())) {
                z = false;
            } else {
                z = true;
            }
            WorkSpec workSpec2 = this.workSpec;
            if (workSpec2.expedited) {
                if (z) {
                    throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
                } else if (workSpec2.initialDelay > 0) {
                    throw new IllegalArgumentException("Expedited jobs cannot be delayed");
                }
            }
            if (workSpec2.getTraceTag() == null) {
                WorkSpec workSpec3 = this.workSpec;
                workSpec3.setTraceTag(WorkRequest.Companion.deriveTraceTagFromClassName(workSpec3.workerClassName));
            }
            UUID randomUUID = UUID.randomUUID();
            IIX0o.oO(randomUUID, "randomUUID()");
            setId(randomUUID);
            return buildInternal$work_runtime_release;
        }

        @OOXIXo
        public abstract W buildInternal$work_runtime_release();

        public final boolean getBackoffCriteriaSet$work_runtime_release() {
            return this.backoffCriteriaSet;
        }

        @OOXIXo
        public final UUID getId$work_runtime_release() {
            return this.id;
        }

        @OOXIXo
        public final Set<String> getTags$work_runtime_release() {
            return this.tags;
        }

        @OOXIXo
        public abstract B getThisObject$work_runtime_release();

        @OOXIXo
        public final WorkSpec getWorkSpec$work_runtime_release() {
            return this.workSpec;
        }

        @OOXIXo
        public final Class<? extends ListenableWorker> getWorkerClass$work_runtime_release() {
            return this.workerClass;
        }

        @OOXIXo
        public final B keepResultsForAtLeast(long j, @OOXIXo TimeUnit timeUnit) {
            IIX0o.x0xO0oo(timeUnit, "timeUnit");
            this.workSpec.minimumRetentionDuration = timeUnit.toMillis(j);
            return getThisObject$work_runtime_release();
        }

        @OOXIXo
        public final B setBackoffCriteria(@OOXIXo BackoffPolicy backoffPolicy, long j, @OOXIXo TimeUnit timeUnit) {
            IIX0o.x0xO0oo(backoffPolicy, "backoffPolicy");
            IIX0o.x0xO0oo(timeUnit, "timeUnit");
            this.backoffCriteriaSet = true;
            WorkSpec workSpec2 = this.workSpec;
            workSpec2.backoffPolicy = backoffPolicy;
            workSpec2.setBackoffDelayDuration(timeUnit.toMillis(j));
            return getThisObject$work_runtime_release();
        }

        public final void setBackoffCriteriaSet$work_runtime_release(boolean z) {
            this.backoffCriteriaSet = z;
        }

        @OOXIXo
        public final B setConstraints(@OOXIXo Constraints constraints) {
            IIX0o.x0xO0oo(constraints, "constraints");
            this.workSpec.constraints = constraints;
            return getThisObject$work_runtime_release();
        }

        @SuppressLint({"MissingGetterMatchingBuilder"})
        @OOXIXo
        public B setExpedited(@OOXIXo OutOfQuotaPolicy outOfQuotaPolicy) {
            IIX0o.x0xO0oo(outOfQuotaPolicy, "policy");
            WorkSpec workSpec2 = this.workSpec;
            workSpec2.expedited = true;
            workSpec2.outOfQuotaPolicy = outOfQuotaPolicy;
            return getThisObject$work_runtime_release();
        }

        @OOXIXo
        public final B setId(@OOXIXo UUID uuid) {
            IIX0o.x0xO0oo(uuid, "id");
            this.id = uuid;
            String uuid2 = uuid.toString();
            IIX0o.oO(uuid2, "id.toString()");
            this.workSpec = new WorkSpec(uuid2, this.workSpec);
            return getThisObject$work_runtime_release();
        }

        public final void setId$work_runtime_release(@OOXIXo UUID uuid) {
            IIX0o.x0xO0oo(uuid, "<set-?>");
            this.id = uuid;
        }

        @OOXIXo
        public B setInitialDelay(long j, @OOXIXo TimeUnit timeUnit) {
            IIX0o.x0xO0oo(timeUnit, "timeUnit");
            this.workSpec.initialDelay = timeUnit.toMillis(j);
            if (Long.MAX_VALUE - System.currentTimeMillis() > this.workSpec.initialDelay) {
                return getThisObject$work_runtime_release();
            }
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!");
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        @OOXIXo
        public final B setInitialRunAttemptCount(int i) {
            this.workSpec.runAttemptCount = i;
            return getThisObject$work_runtime_release();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        @OOXIXo
        public final B setInitialState(@OOXIXo WorkInfo.State state) {
            IIX0o.x0xO0oo(state, "state");
            this.workSpec.state = state;
            return getThisObject$work_runtime_release();
        }

        @OOXIXo
        public final B setInputData(@OOXIXo Data data) {
            IIX0o.x0xO0oo(data, "inputData");
            this.workSpec.input = data;
            return getThisObject$work_runtime_release();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        @OOXIXo
        public final B setLastEnqueueTime(long j, @OOXIXo TimeUnit timeUnit) {
            IIX0o.x0xO0oo(timeUnit, "timeUnit");
            this.workSpec.lastEnqueueTime = timeUnit.toMillis(j);
            return getThisObject$work_runtime_release();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        @OOXIXo
        public final B setScheduleRequestedAt(long j, @OOXIXo TimeUnit timeUnit) {
            IIX0o.x0xO0oo(timeUnit, "timeUnit");
            this.workSpec.scheduleRequestedAt = timeUnit.toMillis(j);
            return getThisObject$work_runtime_release();
        }

        @OOXIXo
        public final B setTraceTag(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "traceTag");
            this.workSpec.setTraceTag(str);
            return getThisObject$work_runtime_release();
        }

        public final void setWorkSpec$work_runtime_release(@OOXIXo WorkSpec workSpec2) {
            IIX0o.x0xO0oo(workSpec2, "<set-?>");
            this.workSpec = workSpec2;
        }

        @RequiresApi(26)
        @OOXIXo
        public final B keepResultsForAtLeast(@OOXIXo Duration duration) {
            IIX0o.x0xO0oo(duration, "duration");
            this.workSpec.minimumRetentionDuration = DurationApi26Impl.toMillisCompat(duration);
            return getThisObject$work_runtime_release();
        }

        @RequiresApi(26)
        @OOXIXo
        public final B setBackoffCriteria(@OOXIXo BackoffPolicy backoffPolicy, @OOXIXo Duration duration) {
            IIX0o.x0xO0oo(backoffPolicy, "backoffPolicy");
            IIX0o.x0xO0oo(duration, "duration");
            this.backoffCriteriaSet = true;
            WorkSpec workSpec2 = this.workSpec;
            workSpec2.backoffPolicy = backoffPolicy;
            workSpec2.setBackoffDelayDuration(DurationApi26Impl.toMillisCompat(duration));
            return getThisObject$work_runtime_release();
        }

        @RequiresApi(26)
        @OOXIXo
        public B setInitialDelay(@OOXIXo Duration duration) {
            IIX0o.x0xO0oo(duration, "duration");
            this.workSpec.initialDelay = DurationApi26Impl.toMillisCompat(duration);
            if (Long.MAX_VALUE - System.currentTimeMillis() > this.workSpec.initialDelay) {
                return getThisObject$work_runtime_release();
            }
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!");
        }
    }
}
