package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

@kotlin.oxxXoxO(version = "1.1")
/* loaded from: classes6.dex */
public abstract class Oxx0IOOO<E> extends AbstractCollection<E> implements Set<E>, OI0IXox.oIX0oI {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f29124XO = new oIX0oI(null);

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public final int II0xO0(@OXOo.OOXIXo Collection<?> c) {
            int i;
            kotlin.jvm.internal.IIX0o.x0xO0oo(c, "c");
            int i2 = 0;
            for (Object obj : c) {
                if (obj != null) {
                    i = obj.hashCode();
                } else {
                    i = 0;
                }
                i2 += i;
            }
            return i2;
        }

        public final boolean oIX0oI(@OXOo.OOXIXo Set<?> c, @OXOo.OOXIXo Set<?> other) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(c, "c");
            kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
            if (c.size() != other.size()) {
                return false;
            }
            return c.containsAll(other);
        }

        public oIX0oI() {
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        return f29124XO.oIX0oI(this, (Set) obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return f29124XO.II0xO0(this);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
