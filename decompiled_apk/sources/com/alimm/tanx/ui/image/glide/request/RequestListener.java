package com.alimm.tanx.ui.image.glide.request;

import com.alimm.tanx.ui.image.glide.request.target.Target;

/* loaded from: classes.dex */
public interface RequestListener<T, R> {
    boolean onException(Exception exc, T t, Target<R> target, boolean z);

    boolean onResourceReady(R r, T t, Target<R> target, boolean z, boolean z2);
}
