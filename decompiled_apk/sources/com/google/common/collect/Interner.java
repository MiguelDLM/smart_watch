package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotMock;

@DoNotMock("Use Interners.new*Interner")
@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes9.dex */
public interface Interner<E> {
    @CanIgnoreReturnValue
    E intern(E e);
}
