package androidx.core.util;

import OXOo.OOXIXo;
import android.annotation.SuppressLint;
import android.util.Pair;

public final class PairKt {
    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F component1(@OOXIXo Pair<F, S> pair) {
        return pair.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S component2(@OOXIXo Pair<F, S> pair) {
        return pair.second;
    }

    @OOXIXo
    public static final <F, S> Pair<F, S> toAndroidPair(@OOXIXo kotlin.Pair<? extends F, ? extends S> pair) {
        return new Pair<>(pair.getFirst(), pair.getSecond());
    }

    @OOXIXo
    public static final <F, S> Pair<F, S> toAndroidXPair(@OOXIXo kotlin.Pair<? extends F, ? extends S> pair) {
        return new Pair<>(pair.getFirst(), pair.getSecond());
    }

    @OOXIXo
    public static final <F, S> kotlin.Pair<F, S> toKotlinPair(@OOXIXo Pair<F, S> pair) {
        return new kotlin.Pair<>(pair.first, pair.second);
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F component1(@OOXIXo Pair<F, S> pair) {
        return pair.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S component2(@OOXIXo Pair<F, S> pair) {
        return pair.second;
    }

    @OOXIXo
    public static final <F, S> kotlin.Pair<F, S> toKotlinPair(@OOXIXo Pair<F, S> pair) {
        return new kotlin.Pair<>(pair.first, pair.second);
    }
}
