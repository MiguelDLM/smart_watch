package androidx.room;

import java.util.concurrent.Callable;
import kotlin.I0oOoX;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.xII;

@IXIxx0.oxoX(c = "androidx.room.CoroutinesRoom$Companion$execute$4$job$1", f = "CoroutinesRoom.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class CoroutinesRoom$Companion$execute$4$job$1 extends SuspendLambda implements Oox.x0xO0oo<xII, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ Callable<R> $callable;
    final /* synthetic */ kotlinx.coroutines.oO<R> $continuation;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CoroutinesRoom$Companion$execute$4$job$1(Callable<R> callable, kotlinx.coroutines.oO<? super R> oOVar, kotlin.coroutines.I0Io<? super CoroutinesRoom$Companion$execute$4$job$1> i0Io) {
        super(2, i0Io);
        this.$callable = callable;
        this.$continuation = oOVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        return new CoroutinesRoom$Companion$execute$4$job$1(this.$callable, this.$continuation, i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        if (this.label == 0) {
            I0oOoX.x0XOIxOo(obj);
            try {
                Object call = this.$callable.call();
                kotlin.coroutines.I0Io i0Io = this.$continuation;
                Result.oIX0oI oix0oi = Result.Companion;
                i0Io.resumeWith(Result.m287constructorimpl(call));
            } catch (Throwable th) {
                kotlin.coroutines.I0Io i0Io2 = this.$continuation;
                Result.oIX0oI oix0oi2 = Result.Companion;
                i0Io2.resumeWith(Result.m287constructorimpl(I0oOoX.oIX0oI(th)));
            }
            return oXIO0o0XI.f29392oIX0oI;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo xII xii, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((CoroutinesRoom$Companion$execute$4$job$1) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
