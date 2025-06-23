package kotlinx.coroutines.flow.internal;

import Oox.IXxxXO;
import Oox.x0xO0oo;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.xII;

@XX({"SMAP\nFlowCoroutine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlowCoroutine.kt\nkotlinx/coroutines/flow/internal/FlowCoroutineKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,63:1\n107#2:64\n*S KotlinDebug\n*F\n+ 1 FlowCoroutine.kt\nkotlinx/coroutines/flow/internal/FlowCoroutineKt\n*L\n50#1:64\n*E\n"})
/* loaded from: classes6.dex */
public final class FlowCoroutineKt {

    /* JADX INFO: Add missing generic type declarations: [R] */
    @XX({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 FlowCoroutine.kt\nkotlinx/coroutines/flow/internal/FlowCoroutineKt\n*L\n1#1,113:1\n51#2,2:114\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI<R> implements kotlinx.coroutines.flow.X0o0xo<R> {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ IXxxXO f30182XO;

        public oIX0oI(IXxxXO iXxxXO) {
            this.f30182XO = iXxxXO;
        }

        @Override // kotlinx.coroutines.flow.X0o0xo
        @OXOo.oOoXoXO
        public Object collect(@OXOo.OOXIXo kotlinx.coroutines.flow.XO<? super R> xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
            Object oIX0oI2 = FlowCoroutineKt.oIX0oI(new FlowCoroutineKt$scopedFlow$1$1(this.f30182XO, xo2, null), i0Io);
            if (oIX0oI2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                return oIX0oI2;
            }
            return oXIO0o0XI.f29392oIX0oI;
        }
    }

    @OXOo.OOXIXo
    public static final <R> kotlinx.coroutines.flow.X0o0xo<R> II0xO0(@kotlin.II0xO0 @OXOo.OOXIXo IXxxXO<? super xII, ? super kotlinx.coroutines.flow.XO<? super R>, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> iXxxXO) {
        return new oIX0oI(iXxxXO);
    }

    @OXOo.oOoXoXO
    public static final <R> Object oIX0oI(@kotlin.II0xO0 @OXOo.OOXIXo x0xO0oo<? super xII, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> x0xo0oo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super R> i0Io) {
        Oxx0IOOO oxx0IOOO = new Oxx0IOOO(i0Io.getContext(), i0Io);
        Object X0o0xo2 = o0xIoII.II0xO0.X0o0xo(oxx0IOOO, oxx0IOOO, x0xo0oo);
        if (X0o0xo2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            IXIxx0.XO.I0Io(i0Io);
        }
        return X0o0xo2;
    }
}
