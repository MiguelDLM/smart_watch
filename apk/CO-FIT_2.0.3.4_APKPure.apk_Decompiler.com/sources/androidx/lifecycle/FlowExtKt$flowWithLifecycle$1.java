package androidx.lifecycle;

import IXIxx0.oxoX;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.x0xO0oo;
import androidx.lifecycle.Lifecycle;
import kotlin.I0oOoX;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.intrinsics.II0xO0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.channels.IXxxXO;
import kotlinx.coroutines.channels.oI0IIXIo;
import kotlinx.coroutines.flow.X0o0xo;
import kotlinx.coroutines.flow.XO;
import kotlinx.coroutines.xII;

@oxoX(c = "androidx.lifecycle.FlowExtKt$flowWithLifecycle$1", f = "FlowExt.kt", i = {0}, l = {91}, m = "invokeSuspend", n = {"$this$callbackFlow"}, s = {"L$0"})
public final class FlowExtKt$flowWithLifecycle$1 extends SuspendLambda implements x0xO0oo<IXxxXO<? super T>, I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ Lifecycle $lifecycle;
    final /* synthetic */ Lifecycle.State $minActiveState;
    final /* synthetic */ X0o0xo<T> $this_flowWithLifecycle;
    private /* synthetic */ Object L$0;
    int label;

    @oxoX(c = "androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1", f = "FlowExt.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements x0xO0oo<xII, I0Io<? super oXIO0o0XI>, Object> {
        int label;

        @OOXIXo
        public final I0Io<oXIO0o0XI> create(@oOoXoXO Object obj, @OOXIXo I0Io<?> i0Io) {
            return new AnonymousClass1(x0o0xo, iXxxXO2, i0Io);
        }

        @oOoXoXO
        public final Object invokeSuspend(@OOXIXo Object obj) {
            Object oOoXoXO2 = II0xO0.oOoXoXO();
            int i = this.label;
            if (i == 0) {
                I0oOoX.x0XOIxOo(obj);
                X0o0xo<T> x0o0xo = x0o0xo;
                final IXxxXO<T> iXxxXO = iXxxXO2;
                AnonymousClass1 r1 = new XO() {
                    @oOoXoXO
                    public final Object emit(T t, @OOXIXo I0Io<? super oXIO0o0XI> i0Io) {
                        Object XOxIOxOx2 = iXxxXO.XOxIOxOx(t, i0Io);
                        if (XOxIOxOx2 == II0xO0.oOoXoXO()) {
                            return XOxIOxOx2;
                        }
                        return oXIO0o0XI.f19155oIX0oI;
                    }
                };
                this.label = 1;
                if (x0o0xo.collect(r1, this) == oOoXoXO2) {
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
            return ((AnonymousClass1) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f19155oIX0oI);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowExtKt$flowWithLifecycle$1(Lifecycle lifecycle, Lifecycle.State state, X0o0xo<? extends T> x0o0xo, I0Io<? super FlowExtKt$flowWithLifecycle$1> i0Io) {
        super(2, i0Io);
        this.$lifecycle = lifecycle;
        this.$minActiveState = state;
        this.$this_flowWithLifecycle = x0o0xo;
    }

    @OOXIXo
    public final I0Io<oXIO0o0XI> create(@oOoXoXO Object obj, @OOXIXo I0Io<?> i0Io) {
        FlowExtKt$flowWithLifecycle$1 flowExtKt$flowWithLifecycle$1 = new FlowExtKt$flowWithLifecycle$1(this.$lifecycle, this.$minActiveState, this.$this_flowWithLifecycle, i0Io);
        flowExtKt$flowWithLifecycle$1.L$0 = obj;
        return flowExtKt$flowWithLifecycle$1;
    }

    @oOoXoXO
    public final Object invokeSuspend(@OOXIXo Object obj) {
        IXxxXO iXxxXO;
        Object oOoXoXO2 = II0xO0.oOoXoXO();
        int i = this.label;
        if (i == 0) {
            I0oOoX.x0XOIxOo(obj);
            final IXxxXO iXxxXO2 = (IXxxXO) this.L$0;
            Lifecycle lifecycle = this.$lifecycle;
            Lifecycle.State state = this.$minActiveState;
            final X0o0xo<T> x0o0xo = this.$this_flowWithLifecycle;
            AnonymousClass1 r5 = new AnonymousClass1((I0Io<? super AnonymousClass1>) null);
            this.L$0 = iXxxXO2;
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(lifecycle, state, (x0xO0oo<? super xII, ? super I0Io<? super oXIO0o0XI>, ? extends Object>) r5, (I0Io<? super oXIO0o0XI>) this) == oOoXoXO2) {
                return oOoXoXO2;
            }
            iXxxXO = iXxxXO2;
        } else if (i == 1) {
            iXxxXO = (IXxxXO) this.L$0;
            I0oOoX.x0XOIxOo(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        oI0IIXIo.oIX0oI.oIX0oI(iXxxXO, (Throwable) null, 1, (Object) null);
        return oXIO0o0XI.f19155oIX0oI;
    }

    @oOoXoXO
    public final Object invoke(@OOXIXo IXxxXO<? super T> iXxxXO, @oOoXoXO I0Io<? super oXIO0o0XI> i0Io) {
        return ((FlowExtKt$flowWithLifecycle$1) create(iXxxXO, i0Io)).invokeSuspend(oXIO0o0XI.f19155oIX0oI);
    }
}
