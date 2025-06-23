package com.baidu.mapapi.map;

import android.os.Bundle;
import com.facebook.appevents.internal.ViewHierarchyConstants;

/* loaded from: classes7.dex */
public final class Stroke {
    public final int color;
    public final int strokeWidth;

    public Stroke(int i, int i2) {
        this.strokeWidth = i <= 0 ? 5 : i;
        this.color = i2;
    }

    public Bundle a(Bundle bundle) {
        bundle.putInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.strokeWidth);
        Overlay.a(this.color, bundle);
        return bundle;
    }
}
