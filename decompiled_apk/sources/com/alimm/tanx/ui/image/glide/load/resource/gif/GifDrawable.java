package com.alimm.tanx.ui.image.glide.load.resource.gif;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder;
import com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader;
import com.alimm.tanx.ui.image.glide.load.Transformation;
import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool;
import com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable;
import com.alimm.tanx.ui.image.glide.load.resource.gif.GifFrameLoader;

/* loaded from: classes.dex */
public class GifDrawable extends GlideDrawable implements GifFrameLoader.FrameCallback {
    private boolean applyGravity;
    private final GifDecoder decoder;
    private final Rect destRect;
    private final GifFrameLoader frameLoader;
    private boolean isRecycled;
    private boolean isRunning;
    private boolean isStarted;
    private boolean isVisible;
    private int loopCount;
    private int maxLoopCount;
    private final Paint paint;
    private final GifState state;

    /* loaded from: classes.dex */
    public static class GifState extends Drawable.ConstantState {
        private static final int GRAVITY = 119;
        BitmapPool bitmapPool;
        GifDecoder.BitmapProvider bitmapProvider;
        Context context;
        byte[] data;
        Bitmap firstFrame;
        Transformation<Bitmap> frameTransformation;
        GifHeader gifHeader;
        int targetHeight;
        int targetWidth;

        public GifState(GifHeader gifHeader, byte[] bArr, Context context, Transformation<Bitmap> transformation, int i, int i2, GifDecoder.BitmapProvider bitmapProvider, BitmapPool bitmapPool, Bitmap bitmap) {
            if (bitmap != null) {
                this.gifHeader = gifHeader;
                this.data = bArr;
                this.bitmapPool = bitmapPool;
                this.firstFrame = bitmap;
                this.context = context.getApplicationContext();
                this.frameTransformation = transformation;
                this.targetWidth = i;
                this.targetHeight = i2;
                this.bitmapProvider = bitmapProvider;
                return;
            }
            throw new NullPointerException("The first frame of the GIF must not be null");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new GifDrawable(this);
        }

        public GifState(GifState gifState) {
            if (gifState != null) {
                this.gifHeader = gifState.gifHeader;
                this.data = gifState.data;
                this.context = gifState.context;
                this.frameTransformation = gifState.frameTransformation;
                this.targetWidth = gifState.targetWidth;
                this.targetHeight = gifState.targetHeight;
                this.bitmapProvider = gifState.bitmapProvider;
                this.bitmapPool = gifState.bitmapPool;
                this.firstFrame = gifState.firstFrame;
            }
        }
    }

    public GifDrawable(Context context, GifDecoder.BitmapProvider bitmapProvider, BitmapPool bitmapPool, Transformation<Bitmap> transformation, int i, int i2, GifHeader gifHeader, byte[] bArr, Bitmap bitmap) {
        this(new GifState(gifHeader, bArr, context, transformation, i, i2, bitmapProvider, bitmapPool, bitmap));
    }

    private void reset() {
        this.frameLoader.clear();
        invalidateSelf();
    }

    private void resetLoopCount() {
        this.loopCount = 0;
    }

    private void startRunning() {
        if (this.decoder.getFrameCount() == 1) {
            invalidateSelf();
        } else if (!this.isRunning) {
            this.isRunning = true;
            this.frameLoader.start();
            invalidateSelf();
        }
    }

