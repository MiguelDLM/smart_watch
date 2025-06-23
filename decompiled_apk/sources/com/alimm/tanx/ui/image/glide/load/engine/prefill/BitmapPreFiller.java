package com.alimm.tanx.ui.image.glide.load.engine.prefill;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.alimm.tanx.ui.image.glide.load.DecodeFormat;
import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool;
import com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache;
import com.alimm.tanx.ui.image.glide.load.engine.prefill.PreFillType;
import com.alimm.tanx.ui.image.glide.util.Util;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class BitmapPreFiller {
    private final BitmapPool bitmapPool;
    private BitmapPreFillRunner current;
    private final DecodeFormat defaultFormat;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final MemoryCache memoryCache;

    public BitmapPreFiller(MemoryCache memoryCache, BitmapPool bitmapPool, DecodeFormat decodeFormat) {
        this.memoryCache = memoryCache;
        this.bitmapPool = bitmapPool;
        this.defaultFormat = decodeFormat;
    }

    private static int getSizeInBytes(PreFillType preFillType) {
        return Util.getBitmapByteSize(preFillType.getWidth(), preFillType.getHeight(), preFillType.getConfig());
    }

    public PreFillQueue generateAllocationOrder(PreFillType[] preFillTypeArr) {
        int maxSize = this.bitmapPool.getMaxSize() + (this.memoryCache.getMaxSize() - this.memoryCache.getCurrentSize());
        int i = 0;
        for (PreFillType preFillType : preFillTypeArr) {
            i += preFillType.getWeight();
        }
        float f = maxSize / i;
        HashMap hashMap = new HashMap();
        for (PreFillType preFillType2 : preFillTypeArr) {
            hashMap.put(preFillType2, Integer.valueOf(Math.round(preFillType2.getWeight() * f) / Util.getBitmapByteSize(preFillType2.getWidth(), preFillType2.getHeight(), preFillType2.getConfig())));
        }
        return new PreFillQueue(hashMap);
    }

    public void preFill(PreFillType.Builder... builderArr) {
        Bitmap.Config config;
        BitmapPreFillRunner bitmapPreFillRunner = this.current;
        if (bitmapPreFillRunner != null) {
            bitmapPreFillRunner.cancel();
        }
        PreFillType[] preFillTypeArr = new PreFillType[builderArr.length];
        for (int i = 0; i < builderArr.length; i++) {
            PreFillType.Builder builder = builderArr[i];
            if (builder.getConfig() == null) {
                DecodeFormat decodeFormat = this.defaultFormat;
                if (decodeFormat != DecodeFormat.ALWAYS_ARGB_8888 && decodeFormat != DecodeFormat.PREFER_ARGB_8888) {
                    config = Bitmap.Config.RGB_565;
                } else {
                    config = Bitmap.Config.ARGB_8888;
                }
                builder.setConfig(config);
            }
            preFillTypeArr[i] = builder.build();
        }
        BitmapPreFillRunner bitmapPreFillRunner2 = new BitmapPreFillRunner(this.bitmapPool, this.memoryCache, generateAllocationOrder(preFillTypeArr));
        this.current = bitmapPreFillRunner2;
        this.handler.post(bitmapPreFillRunner2);
    }
}
