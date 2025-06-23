package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool;

/* loaded from: classes.dex */
public class CenterCrop extends BitmapTransformation {
    public CenterCrop(Context context) {
        super(context);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Transformation
    public String getId() {
        return "CenterCrop.com.alimm.tanx.ui.image.glide.load.resource.bitmap";
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        Bitmap.Config config;
        if (bitmap.getConfig() != null) {
            config = bitmap.getConfig();
        } else {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap bitmap2 = bitmapPool.get(i, i2, config);
        Bitmap centerCrop = TransformationUtils.centerCrop(bitmap2, bitmap, i, i2);
        if (bitmap2 != null && bitmap2 != centerCrop && !bitmapPool.put(bitmap2)) {
            bitmap2.recycle();
        }
        return centerCrop;
    }

    public CenterCrop(BitmapPool bitmapPool) {
        super(bitmapPool);
    }
}
