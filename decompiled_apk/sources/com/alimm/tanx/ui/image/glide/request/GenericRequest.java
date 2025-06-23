package com.alimm.tanx.ui.image.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.alimm.tanx.ui.image.glide.Priority;
import com.alimm.tanx.ui.image.glide.load.Key;
import com.alimm.tanx.ui.image.glide.load.Transformation;
import com.alimm.tanx.ui.image.glide.load.data.DataFetcher;
import com.alimm.tanx.ui.image.glide.load.engine.DiskCacheStrategy;
import com.alimm.tanx.ui.image.glide.load.engine.Engine;
import com.alimm.tanx.ui.image.glide.load.engine.Resource;
import com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder;
import com.alimm.tanx.ui.image.glide.provider.LoadProvider;
import com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory;
import com.alimm.tanx.ui.image.glide.request.target.SizeReadyCallback;
import com.alimm.tanx.ui.image.glide.request.target.Target;
import com.alimm.tanx.ui.image.glide.util.LogTime;
import com.alimm.tanx.ui.image.glide.util.Util;
import java.util.Queue;
import oOxxXI.oIX0oI;
import org.apache.commons.text.ooOOo0oXI;

/* loaded from: classes.dex */
public final class GenericRequest<A, T, Z, R> implements Request, SizeReadyCallback, ResourceCallback {
    private static final Queue<GenericRequest<?, ?, ?, ?>> REQUEST_POOL = Util.createQueue(0);
    private static final String TAG = "GenericRequest";
    private static final double TO_MEGABYTE = 9.5367431640625E-7d;
    private GlideAnimationFactory<R> animationFactory;
    private Context context;
    private DiskCacheStrategy diskCacheStrategy;
    private Engine engine;
    private Drawable errorDrawable;
    private int errorResourceId;
    private Drawable fallbackDrawable;
    private int fallbackResourceId;
    private boolean isMemoryCacheable;
    private LoadProvider<A, T, Z, R> loadProvider;
    private Engine.LoadStatus loadStatus;
    private boolean loadedFromMemoryCache;
    private A model;
    private int overrideHeight;
    private int overrideWidth;
    private Drawable placeholderDrawable;
    private int placeholderResourceId;
    private Priority priority;
    private RequestCoordinator requestCoordinator;
    private RequestListener<? super A, R> requestListener;
    private Resource<?> resource;
    private Key signature;
    private float sizeMultiplier;
    private long startTime;
    private Status status;
    private final String tag = String.valueOf(hashCode());
    private Target<R> target;
    private Class<R> transcodeClass;
    private Transformation<Z> transformation;

