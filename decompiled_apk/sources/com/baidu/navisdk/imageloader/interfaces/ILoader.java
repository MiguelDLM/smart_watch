package com.baidu.navisdk.imageloader.interfaces;

import android.view.View;
import com.baidu.navisdk.imageloader.config.ImageConfig;

/* loaded from: classes7.dex */
public abstract class ILoader {
    public abstract void clearDiskCache();

    public abstract void clearMemoryCache();

    public abstract void clearMemoryCache(View view);

    public abstract Object getObject(ImageConfig imageConfig);

    public abstract void onLowMemory();

    public abstract void pause();

    public abstract void requestData(ImageConfig imageConfig);

    public abstract void resume();

    public abstract void trimMemory(int i);
}
