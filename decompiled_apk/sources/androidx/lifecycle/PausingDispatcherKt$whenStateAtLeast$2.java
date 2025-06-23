package androidx.lifecycle;

import Oox.x0xO0oo;
import androidx.lifecycle.Lifecycle;
import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.xII;

/* JADX INFO: Add missing generic type declarations: [T] */
@IXIxx0.oxoX(c = "androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2", f = "PausingDispatcher.kt", i = {0}, l = {203}, m = "invokeSuspend", n = {"controller"}, s = {"L$0"})
/* loaded from: classes.dex */
public final class PausingDispatcherKt$whenStateAtLeast$2<T> extends SuspendLambda implements x0xO0oo<xII, kotlin.coroutines.I0Io<? super T>, Object> {
    final /* synthetic */ x0xO0oo<xII, kotlin.coroutines.I0Io<? super T>, Object> $block;
    final /* synthetic */ Lifecycle.State $minState;
    final /* synthetic */ Lifecycle $this_whenStateAtLeast;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PausingDispatcherKt$whenStateAtLeast$2(Lifecycle lifecycle, Lifecycle.State state, x0xO0oo<? super xII, ? super kotlin.coroutines.I0Io<? super T>, ? extends Object> x0xo0oo, kotlin.coroutines.I0Io<? super PausingDispatcherKt$whenStateAtLeast$2> i0Io) {
        super(2, i0Io);
        this.$this_whenStateAtLeast = lifecycle;
        this.$minState = state;
        this.$block = x0xo0oo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        PausingDispatcherKt$whenStateAtLeast$2 pausingDispatcherKt$whenStateAtLeast$2 = new PausingDispatcherKt$whenStateAtLeast$2(this.$this_whenStateAtLeast, this.$minState, this.$block, i0Io);
        pausingDispatcherKt$whenStateAtLeast$2.L$0 = obj;
        return pausingDispatcherKt$whenStateAtLeast$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        LifecycleController lifecycleController;
        Object oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                lifecycleController = (LifecycleController) this.L$0;
                try {
                    I0oOoX.x0XOIxOo(obj);
                } catch (Throwable th) {
                    th = th;
                    lifecycleController.finish();
                    throw th;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            I0oOoX.x0XOIxOo(obj);
            kotlinx.coroutines.oXIO0o0XI oxio0o0xi = (kotlinx.coroutines.oXIO0o0XI) ((xII) this.L$0).getCoroutineContext().get(kotlinx.coroutines.oXIO0o0XI.f30343xxIXOIIO);
            if (oxio0o0xi != null) {
                PausingDispatcher pausingDispatcher = new PausingDispatcher();
                LifecycleController lifecycleController2 = new LifecycleController(this.$this_whenStateAtLeast, this.$minState, pausingDispatcher.dispatchQueue, oxio0o0xi);
                try {
                    x0xO0oo<xII, kotlin.coroutines.I0Io<? super T>, Object> x0xo0oo = this.$block;
                    this.L$0 = lifecycleController2;
                    this.label = 1;
                    obj = kotlinx.coroutines.II0XooXoX.II0XooXoX(pausingDispatcher, x0xo0oo, this);
                    if (obj == oOoXoXO2) {
                        return oOoXoXO2;
                    }
                    lifecycleController = lifecycleController2;
                } catch (Throwable th2) {
                    th = th2;
                    lifecycleController = lifecycleController2;
                    lifecycleController.finish();
                    throw th;
                }
            } else {
                throw new IllegalStateException("when[State] methods should have a parent job");
            }
        }
        lifecycleController.finish();
        return obj;
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo xII xii, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super T> i0Io) {
        return ((PausingDispatcherKt$whenStateAtLeast$2) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
