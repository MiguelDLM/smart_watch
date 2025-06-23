package androidx.collection;

import OI0IXox.oxoX;
import OXOo.OOXIXo;
import java.util.Iterator;
import kotlin.coroutines.I0Io;
import kotlin.sequences.IXxxXO;

public final class MutableScatterSet$MutableSetWrapper$iterator$1 implements Iterator<E>, oxoX {
    private int current = -1;
    @OOXIXo
    private final Iterator<E> iterator;
    final /* synthetic */ MutableScatterSet<E> this$0;

    public MutableScatterSet$MutableSetWrapper$iterator$1(MutableScatterSet<E> mutableScatterSet) {
        this.this$0 = mutableScatterSet;
        this.iterator = IXxxXO.oIX0oI(new MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1(mutableScatterSet, this, (I0Io<? super MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1>) null));
    }

    public final int getCurrent() {
        return this.current;
    }

    @OOXIXo
    public final Iterator<E> getIterator() {
        return this.iterator;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public E next() {
        return this.iterator.next();
    }

    public void remove() {
        int i = this.current;
        if (i != -1) {
            this.this$0.removeElementAt(i);
            this.current = -1;
        }
    }

    public final void setCurrent(int i) {
        this.current = i;
    }
}
