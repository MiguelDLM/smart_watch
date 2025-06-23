package androidx.core.util;

import android.util.SparseIntArray;
import kotlin.collections.oOXoIIIo;

public final class SparseIntArrayKt$valueIterator$1 extends oOXoIIIo {
    final /* synthetic */ SparseIntArray $this_valueIterator;
    private int index;

    public SparseIntArrayKt$valueIterator$1(SparseIntArray sparseIntArray) {
        this.$this_valueIterator = sparseIntArray;
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

    public int nextInt() {
        SparseIntArray sparseIntArray = this.$this_valueIterator;
        int i = this.index;
        this.index = i + 1;
        return sparseIntArray.valueAt(i);
    }

    public final void setIndex(int i) {
        this.index = i;
    }
}
