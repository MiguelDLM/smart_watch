package androidx.work.impl.constraints;

import Oox.oOoXoXO;
import androidx.work.impl.constraints.controllers.ConstraintController;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class WorkConstraintsTracker$areAllConstraintsMet$1 extends Lambda implements oOoXoXO<ConstraintController, CharSequence> {
    public static final WorkConstraintsTracker$areAllConstraintsMet$1 INSTANCE = new WorkConstraintsTracker$areAllConstraintsMet$1();

    public WorkConstraintsTracker$areAllConstraintsMet$1() {
        super(1);
    }

    public final CharSequence invoke(ConstraintController constraintController) {
        IIX0o.x0xO0oo(constraintController, "it");
        String simpleName = constraintController.getClass().getSimpleName();
        IIX0o.oO(simpleName, "it.javaClass.simpleName");
        return simpleName;
    }
}
