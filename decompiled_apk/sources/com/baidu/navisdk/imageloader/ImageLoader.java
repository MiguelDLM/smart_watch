package com.baidu.navisdk.imageloader;

import android.content.Context;
import android.view.View;
import com.baidu.navisdk.imageloader.config.ImageConfig;
import com.baidu.navisdk.imageloader.interfaces.ILoader;

/* loaded from: classes7.dex */
public class ImageLoader {
    private static ILoader loader;

    public static void clear(View view) {
        ILoader iLoader = loader;
        if (iLoader != null) {
            iLoader.clearMemoryCache(view);
        }
    }

    public static void clearAllMemoryCaches() {
        ILoader iLoader = loader;
        if (iLoader != null) {
            iLoader.clearMemoryCache();
        }
    }

    public static ILoader getLoader() {
        return loader;
    }

    public static void trimMemory(int i) {
        loader.trimMemory(i);
    }

    public static ImageConfig.ConfigBuilder with(Context context) {
        if (loader == null) {
            loader = new GlideLoader();
        }
        return new ImageConfig.ConfigBuilder(context);
    }
}
