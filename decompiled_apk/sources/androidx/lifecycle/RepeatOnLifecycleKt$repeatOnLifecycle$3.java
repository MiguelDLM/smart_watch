package androidx.lifecycle;

import Oox.x0xO0oo;
import androidx.lifecycle.Lifecycle;
import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.Xo0;
import kotlinx.coroutines.o0oIxOo;
import kotlinx.coroutines.xII;

@IXIxx0.oxoX(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class RepeatOnLifecycleKt$repeatOnLifecycle$3 extends SuspendLambda implements x0xO0oo<xII, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ x0xO0oo<xII, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> $block;
    final /* synthetic */ Lifecycle.State $state;
    final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
    private /* synthetic */ Object L$0;
    int label;

    @IXIxx0.oxoX(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", i = {0, 0}, l = {166}, m = "invokeSuspend", n = {"launchedJob", "observer"}, s = {"L$0", "L$1"})
    @XX({"SMAP\nRepeatOnLifecycle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RepeatOnLifecycle.kt\nandroidx/lifecycle/RepeatOnLifecycleKt$repeatOnLifecycle$3$1\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,165:1\n314#2,11:166\n*S KotlinDebug\n*F\n+ 1 RepeatOnLifecycle.kt\nandroidx/lifecycle/RepeatOnLifecycleKt$repeatOnLifecycle$3$1\n*L\n97#1:166,11\n*E\n"})
    /* renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements x0xO0oo<xII, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
        final /* synthetic */ xII $$this$coroutineScope;
        final /* synthetic */ x0xO0oo<xII, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> $block;
        final /* synthetic */ Lifecycle.State $state;
        final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Lifecycle lifecycle, Lifecycle.State state, xII xii, x0xO0oo<? super xII, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo, kotlin.coroutines.I0Io<? super AnonymousClass1> i0Io) {
            super(2, i0Io);
            this.$this_repeatOnLifecycle = lifecycle;
            this.$state = state;
            this.$$this$coroutineScope = xii;
            this.$block = x0xo0oo;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @OXOo.OOXIXo
        public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
            return new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, this.$$this$coroutineScope, this.$block, i0Io);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x00cf  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00d9  */
        /* JADX WARN: Type inference failed for: r10v0, types: [androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1, T, java.lang.Object] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @OXOo.oOoXoXO
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@OXOo.OOXIXo java.lang.Object r17) {
            /*
                Method dump skipped, instructions count: 223
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // Oox.x0xO0oo
        @OXOo.oOoXoXO
        public final Object invoke(@OXOo.OOXIXo xII xii, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
            return ((AnonymousClass1) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RepeatOnLifecycleKt$repeatOnLifecycle$3(Lifecycle lifecycle, Lifecycle.State state, x0xO0oo<? super xII, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo, kotlin.coroutines.I0Io<? super RepeatOnLifecycleKt$repeatOnLifecycle$3> i0Io) {
        super(2, i0Io);
        this.$this_repeatOnLifecycle = lifecycle;
        this.$state = state;
        this.$block = x0xo0oo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        RepeatOnLifecycleKt$repeatOnLifecycle$3 repeatOnLifecycleKt$repeatOnLifecycle$3 = new RepeatOnLifecycleKt$repeatOnLifecycle$3(this.$this_repeatOnLifecycle, this.$state, this.$block, i0Io);
        repeatOnLifecycleKt$repeatOnLifecycle$3.L$0 = obj;
        return repeatOnLifecycleKt$repeatOnLifecycle$3;
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
            xII xii = (xII) this.L$0;
            o0oIxOo o002 = Xo0.X0o0xo().o00();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, xii, this.$block, null);
            this.label = 1;
            if (kotlinx.coroutines.II0XooXoX.II0XooXoX(o002, anonymousClass1, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo xII xii, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((RepeatOnLifecycleKt$repeatOnLifecycle$3) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
