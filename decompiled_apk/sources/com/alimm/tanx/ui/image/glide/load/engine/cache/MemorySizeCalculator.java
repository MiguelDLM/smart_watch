package com.alimm.tanx.ui.image.glide.load.engine.cache;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import oOxxXI.oIX0oI;

/* loaded from: classes.dex */
public class MemorySizeCalculator {
    static final int BITMAP_POOL_TARGET_SCREENS = 4;
    static final int BYTES_PER_ARGB_8888_PIXEL = 4;
    static final float LOW_MEMORY_MAX_SIZE_MULTIPLIER = 0.33f;
    static final float MAX_SIZE_MULTIPLIER = 0.4f;
    static final int MEMORY_CACHE_TARGET_SCREENS = 2;
    private static final String TAG = "MemorySizeCalculator";
    private final int bitmapPoolSize;
    private final Context context;
    private final int memoryCacheSize;

    /* loaded from: classes.dex */
    public static class DisplayMetricsScreenDimensions implements ScreenDimensions {
        private final DisplayMetrics displayMetrics;

        public DisplayMetricsScreenDimensions(DisplayMetrics displayMetrics) {
            this.displayMetrics = displayMetrics;
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions
        public int getHeightPixels() {
            return this.displayMetrics.heightPixels;
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions
        public int getWidthPixels() {
            return this.displayMetrics.widthPixels;
        }
    }

    /* loaded from: classes.dex */
    public interface ScreenDimensions {
        int getHeightPixels();

        int getWidthPixels();
    }

    public MemorySizeCalculator(Context context) {
        this(context, (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY), new DisplayMetricsScreenDimensions(context.getResources().getDisplayMetrics()));
    }

    private static int getMaxSize(ActivityManager activityManager) {
        float f;
        float memoryClass = activityManager.getMemoryClass() * 1048576;
        if (isLowMemoryDevice(activityManager)) {
            f = LOW_MEMORY_MAX_SIZE_MULTIPLIER;
        } else {
            f = MAX_SIZE_MULTIPLIER;
        }
        return Math.round(memoryClass * f);
    }

    @TargetApi(19)
    private static boolean isLowMemoryDevice(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }

    private String toMb(int i) {
        return Formatter.formatFileSize(this.context, i);
    }

    public int getBitmapPoolSize() {
        return this.bitmapPoolSize;
    }

    public int getMemoryCacheSize() {
        return this.memoryCacheSize;
    }

    public MemorySizeCalculator(Context context, ActivityManager activityManager, ScreenDimensions screenDimensions) {
        this.context = context;
        int maxSize = getMaxSize(activityManager);
        int widthPixels = screenDimensions.getWidthPixels() * screenDimensions.getHeightPixels();
        int i = widthPixels * 16;
        int i2 = widthPixels * 8;
        int i3 = i2 + i;
        if (i3 <= maxSize) {
            this.memoryCacheSize = i2;
            this.bitmapPoolSize = i;
        } else {
            int round = Math.round(maxSize / 6.0f);
            this.memoryCacheSize = round * 2;
            this.bitmapPoolSize = round * 4;
        }
        if (Log.isLoggable(TAG, 3)) {
            StringBuilder oIX0oI2 = oIX0oI.oIX0oI("Calculated memory cache size: ");
            oIX0oI2.append(toMb(this.memoryCacheSize));
            oIX0oI2.append(" pool size: ");
            oIX0oI2.append(toMb(this.bitmapPoolSize));
            oIX0oI2.append(" memory class limited? ");
            oIX0oI2.append(i3 > maxSize);
            oIX0oI2.append(" max size: ");
            oIX0oI2.append(toMb(maxSize));
            oIX0oI2.append(" memoryClass: ");
            oIX0oI2.append(activityManager.getMemoryClass());
            oIX0oI2.append(" isLowMemoryDevice: ");
            oIX0oI2.append(isLowMemoryDevice(activityManager));
            Log.d(TAG, oIX0oI2.toString());
        }
    }
}
