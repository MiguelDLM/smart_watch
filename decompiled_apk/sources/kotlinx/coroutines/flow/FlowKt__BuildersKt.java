package kotlinx.coroutines.flow;

import java.util.Iterator;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nBuilders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,354:1\n107#2:355\n107#2:356\n107#2:357\n107#2:358\n107#2:359\n107#2:360\n107#2:361\n107#2:362\n107#2:363\n107#2:364\n107#2:365\n107#2:366\n*S KotlinDebug\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n68#1:355\n82#1:356\n89#1:357\n98#1:358\n107#1:359\n122#1:360\n131#1:361\n153#1:362\n164#1:363\n175#1:364\n184#1:365\n193#1:366\n*E\n"})
/* loaded from: classes6.dex */
public final /* synthetic */ class FlowKt__BuildersKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @XX({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n1#1,113:1\n136#2,2:114\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class II0xO0<T> implements X0o0xo<T> {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Object f29974XO;

        public II0xO0(Object obj) {
            this.f29974XO = obj;
        }

        @Override // kotlinx.coroutines.flow.X0o0xo
        @OXOo.oOoXoXO
        public Object collect(@OXOo.OOXIXo XO<? super T> xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
            Object emit = xo2.emit((Object) this.f29974XO, i0Io);
            if (emit == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                return emit;
            }
            return oXIO0o0XI.f29392oIX0oI;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @XX({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n1#1,113:1\n69#2,2:114\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI<T> implements X0o0xo<T> {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Oox.oIX0oI f29975XO;

        public oIX0oI(Oox.oIX0oI oix0oi) {
            this.f29975XO = oix0oi;
        }

        @Override // kotlinx.coroutines.flow.X0o0xo
        @OXOo.oOoXoXO
        public Object collect(@OXOo.OOXIXo XO<? super T> xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
            Object emit = xo2.emit((Object) this.f29975XO.invoke(), i0Io);
            if (emit == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                return emit;
            }
            return oXIO0o0XI.f29392oIX0oI;
        }
    }

    @OXOo.OOXIXo
    public static final X0o0xo<Integer> I0Io(@OXOo.OOXIXo X0.oOoXoXO oooxoxo) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9(oooxoxo);
    }

    @OXOo.OOXIXo
    public static final X0o0xo<Integer> II0XooXoX(@OXOo.OOXIXo int[] iArr) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7(iArr);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> II0xO0(@OXOo.OOXIXo Oox.oOoXoXO<? super kotlin.coroutines.I0Io<? super T>, ? extends Object> oooxoxo) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2(oooxoxo);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> OOXIXo(@kotlin.II0xO0 @OXOo.OOXIXo Oox.x0xO0oo<? super kotlinx.coroutines.channels.IXxxXO<? super T>, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo) {
        return new CallbackFlowBuilder(x0xo0oo, null, 0, null, 14, null);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> Oxx0IOOO(@OXOo.OOXIXo kotlin.sequences.ooOOo0oXI<? extends T> ooooo0oxi) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$5(ooooo0oxi);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> X0o0xo(@OXOo.OOXIXo Iterable<? extends T> iterable) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3(iterable);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> XO(@OXOo.OOXIXo Iterator<? extends T> it) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4(it);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> oIX0oI(@OXOo.OOXIXo Oox.oIX0oI<? extends T> oix0oi) {
        return new oIX0oI(oix0oi);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> oO(T t) {
        return new II0xO0(t);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> oOoXoXO(@kotlin.II0xO0 @OXOo.OOXIXo Oox.x0xO0oo<? super kotlinx.coroutines.channels.IXxxXO<? super T>, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo) {
        return new I0Io(x0xo0oo, null, 0, null, 14, null);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> ooOOo0oXI() {
        return oxoX.f30209XO;
    }

    @OXOo.OOXIXo
    public static final X0o0xo<Long> oxoX(@OXOo.OOXIXo X0.oO oOVar) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10(oOVar);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> x0XOIxOo(@kotlin.II0xO0 @OXOo.OOXIXo Oox.x0xO0oo<? super XO<? super T>, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo) {
        return new ooOOo0oXI(x0xo0oo);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> x0xO0oo(@OXOo.OOXIXo T... tArr) {
        return new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1(tArr);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> xoIox(@OXOo.OOXIXo T[] tArr) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6(tArr);
    }

    @OXOo.OOXIXo
    public static final X0o0xo<Long> xxIXOIIO(@OXOo.OOXIXo long[] jArr) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8(jArr);
    }
}
