package com.jd.ad.sdk.jad_it;

import androidx.annotation.NonNull;

/* loaded from: classes10.dex */
public interface jad_er<T> {

    /* loaded from: classes10.dex */
    public interface jad_an<T> {
        @NonNull
        jad_er<T> jad_an(@NonNull T t);

        @NonNull
        Class<T> jad_an();
    }

    @NonNull
    T jad_an();

    void jad_bo();
}
