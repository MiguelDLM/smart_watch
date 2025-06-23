package androidx.work.impl.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.XO;
import androidx.annotation.IntRange;
import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.collection.oIX0oI;
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
import com.baidu.mobads.sdk.internal.bn;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@XX({"SMAP\nWorkSpec.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkSpec.kt\nandroidx/work/impl/model/WorkSpec\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,463:1\n1549#2:464\n1620#2,3:465\n*S KotlinDebug\n*F\n+ 1 WorkSpec.kt\nandroidx/work/impl/model/WorkSpec\n*L\n402#1:464\n402#1:465,3\n*E\n"})
@Entity(indices = {@Index({"schedule_requested_at"}), @Index({"last_enqueue_time"})})
public final class WorkSpec {
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);
    public static final long SCHEDULE_NOT_REQUESTED_YET = -1;
    @OOXIXo
    private static final String TAG;
    @XO
    @OOXIXo
    public static final Function<List<WorkInfoPojo>, List<WorkInfo>> WORK_INFO_MAPPER = new oxoX();
    @ColumnInfo(name = "backoff_delay_duration")
    @XO
    public long backoffDelayDuration;
    @ColumnInfo(name = "backoff_policy")
    @XO
    @OOXIXo
    public BackoffPolicy backoffPolicy;
    @XO
    @OOXIXo
    @Embedded
    public Constraints constraints;
    @ColumnInfo(name = "run_in_foreground")
    @XO
    public boolean expedited;
    @ColumnInfo(name = "flex_duration")
    @XO
    public long flexDuration;
    @ColumnInfo(defaultValue = "0")
    private final int generation;
    @ColumnInfo(name = "id")
    @PrimaryKey
    @XO
    @OOXIXo
    public final String id;
    @ColumnInfo(name = "initial_delay")
    @XO
    public long initialDelay;
    @ColumnInfo(name = "input")
    @XO
    @OOXIXo
    public Data input;
    @ColumnInfo(name = "input_merger_class_name")
    @XO
    @OOXIXo
    public String inputMergerClassName;
    @ColumnInfo(name = "interval_duration")
    @XO
    public long intervalDuration;
    @ColumnInfo(defaultValue = "-1", name = "last_enqueue_time")
    @XO
    public long lastEnqueueTime;
    @ColumnInfo(name = "minimum_retention_duration")
    @XO
    public long minimumRetentionDuration;
    @ColumnInfo(defaultValue = "9223372036854775807", name = "next_schedule_time_override")
    private long nextScheduleTimeOverride;
    @ColumnInfo(defaultValue = "0", name = "next_schedule_time_override_generation")
    private int nextScheduleTimeOverrideGeneration;
    @ColumnInfo(name = "out_of_quota_policy")
    @XO
    @OOXIXo
    public OutOfQuotaPolicy outOfQuotaPolicy;
    @ColumnInfo(name = "output")
    @XO
    @OOXIXo
    public Data output;
    @ColumnInfo(defaultValue = "0", name = "period_count")
    private int periodCount;
    @ColumnInfo(name = "run_attempt_count")
    @XO
    public int runAttemptCount;
    @ColumnInfo(name = "schedule_requested_at")
    @XO
    public long scheduleRequestedAt;
    @ColumnInfo(name = "state")
    @XO
    @OOXIXo
    public WorkInfo.State state;
    @ColumnInfo(defaultValue = "-256", name = "stop_reason")
    private final int stopReason;
    @ColumnInfo(name = "trace_tag")
    @oOoXoXO
    private String traceTag;
    @ColumnInfo(name = "worker_class_name")
    @XO
    @OOXIXo
    public String workerClassName;

    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        public final long calculateNextRunTime(boolean z, int i, @OOXIXo BackoffPolicy backoffPolicy, long j, long j2, int i2, boolean z2, long j3, long j4, long j5, long j6) {
            long j7;
            long j8;
            int i3 = i;
            BackoffPolicy backoffPolicy2 = backoffPolicy;
            long j9 = j;
            long j10 = j6;
            IIX0o.x0xO0oo(backoffPolicy, "backoffPolicy");
            if (j10 == Long.MAX_VALUE || !z2) {
                if (z) {
                    if (backoffPolicy2 == BackoffPolicy.LINEAR) {
                        j8 = ((long) i3) * j9;
                    } else {
                        j8 = (long) Math.scalb((float) j9, i3 - 1);
                    }
                    return j2 + X0.IIXOooo.XIxXXX0x0(j8, WorkRequest.MAX_BACKOFF_MILLIS);
                } else if (z2) {
                    if (i2 == 0) {
                        j7 = j2 + j3;
                    } else {
                        j7 = j2 + j5;
                    }
                    if (j4 != j5 && i2 == 0) {
                        j7 += j5 - j4;
                    }
                    return j7;
                } else if (j2 == -1) {
                    return Long.MAX_VALUE;
                } else {
                    return j2 + j3;
                }
            } else if (i2 == 0) {
                return j10;
            } else {
                return X0.IIXOooo.IIXOooo(j10, PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS + j2);
            }
        }

        private Companion() {
        }
    }

    public static final class IdAndState {
        @ColumnInfo(name = "id")
        @XO
        @OOXIXo
        public String id;
        @ColumnInfo(name = "state")
        @XO
        @OOXIXo
        public WorkInfo.State state;

        public IdAndState(@OOXIXo String str, @OOXIXo WorkInfo.State state2) {
            IIX0o.x0xO0oo(str, "id");
            IIX0o.x0xO0oo(state2, "state");
            this.id = str;
            this.state = state2;
        }

        public static /* synthetic */ IdAndState copy$default(IdAndState idAndState, String str, WorkInfo.State state2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = idAndState.id;
            }
            if ((i & 2) != 0) {
                state2 = idAndState.state;
            }
            return idAndState.copy(str, state2);
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
        public final IdAndState copy(@OOXIXo String str, @OOXIXo WorkInfo.State state2) {
            IIX0o.x0xO0oo(str, "id");
            IIX0o.x0xO0oo(state2, "state");
            return new IdAndState(str, state2);
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
    }

    public WorkSpec(@OOXIXo String str, @OOXIXo WorkInfo.State state2, @OOXIXo String str2, @OOXIXo String str3, @OOXIXo Data data, @OOXIXo Data data2, long j, long j2, long j3, @OOXIXo Constraints constraints2, @IntRange(from = 0) int i, @OOXIXo BackoffPolicy backoffPolicy2, long j4, long j5, long j6, long j7, boolean z, @OOXIXo OutOfQuotaPolicy outOfQuotaPolicy2, int i2, int i3, long j8, int i4, int i5, @oOoXoXO String str4) {
        Data data3 = data;
        Data data4 = data2;
        Constraints constraints3 = constraints2;
        BackoffPolicy backoffPolicy3 = backoffPolicy2;
        OutOfQuotaPolicy outOfQuotaPolicy3 = outOfQuotaPolicy2;
        IIX0o.x0xO0oo(str, "id");
        IIX0o.x0xO0oo(state2, "state");
        IIX0o.x0xO0oo(str2, "workerClassName");
        IIX0o.x0xO0oo(str3, "inputMergerClassName");
        IIX0o.x0xO0oo(data3, "input");
        IIX0o.x0xO0oo(data4, "output");
        IIX0o.x0xO0oo(constraints3, "constraints");
        IIX0o.x0xO0oo(backoffPolicy3, "backoffPolicy");
        IIX0o.x0xO0oo(outOfQuotaPolicy3, "outOfQuotaPolicy");
        this.id = str;
        this.state = state2;
        this.workerClassName = str2;
        this.inputMergerClassName = str3;
        this.input = data3;
        this.output = data4;
        this.initialDelay = j;
        this.intervalDuration = j2;
        this.flexDuration = j3;
        this.constraints = constraints3;
        this.runAttemptCount = i;
        this.backoffPolicy = backoffPolicy3;
        this.backoffDelayDuration = j4;
        this.lastEnqueueTime = j5;
        this.minimumRetentionDuration = j6;
        this.scheduleRequestedAt = j7;
        this.expedited = z;
        this.outOfQuotaPolicy = outOfQuotaPolicy3;
        this.periodCount = i2;
        this.generation = i3;
        this.nextScheduleTimeOverride = j8;
        this.nextScheduleTimeOverrideGeneration = i4;
        this.stopReason = i5;
        this.traceTag = str4;
    }

    /* access modifiers changed from: private */
    public static final List WORK_INFO_MAPPER$lambda$1(List list) {
        if (list == null) {
            return null;
        }
        Iterable<WorkInfoPojo> iterable = list;
        ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(iterable, 10));
        for (WorkInfoPojo workInfo : iterable) {
            arrayList.add(workInfo.toWorkInfo());
        }
        return arrayList;
    }

    public static /* synthetic */ WorkSpec copy$default(WorkSpec workSpec, String str, WorkInfo.State state2, String str2, String str3, Data data, Data data2, long j, long j2, long j3, Constraints constraints2, int i, BackoffPolicy backoffPolicy2, long j4, long j5, long j6, long j7, boolean z, OutOfQuotaPolicy outOfQuotaPolicy2, int i2, int i3, long j8, int i4, int i5, String str4, int i6, Object obj) {
        WorkSpec workSpec2 = workSpec;
        int i7 = i6;
        String str5 = (i7 & 1) != 0 ? workSpec2.id : str;
        WorkInfo.State state3 = (i7 & 2) != 0 ? workSpec2.state : state2;
        String str6 = (i7 & 4) != 0 ? workSpec2.workerClassName : str2;
        String str7 = (i7 & 8) != 0 ? workSpec2.inputMergerClassName : str3;
        Data data3 = (i7 & 16) != 0 ? workSpec2.input : data;
        Data data4 = (i7 & 32) != 0 ? workSpec2.output : data2;
        long j9 = (i7 & 64) != 0 ? workSpec2.initialDelay : j;
        long j10 = (i7 & 128) != 0 ? workSpec2.intervalDuration : j2;
        long j11 = (i7 & 256) != 0 ? workSpec2.flexDuration : j3;
        Constraints constraints3 = (i7 & 512) != 0 ? workSpec2.constraints : constraints2;
        return workSpec.copy(str5, state3, str6, str7, data3, data4, j9, j10, j11, constraints3, (i7 & 1024) != 0 ? workSpec2.runAttemptCount : i, (i7 & 2048) != 0 ? workSpec2.backoffPolicy : backoffPolicy2, (i7 & 4096) != 0 ? workSpec2.backoffDelayDuration : j4, (i7 & 8192) != 0 ? workSpec2.lastEnqueueTime : j5, (i7 & 16384) != 0 ? workSpec2.minimumRetentionDuration : j6, (i7 & 32768) != 0 ? workSpec2.scheduleRequestedAt : j7, (i7 & 65536) != 0 ? workSpec2.expedited : z, (131072 & i7) != 0 ? workSpec2.outOfQuotaPolicy : outOfQuotaPolicy2, (i7 & 262144) != 0 ? workSpec2.periodCount : i2, (i7 & 524288) != 0 ? workSpec2.generation : i3, (i7 & 1048576) != 0 ? workSpec2.nextScheduleTimeOverride : j8, (i7 & 2097152) != 0 ? workSpec2.nextScheduleTimeOverrideGeneration : i4, (4194304 & i7) != 0 ? workSpec2.stopReason : i5, (i7 & 8388608) != 0 ? workSpec2.traceTag : str4);
    }

    public final long calculateNextRunTime() {
        Companion companion = Companion;
        return companion.calculateNextRunTime(isBackedOff(), this.runAttemptCount, this.backoffPolicy, this.backoffDelayDuration, this.lastEnqueueTime, this.periodCount, isPeriodic(), this.initialDelay, this.flexDuration, this.intervalDuration, this.nextScheduleTimeOverride);
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
    public final WorkSpec copy(@OOXIXo String str, @OOXIXo WorkInfo.State state2, @OOXIXo String str2, @OOXIXo String str3, @OOXIXo Data data, @OOXIXo Data data2, long j, long j2, long j3, @OOXIXo Constraints constraints2, @IntRange(from = 0) int i, @OOXIXo BackoffPolicy backoffPolicy2, long j4, long j5, long j6, long j7, boolean z, @OOXIXo OutOfQuotaPolicy outOfQuotaPolicy2, int i2, int i3, long j8, int i4, int i5, @oOoXoXO String str4) {
        String str5 = str;
        IIX0o.x0xO0oo(str5, "id");
        IIX0o.x0xO0oo(state2, "state");
        IIX0o.x0xO0oo(str2, "workerClassName");
        IIX0o.x0xO0oo(str3, "inputMergerClassName");
        IIX0o.x0xO0oo(data, "input");
        IIX0o.x0xO0oo(data2, "output");
        IIX0o.x0xO0oo(constraints2, "constraints");
        IIX0o.x0xO0oo(backoffPolicy2, "backoffPolicy");
        IIX0o.x0xO0oo(outOfQuotaPolicy2, "outOfQuotaPolicy");
        return new WorkSpec(str5, state2, str2, str3, data, data2, j, j2, j3, constraints2, i, backoffPolicy2, j4, j5, j6, j7, z, outOfQuotaPolicy2, i2, i3, j8, i4, i5, str4);
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
        int hashCode = ((((((((((((((((((((((((((((((((((((((((((((this.id.hashCode() * 31) + this.state.hashCode()) * 31) + this.workerClassName.hashCode()) * 31) + this.inputMergerClassName.hashCode()) * 31) + this.input.hashCode()) * 31) + this.output.hashCode()) * 31) + oIX0oI.oIX0oI(this.initialDelay)) * 31) + oIX0oI.oIX0oI(this.intervalDuration)) * 31) + oIX0oI.oIX0oI(this.flexDuration)) * 31) + this.constraints.hashCode()) * 31) + this.runAttemptCount) * 31) + this.backoffPolicy.hashCode()) * 31) + oIX0oI.oIX0oI(this.backoffDelayDuration)) * 31) + oIX0oI.oIX0oI(this.lastEnqueueTime)) * 31) + oIX0oI.oIX0oI(this.minimumRetentionDuration)) * 31) + oIX0oI.oIX0oI(this.scheduleRequestedAt)) * 31) + androidx.work.oIX0oI.oIX0oI(this.expedited)) * 31) + this.outOfQuotaPolicy.hashCode()) * 31) + this.periodCount) * 31) + this.generation) * 31) + oIX0oI.oIX0oI(this.nextScheduleTimeOverride)) * 31) + this.nextScheduleTimeOverrideGeneration) * 31) + this.stopReason) * 31;
        String str = this.traceTag;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final boolean isBackedOff() {
        if (this.state != WorkInfo.State.ENQUEUED || this.runAttemptCount <= 0) {
            return false;
        }
        return true;
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
        this.backoffDelayDuration = X0.IIXOooo.oo(j, 10000, WorkRequest.MAX_BACKOFF_MILLIS);
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
            Logger logger = Logger.get();
            String str = TAG;
            logger.warning(str, "Flex duration greater than interval duration; Changed to " + j);
        }
        this.flexDuration = X0.IIXOooo.oo(j2, 300000, this.intervalDuration);
    }

    public static final class WorkInfoPojo {
        @ColumnInfo(name = "backoff_delay_duration")
        private long backoffDelayDuration;
        @ColumnInfo(name = "backoff_policy")
        @OOXIXo
        private BackoffPolicy backoffPolicy;
        @OOXIXo
        @Embedded
        private final Constraints constraints;
        @ColumnInfo(name = "flex_duration")
        private final long flexDuration;
        @ColumnInfo(name = "generation")
        private final int generation;
        @ColumnInfo(name = "id")
        @OOXIXo
        private final String id;
        @ColumnInfo(name = "initial_delay")
        private final long initialDelay;
        @ColumnInfo(name = "interval_duration")
        private final long intervalDuration;
        @ColumnInfo(name = "last_enqueue_time")
        private long lastEnqueueTime;
        @ColumnInfo(name = "next_schedule_time_override")
        private final long nextScheduleTimeOverride;
        @ColumnInfo(name = "output")
        @OOXIXo
        private final Data output;
        @ColumnInfo(defaultValue = "0", name = "period_count")
        private int periodCount;
        @Relation(entity = WorkProgress.class, entityColumn = "work_spec_id", parentColumn = "id", projection = {"progress"})
        @OOXIXo
        private final List<Data> progress;
        @ColumnInfo(name = "run_attempt_count")
        private final int runAttemptCount;
        @ColumnInfo(name = "state")
        @OOXIXo
        private final WorkInfo.State state;
        @ColumnInfo(name = "stop_reason")
        private final int stopReason;
        @Relation(entity = WorkTag.class, entityColumn = "work_spec_id", parentColumn = "id", projection = {"tag"})
        @OOXIXo
        private final List<String> tags;

        public WorkInfoPojo(@OOXIXo String str, @OOXIXo WorkInfo.State state2, @OOXIXo Data data, long j, long j2, long j3, @OOXIXo Constraints constraints2, int i, @OOXIXo BackoffPolicy backoffPolicy2, long j4, long j5, int i2, int i3, long j6, int i4, @OOXIXo List<String> list, @OOXIXo List<Data> list2) {
            Constraints constraints3 = constraints2;
            BackoffPolicy backoffPolicy3 = backoffPolicy2;
            List<String> list3 = list;
            List<Data> list4 = list2;
            IIX0o.x0xO0oo(str, "id");
            IIX0o.x0xO0oo(state2, "state");
            IIX0o.x0xO0oo(data, "output");
            IIX0o.x0xO0oo(constraints3, "constraints");
            IIX0o.x0xO0oo(backoffPolicy3, "backoffPolicy");
            IIX0o.x0xO0oo(list3, bn.l);
            IIX0o.x0xO0oo(list4, "progress");
            this.id = str;
            this.state = state2;
            this.output = data;
            this.initialDelay = j;
            this.intervalDuration = j2;
            this.flexDuration = j3;
            this.constraints = constraints3;
            this.runAttemptCount = i;
            this.backoffPolicy = backoffPolicy3;
            this.backoffDelayDuration = j4;
            this.lastEnqueueTime = j5;
            this.periodCount = i2;
            this.generation = i3;
            this.nextScheduleTimeOverride = j6;
            this.stopReason = i4;
            this.tags = list3;
            this.progress = list4;
        }

        private final long calculateNextRunTimeMillis() {
            if (this.state == WorkInfo.State.ENQUEUED) {
                return WorkSpec.Companion.calculateNextRunTime(isBackedOff(), this.runAttemptCount, this.backoffPolicy, this.backoffDelayDuration, this.lastEnqueueTime, this.periodCount, isPeriodic(), this.initialDelay, this.flexDuration, this.intervalDuration, this.nextScheduleTimeOverride);
            }
            return Long.MAX_VALUE;
        }

        public static /* synthetic */ WorkInfoPojo copy$default(WorkInfoPojo workInfoPojo, String str, WorkInfo.State state2, Data data, long j, long j2, long j3, Constraints constraints2, int i, BackoffPolicy backoffPolicy2, long j4, long j5, int i2, int i3, long j6, int i4, List list, List list2, int i5, Object obj) {
            WorkInfoPojo workInfoPojo2 = workInfoPojo;
            int i6 = i5;
            return workInfoPojo.copy((i6 & 1) != 0 ? workInfoPojo2.id : str, (i6 & 2) != 0 ? workInfoPojo2.state : state2, (i6 & 4) != 0 ? workInfoPojo2.output : data, (i6 & 8) != 0 ? workInfoPojo2.initialDelay : j, (i6 & 16) != 0 ? workInfoPojo2.intervalDuration : j2, (i6 & 32) != 0 ? workInfoPojo2.flexDuration : j3, (i6 & 64) != 0 ? workInfoPojo2.constraints : constraints2, (i6 & 128) != 0 ? workInfoPojo2.runAttemptCount : i, (i6 & 256) != 0 ? workInfoPojo2.backoffPolicy : backoffPolicy2, (i6 & 512) != 0 ? workInfoPojo2.backoffDelayDuration : j4, (i6 & 1024) != 0 ? workInfoPojo2.lastEnqueueTime : j5, (i6 & 2048) != 0 ? workInfoPojo2.periodCount : i2, (i6 & 4096) != 0 ? workInfoPojo2.generation : i3, (i6 & 8192) != 0 ? workInfoPojo2.nextScheduleTimeOverride : j6, (i6 & 16384) != 0 ? workInfoPojo2.stopReason : i4, (32768 & i6) != 0 ? workInfoPojo2.tags : list, (i6 & 65536) != 0 ? workInfoPojo2.progress : list2);
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
        public final WorkInfoPojo copy(@OOXIXo String str, @OOXIXo WorkInfo.State state2, @OOXIXo Data data, long j, long j2, long j3, @OOXIXo Constraints constraints2, int i, @OOXIXo BackoffPolicy backoffPolicy2, long j4, long j5, int i2, int i3, long j6, int i4, @OOXIXo List<String> list, @OOXIXo List<Data> list2) {
            String str2 = str;
            IIX0o.x0xO0oo(str2, "id");
            IIX0o.x0xO0oo(state2, "state");
            IIX0o.x0xO0oo(data, "output");
            IIX0o.x0xO0oo(constraints2, "constraints");
            IIX0o.x0xO0oo(backoffPolicy2, "backoffPolicy");
            IIX0o.x0xO0oo(list, bn.l);
            IIX0o.x0xO0oo(list2, "progress");
            return new WorkInfoPojo(str2, state2, data, j, j2, j3, constraints2, i, backoffPolicy2, j4, j5, i2, i3, j6, i4, list, list2);
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
            return (((((((((((((((((((((((((((((((this.id.hashCode() * 31) + this.state.hashCode()) * 31) + this.output.hashCode()) * 31) + oIX0oI.oIX0oI(this.initialDelay)) * 31) + oIX0oI.oIX0oI(this.intervalDuration)) * 31) + oIX0oI.oIX0oI(this.flexDuration)) * 31) + this.constraints.hashCode()) * 31) + this.runAttemptCount) * 31) + this.backoffPolicy.hashCode()) * 31) + oIX0oI.oIX0oI(this.backoffDelayDuration)) * 31) + oIX0oI.oIX0oI(this.lastEnqueueTime)) * 31) + this.periodCount) * 31) + this.generation) * 31) + oIX0oI.oIX0oI(this.nextScheduleTimeOverride)) * 31) + this.stopReason) * 31) + this.tags.hashCode()) * 31) + this.progress.hashCode();
        }

        public final boolean isBackedOff() {
            if (this.state != WorkInfo.State.ENQUEUED || this.runAttemptCount <= 0) {
                return false;
            }
            return true;
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

        public final void setBackoffPolicy(@OOXIXo BackoffPolicy backoffPolicy2) {
            IIX0o.x0xO0oo(backoffPolicy2, "<set-?>");
            this.backoffPolicy = backoffPolicy2;
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

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ WorkInfoPojo(java.lang.String r29, androidx.work.WorkInfo.State r30, androidx.work.Data r31, long r32, long r34, long r36, androidx.work.Constraints r38, int r39, androidx.work.BackoffPolicy r40, long r41, long r43, int r45, int r46, long r47, int r49, java.util.List r50, java.util.List r51, int r52, kotlin.jvm.internal.IIXOooo r53) {
            /*
                r28 = this;
                r0 = r52
                r1 = r0 & 8
                r2 = 0
                if (r1 == 0) goto L_0x000a
                r8 = r2
                goto L_0x000c
            L_0x000a:
                r8 = r32
            L_0x000c:
                r1 = r0 & 16
                if (r1 == 0) goto L_0x0012
                r10 = r2
                goto L_0x0014
            L_0x0012:
                r10 = r34
            L_0x0014:
                r1 = r0 & 32
                if (r1 == 0) goto L_0x001a
                r12 = r2
                goto L_0x001c
            L_0x001a:
                r12 = r36
            L_0x001c:
                r1 = r0 & 256(0x100, float:3.59E-43)
                if (r1 == 0) goto L_0x0025
                androidx.work.BackoffPolicy r1 = androidx.work.BackoffPolicy.EXPONENTIAL
                r16 = r1
                goto L_0x0027
            L_0x0025:
                r16 = r40
            L_0x0027:
                r1 = r0 & 512(0x200, float:7.175E-43)
                if (r1 == 0) goto L_0x0030
                r4 = 30000(0x7530, double:1.4822E-319)
                r17 = r4
                goto L_0x0032
            L_0x0030:
                r17 = r41
            L_0x0032:
                r1 = r0 & 1024(0x400, float:1.435E-42)
                if (r1 == 0) goto L_0x0039
                r19 = r2
                goto L_0x003b
            L_0x0039:
                r19 = r43
            L_0x003b:
                r0 = r0 & 2048(0x800, float:2.87E-42)
                if (r0 == 0) goto L_0x0043
                r0 = 0
                r21 = 0
                goto L_0x0045
            L_0x0043:
                r21 = r45
            L_0x0045:
                r4 = r28
                r5 = r29
                r6 = r30
                r7 = r31
                r14 = r38
                r15 = r39
                r22 = r46
                r23 = r47
                r25 = r49
                r26 = r50
                r27 = r51
                r4.<init>(r5, r6, r7, r8, r10, r12, r14, r15, r16, r17, r19, r21, r22, r23, r25, r26, r27)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkSpec.WorkInfoPojo.<init>(java.lang.String, androidx.work.WorkInfo$State, androidx.work.Data, long, long, long, androidx.work.Constraints, int, androidx.work.BackoffPolicy, long, long, int, int, long, int, java.util.List, java.util.List, int, kotlin.jvm.internal.IIXOooo):void");
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ WorkSpec(java.lang.String r36, androidx.work.WorkInfo.State r37, java.lang.String r38, java.lang.String r39, androidx.work.Data r40, androidx.work.Data r41, long r42, long r44, long r46, androidx.work.Constraints r48, int r49, androidx.work.BackoffPolicy r50, long r51, long r53, long r55, long r57, boolean r59, androidx.work.OutOfQuotaPolicy r60, int r61, int r62, long r63, int r65, int r66, java.lang.String r67, int r68, kotlin.jvm.internal.IIXOooo r69) {
        /*
            r35 = this;
            r0 = r68
            r1 = r0 & 2
            if (r1 == 0) goto L_0x000a
            androidx.work.WorkInfo$State r1 = androidx.work.WorkInfo.State.ENQUEUED
            r4 = r1
            goto L_0x000c
        L_0x000a:
            r4 = r37
        L_0x000c:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x001d
            java.lang.Class<androidx.work.OverwritingInputMerger> r1 = androidx.work.OverwritingInputMerger.class
            java.lang.String r1 = r1.getName()
            java.lang.String r2 = "OverwritingInputMerger::class.java.name"
            kotlin.jvm.internal.IIX0o.oO(r1, r2)
            r6 = r1
            goto L_0x001f
        L_0x001d:
            r6 = r39
        L_0x001f:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0027
            androidx.work.Data r1 = androidx.work.Data.EMPTY
            r7 = r1
            goto L_0x0029
        L_0x0027:
            r7 = r40
        L_0x0029:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0031
            androidx.work.Data r1 = androidx.work.Data.EMPTY
            r8 = r1
            goto L_0x0033
        L_0x0031:
            r8 = r41
        L_0x0033:
            r1 = r0 & 64
            r2 = 0
            if (r1 == 0) goto L_0x003b
            r9 = r2
            goto L_0x003d
        L_0x003b:
            r9 = r42
        L_0x003d:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0043
            r11 = r2
            goto L_0x0045
        L_0x0043:
            r11 = r44
        L_0x0045:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x004b
            r13 = r2
            goto L_0x004d
        L_0x004b:
            r13 = r46
        L_0x004d:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0055
            androidx.work.Constraints r1 = androidx.work.Constraints.NONE
            r15 = r1
            goto L_0x0057
        L_0x0055:
            r15 = r48
        L_0x0057:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            r5 = 0
            if (r1 == 0) goto L_0x005f
            r16 = 0
            goto L_0x0061
        L_0x005f:
            r16 = r49
        L_0x0061:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x006a
            androidx.work.BackoffPolicy r1 = androidx.work.BackoffPolicy.EXPONENTIAL
            r17 = r1
            goto L_0x006c
        L_0x006a:
            r17 = r50
        L_0x006c:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0073
            r18 = 30000(0x7530, double:1.4822E-319)
            goto L_0x0075
        L_0x0073:
            r18 = r51
        L_0x0075:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            r20 = -1
            if (r1 == 0) goto L_0x007e
            r22 = r20
            goto L_0x0080
        L_0x007e:
            r22 = r53
        L_0x0080:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0087
            r24 = r2
            goto L_0x0089
        L_0x0087:
            r24 = r55
        L_0x0089:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0092
            r26 = r20
            goto L_0x0094
        L_0x0092:
            r26 = r57
        L_0x0094:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x009b
            r1 = 0
            goto L_0x009d
        L_0x009b:
            r1 = r59
        L_0x009d:
            r2 = 131072(0x20000, float:1.83671E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x00a7
            androidx.work.OutOfQuotaPolicy r2 = androidx.work.OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST
            r28 = r2
            goto L_0x00a9
        L_0x00a7:
            r28 = r60
        L_0x00a9:
            r2 = 262144(0x40000, float:3.67342E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x00b1
            r29 = 0
            goto L_0x00b3
        L_0x00b1:
            r29 = r61
        L_0x00b3:
            r2 = 524288(0x80000, float:7.34684E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x00bb
            r30 = 0
            goto L_0x00bd
        L_0x00bb:
            r30 = r62
        L_0x00bd:
            r2 = 1048576(0x100000, float:1.469368E-39)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x00ca
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r31 = r2
            goto L_0x00cc
        L_0x00ca:
            r31 = r63
        L_0x00cc:
            r2 = 2097152(0x200000, float:2.938736E-39)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x00d4
            r33 = 0
            goto L_0x00d6
        L_0x00d4:
            r33 = r65
        L_0x00d6:
            r2 = 4194304(0x400000, float:5.877472E-39)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x00e0
            r2 = -256(0xffffffffffffff00, float:NaN)
            r34 = -256(0xffffffffffffff00, float:NaN)
            goto L_0x00e2
        L_0x00e0:
            r34 = r66
        L_0x00e2:
            r2 = 8388608(0x800000, float:1.17549435E-38)
            r0 = r0 & r2
            if (r0 == 0) goto L_0x00e9
            r0 = 0
            goto L_0x00eb
        L_0x00e9:
            r0 = r67
        L_0x00eb:
            r2 = r35
            r3 = r36
            r5 = r38
            r20 = r22
            r22 = r24
            r24 = r26
            r26 = r1
            r27 = r28
            r28 = r29
            r29 = r30
            r30 = r31
            r32 = r33
            r33 = r34
            r34 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r11, r13, r15, r16, r17, r18, r20, r22, r24, r26, r27, r28, r29, r30, r32, r33, r34)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkSpec.<init>(java.lang.String, androidx.work.WorkInfo$State, java.lang.String, java.lang.String, androidx.work.Data, androidx.work.Data, long, long, long, androidx.work.Constraints, int, androidx.work.BackoffPolicy, long, long, long, long, boolean, androidx.work.OutOfQuotaPolicy, int, int, long, int, int, java.lang.String, int, kotlin.jvm.internal.IIXOooo):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WorkSpec(@OOXIXo String str, @OOXIXo String str2) {
        this(str, (WorkInfo.State) null, str2, (String) null, (Data) null, (Data) null, 0, 0, 0, (Constraints) null, 0, (BackoffPolicy) null, 0, 0, 0, 0, false, (OutOfQuotaPolicy) null, 0, 0, 0, 0, 0, (String) null, 16777210, (IIXOooo) null);
        IIX0o.x0xO0oo(str, "id");
        IIX0o.x0xO0oo(str2, "workerClassName_");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public WorkSpec(@OXOo.OOXIXo java.lang.String r39, @OXOo.OOXIXo androidx.work.impl.model.WorkSpec r40) {
        /*
            r38 = this;
            r0 = r40
            r1 = r38
            r2 = r39
            java.lang.String r3 = "newId"
            r4 = r39
            kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r3)
            java.lang.String r3 = "other"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r0, r3)
            java.lang.String r4 = r0.workerClassName
            androidx.work.WorkInfo$State r3 = r0.state
            java.lang.String r5 = r0.inputMergerClassName
            androidx.work.Data r7 = new androidx.work.Data
            r6 = r7
            androidx.work.Data r8 = r0.input
            r7.<init>((androidx.work.Data) r8)
            androidx.work.Data r8 = new androidx.work.Data
            r7 = r8
            androidx.work.Data r9 = r0.output
            r8.<init>((androidx.work.Data) r9)
            long r8 = r0.initialDelay
            long r10 = r0.intervalDuration
            long r12 = r0.flexDuration
            androidx.work.Constraints r15 = new androidx.work.Constraints
            r14 = r15
            r36 = r1
            androidx.work.Constraints r1 = r0.constraints
            r15.<init>(r1)
            int r15 = r0.runAttemptCount
            androidx.work.BackoffPolicy r1 = r0.backoffPolicy
            r16 = r1
            r37 = r2
            long r1 = r0.backoffDelayDuration
            r17 = r1
            long r1 = r0.lastEnqueueTime
            r19 = r1
            long r1 = r0.minimumRetentionDuration
            r21 = r1
            long r1 = r0.scheduleRequestedAt
            r23 = r1
            boolean r1 = r0.expedited
            r25 = r1
            androidx.work.OutOfQuotaPolicy r1 = r0.outOfQuotaPolicy
            r26 = r1
            int r1 = r0.periodCount
            r27 = r1
            long r1 = r0.nextScheduleTimeOverride
            r29 = r1
            int r1 = r0.nextScheduleTimeOverrideGeneration
            r31 = r1
            int r1 = r0.stopReason
            r32 = r1
            java.lang.String r0 = r0.traceTag
            r33 = r0
            r34 = 524288(0x80000, float:7.34684E-40)
            r35 = 0
            r28 = 0
            r1 = r36
            r2 = r37
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r10, r12, r14, r15, r16, r17, r19, r21, r23, r25, r26, r27, r28, r29, r31, r32, r33, r34, r35)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkSpec.<init>(java.lang.String, androidx.work.impl.model.WorkSpec):void");
    }
}
