package androidx.room;

import IXIxx0.oxoX;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.x0xO0oo;
import java.util.concurrent.Callable;
import kotlin.I0oOoX;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.intrinsics.II0xO0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.xII;

@oxoX(c = "androidx.room.CoroutinesRoom$Companion$execute$2", f = "CoroutinesRoom.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CoroutinesRoom$Companion$execute$2 extends SuspendLambda implements x0xO0oo<xII, I0Io<? super R>, Object> {
    final /* synthetic */ Callable<R> $callable;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoroutinesRoom$Companion$execute$2(Callable<R> callable, I0Io<? super CoroutinesRoom$Companion$execute$2> i0Io) {
        super(2, i0Io);
        this.$callable = callable;
    }

    @OOXIXo
    public final I0Io<oXIO0o0XI> create(@oOoXoXO Object obj, @OOXIXo I0Io<?> i0Io) {
        return new CoroutinesRoom$Companion$execute$2(this.$callable, i0Io);
    }

    @oOoXoXO
    public final Object invokeSuspend(@OOXIXo Object obj) {
        II0xO0.oOoXoXO();
        if (this.label == 0) {
            I0oOoX.x0XOIxOo(obj);
            return this.$callable.call();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @oOoXoXO
    public final Object invoke(@OOXIXo xII xii, @oOoXoXO I0Io<? super R> i0Io) {
        return ((CoroutinesRoom$Companion$execute$2) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f19155oIX0oI);
    }
}
