package com.baidu.ar;

import android.content.Context;
import com.baidu.ar.callback.ICallback;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.ihttp.IProgressCallback;
import com.baidu.ar.remoteres.IDuMixResLoadTask;

/* loaded from: classes7.dex */
public interface ic {
    boolean isSoDownloadSuccess();

    void prepareEglCore(ICallback iCallback, IProgressCallback iProgressCallback, ICallbackWith<IDuMixResLoadTask> iCallbackWith);

    void release();

    void setBusinessTag(String str);

    void setSoName(String str);

    void setup(Context context);
}
