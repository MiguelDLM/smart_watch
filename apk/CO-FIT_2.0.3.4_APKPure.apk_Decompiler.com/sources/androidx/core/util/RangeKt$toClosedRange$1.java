package androidx.core.util;

import OXOo.OOXIXo;
import X0.Oxx0IOOO;
import android.util.Range;

public final class RangeKt$toClosedRange$1 implements Oxx0IOOO<T> {
    final /* synthetic */ Range<T> $this_toClosedRange;

    public RangeKt$toClosedRange$1(Range<T> range) {
        this.$this_toClosedRange = range;
    }

    public boolean contains(@OOXIXo T t) {
        return Oxx0IOOO.oIX0oI.oIX0oI(this, t);
    }

    public T getEndInclusive() {
        return this.$this_toClosedRange.getUpper();
    }

    public T getStart() {
        return this.$this_toClosedRange.getLower();
    }

    public boolean isEmpty() {
        return Oxx0IOOO.oIX0oI.II0xO0(this);
    }
}
