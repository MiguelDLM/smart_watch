package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.Iterator;

/* loaded from: classes10.dex */
public final /* synthetic */ class xxxoo0XI {
    public static void I0Io(RangeSet rangeSet, Iterable iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            rangeSet.remove((Range) it.next());
        }
    }

    public static boolean II0xO0(RangeSet rangeSet, Iterable iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            if (!rangeSet.encloses((Range) it.next())) {
                return false;
            }
        }
        return true;
    }

    public static void oIX0oI(RangeSet rangeSet, Iterable iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            rangeSet.add((Range) it.next());
        }
    }
}
