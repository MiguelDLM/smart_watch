package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.XX;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.internal.x0o;

@XX({"SMAP\nStateFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,428:1\n1#2:429\n*E\n"})
/* loaded from: classes6.dex */
public final class xoXoI {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final x0o f30213oIX0oI = new x0o("NONE");

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final x0o f30212II0xO0 = new x0o("PENDING");

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T Oxx0IOOO(@OXOo.OOXIXo xoIox<T> xoiox, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends T> oooxoxo) {
        I00O.II0xO0 iI0xO0;
        T invoke;
        do {
            iI0xO0 = (Object) xoiox.getValue();
            invoke = oooxoxo.invoke(iI0xO0);
        } while (!xoiox.compareAndSet(iI0xO0, invoke));
        return invoke;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.lang.Object] */
    public static final <T> T X0o0xo(@OXOo.OOXIXo xoIox<T> xoiox, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends T> oooxoxo) {
        ?? r0;
        do {
            r0 = (Object) xoiox.getValue();
        } while (!xoiox.compareAndSet(r0, oooxoxo.invoke(r0)));
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void XO(@OXOo.OOXIXo xoIox<T> xoiox, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends T> oooxoxo) {
        I00O.II0xO0 iI0xO0;
        do {
            iI0xO0 = (Object) xoiox.getValue();
        } while (!xoiox.compareAndSet(iI0xO0, oooxoxo.invoke(iI0xO0)));
    }

    @OXOo.OOXIXo
    public static final <T> xoIox<T> oIX0oI(T t) {
        if (t == null) {
            t = (T) kotlinx.coroutines.flow.internal.oOoXoXO.f30198oIX0oI;
        }
        return new StateFlowImpl(t);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> oxoX(@OXOo.OOXIXo IIXOooo<? extends T> iIXOooo, @OXOo.OOXIXo CoroutineContext coroutineContext, int i, @OXOo.OOXIXo BufferOverflow bufferOverflow) {
        if (((i >= 0 && i < 2) || i == -2) && bufferOverflow == BufferOverflow.DROP_OLDEST) {
            return iIXOooo;
        }
        return oO.X0o0xo(iIXOooo, coroutineContext, i, bufferOverflow);
    }
}
