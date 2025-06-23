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
import com.alimm.tanx.ui.image.glide.load.Transformation;
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
import java.util.List;

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

    public static class ClearTarget extends ViewTarget<View, Object> {
        public ClearTarget(View view) {
            super(view);
        }

        public void onLoadCleared(Drawable drawable) {
        }

        public void onLoadFailed(Exception exc, Drawable drawable) {
        }

        public void onLoadStarted(Drawable drawable) {
        }

        public void onResourceReady(Object obj, GlideAnimation<? super Object> glideAnimation) {
        }
    }

    public Glide(Engine engine2, MemoryCache memoryCache2, BitmapPool bitmapPool2, Context context, DecodeFormat decodeFormat2) {
        TranscoderRegistry transcoderRegistry2 = new TranscoderRegistry();
        this.transcoderRegistry = transcoderRegistry2;
        this.engine = engine2;
        this.bitmapPool = bitmapPool2;
        this.memoryCache = memoryCache2;
        this.decodeFormat = decodeFormat2;
        this.loaderFactory = new GenericLoaderFactory(context);
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.bitmapPreFiller = new BitmapPreFiller(memoryCache2, bitmapPool2, decodeFormat2);
        DataLoadProviderRegistry dataLoadProviderRegistry2 = new DataLoadProviderRegistry();
        this.dataLoadProviderRegistry = dataLoadProviderRegistry2;
        StreamBitmapDataLoadProvider streamBitmapDataLoadProvider = new StreamBitmapDataLoadProvider(bitmapPool2, decodeFormat2);
        Class<InputStream> cls = InputStream.class;
        Class<Bitmap> cls2 = Bitmap.class;
        dataLoadProviderRegistry2.register(cls, cls2, streamBitmapDataLoadProvider);
        FileDescriptorBitmapDataLoadProvider fileDescriptorBitmapDataLoadProvider = new FileDescriptorBitmapDataLoadProvider(bitmapPool2, decodeFormat2);
        Class<ParcelFileDescriptor> cls3 = ParcelFileDescriptor.class;
        dataLoadProviderRegistry2.register(cls3, cls2, fileDescriptorBitmapDataLoadProvider);
        ImageVideoDataLoadProvider imageVideoDataLoadProvider = new ImageVideoDataLoadProvider(streamBitmapDataLoadProvider, fileDescriptorBitmapDataLoadProvider);
        Class<ImageVideoWrapper> cls4 = ImageVideoWrapper.class;
        dataLoadProviderRegistry2.register(cls4, cls2, imageVideoDataLoadProvider);
        GifDrawableLoadProvider gifDrawableLoadProvider = new GifDrawableLoadProvider(context, bitmapPool2);
        dataLoadProviderRegistry2.register(cls, GifDrawable.class, gifDrawableLoadProvider);
        ImageVideoGifDrawableLoadProvider imageVideoGifDrawableLoadProvider = new ImageVideoGifDrawableLoadProvider(imageVideoDataLoadProvider, gifDrawableLoadProvider, bitmapPool2);
        Class<GifBitmapWrapper> cls5 = GifBitmapWrapper.class;
        dataLoadProviderRegistry2.register(cls4, cls5, imageVideoGifDrawableLoadProvider);
        Class<File> cls6 = File.class;
        dataLoadProviderRegistry2.register(cls, cls6, new StreamFileDataLoadProvider());
        register(cls6, cls3, new FileDescriptorFileLoader.Factory());
        register(cls6, cls, new StreamFileLoader.Factory());
        Class cls7 = Integer.TYPE;
        register(cls7, cls3, new FileDescriptorResourceLoader.Factory());
        register(cls7, cls, new StreamResourceLoader.Factory());
        Class<Integer> cls8 = Integer.class;
        register(cls8, cls3, new FileDescriptorResourceLoader.Factory());
        register(cls8, cls, new StreamResourceLoader.Factory());
        Class<String> cls9 = String.class;
        register(cls9, cls3, new FileDescriptorStringLoader.Factory());
        register(cls9, cls, new StreamStringLoader.Factory());
        Class<Uri> cls10 = Uri.class;
        register(cls10, cls3, new FileDescriptorUriLoader.Factory());
        register(cls10, cls, new StreamUriLoader.Factory());
        register(URL.class, cls, new StreamUrlLoader.Factory());
        register(GlideUrl.class, cls, new HttpUrlGlideUrlLoader.Factory());
        register(byte[].class, cls, new StreamByteArrayLoader.Factory());
        transcoderRegistry2.register(cls2, GlideBitmapDrawable.class, new GlideBitmapDrawableTranscoder(context.getResources(), bitmapPool2));
        transcoderRegistry2.register(cls5, GlideDrawable.class, new GifBitmapWrapperDrawableTranscoder(new GlideBitmapDrawableTranscoder(context.getResources(), bitmapPool2)));
        CenterCrop centerCrop = new CenterCrop(bitmapPool2);
        this.bitmapCenterCrop = centerCrop;
        this.drawableCenterCrop = new GifBitmapWrapperTransformation(bitmapPool2, (Transformation<Bitmap>) centerCrop);
        FitCenter fitCenter = new FitCenter(bitmapPool2);
        this.bitmapFitCenter = fitCenter;
        this.drawableFitCenter = new GifBitmapWrapperTransformation(bitmapPool2, (Transformation<Bitmap>) fitCenter);
    }

    public static <T> ModelLoader<T, ParcelFileDescriptor> buildFileDescriptorModelLoader(Class<T> cls, Context context) {
        return buildModelLoader(cls, ParcelFileDescriptor.class, context);
    }

    public static <T, Y> ModelLoader<T, Y> buildModelLoader(Class<T> cls, Class<Y> cls2, Context context) {
        if (cls != null) {
            return get(context).loaderFactory.buildModelLoader(cls, cls2);
        }
        if (!Log.isLoggable(TAG, 3)) {
            return null;
        }
        Log.d(TAG, "Unable to load null model, setting placeholder only");
        return null;
    }

    public static <T> ModelLoader<T, InputStream> buildStreamModelLoader(Class<T> cls, Context context) {
        return buildModelLoader(cls, InputStream.class, context);
    }

    public static void clear(Target<?> target) {
        Util.assertMainThread();
        Request request = target.getRequest();
        if (request != null) {
            request.clear();
            target.setRequest((Request) null);
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
                        for (GlideModule applyOptions : parseGlideModules) {
                            applyOptions.applyOptions(applicationContext, glideBuilder);
                        }
                        glide = glideBuilder.createGlide();
                        for (GlideModule registerComponents : parseGlideModules) {
                            registerComponents.registerComponents(applicationContext, glide);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
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
        ModelLoaderFactory<Y, Y> unregister = this.loaderFactory.unregister(cls, cls2);
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
        return buildModelLoader(t != null ? t.getClass() : null, cls, context);
    }

    public static void clear(View view) {
        clear((Target<?>) new ClearTarget(view));
    }

    @TargetApi(11)
    public static RequestManager with(Fragment fragment) {
        return RequestManagerRetriever.get().get(fragment);
    }

    public static RequestManager with(androidx.fragment.app.Fragment fragment) {
        return RequestManagerRetriever.get().get(fragment);
    }
}
