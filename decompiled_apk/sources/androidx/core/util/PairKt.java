package androidx.core.util;

import android.annotation.SuppressLint;

/* loaded from: classes.dex */
public final class PairKt {
    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F component1(@OXOo.OOXIXo Pair<F, S> pair) {
        return pair.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S component2(@OXOo.OOXIXo Pair<F, S> pair) {
        return pair.second;
    }

    @OXOo.OOXIXo
    public static final <F, S> android.util.Pair<F, S> toAndroidPair(@OXOo.OOXIXo kotlin.Pair<? extends F, ? extends S> pair) {
        return new android.util.Pair<>(pair.getFirst(), pair.getSecond());
    }

    @OXOo.OOXIXo
    public static final <F, S> Pair<F, S> toAndroidXPair(@OXOo.OOXIXo kotlin.Pair<? extends F, ? extends S> pair) {
        return new Pair<>(pair.getFirst(), pair.getSecond());
    }

    @OXOo.OOXIXo
    public static final <F, S> kotlin.Pair<F, S> toKotlinPair(@OXOo.OOXIXo Pair<F, S> pair) {
        return new kotlin.Pair<>(pair.first, pair.second);
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F component1(@OXOo.OOXIXo android.util.Pair<F, S> pair) {
        return (F) pair.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S component2(@OXOo.OOXIXo android.util.Pair<F, S> pair) {
        return (S) pair.second;
    }

    @OXOo.OOXIXo
    public static final <F, S> kotlin.Pair<F, S> toKotlinPair(@OXOo.OOXIXo android.util.Pair<F, S> pair) {
        return new kotlin.Pair<>(pair.first, pair.second);
    }
}
