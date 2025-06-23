package kotlin.coroutines;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import kotlin.IXxxXO;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.oIX0oI;
import kotlin.jvm.internal.IIX0o;
import kotlin.oxxXoxO;

@IXxxXO
@oxxXoxO(version = "1.3")
/* loaded from: classes6.dex */
public abstract class II0xO0<B extends CoroutineContext.oIX0oI, E extends B> implements CoroutineContext.II0xO0<E> {

    /* renamed from: Oo, reason: collision with root package name */
    @OOXIXo
    public final CoroutineContext.II0xO0<?> f29192Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OOXIXo
    public final oOoXoXO<CoroutineContext.oIX0oI, E> f29193XO;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.coroutines.CoroutineContext$II0xO0<?>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [Oox.oOoXoXO<kotlin.coroutines.CoroutineContext$oIX0oI, E extends B>, Oox.oOoXoXO<? super kotlin.coroutines.CoroutineContext$oIX0oI, ? extends E extends B>, java.lang.Object] */
    public II0xO0(@OOXIXo CoroutineContext.II0xO0<B> baseKey, @OOXIXo oOoXoXO<? super CoroutineContext.oIX0oI, ? extends E> safeCast) {
        IIX0o.x0xO0oo(baseKey, "baseKey");
        IIX0o.x0xO0oo(safeCast, "safeCast");
        this.f29193XO = safeCast;
        this.f29192Oo = baseKey instanceof II0xO0 ? (CoroutineContext.II0xO0<B>) ((II0xO0) baseKey).f29192Oo : baseKey;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lkotlin/coroutines/CoroutineContext$oIX0oI;)TE; */
    @OXOo.oOoXoXO
    public final CoroutineContext.oIX0oI II0xO0(@OOXIXo CoroutineContext.oIX0oI element) {
        IIX0o.x0xO0oo(element, "element");
        return (CoroutineContext.oIX0oI) this.f29193XO.invoke(element);
    }

    public final boolean oIX0oI(@OOXIXo CoroutineContext.II0xO0<?> key) {
        IIX0o.x0xO0oo(key, "key");
        if (key != this && this.f29192Oo != key) {
            return false;
        }
        return true;
    }
}
