package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes9.dex */
public abstract class AbstractSequentialIterator<T> extends UnmodifiableIterator<T> {

    @CheckForNull
    private T nextOrNull;

    public AbstractSequentialIterator(@CheckForNull T t) {
        this.nextOrNull = t;
    }

    @CheckForNull
    public abstract T computeNext(T t);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.nextOrNull != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final T next() {
        T t = this.nextOrNull;
        if (t != null) {
            this.nextOrNull = computeNext(t);
            return t;
        }
        throw new NoSuchElementException();
    }
}
