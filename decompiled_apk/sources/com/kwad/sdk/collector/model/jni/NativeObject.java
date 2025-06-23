package com.kwad.sdk.collector.model.jni;

import androidx.annotation.Keep;

@Keep
/* loaded from: classes11.dex */
public abstract class NativeObject {

    @Keep
    protected long mPtr;

    public abstract void destroy();

    public long getNativePtr() {
        return this.mPtr;
    }
}
