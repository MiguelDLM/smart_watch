package com.jd.ad.sdk.jad_ir;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes10.dex */
public interface jad_fs {
    jad_fs jad_an(@Nullable String str);

    void jad_an();

    void jad_an(int i, @Nullable String str, @Nullable String str2, @Nullable Throwable th);

    void jad_an(@NonNull jad_bo jad_boVar);

    void jad_an(@Nullable Object obj);

    void jad_an(@NonNull String str, @Nullable Object... objArr);

    void jad_an(@Nullable Throwable th, @NonNull String str, @Nullable Object... objArr);

    void jad_bo(@Nullable String str);

    void jad_bo(@NonNull String str, @Nullable Object... objArr);

    void jad_cp(@Nullable String str);

    void jad_cp(@NonNull String str, @Nullable Object... objArr);

    void jad_dq(@NonNull String str, @Nullable Object... objArr);

    void jad_er(@NonNull String str, @Nullable Object... objArr);
}
