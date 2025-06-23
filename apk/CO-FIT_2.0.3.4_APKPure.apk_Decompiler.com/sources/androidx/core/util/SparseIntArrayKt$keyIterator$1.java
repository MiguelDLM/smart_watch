package androidx.core.util;

import android.util.SparseIntArray;
import kotlin.collections.oOXoIIIo;

public final class SparseIntArrayKt$keyIterator$1 extends oOXoIIIo {
    final /* synthetic */ SparseIntArray $this_keyIterator;
    private int index;

    public SparseIntArrayKt$keyIterator$1(SparseIntArray sparseIntArray) {
        this.$this_keyIterator = sparseIntArray;
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
        SparseIntArray sparseIntArray = this.$this_keyIterator;
        int i = this.index;
        this.index = i + 1;
        return sparseIntArray.keyAt(i);
    }

    public final void setIndex(int i) {
        this.index = i;
    }
}
