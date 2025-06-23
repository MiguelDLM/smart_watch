package androidx.core.util;

import android.util.SparseBooleanArray;
import kotlin.collections.oO;

public final class SparseBooleanArrayKt$valueIterator$1 extends oO {
    final /* synthetic */ SparseBooleanArray $this_valueIterator;
    private int index;

    public SparseBooleanArrayKt$valueIterator$1(SparseBooleanArray sparseBooleanArray) {
        this.$this_valueIterator = sparseBooleanArray;
    }

    public final int getIndex() {
        return this.index;
    }

    public boolean hasNext() {
        if (this.index < this.$this_valueIterator.size()) {
            return true;
        }
        return false;
    }

    public boolean nextBoolean() {
        SparseBooleanArray sparseBooleanArray = this.$this_valueIterator;
        int i = this.index;
        this.index = i + 1;
        return sparseBooleanArray.valueAt(i);
    }

    public final void setIndex(int i) {
        this.index = i;
    }
}
