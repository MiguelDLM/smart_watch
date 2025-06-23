package org.apache.commons.lang3;

import java.io.Serializable;
import java.util.Comparator;

/* loaded from: classes6.dex */
public final class Range<T> implements Serializable {
    private static final long serialVersionUID = 1;
    private final Comparator<T> comparator;
    private transient int hashCode;
    private final T maximum;
    private final T minimum;
    private transient String toString;

    /* loaded from: classes6.dex */
    public enum ComparableComparator implements Comparator {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    private Range(T t, T t2, Comparator<T> comparator) {
        if (t != null && t2 != null) {
            if (comparator == null) {
                this.comparator = ComparableComparator.INSTANCE;
            } else {
                this.comparator = comparator;
            }
            if (this.comparator.compare(t, t2) < 1) {
                this.minimum = t;
                this.maximum = t2;
                return;
            } else {
                this.minimum = t2;
                this.maximum = t;
                return;
            }
        }
        throw new IllegalArgumentException("Elements in a range must not be null: element1=" + t + ", element2=" + t2);
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/lang/Comparable<TT;>;>(TT;TT;)Lorg/apache/commons/lang3/Range<TT;>; */
    public static Range between(Comparable comparable, Comparable comparable2) {
        return between(comparable, comparable2, null);
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/lang/Comparable<TT;>;>(TT;)Lorg/apache/commons/lang3/Range<TT;>; */
    public static Range is(Comparable comparable) {
        return between(comparable, comparable, null);
    }

    public boolean contains(T t) {
        if (t == null || this.comparator.compare(t, this.minimum) <= -1 || this.comparator.compare(t, this.maximum) >= 1) {
            return false;
        }
        return true;
    }

    public boolean containsRange(Range<T> range) {
        if (range == null || !contains(range.minimum) || !contains(range.maximum)) {
            return false;
        }
        return true;
    }

    public int elementCompareTo(T t) {
        xoIxX.xo0x(t, "Element is null", new Object[0]);
        if (isAfter(t)) {
            return -1;
        }
        if (!isBefore(t)) {
            return 0;
        }
        return 1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != Range.class) {
            return false;
        }
        Range range = (Range) obj;
        if (this.minimum.equals(range.minimum) && this.maximum.equals(range.maximum)) {
            return true;
        }
        return false;
    }

    public T fit(T t) {
        xoIxX.xo0x(t, "element", new Object[0]);
        if (isAfter(t)) {
            return this.minimum;
        }
        if (isBefore(t)) {
            return this.maximum;
        }
        return t;
    }

    public Comparator<T> getComparator() {
        return this.comparator;
    }

    public T getMaximum() {
        return this.maximum;
    }

    public T getMinimum() {
        return this.minimum;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            int hashCode = this.maximum.hashCode() + ((((629 + Range.class.hashCode()) * 37) + this.minimum.hashCode()) * 37);
            this.hashCode = hashCode;
            return hashCode;
        }
        return i;
    }

    public Range<T> intersectionWith(Range<T> range) {
        T t;
        T t2;
        if (isOverlappedBy(range)) {
            if (equals(range)) {
                return this;
            }
            if (getComparator().compare(this.minimum, range.minimum) < 0) {
                t = range.minimum;
            } else {
                t = this.minimum;
            }
            if (getComparator().compare(this.maximum, range.maximum) < 0) {
                t2 = this.maximum;
            } else {
                t2 = range.maximum;
            }
            return between(t, t2, getComparator());
        }
        throw new IllegalArgumentException(String.format("Cannot calculate intersection with non-overlapping range %s", range));
    }

    public boolean isAfter(T t) {
        if (t == null || this.comparator.compare(t, this.minimum) >= 0) {
            return false;
        }
        return true;
    }

    public boolean isAfterRange(Range<T> range) {
        if (range == null) {
            return false;
        }
        return isAfter(range.maximum);
    }

    public boolean isBefore(T t) {
        if (t == null || this.comparator.compare(t, this.maximum) <= 0) {
            return false;
        }
        return true;
    }

    public boolean isBeforeRange(Range<T> range) {
        if (range == null) {
            return false;
        }
        return isBefore(range.minimum);
    }

    public boolean isEndedBy(T t) {
        if (t == null || this.comparator.compare(t, this.maximum) != 0) {
            return false;
        }
        return true;
    }

    public boolean isNaturalOrdering() {
        if (this.comparator == ComparableComparator.INSTANCE) {
            return true;
        }
        return false;
    }

    public boolean isOverlappedBy(Range<T> range) {
        if (range == null) {
            return false;
        }
        if (!range.contains(this.minimum) && !range.contains(this.maximum) && !contains(range.minimum)) {
            return false;
        }
        return true;
    }

    public boolean isStartedBy(T t) {
        if (t == null || this.comparator.compare(t, this.minimum) != 0) {
            return false;
        }
        return true;
    }

    public String toString() {
        if (this.toString == null) {
            this.toString = "[" + this.minimum + ".." + this.maximum + "]";
        }
        return this.toString;
    }

    public static <T> Range<T> between(T t, T t2, Comparator<T> comparator) {
        return new Range<>(t, t2, comparator);
    }

    public static <T> Range<T> is(T t, Comparator<T> comparator) {
        return between(t, t, comparator);
    }

    public String toString(String str) {
        return String.format(str, this.minimum, this.maximum, this.comparator);
    }
}
