package kotlinx.coroutines.selects;

import Oox.x0xO0oo;
import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.xII;

@IXIxx0.oxoX(c = "kotlinx.coroutines.selects.UnbiasedSelectBuilderImpl$initSelectResult$1", f = "SelectOld.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class UnbiasedSelectBuilderImpl$initSelectResult$1 extends SuspendLambda implements x0xO0oo<xII, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    int label;
    final /* synthetic */ UnbiasedSelectBuilderImpl<R> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnbiasedSelectBuilderImpl$initSelectResult$1(UnbiasedSelectBuilderImpl<R> unbiasedSelectBuilderImpl, kotlin.coroutines.I0Io<? super UnbiasedSelectBuilderImpl$initSelectResult$1> i0Io) {
        super(2, i0Io);
        this.this$0 = unbiasedSelectBuilderImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        return new UnbiasedSelectBuilderImpl$initSelectResult$1(this.this$0, i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        kotlinx.coroutines.x0xO0oo x0xo0oo;
        kotlinx.coroutines.x0xO0oo x0xo0oo2;
        Object oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        int i = this.label;
        try {
            if (i != 0) {
                if (i == 1) {
                    I0oOoX.x0XOIxOo(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                I0oOoX.x0XOIxOo(obj);
                x0XOIxOo x0xoixoo = this.this$0;
                this.label = 1;
                obj = x0xoixoo.o00(this);
                if (obj == oOoXoXO2) {
                    return oOoXoXO2;
                }
            }
            x0xo0oo2 = this.this$0.f30420xoXoI;
            oOoXoXO.I0Io(x0xo0oo2, obj);
            return oXIO0o0XI.f29392oIX0oI;
        } catch (Throwable th) {
            x0xo0oo = this.this$0.f30420xoXoI;
            oOoXoXO.oxoX(x0xo0oo, th);
            return oXIO0o0XI.f29392oIX0oI;
        }
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo xII xii, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((UnbiasedSelectBuilderImpl$initSelectResult$1) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
