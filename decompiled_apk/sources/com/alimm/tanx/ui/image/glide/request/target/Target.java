package com.alimm.tanx.ui.image.glide.request.target;

import android.graphics.drawable.Drawable;
import com.alimm.tanx.ui.image.glide.manager.LifecycleListener;
import com.alimm.tanx.ui.image.glide.request.Request;
import com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation;

/* loaded from: classes.dex */
public interface Target<R> extends LifecycleListener {
    public static final int SIZE_ORIGINAL = Integer.MIN_VALUE;

    Request getRequest();

    void getSize(SizeReadyCallback sizeReadyCallback);

    void onLoadCleared(Drawable drawable);

    void onLoadFailed(Exception exc, Drawable drawable);

    void onLoadStarted(Drawable drawable);

    void onResourceReady(R r, GlideAnimation<? super R> glideAnimation);

    void setRequest(Request request);
}
