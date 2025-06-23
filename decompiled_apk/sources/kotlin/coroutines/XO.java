package kotlin.coroutines;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import kotlin.IXxxXO;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.IIX0o;
import kotlin.oxxXoxO;

/* loaded from: classes6.dex */
public final class XO {
    @IXxxXO
    @OOXIXo
    @oxxXoxO(version = "1.3")
    public static final CoroutineContext II0xO0(@OOXIXo CoroutineContext.oIX0oI oix0oi, @OOXIXo CoroutineContext.II0xO0<?> key) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        IIX0o.x0xO0oo(key, "key");
        if (key instanceof II0xO0) {
            II0xO0 iI0xO0 = (II0xO0) key;
            if (iI0xO0.oIX0oI(oix0oi.getKey()) && iI0xO0.II0xO0(oix0oi) != null) {
                return EmptyCoroutineContext.INSTANCE;
            }
            return oix0oi;
        }
        if (oix0oi.getKey() == key) {
            return EmptyCoroutineContext.INSTANCE;
        }
        return oix0oi;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @IXxxXO
    @oxxXoxO(version = "1.3")
    @oOoXoXO
    public static final <E extends CoroutineContext.oIX0oI> E oIX0oI(@OOXIXo CoroutineContext.oIX0oI oix0oi, @OOXIXo CoroutineContext.II0xO0<E> key) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        IIX0o.x0xO0oo(key, "key");
        if (key instanceof II0xO0) {
            II0xO0 iI0xO0 = (II0xO0) key;
            if (!iI0xO0.oIX0oI(oix0oi.getKey())) {
                return null;
            }
            E e = (E) iI0xO0.II0xO0(oix0oi);
            if (!(e instanceof CoroutineContext.oIX0oI)) {
                return null;
            }
            return e;
        }
        if (oix0oi.getKey() != key) {
            return null;
        }
        return oix0oi;
    }
}
