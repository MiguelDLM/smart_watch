package com.alimm.tanx.ui.image.glide;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.alimm.tanx.ui.image.glide.load.DecodeFormat;
import com.alimm.tanx.ui.image.glide.load.engine.Engine;
import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool;
import com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache;
import com.alimm.tanx.ui.image.glide.load.engine.prefill.BitmapPreFiller;
import com.alimm.tanx.ui.image.glide.load.engine.prefill.PreFillType;
import com.alimm.tanx.ui.image.glide.load.model.GenericLoaderFactory;
import com.alimm.tanx.ui.image.glide.load.model.GlideUrl;
import com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper;
import com.alimm.tanx.ui.image.glide.load.model.ModelLoader;
import com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory;
import com.alimm.tanx.ui.image.glide.load.model.file_descriptor.FileDescriptorFileLoader;
import com.alimm.tanx.ui.image.glide.load.model.file_descriptor.FileDescriptorResourceLoader;
import com.alimm.tanx.ui.image.glide.load.model.file_descriptor.FileDescriptorStringLoader;
import com.alimm.tanx.ui.image.glide.load.model.file_descriptor.FileDescriptorUriLoader;
import com.alimm.tanx.ui.image.glide.load.model.stream.HttpUrlGlideUrlLoader;
import com.alimm.tanx.ui.image.glide.load.model.stream.StreamByteArrayLoader;
import com.alimm.tanx.ui.image.glide.load.model.stream.StreamFileLoader;
import com.alimm.tanx.ui.image.glide.load.model.stream.StreamResourceLoader;
import com.alimm.tanx.ui.image.glide.load.model.stream.StreamStringLoader;
import com.alimm.tanx.ui.image.glide.load.model.stream.StreamUriLoader;
import com.alimm.tanx.ui.image.glide.load.model.stream.StreamUrlLoader;
import com.alimm.tanx.ui.image.glide.load.resource.bitmap.CenterCrop;
import com.alimm.tanx.ui.image.glide.load.resource.bitmap.FileDescriptorBitmapDataLoadProvider;
import com.alimm.tanx.ui.image.glide.load.resource.bitmap.FitCenter;
import com.alimm.tanx.ui.image.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageVideoDataLoadProvider;
import com.alimm.tanx.ui.image.glide.load.resource.bitmap.StreamBitmapDataLoadProvider;
import com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable;
import com.alimm.tanx.ui.image.glide.load.resource.file.StreamFileDataLoadProvider;
import com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable;
import com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawableLoadProvider;
import com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper;
import com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapperTransformation;
import com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.ImageVideoGifDrawableLoadProvider;
import com.alimm.tanx.ui.image.glide.load.resource.transcode.GifBitmapWrapperDrawableTranscoder;
import com.alimm.tanx.ui.image.glide.load.resource.transcode.GlideBitmapDrawableTranscoder;
import com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder;
import com.alimm.tanx.ui.image.glide.load.resource.transcode.TranscoderRegistry;
import com.alimm.tanx.ui.image.glide.manager.RequestManagerRetriever;
import com.alimm.tanx.ui.image.glide.module.GlideModule;
import com.alimm.tanx.ui.image.glide.module.ManifestParser;
import com.alimm.tanx.ui.image.glide.provider.DataLoadProvider;
import com.alimm.tanx.ui.image.glide.provider.DataLoadProviderRegistry;
import com.alimm.tanx.ui.image.glide.request.FutureTarget;
import com.alimm.tanx.ui.image.glide.request.Request;
import com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation;
import com.alimm.tanx.ui.image.glide.request.target.ImageViewTargetFactory;
import com.alimm.tanx.ui.image.glide.request.target.Target;
import com.alimm.tanx.ui.image.glide.request.target.ViewTarget;
import com.alimm.tanx.ui.image.glide.util.Util;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class Glide {
    private static final String TAG = "Glide";
    private static volatile Glide glide = null;
    private static boolean modulesEnabled = true;
    private final CenterCrop bitmapCenterCrop;
    private final FitCenter bitmapFitCenter;
    private final BitmapPool bitmapPool;
    private final BitmapPreFiller bitmapPreFiller;
    private final DataLoadProviderRegistry dataLoadProviderRegistry;
    private final DecodeFormat decodeFormat;
    private final GifBitmapWrapperTransformation drawableCenterCrop;
    private final GifBitmapWrapperTransformation drawableFitCenter;
    private final Engine engine;
    private final ImageViewTargetFactory imageViewTargetFactory = new ImageViewTargetFactory();
    private final GenericLoaderFactory loaderFactory;
    private final Handler mainHandler;
    private final MemoryCache memoryCache;
    private final TranscoderRegistry transcoderRegistry;

    /* loaded from: classes.dex */
    public static class ClearTarget extends ViewTarget<View, Object> {
        public ClearTarget(View view) {
            super(view);
        }

        @Override // com.alimm.tanx.ui.image.glide.request.target.BaseTarget, com.alimm.tanx.ui.image.glide.request.target.Target
        public void onLoadCleared(Drawable drawable) {
        }

        @Override // com.alimm.tanx.ui.image.glide.request.target.BaseTarget, com.alimm.tanx.ui.image.glide.request.target.Target
        public void onLoadFailed(Exception exc, Drawable drawable) {
        }

        @Override // com.alimm.tanx.ui.image.glide.request.target.BaseTarget, com.alimm.tanx.ui.image.glide.request.target.Target
        public void onLoadStarted(Drawable drawable) {
        }

        @Override // com.alimm.tanx.ui.image.glide.request.target.Target
        public void onResourceReady(Object obj, GlideAnimation<? super Object> glideAnimation) {
        }
    }

    public Glide(Engine engine, MemoryCache memoryCache, BitmapPool bitmapPool, Context context, DecodeFormat decodeFormat) {
        TranscoderRegistry transcoderRegistry = new TranscoderRegistry();
        this.transcoderRegistry = transcoderRegistry;
        this.engine = engine;
        this.bitmapPool = bitmapPool;
        this.memoryCache = memoryCache;
        this.decodeFormat = decodeFormat;
        this.loaderFactory = new GenericLoaderFactory(context);
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.bitmapPreFiller = new BitmapPreFiller(memoryCache, bitmapPool, decodeFormat);
        DataLoadProviderRegistry dataLoadProviderRegistry = new DataLoadProviderRegistry();
        this.dataLoadProviderRegistry = dataLoadProviderRegistry;
        StreamBitmapDataLoadProvider streamBitmapDataLoadProvider = new StreamBitmapDataLoadProvider(bitmapPool, decodeFormat);
        dataLoadProviderRegistry.register(InputStream.class, Bitmap.class, streamBitmapDataLoadProvider);
        FileDescriptorBitmapDataLoadProvider fileDescriptorBitmapDataLoadProvider = new FileDescriptorBitmapDataLoadProvider(bitmapPool, decodeFormat);
        dataLoadProviderRegistry.register(ParcelFileDescriptor.class, Bitmap.class, fileDescriptorBitmapDataLoadProvider);
        ImageVideoDataLoadProvider imageVideoDataLoadProvider = new ImageVideoDataLoadProvider(streamBitmapDataLoadProvider, fileDescriptorBitmapDataLoadProvider);
        dataLoadProviderRegistry.register(ImageVideoWrapper.class, Bitmap.class, imageVideoDataLoadProvider);
        GifDrawableLoadProvider gifDrawableLoadProvider = new GifDrawableLoadProvider(context, bitmapPool);
        dataLoadProviderRegistry.register(InputStream.class, GifDrawable.class, gifDrawableLoadProvider);
        dataLoadProviderRegistry.register(ImageVideoWrapper.class, GifBitmapWrapper.class, new ImageVideoGifDrawableLoadProvider(imageVideoDataLoadProvider, gifDrawableLoadProvider, bitmapPool));
        dataLoadProviderRegistry.register(InputStream.class, File.class, new StreamFileDataLoadProvider());
        register(File.class, ParcelFileDescriptor.class, new FileDescriptorFileLoader.Factory());
        register(File.class, InputStream.class, new StreamFileLoader.Factory());
        Class cls = Integer.TYPE;
        register(cls, ParcelFileDescriptor.class, new FileDescriptorResourceLoader.Factory());
        register(cls, InputStream.class, new StreamResourceLoader.Factory());
        register(Integer.class, ParcelFileDescriptor.class, new FileDescriptorResourceLoader.Factory());
        register(Integer.class, InputStream.class, new StreamResourceLoader.Factory());
        register(String.class, ParcelFileDescriptor.class, new FileDescriptorStringLoader.Factory());
        register(String.class, InputStream.class, new StreamStringLoader.Factory());
        register(Uri.class, ParcelFileDescriptor.class, new FileDescriptorUriLoader.Factory());
        register(Uri.class, InputStream.class, new StreamUriLoader.Factory());
        register(URL.class, InputStream.class, new StreamUrlLoader.Factory());
        register(GlideUrl.class, InputStream.class, new HttpUrlGlideUrlLoader.Factory());
        register(byte[].class, InputStream.class, new StreamByteArrayLoader.Factory());
        transcoderRegistry.register(Bitmap.class, GlideBitmapDrawable.class, new GlideBitmapDrawableTranscoder(context.getResources(), bitmapPool));
        transcoderRegistry.register(GifBitmapWrapper.class, GlideDrawable.class, new GifBitmapWrapperDrawableTranscoder(new GlideBitmapDrawableTranscoder(context.getResources(), bitmapPool)));
        CenterCrop centerCrop = new CenterCrop(bitmapPool);
        this.bitmapCenterCrop = centerCrop;
        this.drawableCenterCrop = new GifBitmapWrapperTransformation(bitmapPool, centerCrop);
        FitCenter fitCenter = new FitCenter(bitmapPool);
        this.bitmapFitCenter = fitCenter;
        this.drawableFitCenter = new GifBitmapWrapperTransformation(bitmapPool, fitCenter);
    }

    public static <T> ModelLoader<T, ParcelFileDescriptor> buildFileDescriptorModelLoader(Class<T> cls, Context context) {
        return buildModelLoader((Class) cls, ParcelFileDescriptor.class, context);
    }

    public static <T, Y> ModelLoader<T, Y> buildModelLoader(Class<T> cls, Class<Y> cls2, Context context) {
        if (cls == null) {
            if (!Log.isLoggable(TAG, 3)) {
                return null;
            }
            Log.d(TAG, "Unable to load null model, setting placeholder only");
            return null;
        }
        return get(context).loaderFactory.buildModelLoader(cls, cls2);
    }

    public static <T> ModelLoader<T, InputStream> buildStreamModelLoader(Class<T> cls, Context context) {
        return buildModelLoader((Class) cls, InputStream.class, context);
    }

    public static void clear(Target<?> target) {
        Util.assertMainThread();
        Request request = target.getRequest();
        if (request != null) {
            request.clear();
            target.setRequest(null);
        }
    }

    public static Glide get(Context context) {
        if (glide == null) {
            synchronized (Glide.class) {
                try {
                    if (glide == null) {
                        Context applicationContext = context.getApplicationContext();
                        GlideBuilder glideBuilder = new GlideBuilder(applicationContext);
                        List<GlideModule> parseGlideModules = parseGlideModules(applicationContext);
                        Iterator<GlideModule> it = parseGlideModules.iterator();
                        while (it.hasNext()) {
                            it.next().applyOptions(applicationContext, glideBuilder);
                        }
                        glide = glideBuilder.createGlide();
                        Iterator<GlideModule> it2 = parseGlideModules.iterator();
                        while (it2.hasNext()) {
                            it2.next().registerComponents(applicationContext, glide);
                        }
                    }
                } finally {
                }
            }
        }
        return glide;
    }

    private GenericLoaderFactory getLoaderFactory() {
        return this.loaderFactory;
    }

    public static File getPhotoCacheDir(Context context) {
        return getPhotoCacheDir(context, "image_manager_disk_cache");
    }

    @Deprecated
    public static boolean isSetup() {
        if (glide != null) {
            return true;
        }
        return false;
    }

    private static List<GlideModule> parseGlideModules(Context context) {
        if (modulesEnabled) {
            return new ManifestParser(context).parse();
        }
        return Collections.emptyList();
    }

    public static void setModulesEnabled(boolean z) {
        synchronized (Glide.class) {
            try {
                if (glide == null) {
                    modulesEnabled = z;
                } else {
                    throw new IllegalArgumentException("Glide singleton already exists.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Deprecated
    public static void setup(GlideBuilder glideBuilder) {
        if (!isSetup()) {
            glide = glideBuilder.createGlide();
            return;
        }
        throw new IllegalArgumentException("Glide is already setup, check with isSetup() first");
    }

    public static void tearDown() {
        glide = null;
        modulesEnabled = true;
    }

    public static RequestManager with(Context context) {
        return RequestManagerRetriever.get().get(context);
    }

    public <T, Z> DataLoadProvider<T, Z> buildDataProvider(Class<T> cls, Class<Z> cls2) {
        return this.dataLoadProviderRegistry.get(cls, cls2);
    }

    public <R> Target<R> buildImageViewTarget(ImageView imageView, Class<R> cls) {
        return this.imageViewTargetFactory.buildTarget(imageView, cls);
    }

    public <Z, R> ResourceTranscoder<Z, R> buildTranscoder(Class<Z> cls, Class<R> cls2) {
        return this.transcoderRegistry.get(cls, cls2);
    }

    public void clearDiskCache() {
        Util.assertBackgroundThread();
        getEngine().clearDiskCache();
    }

    public void clearMemory() {
        Util.assertMainThread();
        this.memoryCache.clearMemory();
        this.bitmapPool.clearMemory();
    }

    public CenterCrop getBitmapCenterCrop() {
        return this.bitmapCenterCrop;
    }

    public FitCenter getBitmapFitCenter() {
        return this.bitmapFitCenter;
    }

    public BitmapPool getBitmapPool() {
        return this.bitmapPool;
    }

    public DecodeFormat getDecodeFormat() {
        return this.decodeFormat;
    }

    public GifBitmapWrapperTransformation getDrawableCenterCrop() {
        return this.drawableCenterCrop;
    }

    public GifBitmapWrapperTransformation getDrawableFitCenter() {
        return this.drawableFitCenter;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public Handler getMainHandler() {
        return this.mainHandler;
    }

    public void preFillBitmapPool(PreFillType.Builder... builderArr) {
        this.bitmapPreFiller.preFill(builderArr);
    }

    public <T, Y> void register(Class<T> cls, Class<Y> cls2, ModelLoaderFactory<T, Y> modelLoaderFactory) {
        ModelLoaderFactory<T, Y> register = this.loaderFactory.register(cls, cls2, modelLoaderFactory);
        if (register != null) {
            register.teardown();
        }
    }

    public void setMemoryCategory(MemoryCategory memoryCategory) {
        Util.assertMainThread();
        this.memoryCache.setSizeMultiplier(memoryCategory.getMultiplier());
        this.bitmapPool.setSizeMultiplier(memoryCategory.getMultiplier());
    }

    public void trimMemory(int i) {
        Util.assertMainThread();
        this.memoryCache.trimMemory(i);
        this.bitmapPool.trimMemory(i);
    }

    @Deprecated
    public <T, Y> void unregister(Class<T> cls, Class<Y> cls2) {
        ModelLoaderFactory<T, Y> unregister = this.loaderFactory.unregister(cls, cls2);
        if (unregister != null) {
            unregister.teardown();
        }
    }

    public static <T> ModelLoader<T, ParcelFileDescriptor> buildFileDescriptorModelLoader(T t, Context context) {
        return buildModelLoader(t, ParcelFileDescriptor.class, context);
    }

    public static <T> ModelLoader<T, InputStream> buildStreamModelLoader(T t, Context context) {
        return buildModelLoader(t, InputStream.class, context);
    }

    public static File getPhotoCacheDir(Context context, String str) {
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            File file = new File(cacheDir, str);
            if (file.mkdirs() || (file.exists() && file.isDirectory())) {
                return file;
            }
            return null;
        }
        if (Log.isLoggable(TAG, 6)) {
            Log.e(TAG, "default disk cache dir is null");
        }
        return null;
    }

    public static RequestManager with(Activity activity) {
        return RequestManagerRetriever.get().get(activity);
    }

    public static void clear(FutureTarget<?> futureTarget) {
        futureTarget.clear();
    }

    public static RequestManager with(FragmentActivity fragmentActivity) {
        return RequestManagerRetriever.get().get(fragmentActivity);
    }

    public static <T, Y> ModelLoader<T, Y> buildModelLoader(T t, Class<Y> cls, Context context) {
        return buildModelLoader((Class) (t != null ? t.getClass() : null), (Class) cls, context);
    }

    public static void clear(View view) {
        clear(new ClearTarget(view));
    }

    @TargetApi(11)
    public static RequestManager with(Fragment fragment) {
        return RequestManagerRetriever.get().get(fragment);
    }

    public static RequestManager with(androidx.fragment.app.Fragment fragment) {
        return RequestManagerRetriever.get().get(fragment);
    }
}
