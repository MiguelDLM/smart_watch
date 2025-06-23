package androidx.core.view;

import OI0IXox.oIX0oI;
import OXOo.OOXIXo;
import Oox.oOoXoXO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OxI;

public final class TreeIterator<T> implements Iterator<T>, oIX0oI {
    @OOXIXo
    private final oOoXoXO<T, Iterator<T>> getChildIterator;
    @OOXIXo
    private Iterator<? extends T> iterator;
    @OOXIXo
    private final List<Iterator<T>> stack = new ArrayList();

    public TreeIterator(@OOXIXo Iterator<? extends T> it, @OOXIXo oOoXoXO<? super T, ? extends Iterator<? extends T>> oooxoxo) {
        this.getChildIterator = oooxoxo;
        this.iterator = it;
    }

    private final void prepareNextIterator(T t) {
        Iterator<? extends T> invoke = this.getChildIterator.invoke(t);
        if (invoke == null || !invoke.hasNext()) {
            while (!this.iterator.hasNext() && !this.stack.isEmpty()) {
                this.iterator = (Iterator) CollectionsKt___CollectionsKt.O0O0Io00X(this.stack);
                OxI.xx0X0(this.stack);
            }
            return;
        }
        this.stack.add(this.iterator);
        this.iterator = invoke;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public T next() {
        T next = this.iterator.next();
        prepareNextIterator(next);
        return next;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
