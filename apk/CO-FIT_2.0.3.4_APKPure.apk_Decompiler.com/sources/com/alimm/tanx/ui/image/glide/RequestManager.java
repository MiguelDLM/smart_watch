package com.alimm.tanx.ui.image.glide;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import com.alimm.tanx.ui.image.glide.load.Key;
import com.alimm.tanx.ui.image.glide.load.engine.DiskCacheStrategy;
import com.alimm.tanx.ui.image.glide.load.model.ModelLoader;
import com.alimm.tanx.ui.image.glide.load.model.file_descriptor.FileDescriptorModelLoader;
import com.alimm.tanx.ui.image.glide.load.model.stream.MediaStoreStreamLoader;
import com.alimm.tanx.ui.image.glide.load.model.stream.StreamByteArrayLoader;
import com.alimm.tanx.ui.image.glide.load.model.stream.StreamModelLoader;
import com.alimm.tanx.ui.image.glide.manager.ConnectivityMonitor;
import com.alimm.tanx.ui.image.glide.manager.ConnectivityMonitorFactory;
import com.alimm.tanx.ui.image.glide.manager.Lifecycle;
import com.alimm.tanx.ui.image.glide.manager.LifecycleListener;
import com.alimm.tanx.ui.image.glide.manager.RequestManagerTreeNode;
import com.alimm.tanx.ui.image.glide.manager.RequestTracker;
import com.alimm.tanx.ui.image.glide.signature.ApplicationVersionSignature;
import com.alimm.tanx.ui.image.glide.signature.MediaStoreSignature;
import com.alimm.tanx.ui.image.glide.signature.StringSignature;
import com.alimm.tanx.ui.image.glide.util.Util;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.UUID;

public class RequestManager implements LifecycleListener {
    /* access modifiers changed from: private */
    public final Context context;
    /* access modifiers changed from: private */
    public final Glide glide;
    /* access modifiers changed from: private */
    public final Lifecycle lifecycle;
    /* access modifiers changed from: private */
    public DefaultOptions options;
    /* access modifiers changed from: private */
    public final OptionsApplier optionsApplier;
    /* access modifiers changed from: private */
    public final RequestTracker requestTracker;
    private final RequestManagerTreeNode treeNode;

    public interface DefaultOptions {
        <T> void apply(GenericRequestBuilder<T, ?, ?, ?> genericRequestBuilder);
    }

    public final class ImageModelRequest<T> {
        private final ModelLoader<T, InputStream> loader;

        public ImageModelRequest(ModelLoader<T, InputStream> modelLoader) {
            this.loader = modelLoader;
        }

        public DrawableTypeRequest<T> from(Class<T> cls) {
            return (DrawableTypeRequest) RequestManager.this.optionsApplier.apply(new DrawableTypeRequest(cls, this.loader, (ModelLoader) null, RequestManager.this.context, RequestManager.this.glide, RequestManager.this.requestTracker, RequestManager.this.lifecycle, RequestManager.this.optionsApplier));
        }

        public DrawableTypeRequest<T> load(T t) {
            return (DrawableTypeRequest) from(RequestManager.getSafeClass(t)).load(t);
        }
    }

    public class OptionsApplier {
        public OptionsApplier() {
        }

        public <A, X extends GenericRequestBuilder<A, ?, ?, ?>> X apply(X x) {
            if (RequestManager.this.options != null) {
                RequestManager.this.options.apply(x);
            }
            return x;
        }
    }

    public static class RequestManagerConnectivityListener implements ConnectivityMonitor.ConnectivityListener {
        private final RequestTracker requestTracker;

        public RequestManagerConnectivityListener(RequestTracker requestTracker2) {
            this.requestTracker = requestTracker2;
        }

        public void onConnectivityChanged(boolean z) {
            if (z) {
                this.requestTracker.restartRequests();
            }
        }
    }

    public final class VideoModelRequest<T> {
        private final ModelLoader<T, ParcelFileDescriptor> loader;

        public VideoModelRequest(ModelLoader<T, ParcelFileDescriptor> modelLoader) {
            this.loader = modelLoader;
        }

        public DrawableTypeRequest<T> load(T t) {
            return (DrawableTypeRequest) ((DrawableTypeRequest) RequestManager.this.optionsApplier.apply(new DrawableTypeRequest(RequestManager.getSafeClass(t), (ModelLoader) null, this.loader, RequestManager.this.context, RequestManager.this.glide, RequestManager.this.requestTracker, RequestManager.this.lifecycle, RequestManager.this.optionsApplier))).load(t);
        }
    }

