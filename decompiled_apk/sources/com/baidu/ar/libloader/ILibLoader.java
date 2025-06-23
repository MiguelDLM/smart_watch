package com.baidu.ar.libloader;

import android.content.Context;
import com.baidu.ar.ARType;
import com.baidu.ar.DuMixErrorType;

/* loaded from: classes7.dex */
public interface ILibLoader {

    /* loaded from: classes7.dex */
    public interface a {
        void a(ARType aRType, String str, String str2);

        void a(DuMixErrorType duMixErrorType, String str);
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(DuMixErrorType duMixErrorType, Exception exc);

        void onSuccess();
    }

    /* loaded from: classes7.dex */
    public interface c {
        void onError();

        void onReady();
    }

    void load(Context context, b bVar);

    void prepareCaseRes(ARType aRType, String str, String str2, a aVar);

    void release();

    void require(String str);

    void setLibLoadPlugin(ILibLoaderPlugin iLibLoaderPlugin);

    void setLibReadyListener(String str, c cVar);
}
