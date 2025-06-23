package com.baidu.ar.libloader;

import com.baidu.ar.callback.ICallback;

/* loaded from: classes7.dex */
public interface ILibLoaderPlugin {
    void onBeforeLoad(ICallback iCallback);

    boolean processLoadError(ICallback iCallback);
}
