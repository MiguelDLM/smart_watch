package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
public interface Predicate<T> {
    @CanIgnoreReturnValue
    boolean apply(@ParametricNullness T t);

    boolean equals(@CheckForNull Object obj);
}
