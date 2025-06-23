package androidx.work.impl.constraints.controllers;

import OXOo.OOXIXo;
import androidx.work.Constraints;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import kotlin.jvm.internal.IIX0o;
import kotlinx.coroutines.flow.Oxx0IOOO;
import kotlinx.coroutines.flow.X0o0xo;

/* loaded from: classes.dex */
public abstract class BaseConstraintController<T> implements ConstraintController {

    @OOXIXo
    private final ConstraintTracker<T> tracker;

    public BaseConstraintController(@OOXIXo ConstraintTracker<T> tracker) {
        IIX0o.x0xO0oo(tracker, "tracker");
        this.tracker = tracker;
    }

    public static /* synthetic */ void getReason$annotations() {
    }

    public abstract int getReason();

    public boolean isConstrained(T t) {
        return false;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public boolean isCurrentlyConstrained(@OOXIXo WorkSpec workSpec) {
        IIX0o.x0xO0oo(workSpec, "workSpec");
        if (hasConstraint(workSpec) && isConstrained(this.tracker.readSystemState())) {
            return true;
        }
        return false;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    @OOXIXo
    public X0o0xo<ConstraintsState> track(@OOXIXo Constraints constraints) {
        IIX0o.x0xO0oo(constraints, "constraints");
        return Oxx0IOOO.Oxx0xo(new BaseConstraintController$track$1(this, null));
    }
}
