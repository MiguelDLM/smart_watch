package com.alimm.tanx.ui.image.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.alimm.tanx.ui.image.glide.GenericRequestBuilder;
import com.alimm.tanx.ui.image.glide.Glide;
import com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder;
import com.alimm.tanx.ui.image.glide.load.Key;
import com.alimm.tanx.ui.image.glide.load.Transformation;
import com.alimm.tanx.ui.image.glide.load.engine.DiskCacheStrategy;
import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool;
import com.alimm.tanx.ui.image.glide.load.resource.NullEncoder;
import com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation;
import com.alimm.tanx.ui.image.glide.request.target.SimpleTarget;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.UUID;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class GifFrameLoader {
    private final FrameCallback callback;
    private DelayTarget current;
    private final GifDecoder gifDecoder;
    private final Handler handler;
    private boolean isCleared;
    private boolean isLoadPending;
    private boolean isRunning;
    private GenericRequestBuilder<GifDecoder, GifDecoder, Bitmap, Bitmap> requestBuilder;

    /* loaded from: classes.dex */
    public static class DelayTarget extends SimpleTarget<Bitmap> {
        private final Handler handler;
        private final int index;
        private Bitmap resource;
        private final long targetTime;

        public DelayTarget(Handler handler, int i, long j) {
            this.handler = handler;
            this.index = i;
            this.targetTime = j;
        }

        public Bitmap getResource() {
            return this.resource;
        }

        @Override // com.alimm.tanx.ui.image.glide.request.target.Target
        public /* bridge */ /* synthetic */ void onResourceReady(Object obj, GlideAnimation glideAnimation) {
            onResourceReady((Bitmap) obj, (GlideAnimation<? super Bitmap>) glideAnimation);
        }

        public void onResourceReady(Bitmap bitmap, GlideAnimation<? super Bitmap> glideAnimation) {
            this.resource = bitmap;
            this.handler.sendMessageAtTime(this.handler.obtainMessage(1, this), this.targetTime);
        }
    }

    /* loaded from: classes.dex */
    public interface FrameCallback {
        void onFrameReady(int i);
    }

    /* loaded from: classes.dex */
    public class FrameLoaderCallback implements Handler.Callback {
        public static final int MSG_CLEAR = 2;
        public static final int MSG_DELAY = 1;

        private FrameLoaderCallback() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                GifFrameLoader.this.onFrameReady((DelayTarget) message.obj);
                return true;
            }
            if (i == 2) {
                Glide.clear((DelayTarget) message.obj);
                return false;
            }
            return false;
        }

        public /* synthetic */ FrameLoaderCallback(AnonymousClass1 anonymousClass1) {
        }
    }

    /* loaded from: classes.dex */
    public static class FrameSignature implements Key {
        private final UUID uuid;

        public FrameSignature() {
            this(UUID.randomUUID());
        }

        @Override // com.alimm.tanx.ui.image.glide.load.Key
        public boolean equals(Object obj) {
            if (obj instanceof FrameSignature) {
                return ((FrameSignature) obj).uuid.equals(this.uuid);
            }
            return false;
        }

        @Override // com.alimm.tanx.ui.image.glide.load.Key
        public int hashCode() {
            return this.uuid.hashCode();
        }

        @Override // com.alimm.tanx.ui.image.glide.load.Key
        public void updateDiskCacheKey(MessageDigest messageDigest) throws UnsupportedEncodingException {
            throw new UnsupportedOperationException("Not implemented");
        }

        public FrameSignature(UUID uuid) {
            this.uuid = uuid;
        }
    }

    public GifFrameLoader(Context context, FrameCallback frameCallback, GifDecoder gifDecoder, int i, int i2) {
        this(frameCallback, gifDecoder, null, getRequestBuilder(context, gifDecoder, i, i2, Glide.get(context).getBitmapPool()));
    }

    private static GenericRequestBuilder<GifDecoder, GifDecoder, Bitmap, Bitmap> getRequestBuilder(Context context, GifDecoder gifDecoder, int i, int i2, BitmapPool bitmapPool) {
        GifFrameResourceDecoder gifFrameResourceDecoder = new GifFrameResourceDecoder(bitmapPool);
        GifFrameModelLoader gifFrameModelLoader = new GifFrameModelLoader();
        return Glide.with(context).using(gifFrameModelLoader, GifDecoder.class).load(gifDecoder).as(Bitmap.class).sourceEncoder(NullEncoder.get()).decoder(gifFrameResourceDecoder).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).override(i, i2);
    }

    private void loadNextFrame() {
        if (this.isRunning && !this.isLoadPending) {
            this.isLoadPending = true;
            long uptimeMillis = SystemClock.uptimeMillis() + this.gifDecoder.getNextDelay();
            this.gifDecoder.advance();
            this.requestBuilder.signature(new FrameSignature()).into((GenericRequestBuilder<GifDecoder, GifDecoder, Bitmap, Bitmap>) new DelayTarget(this.handler, this.gifDecoder.getCurrentFrameIndex(), uptimeMillis));
        }
    }

    public void clear() {
        stop();
        DelayTarget delayTarget = this.current;
        if (delayTarget != null) {
            Glide.clear(delayTarget);
            this.current = null;
        }
        this.isCleared = true;
    }

    public Bitmap getCurrentFrame() {
        DelayTarget delayTarget = this.current;
        if (delayTarget != null) {
            return delayTarget.getResource();
        }
        return null;
    }

    public void onFrameReady(DelayTarget delayTarget) {
        if (this.isCleared) {
            this.handler.obtainMessage(2, delayTarget).sendToTarget();
            return;
        }
        DelayTarget delayTarget2 = this.current;
        this.current = delayTarget;
        this.callback.onFrameReady(delayTarget.index);
        if (delayTarget2 != null) {
            this.handler.obtainMessage(2, delayTarget2).sendToTarget();
        }
        this.isLoadPending = false;
        loadNextFrame();
    }

    public void setFrameTransformation(Transformation<Bitmap> transformation) {
        if (transformation != null) {
            this.requestBuilder = this.requestBuilder.transform(transformation);
            return;
        }
        throw new NullPointerException("Transformation must not be null");
    }

    public void start() {
        if (this.isRunning) {
            return;
        }
        this.isRunning = true;
        this.isCleared = false;
        loadNextFrame();
    }

    public void stop() {
        this.isRunning = false;
    }

    public GifFrameLoader(FrameCallback frameCallback, GifDecoder gifDecoder, Handler handler, GenericRequestBuilder<GifDecoder, GifDecoder, Bitmap, Bitmap> genericRequestBuilder) {
        this.isRunning = false;
        this.isLoadPending = false;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new FrameLoaderCallback(null)) : handler;
        this.callback = frameCallback;
        this.gifDecoder = gifDecoder;
        this.handler = handler;
        this.requestBuilder = genericRequestBuilder;
    }
}
