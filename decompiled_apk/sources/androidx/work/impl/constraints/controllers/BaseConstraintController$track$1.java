package androidx.work.impl.constraints.controllers;

import IXIxx0.oxoX;
import Oox.oIX0oI;
import Oox.x0xO0oo;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import kotlin.I0oOoX;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.intrinsics.II0xO0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.channels.IXxxXO;
import kotlinx.coroutines.channels.ProduceKt;

@oxoX(c = "androidx.work.impl.constraints.controllers.BaseConstraintController$track$1", f = "ContraintControllers.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class BaseConstraintController$track$1 extends SuspendLambda implements x0xO0oo<IXxxXO<? super ConstraintsState>, I0Io<? super oXIO0o0XI>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BaseConstraintController<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseConstraintController$track$1(BaseConstraintController<T> baseConstraintController, I0Io<? super BaseConstraintController$track$1> i0Io) {
        super(2, i0Io);
        this.this$0 = baseConstraintController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final I0Io<oXIO0o0XI> create(Object obj, I0Io<?> i0Io) {
        BaseConstraintController$track$1 baseConstraintController$track$1 = new BaseConstraintController$track$1(this.this$0, i0Io);
        baseConstraintController$track$1.L$0 = obj;
        return baseConstraintController$track$1;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.work.impl.constraints.controllers.BaseConstraintController$track$1$listener$1, androidx.work.impl.constraints.ConstraintListener] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ConstraintTracker constraintTracker;
        Object oOoXoXO2 = II0xO0.oOoXoXO();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                I0oOoX.x0XOIxOo(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            I0oOoX.x0XOIxOo(obj);
            final IXxxXO iXxxXO = (IXxxXO) this.L$0;
            final BaseConstraintController<T> baseConstraintController = this.this$0;
            final ?? r1 = new ConstraintListener<T>() { // from class: androidx.work.impl.constraints.controllers.BaseConstraintController$track$1$listener$1
                @Override // androidx.work.impl.constraints.ConstraintListener
                public void onConstraintChanged(T t) {
                    ConstraintsState constraintsState;
                    if (baseConstraintController.isConstrained(t)) {
                        constraintsState = new ConstraintsState.ConstraintsNotMet(baseConstraintController.getReason());
                    } else {
                        constraintsState = ConstraintsState.ConstraintsMet.INSTANCE;
                    }
                    iXxxXO.getChannel().x0xO0oo(constraintsState);
                }
            };
            constraintTracker = ((BaseConstraintController) this.this$0).tracker;
            constraintTracker.addListener(r1);
            final BaseConstraintController<T> baseConstraintController2 = this.this$0;
            oIX0oI<oXIO0o0XI> oix0oi = new oIX0oI<oXIO0o0XI>() { // from class: androidx.work.impl.constraints.controllers.BaseConstraintController$track$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // Oox.oIX0oI
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                    invoke2();
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ConstraintTracker constraintTracker2;
                    constraintTracker2 = ((BaseConstraintController) baseConstraintController2).tracker;
                    constraintTracker2.removeListener(r1);
                }
            };
            this.label = 1;
            if (ProduceKt.oIX0oI(iXxxXO, oix0oi, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // Oox.x0xO0oo
    public final Object invoke(IXxxXO<? super ConstraintsState> iXxxXO, I0Io<? super oXIO0o0XI> i0Io) {
        return ((BaseConstraintController$track$1) create(iXxxXO, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
