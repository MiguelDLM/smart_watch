package com.androidnetworking.cache;

import android.graphics.Bitmap;
import com.androidnetworking.internal.ANImageLoader;

/* loaded from: classes.dex */
public class LruBitmapCache extends LruCache<String, Bitmap> implements ANImageLoader.ImageCache {
    public LruBitmapCache(int i) {
        super(i);
    }

    @Override // com.androidnetworking.internal.ANImageLoader.ImageCache
    public void evictAllBitmap() {
        evictAll();
    }

    @Override // com.androidnetworking.internal.ANImageLoader.ImageCache
    public void evictBitmap(String str) {
        remove(str);
    }

    @Override // com.androidnetworking.internal.ANImageLoader.ImageCache
    public Bitmap getBitmap(String str) {
        return get(str);
    }

    @Override // com.androidnetworking.internal.ANImageLoader.ImageCache
    public void putBitmap(String str, Bitmap bitmap) {
        put(str, bitmap);
    }

    @Override // com.androidnetworking.cache.LruCache
    public int sizeOf(String str, Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }
}
