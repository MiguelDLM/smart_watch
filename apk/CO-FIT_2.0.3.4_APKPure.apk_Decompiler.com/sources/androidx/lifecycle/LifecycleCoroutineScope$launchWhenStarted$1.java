package androidx.lifecycle;

import IXIxx0.oxoX;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.x0xO0oo;
import kotlin.I0oOoX;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.intrinsics.II0xO0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.xII;

@oxoX(c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenStarted$1", f = "Lifecycle.kt", i = {}, l = {356}, m = "invokeSuspend", n = {}, s = {})
public final class LifecycleCoroutineScope$launchWhenStarted$1 extends SuspendLambda implements x0xO0oo<xII, I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ x0xO0oo<xII, I0Io<? super oXIO0o0XI>, Object> $block;
    int label;
    final /* synthetic */ LifecycleCoroutineScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LifecycleCoroutineScope$launchWhenStarted$1(LifecycleCoroutineScope lifecycleCoroutineScope, x0xO0oo<? super xII, ? super I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo, I0Io<? super LifecycleCoroutineScope$launchWhenStarted$1> i0Io) {
        super(2, i0Io);
        this.this$0 = lifecycleCoroutineScope;
        this.$block = x0xo0oo;
    }

    @OOXIXo
    public final I0Io<oXIO0o0XI> create(@oOoXoXO Object obj, @OOXIXo I0Io<?> i0Io) {
        return new LifecycleCoroutineScope$launchWhenStarted$1(this.this$0, this.$block, i0Io);
    }

    @oOoXoXO
    public final Object invokeSuspend(@OOXIXo Object obj) {
        Object oOoXoXO2 = II0xO0.oOoXoXO();
        int i = this.label;
        if (i == 0) {
            I0oOoX.x0XOIxOo(obj);
            Lifecycle lifecycle$lifecycle_common = this.this$0.getLifecycle$lifecycle_common();
            x0xO0oo<xII, I0Io<? super oXIO0o0XI>, Object> x0xo0oo = this.$block;
            this.label = 1;
            if (PausingDispatcherKt.whenStarted(lifecycle$lifecycle_common, x0xo0oo, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        } else if (i == 1) {
            I0oOoX.x0XOIxOo(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return oXIO0o0XI.f19155oIX0oI;
    }

    @oOoXoXO
    public final Object invoke(@OOXIXo xII xii, @oOoXoXO I0Io<? super oXIO0o0XI> i0Io) {
        return ((LifecycleCoroutineScope$launchWhenStarted$1) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f19155oIX0oI);
    }
}
