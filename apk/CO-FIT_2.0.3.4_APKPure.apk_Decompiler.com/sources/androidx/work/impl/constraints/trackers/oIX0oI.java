package androidx.work.impl.constraints.trackers;

import java.util.List;

public final /* synthetic */ class oIX0oI implements Runnable {

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ ConstraintTracker f530Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ List f531XO;

    public /* synthetic */ oIX0oI(List list, ConstraintTracker constraintTracker) {
        this.f531XO = list;
        this.f530Oo = constraintTracker;
    }

    public final void run() {
        ConstraintTracker._set_state_$lambda$4$lambda$3(this.f531XO, this.f530Oo);
    }
}
