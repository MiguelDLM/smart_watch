package kotlin.sequences;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class oIX0oI<T> implements ooOOo0oXI<T> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final AtomicReference<ooOOo0oXI<T>> f29475oIX0oI;

    public oIX0oI(@OXOo.OOXIXo ooOOo0oXI<? extends T> sequence) {
        IIX0o.x0xO0oo(sequence, "sequence");
        this.f29475oIX0oI = new AtomicReference<>(sequence);
    }

    @Override // kotlin.sequences.ooOOo0oXI
    @OXOo.OOXIXo
    public Iterator<T> iterator() {
        ooOOo0oXI<T> andSet = this.f29475oIX0oI.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
