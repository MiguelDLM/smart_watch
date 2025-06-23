package kotlin.collections;

import java.util.AbstractSet;
import java.util.Set;

@kotlin.oxxXoxO(version = "1.1")
/* loaded from: classes6.dex */
public abstract class XO<E> extends AbstractSet<E> implements Set<E>, OI0IXox.II0XooXoX {
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean add(E e);

    public abstract int getSize();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }
}
