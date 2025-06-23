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
/* loaded from: classes.dex */
public final class WorkConstraintsTrackerKt$listen$1 extends SuspendLambda implements x0xO0oo<xII, I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ OnConstraintsStateChangedListener $listener;
    final /* synthetic */ WorkSpec $spec;
    final /* synthetic */ WorkConstraintsTracker $this_listen;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkConstraintsTrackerKt$listen$1(WorkConstraintsTracker workConstraintsTracker, WorkSpec workSpec, OnConstraintsStateChangedListener onConstraintsStateChangedListener, I0Io<? super WorkConstraintsTrackerKt$listen$1> i0Io) {
        super(2, i0Io);
        this.$this_listen = workConstraintsTracker;
        this.$spec = workSpec;
        this.$listener = onConstraintsStateChangedListener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final I0Io<oXIO0o0XI> create(Object obj, I0Io<?> i0Io) {
        return new WorkConstraintsTrackerKt$listen$1(this.$this_listen, this.$spec, this.$listener, i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
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
            X0o0xo<ConstraintsState> track = this.$this_listen.track(this.$spec);
            final OnConstraintsStateChangedListener onConstraintsStateChangedListener = this.$listener;
            final WorkSpec workSpec = this.$spec;
            XO<? super ConstraintsState> xo2 = new XO() { // from class: androidx.work.impl.constraints.WorkConstraintsTrackerKt$listen$1.1
                public final Object emit(ConstraintsState constraintsState, I0Io<? super oXIO0o0XI> i0Io) {
                    OnConstraintsStateChangedListener.this.onConstraintsStateChanged(workSpec, constraintsState);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                @Override // kotlinx.coroutines.flow.XO
                public /* bridge */ /* synthetic */ Object emit(Object obj2, I0Io i0Io) {
                    return emit((ConstraintsState) obj2, (I0Io<? super oXIO0o0XI>) i0Io);
                }
            };
            this.label = 1;
            if (track.collect(xo2, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // Oox.x0xO0oo
    public final Object invoke(xII xii, I0Io<? super oXIO0o0XI> i0Io) {
        return ((WorkConstraintsTrackerKt$listen$1) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
