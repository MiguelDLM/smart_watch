package androidx.work.impl.constraints.trackers;

import OXOo.OOXIXo;
import XO0OX.xoIox;
import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.huawei.openalliance.ad.constant.bn;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Trackers {
    @OOXIXo
    private final ConstraintTracker<Boolean> batteryChargingTracker;
    @OOXIXo
    private final BatteryNotLowTracker batteryNotLowTracker;
    @OOXIXo
    private final Context context;
    @OOXIXo
    private final ConstraintTracker<NetworkState> networkStateTracker;
    @OOXIXo
    private final ConstraintTracker<Boolean> storageNotLowTracker;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @xoIox
    public Trackers(@OOXIXo Context context2, @OOXIXo TaskExecutor taskExecutor) {
        this(context2, taskExecutor, (ConstraintTracker) null, (BatteryNotLowTracker) null, (ConstraintTracker) null, (ConstraintTracker) null, 60, (IIXOooo) null);
        IIX0o.x0xO0oo(context2, bn.f.o);
        IIX0o.x0xO0oo(taskExecutor, "taskExecutor");
    }

    @OOXIXo
    public final ConstraintTracker<Boolean> getBatteryChargingTracker() {
        return this.batteryChargingTracker;
    }

    @OOXIXo
    public final BatteryNotLowTracker getBatteryNotLowTracker() {
        return this.batteryNotLowTracker;
    }

    @OOXIXo
    public final Context getContext() {
        return this.context;
    }

    @OOXIXo
    public final ConstraintTracker<NetworkState> getNetworkStateTracker() {
        return this.networkStateTracker;
    }

    @OOXIXo
    public final ConstraintTracker<Boolean> getStorageNotLowTracker() {
        return this.storageNotLowTracker;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @xoIox
    public Trackers(@OOXIXo Context context2, @OOXIXo TaskExecutor taskExecutor, @OOXIXo ConstraintTracker<Boolean> constraintTracker) {
        this(context2, taskExecutor, constraintTracker, (BatteryNotLowTracker) null, (ConstraintTracker) null, (ConstraintTracker) null, 56, (IIXOooo) null);
        IIX0o.x0xO0oo(context2, bn.f.o);
        IIX0o.x0xO0oo(taskExecutor, "taskExecutor");
        IIX0o.x0xO0oo(constraintTracker, "batteryChargingTracker");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @xoIox
    public Trackers(@OOXIXo Context context2, @OOXIXo TaskExecutor taskExecutor, @OOXIXo ConstraintTracker<Boolean> constraintTracker, @OOXIXo BatteryNotLowTracker batteryNotLowTracker2) {
        this(context2, taskExecutor, constraintTracker, batteryNotLowTracker2, (ConstraintTracker) null, (ConstraintTracker) null, 48, (IIXOooo) null);
        IIX0o.x0xO0oo(context2, bn.f.o);
        IIX0o.x0xO0oo(taskExecutor, "taskExecutor");
        IIX0o.x0xO0oo(constraintTracker, "batteryChargingTracker");
        IIX0o.x0xO0oo(batteryNotLowTracker2, "batteryNotLowTracker");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @xoIox
    public Trackers(@OOXIXo Context context2, @OOXIXo TaskExecutor taskExecutor, @OOXIXo ConstraintTracker<Boolean> constraintTracker, @OOXIXo BatteryNotLowTracker batteryNotLowTracker2, @OOXIXo ConstraintTracker<NetworkState> constraintTracker2) {
        this(context2, taskExecutor, constraintTracker, batteryNotLowTracker2, constraintTracker2, (ConstraintTracker) null, 32, (IIXOooo) null);
        IIX0o.x0xO0oo(context2, bn.f.o);
        IIX0o.x0xO0oo(taskExecutor, "taskExecutor");
        IIX0o.x0xO0oo(constraintTracker, "batteryChargingTracker");
        IIX0o.x0xO0oo(batteryNotLowTracker2, "batteryNotLowTracker");
        IIX0o.x0xO0oo(constraintTracker2, "networkStateTracker");
    }

    @xoIox
    public Trackers(@OOXIXo Context context2, @OOXIXo TaskExecutor taskExecutor, @OOXIXo ConstraintTracker<Boolean> constraintTracker, @OOXIXo BatteryNotLowTracker batteryNotLowTracker2, @OOXIXo ConstraintTracker<NetworkState> constraintTracker2, @OOXIXo ConstraintTracker<Boolean> constraintTracker3) {
        IIX0o.x0xO0oo(context2, bn.f.o);
        IIX0o.x0xO0oo(taskExecutor, "taskExecutor");
        IIX0o.x0xO0oo(constraintTracker, "batteryChargingTracker");
        IIX0o.x0xO0oo(batteryNotLowTracker2, "batteryNotLowTracker");
        IIX0o.x0xO0oo(constraintTracker2, "networkStateTracker");
        IIX0o.x0xO0oo(constraintTracker3, "storageNotLowTracker");
        this.context = context2;
        this.batteryChargingTracker = constraintTracker;
        this.batteryNotLowTracker = batteryNotLowTracker2;
        this.networkStateTracker = constraintTracker2;
        this.storageNotLowTracker = constraintTracker3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Trackers(android.content.Context r8, androidx.work.impl.utils.taskexecutor.TaskExecutor r9, androidx.work.impl.constraints.trackers.ConstraintTracker r10, androidx.work.impl.constraints.trackers.BatteryNotLowTracker r11, androidx.work.impl.constraints.trackers.ConstraintTracker r12, androidx.work.impl.constraints.trackers.ConstraintTracker r13, int r14, kotlin.jvm.internal.IIXOooo r15) {
        /*
            r7 = this;
            r0 = r14 & 4
            java.lang.String r1 = "context.applicationContext"
            if (r0 == 0) goto L_0x0014
            androidx.work.impl.constraints.trackers.BatteryChargingTracker r0 = new androidx.work.impl.constraints.trackers.BatteryChargingTracker
            android.content.Context r3 = r8.getApplicationContext()
            kotlin.jvm.internal.IIX0o.oO(r3, r1)
            r0.<init>(r3, r9)
            r3 = r0
            goto L_0x0015
        L_0x0014:
            r3 = r10
        L_0x0015:
            r0 = r14 & 8
            if (r0 == 0) goto L_0x0027
            androidx.work.impl.constraints.trackers.BatteryNotLowTracker r0 = new androidx.work.impl.constraints.trackers.BatteryNotLowTracker
            android.content.Context r4 = r8.getApplicationContext()
            kotlin.jvm.internal.IIX0o.oO(r4, r1)
            r0.<init>(r4, r9)
            r4 = r0
            goto L_0x0028
        L_0x0027:
            r4 = r11
        L_0x0028:
            r0 = r14 & 16
            if (r0 == 0) goto L_0x0039
            android.content.Context r0 = r8.getApplicationContext()
            kotlin.jvm.internal.IIX0o.oO(r0, r1)
            androidx.work.impl.constraints.trackers.ConstraintTracker r0 = androidx.work.impl.constraints.trackers.NetworkStateTrackerKt.NetworkStateTracker(r0, r9)
            r5 = r0
            goto L_0x003a
        L_0x0039:
            r5 = r12
        L_0x003a:
            r0 = r14 & 32
            if (r0 == 0) goto L_0x004c
            androidx.work.impl.constraints.trackers.StorageNotLowTracker r0 = new androidx.work.impl.constraints.trackers.StorageNotLowTracker
            android.content.Context r6 = r8.getApplicationContext()
            kotlin.jvm.internal.IIX0o.oO(r6, r1)
            r0.<init>(r6, r9)
            r6 = r0
            goto L_0x004d
        L_0x004c:
            r6 = r13
        L_0x004d:
            r0 = r7
            r1 = r8
            r2 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.constraints.trackers.Trackers.<init>(android.content.Context, androidx.work.impl.utils.taskexecutor.TaskExecutor, androidx.work.impl.constraints.trackers.ConstraintTracker, androidx.work.impl.constraints.trackers.BatteryNotLowTracker, androidx.work.impl.constraints.trackers.ConstraintTracker, androidx.work.impl.constraints.trackers.ConstraintTracker, int, kotlin.jvm.internal.IIXOooo):void");
    }
}
