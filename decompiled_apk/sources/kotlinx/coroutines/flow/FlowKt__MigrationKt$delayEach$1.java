package kotlinx.coroutines.flow;

import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Add missing generic type declarations: [T] */
@IXIxx0.oxoX(c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$delayEach$1", f = "Migration.kt", i = {}, l = {427}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class FlowKt__MigrationKt$delayEach$1<T> extends SuspendLambda implements Oox.x0xO0oo<T, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ long $timeMillis;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__MigrationKt$delayEach$1(long j, kotlin.coroutines.I0Io<? super FlowKt__MigrationKt$delayEach$1> i0Io) {
        super(2, i0Io);
        this.$timeMillis = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        return new FlowKt__MigrationKt$delayEach$1(this.$timeMillis, i0Io);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // Oox.x0xO0oo
    public /* bridge */ /* synthetic */ Object invoke(Object obj, kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return invoke2((FlowKt__MigrationKt$delayEach$1<T>) obj, i0Io);
    }

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
            long j = this.$timeMillis;
            this.label = 1;
            if (DelayKt.II0xO0(j, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @OXOo.oOoXoXO
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(T t, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((FlowKt__MigrationKt$delayEach$1) create(t, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
