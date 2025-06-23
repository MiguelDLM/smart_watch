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
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.II0XooXoX;
import kotlinx.coroutines.Xo0;
import kotlinx.coroutines.o0oIxOo;
import kotlinx.coroutines.xII;

@oxoX(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
public final class RepeatOnLifecycleKt$repeatOnLifecycle$3 extends SuspendLambda implements x0xO0oo<xII, I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ x0xO0oo<xII, I0Io<? super oXIO0o0XI>, Object> $block;
    final /* synthetic */ Lifecycle.State $state;
    final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
    private /* synthetic */ Object L$0;
    int label;

    @oxoX(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", i = {0, 0}, l = {166}, m = "invokeSuspend", n = {"launchedJob", "observer"}, s = {"L$0", "L$1"})
    @XX({"SMAP\nRepeatOnLifecycle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RepeatOnLifecycle.kt\nandroidx/lifecycle/RepeatOnLifecycleKt$repeatOnLifecycle$3$1\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,165:1\n314#2,11:166\n*S KotlinDebug\n*F\n+ 1 RepeatOnLifecycle.kt\nandroidx/lifecycle/RepeatOnLifecycleKt$repeatOnLifecycle$3$1\n*L\n97#1:166,11\n*E\n"})
    /* renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements x0xO0oo<xII, I0Io<? super oXIO0o0XI>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        @OOXIXo
        public final I0Io<oXIO0o0XI> create(@oOoXoXO Object obj, @OOXIXo I0Io<?> i0Io) {
            return new AnonymousClass1(lifecycle, state, xii, x0xo0oo, i0Io);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: kotlin.jvm.internal.Ref$ObjectRef} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: kotlin.jvm.internal.Ref$ObjectRef} */
        /* JADX WARNING: Multi-variable type inference failed */
        @OXOo.oOoXoXO
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(@OXOo.OOXIXo java.lang.Object r17) {
            /*
                r16 = this;
                r1 = r16
                java.lang.Object r0 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
                int r2 = r1.label
                r3 = 0
                r4 = 1
                if (r2 == 0) goto L_0x0038
                if (r2 != r4) goto L_0x0030
                java.lang.Object r0 = r1.L$5
                Oox.x0xO0oo r0 = (Oox.x0xO0oo) r0
                java.lang.Object r0 = r1.L$4
                kotlinx.coroutines.xII r0 = (kotlinx.coroutines.xII) r0
                java.lang.Object r0 = r1.L$3
                androidx.lifecycle.Lifecycle r0 = (androidx.lifecycle.Lifecycle) r0
                java.lang.Object r0 = r1.L$2
                androidx.lifecycle.Lifecycle$State r0 = (androidx.lifecycle.Lifecycle.State) r0
                java.lang.Object r0 = r1.L$1
                r2 = r0
                kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
                java.lang.Object r0 = r1.L$0
                r5 = r0
                kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref.ObjectRef) r5
                kotlin.I0oOoX.x0XOIxOo(r17)     // Catch:{ all -> 0x002d }
                goto L_0x00b1
            L_0x002d:
                r0 = move-exception
                goto L_0x00c9
            L_0x0030:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r2)
                throw r0
            L_0x0038:
                kotlin.I0oOoX.x0XOIxOo(r17)
                androidx.lifecycle.Lifecycle r2 = r4
                androidx.lifecycle.Lifecycle$State r2 = r2.getCurrentState()
                androidx.lifecycle.Lifecycle$State r5 = androidx.lifecycle.Lifecycle.State.DESTROYED
                if (r2 != r5) goto L_0x0048
                kotlin.oXIO0o0XI r0 = kotlin.oXIO0o0XI.f19155oIX0oI
                return r0
            L_0x0048:
                kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
                r2.<init>()
                kotlin.jvm.internal.Ref$ObjectRef r13 = new kotlin.jvm.internal.Ref$ObjectRef
                r13.<init>()
                androidx.lifecycle.Lifecycle$State r5 = r5     // Catch:{ all -> 0x00a8 }
                androidx.lifecycle.Lifecycle r14 = r4     // Catch:{ all -> 0x00a8 }
                kotlinx.coroutines.xII r8 = r6     // Catch:{ all -> 0x00a8 }
                Oox.x0xO0oo<kotlinx.coroutines.xII, kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI>, java.lang.Object> r12 = r7     // Catch:{ all -> 0x00a8 }
                r1.L$0 = r2     // Catch:{ all -> 0x00a8 }
                r1.L$1 = r13     // Catch:{ all -> 0x00a8 }
                r1.L$2 = r5     // Catch:{ all -> 0x00a8 }
                r1.L$3 = r14     // Catch:{ all -> 0x00a8 }
                r1.L$4 = r8     // Catch:{ all -> 0x00a8 }
                r1.L$5 = r12     // Catch:{ all -> 0x00a8 }
                r1.label = r4     // Catch:{ all -> 0x00a8 }
                kotlinx.coroutines.x0xO0oo r15 = new kotlinx.coroutines.x0xO0oo     // Catch:{ all -> 0x00a8 }
                kotlin.coroutines.I0Io r6 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(r16)     // Catch:{ all -> 0x00a8 }
                r15.<init>(r6, r4)     // Catch:{ all -> 0x00a8 }
                r15.IO()     // Catch:{ all -> 0x00a8 }
                androidx.lifecycle.Lifecycle$Event$Companion r6 = androidx.lifecycle.Lifecycle.Event.Companion     // Catch:{ all -> 0x00a8 }
                androidx.lifecycle.Lifecycle$Event r7 = r6.upTo(r5)     // Catch:{ all -> 0x00a8 }
                androidx.lifecycle.Lifecycle$Event r9 = r6.downFrom(r5)     // Catch:{ all -> 0x00a8 }
                r5 = 0
                kotlinx.coroutines.sync.oIX0oI r11 = kotlinx.coroutines.sync.MutexKt.II0xO0(r5, r4, r3)     // Catch:{ all -> 0x00a8 }
                androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1 r10 = new androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1     // Catch:{ all -> 0x00a8 }
                r5 = r10
                r6 = r7
                r7 = r2
                r3 = r10
                r10 = r15
                r5.<init>(r6, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x00a8 }
                r13.element = r3     // Catch:{ all -> 0x00a8 }
                java.lang.String r5 = "null cannot be cast to non-null type androidx.lifecycle.LifecycleEventObserver"
                kotlin.jvm.internal.IIX0o.x0XOIxOo(r3, r5)     // Catch:{ all -> 0x00a8 }
                r10 = r3
                androidx.lifecycle.LifecycleEventObserver r10 = (androidx.lifecycle.LifecycleEventObserver) r10     // Catch:{ all -> 0x00a8 }
                r14.addObserver(r10)     // Catch:{ all -> 0x00a8 }
                java.lang.Object r3 = r15.o00()     // Catch:{ all -> 0x00a8 }
                java.lang.Object r5 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()     // Catch:{ all -> 0x00a8 }
                if (r3 != r5) goto L_0x00ac
                IXIxx0.XO.I0Io(r16)     // Catch:{ all -> 0x00a8 }
                goto L_0x00ac
            L_0x00a8:
                r0 = move-exception
                r5 = r2
                r2 = r13
                goto L_0x00c9
            L_0x00ac:
                if (r3 != r0) goto L_0x00af
                return r0
            L_0x00af:
                r5 = r2
                r2 = r13
            L_0x00b1:
                T r0 = r5.element
                kotlinx.coroutines.oXIO0o0XI r0 = (kotlinx.coroutines.oXIO0o0XI) r0
                if (r0 == 0) goto L_0x00bb
                r3 = 0
                kotlinx.coroutines.oXIO0o0XI.oIX0oI.II0xO0(r0, r3, r4, r3)
            L_0x00bb:
                T r0 = r2.element
                androidx.lifecycle.LifecycleEventObserver r0 = (androidx.lifecycle.LifecycleEventObserver) r0
                if (r0 == 0) goto L_0x00c6
                androidx.lifecycle.Lifecycle r2 = r4
                r2.removeObserver(r0)
            L_0x00c6:
                kotlin.oXIO0o0XI r0 = kotlin.oXIO0o0XI.f19155oIX0oI
                return r0
            L_0x00c9:
                T r3 = r5.element
                kotlinx.coroutines.oXIO0o0XI r3 = (kotlinx.coroutines.oXIO0o0XI) r3
                if (r3 == 0) goto L_0x00d3
                r5 = 0
                kotlinx.coroutines.oXIO0o0XI.oIX0oI.II0xO0(r3, r5, r4, r5)
            L_0x00d3:
                T r2 = r2.element
                androidx.lifecycle.LifecycleEventObserver r2 = (androidx.lifecycle.LifecycleEventObserver) r2
                if (r2 == 0) goto L_0x00de
                androidx.lifecycle.Lifecycle r3 = r4
                r3.removeObserver(r2)
            L_0x00de:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @oOoXoXO
        public final Object invoke(@OOXIXo xII xii, @oOoXoXO I0Io<? super oXIO0o0XI> i0Io) {
            return ((AnonymousClass1) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f19155oIX0oI);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RepeatOnLifecycleKt$repeatOnLifecycle$3(Lifecycle lifecycle, Lifecycle.State state, x0xO0oo<? super xII, ? super I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo, I0Io<? super RepeatOnLifecycleKt$repeatOnLifecycle$3> i0Io) {
        super(2, i0Io);
        this.$this_repeatOnLifecycle = lifecycle;
        this.$state = state;
        this.$block = x0xo0oo;
    }

    @OOXIXo
    public final I0Io<oXIO0o0XI> create(@oOoXoXO Object obj, @OOXIXo I0Io<?> i0Io) {
        RepeatOnLifecycleKt$repeatOnLifecycle$3 repeatOnLifecycleKt$repeatOnLifecycle$3 = new RepeatOnLifecycleKt$repeatOnLifecycle$3(this.$this_repeatOnLifecycle, this.$state, this.$block, i0Io);
        repeatOnLifecycleKt$repeatOnLifecycle$3.L$0 = obj;
        return repeatOnLifecycleKt$repeatOnLifecycle$3;
    }

    @oOoXoXO
    public final Object invokeSuspend(@OOXIXo Object obj) {
        Object oOoXoXO2 = II0xO0.oOoXoXO();
        int i = this.label;
        if (i == 0) {
            I0oOoX.x0XOIxOo(obj);
            final xII xii = (xII) this.L$0;
            o0oIxOo IIXOooo2 = Xo0.X0o0xo().IIXOooo();
            final Lifecycle lifecycle = this.$this_repeatOnLifecycle;
            final Lifecycle.State state = this.$state;
            final x0xO0oo<xII, I0Io<? super oXIO0o0XI>, Object> x0xo0oo = this.$block;
            AnonymousClass1 r3 = new AnonymousClass1((I0Io<? super AnonymousClass1>) null);
            this.label = 1;
            if (II0XooXoX.II0XooXoX(IIXOooo2, r3, this) == oOoXoXO2) {
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
        return ((RepeatOnLifecycleKt$repeatOnLifecycle$3) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f19155oIX0oI);
    }
}
