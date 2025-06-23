package androidx.work.impl.constraints.controllers;

import OXOo.OOXIXo;
import androidx.work.impl.constraints.trackers.BatteryNotLowTracker;
import androidx.work.impl.model.WorkSpec;
import kotlin.jvm.internal.IIX0o;

public final class BatteryNotLowController extends BaseConstraintController<Boolean> {
    private final int reason = 5;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BatteryNotLowController(@OOXIXo BatteryNotLowTracker batteryNotLowTracker) {
        super(batteryNotLowTracker);
        IIX0o.x0xO0oo(batteryNotLowTracker, "tracker");
    }

    public int getReason() {
        return this.reason;
    }

    public boolean hasConstraint(@OOXIXo WorkSpec workSpec) {
        IIX0o.x0xO0oo(workSpec, "workSpec");
        return workSpec.constraints.requiresBatteryNotLow();
    }

    public boolean isConstrained(boolean z) {
        return !z;
    }

    public /* bridge */ /* synthetic */ boolean isConstrained(Object obj) {
        return isConstrained(((Boolean) obj).booleanValue());
    }
}
