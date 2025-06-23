package androidx.work;

import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.DurationApi26Impl;
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

/* loaded from: classes.dex */
public abstract class WorkRequest {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final long DEFAULT_BACKOFF_DELAY_MILLIS = 30000;

    @SuppressLint({"MinMaxConstant"})
    public static final long MAX_BACKOFF_MILLIS = 18000000;
    private static final int MAX_TRACE_SPAN_LENGTH = 127;

    @SuppressLint({"MinMaxConstant"})
    public static final long MIN_BACKOFF_MILLIS = 10000;

    @OXOo.OOXIXo
    private final UUID id;

    @OXOo.OOXIXo
    private final Set<String> tags;

    @OXOo.OOXIXo
    private final WorkSpec workSpec;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String deriveTraceTagFromClassName(String str) {
            String str2;
            List XXoO0oX2 = StringsKt__StringsKt.XXoO0oX(str, new String[]{FileUtils.FILE_EXTENSION_SEPARATOR}, false, 0, 6, null);
            if (XXoO0oX2.size() == 1) {
                str2 = (String) XXoO0oX2.get(0);
            } else {
                str2 = (String) CollectionsKt___CollectionsKt.O0O0Io00X(XXoO0oX2);
            }
            if (str2.length() > 127) {
                return StringsKt___StringsKt.oOI0IXOO(str2, 127);
            }
            return str2;
        }