    private void stopRunning() {
        this.isRunning = false;
        this.frameLoader.stop();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.isRecycled) {
            return;
        }
        if (this.applyGravity) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), this.destRect);
            this.applyGravity = false;
        }
        Bitmap currentFrame = this.frameLoader.getCurrentFrame();
        if (currentFrame == null) {
            currentFrame = this.state.firstFrame;
        }
        canvas.drawBitmap(currentFrame, (Rect) null, this.destRect, this.paint);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.state;
    }

    public byte[] getData() {
        return this.state.data;
    }

    public GifDecoder getDecoder() {
        return this.decoder;
    }

    public Bitmap getFirstFrame() {
        return this.state.firstFrame;
    }

    public int getFrameCount() {
        return this.decoder.getFrameCount();
    }

    public Transformation<Bitmap> getFrameTransformation() {
        return this.state.frameTransformation;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.state.firstFrame.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.state.firstFrame.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable
    public boolean isAnimated() {
        return true;
    }

    public boolean isRecycled() {
        return this.isRecycled;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.applyGravity = true;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.gif.GifFrameLoader.FrameCallback
    @TargetApi(11)
    public void onFrameReady(int i) {
        if (getCallback() == null) {
            stop();
            reset();
            return;
        }
        invalidateSelf();
        if (i == this.decoder.getFrameCount() - 1) {
            this.loopCount++;
        }
        int i2 = this.maxLoopCount;
        if (i2 != -1 && this.loopCount >= i2) {
            stop();
        }
    }

    public void recycle() {
        this.isRecycled = true;
        GifState gifState = this.state;
        gifState.bitmapPool.put(gifState.firstFrame);
        this.frameLoader.clear();
        this.frameLoader.stop();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.paint.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }

    public void setFrameTransformation(Transformation<Bitmap> transformation, Bitmap bitmap) {
        if (bitmap != null) {
            if (transformation != null) {
                GifState gifState = this.state;
                gifState.frameTransformation = transformation;
                gifState.firstFrame = bitmap;
                this.frameLoader.setFrameTransformation(transformation);
                return;
            }
            throw new NullPointerException("The frame transformation must not be null");
        }
        throw new NullPointerException("The first frame of the GIF must not be null");
    }

    public void setIsRunning(boolean z) {
        this.isRunning = z;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable
    public void setLoopCount(int i) {
        int i2 = -1;
        if (i <= 0 && i != -1 && i != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        }
        if (i == 0) {
            int totalIterationCount = this.decoder.getTotalIterationCount();
            if (totalIterationCount != 0) {
                i2 = totalIterationCount;
            }
            this.maxLoopCount = i2;
            return;
        }
        this.maxLoopCount = i;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        this.isVisible = z;
        if (!z) {
            stopRunning();
        } else if (this.isStarted) {
            startRunning();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.isStarted = true;
        resetLoopCount();
        if (this.isVisible) {
            startRunning();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.isStarted = false;
        stopRunning();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public GifDrawable(com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable r12, android.graphics.Bitmap r13, com.alimm.tanx.ui.image.glide.load.Transformation<android.graphics.Bitmap> r14) {
        /*
            r11 = this;
            com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable$GifState r10 = new com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable$GifState
            com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable$GifState r12 = r12.state
            com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader r1 = r12.gifHeader
            byte[] r2 = r12.data
            android.content.Context r3 = r12.context
            int r5 = r12.targetWidth
            int r6 = r12.targetHeight
            com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder$BitmapProvider r7 = r12.bitmapProvider
            com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool r8 = r12.bitmapPool
            r0 = r10
            r4 = r14
            r9 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r11.<init>(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable.<init>(com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable, android.graphics.Bitmap, com.alimm.tanx.ui.image.glide.load.Transformation):void");
    }

    public GifDrawable(GifState gifState) {
        this.destRect = new Rect();
        this.isVisible = true;
        this.maxLoopCount = -1;
        if (gifState != null) {
            this.state = gifState;
            GifDecoder gifDecoder = new GifDecoder(gifState.bitmapProvider);
            this.decoder = gifDecoder;
            this.paint = new Paint();
            gifDecoder.setData(gifState.gifHeader, gifState.data);
            GifFrameLoader gifFrameLoader = new GifFrameLoader(gifState.context, this, gifDecoder, gifState.targetWidth, gifState.targetHeight);
            this.frameLoader = gifFrameLoader;
            gifFrameLoader.setFrameTransformation(gifState.frameTransformation);
            return;
        }
        throw new NullPointerException("GifState must not be null");
    }

    public GifDrawable(GifDecoder gifDecoder, GifFrameLoader gifFrameLoader, Bitmap bitmap, BitmapPool bitmapPool, Paint paint) {
        this.destRect = new Rect();
        this.isVisible = true;
        this.maxLoopCount = -1;
        this.decoder = gifDecoder;
        this.frameLoader = gifFrameLoader;
        GifState gifState = new GifState(null);
        this.state = gifState;
        this.paint = paint;
        gifState.bitmapPool = bitmapPool;
        gifState.firstFrame = bitmap;
    }
}
