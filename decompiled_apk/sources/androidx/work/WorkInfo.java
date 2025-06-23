package androidx.work;

import androidx.annotation.IntRange;
import androidx.annotation.RequiresApi;
import com.jieli.jl_filebrowse.FileBrowseManager;
import java.util.Set;
import java.util.UUID;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import okio.Utf8;

/* loaded from: classes.dex */
public final class WorkInfo {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int STOP_REASON_APP_STANDBY = 12;
    public static final int STOP_REASON_BACKGROUND_RESTRICTION = 11;
    public static final int STOP_REASON_CANCELLED_BY_APP = 1;
    public static final int STOP_REASON_CONSTRAINT_BATTERY_NOT_LOW = 5;
    public static final int STOP_REASON_CONSTRAINT_CHARGING = 6;
    public static final int STOP_REASON_CONSTRAINT_CONNECTIVITY = 7;
    public static final int STOP_REASON_CONSTRAINT_DEVICE_IDLE = 8;
    public static final int STOP_REASON_CONSTRAINT_STORAGE_NOT_LOW = 9;
    public static final int STOP_REASON_DEVICE_STATE = 4;
    public static final int STOP_REASON_ESTIMATED_APP_LAUNCH_TIME_CHANGED = 15;
    public static final int STOP_REASON_FOREGROUND_SERVICE_TIMEOUT = -128;
    public static final int STOP_REASON_NOT_STOPPED = -256;
    public static final int STOP_REASON_PREEMPT = 2;
    public static final int STOP_REASON_QUOTA = 10;
    public static final int STOP_REASON_SYSTEM_PROCESSING = 14;
    public static final int STOP_REASON_TIMEOUT = 3;
    public static final int STOP_REASON_UNKNOWN = -512;
    public static final int STOP_REASON_USER = 13;

    @OXOo.OOXIXo
    private final Constraints constraints;
    private final int generation;

    @OXOo.OOXIXo
    private final UUID id;
    private final long initialDelayMillis;
    private final long nextScheduleTimeMillis;

    @OXOo.OOXIXo
    private final Data outputData;

    @OXOo.oOoXoXO
    private final PeriodicityInfo periodicityInfo;

    @OXOo.OOXIXo
    private final Data progress;
    private final int runAttemptCount;

    @OXOo.OOXIXo
    private final State state;
    private final int stopReason;

    @OXOo.OOXIXo
    private final Set<String> tags;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* loaded from: classes.dex */
    public static final class PeriodicityInfo {
        private final long flexIntervalMillis;
        private final long repeatIntervalMillis;

        public PeriodicityInfo(long j, long j2) {
            this.repeatIntervalMillis = j;
            this.flexIntervalMillis = j2;
        }

        public boolean equals(@OXOo.oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !IIX0o.Oxx0IOOO(PeriodicityInfo.class, obj.getClass())) {
                return false;
            }
            PeriodicityInfo periodicityInfo = (PeriodicityInfo) obj;
            if (periodicityInfo.repeatIntervalMillis == this.repeatIntervalMillis && periodicityInfo.flexIntervalMillis == this.flexIntervalMillis) {
                return true;
            }
            return false;
        }

        public final long getFlexIntervalMillis() {
            return this.flexIntervalMillis;
        }

        public final long getRepeatIntervalMillis() {
            return this.repeatIntervalMillis;
        }

        public int hashCode() {
            return (androidx.collection.oIX0oI.oIX0oI(this.repeatIntervalMillis) * 31) + androidx.collection.oIX0oI.oIX0oI(this.flexIntervalMillis);
        }

