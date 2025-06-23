package androidx.work.impl.constraints;

import IXIxx0.oxoX;
import Oox.x0xO0oo;
import androidx.work.impl.model.WorkSpec;
import kotlin.I0oOoX;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.intrinsics.II0xO0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.flow.X0o0xo;
import kotlinx.coroutines.flow.XO;
import kotlinx.coroutines.xII;

@oxoX(c = "androidx.work.impl.constraints.WorkConstraintsTrackerKt$listen$1", f = "WorkConstraintsTracker.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {})
public final class WorkConstraintsTrackerKt$listen$1 extends SuspendLambda implements x0xO0oo<xII, I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ OnConstraintsStateChangedListener $listener;
    final /* synthetic */ WorkSpec $spec;
    final /* synthetic */ WorkConstraintsTracker $this_listen;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WorkConstraintsTrackerKt$listen$1(WorkConstraintsTracker workConstraintsTracker, WorkSpec workSpec, OnConstraintsStateChangedListener onConstraintsStateChangedListener, I0Io<? super WorkConstraintsTrackerKt$listen$1> i0Io) {
        super(2, i0Io);
        this.$this_listen = workConstraintsTracker;
        this.$spec = workSpec;
        this.$listener = onConstraintsStateChangedListener;
    }

    public final I0Io<oXIO0o0XI> create(Object obj, I0Io<?> i0Io) {
        return new WorkConstraintsTrackerKt$listen$1(this.$this_listen, this.$spec, this.$listener, i0Io);
    }

    public final Object invokeSuspend(Object obj) {
        Object oOoXoXO2 = II0xO0.oOoXoXO();
        int i = this.label;
        if (i == 0) {
            I0oOoX.x0XOIxOo(obj);
            X0o0xo<ConstraintsState> track = this.$this_listen.track(this.$spec);
            final OnConstraintsStateChangedListener onConstraintsStateChangedListener = this.$listener;
            final WorkSpec workSpec = this.$spec;
            AnonymousClass1 r1 = new XO() {
                public final Object emit(ConstraintsState constraintsState, I0Io<? super oXIO0o0XI> i0Io) {
                    onConstraintsStateChangedListener.onConstraintsStateChanged(workSpec, constraintsState);
                    return oXIO0o0XI.f19155oIX0oI;
                }
            };
            this.label = 1;
            if (track.collect(r1, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        } else if (i == 1) {
            I0oOoX.x0XOIxOo(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return oXIO0o0XI.f19155oIX0oI;
    }

    public final Object invoke(xII xii, I0Io<? super oXIO0o0XI> i0Io) {
        return ((WorkConstraintsTrackerKt$listen$1) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f19155oIX0oI);
    }
}
