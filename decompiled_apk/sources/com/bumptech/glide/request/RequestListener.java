package com.bumptech.glide.request;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.Target;

/* loaded from: classes8.dex */
public interface RequestListener<R> {
    boolean onLoadFailed(@Nullable GlideException glideException, @Nullable Object obj, @NonNull Target<R> target, boolean z);

    boolean onResourceReady(@NonNull R r, @NonNull Object obj, Target<R> target, @NonNull DataSource dataSource, boolean z);
}