    /* loaded from: classes.dex */
    public enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CANCELLED,
        CLEARED,
        PAUSED
    }

    private GenericRequest() {
    }

    private boolean canNotifyStatusChanged() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        if (requestCoordinator != null && !requestCoordinator.canNotifyStatusChanged(this)) {
            return false;
        }
        return true;
    }

    private boolean canSetResource() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        if (requestCoordinator != null && !requestCoordinator.canSetImage(this)) {
            return false;
        }
        return true;
    }

    private static void check(String str, Object obj, String str2) {
        if (obj == null) {
            StringBuilder sb = new StringBuilder(str);
            sb.append(" must not be null");
            if (str2 != null) {
                sb.append(", ");
                sb.append(str2);
            }
            throw new NullPointerException(sb.toString());
        }
    }

    private Drawable getErrorDrawable() {
        if (this.errorDrawable == null && this.errorResourceId > 0) {
            this.errorDrawable = this.context.getResources().getDrawable(this.errorResourceId);
        }
        return this.errorDrawable;
    }

    private Drawable getFallbackDrawable() {
        if (this.fallbackDrawable == null && this.fallbackResourceId > 0) {
            this.fallbackDrawable = this.context.getResources().getDrawable(this.fallbackResourceId);
        }
        return this.fallbackDrawable;
    }

    private Drawable getPlaceholderDrawable() {
        if (this.placeholderDrawable == null && this.placeholderResourceId > 0) {
            this.placeholderDrawable = this.context.getResources().getDrawable(this.placeholderResourceId);
        }
        return this.placeholderDrawable;
    }

    private void init(LoadProvider<A, T, Z, R> loadProvider, A a2, Key key, Context context, Priority priority, Target<R> target, float f, Drawable drawable, int i, Drawable drawable2, int i2, Drawable drawable3, int i3, RequestListener<? super A, R> requestListener, RequestCoordinator requestCoordinator, Engine engine, Transformation<Z> transformation, Class<R> cls, boolean z, GlideAnimationFactory<R> glideAnimationFactory, int i4, int i5, DiskCacheStrategy diskCacheStrategy) {
        this.loadProvider = loadProvider;
        this.model = a2;
        this.signature = key;
        this.fallbackDrawable = drawable3;
        this.fallbackResourceId = i3;
        this.context = context.getApplicationContext();
        this.priority = priority;
        this.target = target;
        this.sizeMultiplier = f;
        this.placeholderDrawable = drawable;
        this.placeholderResourceId = i;
        this.errorDrawable = drawable2;
        this.errorResourceId = i2;
        this.requestListener = requestListener;
        this.requestCoordinator = requestCoordinator;
        this.engine = engine;
        this.transformation = transformation;
        this.transcodeClass = cls;
        this.isMemoryCacheable = z;
        this.animationFactory = glideAnimationFactory;
        this.overrideWidth = i4;
        this.overrideHeight = i5;
        this.diskCacheStrategy = diskCacheStrategy;
        this.status = Status.PENDING;
        if (a2 != null) {
            check("ModelLoader", loadProvider.getModelLoader(), "try .using(ModelLoader)");
            check("Transcoder", loadProvider.getTranscoder(), "try .as*(Class).transcode(ResourceTranscoder)");
            check("Transformation", transformation, "try .transform(UnitTransformation.get())");
            if (diskCacheStrategy.cacheSource()) {
                check("SourceEncoder", loadProvider.getSourceEncoder(), "try .sourceEncoder(Encoder) or .diskCacheStrategy(NONE/RESULT)");
            } else {
                check("SourceDecoder", loadProvider.getSourceDecoder(), "try .decoder/.imageDecoder/.videoDecoder(ResourceDecoder) or .diskCacheStrategy(ALL/SOURCE)");
            }
            if (diskCacheStrategy.cacheSource() || diskCacheStrategy.cacheResult()) {
                check("CacheDecoder", loadProvider.getCacheDecoder(), "try .cacheDecoder(ResouceDecoder) or .diskCacheStrategy(NONE)");
            }
            if (diskCacheStrategy.cacheResult()) {
                check("Encoder", loadProvider.getEncoder(), "try .encode(ResourceEncoder) or .diskCacheStrategy(NONE/SOURCE)");
            }
        }
    }

    private boolean isFirstReadyResource() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        if (requestCoordinator != null && requestCoordinator.isAnyResourceSet()) {
            return false;
        }
        return true;
    }

    private void logV(String str) {
        Log.v(TAG, str + " this: " + this.tag);
    }

    private void notifyLoadSuccess() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        if (requestCoordinator != null) {
            requestCoordinator.onRequestSuccess(this);
        }
    }

    public static <A, T, Z, R> GenericRequest<A, T, Z, R> obtain(LoadProvider<A, T, Z, R> loadProvider, A a2, Key key, Context context, Priority priority, Target<R> target, float f, Drawable drawable, int i, Drawable drawable2, int i2, Drawable drawable3, int i3, RequestListener<? super A, R> requestListener, RequestCoordinator requestCoordinator, Engine engine, Transformation<Z> transformation, Class<R> cls, boolean z, GlideAnimationFactory<R> glideAnimationFactory, int i4, int i5, DiskCacheStrategy diskCacheStrategy) {
        GenericRequest<A, T, Z, R> genericRequest = (GenericRequest) REQUEST_POOL.poll();
        if (genericRequest == null) {
            genericRequest = new GenericRequest<>();
        }
        genericRequest.init(loadProvider, a2, key, context, priority, target, f, drawable, i, drawable2, i2, drawable3, i3, requestListener, requestCoordinator, engine, transformation, cls, z, glideAnimationFactory, i4, i5, diskCacheStrategy);
        return genericRequest;
    }

    private void releaseResource(Resource resource) {
        this.engine.release(resource);
        this.resource = null;
    }

    private void setErrorPlaceholder(Exception exc) {
        Drawable drawable;
        if (!canNotifyStatusChanged()) {
            return;
        }
        if (this.model == null) {
            drawable = getFallbackDrawable();
        } else {
            drawable = null;
        }
        if (drawable == null) {
            drawable = getErrorDrawable();
        }
        if (drawable == null) {
            drawable = getPlaceholderDrawable();
        }
        this.target.onLoadFailed(exc, drawable);
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public void begin() {
        this.startTime = LogTime.getLogTime();
        if (this.model == null) {
            onException(null);
            return;
        }
        this.status = Status.WAITING_FOR_SIZE;
        if (Util.isValidDimensions(this.overrideWidth, this.overrideHeight)) {
            onSizeReady(this.overrideWidth, this.overrideHeight);
        } else {
            this.target.getSize(this);
        }
        if (!isComplete() && !isFailed() && canNotifyStatusChanged()) {
            this.target.onLoadStarted(getPlaceholderDrawable());
        }
        if (Log.isLoggable(TAG, 2)) {
            StringBuilder oIX0oI2 = oIX0oI.oIX0oI("finished run method in ");
            oIX0oI2.append(LogTime.getElapsedMillis(this.startTime));
            logV(oIX0oI2.toString());
        }
    }

    public void cancel() {
        this.status = Status.CANCELLED;
        Engine.LoadStatus loadStatus = this.loadStatus;
        if (loadStatus != null) {
            loadStatus.cancel();
            this.loadStatus = null;
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public void clear() {
        Util.assertMainThread();
        Status status = this.status;
        Status status2 = Status.CLEARED;
        if (status == status2) {
            return;
        }
        cancel();
        Resource<?> resource = this.resource;
        if (resource != null) {
            releaseResource(resource);
        }
        if (canNotifyStatusChanged()) {
            this.target.onLoadCleared(getPlaceholderDrawable());
        }
        this.status = status2;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public boolean isCancelled() {
        Status status = this.status;
        if (status != Status.CANCELLED && status != Status.CLEARED) {
            return false;
        }
        return true;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public boolean isComplete() {
        if (this.status == Status.COMPLETE) {
            return true;
        }
        return false;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public boolean isFailed() {
        if (this.status == Status.FAILED) {
            return true;
        }
        return false;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public boolean isPaused() {
        if (this.status == Status.PAUSED) {
            return true;
        }
        return false;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public boolean isResourceSet() {
        return isComplete();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public boolean isRunning() {
        Status status = this.status;
        if (status != Status.RUNNING && status != Status.WAITING_FOR_SIZE) {
            return false;
        }
        return true;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.ResourceCallback
    public void onException(Exception exc) {
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "load failed", exc);
        }
        this.status = Status.FAILED;
        RequestListener<? super A, R> requestListener = this.requestListener;
        if (requestListener == null || !requestListener.onException(exc, this.model, this.target, isFirstReadyResource())) {
            setErrorPlaceholder(exc);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.request.ResourceCallback
    public void onResourceReady(Resource<?> resource) {
        if (resource == null) {
            StringBuilder oIX0oI2 = oIX0oI.oIX0oI("Expected to receive a Resource<R> with an object of ");
            oIX0oI2.append(this.transcodeClass);
            oIX0oI2.append(" inside, but instead got null.");
            onException(new Exception(oIX0oI2.toString()));
            return;
        }
        Object obj = resource.get();
        if (obj != null && this.transcodeClass.isAssignableFrom(obj.getClass())) {
            if (!canSetResource()) {
                this.engine.release(resource);
                this.resource = null;
                this.status = Status.COMPLETE;
                return;
            }
            onResourceReady(resource, obj);
            return;
        }
        this.engine.release(resource);
        this.resource = null;
        StringBuilder oIX0oI3 = oIX0oI.oIX0oI("Expected to receive an object of ");
        oIX0oI3.append(this.transcodeClass);
        oIX0oI3.append(" but instead got ");
        oIX0oI3.append(obj != null ? obj.getClass() : "");
        oIX0oI3.append("{");
        oIX0oI3.append(obj);
        oIX0oI3.append(ooOOo0oXI.f33074oOoXoXO);
        oIX0oI3.append(" inside Resource{");
        oIX0oI3.append(resource);
        oIX0oI3.append("}.");
        oIX0oI3.append(obj == null ? " To indicate failure return a null Resource object, rather than a Resource object containing null data." : "");
        onException(new Exception(oIX0oI3.toString()));
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.SizeReadyCallback
    public void onSizeReady(int i, int i2) {
        if (Log.isLoggable(TAG, 2)) {
            StringBuilder oIX0oI2 = oIX0oI.oIX0oI("Got onSizeReady in ");
            oIX0oI2.append(LogTime.getElapsedMillis(this.startTime));
            logV(oIX0oI2.toString());
        }
        if (this.status != Status.WAITING_FOR_SIZE) {
            return;
        }
        this.status = Status.RUNNING;
        int round = Math.round(this.sizeMultiplier * i);
        int round2 = Math.round(this.sizeMultiplier * i2);
        DataFetcher<T> resourceFetcher = this.loadProvider.getModelLoader().getResourceFetcher(this.model, round, round2);
        if (resourceFetcher == null) {
            StringBuilder oIX0oI3 = oIX0oI.oIX0oI("Failed to load model: '");
            oIX0oI3.append(this.model);
            oIX0oI3.append("'");
            onException(new Exception(oIX0oI3.toString()));
            return;
        }
        ResourceTranscoder<Z, R> transcoder = this.loadProvider.getTranscoder();
        if (Log.isLoggable(TAG, 2)) {
            StringBuilder oIX0oI4 = oIX0oI.oIX0oI("finished setup for calling load in ");
            oIX0oI4.append(LogTime.getElapsedMillis(this.startTime));
            logV(oIX0oI4.toString());
        }
        boolean z = true;
        this.loadedFromMemoryCache = true;
        this.loadStatus = this.engine.load(this.signature, round, round2, resourceFetcher, this.loadProvider, this.transformation, transcoder, this.priority, this.isMemoryCacheable, this.diskCacheStrategy, this);
        if (this.resource == null) {
            z = false;
        }
        this.loadedFromMemoryCache = z;
        if (Log.isLoggable(TAG, 2)) {
            StringBuilder oIX0oI5 = oIX0oI.oIX0oI("finished onSizeReady in ");
            oIX0oI5.append(LogTime.getElapsedMillis(this.startTime));
            logV(oIX0oI5.toString());
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public void pause() {
        clear();
        this.status = Status.PAUSED;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public void recycle() {
        this.loadProvider = null;
        this.model = null;
        this.context = null;
        this.target = null;
        this.placeholderDrawable = null;
        this.errorDrawable = null;
        this.fallbackDrawable = null;
        this.requestListener = null;
        this.requestCoordinator = null;
        this.transformation = null;
        this.animationFactory = null;
        this.loadedFromMemoryCache = false;
        this.loadStatus = null;
        REQUEST_POOL.offer(this);
    }

    private void onResourceReady(Resource<?> resource, R r) {
        boolean isFirstReadyResource = isFirstReadyResource();
        this.status = Status.COMPLETE;
        this.resource = resource;
        RequestListener<? super A, R> requestListener = this.requestListener;
        if (requestListener == null || !requestListener.onResourceReady(r, this.model, this.target, this.loadedFromMemoryCache, isFirstReadyResource)) {
            this.target.onResourceReady(r, this.animationFactory.build(this.loadedFromMemoryCache, isFirstReadyResource));
        }
        notifyLoadSuccess();
        if (Log.isLoggable(TAG, 2)) {
            StringBuilder oIX0oI2 = oIX0oI.oIX0oI("Resource ready in ");
            oIX0oI2.append(LogTime.getElapsedMillis(this.startTime));
            oIX0oI2.append(" size: ");
            oIX0oI2.append(resource.getSize() * TO_MEGABYTE);
            oIX0oI2.append(" fromCache: ");
            oIX0oI2.append(this.loadedFromMemoryCache);
            logV(oIX0oI2.toString());
        }
    }
}
