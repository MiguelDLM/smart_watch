package androidx.work.impl.constraints.controllers;

import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.constraints.ConstraintsState;
import kotlinx.coroutines.channels.IXxxXO;

public final class BaseConstraintController$track$1$listener$1 implements ConstraintListener<T> {
    final /* synthetic */ IXxxXO<ConstraintsState> $$this$callbackFlow;
    final /* synthetic */ BaseConstraintController<T> this$0;

    public BaseConstraintController$track$1$listener$1(BaseConstraintController<T> baseConstraintController, IXxxXO<? super ConstraintsState> iXxxXO) {
        this.this$0 = baseConstraintController;
        this.$$this$callbackFlow = iXxxXO;
    }

    public void onConstraintChanged(T t) {
        Object obj;
        if (this.this$0.isConstrained(t)) {
            obj = new ConstraintsState.ConstraintsNotMet(this.this$0.getReason());
        } else {
            obj = ConstraintsState.ConstraintsMet.INSTANCE;
        }
        this.$$this$callbackFlow.getChannel().x0xO0oo(obj);
    }
}
