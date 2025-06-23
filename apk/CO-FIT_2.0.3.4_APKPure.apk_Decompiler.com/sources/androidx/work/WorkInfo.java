package androidx.work;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import androidx.annotation.IntRange;
import androidx.annotation.RequiresApi;
import androidx.collection.oIX0oI;
import com.baidu.mobads.sdk.internal.bn;
import com.jieli.jl_filebrowse.FileBrowseManager;
import java.util.Set;
import java.util.UUID;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import okio.Utf8;

public final class WorkInfo {
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);
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
    @OOXIXo
    private final Constraints constraints;
    private final int generation;
    @OOXIXo
    private final UUID id;
    private final long initialDelayMillis;
    private final long nextScheduleTimeMillis;
    @OOXIXo
    private final Data outputData;
    @oOoXoXO
    private final PeriodicityInfo periodicityInfo;
    @OOXIXo
    private final Data progress;
    private final int runAttemptCount;
    @OOXIXo
    private final State state;
    private final int stopReason;
    @OOXIXo
    private final Set<String> tags;

    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public static final class PeriodicityInfo {
        private final long flexIntervalMillis;
        private final long repeatIntervalMillis;

        public PeriodicityInfo(long j, long j2) {
            this.repeatIntervalMillis = j;
            this.flexIntervalMillis = j2;
        }

        public boolean equals(@oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (IIX0o.Oxx0IOOO(PeriodicityInfo.class, obj.getClass())) {
                    PeriodicityInfo periodicityInfo = (PeriodicityInfo) obj;
                    if (periodicityInfo.repeatIntervalMillis == this.repeatIntervalMillis && periodicityInfo.flexIntervalMillis == this.flexIntervalMillis) {
                        return true;
                    }
                    return false;
                }
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
            return (oIX0oI.oIX0oI(this.repeatIntervalMillis) * 31) + oIX0oI.oIX0oI(this.flexIntervalMillis);
        }

        @OOXIXo
        public String toString() {
            return "PeriodicityInfo{repeatIntervalMillis=" + this.repeatIntervalMillis + ", flexIntervalMillis=" + this.flexIntervalMillis + '}';
        }
    }

    public enum State {
        ENQUEUED,
        RUNNING,
        SUCCEEDED,
        FAILED,
        BLOCKED,
        CANCELLED;

        public final boolean isFinished() {
            if (this == SUCCEEDED || this == FAILED || this == CANCELLED) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @xoIox
    public WorkInfo(@OOXIXo UUID uuid, @OOXIXo State state2, @OOXIXo Set<String> set) {
        this(uuid, state2, set, (Data) null, (Data) null, 0, 0, (Constraints) null, 0, (PeriodicityInfo) null, 0, 0, 4088, (IIXOooo) null);
        IIX0o.x0xO0oo(uuid, "id");
        IIX0o.x0xO0oo(state2, "state");
        IIX0o.x0xO0oo(set, bn.l);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!IIX0o.Oxx0IOOO(WorkInfo.class, obj.getClass())) {
            return false;
        }
        WorkInfo workInfo = (WorkInfo) obj;
        if (this.runAttemptCount == workInfo.runAttemptCount && this.generation == workInfo.generation && IIX0o.Oxx0IOOO(this.id, workInfo.id) && this.state == workInfo.state && IIX0o.Oxx0IOOO(this.outputData, workInfo.outputData) && IIX0o.Oxx0IOOO(this.constraints, workInfo.constraints) && this.initialDelayMillis == workInfo.initialDelayMillis && IIX0o.Oxx0IOOO(this.periodicityInfo, workInfo.periodicityInfo) && this.nextScheduleTimeMillis == workInfo.nextScheduleTimeMillis && this.stopReason == workInfo.stopReason && IIX0o.Oxx0IOOO(this.tags, workInfo.tags)) {
            return IIX0o.Oxx0IOOO(this.progress, workInfo.progress);
        }
        return false;
    }

    @OOXIXo
    public final Constraints getConstraints() {
        return this.constraints;
    }

    public final int getGeneration() {
        return this.generation;
    }

    @OOXIXo
    public final UUID getId() {
        return this.id;
    }

    public final long getInitialDelayMillis() {
        return this.initialDelayMillis;
    }

    public final long getNextScheduleTimeMillis() {
        return this.nextScheduleTimeMillis;
    }

    @OOXIXo
    public final Data getOutputData() {
        return this.outputData;
    }

    @oOoXoXO
    public final PeriodicityInfo getPeriodicityInfo() {
        return this.periodicityInfo;
    }

    @OOXIXo
    public final Data getProgress() {
        return this.progress;
    }

    @IntRange(from = 0)
    public final int getRunAttemptCount() {
        return this.runAttemptCount;
    }

    @OOXIXo
    public final State getState() {
        return this.state;
    }

    @RequiresApi(31)
    public final int getStopReason() {
        return this.stopReason;
    }

    @OOXIXo
    public final Set<String> getTags() {
        return this.tags;
    }

    public int hashCode() {
        int i;
        int hashCode = ((((((((((((((((this.id.hashCode() * 31) + this.state.hashCode()) * 31) + this.outputData.hashCode()) * 31) + this.tags.hashCode()) * 31) + this.progress.hashCode()) * 31) + this.runAttemptCount) * 31) + this.generation) * 31) + this.constraints.hashCode()) * 31) + oIX0oI.oIX0oI(this.initialDelayMillis)) * 31;
        PeriodicityInfo periodicityInfo2 = this.periodicityInfo;
        if (periodicityInfo2 != null) {
            i = periodicityInfo2.hashCode();
        } else {
            i = 0;
        }
        return ((((hashCode + i) * 31) + oIX0oI.oIX0oI(this.nextScheduleTimeMillis)) * 31) + this.stopReason;
    }

    @OOXIXo
    public String toString() {
        return "WorkInfo{id='" + this.id + "', state=" + this.state + ", outputData=" + this.outputData + ", tags=" + this.tags + ", progress=" + this.progress + ", runAttemptCount=" + this.runAttemptCount + ", generation=" + this.generation + ", constraints=" + this.constraints + ", initialDelayMillis=" + this.initialDelayMillis + ", periodicityInfo=" + this.periodicityInfo + ", nextScheduleTimeMillis=" + this.nextScheduleTimeMillis + "}, stopReason=" + this.stopReason;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @xoIox
    public WorkInfo(@OOXIXo UUID uuid, @OOXIXo State state2, @OOXIXo Set<String> set, @OOXIXo Data data) {
        this(uuid, state2, set, data, (Data) null, 0, 0, (Constraints) null, 0, (PeriodicityInfo) null, 0, 0, 4080, (IIXOooo) null);
        IIX0o.x0xO0oo(uuid, "id");
        IIX0o.x0xO0oo(state2, "state");
        IIX0o.x0xO0oo(set, bn.l);
        IIX0o.x0xO0oo(data, "outputData");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @xoIox
    public WorkInfo(@OOXIXo UUID uuid, @OOXIXo State state2, @OOXIXo Set<String> set, @OOXIXo Data data, @OOXIXo Data data2) {
        this(uuid, state2, set, data, data2, 0, 0, (Constraints) null, 0, (PeriodicityInfo) null, 0, 0, 4064, (IIXOooo) null);
        IIX0o.x0xO0oo(uuid, "id");
        IIX0o.x0xO0oo(state2, "state");
        IIX0o.x0xO0oo(set, bn.l);
        IIX0o.x0xO0oo(data, "outputData");
        IIX0o.x0xO0oo(data2, "progress");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @xoIox
    public WorkInfo(@OOXIXo UUID uuid, @OOXIXo State state2, @OOXIXo Set<String> set, @OOXIXo Data data, @OOXIXo Data data2, int i) {
        this(uuid, state2, set, data, data2, i, 0, (Constraints) null, 0, (PeriodicityInfo) null, 0, 0, 4032, (IIXOooo) null);
        IIX0o.x0xO0oo(uuid, "id");
        IIX0o.x0xO0oo(state2, "state");
        IIX0o.x0xO0oo(set, bn.l);
        IIX0o.x0xO0oo(data, "outputData");
        IIX0o.x0xO0oo(data2, "progress");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @xoIox
    public WorkInfo(@OOXIXo UUID uuid, @OOXIXo State state2, @OOXIXo Set<String> set, @OOXIXo Data data, @OOXIXo Data data2, int i, int i2) {
        this(uuid, state2, set, data, data2, i, i2, (Constraints) null, 0, (PeriodicityInfo) null, 0, 0, Utf8.MASK_2BYTES, (IIXOooo) null);
        IIX0o.x0xO0oo(uuid, "id");
        IIX0o.x0xO0oo(state2, "state");
        IIX0o.x0xO0oo(set, bn.l);
        IIX0o.x0xO0oo(data, "outputData");
        IIX0o.x0xO0oo(data2, "progress");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @xoIox
    public WorkInfo(@OOXIXo UUID uuid, @OOXIXo State state2, @OOXIXo Set<String> set, @OOXIXo Data data, @OOXIXo Data data2, int i, int i2, @OOXIXo Constraints constraints2) {
        this(uuid, state2, set, data, data2, i, i2, constraints2, 0, (PeriodicityInfo) null, 0, 0, 3840, (IIXOooo) null);
        IIX0o.x0xO0oo(uuid, "id");
        IIX0o.x0xO0oo(state2, "state");
        IIX0o.x0xO0oo(set, bn.l);
        IIX0o.x0xO0oo(data, "outputData");
        IIX0o.x0xO0oo(data2, "progress");
        IIX0o.x0xO0oo(constraints2, "constraints");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @xoIox
    public WorkInfo(@OOXIXo UUID uuid, @OOXIXo State state2, @OOXIXo Set<String> set, @OOXIXo Data data, @OOXIXo Data data2, int i, int i2, @OOXIXo Constraints constraints2, long j) {
        this(uuid, state2, set, data, data2, i, i2, constraints2, j, (PeriodicityInfo) null, 0, 0, 3584, (IIXOooo) null);
        IIX0o.x0xO0oo(uuid, "id");
        IIX0o.x0xO0oo(state2, "state");
        IIX0o.x0xO0oo(set, bn.l);
        IIX0o.x0xO0oo(data, "outputData");
        IIX0o.x0xO0oo(data2, "progress");
        IIX0o.x0xO0oo(constraints2, "constraints");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @xoIox
    public WorkInfo(@OOXIXo UUID uuid, @OOXIXo State state2, @OOXIXo Set<String> set, @OOXIXo Data data, @OOXIXo Data data2, int i, int i2, @OOXIXo Constraints constraints2, long j, @oOoXoXO PeriodicityInfo periodicityInfo2) {
        this(uuid, state2, set, data, data2, i, i2, constraints2, j, periodicityInfo2, 0, 0, FileBrowseManager.y, (IIXOooo) null);
        IIX0o.x0xO0oo(uuid, "id");
        IIX0o.x0xO0oo(state2, "state");
        IIX0o.x0xO0oo(set, bn.l);
        IIX0o.x0xO0oo(data, "outputData");
        IIX0o.x0xO0oo(data2, "progress");
        IIX0o.x0xO0oo(constraints2, "constraints");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @xoIox
    public WorkInfo(@OOXIXo UUID uuid, @OOXIXo State state2, @OOXIXo Set<String> set, @OOXIXo Data data, @OOXIXo Data data2, int i, int i2, @OOXIXo Constraints constraints2, long j, @oOoXoXO PeriodicityInfo periodicityInfo2, long j2) {
        this(uuid, state2, set, data, data2, i, i2, constraints2, j, periodicityInfo2, j2, 0, 2048, (IIXOooo) null);
        IIX0o.x0xO0oo(uuid, "id");
        IIX0o.x0xO0oo(state2, "state");
        IIX0o.x0xO0oo(set, bn.l);
        IIX0o.x0xO0oo(data, "outputData");
        IIX0o.x0xO0oo(data2, "progress");
        IIX0o.x0xO0oo(constraints2, "constraints");
    }

    @xoIox
    public WorkInfo(@OOXIXo UUID uuid, @OOXIXo State state2, @OOXIXo Set<String> set, @OOXIXo Data data, @OOXIXo Data data2, int i, int i2, @OOXIXo Constraints constraints2, long j, @oOoXoXO PeriodicityInfo periodicityInfo2, long j2, int i3) {
        IIX0o.x0xO0oo(uuid, "id");
        IIX0o.x0xO0oo(state2, "state");
        IIX0o.x0xO0oo(set, bn.l);
        IIX0o.x0xO0oo(data, "outputData");
        IIX0o.x0xO0oo(data2, "progress");
        IIX0o.x0xO0oo(constraints2, "constraints");
        this.id = uuid;
        this.state = state2;
        this.tags = set;
        this.outputData = data;
        this.progress = data2;
        this.runAttemptCount = i;
        this.generation = i2;
        this.constraints = constraints2;
        this.initialDelayMillis = j;
        this.periodicityInfo = periodicityInfo2;
        this.nextScheduleTimeMillis = j2;
        this.stopReason = i3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ WorkInfo(java.util.UUID r18, androidx.work.WorkInfo.State r19, java.util.Set r20, androidx.work.Data r21, androidx.work.Data r22, int r23, int r24, androidx.work.Constraints r25, long r26, androidx.work.WorkInfo.PeriodicityInfo r28, long r29, int r31, int r32, kotlin.jvm.internal.IIXOooo r33) {
        /*
            r17 = this;
            r0 = r32
            r1 = r0 & 8
            if (r1 == 0) goto L_0x000a
            androidx.work.Data r1 = androidx.work.Data.EMPTY
            r6 = r1
            goto L_0x000c
        L_0x000a:
            r6 = r21
        L_0x000c:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0014
            androidx.work.Data r1 = androidx.work.Data.EMPTY
            r7 = r1
            goto L_0x0016
        L_0x0014:
            r7 = r22
        L_0x0016:
            r1 = r0 & 32
            r2 = 0
            if (r1 == 0) goto L_0x001d
            r8 = 0
            goto L_0x001f
        L_0x001d:
            r8 = r23
        L_0x001f:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0025
            r9 = 0
            goto L_0x0027
        L_0x0025:
            r9 = r24
        L_0x0027:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x002f
            androidx.work.Constraints r1 = androidx.work.Constraints.NONE
            r10 = r1
            goto L_0x0031
        L_0x002f:
            r10 = r25
        L_0x0031:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0039
            r1 = 0
            r11 = r1
            goto L_0x003b
        L_0x0039:
            r11 = r26
        L_0x003b:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0042
            r1 = 0
            r13 = r1
            goto L_0x0044
        L_0x0042:
            r13 = r28
        L_0x0044:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x004f
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r14 = r1
            goto L_0x0051
        L_0x004f:
            r14 = r29
        L_0x0051:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x005a
            r0 = -256(0xffffffffffffff00, float:NaN)
            r16 = -256(0xffffffffffffff00, float:NaN)
            goto L_0x005c
        L_0x005a:
            r16 = r31
        L_0x005c:
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r14, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.WorkInfo.<init>(java.util.UUID, androidx.work.WorkInfo$State, java.util.Set, androidx.work.Data, androidx.work.Data, int, int, androidx.work.Constraints, long, androidx.work.WorkInfo$PeriodicityInfo, long, int, int, kotlin.jvm.internal.IIXOooo):void");
    }
}
