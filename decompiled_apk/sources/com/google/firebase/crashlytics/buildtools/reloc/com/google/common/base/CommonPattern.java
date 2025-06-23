package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtCompatible;

@GwtCompatible
/* loaded from: classes10.dex */
abstract class CommonPattern {
    public abstract boolean equals(Object obj);

    public abstract int flags();

    public abstract int hashCode();

    public abstract CommonMatcher matcher(CharSequence charSequence);

    public abstract String pattern();

    public abstract String toString();
}
