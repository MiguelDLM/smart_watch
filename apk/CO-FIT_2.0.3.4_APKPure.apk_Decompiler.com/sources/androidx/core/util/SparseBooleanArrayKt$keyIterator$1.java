package androidx.core.util;

import android.util.SparseBooleanArray;
import kotlin.collections.oOXoIIIo;

public final class SparseBooleanArrayKt$keyIterator$1 extends oOXoIIIo {
    final /* synthetic */ SparseBooleanArray $this_keyIterator;
    private int index;

    public SparseBooleanArrayKt$keyIterator$1(SparseBooleanArray sparseBooleanArray) {
        this.$this_keyIterator = sparseBooleanArray;
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
        SparseBooleanArray sparseBooleanArray = this.$this_keyIterator;
        int i = this.index;
        this.index = i + 1;
        return sparseBooleanArray.keyAt(i);
    }

    public final void setIndex(int i) {
        this.index = i;
    }
}
