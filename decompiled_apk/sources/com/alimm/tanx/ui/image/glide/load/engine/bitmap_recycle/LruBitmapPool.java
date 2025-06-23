package com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import oOxxXI.oIX0oI;

/* loaded from: classes.dex */
public class LruBitmapPool implements BitmapPool {
    private static final Bitmap.Config DEFAULT_CONFIG = Bitmap.Config.ARGB_8888;
    private static final String TAG = "LruBitmapPool";
    private final Set<Bitmap.Config> allowedConfigs;
    private int currentSize;
    private int evictions;
    private int hits;
    private final int initialMaxSize;
    private int maxSize;
    private int misses;
    private int puts;
    private final LruPoolStrategy strategy;
    private final BitmapTracker tracker;

    /* loaded from: classes.dex */
    public interface BitmapTracker {
        void add(Bitmap bitmap);

        void remove(Bitmap bitmap);
    }

    /* loaded from: classes.dex */
    public static class NullBitmapTracker implements BitmapTracker {
        private NullBitmapTracker() {
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void add(Bitmap bitmap) {
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void remove(Bitmap bitmap) {
        }

        public /* synthetic */ NullBitmapTracker(AnonymousClass1 anonymousClass1) {
        }
    }

    /* loaded from: classes.dex */
    public static class ThrowingBitmapTracker implements BitmapTracker {
        private final Set<Bitmap> bitmaps = Collections.synchronizedSet(new HashSet());

        private ThrowingBitmapTracker() {
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void add(Bitmap bitmap) {
            if (!this.bitmaps.contains(bitmap)) {
                this.bitmaps.add(bitmap);
                return;
            }
            throw new IllegalStateException("Can't add already added bitmap: " + bitmap + " [" + bitmap.getWidth() + "x" + bitmap.getHeight() + "]");
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void remove(Bitmap bitmap) {
            if (this.bitmaps.contains(bitmap)) {
                this.bitmaps.remove(bitmap);
                return;
            }
            throw new IllegalStateException("Cannot remove bitmap not in tracker");
        }
    }

    public LruBitmapPool(int i, LruPoolStrategy lruPoolStrategy, Set<Bitmap.Config> set) {
        this.initialMaxSize = i;
        this.maxSize = i;
        this.strategy = lruPoolStrategy;
        this.allowedConfigs = set;
        this.tracker = new NullBitmapTracker(null);
    }

    private void dump() {
        if (Log.isLoggable(TAG, 2)) {
            dumpUnchecked();
        }
    }

    private void dumpUnchecked() {
        StringBuilder oIX0oI2 = oIX0oI.oIX0oI("Hits=");
        oIX0oI2.append(this.hits);
        oIX0oI2.append(", misses=");
        oIX0oI2.append(this.misses);
        oIX0oI2.append(", puts=");
        oIX0oI2.append(this.puts);
        oIX0oI2.append(", evictions=");
        oIX0oI2.append(this.evictions);
        oIX0oI2.append(", currentSize=");
        oIX0oI2.append(this.currentSize);
        oIX0oI2.append(", maxSize=");
        oIX0oI2.append(this.maxSize);
        oIX0oI2.append("\nStrategy=");
        oIX0oI2.append(this.strategy);
        Log.v(TAG, oIX0oI2.toString());
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    private static Set<Bitmap.Config> getDefaultAllowedConfigs() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(Arrays.asList(Bitmap.Config.values()));
        hashSet.add(null);
        return Collections.unmodifiableSet(hashSet);
    }

    private static LruPoolStrategy getDefaultStrategy() {
        return new SizeConfigStrategy();
    }

    private synchronized void trimToSize(int i) {
        while (this.currentSize > i) {
            try {
                Bitmap removeLast = this.strategy.removeLast();
                if (removeLast == null) {
                    if (Log.isLoggable(TAG, 5)) {
                        Log.w(TAG, "Size mismatch, resetting");
                        dumpUnchecked();
                    }
                    this.currentSize = 0;
                    return;
                }
                this.tracker.remove(removeLast);
                this.currentSize -= this.strategy.getSize(removeLast);
                removeLast.recycle();
                this.evictions++;
                if (Log.isLoggable(TAG, 3)) {
                    StringBuilder oIX0oI2 = oIX0oI.oIX0oI("Evicting bitmap=");
                    oIX0oI2.append(this.strategy.logBitmap(removeLast));
                    Log.d(TAG, oIX0oI2.toString());
                }
                dump();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    public void clearMemory() {
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "clearMemory");
        }
        trimToSize(0);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized Bitmap get(int i, int i2, Bitmap.Config config) {
        Bitmap dirty;
        dirty = getDirty(i, i2, config);
        if (dirty != null) {
            dirty.eraseColor(0);
        }
        return dirty;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    @TargetApi(12)
    public synchronized Bitmap getDirty(int i, int i2, Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap bitmap;
        try {
            LruPoolStrategy lruPoolStrategy = this.strategy;
            if (config != null) {
                config2 = config;
            } else {
                config2 = DEFAULT_CONFIG;
            }
            bitmap = lruPoolStrategy.get(i, i2, config2);
            if (bitmap == null) {
                if (Log.isLoggable(TAG, 3)) {
                    StringBuilder oIX0oI2 = oIX0oI.oIX0oI("Missing bitmap=");
                    oIX0oI2.append(this.strategy.logBitmap(i, i2, config));
                    Log.d(TAG, oIX0oI2.toString());
                }
                this.misses++;
            } else {
                this.hits++;
                this.currentSize -= this.strategy.getSize(bitmap);
                this.tracker.remove(bitmap);
                bitmap.setHasAlpha(true);
            }
            if (Log.isLoggable(TAG, 2)) {
                StringBuilder oIX0oI3 = oIX0oI.oIX0oI("Get bitmap=");
                oIX0oI3.append(this.strategy.logBitmap(i, i2, config));
                Log.v(TAG, oIX0oI3.toString());
            }
            dump();
        } catch (Throwable th) {
            throw th;
        }
        return bitmap;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    public int getMaxSize() {
        return this.maxSize;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized boolean put(Bitmap bitmap) {
        try {
            if (bitmap != null) {
                if (bitmap.isMutable() && this.strategy.getSize(bitmap) <= this.maxSize && this.allowedConfigs.contains(bitmap.getConfig())) {
                    int size = this.strategy.getSize(bitmap);
                    this.strategy.put(bitmap);
                    this.tracker.add(bitmap);
                    this.puts++;
                    this.currentSize += size;
                    if (Log.isLoggable(TAG, 2)) {
                        StringBuilder oIX0oI2 = oIX0oI.oIX0oI("Put bitmap in pool=");
                        oIX0oI2.append(this.strategy.logBitmap(bitmap));
                        Log.v(TAG, oIX0oI2.toString());
                    }
                    dump();
                    evict();
                    return true;
                }
                if (Log.isLoggable(TAG, 2)) {
                    StringBuilder oIX0oI3 = oIX0oI.oIX0oI("Reject bitmap from pool, bitmap: ");
                    oIX0oI3.append(this.strategy.logBitmap(bitmap));
                    oIX0oI3.append(", is mutable: ");
                    oIX0oI3.append(bitmap.isMutable());
                    oIX0oI3.append(", is allowed config: ");
                    oIX0oI3.append(this.allowedConfigs.contains(bitmap.getConfig()));
                    Log.v(TAG, oIX0oI3.toString());
                }
                return false;
            }
            throw new NullPointerException("Bitmap must not be null");
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized void setSizeMultiplier(float f) {
        this.maxSize = Math.round(this.initialMaxSize * f);
        evict();
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    @SuppressLint({"InlinedApi"})
    public void trimMemory(int i) {
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "trimMemory, level=" + i);
        }
        if (i >= 60) {
            clearMemory();
        } else if (i >= 40) {
            trimToSize(this.maxSize / 2);
        }
    }

    public LruBitmapPool(int i) {
        this(i, getDefaultStrategy(), getDefaultAllowedConfigs());
    }

    public LruBitmapPool(int i, Set<Bitmap.Config> set) {
        this(i, getDefaultStrategy(), set);
    }
}
