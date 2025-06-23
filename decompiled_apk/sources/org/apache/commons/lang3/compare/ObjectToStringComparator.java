package org.apache.commons.lang3.compare;

import java.io.Serializable;
import java.util.Comparator;

/* loaded from: classes6.dex */
public final class ObjectToStringComparator implements Comparator<Object>, Serializable {
    public static final ObjectToStringComparator INSTANCE = new ObjectToStringComparator();
    private static final long serialVersionUID = 1;

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return 0;
        }
        if (obj == null) {
            return 1;
        }
        if (obj2 == null) {
            return -1;
        }
        String obj3 = obj.toString();
        String obj4 = obj2.toString();
        if (obj3 == null && obj4 == null) {
            return 0;
        }
        if (obj3 == null) {
            return 1;
        }
        if (obj4 == null) {
            return -1;
        }
        return obj3.compareTo(obj4);
    }
}