        @OXOo.OOXIXo
        public String toString() {
            return "PeriodicityInfo{repeatIntervalMillis=" + this.repeatIntervalMillis + ", flexIntervalMillis=" + this.flexIntervalMillis + '}';
        }
    }

    /* loaded from: classes.dex */
    public enum State {
        ENQUEUED,
        RUNNING,
        SUCCEEDED,
        FAILED,
        BLOCKED,
        CANCELLED;

        public final boolean isFinished() {
            if (this != SUCCEEDED && this != FAILED && this != CANCELLED) {
                return false;
            }
            return true;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public WorkInfo(@OXOo.OOXIXo UUID id, @OXOo.OOXIXo State state, @OXOo.OOXIXo Set<String> tags) {
        this(id, state, tags, null, null, 0, 0, null, 0L, null, 0L, 0, 4088, null);
        IIX0o.x0xO0oo(id, "id");
        IIX0o.x0xO0oo(state, "state");
        IIX0o.x0xO0oo(tags, "tags");
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !IIX0o.Oxx0IOOO(WorkInfo.class, obj.getClass())) {
            return false;
        }
        WorkInfo workInfo = (WorkInfo) obj;
        if (this.runAttemptCount != workInfo.runAttemptCount || this.generation != workInfo.generation || !IIX0o.Oxx0IOOO(this.id, workInfo.id) || this.state != workInfo.state || !IIX0o.Oxx0IOOO(this.outputData, workInfo.outputData) || !IIX0o.Oxx0IOOO(this.constraints, workInfo.constraints) || this.initialDelayMillis != workInfo.initialDelayMillis || !IIX0o.Oxx0IOOO(this.periodicityInfo, workInfo.periodicityInfo) || this.nextScheduleTimeMillis != workInfo.nextScheduleTimeMillis || this.stopReason != workInfo.stopReason || !IIX0o.Oxx0IOOO(this.tags, workInfo.tags)) {
            return false;
        }
        return IIX0o.Oxx0IOOO(this.progress, workInfo.progress);
    }

    @OXOo.OOXIXo
    public final Constraints getConstraints() {
        return this.constraints;
    }

    public final int getGeneration() {
        return this.generation;
    }

    @OXOo.OOXIXo
    public final UUID getId() {
        return this.id;
    }

    public final long getInitialDelayMillis() {
        return this.initialDelayMillis;
    }

    public final long getNextScheduleTimeMillis() {
        return this.nextScheduleTimeMillis;
    }

    @OXOo.OOXIXo
    public final Data getOutputData() {
        return this.outputData;
    }

    @OXOo.oOoXoXO
    public final PeriodicityInfo getPeriodicityInfo() {
        return this.periodicityInfo;
    }

    @OXOo.OOXIXo
    public final Data getProgress() {
        return this.progress;
    }

    @IntRange(from = 0)
    public final int getRunAttemptCount() {
        return this.runAttemptCount;
    }

    @OXOo.OOXIXo
    public final State getState() {
        return this.state;
    }

    @RequiresApi(31)
    public final int getStopReason() {
        return this.stopReason;
    }

    @OXOo.OOXIXo
    public final Set<String> getTags() {
        return this.tags;
    }

    public int hashCode() {
        int i;
        int hashCode = ((((((((((((((((this.id.hashCode() * 31) + this.state.hashCode()) * 31) + this.outputData.hashCode()) * 31) + this.tags.hashCode()) * 31) + this.progress.hashCode()) * 31) + this.runAttemptCount) * 31) + this.generation) * 31) + this.constraints.hashCode()) * 31) + androidx.collection.oIX0oI.oIX0oI(this.initialDelayMillis)) * 31;
        PeriodicityInfo periodicityInfo = this.periodicityInfo;
        if (periodicityInfo != null) {
            i = periodicityInfo.hashCode();
        } else {
            i = 0;
        }
        return ((((hashCode + i) * 31) + androidx.collection.oIX0oI.oIX0oI(this.nextScheduleTimeMillis)) * 31) + this.stopReason;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "WorkInfo{id='" + this.id + "', state=" + this.state + ", outputData=" + this.outputData + ", tags=" + this.tags + ", progress=" + this.progress + ", runAttemptCount=" + this.runAttemptCount + ", generation=" + this.generation + ", constraints=" + this.constraints + ", initialDelayMillis=" + this.initialDelayMillis + ", periodicityInfo=" + this.periodicityInfo + ", nextScheduleTimeMillis=" + this.nextScheduleTimeMillis + "}, stopReason=" + this.stopReason;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public WorkInfo(@OXOo.OOXIXo UUID id, @OXOo.OOXIXo State state, @OXOo.OOXIXo Set<String> tags, @OXOo.OOXIXo Data outputData) {
        this(id, state, tags, outputData, null, 0, 0, null, 0L, null, 0L, 0, 4080, null);
        IIX0o.x0xO0oo(id, "id");
        IIX0o.x0xO0oo(state, "state");
        IIX0o.x0xO0oo(tags, "tags");
        IIX0o.x0xO0oo(outputData, "outputData");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public WorkInfo(@OXOo.OOXIXo UUID id, @OXOo.OOXIXo State state, @OXOo.OOXIXo Set<String> tags, @OXOo.OOXIXo Data outputData, @OXOo.OOXIXo Data progress) {
        this(id, state, tags, outputData, progress, 0, 0, null, 0L, null, 0L, 0, 4064, null);
        IIX0o.x0xO0oo(id, "id");
        IIX0o.x0xO0oo(state, "state");
        IIX0o.x0xO0oo(tags, "tags");
        IIX0o.x0xO0oo(outputData, "outputData");
        IIX0o.x0xO0oo(progress, "progress");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public WorkInfo(@OXOo.OOXIXo UUID id, @OXOo.OOXIXo State state, @OXOo.OOXIXo Set<String> tags, @OXOo.OOXIXo Data outputData, @OXOo.OOXIXo Data progress, int i) {
        this(id, state, tags, outputData, progress, i, 0, null, 0L, null, 0L, 0, 4032, null);
        IIX0o.x0xO0oo(id, "id");
        IIX0o.x0xO0oo(state, "state");
        IIX0o.x0xO0oo(tags, "tags");
        IIX0o.x0xO0oo(outputData, "outputData");
        IIX0o.x0xO0oo(progress, "progress");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public WorkInfo(@OXOo.OOXIXo UUID id, @OXOo.OOXIXo State state, @OXOo.OOXIXo Set<String> tags, @OXOo.OOXIXo Data outputData, @OXOo.OOXIXo Data progress, int i, int i2) {
        this(id, state, tags, outputData, progress, i, i2, null, 0L, null, 0L, 0, Utf8.MASK_2BYTES, null);
        IIX0o.x0xO0oo(id, "id");
        IIX0o.x0xO0oo(state, "state");
        IIX0o.x0xO0oo(tags, "tags");
        IIX0o.x0xO0oo(outputData, "outputData");
        IIX0o.x0xO0oo(progress, "progress");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public WorkInfo(@OXOo.OOXIXo UUID id, @OXOo.OOXIXo State state, @OXOo.OOXIXo Set<String> tags, @OXOo.OOXIXo Data outputData, @OXOo.OOXIXo Data progress, int i, int i2, @OXOo.OOXIXo Constraints constraints) {
        this(id, state, tags, outputData, progress, i, i2, constraints, 0L, null, 0L, 0, 3840, null);
        IIX0o.x0xO0oo(id, "id");
        IIX0o.x0xO0oo(state, "state");
        IIX0o.x0xO0oo(tags, "tags");
        IIX0o.x0xO0oo(outputData, "outputData");
        IIX0o.x0xO0oo(progress, "progress");
        IIX0o.x0xO0oo(constraints, "constraints");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public WorkInfo(@OXOo.OOXIXo UUID id, @OXOo.OOXIXo State state, @OXOo.OOXIXo Set<String> tags, @OXOo.OOXIXo Data outputData, @OXOo.OOXIXo Data progress, int i, int i2, @OXOo.OOXIXo Constraints constraints, long j) {
        this(id, state, tags, outputData, progress, i, i2, constraints, j, null, 0L, 0, 3584, null);
        IIX0o.x0xO0oo(id, "id");
        IIX0o.x0xO0oo(state, "state");
        IIX0o.x0xO0oo(tags, "tags");
        IIX0o.x0xO0oo(outputData, "outputData");
        IIX0o.x0xO0oo(progress, "progress");
        IIX0o.x0xO0oo(constraints, "constraints");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public WorkInfo(@OXOo.OOXIXo UUID id, @OXOo.OOXIXo State state, @OXOo.OOXIXo Set<String> tags, @OXOo.OOXIXo Data outputData, @OXOo.OOXIXo Data progress, int i, int i2, @OXOo.OOXIXo Constraints constraints, long j, @OXOo.oOoXoXO PeriodicityInfo periodicityInfo) {
        this(id, state, tags, outputData, progress, i, i2, constraints, j, periodicityInfo, 0L, 0, FileBrowseManager.y, null);
        IIX0o.x0xO0oo(id, "id");
        IIX0o.x0xO0oo(state, "state");
        IIX0o.x0xO0oo(tags, "tags");
        IIX0o.x0xO0oo(outputData, "outputData");
        IIX0o.x0xO0oo(progress, "progress");
        IIX0o.x0xO0oo(constraints, "constraints");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public WorkInfo(@OXOo.OOXIXo UUID id, @OXOo.OOXIXo State state, @OXOo.OOXIXo Set<String> tags, @OXOo.OOXIXo Data outputData, @OXOo.OOXIXo Data progress, int i, int i2, @OXOo.OOXIXo Constraints constraints, long j, @OXOo.oOoXoXO PeriodicityInfo periodicityInfo, long j2) {
        this(id, state, tags, outputData, progress, i, i2, constraints, j, periodicityInfo, j2, 0, 2048, null);
        IIX0o.x0xO0oo(id, "id");
        IIX0o.x0xO0oo(state, "state");
        IIX0o.x0xO0oo(tags, "tags");
        IIX0o.x0xO0oo(outputData, "outputData");
        IIX0o.x0xO0oo(progress, "progress");
        IIX0o.x0xO0oo(constraints, "constraints");
    }

    @XO0OX.xoIox
    public WorkInfo(@OXOo.OOXIXo UUID id, @OXOo.OOXIXo State state, @OXOo.OOXIXo Set<String> tags, @OXOo.OOXIXo Data outputData, @OXOo.OOXIXo Data progress, int i, int i2, @OXOo.OOXIXo Constraints constraints, long j, @OXOo.oOoXoXO PeriodicityInfo periodicityInfo, long j2, int i3) {
        IIX0o.x0xO0oo(id, "id");
        IIX0o.x0xO0oo(state, "state");
        IIX0o.x0xO0oo(tags, "tags");
        IIX0o.x0xO0oo(outputData, "outputData");
        IIX0o.x0xO0oo(progress, "progress");
        IIX0o.x0xO0oo(constraints, "constraints");
        this.id = id;
        this.state = state;
        this.tags = tags;
        this.outputData = outputData;
        this.progress = progress;
        this.runAttemptCount = i;
        this.generation = i2;
        this.constraints = constraints;
        this.initialDelayMillis = j;
        this.periodicityInfo = periodicityInfo;
        this.nextScheduleTimeMillis = j2;
        this.stopReason = i3;
    }

    public /* synthetic */ WorkInfo(UUID uuid, State state, Set set, Data data, Data data2, int i, int i2, Constraints constraints, long j, PeriodicityInfo periodicityInfo, long j2, int i3, int i4, IIXOooo iIXOooo) {
        this(uuid, state, set, (i4 & 8) != 0 ? Data.EMPTY : data, (i4 & 16) != 0 ? Data.EMPTY : data2, (i4 & 32) != 0 ? 0 : i, (i4 & 64) != 0 ? 0 : i2, (i4 & 128) != 0 ? Constraints.NONE : constraints, (i4 & 256) != 0 ? 0L : j, (i4 & 512) != 0 ? null : periodicityInfo, (i4 & 1024) != 0 ? Long.MAX_VALUE : j2, (i4 & 2048) != 0 ? -256 : i3);
    }
}
