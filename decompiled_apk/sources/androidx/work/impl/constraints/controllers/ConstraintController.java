package androidx.work.impl.constraints.controllers;

import OXOo.OOXIXo;
import androidx.work.Constraints;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.model.WorkSpec;
import kotlinx.coroutines.flow.X0o0xo;

/* loaded from: classes.dex */
public interface ConstraintController {
    boolean hasConstraint(@OOXIXo WorkSpec workSpec);

    boolean isCurrentlyConstrained(@OOXIXo WorkSpec workSpec);

    @OOXIXo
    X0o0xo<ConstraintsState> track(@OOXIXo Constraints constraints);
}
