package androidx.core.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes.dex */
public final class TreeIterator<T> implements Iterator<T>, OI0IXox.oIX0oI {

    @OXOo.OOXIXo
    private final Oox.oOoXoXO<T, Iterator<T>> getChildIterator;

    @OXOo.OOXIXo
    private Iterator<? extends T> iterator;

    @OXOo.OOXIXo
    private final List<Iterator<T>> stack = new ArrayList();

    /* JADX WARN: Multi-variable type inference failed */
    public TreeIterator(@OXOo.OOXIXo Iterator<? extends T> it, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends Iterator<? extends T>> oooxoxo) {
        this.getChildIterator = oooxoxo;
        this.iterator = it;
    }

    private final void prepareNextIterator(T t) {
        Iterator<T> invoke = this.getChildIterator.invoke(t);
        if (invoke != null && invoke.hasNext()) {
            this.stack.add(this.iterator);
            this.iterator = invoke;
        } else {
            while (!this.iterator.hasNext() && !this.stack.isEmpty()) {
                this.iterator = (Iterator) CollectionsKt___CollectionsKt.O0O0Io00X(this.stack);
                kotlin.collections.OxI.xx0X0(this.stack);
            }
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public T next() {
        T next = this.iterator.next();
        prepareNextIterator(next);
        return next;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
