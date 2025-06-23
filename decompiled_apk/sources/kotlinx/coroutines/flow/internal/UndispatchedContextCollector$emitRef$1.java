package kotlinx.coroutines.flow.internal;

import Oox.x0xO0oo;
import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;

/* JADX INFO: Add missing generic type declarations: [T] */
@IXIxx0.oxoX(c = "kotlinx.coroutines.flow.internal.UndispatchedContextCollector$emitRef$1", f = "ChannelFlow.kt", i = {}, l = {212}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class UndispatchedContextCollector$emitRef$1<T> extends SuspendLambda implements x0xO0oo<T, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ kotlinx.coroutines.flow.XO<T> $downstream;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UndispatchedContextCollector$emitRef$1(kotlinx.coroutines.flow.XO<? super T> xo2, kotlin.coroutines.I0Io<? super UndispatchedContextCollector$emitRef$1> i0Io) {
        super(2, i0Io);
        this.$downstream = xo2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        UndispatchedContextCollector$emitRef$1 undispatchedContextCollector$emitRef$1 = new UndispatchedContextCollector$emitRef$1(this.$downstream, i0Io);
        undispatchedContextCollector$emitRef$1.L$0 = obj;
        return undispatchedContextCollector$emitRef$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // Oox.x0xO0oo
    public /* bridge */ /* synthetic */ Object invoke(Object obj, kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return invoke2((UndispatchedContextCollector$emitRef$1<T>) obj, i0Io);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        Object oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                I0oOoX.x0XOIxOo(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            I0oOoX.x0XOIxOo(obj);
            Object obj2 = this.L$0;
            kotlinx.coroutines.flow.XO<T> xo2 = this.$downstream;
            this.label = 1;
            if (xo2.emit(obj2, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @OXOo.oOoXoXO
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(T t, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((UndispatchedContextCollector$emitRef$1) create(t, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
