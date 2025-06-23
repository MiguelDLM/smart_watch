package androidx.work.impl.constraints.controllers;

import IXIxx0.oxoX;
import Oox.oIX0oI;
import Oox.x0xO0oo;
import androidx.work.impl.constraints.ConstraintsState;
import kotlin.I0oOoX;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.intrinsics.II0xO0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.channels.IXxxXO;
import kotlinx.coroutines.channels.ProduceKt;

@oxoX(c = "androidx.work.impl.constraints.controllers.BaseConstraintController$track$1", f = "ContraintControllers.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
public final class BaseConstraintController$track$1 extends SuspendLambda implements x0xO0oo<IXxxXO<? super ConstraintsState>, I0Io<? super oXIO0o0XI>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BaseConstraintController<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseConstraintController$track$1(BaseConstraintController<T> baseConstraintController, I0Io<? super BaseConstraintController$track$1> i0Io) {
        super(2, i0Io);
        this.this$0 = baseConstraintController;
    }

    public final I0Io<oXIO0o0XI> create(Object obj, I0Io<?> i0Io) {
        BaseConstraintController$track$1 baseConstraintController$track$1 = new BaseConstraintController$track$1(this.this$0, i0Io);
        baseConstraintController$track$1.L$0 = obj;
        return baseConstraintController$track$1;
    }

    public final Object invokeSuspend(Object obj) {
        Object oOoXoXO2 = II0xO0.oOoXoXO();
        int i = this.label;
        if (i == 0) {
            I0oOoX.x0XOIxOo(obj);
            IXxxXO iXxxXO = (IXxxXO) this.L$0;
            final BaseConstraintController$track$1$listener$1 baseConstraintController$track$1$listener$1 = new BaseConstraintController$track$1$listener$1(this.this$0, iXxxXO);
            this.this$0.tracker.addListener(baseConstraintController$track$1$listener$1);
            final BaseConstraintController<T> baseConstraintController = this.this$0;
            AnonymousClass1 r3 = new oIX0oI<oXIO0o0XI>() {
                public final void invoke() {
                    baseConstraintController.tracker.removeListener(baseConstraintController$track$1$listener$1);
                }
            };
            this.label = 1;
            if (ProduceKt.oIX0oI(iXxxXO, r3, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        } else if (i == 1) {
            I0oOoX.x0XOIxOo(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return oXIO0o0XI.f19155oIX0oI;
    }

    public final Object invoke(IXxxXO<? super ConstraintsState> iXxxXO, I0Io<? super oXIO0o0XI> i0Io) {
        return ((BaseConstraintController$track$1) create(iXxxXO, i0Io)).invokeSuspend(oXIO0o0XI.f19155oIX0oI);
    }
}
