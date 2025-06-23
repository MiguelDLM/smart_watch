package androidx.work.impl.constraints.controllers;

import OXOo.OOXIXo;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import kotlin.jvm.internal.IIX0o;

public final class StorageNotLowController extends BaseConstraintController<Boolean> {
    private final int reason = 9;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StorageNotLowController(@OOXIXo ConstraintTracker<Boolean> constraintTracker) {
        super(constraintTracker);
        IIX0o.x0xO0oo(constraintTracker, "tracker");
    }

    public int getReason() {
        return this.reason;
    }

    public boolean hasConstraint(@OOXIXo WorkSpec workSpec) {
        IIX0o.x0xO0oo(workSpec, "workSpec");
        return workSpec.constraints.requiresStorageNotLow();
    }

    public boolean isConstrained(boolean z) {
        return !z;
    }

    public /* bridge */ /* synthetic */ boolean isConstrained(Object obj) {
        return isConstrained(((Boolean) obj).booleanValue());
    }
}
