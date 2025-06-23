package androidx.collection;

import OI0IXox.oxoX;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nIndexBasedArrayIterator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IndexBasedArrayIterator.kt\nandroidx/collection/IndexBasedArrayIterator\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,48:1\n1#2:49\n*E\n"})
public abstract class IndexBasedArrayIterator<T> implements Iterator<T>, oxoX {
    private boolean canRemove;
    private int index;
    private int size;

    public IndexBasedArrayIterator(int i) {
        this.size = i;
    }

    public abstract T elementAt(int i);

    public boolean hasNext() {
        if (this.index < this.size) {
            return true;
        }
        return false;
    }

    public T next() {
        if (hasNext()) {
            T elementAt = elementAt(this.index);
            this.index++;
            this.canRemove = true;
            return elementAt;
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        if (this.canRemove) {
            int i = this.index - 1;
            this.index = i;
            removeAt(i);
            this.size--;
            this.canRemove = false;
            return;
        }
        throw new IllegalStateException("Call next() before removing an element.");
    }

    public abstract void removeAt(int i);
}
