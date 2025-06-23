package androidx.core.util;

import android.util.SparseArray;
import kotlin.collections.oOXoIIIo;

public final class SparseArrayKt$keyIterator$1 extends oOXoIIIo {
    final /* synthetic */ SparseArray<T> $this_keyIterator;
    private int index;

    public SparseArrayKt$keyIterator$1(SparseArray<T> sparseArray) {
        this.$this_keyIterator = sparseArray;
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
        SparseArray<T> sparseArray = this.$this_keyIterator;
        int i = this.index;
        this.index = i + 1;
        return sparseArray.keyAt(i);
    }

    public final void setIndex(int i) {
        this.index = i;
    }
}
