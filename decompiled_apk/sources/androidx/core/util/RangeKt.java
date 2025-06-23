package androidx.core.util;

import X0.Oxx0IOOO;
import android.annotation.SuppressLint;
import android.util.Range;
import androidx.annotation.RequiresApi;

@SuppressLint({"ClassVerificationFailure"})
/* loaded from: classes.dex */
public final class RangeKt {
    @OXOo.OOXIXo
    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> and(@OXOo.OOXIXo Range<T> range, @OXOo.OOXIXo Range<T> range2) {
        return range.intersect(range2);
    }

    @OXOo.OOXIXo
    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> plus(@OXOo.OOXIXo Range<T> range, @OXOo.OOXIXo T t) {
        return range.extend((Range<T>) t);
    }

    @OXOo.OOXIXo
    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> rangeTo(@OXOo.OOXIXo T t, @OXOo.OOXIXo T t2) {
        return new Range<>(t, t2);
    }

    @OXOo.OOXIXo
    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> X0.Oxx0IOOO<T> toClosedRange(@OXOo.OOXIXo final Range<T> range) {
        return (X0.Oxx0IOOO<T>) new X0.Oxx0IOOO<T>() { // from class: androidx.core.util.RangeKt$toClosedRange$1
            /* JADX WARN: Incorrect types in method signature: (TT;)Z */
            @Override // X0.Oxx0IOOO, X0.Oxx0xo
            public boolean contains(@OXOo.OOXIXo Comparable comparable) {
                return Oxx0IOOO.oIX0oI.oIX0oI(this, comparable);
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // X0.Oxx0IOOO
            public Comparable getEndInclusive() {
                return range.getUpper();
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // X0.Oxx0IOOO, X0.Oxx0xo
            public Comparable getStart() {
                return range.getLower();
            }

            @Override // X0.Oxx0IOOO, X0.Oxx0xo
            public boolean isEmpty() {
                return Oxx0IOOO.oIX0oI.II0xO0(this);
            }
        };
    }

    @OXOo.OOXIXo
    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> toRange(@OXOo.OOXIXo X0.Oxx0IOOO<T> oxx0IOOO) {
        return new Range<>(oxx0IOOO.getStart(), oxx0IOOO.getEndInclusive());
    }

    @OXOo.OOXIXo
    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> plus(@OXOo.OOXIXo Range<T> range, @OXOo.OOXIXo Range<T> range2) {
        return range.extend(range2);
    }
}
