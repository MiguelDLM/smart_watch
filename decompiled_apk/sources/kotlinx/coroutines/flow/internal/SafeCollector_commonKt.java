package kotlinx.coroutines.flow.internal;

import Oox.x0xO0oo;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.IIX0o;
import kotlin.o0;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.internal.Xx000oIo;

/* loaded from: classes6.dex */
public final class SafeCollector_commonKt {
    @OXOo.OOXIXo
    @o0
    public static final <T> kotlinx.coroutines.flow.X0o0xo<T> I0Io(@kotlin.II0xO0 @OXOo.OOXIXo x0xO0oo<? super kotlinx.coroutines.flow.XO<? super T>, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo) {
        return new SafeCollector_commonKt$unsafeFlow$1(x0xo0oo);
    }

    @OXOo.oOoXoXO
    public static final kotlinx.coroutines.oXIO0o0XI II0xO0(@OXOo.oOoXoXO kotlinx.coroutines.oXIO0o0XI oxio0o0xi, @OXOo.oOoXoXO kotlinx.coroutines.oXIO0o0XI oxio0o0xi2) {
        while (oxio0o0xi != null) {
            if (oxio0o0xi == oxio0o0xi2) {
                return oxio0o0xi;
            }
            if (!(oxio0o0xi instanceof Xx000oIo)) {
                return oxio0o0xi;
            }
            oxio0o0xi = oxio0o0xi.getParent();
        }
        return null;
    }

    @XO0OX.xxIXOIIO(name = "checkContext")
    public static final void oIX0oI(@OXOo.OOXIXo final SafeCollector<?> safeCollector, @OXOo.OOXIXo CoroutineContext coroutineContext) {
        if (((Number) coroutineContext.fold(0, new x0xO0oo<Integer, CoroutineContext.oIX0oI, Integer>() { // from class: kotlinx.coroutines.flow.internal.SafeCollector_commonKt$checkContext$result$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // Oox.x0xO0oo
            public /* bridge */ /* synthetic */ Integer invoke(Integer num, CoroutineContext.oIX0oI oix0oi) {
                return invoke(num.intValue(), oix0oi);
            }

            @OXOo.OOXIXo
            public final Integer invoke(int i, @OXOo.OOXIXo CoroutineContext.oIX0oI oix0oi) {
                CoroutineContext.II0xO0<?> key = oix0oi.getKey();
                CoroutineContext.oIX0oI oix0oi2 = safeCollector.collectContext.get(key);
                if (key != kotlinx.coroutines.oXIO0o0XI.f30343xxIXOIIO) {
                    return Integer.valueOf(oix0oi != oix0oi2 ? Integer.MIN_VALUE : i + 1);
                }
                kotlinx.coroutines.oXIO0o0XI oxio0o0xi = (kotlinx.coroutines.oXIO0o0XI) oix0oi2;
                IIX0o.x0XOIxOo(oix0oi, "null cannot be cast to non-null type kotlinx.coroutines.Job");
                kotlinx.coroutines.oXIO0o0XI II0xO02 = SafeCollector_commonKt.II0xO0((kotlinx.coroutines.oXIO0o0XI) oix0oi, oxio0o0xi);
                if (II0xO02 == oxio0o0xi) {
                    if (oxio0o0xi != null) {
                        i++;
                    }
                    return Integer.valueOf(i);
                }
                throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + II0xO02 + ", expected child of " + oxio0o0xi + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
            }
        })).intValue() == safeCollector.collectContextSize) {
            return;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + safeCollector.collectContext + ",\n\t\tbut emission happened in " + coroutineContext + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }
}