    public RequestManager(Context context2, Lifecycle lifecycle2, RequestManagerTreeNode requestManagerTreeNode) {
        this(context2, lifecycle2, requestManagerTreeNode, new RequestTracker(), new ConnectivityMonitorFactory());
    }

    /* access modifiers changed from: private */
    public static <T> Class<T> getSafeClass(T t) {
        if (t != null) {
            return t.getClass();
        }
        return null;
    }

    private <T> DrawableTypeRequest<T> loadGeneric(Class<T> cls) {
        ModelLoader<T, InputStream> buildStreamModelLoader = Glide.buildStreamModelLoader(cls, this.context);
        ModelLoader<T, ParcelFileDescriptor> buildFileDescriptorModelLoader = Glide.buildFileDescriptorModelLoader(cls, this.context);
        if (cls != null && buildStreamModelLoader == null && buildFileDescriptorModelLoader == null) {
            throw new IllegalArgumentException("Unknown type " + cls + ". You must provide a Model of a type for" + " which there is a registered ModelLoader, if you are using a custom model, you must first call" + " Glide#register with a ModelLoaderFactory for your custom model class");
        }
        OptionsApplier optionsApplier2 = this.optionsApplier;
        return (DrawableTypeRequest) optionsApplier2.apply(new DrawableTypeRequest(cls, buildStreamModelLoader, buildFileDescriptorModelLoader, this.context, this.glide, this.requestTracker, this.lifecycle, optionsApplier2));
    }

    public <T> DrawableTypeRequest<T> from(Class<T> cls) {
        return loadGeneric(cls);
    }

