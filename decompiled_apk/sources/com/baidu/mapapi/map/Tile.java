package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;

/* loaded from: classes7.dex */
public class Tile {
    public final byte[] data;
    public final int height;
    public final int width;

    public Tile(int i, int i2, byte[] bArr) {
        this.width = i;
        this.height = i2;
        this.data = bArr;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(RouteGuideParams.RGKey.ExpandMap.ImageWidth, this.width);
        bundle.putInt(RouteGuideParams.RGKey.ExpandMap.ImageHeight, this.height);
        bundle.putByteArray("image_data", this.data);
        return bundle;
    }
}
