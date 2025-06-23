package androidx.collection;

import kotlin.collections.oOXoIIIo;

public final class SparseArrayKt$keyIterator$1 extends oOXoIIIo {
    final /* synthetic */ SparseArrayCompat<T> $this_keyIterator;
    private int index;

    public SparseArrayKt$keyIterator$1(SparseArrayCompat<T> sparseArrayCompat) {
        this.$this_keyIterator = sparseArrayCompat;
    }

    public final int getIndex() {
        return this.index;
    }

    public boolean hasNext() {
        if (this.index < this.$this_keyIterator.size()) {
            return true;
        }
        return false;
    }

    public int nextInt() {
        SparseArrayCompat<T> sparseArrayCompat = this.$this_keyIterator;
        int i = this.index;
        this.index = i + 1;
        return sparseArrayCompat.keyAt(i);
    }

    public final void setIndex(int i) {
        this.index = i;
    }
}
