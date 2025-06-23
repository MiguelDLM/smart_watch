package kotlinx.coroutines.flow.internal;

import Oox.IXxxXO;
import kotlin.jvm.internal.XX;
import kotlin.o0;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.x0o;

@XX({"SMAP\nCombine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Combine.kt\nkotlinx/coroutines/flow/internal/CombineKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,143:1\n107#2:144\n*S KotlinDebug\n*F\n+ 1 Combine.kt\nkotlinx/coroutines/flow/internal/CombineKt\n*L\n86#1:144\n*E\n"})
/* loaded from: classes6.dex */
public final class CombineKt {

    /* JADX INFO: Add missing generic type declarations: [R] */
    @XX({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Combine.kt\nkotlinx/coroutines/flow/internal/CombineKt\n*L\n1#1,113:1\n87#2:114\n142#2:115\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI<R> implements kotlinx.coroutines.flow.X0o0xo<R> {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ IXxxXO f30173IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.flow.X0o0xo f30174Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.flow.X0o0xo f30175XO;

        public oIX0oI(kotlinx.coroutines.flow.X0o0xo x0o0xo, kotlinx.coroutines.flow.X0o0xo x0o0xo2, IXxxXO iXxxXO) {
            this.f30175XO = x0o0xo;
            this.f30174Oo = x0o0xo2;
            this.f30173IXxxXO = iXxxXO;
        }

        @Override // kotlinx.coroutines.flow.X0o0xo
        @OXOo.oOoXoXO
        public Object collect(@OXOo.OOXIXo kotlinx.coroutines.flow.XO<? super R> xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
            Object Oxx0IOOO2 = x0o.Oxx0IOOO(new CombineKt$zipImpl$1$1(xo2, this.f30175XO, this.f30174Oo, this.f30173IXxxXO, null), i0Io);
            if (Oxx0IOOO2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                return Oxx0IOOO2;
            }
            return oXIO0o0XI.f29392oIX0oI;
        }
    }

    @OXOo.OOXIXo
    public static final <T1, T2, R> kotlinx.coroutines.flow.X0o0xo<R> II0xO0(@OXOo.OOXIXo kotlinx.coroutines.flow.X0o0xo<? extends T1> x0o0xo, @OXOo.OOXIXo kotlinx.coroutines.flow.X0o0xo<? extends T2> x0o0xo2, @OXOo.OOXIXo IXxxXO<? super T1, ? super T2, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> iXxxXO) {
        return new oIX0oI(x0o0xo2, x0o0xo, iXxxXO);
    }

    @o0
    @OXOo.oOoXoXO
    public static final <R, T> Object oIX0oI(@OXOo.OOXIXo kotlinx.coroutines.flow.XO<? super R> xo2, @OXOo.OOXIXo kotlinx.coroutines.flow.X0o0xo<? extends T>[] x0o0xoArr, @OXOo.OOXIXo Oox.oIX0oI<T[]> oix0oi, @OXOo.OOXIXo IXxxXO<? super kotlinx.coroutines.flow.XO<? super R>, ? super T[], ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> iXxxXO, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        Object oIX0oI2 = FlowCoroutineKt.oIX0oI(new CombineKt$combineInternal$2(x0o0xoArr, oix0oi, iXxxXO, xo2, null), i0Io);
        if (oIX0oI2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return oIX0oI2;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }
}
