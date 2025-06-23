package androidx.work.impl.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.annotation.IntRange;
import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.Relation;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkRequest;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.google.android.exoplayer2.offline.DownloadService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@Entity(indices = {@Index({"schedule_requested_at"}), @Index({"last_enqueue_time"})})
@XX({"SMAP\nWorkSpec.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkSpec.kt\nandroidx/work/impl/model/WorkSpec\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,463:1\n1549#2:464\n1620#2,3:465\n*S KotlinDebug\n*F\n+ 1 WorkSpec.kt\nandroidx/work/impl/model/WorkSpec\n*L\n402#1:464\n402#1:465,3\n*E\n"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class WorkSpec {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final long SCHEDULE_NOT_REQUESTED_YET = -1;

    @OOXIXo
    private static final String TAG;

    @OOXIXo
    @XO0OX.XO
    public static final Function<List<WorkInfoPojo>, List<WorkInfo>> WORK_INFO_MAPPER;

    @XO0OX.XO
    @ColumnInfo(name = "backoff_delay_duration")
    public long backoffDelayDuration;

    @OOXIXo
    @XO0OX.XO
    @ColumnInfo(name = "backoff_policy")
    public BackoffPolicy backoffPolicy;

    @OOXIXo
    @Embedded
    @XO0OX.XO
    public Constraints constraints;

    @XO0OX.XO
    @ColumnInfo(name = "run_in_foreground")
    public boolean expedited;

    @XO0OX.XO
    @ColumnInfo(name = "flex_duration")
    public long flexDuration;

    @ColumnInfo(defaultValue = "0")
    private final int generation;

    @OOXIXo
    @XO0OX.XO
    @PrimaryKey
    @ColumnInfo(name = "id")
    public final String id;

    @XO0OX.XO
    @ColumnInfo(name = "initial_delay")
    public long initialDelay;

    @OOXIXo
    @XO0OX.XO
    @ColumnInfo(name = "input")
    public Data input;

    @OOXIXo
    @XO0OX.XO
    @ColumnInfo(name = "input_merger_class_name")
    public String inputMergerClassName;

    @XO0OX.XO
    @ColumnInfo(name = "interval_duration")
    public long intervalDuration;

    @XO0OX.XO
    @ColumnInfo(defaultValue = "-1", name = "last_enqueue_time")
    public long lastEnqueueTime;

    @XO0OX.XO
    @ColumnInfo(name = "minimum_retention_duration")
    public long minimumRetentionDuration;

    @ColumnInfo(defaultValue = "9223372036854775807", name = "next_schedule_time_override")
    private long nextScheduleTimeOverride;

    @ColumnInfo(defaultValue = "0", name = "next_schedule_time_override_generation")
    private int nextScheduleTimeOverrideGeneration;

    @OOXIXo
    @XO0OX.XO
    @ColumnInfo(name = "out_of_quota_policy")
    public OutOfQuotaPolicy outOfQuotaPolicy;

    @OOXIXo
    @XO0OX.XO
    @ColumnInfo(name = "output")
    public Data output;

    @ColumnInfo(defaultValue = "0", name = "period_count")
    private int periodCount;

    @XO0OX.XO
    @ColumnInfo(name = "run_attempt_count")
    public int runAttemptCount;

    @XO0OX.XO
    @ColumnInfo(name = "schedule_requested_at")
    public long scheduleRequestedAt;

    @OOXIXo
    @XO0OX.XO
    @ColumnInfo(name = "state")
    public WorkInfo.State state;

    @ColumnInfo(defaultValue = "-256", name = DownloadService.KEY_STOP_REASON)
    private final int stopReason;

    @oOoXoXO
    @ColumnInfo(name = "trace_tag")
    private String traceTag;

    @OOXIXo
    @XO0OX.XO
    @ColumnInfo(name = "worker_class_name")
    public String workerClassName;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        public final long calculateNextRunTime(boolean z, int i, @OOXIXo BackoffPolicy backoffPolicy, long j, long j2, int i2, boolean z2, long j3, long j4, long j5, long j6) {
            long j7;
            long scalb;
            IIX0o.x0xO0oo(backoffPolicy, "backoffPolicy");
            if (j6 != Long.MAX_VALUE && z2) {
                if (i2 == 0) {
                    return j6;
                }
                return X0.IIXOooo.IIXOooo(j6, PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS + j2);
            }
            if (z) {
                if (backoffPolicy == BackoffPolicy.LINEAR) {
                    scalb = i * j;
                } else {
                    scalb = Math.scalb((float) j, i - 1);
                }
                return j2 + X0.IIXOooo.XIxXXX0x0(scalb, WorkRequest.MAX_BACKOFF_MILLIS);
            }
            if (z2) {
                if (i2 == 0) {
                    j7 = j2 + j3;
                } else {
                    j7 = j2 + j5;
                }
                if (j4 != j5 && i2 == 0) {
                    j7 += j5 - j4;
                }
                return j7;
            }
            if (j2 == -1) {
                return Long.MAX_VALUE;
            }
            return j2 + j3;
        }

        private Companion() {
        }
    }

    /* loaded from: classes.dex */
    public static final class IdAndState {

        @OOXIXo
        @XO0OX.XO
        @ColumnInfo(name = "id")
        public String id;

        @OOXIXo
        @XO0OX.XO
        @ColumnInfo(name = "state")
        public WorkInfo.State state;

        public IdAndState(@OOXIXo String id, @OOXIXo WorkInfo.State state) {
            IIX0o.x0xO0oo(id, "id");
            IIX0o.x0xO0oo(state, "state");
            this.id = id;
            this.state = state;
        }

        public static /* synthetic */ IdAndState copy$default(IdAndState idAndState, String str, WorkInfo.State state, int i, Object obj) {
            if ((i & 1) != 0) {
                str = idAndState.id;
            }
            if ((i & 2) != 0) {
                state = idAndState.state;
            }
            return idAndState.copy(str, state);
        }

        @OOXIXo
        public final String component1() {
            return this.id;
        }

        @OOXIXo
        public final WorkInfo.State component2() {
            return this.state;
        }

        @OOXIXo
        public final IdAndState copy(@OOXIXo String id, @OOXIXo WorkInfo.State state) {
            IIX0o.x0xO0oo(id, "id");
            IIX0o.x0xO0oo(state, "state");
            return new IdAndState(id, state);
        }

        public boolean equals(@oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IdAndState)) {
                return false;
            }
            IdAndState idAndState = (IdAndState) obj;
            return IIX0o.Oxx0IOOO(this.id, idAndState.id) && this.state == idAndState.state;
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.state.hashCode();
        }

        @OOXIXo
        public String toString() {
            return "IdAndState(id=" + this.id + ", state=" + this.state + HexStringBuilder.COMMENT_END_CHAR;
        }
    }

    static {
        String tagWithPrefix = Logger.tagWithPrefix("WorkSpec");
        IIX0o.oO(tagWithPrefix, "tagWithPrefix(\"WorkSpec\")");
        TAG = tagWithPrefix;
        WORK_INFO_MAPPER = new Function() { // from class: androidx.work.impl.model.oxoX
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                List WORK_INFO_MAPPER$lambda$1;
                WORK_INFO_MAPPER$lambda$1 = WorkSpec.WORK_INFO_MAPPER$lambda$1((List) obj);
                return WORK_INFO_MAPPER$lambda$1;
            }
        };
    }

    public WorkSpec(@OOXIXo String id, @OOXIXo WorkInfo.State state, @OOXIXo String workerClassName, @OOXIXo String inputMergerClassName, @OOXIXo Data input, @OOXIXo Data output, long j, long j2, long j3, @OOXIXo Constraints constraints, @IntRange(from = 0) int i, @OOXIXo BackoffPolicy backoffPolicy, long j4, long j5, long j6, long j7, boolean z, @OOXIXo OutOfQuotaPolicy outOfQuotaPolicy, int i2, int i3, long j8, int i4, int i5, @oOoXoXO String str) {
        IIX0o.x0xO0oo(id, "id");
        IIX0o.x0xO0oo(state, "state");
        IIX0o.x0xO0oo(workerClassName, "workerClassName");
        IIX0o.x0xO0oo(inputMergerClassName, "inputMergerClassName");
        IIX0o.x0xO0oo(input, "input");
        IIX0o.x0xO0oo(output, "output");
        IIX0o.x0xO0oo(constraints, "constraints");
        IIX0o.x0xO0oo(backoffPolicy, "backoffPolicy");
        IIX0o.x0xO0oo(outOfQuotaPolicy, "outOfQuotaPolicy");
        this.id = id;
        this.state = state;
        this.workerClassName = workerClassName;
        this.inputMergerClassName = inputMergerClassName;
        this.input = input;
        this.output = output;
        this.initialDelay = j;
        this.intervalDuration = j2;
        this.flexDuration = j3;
        this.constraints = constraints;
        this.runAttemptCount = i;
        this.backoffPolicy = backoffPolicy;
        this.backoffDelayDuration = j4;
        this.lastEnqueueTime = j5;
        this.minimumRetentionDuration = j6;
        this.scheduleRequestedAt = j7;
        this.expedited = z;
        this.outOfQuotaPolicy = outOfQuotaPolicy;
        this.periodCount = i2;
        this.generation = i3;
        this.nextScheduleTimeOverride = j8;
        this.nextScheduleTimeOverrideGeneration = i4;
        this.stopReason = i5;
        this.traceTag = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List WORK_INFO_MAPPER$lambda$1(List list) {
        if (list != null) {
            List list2 = list;
            ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((WorkInfoPojo) it.next()).toWorkInfo());
            }
            return arrayList;
        }
        return null;
    }

    public static /* synthetic */ WorkSpec copy$default(WorkSpec workSpec, String str, WorkInfo.State state, String str2, String str3, Data data, Data data2, long j, long j2, long j3, Constraints constraints, int i, BackoffPolicy backoffPolicy, long j4, long j5, long j6, long j7, boolean z, OutOfQuotaPolicy outOfQuotaPolicy, int i2, int i3, long j8, int i4, int i5, String str4, int i6, Object obj) {
        String str5 = (i6 & 1) != 0 ? workSpec.id : str;
        WorkInfo.State state2 = (i6 & 2) != 0 ? workSpec.state : state;
        String str6 = (i6 & 4) != 0 ? workSpec.workerClassName : str2;
        String str7 = (i6 & 8) != 0 ? workSpec.inputMergerClassName : str3;
        Data data3 = (i6 & 16) != 0 ? workSpec.input : data;
        Data data4 = (i6 & 32) != 0 ? workSpec.output : data2;
        long j9 = (i6 & 64) != 0 ? workSpec.initialDelay : j;
        long j10 = (i6 & 128) != 0 ? workSpec.intervalDuration : j2;
        long j11 = (i6 & 256) != 0 ? workSpec.flexDuration : j3;
        Constraints constraints2 = (i6 & 512) != 0 ? workSpec.constraints : constraints;
        return workSpec.copy(str5, state2, str6, str7, data3, data4, j9, j10, j11, constraints2, (i6 & 1024) != 0 ? workSpec.runAttemptCount : i, (i6 & 2048) != 0 ? workSpec.backoffPolicy : backoffPolicy, (i6 & 4096) != 0 ? workSpec.backoffDelayDuration : j4, (i6 & 8192) != 0 ? workSpec.lastEnqueueTime : j5, (i6 & 16384) != 0 ? workSpec.minimumRetentionDuration : j6, (i6 & 32768) != 0 ? workSpec.scheduleRequestedAt : j7, (i6 & 65536) != 0 ? workSpec.expedited : z, (131072 & i6) != 0 ? workSpec.outOfQuotaPolicy : outOfQuotaPolicy, (i6 & 262144) != 0 ? workSpec.periodCount : i2, (i6 & 524288) != 0 ? workSpec.generation : i3, (i6 & 1048576) != 0 ? workSpec.nextScheduleTimeOverride : j8, (i6 & 2097152) != 0 ? workSpec.nextScheduleTimeOverrideGeneration : i4, (4194304 & i6) != 0 ? workSpec.stopReason : i5, (i6 & 8388608) != 0 ? workSpec.traceTag : str4);
    }

    public final long calculateNextRunTime() {
        return Companion.calculateNextRunTime(isBackedOff(), this.runAttemptCount, this.backoffPolicy, this.backoffDelayDuration, this.lastEnqueueTime, this.periodCount, isPeriodic(), this.initialDelay, this.flexDuration, this.intervalDuration, this.nextScheduleTimeOverride);
    }

    @OOXIXo
    public final String component1() {
        return this.id;
    }

    @OOXIXo
    public final Constraints component10() {
        return this.constraints;
    }

    public final int component11() {
        return this.runAttemptCount;
    }

    @OOXIXo
    public final BackoffPolicy component12() {
        return this.backoffPolicy;
    }

    public final long component13() {
        return this.backoffDelayDuration;
    }

    public final long component14() {
        return this.lastEnqueueTime;
    }

    public final long component15() {
        return this.minimumRetentionDuration;
    }

    public final long component16() {
        return this.scheduleRequestedAt;
    }

    public final boolean component17() {
        return this.expedited;
    }

    @OOXIXo
    public final OutOfQuotaPolicy component18() {
        return this.outOfQuotaPolicy;
    }

    public final int component19() {
        return this.periodCount;
    }

    @OOXIXo
    public final WorkInfo.State component2() {
        return this.state;
    }

    public final int component20() {
        return this.generation;
    }

    public final long component21() {
        return this.nextScheduleTimeOverride;
    }

    public final int component22() {
        return this.nextScheduleTimeOverrideGeneration;
    }

    public final int component23() {
        return this.stopReason;
    }

    @oOoXoXO
    public final String component24() {
        return this.traceTag;
    }

    @OOXIXo
    public final String component3() {
        return this.workerClassName;
    }

    @OOXIXo
    public final String component4() {
        return this.inputMergerClassName;
    }

    @OOXIXo
    public final Data component5() {
        return this.input;
    }

    @OOXIXo
    public final Data component6() {
        return this.output;
    }

    public final long component7() {
        return this.initialDelay;
    }

    public final long component8() {
        return this.intervalDuration;
    }

    public final long component9() {
        return this.flexDuration;
    }

    @OOXIXo
    public final WorkSpec copy(@OOXIXo String id, @OOXIXo WorkInfo.State state, @OOXIXo String workerClassName, @OOXIXo String inputMergerClassName, @OOXIXo Data input, @OOXIXo Data output, long j, long j2, long j3, @OOXIXo Constraints constraints, @IntRange(from = 0) int i, @OOXIXo BackoffPolicy backoffPolicy, long j4, long j5, long j6, long j7, boolean z, @OOXIXo OutOfQuotaPolicy outOfQuotaPolicy, int i2, int i3, long j8, int i4, int i5, @oOoXoXO String str) {
        IIX0o.x0xO0oo(id, "id");
        IIX0o.x0xO0oo(state, "state");
        IIX0o.x0xO0oo(workerClassName, "workerClassName");
        IIX0o.x0xO0oo(inputMergerClassName, "inputMergerClassName");
        IIX0o.x0xO0oo(input, "input");
        IIX0o.x0xO0oo(output, "output");
        IIX0o.x0xO0oo(constraints, "constraints");
        IIX0o.x0xO0oo(backoffPolicy, "backoffPolicy");
        IIX0o.x0xO0oo(outOfQuotaPolicy, "outOfQuotaPolicy");
        return new WorkSpec(id, state, workerClassName, inputMergerClassName, input, output, j, j2, j3, constraints, i, backoffPolicy, j4, j5, j6, j7, z, outOfQuotaPolicy, i2, i3, j8, i4, i5, str);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WorkSpec)) {
            return false;
        }
        WorkSpec workSpec = (WorkSpec) obj;
        return IIX0o.Oxx0IOOO(this.id, workSpec.id) && this.state == workSpec.state && IIX0o.Oxx0IOOO(this.workerClassName, workSpec.workerClassName) && IIX0o.Oxx0IOOO(this.inputMergerClassName, workSpec.inputMergerClassName) && IIX0o.Oxx0IOOO(this.input, workSpec.input) && IIX0o.Oxx0IOOO(this.output, workSpec.output) && this.initialDelay == workSpec.initialDelay && this.intervalDuration == workSpec.intervalDuration && this.flexDuration == workSpec.flexDuration && IIX0o.Oxx0IOOO(this.constraints, workSpec.constraints) && this.runAttemptCount == workSpec.runAttemptCount && this.backoffPolicy == workSpec.backoffPolicy && this.backoffDelayDuration == workSpec.backoffDelayDuration && this.lastEnqueueTime == workSpec.lastEnqueueTime && this.minimumRetentionDuration == workSpec.minimumRetentionDuration && this.scheduleRequestedAt == workSpec.scheduleRequestedAt && this.expedited == workSpec.expedited && this.outOfQuotaPolicy == workSpec.outOfQuotaPolicy && this.periodCount == workSpec.periodCount && this.generation == workSpec.generation && this.nextScheduleTimeOverride == workSpec.nextScheduleTimeOverride && this.nextScheduleTimeOverrideGeneration == workSpec.nextScheduleTimeOverrideGeneration && this.stopReason == workSpec.stopReason && IIX0o.Oxx0IOOO(this.traceTag, workSpec.traceTag);
    }

    public final int getGeneration() {
        return this.generation;
    }

    public final long getNextScheduleTimeOverride() {
        return this.nextScheduleTimeOverride;
    }

    public final int getNextScheduleTimeOverrideGeneration() {
        return this.nextScheduleTimeOverrideGeneration;
    }

    public final int getPeriodCount() {
        return this.periodCount;
    }

    public final int getStopReason() {
        return this.stopReason;
    }

    @oOoXoXO
    public final String getTraceTag() {
        return this.traceTag;
    }

    public final boolean hasConstraints() {
        return !IIX0o.Oxx0IOOO(Constraints.NONE, this.constraints);
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((((((((((((((((((((((((this.id.hashCode() * 31) + this.state.hashCode()) * 31) + this.workerClassName.hashCode()) * 31) + this.inputMergerClassName.hashCode()) * 31) + this.input.hashCode()) * 31) + this.output.hashCode()) * 31) + androidx.collection.oIX0oI.oIX0oI(this.initialDelay)) * 31) + androidx.collection.oIX0oI.oIX0oI(this.intervalDuration)) * 31) + androidx.collection.oIX0oI.oIX0oI(this.flexDuration)) * 31) + this.constraints.hashCode()) * 31) + this.runAttemptCount) * 31) + this.backoffPolicy.hashCode()) * 31) + androidx.collection.oIX0oI.oIX0oI(this.backoffDelayDuration)) * 31) + androidx.collection.oIX0oI.oIX0oI(this.lastEnqueueTime)) * 31) + androidx.collection.oIX0oI.oIX0oI(this.minimumRetentionDuration)) * 31) + androidx.collection.oIX0oI.oIX0oI(this.scheduleRequestedAt)) * 31) + androidx.work.oIX0oI.oIX0oI(this.expedited)) * 31) + this.outOfQuotaPolicy.hashCode()) * 31) + this.periodCount) * 31) + this.generation) * 31) + androidx.collection.oIX0oI.oIX0oI(this.nextScheduleTimeOverride)) * 31) + this.nextScheduleTimeOverrideGeneration) * 31) + this.stopReason) * 31;
        String str = this.traceTag;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final boolean isBackedOff() {
        if (this.state == WorkInfo.State.ENQUEUED && this.runAttemptCount > 0) {
            return true;
        }
        return false;
    }

    public final boolean isPeriodic() {
        if (this.intervalDuration != 0) {
            return true;
        }
        return false;
    }

    public final void setBackoffDelayDuration(long j) {
        if (j > WorkRequest.MAX_BACKOFF_MILLIS) {
            Logger.get().warning(TAG, "Backoff delay duration exceeds maximum value");
        }
        if (j < 10000) {
            Logger.get().warning(TAG, "Backoff delay duration less than minimum value");
        }
        this.backoffDelayDuration = X0.IIXOooo.oo(j, 10000L, WorkRequest.MAX_BACKOFF_MILLIS);
    }

    public final void setNextScheduleTimeOverride(long j) {
        this.nextScheduleTimeOverride = j;
    }

    public final void setNextScheduleTimeOverrideGeneration(int i) {
        this.nextScheduleTimeOverrideGeneration = i;
    }

    public final void setPeriodCount(int i) {
        this.periodCount = i;
    }

    public final void setPeriodic(long j) {
        if (j < PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS) {
            Logger.get().warning(TAG, "Interval duration lesser than minimum allowed value; Changed to 900000");
        }
        setPeriodic(X0.IIXOooo.IIXOooo(j, PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS), X0.IIXOooo.IIXOooo(j, PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS));
    }

    public final void setTraceTag(@oOoXoXO String str) {
        this.traceTag = str;
    }

    @OOXIXo
    public String toString() {
        return "{WorkSpec: " + this.id + '}';
    }

    public final void setPeriodic(long j, long j2) {
        if (j < PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS) {
            Logger.get().warning(TAG, "Interval duration lesser than minimum allowed value; Changed to 900000");
        }
        this.intervalDuration = X0.IIXOooo.IIXOooo(j, PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS);
        if (j2 < 300000) {
            Logger.get().warning(TAG, "Flex duration lesser than minimum allowed value; Changed to 300000");
        }
        if (j2 > this.intervalDuration) {
            Logger.get().warning(TAG, "Flex duration greater than interval duration; Changed to " + j);
        }
        this.flexDuration = X0.IIXOooo.oo(j2, 300000L, this.intervalDuration);
    }

    /* loaded from: classes.dex */
    public static final class WorkInfoPojo {

        @ColumnInfo(name = "backoff_delay_duration")
        private long backoffDelayDuration;

        @OOXIXo
        @ColumnInfo(name = "backoff_policy")
        private BackoffPolicy backoffPolicy;

        @OOXIXo
        @Embedded
        private final Constraints constraints;

        @ColumnInfo(name = "flex_duration")
        private final long flexDuration;

        @ColumnInfo(name = "generation")
        private final int generation;

        @OOXIXo
        @ColumnInfo(name = "id")
        private final String id;

        @ColumnInfo(name = "initial_delay")
        private final long initialDelay;

        @ColumnInfo(name = "interval_duration")
        private final long intervalDuration;

        @ColumnInfo(name = "last_enqueue_time")
        private long lastEnqueueTime;

        @ColumnInfo(name = "next_schedule_time_override")
        private final long nextScheduleTimeOverride;

        @OOXIXo
        @ColumnInfo(name = "output")
        private final Data output;

        @ColumnInfo(defaultValue = "0", name = "period_count")
        private int periodCount;

        @Relation(entity = WorkProgress.class, entityColumn = "work_spec_id", parentColumn = "id", projection = {"progress"})
        @OOXIXo
        private final List<Data> progress;

        @ColumnInfo(name = "run_attempt_count")
        private final int runAttemptCount;

        @OOXIXo
        @ColumnInfo(name = "state")
        private final WorkInfo.State state;

        @ColumnInfo(name = DownloadService.KEY_STOP_REASON)
        private final int stopReason;

        @Relation(entity = WorkTag.class, entityColumn = "work_spec_id", parentColumn = "id", projection = {"tag"})
        @OOXIXo
        private final List<String> tags;

        public WorkInfoPojo(@OOXIXo String id, @OOXIXo WorkInfo.State state, @OOXIXo Data output, long j, long j2, long j3, @OOXIXo Constraints constraints, int i, @OOXIXo BackoffPolicy backoffPolicy, long j4, long j5, int i2, int i3, long j6, int i4, @OOXIXo List<String> tags, @OOXIXo List<Data> progress) {
            IIX0o.x0xO0oo(id, "id");
            IIX0o.x0xO0oo(state, "state");
            IIX0o.x0xO0oo(output, "output");
            IIX0o.x0xO0oo(constraints, "constraints");
            IIX0o.x0xO0oo(backoffPolicy, "backoffPolicy");
            IIX0o.x0xO0oo(tags, "tags");
            IIX0o.x0xO0oo(progress, "progress");
            this.id = id;
            this.state = state;
            this.output = output;
            this.initialDelay = j;
            this.intervalDuration = j2;
            this.flexDuration = j3;
            this.constraints = constraints;
            this.runAttemptCount = i;
            this.backoffPolicy = backoffPolicy;
            this.backoffDelayDuration = j4;
            this.lastEnqueueTime = j5;
            this.periodCount = i2;
            this.generation = i3;
            this.nextScheduleTimeOverride = j6;
            this.stopReason = i4;
            this.tags = tags;
            this.progress = progress;
        }

        private final long calculateNextRunTimeMillis() {
            if (this.state == WorkInfo.State.ENQUEUED) {
                return WorkSpec.Companion.calculateNextRunTime(isBackedOff(), this.runAttemptCount, this.backoffPolicy, this.backoffDelayDuration, this.lastEnqueueTime, this.periodCount, isPeriodic(), this.initialDelay, this.flexDuration, this.intervalDuration, this.nextScheduleTimeOverride);
            }
            return Long.MAX_VALUE;
        }

        private final WorkInfo.PeriodicityInfo getPeriodicityOrNull() {
            long j = this.intervalDuration;
            if (j != 0) {
                return new WorkInfo.PeriodicityInfo(j, this.flexDuration);
            }
            return null;
        }

        @OOXIXo
        public final String component1() {
            return this.id;
        }

        public final long component10() {
            return this.backoffDelayDuration;
        }

        public final long component11() {
            return this.lastEnqueueTime;
        }

        public final int component12() {
            return this.periodCount;
        }

        public final int component13() {
            return this.generation;
        }

        public final long component14() {
            return this.nextScheduleTimeOverride;
        }

        public final int component15() {
            return this.stopReason;
        }

        @OOXIXo
        public final List<String> component16() {
            return this.tags;
        }

        @OOXIXo
        public final List<Data> component17() {
            return this.progress;
        }

        @OOXIXo
        public final WorkInfo.State component2() {
            return this.state;
        }

        @OOXIXo
        public final Data component3() {
            return this.output;
        }

        public final long component4() {
            return this.initialDelay;
        }

        public final long component5() {
            return this.intervalDuration;
        }

        public final long component6() {
            return this.flexDuration;
        }

        @OOXIXo
        public final Constraints component7() {
            return this.constraints;
        }

        public final int component8() {
            return this.runAttemptCount;
        }

        @OOXIXo
        public final BackoffPolicy component9() {
            return this.backoffPolicy;
        }

        @OOXIXo
        public final WorkInfoPojo copy(@OOXIXo String id, @OOXIXo WorkInfo.State state, @OOXIXo Data output, long j, long j2, long j3, @OOXIXo Constraints constraints, int i, @OOXIXo BackoffPolicy backoffPolicy, long j4, long j5, int i2, int i3, long j6, int i4, @OOXIXo List<String> tags, @OOXIXo List<Data> progress) {
            IIX0o.x0xO0oo(id, "id");
            IIX0o.x0xO0oo(state, "state");
            IIX0o.x0xO0oo(output, "output");
            IIX0o.x0xO0oo(constraints, "constraints");
            IIX0o.x0xO0oo(backoffPolicy, "backoffPolicy");
            IIX0o.x0xO0oo(tags, "tags");
            IIX0o.x0xO0oo(progress, "progress");
            return new WorkInfoPojo(id, state, output, j, j2, j3, constraints, i, backoffPolicy, j4, j5, i2, i3, j6, i4, tags, progress);
        }

        public boolean equals(@oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WorkInfoPojo)) {
                return false;
            }
            WorkInfoPojo workInfoPojo = (WorkInfoPojo) obj;
            return IIX0o.Oxx0IOOO(this.id, workInfoPojo.id) && this.state == workInfoPojo.state && IIX0o.Oxx0IOOO(this.output, workInfoPojo.output) && this.initialDelay == workInfoPojo.initialDelay && this.intervalDuration == workInfoPojo.intervalDuration && this.flexDuration == workInfoPojo.flexDuration && IIX0o.Oxx0IOOO(this.constraints, workInfoPojo.constraints) && this.runAttemptCount == workInfoPojo.runAttemptCount && this.backoffPolicy == workInfoPojo.backoffPolicy && this.backoffDelayDuration == workInfoPojo.backoffDelayDuration && this.lastEnqueueTime == workInfoPojo.lastEnqueueTime && this.periodCount == workInfoPojo.periodCount && this.generation == workInfoPojo.generation && this.nextScheduleTimeOverride == workInfoPojo.nextScheduleTimeOverride && this.stopReason == workInfoPojo.stopReason && IIX0o.Oxx0IOOO(this.tags, workInfoPojo.tags) && IIX0o.Oxx0IOOO(this.progress, workInfoPojo.progress);
        }

        public final long getBackoffDelayDuration() {
            return this.backoffDelayDuration;
        }

        @OOXIXo
        public final BackoffPolicy getBackoffPolicy() {
            return this.backoffPolicy;
        }

        @OOXIXo
        public final Constraints getConstraints() {
            return this.constraints;
        }

        public final long getFlexDuration() {
            return this.flexDuration;
        }

        public final int getGeneration() {
            return this.generation;
        }

        @OOXIXo
        public final String getId() {
            return this.id;
        }

        public final long getInitialDelay() {
            return this.initialDelay;
        }

        public final long getIntervalDuration() {
            return this.intervalDuration;
        }

        public final long getLastEnqueueTime() {
            return this.lastEnqueueTime;
        }

        public final long getNextScheduleTimeOverride() {
            return this.nextScheduleTimeOverride;
        }

        @OOXIXo
        public final Data getOutput() {
            return this.output;
        }

        public final int getPeriodCount() {
            return this.periodCount;
        }

        @OOXIXo
        public final List<Data> getProgress() {
            return this.progress;
        }

        public final int getRunAttemptCount() {
            return this.runAttemptCount;
        }

        @OOXIXo
        public final WorkInfo.State getState() {
            return this.state;
        }

        public final int getStopReason() {
            return this.stopReason;
        }

        @OOXIXo
        public final List<String> getTags() {
            return this.tags;
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((((((this.id.hashCode() * 31) + this.state.hashCode()) * 31) + this.output.hashCode()) * 31) + androidx.collection.oIX0oI.oIX0oI(this.initialDelay)) * 31) + androidx.collection.oIX0oI.oIX0oI(this.intervalDuration)) * 31) + androidx.collection.oIX0oI.oIX0oI(this.flexDuration)) * 31) + this.constraints.hashCode()) * 31) + this.runAttemptCount) * 31) + this.backoffPolicy.hashCode()) * 31) + androidx.collection.oIX0oI.oIX0oI(this.backoffDelayDuration)) * 31) + androidx.collection.oIX0oI.oIX0oI(this.lastEnqueueTime)) * 31) + this.periodCount) * 31) + this.generation) * 31) + androidx.collection.oIX0oI.oIX0oI(this.nextScheduleTimeOverride)) * 31) + this.stopReason) * 31) + this.tags.hashCode()) * 31) + this.progress.hashCode();
        }

        public final boolean isBackedOff() {
            if (this.state == WorkInfo.State.ENQUEUED && this.runAttemptCount > 0) {
                return true;
            }
            return false;
        }

        public final boolean isPeriodic() {
            if (this.intervalDuration != 0) {
                return true;
            }
            return false;
        }

        public final void setBackoffDelayDuration(long j) {
            this.backoffDelayDuration = j;
        }

        public final void setBackoffPolicy(@OOXIXo BackoffPolicy backoffPolicy) {
            IIX0o.x0xO0oo(backoffPolicy, "<set-?>");
            this.backoffPolicy = backoffPolicy;
        }

        public final void setLastEnqueueTime(long j) {
            this.lastEnqueueTime = j;
        }

        public final void setPeriodCount(int i) {
            this.periodCount = i;
        }

        @OOXIXo
        public String toString() {
            return "WorkInfoPojo(id=" + this.id + ", state=" + this.state + ", output=" + this.output + ", initialDelay=" + this.initialDelay + ", intervalDuration=" + this.intervalDuration + ", flexDuration=" + this.flexDuration + ", constraints=" + this.constraints + ", runAttemptCount=" + this.runAttemptCount + ", backoffPolicy=" + this.backoffPolicy + ", backoffDelayDuration=" + this.backoffDelayDuration + ", lastEnqueueTime=" + this.lastEnqueueTime + ", periodCount=" + this.periodCount + ", generation=" + this.generation + ", nextScheduleTimeOverride=" + this.nextScheduleTimeOverride + ", stopReason=" + this.stopReason + ", tags=" + this.tags + ", progress=" + this.progress + HexStringBuilder.COMMENT_END_CHAR;
        }

        @OOXIXo
        public final WorkInfo toWorkInfo() {
            Data data;
            if (!this.progress.isEmpty()) {
                data = this.progress.get(0);
            } else {
                data = Data.EMPTY;
            }
            Data data2 = data;
            UUID fromString = UUID.fromString(this.id);
            IIX0o.oO(fromString, "fromString(id)");
            return new WorkInfo(fromString, this.state, new HashSet(this.tags), this.output, data2, this.runAttemptCount, this.generation, this.constraints, this.initialDelay, getPeriodicityOrNull(), calculateNextRunTimeMillis(), this.stopReason);
        }

        public /* synthetic */ WorkInfoPojo(String str, WorkInfo.State state, Data data, long j, long j2, long j3, Constraints constraints, int i, BackoffPolicy backoffPolicy, long j4, long j5, int i2, int i3, long j6, int i4, List list, List list2, int i5, IIXOooo iIXOooo) {
            this(str, state, data, (i5 & 8) != 0 ? 0L : j, (i5 & 16) != 0 ? 0L : j2, (i5 & 32) != 0 ? 0L : j3, constraints, i, (i5 & 256) != 0 ? BackoffPolicy.EXPONENTIAL : backoffPolicy, (i5 & 512) != 0 ? 30000L : j4, (i5 & 1024) != 0 ? 0L : j5, (i5 & 2048) != 0 ? 0 : i2, i3, j6, i4, list, list2);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ WorkSpec(java.lang.String r36, androidx.work.WorkInfo.State r37, java.lang.String r38, java.lang.String r39, androidx.work.Data r40, androidx.work.Data r41, long r42, long r44, long r46, androidx.work.Constraints r48, int r49, androidx.work.BackoffPolicy r50, long r51, long r53, long r55, long r57, boolean r59, androidx.work.OutOfQuotaPolicy r60, int r61, int r62, long r63, int r65, int r66, java.lang.String r67, int r68, kotlin.jvm.internal.IIXOooo r69) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkSpec.<init>(java.lang.String, androidx.work.WorkInfo$State, java.lang.String, java.lang.String, androidx.work.Data, androidx.work.Data, long, long, long, androidx.work.Constraints, int, androidx.work.BackoffPolicy, long, long, long, long, boolean, androidx.work.OutOfQuotaPolicy, int, int, long, int, int, java.lang.String, int, kotlin.jvm.internal.IIXOooo):void");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WorkSpec(@OOXIXo String id, @OOXIXo String workerClassName_) {
        this(id, null, workerClassName_, null, null, null, 0L, 0L, 0L, null, 0, null, 0L, 0L, 0L, 0L, false, null, 0, 0, 0L, 0, 0, null, 16777210, null);
        IIX0o.x0xO0oo(id, "id");
        IIX0o.x0xO0oo(workerClassName_, "workerClassName_");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WorkSpec(@OOXIXo String newId, @OOXIXo WorkSpec other) {
        this(newId, other.state, other.workerClassName, other.inputMergerClassName, new Data(other.input), new Data(other.output), other.initialDelay, other.intervalDuration, other.flexDuration, new Constraints(other.constraints), other.runAttemptCount, other.backoffPolicy, other.backoffDelayDuration, other.lastEnqueueTime, other.minimumRetentionDuration, other.scheduleRequestedAt, other.expedited, other.outOfQuotaPolicy, other.periodCount, 0, other.nextScheduleTimeOverride, other.nextScheduleTimeOverrideGeneration, other.stopReason, other.traceTag, 524288, null);
        IIX0o.x0xO0oo(newId, "newId");
        IIX0o.x0xO0oo(other, "other");
    }
}
