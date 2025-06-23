package androidx.core.util;

import android.util.LongSparseArray;
import kotlin.collections.Xx000oIo;

public final class LongSparseArrayKt$keyIterator$1 extends Xx000oIo {
    final /* synthetic */ LongSparseArray<T> $this_keyIterator;
    private int index;

    public LongSparseArrayKt$keyIterator$1(LongSparseArray<T> longSparseArray) {
        this.$this_keyIterator = longSparseArray;
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

    public long nextLong() {
        LongSparseArray<T> longSparseArray = this.$this_keyIterator;
        int i = this.index;
        this.index = i + 1;
        return longSparseArray.keyAt(i);
    }

    public final void setIndex(int i) {
        this.index = i;
    }
}