    public DrawableTypeRequest<byte[]> fromBytes() {
        return (DrawableTypeRequest) loadGeneric(byte[].class).signature((Key) new StringSignature(UUID.randomUUID().toString())).diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true);
    }

    public DrawableTypeRequest<File> fromFile() {
        return loadGeneric(File.class);
    }

    public DrawableTypeRequest<Uri> fromMediaStore() {
        Class<Uri> cls = Uri.class;
        MediaStoreStreamLoader mediaStoreStreamLoader = new MediaStoreStreamLoader(this.context, Glide.buildStreamModelLoader(cls, this.context));
        ModelLoader<Uri, ParcelFileDescriptor> buildFileDescriptorModelLoader = Glide.buildFileDescriptorModelLoader(cls, this.context);
        OptionsApplier optionsApplier2 = this.optionsApplier;
        return (DrawableTypeRequest) optionsApplier2.apply(new DrawableTypeRequest(Uri.class, mediaStoreStreamLoader, buildFileDescriptorModelLoader, this.context, this.glide, this.requestTracker, this.lifecycle, optionsApplier2));
    }

    public DrawableTypeRequest<Integer> fromResource() {
        return (DrawableTypeRequest) loadGeneric(Integer.class).signature(ApplicationVersionSignature.obtain(this.context));
    }

    public DrawableTypeRequest<String> fromString() {
        return loadGeneric(String.class);
    }

    public DrawableTypeRequest<Uri> fromUri() {
        return loadGeneric(Uri.class);
    }

    @Deprecated
    public DrawableTypeRequest<URL> fromUrl() {
        return loadGeneric(URL.class);
    }

    public boolean isPaused() {
        Util.assertMainThread();
        return this.requestTracker.isPaused();
    }

    public DrawableTypeRequest<String> load(String str) {
        return (DrawableTypeRequest) fromString().load(str);
    }

    @Deprecated
    public DrawableTypeRequest<Uri> loadFromMediaStore(Uri uri, String str, long j, int i) {
        return (DrawableTypeRequest) loadFromMediaStore(uri).signature((Key) new MediaStoreSignature(str, j, i));
    }

    public void onDestroy() {
        this.requestTracker.clearRequests();
    }

    public void onLowMemory() {
        this.glide.clearMemory();
    }

    public void onStart() {
        resumeRequests();
    }

    public void onStop() {
        pauseRequests();
    }

    public void onTrimMemory(int i) {
        this.glide.trimMemory(i);
    }

    public void pauseRequests() {
        Util.assertMainThread();
        this.requestTracker.pauseRequests();
    }

    public void pauseRequestsRecursive() {
        Util.assertMainThread();
        pauseRequests();
        for (RequestManager pauseRequests : this.treeNode.getDescendants()) {
            pauseRequests.pauseRequests();
        }
    }

    public void resumeRequests() {
        Util.assertMainThread();
        this.requestTracker.resumeRequests();
    }

    public void resumeRequestsRecursive() {
        Util.assertMainThread();
        resumeRequests();
        for (RequestManager resumeRequests : this.treeNode.getDescendants()) {
            resumeRequests.resumeRequests();
        }
    }

    public void setDefaultOptions(DefaultOptions defaultOptions) {
        this.options = defaultOptions;
    }

    public <A, T> GenericModelRequest<A, T> using(ModelLoader<A, T> modelLoader, Class<T> cls) {
        return new GenericModelRequest<>(modelLoader, cls);
    }

    public RequestManager(Context context2, final Lifecycle lifecycle2, RequestManagerTreeNode requestManagerTreeNode, RequestTracker requestTracker2, ConnectivityMonitorFactory connectivityMonitorFactory) {
        this.context = context2.getApplicationContext();
        this.lifecycle = lifecycle2;
        this.treeNode = requestManagerTreeNode;
        this.requestTracker = requestTracker2;
        this.glide = Glide.get(context2);
        this.optionsApplier = new OptionsApplier();
        ConnectivityMonitor build = connectivityMonitorFactory.build(context2, new RequestManagerConnectivityListener(requestTracker2));
        if (Util.isOnBackgroundThread()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    lifecycle2.addListener(RequestManager.this);
                }
            });
        } else {
            lifecycle2.addListener(this);
        }
        lifecycle2.addListener(build);
    }

    public DrawableTypeRequest<Uri> load(Uri uri) {
        return (DrawableTypeRequest) fromUri().load(uri);
    }

    public <T> ImageModelRequest<T> using(StreamModelLoader<T> streamModelLoader) {
        return new ImageModelRequest<>(streamModelLoader);
    }

    public final class GenericModelRequest<A, T> {
        /* access modifiers changed from: private */
        public final Class<T> dataClass;
        /* access modifiers changed from: private */
        public final ModelLoader<A, T> modelLoader;

        public GenericModelRequest(ModelLoader<A, T> modelLoader2, Class<T> cls) {
            this.modelLoader = modelLoader2;
            this.dataClass = cls;
        }

        public GenericModelRequest<A, T>.GenericTypeRequest from(Class<A> cls) {
            return new GenericTypeRequest(cls);
        }

        public GenericModelRequest<A, T>.GenericTypeRequest load(A a2) {
            return new GenericTypeRequest(a2);
        }

        public final class GenericTypeRequest {
            private final A model;
            private final Class<A> modelClass;
            private final boolean providedModel;

            public GenericTypeRequest(A a2) {
                this.providedModel = true;
                this.model = a2;
                this.modelClass = RequestManager.getSafeClass(a2);
            }

            public <Z> GenericTranscodeRequest<A, T, Z> as(Class<Z> cls) {
                GenericTranscodeRequest<A, T, Z> genericTranscodeRequest = (GenericTranscodeRequest) RequestManager.this.optionsApplier.apply(new GenericTranscodeRequest(RequestManager.this.context, RequestManager.this.glide, this.modelClass, GenericModelRequest.this.modelLoader, GenericModelRequest.this.dataClass, cls, RequestManager.this.requestTracker, RequestManager.this.lifecycle, RequestManager.this.optionsApplier));
                if (this.providedModel) {
                    genericTranscodeRequest.load(this.model);
                }
                return genericTranscodeRequest;
            }

            public GenericTypeRequest(Class<A> cls) {
                this.providedModel = false;
                this.model = null;
                this.modelClass = cls;
            }
        }
    }

    public DrawableTypeRequest<File> load(File file) {
        return (DrawableTypeRequest) fromFile().load(file);
    }

    public DrawableTypeRequest<Uri> loadFromMediaStore(Uri uri) {
        return (DrawableTypeRequest) fromMediaStore().load(uri);
    }

    public ImageModelRequest<byte[]> using(StreamByteArrayLoader streamByteArrayLoader) {
        return new ImageModelRequest<>(streamByteArrayLoader);
    }

    public DrawableTypeRequest<Integer> load(Integer num) {
        return (DrawableTypeRequest) fromResource().load(num);
    }

    public <T> VideoModelRequest<T> using(FileDescriptorModelLoader<T> fileDescriptorModelLoader) {
        return new VideoModelRequest<>(fileDescriptorModelLoader);
    }

    @Deprecated
    public DrawableTypeRequest<URL> load(URL url) {
        return (DrawableTypeRequest) fromUrl().load(url);
    }

    @Deprecated
    public DrawableTypeRequest<byte[]> load(byte[] bArr, String str) {
        return (DrawableTypeRequest) load(bArr).signature((Key) new StringSignature(str));
    }

    public DrawableTypeRequest<byte[]> load(byte[] bArr) {
        return (DrawableTypeRequest) fromBytes().load(bArr);
    }

    public <T> DrawableTypeRequest<T> load(T t) {
        return (DrawableTypeRequest) loadGeneric(getSafeClass(t)).load(t);
    }
}
