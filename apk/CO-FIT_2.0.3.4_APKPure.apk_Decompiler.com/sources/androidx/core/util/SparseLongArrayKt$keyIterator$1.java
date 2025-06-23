package androidx.core.util;

import android.util.SparseLongArray;
import kotlin.collections.oOXoIIIo;

public final class SparseLongArrayKt$keyIterator$1 extends oOXoIIIo {
    final /* synthetic */ SparseLongArray $this_keyIterator;
    private int index;

    public SparseLongArrayKt$keyIterator$1(SparseLongArray sparseLongArray) {
        this.$this_keyIterator = sparseLongArray;
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
        SparseLongArray sparseLongArray = this.$this_keyIterator;
        int i = this.index;
        this.index = i + 1;
        return sparseLongArray.keyAt(i);
    }

    public final void setIndex(int i) {
        this.index = i;
    }
}
