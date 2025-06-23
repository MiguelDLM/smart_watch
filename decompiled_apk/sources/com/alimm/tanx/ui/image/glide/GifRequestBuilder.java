package com.alimm.tanx.ui.image.glide;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import com.alimm.tanx.ui.image.glide.load.Encoder;
import com.alimm.tanx.ui.image.glide.load.Key;
import com.alimm.tanx.ui.image.glide.load.ResourceDecoder;
import com.alimm.tanx.ui.image.glide.load.ResourceEncoder;
import com.alimm.tanx.ui.image.glide.load.Transformation;
import com.alimm.tanx.ui.image.glide.load.engine.DiskCacheStrategy;
import com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapTransformation;
import com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable;
import com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawableTransformation;
import com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder;
import com.alimm.tanx.ui.image.glide.provider.LoadProvider;
import com.alimm.tanx.ui.image.glide.request.RequestListener;
import com.alimm.tanx.ui.image.glide.request.animation.DrawableCrossFadeFactory;
import com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory;
import com.alimm.tanx.ui.image.glide.request.animation.ViewPropertyAnimation;
import java.io.File;
import java.io.InputStream;

/* loaded from: classes.dex */
public class GifRequestBuilder<ModelType> extends GenericRequestBuilder<ModelType, InputStream, GifDrawable, GifDrawable> implements BitmapOptions, DrawableOptions {
    public GifRequestBuilder(LoadProvider<ModelType, InputStream, GifDrawable, GifDrawable> loadProvider, Class<GifDrawable> cls, GenericRequestBuilder<ModelType, ?, ?, ?> genericRequestBuilder) {
        super(loadProvider, cls, genericRequestBuilder);
    }

    private GifDrawableTransformation[] toGifTransformations(Transformation<Bitmap>[] transformationArr) {
        GifDrawableTransformation[] gifDrawableTransformationArr = new GifDrawableTransformation[transformationArr.length];
        for (int i = 0; i < transformationArr.length; i++) {
            gifDrawableTransformationArr[i] = new GifDrawableTransformation(transformationArr[i], this.glide.getBitmapPool());
        }
        return gifDrawableTransformationArr;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public void applyCenterCrop() {
        centerCrop();
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public void applyFitCenter() {
        fitCenter();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public /* bridge */ /* synthetic */ GenericRequestBuilder load(Object obj) {
        return load((GifRequestBuilder<ModelType>) obj);
    }

    public GifRequestBuilder<ModelType> transformFrame(BitmapTransformation... bitmapTransformationArr) {
        return transform((Transformation<GifDrawable>[]) toGifTransformations(bitmapTransformationArr));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> cacheDecoder(ResourceDecoder<File, GifDrawable> resourceDecoder) {
        super.cacheDecoder((ResourceDecoder) resourceDecoder);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.BitmapOptions
    public GifRequestBuilder<ModelType> centerCrop() {
        return transformFrame(this.glide.getBitmapCenterCrop());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> decoder(ResourceDecoder<InputStream, GifDrawable> resourceDecoder) {
        super.decoder((ResourceDecoder) resourceDecoder);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> diskCacheStrategy(DiskCacheStrategy diskCacheStrategy) {
        super.diskCacheStrategy(diskCacheStrategy);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> dontAnimate() {
        super.dontAnimate();
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> dontTransform() {
        super.dontTransform();
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> encoder(ResourceEncoder<GifDrawable> resourceEncoder) {
        super.encoder((ResourceEncoder) resourceEncoder);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.BitmapOptions
    public GifRequestBuilder<ModelType> fitCenter() {
        return transformFrame(this.glide.getBitmapFitCenter());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> listener(RequestListener<? super ModelType, GifDrawable> requestListener) {
        super.listener((RequestListener) requestListener);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> load(ModelType modeltype) {
        super.load((GifRequestBuilder<ModelType>) modeltype);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> override(int i, int i2) {
        super.override(i, i2);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> priority(Priority priority) {
        super.priority(priority);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> signature(Key key) {
        super.signature(key);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> sizeMultiplier(float f) {
        super.sizeMultiplier(f);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> skipMemoryCache(boolean z) {
        super.skipMemoryCache(z);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> sourceEncoder(Encoder<InputStream> encoder) {
        super.sourceEncoder((Encoder) encoder);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> transcoder(ResourceTranscoder<GifDrawable, GifDrawable> resourceTranscoder) {
        super.transcoder((ResourceTranscoder) resourceTranscoder);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> transform(Transformation<GifDrawable>... transformationArr) {
        super.transform((Transformation[]) transformationArr);
        return this;
    }

    public GifRequestBuilder<ModelType> transformFrame(Transformation<Bitmap>... transformationArr) {
        return transform((Transformation<GifDrawable>[]) toGifTransformations(transformationArr));
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    /* renamed from: clone */
    public GifRequestBuilder<ModelType> mo43clone() {
        return (GifRequestBuilder) super.mo43clone();
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> error(int i) {
        super.error(i);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> fallback(Drawable drawable) {
        super.fallback(drawable);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> placeholder(int i) {
        super.placeholder(i);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> thumbnail(GenericRequestBuilder<?, ?, ?, GifDrawable> genericRequestBuilder) {
        super.thumbnail((GenericRequestBuilder) genericRequestBuilder);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> error(Drawable drawable) {
        super.error(drawable);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> fallback(int i) {
        super.fallback(i);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> placeholder(Drawable drawable) {
        super.placeholder(drawable);
        return this;
    }

    public GifRequestBuilder<ModelType> thumbnail(GifRequestBuilder<?> gifRequestBuilder) {
        super.thumbnail((GenericRequestBuilder) gifRequestBuilder);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> animate(int i) {
        super.animate(i);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.DrawableOptions
    public GifRequestBuilder<ModelType> crossFade() {
        super.animate((GlideAnimationFactory) new DrawableCrossFadeFactory());
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> thumbnail(float f) {
        super.thumbnail(f);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    @Deprecated
    public GifRequestBuilder<ModelType> animate(Animation animation) {
        super.animate(animation);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.DrawableOptions
    public GifRequestBuilder<ModelType> crossFade(int i) {
        super.animate((GlideAnimationFactory) new DrawableCrossFadeFactory(i));
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> animate(ViewPropertyAnimation.Animator animator) {
        super.animate(animator);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.DrawableOptions
    @Deprecated
    public GifRequestBuilder<ModelType> crossFade(Animation animation, int i) {
        super.animate((GlideAnimationFactory) new DrawableCrossFadeFactory(animation, i));
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public GifRequestBuilder<ModelType> animate(GlideAnimationFactory<GifDrawable> glideAnimationFactory) {
        super.animate((GlideAnimationFactory) glideAnimationFactory);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.DrawableOptions
    public GifRequestBuilder<ModelType> crossFade(int i, int i2) {
        super.animate((GlideAnimationFactory) new DrawableCrossFadeFactory(this.context, i, i2));
        return this;
    }
}
