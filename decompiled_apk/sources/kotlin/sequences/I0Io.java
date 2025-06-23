package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class I0Io<T, K> implements ooOOo0oXI<T> {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Oox.oOoXoXO<T, K> f29410II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ooOOo0oXI<T> f29411oIX0oI;

    /* JADX WARN: Multi-variable type inference failed */
    public I0Io(@OXOo.OOXIXo ooOOo0oXI<? extends T> source, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends K> keySelector) {
        IIX0o.x0xO0oo(source, "source");
        IIX0o.x0xO0oo(keySelector, "keySelector");
        this.f29411oIX0oI = source;
        this.f29410II0xO0 = keySelector;
    }

    @Override // kotlin.sequences.ooOOo0oXI
    @OXOo.OOXIXo
    public Iterator<T> iterator() {
        return new II0xO0(this.f29411oIX0oI.iterator(), this.f29410II0xO0);
    }
}
