package androidx.work.impl.constraints.controllers;

import OXOo.OOXIXo;
import androidx.work.Constraints;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import kotlin.coroutines.I0Io;
import kotlin.jvm.internal.IIX0o;
import kotlinx.coroutines.flow.Oxx0IOOO;
import kotlinx.coroutines.flow.X0o0xo;

public abstract class BaseConstraintController<T> implements ConstraintController {
    /* access modifiers changed from: private */
    @OOXIXo
    public final ConstraintTracker<T> tracker;

    public BaseConstraintController(@OOXIXo ConstraintTracker<T> constraintTracker) {
        IIX0o.x0xO0oo(constraintTracker, "tracker");
        this.tracker = constraintTracker;
    }

    public static /* synthetic */ void getReason$annotations() {
    }

    public abstract int getReason();

    public boolean isConstrained(T t) {
        return false;
    }

    public boolean isCurrentlyConstrained(@OOXIXo WorkSpec workSpec) {
        IIX0o.x0xO0oo(workSpec, "workSpec");
        if (!hasConstraint(workSpec) || !isConstrained(this.tracker.readSystemState())) {
            return false;
        }
        return true;
    }

    @OOXIXo
    public X0o0xo<ConstraintsState> track(@OOXIXo Constraints constraints) {
        IIX0o.x0xO0oo(constraints, "constraints");
        return Oxx0IOOO.Oxx0xo(new BaseConstraintController$track$1(this, (I0Io<? super BaseConstraintController$track$1>) null));
    }
}
