package androidx.room;

import IXIxx0.oxoX;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.x0xO0oo;
import java.util.concurrent.Callable;
import kotlin.I0oOoX;
import kotlin.Result;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.intrinsics.II0xO0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.oO;
import kotlinx.coroutines.xII;

@oxoX(c = "androidx.room.CoroutinesRoom$Companion$execute$4$job$1", f = "CoroutinesRoom.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CoroutinesRoom$Companion$execute$4$job$1 extends SuspendLambda implements x0xO0oo<xII, I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ Callable<R> $callable;
    final /* synthetic */ oO<R> $continuation;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoroutinesRoom$Companion$execute$4$job$1(Callable<R> callable, oO<? super R> oOVar, I0Io<? super CoroutinesRoom$Companion$execute$4$job$1> i0Io) {
        super(2, i0Io);
        this.$callable = callable;
        this.$continuation = oOVar;
    }

    @OOXIXo
    public final I0Io<oXIO0o0XI> create(@oOoXoXO Object obj, @OOXIXo I0Io<?> i0Io) {
        return new CoroutinesRoom$Companion$execute$4$job$1(this.$callable, this.$continuation, i0Io);
    }

    @oOoXoXO
    public final Object invokeSuspend(@OOXIXo Object obj) {
        II0xO0.oOoXoXO();
        if (this.label == 0) {
            I0oOoX.x0XOIxOo(obj);
            try {
                R call = this.$callable.call();
                oO<R> oOVar = this.$continuation;
                Result.oIX0oI oix0oi = Result.Companion;
                oOVar.resumeWith(Result.m42constructorimpl(call));
            } catch (Throwable th) {
                oO<R> oOVar2 = this.$continuation;
                Result.oIX0oI oix0oi2 = Result.Companion;
                oOVar2.resumeWith(Result.m42constructorimpl(I0oOoX.oIX0oI(th)));
            }
            return oXIO0o0XI.f19155oIX0oI;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @oOoXoXO
    public final Object invoke(@OOXIXo xII xii, @oOoXoXO I0Io<? super oXIO0o0XI> i0Io) {
        return ((CoroutinesRoom$Companion$execute$4$job$1) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f19155oIX0oI);
    }
}
