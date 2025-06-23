package androidx.core.util;

import OXOo.OOXIXo;
import X0.Oxx0IOOO;
import android.annotation.SuppressLint;
import android.util.Range;
import androidx.annotation.RequiresApi;

@SuppressLint({"ClassVerificationFailure"})
public final class RangeKt {
    @RequiresApi(21)
    @OOXIXo
    public static final <T extends Comparable<? super T>> Range<T> and(@OOXIXo Range<T> range, @OOXIXo Range<T> range2) {
        return range.intersect(range2);
    }

    @RequiresApi(21)
    @OOXIXo
    public static final <T extends Comparable<? super T>> Range<T> plus(@OOXIXo Range<T> range, @OOXIXo T t) {
        return range.extend(t);
    }

    @RequiresApi(21)
    @OOXIXo
    public static final <T extends Comparable<? super T>> Range<T> rangeTo(@OOXIXo T t, @OOXIXo T t2) {
        return new Range<>(t, t2);
    }

    @RequiresApi(21)
    @OOXIXo
    public static final <T extends Comparable<? super T>> Oxx0IOOO<T> toClosedRange(@OOXIXo Range<T> range) {
        return new RangeKt$toClosedRange$1(range);
    }

    @RequiresApi(21)
    @OOXIXo
    public static final <T extends Comparable<? super T>> Range<T> toRange(@OOXIXo Oxx0IOOO<T> oxx0IOOO) {
        return new Range<>(oxx0IOOO.getStart(), oxx0IOOO.getEndInclusive());
    }

    @RequiresApi(21)
    @OOXIXo
    public static final <T extends Comparable<? super T>> Range<T> plus(@OOXIXo Range<T> range, @OOXIXo Range<T> range2) {
        return range.extend(range2);
    }
}
