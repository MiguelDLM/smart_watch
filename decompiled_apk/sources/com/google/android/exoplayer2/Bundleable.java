package com.google.android.exoplayer2;

import android.os.Bundle;

/* loaded from: classes9.dex */
public interface Bundleable {

    /* loaded from: classes9.dex */
    public interface Creator<T extends Bundleable> {
        T fromBundle(Bundle bundle);
    }

    Bundle toBundle();
}
