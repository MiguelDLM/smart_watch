package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.DoNotMock;

@DoNotMock("Use an instance of one of the Finalizable*Reference classes")
@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
public interface FinalizableReference {
    void finalizeReferent();
}
