package kotlin.sequences;

import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class II0xO0<T, K> extends kotlin.collections.oIX0oI<T> {

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Iterator<T> f29419IXxxXO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Oox.oOoXoXO<T, K> f29420Oxx0xo;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final HashSet<K> f29421oI0IIXIo;

    /* JADX WARN: Multi-variable type inference failed */
    public II0xO0(@OXOo.OOXIXo Iterator<? extends T> source, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends K> keySelector) {
        IIX0o.x0xO0oo(source, "source");
        IIX0o.x0xO0oo(keySelector, "keySelector");
        this.f29419IXxxXO = source;
        this.f29420Oxx0xo = keySelector;
        this.f29421oI0IIXIo = new HashSet<>();
    }

    @Override // kotlin.collections.oIX0oI
    public void oIX0oI() {
        while (this.f29419IXxxXO.hasNext()) {
            T next = this.f29419IXxxXO.next();
            if (this.f29421oI0IIXIo.add(this.f29420Oxx0xo.invoke(next))) {
                oxoX(next);
                return;
            }
        }
        II0xO0();
    }
}
