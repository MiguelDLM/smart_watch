package com.facebook.internal;

import android.graphics.Bitmap;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class ImageResponse {

    @OXOo.oOoXoXO
    private final Bitmap bitmap;

    @OXOo.oOoXoXO
    private final Exception error;
    private final boolean isCachedRedirect;

    @OXOo.OOXIXo
    private final ImageRequest request;

    public ImageResponse(@OXOo.OOXIXo ImageRequest request, @OXOo.oOoXoXO Exception exc, boolean z, @OXOo.oOoXoXO Bitmap bitmap) {
        IIX0o.x0xO0oo(request, "request");
        this.request = request;
        this.error = exc;
        this.isCachedRedirect = z;
        this.bitmap = bitmap;
    }

    @OXOo.oOoXoXO
    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    @OXOo.oOoXoXO
    public final Exception getError() {
        return this.error;
    }

    @OXOo.OOXIXo
    public final ImageRequest getRequest() {
        return this.request;
    }

    public final boolean isCachedRedirect() {
        return this.isCachedRedirect;
    }
}
