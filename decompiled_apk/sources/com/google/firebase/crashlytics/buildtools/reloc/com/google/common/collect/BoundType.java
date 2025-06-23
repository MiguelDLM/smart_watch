package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtCompatible;

@GwtCompatible
/* loaded from: classes10.dex */
public enum BoundType {
    OPEN(false),
    CLOSED(true);

    final boolean inclusive;

    BoundType(boolean z) {
        this.inclusive = z;
    }

    public static BoundType forBoolean(boolean z) {
        if (z) {
            return CLOSED;
        }
        return OPEN;
    }

    public BoundType flip() {
        return forBoolean(!this.inclusive);
    }
}