        private Companion() {
        }
    }

    public WorkRequest(@OXOo.OOXIXo UUID id, @OXOo.OOXIXo WorkSpec workSpec, @OXOo.OOXIXo Set<String> tags) {
        IIX0o.x0xO0oo(id, "id");
        IIX0o.x0xO0oo(workSpec, "workSpec");
        IIX0o.x0xO0oo(tags, "tags");
        this.id = id;
        this.workSpec = workSpec;
        this.tags = tags;
    }

    @OXOo.OOXIXo
    public UUID getId() {
        return this.id;
    }

    @OXOo.OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final String getStringId() {
        String uuid = getId().toString();
        IIX0o.oO(uuid, "id.toString()");
        return uuid;
    }

    @OXOo.OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Set<String> getTags() {
        return this.tags;
    }

    @OXOo.OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final WorkSpec getWorkSpec() {
        return this.workSpec;
    }

    @XX({"SMAP\nWorkRequest.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkRequest.kt\nandroidx/work/WorkRequest$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,387:1\n1#2:388\n*E\n"})
    /* loaded from: classes.dex */
    public static abstract class Builder<B extends Builder<B, ?>, W extends WorkRequest> {
        private boolean backoffCriteriaSet;

        @OXOo.OOXIXo
        private UUID id;

        @OXOo.OOXIXo
        private final Set<String> tags;

        @OXOo.OOXIXo
        private WorkSpec workSpec;

        @OXOo.OOXIXo
        private final Class<? extends ListenableWorker> workerClass;

        public Builder(@OXOo.OOXIXo Class<? extends ListenableWorker> workerClass) {
            IIX0o.x0xO0oo(workerClass, "workerClass");
            this.workerClass = workerClass;
            UUID randomUUID = UUID.randomUUID();
            IIX0o.oO(randomUUID, "randomUUID()");
            this.id = randomUUID;
            String uuid = this.id.toString();
            IIX0o.oO(uuid, "id.toString()");
            String name = workerClass.getName();
            IIX0o.oO(name, "workerClass.name");
            this.workSpec = new WorkSpec(uuid, name);
            String name2 = workerClass.getName();
            IIX0o.oO(name2, "workerClass.name");
            this.tags = Xo0.Oo(name2);
        }

        @OXOo.OOXIXo
        public final B addTag(@OXOo.OOXIXo String tag) {
            IIX0o.x0xO0oo(tag, "tag");
            this.tags.add(tag);
            return getThisObject$work_runtime_release();
        }

        @OXOo.OOXIXo
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
            WorkSpec workSpec = this.workSpec;
            if (workSpec.expedited) {
                if (!z) {
                    if (workSpec.initialDelay > 0) {
                        throw new IllegalArgumentException("Expedited jobs cannot be delayed");
                    }
                } else {
                    throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
                }
            }
            if (workSpec.getTraceTag() == null) {
                WorkSpec workSpec2 = this.workSpec;
                workSpec2.setTraceTag(WorkRequest.Companion.deriveTraceTagFromClassName(workSpec2.workerClassName));
            }
            UUID randomUUID = UUID.randomUUID();
            IIX0o.oO(randomUUID, "randomUUID()");
            setId(randomUUID);
            return buildInternal$work_runtime_release;
        }

        @OXOo.OOXIXo
        public abstract W buildInternal$work_runtime_release();

        public final boolean getBackoffCriteriaSet$work_runtime_release() {
            return this.backoffCriteriaSet;
        }

        @OXOo.OOXIXo
        public final UUID getId$work_runtime_release() {
            return this.id;
        }

        @OXOo.OOXIXo
        public final Set<String> getTags$work_runtime_release() {
            return this.tags;
        }

        @OXOo.OOXIXo
        public abstract B getThisObject$work_runtime_release();

        @OXOo.OOXIXo
        public final WorkSpec getWorkSpec$work_runtime_release() {
            return this.workSpec;
        }

        @OXOo.OOXIXo
        public final Class<? extends ListenableWorker> getWorkerClass$work_runtime_release() {
            return this.workerClass;
        }

        @OXOo.OOXIXo
        public final B keepResultsForAtLeast(long j, @OXOo.OOXIXo TimeUnit timeUnit) {
            IIX0o.x0xO0oo(timeUnit, "timeUnit");
            this.workSpec.minimumRetentionDuration = timeUnit.toMillis(j);
            return getThisObject$work_runtime_release();
        }

        @OXOo.OOXIXo
        public final B setBackoffCriteria(@OXOo.OOXIXo BackoffPolicy backoffPolicy, long j, @OXOo.OOXIXo TimeUnit timeUnit) {
            IIX0o.x0xO0oo(backoffPolicy, "backoffPolicy");
            IIX0o.x0xO0oo(timeUnit, "timeUnit");
            this.backoffCriteriaSet = true;
            WorkSpec workSpec = this.workSpec;
            workSpec.backoffPolicy = backoffPolicy;
            workSpec.setBackoffDelayDuration(timeUnit.toMillis(j));
            return getThisObject$work_runtime_release();
        }

        public final void setBackoffCriteriaSet$work_runtime_release(boolean z) {
            this.backoffCriteriaSet = z;
        }

        @OXOo.OOXIXo
        public final B setConstraints(@OXOo.OOXIXo Constraints constraints) {
            IIX0o.x0xO0oo(constraints, "constraints");
            this.workSpec.constraints = constraints;
            return getThisObject$work_runtime_release();
        }

        @OXOo.OOXIXo
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public B setExpedited(@OXOo.OOXIXo OutOfQuotaPolicy policy) {
            IIX0o.x0xO0oo(policy, "policy");
            WorkSpec workSpec = this.workSpec;
            workSpec.expedited = true;
            workSpec.outOfQuotaPolicy = policy;
            return getThisObject$work_runtime_release();
        }

        @OXOo.OOXIXo
        public final B setId(@OXOo.OOXIXo UUID id) {
            IIX0o.x0xO0oo(id, "id");
            this.id = id;
            String uuid = id.toString();
            IIX0o.oO(uuid, "id.toString()");
            this.workSpec = new WorkSpec(uuid, this.workSpec);
            return getThisObject$work_runtime_release();
        }

        public final void setId$work_runtime_release(@OXOo.OOXIXo UUID uuid) {
            IIX0o.x0xO0oo(uuid, "<set-?>");
            this.id = uuid;
        }

        @OXOo.OOXIXo
        public B setInitialDelay(long j, @OXOo.OOXIXo TimeUnit timeUnit) {
            IIX0o.x0xO0oo(timeUnit, "timeUnit");
            this.workSpec.initialDelay = timeUnit.toMillis(j);
            if (Long.MAX_VALUE - System.currentTimeMillis() > this.workSpec.initialDelay) {
                return getThisObject$work_runtime_release();
            }
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!");
        }

        @OXOo.OOXIXo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        public final B setInitialRunAttemptCount(int i) {
            this.workSpec.runAttemptCount = i;
            return getThisObject$work_runtime_release();
        }

        @OXOo.OOXIXo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        public final B setInitialState(@OXOo.OOXIXo WorkInfo.State state) {
            IIX0o.x0xO0oo(state, "state");
            this.workSpec.state = state;
            return getThisObject$work_runtime_release();
        }

        @OXOo.OOXIXo
        public final B setInputData(@OXOo.OOXIXo Data inputData) {
            IIX0o.x0xO0oo(inputData, "inputData");
            this.workSpec.input = inputData;
            return getThisObject$work_runtime_release();
        }

        @OXOo.OOXIXo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        public final B setLastEnqueueTime(long j, @OXOo.OOXIXo TimeUnit timeUnit) {
            IIX0o.x0xO0oo(timeUnit, "timeUnit");
            this.workSpec.lastEnqueueTime = timeUnit.toMillis(j);
            return getThisObject$work_runtime_release();
        }

        @OXOo.OOXIXo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        public final B setScheduleRequestedAt(long j, @OXOo.OOXIXo TimeUnit timeUnit) {
            IIX0o.x0xO0oo(timeUnit, "timeUnit");
            this.workSpec.scheduleRequestedAt = timeUnit.toMillis(j);
            return getThisObject$work_runtime_release();
        }

        @OXOo.OOXIXo
        public final B setTraceTag(@OXOo.OOXIXo String traceTag) {
            IIX0o.x0xO0oo(traceTag, "traceTag");
            this.workSpec.setTraceTag(traceTag);
            return getThisObject$work_runtime_release();
        }

        public final void setWorkSpec$work_runtime_release(@OXOo.OOXIXo WorkSpec workSpec) {
            IIX0o.x0xO0oo(workSpec, "<set-?>");
            this.workSpec = workSpec;
        }

        @OXOo.OOXIXo
        @RequiresApi(26)
        public final B keepResultsForAtLeast(@OXOo.OOXIXo Duration duration) {
            IIX0o.x0xO0oo(duration, "duration");
            this.workSpec.minimumRetentionDuration = DurationApi26Impl.toMillisCompat(duration);
            return getThisObject$work_runtime_release();
        }

        @OXOo.OOXIXo
        @RequiresApi(26)
        public final B setBackoffCriteria(@OXOo.OOXIXo BackoffPolicy backoffPolicy, @OXOo.OOXIXo Duration duration) {
            IIX0o.x0xO0oo(backoffPolicy, "backoffPolicy");
            IIX0o.x0xO0oo(duration, "duration");
            this.backoffCriteriaSet = true;
            WorkSpec workSpec = this.workSpec;
            workSpec.backoffPolicy = backoffPolicy;
            workSpec.setBackoffDelayDuration(DurationApi26Impl.toMillisCompat(duration));
            return getThisObject$work_runtime_release();
        }

        @OXOo.OOXIXo
        @RequiresApi(26)
        public B setInitialDelay(@OXOo.OOXIXo Duration duration) {
            IIX0o.x0xO0oo(duration, "duration");
            this.workSpec.initialDelay = DurationApi26Impl.toMillisCompat(duration);
            if (Long.MAX_VALUE - System.currentTimeMillis() > this.workSpec.initialDelay) {
                return getThisObject$work_runtime_release();
            }
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!");
        }
    }
}
