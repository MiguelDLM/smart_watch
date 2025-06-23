package kotlin.coroutines;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.x0xO0oo;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.oxoX;
import kotlin.jvm.internal.IIX0o;
import kotlin.oxxXoxO;

@oxxXoxO(version = "1.3")
/* loaded from: classes6.dex */
public interface CoroutineContext {

    /* loaded from: classes6.dex */
    public static final class DefaultImpls {
        @OOXIXo
        public static CoroutineContext oIX0oI(@OOXIXo CoroutineContext coroutineContext, @OOXIXo CoroutineContext context) {
            IIX0o.x0xO0oo(context, "context");
            if (context != EmptyCoroutineContext.INSTANCE) {
                return (CoroutineContext) context.fold(coroutineContext, new x0xO0oo<CoroutineContext, oIX0oI, CoroutineContext>() { // from class: kotlin.coroutines.CoroutineContext$plus$1
                    @Override // Oox.x0xO0oo
                    @OOXIXo
                    public final CoroutineContext invoke(@OOXIXo CoroutineContext acc, @OOXIXo CoroutineContext.oIX0oI element) {
                        CombinedContext combinedContext;
                        IIX0o.x0xO0oo(acc, "acc");
                        IIX0o.x0xO0oo(element, "element");
                        CoroutineContext minusKey = acc.minusKey(element.getKey());
                        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
                        if (minusKey == emptyCoroutineContext) {
                            return element;
                        }
                        oxoX.II0xO0 iI0xO0 = oxoX.f29196Oxx0IOOO;
                        oxoX oxox = (oxoX) minusKey.get(iI0xO0);
                        if (oxox == null) {
                            combinedContext = new CombinedContext(minusKey, element);
                        } else {
                            CoroutineContext minusKey2 = minusKey.minusKey(iI0xO0);
                            if (minusKey2 == emptyCoroutineContext) {
                                return new CombinedContext(element, oxox);
                            }
                            combinedContext = new CombinedContext(new CombinedContext(minusKey2, element), oxox);
                        }
                        return combinedContext;
                    }
                });
            }
            return coroutineContext;
        }
    }

    /* loaded from: classes6.dex */
    public interface II0xO0<E extends oIX0oI> {
    }

    /* loaded from: classes6.dex */
    public interface oIX0oI extends CoroutineContext {

        /* renamed from: kotlin.coroutines.CoroutineContext$oIX0oI$oIX0oI, reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C1106oIX0oI {
            @OOXIXo
            public static CoroutineContext I0Io(@OOXIXo oIX0oI oix0oi, @OOXIXo II0xO0<?> key) {
                IIX0o.x0xO0oo(key, "key");
                if (IIX0o.Oxx0IOOO(oix0oi.getKey(), key)) {
                    return EmptyCoroutineContext.INSTANCE;
                }
                return oix0oi;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @oOoXoXO
            public static <E extends oIX0oI> E II0xO0(@OOXIXo oIX0oI oix0oi, @OOXIXo II0xO0<E> key) {
                IIX0o.x0xO0oo(key, "key");
                if (IIX0o.Oxx0IOOO(oix0oi.getKey(), key)) {
                    IIX0o.x0XOIxOo(oix0oi, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                    return oix0oi;
                }
                return null;
            }

            public static <R> R oIX0oI(@OOXIXo oIX0oI oix0oi, R r, @OOXIXo x0xO0oo<? super R, ? super oIX0oI, ? extends R> operation) {
                IIX0o.x0xO0oo(operation, "operation");
                return operation.invoke(r, oix0oi);
            }

            @OOXIXo
            public static CoroutineContext oxoX(@OOXIXo oIX0oI oix0oi, @OOXIXo CoroutineContext context) {
                IIX0o.x0xO0oo(context, "context");
                return DefaultImpls.oIX0oI(oix0oi, context);
            }
        }

        @Override // kotlin.coroutines.CoroutineContext
        <R> R fold(R r, @OOXIXo x0xO0oo<? super R, ? super oIX0oI, ? extends R> x0xo0oo);

        @Override // kotlin.coroutines.CoroutineContext
        @oOoXoXO
        <E extends oIX0oI> E get(@OOXIXo II0xO0<E> iI0xO0);

        @OOXIXo
        II0xO0<?> getKey();

        @Override // kotlin.coroutines.CoroutineContext
        @OOXIXo
        CoroutineContext minusKey(@OOXIXo II0xO0<?> iI0xO0);
    }

    <R> R fold(R r, @OOXIXo x0xO0oo<? super R, ? super oIX0oI, ? extends R> x0xo0oo);

    @oOoXoXO
    <E extends oIX0oI> E get(@OOXIXo II0xO0<E> iI0xO0);

    @OOXIXo
    CoroutineContext minusKey(@OOXIXo II0xO0<?> iI0xO0);

    @OOXIXo
    CoroutineContext plus(@OOXIXo CoroutineContext coroutineContext);
}
