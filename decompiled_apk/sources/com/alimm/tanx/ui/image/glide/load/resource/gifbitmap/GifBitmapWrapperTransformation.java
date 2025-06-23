package com.alimm.tanx.ui.image.glide.load.resource.gifbitmap;

import android.graphics.Bitmap;
import com.alimm.tanx.ui.image.glide.load.Transformation;
import com.alimm.tanx.ui.image.glide.load.engine.Resource;
import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool;
import com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable;
import com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawableTransformation;

/* loaded from: classes.dex */
public class GifBitmapWrapperTransformation implements Transformation<GifBitmapWrapper> {
    private final Transformation<Bitmap> bitmapTransformation;
    private final Transformation<GifDrawable> gifDataTransformation;

    public GifBitmapWrapperTransformation(BitmapPool bitmapPool, Transformation<Bitmap> transformation) {
        GifDrawableTransformation gifDrawableTransformation = new GifDrawableTransformation(transformation, bitmapPool);
        this.bitmapTransformation = transformation;
        this.gifDataTransformation = gifDrawableTransformation;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Transformation
    public String getId() {
        return this.bitmapTransformation.getId();
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Transformation
    public Resource<GifBitmapWrapper> transform(Resource<GifBitmapWrapper> resource, int i, int i2) {
        Transformation<GifDrawable> transformation;
        Transformation<Bitmap> transformation2;
        Resource<Bitmap> bitmapResource = resource.get().getBitmapResource();
        Resource<GifDrawable> gifResource = resource.get().getGifResource();
        if (bitmapResource != null && (transformation2 = this.bitmapTransformation) != null) {
            Resource<Bitmap> transform = transformation2.transform(bitmapResource, i, i2);
            if (!bitmapResource.equals(transform)) {
                return new GifBitmapWrapperResource(new GifBitmapWrapper(transform, resource.get().getGifResource()));
            }
            return resource;
        }
        if (gifResource != null && (transformation = this.gifDataTransformation) != null) {
            Resource<GifDrawable> transform2 = transformation.transform(gifResource, i, i2);
            if (!gifResource.equals(transform2)) {
                return new GifBitmapWrapperResource(new GifBitmapWrapper(resource.get().getBitmapResource(), transform2));
            }
            return resource;
        }
        return resource;
    }

    public GifBitmapWrapperTransformation(Transformation<Bitmap> transformation, Transformation<GifDrawable> transformation2) {
        this.bitmapTransformation = transformation;
        this.gifDataTransformation = transformation2;
    }
}
